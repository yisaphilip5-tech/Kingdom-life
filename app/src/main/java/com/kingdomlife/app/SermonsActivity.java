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
        // January — Thanksgiving
        {
                "What Is Thanksgiving?",
                "Characteristics of an Acceptable Thanksgiving",
                "Why Should I Give Thanks to God?",
                "How to Give an Acceptable Thanksgiving to God"
        },

        // February — Love
        {
                "Understanding the Love of God",
                "The Importance of Love in the Christian Life",
                "Faith Without Love Is Nothing",
                "Proofs of My Love for God and How to Apply Love in My Life"
        },

        // March — Divine Guidance (The Supernatural)
        {
                "Understanding the Supernatural",
                "Spiritual Atmospheres That Grant Access to the Supernatural",
                "Why Must I Operate in the Supernatural?",
                "How to Walk in the Supernatural"
        },

        // April — Prayer
        {
                "Understanding Prayer: Our Hotline to God",
                "Getting Ready to Pray and Write",
                "The Dominion Power of a Praying and Fasting Teenager",
                "Prayer and Fasting: The Lifewire of Every Growing Church"
        },

        // May — The Word of God
        {
                "Understanding the Word of God",
                "How the Word of God Works in Our Lives",
                "Hindrances to the Study of the Word of God",
                "The Word of God and the Development of Christian Character"
        },

        // June — Divine Health
        {
                "Understanding Healing and Health",
                "Jesus the Healer: Individuals He Healed and Miracles He Performed",
                "The Healing Power and Spiritual Significance of Anointing Oil",
                "Understanding Our Heritage Over Sickness and Disease"
        },

        // July — Wisdom
        {
                "Understanding Wisdom",
                "Types of Wisdom",
                "Characteristics of Wisdom",
                "How to Activate and Apply the Wisdom of God in My Life"
        },

        // August — Success
        {
                "Understanding Success: What Is Success?",
                "Types of Success",
                "Wisdom That Empowers for Success",
                "Steps to Living a Successful Life"
        },

        // September — The Holy Spirit
        {
                "Understanding the Holy Spirit and the Promise of His Coming",
                "The Day of Pentecost: The Coming of the Holy Spirit",
                "The Significance and Manifestations of the Holy Spirit",
                "The Work and Ministry of the Holy Spirit in the Life of a Believer"
        },

        // October — Faith
        {
                "Understanding the Faith That Moves Mountains",
                "The Characteristics and Expressions of Genuine Faith",
                "The Faith That Overcomes Challenges and Produces Results",
                "How to Develop and Grow Your Faith"
        },

        // November — Praise
        {
                "What Is Praise?",
                "Understanding the Power of Praise",
                "What Is an Acceptable Praise?",
                "How to Give an Acceptable Praise"
        },

        // December — Fasting
        {
                "Understanding Fasting: What Is Fasting?",
                "The Biblical Purpose and Importance of Fasting",
                "The Spiritual Benefits and Power of Fasting",
                "How to Fast Acceptably and Effectively"
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
    // Returns the current calendar month (0 = January).
private int getCurrentMonth() {
    return Calendar.getInstance().get(Calendar.MONTH);
}

// Returns the number of the current week in the month.
// Days 1–7 = Week 1
// Days 8–14 = Week 2
// Days 15–21 = Week 3
// Days 22–28 = Week 4
// Days 29–31 = Fifth week
private int getCurrentWeek() {
    int day = Calendar.getInstance().get(
            Calendar.DAY_OF_MONTH
    );

    return ((day - 1) / 7) + 1;
}

// Checks whether a month has been released.
private boolean isMonthReleased(int monthIndex) {
    return monthIndex <= getCurrentMonth();
}

// Checks whether a normal weekly teaching has been released.
private boolean isWeekReleased(
        int monthIndex,
        int weekIndex) {

    int currentMonth = getCurrentMonth();

    if (monthIndex < currentMonth) {
        return true;
    }

    if (monthIndex > currentMonth) {
        return false;
    }

    // weekIndex is zero-based.
    return weekIndex < Math.min(getCurrentWeek(), 4);
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

    if (!isMonthReleased(i)) {
        continue;
    }
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
            if (!isWeekReleased(monthIndex, i)) {
    continue;
            }

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
        if (!isWeekReleased(monthIndex, weekIndex)) {
    showMonth(monthIndex);
    return;
        }

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

switch (monthIndex) {

    case 0: // January — Thanksgiving
        switch (weekIndex) {
            case 0: showJanuaryWeekOne(); break;
            case 1: showJanuaryWeekTwo(); break;
            case 2: showJanuaryWeekThree(); break;
            case 3: showJanuaryWeekFour(); break;
        }
        break;

    case 1: // February — Love
        switch (weekIndex) {
            case 0: showFebruaryWeekOne(); break;
            case 1: showFebruaryWeekTwo(); break;
            case 2: showFebruaryWeekThree(); break;
            case 3: showFebruaryWeekFour(); break;
        }
        break;

    case 2: // March — Divine Guidance
        switch (weekIndex) {
            case 0: showMarchWeekOne(); break;
            case 1: showMarchWeekTwo(); break;
            case 2: showMarchWeekThree(); break;
            case 3: showMarchWeekFour(); break;
        }
        break;

    case 3: // April — Prayer
        switch (weekIndex) {
            case 0: showAprilWeekOne(); break;
            case 1: showAprilWeekTwo(); break;
            case 2: showAprilWeekThree(); break;
            case 3: showAprilWeekFour(); break;
        }
        break;

    case 4: // May — The Word of God
        switch (weekIndex) {
            case 0: showMayWeekOne(); break;
            case 1: showMayWeekTwo(); break;
            case 2: showMayWeekThree(); break;
            case 3: showMayWeekFour(); break;
        }
        break;

    case 5: // June — Divine Health
        switch (weekIndex) {
            case 0: showJuneWeekOne(); break;
            case 1: showJuneWeekTwo(); break;
            case 2: showJuneWeekThree(); break;
            case 3: showJuneWeekFour(); break;
        }
        break;

    case 6: // July — Wisdom
        switch (weekIndex) {
            case 0: showJulyWeekOne(); break;
            case 1: showJulyWeekTwo(); break;
            case 2: showJulyWeekThree(); break;
            case 3: showJulyWeekFour(); break;
        }
        break;

    case 7: // August — Success
        switch (weekIndex) {
            case 0: showAugustWeekOne(); break;
            case 1: showAugustWeekTwo(); break;
            case 2: showAugustWeekThree(); break;
            case 3: showAugustWeekFour(); break;
        }
        break;

    case 8: // September — The Holy Spirit
        switch (weekIndex) {
            case 0: showSeptemberWeekOne(); break;
            case 1: showSeptemberWeekTwo(); break;
            case 2: showSeptemberWeekThree(); break;
            case 3: showSeptemberWeekFour(); break;
        }
        break;

    case 9: // October — Faith
        switch (weekIndex) {
            case 0: showOctoberWeekOne(); break;
            case 1: showOctoberWeekTwo(); break;
            case 2: showOctoberWeekThree(); break;
            case 3: showOctoberWeekFour(); break;
        }
        break;

    case 10: // November — Praise
        switch (weekIndex) {
            case 0: showNovemberWeekOne(); break;
            case 1: showNovemberWeekTwo(); break;
            case 2: showNovemberWeekThree(); break;
            case 3: showNovemberWeekFour(); break;
        }
        break;

    case 11: // December — Fasting
        switch (weekIndex) {
            case 0: showDecemberWeekOne(); break;
            case 1: showDecemberWeekTwo(); break;
            case 2: showDecemberWeekThree(); break;
            case 3: showDecemberWeekFour(); break;
        }
        break;

    default:
        addText(
                "This teaching is not available.",
                16,
                DARK_TEXT,
                false
        );
        break;
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
    private void showFebruaryWeekOne() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "John 3:16\n"
                    + "Romans 5:8\n"
                    + "1 John 4:8–10\n"
                    + "Ephesians 2:4–5",
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
            "The love of God is one of the greatest "
                    + "truths revealed in the Bible. God's "
                    + "love is not based on human perfection "
                    + "or achievement. He demonstrated His "
                    + "love by giving His Son, Jesus Christ, "
                    + "for the salvation of humanity. "
                    + "Understanding this love helps us "
                    + "develop a closer relationship with Him.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. God's Love Is Unconditional",
            "God's love is not something we earn through "
                    + "our achievements. Romans 5:8 shows "
                    + "that Christ died for us while we were "
                    + "still sinners. His love is demonstrated "
                    + "through His grace and mercy."
    );

    addTeachingPoint(
            "2. God's Love Was Demonstrated Through Jesus Christ",
            "John 3:16 reveals the great expression of "
                    + "God's love: He gave His only begotten "
                    + "Son so that whoever believes in Him "
                    + "should not perish but have everlasting life."
    );

    addTeachingPoint(
            "3. God's Love Is Great and Rich in Mercy",
            "Ephesians 2:4–5 describes God as rich in "
                    + "mercy because of His great love "
                    + "towards us. His love brings hope, "
                    + "forgiveness and new life through Christ."
    );

    addTeachingPoint(
            "4. God Is the Source of True Love",
            "1 John 4:8 teaches that God is love. "
                    + "True love begins with Him. As we "
                    + "know God and grow in our relationship "
                    + "with Him, we learn to understand "
                    + "and express His love."
    );

    addTeachingPoint(
            "5. God's Love Gives Us Confidence in Him",
            "Knowing that God loves us helps us approach "
                    + "Him with confidence and trust. "
                    + "We can depend on His faithfulness "
                    + "and remember that His love is revealed "
                    + "through His Word and His actions."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• God's love is not earned through human achievements.\n"
                    + "• Jesus Christ is the greatest demonstration of God's love.\n"
                    + "• God's love is accompanied by mercy and grace.\n"
                    + "• God is the source of true love.\n"
                    + "• Knowing God's love helps us trust Him more.",
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
            "Do I truly understand how much God loves me, "
                    + "and does that understanding influence "
                    + "the way I relate to Him?",
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
            "Heavenly Father, thank You for Your great "
                    + "love towards me. Help me understand "
                    + "the depth of Your love and grow "
                    + "in my relationship with You. Teach "
                    + "me to trust You and reflect Your "
                    + "love in my daily life. In Jesus' "
                    + "name, Amen.",
            15,
            DARK_TEXT,
            false
    );
    }
    private void showFebruaryWeekTwo() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "1 Corinthians 13:1–3\n"
                    + "John 13:34–35\n"
                    + "1 John 4:7–8\n"
                    + "Colossians 3:14",
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
            "Love is central to the Christian life. "
                    + "Our faith should be reflected not only "
                    + "in what we say or know, but also in "
                    + "how we treat others. The Bible teaches "
                    + "that love is essential to our Christian "
                    + "character and our relationship with God.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. Love Is a Commandment From Jesus",
            "In John 13:34–35, Jesus commands His disciples "
                    + "to love one another as He has loved them. "
                    + "Love is not merely an optional quality "
                    + "for Christians; it is part of our calling."
    );

    addTeachingPoint(
            "2. Love Is Greater Than Spiritual Display Without It",
            "1 Corinthians 13:1–3 explains that even great "
                    + "abilities, knowledge and sacrifices "
                    + "amount to nothing without love. "
                    + "Our spiritual activities should be "
                    + "accompanied by genuine love."
    );

    addTeachingPoint(
            "3. Love Shows That We Know God",
            "1 John 4:7–8 teaches that love comes from God. "
                    + "Anyone who truly knows God should "
                    + "grow in love because God Himself is love."
    );

    addTeachingPoint(
            "4. Love Brings Unity Among Believers",
            "Colossians 3:14 describes love as the bond "
                    + "of perfectness. Love helps believers "
                    + "live together in unity, patience "
                    + "and understanding."
    );

    addTeachingPoint(
            "5. Love Gives Meaning to Our Christian Conduct",
            "Our actions should be guided by love rather "
                    + "than selfishness, pride or the desire "
                    + "to hurt others. Genuine Christian love "
                    + "should influence our words, decisions "
                    + "and relationships."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• Love is a commandment from Jesus.\n"
                    + "• Spiritual gifts and knowledge should be accompanied by love.\n"
                    + "• Knowing God should produce love in us.\n"
                    + "• Love helps maintain unity among believers.\n"
                    + "• Let love guide your words and actions.",
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
            "Can people recognise the love of Christ "
                    + "through the way I treat them, or do "
                    + "my actions sometimes contradict "
                    + "what I profess to believe?",
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
            "Heavenly Father, help me understand the "
                    + "importance of love in my Christian "
                    + "life. Teach me to love as Christ "
                    + "loved, to walk in unity with others "
                    + "and to let my actions reflect Your "
                    + "character. In Jesus' name, Amen.",
            15,
            DARK_TEXT,
            false
    );
    }
    private void showFebruaryWeekThree() {

    addText(
            "Main Scriptures",
            18,
            PURPLE,
            true
    );

    addText(
            "Ephesians 4:31–32\n"
                    + "Matthew 5:43–45\n"
                    + "Romans 12:9–10\n"
                    + "1 John 3:17–18",
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
            "Christian love should not remain only in "
                    + "our hearts or in the words we speak. "
                    + "It should be visible in the way we "
                    + "treat people. God calls us to show "
                    + "kindness, forgiveness, compassion "
                    + "and genuine concern for others, "
                    + "including those who may not treat "
                    + "us kindly.",
            15,
            DARK_TEXT,
            false
    );

    addTeachingPoint(
            "1. Love Others With Genuine Sincerity",
            "Romans 12:9 teaches that love should be "
                    + "without dissimulation. This means "
                    + "our love should be genuine, not "
                    + "pretended or motivated by personal "
                    + "gain. We should treat people with "
                    + "honesty and sincerity."
    );

    addTeachingPoint(
            "2. Show Kindness and Compassion",
            "Ephesians 4:32 encourages believers to be "
                    + "kind, tenderhearted and forgiving "
                    + "towards one another. Love should "
                    + "be seen in our patience, kindness "
                    + "and willingness to understand others."
    );

    addTeachingPoint(
            "3. Love Even Those Who Are Difficult to Love",
            "In Matthew 5:43–45, Jesus teaches us to "
                    + "love our enemies and pray for those "
                    + "who persecute us. Christian love "
                    + "should not depend only on how "
                    + "others treat us. We should respond "
                    + "with goodness rather than hatred."
    );

    addTeachingPoint(
            "4. Demonstrate Love Through Practical Actions",
            "1 John 3:17–18 teaches that love should "
                    + "not be expressed only through "
                    + "words and speech, but through "
                    + "actions and truth. We should be "
                    + "willing to help people when we "
                    + "have the ability and opportunity."
    );

    addTeachingPoint(
            "5. Honour and Value Others",
            "Romans 12:10 encourages believers to "
                    + "love one another with brotherly "
                    + "love and give preference to one "
                    + "another in honour. Love teaches "
                    + "us to respect people and avoid "
                    + "selfishness and pride."
    );

    addText(
            "Key Lessons",
            18,
            PURPLE,
            true
    );

    addText(
            "• Let your love be genuine and sincere.\n"
                    + "• Show kindness and compassion to others.\n"
                    + "• Do not repay hatred with hatred.\n"
                    + "• Demonstrate love through practical actions.\n"
                    + "• Respect and honour other people.",
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
            "Can people see genuine Christian love "
                    + "through my behaviour, especially "
                    + "when I am dealing with people "
                    + "who are difficult to relate to?",
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
            "Heavenly Father, teach me to walk in "
                    + "genuine love towards others. Help "
                    + "me to be kind, compassionate, "
                    + "forgiving and willing to help. "
                    + "Remove selfishness and hatred "
                    + "from my heart, and let the love "
                    + "of Christ be seen in my life. "
                    + "In Jesus' name, Amen.",
            15,
            DARK_TEXT,
            false
    );
    }
    
    private void showFebruaryWeekFour() {
    addText("Proofs of My Love for God and How to Apply Love in My Life",
            22, PURPLE, true);

    addText("Main Scripture: John 21:17",
            17, DARK_TEXT, true);

    addText(
            "Love for God should be more than a confession. "
            + "It should be demonstrated through our attitude, "
            + "choices, devotion and actions.",
            16, DARK_TEXT, false
    );

    addText("1. I Will Love God's Word",
            19, PURPLE, true);

    addText(
            "A person who loves God should also develop a love "
            + "for His Word. God's Word should not be something "
            + "we read only when we need an answer; it should "
            + "be part of our daily walk with Him.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Psalm 119:97; 1 Samuel 13:14",
            15, DARK_TEXT, false);

    addText("How to Apply It",
            17, PURPLE, true);

    addText(
            "• Set aside time to read the Bible daily.\n"
            + "• Think about what you have read.\n"
            + "• Practise what the Scriptures teach.",
            15, DARK_TEXT, false
    );

    addText("2. I Will Love God's House",
            19, PURPLE, true);

    addText(
            "Love for God should reflect in our attitude towards "
            + "His house and fellowship with other believers. "
            + "We should value opportunities to worship, learn "
            + "and grow together.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Psalm 84:7",
            15, DARK_TEXT, false);

    addText("How to Apply It",
            17, PURPLE, true);

    addText(
            "• Participate sincerely in church gatherings.\n"
            + "• Respect the place and activities of worship.\n"
            + "• Encourage others to grow in fellowship.",
            15, DARK_TEXT, false
    );

    addText("3. Giving Will Be a Delight",
            19, PURPLE, true);

    addText(
            "Genuine love expresses itself through generosity. "
            + "Giving should come from a willing and loving heart, "
            + "not merely from pressure or a desire to impress people.",
            16, DARK_TEXT, false
    );

    addText(
            "Scriptures: 1 John 3:17; 2 Corinthians 8:1–8",
            15, DARK_TEXT, false
    );

    addText("How to Apply It",
            17, PURPLE, true);

    addText(
            "• Share what you can with someone in need.\n"
            + "• Give willingly and sincerely.\n"
            + "• Be generous with your time, kindness and help.",
            15, DARK_TEXT, false
    );

    addText("4. I Will Have a Heart for Souls",
            19, PURPLE, true);

    addText(
            "Love for God should produce concern for other people. "
            + "We should care about their spiritual growth and "
            + "well-being instead of thinking only about ourselves.",
            16, DARK_TEXT, false
    );

    addText("How to Apply It",
            17, PURPLE, true);

    addText(
            "• Pray for people who need God's help.\n"
            + "• Show kindness and compassion.\n"
            + "• Share your faith respectfully when opportunities arise.",
            15, DARK_TEXT, false
    );

    addText("5. Zero Love for God, Zero Effort",
            19, PURPLE, true);

    addText(
            "Love should produce a willingness to serve and obey God. "
            + "If we claim to love Him, our lives should show a sincere "
            + "desire to follow His ways.",
            16, DARK_TEXT, false
    );

    addText("How to Apply It",
            17, PURPLE, true);

    addText(
            "• Serve God with sincerity.\n"
            + "• Be consistent in your Christian responsibilities.\n"
            + "• Do what is right even when nobody is watching.",
            15, DARK_TEXT, false
    );

    addText("Small Lessons to Remember",
            19, PURPLE, true);

    addText(
            "• Love is demonstrated through action.\n"
            + "• Our devotion should be genuine, not just outward.\n"
            + "• We can show love through small daily decisions.\n"
            + "• Loving God should influence how we treat people.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Which of these proofs of love for God is strongest "
            + "in my life, and which one do I need to improve?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Father, help me to demonstrate my love for You "
            + "through Your Word, worship, giving, service and "
            + "care for others. Let my love be sincere and visible "
            + "in my everyday life. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showMarchWeekOne() {
    addText("Understanding the Supernatural",
            22, PURPLE, true);

    addText("Main Scripture: John 3:3–8",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "The supernatural describes the dimension of life "
            + "that goes beyond ordinary human ability and depends "
            + "on God's power. It reminds us that our Christian "
            + "walk is not limited to what we can achieve by "
            + "human strength alone.",
            16, DARK_TEXT, false
    );

    addText("What Is the Supernatural?",
            19, PURPLE, true);

    addText("1. The Answer or Key to the Impossible",
            18, PURPLE, true);

    addText(
            "The supernatural is"
            + " the answer or key to all that is impossible. "
            + "It points us towards God's ability to do what "
            + "human strength cannot accomplish.",
            16, DARK_TEXT, false
    );

    addText("2. A Product of Faith",
            18, PURPLE, true);

    addText(
            "The supernatural is also described "
            + "as a product of faith. Faith enables us to trust "
            + "God beyond what our physical circumstances "
            + "seem to show.",
            16, DARK_TEXT, false
    );

    addText("3. The Security of Our Destiny in Christ",
            18, PURPLE, true);

    addText(
            "The supernatural is the security of our destiny "
            + "in Christ. Our hope and future are anchored in "
            + "our relationship with Jesus, rather than in "
            + "human ability alone.",
            16, DARK_TEXT, false
    );

    addText("Why Does Understanding It Matter?",
            19, PURPLE, true);

    addText(
            "• It helps us depend on God rather than only on "
            + "our own strength.\n"
            + "• It encourages us to develop our faith.\n"
            + "• It reminds us that our identity and hope "
            + "are found in Christ.\n"
            + "• It helps us approach difficult situations "
            + "with trust in God.",
            15, DARK_TEXT, false
    );

    addText(" Faith and Responsibility",
            19, PURPLE, true);

    addText(
            "Trusting God does not mean refusing to take "
            + "responsible action. Faith should encourage us "
            + "to obey God's Word, make wise decisions and "
            + "do our part while depending on Him.",
            16, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Do I depend only on what I can see and achieve, "
            + "or am I learning to trust God and His Word?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Father, help me understand the life You have "
            + "called me to live in Christ. Strengthen my faith, "
            + "teach me to depend on You and guide my steps "
            + "according to Your Word. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showMarchWeekTwo() {
    addText("Spiritual Atmospheres That Grant Access to the Supernatural",
            22, PURPLE, true);

    addText("Main Scripture: Romans 4:19–22",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Operating in the supernatural requires more than "
            + "desiring to experience God's power. We must also "
            + "pay attention to certain spiritual atmospheres "
            + "that help us position ourselves to encounter "
            + "and experience the supernatural.\n\n"
            + "These atmospheres influence our relationship with "
            + "God, strengthen our faith and help us remain "
            + "conscious of His presence. They include the "
            + "atmosphere of glory, faith, prayer, praise and "
            + "worship, and joy.",
            16, DARK_TEXT, false
    );

    addText("1. The Atmosphere of Glory",
            19, PURPLE, true);

    addText(
            "The atmosphere of glory draws our attention to "
            + "God's presence, greatness and majesty. To operate "
            + "in the supernatural, we must recognise that "
            + "everything begins with God and that all glory "
            + "belongs to Him.\n\n"
            + "When our hearts are focused on His glory, "
            + "we become more conscious of His presence "
            + "rather than being consumed by our circumstances.",
            16, DARK_TEXT, false
    );

    addText("Scripture: John 1:14",
            15, DARK_TEXT, false);

    addText("2. The Atmosphere of Faith",
            19, PURPLE, true);

    addText(
            "Faith is essential to operating in the supernatural "
            + "because it enables us to trust God's ability "
            + "beyond what our physical circumstances reveal.\n\n"
            + "Abraham did not allow his circumstances to destroy "
            + "his confidence in God's promise. Instead, he grew "
            + "strong in faith, giving glory to God and remaining "
            + "fully persuaded that God was able to fulfil "
            + "what He had promised.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Romans 4:19–22",
            15, DARK_TEXT, false);

    addText("3. The Atmosphere of Prayer",
            19, PURPLE, true);

    addText(
            "Prayer creates an atmosphere of communion and "
            + "dependence on God. It is through prayer that "
            + "we express our hearts to Him, seek His direction "
            + "and maintain fellowship with Him.\n\n"
            + "A person who desires to operate in the supernatural "
            + "must learn to make prayer an important part "
            + "of daily life. Prayer keeps our attention on God "
            + "and helps us seek His will.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: John 17:1; 2 Chronicles 1:3",
            15, DARK_TEXT, false);

    addText("4. The Atmosphere of Praise and Worship",
            19, PURPLE, true);

    addText(
            "Praise and worship establish an atmosphere "
            + "of honour and adoration towards God. They shift "
            + "our attention away from distractions and remind "
            + "us of His greatness and faithfulness.\n\n"
            + "As we praise and worship God sincerely, "
            + "we express our gratitude, acknowledge His power "
            + "and give Him the honour He deserves. Our worship "
            + "should come from a sincere heart, not merely "
            + "from outward activity.",
            16, DARK_TEXT, false
    );

    addText("5. The Atmosphere of Joy",
            19, PURPLE, true);

    addText(
            "Joy is another important atmosphere to cultivate "
            + "in our walk with God. Operating in the supernatural "
            + "should not be separated from a heart that finds "
            + "confidence and delight in God.\n\n"
            + "This joy is not based only on whether everything "
            + "around us is going well. It comes from knowing "
            + "God, trusting His goodness and remaining confident "
            + "in Him even during difficult seasons.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Psalm 67:5–7; Proverbs 28:12",
            15, DARK_TEXT, false);

    addText("How to Cultivate These Atmospheres",
            19, PURPLE, true);

    addText(
            "• Give God glory in your thoughts, words and actions.\n"
            + "• Build your faith through His Word.\n"
            + "• Maintain a consistent life of prayer.\n"
            + "• Make praise and sincere worship part of your devotion.\n"
            + "• Choose to remain joyful and confident in God.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Which of these spiritual atmospheres am I "
            + "cultivating in my daily walk with God? "
            + "What changes do I need to make to become "
            + "more intentional about them?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Father, help me to cultivate the right spiritual "
            + "atmospheres in my life. Let my heart remain "
            + "conscious of Your glory, established in faith, "
            + "committed to prayer, filled with praise and "
            + "rooted in joy. Help me to grow in my walk with "
            + "You and experience the life You have called "
            + "me to live. Amen.",
            16, DARK_TEXT, false
    );
        }
    private void showMarchWeekThree() {
    addText("Why Must I Operate in the Supernatural?",
            22, PURPLE, true);

    addText("Main Scriptures: Zechariah 4:6; John 15:5",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "God has not called us to live the Christian life "
            + "by human strength alone. Our journey of faith "
            + "requires His power, wisdom and direction.\n\n"
            + "Operating in the supernatural means learning "
            + "to depend on God beyond our natural abilities "
            + "and allowing His power to work in our lives. "
            + "It is not about seeking extraordinary experiences "
            + "for their own sake, but about living in dependence "
            + "on God and fulfilling His purpose.",
            16, DARK_TEXT, false
    );

    addText("1. To Live Beyond Human Limitations",
            19, PURPLE, true);

    addText(
            "Human ability has limitations, but God's power "
            + "is not limited by human strength. There are "
            + "situations that require wisdom, strength and "
            + "help beyond what we can provide for ourselves.\n\n"
            + "This is why we must learn to depend on God "
            + "rather than making our natural ability "
            + "the final measure of what is possible.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Zechariah 4:6; Luke 18:27",
            15, DARK_TEXT, false);

    addText("2. To Fulfil God's Purpose for Our Lives",
            19, PURPLE, true);

    addText(
            "God's purpose for our lives requires more than "
            + "personal ambition. We need His guidance and "
            + "strength to fulfil the assignments He has "
            + "given us.\n\n"
            + "Operating in the supernatural helps us recognise "
            + "that we cannot successfully fulfil God's purpose "
            + "while ignoring our dependence on Him.",
            16, DARK_TEXT, false
    );

    addText("Scripture: John 15:5",
            15, DARK_TEXT, false);

    addText("3. To Receive Divine Guidance",
            19, PURPLE, true);

    addText(
            "We do not always know the right steps to take "
            + "or understand everything that lies ahead. "
            + "We therefore need God's wisdom and direction.\n\n"
            + "As we maintain fellowship with Him through "
            + "prayer and His Word, we learn to seek His "
            + "direction instead of depending only on "
            + "our own understanding.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Proverbs 3:5–6; Isaiah 30:21",
            15, DARK_TEXT, false);

    addText("4. To Stand Firm in Difficult Times",
            19, PURPLE, true);

    addText(
            "The Christian life comes with challenges, "
            + "but we are not expected to face them "
            + "without God's help.\n\n"
            + "Operating in the supernatural teaches us "
            + "to remain strong in faith, depend on God's "
            + "promises and continue trusting Him even "
            + "when circumstances are difficult.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Ephesians 6:10; 2 Corinthians 12:9",
            15, DARK_TEXT, false);

    addText("5. To Be Effective Witnesses for Christ",
            19, PURPLE, true);

    addText(
            "Our Christian lives should point people towards "
            + "Jesus. God empowers His children to serve, "
            + "show His love and bear witness to the truth "
            + "of the Gospel.\n\n"
            + "We need His help to live out our faith "
            + "and represent Christ faithfully wherever "
            + "we find ourselves.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Acts 1:8; Matthew 5:14–16",
            15, DARK_TEXT, false);

    addText("How This Should Reflect in My Life",
            19, PURPLE, true);

    addText(
            "• Depend on God when facing situations beyond "
            + "your ability.\n"
            + "• Seek His direction before making important "
            + "decisions.\n"
            + "• Build your faith through His Word.\n"
            + "• Remain prayerful during difficult seasons.\n"
            + "• Allow your life to reflect the character "
            + "and teachings of Christ.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Am I depending on God in my daily decisions, "
            + "challenges and responsibilities, or am I "
            + "trying to handle everything through "
            + "my own strength?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Father, help me to depend on Your power "
            + "and wisdom in every area of my life. "
            + "Teach me to trust You beyond my limitations, "
            + "follow Your direction and fulfil Your purpose "
            + "for my life. Let my life bring glory to You. Amen.",
            16, DARK_TEXT, false
    );
        }
    private void showMarchWeekFour() {
    addText("How to Walk in the Supernatural",
            22, PURPLE, true);

    addText("Main Scripture: John 3:3–8",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Understanding the supernatural and recognising "
            + "the spiritual atmospheres that grant access to it "
            + "are important, but we must also understand how "
            + "to walk in this dimension of life.\n\n"
            + "Walking in the supernatural involves living "
            + "in a relationship with God, depending on His Word "
            + "and allowing our faith to influence our words "
            + "and actions.",
            16, DARK_TEXT, false
    );

    addText("1. Be Born Again and Speak in Tongues",
            19, PURPLE, true);

    addText(
            "The foundation of walking in the supernatural "
            + "begins with the new birth. Jesus explained in "
            + "John 3:3–8 that a person must be born again "
            + "to enter the kingdom of God.\n\n"
            + "Being born again introduces us to a new life "
            + "in Christ. Speaking in tongues is also identified "
            + "in this teaching as part of the believer's "
            + "spiritual life and expression of faith.",
            16, DARK_TEXT, false
    );

    addText("Scripture: John 3:3–8",
            15, DARK_TEXT, false);

    addText("2. Read, Study and Believe the Word of God",
            19, PURPLE, true);

    addText(
            "To walk in the supernatural, we must give "
            + "ourselves to the Word of God. It is not enough "
            + "to own a Bible or occasionally read a passage. "
            + "We must study it, understand it and believe "
            + "what it teaches.\n\n"
            + "The Word of God builds our faith and provides "
            + "the foundation for our confidence in His promises. "
            + "The more we understand His Word, the better "
            + "equipped we become to live according to it.",
            16, DARK_TEXT, false
    );

    addText("Scripture: 2 Timothy 2:15",
            15, DARK_TEXT, false);

    addText("3. Act and Say What the Word of God Says",
            19, PURPLE, true);

    addText(
            "Walking in the supernatural requires agreement "
            + "with God's Word in both speech and conduct. "
            + "We should not only believe the Word in our hearts "
            + "but also allow it to guide the way we speak "
            + "and behave.\n\n"
            + "When our actions agree with what we believe, "
            + "our faith becomes visible in our daily lives. "
            + "We must therefore learn to respond to situations "
            + "with confidence in God's truth rather than "
            + "allowing fear and discouragement to control us.",
            16, DARK_TEXT, false
    );

    addText("Faith Talk",
            19, PURPLE, true);

    addText(
            "• I will always put the Word in my mouth.\n"
            + "• Say daily: God bless you.",
            16, DARK_TEXT, false
    );

    addText("4. Maintain a Lifestyle of Faith",
            19, PURPLE, true);

    addText(
            "Faith should not be something we practise only "
            + "when we attend church or face difficult situations. "
            + "It should become part of our daily walk with God.\n\n"
            + "As we continue to read, believe, speak and act "
            + "according to God's Word, we develop consistency "
            + "in our walk of faith.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Maintain your relationship with Jesus Christ.\n"
            + "• Give time to reading and studying Scripture.\n"
            + "• Believe God's Word and put it into practice.\n"
            + "• Be intentional about the words you speak.\n"
            + "• Let your daily conduct reflect your faith.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Am I allowing God's Word to influence my thoughts, "
            + "speech and actions, or do I only listen to it "
            + "without practising it?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Father, help me to walk in the life You have "
            + "called me to live through Christ. Give me "
            + "a hunger for Your Word, strengthen my faith "
            + "and teach me to speak and act according "
            + "to Your truth. Let my life continually reflect "
            + "Your power and glory. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showAprilWeekOne() {
    addText("Understanding Prayer: Our Hotline to God",
            22, PURPLE, true);

    addText("Main Scripture: Isaiah 58:6–8",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Prayer is one of the most important parts of "
            + "our relationship with God. It is our means "
            + "of communicating with our Heavenly Father, "
            + "sharing our hearts with Him and seeking His "
            + "direction, help and intervention.\n\n"
            + "Think of a hotline as a line established for "
            + "communication. In the same way, prayer gives "
            + "believers the opportunity to communicate "
            + "with God continually. It is not something "
            + "reserved only for emergencies; it is a "
            + "relationship we maintain every day.",
            16, DARK_TEXT, false
    );

    addText("What Is Prayer?",
            19, PURPLE, true);

    addText(
            "Prayer is primarily communication with our "
            + "Heavenly Father. It is how we express our "
            + "gratitude, present our requests, seek His "
            + "guidance and develop fellowship with Him.\n\n"
            + "Prayer is more than presenting a list of "
            + "needs. It also involves listening, trusting "
            + "and aligning our hearts with God's will.",
            16, DARK_TEXT, false
    );

    addText("1. Prayer Is Our Means of Communicating with God",
            18, PURPLE, true);

    addText(
            "Communication helps build and maintain a "
            + "relationship. Through prayer, we draw near "
            + "to God and express what is in our hearts. "
            + "We can speak to Him about our needs, "
            + "challenges, decisions and thanksgiving.\n\n"
            + "A consistent prayer life helps us remain "
            + "conscious of God's presence instead of "
            + "turning to Him only when problems arise.",
            16, DARK_TEXT, false
    );

    addText("2. Prayer and Fasting Help Us Seek God",
            18, PURPLE, true);

    addText(
            "Prayer and fasting are important spiritual "
            + "practices. Isaiah 58:6–8 connects the right "
            + "kind of fasting with freedom, the breaking "
            + "of oppressive burdens and caring for others.\n\n"
            + "Fasting should not be treated as a way to "
            + "force God to act. It should accompany a "
            + "sincere desire to seek Him and live according "
            + "to His ways.",
            16, DARK_TEXT, false
    );

    addText("3. Prayer Makes Room for Divine Intervention",
            18, PURPLE, true);

    addText(
            "Prayer brings our situations before God. "
            + "It is an expression of dependence on Him "
            + "and trust in His ability to help us.\n\n"
            + "Prayer does not mean that everything will "
            + "happen exactly when or how we expect. "
            + "Rather, it keeps us dependent on God as "
            + "we trust His wisdom and timing.",
            16, DARK_TEXT, false
    );

    addText("4. Prayer Helps Us Receive Understanding "
            + "and Direction",
            18, PURPLE, true);

    addText(
            "As we spend time with God, we can seek "
            + "understanding concerning His Word and "
            + "direction for our lives. Prayer should "
            + "therefore be accompanied by a willingness "
            + "to listen and obey what God teaches us.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Make personal prayer a regular part of "
            + "your daily life.\n"
            + "• Approach God sincerely and honestly.\n"
            + "• Include thanksgiving, requests and time "
            + "to seek His direction.\n"
            + "• Let your prayer life influence your "
            + "attitude and conduct.\n"
            + "• When fasting, do so with the right "
            + "heart and purpose.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Is prayer a regular part of my relationship "
            + "with God, or do I remember to pray only "
            + "when I need something?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, help me develop a consistent "
            + "and sincere prayer life. Teach me to seek "
            + "You beyond my needs, to trust Your wisdom "
            + "and to remain sensitive to Your direction. "
            + "Let my relationship with You grow stronger "
            + "every day. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showAprilWeekTwo() {
    addText("Getting Ready to Pray and Write",
            22, PURPLE, true);

    addText("Main Scripture: Mark 10:36",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Prayer is an important part of our relationship "
            + "with God, but we should not approach it carelessly. "
            + "Preparation helps us become focused, sincere "
            + "and intentional when we come before Him.\n\n"
            + "Getting ready to pray involves preparing our "
            + "hearts, examining our motives, exercising faith "
            + "and understanding what we are bringing before "
            + "God. It also involves preparing to write down "
            + "important lessons and instructions from His Word.",
            16, DARK_TEXT, false
    );

    addText("1. Prepare Your Heart",
            19, PURPLE, true);

    addText(
            "Before praying, take time to examine the condition "
            + "of your heart. Prayer should come from a sincere "
            + "desire to communicate with God, not merely from "
            + "a desire to perform a religious activity.\n\n"
            + "A prepared heart is willing to seek God, receive "
            + "His instruction and respond to what He reveals "
            + "through His Word.",
            16, DARK_TEXT, false
    );

    addText("2. Consecration",
            19, PURPLE, true);

    addText(
            "Consecration means setting yourself apart for "
            + "God. It involves making room for Him and "
            + "being intentional about your spiritual life.\n\n"
            + "When we prepare ourselves through consecration, "
            + "we approach prayer with greater seriousness "
            + "and a willingness to honour God.",
            16, DARK_TEXT, false
    );

    addText("3. Forgiveness",
            19, PURPLE, true);

    addText(
            "Forgiveness is an important part of preparing "
            + "our hearts for prayer. We should be willing "
            + "to forgive those who have offended us and "
            + "also seek God's forgiveness when we have "
            + "done wrong.\n\n"
            + "Holding on to bitterness can affect our "
            + "relationships with others and our spiritual "
            + "attitude. We should therefore approach God "
            + "with humble and forgiving hearts.",
            16, DARK_TEXT, false
    );

    addText("4. Have the Right Motive",
            19, PURPLE, true);

    addText(
            "Our reasons for praying matter. Prayer should "
            + "not be driven by selfish ambition, pride "
            + "or a desire to impress other people.\n\n"
            + "We should seek God because we desire a genuine "
            + "relationship with Him and want our lives "
            + "to agree with His will.",
            16, DARK_TEXT, false
    );

    addText("5. Have Faith",
            19, PURPLE, true);

    addText(
            "Faith is important when we approach God in prayer. "
            + "We should pray with confidence in His ability "
            + "and trustworthiness, rather than allowing "
            + "doubt to control our hearts.\n\n"
            + "Faith does not mean that we dictate how God "
            + "must answer. It means that we trust Him "
            + "even while we wait for His response.",
            16, DARK_TEXT, false
    );

    addText("6. Know What You Want",
            19, PURPLE, true);

    addText(
            "Before you begin praying, take time to understand "
            + "what you are asking God for. Be specific "
            + "and intentional about the matters you want "
            + "to bring before Him.\n\n"
            + "Knowing what you want helps you pray with "
            + "focus. It also helps you recognise the areas "
            + "where you need God's wisdom, help and direction.",
            16, DARK_TEXT, false
    );

    addText("7. Search the Scriptures",
            19, PURPLE, true);

    addText(
            "Preparation for prayer should include searching "
            + "the Word of God. Scripture helps us understand "
            + "God's character, His promises and His will.\n\n"
            + "Rather than praying without understanding, "
            + "look into the Bible for guidance concerning "
            + "the matters you are bringing before God.",
            16, DARK_TEXT, false
    );

    addText("8. Write Out Key Points from the Bible",
            19, PURPLE, true);

    addText(
            "Writing is a useful way to preserve what you "
            + "learn during Bible study and prayer. Write "
            + "down important Scriptures, key points, "
            + "questions and instructions that stand out "
            + "to you.\n\n"
            + "These notes can help you remember what you "
            + "have studied, reflect on it later and put "
            + "what you learn into practice.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "Before your next prayer session:\n"
            + "• Prepare your heart and set time apart for God.\n"
            + "• Examine your motives and be willing to forgive.\n"
            + "• Identify the matters you want to pray about.\n"
            + "• Search the Scriptures for understanding.\n"
            + "• Write down important points from your study.\n"
            + "• Pray with faith and trust in God.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Do I prepare my heart and understand what "
            + "I am bringing before God, or do I approach "
            + "prayer without focus or preparation?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, prepare my heart to seek You "
            + "sincerely. Help me to walk in forgiveness, "
            + "maintain the right motives and grow in faith. "
            + "Give me understanding as I study Your Word "
            + "and help me remember and practise what "
            + "You teach me. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showAprilWeekThree() {
    addText("The Dominion Power of a Praying and Fasting Believer",
            22, PURPLE, true);

    addText("Main Scripture: Matthew 17:1–5, 19–21",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Prayer is not meant to be an occasional activity "
            + "in the life of a believer. It is an important "
            + "part of spiritual growth, empowerment and "
            + "fellowship with God.\n\n"
            + "A teenager who continually and consistently "
            + "engages in a lifestyle of prayer and seeking "
            + "God is developing a strong spiritual foundation. "
            + "Such a life is not controlled by age or outward "
            + "limitations, but is built on dependence on God.",
            16, DARK_TEXT, false
    );

    addText("Who Is a Praying and Fasting Believer ?",
            19, PURPLE, true);

    addText(
            "A praying and fasting believer is one who "
            + "is intentional about maintaining a lifestyle "
            + "of seeking God. Prayer becomes a regular part "
            + "of their relationship with Him rather than "
            + "something done only when difficulties arise.\n\n"
            + "This kind of believer desires spiritual growth, "
            + "takes God's Word seriously and makes room "
            + "for fellowship with Him.",
            16, DARK_TEXT, false
    );

    addText("Why Do We Pray and Fast for Empowerment?",
            19, PURPLE, true);

    addText("1. To Gain Command and Authority as Sons of God",
            18, PURPLE, true);

    addText(
            "Prayer helps believers depend on God's power "
            + "rather than relying only on human strength. "
            + "Matthew 17:19–21 records the disciples asking "
            + "Jesus why they could not cast out a particular "
            + "demon. Jesus addressed their lack of faith "
            + "and taught them about the importance of faith "
            + "and prayer.\n\n"
            + "Spiritual authority is not about controlling "
            + "people or showing superiority. It is about "
            + "living under God's authority and depending "
            + "on Him to fulfil His purpose.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Matthew 17:19–21",
            15, DARK_TEXT, false);

    addText("2. To Access Our Inheritance in Christ",
            18, PURPLE, true);

    addText(
            "God has given believers an inheritance through "
            + "their relationship with Christ. Prayer helps "
            + "us grow in our understanding of what God "
            + "has made available to us and how to live "
            + "according to His promises.\n\n"
            + "We should not approach prayer as a way of "
            + "earning God's love or forcing Him to give "
            + "us something. We pray because we belong "
            + "to Him and depend on His grace.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Deuteronomy 2:24",
            15, DARK_TEXT, false);

    addText("How to Gain Power for Dominion",
            19, PURPLE, true);

    addText("1. Be Born Again",
            18, PURPLE, true);

    addText(
            "The foundation of a believer's spiritual life "
            + "is a genuine relationship with Jesus Christ. "
            + "Being born again means receiving new life "
            + "through faith in Him.\n\n"
            + "Before focusing on spiritual power, we must "
            + "first establish our lives in Christ and allow "
            + "Him to shape our character and conduct.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Acts 2:38",
            15, DARK_TEXT, false);

    addText("2. Schedule Personal Prayer Time",
            18, PURPLE, true);

    addText(
            "Consistency is important in developing a "
            + "prayer life. Scheduling personal prayer time "
            + "helps us become intentional about spending "
            + "time with God.\n\n"
            + "Jesus Himself made time to pray, even when "
            + "there were many demands on His attention. "
            + "This teaches us not to allow our daily "
            + "activities to completely displace our "
            + "fellowship with God.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Mark 1:35",
            15, DARK_TEXT, false);

    addText("3. Avoid Sin and Ungodly Relationships",
            18, PURPLE, true);

    addText(
            "A life of prayer should also be accompanied "
            + "by a life that honours God. We must be "
            + "intentional about the choices we make, "
            + "the influences we accept and the relationships "
            + "we maintain.\n\n"
            + "Avoiding ungodly influences does not mean "
            + "treating people with hatred or disrespect. "
            + "It means maintaining godly values and "
            + "choosing relationships that do not lead "
            + "us away from our faith.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Proverbs 28:19",
            15, DARK_TEXT, false);

    addText("The Importance of Prayer and Fasting",
            19, PURPLE, true);

    addText(
            "Prayer and fasting are presented in Scripture "
            + "as spiritual practices that help believers "
            + "seek God with focus and sincerity. They "
            + "should not become performances or methods "
            + "of forcing God to respond.\n\n"
            + "Fasting should always be approached wisely "
            + " You should not undertake food restriction "
            + "without guidance from God or a trusted "
            + "health professional. Prayer, Bible study "
            + "and setting aside distractions are also "
            + "meaningful ways to focus on God.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Build a consistent personal prayer routine.\n"
            + "• Make time to study and understand God's Word.\n"
            + "• Examine your choices and relationships.\n"
            + "• Depend on God rather than your own strength.\n"
            + "• Seek spiritual growth with sincerity and humility.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Am I developing a consistent relationship "
            + "with God through prayer, and do my daily "
            + "choices reflect the faith I profess?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, help me grow in my relationship "
            + "with You. Give me the discipline to seek You "
            + "consistently, the wisdom to make godly choices "
            + "and the faith to depend on Your power. Help "
            + "me understand my inheritance in Christ and "
            + "live a life that brings glory to Your name. Amen.",
            16, DARK_TEXT, false
    );
        }
    private void showAprilWeekFour() {
    addText("Prayer and Fasting: The Lifeline of Every Growing Church",
            22, PURPLE, true);

    addText("Main Scripture: Luke 11:9",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Prayer and fasting are important to the spiritual "
            + "life of a believer and the growth of the Church. "
            + "Just as a lifeline supports something that "
            + "depends on it, prayer sustains our fellowship "
            + "with God and keeps us dependent on Him.\n\n"
            + "A growing church needs more than activities "
            + "and programmes. It needs believers who seek "
            + "God sincerely, depend on His power and desire "
            + "to understand His Word. Prayer and fasting "
            + "help create room for this spiritual growth.",
            16, DARK_TEXT, false
    );

    addText("1. Prayer Is a Divine Licence for Divine Intervention",
            19, PURPLE, true);

    addText(
            "Prayer is an opportunity God has given us "
            + "to bring our needs and situations before Him. "
            + "Through prayer, we acknowledge that human "
            + "strength is limited and that we need God's "
            + "wisdom, help and intervention.\n\n"
            + "When we pray, we are not forcing God to act. "
            + "We are expressing our dependence on Him "
            + "and trusting His power, wisdom and timing.",
            16, DARK_TEXT, false
    );

    addText("2. Prayer Guarantees Access to Our Inheritance",
            19, PURPLE, true);

    addText(
            "Through Jesus Christ, believers receive an "
            + "inheritance that comes from God's grace. "
            + "Prayer helps us draw near to God and grow "
            + "in our understanding of the life and promises "
            + "we have received through Christ.\n\n"
            + "We do not earn this inheritance through "
            + "prayer or fasting. It is God's gift, received "
            + "through grace. Prayer helps us live in "
            + "relationship with the One who has given it.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Ephesians 2:8",
            15, DARK_TEXT, false);

    addText("3. Pray for Revelation of God's Word",
            19, PURPLE, true);

    addText(
            "It is possible to read the Bible without "
            + "understanding the full meaning or significance "
            + "of what we are reading. This is why we should "
            + "also pray for understanding and insight "
            + "as we study Scripture.\n\n"
            + "Prayer helps us approach God's Word with "
            + "a teachable heart. We should desire not only "
            + "to read it but also to understand it, believe "
            + "it and put it into practice.",
            16, DARK_TEXT, false
    );

    addText("Scripture: John 6:68",
            15, DARK_TEXT, false);

    addText("4. Prayer and Fasting Enhance Spiritual Refreshment",
            19, PURPLE, true);

    addText(
            "Spiritual refreshment involves being renewed "
            + "in our relationship with God. Prayer and "
            + "fasting can help believers set aside "
            + "distractions and focus more intentionally "
            + "on seeking Him.\n\n"
            + "As we spend time with God, study His Word "
            + "and bring our hearts before Him, we are "
            + "reminded of His faithfulness and encouraged "
            + "to continue growing in our faith.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Acts 3:19",
            15, DARK_TEXT, false
    );

    addText("The Importance of Prayer in a Growing Church",
            19, PURPLE, true);

    addText(
            "A church grows spiritually when its members "
            + "learn to seek God, depend on His Word "
            + "and live out their faith. Prayer should "
            + "therefore be part of both personal devotion "
            + "and the shared life of the church.\n\n"
            + "When believers pray together with sincerity "
            + "and unity, they encourage one another "
            + "and strengthen their commitment to God's "
            + "purpose.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Make prayer a consistent part of your life.\n"
            + "• Pray for God's help and direction.\n"
            + "• Ask for understanding when studying Scripture.\n"
            + "• Participate sincerely in corporate prayer.\n"
            + "• Make time to seek God without unnecessary "
            + "distractions.\n"
            + "• Approach fasting wisely and with appropriate "
            + "guidance; prayer and Bible study can also "
            + "be practised without restricting food.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Does prayer occupy an important place in "
            + "my personal walk with God, and am I "
            + "contributing to the spiritual growth "
            + "of my church through sincere prayer?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, help me develop a consistent "
            + "and sincere prayer life. Give me understanding "
            + "of Your Word, renew my heart and teach me "
            + "to depend on You in every situation. Help "
            + "Your Church grow in unity, faith and devotion "
            + "to You. May our lives continually honour "
            + "Your name. Amen.",
            16, DARK_TEXT, false
    );
        }
    private void showMayWeekOne() {
    addText("Understanding the Word of God",
            22, PURPLE, true);

    addText("Main Scripture: Hebrews 4:12",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "The Word of God is central to the life of every "
            + "believer. It reveals God's nature, His instructions "
            + "and His purpose for humanity. It is not merely "
            + "a collection of written words; it is God's truth "
            + "given to guide, teach and transform our lives.\n\n"
            + "To grow spiritually, we must learn to value "
            + "the Word, study it and allow it to influence "
            + "our thoughts, decisions and conduct.",
            16, DARK_TEXT, false
    );

    addText("What Is the Word of God?",
            19, PURPLE, true);

    addText(
            "The Word of God is God's revealed truth. "
            + "It communicates His will, His promises "
            + "and His instructions to us. The Bible "
            + "is the written Word through which we "
            + "learn about God and His dealings with people.\n\n"
            + "The Word gives us a foundation for faith "
            + "and helps us distinguish truth from error.",
            16, DARK_TEXT, false
    );

    addText("The Word of God Is:",
            19, PURPLE, true);

    addText("1. Power",
            18, PURPLE, true);

    addText(
            "God's Word carries His power to accomplish "
            + "His purposes. When God speaks, His Word "
            + "is not empty or powerless.",
            16, DARK_TEXT, false
    );

    addText("2. A Hammer",
            18, PURPLE, true);

    addText(
            "The Word of God is compared to a hammer "
            + "that breaks a rock in pieces. This shows "
            + "its power to confront and break down "
            + "what stands against God's truth.",
            16, DARK_TEXT, false
    );

    addText("3. A Two-Edged Sword",
            18, PURPLE, true);

    addText(
            "God's Word is living and powerful, sharper "
            + "than any two-edged sword. It reaches "
            + "the heart and reveals our thoughts "
            + "and intentions.",
            16, DARK_TEXT, false
    );

    addText("4. Light",
            18, PURPLE, true);

    addText(
            "The Word gives direction and understanding. "
            + "Like a light, it helps us see the right "
            + "path and avoid walking in darkness.",
            16, DARK_TEXT, false
    );

    addText("5. Water",
            18, PURPLE, true);

    addText(
            "Water cleanses and refreshes. In the same "
            + "way, God's Word works in our lives, "
            + "bringing cleansing and spiritual renewal.",
            16, DARK_TEXT, false
    );

    addText("6. Fire",
            18, PURPLE, true);

    addText(
            "The Word is also compared to fire. "
            + "It can expose what is false and challenge "
            + "what does not agree with God's truth.",
            16, DARK_TEXT, false
    );

    addText("7. The Bible",
            18, PURPLE, true);

    addText(
            "The Bible is the written Word of God "
            + "and the foundation for our study. "
            + "Through it, we learn God's instructions "
            + "and discover how to live according "
            + "to His will.",
            16, DARK_TEXT, false
    );

    addText("What Does the Word of God Do?",
            19, PURPLE, true);

    addText(
            "• It gives victory.\n"
            + "• It gives divine health.\n"
            + "• It protects.\n"
            + "• It provides.\n"
            + "• It shows us the way.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Read the Bible consistently.\n"
            + "• Study passages carefully instead of reading "
            + "without understanding.\n"
            + "• Write down important lessons and Scriptures.\n"
            + "• Believe God's truth and apply it to daily life.\n"
            + "• Allow the Word to guide your decisions "
            + "and conduct.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "How much value do I place on God's Word? "
            + "Am I allowing it to guide my thoughts, "
            + "decisions and everyday life?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, give me a genuine hunger "
            + "for Your Word. Help me to study it with "
            + "understanding, believe its truth and apply "
            + "it in my daily life. Let Your Word guide "
            + "my decisions and transform my character. "
            + "Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showMayWeekTwo() {
    addText("How the Word of God Works in Our Lives",
            22, PURPLE, true);

    addText("Main Scripture: Hebrews 4:12",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "The Word of God is not meant to be read and "
            + "forgotten. It is living and powerful, and "
            + "it works in the lives of those who receive "
            + "it with faith and allow it to guide them.\n\n"
            + "Understanding how God's Word works helps "
            + "us recognise why we must study it, believe "
            + "it and apply it. Its influence reaches "
            + "our faith, our understanding and the way "
            + "we live.",
            16, DARK_TEXT, false
    );

    addText("1. Discover the Word Before You Recover",
            19, PURPLE, true);

    addText(
            "Before we can stand on what God has said, "
            + "we must first discover what His Word teaches. "
            + "We cannot confidently apply a promise "
            + "we have never taken time to understand.\n\n"
            + "This is why studying Scripture is important. "
            + "As we discover God's truth, we learn what "
            + "He has made available to us and how to "
            + "respond to life's situations with faith.\n\n"
            + "The Word should not be treated as a collection "
            + "of words we repeat without understanding. "
            + "We must know what it says and allow that "
            + "truth to shape our confidence in God.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Matthew 8:17",
            15, DARK_TEXT, false);

    addText("2. The Word of God Quickens Our Mortal Bodies",
            19, PURPLE, true);

    addText(
            "The Word of God brings life and strengthens "
            + "our hope in Him. Isaiah 58:8 speaks of "
            + "light breaking forth and health springing "
            + "forth speedily.\n\n"
            + "This reminds us that God cares about the "
            + "whole person. His Word encourages us to "
            + "trust Him, seek His help and live according "
            + "to His instructions.\n\n"
            + "We should receive this truth with faith "
            + "without treating it as a promise that "
            + "believers will never experience sickness "
            + "or physical difficulty.",
            16, DARK_TEXT, false
    );

    addText("Scripture: Isaiah 58:8",
            15, DARK_TEXT, false);

    addText("3. The Word of God Transmits Divine Nature",
            19, PURPLE, true);

    addText(
            "God's Word reveals His nature and introduces "
            + "us to His character. John 1:1–5 presents "
            + "Jesus Christ as the Word, describing Him "
            + "as the source of life and the light of men.\n\n"
            + "As we receive and follow God's Word, "
            + "we learn to reflect His character. "
            + "Our thoughts, attitudes and conduct "
            + "should increasingly agree with the truth "
            + "we have received.",
            16, DARK_TEXT, false
    );

    addText("Scripture: John 1:1–5",
            15, DARK_TEXT, false);

    addText("4. The Word Produces Transformation",
            19, PURPLE, true);

    addText(
            "The Word of God does not only give us "
            + "information; it calls us to transformation. "
            + "When we study it, believe it and obey it, "
            + "it influences the way we think and live.\n\n"
            + "This transformation is seen in our choices, "
            + "our character and our response to others. "
            + "The goal is not simply to know more Scripture, "
            + "but to become people whose lives reflect "
            + "what God has taught us.",
            16, DARK_TEXT, false
    );

    addText("Practical Application",
            19, PURPLE, true);

    addText(
            "• Search the Scriptures to understand God's promises.\n"
            + "• Do not repeat Bible verses without understanding them.\n"
            + "• Receive God's Word with faith and wisdom.\n"
            + "• Allow Scripture to influence your choices and conduct.\n"
            + "• Put what you learn into practice.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Am I discovering and understanding God's Word, "
            + "or am I only hearing it without allowing "
            + "it to influence my life?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, give me understanding of Your "
            + "Word. Help me discover Your truth, receive "
            + "it with faith and allow it to transform "
            + "my life. May my thoughts, decisions and "
            + "conduct reflect Your character. Amen.",
            16, DARK_TEXT, false
    );
        }
    private void showMayWeekThree() {
    addText("Hindrances to the Study of the Word of God",
            22, PURPLE, true);

    addText("Main Scripture: Psalm 119:11",
            17, DARK_TEXT, true);

    addText("Introduction",
            19, PURPLE, true);

    addText(
            "Studying the Word of God is essential for "
            + "spiritual growth. Through Scripture, we "
            + "receive understanding, direction and "
            + "instruction for our daily lives.\n\n"
            + "However, there are things that can prevent "
            + "us from giving God's Word the attention "
            + "it deserves. Some affect our spiritual "
            + "condition, while others affect our discipline "
            + "and ability to concentrate. Recognising "
            + "these hindrances helps us deal with them "
            + "and become more intentional about studying "
            + "the Bible.",
            16, DARK_TEXT, false
    );

    addText("1. Sin",
            19, PURPLE, true);

    addText(
            "Sin can affect our relationship with God "
            + "and our attitude towards His Word. When "
            + "we knowingly hold on to wrongdoing, "
            + "we may become unwilling to accept the "
            + "correction and instruction Scripture gives.\n\n"
            + "God's Word exposes what is wrong and "
            + "shows us the way to live rightly. Instead "
            + "of avoiding Scripture when it corrects us, "
            + "we should respond with humility, repentance "
            + "and a willingness to change.",
            16, DARK_TEXT, false
    );

    addText("2. Distraction",
            19, PURPLE, true);

    addText(
            "Distraction occurs when other things "
            + "continually compete for our attention "
            + "and prevent us from concentrating on "
            + "the Word of God.\n\n"
            + "Phones, entertainment, unnecessary "
            + "conversations and excessive activities "
            + "can take time away from Bible study. "
            + "We must therefore learn to create a "
            + "quiet and suitable time for reading "
            + "and understanding Scripture.",
            16, DARK_TEXT, false
    );

    addText("3. Slothfulness",
            19, PURPLE, true);

    addText(
            "Slothfulness means laziness or an unwillingness "
            + "to make the necessary effort. A person may "
            + "desire spiritual growth but fail to develop "
            + "the discipline required to study God's Word "
            + "consistently.\n\n"
            + "We should not depend only on moments "
            + "when we feel motivated. Building a regular "
            + "Bible-study habit requires commitment, "
            + "discipline and deliberate effort.",
            16, DARK_TEXT, false
    );

    addText("4. Restlessness of Mind",
            19, PURPLE, true);

    addText(
            "A restless mind struggles to remain focused. "
            + "Even when we open the Bible, worries, "
            + "unsettled thoughts and concerns may "
            + "continually interrupt our concentration.\n\n"
            + "We can deal with this by setting aside "
            + "a suitable time, reducing unnecessary "
            + "distractions and approaching Bible study "
            + "calmly. We should also bring our concerns "
            + "before God in prayer and ask Him for "
            + "understanding.",
            16, DARK_TEXT, false
    );

    addText("How to Overcome These Hindrances",
            19, PURPLE, true);

    addText(
            "• Deal honestly with sin through repentance "
            + "and obedience to God's Word.\n"
            + "• Set aside distractions during Bible study.\n"
            + "• Develop discipline and consistency.\n"
            + "• Choose a suitable time and place to study.\n"
            + "• Pray for understanding and a focused mind.\n"
            + "• Put into practice what you learn.",
            15, DARK_TEXT, false
    );

    addText("Personal Reflection",
            19, PURPLE, true);

    addText(
            "Which of these four hindrances most often "
            + "affects my personal study of God's Word, "
            + "and what practical step can I take "
            + "to overcome it?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Heavenly Father, help me remove every "
            + "hindrance that prevents me from studying "
            + "Your Word. Give me a sincere heart, "
            + "discipline, concentration and a desire "
            + "to understand Scripture. Help me not "
            + "only to read Your Word but also to obey "
            + "and practise it. Amen.",
            16, DARK_TEXT, false
    );
    }
    private void showMayWeekFour() {
    addText("The Word of God and the Development of Christian Character",
            22, Color.BLACK, true);

    addText("Main Scriptures: 2 Timothy 3:16–17; Matthew 5:13–16",
            16, Color.DKGRAY, true);

    addText(
            "Christian character is the ability to behave like Jesus Christ. "
            + "Developing this character requires more than knowing the Word "
            + "of God; we must allow the Word to teach us, correct us and "
            + "guide the way we live.",
            16, Color.BLACK, false
    );

    addText("1. The Word Teaches Us How to Live",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Learning the Character of Christ",
            "The Word of God reveals the nature, teachings and example of "
            + "Jesus Christ. As we study it, we learn how a Christian should "
            + "think, speak and behave."
    );

    addTeachingPoint(
            "The Word Corrects Our Behaviour",
            "According to 2 Timothy 3:16–17, Scripture is useful for teaching, "
            + "reproof, correction and instruction in righteousness. It shows "
            + "us what is wrong and guides us towards what is right."
    );

    addText("2. Developing Christian Character Through the Word",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Honesty",
            "The Word teaches us to speak truthfully and deal sincerely "
            + "with others. We develop honesty by putting these teachings "
            + "into practice in our daily lives."
    );

    addTeachingPoint(
            "Moral Excellence",
            "God's Word helps us recognise what is right and wrong. "
            + "As we obey its instructions, we learn to make choices "
            + "that honour God."
    );

    addTeachingPoint(
            "Purity",
            "The Word guides us towards a pure relationship with God "
            + "and sincere relationships with other people. We must allow "
            + "its teachings to influence our thoughts, intentions and actions."
    );

    addText("3. Let Your Character Reflect the Word",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Be a Doer of the Word",
            "It is not enough to hear or read the Word. We must practise "
            + "what it teaches. As we consistently obey God's Word, "
            + "our character begins to reflect what we have learned."
    );

    addTeachingPoint(
            "Become the Light of the World",
            "Matthew 5:13–16 teaches that believers are the salt of the earth "
            + "and the light of the world. When our character reflects Christ, "
            + "our lives become a testimony that can encourage others "
            + "to know Him."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "The Word of God is not meant to remain in our minds alone. "
            + "It must influence our character and daily conduct. "
            + "As we study, receive and obey the Word, we grow in "
            + "Christlikeness.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "Am I allowing God's Word to change the way I think, speak "
            + "and behave towards Him and other people?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, help me to receive Your Word and put it into "
            + "practice. Let it shape my thoughts, words and actions. "
            + "Help me grow in honesty, moral excellence and purity, "
            + "so that my life will reflect Jesus Christ. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showJuneWeekOne() {
    addText("Understanding Healing and Health",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "Healing and health are important parts of our understanding "
            + "of God's care for us. Before discussing how faith relates "
            + "to healing, we must first understand what healing means. "
            + "Healing is more than simply feeling better; it speaks of "
            + "being free from sickness and disease, and being restored "
            + "to wholeness and well-being.",
            16, Color.BLACK, false
    );

    addText("1. What Is Healing and Health?",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Healing Is Being Free from Sickness",
            "Healing means being delivered from sickness. When a person "
            + "is sick, the body is not functioning in the way it should. "
            + "Healing describes the restoration of health and freedom "
            + "from that sickness."
    );

    addTeachingPoint(
            "Healing Is Being Made Whole",
            "To be whole means to be restored to a state of well-being. "
            + "It describes more than a temporary feeling of relief; "
            + "it points to the restoration of the person from the effects "
            + "of sickness."
    );

    addTeachingPoint(
            "Healing Is Being Hale and Hearty",
            "To be hale and hearty means to be healthy, strong and well. "
            + "This helps us understand that healing is connected with "
            + "the restoration of health and the ability to live well."
    );

    addTeachingPoint(
            "Healing Comes from God",
            "God is the source of healing. When we consider healing, "
            + "we must recognise that our confidence is ultimately in Him. "
            + "We look to God as the one who cares for us and is able "
            + "to restore health."
    );

    addTeachingPoint(
            "Healing Is a Gift",
            " Healing is a gift. A gift is received, "
            + "not earned as a reward. This reminds us to approach God "
            + "with gratitude and to recognise His goodness."
    );

    addTeachingPoint(
            "Healing Is Freedom from Disease",
            "Disease is another form of sickness that affects the body. "
            + "Therefore, when we talk about healing, we are also talking "
            + "about freedom from disease and the restoration of health."
    );

    addText("2. How Does Faith Come Into Healing?",
            18, Color.BLACK, true);

    addText(
            "Having understood what healing means, the next question is: "
            + "how does faith relate to it? Let's identify faith for "
            + "salvation and faith for healing. This shows that faith is "
            + "not discussed only in connection with becoming a Christian; "
            + "it is also part of how a believer looks to God for healing.",
            16, Color.BLACK, false
    );

    addTeachingPoint(
            "Faith for Salvation",
            "Salvation begins with believing in Jesus Christ and trusting "
            + "in what He has done. Faith involves accepting God's provision "
            + "rather than depending on our own efforts. It is through "
            + "faith that we receive the salvation God offers."
    );

    addTeachingPoint(
            "Faith for Healing",
            "In the same way, when we seek God for healing, we exercise "
            + "faith by trusting in Him. We acknowledge Him as the source "
            + "of healing and bring our needs before Him with confidence. "
            + "Faith means relying on God rather than allowing fear to "
            + "become the foundation of our response."
    );

    addText("3. Understanding the God-Kind of Faith",
            18, Color.BLACK, true);

    addText(
            "The God-kind of faith is believing in "
            + "the heart and confessing with the mouth what one believes "
            + "in the heart. In other words, faith is not merely saying "
            + "something without believing it. It begins with genuine "
            + "belief within the heart, and that belief is expressed "
            + "through our words.",
            16, Color.BLACK, false
    );

    addTeachingPoint(
            "Believing in the Heart",
            "Faith begins with what we truly believe. It involves trusting "
            + "God and holding firmly to what we have received from His Word."
    );

    addTeachingPoint(
            "Confessing with the Mouth",
            "What we believe should also be reflected in what we say. "
            + "Our words should agree with the faith we profess, rather "
            + "than constantly speaking from fear and doubt."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "Healing means freedom from sickness and disease, restoration "
            + "to wholeness, and being hale and hearty. God is the source "
            + "of healing, and faith teaches us to trust Him. Our faith "
            + "should be genuine in the heart and reflected in our words.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "Do I understand what healing means? When I bring my needs "
            + "before God, am I trusting Him from my heart, and do my "
            + "words reflect that trust?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for being the source of healing. "
            + "Help me understand Your goodness and grow in genuine faith. "
            + "Teach me to trust You in my heart and let my words reflect "
            + "that trust. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showJuneWeekTwo() {
    addText("Jesus the Healer: Individuals He Healed and Miracles He Performed",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "During His earthly ministry, Jesus demonstrated His compassion "
            + "and power through many miracles. He healed the sick, restored "
            + "the weak, gave sight to the blind and even raised the dead. "
            + "These miracles revealed that Jesus was not indifferent to "
            + "human suffering. He showed mercy to individuals and brought "
            + "hope to people whose situations appeared impossible.",
            16, Color.BLACK, false
    );

    addText("1. Individuals Jesus Healed",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Peter's Mother-in-law",
            "In Matthew 8:14–15, Jesus entered Peter's house and saw "
            + "his mother-in-law lying sick with a fever. He touched her "
            + "hand, and the fever left her. She immediately got up "
            + "and ministered to Him. This account shows Jesus' concern "
            + "for people even in their personal and everyday struggles."
    );

    addTeachingPoint(
            "The Woman with the Issue of Blood",
            "Mark 5:25–34 tells us about a woman who had suffered from "
            + "an issue of blood for twelve years. She had endured much "
            + "and spent what she had seeking help, but her condition "
            + "continued. When she heard about Jesus, she came in faith "
            + "and touched His garment. She was healed. Jesus recognised "
            + "her and spoke to her with compassion, calling her daughter."
    );

    addTeachingPoint(
            "Jairus' Daughter",
            "In Mark 5:21–24, 35–43, Jairus came to Jesus because his "
            + "daughter was seriously ill. Before they arrived, news came "
            + "that the child had died. Jesus encouraged Jairus not to "
            + "fear but to believe. He went to the house and raised the "
            + "girl back to life. This miracle demonstrates His authority "
            + "even over death."
    );

    addTeachingPoint(
            "Blind Bartimaeus",
            "Mark 10:46–52 records the healing of blind Bartimaeus. "
            + "When he heard that Jesus was passing by, he cried out "
            + "for mercy. Although people tried to silence him, he "
            + "continued calling. Jesus stopped, called him and restored "
            + "his sight. Bartimaeus then followed Jesus along the way."
    );

    addTeachingPoint(
            "The Ten Lepers",
            "In Luke 17:11–19, ten lepers cried out to Jesus for mercy. "
            + "Jesus instructed them to go and show themselves to the "
            + "priests. As they went, they were cleansed. One of them "
            + "returned to give glory to God and thank Jesus. This account "
            + "teaches us not to receive God's goodness without expressing "
            + "gratitude."
    );

    addTeachingPoint(
            "Lazarus",
            "John 11:1–44 tells the story of Lazarus, who had been dead "
            + "for four days before Jesus arrived. Jesus went to the tomb "
            + "and called Lazarus out. Lazarus came out alive. This miracle "
            + "reveals Jesus' authority over death and His power to do "
            + "what human strength cannot accomplish."
    );

    addText("2. Miracles Jesus Performed",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Turning Water into Wine",
            "In John 2:1–11, Jesus attended a wedding in Cana where "
            + "the wine ran out. He instructed the servants to fill "
            + "waterpots with water, and the water became wine. "
            + "This was the beginning of His miracles and revealed "
            + "His glory to His disciples."
    );

    addTeachingPoint(
            "Raising the Dead",
            "Jesus demonstrated authority over death by raising people "
            + "back to life. Examples include Jairus' daughter "
            + "(Mark 5:35–43), the widow's son at Nain (Luke 7:11–17) "
            + "and Lazarus (John 11:1–44). These accounts reveal "
            + "that His power was not limited by what appeared impossible."
    );

    addTeachingPoint(
            "Healing the Sick",
            "Jesus healed people suffering from different sicknesses "
            + "and diseases. Matthew 4:23–24 describes how He went "
            + "throughout Galilee teaching, preaching and healing "
            + "all manner of sickness and disease among the people."
    );

    addTeachingPoint(
            "Making the Lame Walk",
            "In John 5:1–9, Jesus met a man who had been infirm for "
            + "thirty-eight years. Jesus told him to rise, take up "
            + "his bed and walk. The man was immediately made whole "
            + "and began to walk."
    );

    addTeachingPoint(
            "Making the Blind See",
            "John 9:1–7 records how Jesus restored the sight of a man "
            + "who had been blind from birth. Jesus instructed him "
            + "to wash in the pool of Siloam, and he returned seeing. "
            + "This miracle revealed the power of God at work through Jesus."
    );

    addTeachingPoint(
            "Healing the Woman with the Issue of Blood",
            "The healing of the woman with the issue of blood "
            + "(Mark 5:25–34) is another demonstration of Jesus' "
            + "healing power. Her long period of suffering ended "
            + "when she encountered Him."
    );

    addText("3. Lessons from the Healing Ministry of Jesus",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Jesus Is Compassionate",
            "Jesus did not ignore people because of their conditions "
            + "or circumstances. He showed mercy and responded to "
            + "those who came to Him."
    );

    addTeachingPoint(
            "Jesus Has Power over Sickness and Disease",
            "The different healings recorded in Scripture demonstrate "
            + "His authority over many forms of sickness and disease."
    );

    addTeachingPoint(
            "Jesus Has Authority over Death",
            "The raising of Jairus' daughter, the widow's son and "
            + "Lazarus shows that even death was not beyond His authority."
    );

    addTeachingPoint(
            "We Should Give God Glory",
            "When we recognise God's goodness in our lives, we should "
            + "respond with gratitude and give Him the glory, just as "
            + "the Samaritan leper returned to thank Jesus."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "The healing ministry of Jesus reveals His compassion, "
            + "love and authority. He cared for individuals, restored "
            + "those who were suffering and demonstrated the power "
            + "of God through His miracles.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "What do the healing miracles of Jesus teach me about "
            + "His compassion, power and concern for people?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for revealing Your power and "
            + "compassion through Jesus Christ. Help me to understand "
            + "His works, grow in faith and always give You glory "
            + "for Your goodness. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showJuneWeekThree() {
    addText("The Healing Power and Spiritual Significance of Anointing Oil",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "Anointing oil has an important place in the Bible. It was "
            + "used in different acts of consecration and ministry. "
            + "In the ministry of Jesus and His disciples, anointing "
            + "with oil was also associated with prayer for the sick. "
            + "However, the power to heal does not belong to the oil "
            + "itself; it belongs to God. Understanding this helps us "
            + "approach anointing with faith, reverence and the right "
            + "understanding of God's power.",
            16, Color.BLACK, false
    );

    addText("1. What Is in the Anointing Oil?",
            18, Color.BLACK, true);

    addTeachingPoint(
            "The Spirit of the Lord",
            "Luke 4:18 records Jesus declaring that the Spirit of the "
            + "Lord was upon Him because God had anointed Him to preach "
            + "the gospel, heal the brokenhearted, proclaim deliverance "
            + "and set the oppressed free. This shows that the anointing "
            + "is connected with the empowerment of the Holy Spirit "
            + "for God's purpose. The healing ministry of Jesus was "
            + "an expression of the Spirit's work through Him."
    );

    addTeachingPoint(
            "The Oil Represents the Power of God",
            "Oil is used in Scripture as a symbol of anointing and "
            + "consecration. Its spiritual significance points beyond "
            + "the physical substance to God, who is the source of "
            + "power. When oil is used during prayer for the sick, "
            + "our confidence must remain in God rather than in "
            + "the oil as an object."
    );

    addTeachingPoint(
            "A Seal of Exemption from Evil",
            "Ezekiel 9:4 describes a mark placed on the foreheads "
            + "of those who grieved over the evil taking place "
            + "in Jerusalem. The mark distinguished them from "
            + "those who faced judgment. This vision reminds us "
            + "that God knows those who belong to Him. It should "
            + "not be interpreted to mean that applying physical "
            + "oil guarantees freedom from every difficulty."
    );

    addTeachingPoint(
            "The Mystery of the Fan and the Fire",
            "Matthew 3:11–12 speaks about the One who would baptise "
            + "with the Holy Ghost and with fire. The passage then "
            + "describes a fan used to separate wheat from chaff. "
            + "The wheat is gathered while the chaff is burned. "
            + "This picture speaks of separation and judgment. "
            + "First Corinthians 6:19 reminds us that our bodies "
            + "are the temple of the Holy Ghost. Therefore, our "
            + "lives should honour God and reflect His presence."
    );

    addText("2. The Healing Power Associated with Anointing Oil",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Anointing and Prayer for the Sick",
            "James 5:14–15 teaches that when someone is sick, "
            + "the person should call for the elders of the church. "
            + "They are to pray over the sick person and anoint "
            + "them with oil in the name of the Lord. The passage "
            + "places the emphasis on prayer, faith and dependence "
            + "on God. It shows that anointing oil can accompany "
            + "prayer for healing."
    );

    addTeachingPoint(
            "The Disciples Anointed the Sick",
            "Mark 6:12–13 records how the disciples went out "
            + "preaching repentance. They cast out many devils "
            + "and anointed many that were sick with oil, "
            + "and healed them. This demonstrates that anointing "
            + "with oil was part of their ministry to people "
            + "who needed healing."
    );

    addTeachingPoint(
            "God Is the Source of Healing",
            "The physical oil is not a medicine or a magical "
            + "substance. God is the one we depend on for healing. "
            + "When anointing oil is used, it should direct our "
            + "attention towards Him and strengthen our expression "
            + "of faith through prayer."
    );

    addText("3. How to Apply the Anointing Oil",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Apply It on the Forehead",
            "Anointing the forehead may be practised as a symbolic "
            + "act of dedication and prayer. The significance "
            + "is in the faith and prayer directed towards God, "
            + "not in the physical act alone."
    );

    addTeachingPoint(
            "Set Aside a Portion for Anointing",
            "A portion of oil may be set aside for use during "
            + "prayer and anointing. Its use should remain "
            + "reverent and symbolic. The oil should not be "
            + "consumed as a healing treatment."
    );

    addTeachingPoint(
            "Anoint the Premises of Your Home or Business",
            "Some Christians use anointing oil when praying "
            + "over their homes or business premises as an act "
            + "of dedication to God. This should go together "
            + "with a commitment to live and work in ways "
            + "that honour Him."
    );

    addText("4. The Right Attitude Towards Anointing",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Have Faith in God",
            "Our confidence must be in God, not in the physical "
            + "oil. We should approach Him sincerely, trusting "
            + "His power, wisdom and goodness."
    );

    addTeachingPoint(
            "Pray with Understanding",
            "Anointing should not become an empty religious activity. "
            + "We should understand why we are praying and remember "
            + "that the Lord is the one we are calling upon."
    );

    addTeachingPoint(
            "Honour God with Your Body",
            "First Corinthians 6:19 teaches that our bodies are "
            + "the temple of the Holy Ghost. We should therefore "
            + "honour God through our choices, conduct and "
            + "care for our bodies."
    );

    addTeachingPoint(
            "Do Not Neglect Medical Care",
            "Prayer and anointing should not prevent anyone from "
            + "seeking appropriate medical attention. We can pray "
            + "and trust God while also receiving responsible "
            + "medical care."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "Anointing oil is associated with consecration and "
            + "prayer for the sick in Scripture. Its significance "
            + "points us towards God, who is the source of healing. "
            + "Our faith must remain in Him, and our lives should "
            + "reflect the presence and work of His Spirit.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "Is my confidence in God, or have I placed too much "
            + "confidence in the physical oil? Do I understand "
            + "the relationship between prayer, faith and healing?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for being the source "
            + "of healing and restoration. Help me understand "
            + "the significance of anointing and the work of "
            + "Your Holy Spirit. Teach me to pray with faith, "
            + "depend on You and honour You with my life. "
            + "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showJuneWeekFour() {
    addText("Understanding Our Heritage Over Sickness and Disease",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "As children of God, we need to understand what we have "
            + "received through our relationship with Jesus Christ. "
            + "Being born again gives us a new life and brings us into "
            + "a new relationship with God. Through redemption, our "
            + "identity and spiritual position are no longer defined "
            + "by the kingdom of darkness. We now belong to Christ. "
            + "Understanding this heritage helps us face sickness "
            + "and disease with faith, confidence and hope in God. "
            + "It does not mean that Christians can never become sick; "
            + "rather, it reminds us that sickness does not define "
            + "our identity in Christ.",
            16, Color.BLACK, false
    );

    addText("1. New Birth and Everlasting Life",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Understanding the New Birth",
            "John 3:16 explains God's love for the world and His gift "
            + "of His only begotten Son, so that whoever believes in "
            + "Him should not perish but have everlasting life. "
            + "This is the foundation of our new life in Christ. "
            + "Being born again means receiving a new spiritual life "
            + "through faith in Jesus. Our relationship with God is "
            + "no longer based on our former life but on what Christ "
            + "has done for us."
    );

    addTeachingPoint(
            "We Have Everlasting Life",
            "First John 3:2 reminds us that we are now the children "
            + "of God, even though the full reality of what we shall "
            + "be has not yet been revealed. This gives us confidence "
            + "in our identity and future in Christ. Everlasting life "
            + "is God's gift, and it gives us a hope that goes beyond "
            + "the temporary conditions we experience in this world."
    );

    addTeachingPoint(
            "Open Your Understanding to God's Word",
            "Psalm 119:18 is a prayer asking God to open our eyes "
            + "so that we may behold wonderful things from His law. "
            + "As we study God's Word, we should also ask Him to "
            + "help us understand what He has made available to us "
            + "through Christ. Knowing our heritage requires more "
            + "than hearing about it; we must understand and live "
            + "according to the truth of God's Word."
    );

    addText("2. Translation from Darkness into Light",
            18, Color.BLACK, true);

    addTeachingPoint(
            "A Change of Spiritual Kingdom",
            "Being born again brings about a change in our spiritual "
            + "identity. We are no longer meant to live according "
            + "to the ways of darkness. Through Christ, we receive "
            + "a new life and are called to walk in the light of God. "
            + "This change should be seen in our decisions, character "
            + "and daily conduct."
    );

    addTeachingPoint(
            "Jesus Gives Abundant Life",
            "John 10:10 contrasts the purpose of the thief, who comes "
            + "to steal, kill and destroy, with the purpose of Jesus, "
            + "who came so that we may have life and have it more "
            + "abundantly. Christ is the source of this life. "
            + "Therefore, we should not allow fear, sickness or "
            + "difficult circumstances to make us forget the hope "
            + "and life we have received in Him."
    );

    addTeachingPoint(
            "Live According to Your New Identity",
            "Our new identity should influence how we live. "
            + "We should turn away from sinful practices, grow "
            + "in the knowledge of God and allow His Word to guide "
            + "our choices. Living in the light means choosing "
            + "what pleases God and allowing our conduct to reflect "
            + "our relationship with Christ."
    );

    addText("3. Our Position Through Redemption",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Repositioned in Christ",
            "Through redemption, we have been given a new spiritual "
            + "position in Christ. Ephesians 2:6 says that God has "
            + "raised us up together and made us sit together in "
            + "heavenly places in Christ Jesus. This reveals the "
            + "spiritual position we have received through our "
            + "relationship with Him. We are no longer identified "
            + "with our former life; our identity is now found in "
            + "Christ."
    );

    addTeachingPoint(
            "Far Above Sickness and Disease",
            "Our position in Christ gives us a reason to face "
            + "sickness and disease with faith rather than fear. "
            + "We can pray, trust God's power and look to Him "
            + "for healing and strength. Sickness is not our "
            + "identity, and it does not cancel the life we have "
            + "received in Christ. Being seated with Christ in "
            + "heavenly places gives us a spiritual perspective "
            + "that is greater than the challenges we face."
    );

    addTeachingPoint(
            "Walk in the Reality of Your Heritage",
            "Knowing our position in Christ should affect our "
            + "daily lives. We should grow in God's Word, maintain "
            + "our faith, pray and continue to trust Him in every "
            + "situation. We should not allow sickness or difficult "
            + "circumstances to take away our confidence in God's "
            + "love and promises. We can seek prayer and appropriate "
            + "medical care while continuing to trust God."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "Through the new birth, we receive everlasting life "
            + "and a new identity in Christ. Redemption has given "
            + "us a new spiritual position: we are seated together "
            + "with Christ in heavenly places. Therefore, we can "
            + "face sickness and disease with faith, knowing that "
            + "our hope and identity are in Him. We must continue "
            + "to grow in the understanding of our heritage through "
            + "God's Word.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "Do I truly understand my new identity and position "
            + "in Christ? When I face sickness or difficult "
            + "circumstances, do I remember the life and hope "
            + "I have received through redemption?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for the gift of everlasting "
            + "life through Jesus Christ. Help me understand my "
            + "new identity and position in You. Open my eyes to "
            + "the truth of Your Word and strengthen my faith "
            + "when I face sickness or difficult situations. "
            + "Teach me to live according to the heritage I have "
            + "received through Christ. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showJulyWeekOne() {
    addText("Understanding Wisdom",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "Wisdom is an important part of living a purposeful "
            + "and successful life. It is not simply having knowledge "
            + "or knowing many things; it is knowing what to do "
            + "and applying that understanding in the right way. "
            + "A person may have knowledge but still make poor "
            + "decisions if that knowledge is not applied wisely. "
            + "Wisdom helps us think through situations, recognise "
            + "what is right and make decisions that agree with "
            + "God's purpose.",
            16, Color.BLACK, false
    );

    addText("1. Wisdom Is the Principal Thing",
            18, Color.BLACK, true);

    addTeachingPoint(
            "The Importance of Wisdom",
            "Proverbs 4:7 teaches that wisdom is the principal thing "
            + "and encourages us to get wisdom. This shows that "
            + "wisdom should be something we deliberately pursue. "
            + "It is important in our relationship with God, "
            + "our decisions, our responsibilities and the way "
            + "we handle everyday situations. We should not make "
            + "decisions carelessly or depend only on what we "
            + "think we know. We need wisdom to understand "
            + "situations and respond appropriately."
    );

    addTeachingPoint(
            "Wisdom Is Knowing What to Do and Doing It",
            "Wisdom involves more than knowing the right thing. "
            + "It also involves putting that understanding into "
            + "practice. For example, knowing that honesty is "
            + "important is knowledge, but choosing to be honest "
            + "even when it is difficult is an application of "
            + "wisdom. Wisdom therefore connects understanding "
            + "with action. It helps us make choices that reflect "
            + "what we know to be right."
    );

    addTeachingPoint(
            "Thinking Things Through with God",
            "Wisdom also involves taking time to think through "
            + "our decisions with God in view. Instead of acting "
            + "only on emotions, pressure or assumptions, we "
            + "should seek God's direction and consider whether "
            + "our choices agree with His Word. This helps us "
            + "avoid careless decisions and develop a life guided "
            + "by godly understanding."
    );

    addText("2. Why Do We Need Wisdom?",
            18, Color.BLACK, true);

    addTeachingPoint(
            "To Succeed in Life",
            "Wisdom helps us handle the opportunities and "
            + "responsibilities that come our way. Success "
            + "requires more than desire; it requires good "
            + "judgement, discipline and the ability to make "
            + "appropriate decisions. Wisdom helps us recognise "
            + "what needs to be done and take responsible steps "
            + "towards our goals."
    );

    addTeachingPoint(
            "To Fulfil Our Goals",
            "Having goals is important, but we also need wisdom "
            + "to know how to pursue them. Wisdom helps us "
            + "consider our priorities, use our time well and "
            + "choose the right steps. It helps us avoid being "
            + "distracted by things that do not contribute "
            + "to the purpose we are pursuing."
    );

    addTeachingPoint(
            "To Understand What We Are Doing",
            "Wisdom helps us understand the purpose and "
            + "importance of our actions. Rather than doing "
            + "things without understanding, we learn to "
            + "consider why we are doing them and what "
            + "their results may be. This gives direction "
            + "to our actions and helps us act with intention."
    );

    addText("3. The Ultimate Purpose of Wisdom",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Glory",
            "Wisdom should ultimately bring glory to God. "
            + "When we use the understanding He gives us "
            + "to make good decisions and fulfil His purpose, "
            + "our lives can become a testimony of His goodness. "
            + "Our abilities and achievements should not make "
            + "us proud; they should lead us to honour the "
            + "One who gives wisdom."
    );

    addTeachingPoint(
            "Stability",
            "Wisdom helps establish stability in our lives. "
            + "It teaches us to think carefully, act responsibly "
            + "and avoid decisions that can create unnecessary "
            + "problems. A wise person does not allow every "
            + "situation or emotion to determine their actions. "
            + "Instead, they learn to make decisions based "
            + "on understanding and godly direction."
    );

    addTeachingPoint(
            "Mighty Works",
            "Wisdom can help us use our abilities and opportunities "
            + "effectively. When we apply understanding correctly, "
            + "we can accomplish meaningful things and contribute "
            + "positively to the lives of others. The things we "
            + "accomplish should point back to God and reflect "
            + "the wisdom He gives."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "Wisdom is the principal thing. It involves knowing "
            + "what to do, thinking things through with God "
            + "and putting understanding into action. We need "
            + "wisdom to succeed in life, fulfil our goals "
            + "and live purposefully. Its ultimate purpose "
            + "should be to bring glory to God, establish "
            + "stability and help us accomplish meaningful works.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "Do I only have knowledge, or am I also applying "
            + "what I know wisely? Do I involve God in my "
            + "decisions and think carefully before I act?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You because You are the "
            + "source of wisdom. Help me understand the "
            + "importance of wisdom and teach me to apply "
            + "what I know correctly. Guide my thoughts, "
            + "decisions and actions so that my life will "
            + "fulfil Your purpose and bring glory to Your name. "
            + "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showJulyWeekTwo() {
    addText("Types of Wisdom",
            22, Color.BLACK, true);

    addText("Introduction",
            18, Color.BLACK, true);

    addText(
            "Not every kind of wisdom comes from the same source "
            + "or produces the same results. A person may be clever, "
            + "experienced or knowledgeable and still make decisions "
            + "that are contrary to God's will. This is why we must "
            + "understand the different types of wisdom and learn "
            + "to recognise the wisdom that should guide our lives. "
            + "James 3:13–17 describes the difference between wisdom "
            + "that is earthly, sensual and devilish and the wisdom "
            + "that comes from above.",
            16, Color.BLACK, false
    );

    addText("1. Earthly Wisdom",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Wisdom Based on the World's Standards",
            "Earthly wisdom is understanding and judgement that "
            + "are limited to the standards, values and reasoning "
            + "of this world. It may be based on human experience, "
            + "education, observation or personal ambition without "
            + "considering God's direction. James 3:15 describes "
            + "this kind of wisdom as not coming from above but "
            + "as earthly. This teaches us that human intelligence "
            + "alone is not the same as the wisdom of God."
    );

    addTeachingPoint(
            "The Limitation of Earthly Wisdom",
            "Human knowledge can be useful, but it has limitations. "
            + "When a person depends entirely on personal reasoning "
            + "and ignores God's Word, their decisions may lead "
            + "them away from His purpose. Proverbs 3:5–6 teaches "
            + "us not to lean entirely on our own understanding "
            + "but to acknowledge God in all our ways. We should "
            + "therefore allow God's direction to guide the way "
            + "we use our knowledge and experience."
    );

    addText("2. Sensual Wisdom",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Wisdom Governed by Natural Desires",
            "Sensual wisdom is wisdom that is controlled by the "
            + "natural or fleshly desires of a person rather than "
            + "by the Spirit of God. It allows feelings, impulses "
            + "and personal desires to determine decisions without "
            + "proper regard for God's truth. James 3:15 uses "
            + "the word sensual when describing wisdom that "
            + "does not come from above. This reminds us that "
            + "not every feeling or desire should become the "
            + "basis for our choices."
    );

    addTeachingPoint(
            "Do Not Allow Feelings to Control Your Decisions",
            "Our emotions are part of human life, but they should "
            + "not become our highest authority. A person who "
            + "always follows immediate desires may make decisions "
            + "without considering their consequences or whether "
            + "those decisions please God. Galatians 5:16 encourages "
            + "believers to walk in the Spirit rather than fulfil "
            + "the desires of the flesh. We must learn to bring "
            + "our desires under the guidance of God's Word."
    );

    addText("3. Devilish Wisdom",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Wisdom That Reflects the Nature of Evil",
            "Devilish wisdom is not wisdom that comes from God. "
            + "James 3:15 identifies it as wisdom that is earthly, "
            + "sensual and devilish. It is associated with attitudes "
            + "and actions that oppose God's character, such as "
            + "envy, selfish ambition and disorder. James 3:14–16 "
            + "warns against bitter envy and selfish ambition "
            + "because they produce confusion and evil practices."
    );

    addTeachingPoint(
            "Recognise Its Fruits",
            "One way to recognise this kind of wisdom is by "
            + "examining the results it produces. When someone's "
            + "thinking encourages hatred, manipulation, jealousy, "
            + "dishonesty or selfish ambition, it does not reflect "
            + "the wisdom of God. We must be careful not to admire "
            + "an idea simply because it appears clever or "
            + "successful. Its character and results must also "
            + "be examined in the light of God's Word."
    );

    addText("4. Divine Wisdom",
            18, Color.BLACK, true);

    addTeachingPoint(
            "Wisdom That Comes from God",
            "Divine wisdom is the wisdom that comes from above. "
            + "James 3:17 explains that the wisdom from above "
            + "is first pure, then peaceable, gentle and easy "
            + "to be entreated. It is full of mercy and good fruits, "
            + "without partiality and without hypocrisy. Unlike "
            + "wisdom that is controlled by selfish desires, "
            + "divine wisdom reflects God's character and leads "
            + "us towards what is right."
    );

    addTeachingPoint(
            "Divine Wisdom Produces Godly Results",
            "A person walking in divine wisdom does not seek "
            + "only personal advantage. God's wisdom teaches "
            + "us to act with purity, peace, humility and mercy. "
            + "It influences how we treat people, handle "
            + "responsibilities and respond to difficult situations. "
            + "When our decisions are guided by divine wisdom, "
            + "the results should reflect the character and "
            + "principles of God."
    );

    addTeachingPoint(
            "Seek Wisdom from God",
            "James 1:5 encourages anyone who lacks wisdom to "
            + "ask God, who gives generously to all without "
            + "reproach. This shows that divine wisdom is "
            + "something we should continually seek from God. "
            + "We should not assume that our own understanding "
            + "is always sufficient. Through prayer, the study "
            + "of Scripture and obedience, we can grow in "
            + "understanding and learn to make decisions "
            + "that honour Him."
    );

    addText("Key Lesson",
            18, Color.BLACK, true);

    addText(
            "There are different types of wisdom, but they do "
            + "not all come from the same source or produce "
            + "the same results. Earthly, sensual and devilish "
            + "wisdom are described in James 3 as wisdom that "
            + "does not come from above. Divine wisdom comes "
            + "from God and produces purity, peace, gentleness "
            + "and good fruits. We must seek the wisdom that "
            + "comes from above and allow it to guide our lives.",
            16, Color.BLACK, false
    );

    addText("Reflection",
            18, Color.BLACK, true);

    addText(
            "What kind of wisdom is influencing my decisions? "
            + "Am I allowing worldly standards, personal desires "
            + "or selfish ambition to control my choices, "
            + "or am I seeking the wisdom that comes from God?",
            16, Color.BLACK, false
    );

    addText("Prayer",
            18, Color.BLACK, true);

    addText(
            "Heavenly Father, help me recognise the different "
            + "types of wisdom. Deliver me from thinking and "
            + "acting in ways that oppose Your Word. Give me "
            + "divine wisdom that is pure, peaceable, gentle "
            + "and full of mercy. Guide my thoughts and decisions "
            + "so that my life will reflect Your character. "
            + "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showJulyWeekThree() {

    addText("Characteristics of Wisdom", 22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);

    addText(
            "Wisdom is more than having knowledge or being able to speak intelligently. " +
            "It is demonstrated through our thoughts, decisions, attitudes and daily conduct. " +
            "A person may know many things but still make unwise decisions. True wisdom " +
            "helps us understand what is right, choose what is beneficial and live in a " +
            "way that honours God. The characteristics of wisdom reveal themselves in " +
            "both our relationship with God and our relationship with other people.",
            16, Color.BLACK, false
    );

    addText("1. Inspiration", 18, Color.BLACK, true);

    addText(
            "Inspiration is one of the elements of wisdom. A wise person seeks inspiration " +
            "from God and allows godly principles to influence their thoughts and decisions. " +
            "Instead of depending entirely on personal ideas, we should seek God's direction " +
            "and allow His Word to shape our understanding. This helps us approach challenges " +
            "with faith, purpose and a desire to do what is right.",
            16, Color.BLACK, false
    );

    addText("Scripture: James 1:5", 15, Color.DKGRAY, false);

    addText("2. Creativity", 18, Color.BLACK, true);

    addText(
            "Wisdom makes room for creativity. A wise person does not approach every " +
            "challenge carelessly or assume that there is no solution. Instead, they think " +
            "constructively, identify possibilities and make good use of the abilities and " +
            "resources available to them. Creativity guided by wisdom is not simply about " +
            "having new ideas; it is about using those ideas responsibly and productively.",
            16, Color.BLACK, false
    );

    addText("Scripture: Exodus 35:30–35", 15, Color.DKGRAY, false);

    addText("3. Revelation and Understanding", 18, Color.BLACK, true);

    addText(
            "Revelation is another element of wisdom. It involves gaining understanding " +
            "and insight into God's Word and His principles. A wise person does not merely " +
            "hear or read the Word; they seek to understand it and apply it correctly. " +
            "God's Word gives light and helps us see situations from a godly perspective. " +
            "As we grow in understanding, our decisions and conduct should also reflect " +
            "what we have learned.",
            16, Color.BLACK, false
    );

    addText("Scripture: Ephesians 1:17–18; Psalm 119:130", 15, Color.DKGRAY, false);

    addText("4. Guidance", 18, Color.BLACK, true);

    addText(
            "A wise person understands the importance of direction. They do not make " +
            "every decision based only on feelings, pressure or what other people are doing. " +
            "They seek God's guidance, consider His Word and carefully examine the choices " +
            "before them. Wisdom helps us recognise the right path and avoid decisions " +
            "that can lead us away from God's purpose.",
            16, Color.BLACK, false
    );

    addText("Scripture: Proverbs 3:5–6", 15, Color.DKGRAY, false);

    addText("5. Patience", 18, Color.BLACK, true);

    addText(
            "Patience is an important characteristic of wisdom. A wise person does not " +
            "rush into decisions or allow temporary emotions to control their actions. " +
            "They understand that some situations require time, careful thought and " +
            "self-control. Patience also helps us listen properly, respond thoughtfully " +
            "and avoid unnecessary mistakes.",
            16, Color.BLACK, false
    );

    addText("Scripture: Proverbs 14:29; James 1:19", 15, Color.DKGRAY, false);

    addText("6. Meekness and Gentleness", 18, Color.BLACK, true);

    addText(
            "Meekness is not weakness. It is the ability to remain humble, gentle and " +
            "controlled even when dealing with difficult situations. A wise person does " +
            "not use knowledge to look down on others or create arguments. Instead, " +
            "they communicate respectfully, consider other people's feelings and remain " +
            "willing to receive correction. True wisdom is reflected in a person's attitude, " +
            "not just in their words.",
            16, Color.BLACK, false
    );

    addText("Scripture: James 3:13; Galatians 5:22–23", 15, Color.DKGRAY, false);

    addText("7. Honesty and Integrity", 18, Color.BLACK, true);

    addText(
            "A wise person values truth and integrity. They understand that character " +
            "matters just as much as knowledge or achievement. They speak honestly, keep " +
            "their promises and do what is right even when nobody is watching. Dishonesty " +
            "may appear to offer temporary advantages, but it damages trust and character. " +
            "Wisdom teaches us to live sincerely and responsibly.",
            16, Color.BLACK, false
    );

    addText("Scripture: Proverbs 10:9; Proverbs 12:22", 15, Color.DKGRAY, false);

    addText("8. Discernment", 18, Color.BLACK, true);

    addText(
            "Discernment is the ability to distinguish between what is right and wrong, " +
            "helpful and harmful, or wise and unwise. A discerning person does not accept " +
            "everything simply because it sounds attractive or popular. They examine " +
            "situations carefully, consider the consequences and measure their choices " +
            "against God's principles. Discernment helps us make decisions that protect " +
            "our values and future.",
            16, Color.BLACK, false
    );

    addText("Scripture: Hebrews 5:14; Philippians 1:9–10", 15, Color.DKGRAY, false);

    addText("9. Humility and Teachability", 18, Color.BLACK, true);

    addText(
            "Wisdom is accompanied by humility. A wise person does not assume that they " +
            "know everything. They remain willing to learn, listen to godly counsel and " +
            "accept correction when necessary. Pride can prevent a person from recognising " +
            "their mistakes, but humility creates room for growth. We become wiser when " +
            "we are willing to learn from God and from sound instruction.",
            16, Color.BLACK, false
    );

    addText("Scripture: Proverbs 11:2; Proverbs 12:15", 15, Color.DKGRAY, false);

    addText("10. Self-Control", 18, Color.BLACK, true);

    addText(
            "Self-control is another evidence of wisdom. A wise person learns to govern " +
            "their words, emotions and actions. They do not allow anger, pressure or " +
            "impulsive desires to make decisions for them. They understand that not every " +
            "thought needs to be spoken and not every feeling needs to become an action. " +
            "Self-control helps us respond with maturity and maintain good relationships.",
            16, Color.BLACK, false
    );

    addText("Scripture: Proverbs 16:32; Galatians 5:22–23", 15, Color.DKGRAY, false);

    addText("Key Lesson", 18, Color.BLACK, true);

    addText(
            "Wisdom is not measured only by what we know, but also by how we live. " +
            "It is reflected in our inspiration, creativity, revelation and guidance, " +
            "as well as in our patience, meekness, honesty, discernment, humility and " +
            "self-control. As we grow in godly wisdom, our character should increasingly " +
            "reflect the values and principles of God's Word.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);

    addText(
            "Which of these characteristics of wisdom do you need to develop more in " +
            "your daily life? Are your decisions, words and actions showing the wisdom " +
            "you are learning from God's Word?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for being the source of true wisdom. Give me " +
            "understanding and help me develop a character that reflects Your wisdom. " +
            "Teach me to be patient, meek, honest, humble and discerning. Guide my " +
            "thoughts, words and decisions so that my life will honour You. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showJulyWeekFour() {

    addText("How to Activate and Apply the Wisdom of God in My Life",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);

    addText(
            "Wisdom is not meant to remain something we only learn about; it is " +
            "something we must activate and demonstrate in our daily lives. God's " +
            "wisdom helps us make sound decisions, handle challenges, relate properly " +
            "with others and live according to His purpose. However, walking in this " +
            "wisdom requires an intentional relationship with God and the willingness " +
            "to put His Word into practice. We must move beyond knowing what wisdom " +
            "is and learn how to apply it in our thoughts, conversations, relationships, " +
            "responsibilities and decisions.",
            16, Color.BLACK, false
    );

    addText("1. Develop an Intimate Relationship with God",
            18, Color.BLACK, true);

    addText(
            "The foundation of godly wisdom is an intimate relationship with God. " +
            "We cannot fully understand His ways without drawing closer to Him. " +
            "Developing this relationship involves spending time with Him through " +
            "prayer, studying His Word, worship and obedience. As we grow in fellowship " +
            "with God, we become more conscious of His principles and learn to depend " +
            "on Him for direction.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Make time for God daily. Before making important decisions, " +
            "seek His direction and consider whether your choices agree with His Word. " +
            "Do not allow your relationship with Him to become something you remember " +
            "only when you need help.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Colossians 2:9; Colossians 1:24; Colossians 1:27; Romans 11:33",
            15, Color.DKGRAY, false
    );

    addText("2. Spiritual-Mindedness: Let the Word of God Dominate Your Thinking",
            18, Color.BLACK, true);

    addText(
            "Spiritual-mindedness means deliberately turning our minds towards the " +
            "things of the Spirit and allowing God's Word to influence our thoughts, " +
            "understanding and decisions. We must not allow worldly thinking, temporary " +
            "concerns, distractions or the opinions of others to control our minds. " +
            "Instead, we should continually focus on God's truth and allow His principles " +
            "to shape our priorities and responses. Spiritual-mindedness requires us " +
            "to keep our attention on the things of God and develop the habit of thinking " +
            "in agreement with His Word.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Make meditation on God's Word a regular habit. Think carefully " +
            "about what you read and allow it to influence your choices. When facing " +
            "pressure or difficult situations, pause and consider God's principles " +
            "before responding. Practise directing your attention towards things that " +
            "strengthen your spiritual life.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Romans 12:2; John 12:24; Joshua 1:8; Proverbs (reference unclear in the handwritten notes)",
            15, Color.DKGRAY, false
    );

    addText("3. Renewal of the Mind Is the First Step",
            18, Color.BLACK, true);

    addText(
            "The renewal of the mind is essential to developing spiritual wisdom. " +
            "It involves replacing thoughts and attitudes that oppose God's Word " +
            "with thoughts that agree with His truth. Instead of allowing fear, " +
            "pride, confusion or unhealthy influences to determine our decisions, " +
            "we should continually train our minds to follow God's principles. " +
            "As our thinking changes, our way of living and responding to situations " +
            "also begins to change.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Pay attention to the thoughts you entertain. When you " +
            "recognise a thought or attitude that leads you away from God's principles, " +
            "replace it with the truth of His Word. Be willing to change your thinking " +
            "when Scripture corrects you.",
            16, Color.BLACK, false
    );

    addText("Scripture: Romans 8:6", 15, Color.DKGRAY, false);

    addText("4. Supernatural Research: Interacting with Spiritual Materials",
            18, Color.BLACK, true);

    addText(
            "Developing wisdom also requires a willingness to study and learn. " +
            "Supernatural research involves giving attention to spiritual materials " +
            "that help us grow in the knowledge of God and understand His Word more " +
            "deeply. We should not be careless about spiritual learning. Reading, " +
            "studying, meditating and carefully examining Scripture help us develop " +
            "understanding. Everything we learn should be examined in the light of " +
            "God's Word.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Do not read the Bible merely to finish a chapter. Take time " +
            "to understand what you are reading. Write down important lessons, examine " +
            "the Scriptures and consider how to apply what you learn at home, in school, " +
            "in your relationships and in your responsibilities.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Ecclesiastes 1:13; 2 Timothy 3:15",
            15, Color.DKGRAY, false
    );

    addText("5. Maintain a Prayerful Lifestyle",
            18, Color.BLACK, true);

    addText(
            "Prayer is an important part of our relationship with God. A prayerful " +
            "person continually depends on God for direction, understanding and " +
            "strength. Prayer should not be limited to emergencies; it should become " +
            "a regular part of our daily lives. Through prayer, we express our " +
            "dependence on God, seek His help and remain attentive to His direction.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Establish a consistent personal prayer time. Pray about " +
            "your decisions, responsibilities, relationships and spiritual growth. " +
            "When you are uncertain about what to do, seek God's wisdom rather than " +
            "acting carelessly. Let prayer become a regular part of your life.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: James 4:6; Psalm 42:9",
            15, Color.DKGRAY, false
    );

    addText("Putting God's Wisdom into Everyday Life",
            18, Color.BLACK, true);

    addText(
            "The wisdom of God must be visible in the way we live. It should influence " +
            "how we speak to people, respond to correction, manage our time, handle " +
            "conflicts and make decisions. When dealing with others, practise patience, " +
            "meekness and honesty. When faced with choices, consider the consequences " +
            "and seek godly direction. When given responsibilities, handle them with " +
            "diligence and integrity. Do not separate spiritual growth from everyday " +
            "conduct. The wisdom we receive from God should be reflected in our actions.",
            16, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);

    addText(
            "Activating and applying God's wisdom requires an intimate relationship " +
            "with Him, a mind controlled by His Word, continuous renewal of our thinking, " +
            "spiritual-mindedness, serious study and a consistent prayer life. " +
            "True wisdom is demonstrated when we put what we learn into practice. " +
            "We must allow God's wisdom to guide not only our spiritual activities " +
            "but also our everyday decisions and behaviour.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);

    addText(
            "Am I allowing God's Word to influence my daily decisions? Do I make time " +
            "for prayer and the study of Scripture? In what areas of my life do I need " +
            "to start applying God's wisdom more intentionally?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You because You are the source of true wisdom. " +
            "Help me develop an intimate relationship with You and allow Your Word " +
            "to guide my thoughts and decisions. Renew my mind, increase my understanding " +
            "and teach me to remain spiritually minded. Give me discipline to study " +
            "Your Word and maintain a consistent prayer life. Help me apply Your wisdom " +
            "in my relationships, responsibilities and everyday decisions. Let my " +
            "life reflect Your wisdom and bring glory to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showAugustWeekOne() {

    addText("Understanding Success: What Is Success?",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);

    addText(
            "Success is a goal many people desire, but not everyone understands " +
            "what true success means. Some people measure success by wealth, " +
            "positions, popularity, academic achievements or material possessions. " +
            "Although these things may be part of a person's achievements, they do " +
            "not by themselves define a truly successful life. From a Christian " +
            "perspective, success involves making meaningful progress, fulfilling " +
            "God's purpose and living according to His principles. True success " +
            "should not only be seen in what we acquire but also in the kind of " +
            "person we become and the positive impact our lives make.",
            16, Color.BLACK, false
    );

    addText("1. Understanding the Meaning of Success",
            18, Color.BLACK, true);

    addText(
            "Success can be understood as the accomplishment of worthwhile goals " +
            "and the steady progress towards becoming what we are meant to be. " +
            "It involves growth, development, achievement and the responsible use " +
            "of the abilities and opportunities available to us. Success is not " +
            "always achieved at once. It often involves learning, making corrections, " +
            "overcoming challenges and remaining committed to the right direction.",
            16, Color.BLACK, false
    );

    addText(
            "As Christians, we must understand that success should be measured " +
            "in the light of God's Word. We should not pursue achievements at the " +
            "expense of our faith, character or relationship with God.",
            16, Color.BLACK, false
    );

    addText("Scripture: Joshua 1:8; Psalm 1:1–3",
            15, Color.DKGRAY, false);

    addText("2. Success Is More Than Material Achievement",
            18, Color.BLACK, true);

    addText(
            "Material possessions, financial stability, education and professional " +
            "achievements can be valuable, but they are not the complete measure " +
            "of success. A person may possess many things and still lack peace, " +
            "good character, meaningful relationships or spiritual growth. " +
            "God wants us to understand that our lives are more valuable than " +
            "the things we possess.",
            16, Color.BLACK, false
    );

    addText(
            "We should therefore avoid comparing our lives with others or believing " +
            "that our worth is determined by how much we own. Instead, we should " +
            "pursue meaningful progress while maintaining the values that matter " +
            "to God.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Luke 12:15; Mark 8:36",
            15, Color.DKGRAY, false);

    addText("3. Success Involves Growth and Continuous Progress",
            18, Color.BLACK, true);

    addText(
            "A successful life requires a willingness to grow. We should not become " +
            "comfortable with remaining at the same level when there is room to " +
            "develop our knowledge, abilities, character and understanding. " +
            "Growth requires learning, discipline, patience and consistent effort. " +
            "There may be challenges and setbacks along the way, but these should " +
            "not automatically make us abandon worthwhile goals.",
            16, Color.BLACK, false
    );

    addText(
            "Every day presents opportunities to improve. We can grow spiritually " +
            "through God's Word, develop our abilities through learning, become " +
            "more responsible in our duties and improve how we relate with others. " +
            "These small and consistent steps contribute to meaningful progress.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Proverbs 4:18; Philippians 3:13–14",
            15, Color.DKGRAY, false);

    addText("4. Success Must Agree with God's Purpose",
            18, Color.BLACK, true);

    addText(
            "Not every achievement represents success in God's eyes. The way we " +
            "pursue our goals matters just as much as the goals themselves. " +
            "We should not gain recognition through dishonesty, take advantage " +
            "of others or abandon our convictions simply to get ahead. " +
            "Godly success involves pursuing worthwhile goals through principles " +
            "that honour God.",
            16, Color.BLACK, false
    );

    addText(
            "God has given each person abilities, opportunities and responsibilities. " +
            "We should seek to discover how to use these gifts meaningfully rather " +
            "than living only for personal recognition. When our ambitions are " +
            "guided by God's principles, our achievements can become a blessing " +
            "to others as well.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Proverbs 16:3; Colossians 3:23–24",
            15, Color.DKGRAY, false);

    addText("5. Good Success Versus Bad Success",
            18, Color.BLACK, true);

    addText(
            "It is important to understand that there is a difference between " +
            "achieving something and achieving it in a way that pleases God. " +
            "A person may become wealthy, influential or popular through methods " +
            "that involve dishonesty, exploitation or disobedience. Such achievements " +
            "may appear successful outwardly, but they do not reflect godly success.",
            16, Color.BLACK, false
    );

    addText(
            "Good success is pursued with integrity, wisdom, diligence and respect " +
            "for God's principles. It does not require us to sacrifice our faith " +
            "or character to obtain results. We should desire achievements that " +
            "we can pursue with a clear conscience and use responsibly.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Proverbs 10:9; Proverbs 28:6; Mark 8:36",
            15, Color.DKGRAY, false);

    addText("6. Why Should We Pursue a Successful Life?",
            18, Color.BLACK, true);

    addText(
            "We should desire success because our lives have purpose and our " +
            "abilities should not be wasted. God expects us to be responsible " +
            "with what He has entrusted to us. Developing our gifts, fulfilling " +
            "our responsibilities and making meaningful contributions can help " +
            "us serve others and honour God.",
            16, Color.BLACK, false
    );

    addText(
            "Success also enables us to become more useful in our families, " +
            "communities and places of responsibility. We should therefore pursue " +
            "growth not merely to impress people but to become responsible individuals " +
            "who use their opportunities and resources wisely.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Matthew 5:16; 1 Peter 4:10",
            15, Color.DKGRAY, false);

    addText("Key Lesson", 18, Color.BLACK, true);

    addText(
            "True success is more than wealth, fame, position or material achievement. " +
            "It involves meaningful growth, fulfilling worthwhile goals and living " +
            "according to God's principles. We must pursue progress without sacrificing " +
            "our faith or character. The goal is not simply to achieve something, " +
            "but to become responsible people whose lives honour God and positively " +
            "affect others.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);

    addText(
            "How do I currently measure success? Am I pursuing achievements that " +
            "agree with God's principles? What areas of my life need improvement, " +
            "and how can I use my abilities and opportunities more responsibly?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for the abilities, opportunities and purpose " +
            "You have given me. Help me understand true success and guide me as I " +
            "pursue meaningful goals. Teach me to grow in wisdom, discipline and " +
            "character. Keep me from pursuing achievements that will take me away " +
            "from Your principles. Help me use my gifts responsibly and let my life " +
            "bring glory to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showAugustWeekTwo() {

    addText("Types of Success", 22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);

    addText(
            "Success is not limited to one area of life. A person may make progress " +
            "financially but neglect their spiritual life, or achieve academic and " +
            "professional goals while failing to care for their physical well-being. " +
            "A balanced understanding of success recognises the importance of " +
            "different areas of our lives. In this teaching, we will consider three " +
            "important areas: spiritual success, physical success and financial success. " +
            "Each requires attention, discipline and responsible choices.",
            16, Color.BLACK, false
    );

    addText("1. Spiritual Success", 18, Color.BLACK, true);

    addText(
            "Spiritual success begins with having a meaningful relationship with God " +
            "and growing in our faith. It involves becoming more committed to God, " +
            "developing a consistent prayer life and maintaining an attitude of " +
            "gratitude. Spiritual success is not measured simply by how often we " +
            "attend religious activities, but also by the growth of our faith, " +
            "obedience to God's Word and the character we demonstrate in everyday life.",
            16, Color.BLACK, false
    );

    addText("A. Commitment to God", 17, Color.BLACK, true);

    addText(
            "Commitment means making God an important part of our daily lives. " +
            "It involves choosing to follow His principles, remain faithful to Him " +
            "and continue growing spiritually. Our relationship with God should " +
            "not depend only on how convenient life is. We should remain devoted " +
            "to Him in both favourable and difficult seasons.",
            16, Color.BLACK, false
    );

    addText("B. Prayer", 17, Color.BLACK, true);

    addText(
            "Prayer is an important part of spiritual growth. Through prayer, " +
            "we communicate with God, express our gratitude, seek His direction " +
            "and depend on His strength. A consistent prayer life helps us remain " +
            "conscious of God and strengthens our relationship with Him.",
            16, Color.BLACK, false
    );

    addText("C. Gratitude", 17, Color.BLACK, true);

    addText(
            "A grateful person recognises God's goodness and appreciates what " +
            "He has provided. Gratitude prevents us from becoming controlled by " +
            "constant comparison or dissatisfaction. Even while pursuing greater " +
            "goals, we should learn to appreciate our present blessings and give " +
            "God thanks in every situation.",
            16, Color.BLACK, false
    );

    addText(
            "Practical Application: Set aside time for prayer, study God's Word, " +
            "remain committed to His principles and develop the habit of thanking " +
            "Him daily.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Matthew 6:33; 1 Thessalonians 5:17–18; Colossians 2:6–7",
            15, Color.DKGRAY, false);

    addText("2. Physical Success", 18, Color.BLACK, true);

    addText(
            "Physical success involves taking responsible care of the body and " +
            "maintaining habits that support health and well-being. Our bodies " +
            "are important, and we need to care for them so that we can carry out " +
            "our daily responsibilities. Physical well-being does not mean that " +
            "a person will never experience illness or difficulty. It means " +
            "recognising the importance of healthy habits and seeking appropriate " +
            "care when necessary.",
            16, Color.BLACK, false
    );

    addText("A. Exercise Regularly", 17, Color.BLACK, true);

    addText(
            "Regular physical activity helps the body remain active and supports " +
            "general health. Exercise can improve strength, movement and endurance. " +
            "It does not have to be complicated; suitable activities such as walking, " +
            "stretching and other enjoyable forms of exercise can become part of " +
            "a healthy routine.",
            16, Color.BLACK, false
    );

    addText("B. Avoid Substance Abuse", 17, Color.BLACK, true);

    addText(
            "Avoiding the misuse of harmful substances is an important part of " +
            "caring for the body. We should make responsible choices and avoid " +
            "habits that can damage our health, judgment and ability to fulfil " +
            "our responsibilities.",
            16, Color.BLACK, false
    );

    addText("C. Get Adequate Sleep", 17, Color.BLACK, true);

    addText(
            "Rest is necessary for the body and mind. Adequate sleep supports " +
            "concentration, learning, recovery and general well-being. We should " +
            "develop a reasonable sleeping routine rather than constantly " +
            "overworking ourselves or neglecting rest.",
            16, Color.BLACK, false
    );

    addText("D. Stay Hydrated", 17, Color.BLACK, true);

    addText(
            "Drinking enough water is another simple but important way to care " +
            "for the body. Water supports normal body functions, and we should " +
            "make it a habit to drink water regularly throughout the day.",
            16, Color.BLACK, false
    );

    addText("E. Eat and Drink Responsibly", 17, Color.BLACK, true);

    addText(
            "What we eat and drink contributes to our general well-being. We " +
            "should make balanced food choices, maintain healthy eating habits " +
            "and avoid careless patterns that may negatively affect our health. " +
            "Caring for the body requires consistency rather than occasional effort.",
            16, Color.BLACK, false
    );

    addText(
            "Practical Application: Develop healthy routines that include suitable " +
            "physical activity, adequate rest, drinking enough water, balanced meals " +
            "and avoiding harmful substances. Seek appropriate medical advice when needed.",
            16, Color.BLACK, false
    );

    addText("Scriptures: 1 Corinthians 6:19–20; 1 Timothy 4:8",
            15, Color.DKGRAY, false);

    addText("3. Financial Success", 18, Color.BLACK, true);

    addText(
            "Financial success involves learning to manage resources responsibly, " +
            "developing useful abilities and making thoughtful financial decisions. " +
            "It is not simply about how much money a person possesses. It also " +
            "involves understanding how to earn, save, budget, plan and use money " +
            "wisely. Financial responsibility requires discipline, patience and " +
            "a willingness to keep learning.",
            16, Color.BLACK, false
    );

    addText("A. Invest in Yourself", 17, Color.BLACK, true);

    addText(
            "One valuable investment is the development of your own knowledge " +
            "and abilities. Learning, education and personal development can " +
            "prepare you for opportunities and responsibilities. We should not " +
            "be satisfied with what we already know when there is room to improve.",
            16, Color.BLACK, false
    );

    addText("B. Develop Useful Skills", 17, Color.BLACK, true);

    addText(
            "Skills help us solve problems, provide services and contribute " +
            "meaningfully to society. We should identify areas where we have " +
            "interest or ability and work towards improving them. Practical " +
            "skills, professional knowledge and creativity can open opportunities " +
            "for responsible work and productivity.",
            16, Color.BLACK, false
    );

    addText("C. Seek Financial Mentorship", 17, Color.BLACK, true);

    addText(
            "Learning from people with sound financial experience can help us " +
            "understand money management and avoid preventable mistakes. Good " +
            "mentorship should encourage responsible planning, patience and " +
            "careful decision-making. We should also examine advice wisely rather " +
            "than following every financial suggestion without understanding it.",
            16, Color.BLACK, false
    );

    addText("D. Budget and Manage Spending", 17, Color.BLACK, true);

    addText(
            "Budgeting helps us understand what comes in, what goes out and " +
            "how available resources should be allocated. Without a plan, it " +
            "is easy to spend carelessly and neglect important needs. Learning " +
            "to distinguish between needs and wants helps us become more " +
            "responsible with money.",
            16, Color.BLACK, false
    );

    addText("E. Avoid Unnecessary Debt", 17, Color.BLACK, true);

    addText(
            "Financial responsibility includes understanding the consequences " +
            "of borrowing. We should avoid unnecessary borrowing and be careful " +
            "about making financial commitments we cannot reasonably meet. " +
            "Before taking on an obligation, we should understand its terms " +
            "and consider how repayment will affect our responsibilities.",
            16, Color.BLACK, false
    );

    addText("F. Understand That God Gives the Ability to Get Wealth",
            17, Color.BLACK, true);

    addText(
            "Our abilities, opportunities and resources should never make us " +
            "forget God. Scripture reminds us that it is God who gives us the " +
            "ability to acquire wealth. We should therefore remain humble, " +
            "grateful and responsible with whatever comes into our hands. " +
            "Financial progress should never become an excuse for pride, greed " +
            "or dishonesty.",
            16, Color.BLACK, false
    );

    addText(
            "Practical Application: Continue developing useful skills, learn " +
            "to plan your spending, seek sound guidance, avoid unnecessary " +
            "financial commitments and handle resources with integrity.",
            16, Color.BLACK, false
    );

    addText("Scriptures: Deuteronomy 8:18; Proverbs 21:5; Luke 14:28",
            15, Color.DKGRAY, false);

    addText("Bringing the Three Areas Together",
            18, Color.BLACK, true);

    addText(
            "Spiritual, physical and financial success should not be treated " +
            "as unrelated parts of life. They influence one another. Spiritual " +
            "growth helps us develop values and discipline. Physical well-being " +
            "supports our ability to carry out daily responsibilities. Financial " +
            "responsibility helps us manage resources and meet legitimate needs. " +
            "We should therefore give attention to these areas while remembering " +
            "that our relationship with God and our character must remain central.",
            16, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);

    addText(
            "Success has different dimensions. Spiritual success involves growing " +
            "in our relationship with God through commitment, prayer and gratitude. " +
            "Physical success involves caring responsibly for our bodies, while " +
            "financial success involves developing abilities and managing resources " +
            "wisely. A balanced life requires us to give attention to these areas " +
            "without allowing any of them to replace our commitment to God.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);

    addText(
            "Which of these three areas am I giving the most attention to? " +
            "Am I neglecting my spiritual growth, physical well-being or " +
            "financial responsibilities? What practical step can I take " +
            "to become more responsible in each area?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You for every area of life You have entrusted " +
            "to me. Help me grow spiritually, care responsibly for my body and " +
            "develop wisdom in managing my resources. Teach me commitment, " +
            "discipline, gratitude and responsibility. Help me use my abilities " +
            "and opportunities wisely, and let every area of my life honour You. " +
            "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showAugustWeekThree() {

    addText("Wisdom That Empowers for Success", 22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);

    addText(
            "Success requires more than desire, ambition or hard work. We also need " +
            "wisdom to know what to do, how to do it and when to take action. " +
            "A person may have opportunities, abilities and resources but still " +
            "make decisions that prevent progress. Wisdom helps us use what we have " +
            "responsibly and make choices that lead towards worthwhile goals. " +
            "For a Christian, true wisdom comes from God and must be guided by His Word. " +
            "It empowers us to pursue success while maintaining godly character.",
            16, Color.BLACK, false
    );

    addText("1. Understanding the Place of Wisdom in Success",
            18, Color.BLACK, true);

    addText(
            "Wisdom is the ability to apply knowledge and understanding correctly. " +
            "It involves knowing what to do and making the right decisions at the " +
            "right time. Knowledge may tell us what is available, but wisdom helps " +
            "us determine how to use it properly. This is why wisdom is important " +
            "in every area of life. Whether we are pursuing spiritual growth, " +
            "developing our abilities or managing resources, we need wisdom to " +
            "make responsible choices.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Proverbs 4:7; James 1:5",
            15, Color.DKGRAY, false
    );

    addText("2. Wisdom for Making the Right Decisions",
            18, Color.BLACK, true
    );

    addText(
            "Our decisions influence the direction of our lives. Some choices may " +
            "produce immediate satisfaction but create difficulties later, while " +
            "other choices may require patience and discipline but lead to better " +
            "outcomes. Wisdom helps us look beyond the immediate benefits of a " +
            "decision and consider its possible consequences. It also teaches us " +
            "not to make important decisions carelessly or simply because others " +
            "are doing the same thing.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Before making important decisions, seek God's direction, " +
            "consider the principles of His Word and think about the possible " +
            "consequences. Do not allow pressure, excitement or temporary emotions " +
            "to control your choices.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Proverbs 3:5–6; Proverbs 14:12",
            15, Color.DKGRAY, false
    );

    addText("3. Wisdom for Managing Opportunities and Resources",
            18, Color.BLACK, true
    );

    addText(
            "Opportunities and resources are valuable, but they must be managed " +
            "properly. Wisdom helps us recognise opportunities, prepare for them " +
            "and make good use of what is available. It also teaches us not to " +
            "waste our time, abilities, finances or other resources. Having " +
            "something is not enough; we must learn how to use it responsibly.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Identify the abilities and opportunities available to " +
            "you and develop them. Plan your activities, manage your time carefully " +
            "and avoid wasting resources. When an opportunity comes, consider " +
            "whether it is worthwhile and how you can handle it responsibly.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Luke 16:10; Proverbs 21:5",
            15, Color.DKGRAY, false
    );

    addText("4. Wisdom for Solving Problems",
            18, Color.BLACK, true
    );

    addText(
            "Challenges are part of life, and success does not mean that we will " +
            "never encounter difficulties. Wisdom helps us respond to problems " +
            "with understanding instead of panic or careless reactions. It enables " +
            "us to examine situations, identify possible solutions and learn from " +
            "experience. Rather than giving up immediately when something becomes " +
            "difficult, a wise person seeks understanding and considers the best " +
            "way forward.",
            16, Color.BLACK, false
    );

    addText(
            "Application: When faced with a challenge, take time to understand " +
            "the problem. Seek godly counsel where necessary, consider available " +
            "solutions and take responsible steps. Do not allow frustration to " +
            "make you abandon a worthwhile goal.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Proverbs 24:3–6; Ecclesiastes 10:10",
            15, Color.DKGRAY, false
    );

    addText("5. Wisdom for Building Relationships",
            18, Color.BLACK, true
    );

    addText(
            "Our relationships can influence our growth and direction in life. " +
            "Wisdom teaches us how to communicate respectfully, choose good " +
            "companions, listen to others and handle disagreements properly. " +
            "It also helps us recognise the importance of godly counsel and " +
            "surrounding ourselves with people who encourage good values. " +
            "A person who desires success should not neglect the way they treat others.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Practise honesty, patience, humility and respect in " +
            "your relationships. Be willing to listen and learn. Choose companions " +
            "who encourage positive growth, and avoid relationships that continually " +
            "lead you towards destructive choices.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Proverbs 13:20; Proverbs 15:22; Ephesians 4:29",
            15, Color.DKGRAY, false
    );

    addText("6. Wisdom for Avoiding Destructive Choices",
            18, Color.BLACK, true
    );

    addText(
            "Wisdom does not only help us know what to do; it also helps us recognise " +
            "what we should avoid. Some attitudes and habits can gradually damage " +
            "our progress. Dishonesty, laziness, pride, greed and uncontrolled " +
            "behaviour can lead to consequences that affect our future. A wise " +
            "person understands that not every opportunity should be accepted " +
            "and not every desire should be followed.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Examine your habits and decisions regularly. Avoid " +
            "shortcuts that require dishonesty or compromise your values. Develop " +
            "self-control, remain teachable and be willing to walk away from " +
            "choices that can harm your future.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Proverbs 22:3; Proverbs 10:9; 1 Corinthians 10:23",
            15, Color.DKGRAY, false
    );

    addText("7. Applying God's Wisdom in Everyday Responsibilities",
            18, Color.BLACK, true
    );

    addText(
            "Wisdom must be demonstrated through our daily actions. It should " +
            "influence how we study, work, manage our responsibilities, use our " +
            "abilities and relate with people. We should not separate our spiritual " +
            "lives from our everyday decisions. God's wisdom should be visible in " +
            "our diligence, honesty, discipline and willingness to do what is right.",
            16, Color.BLACK, false
    );

    addText(
            "Application: Whatever responsibility is entrusted to you, handle it " +
            "with diligence and integrity. Whether you are studying, working, " +
            "serving others or developing a skill, give it proper attention. " +
            "Do not wait for a major opportunity before practising responsibility " +
            "in the little things.",
            16, Color.BLACK, false
    );

    addText(
            "Scriptures: Colossians 3:23–24; Luke 16:10",
            15, Color.DKGRAY, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);

    addText(
            "Wisdom is an important foundation for lasting success. It helps us " +
            "make sound decisions, manage opportunities and resources, solve " +
            "problems, build healthy relationships and avoid destructive choices. " +
            "Godly wisdom must not remain something we only hear about; it must " +
            "be applied in our daily lives. As we seek wisdom from God and practise " +
            "His principles, we become better prepared to fulfil our responsibilities " +
            "and pursue worthwhile goals.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);

    addText(
            "Am I seeking God's wisdom before making important decisions? " +
            "How do I manage the opportunities and resources available to me? " +
            "Are my habits, relationships and daily choices helping me move " +
            "towards the kind of success that honours God?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);

    addText(
            "Heavenly Father, thank You because You are the source of true wisdom. " +
            "Give me wisdom and understanding to make the right decisions. " +
            "Teach me to manage my opportunities and resources responsibly, " +
            "solve problems with understanding and build relationships that " +
            "encourage godly growth. Help me avoid destructive choices and " +
            "remain diligent in my responsibilities. Let Your wisdom guide " +
            "my thoughts, decisions and actions as I pursue success. " +
            "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showAugustWeekFour() {

    addText("Steps to Living a Successful Life", 22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Living a successful life requires more than having dreams or setting goals. " +
            "It involves making daily choices that agree with God's Word and developing " +
            "the character, discipline and commitment needed to fulfil your purpose. " +
            "Success is built through a consistent walk with God and faithful attention " +
            "to the responsibilities He has placed before you.",
            16, Color.BLACK, false
    );

    addText("1. Build a Genuine Relationship with God", 18, Color.BLACK, true);
    addText(
            "The foundation of a successful Christian life is a genuine relationship " +
            "with God. Before pursuing achievements, develop a personal walk with Him. " +
            "Know Him through His Word, trust Him in your decisions and allow your life " +
            "to reflect His character. When your relationship with God comes first, " +
            "your priorities and direction become better aligned with His purpose.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 6:33; John 15:5.", 15, Color.DKGRAY, false);

    addText("2. Make God's Word the Foundation of Your Life", 18, Color.BLACK, true);
    addText(
            "God's Word provides direction, correction and wisdom for daily living. " +
            "Do not merely read the Bible; study it, understand it and put it into " +
            "practice. Let the Word guide your choices, attitudes, relationships and " +
            "plans. A life built on God's instructions has a firm foundation even when " +
            "challenges arise.",
            16, Color.BLACK, false
    );
    addText("Scripture: Joshua 1:8; Psalm 119:105; James 1:22.", 15, Color.DKGRAY, false);

    addText("3. Develop a Consistent Prayer Life", 18, Color.BLACK, true);
    addText(
            "Prayer keeps your relationship with God active and gives you an opportunity " +
            "to seek His wisdom, express your gratitude and commit your plans to Him. " +
            "Make prayer a regular part of your daily routine rather than something you " +
            "only remember when difficulties arise. Through prayer, learn to depend on " +
            "God instead of relying entirely on your own understanding.",
            16, Color.BLACK, false
    );
    addText("Scripture: 1 Thessalonians 5:17; Philippians 4:6–7; Proverbs 3:5–6.",
            15, Color.DKGRAY, false);

    addText("4. Follow the Guidance of the Holy Spirit", 18, Color.BLACK, true);
    addText(
            "A successful Christian life requires sensitivity to the leading of the " +
            "Holy Spirit. Do not make every decision based only on pressure, emotions " +
            "or what other people are doing. Seek God's direction and allow the Holy " +
            "Spirit to guide you through His truth. His guidance helps you make choices " +
            "that agree with God's purpose.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 16:13; Romans 8:14.", 15, Color.DKGRAY, false);

    addText("5. Be Diligent and Committed to Your Responsibilities", 18, Color.BLACK, true);
    addText(
            "Success requires diligence. Whatever responsibility you have been given, " +
            "approach it with seriousness and commitment. Do not depend only on motivation " +
            "or wait until you feel ready before taking action. Be faithful in your " +
            "studies, work, service and daily duties. Small responsibilities handled " +
            "faithfully can prepare you for greater opportunities.",
            16, Color.BLACK, false
    );
    addText("Scripture: Proverbs 22:29; Colossians 3:23–24.", 15, Color.DKGRAY, false);

    addText("6. Develop Useful Skills and Keep Learning", 18, Color.BLACK, true);
    addText(
            "God has given people abilities and opportunities to develop. Do not remain " +
            "satisfied with what you already know. Identify the skills you need for your " +
            "purpose and make deliberate efforts to improve them. Learn from people with " +
            "experience, seek good instruction and remain willing to grow. Developing " +
            "your abilities helps you become more useful and prepared for opportunities.",
            16, Color.BLACK, false
    );
    addText("Scripture: Proverbs 18:15; 2 Timothy 2:15.", 15, Color.DKGRAY, false);

    addText("7. Practise Discipline, Patience and Consistency", 18, Color.BLACK, true);
    addText(
            "A successful life is not built in one day. It takes discipline to do what " +
            "is right even when it is difficult, patience to continue while waiting for " +
            "results and consistency to keep making progress. Avoid giving up simply " +
            "because results are not immediate. Develop good habits and remain committed " +
            "to the right path.",
            16, Color.BLACK, false
    );
    addText("Scripture: Hebrews 12:1; Galatians 6:9; Proverbs 13:4.",
            15, Color.DKGRAY, false);

    addText("8. Use Opportunities and Resources Wisely", 18, Color.BLACK, true);
    addText(
            "Time, abilities, knowledge, relationships and material resources should " +
            "be handled responsibly. Do not waste the opportunities available to you. " +
            "Plan carefully, manage what you have and make thoughtful decisions about " +
            "how you use your resources. Faithfulness in handling what you have today " +
            "can prepare you for greater responsibilities tomorrow.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 16:10; Ephesians 5:15–16.", 15, Color.DKGRAY, false);

    addText("9. Maintain Godly Character While Pursuing Your Goals", 18, Color.BLACK, true);
    addText(
            "Success should never come at the expense of your character. Do not sacrifice " +
            "honesty, purity, humility or obedience to God just to achieve something. " +
            "Your conduct matters just as much as your accomplishments. Let your life " +
            "demonstrate integrity and kindness so that your achievements bring honour " +
            "to God and become a positive influence on others.",
            16, Color.BLACK, false
    );
    addText("Scripture: Proverbs 10:9; Matthew 5:16; 1 Timothy 4:12.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Set aside time daily for prayer and the study of God's Word.\n" +
            "2. Identify one responsibility you need to handle more diligently.\n" +
            "3. Choose a useful skill you can begin developing.\n" +
            "4. Make a simple plan for using your time and resources wisely.\n" +
            "5. Examine your decisions and ensure that your goals agree with godly character.\n" +
            "6. Remain patient and consistent as you work towards meaningful goals.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "A successful life is built through a genuine relationship with God, " +
            "obedience to His Word, prayer, the guidance of the Holy Spirit, diligence, " +
            "continuous learning, discipline and godly character. Success is not merely " +
            "about what you achieve; it is also about who you become and how faithfully " +
            "you fulfil your God-given responsibilities.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Which of these steps am I already practising, and which ones do I need " +
            "to improve? What practical change can I begin making today to live a " +
            "more purposeful and successful life?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for giving me the opportunity to live a " +
            "purposeful and successful life. Help me to grow in my relationship with " +
            "You, follow Your Word and depend on the guidance of the Holy Spirit. " +
            "Give me wisdom, discipline, patience and diligence. Help me develop my " +
            "abilities, use my opportunities wisely and maintain godly character in " +
            "everything I do. May my life bring glory to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showSeptemberWeekOne() {

    addText("Understanding the Holy Spirit and the Promise of His Coming",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Before Jesus left His disciples, He promised that they would not be " +
            "left without help. He told them about the coming of the Holy Spirit, " +
            "who would be their Comforter and Helper. This promise was fulfilled " +
            "when the Holy Spirit came upon the apostles on the Day of Pentecost. " +
            "The coming of the Holy Spirit marked an important moment in the life " +
            "of the early Church.",
            16, Color.BLACK, false
    );

    addText("1. Understanding Who the Holy Spirit Is", 18, Color.BLACK, true);
    addText(
            "The Holy Spirit is the Spirit of God. He is not merely a feeling or " +
            "an influence; He is the divine Helper whom Jesus promised to His " +
            "disciples. Through the Holy Spirit, believers receive help in their " +
            "Christian walk and are guided in the things of God. Understanding " +
            "the Holy Spirit helps us recognise the importance of His presence " +
            "in our lives.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:16–17; Acts 5:3–4.",
            15, Color.DKGRAY, false);

    addText("2. Jesus Promised to Send the Holy Spirit", 18, Color.BLACK, true);
    addText(
            "Jesus knew that His disciples would need divine help after His " +
            "departure. He therefore promised that the Father would send them " +
            "another Comforter who would remain with them. This promise showed " +
            "that the disciples would not be left alone to carry out the work " +
            "Jesus had given them. The Holy Spirit would continue to help and " +
            "strengthen them.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:16–18; John 15:26.",
            15, Color.DKGRAY, false);

    addText("3. The Holy Spirit Is Our Comforter and Helper", 18, Color.BLACK, true);
    addText(
            "Jesus described the Holy Spirit as the Comforter who would be with " +
            "His disciples. The Holy Spirit helps believers in their walk with " +
            "God and strengthens them to remain faithful. His presence reminds " +
            "us that God has not left us without help. We can depend on Him as " +
            "we face the responsibilities and challenges of Christian living.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:16; Romans 8:26.",
            15, Color.DKGRAY, false);

    addText("4. The Holy Spirit Guides Us into All Truth", 18, Color.BLACK, true);
    addText(
            "Jesus also promised that the Holy Spirit would guide His disciples " +
            "into all truth. He would help them understand and remember the " +
            "things Jesus had taught them. In the same way, believers should " +
            "remain attentive to the Holy Spirit and allow God's truth to shape " +
            "their understanding, decisions and conduct.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:26; John 16:13.",
            15, Color.DKGRAY, false);

    addText("5. The Promise of the Holy Spirit Was Fulfilled", 18, Color.BLACK, true);
    addText(
            "After His resurrection, Jesus instructed His disciples to wait for " +
            "the promise of the Father. He explained that they would receive " +
            "power when the Holy Spirit came upon them. The disciples obeyed " +
            "and waited together. On the Day of Pentecost, the promise was " +
            "fulfilled as the Holy Spirit came upon them.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 24:49; Acts 1:4–8; Acts 2:1–4.",
            15, Color.DKGRAY, false);

    addText("6. The Holy Spirit Empowers Believers", 18, Color.BLACK, true);
    addText(
            "Jesus promised that the disciples would receive power when the " +
            "Holy Spirit came upon them. This power would enable them to become " +
            "witnesses of Jesus Christ. The coming of the Holy Spirit was not " +
            "simply an experience for the disciples; it prepared them to carry " +
            "out the work of spreading the Gospel. Believers should therefore " +
            "recognise their need for the Holy Spirit's help in living and " +
            "sharing their faith.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 1:8; 2 Timothy 1:7.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Understand that the Holy Spirit is God's promised Helper.\n" +
            "2. Read and reflect on the promises Jesus made concerning the Holy Spirit.\n" +
            "3. Depend on God's help rather than relying only on your own strength.\n" +
            "4. Pay attention to the truth of God's Word as you seek His guidance.\n" +
            "5. Be willing to share your faith and represent Jesus Christ.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The Holy Spirit is God's promised Comforter and Helper. Jesus " +
            "promised to send Him to His disciples, and that promise was " +
            "fulfilled on the Day of Pentecost. The Holy Spirit guides, helps " +
            "and empowers believers to live for God and bear witness to Jesus Christ.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Why did Jesus promise to send the Holy Spirit to His disciples? " +
            "What does it mean to depend on the Holy Spirit for help and guidance " +
            "in your daily Christian life?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for the gift and promise of the Holy Spirit. " +
            "Help me to understand His presence and His work in my life. Teach me " +
            "to depend on His help, follow the truth of Your Word and live in a way " +
            "that honours You. Empower me to remain faithful and to be a true " +
            "witness of Jesus Christ. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showSeptemberWeekTwo() {

    addText("The Day of Pentecost: The Coming of the Holy Spirit",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "The Day of Pentecost was a significant moment in the history of " +
            "the early Church. It was the day the promise Jesus made concerning " +
            "the Holy Spirit was fulfilled. The disciples who had waited for " +
            "this promise experienced the coming of the Holy Spirit in a " +
            "remarkable way. This event brought a new boldness and empowerment " +
            "that helped them carry the message of Jesus Christ to others.",
            16, Color.BLACK, false
    );

    addText("1. The Disciples Waited for the Promise", 18, Color.BLACK, true);
    addText(
            "Before the Day of Pentecost, Jesus had instructed His disciples " +
            "to wait for the promise of the Father. He told them that they " +
            "would receive power when the Holy Spirit came upon them. They " +
            "therefore gathered and waited as Jesus had instructed. Their " +
            "experience teaches the importance of trusting God's promises " +
            "and following His instructions.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 24:49; Acts 1:4–8.",
            15, Color.DKGRAY, false);

    addText("2. A Sound Came from Heaven", 18, Color.BLACK, true);
    addText(
            "When the Day of Pentecost arrived, the disciples were gathered " +
            "together in one place. Suddenly, there came a sound from heaven " +
            "like a rushing mighty wind, and it filled the house where they " +
            "were sitting. This was part of the remarkable way in which the " +
            "coming of the Holy Spirit was manifested.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:1–2.",
            15, Color.DKGRAY, false);

    addText("3. Cloven Tongues Like as of Fire Appeared", 18, Color.BLACK, true);
    addText(
            "The Scriptures further record that there appeared unto the " +
            "disciples cloven tongues like as of fire, and one sat upon each " +
            "of them. This was another remarkable occurrence on the Day of " +
            "Pentecost. The event showed that the promise of the Holy Spirit " +
            "was being fulfilled among the waiting disciples.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:3.",
            15, Color.DKGRAY, false);

    addText("4. They Were Filled with the Holy Spirit", 18, Color.BLACK, true);
    addText(
            "The disciples were all filled with the Holy Ghost and began to " +
            "speak with other tongues as the Spirit gave them utterance. " +
            "This was a central part of the Pentecost experience recorded " +
            "in Scripture. They did not speak by their own ability; they " +
            "spoke as the Spirit enabled them.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:4.",
            15, Color.DKGRAY, false);

    addText("5. The Significance of the Day of Pentecost", 18, Color.BLACK, true);

    addText("A. The Holy Spirit Came Upon the Disciples", 17, Color.BLACK, true);
    addText(
            "The Holy Spirit came upon the apostles, fulfilling the promise " +
            "Jesus had made to them. They were no longer to depend only on " +
            "their own strength as they carried out the work entrusted to them.",
            16, Color.BLACK, false
    );

    addText("B. They Became Bold to Preach the Gospel", 17, Color.BLACK, true);
    addText(
            "The coming of the Holy Spirit brought boldness to the disciples. " +
            "They became courageous in proclaiming the Gospel of Jesus Christ. " +
            "The same disciples who had waited for the promise now began to " +
            "declare the message of Christ openly.",
            16, Color.BLACK, false
    );

    addText("C. They Spoke with Other Tongues", 17, Color.BLACK, true);
    addText(
            "As the Holy Spirit gave them utterance, the disciples spoke with " +
            "other tongues. This was one of the manifestations that accompanied " +
            "the coming of the Holy Spirit on the Day of Pentecost.",
            16, Color.BLACK, false
    );

    addText("D. Many People Believed in Jesus and Were Saved", 17, Color.BLACK, true);
    addText(
            "The events of Pentecost drew attention to the message being " +
            "proclaimed. As the Gospel was preached, many people believed " +
            "in Jesus Christ and were saved. The coming of the Holy Spirit " +
            "therefore helped advance the message of salvation.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:5–11, 37–41.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Trust God's promises and remain obedient to His instructions.\n" +
            "2. Recognise your need for the Holy Spirit's empowerment.\n" +
            "3. Be courageous in sharing the Gospel of Jesus Christ.\n" +
            "4. Allow your life and words to point others towards Jesus.\n" +
            "5. Remember that the work of spreading the Gospel is not meant " +
            "to depend on human strength alone.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The Day of Pentecost marked the fulfilment of Jesus' promise " +
            "concerning the Holy Spirit. The disciples were filled with the " +
            "Holy Spirit, spoke with other tongues and received boldness to " +
            "preach the Gospel. Through their witness, many people believed " +
            "in Jesus Christ.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "What happened on the Day of Pentecost? What changes did the " +
            "coming of the Holy Spirit bring to the disciples, and how can " +
            "their boldness in preaching the Gospel encourage you today?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for fulfilling Your promise by sending " +
            "the Holy Spirit. Help me to trust Your promises, remain obedient " +
            "to Your Word and depend on Your Spirit. Give me courage to stand " +
            "for Jesus Christ and share the Gospel with others. May my life " +
            "be a faithful witness of Your goodness. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showSeptemberWeekThree() {

    addText("The Significance and Manifestations of the Holy Spirit",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "The coming of the Holy Spirit brought empowerment and transformation " +
            "to the early believers. His work was seen through spiritual manifestations " +
            "and through the changes He produced in their lives. The Holy Spirit enables " +
            "believers to serve God, bear witness to Jesus Christ and develop godly " +
            "character. Therefore, understanding His manifestations involves looking " +
            "both at His supernatural work and at the fruit He produces in our daily lives.",
            16, Color.BLACK, false
    );

    addText("1. The Holy Spirit Gives Power to Witness", 18, Color.BLACK, true);
    addText(
            "One important reason Jesus promised the Holy Spirit was to empower His " +
            "disciples to become witnesses of Him. Before Pentecost, the disciples had " +
            "been instructed to wait for this power. When the Holy Spirit came upon " +
            "them, they received boldness to proclaim the Gospel. This teaches us that " +
            "sharing the message of Jesus Christ should not depend on human courage alone; " +
            "we need the help and empowerment of the Holy Spirit.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 1:8; Acts 4:31.",
            15, Color.DKGRAY, false);

    addText("2. The Manifestation of Speaking in Other Tongues", 18, Color.BLACK, true);
    addText(
            "On the Day of Pentecost, the disciples were filled with the Holy Spirit " +
            "and began to speak with other tongues as the Spirit gave them utterance. " +
            "This was one of the remarkable manifestations that accompanied the " +
            "coming of the Holy Spirit. It demonstrated that the disciples were " +
            "empowered by the Spirit rather than relying on their natural ability.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:1–4; Acts 10:44–46.",
            15, Color.DKGRAY, false);

    addText("3. The Manifestation of Prophecy", 18, Color.BLACK, true);
    addText(
            "The Scriptures reveal that the coming of the Holy Spirit is associated " +
            "with prophecy. Peter explained that the events of Pentecost fulfilled " +
            "the prophecy that God would pour out His Spirit upon all flesh. Sons " +
            "and daughters would prophesy, showing that the work of the Holy Spirit " +
            "was not limited to a particular group of people. God would work through " +
            "those who received His Spirit.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:16–18; Joel 2:28–29.",
            15, Color.DKGRAY, false);

    addText("4. The Manifestation of Visions and Dreams", 18, Color.BLACK, true);
    addText(
            "Peter also referred to the promise that young men would see visions " +
            "and old men would dream dreams when God poured out His Spirit. These " +
            "manifestations demonstrate that God can communicate and reveal things " +
            "according to His purpose. Believers should remain grounded in Scripture " +
            "and seek God's wisdom when considering spiritual experiences.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 2:17; Joel 2:28.",
            15, Color.DKGRAY, false);

    addText("5. Manifestation of the Fruit of the Spirit ", 18, Color.BLACK, true);
    addText(
            "Beyond supernatural manifestations, the presence of the Holy Spirit " +
            "should also be reflected in the character of a believer. Galatians " +
            "5:22–23 describes the fruit of the Spirit. These qualities show the " +
            "kind of life the Holy Spirit develops in us as we walk with God. " +
            "They should become visible in our attitudes, relationships, decisions " +
            "and everyday conduct.",
            16, Color.BLACK, false
    );

    addText("A. Love", 17, Color.BLACK, true);
    addText(
            "Love enables us to care for others sincerely, treat people with kindness " +
            "and show the kind of love that reflects God's character. It teaches us " +
            "not to live selfishly but to consider the well-being of others.",
            15, Color.BLACK, false
    );

    addText("B. Joy", 17, Color.BLACK, true);
    addText(
            "Joy gives us an inward gladness that is not controlled entirely by " +
            "our circumstances. It helps us remain thankful and hopeful in God " +
            "even when life becomes challenging.",
            15, Color.BLACK, false
    );

    addText("C. Peace", 17, Color.BLACK, true);
    addText(
            "Peace helps us remain calm and trust God instead of allowing fear, " +
            "confusion or unnecessary conflict to control our lives. It also " +
            "encourages us to live peacefully with others.",
            15, Color.BLACK, false
    );

    addText("D. Longsuffering", 17, Color.BLACK, true);
    addText(
            "Longsuffering means patience and the ability to endure difficulties " +
            "without quickly giving up or responding with anger. It helps us " +
            "remain patient with others and with the process of growth.",
            15, Color.BLACK, false
    );

    addText("E. Gentleness", 17, Color.BLACK, true);
    addText(
            "Gentleness is shown through a considerate and humble attitude. " +
            "It affects how we speak to people, correct others and respond " +
            "when disagreements arise.",
            15, Color.BLACK, false
    );

    addText("F. Goodness", 17, Color.BLACK, true);
    addText(
            "Goodness involves choosing what is right and showing kindness " +
            "through our actions. It encourages us to do good even when there " +
            "is no personal reward or recognition.",
            15, Color.BLACK, false
    );

    addText("G. Faith", 17, Color.BLACK, true);
    addText(
            "Faithfulness means being dependable, trustworthy and committed " +
            "to God. It should be seen in our words, promises, responsibilities " +
            "and relationship with others.",
            15, Color.BLACK, false
    );

    addText("H. Meekness", 17, Color.BLACK, true);
    addText(
            "Meekness is strength expressed with humility and self-control. " +
            "It helps us avoid pride, receive correction and treat others " +
            "with respect.",
            15, Color.BLACK, false
    );

    addText("I. Temperance", 17, Color.BLACK, true);
    addText(
            "Temperance means self-control. It helps us manage our emotions, " +
            "desires, words and actions instead of allowing them to control us. " +
            "It enables us to make choices that agree with God's Word.",
            15, Color.BLACK, false
    );

    addText("Scripture: Galatians 5:22–23.",
            15, Color.DKGRAY, false);

    addText("6. The Difference Between Spiritual Manifestations and the Fruit of the Spirit",
            18, Color.BLACK, true);
    addText(
            "Spiritual manifestations demonstrate the Holy Spirit's empowerment " +
            "and work through believers, while the fruit of the Spirit describes " +
            "the godly character He develops within them. Both are important in " +
            "the Christian life. A believer should not focus only on spiritual " +
            "experiences while neglecting love, patience, humility and self-control. " +
            "The work of the Holy Spirit should be reflected both in how we serve " +
            "God and in how we live.",
            16, Color.BLACK, false
    );
    addText("Scripture: Galatians 5:22–25; 1 Corinthians 12:4–7.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Depend on the Holy Spirit for boldness to share the Gospel.\n" +
            "2. Study the biblical accounts of the manifestations of the Holy Spirit.\n" +
            "3. Practise love and kindness in your relationships.\n" +
            "4. Learn to respond with patience and gentleness when challenged.\n" +
            "5. Develop faithfulness in your responsibilities.\n" +
            "6. Exercise self-control in your words, choices and behaviour.\n" +
            "7. Examine your daily conduct and identify areas where you need spiritual growth.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The Holy Spirit empowers believers for service and develops godly " +
            "character in their lives. His manifestations demonstrate His work " +
            "and empowerment, while the fruit of the Spirit shows the character " +
            "that should become evident in those who walk with Him.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Which fruit of the Spirit is most evident in my daily life? Which " +
            "qualities do I need to develop further? Do my attitudes and actions " +
            "reflect the work of the Holy Spirit in me?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for the Holy Spirit and His work in my life. " +
            "Help me to depend on His empowerment and to grow in the fruit of the " +
            "Spirit. Develop love, joy, peace, patience, gentleness, goodness, " +
            "faithfulness, meekness and self-control in me. Let my life reflect " +
            "Your character and help me become a faithful witness of Jesus Christ. " +
            "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showSeptemberWeekFour() {

    addText("The Work and Ministry of the Holy Spirit in the Life of a Believer",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "The Holy Spirit was not sent only for the disciples who lived during " +
            "the time of Jesus. His ministry remains important in the life of every " +
            "believer. Jesus promised that the Holy Spirit would be with His disciples " +
            "as their Comforter and Helper. He would guide them into all truth and " +
            "empower them to fulfil the work God had given them. Understanding His " +
            "ministry helps us recognise our dependence on Him in our daily Christian walk.",
            16, Color.BLACK, false
    );

    addText("1. The Holy Spirit Is Our Comforter", 18, Color.BLACK, true);
    addText(
            "Jesus promised His disciples another Comforter who would abide with " +
            "them. This promise reveals the care of God for His people. The Holy " +
            "Spirit comforts and strengthens believers, reminding them that they " +
            "are not left alone in their walk with God. In times of difficulty, " +
            "we can depend on God's presence and find strength in Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:16–18; John 15:26.",
            15, Color.DKGRAY, false);

    addText("2. The Holy Spirit Is Our Helper", 18, Color.BLACK, true);
    addText(
            "There are situations in which human strength and understanding are " +
            "not enough. The Holy Spirit helps believers in their weaknesses and " +
            "assists them in their walk with God. We should therefore learn to " +
            "depend on His help rather than believing that we can accomplish " +
            "everything through our own strength.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 8:26; John 14:16.",
            15, Color.DKGRAY, false);

    addText("3. The Holy Spirit Guides Us into All Truth", 18, Color.BLACK, true);
    addText(
            "One of the important ministries of the Holy Spirit is to guide " +
            "believers into all truth. Jesus explained that the Spirit would " +
            "teach His disciples and remind them of the things He had spoken. " +
            "The Holy Spirit helps us understand God's truth and directs our " +
            "attention to what agrees with His Word. We must remain willing " +
            "to learn, obey and follow the truth revealed in Scripture.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:26; John 16:13.",
            15, Color.DKGRAY, false);

    addText("4. The Holy Spirit Empowers Us to Be Witnesses", 18, Color.BLACK, true);
    addText(
            "Jesus told His disciples that they would receive power after the " +
            "Holy Spirit came upon them and that they would become His witnesses. " +
            "The Holy Spirit gives believers the boldness and strength needed " +
            "to proclaim the Gospel. This means that sharing our faith and " +
            "representing Christ should be done with dependence on the Spirit " +
            "rather than human confidence alone.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 1:8; Acts 4:31.",
            15, Color.DKGRAY, false);

    addText("5. The Holy Spirit Helps Us Live for God", 18, Color.BLACK, true);
    addText(
            "The Christian life is not meant to be lived by human effort alone. " +
            "Believers need the Holy Spirit's help to walk in obedience and " +
            "resist the desires that oppose God's will. As we yield ourselves " +
            "to His leading, our conduct should increasingly reflect the " +
            "character that pleases God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Galatians 5:16; Romans 8:13–14.",
            15, Color.DKGRAY, false);

    addText("6. The Holy Spirit Helps Us Remember the Teachings of Jesus",
            18, Color.BLACK, true);
    addText(
            "Jesus explained that the Comforter, the Holy Ghost, would teach " +
            "His disciples all things and bring His words to their remembrance. " +
            "This ministry helped the disciples understand and remember the " +
            "teachings of Jesus. It also reminds believers of the importance " +
            "of learning God's Word and depending on the Holy Spirit as they " +
            "grow in understanding and obedience.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 14:26.",
            15, Color.DKGRAY, false);

    addText("7. The Holy Spirit Makes Us Effective in God's Work",
            18, Color.BLACK, true);
    addText(
            "The Holy Spirit empowers believers to serve God and contribute " +
            "to the work of His Kingdom. The early disciples were strengthened " +
            "to preach the Gospel, and their witness helped many people hear " +
            "and believe the message of Jesus Christ. We should not treat our " +
            "abilities as substitutes for the Spirit's help. Instead, we should " +
            "serve faithfully while depending on God for strength and direction.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 1:8; 1 Corinthians 12:4–7.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Depend on the Holy Spirit in your daily Christian walk.\n" +
            "2. Seek His guidance through prayer and the study of God's Word.\n" +
            "3. Remain willing to learn and obey the truth of Scripture.\n" +
            "4. Ask God for boldness to share the Gospel with others.\n" +
            "5. Do not depend entirely on your own strength when facing challenges.\n" +
            "6. Make room for spiritual growth by yielding your life to God's leading.\n" +
            "7. Serve God faithfully and use your abilities to benefit others.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The Holy Spirit is our Comforter, Helper and Guide. He teaches, " +
            "strengthens and empowers believers to live for God and fulfil " +
            "their responsibilities as witnesses of Jesus Christ. We must " +
            "learn to depend on His ministry rather than relying only on " +
            "our natural strength and understanding.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Do I depend on the Holy Spirit in my daily decisions and Christian " +
            "responsibilities? Am I willing to follow His guidance through " +
            "God's Word? How can I become a more effective witness of Jesus Christ?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for the gift and ministry of the Holy " +
            "Spirit. Help me to depend on Him as my Comforter, Helper and Guide. " +
            "Teach me to understand Your Word, obey Your instructions and walk " +
            "in Your truth. Give me boldness to share the Gospel and strength " +
            "to live a life that honours You. May I become more effective in " +
            "serving You and fulfilling Your purpose for my life. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showOctoberWeekOne() {

    addText("Understanding the Faith That Moves Mountains",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Faith is an important part of the Christian life. It enables us to " +
            "trust God beyond what we can see, understand or accomplish through " +
            "our natural ability. Faith gives us access to the world of unlimited " +
            "possibilities because it rests on the power and faithfulness of God. " +
            "It is not merely a positive thought; it is a confident response to " +
            "God and His Word.",
            16, Color.BLACK, false
    );

    addText("1. What Is Faith?", 18, Color.BLACK, true);
    addText(
            "Faith is access to the world of unlimited possibilities. It is the " +
            "confidence that God is able to do what He has promised, even when " +
            "the circumstances around us appear impossible. Faith looks beyond " +
            "what is visible and depends on God's ability rather than human limitations. " +
            "When Jesus said that all things are possible to him that believeth, " +
            "He showed the importance of believing in God's power.",
            16, Color.BLACK, false
    );
    addText("Scripture: Mark 9:23–27; Hebrews 11:1.",
            15, Color.DKGRAY, false);

    addText("2. Faith Is a Living Force", 18, Color.BLACK, true);
    addText(
            "Faith is a living force drawn from the living Word of God to produce " +
            "living proofs. Genuine faith is not empty talk or mere agreement with " +
            "a statement. It begins with believing God's Word and is demonstrated " +
            "through the way we live, speak and act. When we receive God's Word " +
            "with faith, it influences our decisions and gives us confidence to " +
            "obey Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 10:17; James 2:17–18.",
            15, Color.DKGRAY, false);

    addText("3. Faith Gives Access to Unlimited Possibilities", 18, Color.BLACK, true);
    addText(
            "There are situations that may appear beyond human ability, but faith " +
            "reminds us that God is not limited by what we see. In Mark 9, a father " +
            "brought his son to Jesus and needed help to believe. Jesus directed his " +
            "attention to the possibility of God's intervention. This account teaches " +
            "us to bring our difficulties to God and trust Him rather than allowing " +
            "impossible-looking circumstances to determine what we believe.",
            16, Color.BLACK, false
    );
    addText("Scripture: Mark 9:23–27; Luke 1:37.",
            15, Color.DKGRAY, false);

    addText("4. Faith Is Demonstrated Through Our Actions", 18, Color.BLACK, true);
    addText(
            "Faith should influence what we do, not only what we say. In Matthew 14, " +
            "Peter stepped out of the boat at the word of Jesus and walked on the " +
            "water. When he became afraid because of the wind, he began to sink and " +
            "cried out to Jesus for help. This account shows the importance of keeping " +
            "our attention on Christ and trusting His Word even when circumstances " +
            "become frightening.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 14:23–31; James 2:17.",
            15, Color.DKGRAY, false);

    addText("5. Faith Must Be Strengthened and Protected", 18, Color.BLACK, true);
    addText(
            "Our faith can face challenges, doubts and difficult circumstances. " +
            "Jesus warned Peter that Satan desired to sift him as wheat, but Jesus " +
            "also said that He had prayed for Peter's faith not to fail. This reminds " +
            "us that our faith is valuable and must be strengthened through our " +
            "relationship with God, prayer and attention to His Word. When challenges " +
            "come, we should not abandon our trust in God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 22:31–32; 1 Peter 1:6–7.",
            15, Color.DKGRAY, false);

    addText("6. Faith Helps Us Live in Righteousness", 18, Color.BLACK, true);
    addText(
            "Faith is not only for receiving answers to prayers or overcoming " +
            "difficult situations. It also affects how we live before God. Through " +
            "faith, we trust God's instructions and choose to walk in obedience. " +
            "A life of faith should therefore be reflected in our conduct, decisions " +
            "and commitment to doing what pleases God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 1:17; Hebrews 10:38.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Read and meditate on God's Word so that your faith can be strengthened.\n" +
            "2. Bring difficult situations to God instead of allowing fear to control you.\n" +
            "3. Practise obeying God's Word even when it requires courage.\n" +
            "4. Keep your attention on Christ when challenges arise.\n" +
            "5. Protect your faith through prayer and consistent fellowship with God.\n" +
            "6. Let your faith be reflected in your daily actions and conduct.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Faith gives us access to the world of unlimited possibilities because " +
            "it places our confidence in God and His Word. It is a living force that " +
            "should produce visible evidence through our actions and way of life. " +
            "We must continue to strengthen and protect our faith, especially when " +
            "we face challenges.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "What does faith mean to me? Do I depend on God's Word when circumstances " +
            "become difficult? Is my faith visible through my actions, decisions " +
            "and daily relationship with God?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for Your Word and for the gift of faith. " +
            "Help me to trust You even when I face difficult situations. Strengthen " +
            "my faith, remove fear and doubt from my heart, and teach me to keep " +
            "my attention on Jesus Christ. Let my faith produce visible evidence " +
            "through my actions and my obedience to Your Word. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showOctoberWeekTwo() {

    addText("The Characteristics and Expressions of Genuine Faith",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Genuine faith is more than saying that we believe in God. It is a " +
            "living confidence in God and His Word that influences our thoughts, " +
            "words and actions. Faith should be evident in the way we respond to " +
            "challenges, obey God's instructions and approach the responsibilities " +
            "of life. When faith is active in us, it produces evidence through the " +
            "way we live.",
            16, Color.BLACK, false
    );

    addText("1. Genuine Faith Is a Living Force", 18, Color.BLACK, true);
    addText(
            "Faith is a living force drawn from the living Word of God to produce " +
            "living proofs. It is not merely an idea or an empty confession. It " +
            "begins when we receive God's Word and allow it to influence our lives. " +
            "A person who genuinely believes God's Word should show that belief " +
            "through obedience, confidence and practical actions.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 10:17; James 2:17–18.",
            15, Color.DKGRAY, false);

    addText("2. Genuine Faith Believes God's Word", 18, Color.BLACK, true);
    addText(
            "Faith depends on what God has spoken rather than being controlled " +
            "only by what the eyes can see. Abraham believed God's promise even " +
            "when the circumstances appeared difficult. Genuine faith therefore " +
            "requires us to take God's Word seriously and trust His faithfulness " +
            "even when we have not yet seen the outcome.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 4:18–21; Hebrews 11:1.",
            15, Color.DKGRAY, false);

    addText("3. Genuine Faith Is Expressed Through Our Words", 18, Color.BLACK, true);
    addText(
            "What we believe should influence what we say. Faith-filled speech " +
            "agrees with God's Word instead of allowing fear and discouragement " +
            "to control our confession. This does not mean pretending that " +
            "problems do not exist; it means speaking with confidence in God's " +
            "promises while continuing to trust and obey Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Mark 11:22–23; 2 Corinthians 4:13.",
            15, Color.DKGRAY, false);

    addText("4. Genuine Faith Is Demonstrated Through Obedience",
            18, Color.BLACK, true);
    addText(
            "Faith is demonstrated when we act on what God has said. It is not " +
            "enough to hear God's instructions and agree with them without " +
            "putting them into practice. Genuine faith moves us to obey God, " +
            "even when obedience requires patience, courage or sacrifice. " +
            "Our actions should give evidence of what we believe.",
            16, Color.BLACK, false
    );
    addText("Scripture: James 2:17–24; Hebrews 11:8.",
            15, Color.DKGRAY, false);

    addText("5. Genuine Faith Produces Confidence in God",
            18, Color.BLACK, true);
    addText(
            "Faith gives us confidence to depend on God when we face uncertainty. " +
            "It does not mean that we will never experience fear or difficulty. " +
            "Rather, it means that we choose to trust God's ability and faithfulness " +
            "instead of allowing difficult circumstances to become greater than " +
            "our confidence in Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Proverbs 3:5–6; Hebrews 10:35–36.",
            15, Color.DKGRAY, false);

    addText("6. Genuine Faith Can Grow to Greater Levels",
            18, Color.BLACK, true);
    addText(
            "The Scriptures speak about different expressions and measures of " +
            "faith. Jesus spoke about little faith and great faith, showing that " +
            "believers should not remain stagnant in their confidence in God. " +
            "As we continue to receive God's Word, practise obedience and depend " +
            "on Him, our faith can become stronger and more mature.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 8:10; Matthew 14:31; Romans 12:3.",
            15, Color.DKGRAY, false);

    addText("7. Genuine Faith Produces Visible Results",
            18, Color.BLACK, true);
    addText(
            "Faith should not remain hidden in our hearts without influencing " +
            "our lives. Its evidence can be seen in our obedience, perseverance, " +
            "love and willingness to follow God's instructions. The lives of " +
            "people recorded in Hebrews 11 demonstrate how faith influenced " +
            "their decisions and actions. Genuine faith produces a life that " +
            "shows confidence in God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Hebrews 11:1–10; James 2:18.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Read God's Word regularly and allow it to shape your beliefs.\n" +
            "2. Speak in agreement with God's promises rather than allowing fear to control you.\n" +
            "3. Put your faith into action through obedience to God's instructions.\n" +
            "4. Trust God when circumstances are uncertain or difficult.\n" +
            "5. Keep growing through prayer, study and consistent obedience.\n" +
            "6. Let your actions demonstrate the faith you profess.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Genuine faith is a living confidence in God and His Word. It is " +
            "expressed through our words, obedience, decisions and daily conduct. " +
            "It can grow stronger as we continue to walk with God, and its " +
            "evidence should be seen in the way we live.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Does my daily conduct agree with what I say I believe? Do I act " +
            "on God's Word when obedience is difficult? What can I do to " +
            "strengthen my faith and allow it to become more evident in my life?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for Your Word and for the gift of faith. " +
            "Help me to develop genuine faith that influences my thoughts, words " +
            "and actions. Teach me to trust Your promises, obey Your instructions " +
            "and remain confident in You during difficult times. Let my life " +
            "produce evidence of my faith and bring glory to Your name. " +
            "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showOctoberWeekThree() {

    addText("The Faith That Overcomes Challenges and Produces Results",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Every believer will encounter situations that test their faith. " +
            "There may be moments when circumstances appear difficult, answers " +
            "seem delayed or the way forward is unclear. However, faith enables " +
            "us to remain confident in God and His promises. Overcoming challenges " +
            "through faith does not mean that difficulties will never occur; it " +
            "means that we continue to trust God and follow His Word even in the " +
            "midst of them.",
            16, Color.BLACK, false
    );

    addText("1. Faith Keeps Us Confident in God's Promises",
            18, Color.BLACK, true);
    addText(
            "One way faith helps us overcome challenges is by keeping our " +
            "confidence in what God has promised. Abraham faced circumstances " +
            "that appeared contrary to God's promise, yet he remained strong " +
            "in faith and gave glory to God. His example teaches us not to allow " +
            "what we see around us to destroy our confidence in God's faithfulness. " +
            "We must learn to hold firmly to His Word.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 4:18–21; Hebrews 10:23.",
            15, Color.DKGRAY, false);

    addText("2. Faith Helps Us Overcome Fear and Doubt",
            18, Color.BLACK, true);
    addText(
            "Fear and doubt can weaken our confidence when we face difficult " +
            "situations. In Matthew 14, Peter began walking on the water towards " +
            "Jesus, but when he noticed the strong wind, he became afraid and " +
            "began to sink. Jesus reached out and helped him. This account teaches " +
            "us to keep our attention on Christ rather than allowing frightening " +
            "circumstances to control our response. When fear arises, we should " +
            "turn to God for help.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 14:28–31; 2 Timothy 1:7.",
            15, Color.DKGRAY, false);

    addText("3. Faith Gives Us Strength to Persevere",
            18, Color.BLACK, true);
    addText(
            "Sometimes the answer to a prayer does not come immediately. During " +
            "such moments, faith teaches us to remain patient and continue trusting " +
            "God. We should not abandon what is right simply because we have not " +
            "seen the result we desire. Perseverance helps us remain committed " +
            "to God's instructions while waiting on Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Galatians 6:9; Hebrews 10:35–36.",
            15, Color.DKGRAY, false);

    addText("4. Faith Moves Us to Take Action",
            18, Color.BLACK, true);
    addText(
            "Genuine faith is expressed through action. It is not enough to " +
            "say that we believe if we are unwilling to obey God's instructions. " +
            "James explains that faith without works is dead. This means that " +
            "our actions should agree with what we profess to believe. When God " +
            "gives us direction through His Word, we must be willing to act upon it.",
            16, Color.BLACK, false
    );
    addText("Scripture: James 2:17–18; Hebrews 11:8.",
            15, Color.DKGRAY, false);

    addText("5. Faith Enables Us to Face Impossible Situations",
            18, Color.BLACK, true);
    addText(
            "There are situations that may appear impossible from a human " +
            "perspective. However, God's power is not limited by human ability. " +
            "When a father brought his son to Jesus, he asked for help with " +
            "his unbelief. Jesus responded by teaching him about the possibility " +
            "of believing. This account encourages us to bring our difficulties " +
            "to God and trust Him even when we do not know how the solution will come.",
            16, Color.BLACK, false
    );
    addText("Scripture: Mark 9:17–27; Luke 1:37.",
            15, Color.DKGRAY, false);

    addText("6. Faith Produces Results According to God's Will",
            18, Color.BLACK, true);
    addText(
            "Faith is not simply a way of trying to obtain whatever we desire. " +
            "It is confidence in God, His wisdom and His promises. We must " +
            "therefore bring our requests before Him while remaining willing " +
            "to trust His will. The results of faith may be seen through answered " +
            "prayer, strengthened character, obedience, perseverance and God's " +
            "work in our lives.",
            16, Color.BLACK, false
    );
    addText("Scripture: 1 John 5:14–15; Hebrews 11:6.",
            15, Color.DKGRAY, false);

    addText("7. Faith Gives Us Victory Through Christ",
            18, Color.BLACK, true);
    addText(
            "The Christian life involves challenges, but believers are encouraged " +
            "to remain confident in Christ. Victory does not mean that we will " +
            "never experience hardship. It means that hardship does not have to " +
            "separate us from God's love or cause us to abandon our faith. Through " +
            "Christ, we can remain steadfast and continue living according to God's Word.",
            16, Color.BLACK, false
    );
    addText("Scripture: 1 John 5:4–5; Romans 8:35–39.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Identify a challenge that is testing your faith and take it to God in prayer.\n" +
            "2. Find relevant promises in God's Word and meditate on them.\n" +
            "3. Refuse to let fear and discouragement control your decisions.\n" +
            "4. Remain patient and continue doing what is right while waiting on God.\n" +
            "5. Put your faith into action through obedience to God's instructions.\n" +
            "6. Trust God's wisdom and remain committed to His will, whatever the outcome.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Faith enables us to face challenges with confidence in God. It helps " +
            "us overcome fear, persevere through difficult seasons, obey God's " +
            "Word and remain steadfast. Genuine faith is not merely spoken; it " +
            "is demonstrated through our actions and continued trust in God.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "When I face difficult situations, do I respond with faith or allow " +
            "fear to control me? Am I willing to obey God's Word even when the " +
            "outcome is not yet clear? What challenge do I need to commit to God today?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You because I can depend on You in every " +
            "situation. Strengthen my faith when I face challenges. Help me " +
            "overcome fear and doubt, remain patient during difficult seasons " +
            "and obey Your Word. Teach me to trust Your wisdom and remain " +
            "steadfast in Christ. Let my life demonstrate genuine faith through " +
            "my words and actions. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showOctoberWeekFour() {

    addText("How to Develop and Grow Your Faith",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Faith is essential to the Christian life, but it is also something " +
            "that believers must continually develop. We should not remain at " +
            "the same level of faith throughout our walk with God. Just as the " +
            "body grows through proper nourishment, our faith grows as we receive " +
            "God's Word, maintain fellowship with Him and put His instructions " +
            "into practice. Developing our faith requires commitment, consistency " +
            "and a willingness to trust God in every area of life.",
            16, Color.BLACK, false
    );

    addText("1. Build Your Faith Through the Word of God",
            18, Color.BLACK, true);
    addText(
            "The Word of God is one of the primary ways through which our faith " +
            "is developed. Romans 10:17 teaches that faith comes by hearing the " +
            "Word of God. This means that we must regularly read, hear, study and " +
            "meditate on Scripture. As we become more familiar with God's promises " +
            "and instructions, our confidence in Him becomes stronger. We should " +
            "make the Word a consistent part of our daily lives rather than " +
            "depending on it only when difficulties arise.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 10:17; Joshua 1:8; Psalm 1:2–3.",
            15, Color.DKGRAY, false);

    addText("2. Develop a Consistent Prayer Life",
            18, Color.BLACK, true);
    addText(
            "Prayer helps us maintain fellowship and communication with God. " +
            "Through prayer, we express our dependence on Him, seek His guidance " +
            "and bring our concerns before Him. A consistent prayer life helps " +
            "us remain spiritually attentive and strengthens our relationship " +
            "with our Heavenly Father. We should therefore create time to pray " +
            "regularly and not allow our busy schedules to replace our fellowship " +
            "with God.",
            16, Color.BLACK, false
    );
    addText("Scripture: 1 Thessalonians 5:17; Luke 18:1; Philippians 4:6–7.",
            15, Color.DKGRAY, false);

    addText("3. Exercise Your Faith Through Obedience",
            18, Color.BLACK, true);
    addText(
            "Faith grows when we act upon what God has said. It is not enough " +
            "to hear His Word without making a decision to obey it. Abraham " +
            "demonstrated faith when he obeyed God's instruction to leave his " +
            "country and go to the place God would show him. In the same way, " +
            "we must be willing to follow God's instructions even when we do " +
            "not understand every detail. Each act of obedience gives us an " +
            "opportunity to practise trusting Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: James 2:17–18; Hebrews 11:8; John 14:23.",
            15, Color.DKGRAY, false);

    addText("4. Guard Your Heart Against Fear and Doubt",
            18, Color.BLACK, true);
    addText(
            "Fear and doubt can weaken our confidence in God when we allow " +
            "them to dominate our thoughts. This is why we must pay attention " +
            "to what we believe and what we allow to influence our hearts. " +
            "Whenever negative thoughts arise, we should return to the truth " +
            "of God's Word and remind ourselves of His faithfulness. Growing " +
            "faith does not mean that questions or difficult feelings will never " +
            "arise; it means learning to turn to God rather than allowing fear " +
            "to determine our decisions.",
            16, Color.BLACK, false
    );
    addText("Scripture: Proverbs 4:23; 2 Timothy 1:7; Mark 9:24.",
            15, Color.DKGRAY, false);

    addText("5. Associate with People Who Strengthen Your Faith",
            18, Color.BLACK, true);
    addText(
            "The people we regularly associate with can influence our beliefs, " +
            "attitudes and decisions. It is important to build relationships " +
            "with people who encourage us to follow Christ and remain committed " +
            "to God's Word. Fellowship with other believers gives us opportunities " +
            "to learn, encourage one another and grow together. We should choose " +
            "companionship that helps us become stronger in our walk with God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Hebrews 10:24–25; Proverbs 13:20; 1 Thessalonians 5:11.",
            15, Color.DKGRAY, false);

    addText("6. Remain Patient and Steadfast in Your Walk with God",
            18, Color.BLACK, true);
    addText(
            "Faith development is a continuous journey. There will be times " +
            "when we must wait, remain patient and continue trusting God. We " +
            "should not become discouraged because our growth or desired results " +
            "do not appear immediately. Instead, we must remain committed to " +
            "God's Word and continue doing what is right. As we remain steadfast, " +
            "we develop spiritual maturity and become better prepared to face " +
            "the challenges of life.",
            16, Color.BLACK, false
    );
    addText("Scripture: Hebrews 10:35–36; Galatians 6:9; James 1:3–4.",
            15, Color.DKGRAY, false);

    addText("7. Put Your Faith into Practice Every Day",
            18, Color.BLACK, true);
    addText(
            "Faith should be visible in our everyday lives. It should influence " +
            "how we speak, make decisions, treat others and respond to difficult " +
            "situations. We must not limit the practice of faith to church " +
            "activities or moments of prayer. Instead, we should demonstrate " +
            "trust in God through honesty, love, forgiveness, responsibility " +
            "and obedience. As we consistently apply God's Word, our faith " +
            "becomes an active part of our daily living.",
            16, Color.BLACK, false
    );
    addText("Scripture: Colossians 3:17; 2 Corinthians 5:7; James 2:18.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Set aside time each day to read and meditate on God's Word.\n" +
            "2. Develop a regular prayer routine and remain consistent in it.\n" +
            "3. Identify one instruction from Scripture and make a deliberate effort to obey it.\n" +
            "4. Replace thoughts of fear and doubt with the truth of God's Word.\n" +
            "5. Build friendships with people who encourage your spiritual growth.\n" +
            "6. Remain patient and steadfast when answers or results seem delayed.\n" +
            "7. Practise your faith through your words, choices and actions every day.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Faith grows as we continually receive God's Word, maintain fellowship " +
            "with Him, obey His instructions and put what we believe into practice. " +
            "We must be intentional about our spiritual growth and remain steadfast " +
            "in our walk with God. Developing faith is not a one-time experience; " +
            "it is a lifelong commitment to trusting and following Him.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Am I making time to study God's Word and pray consistently? Do my " +
            "actions agree with what I profess to believe? What changes can I " +
            "make today to strengthen my faith and grow in my relationship with God?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for giving me the opportunity to grow " +
            "in faith. Help me to love Your Word, remain consistent in prayer " +
            "and obey Your instructions. Strengthen my heart against fear and " +
            "doubt. Lead me into relationships that encourage my spiritual " +
            "growth, and teach me to remain patient and steadfast in every " +
            "season. May my faith be evident in my words, decisions and actions. " +
            "Help me to grow daily in my walk with You. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showNovemberWeekOne() {

    addText("What Is Praise?",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Praise is an important part of our relationship with God. " +
            "It is an expression of appreciation, honour and acknowledgement " +
            "of who God is and what He has done. When we praise God, we " +
            "recognise His greatness, goodness, faithfulness and mighty works. " +
            "Praise should not be limited to moments when everything is going " +
            "well. We can praise God because He remains worthy of our praise " +
            "in every season of life.",
            16, Color.BLACK, false
    );

    addText("1. Understanding the Meaning of Praise",
            18, Color.BLACK, true);
    addText(
            "Praise means expressing admiration, appreciation and honour " +
            "towards God for His greatness and goodness. It involves declaring " +
            "His wonderful attributes, acknowledging His mighty works and " +
            "giving Him the glory He deserves. Praise is more than singing " +
            "songs; it is an expression of a heart that recognises the greatness " +
            "of God. Through praise, we openly declare that God is worthy of " +
            "honour, worship and thanksgiving.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 100:4; Psalm 150:1–2; Psalm 145:3.",
            15, Color.DKGRAY, false);

    addText("2. Praise Is Appreciating and Acknowledging God",
            18, Color.BLACK, true);
    addText(
            "Praise involves appreciating God for who He is and acknowledging " +
            "Him for what He has done, what He is doing and what He will yet " +
            "do. We should never become so occupied with our daily activities " +
            "that we forget His goodness. David understood the importance of " +
            "remembering God's benefits. In Psalm 103, he encouraged his soul " +
            "to bless the Lord and remember all His benefits. In the same way, " +
            "we should develop a heart that continually recognises God's " +
            "faithfulness and expresses gratitude to Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 103:1–5; Psalm 34:1; Psalm 107:1–2.",
            15, Color.DKGRAY, false
    );

    addText("3. Praise Is a Commandment",
            18, Color.BLACK, true);
    addText(
            "Praising God is not something we should do only when we feel " +
            "happy or when we receive something from Him. Scripture repeatedly " +
            "instructs us to praise the Lord. This shows that praise is an " +
            "important responsibility in the life of every believer. Even " +
            "when circumstances are difficult, we can still recognise God's " +
            "goodness and remain grateful to Him. We should therefore make " +
            "praise a consistent part of our Christian lives.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 150:1–2; Hebrews 13:15; Psalm 34:1.",
            15, Color.DKGRAY, false
    );

    addText("4. Why Praise Is Important in Our Walk with God",
            18, Color.BLACK, true);
    addText(
            "Praise helps us keep our attention on God rather than allowing " +
            "our circumstances to become the centre of our lives. It reminds " +
            "us of His greatness, strengthens our gratitude and encourages " +
            "us to remain conscious of His presence. Praise also helps us " +
            "express our confidence in God even during difficult seasons. " +
            "Paul and Silas demonstrated this when they prayed and sang praises " +
            "to God while in prison. Their circumstances did not prevent them " +
            "from honouring God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 16:25–26; Psalm 34:1; Psalm 92:1–2.",
            15, Color.DKGRAY, false
    );

    addText("5. The Role of Praise in Divine Intervention",
            18, Color.BLACK, true);
    addText(
            "Praise is one of the ways believers express their dependence " +
            "and confidence in God. An important example is the experience " +
            "of King Jehoshaphat in 2 Chronicles 20. When a great multitude " +
            "came against Judah, Jehoshaphat sought the Lord and encouraged " +
            "the people to trust Him. He appointed singers to praise the Lord " +
            "as the army went out. As they began to sing and praise, the Lord " +
            "set ambushments against their enemies, and Judah experienced a " +
            "great victory. This account teaches us that when we face challenges, " +
            "we should seek God, trust His Word and continue to honour Him. " +
            "God deserves our praise, and He remains able to intervene in " +
            "situations beyond our human ability.",
            16, Color.BLACK, false
    );
    addText("Scripture: 2 Chronicles 20:17; 2 Chronicles 20:21–22.",
            15, Color.DKGRAY, false
    );

    addText("6. Praise and Victory Over the Enemy",
            18, Color.BLACK, true);
    addText(
            "Praise helps us maintain our confidence in God when we face " +
            "opposition. David provides a powerful example of someone who " +
            "continually acknowledged and praised the Lord. In Psalm 18, " +
            "David declared that he would call upon the Lord, who is worthy " +
            "to be praised. David understood that his strength and deliverance " +
            "came from God, not merely from his own ability. His life teaches " +
            "us to look to God for strength and to give Him the glory for " +
            "every victory. We must remember that praise is not a magical " +
            "formula for controlling outcomes; our confidence must remain " +
            "in God and His wisdom.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 18:3; Psalm 34:1; Psalm 149:6–9.",
            15, Color.DKGRAY, false
    );

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Make time every day to appreciate God for who He is.\n" +
            "2. Remember His goodness and acknowledge what He has done in your life.\n" +
            "3. Develop the habit of praising God even when circumstances are difficult.\n" +
            "4. Read and meditate on biblical accounts of people who praised God.\n" +
            "5. Follow the examples of David and Jehoshaphat by trusting God in difficult situations.\n" +
            "6. Use songs, thanksgiving and sincere words to express your praise to God.\n" +
            "7. Give God the glory rather than taking credit for what He has helped you accomplish.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Praise is the expression of appreciation, honour and acknowledgement " +
            "of God for who He is and what He has done. It is a commandment and " +
            "an important part of our walk with God. Through the examples of " +
            "David and Jehoshaphat, we learn to remain confident in God, " +
            "acknowledge His greatness and praise Him in every season of life.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Do I appreciate God only when things are going well, or do I " +
            "recognise His greatness in every season? Am I intentional about " +
            "remembering His goodness and giving Him the glory? What can I " +
            "begin doing differently to make praise a consistent part of my life?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You for Your goodness, faithfulness and " +
            "greatness. Forgive me for the times I have forgotten to appreciate " +
            "You. Give me a grateful heart that continually acknowledges who " +
            "You are and what You have done. Teach me to praise You in every " +
            "season, whether things are easy or difficult. Help me to follow " +
            "the examples of David and Jehoshaphat by trusting You and giving " +
            "You the glory in all things. May my life continually bring honour " +
            "to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showNovemberWeekTwo() {

    addText("Understanding the Power of Praise",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Praise is more than an expression of happiness or a religious " +
            "activity. It is an important spiritual expression through which " +
            "we acknowledge God's greatness, honour His name and demonstrate " +
            "our confidence in Him. Throughout Scripture, we see how people " +
            "praised God in difficult situations and experienced His intervention. " +
            "Understanding the power of praise helps us recognise why it should " +
            "remain an important part of our relationship with God.",
            16, Color.BLACK, false
    );

    addText("1. Praise Invites Us to Recognise God's Presence",
            18, Color.BLACK, true);
    addText(
            "When we praise God, we turn our attention towards Him and " +
            "acknowledge His greatness. Praise helps us become conscious of " +
            "His presence rather than allowing our circumstances to dominate " +
            "our thoughts. Psalm 22:3 describes God as inhabiting the praises " +
            "of Israel. This reminds us of the special place praise has in " +
            "our relationship with Him. We should approach God with reverence, " +
            "thanksgiving and sincere hearts.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 22:3; Psalm 100:4; Psalm 95:1–3.",
            15, Color.DKGRAY, false
    );

    addText("2. Praise Is a Key to Divine Intervention",
            18, Color.BLACK, true);
    addText(
            "One of the remarkable examples of praise in Scripture is the " +
            "experience of King Jehoshaphat. When Judah faced a great army, " +
            "Jehoshaphat sought the Lord and encouraged the people to trust " +
            "Him. Singers were appointed to go before the army, praising God " +
            "for His mercy. As they began to sing and praise, the Lord caused " +
            "confusion among their enemies, and Judah experienced victory. " +
            "This account teaches us to seek God and remain confident in Him " +
            "when we face situations beyond our ability.",
            16, Color.BLACK, false
    );
    addText("Scripture: 2 Chronicles 20:17–22.",
            15, Color.DKGRAY, false
    );

    addText("3. Praise Helps Us Overcome Difficult Situations",
            18, Color.BLACK, true);
    addText(
            "Praise does not mean that difficulties will never occur. Rather, " +
            "it teaches us to keep our confidence in God even when situations " +
            "are challenging. Paul and Silas demonstrated this when they were " +
            "imprisoned. Instead of allowing their situation to stop them from " +
            "honouring God, they prayed and sang praises at midnight. Suddenly, " +
            "there was a great earthquake, the prison foundations were shaken " +
            "and the prison doors were opened. Their example teaches us that " +
            "we can continue to praise God even in difficult seasons.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 16:22–26.",
            15, Color.DKGRAY, false
    );

    addText("4. Praise Helps Us Remember God's Goodness and Faithfulness",
            18, Color.BLACK, true);
    addText(
            "Praise helps us remember that God has been faithful in the past " +
            "and remains worthy of our trust. David regularly encouraged his " +
            "soul to bless the Lord and remember His benefits. When we remember " +
            "God's goodness, forgiveness, mercy and provision, we develop a " +
            "grateful heart. Instead of concentrating only on what we lack, " +
            "we learn to recognise the many reasons we have to give God thanks.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 103:1–5; Psalm 34:1; Psalm 136:1.",
            15, Color.DKGRAY, false
    );

    addText("5. Praise Gives God the Glory for Our Victories",
            18, Color.BLACK, true);
    addText(
            "Whenever we experience success, deliverance or an answer to " +
            "prayer, we should remember to give God the glory. David understood " +
            "that his strength and victories came from the Lord. In Psalm 18, " +
            "he declared that he would call upon the Lord, who is worthy to " +
            "be praised. Praise keeps us from becoming proud or taking all " +
            "the credit for what God has helped us accomplish. It reminds us " +
            "that every good gift and every true victory should lead us to honour Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 18:3; Psalm 115:1; James 1:17.",
            15, Color.DKGRAY, false
    );

    addText("6. Praise Strengthens Our Confidence in God",
            18, Color.BLACK, true);
    addText(
            "When we praise God, we declare that He is greater than the " +
            "challenges we face. This does not mean that we ignore our problems " +
            "or pretend that they do not exist. It means that we refuse to " +
            "measure God's ability by the size of our difficulties. Praise " +
            "helps us focus on God's character, His power and His faithfulness. " +
            "As we remember who He is, we are encouraged to keep trusting Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Habakkuk 3:17–19; Isaiah 26:3–4; Psalm 27:1.",
            15, Color.DKGRAY, false
    );

    addText("7. Praise Can Be a Testimony to Others",
            18, Color.BLACK, true);
    addText(
            "Our praise can also encourage other people to recognise God's " +
            "goodness. When believers continue to honour God during difficult " +
            "seasons, their lives can become an example of trust and confidence " +
            "in Him. David's psalms openly declared God's greatness and mighty " +
            "works, giving others reasons to praise Him too. Our testimony " +
            "should point people towards God rather than draw attention to ourselves.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 40:1–3; Psalm 145:4–7; Matthew 5:16.",
            15, Color.DKGRAY, false
    );

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Make praise a regular part of your daily relationship with God.\n" +
            "2. Remember God's past goodness whenever you face a difficult situation.\n" +
            "3. Follow Jehoshaphat's example by seeking God and trusting Him in challenges.\n" +
            "4. Learn from Paul and Silas to continue honouring God during difficult seasons.\n" +
            "5. Give God the glory whenever you experience success or receive an answer to prayer.\n" +
            "6. Use praise to express your confidence in God's character and faithfulness.\n" +
            "7. Let your testimony encourage others to recognise God's goodness.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The power of praise is seen in how it directs our attention to " +
            "God, strengthens our confidence in Him and gives Him the glory " +
            "He deserves. The examples of Jehoshaphat, David, Paul and Silas " +
            "teach us to praise God in every season and trust Him through " +
            "every challenge. Praise is not a formula for controlling God; " +
            "it is an expression of faith, honour and dependence on Him.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "How do I respond to God when I face difficult situations? Do I " +
            "remember His goodness and continue to praise Him? Am I willing " +
            "to give Him the glory for the victories and blessings in my life?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You because You are worthy of all praise. " +
            "Help me to understand the importance of praising You in every " +
            "season of my life. Teach me to trust You when I face difficulties " +
            "and to remember Your goodness and faithfulness. Give me a grateful " +
            "heart that honours You in my words and actions. May my life bring " +
            "glory to Your name and encourage others to recognise Your goodness. " +
            "In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showNovemberWeekThree() {

    addText("What Is an Acceptable Praise?",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "God deserves our praise, but our praise should come from a " +
            "sincere heart that honours Him. Acceptable praise is praise " +
            "offered with genuine gratitude, faith, reverence and obedience " +
            "to God. It is not merely an outward activity or a performance " +
            "before people. God looks beyond our outward expressions and " +
            "considers the condition of our hearts. Therefore, we must " +
            "understand what makes our praise pleasing and acceptable to Him.",
            16, Color.BLACK, false
    );

    addText("1. Acceptable Praise Comes from a Sincere Heart",
            18, Color.BLACK, true);
    addText(
            "Praise that pleases God must come from a genuine heart. We " +
            "should not praise Him merely to impress people or receive " +
            "recognition. Our expressions of praise must be sincere and " +
            "must reflect what we truly believe about God. Jesus taught " +
            "that God desires people who worship Him in spirit and in truth. " +
            "This reminds us that our relationship with God must be genuine, " +
            "and our praise should reflect that sincerity.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 4:23–24; Psalm 51:17.",
            15, Color.DKGRAY, false
    );

    addText("2. Acceptable Praise Must Be Offered with Thanksgiving",
            18, Color.BLACK, true);
    addText(
            "Thanksgiving is an important expression of acceptable praise. " +
            "We should recognise God's goodness and appreciate Him for His " +
            "mercy, faithfulness, provision and protection. Instead of " +
            "complaining continually or forgetting His benefits, we should " +
            "cultivate a grateful heart. Thanksgiving reminds us that every " +
            "good thing comes from God and that He deserves our appreciation.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 100:4; Psalm 103:1–5; 1 Thessalonians 5:18.",
            15, Color.DKGRAY, false
    );

    addText("3. Acceptable Praise Must Be Offered in Faith",
            18, Color.BLACK, true);
    addText(
            "Our praise should reflect confidence in God's character and " +
            "faithfulness. We should not praise Him only because we can " +
            "see the answers we desire. Even when situations are difficult, " +
            "we can acknowledge that God remains good and worthy of praise. " +
            "Habakkuk demonstrated this attitude when he declared his " +
            "confidence in God even though the expected harvest and " +
            "provision were absent. Acceptable praise therefore comes from " +
            "a heart that trusts God in every season.",
            16, Color.BLACK, false
    );
    addText("Scripture: Habakkuk 3:17–19; Hebrews 11:6.",
            15, Color.DKGRAY, false
    );

    addText("4. Acceptable Praise Must Honour God",
            18, Color.BLACK, true);
    addText(
            "God alone deserves the glory and honour that belong to Him. " +
            "Our praise should not be centred on ourselves or used as an " +
            "opportunity to attract attention. When we praise God, we should " +
            "recognise His greatness and acknowledge that He is the source " +
            "of our strength and blessings. David continually declared the " +
            "greatness of the Lord and encouraged others to magnify His name.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 34:1–3; Psalm 115:1; Psalm 29:1–2.",
            15, Color.DKGRAY, false
    );

    addText("5. Acceptable Praise Must Agree with a Life of Obedience",
            18, Color.BLACK, true);
    addText(
            "Our praise should not be separated from the way we live. God " +
            "desires obedience rather than outward religious activities " +
            "that are not supported by a sincere relationship with Him. " +
            "We cannot deliberately live in disobedience while treating " +
            "praise as a substitute for doing what God commands. An " +
            "acceptable expression of praise should come from a life that " +
            "is willing to honour God through its choices and actions.",
            16, Color.BLACK, false
    );
    addText("Scripture: 1 Samuel 15:22; Romans 12:1; Colossians 3:17.",
            15, Color.DKGRAY, false
    );

    addText("6. Acceptable Praise Should Be Offered Continually",
            18, Color.BLACK, true);
    addText(
            "Praise should not be restricted to special occasions or " +
            "moments when we receive good news. Hebrews teaches believers " +
            "to offer the sacrifice of praise continually. This means that " +
            "we should develop a lifestyle of acknowledging God and giving " +
            "Him thanks. David declared that he would bless the Lord at all " +
            "times. We should also learn to maintain a heart of praise in " +
            "different seasons of life.",
            16, Color.BLACK, false
    );
    addText("Scripture: Hebrews 13:15; Psalm 34:1; Ephesians 5:19–20.",
            15, Color.DKGRAY, false
    );

    addText("7. Acceptable Praise Must Come from a Life That Belongs to God",
            18, Color.BLACK, true);
    addText(
            "Our praise should reflect a genuine commitment to God. " +
            "Romans 12:1 encourages believers to present their bodies " +
            "as a living sacrifice, holy and acceptable unto God. This " +
            "teaches us that honouring God involves more than what we say " +
            "or sing. Our conduct, decisions and daily responsibilities " +
            "should also reflect our commitment to Him. A life that seeks " +
            "to please God gives meaning to the praise we offer.",
            16, Color.BLACK, false
    );
    addText("Scripture: Romans 12:1–2; 1 Corinthians 10:31.",
            15, Color.DKGRAY, false
    );

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Examine your heart and make sure your praise is sincere.\n" +
            "2. Develop a habit of thanking God for His goodness and faithfulness.\n" +
            "3. Continue trusting God and acknowledging His greatness during difficult seasons.\n" +
            "4. Give God the glory instead of seeking attention for yourself.\n" +
            "5. Make obedience to God's Word part of your daily life.\n" +
            "6. Practise praising God regularly, not only when you need something.\n" +
            "7. Let your conduct reflect the God you praise.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Acceptable praise is offered to God with sincerity, thanksgiving, " +
            "faith, reverence and obedience. It is not merely an outward " +
            "expression but something that should reflect the condition " +
            "of our hearts and the way we live. God deserves praise from " +
            "people who genuinely desire to honour Him.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Is my praise sincere, or am I more concerned about how people " +
            "see me? Does my daily conduct agree with the praise I offer " +
            "God? What changes do I need to make so that my praise reflects " +
            "a genuine heart that honours Him?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, thank You because You are worthy of all praise. " +
            "Give me a sincere and grateful heart that honours You in every " +
            "season. Help me to praise You in faith, walk in obedience to " +
            "Your Word and give You the glory in everything I do. Remove " +
            "every desire to seek human recognition, and teach me to live " +
            "a life that pleases You. May my words, actions and attitude " +
            "continually bring honour to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
            }
    private void showNovemberWeekFour() {

    addText("How to Give an Acceptable Praise",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Praise is an important part of our relationship with God. " +
            "However, acceptable praise must come from a heart that honours Him. " +
            "It involves more than singing or speaking words of appreciation; " +
            "it should reflect our relationship with God and the way we live. " +
            "Let us examine some ways to give acceptable praise to God.",
            16, Color.BLACK, false
    );

    addText("1. Be Born Again", 18, Color.BLACK, true);
    addText(
            "Acceptable praise begins with a genuine relationship with God through " +
            "Jesus Christ. Being born again means receiving Christ and becoming " +
            "a new creation. Our praise should come from a heart that belongs to God. " +
            "When we surrender our lives to Christ, we can worship God sincerely " +
            "and live in a way that honours Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: John 3:3–7; 2 Corinthians 5:17; John 1:12.",
            15, Color.DKGRAY, false);

    addText("2. By Prayer and Supplication", 18, Color.BLACK, true);
    addText(
            "Prayer and supplication help us maintain communication with God. " +
            "As we come before Him with thanksgiving and make our requests known, " +
            "we express our dependence on Him. Prayer should not be separated from " +
            "praise, because we can approach God with grateful hearts even while " +
            "presenting our needs. We should pray sincerely and trust Him with the " +
            "outcome.",
            16, Color.BLACK, false
    );
    addText("Scripture: Philippians 4:6; Ephesians 6:18; 1 Timothy 2:1.",
            15, Color.DKGRAY, false);

    addText("3. By Doing the Right Thing at the Right Time",
            18, Color.BLACK, true);
    addText(
            "Acceptable praise should also be reflected in our actions. God desires " +
            "that we do what is right and fulfil our responsibilities faithfully. " +
            "There is a proper time for every purpose, and we should learn to act " +
            "with wisdom rather than delay what we ought to do. Our obedience, " +
            "good conduct and willingness to do what pleases God can bring honour " +
            "to His name.",
            16, Color.BLACK, false
    );
    addText("Scripture: Ecclesiastes 3:1; Galatians 6:9–10; Colossians 3:17.",
            15, Color.DKGRAY, false);

    addText("4. By Worshipping God's Name", 18, Color.BLACK, true);
    addText(
            "Worshipping God's name means giving Him the honour, reverence and " +
            "adoration He deserves. We should praise Him for who He is and " +
            "acknowledge His greatness. Our worship should be sincere and should " +
            "come from the heart, not merely from outward expressions. Let our " +
            "words, songs and actions continually bring glory to God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Psalm 34:1–3; Psalm 29:2; Psalm 96:8.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Maintain a genuine relationship with Jesus Christ.\n" +
            "2. Make prayer and supplication a regular part of your life.\n" +
            "3. Be willing to do what is right and fulfil your responsibilities.\n" +
            "4. Honour God's name through sincere worship and daily conduct.\n" +
            "5. Let your life consistently reflect gratitude and reverence for God.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Acceptable praise is not limited to songs or spoken words. " +
            "It comes from a heart that belongs to God and is expressed through " +
            "prayer, obedience, right actions and sincere worship.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Does my relationship with God, my prayers, my actions and my worship " +
            "show that I genuinely honour Him?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, help me to give You acceptable praise. " +
            "Give me a sincere heart, strengthen my prayer life, and help me " +
            "to do what is right. May my words, actions and worship continually " +
            "bring glory to Your name, in Jesus' name. Amen.",
            16, Color.BLACK, false
    );
    }
    private void showDecemberWeekOne() {

    addText("Understanding Fasting: What Is Fasting?",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Fasting is a spiritual practice found throughout the Bible. " +
            "God's people fasted during different seasons when they wanted " +
            "to seek Him, humble themselves, pray or receive direction. " +
            "Fasting is closely connected with prayer and a sincere desire " +
            "to draw closer to God. However, fasting is not a way to force " +
            "God to answer us or to impress other people. What matters most " +
            "is the condition of our hearts and our genuine relationship with Him.",
            16, Color.BLACK, false
    );

    addText("1. The Meaning of Fasting",
            18, Color.BLACK, true);
    addText(
            "Biblical fasting is a spiritual discipline in which a person " +
            "sets aside ordinary activities or certain comforts for a period " +
            "of focused prayer and seeking God. In many Bible accounts, fasting " +
            "involved abstaining from food for a time, but its purpose was " +
            "spiritual rather than merely physical. Fasting should direct our " +
            "attention towards God and help us approach Him with humility. " +
            "It is important to understand that fasting does not make God " +
            "love us more or guarantee that every request will be granted.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 6:16–18; Ezra 8:21.",
            15, Color.DKGRAY, false);

    addText("2. The Purpose of Fasting",
            18, Color.BLACK, true);
    addText(
            "People in the Bible fasted for different spiritual reasons. " +
            "Some fasted while seeking God's direction, others during difficult " +
            "situations, and some as an expression of repentance and humility. " +
            "Fasting can help us give focused attention to prayer and examine " +
            "our relationship with God. Ezra and the people who returned with " +
            "him sought God's protection through prayer and fasting. Their " +
            "example reminds us to depend on God rather than relying only " +
            "on our own strength.",
            16, Color.BLACK, false
    );
    addText("Scripture: Ezra 8:21–23; Joel 2:12–13.",
            15, Color.DKGRAY, false);

    addText("3. Fasting and Prayer",
            18, Color.BLACK, true);
    addText(
            "Fasting and prayer are closely connected in Scripture. Prayer " +
            "allows us to communicate with God, express our needs and seek " +
            "His guidance. Fasting is sometimes practised alongside prayer " +
            "as an expression of devotion and dependence on Him. In Acts 13, " +
            "the believers ministered to the Lord and fasted, and the Holy " +
            "Spirit gave them direction concerning the work to which Barnabas " +
            "and Saul were called. This teaches us the importance of seeking " +
            "God's direction with a sincere and attentive heart.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 13:2–3; Luke 2:36–37.",
            15, Color.DKGRAY, false);

    addText("4. The Heart Behind Fasting",
            18, Color.BLACK, true);
    addText(
            "God is concerned about the condition of our hearts. Fasting " +
            "should not be done to attract attention, receive praise from " +
            "people or appear more spiritual than others. Jesus taught His " +
            "disciples not to make a display of fasting. Instead, they were " +
            "to approach it sincerely before God. Our attitude should be " +
            "humility, honesty and a genuine desire to seek Him.",
            16, Color.BLACK, false
    );
    addText("Scripture: Matthew 6:16–18; Joel 2:12–13.",
            15, Color.DKGRAY, false);

    addText("5. What Fasting Is Not",
            18, Color.BLACK, true);
    addText(
            "Fasting is not a way to manipulate God, force Him to grant " +
            "our wishes or prove that we are more spiritual than someone else. " +
            "It is also not a replacement for obedience, kindness, justice " +
            "or genuine love for others. Isaiah 58 teaches that outward " +
            "religious activities are not enough when people's actions are " +
            "unjust or unkind. True devotion to God should influence how " +
            "we treat the people around us.",
            16, Color.BLACK, false
    );
    addText("Scripture: Isaiah 58:3–7; Matthew 6:16–18.",
            15, Color.DKGRAY, false);

    addText("6. God Desires a Sincere Heart",
            18, Color.BLACK, true);
    addText(
            "God desires more than outward religious activities. He wants " +
            "people who sincerely seek Him and demonstrate His character " +
            "through their actions. Isaiah 58 connects genuine devotion with " +
            "helping those in need, showing kindness and treating others " +
            "rightly. Therefore, our relationship with God should be reflected " +
            "in the way we live. A sincere heart seeks God while also showing " +
            "love, compassion and obedience.",
            16, Color.BLACK, false
    );
    addText("Scripture: Isaiah 58:6–7; Micah 6:8.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Learn the biblical purpose of fasting and prayer.\n" +
            "2. Make time for prayer and studying God's Word.\n" +
            "3. Examine your motives and approach God sincerely.\n" +
            "4. Practise humility, kindness and obedience in your daily life.\n" +
            "5. Seek God's direction instead of trying to force a particular outcome.\n" +
            "6. Remember that your health matters. Do not skip meals or attempt " +
            "a food fast without guidance from a parent or guardian and a " +
            "qualified healthcare professional.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "Fasting is a biblical spiritual discipline associated with " +
            "prayer, humility and seeking God. Its value is not found in " +
            "outward appearance or the mere act of abstaining from food, " +
            "but in a sincere heart that desires God and is willing to obey Him.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Do I understand why people in the Bible fasted? Are my prayers " +
            "and spiritual activities motivated by a genuine desire to seek " +
            "God? Does my relationship with Him influence how I treat others?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, help me to understand the true purpose of " +
            "fasting and prayer. Give me a sincere heart that desires to " +
            "know You more. Teach me to seek Your direction, walk in humility " +
            "and demonstrate Your love through my actions. Help me to value " +
            "obedience above outward appearance and to depend on You in every " +
            "situation. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
        }
    private void showDecemberWeekTwo() {

    addText("The Biblical Purpose and Importance of Fasting",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Throughout the Bible, fasting appears during important moments " +
            "when individuals and communities sought God. They turned to Him " +
            "in times of difficulty, repentance, decision-making and spiritual " +
            "service. These accounts show that fasting was connected with " +
            "humility, prayer and dependence on God. Understanding its biblical " +
            "purpose helps us recognise that spiritual devotion is not about " +
            "outward appearance, but about sincerely seeking God and responding " +
            "to His Word.",
            16, Color.BLACK, false
    );

    addText("1. Fasting as an Expression of Humility Before God",
            18, Color.BLACK, true);
    addText(
            "One biblical purpose of fasting was to express humility before God. " +
            "When people recognised their dependence on Him, they humbled " +
            "themselves and sought His help. Ezra proclaimed a fast by the river " +
            "Ahava so that the people could humble themselves before God and " +
            "seek a safe journey. Their example teaches us that we should not " +
            "depend only on our own ability, but acknowledge our need for God's " +
            "wisdom, protection and guidance.",
            16, Color.BLACK, false
    );
    addText("Scripture: Ezra 8:21–23; Psalm 35:13.",
            15, Color.DKGRAY, false);

    addText("2. Fasting During Times of Repentance",
            18, Color.BLACK, true);
    addText(
            "In Scripture, fasting was sometimes associated with repentance. " +
            "When people recognised their wrongdoing, they turned towards God " +
            "and sought His mercy. Joel called the people to return to God with " +
            "all their hearts, with fasting, weeping and mourning. However, " +
            "repentance is more than an outward religious activity. It involves " +
            "a sincere change of heart and a willingness to turn away from " +
            "wrongdoing and follow God's ways.",
            16, Color.BLACK, false
    );
    addText("Scripture: Joel 2:12–13; Jonah 3:5–10.",
            15, Color.DKGRAY, false);

    addText("3. Fasting While Seeking God's Direction",
            18, Color.BLACK, true);
    addText(
            "Another purpose of fasting in the Bible was to seek God's direction. " +
            "In Acts 13, the believers were ministering to the Lord and fasting " +
            "when the Holy Spirit gave instructions concerning Barnabas and Saul. " +
            "This account reminds us of the importance of giving attention to " +
            "God through prayer, worship and His Word when seeking direction. " +
            "We should remain willing to follow what God teaches rather than " +
            "simply expecting Him to approve every decision we have already made.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 13:1–3; Acts 14:21–23.",
            15, Color.DKGRAY, false);

    addText("4. Fasting in Times of Trouble and Danger",
            18, Color.BLACK, true);
    addText(
            "The Bible also records occasions when people sought God during " +
            "times of serious trouble. When Queen Esther learned about the " +
            "danger facing her people, she asked the Jews in Shushan to join " +
            "her in a period of fasting before she approached the king. " +
            "Their response demonstrated unity, dependence on God and the " +
            "importance of seeking Him during difficult circumstances. " +
            "This teaches us to turn to God for wisdom and courage when we " +
            "face situations beyond our understanding.",
            16, Color.BLACK, false
    );
    addText("Scripture: Esther 4:15–17.",
            15, Color.DKGRAY, false);

    addText("5. Fasting and Spiritual Service",
            18, Color.BLACK, true);
    addText(
            "Fasting also appears in the lives of people who were devoted " +
            "to serving God. Anna, a prophetess, worshipped God with fasting " +
            "and prayers. Her life demonstrated consistent devotion and " +
            "faithfulness. Similarly, the believers in Antioch worshipped " +
            "the Lord and fasted while serving Him. These examples remind " +
            "us that our spiritual lives should involve consistent prayer, " +
            "worship, faithfulness and willingness to serve God.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 2:36–38; Acts 13:2–3.",
            15, Color.DKGRAY, false);

    addText("6. Fasting Should Be Accompanied by Righteous Living",
            18, Color.BLACK, true);
    addText(
            "The importance of fasting cannot be separated from the way " +
            "we live. In Isaiah 58, God corrected people who observed " +
            "religious practices but continued to act unjustly and neglect " +
            "others. God called them to demonstrate compassion, share with " +
            "those in need and stop oppressing others. This teaches us that " +
            "genuine devotion must be reflected in our character. Prayer " +
            "and spiritual activities should encourage us to live with " +
            "justice, kindness and love.",
            16, Color.BLACK, false
    );
    addText("Scripture: Isaiah 58:6–10; Micah 6:8.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Remember to depend on God rather than relying only on yourself.\n" +
            "2. Be willing to acknowledge your mistakes and turn away from wrongdoing.\n" +
            "3. Seek God's direction through prayer and the study of His Word.\n" +
            "4. Turn to God for wisdom and courage during difficult situations.\n" +
            "5. Develop a consistent attitude of prayer, worship and service.\n" +
            "6. Demonstrate your devotion through kindness, honesty and obedience.\n" +
            "7. Never put your health at risk through food restriction. You can " +
            "seek God through prayer, worship and studying His Word without " +
            "skipping meals.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The Bible shows that fasting was practised during times of " +
            "humility, repentance, seeking direction, trouble and spiritual " +
            "service. Its importance must be understood alongside sincere " +
            "prayer, obedience and a life that reflects God's character.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "When I face difficult situations or need direction, do I sincerely " +
            "seek God? Does my devotion influence my character and the way " +
            "I treat other people?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, teach me to depend on You in every situation. " +
            "Give me a humble and repentant heart. Help me seek Your direction, " +
            "remain faithful in prayer and serve You sincerely. Let my life " +
            "reflect Your love, kindness and righteousness. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showDecemberWeekThree() {

    addText("The Spiritual Benefits and Power of Fasting",
            22, Color.BLACK, true);

    addText("Introduction", 18, Color.BLACK, true);
    addText(
            "Throughout Scripture, fasting is associated with moments of " +
            "prayer, devotion and seeking God. It was practised by individuals " +
            "who desired to humble themselves before Him, seek His direction " +
            "and remain committed to His purpose. The spiritual value of " +
            "fasting is not found in the physical act alone, but in a sincere " +
            "heart that desires God. When considered alongside prayer, worship " +
            "and obedience, fasting teaches us important lessons about our " +
            "relationship with Him.",
            16, Color.BLACK, false
    );

    addText("1. Fasting Encourages Humility Before God",
            18, Color.BLACK, true);
    addText(
            "One important spiritual benefit associated with fasting is " +
            "the reminder that we depend on God. It encourages us to recognise " +
            "that our strength, wisdom and understanding are limited, while " +
            "God remains our source of help. Ezra and the people who returned " +
            "with him humbled themselves before God and sought His protection. " +
            "Their example teaches us to approach God with humility rather " +
            "than pride or self-confidence.",
            16, Color.BLACK, false
    );
    addText("Scripture: Ezra 8:21–23; James 4:10.",
            15, Color.DKGRAY, false);

    addText("2. Fasting Creates Time for Focused Prayer",
            18, Color.BLACK, true);
    addText(
            "Fasting is often practised alongside prayer. It can serve as " +
            "a reminder to give deliberate attention to seeking God rather " +
            "than allowing everyday activities to distract us. In the Bible, " +
            "Anna served God with fasting and prayers. Her example shows " +
            "the value of a life devoted to worship and communication with " +
            "God. We should develop a consistent prayer life and make time " +
            "to speak with God and study His Word.",
            16, Color.BLACK, false
    );
    addText("Scripture: Luke 2:36–38; Colossians 4:2.",
            15, Color.DKGRAY, false);

    addText("3. Fasting Is Associated with Seeking God's Direction",
            18, Color.BLACK, true);
    addText(
            "There are moments when we need wisdom and direction concerning " +
            "important decisions. In Acts 13, the believers in Antioch were " +
            "ministering to the Lord and fasting when the Holy Spirit gave " +
            "instructions concerning Barnabas and Saul. This account reminds " +
            "us of the importance of seeking God's direction through prayer, " +
            "worship and attention to His Word. We should remain willing to " +
            "follow His instructions rather than insist on our own plans.",
            16, Color.BLACK, false
    );
    addText("Scripture: Acts 13:1–3; Proverbs 3:5–6.",
            15, Color.DKGRAY, false);

    addText("4. Fasting Reminds Us to Depend on God's Strength",
            18, Color.BLACK, true);
    addText(
            "Human strength and ability are limited, but God is faithful " +
            "to those who trust Him. Fasting is sometimes observed during " +
            "difficult seasons when people seek God's help. However, it is " +
            "not a guarantee that every difficulty will immediately disappear. " +
            "Rather, our confidence should remain in God, who gives strength " +
            "to those who are weary and helps His people through challenging " +
            "situations.",
            16, Color.BLACK, false
    );
    addText("Scripture: Isaiah 40:29–31; 2 Corinthians 12:9.",
            15, Color.DKGRAY, false);

    addText("5. Fasting Can Accompany Repentance and Spiritual Renewal",
            18, Color.BLACK, true);
    addText(
            "Fasting appears in Scripture during times when people recognised " +
            "their need to return to God. Joel called the people to return " +
            "to the Lord with all their hearts. This teaches us that spiritual " +
            "renewal begins with sincerity, repentance and a willingness to " +
            "follow God's ways. Outward religious activities cannot replace " +
            "a genuine change of heart. God desires people who are willing " +
            "to turn away from wrongdoing and walk in obedience.",
            16, Color.BLACK, false
    );
    addText("Scripture: Joel 2:12–13; Psalm 51:10–12.",
            15, Color.DKGRAY, false);

    addText("6. Fasting Should Produce a Life of Love and Righteousness",
            18, Color.BLACK, true);
    addText(
            "The spiritual value of fasting must also be reflected in our " +
            "daily conduct. Isaiah 58 teaches that God was not pleased with " +
            "people who observed religious practices while neglecting justice " +
            "and compassion. He called them to help those in need and treat " +
            "others rightly. This reminds us that spiritual growth should " +
            "produce visible changes in our character. Our devotion to God " +
            "should be demonstrated through love, kindness, honesty and " +
            "obedience.",
            16, Color.BLACK, false
    );
    addText("Scripture: Isaiah 58:6–10; Galatians 5:22–23.",
            15, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText(
            "1. Approach God with humility and recognise your dependence on Him.\n" +
            "2. Develop a consistent habit of prayer and Bible study.\n" +
            "3. Seek God's wisdom before making important decisions.\n" +
            "4. Trust God for strength when facing difficult situations.\n" +
            "5. Examine your heart and be willing to repent when necessary.\n" +
            "6. Demonstrate spiritual growth through love, kindness and obedience.\n" +
            "7. Remember that prayer and seeking God do not require you to " +
            "skip meals or put your health at risk.",
            15, Color.BLACK, false
    );

    addText("Key Lesson", 18, Color.BLACK, true);
    addText(
            "The spiritual value of fasting is connected with humility, " +
            "prayer, seeking God's direction and a sincere desire to live " +
            "according to His Word. True spiritual growth should be reflected " +
            "in our character, choices and treatment of others.",
            16, Color.BLACK, false
    );

    addText("Reflection", 18, Color.BLACK, true);
    addText(
            "Am I genuinely seeking God in my daily life? Do I depend on " +
            "His wisdom and strength? Is my spiritual devotion producing " +
            "greater love, humility and obedience in my character?",
            16, Color.BLACK, false
    );

    addText("Prayer", 18, Color.BLACK, true);
    addText(
            "Heavenly Father, help me to grow in my relationship with You. " +
            "Give me a humble heart, strengthen my prayer life and guide " +
            "me in Your ways. Help me depend on Your strength, seek Your " +
            "wisdom and demonstrate Your love through my actions. May my " +
            "life bring honour to Your name. In Jesus' name, Amen.",
            16, Color.BLACK, false
    );
    }
    private void showDecemberWeekFour() {
    addText("How to Fast Acceptably and Effectively", 22, Color.BLACK, true);

    addText("Introduction", 20, Color.BLACK, true);
    addText("Fasting is a spiritual discipline discussed throughout the Bible. However, acceptable fasting is not simply about going without food or being seen by others. It is about sincerely seeking God through prayer, humility, repentance and obedience. God is concerned with the condition of our hearts and the way we live.", 16, Color.BLACK, false);

    addText("1. Have a Sincere Heart and the Right Motive", 18, Color.BLACK, true);
    addText("Fasting should come from a genuine desire to draw closer to God, not to impress people or receive their praise. Jesus taught that our devotion should be sincere and not performed for public recognition. God sees what is done in secret and knows the true intentions of our hearts.", 16, Color.BLACK, false);
    addText("Scripture: Matthew 6:16–18; 1 Samuel 16:7", 14, Color.DKGRAY, false);

    addText("2. Combine Prayer with Your Desire to Seek God", 18, Color.BLACK, true);
    addText("Prayer is an important part of seeking God. Biblical examples show people combining fasting with prayer when they needed God's direction, help or intervention. Our focus should be on communicating with God, listening to His Word and trusting His wisdom.", 16, Color.BLACK, false);
    addText("Scripture: Acts 13:2–3; Ezra 8:21–23", 14, Color.DKGRAY, false);

    addText("3. Repent and Turn Away from Wrongdoing", 18, Color.BLACK, true);
    addText("Acceptable fasting must be accompanied by a willingness to turn away from sin and live according to God's instructions. Isaiah 58 teaches that God does not desire an outward religious practice while people continue in injustice, oppression and selfishness. True devotion should produce a changed attitude and a life that pleases God.", 16, Color.BLACK, false);
    addText("Scripture: Joel 2:12–13; Isaiah 58:6–10", 14, Color.DKGRAY, false);

    addText("4. Let Your Devotion Show Through Love and Good Works", 18, Color.BLACK, true);
    addText("Seeking God should influence how we treat other people. We should show kindness, help those in need, forgive others and act justly. A person cannot separate devotion to God from love and concern for people. Our faith should be visible through our actions.", 16, Color.BLACK, false);
    addText("Scripture: Isaiah 58:7–10; Micah 6:8; James 1:27", 14, Color.DKGRAY, false);

    addText("Practical Application", 18, Color.BLACK, true);
    addText("• Examine your motives whenever you set aside time to seek God.\n• Make time for sincere prayer and Bible study.\n• Ask God to help you recognise and turn away from wrongdoing.\n• Practise kindness, forgiveness and compassion.\n• Do not use fasting to impress people or force God to answer a request.\n• Remember that seeking God does not require skipping meals. Young people should not undertake food restrictions or change their eating habits for fasting without guidance from a parent or guardian and a qualified healthcare professional.", 16, Color.BLACK, false);

    addText("Key Lesson", 18, Color.BLACK, true);
    addText("Acceptable devotion is rooted in a sincere heart, prayer, repentance, obedience and love. God desires a life that reflects His character, not merely an outward religious activity.", 16, Color.BLACK, false);

    addText("Reflection", 18, Color.BLACK, true);
    addText("Are my motives for seeking God sincere? Do my prayers and devotion influence the way I treat others and live each day?", 16, Color.BLACK, false);

    addText("Prayer", 18, Color.BLACK, true);
    addText("Heavenly Father, help me to seek You with a sincere heart. Teach me to pray, obey Your Word, turn away from wrongdoing and show love to others. Let my devotion be pleasing to You and let my daily life reflect Your goodness. In Jesus' name, Amen.", 16, Color.BLACK, false);
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
            "These four extra teachings are released "
                    + "progressively throughout the year.",
            15,
            DARK_TEXT,
            false
    );

    String[] additionalMonths = {
            "February",
            "March",
            "November",
            "July"
    };

    int[] monthIndexes = {
            1, 2, 10, 6
    };

    for (int i = 0; i < additionalMonths.length; i++) {

        if (monthIndexes[i] > Calendar.getInstance()
                .get(Calendar.MONTH)) {
            continue;
        }

        addCard(
                "Additional Teaching " + (i + 1),
                "Released in " + additionalMonths[i]
                        + " • Content to be added.",
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
