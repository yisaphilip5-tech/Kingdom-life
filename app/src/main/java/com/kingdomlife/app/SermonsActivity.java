package com.kingdomlife.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Calendar;

public class SermonsActivity extends Activity {

    private LinearLayout content;

    private final int PURPLE = Color.rgb(30, 24, 55);
    private final int GOLD = Color.rgb(184, 134, 11);
    private final int DARK_TEXT = Color.rgb(45, 45, 45);

    private final String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    private final String[] topics = {
            "Thanksgiving",
            "Love",
            "Divine Guidance (The Supernatural)",
            "Prayer",
            "The Word of God",
            "Divine Health",
            "Wisdom",
            "Success",
            "The Holy Spirit",
            "Faith",
            "Praise",
            "Fasting"
    };

    private final String[][] weeklyTeachings = {
            {
                    "What Is Thanksgiving?",
                    "Characteristics of an Acceptable Thanksgiving",
                    "Why Should I Give Thanks to God?",
                    "How to Give an Acceptable Thanksgiving to God"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            },
            {
                    "Week 1 Teaching",
                    "Week 2 Teaching",
                    "Week 3 Teaching",
                    "Week 4 Teaching"
            }
    };

    private int selectedMonth;
    private int selectedWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(20), dp(15), dp(20), dp(25));

        scrollView.addView(content);

        // Keep content clear of the phone's system bars.
        scrollView.setOnApplyWindowInsetsListener((view, insets) -> {
            view.setPadding(
                    insets.getSystemWindowInsetLeft(),
                    insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    insets.getSystemWindowInsetBottom()
            );
            return insets;
        });

        setContentView(scrollView);

        applyKingdomBackground();

        Calendar calendar = Calendar.getInstance();

        selectedMonth =
                calendar.get(Calendar.MONTH);

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        selectedWeek = Math.min((day - 1) / 7, 3);

        showSermonsHome();
    }

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }

    private GradientDrawable makeBackground(
            int backgroundColor,
            int strokeColor) {

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(backgroundColor);
        drawable.setCornerRadius(dp(18));
        drawable.setStroke(dp(2), strokeColor);

        return drawable;
    }

    private void applyKingdomBackground() {

        android.content.SharedPreferences displayPrefs =
                getSharedPreferences(
                        "KingdomLifeDisplayPrefs",
                        MODE_PRIVATE
                );

        String displayMode =
                displayPrefs.getString("displayMode", "AUTO");

        if (displayMode.equals("DAY")) {

            content.setBackgroundResource(
                    R.drawable.kingdom_home_bg
            );

        } else if (displayMode.equals("NIGHT")) {

            content.setBackgroundResource(
                    R.drawable.kingdom_night_bg
            );

        } else {

            int hour = Calendar.getInstance()
                    .get(Calendar.HOUR_OF_DAY);

            if (hour >= 6 && hour < 18) {
                content.setBackgroundResource(
                        R.drawable.kingdom_home_bg
                );
            } else {
                content.setBackgroundResource(
                        R.drawable.kingdom_night_bg
                );
            }
        }
    }

    private void addBackButton(Runnable action) {

        ImageButton backButton = new ImageButton(this);

        backButton.setImageResource(
                android.R.drawable.ic_media_previous
        );

        backButton.setBackgroundColor(Color.TRANSPARENT);
        backButton.setContentDescription("Back");

        backButton.setOnClickListener(v -> action.run());

        content.addView(
                backButton,
                new LinearLayout.LayoutParams(
                        dp(60),
                        dp(60)
                )
        );
    }

    private TextView addText(
            String text,
            int size,
            int color,
            boolean bold) {

        TextView view = new TextView(this);

        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(color);

        if (bold) {
            view.setTypeface(
                    Typeface.DEFAULT,
                    Typeface.BOLD
            );
        }

        view.setPadding(0, dp(5), 0, dp(8));

        content.addView(view);

        return view;
    }

    private void addCard(
            String heading,
            String description,
            View.OnClickListener listener) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(12), dp(10), dp(12), dp(10));
        card.setBackground(makeBackground(Color.WHITE, GOLD));
        card.setElevation(dp(3));
        card.setClickable(true);
        card.setFocusable(true);

        TextView title = new TextView(this);
        title.setText(heading);
        title.setTextSize(16);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(PURPLE);

        TextView details = new TextView(this);
        details.setText(description);
        details.setTextSize(13);
        details.setTextColor(DARK_TEXT);
        details.setPadding(0, dp(5), 0, 0);

        card.addView(title);
        card.addView(details);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 0, 0, dp(10));

        content.addView(card, params);

        card.setOnClickListener(listener);
    }

    public void showSermonsHome() {

        content.removeAllViews();

        addBackButton(this::finish);

        addText(
                "🎙️ Kingdom Sermons",
                24,
                DARK_TEXT,
                true
        );

        addText(
                "Grow in faith through biblical teachings.",
                15,
                DARK_TEXT,
                false
        );

        addCard(
                "📖 This Month: " + months[selectedMonth],
                topics[selectedMonth],
                v -> showMonth(selectedMonth)
        );

        addText(
                "All Monthly Topics",
                19,
                DARK_TEXT,
                true
        );

        for (int i = 0; i < months.length; i++) {

            final int monthIndex = i;

            addCard(
                    months[i],
                    topics[i],
                    v -> showMonth(monthIndex)
            );
        }

        addCard(
                "📚 Additional Fifth-Week Teachings",
                "Four additional teachings will complete the annual "
                        + "52-week sermon programme.",
                v -> showAdditionalTeachings()
        );
    }

    private void showMonth(int monthIndex) {

        content.removeAllViews();

        addBackButton(this::showSermonsHome);

        addText(
                months[monthIndex],
                24,
                DARK_TEXT,
                true
        );

        addText(
                "Monthly Topic: " + topics[monthIndex],
                17,
                DARK_TEXT,
                true
        );

        addText(
                "Weekly Teachings",
                19,
                DARK_TEXT,
                true
        );

        for (int i = 0; i < 4; i++) {

            final int weekIndex = i;

            String label = "Week " + (i + 1);

            if (monthIndex == selectedMonth
                    && weekIndex == selectedWeek) {
                label += " • Current Week";
            }

            addCard(
                    label + ": " + weeklyTeachings[monthIndex][i],
                    "Open this week's biblical teaching.",
                    v -> showTeaching(monthIndex, weekIndex)
            );
        }
    }

    private void showTeaching(
            int monthIndex,
            int weekIndex) {

        content.removeAllViews();

        addBackButton(() -> showMonth(monthIndex));

        addText(
                months[monthIndex] + " — Week "
                        + (weekIndex + 1),
                23,
                DARK_TEXT,
                true
        );

        addText(
                weeklyTeachings[monthIndex][weekIndex],
                20,
                DARK_TEXT,
                true
        );

        if (monthIndex == 0 && weekIndex == 0) {
            showJanuaryWeekOne();
        } else {

            addText(
                    "This teaching is being prepared.",
                    16,
                    DARK_TEXT,
                    false
            );

            addText(
                    "The full sermon will be added when its "
                            + "source material has been organised.",
                    14,
                    DARK_TEXT,
                    false
            );
        }
    }

    private void showJanuaryWeekOne() {

        addText(
                "Main Scriptures",
                18,
                PURPLE,
                true
        );

        addText(
                "1 Thessalonians 5:18\n"
                        + "2 Thessalonians 2:13\n"
                        + "Luke 17:15–18",
                15,
                DARK_TEXT,
                false
        );

        addText(
                "Introduction",
                18,
                PURPLE,
                true
        );

        addText(
                "Thanksgiving is an expression of gratitude to God. "
                        + "It is an important part of our Christian "
                        + "life and a way of acknowledging God's "
                        + "goodness and faithfulness.",
                15,
                DARK_TEXT,
                false
        );

        addTeachingPoint(
                "1. Thanksgiving Is an Expression of Gratitude",
                "Thanksgiving is how we express our appreciation "
                        + "to God for His goodness, kindness and "
                        + "faithfulness."
        );

        addTeachingPoint(
                "2. Thanksgiving Is a Debt We Owe God",
                "In Luke 17:15–18, ten lepers were healed, but "
                        + "only one returned to give thanks. "
                        + "We should not receive God's blessings "
                        + "without remembering to appreciate Him."
        );

        addTeachingPoint(
                "3. Thanksgiving Helps Us Recognise Our Blessings",
                "A thankful heart remembers God's goodness and "
                        + "does not take His blessings for granted."
        );

        addTeachingPoint(
                "4. Thanksgiving Gives God the Glory",
                "Our thanksgiving should direct the glory and "
                        + "honour to God, recognising Him as "
                        + "the source of our blessings."
        );

        addText(
                "Key Lessons",
                18,
                PURPLE,
                true
        );

        addText(
                "• Develop a grateful heart.\n"
                        + "• Do not take God's blessings for granted.\n"
                        + "• Make gratitude part of everyday life.\n"
                        + "• Recognise God as the source of your blessings.\n"
                        + "• Give thanks even during difficult times.",
                15,
                DARK_TEXT,
                false
        );

        addText(
                "Reflection",
                18,
                PURPLE,
                true
        );

        addText(
                "Do I remember to thank God only when I receive "
                        + "something, or is gratitude part of my "
                        + "everyday life?",
                15,
                DARK_TEXT,
                false
        );

        addText(
                "Closing Prayer",
                18,
                PURPLE,
                true
        );

        addText(
                "Heavenly Father, give me a grateful heart. "
                        + "Help me to recognise Your goodness, "
                        + "remember Your blessings and give You "
                        + "the glory in every situation. In Jesus' "
                        + "name, Amen.",
                15,
                DARK_TEXT,
                false
        );
    }
    private void showJanuaryWeekTwo() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "2 Corinthians 9:7\n"
                    + "Psalm 50:14\n"
                    + "Hebrews 11:6\n"
                    + "Deuteronomy 8:10–14",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Introduction",
            18,
            PURPLE,
            true
    );

    addText(
            "Thanksgiving is more than simply saying "
                    + "thank you to God. It should come from "
                    + "a sincere heart and reflect our "
                    + "recognition of His goodness. God "
                    + "desires thanksgiving that is genuine "
                    + "and accompanied by a life that honours Him.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. It Must Come From a Sincere Heart",
            "Acceptable thanksgiving begins within the heart. "
                    + "We should genuinely appreciate God rather "
                    + "than offer words without meaning. "
                    + "Psalm 9:1 reminds us to praise God "
                    + "with our whole heart."
    );

    addTeachingPoint(
            "2. It Must Be Given Willingly",
            "Our thanksgiving should not be forced or offered "
                    + "merely because others expect it. "
                    + "2 Corinthians 9:7 teaches the importance "
                    + "of giving willingly and cheerfully. "
                    + "This principle reminds us to approach "
                    + "God with a willing heart."
    );

    addTeachingPoint(
            "3. It Must Be Offered in Faith",
            "We should approach God with faith, trusting "
                    + "in His goodness and faithfulness. "
                    + "Hebrews 11:6 reminds us that without "
                    + "faith it is impossible to please God."
    );

    addTeachingPoint(
            "4. It Must Be Accompanied by a Life That Honours God",
            "Thanksgiving should not end with our words. "
                    + "Our actions, decisions and daily conduct "
                    + "should also honour God. Colossians 3:17 "
                    + "teaches us to do everything in the name "
                    + "of the Lord Jesus, giving thanks to God."
    );

    addTeachingPoint(
            "5. It Must Recognise God as the Source of Our Blessings",
            "We must never become so focused on what we have "
                    + "received that we forget the One who "
                    + "provided it. Deuteronomy 8:10–14 warns "
                    + "against forgetting God when we enjoy "
                    + "His blessings."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• Let your thanksgiving come from a sincere heart.\n"
                    + "• Thank God willingly and cheerfully.\n"
                    + "• Trust God and approach Him in faith.\n"
                    + "• Let your daily life honour God.\n"
                    + "• Never forget God as the source of your blessings.",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Reflection",
            18,
            PURPLE,
            true
    );

    addText(
            "Is my thanksgiving sincere and willing, "
                    + "or do I sometimes express gratitude "
                    + "only because I feel expected to?",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Closing Prayer",
            18,
            PURPLE,
            true
    );

    addText(
            "Heavenly Father, help me to offer You "
                    + "thanksgiving from a sincere and willing "
                    + "heart. Teach me to trust You, honour You "
                    + "with my life and never forget that every "
                    + "good thing comes from You. In Jesus' "
                    + "name, Amen.",
            15,
            DARK_TEXT,
            false
    );
    }
    private void showJanuaryWeekThree() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "Psalm 107:1\n"
                    + "Psalm 103:1–5\n"
                    + "Colossians 3:15–17\n"
                    + "1 Thessalonians 5:18",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Introduction",
            18,
            PURPLE,
            true
    );

    addText(
            "Thanksgiving is an important part of our "
                    + "relationship with God. We do not give "
                    + "thanks only because everything is going "
                    + "well, but because God is good and "
                    + "deserves our gratitude. Understanding "
                    + "why we should give thanks helps us "
                    + "develop a consistent attitude of gratitude.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. Because God Is Good and His Mercy Endures Forever",
            "Psalm 107:1 calls us to give thanks unto the Lord "
                    + "because He is good and His mercy endures "
                    + "forever. God's goodness gives us reason "
                    + "to remain thankful."
    );

    addTeachingPoint(
            "2. Because God Has Done Great Things for Us",
            "God has blessed, helped, protected and sustained "
                    + "us in many ways. Psalm 103:2 reminds us "
                    + "not to forget all His benefits. Thanksgiving "
                    + "helps us remember what God has done."
    );

    addTeachingPoint(
            "3. Because Thanksgiving Gives Glory to God",
            "When we acknowledge God's goodness, we direct "
                    + "honour and praise to Him. Thanksgiving "
                    + "reminds us that He is worthy of our "
                    + "worship and appreciation."
    );

    addTeachingPoint(
            "4. Because Thanksgiving Helps Us Maintain a Grateful Heart",
            "A thankful heart learns to recognise God's goodness "
                    + "even in ordinary moments. Colossians 3:15 "
                    + "encourages us to be thankful. Gratitude "
                    + "should become part of our daily lives."
    );

    addTeachingPoint(
            "5. Because God Deserves Our Thanksgiving in Every Situation",
            "1 Thessalonians 5:18 teaches us to give thanks "
                    + "in every situation. This does not mean "
                    + "that every situation is pleasant, but "
                    + "that we can continue to trust and "
                    + "acknowledge God through every season."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• God is good and deserves our gratitude.\n"
                    + "• Remember the good things God has done.\n"
                    + "• Give God the glory for His goodness.\n"
                    + "• Develop a thankful heart every day.\n"
                    + "• Continue trusting God through every season.",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Reflection",
            18,
            PURPLE,
            true
    );

    addText(
            "Do I recognise and appreciate God's goodness "
                    + "in my everyday life, or do I focus mainly "
                    + "on the things I am still waiting for?",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Closing Prayer",
            18,
            PURPLE,
            true
    );

    addText(
            "Heavenly Father, thank You for Your goodness "
                    + "and mercy. Help me never to forget "
                    + "Your benefits. Give me a grateful heart "
                    + "that honours You in every season of my "
                    + "life. In Jesus' name, Amen.",
            15,
            DARK_TEXT,
            false
    );
        }
    private void showJanuaryWeekFour() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "Psalm 100:4\n"
                    + "Hebrews 13:15\n"
                    + "Colossians 3:17\n"
                    + "Philippians 4:6",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Introduction",
            18,
            PURPLE,
            true
    );

    addText(
            "Knowing that we should give thanks to God "
                    + "is important, but we must also understand "
                    + "how to express our gratitude. Acceptable "
                    + "thanksgiving involves our words, our "
                    + "attitude and the way we live. God deserves "
                    + "thanksgiving that comes from a sincere heart.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. Give Thanks With a Sincere Heart",
            "Thanksgiving should be genuine. God is not "
                    + "interested in empty words that do not "
                    + "reflect what is in our hearts. We should "
                    + "appreciate Him sincerely for His goodness."
    );

    addTeachingPoint(
            "2. Give Thanks Through Praise and Worship",
            "Psalm 100:4 encourages us to enter God's gates "
                    + "with thanksgiving and His courts with "
                    + "praise. We can express our gratitude "
                    + "through worship, songs and words of praise."
    );

    addTeachingPoint(
            "3. Give Thanks Continually",
            "Hebrews 13:15 encourages us to offer the "
                    + "sacrifice of praise to God continually. "
                    + "Our gratitude should not be limited "
                    + "to special occasions. We should develop "
                    + "a consistent lifestyle of thanksgiving."
    );

    addTeachingPoint(
            "4. Give Thanks Through Your Words and Actions",
            "Colossians 3:17 teaches us to do everything "
                    + "in the name of the Lord Jesus, giving "
                    + "thanks to God. Our conduct should reflect "
                    + "the gratitude we profess with our mouths."
    );

    addTeachingPoint(
            "5. Give Thanks in Prayer",
            "Philippians 4:6 teaches us to present our "
                    + "requests to God with thanksgiving. "
                    + "Even when we have needs, we should "
                    + "remember to appreciate God while "
                    + "bringing our concerns before Him."
    );

    addTeachingPoint(
            "6. Give Thanks Without Forgetting God's Goodness",
            "Remembering God's past faithfulness helps "
                    + "us remain grateful. We should take time "
                    + "to reflect on His goodness rather than "
                    + "allowing our present challenges to "
                    + "make us forget what He has done."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• Offer God genuine thanksgiving.\n"
                    + "• Express gratitude through praise and worship.\n"
                    + "• Make thanksgiving a daily practice.\n"
                    + "• Let your actions reflect your gratitude.\n"
                    + "• Include thanksgiving in your prayers.\n"
                    + "• Remember God's faithfulness in every season.",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Reflection",
            18,
            PURPLE,
            true
    );

    addText(
            "Apart from saying thank You to God, "
                    + "do my actions and daily lifestyle "
                    + "also demonstrate a grateful heart?",
            15,
            DARK_TEXT,
            false
    );

    addText(
            "Closing Prayer",
            18,
            PURPLE,
            true
    );

    addText(
            "Heavenly Father, teach me how to offer "
                    + "You acceptable thanksgiving. Let my "
                    + "words, worship, prayers and actions "
                    + "reflect a sincere and grateful heart. "
                    + "Help me never to forget Your goodness "
                    + "and faithfulness. In Jesus' name, Amen.",
            15,
            DARK_TEXT,
            false
    );
    }

    private void addTeachingPoint(
            String heading,
            String explanation) {

        addText(
                heading,
                17,
                PURPLE,
                true
        );

        addText(
                explanation,
                15,
                DARK_TEXT,
                false
        );
    }

    private void showAdditionalTeachings() {

        content.removeAllViews();

        addBackButton(this::showSermonsHome);

        addText(
                "Additional Fifth-Week Teachings",
                22,
                DARK_TEXT,
                true
        );

        addText(
                "These four extra teachings will be assigned "
                        + "to selected months as the annual "
                        + "sermon programme is completed.",
                15,
                DARK_TEXT,
                false
        );

        for (int i = 1; i <= 4; i++) {

            addCard(
                    "Additional Teaching " + i,
                    "Content to be added.",
                    v -> showMessage(
                            "This additional teaching is "
                                    + "still being prepared."
                    )
            );
        }
    }

    private void showMessage(String message) {

        new android.app.AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
            }
