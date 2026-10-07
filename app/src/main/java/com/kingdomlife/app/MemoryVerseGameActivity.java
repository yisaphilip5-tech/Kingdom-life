package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemoryVerseGameActivity extends Activity {

    private LinearLayout content;

    private String gameType;
    private int level;

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
                20,
                10,
                20,
                20
        );

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

        button.setOnClickListener(
                v -> showLevels(type)
        );

        content.addView(
                button,
                new LinearLayout.LayoutParams(
                        -1,
                        90
                )
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

        button.setText(text);

        button.setTextSize(18);

        button.setAllCaps(false);

        button.setOnClickListener(
                v -> startGame(
                        type,
                        selectedLevel
                )
        );

        content.addView(
                button,
                new LinearLayout.LayoutParams(
                        -1,
                        70
                )
        );
    }

    private void startGame(
            String type,
            int selectedLevel
    ) {

        // Game question system will be connected next.
        showMessage(
                "Memory Verse",
                "Game: " + type +
                "\nLevel: " + selectedLevel +
                "\n\nQuestions will be connected next."
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
