package com.kingdomlife.app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import java.util.Calendar;
import android.view.View;
import android.content.Intent;
import android.widget.ProgressBar;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class AchievementsActivity extends Activity {

    private static final int PURPLE = Color.rgb(30, 24, 55);
    private static final int GOLD = Color.rgb(184, 134, 11);
    private static final int BRIGHT_GOLD = Color.rgb(255, 215, 0);

    private SharedPreferences prefs;
    private AchievementManager achievementManager;

    private LinearLayout content;
    private TextView pageIndicator;
    private Button previousButton;
    private Button nextButton;

    private List<AchievementData> achievements;
    private boolean[] unlockedStates;
    private int currentPage = 0;

    private static final int PAGE_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences(
                "KingdomLifePrefs",
                MODE_PRIVATE
        );

        achievementManager = new AchievementManager(this);

        achievements = AchievementData.getAll();

        unlockedStates = new boolean[achievements.size()];

        for (int i = 0; i < achievements.size(); i++) {
            unlockedStates[i] =
                    isAchievementUnlocked(achievements.get(i).key);
        }

        achievementManager.updateAchievementStates(
                achievements,
                unlockedStates
        );

        buildScreen();
        showPage(0);
    }

    private void buildScreen() {

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
root.setPadding(10, 8, 10, 0);
root.setClipToPadding(false);

android.content.SharedPreferences displayPrefs =
        getSharedPreferences(
                "KingdomLifeDisplayPrefs",
                MODE_PRIVATE
        );

String displayMode =
        displayPrefs.getString("displayMode", "AUTO");

if (displayMode.equals("DAY")) {
    root.setBackgroundResource(R.drawable.kingdom_home_bg);
} else if (displayMode.equals("NIGHT")) {
    root.setBackgroundResource(R.drawable.kingdom_night_bg);
} else {
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    if (hour >= 6 && hour < 18) {
        root.setBackgroundResource(R.drawable.kingdom_home_bg);
    } else {
        root.setBackgroundResource(R.drawable.kingdom_night_bg);
    }
}
        android.widget.ImageButton backButton =
        new android.widget.ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setColorFilter(Color.WHITE);

backButton.setContentDescription("Back");

backButton.setBackgroundColor(
        android.graphics.Color.TRANSPARENT
);

backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

float backDensity = getResources().getDisplayMetrics().density;

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(
                (int) (56 * backDensity),
                (int) (50 * backDensity)
        );

backParams.gravity = Gravity.LEFT;

backButton.setOnClickListener(v -> finish());

root.addView(backButton, backParams);
        TextView title = new TextView(this);
        title.setText("🏆 Achievements");
        title.setTextSize(25);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(BRIGHT_GOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 8, 0, 3);

        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText(
                "Your journey of faith and progress"
        );
        subtitle.setTextSize(13);
        subtitle.setTextColor(Color.WHITE);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, 8);

        root.addView(subtitle);
        int unlockedCount = 0;

for (boolean unlocked : unlockedStates) {
    if (unlocked) {
        unlockedCount++;
    }
}

TextView progressDescription = new TextView(this);

progressDescription.setText(
        "Your Achievement Progress\n"
        + unlockedCount + " of "
        + achievements.size()
        + " achievements unlocked. Keep growing "
        + "in faith and completing challenges!"
);

progressDescription.setTextSize(13);
progressDescription.setTextColor(BRIGHT_GOLD);
progressDescription.setGravity(Gravity.CENTER);
progressDescription.setPadding(12, 4, 12, 12);

root.addView(progressDescription);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(0, 2, 0, 6);

        scrollView.addView(content);

        root.addView(
                scrollView,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                )
        );

        LinearLayout navigation = new LinearLayout(this);
        navigation.setOrientation(LinearLayout.HORIZONTAL);
        navigation.setGravity(Gravity.CENTER_VERTICAL);
        navigation.setPadding(0, 4, 0, 0);

        previousButton = new Button(this);
