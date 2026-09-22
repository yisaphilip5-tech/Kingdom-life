
package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

    LinearLayout content;
  SharedPreferences prefs;

    int darkText = Color.rgb(45, 45, 45);
    int cardColor = Color.rgb(245, 247, 250);
String[] scrambleWords = {
    "JESUS",
    "MOSES",
    "DAVID",
    "NOAH",
    "ABRAHAM",
    "SAMSON",
    "SOLOMON",
    "JERUSALEM",
    "BETHLEHEM",
    "NAZARETH",
    "GALILEE",
    "JORDAN",
    "GENESIS",
    "EXODUS",
    "PSALMS",
    "PROVERBS",
    "MATTHEW",
    "MARK",
    "LUKE",
    "JOHN",
    "PETER",
    "PAUL",
    "STEPHEN",
    "ELIJAH",
    "DANIEL"
};
    String[] questions = {
        "Who built the ark?",
        "Which Bible book comes first?",
        "Who was swallowed by a great fish?",
        "Who defeated Goliath?",
        "How many disciples did Jesus choose?",
        "Who led the Israelites out of Egypt?",
        "What was the first miracle of Jesus recorded in John?",
        "Who was the mother of Jesus?",
        "Who betrayed Jesus?",
        "What did David use to defeat Goliath?",
        "Who received the Ten Commandments?",
        "Which New Testament book has only one chapter and is addressed to Philemon?",
        "Who was known for his great wisdom?",
        "Where was Jesus born?",
        "Who denied Jesus three times?"
};

String[][] options = {
        {"Moses", "Noah", "David", "Abraham"},
        {"Exodus", "Genesis", "Matthew", "Psalms"},
        {"Jonah", "Peter", "Paul", "Daniel"},
        {"Solomon", "David", "Samuel", "Joshua"},
        {"10", "11", "12", "14"},
        {"Moses", "Joshua", "Aaron", "Samuel"},
        {"Walking on water", "Turning water into wine", "Healing a blind man", "Feeding 5,000"},
        {"Mary", "Martha", "Elizabeth", "Sarah"},
        {"Peter", "Judas Iscariot", "Thomas", "John"},
        {"A sword", "A spear", "A sling and stones", "A bow"},
        {"David", "Moses", "Solomon", "Joshua"},
        {"Philemon", "Romans", "Genesis", "Revelation"},
        {"Solomon", "Samson", "Paul", "Isaiah"},
        {"Jerusalem", "Nazareth", "Bethlehem", "Capernaum"},
        {"John", "Peter", "James", "Matthew"}
};

int[] answers = {
        1,
        1,
        0,
        1,
        2,
        0,
        1,
        0,
        1,
        2,
        1,
        0,
        0,
        2,
        1
};
String[] level2Questions = {
        "Which prophet confronted the prophets of Baal on Mount Carmel?",
        "Who interpreted Pharaoh's dreams in Egypt?",
        "Which judge of Israel was known for his great strength?",
        "Who was the father of King Solomon?",
        "Which disciple was also called Didymus?"
};

String[][] level2Options = {
        {"Elijah", "Isaiah", "Jeremiah", "Ezekiel"},
        {"Joseph", "Daniel", "Moses", "Aaron"},
        {"Gideon", "Samson", "Samuel", "Jephthah"},
        {"Saul", "David", "Samuel", "Jesse"},
        {"Peter", "Thomas", "Andrew", "Philip"}
};

int[] level2Answers = {0, 0, 1, 1, 1};
    String[] level3Questions = {
        "Which king of Judah was shown the shadow moving backward as a sign?",
        "Which prophet married Gomer?",
        "Who was the first Christian martyr recorded in Acts?",
        "Which judge made a vow before going into battle against the Ammonites?",
        "Which king asked God for wisdom rather than riches or long life?"
};

String[][] level3Options = {
        {"Hezekiah", "Josiah", "Uzziah", "Manasseh"},
        {"Hosea", "Amos", "Joel", "Micah"},
        {"Stephen", "James", "Barnabas", "Philip"},
        {"Jephthah", "Gideon", "Samson", "Ehud"},
        {"Solomon", "David", "Saul", "Rehoboam"}
};

int[] level3Answers = {0, 0, 0, 0, 0};
    int currentQuestion = 0;
    int currentLevel = 1;
    int highestLevelUnlocked = 1;
    int score = 0;
    int scrambleQuestion = 0;
int scrambleScore = 0;
  int totalPoints = 0;
  int learnedVerses = 0;
  int dailyStreak = 0;
  boolean challengeCompletedToday = false;
  String lastChallengeDate = "";
    int correctAnswers = 0;
    int wrongAnswers = 0;

    boolean answered = false;
    CountDownTimer timer;

    int timeLimit = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      prefs = getSharedPreferences("KingdomLifePrefs", MODE_PRIVATE);
dailyStreak = prefs.getInt("dailyStreak", 0);
totalPoints = prefs.getInt("totalPoints", 0);
learnedVerses = prefs.getInt("learnedVerses", 0);
lastChallengeDate = prefs.getString("lastChallengeDate", "");
        highestLevelUnlocked = prefs.getInt("highestLevelUnlocked", 1);
        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(0, 0, 0, 80);
        main.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("Kingdom Life");
        title.setTextSize(28);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 30, 0, 15);

        main.addView(title);

        ScrollView scrollView = new ScrollView(this);

content = new LinearLayout(this);
content.setOrientation(LinearLayout.VERTICAL);
content.setPadding(20, 10, 20, 25);

scrollView.addView(content);

main.addView(scrollView, new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        0,
        1
));
        LinearLayout bottomNav = new LinearLayout(this);
bottomNav.setOrientation(LinearLayout.HORIZONTAL);
bottomNav.setGravity(Gravity.CENTER);
bottomNav.setPadding(4, 4, 4, 4);

String[] navItems = {
        "🏠\nHome",
        "📖\nLearn",
        "🔎\nExplore",
        "🏆\nAchievements",
        "⋯\nMore"
};

for (String item : navItems) {

    Button navButton = new Button(this);

    navButton.setText(item);
    navButton.setTextSize(11);
    navButton.setAllCaps(false);
    navButton.setTextColor(Color.WHITE);
    navButton.setGravity(Gravity.CENTER);

    GradientDrawable navBackground =
            new GradientDrawable();

    navBackground.setColor(
            Color.argb(220, 0, 0, 0)
    );

    navBackground.setCornerRadius(18);

    navButton.setBackground(navBackground);

    LinearLayout.LayoutParams navParams =
            new LinearLayout.LayoutParams(
                    0,
                    60,
                    1
            );

    navParams.setMargins(2, 2, 2, 2);

    bottomNav.addView(navButton, navParams);

    if (item.contains("Home")) {

        navButton.setOnClickListener(v ->
                showHome()
        );

    } else if (item.contains("Learn")) {

        navButton.setOnClickListener(v ->
                showMessage(
                        "📖 Learn",
                        "Bible learning features are here."
                )
        );

    } else if (item.contains("Explore")) {

        navButton.setOnClickListener(v ->
                showMessage(
                        "🔎 Explore",
                        "Explore Kingdom Life features."
                )
        );

    } else if (item.contains("Achievements")) {

        navButton.setOnClickListener(v ->
                showAchievements()
        );

    } else {

        navButton.setOnClickListener(v ->
                showMessage(
                        "⋯ More",
                        "More Kingdom Life options."
                )
        );
    }
}

