package com.kingdomlife.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KingdomMusicActivity extends Activity {

    private static final int PICK_MUSIC = 2001;

    private static final String PREFS = "KingdomMusicPrefs";
    private static final String SONGS_KEY = "song_uris";
    private static final String NAMES_KEY = "song_names";
    private static final String FAVOURITES_KEY = "favourite_uris";

    private final ArrayList<Uri> songUris = new ArrayList<>();
    private final ArrayList<String> songNames = new ArrayList<>();
    private final Set<String> favourites = new HashSet<>();

    private int currentIndex = -1;
    private boolean prepared = false;

    private LinearLayout root;
    private LinearLayout songList;
    private TextView nowPlaying;

    private final int purple = Color.rgb(30, 24, 55);
    private final int gold = Color.rgb(184, 134, 11);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadSavedMusic();
        buildScreen();
    }

    private void buildScreen() {
        ScrollView scroll = new ScrollView(this);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 20, 20, 24);
        root.setBackgroundColor(purple);

        scroll.addView(root);
        setContentView(scroll);

        TextView title = new TextView(this);
        title.setText("🎵 Kingdom Music");
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 12, 0, 22);
        root.addView(title);

        Button choose = makeButton("＋ Choose Music");
        choose.setOnClickListener(v -> chooseMusic());
        root.addView(choose);

        nowPlaying = new TextView(this);
        nowPlaying.setText("Nothing playing");
        nowPlaying.setTextColor(Color.WHITE);
        nowPlaying.setTextSize(16);
        nowPlaying.setGravity(Gravity.CENTER);
        nowPlaying.setPadding(0, 20, 0, 15);
        root.addView(nowPlaying);

        LinearLayout controls = new LinearLayout(this);
        controls.setGravity(Gravity.CENTER);
        controls.setOrientation(LinearLayout.HORIZONTAL);

        addControl(controls, "⏮", this::previousSong);
        addControl(controls, "▶", this::playSong);
        addControl(controls, "⏸", this::pauseSong);
        addControl(controls, "⏭", this::nextSong);
        addControl(controls, "⏹", this::stopSong);

        root.addView(controls);

        TextView listTitle = new TextView(this);
        listTitle.setText("Your Music");
        listTitle.setTextColor(Color.WHITE);
        listTitle.setTextSize(21);
        listTitle.setTypeface(null, Typeface.BOLD);
        listTitle.setPadding(0, 24, 0, 10);
        root.addView(listTitle);

        songList = new LinearLayout(this);
        songList.setOrientation(LinearLayout.VERTICAL);
        root.addView(songList);

        Button back = makeButton("⬅ Back to Settings");
        back.setOnClickListener(v -> finish());
        root.addView(back);

        refreshSongList();
    }

    private Button makeButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(16);
        button.setAllCaps(false);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(gold)
        );
        return button;
    }

    private void addControl(
            LinearLayout row,
            String label,
            Runnable action) {

        Button button = new Button(this);
        button.setText(label);
        button.setTextSize(18);
        button.setTextColor(Color.WHITE);
        button.setAllCaps(false);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(gold)
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(0, 60, 1);

        params.setMargins(2, 4, 2, 4);
        row.addView(button, params);

        button.setOnClickListener(v -> action.run());
    }

    private void chooseMusic() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("audio/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

        startActivityForResult(intent, PICK_MUSIC);
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != PICK_MUSIC ||
                resultCode != RESULT_OK || data == null) {
            return;
        }

        if (data.getClipData() != null) {
            android.content.ClipData clips = data.getClipData();

            for (int i = 0; i < clips.getItemCount(); i++) {
                addSong(clips.getItemAt(i).getUri());
            }

        } else if (data.getData() != null) {
            addSong(data.getData());
        }

        saveMusic();
        refreshSongList();
    }

    private void addSong(Uri uri) {
        try {
            getContentResolver().takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
            );
        } catch (SecurityException ignored) {
        }

        if (songUris.contains(uri)) {
            return;
        }

        songUris.add(uri);

        String name = uri.getLastPathSegment();

        if (name == null || name.trim().isEmpty()) {
            name = "Audio " + songUris.size();
        }

        songNames.add(name);
    }

    private void refreshSongList() {
        if (songList == null) {
            return;
        }

        songList.removeAllViews();

        if (songNames.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText("No songs yet. Choose audio from your device.");
            empty.setTextColor(Color.WHITE);
            empty.setPadding(0, 10, 0, 20);
            songList.addView(empty);
            return;
        }

        for (int i = 0; i < songNames.size(); i++) {
            final int index = i;

            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(12, 10, 12, 10);
            card.setBackgroundColor(Color.rgb(48, 39, 78));

            TextView name = new TextView(this);
            name.setText(
                    (i + 1) + ". " + songNames.get(i) +
                    (favourites.contains(songUris.get(i).toString())
                            ? "  ⭐" : "")
            );
            name.setTextColor(Color.WHITE);
            name.setTextSize(16);
            card.addView(name);

            LinearLayout actions = new LinearLayout(this);

            Button play = makeButton("▶ Play");
            play.setOnClickListener(v -> {
                currentIndex = index;
                playSong();
            });
            actions.addView(play, new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            Button favourite = makeButton("⭐");
            favourite.setOnClickListener(v -> toggleFavourite(index));
            actions.addView(favourite, new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            Button remove = makeButton("Remove");
            remove.setOnClickListener(v -> removeSong(index));
            actions.addView(remove, new LinearLayout.LayoutParams(
                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            card.addView(actions);

            LinearLayout.LayoutParams cardParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);

            cardParams.setMargins(0, 5, 0, 5);
            songList.addView(card, cardParams);
        }
    }

    private void playSong() {
    if (songUris.isEmpty()) {
        toast("Choose some music first.");
        return;
    }

    if (currentIndex < 0 || currentIndex >= songUris.size()) {
        currentIndex = 0;
    }

    Intent intent = new Intent(this, KingdomMusicService.class);
    intent.setAction(KingdomMusicService.ACTION_PLAY);
    intent.putExtra(
            KingdomMusicService.EXTRA_URI,
            songUris.get(currentIndex).toString()
    );
    intent.putExtra(
            KingdomMusicService.EXTRA_TITLE,
            songNames.get(currentIndex)
    );

    if (android.os.Build.VERSION.SDK_INT >= 26) {
        startForegroundService(intent);
    } else {
        startService(intent);
    }

    nowPlaying.setText("▶ Playing: " + songNames.get(currentIndex));
}

private void pauseSong() {
    Intent intent = new Intent(this, KingdomMusicService.class);
    intent.setAction(KingdomMusicService.ACTION_PAUSE);
    startService(intent);

    nowPlaying.setText("⏸ Pause requested");
}

private void stopSong() {
    Intent intent = new Intent(this, KingdomMusicService.class);
    intent.setAction(KingdomMusicService.ACTION_STOP);
    startService(intent);

    nowPlaying.setText("Nothing playing");
}

private void nextSong() {
    if (songUris.isEmpty()) {
        return;
    }

    currentIndex = (currentIndex + 1) % songUris.size();
    playSong();
}

private void previousSong() {
    if (songUris.isEmpty()) {
        return;
    }

    currentIndex--;

    if (currentIndex < 0) {
        currentIndex = songUris.size() - 1;
    }

    playSong();
}

private void releasePlayer() {
    // Playback is now managed by KingdomMusicService.
    // Do not stop the service when this screen closes.
        }
    private void pauseSong() {
        if (player != null && prepared && player.isPlaying()) {
            player.pause();
            nowPlaying.setText(
                    "⏸ Paused: " + songNames.get(currentIndex)
            );
        }
    }

    private void stopSong() {
        releasePlayer();
        nowPlaying.setText("Nothing playing");
    }

    private void nextSong() {
        if (songUris.isEmpty()) {
            return;
        }

        currentIndex = (currentIndex + 1) % songUris.size();
        playSong();
    }

    private void previousSong() {
        if (songUris.isEmpty()) {
            return;
        }

        currentIndex--;

        if (currentIndex < 0) {
            currentIndex = songUris.size() - 1;
        }

        playSong();
    }

    private void toggleFavourite(int index) {
        String key = songUris.get(index).toString();

        if (favourites.contains(key)) {
            favourites.remove(key);
        } else {
            favourites.add(key);
        }

        saveMusic();
        refreshSongList();
    }

    private void removeSong(int index) {
        if (index == currentIndex) {
            stopSong();
            currentIndex = -1;
        } else if (index < currentIndex) {
            currentIndex--;
        }

        favourites.remove(songUris.get(index).toString());
        songUris.remove(index);
        songNames.remove(index);

        saveMusic();
        refreshSongList();
    }

    private void loadSavedMusic() {
        SharedPreferences prefs =
                getSharedPreferences(PREFS, MODE_PRIVATE);

        Set<String> savedUris = prefs.getStringSet(
                SONGS_KEY, new HashSet<>());

        Set<String> savedNames = prefs.getStringSet(
                NAMES_KEY, new HashSet<>());

        Set<String> savedFavourites = prefs.getStringSet(
                FAVOURITES_KEY, new HashSet<>());

        favourites.addAll(savedFavourites);

        // Restore URI/name pairs using numbered preference entries.
        int count = prefs.getInt("song_count", 0);

        for (int i = 0; i < count; i++) {
            String uriText = prefs.getString("uri_" + i, null);
            String name = prefs.getString("name_" + i, null);

            if (uriText != null) {
                songUris.add(Uri.parse(uriText));
                songNames.add(
                        name == null ? "Saved audio " + (i + 1) : name
                );
            }
        }
    }

    private void saveMusic() {
        SharedPreferences.Editor editor =
                getSharedPreferences(PREFS, MODE_PRIVATE).edit();

        editor.putInt("song_count", songUris.size());

        for (int i = 0; i < songUris.size(); i++) {
            editor.putString("uri_" + i, songUris.get(i).toString());
            editor.putString("name_" + i, songNames.get(i));
        }

        editor.putStringSet(
                FAVOURITES_KEY, new HashSet<>(favourites));

        editor.apply();
    }

    private void releasePlayer() {
        if (player != null) {
            try {
                player.setOnPreparedListener(null);
                player.setOnCompletionListener(null);
                player.setOnErrorListener(null);
                player.release();
            } catch (Exception ignored) {
            }

            player = null;
        }

        prepared = false;
    }

    private void toast(String message) {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }
@Override
protected void onDestroy() {
    // KingdomMusicService manages playback independently.
    super.onDestroy();
}
    
          }