previousButton.setText("‹");
previousButton.setTextSize(36);
previousButton.setTextColor(BRIGHT_GOLD);
previousButton.setBackgroundColor(Color.TRANSPARENT);
previousButton.setOnClickListener(
        v -> showPage(currentPage - 1)
);
        navigation.addView(
                previousButton,
                new LinearLayout.LayoutParams(
                        65,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        pageIndicator = new TextView(this);
        pageIndicator.setTextColor(BRIGHT_GOLD);
        pageIndicator.setTextSize(14);
        pageIndicator.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        pageIndicator.setGravity(Gravity.CENTER);

        navigation.addView(
                pageIndicator,
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1f
                )
        );

        nextButton = new Button(this);
nextButton.setText("›");
nextButton.setTextSize(36);
nextButton.setTextColor(BRIGHT_GOLD);
nextButton.setBackgroundColor(Color.TRANSPARENT);
nextButton.setOnClickListener(
        v -> showPage(currentPage + 1)
);
        navigation.addView(
                nextButton,
                new LinearLayout.LayoutParams(
                        65,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        root.addView(
        navigation,
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
);

navigation.setPadding(0, 4, 0, 16);

setContentView(root);

if (android.os.Build.VERSION.SDK_INT >= 30) {
root.setOnApplyWindowInsetsListener((view, windowInsets) -> {
android.graphics.Insets systemBars =
windowInsets.getInsets(
android.view.WindowInsets.Type.systemBars()
);

    view.setPadding(
            10 + systemBars.left,
            8 + systemBars.top,
            10 + systemBars.right,
            systemBars.bottom + 12
    );

    return windowInsets;
});

}
    }

    private void showPage(int page) {

        if (page < 0 || page >= PAGE_COUNT) {
            return;
        }

        currentPage = page;
        content.removeAllViews();

        int total = achievements.size();

        // Split the list into two nearly equal pages.
        int itemsPerPage = (total + PAGE_COUNT - 1) / PAGE_COUNT;

        int start = currentPage * itemsPerPage;
        int end = Math.min(start + itemsPerPage, total);

        LinearLayout row = null;

        for (int i = start; i < end; i++) {

            if ((i - start) % 2 == 0) {
                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setGravity(Gravity.TOP);

                content.addView(
                        row,
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                );
            }

            AchievementData achievement = achievements.get(i);

            addAchievementCard(
                    row,
                    achievement,
                    unlockedStates[i]
            );
        }

        pageIndicator.setText(
                "PAGE " + (currentPage + 1) + " OF " + PAGE_COUNT
        );

        previousButton.setVisibility(
                currentPage == 0 ? View.INVISIBLE : View.VISIBLE
        );

        nextButton.setVisibility(
                currentPage == PAGE_COUNT - 1
                        ? View.INVISIBLE
                        : View.VISIBLE
        );
    }

    private boolean isAchievementUnlocked(String key) {

    int points = prefs.getInt("totalPoints", 0);
    int learnedVerses = prefs.getInt("learnedVerses", 0);
    int dailyStreak = prefs.getInt("dailyStreak", 0);

    boolean challengeComplete =
            prefs.getBoolean("challengeCompletedToday", false);

    int journeyQuestions =
            prefs.getInt("bibleJourney_questions_completed", 0);

    int journeyBooks =
            prefs.getInt("bibleJourney_books_completed", 0);

    int scrambleWords =
            prefs.getInt("bibleScramble_words_solved", 0);

    int missingWordCorrect =
            prefs.getInt("missingWord_correct_answers", 0);

    int referenceCorrect =
            prefs.getInt("memory_reference_correct_answers", 0);

    int guessVerseCorrect =
            prefs.getInt("memory_guess_correct_answers", 0);

    int completeVerseCorrect =
            prefs.getInt("memory_complete_correct_answers", 0);

    boolean level1 =
            prefs.getBoolean("challenge_level_1_completed", false);

    boolean level2 =
            prefs.getBoolean("challenge_level_2_completed", false);

    boolean level3 =
            prefs.getBoolean("challenge_level_3_completed", false);

    boolean level4 =
            prefs.getBoolean("challenge_level_4_completed", false);

    boolean level5 =
            prefs.getBoolean("challenge_level_5_completed", false);

    switch (key) {

        // POINTS AND DAILY PROGRESS

        case "first_step":
            return points >= 5;

        case "bible_learner":
            return learnedVerses >= 5;

        case "streak_keeper":
            return dailyStreak >= 3;

        case "point_builder":
            return points >= 50;

        case "challenge_complete":
            return challengeComplete;

        // BIBLE CHALLENGE

        case "easy_challenger":
            return level1;

        case "medium_challenger":
            return level2;

        case "hard_challenger":
            return level3;

        case "challenge_master":
            return level1 && level2 && level3;

        case "bible_challenge_master":
            return level1 && level2 && level3
                    && level4 && level5;

        // BIBLE JOURNEY QUESTIONS

        case "questions_100":
            return journeyQuestions >= 100;

        case "questions_250":
            return journeyQuestions >= 250;

        case "questions_500":
            return journeyQuestions >= 500;

        case "questions_1000":
            return journeyQuestions >= 1000;

        // BIBLE JOURNEY BOOKS

        case "books_5":
            return journeyBooks >= 5;

        case "books_10":
            return journeyBooks >= 10;

        case "books_25":
            return journeyBooks >= 25;

        case "books_50":
            return journeyBooks >= 50;

        case "books_66":
            return journeyBooks >= 66;

        // BIBLE SCRAMBLE

        case "scramble_10_words":
            return scrambleWords >= 10;

        case "scramble_25_words":
            return scrambleWords >= 25;

        case "scramble_75_words":
            return scrambleWords >= 75;

        case "scramble_100_words":
            return scrambleWords >= 100;

        case "scramble_200_words":
            return scrambleWords >= 200;

        case "scramble_250_words":
            return scrambleWords >= 250;

        // JIGSAW PUZZLE

        case "big_picture":
            return countClaimedJigsawRewards() >= 3;

        case "jigsaw_10_levels":
            return countClaimedJigsawRewards() >= 10;

        case "jigsaw_25_levels":
            return countClaimedJigsawRewards() >= 25;

        case "jigsaw_50_levels":
            return countClaimedJigsawRewards() >= 50;

        case "jigsaw_75_levels":
            return countClaimedJigsawRewards() >= 75;

        case "jigsaw_90_levels":
            return countClaimedJigsawRewards() >= 90;

        // MISSING WORD

        case "word_hearer":
            return missingWordCorrect >= 25;

        // GUESS THE REFERENCE

        case "scripture_detective":
            return referenceCorrect >= 25;

        case "reference_50":
            return referenceCorrect >= 50;

        case "reference_100":
            return referenceCorrect >= 100;

        // GUESS THE VERSE

        case "verse_guardian":
            return guessVerseCorrect >= 25;

        case "guess_verse_50":
            return guessVerseCorrect >= 50;

        case "guess_verse_100":
            return guessVerseCorrect >= 100;

        // COMPLETE THE VERSE

        case "verse_finisher":
            return completeVerseCorrect >= 25;

        case "complete_verse_50":
            return completeVerseCorrect >= 50;

        case "complete_verse_100":
            return completeVerseCorrect >= 100;

        // BIBLE LEARNING

        case "gods_vessel_15":
            return learnedVerses >= 15;

        case "gods_vessel_25":
            return learnedVerses >= 25;

        // NOT YET CONNECTED

        case "word_student":
    return countCompletedMemoryVerseLevels() >= 30;
            case "finisher":
    return countCompletedAllGameStages() >= 644;
            

        default:
            return false;
    }
    }

    private int getAchievementProgress(String key) {

    switch (key) {

        // POINTS

        case "first_step":
        case "point_builder":
            return prefs.getInt("totalPoints", 0);

        // BIBLE LEARNING

        case "bible_learner":
        case "gods_vessel_15":
        case "gods_vessel_25":
            return prefs.getInt("learnedVerses", 0);

        // DAILY PROGRESS

        case "streak_keeper":
            return prefs.getInt("dailyStreak", 0);

        case "challenge_complete":
            return prefs.getBoolean(
                    "challengeCompletedToday", false
            ) ? 1 : 0;

        // BIBLE CHALLENGE

        case "easy_challenger":
            return prefs.getBoolean(
                    "challenge_level_1_completed", false
            ) ? 1 : 0;

        case "medium_challenger":
            return prefs.getBoolean(
                    "challenge_level_2_completed", false
            ) ? 1 : 0;

        case "hard_challenger":
            return prefs.getBoolean(
                    "challenge_level_3_completed", false
            ) ? 1 : 0;

        case "challenge_master":
            return countCompletedChallengeLevels(3);

        case "bible_challenge_master":
            return countCompletedChallengeLevels(5);

        // BIBLE JOURNEY QUESTIONS

        case "questions_100":
        case "questions_250":
        case "questions_500":
        case "questions_1000":
            return prefs.getInt(
                    "bibleJourney_questions_completed", 0
            );

        // BIBLE JOURNEY BOOKS

        case "books_5":
        case "books_10":
        case "books_25":
        case "books_50":
        case "books_66":
            return prefs.getInt(
                    "bibleJourney_books_completed", 0
            );

        // BIBLE SCRAMBLE

        case "scramble_10_words":
        case "scramble_25_words":
        case "scramble_75_words":
        case "scramble_100_words":
        case "scramble_200_words":
        case "scramble_250_words":
            return prefs.getInt(
                    "bibleScramble_words_solved", 0
            );

        // JIGSAW PUZZLE

        case "big_picture":
        case "jigsaw_10_levels":
        case "jigsaw_25_levels":
        case "jigsaw_50_levels":
        case "jigsaw_75_levels":
        case "jigsaw_90_levels":
            return countClaimedJigsawRewards();

        // MISSING WORD

        case "word_hearer":
            return prefs.getInt(
                    "missingWord_correct_answers", 0
            );

        // GUESS THE REFERENCE

        case "scripture_detective":
        case "reference_50":
        case "reference_100":
            return prefs.getInt(
                    "memory_reference_correct_answers", 0
            );

        // GUESS THE VERSE

        case "verse_guardian":
        case "guess_verse_50":
        case "guess_verse_100":
            return prefs.getInt(
                    "memory_guess_correct_answers", 0
            );

        // COMPLETE THE VERSE

        case "verse_finisher":
        case "complete_verse_50":
        case "complete_verse_100":
            return prefs.getInt(
                    "memory_complete_correct_answers", 0
            );
            case "word_student":
    return countCompletedMemoryVerseLevels();
            case "finisher":
    return countCompletedAllGameStages();
        default:
            return isAchievementUnlocked(key) ? 1 : 0;
    }
    }
private int countCompletedChallengeLevels(int maximumLevel) {

    int completed = 0;

    for (int level = 1; level <= maximumLevel; level++) {

        if (prefs.getBoolean(
                "challenge_level_" + level + "_completed",
                false
        )) {
            completed++;
        }
    }

    return completed;
}

private int countClaimedJigsawRewards() {

    SharedPreferences jigsawPrefs = getSharedPreferences(
            "KingdomLifeJigsawPrefs",
            MODE_PRIVATE
    );

    int completed = 0;

    for (int level = 1; level <= 90; level++) {

        if (jigsawPrefs.getBoolean(
                "level" + level + "RewardClaimed",
                false
        )) {
            completed++;
        }
    }

    return completed;
}
    private int countCompletedMemoryVerseLevels() {

    SharedPreferences memoryPrefs = getSharedPreferences(
            "KingdomLifePrefs",
            MODE_PRIVATE
    );

    int completed = 0;

    String[] types = {"guess", "complete", "reference"};

    for (String type : types) {
        for (int level = 1; level <= 10; level++) {

            String key = "memory_" + type +
                    "_level_" + level + "_completed";

            if (memoryPrefs.getBoolean(key, false)) {
                completed++;
            }
        }
    }

    return completed;
    }
    private int countCompletedAllGameStages() {

    int completed = 0;

    // 1. Bible Journey: 66 books × 4 difficulties
    String[] books = {
            "Genesis", "Exodus", "Leviticus", "Numbers",
            "Deuteronomy", "Joshua", "Judges", "Ruth",
            "1 Samuel", "2 Samuel", "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles", "Ezra", "Nehemiah",
            "Esther", "Job", "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon", "Isaiah",
            "Jeremiah", "Lamentations", "Ezekiel", "Daniel",
            "Hosea", "Joel", "Amos", "Obadiah", "Jonah",
            "Micah", "Nahum", "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah", "Malachi",
            "Matthew", "Mark", "Luke", "John", "Acts",
            "Romans", "1 Corinthians", "2 Corinthians",
            "Galatians", "Ephesians", "Philippians",
            "Colossians", "1 Thessalonians", "2 Thessalonians",
            "1 Timothy", "2 Timothy", "Titus", "Philemon",
            "Hebrews", "James", "1 Peter", "2 Peter",
            "1 John", "2 John", "3 John", "Jude", "Revelation"
    };

    String[] difficulties = {
            "Easy", "Medium", "Hard", "Scholar"
    };

    for (String book : books) {
        for (String difficulty : difficulties) {
            if (prefs.getBoolean(
                    "bibleJourney_" + book + "_"
                            + difficulty + "_completed",
                    false)) {
                completed++;
            }
        }
    }

    // 2. Bible Challenge: 5 levels
    for (int level = 1; level <= 5; level++) {
        if (prefs.getBoolean(
                "challenge_level_" + level + "_completed",
                false)) {
            completed++;
        }
    }

    // 3. Three Memory Verse modes: 30 levels
    completed += countCompletedMemoryVerseLevels();

    // 4. Bible Scramble: 250 levels
    for (int level = 1; level <= 250; level++) {
        if (prefs.getBoolean(
                "bibleScrambleSolvedLevel_" + level,
                false)) {
            completed++;
        }
    }

    // 5. Missing Word: 5 levels
    for (int level = 1; level <= 5; level++) {
        if (prefs.getBoolean(
                "missingWord_level_" + level + "_completed",
                false)) {
            completed++;
        }
    }

    // 6. Jigsaw Puzzle: 90 levels
    completed += countClaimedJigsawRewards();

    return completed;
    }
    private void addAchievementCard(
            LinearLayout row,
            AchievementData achievement,
            boolean unlocked) {

        FrameLayout card = new FrameLayout(this);

        GradientDrawable background = new GradientDrawable();
        background.setColor(PURPLE);
        background.setCornerRadius(24);
        background.setStroke(2, GOLD);

        card.setBackground(background);
        card.setElevation(5);
        card.setClipChildren(false);
        card.setClipToPadding(false);
        

        LinearLayout body = new LinearLayout(this);
        body.setOrientation(LinearLayout.VERTICAL);
        body.setGravity(Gravity.CENTER);
        body.setPadding(8, 10, 8, 12);

        card.addView(
                body,
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        FrameLayout iconArea = new FrameLayout(this);
        iconArea.setMinimumHeight(84);

        ImageView badge = new ImageView(this);
        badge.setImageResource(achievement.badgeResource);
        badge.setScaleType(ImageView.ScaleType.FIT_CENTER);
        badge.setAdjustViewBounds(true);
        badge.setVisibility(unlocked ? View.VISIBLE : View.INVISIBLE);

        iconArea.addView(
                badge,
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        84
                )
        );

        TextView lockView = new TextView(this);
        lockView.setText("🔒");
        lockView.setTextSize(30);
        lockView.setGravity(Gravity.CENTER);
        lockView.setVisibility(unlocked ? View.GONE : View.VISIBLE);

        iconArea.addView(
                lockView,
                new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        84
                )
        );

        body.addView(iconArea);

        TextView titleView = new TextView(this);
        titleView.setText(achievement.name);
        titleView.setTextSize(15);
        titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        titleView.setTextColor(BRIGHT_GOLD);
        titleView.setGravity(Gravity.CENTER);
        titleView.setPadding(0, 6, 0, 5);

        float density = getResources().getDisplayMetrics().density;

LinearLayout.LayoutParams titleParams =
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (42 * density)
        );

titleParams.gravity = Gravity.CENTER;
body.addView(titleView, titleParams);

        TextView descriptionView = new TextView(this);
        descriptionView.setText(achievement.description);
        descriptionView.setTextSize(12);
        descriptionView.setTextColor(Color.WHITE);
        descriptionView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams descriptionParams =
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (52 * density)
        );