main.addView(bottomNav);
    setContentView(main);

content.removeAllViews();

TextView loading = new TextView(this);
loading.setText("✝️\n\nKingdom Life\n\nLoading...");
loading.setTextSize(24);
loading.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
loading.setTextColor(darkText);
loading.setGravity(Gravity.CENTER);
loading.setPadding(0, 80, 0, 80);

content.addView(loading);

new Handler().postDelayed(() -> {
    showHome();
}, 1200);
    }

    void showHome() {
        stopTimer();
content.removeAllViews();
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

if (hour >= 6 && hour < 18) {
    content.setBackgroundResource(R.drawable.kingdom_home_bg);
} else {
    content.setBackgroundResource(R.drawable.kingdom_night_bg);
}

/* ===== KINGDOM LIFE HEADER ===== */

LinearLayout header = new LinearLayout(this);
header.setOrientation(LinearLayout.HORIZONTAL);
header.setGravity(Gravity.CENTER_VERTICAL);
header.setPadding(5, 15, 5, 5);

LinearLayout titleArea = new LinearLayout(this);
titleArea.setOrientation(LinearLayout.VERTICAL);
titleArea.setGravity(Gravity.CENTER_VERTICAL);

TextView kingdomTitle = new TextView(this);
kingdomTitle.setText("👑 Kingdom Life");
kingdomTitle.setTextSize(28);
kingdomTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
kingdomTitle.setTextColor(darkText);

titleArea.addView(kingdomTitle);

TextView kingdomSubtitle = new TextView(this);
kingdomSubtitle.setText("Grow in faith. Live with purpose.");
kingdomSubtitle.setTextSize(15);
kingdomSubtitle.setTextColor(darkText);

titleArea.addView(kingdomSubtitle);

LinearLayout.LayoutParams titleParams =
        new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        );

header.addView(titleArea, titleParams);

Button settingsButton = new Button(this);
settingsButton.setText("⚙️");
settingsButton.setTextSize(20);
settingsButton.setAllCaps(false);
settingsButton.setTextColor(darkText);
settingsButton.setBackgroundColor(Color.TRANSPARENT);

settingsButton.setOnClickListener(v -> showSettings());

header.addView(settingsButton);

content.addView(header);

/* ===== DATE ===== */

TextView dateText = new TextView(this);

String currentDate = new SimpleDateFormat(
        "EEEE, MMMM d, yyyy",
        Locale.getDefault()
).format(new Date());

dateText.setText("📅 " + currentDate);
dateText.setTextSize(15);
dateText.setTextColor(darkText);
dateText.setGravity(Gravity.CENTER);
dateText.setPadding(0, 5, 0, 15);

content.addView(dateText);

/* ===== WELCOME ===== */

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
String[] dailyChallenges = {
        "Read today's verse, say a short prayer, and do one act of kindness.",
        "Read a Bible passage, thank God for three things, and encourage someone.",
        "Spend a few quiet minutes in prayer and help someone who needs it.",
        "Read today's verse twice, reflect on it, and show patience to someone.",
        "Say a prayer for someone else and do one helpful thing without being asked.",
        "Read a Bible passage and write down one thing you learned from it.",
        "Thank God for the week, read today's verse, and encourage someone."
};

int challengeIndex = (int) (
        System.currentTimeMillis() / (1000L * 60 * 60 * 24)
        % dailyChallenges.length
);


        addHomeButtonGrid();

addCard(
        "▶️ Continue Learning",
        "Continue your Bible learning journey from where you left off.",
        v -> showBible()
);
addButton(
        "🎵 Background Sound: OFF",
        v -> showMessage(
                "🎵 Background Sound",
                "Background sound controls will be connected when the sound feature is added."
        )
);
        
    }
    void addCard(String heading, String message, View.OnClickListener listener) {

    LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setPadding(28, 22, 28, 22);

    // Soft rounded background
    GradientDrawable cardBackground = new GradientDrawable();
    cardBackground.setColor(Color.argb(225, 255, 255, 255));
    cardBackground.setCornerRadius(32);
    card.setBackground(cardBackground);

    // Subtle depth
    card.setElevation(6);

    card.setOnClickListener(listener);

    LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );

    cardParams.setMargins(12, 10, 12, 10);

    TextView headingView = new TextView(this);
    headingView.setText(heading);
    headingView.setTextSize(20);
    headingView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    headingView.setTextColor(darkText);
    headingView.setGravity(Gravity.CENTER_VERTICAL);

    card.addView(headingView);

    TextView messageView = new TextView(this);
    messageView.setText(message);
    messageView.setTextSize(16);
    messageView.setTextColor(darkText);
    messageView.setPadding(0, 10, 0, 0);

    card.addView(messageView);

    content.addView(card, cardParams);
    }
