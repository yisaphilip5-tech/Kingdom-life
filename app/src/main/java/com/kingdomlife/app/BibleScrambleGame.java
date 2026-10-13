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
    private String[] words;

    public BibleScrambleGame(MainActivity activity) {
        this.activity = activity;
    }

    public void showLevelMenu() {
        activity.stopTimer();
        activity.content.removeAllViews();

        TextView title = new TextView(activity);
        title.setText("🧩 Bible Scramble");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(activity.darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 25, 0, 20);
        activity.content.addView(title);

        TextView description = new TextView(activity);
        description.setText("Choose your difficulty level");
        description.setTextSize(18);
        description.setTextColor(activity.darkText);
        description.setGravity(Gravity.CENTER);
        description.setPadding(0, 0, 0, 20);
        activity.content.addView(description);

        activity.addButton("🌱 Level 1 — Easy",
                v -> startLevel(1));

        activity.addButton("📖 Level 2 — Intermediate",
                v -> startLevel(2));

        activity.addButton("🔥 Level 3 — Advanced",
                v -> startLevel(3));

        activity.addButton("⬅️ Back to Games",
                v -> activity.showGameMenu());
    }

    private void startLevel(int selectedLevel) {
        level = selectedLevel;
        words = BibleScrambleData.getWordsForLevel(level);
        question = 0;
        score = 0;
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
        title.setTextColor(activity.darkText);
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
        scrambled.setText("Unscramble: " + scrambleWord(word));
        scrambled.setTextSize(26);
        scrambled.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        scrambled.setTextColor(activity.darkText);
        scrambled.setGravity(Gravity.CENTER);
        scrambled.setPadding(0, 20, 0, 25);
        activity.content.addView(scrambled);

        EditText answerInput = new EditText(activity);
        answerInput.setHint("Type your answer here");
        answerInput.setTextSize(18);
        answerInput.setSingleLine(true);
        activity.content.addView(answerInput);

        activity.addButton("✅ Submit Answer", v -> {
            String userAnswer = answerInput.getText()
                    .toString().trim();

            if (userAnswer.equalsIgnoreCase(word)) {
                score += 5;
                activity.totalPoints += 5;

                activity.prefs.edit()
                        .putInt("totalPoints",
                                activity.totalPoints)
                        .apply();

                activity.checkAchievementNotifications();

                TextView feedback = new TextView(activity);
                feedback.setText("🎉 Correct! +5 points");
                feedback.setTextSize(20);
                feedback.setTypeface(
                        Typeface.DEFAULT, Typeface.BOLD);
                feedback.setTextColor(activity.darkText);
                feedback.setGravity(Gravity.CENTER);
                feedback.setPadding(0, 15, 0, 15);

                activity.content.addView(feedback, 3);
                answerInput.setEnabled(false);

                activity.addButton("➡️ Next Question",
                        nextView -> nextQuestion());

            } else {
                TextView feedback = new TextView(activity);
                feedback.setText("❌ Not quite. Try again!");
                feedback.setTextSize(18);
                feedback.setTextColor(activity.darkText);
                feedback.setGravity(Gravity.CENTER);
                feedback.setPadding(0, 15, 0, 15);

                activity.content.addView(feedback, 3);
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