descriptionParams.gravity = Gravity.CENTER;
body.addView(descriptionView, descriptionParams);
// Uniform achievement progress section

int target = achievement.target;
int progress;

// Special progress calculations
if (achievement.key.equals("word_student")) {

    progress = countCompletedMemoryVerseLevels();

} else if (achievement.key.equals("finisher")) {

    progress = countCompletedAllGameStages();

} else {

    progress = Math.max(
            0,
            getAchievementProgress(achievement.key)
    );
}

// Preserve the original target for individual challenge levels
if (achievement.key.equals("easy_challenger")
        || achievement.key.equals("medium_challenger")
        || achievement.key.equals("hard_challenger")) {

    target = 1;
}

int displayedProgress = Math.min(progress, target);

// Determine progress unit
String unit = "completed";

if (achievement.key.equals("word_student")) {
    unit = "Memory Verse levels";
} else if (achievement.key.equals("finisher")) {
    unit = "game stages";
} else if (achievement.category.equals("Points")) {
    unit = "points";
} else if (achievement.category.equals("Bible Learning")) {
    unit = "verses";
} else if (achievement.category.equals("Daily Progress")) {
    unit = "days";
} else if (achievement.category.equals("Bible Journey")) {
    unit = achievement.key.startsWith("books_")
            ? "books" : "questions";
} else if (achievement.category.equals("Bible Scramble")) {
    unit = "words";
} else if (achievement.category.equals("Missing Word")
        || achievement.category.equals("Memory Verse")) {
    unit = "answers";
} else if (achievement.category.equals("Jigsaw Puzzle")) {
    unit = "levels";
} else if (achievement.category.equals("Bible Challenge")) {
    unit = achievement.key.equals("challenge_complete")
            ? "challenge" : "levels";
}