void addHomeButtonGrid() {

    LinearLayout grid = new LinearLayout(this);
    grid.setOrientation(LinearLayout.VERTICAL);

    LinearLayout.LayoutParams gridParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    gridParams.setMargins(8, 8, 8, 8);

    // FIRST ROW
    LinearLayout row1 = new LinearLayout(this);
    row1.setOrientation(LinearLayout.HORIZONTAL);

    row1.addView(createHomeSquareButton(
            "📖\nBible Quiz",
            v -> showGameMenu()
    ));

    row1.addView(createHomeSquareButton(
            "🧠\nMemory Verse",
            v -> showMemoryVerse()
    ));

    row1.addView(createHomeSquareButton(
            "🧩\nPuzzle",
            v -> showGameMenu()
    ));

    grid.addView(row1);

    // SECOND ROW
    LinearLayout row2 = new LinearLayout(this);
    row2.setOrientation(LinearLayout.HORIZONTAL);
    
row2.addView(createHomeSquareButton(
        "🎯\nDaily Challenge",
        v -> showMessage(
                "🎯 Daily Challenge",
                "Complete today's challenge to earn points and build your streak."
        )
));
    row2.addView(createHomeSquareButton(
            "📊\nProgress",
            v -> showProgress()
    ));

    row2.addView(createHomeSquareButton(
            "🏆\nAchievements",
            v -> showAchievements()
    ));

    grid.addView(row2);

    content.addView(grid, gridParams);
    }
    View createHomeSquareButton(
        String text,
        View.OnClickListener listener
) {

    Button button = new Button(this);

    button.setText(text);
    button.setTextSize(14);
    button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    button.setTextColor(Color.WHITE);
    button.setGravity(Gravity.CENTER);
    button.setAllCaps(false);

    GradientDrawable background = new GradientDrawable();
    background.setColor(Color.argb(220, 0, 0, 0));
    background.setCornerRadius(24);

    button.setBackground(background);
    button.setElevation(4);
    button.setOnClickListener(listener);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    0,
                    110,
                    1
            );

    params.setMargins(5, 5, 5, 5);

    button.setLayoutParams(params);

    return button;
    }
    void showVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Verse of the Day");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView verse = new TextView(this);
    String[] dailyVerses = {
        "Joshua 1:9 — KJV\n\n" +
        "Have not I commanded thee? Be strong and of a good courage; " +
        "be not afraid, neither be thou dismayed: for the LORD thy God is with thee whithersoever thou goest.",

        "Psalm 23:1 — KJV\n\n" +
        "The LORD is my shepherd; I shall not want.",

        "Proverbs 3:5 — KJV\n\n" +
        "Trust in the LORD with all thine heart; and lean not unto thine own understanding.",

        "Isaiah 41:10 — KJV\n\n" +
        "Fear thou not; for I am with thee: be not dismayed; for I am thy God: " +
        "I will strengthen thee; yea, I will help thee; yea, I will uphold thee with the right hand of my righteousness.",

        "Philippians 4:13 — KJV\n\n" +
        "I can do all things through Christ which strengtheneth me.",

        "Psalm 119:105 — KJV\n\n" +
        "Thy word is a lamp unto my feet, and a light unto my path.",

        "Romans 8:28 — KJV\n\n" +
        "And we know that all things work together for good to them that love God, " +
        "to them who are the called according to his purpose."
};

int verseIndex = (int) (
        System.currentTimeMillis() / (1000L * 60 * 60 * 24)
        % dailyVerses.length
);

