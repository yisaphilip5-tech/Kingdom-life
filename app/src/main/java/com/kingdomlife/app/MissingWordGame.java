package com.kingdomlife.app;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingWordGame {

    private final MainActivity activity;

    private int currentLevel = 1;
    private int questionIndex = 0;
    private int score = 0;

    private String[][] questions;
    private boolean answered = false;

    private TextView progressText;
    private TextView questionText;
    private TextView referenceText;
    private TextView feedbackText;

    private Button[] answerButtons;
    private Button nextButton;

    private int correctPosition = -1;

    private final int backgroundColor = Color.rgb(30, 24, 55);
    private final int goldColor = Color.rgb(212, 175, 55);
    private final int textColor = Color.WHITE;

    public MissingWordGame(MainActivity activity) {
        this.activity = activity;
    }

    private int dp(float value) {
        return (int) (
                value * activity.getResources()
                        .getDisplayMetrics().density
        );
    }

    private GradientDrawable makeBackground(
            int color,
            int strokeColor
    ) {
        GradientDrawable drawable =
                new GradientDrawable();

        drawable.setColor(color);
        drawable.setCornerRadius(dp(16));

        if (strokeColor != Color.TRANSPARENT) {
            drawable.setStroke(dp(2), strokeColor);
        }

        return drawable;
    }

    private TextView makeText(
            String text,
            int size,
            int color,
            boolean bold
    ) {
        TextView view = new TextView(activity);

        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);

        if (bold) {
            view.setTypeface(
                    Typeface.DEFAULT,
                    Typeface.BOLD
            );
        }

        view.setPadding(
                dp(10),
                dp(10),
                dp(10),
                dp(10)
        );

        return view;
    }

    private Button makeButton(String text) {
        Button button = new Button(activity);

        button.setText(text);
        button.setTextSize(16);
        button.setTextColor(textColor);

        button.setAllCaps(false);

        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        backgroundColor
                )
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, dp(5), 0, dp(5));

        button.setLayoutParams(params);

        return button;
    }

    private void prepareScreen() {
        activity.content.removeAllViews();

        activity.content.setOrientation(
                LinearLayout.VERTICAL
        );

        activity.content.setPadding(
                dp(16),
                dp(12),
                dp(16),
                dp(24)
        );
    }

    private void addSpace(int height) {
        View space = new View(activity);

        activity.content.addView(
                space,
                new LinearLayout.LayoutParams(
                        1,
                        dp(height)
                )
        );
    }

    public void showLevelMenu() {
        prepareScreen();

        TextView title = makeText(
                "🔤 Missing Word",
                26,
                goldColor,
                true
        );

        activity.content.addView(title);

        TextView description = makeText(
                "Complete each Bible verse by choosing "
                        + "the missing word.",
                16,
                textColor,
                false
        );

        activity.content.addView(description);

        addSpace(15);

        addLevelButton(
                "Level 1 — Easy",
                1
        );

        addLevelButton(
                "Level 2 — Medium",
                2
        );

        addLevelButton(
                "Level 3 — Hard",
                3
        );

        addSpace(15);

        Button backButton = makeButton(
                "⬅️ Back to Puzzle Menu"
        );

        backButton.setOnClickListener(
                v -> activity.showPuzzleMenu()
        );

        activity.content.addView(backButton);
    }

    private void addLevelButton(
String title,
int level
) {
int unlockedLevel = activity.prefs.getInt(
"missingWordUnlockedLevel", 1);

boolean isUnlocked = level <= unlockedLevel;

Button button = makeButton(
        (isUnlocked ? "🔓 " : "🔒 ") + title
);

button.setBackgroundTintList(
        android.content.res.ColorStateList.valueOf(
                isUnlocked ? goldColor : Color.GRAY
        )
);

button.setTextColor(
        isUnlocked ? backgroundColor : Color.WHITE
);

button.setOnClickListener(v -> {
    if (isUnlocked) {
        startLevel(level);
    } else {
        android.widget.Toast.makeText(
                activity,
                "Complete Level " + (level - 1)
                        + " first to unlock this level!",
                android.widget.Toast.LENGTH_SHORT
        ).show();
    }
});

activity.content.addView(button);

    }

    private void startLevel(int level) {
        currentLevel = level;
        questionIndex = 0;
        score = 0;
        answered = false;

        questions =
                MissingWordData.getQuestionsForLevel(level);

        if (questions == null || questions.length == 0) {
            showLevelMenu();
            return;
        }

        showQuestion();
    }

    private void showQuestion() {
        prepareScreen();

        if (questionIndex >= questions.length) {
            showResults();
            return;
        }

        answered = false;

        String[] question = questions[questionIndex];

        TextView title = makeText(
                "🔤 Missing Word — Level " + currentLevel,
                23,
                goldColor,
                true
        );

        activity.content.addView(title);

        progressText = makeText(
                "Question " + (questionIndex + 1)
                        + " of " + questions.length
                        + "     |     Score: " + score,
                16,
                textColor,
                true
        );

        activity.content.addView(progressText);

        addSpace(10);

        questionText = makeText(
                question[0],
                21,
                textColor,
                true
        );

        questionText.setBackground(
                makeBackground(
                        backgroundColor,
                        goldColor
                )
        );

        activity.content.addView(questionText);

        referenceText = makeText(
                "Bible reference: " + question[5],
                15,
                goldColor,
                false
        );

        activity.content.addView(referenceText);

        addSpace(10);

        feedbackText = makeText(
                "Choose the correct missing word.",
                15,
                textColor,
                false
        );

        activity.content.addView(feedbackText);

        answerButtons = new Button[4];

        List<String> options = new ArrayList<>();

        options.add(question[1]);
        options.add(question[2]);
        options.add(question[3]);
        options.add(question[4]);

        /*
         * Shuffle the four options so the correct
         * answer does not always appear in the same
         * position.
         */
        Collections.shuffle(options);

        correctPosition = -1;

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).equals(question[1])) {
                correctPosition = i;
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            final int selectedPosition = i;

            answerButtons[i] = makeButton(
                    (char) ('A' + i) + ". "
                            + options.get(i)
            );

            answerButtons[i].setOnClickListener(
                    v -> checkAnswer(
                            selectedPosition,
                            options.get(selectedPosition),
                            question[1]
                    )
            );

            activity.content.addView(
                    answerButtons[i]
            );
        }

        addSpace(8);

        nextButton = makeButton("Next Question ➡️");

        nextButton.setEnabled(false);

        nextButton.setOnClickListener(v -> {
            questionIndex++;
            showQuestion();
        });

        activity.content.addView(nextButton);

        Button exitButton = makeButton(
                "Exit to Levels"
        );

        exitButton.setOnClickListener(
                v -> showLevelMenu()
        );

        activity.content.addView(exitButton);
    }

    private void checkAnswer(
            int selectedPosition,
            String selectedAnswer,
            String correctAnswer
    ) {
        if (answered) {
            return;
        }

        answered = true;

        for (Button button : answerButtons) {
            button.setEnabled(false);
        }

        if (selectedAnswer.equals(correctAnswer)) {
            score += 5;

            activity.totalPoints += 5;

            activity.prefs.edit()
                    .putInt(
                            "totalPoints",
                            activity.totalPoints
                    )
                    .apply();

            feedbackText.setText(
                    "✅ Correct! You earned 5 points."
            );

            feedbackText.setTextColor(
                    Color.rgb(100, 220, 130)
            );

            answerButtons[selectedPosition]
                    .setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(
                                    Color.rgb(35, 120, 65)
                            )
                    );

            activity.checkAchievementNotifications();

        } else {
            feedbackText.setText(
                    "❌ Not quite. Correct answer: "
                            + correctAnswer
            );

            feedbackText.setTextColor(
                    Color.rgb(255, 120, 120)
            );

            answerButtons[selectedPosition]
                    .setBackgroundTintList(
                            android.content.res.ColorStateList.valueOf(
                                    Color.rgb(150, 45, 45)
                            )
                    );

            for (int i = 0; i < answerButtons.length; i++) {
                if (answerButtons[i].getText()
                        .toString()
                        .substring(3)
                        .equals(correctAnswer)) {

                    answerButtons[i]
                            .setBackgroundTintList(
                                    android.content.res.ColorStateList.valueOf(
                                            Color.rgb(35, 120, 65)
                                    )
                            );

                    break;
                }
            }
        }

        progressText.setText(
                "Question " + (questionIndex + 1)
                        + " of " + questions.length
                        + "     |     Score: " + score
        );

        nextButton.setEnabled(true);

        if (questionIndex == questions.length - 1) {
            nextButton.setText("View Results 🏆");
        }
    }

    private void showResults() {
        prepareScreen();
        int unlockedLevel = activity.prefs.getInt(
"missingWordUnlockedLevel", 1);

if (currentLevel >= unlockedLevel && currentLevel < 3) {
activity.prefs.edit()
.putInt(
"missingWordUnlockedLevel",
currentLevel + 1
)
.apply();
}

        TextView title = makeText(
                "🏆 Level Complete!",
                27,
                goldColor,
                true
        );

        activity.content.addView(title);

        addSpace(15);

        TextView result = makeText(
                "Level: " + currentLevel
                        + "\n\nQuestions: " + questions.length
                        + "\n\nCorrect answers: " + (score / 5)
                        + "\n\nPoints earned: " + score,
                20,
                textColor,
                true
        );

        result.setBackground(
                makeBackground(
                        backgroundColor,
                        goldColor
                )
        );

        activity.content.addView(result);

        addSpace(20);

        Button replayButton = makeButton(
                "🔄 Play This Level Again"
        );

        replayButton.setOnClickListener(
                v -> startLevel(currentLevel)
        );

        activity.content.addView(replayButton);

        Button levelsButton = makeButton(
                "📚 Choose Another Level"
        );

        levelsButton.setOnClickListener(
                v -> showLevelMenu()
        );

        activity.content.addView(levelsButton);

        Button backButton = makeButton(
                "⬅️ Back to Puzzle Menu"
        );

        backButton.setOnClickListener(
                v -> activity.showPuzzleMenu()
        );

        activity.content.addView(backButton);
    }
                  }