// Fixed-height progress area for every card
float progressDensity =
        getResources().getDisplayMetrics().density;

LinearLayout progressArea = new LinearLayout(this);
progressArea.setOrientation(LinearLayout.VERTICAL);
progressArea.setGravity(Gravity.CENTER);

body.addView(
        progressArea,
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (52 * progressDensity)
        )
);

// Progress text
TextView progressView = new TextView(this);

progressView.setText(
        "Progress: " + displayedProgress
                + " of " + target + " " + unit
);

progressView.setTextSize(11);
progressView.setTextColor(BRIGHT_GOLD);
progressView.setGravity(Gravity.CENTER);
progressView.setMaxLines(2);

progressArea.addView(
        progressView,
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (32 * progressDensity)
        )
);

// Progress bar
ProgressBar progressBar = new ProgressBar(
        this,
        null,
        android.R.attr.progressBarStyleHorizontal
);

progressBar.setMax(Math.max(1, target));
progressBar.setProgress(displayedProgress);

if (android.os.Build.VERSION.SDK_INT >= 21) {

    progressBar.setProgressTintList(
            android.content.res.ColorStateList.valueOf(
                    BRIGHT_GOLD
            )
    );

    progressBar.setProgressBackgroundTintList(
            android.content.res.ColorStateList.valueOf(
                    Color.rgb(75, 65, 90)
            )
    );
}

