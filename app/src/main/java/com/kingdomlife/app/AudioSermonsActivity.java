package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Color;
import android.widget.ImageView;
import android.graphics.Typeface;
import android.os.Build;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.widget.SeekBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AudioSermonsActivity extends Activity {

    private LinearLayout content;
    private LinearLayout listContainer;

    private final int PURPLE = Color.rgb(30, 24, 55);
    private final int GOLD = Color.rgb(184, 134, 11);

    private final int WHITE = Color.WHITE;
    private final int DARK_TEXT = Color.rgb(45, 45, 45);

    private int textColor;
    private int headingColor;
    private int cardColor;

    private String selectedSource = "All";
    private String selectedCategory = "All";

    private final ArrayList<SermonItem> sermons =
            new ArrayList<>();

    private final ArrayList<String> favourites =
            new ArrayList<>();
    private SermonItem currentSermon;
private boolean isSermonPlaying = false;

private SeekBar sermonSeekBar;
private TextView currentTimeText;
private TextView durationText;
private Button playPauseButton;

private boolean isReceiverRegistered = false;
    private final BroadcastReceiver sermonProgressReceiver =
        new BroadcastReceiver() {

    @Override
    public void onReceive(
            android.content.Context context,
            Intent intent
    ) {

        if (intent == null
                || !AudioSermonsService.ACTION_PROGRESS.equals(
                        intent.getAction()
                )) {
            return;
        }
        
String receivedTitle = intent.getStringExtra(
        AudioSermonsService.EXTRA_TITLE
);

String receivedUri = intent.getStringExtra(
        AudioSermonsService.EXTRA_URI
);

if (receivedUri != null && !receivedUri.trim().isEmpty()) {

    if (currentSermon == null
            || currentSermon.audioUri == null
            || !receivedUri.equals(
                    currentSermon.audioUri.toString()
            )) {

        currentSermon = new SermonItem(
                receivedTitle != null
                        ? receivedTitle
                        : "Now Playing",
                "Unknown speaker",
                "Unknown ministry",
                "Audio sermon",
                "Local audio",
                Uri.parse(receivedUri)
        );
    }
}
        if (content != null
        && currentSermon != null
        && sermonSeekBar == null) {

    showNowPlaying();
        }
        int position = intent.getIntExtra(
                AudioSermonsService.EXTRA_POSITION,
                0
        );

        int duration = intent.getIntExtra(
                AudioSermonsService.EXTRA_DURATION,
                0
        );

        isSermonPlaying = intent.getBooleanExtra(
                AudioSermonsService.EXTRA_IS_PLAYING,
                false
        );

        if (sermonSeekBar != null) {
            sermonSeekBar.setMax(Math.max(duration, 1));
            sermonSeekBar.setProgress(
                    Math.min(position, duration)
            );
        }

        if (currentTimeText != null) {
            currentTimeText.setText(formatSermonTime(position));
        }

        if (durationText != null) {
            durationText.setText(formatSermonTime(duration));
        }

        if (playPauseButton != null) {
            playPauseButton.setText(
                    isSermonPlaying ? "Pause" : "Play"
            );
        }
    }
};

private static final int PICK_AUDIO_REQUEST = 2001;
    private static class SermonItem {

        String title;
        String speaker;
        String ministry;
        String category;
        String source;
        Uri audioUri;

        SermonItem(
                String title,
                String speaker,
                String ministry,
                String category,
                String source,
                Uri audioUri
        ) {
            this.title = title;
            this.speaker = speaker;
            this.ministry = ministry;
            this.category = category;
            this.source = source;
            this.audioUri = audioUri;
        }
    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

loadFavourites();
prepareSampleLibrary();
showLibraryHome();
registerSermonProgressReceiver();
    }
    @Override
protected void onDestroy() {
    super.onDestroy();

    if (isReceiverRegistered) {
        unregisterReceiver(sermonProgressReceiver);
        isReceiverRegistered = false;
    }
}

    private void prepareSampleLibrary() {

        // These are sample entries to demonstrate
        // how different sermon sources will be organised.

        sermons.add(new SermonItem(
                "Growing in Faith",
                "Kingdom Life",
                "Kingdom Life",
                "Faith",
                "Kingdom Life",
                null
        ));

        sermons.add(new SermonItem(
                "The Power of Prayer",
                "Kingdom Life",
                "Kingdom Life",
                "Prayer",
                "Kingdom Life",
                null
        ));

        sermons.add(new SermonItem(
                "Walking in Wisdom",
                "External Minister",
                "Online Ministry",
                "Wisdom",
                "Online",
                null
        ));
    }

    // --------------------------------------------------
    // DISPLAY MODE
    // --------------------------------------------------

    
private int dp(int value) {
    return (int) (value * getResources()
            .getDisplayMetrics().density + 0.5f);
}
    private void applyKingdomBackground() {

        android.content.SharedPreferences displayPrefs =
                getSharedPreferences(
                        "KingdomLifeDisplayPrefs",
                        MODE_PRIVATE
                );

        String displayMode =
                displayPrefs.getString("displayMode", "AUTO");

        boolean nightMode;

        if (displayMode.equals("DAY")) {

            content.setBackgroundResource(
                    R.drawable.kingdom_home_bg
            );

            nightMode = false;

        } else if (displayMode.equals("NIGHT")) {

            content.setBackgroundResource(
                    R.drawable.kingdom_night_bg
            );

            nightMode = true;

        } else {

            int hour = Calendar.getInstance()
                    .get(Calendar.HOUR_OF_DAY);

            nightMode = hour < 6 || hour >= 18;

            if (nightMode) {

                content.setBackgroundResource(
                        R.drawable.kingdom_night_bg
                );

            } else {

                content.setBackgroundResource(
                        R.drawable.kingdom_home_bg
                );
            }
        }

        if (nightMode) {

            textColor = WHITE;
            headingColor = GOLD;
            cardColor = Color.rgb(39, 32, 67);

        } else {

            textColor = DARK_TEXT;
            headingColor = PURPLE;
            cardColor = Color.rgb(245, 240, 255);
        }
    }

    // --------------------------------------------------
    // MAIN LIBRARY SCREEN
    // --------------------------------------------------
    private void showLibraryHome() {

    ScrollView scrollView = new ScrollView(this);

    content = new LinearLayout(this);
    content.setOrientation(LinearLayout.VERTICAL);

    applyKingdomBackground();

    scrollView.addView(content);

    // Keep content clear of the phone's system bars.
    scrollView.setOnApplyWindowInsetsListener((view, insets) -> {

        view.setPadding(
                insets.getSystemWindowInsetLeft(),
                insets.getSystemWindowInsetTop(),
                insets.getSystemWindowInsetRight(),
                insets.getSystemWindowInsetBottom()
        );

        return insets;
    });

    setContentView(scrollView);

    LinearLayout page = new LinearLayout(this);
    page.setOrientation(LinearLayout.VERTICAL);

    page.setPadding(
            dp(18),
            dp(18),
            dp(18),
            dp(30)
    );

    content.addView(page);

    addBackButton(page);

    addText(
            page,
            "🎧 Audio Sermons Library",
            25,
            headingColor,
            true
    );

    addText(
            page,
            "Listen, learn and grow through the Word.",
            14,
            textColor,
            false
    );

    addSpace(page, 18);

    addSectionTitle(page, "Browse Sermons");
    addSourceFilters(page);

    addSpace(page, 15);

    addSectionTitle(page, "Categories");
    addCategoryFilters(page);

    addSpace(page, 15);

    addSectionTitle(page, "Featured Sermons");
    addFeaturedSection(page);

    addSpace(page, 15);

    addSectionTitle(page, "All Sermons");

    listContainer = new LinearLayout(this);
    listContainer.setOrientation(LinearLayout.VERTICAL);
    page.addView(listContainer);

    displaySermons();

    addSpace(page, 18);

    addSectionTitle(page, "Your Library");

    addMenuCard(
            page,
            "⭐ Favourites",
            "Your saved sermons",
            v -> showFavourites()
    );

    addMenuCard(
            page,
            "📥 Add Offline Sermons",
            "Choose audio files from your device",
            v -> pickOfflineAudio()
    );

    addMenuCard(
        page,
        "▶ Now Playing",
        "Open your audio sermon player",
        v -> showNowPlaying()
);
    }
    private void addSourceFilters(LinearLayout parent) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);

        parent.addView(row);

        String[] sources = {
                "All",
                "Kingdom Life",
                "Online",
                "Offline"
        };

        for (String source : sources) {

            Button button = new Button(this);

            button.setText(source);
            button.setTextSize(10);

            button.setAllCaps(false);

            button.setTextColor(
                    selectedSource.equals(source)
                            ? WHITE
                            : textColor
            );

            button.setBackground(
                    roundedBackground(
                            selectedSource.equals(source)
                                    ? PURPLE
                                    : cardColor,
                            GOLD,
                            16
                    )
            );

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            0,
                            dp(43),
                            1
                    );

            params.setMargins(
                    dp(2),
                    0,
                    dp(2),
                    0
            );

            row.addView(button, params);

            button.setOnClickListener(v -> {

                selectedSource = source;

                showLibraryHome();
            });
        }
    }

    // --------------------------------------------------
    // CATEGORY FILTERS
    // --------------------------------------------------

    private void addCategoryFilters(LinearLayout parent) {

        String[] categories = {
                "All",
                "Faith",
                "Prayer",
                "Wisdom",
                "Love",
                "Praise",
                "Holy Spirit"
        };

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);

        row.setGravity(Gravity.CENTER_VERTICAL);

        parent.addView(row);

        for (String category : categories) {

            TextView chip = new TextView(this);

            chip.setText(category);
            chip.setTextSize(12);

            chip.setTextColor(
                    selectedCategory.equals(category)
                            ? WHITE
                            : textColor
            );

            chip.setPadding(
                    dp(13),
                    dp(9),
                    dp(13),
                    dp(9)
            );

            chip.setBackground(
                    roundedBackground(
                            selectedCategory.equals(category)
                                    ? PURPLE
                                    : cardColor,
                            GOLD,
                            20
                    )
            );

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            -2,
                            -2
                    );

            params.setMargins(
                    0,
                    0,
                    dp(7),
                    dp(7)
            );

            row.addView(chip, params);

            chip.setOnClickListener(v -> {

                selectedCategory = category;

                showLibraryHome();
            });
        }
    }

    // --------------------------------------------------
    // FEATURED SECTION
    // --------------------------------------------------

    private void addFeaturedSection(LinearLayout parent) {

        LinearLayout card = createCard();

        parent.addView(card);

        addText(
                card,
                "✨ Featured Teaching",
                18,
                headingColor,
                true
        );

        addText(
                card,
                "Growing in Faith",
                17,
                textColor,
                true
        );

        addText(
                card,
                "Kingdom Life • Faith",
                13,
                textColor,
                false
        );

        addSpace(card, 8);

        Button listen = new Button(this);

        listen.setText("▶ Listen");
        listen.setAllCaps(false);

        listen.setTextColor(WHITE);

        listen.setBackground(
                roundedBackground(
                        PURPLE,
                        GOLD,
                        18
                )
        );

        card.addView(listen);

        listen.setOnClickListener(v -> {

            showMessage(
                    "The audio player will be connected "
                            + "when the audio sources are added."
            );
        });
    }

    // --------------------------------------------------
    // SERMON LIST
    // --------------------------------------------------

    private void displaySermons() {

        listContainer.removeAllViews();

        int count = 0;

        for (SermonItem sermon : sermons) {

            if (!selectedSource.equals("All")
                    && !sermon.source.equals(selectedSource)) {
                continue;
            }

            if (!selectedCategory.equals("All")
                    && !sermon.category.equals(selectedCategory)) {
                continue;
            }

            addSermonCard(listContainer, sermon);

            count++;
        }

        if (count == 0) {

            addText(
                    listContainer,
                    "No sermons found in this section yet.",
                    14,
                    textColor,
                    false
            );
        }
    }

    private void addSermonCard(
            LinearLayout parent,
            SermonItem sermon
    ) {

        LinearLayout card = createCard();

        parent.addView(card);

        addText(
                card,
                "🎧 " + sermon.title,
                17,
                headingColor,
                true
        );

        addText(
                card,
                "Speaker: " + sermon.speaker,
                13,
                textColor,
                false
        );

        addText(
                card,
                "Ministry: " + sermon.ministry,
                13,
                textColor,
                false
        );

        addText(
                card,
                "Category: " + sermon.category,
                13,
                textColor,
                false
        );

        addText(
                card,
                "Source: " + getSourceLabel(sermon.source),
                12,
                headingColor,
                true
        );

        addSpace(card, 7);

        LinearLayout actions = new LinearLayout(this);
        actions.setOrientation(LinearLayout.HORIZONTAL);

        card.addView(actions);

        Button listen = new Button(this);

        listen.setText("▶ Listen");
        listen.setAllCaps(false);
        listen.setTextColor(WHITE);

        listen.setBackground(
                roundedBackground(
                        PURPLE,
                        GOLD,
                        16
                )
        );

        actions.addView(
                listen,
                new LinearLayout.LayoutParams(
                        0,
                        dp(43),
                        1
                )
        );

        listen.setOnClickListener(v -> {

    if (sermon.audioUri == null) {

        showMessage(
                "This sermon is awaiting its "
                        + "audio source."
        );

    } else {

        playSermon(sermon);
    }
});

        Button favourite = new Button(this);

        favourite.setAllCaps(false);
        favourite.setTextColor(headingColor);

        updateFavouriteButton(favourite, sermon);

        LinearLayout.LayoutParams favParams =
                new LinearLayout.LayoutParams(
                        0,
                        dp(43),
                        1
                );

        favParams.setMargins(dp(8), 0, 0, 0);

        actions.addView(favourite, favParams);

        favourite.setOnClickListener(v -> {

            if (favourites.contains(sermon.title)) {

    favourites.remove(sermon.title);

} else {

    favourites.add(sermon.title);
}

saveFavourites();

            updateFavouriteButton(favourite, sermon);
        });
    }

    private void updateFavouriteButton(
            Button button,
            SermonItem sermon
    ) {

        if (favourites.contains(sermon.title)) {

            button.setText("★ Saved");

        } else {

            button.setText("☆ Favourite");
        }

        button.setBackground(
                roundedBackground(
                        cardColor,
                        GOLD,
                        16
                )
        );
    }
    