verse.setText(dailyVerses[verseIndex]);
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 25);
    content.addView(verse);

    addButton("🧠 Mark as Learned", v -> {
      learnedVerses++;
totalPoints += 5;

prefs.edit()
        .putInt("learnedVerses", learnedVerses)
        .putInt("totalPoints", totalPoints)
        .apply();
        showMessage(
                "✅ Verse Learned",
                "Jeremiah 29:11 has been marked as learned.\n\n" +
                "+5 points"
        );
    });

    addButton("⬅️ Back to Home", v -> showHome());
    }

    void showThought() {
    String[] dailyThoughts = {
            "💭 Food for Thought\n\n" +
            "Kindness does not always require something big. " +
            "A simple word of encouragement, patience, or helping someone can make a difference.\n\n" +
            "Reflection:\nWhat is one good thing you can do for someone today?",

            "💭 Food for Thought\n\n" +
            "Your words can bring hope to someone who needs encouragement.\n\n" +
            "Reflection:\nHow can you use your words to encourage someone today?",

            "💭 Food for Thought\n\n" +
            "Patience helps us respond with wisdom instead of reacting in anger.\n\n" +
            "Reflection:\nIs there a situation where you can practice more patience?",

            "💭 Food for Thought\n\n" +
            "Gratitude helps us notice the good things we often overlook.\n\n" +
            "Reflection:\nWhat are three things you are thankful for today?",

            "💭 Food for Thought\n\n" +
            "Forgiveness can help us let go of anger and choose peace.\n\n" +
            "Reflection:\nIs there someone you can choose to forgive?",

            "💭 Food for Thought\n\n" +
            "Serving others is one way to show love through action.\n\n" +
            "Reflection:\nWhat helpful thing can you do for someone today?",

            "💭 Food for Thought\n\n" +
            "Doing what is right matters even when nobody is watching.\n\n" +
            "Reflection:\nWhat good choice can you make today?"
    };

    int thoughtIndex = (int) (
            System.currentTimeMillis() / (1000L * 60 * 60 * 24)
            % dailyThoughts.length
    );

    showMessage(
            "💭 Food for Thought",
            dailyThoughts[thoughtIndex]
    );
    }
  void showPrayer() {
    String[] dailyPrayers = {
            "Lord, guide us today and give us wisdom in every decision we make. " +
            "Strengthen our faith, help us walk in love and truth, and give us peace.\n\nAmen.",

            "Lord, thank You for this new day. Help us to be grateful, kind, and faithful " +
            "in everything we do. Give us strength to make good choices today.\n\nAmen.",

            "Lord, give us courage when we face difficult moments. Help us trust You, " +
            "learn from our challenges, and continue doing what is right.\n\nAmen.",

            "Lord, help us treat others with patience, respect, and kindness. " +
            "Teach us to be a source of encouragement and peace wherever we go.\n\nAmen.",

            "Lord, give us wisdom in our studies, work, friendships, and decisions. " +
            "Help us use what we learn to make a positive difference.\n\nAmen.",

            "Lord, help us forgive, show compassion, and choose peace. " +
            "Guide our hearts and actions throughout this day.\n\nAmen.",

            "Lord, thank You for bringing us through another week. " +
            "Help us reflect on what we have learned and prepare our hearts for the days ahead.\n\nAmen."
    };

    int prayerIndex = (int) (
            System.currentTimeMillis() / (1000L * 60 * 60 * 24)
            % dailyPrayers.length
    );

    showMessage(
            "🙏 Prayer for the Day",
            dailyPrayers[prayerIndex]
    );
  }

    void showMemoryVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🧠 Memory Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a Memory Verse challenge:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 20);
    content.addView(instruction);

    addButton("📖 Guess the Verse", v -> showGuessVerse());

    addButton("✍️ Complete the Verse", v -> showCompleteVerse());

    addButton("🔄 Guess the Reference", v -> showGuessReference());

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showBible() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Holy Bible — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "King James Version\n\n" +
            "The complete Bible will be organized here by:\n\n" +
            "📚 Old Testament\n" +
            "📚 New Testament\n\n" +
            "Choose a book and chapter to begin reading."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(0, 10, 0, 20);
    content.addView(message);

    addButton(
        "📚 Old Testament",
        v -> showOldTestament()
);

    addButton(
        "📚 New Testament",
        v -> showNewTestament()
);

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showOldTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 Old Testament");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String[] books = {
            "Genesis",
            "Exodus",
            "Leviticus",
            "Numbers",
            "Deuteronomy",
            "Joshua",
            "Judges",
            "Ruth",
            "1 Samuel",
            "2 Samuel",
            "1 Kings",
            "2 Kings",
            "1 Chronicles",
            "2 Chronicles",
            "Ezra",
            "Nehemiah",
            "Esther",
            "Job",
            "Psalms",
            "Proverbs",
            "Ecclesiastes",
            "Song of Solomon",
            "Isaiah",
            "Jeremiah",
            "Lamentations",
            "Ezekiel",
            "Daniel",
            "Hosea",
            "Joel",
            "Amos",
            "Obadiah",
            "Jonah",
            "Micah",
            "Nahum",
            "Habakkuk",
            "Zephaniah",
            "Haggai",
            "Zechariah",
            "Malachi"
    };

    for (String book : books) {

    if (book.equals("Genesis")) {

        addButton(
                "📖 " + book,
                v -> showBookChapters("Genesis", 50)
        );

    } else if (book.equals("Exodus")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Exodus", 40)
    );

} else if (book.equals("Leviticus")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Leviticus", 27)
    );

}} else if (book.equals("Numbers")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Numbers", 36)
    );

} else if (book.equals("Deuteronomy")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Deuteronomy", 34)
    );

} else if (book.equals("Joshua")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Joshua", 24)
    );

} else if (book.equals("Judges")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Judges", 21)
    );

} else if (book.equals("Ruth")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ruth", 4)
    );

} else if (book.equals("1 Samuel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Samuel", 31)
    );

} else if (book.equals("2 Samuel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Samuel", 24)
    );

} else if (book.equals("1 Kings")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Kings", 22)
    );

} else if (book.equals("2 Kings")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Kings", 25)
    );

} else if (book.equals("1 Chronicles")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Chronicles", 29)
    );

} else if (book.equals("2 Chronicles")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Chronicles", 36)
    );

} else if (book.equals("Ezra")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ezra", 10)
    );

} else if (book.equals("Nehemiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Nehemiah", 13)
    );

} else if (book.equals("Esther")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Esther", 10)
    );

} else if (book.equals("Job")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Job", 42)
    );
        
} else if (book.equals("Psalms")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Psalms", 150)
    );

} else if (book.equals("Proverbs")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Proverbs", 31)
    );

} else if (book.equals("Ecclesiastes")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ecclesiastes", 12)
    );

} else if (book.equals("Song of Solomon")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Song of Solomon", 8)
    );

} else if (book.equals("Isaiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Isaiah", 66)
    );

} else if (book.equals("Jeremiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Jeremiah", 52)
    );

} else if (book.equals("Lamentations")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Lamentations", 5)
    );

} else if (book.equals("Ezekiel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ezekiel", 48)
    );

} else if (book.equals("Daniel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Daniel", 12)
    );

} else if (book.equals("Hosea")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Hosea", 14)
    );

} else if (book.equals("Joel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Joel", 3)
    );

} else if (book.equals("Amos")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Amos", 9)
    );

} else if (book.equals("Obadiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Obadiah", 1)
    );

} else if (book.equals("Jonah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Jonah", 4)
    );

} else if (book.equals("Micah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Micah", 7)
    );

} else if (book.equals("Nahum")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Nahum", 3)
    );

} else if (book.equals("Habakkuk")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Habakkuk", 3)
    );

} else if (book.equals("Zephaniah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Zephaniah", 3)
    );

} else if (book.equals("Haggai")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Haggai", 2)
    );

} else if (book.equals("Zechariah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Zechariah", 14)
    );

} else if (book.equals("Malachi")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Malachi", 4)
    );

} else {

    addButton(
            "📖 " + book,
            v -> showMessage(
                    "📖 " + book,
                    "Chapters for " + book + " will be added next."
            )
    );
    }
    }
        addButton(
            "⬅️ Back to Bible",
            v -> showBible()
    );
    }
        void showNewTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 New Testament");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String[] books = {
            "Matthew",
            "Mark",
            "Luke",
            "John",
            "Acts",
            "Romans",
            "1 Corinthians",
            "2 Corinthians",
            "Galatians",
            "Ephesians",
            "Philippians",
            "Colossians",
            "1 Thessalonians",
            "2 Thessalonians",
            "1 Timothy",
            "2 Timothy",
            "Titus",
            "Philemon",
            "Hebrews",
            "James",
            "1 Peter",
            "2 Peter",
            "1 John",
            "2 John",
            "3 John",
            "Jude",
            "Revelation"
    };

    for (String book : books) {
        addButton(
                "📖 " + book,
                v -> showMessage(
                        "📖 " + book,
                        "Chapters for " + book + " will be added next."
                )
        );
    }

    addButton(
            "⬅️ Back to Bible",
            v -> showBible()
    );
        }

    void showGenesisChapters() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Genesis");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a chapter:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    for (int chapter = 1; chapter <= 50; chapter++) {

        final int selectedChapter = chapter;

        addButton(
        "📜 Chapter " + chapter,
        v -> showBibleChapter("Genesis", selectedChapter)
);
    }

    addButton(
            "⬅️ Back to Old Testament",
            v -> showOldTestament()
    );
    }
    void showBookChapters(String book, int chapterCount) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 " + book);
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a chapter:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    for (int chapter = 1; chapter <= chapterCount; chapter++) {

        final int selectedChapter = chapter;

        addButton(
                "📜 Chapter " + chapter,
                v -> showBibleChapter(book, selectedChapter)
        );
    }

    addButton(
            "⬅️ Back",
            v -> showBible()
    );
    }
    void showGenesisChapter1() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Genesis 1 — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView chapterText = new TextView(this);
    chapterText.setText(
            getKJVChapter("Genesis", 1)
    );
    chapterText.setTextSize(18);
    chapterText.setTextColor(darkText);
    chapterText.setPadding(5, 10, 5, 20);

    content.addView(chapterText);

    addButton(
            "⬅️ Back to Genesis",
            v -> showGenesisChapters()
    );
    }
    String getKJVChapter(String book, int chapter) {

    try {
        InputStream inputStream =
                getAssets().open("kjv/" + book + ".json");

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(inputStream)
                );

        StringBuilder jsonText = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }

        reader.close();

        JSONObject bible =
                new JSONObject(jsonText.toString());

        JSONObject chapters =
                bible.getJSONObject("chapters");

        JSONObject selectedChapter =
                chapters.getJSONObject(
                        String.valueOf(chapter)
                );

        StringBuilder result =
                new StringBuilder();

        java.util.Iterator<String> keys =
                selectedChapter.keys();

        while (keys.hasNext()) {

            String verseNumber = keys.next();

            result.append(verseNumber)
                    .append(" ")
                    .append(selectedChapter.getString(verseNumber))
                    .append("\n\n");
        }

        return result.toString().trim();

    } catch (Exception e) {

        return "Unable to load this Bible chapter.";
    }
    }
  void showProgress() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Progress");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard("⭐ Points", totalPoints + " points earned so far.", v -> {});
addCard("🎮 Game Scores", "Complete Bible games to build your score.", v -> {});
addCard("🧠 Memory Verses", learnedVerses + " verse(s) learned.", v -> {});
addCard("🔥 Daily Streak", dailyStreak + " day(s) streak.", v -> {});
addCard(
        "✅ Challenges",
        challengeCompletedToday
                ? "Today's challenge completed."
                : "Today's challenge not completed yet.",
        v -> {}
);
TextView achievementTitle = new TextView(this);
achievementTitle.setText("🏆 Achievements");
achievementTitle.setTextSize(22);
achievementTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
achievementTitle.setTextColor(darkText);
achievementTitle.setPadding(0, 20, 0, 10);
content.addView(achievementTitle);

