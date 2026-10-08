package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoryVerseGameActivity extends Activity {

    private LinearLayout content;

    private String gameType;
    private int level;
    private MemoryVerseData.MemoryVerse[] activeQuestions;

private int questionIndex = 0;
private int score = 0;
    private boolean isLevelUnlocked(
        String type,
        int selectedLevel
) {

    if (selectedLevel == 1) {
        return true;
    }

    String key =
            "memory_" +
            type +
            "_level_" +
            selectedLevel +
            "_unlocked";

    return getSharedPreferences(
            "KingdomLifePrefs",
            MODE_PRIVATE
    ).getBoolean(
            key,
            false
    );
    }

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    gameType =
            getIntent().getStringExtra(
                    "memory_game_type"
            );

    level =
            getIntent().getIntExtra(
                    "memory_level",
                    1
            );

    content = new LinearLayout(this);

    content.setOrientation(
            LinearLayout.VERTICAL
    );

    content.setPadding(
            12,
            0,
            12,
            12
    );

    int hour =
            java.util.Calendar
                    .getInstance()
                    .get(
                            java.util.Calendar.HOUR_OF_DAY
                    );

    if (hour >= 6 && hour < 18) {

        content.setBackgroundResource(
                R.drawable.kingdom_home_bg
        );

    } else {

        content.setBackgroundResource(
                R.drawable.kingdom_night_bg
        );
    }

    setContentView(content);

    showGameMenu();
}
    private void showGameMenu() {

        content.removeAllViews();

        ImageButton backButton =
                new ImageButton(this);

        backButton.setImageResource(
                android.R.drawable.ic_media_previous
        );

        backButton.setBackgroundColor(
                Color.TRANSPARENT
        );

        backButton.setOnClickListener(
                v -> finish()
        );

        content.addView(
                backButton,
                new LinearLayout.LayoutParams(
                        60,
                        60
                )
        );

        TextView title =
                new TextView(this);

        title.setText(
                "🧠 Memory Verse"
        );

        title.setTextSize(24);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setTextColor(
                Color.BLACK
        );

        title.setGravity(
                Gravity.CENTER
        );

        title.setPadding(
                0,
                15,
                0,
                25
        );

        content.addView(title);

        TextView message =
                new TextView(this);

        message.setText(
                "Choose a Memory Verse challenge:"
        );

        message.setTextSize(18);

        message.setTextColor(
                Color.BLACK
        );

        message.setPadding(
                0,
                0,
                0,
                20
        );

        content.addView(message);

        addGameButton(
                "📖 Guess the Verse",
                "Identify the correct Bible verse.",
                "guess"
        );

        addGameButton(
                "✍️ Complete the Verse",
                "Complete the missing part of a Bible verse.",
                "complete"
        );

        addGameButton(
                "🔄 Guess the Reference",
                "Identify the correct Bible reference.",
                "reference"
        );
    }

    private void addGameButton(
            String title,
            String description,
            String type
    ) {

        Button button =
                new Button(this);

        button.setText(
                title + "\n" + description
        );

        button.setTextSize(16);

button.setAllCaps(false);
        button.setMinHeight(85);

button.setPadding(
        20,
        15,
        20,
        15
);

GradientDrawable buttonBackground =
        new GradientDrawable();

buttonBackground.setColor(
        Color.WHITE
);

buttonBackground.setCornerRadius(
        28
);

button.setBackground(
        buttonBackground
);

button.setMinHeight(100);

button.setPadding(
        15,
        12,
        15,
        12
);
        button.setOnClickListener(
                v -> showLevels(type)
        );

        LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
                -1,
                -2
        );

params.setMargins(
        0,
        8,
        0,
        8
);

