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
        "Understanding the Love of God",
        "The Importance of Love in the Christian Life",
        "Walking in Love Towards Others",
        "How to Demonstrate Genuine Christian Love"
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
    private void showFebruaryWeekThree() {
    addText("Faith Without Love Is Nothing",
            22, PURPLE, true);

    addText("Main Scripture: 1 Corinthians 13:2–3",
            17, DARK_TEXT, true);

    addText(
            "Faith, knowledge and spiritual gifts are valuable, "
            + "but they are not substitutes for love. Our walk with "
            + "God must be rooted in genuine love for Him.",
            16, DARK_TEXT, false
    );

    addText("1. Faith Must Be Rooted in Love",
            19, PURPLE, true);

    addText(
            "1 Corinthians 13:2–3 teaches that even great faith, "
            + "understanding and sacrifice amount to nothing without love. "
            + "Our relationship with God should not be based only on "
            + "what we receive from Him, but also on our love for Him.",
            16, DARK_TEXT, false
    );

    addText("2. Love for God Must Be Genuine",
            19, PURPLE, true);

    addText(
            "Our love for God should influence our thoughts, decisions "
            + "and daily conduct. It should also reflect in how we treat "
            + "other people.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: 1 John 4:20; 1 Peter 1:22",
            15, DARK_TEXT, false);

    addText("3. Grow Deeper in the Love of God",
            19, PURPLE, true);

    addText(
            "The love of God should become deeply rooted in our hearts. "
            + "We should continually seek to understand and experience "
            + "the depth of His love.",
            16, DARK_TEXT, false
    );

    addText("Scriptures: Ephesians 3:17–18; Song of Solomon 8:6",
            15, DARK_TEXT, false);

    addText("4. Lovers of God Become Pathfinders",
            19, PURPLE, true);

    addText(
            "Your handwritten notes describe lovers of God as "
            + "pathfinders and trailblazers, and describe them as "
            + "limit breakers. This highlights the importance of "
            + "allowing love for God to shape our lives and purpose.",
            16, DARK_TEXT, false
    );

    addText("5. Reposition Yourself in the Love of God",
            19, PURPLE, true);

    addText(
            "Do not allow your relationship with God to become "
            + "routine or merely outward. Examine your heart and "
            + "make room for a deeper, more genuine love for Him.",
            16, DARK_TEXT, false
    );

    addText("Small Ideas to Remember",
            19, PURPLE, true);

    addText(
            "• Faith should work together with love.\n"
            + "• Love for God should influence everyday choices.\n"
            + "• Spiritual activities should come from a sincere heart.\n"
            + "• Love is more than words; it should be reflected in our lives.",
            15, DARK_TEXT, false
    );

    addText("Reflection",
            19, PURPLE, true);

    addText(
            "Am I pursuing God because I genuinely love Him, "
            + "or only because of what I hope to receive from Him?",
            16, DARK_TEXT, false
    );

    addText("Prayer",
            19, PURPLE, true);

    addText(
            "Lord, help me to grow in genuine love for You. "
            + "Let my faith, service and daily decisions be rooted "
            + "in love. Give me a heart that seeks You sincerely. Amen.",
            16, DARK_TEXT, false
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