addCard(
        totalPoints >= 5 ? "✅ First Step" : "🔒 First Step",
        totalPoints >= 5
                ? "You earned your first points!"
                : "Earn 5 points to unlock this achievement.",
        v -> {}
);

addCard(
        learnedVerses >= 5 ? "✅ Bible Learner" : "🔒 Bible Learner",
        learnedVerses >= 5
                ? "You have learned 5 Bible verses!"
                : "Learn 5 Bible verses to unlock this achievement.",
        v -> {}
);

addCard(
        dailyStreak >= 3 ? "✅ Streak Keeper" : "🔒 Streak Keeper",
        dailyStreak >= 3
                ? "You reached a 3-day streak!"
                : "Reach a 3-day streak to unlock this achievement.",
        v -> {}
);

addCard(
        totalPoints >= 50 ? "✅ Point Builder" : "🔒 Point Builder",
        totalPoints >= 50
                ? "You reached 50 points!"
                : "Earn 50 points to unlock this achievement.",
        v -> {}
);

addCard(
        challengeCompletedToday ? "✅ Challenge Complete" : "🔒 Challenge Complete",
        challengeCompletedToday
                ? "You completed today's challenge!"
                : "Complete today's challenge to unlock this achievement.",
        v -> {}
);
addCard(
        correctAnswers > 0
                ? "✅ Quiz Starter"
                : "🔒 Quiz Starter",
        correctAnswers > 0
                ? "You answered a Bible Quiz question correctly!"
                : "Answer a Bible Quiz question correctly to unlock this achievement.",
        v -> {}
);
      addCard(
        scrambleScore > 0
                ? "✅ Puzzle Solver"
                : "🔒 Puzzle Solver",
        scrambleScore > 0
                ? "You earned points from a Bible puzzle!"
                : "Earn points from a Bible puzzle to unlock this achievement.",
        v -> {}
);
      addCard(
        totalPoints >= 5
                ? "✅ Word Finder"
                : "🔒 Word Finder",
        totalPoints >= 5
                ? "You earned points from Missing Word!"
                : "Answer a Missing Word question correctly to unlock this achievement.",
        v -> {}
);
      addCard(
        learnedVerses >= 10
                ? "✅ Memory Master"
                : "🔒 Memory Master",
        learnedVerses >= 10
                ? "You have learned 10 Bible verses!"
                : "Learn 10 Bible verses to unlock this achievement.",
        v -> {}
);
      addCard(
        dailyStreak >= 7
                ? "✅ Streak Champion"
                : "🔒 Streak Champion",
        dailyStreak >= 7
                ? "You reached a 7-day streak!"
                : "Reach a 7-day streak to unlock this achievement.",
        v -> {}
);
      addCard(
        totalPoints >= 100
                ? "✅ 100 Point Milestone"
                : "🔒 100 Point Milestone",
        totalPoints >= 100
                ? "You reached 100 total points!"
                : "Earn 100 points to unlock this achievement.",
        v -> {}
);
addButton("⬅️ Back to Home", v -> showHome());
  }
    void showSettings() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("⚙️ Settings");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "🎵 Background Sound",
            "Control background sound for Kingdom Life.",
            v -> showMessage(
                    "🎵 Background Sound",
                    "Sound controls will be connected when the sound feature is added."
            )
    );

    addCard(
            "🔊 Button Sounds",
            "Control sounds when buttons are pressed.",
            v -> showMessage(
                    "🔊 Button Sounds",
                    "Button sound controls will be available here."
            )
    );

    addCard(
            "🌅 Day & Night Background",
            "Kingdom Life automatically changes the home background based on the time.",
            v -> showMessage(
                    "🌅 Day & Night",
                    "Day background: 6:00 AM – 5:59 PM\n" +
                    "Night background: 6:00 PM – 5:59 AM"
            )
    );

    addCard(
            "📊 Progress",
            "View your points, streaks, and learning progress.",
            v -> showProgress()
    );

    addCard(
            "🏆 Achievements",
            "View your unlocked and locked achievements.",
            v -> showAchievements()
    );

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showAchievements() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Achievements");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            totalPoints >= 5 ? "✅ First Step" : "🔒 First Step",
            totalPoints >= 5
                    ? "You earned your first points!"
                    : "Earn 5 points to unlock this achievement.",
            v -> {}
    );

    addCard(
            learnedVerses >= 5 ? "✅ Bible Learner" : "🔒 Bible Learner",
            learnedVerses >= 5
                    ? "You have learned 5 Bible verses!"
                    : "Learn 5 Bible verses to unlock this achievement.",
            v -> {}
    );

    addCard(
            dailyStreak >= 3 ? "✅ Streak Keeper" : "🔒 Streak Keeper",
            dailyStreak >= 3
                    ? "You reached a 3-day streak!"
                    : "Reach a 3-day streak to unlock this achievement.",
            v -> {}
    );

    addCard(
            totalPoints >= 50 ? "✅ Point Builder" : "🔒 Point Builder",
            totalPoints >= 50
                    ? "You reached 50 points!"
                    : "Earn 50 points to unlock this achievement.",
            v -> {}
    );

    addCard(
            challengeCompletedToday
                    ? "✅ Challenge Complete"
                    : "🔒 Challenge Complete",
            challengeCompletedToday
                    ? "You completed today's challenge!"
                    : "Complete today's challenge to unlock this achievement.",
            v -> {}
    );

    addButton("⬅️ Back to Progress", v -> showProgress());
    }
    void showAbout() {
        showMessage(
                "ℹ️ About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, " +
                        "prayer, reflection, daily challenges, and fun Bible activities.\n\n" +
                        "Version 2.2"
        );
    }
    void showGuessVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Guess the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which verse belongs to this reference?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView reference = new TextView(this);
    reference.setText("📖 Jeremiah 29:11 — KJV");
    reference.setTextSize(21);
    reference.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    reference.setTextColor(darkText);
    reference.setGravity(Gravity.CENTER);
    reference.setPadding(10, 15, 10, 20);
    content.addView(reference);

    String[] choices = {
            "For I know the thoughts that I think toward you, saith the LORD, thoughts of peace, and not of evil, to give you an expected end.",
            "The LORD is my shepherd; I shall not want.",
            "I can do all things through Christ which strengtheneth me.",
            "Trust in the LORD with all thine heart; and lean not unto thine own understanding."
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(15);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;
              prefs.edit()
        .putInt("totalPoints", totalPoints)
        .apply();
    feedback.setText("✅ Correct! Excellent memory!\n+10 points");
            } else {
                feedback.setText("❌ Not quite. Try to remember Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
       

    void showCompleteVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("✍️ Complete the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose the missing words from Jeremiah 29:11.");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "📖 Jeremiah 29:11 — KJV\n\n" +
            "For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an ________ end."
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "expected",
            "peaceful",
            "wonderful",
            "joyful"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    feedback.setText("✅ Correct! The missing word is \"expected\".\n+10 points");
} else {
    feedback.setText("❌ Not quite. The correct answer is \"expected\".");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
  void showGuessReference() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔄 Guess the Reference");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which Bible reference contains this verse?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "\"For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an expected end.\""
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "Jeremiah 29:11",
            "Psalm 23:1",
            "John 3:16",
            "Philippians 4:13"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    feedback.setText("✅ Correct! Jeremiah 29:11.\n+10 points");
} else {
    feedback.setText("❌ Not quite. The correct answer is Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
                                  }
    void showGameMenu() {
        stopTimer();
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText("🎮 Bible Games");
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 20);

        content.addView(title);

        TextView instruction = new TextView(this);
        instruction.setText("Choose a difficulty level:");
        instruction.setTextSize(18);
        instruction.setTextColor(darkText);
        instruction.setPadding(0, 0, 0, 15);

        content.addView(instruction);

        addButton("🟢 Level 1 — Easy", v -> {
    currentLevel = 1;
    startGame(30000);
});

        if (highestLevelUnlocked >= 2) {
    addButton("🟡 Level 2 — Medium", v -> {
        currentLevel = 2;
        startGame(20000);
    });
} else {
    addButton("🔒 Level 2 — Locked", v -> {});
                  }

        if (highestLevelUnlocked >= 3) {
    addButton("🔴 Level 3 — Hard", v -> {
        currentLevel = 3;
        startGame(10000);
    });
} else {
    addButton("🔒 Level 3 — Locked", v -> {});
        }
addButton("🧩 Bible Scramble", v -> showBibleScramble());
        addButton("🔤 Missing Word", v -> showMissingWord());
        addButton("⬅️ Back to Home", v -> showHome());
    }

    void startGame(int milliseconds) {
        stopTimer();

        timeLimit = milliseconds;
       currentQuestion = 0;
score = 0;
correctAnswers = 0;
wrongAnswers = 0; 

        showQuestion();
    }

    void showQuestion() {
        stopTimer();
        content.removeAllViews();

        answered = false;
        int questionCount;

if (currentLevel == 2) {
    questionCount = level2Questions.length;
} else if (currentLevel == 3) {
    questionCount = level3Questions.length;
} else {
    questionCount = questions.length;
}
TextView levelText = new TextView(this);
levelText.setText("🏆 Level " + currentLevel);
levelText.setTextSize(20);
levelText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
levelText.setTextColor(darkText);
levelText.setPadding(0, 10, 0, 5);

content.addView(levelText);
        TextView progress = new TextView(this);
        progress.setText("Question " + (currentQuestion + 1) + " of " + questionCount);
        progress.setTextSize(18);
        progress.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        progress.setTextColor(darkText);
        progress.setPadding(0, 10, 0, 10);

        content.addView(progress);

        TextView timerText = new TextView(this);
        timerText.setTextSize(18);
        timerText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        timerText.setTextColor(darkText);
        timerText.setGravity(Gravity.CENTER);
        timerText.setPadding(0, 5, 0, 15);

        content.addView(timerText);

        TextView question = new TextView(this);
        if (currentLevel == 2) {
    question.setText(level2Questions[currentQuestion]);
} else if (currentLevel == 3) {
    question.setText(level3Questions[currentQuestion]);
} else {
    question.setText(questions[currentQuestion]);
        }
        question.setTextSize(22);
        question.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        question.setTextColor(darkText);
        question.setPadding(0, 10, 0, 20);

        content.addView(question);

        Button[] answerButtons = new Button[4];

        for (int i = 0; i < 4; i++) {
            final int selected = i;

            answerButtons[i] = new Button(this);
            if (currentLevel == 2) {
    answerButtons[i].setText(level2Options[currentQuestion][i]);
} else if (currentLevel == 3) {
    answerButtons[i].setText(level3Options[currentQuestion][i]);
} else {
    answerButtons[i].setText(options[currentQuestion][i]);
            }
            answerButtons[i].setTextSize(17);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(0, 5, 0, 5);

            content.addView(answerButtons[i], params);

            answerButtons[i].setOnClickListener(v ->
                    answerQuestion(selected, answerButtons)
            );
        }

        TextView result = new TextView(this);
        result.setTextSize(18);
        result.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        result.setPadding(0, 15, 0, 10);
        content.addView(result);

        LinearLayout navigation = new LinearLayout(this);
        navigation.setOrientation(LinearLayout.HORIZONTAL);

        Button previous = new Button(this);
        previous.setText("← Previous");
        previous.setTextSize(15);
        previous.setEnabled(currentQuestion > 0);

        Button next = new Button(this);
        next.setText(currentQuestion == questionCount - 1
        ? "Finish →"
        : "Next →");
        next.setTextSize(15);

        navigation.addView(previous, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        navigation.addView(next, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        content.addView(navigation);

        previous.setOnClickListener(v -> {
            if (currentQuestion > 0) {
                currentQuestion--;
                showQuestion();
            }
        });

        next.setOnClickListener(v -> {
            if (currentQuestion < questionCount - 1) {
    currentQuestion++;
    showQuestion();
} else {
    showResults();
            }
        });

        timer = new CountDownTimer(timeLimit, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText("⏱️ Time: "
                        + ((millisUntilFinished + 999) / 1000)
                        + " seconds");
            }

            public void onFinish() {
                if (!answered) {
                    answered = true;
                    wrongAnswers++;
                    String correctOption;

if (currentLevel == 2) {
    correctOption = level2Options[currentQuestion][level2Answers[currentQuestion]];
} else if (currentLevel == 3) {
    correctOption = level3Options[currentQuestion][level3Answers[currentQuestion]];
} else {
    correctOption = options[currentQuestion][answers[currentQuestion]];
}

result.setText("⏰ Time's up! The correct answer is: " + correctOption);

                    for (Button button : answerButtons) {
                        button.setEnabled(false);
                    }
                }
            }
        }.start();
    }

    void answerQuestion(int selected, Button[] buttons) {
        if (answered) {
            return;
        }

        answered = true;
        stopTimer();

        TextView feedback = new TextView(this);
        feedback.setTextSize(18);

        int correctAnswer;

if (currentLevel == 2) {
    correctAnswer = level2Answers[currentQuestion];
} else if (currentLevel == 3) {
    correctAnswer = level3Answers[currentQuestion];
} else {
    correctAnswer = answers[currentQuestion];
}

if (selected == correctAnswer) {
    score += 10;
    totalPoints += 10;
    correctAnswers++;
          prefs.edit()
        .putInt("totalPoints", totalPoints)
        .apply();
            feedback.setText("✅ Correct! +10 points");
        } else {
            wrongAnswers++;
            String correctOption;

if (currentLevel == 2) {
    correctOption = level2Options[currentQuestion][level2Answers[currentQuestion]];
} else if (currentLevel == 3) {
    correctOption = level3Options[currentQuestion][level3Answers[currentQuestion]];
} else {
    correctOption = options[currentQuestion][answers[currentQuestion]];
}

feedback.setText("❌ Wrong! Correct answer: " + correctOption);
        }

        feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        feedback.setTextColor(darkText);

        content.addView(feedback, 3);

        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    void showResults() {
        stopTimer();
        content.removeAllViews();
        if (currentLevel == highestLevelUnlocked && highestLevelUnlocked < 3) {
    highestLevelUnlocked++;

    prefs.edit()
            .putInt("highestLevelUnlocked", highestLevelUnlocked)
            .apply();
        }

        TextView title = new TextView(this);
        title.setText("🏆 Game Complete!");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 20, 0, 20);

        content.addView(title);

        TextView results = new TextView(this);
        results.setText(
                "Score: " + score + "\n\n" +
                        "✅ Correct: " + correctAnswers + "\n" +
                        "❌ Wrong: " + wrongAnswers + "\n\n" +
                        "Great job! Keep learning God's Word."
        );
        results.setTextSize(20);
        results.setTextColor(darkText);
        results.setGravity(Gravity.CENTER);
        results.setPadding(0, 10, 0, 25);

        content.addView(results);

        addButton("🔄 Play Again", v -> startGame(timeLimit));

        addButton("⬅️ Back to Games", v -> showGameMenu());

        addButton("🏠 Back to Home", v -> showHome());
    }
void showBibleScramble() {
    stopTimer();
    content.removeAllViews();

    scrambleQuestion = 0;
    scrambleScore = 0;

    showScrambleQuestion();
}
    void showScrambleQuestion() {
    content.removeAllViews();

    String word = scrambleWords[scrambleQuestion];

    TextView title = new TextView(this);
    title.setText("🧩 Bible Scramble");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " + (scrambleQuestion + 1) + " of 25"
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setPadding(0, 0, 0, 15);
    content.addView(progress);

    TextView scrambled = new TextView(this);
    scrambled.setText("Unscramble: " + scrambleWord(word));
    scrambled.setTextSize(26);
    scrambled.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    scrambled.setTextColor(darkText);
    scrambled.setGravity(Gravity.CENTER);
    scrambled.setPadding(0, 20, 0, 25);
    content.addView(scrambled);
EditText answerInput = new EditText(this);
answerInput.setHint("Type your answer here");
answerInput.setTextSize(18);
answerInput.setSingleLine(true);
content.addView(answerInput);
    addButton("✅ Submit Answer", v -> {
    String userAnswer = answerInput.getText().toString().trim();

    if (userAnswer.equalsIgnoreCase(word)) {
        scrambleScore += 5;
        totalPoints += 5;

        prefs.edit()
                .putInt("totalPoints", totalPoints)
                .apply();

        TextView feedback = new TextView(this);
        feedback.setText("🎉 Correct! +5 points");
        feedback.setTextSize(20);
        feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);
        content.addView(feedback, 3);

        answerInput.setEnabled(false);
        addButton("➡️ Next Question", nextView -> {
    if (scrambleQuestion < scrambleWords.length - 1) {
        scrambleQuestion++;
        showScrambleQuestion();
    } else {
        showScrambleFinalResult();
    }
});
    } else {
        TextView feedback = new TextView(this);
        feedback.setText("❌ Not quite. Try again!");
        feedback.setTextSize(18);
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);
        content.addView(feedback, 3);
    }
});

    addButton("➡️ Skip", v -> {
        if (scrambleQuestion < scrambleWords.length - 1) {
            scrambleQuestion++;
            showScrambleQuestion();
        } else {
            showScrambleFinalResult();
        }
    });

    addButton("⬅️ Back to Games", v -> showGameMenu());
    }
    String scrambleWord(String word) {
    char[] letters = word.toCharArray();

    for (int i = letters.length - 1; i > 0; i--) {
        int j = (int) (Math.random() * (i + 1));

        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }

    return new String(letters);
    }
    void showScrambleFinalResult() {
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Scramble Complete!");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    content.addView(title);

    TextView result = new TextView(this);
    result.setText(
            "You completed all 25 questions!\n\n" +
            "🧩 Scramble Score: " + scrambleScore + "\n" +
            "⭐ Total Points: " + totalPoints
    );
    result.setTextSize(20);
    result.setTextColor(darkText);
    result.setGravity(Gravity.CENTER);
    result.setPadding(0, 10, 0, 30);
    content.addView(result);

    addButton("🔄 Play Again", v -> showBibleScramble());
    addButton("⬅️ Back to Games", v -> showGameMenu());
    addButton("🏠 Back to Home", v -> showHome());
    }
    
    void addButton(String text, View.OnClickListener listener) {
    Button button = new Button(this);

    button.setText(text);
    button.setTextSize(17);
    button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    button.setTextColor(darkText);
    button.setAllCaps(false);
    button.setPadding(24, 16, 24, 16);

    // Rounded button background
    GradientDrawable buttonBackground = new GradientDrawable();
    buttonBackground.setColor(Color.argb(225, 255, 255, 255));
    buttonBackground.setCornerRadius(32);
    button.setBackground(buttonBackground);

    // Subtle depth
    button.setElevation(5);

    button.setOnClickListener(listener);

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );

    params.setMargins(12, 8, 12, 8);

    content.addView(button, params);
    }
    void addFeatureGrid() {

    LinearLayout grid = new LinearLayout(this);
    grid.setOrientation(LinearLayout.VERTICAL);

    LinearLayout row1 = new LinearLayout(this);
    row1.setOrientation(LinearLayout.HORIZONTAL);

    LinearLayout row2 = new LinearLayout(this);
    row2.setOrientation(LinearLayout.HORIZONTAL);

    LinearLayout row3 = new LinearLayout(this);
    row3.setOrientation(LinearLayout.HORIZONTAL);

    String[] titles = {
            "🎮 Bible Quiz",
            "🧠 Memory Verse",
            "🧩 Bible Puzzles",
            "🎯 Daily Challenge",
            "📈 Progress",
            "🏆 Achievements"
    };

    View.OnClickListener[] actions = {
            v -> showGameMenu(),
            v -> showMemoryVerse(),
            v -> showGameMenu(),
            v -> showMessage("🎯 Daily Challenge",
                    "Complete today's challenge to earn points and build your streak."),
            v -> showProgress(),
            v -> showProgress()
    };

    for (int i = 0; i < titles.length; i++) {

        Button button = new Button(this);
        button.setText(titles[i]);
        button.setTextSize(14);
        button.setAllCaps(false);
        button.setOnClickListener(actions[i]);
        button.setTextColor(Color.WHITE);
button.setGravity(Gravity.CENTER);

GradientDrawable buttonBackground = new GradientDrawable();
buttonBackground.setColor(Color.argb(220, 0, 0, 0));
buttonBackground.setCornerRadius(24);

button.setBackground(buttonBackground);
button.setElevation(4);

        LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
                0,
                110,
                1
        );

        params.setMargins(6, 6, 6, 6);

        if (i < 2) {
            row1.addView(button, params);
        } else if (i < 4) {
            row2.addView(button, params);
        } else {
            row3.addView(button, params);
        }
    }

    grid.addView(row1);
    grid.addView(row2);
    grid.addView(row3);

    content.addView(grid);
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

    void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onDestroy() {
        stopTimer();
        super.onDestroy();
    }
    void showMissingWord() {
    stopTimer();
    content.removeAllViews();

    final String[][] questions = {
            {"Trust in the Lord with all your ___",
             "heart", "mind", "strength", "soul", "Proverbs 3:5"},

            {"I can do all things through Christ which ___ me",
             "strengtheneth", "guideth", "teacheth", "keepeth", "Philippians 4:13"},

            {"The Lord is my ___; I shall not want",
             "shepherd", "refuge", "strength", "rock", "Psalm 23:1"},

            {"Be strong and of a good ___",
             "courage", "faith", "hope", "heart", "Joshua 1:9"},

            {"And we know that all things work together for ___",
             "good", "peace", "love", "wisdom", "Romans 8:28"},

            {"Thy word is a ___ unto my feet",
             "lamp", "light", "guide", "shield", "Psalm 119:105"},

            {"Fear thou not; for I am with ___",
             "thee", "you", "him", "them", "Isaiah 41:10"},

            {"But seek ye first the kingdom of ___",
             "God", "heaven", "Christ", "glory", "Matthew 6:33"},

            {"If any of you lack ___, let him ask of God",
             "wisdom", "faith", "strength", "knowledge", "James 1:5"},

            {"Let all your things be done with ___",
             "charity", "faith", "joy", "peace", "1 Corinthians 16:14"},

            {"The joy of the Lord is your ___",
             "strength", "peace", "refuge", "salvation", "Nehemiah 8:10"},

            {"God is our refuge and ___",
             "strength", "shield", "rock", "helper", "Psalm 46:1"},

            {"The fear of the Lord is the beginning of ___",
             "wisdom", "knowledge", "understanding", "faith", "Proverbs 9:10"},

            {"Create in me a clean ___, O God",
             "heart", "spirit", "mind", "soul", "Psalm 51:10"},

            {"This is the day which the Lord hath ___",
             "made", "given", "blessed", "chosen", "Psalm 118:24"},

            {"Cast thy burden upon the Lord, and he shall ___ thee",
             "sustain", "strengthen", "guide", "comfort", "Psalm 55:22"},

            {"The Lord is good, a strong hold in the day of ___",
             "trouble", "battle", "sorrow", "fear", "Nahum 1:7"},

            {"Walk by ___, not by sight",
             "faith", "hope", "love", "wisdom", "2 Corinthians 5:7"},

            {"Rejoice in the Lord ___",
             "alway", "always", "daily", "forever", "Philippians 4:4"},

            {"Pray without ___",
             "ceasing", "stopping", "fear", "doubt", "1 Thessalonians 5:17"},

            {"Let your light so ___ before men",
             "shine", "glow", "stand", "rise", "Matthew 5:16"},

            {"Blessed are the ___ in heart",
             "pure", "humble", "meek", "faithful", "Matthew 5:8"},

            {"The Lord is my light and my ___",
             "salvation", "strength", "refuge", "shield", "Psalm 27:1"},

            {"Wait on the Lord: be of good ___",
             "courage", "hope", "faith", "cheer", "Psalm 27:14"},

            {"Whatsoever ye do, do it ___",
             "heartily", "faithfully", "quickly", "joyfully", "Colossians 3:23"}
    };

    showMissingWordQuestion(questions, 0);
}