content.addView(
        button,
        params
);
    }

    private void showLevels(
            String type
    ) {

        content.removeAllViews();

        ImageButton backButton =
                new ImageButton(this);

        backButton.setImageResource(
                android.R.drawable.ic_media_previous
        );

        backButton.setBackgroundColor(
                Color.TRANSPARENT
        );

        backButton.setOnClickListener(
                v -> showGameMenu()
        );

        content.addView(
                backButton,
                new LinearLayout.LayoutParams(
                        60,
                        60
                )
        );

        TextView title =
                new TextView(this);

        if ("guess".equals(type)) {

            title.setText(
                    "📖 Guess the Verse"
            );

        } else if ("complete".equals(type)) {

            title.setText(
                    "✍️ Complete the Verse"
            );

        } else {

            title.setText(
                    "🔄 Guess the Reference"
            );
        }

        title.setTextSize(24);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setTextColor(
                Color.BLACK
        );

        title.setGravity(
                Gravity.CENTER
        );

        title.setPadding(
                0,
                15,
                0,
                25
        );

        content.addView(title);

        TextView message =
                new TextView(this);

        message.setText(
                "Choose your level:"
        );

        message.setTextSize(18);

        message.setTextColor(
                Color.BLACK
        );

        message.setPadding(
                0,
                0,
                0,
                20
        );

        content.addView(message);

        addLevelButton(
                "⭐ Level 1",
                type,
                1
        );

        addLevelButton(
                "⭐⭐ Level 2",
                type,
                2
        );

        addLevelButton(
                "⭐⭐⭐ Level 3",
                type,
                3
        );
    }

    private void addLevelButton(
        String text,
        String type,
        int selectedLevel
) {

    Button button =
            new Button(this);

    boolean unlocked =
            isLevelUnlocked(
                    type,
                    selectedLevel
            );

    if (unlocked) {

        button.setText(text);

        button.setEnabled(true);

        button.setOnClickListener(
                v -> startGame(
                        type,
                        selectedLevel
                )
        );

    } else {

        button.setText(
                text + " 🔒"
        );

        button.setEnabled(false);
    }

    button.setTextSize(18);

    button.setAllCaps(false);
        button.setMinHeight(80);

button.setPadding(
        20,
        15,
        20,
        15
);

GradientDrawable levelBackground =
        new GradientDrawable();

levelBackground.setColor(
        Color.WHITE
);

levelBackground.setCornerRadius(
        28
);

button.setBackground(
        levelBackground
);

    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

params.setMargins(
        0,
        5,
        0,
        5
);

button.setMinHeight(70);
button.setPadding(
        20,
        12,
        20,
        12
);
    content.addView(
            button,
            params
    );
    }

    private void startGame(
        String type,
        int selectedLevel
) {

    gameType = type;
    level = selectedLevel;

    questionIndex = 0;
    score = 0;

    if ("guess".equals(type)) {

        if (selectedLevel == 1) {
            activeQuestions =
                    MemoryVerseData.GUESS_VERSE_LEVEL_1;
        } else if (selectedLevel == 2) {
            activeQuestions =
                    MemoryVerseData.GUESS_VERSE_LEVEL_2;
        } else {
            activeQuestions =
                    MemoryVerseData.GUESS_VERSE_LEVEL_3;
        }

    } else if ("complete".equals(type)) {

        if (selectedLevel == 1) {
            activeQuestions =
                    MemoryVerseData.COMPLETE_VERSE_LEVEL_1;
        } else if (selectedLevel == 2) {
            activeQuestions =
                    MemoryVerseData.COMPLETE_VERSE_LEVEL_2;
        } else {
            activeQuestions =
                    MemoryVerseData.COMPLETE_VERSE_LEVEL_3;
        }

    } else {

        if (selectedLevel == 1) {
            activeQuestions =
                    MemoryVerseData.GUESS_REFERENCE_LEVEL_1;
        } else if (selectedLevel == 2) {
            activeQuestions =
                    MemoryVerseData.GUESS_REFERENCE_LEVEL_2;
        } else {
            activeQuestions =
                    MemoryVerseData.GUESS_REFERENCE_LEVEL_3;
        }
    }

    showQuestion();
    }
    private void showQuestion() {

    content.removeAllViews();

    if (activeQuestions == null ||
            questionIndex >= activeQuestions.length) {

        showFinalResult();
        return;
    }

    MemoryVerseData.MemoryVerse current =
            activeQuestions[questionIndex];

    ImageButton backButton =
            new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showLevels(gameType)
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title =
            new TextView(this);

    if ("guess".equals(gameType)) {

        title.setText(
                "📖 Guess the Verse"
        );

    } else if ("complete".equals(gameType)) {

        title.setText(
                "✍️ Complete the Verse"
        );

    } else {

        title.setText(
                "🔄 Guess the Reference"
        );
    }

    title.setTextSize(23);

    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );

    title.setTextColor(Color.BLACK);

    title.setGravity(Gravity.CENTER);

    content.addView(title);

    TextView progress =
            new TextView(this);

    progress.setText(
            "Level " + level +
            "   •   Question " +
            (questionIndex + 1) +
            " of " +
            activeQuestions.length +
            "\nScore: " +
            score
    );

    progress.setTextSize(16);

    progress.setTextColor(Color.DKGRAY);

    progress.setGravity(Gravity.CENTER);

    progress.setPadding(
            0,
            10,
            0,
            20
    );

    content.addView(progress);

    if ("guess".equals(gameType)) {

        showGuessVerseQuestion(current);

    } else if ("complete".equals(gameType)) {

        showCompleteVerseQuestion(current);

    } else {

        showGuessReferenceQuestion(current);
    }
}


