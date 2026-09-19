package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout content;

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
        title.setTextColor(Color.rgb(45, 45, 45));
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 35, 0, 25);

        main.addView(title);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(25, 10, 25, 10);

        main.addView(content, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1
        ));

        showHome();

        setContentView(main);
    }

    void showHome() {
        content.removeAllViews();

        addButton("🙏 Prayer for the Day", v -> showMessage(
                "Prayer for the Day",
                "Lord, guide us today, strengthen our faith, and help us walk in love, wisdom, and truth. Amen."
        ));

        addButton("📖 Verse of the Day", v -> showMessage(
                "Verse of the Day",
                "Your word is a lamp for my feet and a light on my path."
        ));

        addButton("💭 Food for Thought", v -> showMessage(
                "Food for Thought",
                "Take a moment today to consider how you can show kindness, patience, and faith to someone around you."
        ));

        addButton("🎮 Bible Games", v -> showGames());

        addButton("🧠 Memory Verse", v -> showMessage(
                "Memory Verse",
                "Read, remember, and practice God's Word every day."
        ));

        addButton("ℹ️ About Kingdom Life", v -> showMessage(
                "About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, prayer, reflection, and fun."
        ));
    }

    void showGames() {
        content.removeAllViews();

        addButton("❓ Fill in the Gap", v -> showMessage(
                "Fill in the Gap",
                "In the beginning God created the _____ and the earth."
        ));

        addButton("🧩 Bible Puzzle", v -> showMessage(
                "Bible Puzzle",
                "Who built the ark? Think carefully!"
        ));

        addButton("🏆 Bible Quiz", v -> showMessage(
                "Bible Quiz",
                "Which Bible book comes first? A) Exodus  B) Genesis  C) Matthew"
        ));

        addButton("⬅️ Back to Home", v -> showHome());
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
        title.setPadding(0, 15, 0, 15);

        content.addView(title);

        TextView text = new TextView(this);
        text.setText(message);
        text.setTextSize(18);
        text.setPadding(0, 10, 0, 25);

        content.addView(text);

        addButton("⬅️ Back to Home", v -> showHome());
    }
    }
