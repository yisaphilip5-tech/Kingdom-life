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
private int score = 0;
private int correctlySolved = 0;
private int trialsRemaining = 0;
private int maxTrials = 0;
private String currentWord;
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

LinearLayout levelRow = null;

for (int i = 1; i <= 125; i++) {
final int selectedLevel = i;

if (i % 2 == 1) {
    levelRow = new LinearLayout(activity);
    levelRow.setOrientation(LinearLayout.HORIZONTAL);

    LinearLayout.LayoutParams rowParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

    activity.content.addView(levelRow, rowParams);
}

android.widget.FrameLayout buttonFrame =
        new android.widget.FrameLayout(activity);

LinearLayout.LayoutParams frameParams =
        new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f);

frameParams.setMargins(6, 5, 6, 5);
buttonFrame.setLayoutParams(frameParams);

android.widget.Button levelButton =
        new android.widget.Button(activity);

boolean isUnlocked = i <= unlockedLevel;

levelButton.setText(
        (isUnlocked ? "" : "🔒 ") + "Level " + i);

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

levelRow.addView(buttonFrame);

if (i % 2 == 0 || i == 125) {
    // Add an empty space after the last button if needed.
    if (i == 125 && i % 2 == 1) {
        View spacer = new View(activity);
        levelRow.addView(
                spacer,
                new LinearLayout.LayoutParams(0, 1, 1f));
    }
}

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

    currentWord = BibleScrambleData.getWordForLevel(level);

    if (currentWord == null) {
        return;
    }

    score = 0;

    maxTrials = getTrialLimit(currentWord);
    trialsRemaining = maxTrials;

    showQuestion();
}

