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
import android.widget.ProgressBar;
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

        SharedPreferences jigsawPrefs =
                getSharedPreferences(
                        "KingdomLifeJigsawPrefs",
                        MODE_PRIVATE
                );

        boolean jigsaw1 =
                jigsawPrefs.getBoolean("level1RewardClaimed", false);

        boolean jigsaw2 =
                jigsawPrefs.getBoolean("level2RewardClaimed", false);

        boolean jigsaw3 =
                jigsawPrefs.getBoolean("level3RewardClaimed", false);

        switch (key) {

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

            case "questions_100":
                return journeyQuestions >= 100;

            case "questions_250":
                return journeyQuestions >= 250;

            case "questions_500":
                return journeyQuestions >= 500;

            case "questions_1000":
                return journeyQuestions >= 1000;

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

            case "scramble_10_words":
                return scrambleWords >= 10;

            case "scramble_25_words":
                return scrambleWords >= 25;

            case "scramble_75_words":
                return scrambleWords >= 75;

            case "big_picture":
                return jigsaw1 && jigsaw2 && jigsaw3;

            case "word_hearer":
                return missingWordCorrect >= 25;

            case "scripture_detective":
                return referenceCorrect >= 25;

            case "verse_guardian":
                return guessVerseCorrect >= 25;

            case "verse_finisher":
                return completeVerseCorrect >= 25;

            case "gods_vessel_15":
                return learnedVerses >= 15;

            case "gods_vessel_25":
                return learnedVerses >= 25;

            // We will connect these two to their real
            // progress conditions after inspecting the app.
            case "word_student":
            case "finisher":
                return false;

            default:
                return false;
        }
    }

    private int getAchievementProgress(String key) {

    switch (key) {

        case "first_step":
        case "point_builder":
            return prefs.getInt("totalPoints", 0);

        case "bible_learner":
        case "gods_vessel_15":
        case "gods_vessel_25":
            return prefs.getInt("learnedVerses", 0);

        case "streak_keeper":
            return prefs.getInt("dailyStreak", 0);

        case "challenge_complete":
            return prefs.getBoolean(
                    "challengeCompletedToday", false
            ) ? 1 : 0;

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

        case "questions_100":
        case "questions_250":
        case "questions_500":
        case "questions_1000":
            return prefs.getInt(
                    "bibleJourney_questions_completed", 0
            );

        case "books_5":
        case "books_10":
        case "books_25":
        case "books_50":
        case "books_66":
            return prefs.getInt(
                    "bibleJourney_books_completed", 0
            );

        case "scramble_10_words":
        case "scramble_25_words":
        case "scramble_75_words":
            return prefs.getInt(
                    "bibleScramble_words_solved", 0
            );

        case "big_picture":
            return countClaimedJigsawRewards();

        case "word_hearer":
            return prefs.getInt(
                    "missingWord_correct_answers", 0
            );

        case "scripture_detective":
            return prefs.getInt(
                    "memory_reference_correct_answers", 0
            );

        case "verse_guardian":
            return prefs.getInt(
                    "memory_guess_correct_answers", 0
            );

        case "verse_finisher":
            return prefs.getInt(
                    "memory_complete_correct_answers", 0
            );

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

    for (int level = 1; level <= 3; level++) {

        if (jigsawPrefs.getBoolean(
                "level" + level + "RewardClaimed",
                false
        )) {
            completed++;
        }
    }

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

        body.addView(titleView);

        TextView descriptionView = new TextView(this);
        descriptionView.setText(achievement.description);
        descriptionView.setTextSize(12);
        descriptionView.setTextColor(Color.WHITE);
        descriptionView.setGravity(Gravity.CENTER);

        body.addView(descriptionView);

// Individual achievement progress
if (achievement.key.equals("word_student")
        || achievement.key.equals("finisher")) {

    TextView progressView = new TextView(this);
    progressView.setText(
            "Progress tracking not connected yet"
    );
    progressView.setTextSize(11);
    progressView.setTextColor(Color.LTGRAY);
    progressView.setGravity(Gravity.CENTER);
    progressView.setPadding(0, 8, 0, 4);

    body.addView(progressView);

} else {

    int target = achievement.target;

    if (achievement.key.equals("easy_challenger")
            || achievement.key.equals("medium_challenger")
            || achievement.key.equals("hard_challenger")) {
        target = 1;
    }

    int progress = Math.max(
            0,
            getAchievementProgress(achievement.key)
    );

    int displayedProgress = Math.min(progress, target);

    String unit = "completed";

    if (achievement.category.equals("Points")) {
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
    } else if (achievement.category.equals("Missing Word")) {
        unit = "answers";
    } else if (achievement.category.equals("Memory Verse")) {
        unit = "answers";
    } else if (achievement.category.equals("Jigsaw Puzzle")) {
        unit = "levels";
    } else if (achievement.category.equals("Bible Challenge")) {
        unit = achievement.key.equals("challenge_complete")
                ? "challenge" : "levels";
    }

    TextView progressView = new TextView(this);
    progressView.setText(
            "Progress: " + displayedProgress
                    + " of " + target + " " + unit
    );
    progressView.setTextSize(11);
    progressView.setTextColor(BRIGHT_GOLD);
    progressView.setGravity(Gravity.CENTER);
    progressView.setPadding(0, 8, 0, 4);

    body.addView(progressView);

    ProgressBar progressBar = new ProgressBar(
            this,
            null,
            android.R.attr.progressBarStyleHorizontal
    );

    progressBar.setMax(target);
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

    LinearLayout.LayoutParams progressParams =
            new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    12
            );

    progressParams.setMargins(8, 2, 8, 4);

    body.addView(progressBar, progressParams);
}

TextView statusView = new TextView(this);
        body.addView(statusView);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1f
                );

        cardParams.setMargins(4, 4, 4, 4);
        row.addView(card, cardParams);

        // Newly unlocked animation is connected after
        // the existing saved-state logic is migrated.
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
