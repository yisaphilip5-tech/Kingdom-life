package com.kingdomlife.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BibleScrambleGame {

    private final MainActivity activity;
    private int level = 1;
    private int question = 0;
    private int score = 0;
    private int correctlySolved = 0;
private int correctlySolvedThisLevel = 0;
    private String[] words;
    private final int royalPurple = Color.rgb(30, 24, 55);
private final int kingdomGold = Color.rgb(212, 175, 55);
private final int correctGreen = Color.rgb(35, 120, 65);
private final int wrongRed = Color.rgb(150, 45, 45);

private GradientDrawable makeGameCard(int color, int borderColor) {
    GradientDrawable background = new GradientDrawable();
    background.setColor(color);
    background.setCornerRadius(24);

    if (borderColor != Color.TRANSPARENT) {
        background.setStroke(3, borderColor);
    }

    return background;
}

    public BibleScrambleGame(MainActivity activity) {
        this.activity = activity;
    }

    public void showLevelMenu() {
    activity.stopTimer();
    activity.content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(activity);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to Games");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> activity.showGameMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    activity.content.addView(backButton, backParams);

    TextView title = new TextView(activity);
    title.setText("🧩 Bible Scramble");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(activity.darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    activity.content.addView(title);

    TextView description = new TextView(activity);
    description.setText("Complete each level to unlock the next!");
    description.setTextSize(18);
    description.setTextColor(activity.darkText);
    description.setGravity(Gravity.CENTER);
    description.setPadding(0, 0, 0, 20);
    activity.content.addView(description);

    int unlockedLevel = activity.prefs.getInt(
            "bibleScrambleUnlockedLevel", 1);

    int animatedLevel = activity.prefs.getInt(
            "bibleScramblePendingAnimation", 0);

    String[] levelNames = {
"Level 1",
"Level 2",
"Level 3",
"Level 4",
"Level 5"
};

    for (int i = 1; i <= 5; i++) {
        final int selectedLevel = i;

        android.widget.FrameLayout buttonFrame =
                new android.widget.FrameLayout(activity);

        LinearLayout.LayoutParams frameParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        frameParams.setMargins(12, 5, 12, 5);
        buttonFrame.setLayoutParams(frameParams);

        android.widget.Button levelButton =
                new android.widget.Button(activity);

        boolean isUnlocked = i <= unlockedLevel;

        levelButton.setText(
                (isUnlocked ? "" : "🔒 ")
                        + levelNames[i - 1]);

        levelButton.setAllCaps(false);
        levelButton.setGravity(Gravity.CENTER);

        buttonFrame.addView(
                levelButton,
                new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));

        if (isUnlocked) {
            levelButton.setOnClickListener(
                    v -> startLevel(selectedLevel));
        } else {
            levelButton.setOnClickListener(v ->
                    android.widget.Toast.makeText(
                            activity,
                            "Complete Level " + (selectedLevel - 1)
                                    + " first!",
                            android.widget.Toast.LENGTH_SHORT
                    ).show());
        }

        activity.content.addView(buttonFrame);

        if (i == animatedLevel && isUnlocked) {
            TextView lockIcon = new TextView(activity);
            lockIcon.setText("🔒");
            lockIcon.setTextSize(22);
            lockIcon.setGravity(Gravity.CENTER);
            lockIcon.setTextColor(android.graphics.Color.BLACK);
            lockIcon.setAlpha(1.0f);
            lockIcon.setShadowLayer(
                    2f, 1f, 1f, android.graphics.Color.WHITE);

            android.widget.FrameLayout.LayoutParams lockParams =
                    new android.widget.FrameLayout.LayoutParams(
                            55,
                            android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                            Gravity.CENTER);

            buttonFrame.addView(lockIcon, lockParams);

            LevelUnlockAnimator.animateUnlock(
                    lockIcon,
                    levelButton,
                    activity,
                    "Level " + i
            );

            activity.prefs.edit()
                    .remove("bibleScramblePendingAnimation")
                    .apply();
        }
    }

    // The old bottom Back to Games button has been removed.
                    }

    private void startLevel(int selectedLevel) {
    level = selectedLevel;
    words = BibleScrambleData.getWordsForLevel(level);
    question = 0;
    score = 0;
    correctlySolvedThisLevel = 0;
    showQuestion();
    }

    private void showQuestion() {
        activity.content.removeAllViews();

        ImageButton backButton = new ImageButton(activity);
        backButton.setImageResource(
                android.R.drawable.ic_media_previous);
        backButton.setBackgroundColor(Color.TRANSPARENT);
        backButton.setOnClickListener(
                v -> showLevelMenu());

        activity.content.addView(
                backButton,
                new LinearLayout.LayoutParams(60, 60));

        String word = words[question];

        TextView title = new TextView(activity);
        title.setText("🧩 Bible Scramble — Level " + level);
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(kingdomGold);
        title.setPadding(0, 15, 0, 15);
        activity.content.addView(title);

        TextView progress = new TextView(activity);
        progress.setText(
                "Question " + (question + 1) +
                " of " + words.length);
        progress.setTextSize(18);
        progress.setTextColor(activity.darkText);
        progress.setPadding(0, 0, 0, 15);
        activity.content.addView(progress);

        TextView scrambled = new TextView(activity);
scrambled.setText("🔤 UNSCRAMBLE\n\n" + scrambleWord(word));
scrambled.setTextSize(26);
scrambled.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
scrambled.setTextColor(Color.WHITE);
scrambled.setGravity(Gravity.CENTER);
scrambled.setPadding(16, 28, 16, 28);
scrambled.setBackground(
        makeGameCard(royalPurple, kingdomGold)
);

LinearLayout.LayoutParams scrambledParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

scrambledParams.setMargins(0, 8, 0, 16);
activity.content.addView(scrambled, scrambledParams);

        EditText answerInput = new EditText(activity);
answerInput.setHint("Type your answer here");
answerInput.setTextSize(18);
answerInput.setSingleLine(true);

answerInput.setTextColor(Color.WHITE);
answerInput.setHintTextColor(kingdomGold);
answerInput.setPadding(16, 14, 16, 14);

answerInput.setBackground(
        makeGameCard(royalPurple, kingdomGold)
);

LinearLayout.LayoutParams inputParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

inputParams.setMargins(0, 8, 0, 12);

activity.content.addView(answerInput, inputParams);
        activity.addButton("✅ Submit Answer", v -> {
            String userAnswer = answerInput.getText()
                    .toString().trim();

            if (userAnswer.equalsIgnoreCase(word)) {
                score += 5;
                activity.totalPoints += 5;
                String solvedKey = "bibleScramble_word_solved_level_"
        + level + "_question_" + question;

if (!activity.prefs.getBoolean(solvedKey, false)) {
    int savedSolved = activity.prefs.getInt(
            "bibleScramble_words_solved", 0);

    activity.prefs.edit()
            .putBoolean(solvedKey, true)
            .putInt("bibleScramble_words_solved",
                    savedSolved + 1)
            .apply();
}
                correctlySolved++;
correctlySolvedThisLevel++;

                activity.prefs.edit()
        .putInt("totalPoints", activity.totalPoints)
        .putBoolean("bibleScrambleSolved", true)
        .apply();

                activity.checkAchievementNotifications();

                TextView feedback = new TextView(activity);
feedback.setText("🎉 Correct! +5 points");
feedback.setTextSize(20);
feedback.setTypeface(
        Typeface.DEFAULT, Typeface.BOLD);
feedback.setTextColor(Color.WHITE);
feedback.setGravity(Gravity.CENTER);
feedback.setPadding(16, 18, 16, 18);

feedback.setBackground(
        makeGameCard(correctGreen, kingdomGold)
);

LinearLayout.LayoutParams feedbackParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

feedbackParams.setMargins(0, 12, 0, 12);

activity.content.addView(feedback, 3, feedbackParams);
                answerInput.setEnabled(false);

                activity.addButton("➡️ Next Question",
                        nextView -> nextQuestion());

            } else {
                TextView feedback = new TextView(activity);
feedback.setText("Not quite. Try again!");
feedback.setTextSize(18);
feedback.setTypeface(
        Typeface.DEFAULT, Typeface.BOLD);
feedback.setTextColor(Color.WHITE);
feedback.setGravity(Gravity.CENTER);
feedback.setPadding(16, 18, 16, 18);

feedback.setBackground(
        makeGameCard(wrongRed, kingdomGold)
);

LinearLayout.LayoutParams feedbackParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

feedbackParams.setMargins(0, 12, 0, 12);

activity.content.addView(feedback, feedbackParams);
            }
        });

        activity.addButton("➡️ Skip",
                v -> nextQuestion());
    }

    private void nextQuestion() {
        if (question < words.length - 1) {
            question++;
            showQuestion();
        } else {
            showFinalResult();
        }
    }

    private void showFinalResult() {
        activity.content.removeAllViews();
        int unlockedLevel = activity.prefs.getInt(
"bibleScrambleUnlockedLevel", 1);

if (level >= unlockedLevel && level < 5) {
activity.prefs.edit()
.putInt("bibleScrambleUnlockedLevel", level + 1)
.putInt("bibleScramblePendingAnimation", level + 1)
.apply();
}
        TextView title = new TextView(activity);
        title.setText("🏆 Scramble Complete!");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(activity.darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 25, 0, 20);
        activity.content.addView(title);

        TextView result = new TextView(activity);
        result.setText(
                "You completed Level " + level + "!\n\n" +
                "🧩 Scramble Score: " + score + "\n" +
                "⭐ Total Points: " + activity.totalPoints);
        result.setTextSize(20);
        result.setTextColor(activity.darkText);
        result.setGravity(Gravity.CENTER);
        result.setPadding(0, 10, 0, 30);
        activity.content.addView(result);

        activity.addButton("🔄 Play This Level Again",
                v -> startLevel(level));

        activity.addButton("📚 Choose Another Level",
                v -> showLevelMenu());

        activity.addButton("⬅️ Back to Games",
                v -> activity.showGameMenu());

        activity.addButton("🏠 Back to Home",
                v -> activity.showHome());
    }

    private String scrambleWord(String word) {
        char[] letters = word.toCharArray();

        for (int i = letters.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));

            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }

        String scrambled = new String(letters);

        if (scrambled.equals(word) && letters.length > 1) {
            char temp = letters[0];
            letters[0] = letters[1];
            letters[1] = temp;
            scrambled = new String(letters);
        }

        return scrambled;
    }
                      }
