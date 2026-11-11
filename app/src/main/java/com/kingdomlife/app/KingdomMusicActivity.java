package com.kingdomlife.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
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

    private LinearLayout root;
    private LinearLayout songList;

    private TextView nowPlaying;
    private TextView currentTime;
    private TextView totalTime;

    private SeekBar musicSeekBar;

    private boolean receiverRegistered = false;
    private boolean userSeeking = false;

    private final int purple = Color.rgb(30, 24, 55);
    private final int gold = Color.rgb(184, 134, 11);
    private final int darkText = Color.rgb(45, 45, 45);

    private final BroadcastReceiver progressReceiver =
            new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent == null ||
                    !KingdomMusicService.ACTION_PROGRESS.equals(
                            intent.getAction())) {
                return;
            }

            int position = intent.getIntExtra(
                    KingdomMusicService.EXTRA_POSITION, 0);

            int duration = intent.getIntExtra(
                    KingdomMusicService.EXTRA_DURATION, 0);

            updateProgress(position, duration);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadSavedMusic();
        buildScreen();
    }

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }

    private void buildScreen() {

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(
                dp(20), dp(15), dp(20), dp(25)
        );

        applyKingdomBackground();

        scroll.addView(root);

        scroll.setOnApplyWindowInsetsListener((view, insets) -> {

            view.setPadding(
                    insets.getSystemWindowInsetLeft(),
                    insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom()
            );

            return insets;
        });

        setContentView(scroll);

        TextView title = new TextView(this);
        title.setText("🎵 Kingdom Music");
        title.setTextColor(darkText);
        title.setTextSize(26);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, dp(12), 0, dp(20));

        root.addView(title);

        Button choose = makeButton("＋ Choose Music");
        choose.setOnClickListener(v -> chooseMusic());

        root.addView(choose);

        LinearLayout playerCard = makeCard();

        TextView playerTitle = new TextView(this);
        playerTitle.setText("NOW PLAYING");
        playerTitle.setTextColor(purple);
        playerTitle.setTextSize(13);
        playerTitle.setTypeface(null, Typeface.BOLD);
        playerTitle.setGravity(Gravity.CENTER);

        playerCard.addView(playerTitle);

        nowPlaying = new TextView(this);
        nowPlaying.setText("Nothing playing");
        nowPlaying.setTextColor(darkText);
        nowPlaying.setTextSize(16);
        nowPlaying.setGravity(Gravity.CENTER);
        nowPlaying.setPadding(0, dp(12), 0, dp(12));

        playerCard.addView(nowPlaying);

        musicSeekBar = new SeekBar(this);
        musicSeekBar.setMax(1000);
        musicSeekBar.setProgress(0);

        playerCard.addView(musicSeekBar);

        LinearLayout timeRow = new LinearLayout(this);
        timeRow.setOrientation(LinearLayout.HORIZONTAL);
        timeRow.setGravity(Gravity.CENTER_VERTICAL);

        currentTime = new TextView(this);
        currentTime.setText("00:00");
        currentTime.setTextColor(darkText);
        currentTime.setTextSize(12);

        totalTime = new TextView(this);
        totalTime.setText("00:00");
        totalTime.setTextColor(darkText);
        totalTime.setTextSize(12);
        totalTime.setGravity(Gravity.END);

        timeRow.addView(currentTime,
                new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.WRAP_CONTENT, 1
                ));

        timeRow.addView(totalTime,
                new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.WRAP_CONTENT, 1
                ));

        playerCard.addView(timeRow);

        musicSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(
                    SeekBar seekBar,
                    int progress,
                    boolean fromUser) {

                if (fromUser) {
                    userSeeking = true;
                    currentTime.setText(formatTime(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Intent intent = new Intent(
                        KingdomMusicActivity.this,
                        KingdomMusicService.class
                );

                intent.setAction(
                        KingdomMusicService.ACTION_SEEK
                );

                intent.putExtra(
                        KingdomMusicService.EXTRA_POSITION,
                        seekBar.getProgress()
                );

                startService(intent);

                userSeeking = false;
            }
        });

        root.addView(playerCard, cardMargins());

        addControlRows();

        TextView listTitle = new TextView(this);
        listTitle.setText("Your Music");
        listTitle.setTextColor(darkText);
        listTitle.setTextSize(21);
        listTitle.setTypeface(null, Typeface.BOLD);
        listTitle.setPadding(0, dp(24), 0, dp(10));

        root.addView(listTitle);

        songList = new LinearLayout(this);
        songList.setOrientation(LinearLayout.VERTICAL);

        root.addView(songList);

        Button back = makeButton("⬅ Back to Settings");
        back.setOnClickListener(v -> finish());

        root.addView(back);

        refreshSongList();
    }

    private void applyKingdomBackground() {

        SharedPreferences prefs = getSharedPreferences(
                "KingdomLifeDisplayPrefs",
                MODE_PRIVATE
        );

        String mode = prefs.getString("displayMode", "AUTO");

        if (mode.equals("DAY")) {

            root.setBackgroundResource(
                    R.drawable.kingdom_home_bg
            );

        } else if (mode.equals("NIGHT")) {

            root.setBackgroundResource(
                    R.drawable.kingdom_night_bg
            );

        } else {

            int hour = Calendar.getInstance().get(
                    Calendar.HOUR_OF_DAY
            );

            if (hour >= 6 && hour < 18) {

                root.setBackgroundResource(
                        R.drawable.kingdom_home_bg
                );

            } else {

                root.setBackgroundResource(
                        R.drawable.kingdom_night_bg
                );
            }
        }
    }

    private LinearLayout makeCard() {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(
                dp(14), dp(14), dp(14), dp(14)
        );

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.WHITE);
        background.setCornerRadius(dp(16));
        background.setStroke(dp(1), gold);

        card.setBackground(background);

        return card;
    }

    private LinearLayout.LayoutParams cardMargins() {

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, dp(14), 0, dp(8));

        return params;
    }

    private Button makeButton(String text) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setMinWidth(0);

        button.setBackgroundTintList(
                ColorStateList.valueOf(gold)
        );

        return button;
    }

    private void addControlRows() {

        LinearLayout firstRow = new LinearLayout(this);
        firstRow.setGravity(Gravity.CENTER);
        firstRow.setOrientation(LinearLayout.HORIZONTAL);

        addControl(firstRow, "⏮ Previous", this::previousSong);
        addControl(firstRow, "▶ Play", this::playSong);
        addControl(firstRow, "⏸ Pause", this::pauseSong);

        root.addView(firstRow);

        LinearLayout secondRow = new LinearLayout(this);
        secondRow.setGravity(Gravity.CENTER);
        secondRow.setOrientation(LinearLayout.HORIZONTAL);

        addControl(secondRow, "⏭ Next", this::nextSong);
        addControl(secondRow, "⏹ Stop", this::stopSong);

        root.addView(secondRow);
    }

    private void addControl(
            LinearLayout row,
            String label,
            Runnable action) {

        Button button = makeButton(label);
        button.setTextSize(13);
        button.setPadding(dp(3), 0, dp(3), 0);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        0, dp(55), 1
                );

        params.setMargins(dp(3), dp(4), dp(3), dp(4));

        row.addView(button, params);

        button.setOnClickListener(v -> action.run());
    }

    private String formatTime(int milliseconds) {

        int totalSeconds = Math.max(0, milliseconds) / 1000;

        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format(
                Locale.getDefault(),
                "%02d:%02d",
                minutes,
                seconds
        );
    }

    private void updateProgress(int position, int duration) {

        if (musicSeekBar == null) {
            return;
        }

        if (duration > 0) {

            musicSeekBar.setMax(duration);

            if (!userSeeking) {
                musicSeekBar.setProgress(
                        Math.min(position, duration)
                );
            }

        } else {

            musicSeekBar.setMax(1000);
            musicSeekBar.setProgress(0);
        }

        if (!userSeeking) {
            currentTime.setText(formatTime(position));
        }

        totalTime.setText(formatTime(duration));
    }

    private void chooseMusic() {

        Intent intent = new Intent(
                Intent.ACTION_OPEN_DOCUMENT
        );

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
                resultCode != RESULT_OK ||
                data == null) {
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

            empty.setText(
                    "No songs yet. Choose audio from your device."
            );

            empty.setTextColor(darkText);
            empty.setPadding(0, dp(10), 0, dp(20));

            songList.addView(empty);

            return;
        }

        for (int i = 0; i < songNames.size(); i++) {

            final int index = i;

            LinearLayout card = makeCard();

            TextView name = new TextView(this);

            name.setText(
                    (i + 1) + ". " + songNames.get(i) +
                    (favourites.contains(
                            songUris.get(i).toString()
                    ) ? "  ⭐" : "")
            );

            name.setTextColor(darkText);
            name.setTextSize(15);
            name.setTypeface(null, Typeface.BOLD);

            card.addView(name);

            LinearLayout actions = new LinearLayout(this);
            actions.setOrientation(LinearLayout.HORIZONTAL);

            Button play = makeButton("▶ Play");
            play.setTextSize(12);

            play.setOnClickListener(v -> {
                currentIndex = index;
                playSong();
            });

            actions.addView(play, actionParams());

            Button favourite = makeButton("⭐ Favourite");
            favourite.setTextSize(12);

            favourite.setOnClickListener(
                    v -> toggleFavourite(index)
            );

            actions.addView(favourite, actionParams());

            Button remove = makeButton("Remove");
            remove.setTextSize(12);

            remove.setOnClickListener(
                    v -> removeSong(index)
            );

            actions.addView(remove, actionParams());

            card.addView(actions);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(0, dp(5), 0, dp(5));

            songList.addView(card, params);
        }
    }

    private LinearLayout.LayoutParams actionParams() {

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );

        params.setMargins(dp(2), dp(8), dp(2), dp(2));

        return params;
    }

    private void playSong() {

        if (songUris.isEmpty()) {
            toast("Choose some music first.");
            return;
        }

        if (currentIndex < 0 ||
                currentIndex >= songUris.size()) {
            currentIndex = 0;
        }

        Intent intent = new Intent(
                this,
                KingdomMusicService.class
        );

        intent.setAction(
                KingdomMusicService.ACTION_PLAY
        );

        intent.putExtra(
                KingdomMusicService.EXTRA_URI,
                songUris.get(currentIndex).toString()
        );

        intent.putExtra(
                KingdomMusicService.EXTRA_TITLE,
                songNames.get(currentIndex)
        );

        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }

        nowPlaying.setText(
                "▶ Playing: " + songNames.get(currentIndex)
        );
    }

    private void pauseSong() {

        Intent intent = new Intent(
                this,
                KingdomMusicService.class
        );

        intent.setAction(
                KingdomMusicService.ACTION_PAUSE
        );

        startService(intent);

        nowPlaying.setText("⏸ Pause requested");
    }

    private void stopSong() {

        Intent intent = new Intent(
                this,
                KingdomMusicService.class
        );

        intent.setAction(
                KingdomMusicService.ACTION_STOP
        );

        startService(intent);

        nowPlaying.setText("Nothing playing");

        updateProgress(0, 0);
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

        if (index < 0 || index >= songUris.size()) {
            return;
        }

        String uri = songUris.get(index).toString();

        if (favourites.contains(uri)) {

            favourites.remove(uri);
            toast("Removed from favourites");

        } else {

            favourites.add(uri);
            toast("Added to favourites");
        }

        saveMusic();
        refreshSongList();
    }

    private void removeSong(int index) {

        if (index < 0 || index >= songUris.size()) {
            return;
        }

        String removedUri = songUris.get(index).toString();

        songUris.remove(index);
        songNames.remove(index);
        favourites.remove(removedUri);

        if (songUris.isEmpty()) {

            currentIndex = -1;

        } else if (currentIndex >= songUris.size()) {

            currentIndex = songUris.size() - 1;
        }

        saveMusic();
        refreshSongList();

        toast("Song removed");
    }

    private void loadSavedMusic() {

        SharedPreferences prefs = getSharedPreferences(
                PREFS,
                MODE_PRIVATE
        );

        songUris.clear();
        songNames.clear();
        favourites.clear();

        String savedUris = prefs.getString(SONGS_KEY, "");
String savedNames = prefs.getString(NAMES_KEY, "");

        if (!savedUris.isEmpty() && !savedNames.isEmpty()) {

            String[] uris = savedUris.split("\n", -1);
            String[] names = savedNames.split("\n", -1);

            int count = Math.min(uris.length, names.length);

            for (int i = 0; i < count; i++) {

                if (!uris[i].isEmpty()) {

                    songUris.add(Uri.parse(uris[i]));
                    songNames.add(names[i]);
                }
            }
        }

        favourites.addAll(
                prefs.getStringSet(
                        FAVOURITES_KEY,
                        new HashSet<>()
                )
        );
    }

    private void saveMusic() {

        SharedPreferences prefs = getSharedPreferences(
                PREFS,
                MODE_PRIVATE
        );

        StringBuilder savedUris = new StringBuilder();
        StringBuilder savedNames = new StringBuilder();

        for (int i = 0; i < songUris.size(); i++) {

            if (i > 0) {
                savedUris.append("\n");
                savedNames.append("\n");
            }

            savedUris.append(songUris.get(i).toString());
            savedNames.append(songNames.get(i));
        }

        prefs.edit()
                .putString(SONGS_KEY, savedUris.toString())
                .putString(NAMES_KEY, savedNames.toString())
                .putStringSet(
                        FAVOURITES_KEY,
                        new HashSet<>(favourites)
                )
                .apply();
    }

    @Override
    protected void onResume() {

        super.onResume();

        IntentFilter filter = new IntentFilter(
                KingdomMusicService.ACTION_PROGRESS
        );

        if (Build.VERSION.SDK_INT >= 33) {

            registerReceiver(
                    progressReceiver,
                    filter,
                    Context.RECEIVER_NOT_EXPORTED
            );

        } else {

            registerReceiver(progressReceiver, filter);
        }

        receiverRegistered = true;
    }

    @Override
    protected void onPause() {

        if (receiverRegistered) {

            unregisterReceiver(progressReceiver);
            receiverRegistered = false;
        }

        super.onPause();
    }

    @Override
protected void onDestroy() {

    // KingdomMusicService manages playback independently.
    super.onDestroy();
}

private void toast(String message) {

    Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
    ).show();
}

}