private void saveFavourites() {

    getSharedPreferences(
            "KingdomLifeSermonPrefs",
            MODE_PRIVATE
    ).edit()
            .putStringSet(
                    "favourite_sermons",
                    new java.util.HashSet<>(favourites)
            )
            .apply();
}
    
private void loadFavourites() {

    java.util.Set<String> savedFavourites =
            getSharedPreferences(
                    "KingdomLifeSermonPrefs",
                    MODE_PRIVATE
            ).getStringSet(
                    "favourite_sermons",
                    new java.util.HashSet<>()
            );

    favourites.clear();

    if (savedFavourites != null) {
        favourites.addAll(savedFavourites);
    }
}
    
    

    private String getSourceLabel(String source) {

        if (source.equals("Kingdom Life")) {
            return "👑 Kingdom Life";
        }

        if (source.equals("Online")) {
            return "🌐 Online";
        }

        return "📥 Offline";
    }

    // --------------------------------------------------
    // FAVOURITES
    // --------------------------------------------------

    private void showFavourites() {

        LinearLayout root = createPage();

        addBackButton(root);

        addText(
                root,
                "⭐ Favourite Sermons",
                23,
                headingColor,
                true
        );

        boolean found = false;

        for (SermonItem sermon : sermons) {

            if (favourites.contains(sermon.title)) {

                addSermonCard(root, sermon);

                found = true;
            }
        }

        if (!found) {

            addText(
                    root,
                    "You haven't saved any sermons yet.",
                    14,
                    textColor,
                    false
            );
        }
    }

    // --------------------------------------------------
    // OFFLINE AUDIO FILES
    // --------------------------------------------------

    private void pickOfflineAudio() {

        Intent intent = new Intent(
                Intent.ACTION_OPEN_DOCUMENT
        );

        intent.setType("audio/*");

        intent.addCategory(
                Intent.CATEGORY_OPENABLE
        );

        intent.addFlags(
                Intent.FLAG_GRANT_READ_URI_PERMISSION
                        | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
        );

        startActivityForResult(
                intent,
                PICK_AUDIO_REQUEST
        );
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data
    ) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );

        if (requestCode == PICK_AUDIO_REQUEST
                && resultCode == RESULT_OK
                && data != null) {

            Uri audioUri = data.getData();

            if (audioUri != null) {

                try {

                    getContentResolver()
                            .takePersistableUriPermission(
                                    audioUri,
                                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                            );

                } catch (Exception ignored) {
                    // Some document providers may not support
                    // persistent URI permissions.
                }

                String fileName = "Offline Sermon";

                if (data.getData() != null) {

                    String path = audioUri.getLastPathSegment();

                    if (path != null && !path.isEmpty()) {
                        fileName = path;
                    }
                }

                sermons.add(
                        new SermonItem(
                                fileName,
                                "Device Audio",
                                "Offline Library",
                                "Other",
                                "Offline",
                                                        audioUri
                        )
                );

                selectedSource = "Offline";
                selectedCategory = "All";

                showLibraryHome();

                Toast.makeText(
                        this,
                        "Audio added to your library.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

    // --------------------------------------------------
    // MENU CARDS
    // --------------------------------------------------

    private void addMenuCard(
            LinearLayout parent,
            String title,
            String subtitle,
            View.OnClickListener listener
    ) {

        LinearLayout card = createCard();

        parent.addView(card);

        addText(
                card,
                title,
                17,
                headingColor,
                true
        );

        addText(
                card,
                subtitle,
                13,
                textColor,
                false
        );

        card.setOnClickListener(listener);
    }

    // --------------------------------------------------
    // COMMON UI HELPERS
    // --------------------------------------------------

    private LinearLayout createPage() {

        content = new LinearLayout(this);

        content.setOrientation(
                LinearLayout.VERTICAL
        );

        applyKingdomBackground();

        setContentView(content);

        ScrollView scrollView = new ScrollView(this);

        content.addView(
                scrollView,
                new LinearLayout.LayoutParams(
                        -1,
                        -1
                )
        );

        LinearLayout page = new LinearLayout(this);
      page.setOrientation(
                LinearLayout.VERTICAL
        );

        page.setPadding(
                dp(18),
                dp(18),
                dp(18),
                dp(30)
        );

        scrollView.addView(page);

        return page;
    }

    private LinearLayout createCard() {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(15),
                dp(14),
                dp(15),
                dp(14)
        );

        card.setBackground(
                roundedBackground(
                        cardColor,
                        GOLD,
                        18
                )
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        -2
                );

        params.setMargins(
                0,
                0,
                0,
                dp(12)
        );

        card.setLayoutParams(params);

        return card;
    }

    private void addBackButton(LinearLayout parent) {

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setContentDescription("Back");

    backButton.setOnClickListener(v -> finish());

    parent.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    dp(60),
                    dp(60)
            )
    );
    }

    private void addSectionTitle(
            LinearLayout parent,
            String title
    ) {

        addText(
                parent,
                title,
                19,
                headingColor,
                true
        );
                                     }
  private void addText(
            LinearLayout parent,
            String text,
            int size,
            int color,
            boolean bold
    ) {

        TextView view = new TextView(this);

        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(color);

        if (bold) {

            view.setTypeface(
                    null,
                    Typeface.BOLD
            );
        }

        view.setPadding(
                0,
                dp(5),
                0,
                dp(5)
        );

        parent.addView(view);
    }

    private void addSpace(
            LinearLayout parent,
            int height
    ) {

        View space = new View(this);

        parent.addView(
                space,
                new LinearLayout.LayoutParams(
                        1,
                        dp(height)
                )
        );
    }

    private GradientDrawable roundedBackground(
            int backgroundColor,
            int strokeColor,
            int radius
    ) {

        GradientDrawable drawable =
                new GradientDrawable();

        drawable.setColor(backgroundColor);

        drawable.setCornerRadius(
                dp(radius)
        );

        drawable.setStroke(
                dp(1),
                strokeColor
        );

        return drawable;
    }

    private int dp(float value) {

        return (int) (
                value * getResources()
                        .getDisplayMetrics()
                        .density
        );
    }

    private void showMessage(String message) {

        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }
    
