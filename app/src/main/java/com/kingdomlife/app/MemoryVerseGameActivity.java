package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
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

    private int questionIndex = 0;
    private int score = 0;

    private SharedPreferences prefs;

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

        prefs =
                getSharedPreferences(
                        "KingdomLifePrefs",
                        MODE_PRIVATE
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

        showQuestion();
    }

    private void showQuestion() {
        // Memory Verse game UI will be added here.
        // We are testing the separate Activity first.

        content.removeAllViews();

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

        title.setGravity(
                Gravity.CENTER
        );

        title.setTextColor(
                Color.BLACK
        );

        title.setPadding(
                0,
                30,
                0,
                30
        );

        content.addView(title);

        TextView message =
                new TextView(this);

        message.setText(
                "Memory Verse game connected successfully.\n\n" +
                "Game: " + gameType + "\n" +
                "Level: " + level
        );

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

        content.addView(backButton);

        backButton.setOnClickListener(
                v -> finish()
        );
    }
}