private int getTrialLimit(String word) {
    int length = word.length();

    if (length <= 5) return 27;
    if (length <= 7) return 25;
    if (length <= 9) return 23;
    if (length <= 11) return 21;
    if (length <= 13) return 19;
    if (length <= 15) return 18;

    return 16;
}

    private void showQuestion() {
    activity.content.removeAllViews();

    ImageButton backButton = new ImageButton(activity);
    backButton.setImageResource(
            android.R.drawable.ic_media_previous);
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setOnClickListener(v -> showLevelMenu());

    activity.content.addView(
            backButton,
            new LinearLayout.LayoutParams(60, 60));

    TextView title = new TextView(activity);
    title.setText("🧩 Bible Scramble — Level " + level);
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(kingdomGold);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 15, 0, 15);
    activity.content.addView(title);

    TextView progress = new TextView(activity);
    progress.setText("Level " + level + " of 125");
    progress.setTextSize(18);
    progress.setTextColor(activity.darkText);
    progress.setGravity(Gravity.CENTER);
    progress.setPadding(0, 0, 0, 15);
    activity.content.addView(progress);

    TextView scrambled = new TextView(activity);
    scrambled.setText(
            "🔤 UNSCRAMBLE\n\n" + scrambleWord(currentWord));
    scrambled.setTextSize(26);
    scrambled.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    scrambled.setTextColor(Color.WHITE);
    scrambled.setGravity(Gravity.CENTER);
    scrambled.setPadding(16, 28, 16, 28);
    scrambled.setBackground(
            makeGameCard(royalPurple, kingdomGold));

    LinearLayout.LayoutParams scrambledParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

    scrambledParams.setMargins(0, 8, 0, 16);
    activity.content.addView(scrambled, scrambledParams);

    TextView trialsText = new TextView(activity);
    trialsText.setText(
            "🎯 Trials remaining: " + trialsRemaining
                    + " / " + maxTrials);
    trialsText.setTextSize(19);
    trialsText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    trialsText.setTextColor(kingdomGold);
    trialsText.setGravity(Gravity.CENTER);
    trialsText.setPadding(0, 8, 0, 12);
    activity.content.addView(trialsText);

    EditText answerInput = new EditText(activity);
    answerInput.setHint("Type your answer here");
    answerInput.setTextSize(18);
    answerInput.setSingleLine(true);
    answerInput.setTextColor(Color.WHITE);
    answerInput.setHintTextColor(kingdomGold);
    answerInput.setPadding(16, 14, 16, 14);
    answerInput.setBackground(
            makeGameCard(royalPurple, kingdomGold));

    LinearLayout.LayoutParams inputParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

    inputParams.setMargins(0, 8, 0, 12);
    activity.content.addView(answerInput, inputParams);

    activity.addButton("✅ Submit Answer", v -> {
        String userAnswer = answerInput.getText()
                .toString().trim();

        if (userAnswer.isEmpty()) {
            android.widget.Toast.makeText(
                    activity,
                    "Enter an answer first!",
                    android.widget.Toast.LENGTH_SHORT
            ).show();
            return;
        }

        if (userAnswer.equalsIgnoreCase(currentWord)) {

            android.media.MediaPlayer correctSound =
                    android.media.MediaPlayer.create(
                            activity,
                            R.raw.answer_correct);

            if (correctSound != null) {
                correctSound.setOnCompletionListener(
                        android.media.MediaPlayer::release);
                correctSound.start();
            }

            answerInput.setEnabled(false);

String solvedKey =
        "bibleScrambleSolvedLevel_" + level;

boolean alreadySolved =
        activity.prefs.getBoolean(solvedKey, false);

if (!alreadySolved) {
    score = 5;
    activity.totalPoints += 5;

    activity.prefs.edit()
            .putInt("totalPoints", activity.totalPoints)
            .putBoolean(solvedKey, true)
            .putBoolean("bibleScrambleSolved", true)
            .apply();

    activity.checkAchievementNotifications();

} else {
    score = 0;
}
            TextView feedback = new TextView(activity);
            feedback.setText(
        alreadySolved
                ? "🎉 Correct! Level completed before."
                : "🎉 Correct! +5 points");
            feedback.setTextSize(20);
            feedback.setTypeface(
                    Typeface.DEFAULT, Typeface.BOLD);
            feedback.setTextColor(Color.WHITE);
            feedback.setGravity(Gravity.CENTER);
            feedback.setPadding(16, 18, 16, 18);
            feedback.setBackground(
                    makeGameCard(correctGreen, kingdomGold));

            activity.content.addView(feedback);

            activity.addButton(
                    level == 125
                            ? "🏆 Finish Bible Scramble"
                            : "➡️ Continue to Next Level",
                    nextView -> completeLevel());

        } else {

            trialsRemaining--;

            android.media.MediaPlayer wrongSound =
                    android.media.MediaPlayer.create(
                            activity,
                            R.raw.answer_wrong);

            if (wrongSound != null) {
                wrongSound.setOnCompletionListener(
                        android.media.MediaPlayer::release);
                wrongSound.start();
            }

            trialsText.setText(
                    "🎯 Trials remaining: "
                            + trialsRemaining + " / " + maxTrials);

            if (trialsRemaining <= 0) {
                answerInput.setEnabled(false);

                TextView feedback = new TextView(activity);
                feedback.setText(
                        "❌ Level Failed!\nYou have used all your trials.");
                feedback.setTextSize(20);
                feedback.setTypeface(
                        Typeface.DEFAULT, Typeface.BOLD);
                feedback.setTextColor(Color.WHITE);
                feedback.setGravity(Gravity.CENTER);
                feedback.setPadding(16, 18, 16, 18);
                feedback.setBackground(
                        makeGameCard(wrongRed, kingdomGold));

                activity.content.addView(feedback);

                activity.addButton(
                        "🔄 Retry This Level",
                        retryView -> startLevel(level));

                activity.addButton(
                        "📚 Level Menu",
                        menuView -> showLevelMenu());

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
                        makeGameCard(wrongRed, kingdomGold));

                activity.content.addView(feedback);
            }
        }
    });
                }
    private void completeLevel() {

    int unlockedLevel = activity.prefs.getInt(
            "bibleScrambleUnlockedLevel", 1);

    if (level >= unlockedLevel && level < 125) {
        activity.prefs.edit()
                .putInt("bibleScrambleUnlockedLevel", level + 1)
                .putInt("bibleScramblePendingAnimation", level + 1)
                .apply();
    }

    if (level == 125) {
        android.media.MediaPlayer player =
                android.media.MediaPlayer.create(
                        activity,
                        R.raw.level_complete);

        if (player != null) {
            player.setOnCompletionListener(
                    android.media.MediaPlayer::release);
            player.start();
        }
    }

    activity.content.removeAllViews();

    TextView title = new TextView(activity);
    title.setText(
            level == 125
                    ? "🏆 Bible Scramble Completed!"
                    : "🎉 Level " + level + " Completed!");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(activity.darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    activity.content.addView(title);

    TextView result = new TextView(activity);
    result.setText(
            "You unscrambled the word successfully!\n\n"
                    + "🧩 Level: " + level + " of 125\n"
                    + "⭐ Points earned: " + score
                    + "\n⭐ Total Points: " + activity.totalPoints);
    result.setTextSize(20);
    result.setTextColor(activity.darkText);
    result.setGravity(Gravity.CENTER);
    result.setPadding(0, 10, 0, 30);
    activity.content.addView(result);

    if (level < 125) {
        activity.addButton(
                "➡️ Continue to Level " + (level + 1),
                v -> startLevel(level + 1));
    }

    activity.addButton(
            "🔄 Play This Level Again",
            v -> startLevel(level));

    activity.addButton(
            "📚 Choose a Level",
            v -> showLevelMenu());

    activity.addButton(
            "⬅️ Back to Games",
            v -> activity.showGameMenu());

    activity.addButton(
            "🏠 Back to Home",
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