private void showGuessVerseQuestion(
        MemoryVerseData.MemoryVerse current
) {

    TextView question =
            new TextView(this);

    question.setText(
            "Which verse matches\n" +
            current.reference +
            "?"
    );

    question.setTextSize(19);

    question.setTextColor(Color.BLACK);

    question.setGravity(Gravity.CENTER);

    question.setPadding(
            0,
            10,
            0,
            20
    );

    content.addView(question);

    java.util.ArrayList<String> answers =
            new java.util.ArrayList<>();

    answers.add(current.verse);

    while (answers.size() < 4) {

        MemoryVerseData.MemoryVerse other =
                activeQuestions[
                        new java.util.Random().nextInt(
                                activeQuestions.length
                        )
                ];

        if (!answers.contains(other.verse)) {
            answers.add(other.verse);
        }
    }

    java.util.Collections.shuffle(answers);

    for (String answer : answers) {

        addAnswerButton(
                answer,
                answer.equals(current.verse)
        );
    }
}


private void showCompleteVerseQuestion(
        MemoryVerseData.MemoryVerse current
) {

    String[] words =
            current.verse.split("\\s+");

    if (words.length < 4) {

        showGuessVerseQuestion(current);
        return;
    }

    int missingIndex =
            words.length / 2;

    String correctWord =
            words[missingIndex]
                    .replaceAll(
                            "[^A-Za-z']",
                            ""
                    );

    if (correctWord.isEmpty()) {

        correctWord =
                words[missingIndex];
    }

    StringBuilder display =
            new StringBuilder();

    for (int i = 0;
            i < words.length;
            i++) {

        if (i == missingIndex) {

            display.append("_____ ");

        } else {

            display.append(
                    words[i]
            );

            display.append(" ");
        }
    }

    TextView question =
            new TextView(this);

    question.setText(
            "Complete the verse:\n\n" +
            display.toString().trim() +
            "\n\n" +
            current.reference
    );

    question.setTextSize(18);

    question.setTextColor(Color.BLACK);

    question.setGravity(Gravity.CENTER);

    question.setPadding(
            0,
            10,
            0,
            20
    );

    content.addView(question);

    java.util.ArrayList<String> answers =
            new java.util.ArrayList<>();

    answers.add(correctWord);

    while (answers.size() < 4) {

        MemoryVerseData.MemoryVerse other =
                activeQuestions[
                        new java.util.Random().nextInt(
                                activeQuestions.length
                        )
                ];

        String[] otherWords =
                other.verse.split("\\s+");

        if (otherWords.length > 0) {

            String otherWord =
                    otherWords[
                            new java.util.Random().nextInt(
                                    otherWords.length
                            )
                    ].replaceAll(
                            "[^A-Za-z']",
                            ""
                    );

            if (!otherWord.isEmpty() &&
                    !answers.contains(
                            otherWord
                    )) {

                answers.add(otherWord);
            }
        }
    }

    java.util.Collections.shuffle(answers);

    for (String answer : answers) {

        addAnswerButton(
                answer,
                answer.equals(correctWord)
        );
    }
}


private void showGuessReferenceQuestion(
        MemoryVerseData.MemoryVerse current
) {

    TextView question =
            new TextView(this);

    question.setText(
            "Which reference matches\n\n" +
            current.verse +
            "?"
    );

    question.setTextSize(18);

    question.setTextColor(Color.BLACK);

    question.setGravity(Gravity.CENTER);

    question.setPadding(
            0,
            10,
            0,
            20
    );

    content.addView(question);

    java.util.ArrayList<String> answers =
            new java.util.ArrayList<>();

    answers.add(current.reference);

    while (answers.size() < 4) {

        MemoryVerseData.MemoryVerse other =
                activeQuestions[
                        new java.util.Random().nextInt(
                                activeQuestions.length
                        )
                ];

        if (!answers.contains(
                other.reference
        )) {

            answers.add(
                    other.reference
            );
        }
    }

    java.util.Collections.shuffle(answers);

    for (String answer : answers) {

        addAnswerButton(
                answer,
                answer.equals(
                        current.reference
                )
        );
    }
}


private void addAnswerButton(
        String answer,
        boolean correct
) {

    Button button =
            new Button(this);

    button.setText(answer);

    button.setTextSize(15);

    button.setAllCaps(false);

    button.setOnClickListener(
            v -> handleAnswer(
                    button,
                    correct
            )
    );

    content.addView(
            button,
            new LinearLayout.LayoutParams(
                    -1,
                    -2
            )
    );
}


