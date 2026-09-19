                      package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout content;

    int darkText = Color.rgb(45, 45, 45);
    int cardColor = Color.rgb(245, 247, 250);

    String[] questions = {
            "Who built the ark?",
            "Which Bible book comes first?",
            "Who was swallowed by a great fish?",
            "Who defeated Goliath?",
            "How many disciples did Jesus choose?"
    };

    String[][] options = {
            {"Moses", "Noah", "David", "Abraham"},
            {"Exodus", "Genesis", "Matthew", "Psalms"},
            {"Jonah", "Peter", "Paul", "Daniel"},
            {"Solomon", "David", "Samuel", "Joshua"},
            {"10", "11", "12", "14"}
    };

    int[] answers = {1, 1, 0, 1, 2};

    int currentQuestion = 0;
    int score = 0;
  int totalPoints = 0;
  int learnedVerses = 0;
  int dailyStreak = 0;
    int correctAnswers = 0;
    int wrongAnswers = 0;

    boolean answered = false;
    CountDownTimer timer;

    int timeLimit = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("Kingdom Life");
        title.setTextSize(28);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 30, 0, 15);

        main.addView(title);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(20, 10, 20, 25);

        main.addView(content, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1
        ));

        showHome();

        setContentView(main);
    }

    void showHome() {
        stopTimer();
        content.removeAllViews();

        TextView welcome = new TextView(this);
        welcome.setText("🌅 Welcome to Kingdom Life");
        welcome.setTextSize(22);
        welcome.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        welcome.setTextColor(darkText);
        welcome.setPadding(5, 10, 5, 18);
        content.addView(welcome);

        addCard(
                "📖 Verse of the Day",
                "Jeremiah 29:11 — KJV\n\nFor I know the thoughts that I think toward you, saith the LORD, thoughts of peace, and not of evil, to give you an expected end.",
                v -> showVerse()
        );

        addCard(
                "🙏 Prayer for the Day",
                "Take a moment to pray for guidance, strength, wisdom, and peace today.",
                v -> showPrayer()
        );

        addCard(
                "💭 Food for Thought",
                "How can you show kindness, patience, and faith to someone today?",
                v -> showThought()
        );

        addCard(
                "🎯 Daily Challenge",
                "Read today's verse, say a short prayer, and do one act of kindness.",
                v -> showMessage(
                        "Daily Challenge",
                        "Today's challenge:\n\n1. Read Jeremiah 29:11.\n2. Say a short prayer.\n3. Do one kind thing for someone.\n\nComplete all three today!"
                )
        );

        addButton("🎮 Bible Games", v -> showGameMenu());

        addButton("🧠 Memory Verse", v -> showMemoryVerse());

        addButton("ℹ️ About Kingdom Life", v -> showAbout());
    }

    void addCard(String heading, String message, View.OnClickListener listener) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 18, 20, 18);
        card.setBackgroundColor(cardColor);
        card.setOnClickListener(listener);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        cardParams.setMargins(0, 8, 0, 8);

        TextView headingView = new TextView(this);
        headingView.setText(heading);
        headingView.setTextSize(20);
        headingView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        headingView.setTextColor(darkText);

        card.addView(headingView);

        TextView messageView = new TextView(this);
        messageView.setText(message);
        messageView.setTextSize(16);
        messageView.setTextColor(darkText);
        messageView.setPadding(0, 10, 0, 0);

        card.addView(messageView);

        content.addView(card, cardParams);
    }


    void showVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Verse of the Day");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView verse = new TextView(this);
    verse.setText(
            "Jeremiah 29:11 — KJV\n\n" +
            "For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an expected end."
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 25);
    content.addView(verse);

    addButton("🧠 Mark as Learned", v -> {
      learnedVerses++;
        totalPoints += 5;
        showMessage(
                "✅ Verse Learned",
                "Jeremiah 29:11 has been marked as learned.\n\n" +
                "+5 points"
        );
    });

    addButton("⬅️ Back to Home", v -> showHome());
    }

    void showThought() {
        showMessage(
                "💭 Food for Thought",
                "Kindness does not always require something big. " +
                        "A simple word of encouragement, patience, or helping someone can make a difference.\n\n" +
                        "Reflection:\nWhat is one good thing you can do for someone today?"
        );
    }
  void showPrayer() {
    showMessage(
            "🙏 Prayer for the Day",
            "Lord, guide us today and give us wisdom in every decision we make. " +
            "Strengthen our faith, help us walk in love and truth, and give us peace. " +
            "Help us to be a blessing to those around us.\n\n" +
            "Amen."
    );
  }

    void showMemoryVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🧠 Memory Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a Memory Verse challenge:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 20);
    content.addView(instruction);

    addButton("📖 Guess the Verse", v -> showGuessVerse());

    addButton("✍️ Complete the Verse", v -> showCompleteVerse());

    addButton("🔄 Guess the Reference", v -> showGuessReference());

    addButton("⬅️ Back to Home", v -> showHome());
    }
  void showProgress() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Progress");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard("⭐ Points", totalPoints + " points earned so far.", v -> {});
