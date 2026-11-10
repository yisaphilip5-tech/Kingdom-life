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
