package com.kingdomlife.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class BibleJigsawPuzzle {

    private final MainActivity activity;
    private final LinearLayout content;

    private static final int OLD_TESTAMENT_LEVELS = 50;
private static final int FIRST_NEW_TESTAMENT_LEVEL = 51;
    private static final int ROYAL_PURPLE =
            Color.rgb(30, 24, 55);

    private static final int KINGDOM_GOLD =
            Color.rgb(184, 134, 11);

    private static final String PREFS_NAME =
            "KingdomLifeJigsawPrefs";

    private static final String[] OLD_TESTAMENT_IMAGES = {
        "genesis_eden",
        "genesis_noah",
        "genesis_joseph",
        "abraham_covenant",
        "moses_red_sea",
        "joshua_jericho",
        "david_goliath",
        "david_king",
        "elijah_carmel",
        "esther_queen",
        "ruth_bethlehem",
        "samuel_called",
        "solomon_temple",
        "daniel_lions",
        "shadrach_furnace",
        "jonah_whale",
        "ezra_scriptures",
        "nehemiah_wall",
        "gideon_army",
        "samson_strength",
        "creation_world",
        "job_trials",
        "david_anointed",
        "david_shepherd",
        "moses_commandments",
        "ruth_boaz",
        "tower_babel",
        "jacob_dream",
        "joseph_coat",
        "burning_bush",
        "ten_plagues",
        "manna_wilderness",
        "solomon_judgment",
        "elisha_naaman",
        "moses_basket",
        "joseph_pharaoh_dreams",
        "samson_delilah",
        "writing_on_wall",
        "elijah_widow",
        "jacob_esau",
        "isaac_moriah",
        "jacob_wrestles",
        "balaam_donkey",
        "joshua_jordan",
        "deborah_barak",
        "hannah_prays",
        "david_spares_saul",
        "elijah_taken_up",
        "josiah_law_book",
        "daniel_four_beasts"
};

private static final String[] OLD_TESTAMENT_STORIES = {
        "The Garden of Eden",
        "Noah's Ark",
        "Joseph in Egypt",
        "Abraham and God's Covenant",
        "Moses and the Red Sea",
        "Joshua and Jericho",
        "David and Goliath",
        "David, King of Israel",
        "Elijah on Mount Carmel",
        "Esther's Courage",
        "Ruth and Bethlehem",
        "Samuel Hears God's Call",
        "Solomon Builds the Temple",
        "Daniel and the Lions",
        "The Fiery Furnace",
        "Jonah and the Great Fish",
        "Ezra and the Scriptures",
        "Nehemiah Rebuilds the Wall",
        "Gideon's Army",
        "Samson's Strength",
        "God Creates the World",
        "Job's Faith and Trials",
        "David Anointed as King",
        "David the Shepherd Boy",
        "Moses and the Ten Commandments",
        "Ruth and Boaz",
        "The Tower of Babel",
        "Jacob's Dream",
        "Joseph's Coat of Many Colours",
        "Moses and the Burning Bush",
        "The Ten Plagues of Egypt",
        "Manna in the Wilderness",
        "Solomon and the Two Women",
        "Elisha and Naaman",
        "Moses in the Basket",
        "Joseph Interprets Pharaoh's Dreams",
        "Samson and Delilah",
        "The Writing on the Wall",
        "Elijah and the Widow of Zarephath",
        "Jacob and Esau",
        "Isaac on Mount Moriah",
        "Jacob Wrestles with God",
        "Balaam and the Talking Donkey",
        "Joshua Crosses the Jordan",
        "Deborah and Barak",
        "Hannah Prays for a Son",
        "David Spares Saul",
        "Elijah Is Taken Up to Heaven",
        "Josiah Finds the Book of the Law",
        "Daniel and the Four Beasts"
};
    
    public BibleJigsawPuzzle(MainActivity activity) {
        this.activity = activity;
        this.content = activity.content;
    }

    public void showJigsawMenu() {
        showLevelPage(false);
    }

    private void showLevelPage(boolean newTestament) {
        activity.stopTimer();
        content.removeAllViews();
        content.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(activity);
        title.setText("🧩 Bible Jigsaw Challenge");
        title.setTextSize(25);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(activity.darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(8, 16, 8, 4);
        content.addView(title);

        TextView subtitle = new TextView(activity);
        subtitle.setText(
        newTestament
                ? "New Testament • Levels 51–58"
                : "Old Testament • Levels 1–50"
);
        subtitle.setTextSize(15);
        subtitle.setTextColor(activity.darkText);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(8, 4, 8, 12);
        content.addView(subtitle);

        LinearLayout navigation = new LinearLayout(activity);
        navigation.setOrientation(LinearLayout.HORIZONTAL);
        navigation.setGravity(Gravity.CENTER);
        navigation.setPadding(8, 4, 8, 8);

        Button oldButton = new Button(activity);
        oldButton.setText("Old Testament");
        oldButton.setOnClickListener(v -> showLevelPage(false));

        Button newButton = new Button(activity);
        newButton.setText("New Testament");
        newButton.setOnClickListener(v -> showLevelPage(true));

        navigation.addView(oldButton,
                new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

        navigation.addView(newButton,
                new LinearLayout.LayoutParams(0,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 1f));

        content.addView(navigation);

        ScrollView scroll = new ScrollView(activity);

        LinearLayout grid = new LinearLayout(activity);
        grid.setOrientation(LinearLayout.VERTICAL);
        grid.setPadding(10, 8, 10, 12);

        scroll.addView(grid);
if (newTestament) {
    addNewTestamentLevels(grid);
} else {
    addOldTestamentLevels(grid);
}

        content.addView(scroll, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f));

        Button back = new Button(activity);
        back.setText("⬅ Back to Puzzle Menu");
        back.setOnClickListener(v -> activity.showPuzzleMenu());
        content.addView(back);
    }

    private void addOldTestamentLevels(LinearLayout grid) {
        SharedPreferences prefs =
                activity.getSharedPreferences(
                        PREFS_NAME,
                        Activity.MODE_PRIVATE
                );

        int highestUnlocked =
                prefs.getInt("highestUnlockedLevel", 1);

        int previouslyShownUnlocked =
                prefs.getInt("jigsawLastShownUnlockedLevel", 1);

        LinearLayout row = null;

        for (int level = 1;
             level <= OLD_TESTAMENT_LEVELS;
             level++) {

            if ((level - 1) % 2 == 0) {
                row = new LinearLayout(activity);
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setGravity(Gravity.CENTER_VERTICAL);
                grid.addView(row);
            }

            final int selectedLevel = level;
            boolean unlocked = level <= highestUnlocked;

            LinearLayout card = new LinearLayout(activity);
            card.setOrientation(LinearLayout.HORIZONTAL);
            card.setGravity(Gravity.CENTER);
            card.setPadding(8, 16, 8, 16);

            GradientDrawable background = new GradientDrawable();
            background.setColor(
                    unlocked
                            ? ROYAL_PURPLE
                            : Color.rgb(65, 60, 75)
            );
            background.setCornerRadius(16);
            background.setStroke(2, KINGDOM_GOLD);
            card.setBackground(background);
            card.setEnabled(unlocked);

            TextView label = new TextView(activity);
            label.setText(
                    (unlocked ? "🔓 " : "🔒 ")
                    + "Level " + level
            );
            label.setTextColor(Color.WHITE);
            label.setTextSize(16);
            label.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            label.setGravity(Gravity.CENTER);

            card.addView(label);

            LinearLayout.LayoutParams cardParams =
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1f
                    );

            cardParams.setMargins(5, 5, 5, 5);
            row.addView(card, cardParams);

            if (unlocked) {
                card.setOnClickListener(v ->
                        openLevel(selectedLevel));
            } else {
                card.setOnClickListener(v ->
                        Toast.makeText(
                                activity,
                                "Complete the previous levels to unlock this one.",
                                Toast.LENGTH_SHORT
                        ).show());
            }

            if (level == highestUnlocked
                    && highestUnlocked > previouslyShownUnlocked) {
                label.setText("🔒 Level " + level);

                LevelUnlockAnimator.animateUnlock(
                        label,
                        label,
                        activity,
                        "Level " + level
                );
            }
        }

        if (highestUnlocked > previouslyShownUnlocked) {
            prefs.edit()
                    .putInt(
                            "jigsawLastShownUnlockedLevel",
                            highestUnlocked
                    )
                    .apply();
        }
    }
    
private void addNewTestamentLevels(LinearLayout grid) {
    SharedPreferences prefs =
            activity.getSharedPreferences(
                    PREFS_NAME,
                    Activity.MODE_PRIVATE
            );

    int highestUnlocked =
            prefs.getInt("highestUnlockedLevel", 1);

    LinearLayout row = null;

    for (int level = FIRST_NEW_TESTAMENT_LEVEL;
         level < FIRST_NEW_TESTAMENT_LEVEL + 8;
         level++) {

        if ((level - FIRST_NEW_TESTAMENT_LEVEL) % 2 == 0) {
            row = new LinearLayout(activity);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);
            grid.addView(row);
        }

        final int selectedLevel = level;
        boolean unlocked = level <= highestUnlocked;

        LinearLayout card = new LinearLayout(activity);
        card.setOrientation(LinearLayout.HORIZONTAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(8, 16, 8, 16);

        GradientDrawable background = new GradientDrawable();
        background.setColor(
                unlocked
                        ? ROYAL_PURPLE
                        : Color.rgb(65, 60, 75)
        );
        background.setCornerRadius(16);
        background.setStroke(2, KINGDOM_GOLD);
        card.setBackground(background);
        card.setEnabled(unlocked);

        TextView label = new TextView(activity);
        label.setText(
                (unlocked ? "🔓 " : "🔒 ")
                + "Level " + level
        );
        label.setTextColor(Color.WHITE);
        label.setTextSize(16);
        label.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        label.setGravity(Gravity.CENTER);

        card.addView(label);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1f
                );

        cardParams.setMargins(5, 5, 5, 5);
        row.addView(card, cardParams);

        if (unlocked) {
            card.setOnClickListener(v ->
                    openLevel(selectedLevel));
        } else {
            card.setOnClickListener(v ->
                    Toast.makeText(
                            activity,
                            "Complete the previous levels to unlock this one.",
                            Toast.LENGTH_SHORT
                    ).show());
        }
    }
        }
    private void openLevel(int level) {
    String[] difficulties = {
            "Easy", "Medium", "Hard", "Medium", "Easy",
            "Hard", "Easy", "Hard", "Medium", "Easy",
            "Medium", "Easy", "Hard", "Hard", "Medium",
            "Easy", "Medium", "Hard", "Medium", "Hard",
            "Easy", "Medium", "Hard", "Easy", "Medium",
            "Hard", "Easy", "Medium", "Hard", "Easy",
            "Hard", "Medium", "Easy", "Hard", "Medium",
            "Easy", "Hard", "Medium", "Easy", "Hard"
    };

    String imageName;
    String difficulty;

    if (level >= 1 && level <= OLD_TESTAMENT_LEVELS) {
        imageName = OLD_TESTAMENT_IMAGES[level - 1];

        if (level <= difficulties.length) {
            difficulty = difficulties[level - 1];
        } else {
            difficulty = "Medium";
        }

    } else if (level >= FIRST_NEW_TESTAMENT_LEVEL
            && level < FIRST_NEW_TESTAMENT_LEVEL + 8) {

        String[] newTestamentImages = {
                "jesus_birth",
                "jesus_teaches",
                "feeding_multitude",
                "calming_storm",
                "parable_sower",
                "last_supper",
                "crucifixion",
                "resurrection"
        };

        imageName =
                newTestamentImages[level - FIRST_NEW_TESTAMENT_LEVEL];
        difficulty = "Medium";

    } else {
        new android.app.AlertDialog.Builder(activity)
                .setTitle("Puzzle Not Available Yet")
                .setMessage(
                        "This level does not have a puzzle image yet."
                )
                .setPositiveButton("OK", null)
                .show();
        return;
    }

    int imageId = activity.getResources().getIdentifier(
            imageName,
            "drawable",
            activity.getPackageName()
    );

    android.util.Log.d(
            "JigsawImageCheck",
            "Level: " + level
                    + ", Image: " + imageName
                    + ", Resource ID: " + imageId
    );

    if (imageId == 0) {
        new android.app.AlertDialog.Builder(activity)
                .setTitle("Puzzle Image Not Added Yet")
                .setMessage(
                        "Level " + level
                                + " needs an image named:\n\n"
                                + imageName
                                + "\n\nCheck that the image exists in "
                                + "drawable-nodpi."
                )
                .setPositiveButton("OK", null)
                .show();
        return;
    }

    activity.startJigsawPuzzle(
            level,
            difficulty,
            imageName
    );
            }
                               }