addCard("🎮 Game Scores", "Complete Bible games to build your score.", v -> {});
addCard("🧠 Memory Verses", learnedVerses + " verse(s) learned.", v -> {});
addCard("🔥 Daily Streak", "Start your daily journey today.", v -> {});
addCard("✅ Challenges", "Complete daily challenges to track your progress.", v -> {});

    addButton("⬅️ Back to Home", v -> showHome());
  }
    void showAbout() {
        showMessage(
                "ℹ️ About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, " +
                        "prayer, reflection, daily challenges, and fun Bible activities.\n\n" +
                        "Version 2.2"
        );
    }
    void showGuessVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Guess the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which verse belongs to this reference?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView reference = new TextView(this);
    reference.setText("📖 Jeremiah 29:11 — KJV");
    reference.setTextSize(21);
    reference.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    reference.setTextColor(darkText);
    reference.setGravity(Gravity.CENTER);
    reference.setPadding(10, 15, 10, 20);
    content.addView(reference);

    String[] choices = {
            "For I know the thoughts that I think toward you, saith the LORD, thoughts of peace, and not of evil, to give you an expected end.",
            "The LORD is my shepherd; I shall not want.",
            "I can do all things through Christ which strengtheneth me.",
            "Trust in the LORD with all thine heart; and lean not unto thine own understanding."
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(15);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;
    feedback.setText("✅ Correct! Excellent memory!\n+10 points");
            } else {
                feedback.setText("❌ Not quite. Try to remember Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
       

    void showCompleteVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("✍️ Complete the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose the missing words from Jeremiah 29:11.");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "📖 Jeremiah 29:11 — KJV\n\n" +
            "For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an ________ end."
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "expected",
            "peaceful",
            "wonderful",
            "joyful"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;
    feedback.setText("✅ Correct! The missing word is \"expected\".\n+10 points");
            } else {
                feedback.setText("❌ Not quite. The correct answer is \"expected\".");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
  void showGuessReference() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔄 Guess the Reference");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which Bible reference contains this verse?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "\"For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an expected end.\""
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "Jeremiah 29:11",
            "Psalm 23:1",
            "John 3:16",
            "Philippians 4:13"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;
    feedback.setText("✅ Correct! Jeremiah 29:11.\n+10 points");
            } else {
                feedback.setText("❌ Not quite. The correct answer is Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
                                  }
    void showGameMenu() {
        stopTimer();
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText("🎮 Bible Games");
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 20);

        content.addView(title);

        TextView instruction = new TextView(this);
        instruction.setText("Choose a difficulty level:");
        instruction.setTextSize(18);
        instruction.setTextColor(darkText);
        instruction.setPadding(0, 0, 0, 15);

        content.addView(instruction);

        addButton("🟢 Easy — 30 seconds", v -> startGame(30000));

        addButton("🟡 Medium — 20 seconds", v -> startGame(20000));

        addButton("🔴 Hard — 10 seconds", v -> startGame(10000));

        addButton("⬅️ Back to Home", v -> showHome());
    }

    void startGame(int milliseconds) {
        stopTimer();

        timeLimit = milliseconds;
        currentQuestion = 0;
        score = 0;
        correctAnswers = 0;
        wrongAnswers = 0;

        showQuestion();
    }

    void showQuestion() {
        stopTimer();
        content.removeAllViews();

        answered = false;

        TextView progress = new TextView(this);
        progress.setText("Question " + (currentQuestion + 1) + " of " + questions.length);
        progress.setTextSize(18);
        progress.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        progress.setTextColor(darkText);
        progress.setPadding(0, 10, 0, 10);

        content.addView(progress);

        TextView timerText = new TextView(this);
        timerText.setTextSize(18);
        timerText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        timerText.setTextColor(darkText);
        timerText.setGravity(Gravity.CENTER);
        timerText.setPadding(0, 5, 0, 15);

        content.addView(timerText);

        TextView question = new TextView(this);
        question.setText(questions[currentQuestion]);
        question.setTextSize(22);
        question.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        question.setTextColor(darkText);
        question.setPadding(0, 10, 0, 20);

        content.addView(question);

        Button[] answerButtons = new Button[4];

        for (int i = 0; i < 4; i++) {
            final int selected = i;

            answerButtons[i] = new Button(this);
            answerButtons[i].setText(options[currentQuestion][i]);
            answerButtons[i].setTextSize(17);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(0, 5, 0, 5);

            content.addView(answerButtons[i], params);

            answerButtons[i].setOnClickListener(v ->
                    answerQuestion(selected, answerButtons)
            );
        }

        TextView result = new TextView(this);
        result.setTextSize(18);
        result.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        result.setPadding(0, 15, 0, 10);
        content.addView(result);

        LinearLayout navigation = new LinearLayout(this);
        navigation.setOrientation(LinearLayout.HORIZONTAL);

        Button previous = new Button(this);
        previous.setText("← Previous");
        previous.setTextSize(15);
        previous.setEnabled(currentQuestion > 0);

        Button next = new Button(this);
        next.setText(currentQuestion == questions.length - 1
                ? "Finish →"
                : "Next →");
        next.setTextSize(15);

        navigation.addView(previous, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        navigation.addView(next, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        content.addView(navigation);

        previous.setOnClickListener(v -> {
            if (currentQuestion > 0) {
                currentQuestion--;
                showQuestion();
            }
        });

        next.setOnClickListener(v -> {
            if (currentQuestion < questions.length - 1) {
                currentQuestion++;
                showQuestion();
            } else {
                showResults();
            }
        });

        timer = new CountDownTimer(timeLimit, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText("⏱️ Time: "
                        + ((millisUntilFinished + 999) / 1000)
                        + " seconds");
            }

            public void onFinish() {
                if (!answered) {
                    answered = true;
                    wrongAnswers++;
                    result.setText("⏰ Time's up! The correct answer is: "
                            + options[currentQuestion][answers[currentQuestion]]);

                    for (Button button : answerButtons) {
                        button.setEnabled(false);
                    }
                }
            }
        }.start();
    }

    void answerQuestion(int selected, Button[] buttons) {
        if (answered) {
            return;
        }

        answered = true;
        stopTimer();

        TextView feedback = new TextView(this);
        feedback.setTextSize(18);

        if (selected == answers[currentQuestion]) {
    score += 10;
    totalPoints += 10;
    correctAnswers++;
            feedback.setText("✅ Correct! +10 points");
        } else {
            wrongAnswers++;
            feedback.setText("❌ Wrong! Correct answer: "
                    + options[currentQuestion][answers[currentQuestion]]);
        }

        feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        feedback.setTextColor(darkText);

        content.addView(feedback, 3);

        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    void showResults() {
        stopTimer();
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText("🏆 Game Complete!");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 20, 0, 20);

        content.addView(title);

        TextView results = new TextView(this);
        results.setText(
                "Score: " + score + "\n\n" +
                        "✅ Correct: " + correctAnswers + "\n" +
                        "❌ Wrong: " + wrongAnswers + "\n\n" +
                        "Great job! Keep learning God's Word."
        );
        results.setTextSize(20);
        results.setTextColor(darkText);
        results.setGravity(Gravity.CENTER);
        results.setPadding(0, 10, 0, 25);

        content.addView(results);

        addButton("🔄 Play Again", v -> startGame(timeLimit));

        addButton("⬅️ Back to Games", v -> showGameMenu());

        addButton("🏠 Back to Home", v -> showHome());
    }

    void addButton(String text, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(17);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 8, 0, 8);
        content.addView(button, params);
    }

    void showMessage(String heading, String message) {
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText(heading);
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 15);

        content.addView(title);

        TextView text = new TextView(this);
        text.setText(message);
        text.setTextSize(18);
        text.setTextColor(darkText);
        text.setPadding(0, 10, 0, 25);

        content.addView(text);

        addButton("⬅️ Back to Home", v -> showHome());
    }

    void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onDestroy() {
        stopTimer();
        super.onDestroy();
    }
  }