private void handleAnswer(
        Button selectedButton,
        boolean correct
) {

    for (int i = 0;
            i < content.getChildCount();
            i++) {

        View child =
                content.getChildAt(i);

        if (child instanceof Button) {

            child.setEnabled(false);
        }
    }

    if (correct) {

        score += 10;

        selectedButton.setText(
                "✅ " +
                selectedButton.getText()
        );

    } else {

        selectedButton.setText(
                "❌ " +
                selectedButton.getText()
        );
    }

    Button nextButton =
            new Button(this);

    if (questionIndex + 1 <
            activeQuestions.length) {

        nextButton.setText(
                "➡️ Next Question"
        );

    } else {

        nextButton.setText(
                "🏆 See Results"
        );
    }

    nextButton.setTextSize(17);

    nextButton.setAllCaps(false);

    nextButton.setOnClickListener(
            v -> {

                questionIndex++;

                showQuestion();
            }
    );

    LinearLayout.LayoutParams nextParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

nextParams.setMargins(
        0,
        10,
        0,
        10
);

nextButton.setMinHeight(70);
nextButton.setPadding(
        20,
        12,
        20,
        12
);

content.addView(
        nextButton,
        nextParams
);
}


private void showFinalResult() {

    content.removeAllViews();
    if (level == 1) {

    getSharedPreferences(
            "KingdomLifePrefs",
            MODE_PRIVATE
    ).edit()
            .putBoolean(
                    "memory_" +
                    gameType +
                    "_level_2_unlocked",
                    true
            )
            .apply();

} else if (level == 2) {

    getSharedPreferences(
            "KingdomLifePrefs",
            MODE_PRIVATE
    ).edit()
            .putBoolean(
                    "memory_" +
                    gameType +
                    "_level_3_unlocked",
                    true
            )
            .apply();
    }

    TextView title =
            new TextView(this);

    title.setText(
            "🏆 Level Complete!"
    );

    title.setTextSize(26);

    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );

    title.setTextColor(Color.BLACK);

    title.setGravity(Gravity.CENTER);

    title.setPadding(
            0,
            30,
            0,
            25
    );

    content.addView(title);

    TextView result =
            new TextView(this);

    result.setText(
            "Level " +
            level +
            " completed!\n\n" +
            "Score: " +
            score +
            " / " +
            (activeQuestions.length * 10)
    );

    result.setTextSize(20);

    result.setTextColor(Color.BLACK);

    result.setGravity(Gravity.CENTER);

    result.setPadding(
            0,
            10,
            0,
            30
    );

    content.addView(result);

    Button retryButton =
            new Button(this);

    retryButton.setText(
            "🔄 Play Again"
    );

    retryButton.setAllCaps(false);

    retryButton.setOnClickListener(
            v -> {

                questionIndex = 0;
                score = 0;

                showQuestion();
            }
    );

    content.addView(
            retryButton,
            new LinearLayout.LayoutParams(
                    -1,
                    70
            )
    );

    Button levelsButton =
            new Button(this);

    levelsButton.setText(
            "📚 Choose Another Level"
    );

    levelsButton.setAllCaps(false);

    levelsButton.setOnClickListener(
            v -> showLevels(gameType)
    );

    content.addView(
            levelsButton,
            new LinearLayout.LayoutParams(
                    -1,
                    70
            )
    );

    Button gamesButton =
            new Button(this);

    gamesButton.setText(
            "🧠 Choose Another Game"
    );

    gamesButton.setAllCaps(false);

    gamesButton.setOnClickListener(
            v -> showGameMenu()
    );

    content.addView(
            gamesButton,
            new LinearLayout.LayoutParams(
                    -1,
                    70
            )
    );
        }

    private void showMessage(
            String titleText,
            String messageText
    ) {

        content.removeAllViews();

        TextView title =
                new TextView(this);

        title.setText(titleText);

        title.setTextSize(24);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setTextColor(
                Color.BLACK
        );

        title.setGravity(
                Gravity.CENTER
        );

        title.setPadding(
                0,
                30,
                0,
                20
        );

        content.addView(title);

        TextView message =
                new TextView(this);

        message.setText(messageText);

        message.setTextSize(18);

        message.setTextColor(
                Color.BLACK
        );

        content.addView(message);

        Button backButton =
                new Button(this);

        backButton.setText(
                "⬅️ Back"
        );

        backButton.setOnClickListener(
                v -> showGameMenu()
        );

        content.addView(backButton);
    }
}