private void saveCurrentSermon() {

    if (currentSermon == null ||
            currentSermon.audioUri == null) {
        return;
    }

    getSharedPreferences(
            "KingdomLifeSermonPrefs",
            MODE_PRIVATE
    ).edit()
            .putString(
                    "last_sermon_title",
                    currentSermon.title
            )
            .putString(
                    "last_sermon_uri",
                    currentSermon.audioUri.toString()
            )
            .apply();
}
    
    private void playSermon(SermonItem sermon) {
        currentSermon = sermon;
isSermonPlaying = true;

saveCurrentSermon();

    Intent intent = new Intent(
            this,
            AudioSermonsService.class
    );

    intent.setAction(
            AudioSermonsService.ACTION_PLAY
    );

    intent.putExtra(
            AudioSermonsService.EXTRA_URI,
            sermon.audioUri.toString()
    );

    intent.putExtra(
            AudioSermonsService.EXTRA_TITLE,
            sermon.title
    );

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        startForegroundService(intent);
    } else {
        startService(intent);
    }

    showMessage("Opening: " + sermon.title);
    }
    private void toggleSermonPlayback() {

    if (currentSermon == null
            || currentSermon.audioUri == null) {
        showMessage("Select a sermon first.");
        return;
    }

    Intent intent = new Intent(
            this,
            AudioSermonsService.class
    );

    if (isSermonPlaying) {
        intent.setAction(
                AudioSermonsService.ACTION_PAUSE
        );
    } else {
        intent.setAction(
                AudioSermonsService.ACTION_PLAY
        );

        intent.putExtra(
                AudioSermonsService.EXTRA_URI,
                currentSermon.audioUri.toString()
        );

        intent.putExtra(
                AudioSermonsService.EXTRA_TITLE,
                currentSermon.title
        );
    }

    startService(intent);
    }
    private void stopSermonPlayback() {

    Intent intent = new Intent(
            this,
            AudioSermonsService.class
    );

    intent.setAction(
            AudioSermonsService.ACTION_STOP
    );

    startService(intent);

    isSermonPlaying = false;

    if (sermonSeekBar != null) {
        sermonSeekBar.setProgress(0);
    }

    if (currentTimeText != null) {
        currentTimeText.setText("00:00");
    }

    if (playPauseButton != null) {
        playPauseButton.setText("Play");
    }
    }
    private void showNowPlaying() {

    LinearLayout page = createPage();

    addBackButton(page);

    addText(
            page,
            "▶ Now Playing",
            24,
            headingColor,
            true
    );

    addSpace(page, 20);

    if (currentSermon == null) {

        addText(
                page,
                "No sermon selected",
                18,
                headingColor,
                true
        );

        addText(
                page,
                "Choose a sermon from your library to begin listening.",
                14,
                textColor,
                false
        );

        return;
    }

    addText(
            page,
            "🎧 " + currentSermon.title,
            20,
            headingColor,
            true
    );

    addText(
            page,
            "Speaker: " + currentSermon.speaker,
            14,
            textColor,
            false
    );

    addText(
            page,
            "Ministry: " + currentSermon.ministry,
            14,
            textColor,
            false
    );

    addSpace(page, 20);

    // Playback progress bar
    sermonSeekBar = new SeekBar(this);
    sermonSeekBar.setMax(1);
    sermonSeekBar.setProgress(0);

    page.addView(
            sermonSeekBar,
            new LinearLayout.LayoutParams(
                    -1,
                    dp(45)
            )
    );

    // Playback time
    LinearLayout timeRow = new LinearLayout(this);
    timeRow.setOrientation(LinearLayout.HORIZONTAL);
    timeRow.setGravity(Gravity.CENTER_VERTICAL);

    currentTimeText = new TextView(this);
    currentTimeText.setText("00:00");
    currentTimeText.setTextColor(textColor);

    durationText = new TextView(this);
    durationText.setText("00:00");
    durationText.setTextColor(textColor);
    durationText.setGravity(Gravity.RIGHT);

    timeRow.addView(
            currentTimeText,
            new LinearLayout.LayoutParams(
                    0,
                    -2,
                    1
            )
    );

    timeRow.addView(
            durationText,
            new LinearLayout.LayoutParams(
                    0,
                    -2,
                    1
            )
    );

    page.addView(timeRow);

    addSpace(page, 15);

    // Playback buttons
    LinearLayout controls = new LinearLayout(this);
    controls.setOrientation(LinearLayout.HORIZONTAL);
    controls.setGravity(Gravity.CENTER);

    playPauseButton = new Button(this);
    playPauseButton.setText(
            isSermonPlaying ? "Pause" : "Play"
    );

    Button stopButton = new Button(this);
    stopButton.setText("Stop");

    controls.addView(playPauseButton);
    controls.addView(stopButton);

    page.addView(controls);

    // Play/Pause
    playPauseButton.setOnClickListener(
            v -> toggleSermonPlayback()
    );

    // Stop
    stopButton.setOnClickListener(
            v -> stopSermonPlayback()
    );

    // Seek listener
    sermonSeekBar.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(
                SeekBar seekBar,
                int progress,
                boolean fromUser
        ) {
        }

        @Override
        public void onStartTrackingTouch(
                SeekBar seekBar
        ) {
        }

        @Override
        public void onStopTrackingTouch(
                SeekBar seekBar
        ) {

            Intent intent = new Intent(
                    AudioSermonsActivity.this,
                    AudioSermonsService.class
            );

            intent.setAction(
                    AudioSermonsService.ACTION_SEEK
            );

            intent.putExtra(
                    AudioSermonsService.EXTRA_POSITION,
                    seekBar.getProgress()
            );

            startService(intent);
        }
    });

    // Request current playback information
    Intent progressIntent = new Intent(
            this,
            AudioSermonsService.class
    );

    progressIntent.setAction(
            AudioSermonsService.ACTION_REQUEST_PROGRESS
    );

    startService(progressIntent);
                }

    private String formatSermonTime(int milliseconds) {

    int totalSeconds = Math.max(0, milliseconds) / 1000;

    int minutes = totalSeconds / 60;
    int seconds = totalSeconds % 60;

    return String.format(
            java.util.Locale.getDefault(),
            "%02d:%02d",
            minutes,
            seconds
    );
    }
    private void registerSermonProgressReceiver() {

    if (isReceiverRegistered) {
        return;
    }

    IntentFilter filter = new IntentFilter(
            AudioSermonsService.ACTION_PROGRESS
    );

    if (Build.VERSION.SDK_INT >= 33) {
        registerReceiver(
                sermonProgressReceiver,
                filter,
                android.content.Context.RECEIVER_NOT_EXPORTED
        );
    } else {
        registerReceiver(
                sermonProgressReceiver,
                filter
        );
    }

    isReceiverRegistered = true;
    }
}
  
      
                 