void showMissingWordQuestion(String[][] questions, int questionIndex) {
    content.removeAllViews();

    String[] q = questions[questionIndex];
    final boolean[] answered = {false};

    TextView title = new TextView(this);
    title.setText("🔤 Missing Word");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " + (questionIndex + 1) + " of " + questions.length
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setPadding(0, 0, 0, 15);
    content.addView(progress);

    TextView reference = new TextView(this);
    reference.setText("📖 " + q[5]);
    reference.setTextSize(16);
    reference.setTextColor(darkText);
    reference.setGravity(Gravity.CENTER);
    reference.setPadding(0, 0, 0, 15);
    content.addView(reference);

    TextView verse = new TextView(this);
    verse.setText(q[0]);
    verse.setTextSize(21);
    verse.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    verse.setTextColor(darkText);
    verse.setGravity(Gravity.CENTER);
    verse.setPadding(0, 15, 0, 25);
    content.addView(verse);

    Button[] answerButtons = new Button[4];

    for (int i = 0; i < 4; i++) {
        final int selected = i;

        answerButtons[i] = new Button(this);
        answerButtons[i].setText(
                (char)('A' + i) + ". " + q[i + 1]
        );
        answerButtons[i].setTextSize(17);
        answerButtons[i].setAllCaps(false);

        content.addView(answerButtons[i]);

        answerButtons[i].setOnClickListener(v -> {
            if (answered[0]) {
                return;
            }

            answered[0] = true;

            for (Button button : answerButtons) {
                button.setEnabled(false);
            }

            TextView feedback = new TextView(this);
            feedback.setTextSize(19);
            feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            feedback.setTextColor(darkText);
            feedback.setGravity(Gravity.CENTER);
            feedback.setPadding(0, 15, 0, 15);

            if (selected == 0) {
                totalPoints += 5;

                prefs.edit()
                        .putInt("totalPoints", totalPoints)
                        .apply();

                feedback.setText(
                        "🎉 Correct! +5 points\n\n" +
                        "⭐ Total Points: " + totalPoints
                );
            } else {
                feedback.setText(
                        "❌ Not quite.\n\n" +
                        "The correct answer is: " + q[1]
                );
            }

            content.addView(feedback);

            if (questionIndex < questions.length - 1) {
                addButton(
                        "➡️ Next Question",
                        nextView -> showMissingWordQuestion(
                                questions,
                                questionIndex + 1
                        )
                );
            } else {
                addButton(
                        "🏆 Finish",
                        finishView -> showMessage(
                                "🏆 Missing Word Complete!",
                                "You completed all 25 questions!\n\n" +
                                "⭐ Total Points: " + totalPoints
                        )
                );
            }
        });
    }

    addButton("⬅️ Back to Games", v -> showGameMenu());
            }
  }
