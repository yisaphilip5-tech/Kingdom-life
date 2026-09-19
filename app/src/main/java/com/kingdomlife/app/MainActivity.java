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

    int darkText = Color.rgb(45, 45, 45);
    int cardColor = Color.rgb(245, 247, 250);

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

        addButton("🎮 Bible Games", v -> showGames());

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
        showMessage(
                "📖 Verse of the Day",
                "Jeremiah 29:11 — KJV\n\n" +
                "For I know the thoughts that I think toward you, saith the LORD, " +
                "thoughts of peace, and not of evil, to give you an expected end."
        );
    }

    void showPrayer() {
        showMessage(
                "🙏 Prayer for the Day",
                "Lord, guide us today and give us wisdom in every decision we make. " +
                "Strengthen our faith, help us walk in love and truth, and give us peace. " +
                "Help us to be a blessing to those around us.\n\nAmen."
        );
    }

    void showThought() {
        showMessage(
                "💭 Food for Thought",
                "Kindness does not always require something big. " +
                "A simple word of encouragement, patience, or helping someone can make a difference.\n\n" +
                "Reflection:\nWhat is one good thing you can do for someone today?"
        );
    }

    void showMemoryVerse() {
        showMessage(
                "🧠 Memory Verse",
                "Jeremiah 29:11 — KJV\n\n" +
                "Can you remember what this verse says?\n\n" +
                "The full Memory Verse challenge system will be added next."
        );
    }

    void showAbout() {
        showMessage(
                "ℹ️ About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, " +
                "prayer, reflection, daily challenges, and fun Bible activities.\n\n" +
                "Version 2.1"
        );
    }

    void showGames() {
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText("🎮 Bible Games");
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 20);

        content.addView(title);

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
                "Which Bible book comes first?\n\nA) Exodus\nB) Genesis\nC) Matthew"
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
    }
