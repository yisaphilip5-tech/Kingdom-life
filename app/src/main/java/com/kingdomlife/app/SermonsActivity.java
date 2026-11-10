package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SermonsActivity extends Activity {

    private LinearLayout content;

    private final int PURPLE = Color.rgb(30, 24, 55);
    private final int GOLD = Color.rgb(184, 134, 11);
    private final int WHITE = Color.WHITE;
    private final int LIGHT = Color.rgb(245, 242, 235);

    private final String[] months = {
            "January - Thanksgiving",
            "February - Love",
            "March - Divine Guidance (The Supernatural)",
            "April - Prayer",
            "May - The Word of God",
            "June - Divine Health",
            "July - Wisdom",
            "August - Success",
            "September - The Holy Spirit",
            "October - Faith",
            "November - Praise",
            "December - Fasting"
    };

    private final String[][] weeklyTopics = {
            {
                    "What Is Thanksgiving?",
                    "Characteristics of an Acceptable Thanksgiving",
                    "Why Should I Give Thanks to God?",
                    "How to Give an Acceptable Thanksgiving to God"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            },
            {
                    "Week 1 - To be developed",
                    "Week 2 - To be developed",
                    "Week 3 - To be developed",
                    "Week 4 - To be developed"
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(20, 20, 20, 30);

        scrollView.addView(content);
        setContentView(scrollView);

        showSermonsHome();
    }

    private void addTitle(String text) {
        TextView title = new TextView(this);
        title.setText(text);
        title.setTextSize(25);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(GOLD);
        title.setPadding(0, 20, 0, 15);
        content.addView(title);
    }

    private void addText(String text, int size) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(WHITE);
        view.setPadding(0, 8, 0, 8);
        content.addView(view);
    }

    private void addButton(String text, Runnable action) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(WHITE);
        button.setAllCaps(false);
        button.setTextSize(15);
        button.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(PURPLE)
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 8);

        content.addView(button, params);

        button.setOnClickListener(v -> action.run());
    }

    private void showSermonsHome() {
        content.removeAllViews();
        content.setBackgroundColor(PURPLE);

        addButton("⬅ Back to Learn & Grow", this::finish);

        addTitle("🎙️ Kingdom Life Sermons");

        addText(
                "Grow in faith through weekly biblical teachings.",
                16
        );

        addText(
                "12 monthly topics • 48 regular weekly teachings",
                14
        );

        for (int i = 0; i < months.length; i++) {
            final int monthIndex = i;

            addButton(
                    "📖 " + months[i],
                    () -> showMonth(monthIndex)
            );
        }

        addTitle("Additional Fifth-Week Teachings");

        addText(
                "Four additional teachings will be organised here " +
                "to complete the 52-week annual programme.",
                15
        );
    }

    private void showMonth(int monthIndex) {
        content.removeAllViews();
        content.setBackgroundColor(PURPLE);

        addButton("⬅ Back to Sermons", this::showSermonsHome);

        addTitle(months[monthIndex]);

        addText(
                "Select a weekly teaching:",
                16
        );

        for (int i = 0; i < 4; i++) {
            final int weekIndex = i;

            addButton(
                    "Week " + (i + 1) + ": " +
                            weeklyTopics[monthIndex][i],
                    () -> openTeaching(monthIndex, weekIndex)
            );
        }
    }

    private void openTeaching(int monthIndex, int weekIndex) {

        if (monthIndex == 0 && weekIndex == 0) {
            showJanuaryWeekOne();
            return;
        }

        content.removeAllViews();
        content.setBackgroundColor(PURPLE);

        addButton(
                "⬅ Back to " + months[monthIndex],
                () -> showMonth(monthIndex)
        );

        addTitle(
                "Week " + (weekIndex + 1)
        );

        addText(
                weeklyTopics[monthIndex][weekIndex],
                21
        );

        addText(
                "This teaching will be added after the message " +
                "has been prepared and approved.",
                16
        );
    }

    private void showJanuaryWeekOne() {
        content.removeAllViews();
        content.setBackgroundColor(PURPLE);

        addButton(
                "⬅ Back to January",
                () -> showMonth(0)
        );

        addTitle("JANUARY — THANKSGIVING");

        addText("WEEK 1: WHAT IS THANKSGIVING?", 21);

        addText(
                "Main Scriptures: 1 Thessalonians 5:18; " +
                "2 Thessalonians 2:13; Luke 17:15–18.",
                15
        );

        addSection(
                "Introduction",
                "Thanksgiving is the act of expressing gratitude " +
                "and appreciation to God for His goodness, faithfulness, " +
                "provision and work in our lives. It is more than simply " +
                "saying, 'Thank You, Lord.' It is a recognition that " +
                "everything we have and every good thing we experience " +
                "ultimately comes from Him."
        );

        addSection(
                "1. Thanksgiving Is an Expression of Gratitude to God",
                "When we give thanks, we acknowledge that God is the " +
                "source of our blessings. We recognise His hand in our " +
                "lives rather than taking His goodness for granted.\n\n" +
                "Scripture: 1 Thessalonians 5:18."
        );

        addSection(
                "2. Thanksgiving Is a Debt We Owe God",
                "God has continually shown us goodness, mercy and " +
                "faithfulness. Therefore, giving Him thanks is an " +
                "appropriate response to all He has done.\n\n" +
                "In Luke 17:15–18, ten lepers were healed, but only one " +
                "returned to give glory to God. This teaches us not to " +
                "receive God's blessings and forget to appreciate Him."
        );

        addSection(
                "3. Thanksgiving Helps Us Recognise and Preserve Our Blessings",
                "When we regularly thank God, we become more conscious " +
                "of His goodness. We learn not to take His blessings " +
                "for granted.\n\n" +
                "Thanksgiving is connected with increase and the " +
                "preservation of blessings. We should recognise that " +
                "every increase comes from God and continue to " +
                "acknowledge Him."
        );

        addSection(
                "4. Thanksgiving Gives God the Glory",
                "Thanksgiving directs our attention away from pride " +
                "and towards God. Instead of claiming all the credit " +
                "for ourselves, we acknowledge His help and goodness.\n\n" +
                "Scripture: Matthew 16:17."
        );

        addSection(
                "Key Lessons",
                "• Thanksgiving is an expression of genuine gratitude.\n" +
                "• Never take God's blessings for granted.\n" +
                "• Gratitude should be part of daily Christian life.\n" +
                "• Acknowledge God as the source of every good thing.\n" +
                "• Give God glory even during difficult circumstances."
        );

        addSection(
                "Conclusion",
                "Thanksgiving is not merely a religious activity; " +
                "it is an attitude of the heart. God deserves our " +
                "gratitude because of who He is and because of His " +
                "goodness towards us. Let us learn to recognise His " +
                "hand in our lives and never forget to give Him the glory."
        );

        addSection(
                "Reflection",
                "Do I remember to thank God only when I receive " +
                "something, or is gratitude part of my everyday life?"
        );

        addSection(
                "Closing Prayer",
                "Father, thank You for Your goodness and faithfulness " +
                "in my life. Help me to develop a grateful heart and " +
                "never take Your blessings for granted. Teach me to " +
                "acknowledge You in all things and always give You " +
                "the glory, in Jesus' name. Amen."
        );
    }

    private void addSection(String heading, String body) {

        TextView headingView = new TextView(this);
        headingView.setText(heading);
        headingView.setTextSize(18);
        headingView.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        headingView.setTextColor(GOLD);
        headingView.setPadding(0, 18, 0, 5);

        content.addView(headingView);

        TextView bodyView = new TextView(this);
        bodyView.setText(body);
        bodyView.setTextSize(15);
        bodyView.setTextColor(WHITE);
        bodyView.setLineSpacing(5, 1f);
        bodyView.setPadding(0, 5, 0, 10);

        content.addView(bodyView);
    }
          }