LinearLayout.LayoutParams progressBarParams =
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (12 * progressDensity)
        );

progressBarParams.setMargins(
        (int) (8 * progressDensity),
        0,
        (int) (8 * progressDensity),
        0
);

progressArea.addView(progressBar, progressBarParams);

TextView statusView = new TextView(this);

if (unlocked) {

    statusView.setText("↗ Share Achievement");
    statusView.setTextSize(12);
    statusView.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    statusView.setTextColor(PURPLE);
    statusView.setGravity(Gravity.CENTER);
    statusView.setPadding(12, 8, 12, 8);

    GradientDrawable shareBackground =
            new GradientDrawable();

    shareBackground.setColor(BRIGHT_GOLD);
    shareBackground.setCornerRadius(20);

    statusView.setBackground(shareBackground);

    statusView.setOnClickListener(v ->
            shareAchievement(achievement)
    );

} else {

    statusView.setVisibility(View.GONE);

}

LinearLayout.LayoutParams shareParams =
        new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

shareParams.setMargins(8, 5, 8, 0);

body.addView(statusView, shareParams);
        

LinearLayout.LayoutParams cardParams =
        new LinearLayout.LayoutParams(
                0,
                (int) (250 * density),
                1f
        );

        cardParams.setMargins(4, 4, 4, 4);
        row.addView(card, cardParams);

        // Newly unlocked animation is connected after
        // the existing saved-state logic is migrated.
    }
    
private void shareAchievement(AchievementData achievement) {

    try {

        // Create a separate card for sharing.
        LinearLayout shareCard = new LinearLayout(this);
        shareCard.setOrientation(LinearLayout.VERTICAL);
        shareCard.setGravity(Gravity.CENTER);
        shareCard.setPadding(
                dp(24), dp(28), dp(24), dp(28)
        );

        GradientDrawable cardBackground =
                new GradientDrawable();

        cardBackground.setColor(PURPLE);
        cardBackground.setCornerRadius(dp(28));
        cardBackground.setStroke(dp(3), GOLD);

        shareCard.setBackground(cardBackground);

        // Card heading
        TextView heading = new TextView(this);
        heading.setText("🏆 ACHIEVEMENT UNLOCKED");
        heading.setTextSize(20);
        heading.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        heading.setTextColor(BRIGHT_GOLD);
        heading.setGravity(Gravity.CENTER);

        shareCard.addView(
                heading,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        addShareSpace(shareCard, 20);

        // Actual achievement badge
        ImageView badge = new ImageView(this);
        badge.setImageResource(achievement.badgeResource);
        badge.setScaleType(ImageView.ScaleType.FIT_CENTER);

        shareCard.addView(
                badge,
                new LinearLayout.LayoutParams(
                        dp(135),
                        dp(135)
                )
        );

        addShareSpace(shareCard, 16);

        // Achievement name
        TextView name = new TextView(this);
        name.setText(achievement.name);
        name.setTextSize(23);
        name.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        name.setTextColor(BRIGHT_GOLD);
        name.setGravity(Gravity.CENTER);

        shareCard.addView(
                name,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        addShareSpace(shareCard, 12);

        // Achievement description
        TextView description = new TextView(this);
        description.setText(achievement.description);
        description.setTextSize(16);
        description.setTextColor(Color.WHITE);
        description.setGravity(Gravity.CENTER);
        description.setPadding(
                dp(8), 0, dp(8), dp(8)
        );

        shareCard.addView(
                description,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        addShareSpace(shareCard, 22);

        // Celebration section replaces the progress bar.
        LinearLayout celebration =
                new LinearLayout(this);

        celebration.setOrientation(
                LinearLayout.VERTICAL
        );

        celebration.setGravity(Gravity.CENTER);
        celebration.setPadding(
                dp(12), dp(18), dp(12), dp(18)
        );

        GradientDrawable celebrationBackground =
                new GradientDrawable();

        celebrationBackground.setColor(BRIGHT_GOLD);
        celebrationBackground.setCornerRadius(dp(20));

        celebration.setBackground(
                celebrationBackground
        );

        TextView congratulations = new TextView(this);
        congratulations.setText(
                "🎉 Congratulations!"
        );
        congratulations.setTextSize(20);
        congratulations.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        congratulations.setTextColor(PURPLE);
        congratulations.setGravity(Gravity.CENTER);

        celebration.addView(congratulations);

        TextView complete = new TextView(this);
        complete.setText("Achievement Complete");
        complete.setTextSize(17);
        complete.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        complete.setTextColor(PURPLE);
        complete.setGravity(Gravity.CENTER);

        celebration.addView(complete);

        TextView wellDone = new TextView(this);
        wellDone.setText("Well done 👏");
        wellDone.setTextSize(16);
        wellDone.setTextColor(PURPLE);
        wellDone.setGravity(Gravity.CENTER);

        celebration.addView(wellDone);

        shareCard.addView(
                celebration,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );

        // Measure and draw the separate card as an image.
        int imageWidth = dp(360);

        shareCard.measure(
                View.MeasureSpec.makeMeasureSpec(
                        imageWidth,
                        View.MeasureSpec.EXACTLY
                ),
                View.MeasureSpec.makeMeasureSpec(
                        0,
                        View.MeasureSpec.UNSPECIFIED
                )
        );

        shareCard.layout(
                0,
                0,
                shareCard.getMeasuredWidth(),
                shareCard.getMeasuredHeight()
        );

        Bitmap bitmap = Bitmap.createBitmap(
                shareCard.getMeasuredWidth(),
                shareCard.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888
        );

        Canvas canvas = new Canvas(bitmap);
        shareCard.draw(canvas);

        // Save image in the app's private cache.
        File directory = new File(
                getCacheDir(),
                "shared_achievements"
        );

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String safeKey = achievement.key.replaceAll(
                "[^a-zA-Z0-9_-]",
                "_"
        );

        File imageFile = new File(
                directory,
                "achievement_" + safeKey + ".png"
        );

        try (FileOutputStream output =
                     new FileOutputStream(imageFile)) {

            bitmap.compress(
                    Bitmap.CompressFormat.PNG,
                    100,
                    output
            );

            output.flush();
        }

        bitmap.recycle();

        // Secure image sharing through FileProvider.
        Uri imageUri = FileProvider.getUriForFile(
                this,
                getPackageName() + ".fileprovider",
                imageFile
        );

        String shareText =
                "🏆 Achievement Unlocked! 🎉\n\n" +
                "I'm growing in faith and living with purpose " +
                "with Kingdom Life! 👑";

        Intent shareIntent =
                new Intent(Intent.ACTION_SEND);

        shareIntent.setType("image/png");

        shareIntent.putExtra(
                Intent.EXTRA_STREAM,
                imageUri
        );

        shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                shareText
        );

        shareIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                "Achievement Unlocked!"
        );

        shareIntent.setClipData(
                android.content.ClipData.newUri(
                        getContentResolver(),
                        "Kingdom Life Achievement",
                        imageUri
                )
        );

        shareIntent.addFlags(
                Intent.FLAG_GRANT_READ_URI_PERMISSION
        );

        startActivity(
                Intent.createChooser(
                        shareIntent,
                        "Share Achievement"
                )
        );

    } catch (Exception e) {

        Toast.makeText(
                this,
                "Unable to share achievement. Please try again.",
                Toast.LENGTH_LONG
        ).show();

        e.printStackTrace();
    }
}

// Convert dp values into screen pixels.
private int dp(float value) {
    return (int) (
            value * getResources()
                    .getDisplayMetrics().density
    );
}

// Add spacing to the share-only card.
private void addShareSpace(
        LinearLayout layout,
        int height
) {

    View space = new View(this);

    layout.addView(
            space,
            new LinearLayout.LayoutParams(
                    1,
                    dp(height)
            )
    );
            }
    
    
    private void animateAchievementUnlock(
            View card,
            View lockView,
            View badgeView) {

        if (card == null || lockView == null || badgeView == null) {
            return;
        }

        Animation shake = new TranslateAnimation(-8, 8, 0, 0);
        shake.setDuration(70);
        shake.setRepeatCount(5);
        shake.setRepeatMode(Animation.REVERSE);

        shake.setAnimationListener(
                new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Animation fall = new TranslateAnimation(
                                0, 0,
                                0, Math.max(80, lockView.getHeight())
                        );

                        fall.setDuration(650);

                        fall.setAnimationListener(
                                new Animation.AnimationListener() {

                                    @Override
                                    public void onAnimationStart(
                                            Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(
                                            Animation animation) {

                                        lockView.setVisibility(View.GONE);
                                        badgeView.setVisibility(View.VISIBLE);

                                        if (card instanceof ViewGroup) {
                                            FrameLayout sparkleLayer =
                                                    new FrameLayout(
                                                            AchievementsActivity.this
                                                    );

                                            ((ViewGroup) card).addView(
                                                    sparkleLayer,
                                                    new FrameLayout.LayoutParams(
                                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                                            ViewGroup.LayoutParams.MATCH_PARENT
                                                    )
                                            );

                                            playAchievementCelebration(
                                                    sparkleLayer
                                            );

                                            sparkleLayer.postDelayed(
                                                    () -> ((ViewGroup) card)
                                                            .removeView(sparkleLayer),
                                                    3500
                                            );
                                        }
                                    }

                                    @Override
                                    public void onAnimationRepeat(
                                            Animation animation) {
                                    }
                                }
                        );

                        lockView.startAnimation(fall);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                }
        );

        lockView.startAnimation(shake);
    }

    private void playAchievementCelebration(
            ViewGroup container) {

        final String[] effects = {
                "✨", "⭐", "🌟", "🎉", "💛", "🏆"
        };

        for (int i = 0; i < 16; i++) {

            final TextView sparkle = new TextView(this);
            sparkle.setText(effects[i % effects.length]);
            sparkle.setTextSize(22);

            FrameLayout.LayoutParams params =
                    new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    );

            params.gravity = Gravity.TOP
                    | Gravity.CENTER_HORIZONTAL;

            sparkle.setTranslationX((i - 8) * 30f);
            container.addView(sparkle, params);

            Animation fall = new TranslateAnimation(
                    0, (i % 2 == 0 ? 45 : -45),
                    -30, 260 + (i % 5) * 35
            );

            fall.setDuration(1400 + (i % 4) * 200);
            fall.setStartOffset(i * 65L);

            fall.setAnimationListener(
                    new Animation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            container.removeView(sparkle);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    }
            );

            sparkle.startAnimation(fall);
        }
    }
}
