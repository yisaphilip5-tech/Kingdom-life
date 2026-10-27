
package com.kingdomlife.app;

import com.kingdomlife.app.descendants.DescendantsOfGoodLibrary;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.WindowInsets;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.view.Gravity;
import android.widget.ImageButton;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Space;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

    LinearLayout content;
  SharedPreferences prefs;
    SharedPreferences savedVersesPrefs;
    SharedPreferences notesPrefs;
    SharedPreferences highlightsPrefs;
    SharedPreferences bookmarksPrefs;
    SharedPreferences challengePrefs;

    int darkText = Color.rgb(45, 45, 45);
    int cardColor = Color.rgb(245, 247, 250);

    String[] questions = BibleChallengeData.questions;
String[][] options = BibleChallengeData.options;
int[] answers = BibleChallengeData.answers;

String[] level2Questions = BibleChallengeData.level2Questions;
String[][] level2Options = BibleChallengeData.level2Options;
int[] level2Answers = BibleChallengeData.level2Answers;

String[] level3Questions = BibleChallengeData.level3Questions;
String[][] level3Options = BibleChallengeData.level3Options;
int[] level3Answers = BibleChallengeData.level3Answers;

    int currentQuestion = 0;
    int currentLevel = 1;
    int highestLevelUnlocked = 1;
    int score = 0;
    
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

// Bible Journey
String currentBibleBook = "";
String currentBibleDifficulty = "";
    float bibleJourneyTouchX;

int bibleJourneyQuestion = 0;
int bibleJourneyScore = 0;

ArrayList<String> bibleJourneyQuestions = new ArrayList<>();
ArrayList<String[]> bibleJourneyOptions = new ArrayList<>();
ArrayList<Integer> bibleJourneyAnswers = new ArrayList<>();
    
    void loadGenesisQuestions(String difficulty) {
    GenesisJourneyData.loadGenesisQuestions(
            difficulty,
            bibleJourneyQuestions,
            bibleJourneyOptions,
            bibleJourneyAnswers
    );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

    NotificationChannel channel =
            new NotificationChannel(
                    "kingdom_life_reminders",
                    "Kingdom Life Reminders",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

    channel.setDescription(
            "Reminders for Bible reading, Memory Verse, and Daily Challenge."
    );

    NotificationManager manager =
            getSystemService(NotificationManager.class);

    if (manager != null) {
        manager.createNotificationChannel(channel);
    }
            if (Build.VERSION.SDK_INT >= 33) {

    if (checkSelfPermission(
            "android.permission.POST_NOTIFICATIONS"
    ) != PackageManager.PERMISSION_GRANTED) {

        requestPermissions(
                new String[]{
                        "android.permission.POST_NOTIFICATIONS"
                },
                2001
        );
    }
            }
        }
        savedVersesPrefs = getSharedPreferences(
        "saved_verses",
        MODE_PRIVATE
);
        notesPrefs = getSharedPreferences(
        "bible_notes",
        MODE_PRIVATE
);
        highlightsPrefs = getSharedPreferences(
        "bible_highlights",
        MODE_PRIVATE
);
        bookmarksPrefs = getSharedPreferences(
        "bible_bookmarks",
        MODE_PRIVATE
);
        challengePrefs = getSharedPreferences(
        "daily_challenge",
        MODE_PRIVATE
);
      prefs = getSharedPreferences("KingdomLifePrefs", MODE_PRIVATE);
dailyStreak = prefs.getInt("dailyStreak", 0);
totalPoints = prefs.getInt("totalPoints", 0);
learnedVerses = prefs.getInt("learnedVerses", 0);
        SharedPreferences savedVersesPrefs;
lastChallengeDate = prefs.getString("lastChallengeDate", "");

String today =
        new java.text.SimpleDateFormat(
                "yyyy-MM-dd",
                java.util.Locale.getDefault()
        ).format(new java.util.Date());

challengeCompletedToday =
        today.equals(lastChallengeDate);

highestLevelUnlocked = prefs.getInt("highestLevelUnlocked", 1);
        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(0, 0, 0, 80);
        main.setBackgroundColor(Color.WHITE);

        

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
            showLearnMenu()
    );

    } else if (item.contains("Explore")) {

    navButton.setOnClickListener(v ->
            showExplore()
    );

    } else if (item.contains("Achievements")) {

    navButton.setOnClickListener(v ->
            startActivity(
                    new android.content.Intent(
                            MainActivity.this,
                            AchievementsActivity.class
                    )
            )
    );

} else {

    navButton.setOnClickListener(v ->
            showMoreMenu()
    );
    }
}

main.addView(bottomNav);
    setContentView(main);
        final int baseLeft = main.getPaddingLeft();
final int baseTop = main.getPaddingTop();
final int baseRight = main.getPaddingRight();
final int baseBottom = main.getPaddingBottom();

main.setOnApplyWindowInsetsListener((v, insets) -> {
    int topInset;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        topInset = insets.getInsets(WindowInsets.Type.statusBars()).top;
    } else {
        topInset = insets.getSystemWindowInsetTop();
    }

    v.setPadding(
            baseLeft,
            baseTop + topInset,
            baseRight,
            baseBottom
    );

    return insets;
});

main.requestApplyInsets();

content.removeAllViews();

ImageView loadingIcon = new ImageView(this);
loadingIcon.setImageResource(R.drawable.kingdom_life_icon);
loadingIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);

LinearLayout loadingScreen = new LinearLayout(this);
loadingScreen.setOrientation(LinearLayout.VERTICAL);
loadingScreen.setGravity(Gravity.CENTER);
loadingScreen.setPadding(20, 30, 20, 30);
loadingScreen.setBackgroundColor(Color.WHITE);

LinearLayout.LayoutParams iconParams =
        new LinearLayout.LayoutParams(180, 180);
iconParams.gravity = Gravity.CENTER;
loadingScreen.addView(loadingIcon, iconParams);

TextView loadingTitle = new TextView(this);
loadingTitle.setText("Kingdom Life");
loadingTitle.setTextSize(28);
loadingTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
loadingTitle.setTextColor(Color.rgb(106, 75, 188));
loadingTitle.setGravity(Gravity.CENTER);
loadingTitle.setPadding(0, 20, 0, 8);
loadingScreen.addView(loadingTitle);

TextView loadingSubtitle = new TextView(this);
loadingSubtitle.setText("Grow in faith. Live with purpose.");
loadingSubtitle.setTextSize(16);
loadingSubtitle.setTextColor(Color.DKGRAY);
loadingSubtitle.setGravity(Gravity.CENTER);
loadingSubtitle.setPadding(0, 0, 0, 25);
loadingScreen.addView(loadingSubtitle);

ProgressBar loadingProgress = new ProgressBar(this);
loadingProgress.setIndeterminate(true);
loadingScreen.addView(loadingProgress);

content.addView(loadingScreen);
new Handler().postDelayed(() -> {
    showHome();
}, 1200);
    }

    void showHome() {
        stopTimer();
content.removeAllViews();
        content.setPadding(12, 0, 12, 12);
        android.content.SharedPreferences displayPrefs =
        getSharedPreferences("KingdomLifeDisplayPrefs", MODE_PRIVATE);

String displayMode = displayPrefs.getString("displayMode", "AUTO");

if (displayMode.equals("DAY")) {
    content.setBackgroundResource(R.drawable.kingdom_home_bg);
} else if (displayMode.equals("NIGHT")) {
    content.setBackgroundResource(R.drawable.kingdom_night_bg);
} else {
    int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

    if (hour >= 6 && hour < 18) {
        content.setBackgroundResource(R.drawable.kingdom_home_bg);
    } else {
        content.setBackgroundResource(R.drawable.kingdom_night_bg);
    }
}

/* ===== KINGDOM LIFE HEADER ===== */

LinearLayout header = new LinearLayout(this);
header.setOrientation(LinearLayout.HORIZONTAL);
header.setGravity(Gravity.CENTER_VERTICAL);
header.setPadding(5, 90, 5, 5);

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
        Space headerSpace = new Space(this);

content.addView(
        headerSpace,
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                12
        )
);

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
        "What is the Word of God saying about you today?",
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
String[] dailyChallenges =
        DailyChallengeData.getChallenges();

int challengeIndex = (int) (
        System.currentTimeMillis()
        / (1000L * 60 * 60 * 24)
        % dailyChallenges.length
);

        addHomeButtonGrid();

addCard(
        "▶️ Continue Learning",
        "Continue your Bible learning journey from where you left off.",
        v -> showBible()
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
    
void addAchievementCard(
        LinearLayout row,
        String icon,
        String heading,
        String description,
        boolean unlocked) {

    final int purple = Color.rgb(30, 24, 55);
    final int gold = Color.rgb(184, 134, 11);

    android.widget.FrameLayout card =
            new android.widget.FrameLayout(this);

    GradientDrawable background = new GradientDrawable();
    background.setColor(purple);
    background.setCornerRadius(24);
    background.setStroke(2, gold);

    card.setBackground(background);
    card.setElevation(5);
    card.setClipChildren(false);
    card.setClipToPadding(false);

    LinearLayout body = new LinearLayout(this);
    body.setOrientation(LinearLayout.VERTICAL);
    body.setGravity(Gravity.CENTER);
    body.setPadding(10, 16, 10, 16);
    body.setClipChildren(false);

    android.widget.FrameLayout.LayoutParams bodyParams =
            new android.widget.FrameLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            );

    card.addView(body, bodyParams);

    android.widget.FrameLayout iconArea =
            new android.widget.FrameLayout(this);

    iconArea.setMinimumHeight(48);
    iconArea.setClipChildren(false);

    TextView iconView = new TextView(this);
    iconView.setText(icon);
    iconView.setTextSize(32);
    iconView.setGravity(Gravity.CENTER);
    iconView.setVisibility(unlocked ? View.VISIBLE : View.GONE);

    android.widget.FrameLayout.LayoutParams iconParams =
            new android.widget.FrameLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            );

    iconArea.addView(iconView, iconParams);

    TextView lockView = new TextView(this);
    lockView.setText("🔒");
    lockView.setTextSize(32);
    lockView.setGravity(Gravity.CENTER);
    lockView.setVisibility(unlocked ? View.GONE : View.VISIBLE);

    android.widget.FrameLayout.LayoutParams lockParams =
            new android.widget.FrameLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            );

    iconArea.addView(lockView, lockParams);
    body.addView(iconArea);

    TextView titleView = new TextView(this);
    titleView.setText(heading);
    titleView.setTextSize(16);
    titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    titleView.setTextColor(Color.rgb(255, 215, 0));
    titleView.setGravity(Gravity.CENTER);
    titleView.setPadding(0, 8, 0, 6);
    body.addView(titleView);

    TextView descriptionView = new TextView(this);
    descriptionView.setText(description);
    descriptionView.setTextSize(12);
    descriptionView.setTextColor(Color.WHITE);
    descriptionView.setGravity(Gravity.CENTER);
    body.addView(descriptionView);

    TextView statusView = new TextView(this);
    statusView.setText(unlocked ? "✓ UNLOCKED" : "🔒 LOCKED");
    statusView.setTextSize(11);
    statusView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    statusView.setTextColor(unlocked ? gold : Color.LTGRAY);
    statusView.setGravity(Gravity.CENTER);
    statusView.setPadding(0, 10, 0, 0);
    body.addView(statusView);

    LinearLayout.LayoutParams cardParams =
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
            );

    cardParams.setMargins(6, 6, 6, 6);
    row.addView(card, cardParams);

    card.setTag(heading);

    // Use the same keys defined in showAchievements().
    String achievementKey;

    switch (heading) {
        case "First Step":
            achievementKey = "first_step";
            break;
        case "Bible Learner":
            achievementKey = "bible_learner";
            break;
        case "Streak Keeper":
            achievementKey = "streak_keeper";
            break;
        case "Point Builder":
            achievementKey = "point_builder";
            break;
        case "Challenge Complete":
            achievementKey = "challenge_complete";
            break;
        case "Easy Challenger":
            achievementKey = "easy_challenger";
            break;
        case "Medium Challenger":
            achievementKey = "medium_challenger";
            break;
        case "Hard Challenger":
            achievementKey = "hard_challenger";
            break;
        case "Challenge Master":
            achievementKey = "challenge_master";
            break;
        case "100 Questions":
            achievementKey = "questions_100";
            break;
        case "250 Questions":
            achievementKey = "questions_250";
            break;
        case "500 Questions":
            achievementKey = "questions_500";
            break;
        case "1,000 Questions":
            achievementKey = "questions_1000";
            break;
        case "5 Books":
            achievementKey = "books_5";
            break;
        case "10 Books":
            achievementKey = "books_10";
            break;
        case "25 Books":
            achievementKey = "books_25";
            break;
        case "50 Books":
            achievementKey = "books_50";
            break;
        case "66 Books":
            achievementKey = "books_66";
            break;
        default:
            achievementKey = null;
            break;
    }

    if (unlocked && achievementKey != null) {

        String pendingKey =
                "pending_achievement_animation_" + achievementKey;

        boolean pendingAnimation =
                prefs.getBoolean(pendingKey, false);

        if (pendingAnimation) {

            // Consume the saved flag so this animation runs only once.
            prefs.edit()
                    .putBoolean(pendingKey, false)
                    .apply();

            card.postDelayed(
                    () -> animateAchievementUnlock(
                            card,
                            lockView,
                            iconView
                    ),
                    300
            );
        }
    }
}
    void animateAchievementUnlock(
        android.view.View card,
        android.view.View lockView,
        android.view.View iconView) {

    if (card == null || lockView == null || iconView == null) {
        return;
    }

    if (card.getTag() == null) {
        return;
    }

    android.view.animation.Animation shake =
            new android.view.animation.TranslateAnimation(
                    -8, 8, 0, 0
            );

    shake.setDuration(70);
    shake.setRepeatCount(5);
    shake.setRepeatMode(
            android.view.animation.Animation.REVERSE
    );

    shake.setAnimationListener(
            new android.view.animation.Animation.AnimationListener() {

                @Override
                public void onAnimationStart(
                        android.view.animation.Animation animation) {
                }

                @Override
                public void onAnimationEnd(
                        android.view.animation.Animation animation) {

                    android.view.animation.Animation fall =
                            new android.view.animation.TranslateAnimation(
                                    0, 0,
                                    0, Math.max(80, lockView.getHeight())
                            );

                    fall.setDuration(650);
                    fall.setFillAfter(false);

                    fall.setAnimationListener(
                            new android.view.animation.Animation.AnimationListener() {

                                @Override
                                public void onAnimationStart(
                                        android.view.animation.Animation animation) {
                                }

                                @Override
                                public void onAnimationEnd(
                                        android.view.animation.Animation animation) {

                                    lockView.setVisibility(View.GONE);
                                    iconView.setVisibility(View.VISIBLE);

                                    if (card instanceof android.view.ViewGroup) {
                                        android.view.ViewGroup cardGroup =
                                                (android.view.ViewGroup) card;

                                        android.widget.FrameLayout sparkleLayer =
                                                new android.widget.FrameLayout(
                                                        MainActivity.this
                                                );

                                        android.widget.FrameLayout.LayoutParams sparkleParams =
                                                new android.widget.FrameLayout.LayoutParams(
                                                        android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                                                        android.view.ViewGroup.LayoutParams.MATCH_PARENT
                                                );

                                        cardGroup.addView(
                                                sparkleLayer,
                                                sparkleParams
                                        );

                                        playAchievementCelebration(sparkleLayer);

                                        sparkleLayer.postDelayed(
                                                () -> cardGroup.removeView(sparkleLayer),
                                                3500
                                        );
                                    }
                                }

                                @Override
                                public void onAnimationRepeat(
                                        android.view.animation.Animation animation) {
                                }
                            }
                    );

                    lockView.startAnimation(fall);
                }

                @Override
                public void onAnimationRepeat(
                        android.view.animation.Animation animation) {
                }
            }
    );

    lockView.startAnimation(shake);
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
        v -> showDailyChallenge()
));
    row2.addView(createHomeSquareButton(
            "📊\nProgress",
            v -> showProgress()
    ));

    row2.addView(createHomeSquareButton(
"🏆\nAchievements",
v -> startActivity(
new android.content.Intent(
MainActivity.this,
AchievementsActivity.class
)
)
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
                    120,
                    1
            );

    params.setMargins(4, 4, 4, 4);

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

String[] dailyVerses =
        DailyVerseData.getVerses();

int verseIndex = (int) (
        System.currentTimeMillis()
        / (1000L * 60 * 60 * 24)
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
        checkAchievementNotifications();
        showMessage(
        "✅ Verse Learned",
        "Today's verse has been marked as learned.\n\n" +
        "+5 points"
);
    });

    addButton("⬅️ Back to Home", v -> showHome());
    }

    void showThought() {
    String[] dailyThoughts =
            FoodForThoughtData.getThoughts();

    int thoughtIndex = (int) (
            System.currentTimeMillis()
            / (1000L * 60 * 60 * 24)
            % dailyThoughts.length
    );

    showMessage(
            "💭 Food for Thought",
            dailyThoughts[thoughtIndex]
    );
    }
    
  void showPrayer() {
    String[] dailyPrayers =
            DailyPrayerData.getPrayers();

    java.util.Calendar calendar =
            java.util.Calendar.getInstance();

    int month = calendar.get(java.util.Calendar.MONTH) + 1;
    int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);

    String specialPrayer = null;
    String specialTitle = null;

    // January 1 — New Year + New Month
    if (month == 1 && day == 1) {
        String newYearPrayer = null;
        String newMonthPrayer = null;

        for (String prayer : dailyPrayers) {
            String lower = prayer.toLowerCase();

            if (lower.contains("new year")) {
                newYearPrayer = prayer;
            }

            if (lower.contains("new month")) {
                newMonthPrayer = prayer;
            }
        }

        if (newYearPrayer != null && newMonthPrayer != null) {
            specialTitle = "🙏 New Year & New Month";
            specialPrayer =
                    newYearPrayer + "\n\n" + newMonthPrayer;
        }
    }

    // May 27 — Children's Day
    else if (month == 5 && day == 27) {
        for (String prayer : dailyPrayers) {
            if (prayer.toLowerCase().contains("children's day")) {
                specialTitle = "🙏 Children's Day";
                specialPrayer = prayer;
                break;
            }
        }
    }

    // December 25 — Christmas / Festive Season
    else if (month == 12 && day == 25) {
        for (String prayer : dailyPrayers) {
            if (prayer.toLowerCase().contains("christmas")) {
                specialTitle = "🙏 Christmas Prayer";
                specialPrayer = prayer;
                break;
            }
        }
    }

    // December 31 — End of Year
    else if (month == 12 && day == 31) {
        for (String prayer : dailyPrayers) {
            if (prayer.toLowerCase().contains("end of year")) {
                specialTitle = "🙏 End of Year Prayer";
                specialPrayer = prayer;
                break;
            }
        }
    }

    // Other first days of the month — New Month
    else if (day == 1) {
        for (String prayer : dailyPrayers) {
            if (prayer.toLowerCase().contains("new month")) {
                specialTitle = "🙏 Prayer for the New Month";
                specialPrayer = prayer;
                break;
            }
        }
    }

    // Normal 183-day rotation
    if (specialPrayer == null) {
        int prayerIndex = (int) (
                System.currentTimeMillis()
                / (1000L * 60 * 60 * 24)
                % dailyPrayers.length
        );

        specialTitle = "🙏 Prayer for the Day";
        specialPrayer = dailyPrayers[prayerIndex];
    }

    showMessage(
            specialTitle,
            specialPrayer
    );
  }

    void showMemoryVerse() {

    stopTimer();

    Intent intent =
            new Intent(
                    this,
                    MemoryVerseGameActivity.class
            );

    intent.putExtra(
            "memory_game_type",
            "menu"
    );

    startActivity(intent);
    }
    void showBible() {
    stopTimer();
    content.removeAllViews();

    SharedPreferences biblePrefs =
            getSharedPreferences(
                    "KingdomLifePrefs",
                    MODE_PRIVATE
            );

    String translation =
            biblePrefs.getString(
                    "bible_translation",
                    "KJV"
            );

    TextView title = new TextView(this);

    title.setText(
            "📖 Holy Bible — " + translation
    );

    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );

    content.addView(title);

    TextView message = new TextView(this);

    message.setText(
            "Choose where you want to read:\n\n" +
            "📚 Old Testament\n" +
            "📚 New Testament"
    );

    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(
            0,
            10,
            0,
            20
    );

    content.addView(message);

    addButton(
            "🌍 View Translations",
            v -> showBibleTranslations()
    );

    addButton(
            "📚 Old Testament",
            v -> showOldTestament()
    );

    addButton(
            "🔎 Search Bible",
            v -> showBibleSearch()
    );

    addButton(
            "📚 New Testament",
            v -> showNewTestament()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showBibleTranslations() {
    stopTimer();
    content.removeAllViews();

    // Top-left back arrow
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);
    backButton.setContentDescription("Back to Bible");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );
    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(v -> showBible());

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);
    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    // Title
    TextView title = new TextView(this);
    title.setText("🌍 Bible Translations");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    // Instructions
    TextView message = new TextView(this);
    message.setText("Choose a Bible translation:");
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(0, 10, 0, 20);
    content.addView(message);

    // King James Version
    addButton(
            "📖 King James Version (KJV)",
            v -> {
                getSharedPreferences(
                        "KingdomLifePrefs",
                        MODE_PRIVATE
                ).edit()
                        .putString("bible_translation", "KJV")
                        .apply();

                showBible();
            }
    );

    // World English Bible
    addButton(
            "🌍 World English Bible (WEB)",
            v -> {
                getSharedPreferences(
                        "KingdomLifePrefs",
                        MODE_PRIVATE
                ).edit()
                        .putString("bible_translation", "WEB")
                        .apply();

                showBible();
            }
    );
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

    LinearLayout bookGrid =
        new LinearLayout(this);

bookGrid.setOrientation(
        LinearLayout.VERTICAL
);

for (int i = 0; i < books.length; i += 2) {

    LinearLayout row =
            new LinearLayout(this);

    row.setOrientation(
            LinearLayout.HORIZONTAL
    );

    row.setWeightSum(2);

    String firstBook = books[i];

    Button firstButton =
            new Button(this);

    firstButton.setText(
            "📖 " + firstBook
    );

    firstButton.setOnClickListener(
            v -> showBookChapters(
                    firstBook,
                    getChapterCount(firstBook)
            )
    );

    row.addView(
            firstButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    if (i + 1 < books.length) {

        String secondBook =
                books[i + 1];

        Button secondButton =
                new Button(this);

        secondButton.setText(
                "📖 " + secondBook
        );

        secondButton.setOnClickListener(
                v -> showBookChapters(
                        secondBook,
                        getChapterCount(secondBook)
                )
        );

        row.addView(
                secondButton,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );
    }

    bookGrid.addView(row);
}

content.addView(bookGrid);


        LinearLayout topBar =
        new LinearLayout(this);

topBar.setOrientation(
        LinearLayout.HORIZONTAL
);

topBar.setGravity(
        Gravity.LEFT | Gravity.CENTER_VERTICAL
);

ImageButton backButton =
        new ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setBackgroundColor(
        Color.TRANSPARENT
);

backButton.setContentDescription(
        "Back to Bible"
);

backButton.setOnClickListener(
        v -> showBible()
);

topBar.addView(
        backButton,
        new LinearLayout.LayoutParams(
                70,
                70
        )
);

content.addView(
        topBar,
        0
);
    }
        void showNewTestament() {
    stopTimer();
    content.removeAllViews();

    LinearLayout topBar =
            new LinearLayout(this);

    topBar.setOrientation(
            LinearLayout.HORIZONTAL
    );

    topBar.setGravity(
            Gravity.LEFT | Gravity.CENTER_VERTICAL
    );

    ImageButton backButton =
            new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setContentDescription(
            "Back to Bible"
    );

    backButton.setOnClickListener(
            v -> showBible()
    );

    topBar.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    70,
                    70
            )
    );

    content.addView(topBar);

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

    


LinearLayout bookGrid =
        new LinearLayout(this);

bookGrid.setOrientation(
        LinearLayout.VERTICAL
);

for (int i = 0; i < books.length; i += 2) {

    LinearLayout row =
            new LinearLayout(this);

    row.setOrientation(
            LinearLayout.HORIZONTAL
    );

    row.setWeightSum(2);

    String firstBook =
            books[i];

    Button firstButton =
            new Button(this);

    firstButton.setText(
            "📖 " + firstBook
    );

    firstButton.setOnClickListener(
            v -> showBookChapters(
                    firstBook,
                    getChapterCount(firstBook)
            )
    );

    row.addView(
            firstButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    if (i + 1 < books.length) {

        String secondBook =
                books[i + 1];

        Button secondButton =
                new Button(this);

        secondButton.setText(
                "📖 " + secondBook
        );

        secondButton.setOnClickListener(
                v -> showBookChapters(
                        secondBook,
                        getChapterCount(secondBook)
                )
        );

        row.addView(
                secondButton,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );
    }

    bookGrid.addView(row);
}

content.addView(bookGrid);
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
    void showBibleSearch() {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to Bible");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showBible()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🔎 Search Bible — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Enter a word or phrase");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
            "🔎 Search",
            v -> {
                String query = searchInput.getText()
                        .toString().trim();

                if (query.isEmpty()) {
                    showMessage(
                            "🔎 Bible Search",
                            "Please enter a word or phrase to search."
                    );
                    return;
                }

                showBibleSearchResults(query);
            }
    );

    // The old bottom Back to Bible button is removed.
        }
    void showBibleSearchResults(String query) {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to Search");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showBibleSearch()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🔎 Search Results");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String searchText = query.toLowerCase();
    int resultCount = 0;

    try {
        String[] books = {
                "Genesis", "Exodus", "Leviticus", "Numbers",
                "Deuteronomy", "Joshua", "Judges", "Ruth",
                "1 Samuel", "2 Samuel", "1 Kings", "2 Kings",
                "1 Chronicles", "2 Chronicles", "Ezra", "Nehemiah",
                "Esther", "Job", "Psalms", "Proverbs",
                "Ecclesiastes", "Song of Solomon", "Isaiah", "Jeremiah",
                "Lamentations", "Ezekiel", "Daniel", "Hosea",
                "Joel", "Amos", "Obadiah", "Jonah", "Micah",
                "Nahum", "Habakkuk", "Zephaniah", "Haggai",
                "Zechariah", "Malachi",
                "Matthew", "Mark", "Luke", "John", "Acts",
                "Romans", "1 Corinthians", "2 Corinthians",
                "Galatians", "Ephesians", "Philippians", "Colossians",
                "1 Thessalonians", "2 Thessalonians", "1 Timothy",
                "2 Timothy", "Titus", "Philemon", "Hebrews", "James",
                "1 Peter", "2 Peter", "1 John", "2 John",
                "3 John", "Jude", "Revelation"
        };

        for (String book : books) {
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

            java.util.Iterator<String> chapters = bible.keys();

            while (chapters.hasNext()) {
                String chapterNumber = chapters.next();

                JSONObject chapter =
                        bible.getJSONObject(chapterNumber);

                java.util.Iterator<String> verses = chapter.keys();

                while (verses.hasNext()) {
                    String verseNumber = verses.next();

                    String verseText =
                            chapter.getString(verseNumber);

                    if (verseText.toLowerCase().contains(searchText)) {
                        TextView result = new TextView(this);

                        result.setText(
                                "📖 " + book +
                                " " + chapterNumber +
                                ":" + verseNumber +
                                "\n" + verseText
                        );

                        result.setTextSize(17);
                        result.setTextColor(darkText);
                        result.setPadding(10, 12, 10, 12);

                        content.addView(result);

                        resultCount++;

                        if (resultCount >= 50) {
                            break;
                        }
                    }
                }

                if (resultCount >= 50) {
                    break;
                }
            }

            if (resultCount >= 50) {
                break;
            }
        }

        if (resultCount == 0) {
            TextView none = new TextView(this);

            none.setText("No verses found for: " + query);
            none.setTextSize(18);
            none.setTextColor(darkText);
            none.setPadding(10, 20, 10, 20);

            content.addView(none);
        }

    } catch (Exception e) {
        TextView error = new TextView(this);

        error.setText(
                "Unable to search the Bible.\n\n" +
                e.toString()
        );

        error.setTextSize(16);
        error.setTextColor(darkText);
        error.setPadding(10, 20, 10, 20);

        content.addView(error);
    }

    // The old bottom Back to Search button is removed.
    }
            

        
    void saveVerse(String reference, String verseText) {

    if (savedVersesPrefs == null) {
        return;
    }

    savedVersesPrefs.edit()
            .putString(reference, verseText)
            .apply();

    showMessage(
            "⭐ Verse Saved",
            reference + "\n\n" + verseText
    );
    }
    void saveNote(String reference, String noteText) {

    if (notesPrefs == null) {
        return;
    }

    String key = reference + "_" + System.currentTimeMillis();

    notesPrefs.edit()
            .putString(key, noteText)
            .apply();

    showMessage(
            "📝 Note Saved",
            noteText
    );
    }
    void saveHighlight(String reference, String verseText) {

    if (highlightsPrefs == null) {
        return;
    }

    String key =
            reference + "_" + System.currentTimeMillis();

    highlightsPrefs.edit()
            .putString(key, verseText)
            .apply();

    showMessage(
            "🖍️ Verse Highlighted",
            reference + "\n\n" + verseText
    );
    }
    void showSavedVerses() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("⭐ Saved Verses");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    if (savedVersesPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No saved verses yet.\n\n" +
                "Save a verse from the Bible reader and it will appear here."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(
                10,
                10,
                10,
                20
        );
        content.addView(message);

    } else {

        for (
                java.util.Map.Entry<String, ?> entry :
                savedVersesPrefs.getAll().entrySet()
        ) {

            String reference = entry.getKey();
            String verseText =
                    entry.getValue().toString();

            addCard(
                    "⭐ " + reference,
                    verseText,
                    v -> {}
            );
        }
    }
    }
    void showBibleDictionary() {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to More");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("📚 Bible Dictionary");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "Search Bible words and terms to learn their meanings."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(10, 10, 10, 20);
    content.addView(message);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Enter a Bible word");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
            "🔎 Search Dictionary",
            v -> {
                String query =
                        searchInput.getText().toString().trim();

                if (query.isEmpty()) {
                    showMessage(
                            "📚 Bible Dictionary",
                            "Please enter a Bible word to search."
                    );
                    return;
                }

                showDictionaryResult(query);
            }
    );

    // The old bottom Back to More button is removed.
    }
    void showDictionaryResult(String query) {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to More");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("📚 Bible Dictionary");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String word = query.toLowerCase();

    String meaning = BibleDictionaryData.getMeaning(word);

    if (meaning != null) {
        addCard(
                "🔤 " + query,
                meaning,
                v -> {}
        );
    } else {
        addCard(
                "🔎 No Entry Found",
                "No dictionary entry was found for \"" +
                        query +
                        "\" yet.",
                v -> {}
        );
    }

    addButton(
            "🔎 Search Again",
            v -> showBibleDictionary()
    );

    // The old bottom Back to More button is removed.
    }
    void showMoreMenu() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("⋯ More");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    addButton(
            "⭐ Saved Verses",
            v -> showSavedVerses()
    );
        addButton(
        "🔖 Bookmarks",
        v -> showBookmarks()
);
        addButton(
        "📝 Notes & Highlights",
        v -> showNotesHighlights()
);

    addButton(
            "📚 Bible Dictionary",
            v -> showBibleDictionary()
    );
        addButton(
        "💾 Backup & Restore",
        v -> showBackupRestore()
);

    addButton(
            "⚙️ Settings",
            v -> showSettings()
    );

    addButton(
            "ℹ️ About Kingdom Life",
            v -> showAbout()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showBackupRestore() {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to More");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("💾 Backup & Restore");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    TextView description = new TextView(this);
    description.setText(
            "Protect your Kingdom Life progress, " +
            "Bible notes, saved verses, prayers, " +
            "spiritual goals, and achievements."
    );
    description.setTextSize(16);
    description.setTextColor(darkText);
    description.setPadding(0, 0, 0, 20);
    content.addView(description);

    addButton(
            "📤 Create Backup",
            v -> createBackup()
    );

    addButton(
            "📥 Restore Backup",
            v -> restoreBackup()
    );

    // The old bottom Back to More button has been removed.
    }
    void createBackup() {
    android.content.Intent intent =
            new android.content.Intent(
                    android.content.Intent.ACTION_CREATE_DOCUMENT
            );

    intent.addCategory(
            android.content.Intent.CATEGORY_OPENABLE
    );

    intent.setType("application/json");

    intent.putExtra(
            android.content.Intent.EXTRA_TITLE,
            "KingdomLife_Backup.json"
    );

    startActivityForResult(intent, 7101);
}

void restoreBackup() {
    android.content.Intent intent =
            new android.content.Intent(
                    android.content.Intent.ACTION_OPEN_DOCUMENT
            );

    intent.addCategory(
            android.content.Intent.CATEGORY_OPENABLE
    );

    intent.setType("application/json");

    startActivityForResult(intent, 7102);
}
    org.json.JSONObject collectBackupData()
        throws org.json.JSONException {

    org.json.JSONObject backup = new org.json.JSONObject();

    String[] preferenceFiles = {
            "KingdomLifePrefs",
            "saved_verses",
            "bible_notes",
            "bible_highlights",
            "bible_bookmarks",
            "daily_challenge",
            "prayerJournalPrefs",
            "spiritualGoalsPrefs"
    };

    for (String fileName : preferenceFiles) {

        android.content.SharedPreferences saved =
                getSharedPreferences(fileName, MODE_PRIVATE);

        org.json.JSONObject values = new org.json.JSONObject();
        org.json.JSONObject types = new org.json.JSONObject();

        for (java.util.Map.Entry<String, ?> entry
                : saved.getAll().entrySet()) {

            String key = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof java.util.Set) {

                org.json.JSONArray items = new org.json.JSONArray();

                for (Object item : (java.util.Set<?>) value) {
                    items.put(item.toString());
                }

                values.put(key, items);
                types.put(key, "string_set");

            } else if (value instanceof String) {
                values.put(key, value);
                types.put(key, "string");

            } else if (value instanceof Boolean) {
                values.put(key, value);
                types.put(key, "boolean");

            } else if (value instanceof Integer) {
                values.put(key, value);
                types.put(key, "integer");

            } else if (value instanceof Long) {
                values.put(key, value.toString());
                types.put(key, "long");

            } else if (value instanceof Float) {
                values.put(key, value);
                types.put(key, "float");
            }
        }

        org.json.JSONObject fileData = new org.json.JSONObject();
        fileData.put("values", values);
        fileData.put("types", types);

        backup.put(fileName, fileData);
    }

    backup.put("backupFormatVersion", 1);
    backup.put("appName", "Kingdom Life");

    return backup;
                       }
    void writeBackup(android.net.Uri uri) {
    try {
        org.json.JSONObject backup = collectBackupData();

        try (java.io.OutputStream output =
                     getContentResolver().openOutputStream(uri)) {

            if (output == null) {
                android.widget.Toast.makeText(
                        this,
                        "Could not create the backup file.",
                        android.widget.Toast.LENGTH_LONG
                ).show();
                return;
            }

            output.write(
                    backup.toString(2).getBytes(
                            java.nio.charset.StandardCharsets.UTF_8
                    )
            );
        }

        android.widget.Toast.makeText(
                this,
                "✅ Kingdom Life backup saved!",
                android.widget.Toast.LENGTH_LONG
        ).show();

    } catch (Exception e) {
        android.widget.Toast.makeText(
                this,
                "Backup failed. Please try again.",
                android.widget.Toast.LENGTH_LONG
        ).show();
    }
            }
    void readBackup(android.net.Uri uri) {
    try {
        StringBuilder text = new StringBuilder();

        try (java.io.InputStream input =
                     getContentResolver().openInputStream(uri);
             java.io.BufferedReader reader =
                     new java.io.BufferedReader(
                             new java.io.InputStreamReader(
                                     input,
                                     java.nio.charset.StandardCharsets.UTF_8
                             )
                     )) {

            if (input == null) {
                throw new java.io.IOException("Cannot open backup");
            }

            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line);

                if (text.length() > 5_000_000) {
                    throw new java.io.IOException(
                            "Backup file is too large"
                    );
                }
            }
        }

        org.json.JSONObject backup =
                new org.json.JSONObject(text.toString());

        if (!"Kingdom Life".equals(
                backup.optString("appName"))) {
            throw new org.json.JSONException(
                    "Not a Kingdom Life backup"
            );
        }

        if (backup.optInt("backupFormatVersion", -1) != 1) {
            throw new org.json.JSONException(
                    "Unsupported backup version"
            );
        }

        String[] preferenceFiles = {
                "KingdomLifePrefs",
                "saved_verses",
                "bible_notes",
                "bible_highlights",
                "bible_bookmarks",
                "daily_challenge",
                "prayerJournalPrefs",
                "spiritualGoalsPrefs"
        };

        String[] allowedTypes = {
                "string", "boolean", "integer",
                "long", "float", "string_set"
        };

        // Validate all eight sections before changing saved data.
        for (String fileName : preferenceFiles) {
            org.json.JSONObject fileData =
                    backup.getJSONObject(fileName);

            org.json.JSONObject values =
                    fileData.getJSONObject("values");

            org.json.JSONObject types =
                    fileData.getJSONObject("types");

            java.util.Iterator<String> keys =
                    values.keys();

            while (keys.hasNext()) {
                String key = keys.next();

                if (!types.has(key)) {
                    throw new org.json.JSONException(
                            "Missing value type"
                    );
                }

                String type = types.getString(key);
                boolean supported = false;

                for (String allowed : allowedTypes) {
                    if (allowed.equals(type)) {
                        supported = true;
                        break;
                    }
                }

                if (!supported) {
                    throw new org.json.JSONException(
                            "Unsupported saved value type"
                    );
                }

                Object value = values.get(key);

                if ("string".equals(type)
                        && !(value instanceof String)) {
                    throw new org.json.JSONException("Invalid string");
                }

                if ("boolean".equals(type)
                        && !(value instanceof Boolean)) {
                    throw new org.json.JSONException("Invalid boolean");
                }

                if ("integer".equals(type)
                        && !(value instanceof Integer)) {
                    throw new org.json.JSONException("Invalid integer");
                }

                if ("long".equals(type)) {
                    if (!(value instanceof String)) {
                        throw new org.json.JSONException("Invalid long");
                    }

                    Long.parseLong((String) value);
                }

                if ("float".equals(type)
                        && !(value instanceof Number)) {
                    throw new org.json.JSONException("Invalid float");
                }

                if ("string_set".equals(type)) {
                    if (!(value instanceof org.json.JSONArray)) {
                        throw new org.json.JSONException(
                                "Invalid string set"
                        );
                    }

                    org.json.JSONArray items =
                            (org.json.JSONArray) value;

                    for (int i = 0; i < items.length(); i++) {
                        if (!(items.get(i) instanceof String)) {
                            throw new org.json.JSONException(
                                    "Invalid string-set item"
                            );
                        }
                    }
                }
            }

            if (types.length() != values.length()) {
                throw new org.json.JSONException(
                        "Backup contains unmatched types"
                );
            }
        }

        // All sections passed validation. Restore each preference file.
        for (String fileName : preferenceFiles) {
            org.json.JSONObject fileData =
                    backup.getJSONObject(fileName);

            org.json.JSONObject values =
                    fileData.getJSONObject("values");

            org.json.JSONObject types =
                    fileData.getJSONObject("types");

            android.content.SharedPreferences saved =
                    getSharedPreferences(fileName, MODE_PRIVATE);

            android.content.SharedPreferences.Editor editor =
                    saved.edit();

            editor.clear();

            java.util.Iterator<String> keys =
                    values.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String type = types.getString(key);
                Object value = values.get(key);

                if ("string".equals(type)) {
                    editor.putString(key, (String) value);

                } else if ("boolean".equals(type)) {
                    editor.putBoolean(key, (Boolean) value);

                } else if ("integer".equals(type)) {
                    editor.putInt(key, (Integer) value);

                } else if ("long".equals(type)) {
                    editor.putLong(
                            key,
                            Long.parseLong((String) value)
                    );

                } else if ("float".equals(type)) {
                    editor.putFloat(
                            key,
                            ((Number) value).floatValue()
                    );

                } else if ("string_set".equals(type)) {
                    org.json.JSONArray items =
                            (org.json.JSONArray) value;

                    java.util.Set<String> set =
                            new java.util.HashSet<>();

                    for (int i = 0; i < items.length(); i++) {
                        set.add(items.getString(i));
                    }

                    editor.putStringSet(key, set);
                }
            }

            if (!editor.commit()) {
                throw new java.io.IOException(
                        "Could not save restored data"
                );
            }
        }

        android.widget.Toast.makeText(
                this,
                "✅ Backup restored! Please restart Kingdom Life.",
                android.widget.Toast.LENGTH_LONG
        ).show();

    } catch (Exception e) {
        android.widget.Toast.makeText(
                this,
                "❌ Restore failed. Your backup may be invalid.",
                android.widget.Toast.LENGTH_LONG
        ).show();
    }
                    }
    void showNotesHighlights() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("📝 Notes & Highlights");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    if (notesPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No notes saved yet.\n\n" +
                "Add a note and it will appear here."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(
                10,
                10,
                10,
                20
        );
        content.addView(message);

    } else {

        for (
                java.util.Map.Entry<String, ?> entry :
                notesPrefs.getAll().entrySet()
        ) {

            String noteText =
                    entry.getValue().toString();

            addCard(
                    "📝 Note",
                    noteText,
                    v -> {}
            );
        }
    }

    addButton(
            "📝 Add Note",
            v -> {

                EditText noteInput =
                        new EditText(this);

                noteInput.setHint(
                        "Write your note here"
                );

                noteInput.setTextSize(18);

                content.addView(noteInput);

                addButton(
                        "💾 Save Note",
                        saveView -> {

                            String noteText =
                                    noteInput.getText()
                                            .toString()
                                            .trim();

                            if (noteText.isEmpty()) {

                                showMessage(
                                        "📝 Add Note",
                                        "Please write a note first."
                                );

                                return;
                            }

                            saveNote(
                                    "General Note",
                                    noteText
                            );
                        }
                );
            }
    );

    addButton(
            "🖍️ Highlights",
            v -> showHighlights()
    );
            }
            
    void showLearnMenu() {
stopTimer();
content.removeAllViews();

TextView title = new TextView(this);
title.setText("📖 Learn & Grow");
title.setTextSize(24);
title.setTypeface(
        Typeface.DEFAULT,
        Typeface.BOLD
);
title.setTextColor(darkText);
title.setPadding(0, 15, 0, 20);
content.addView(title);

addCard(
        "📚 Kingdom Books",
        "Read Christian books, inspiring stories, and lessons.",
        v -> showKingdomBooks()
);

addCard(
        "🎙️ Sermons",
        "Listen to sermons and messages for spiritual encouragement.",
        v -> showSermons()
);

addCard(
        "🙏 Prayer Journal",
        "Write, save, and revisit your personal prayers.",
        v -> showPrayerJournal()
);

addCard(
        "🎯 Spiritual Goals",
        "Set spiritual goals and track your progress.",
        v -> showSpiritualGoals()
);

addButton(
        "⬅️ Back to Home",
        v -> showHome()
);

    }
    void showPrayerJournal() {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to Learn & Grow");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showLearnMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🙏 Prayer Journal");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 12);
    content.addView(title);

    TextView description = new TextView(this);
    description.setText(
            "Write your prayers, reflect on your faith, "
                    + "and revisit your conversations with God."
    );
    description.setTextSize(15);
    description.setTextColor(darkText);
    description.setPadding(0, 0, 0, 16);
    content.addView(description);

    addButton(
            "✍️ Write a Prayer",
            v -> writePrayer()
    );

    android.content.SharedPreferences prefs =
            getSharedPreferences(
                    "prayerJournalPrefs",
                    MODE_PRIVATE
            );

    int count = prefs.getInt("prayer_count", 0);

    if (count == 0) {
        TextView empty = new TextView(this);
        empty.setText(
                "Your prayer journal is empty.\n"
                        + "Your saved prayers will appear here."
        );
        empty.setTextSize(16);
        empty.setTextColor(darkText);
        empty.setPadding(0, 24, 0, 24);
        content.addView(empty);
    } else {
        for (int i = count - 1; i >= 0; i--) {
            String prayer = prefs.getString(
                    "prayer_" + i,
                    ""
            );

            if (prayer.isEmpty()) {
                continue;
            }

            final String savedPrayer = prayer;
            final int prayerIndex = i;

            addCard(
                    "🙏 Prayer " + (i + 1),
                    savedPrayer,
                    v -> viewPrayer(prayerIndex, savedPrayer)
            );
        }
    }

    // The old bottom Back to Learn & Grow button is removed.
    }
    void showSpiritualGoals() {
    stopTimer();
    content.removeAllViews();

    // Large back arrow at the top-left
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);

    backButton.setContentDescription("Back to Learn & Grow");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );

    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(
            v -> showLearnMenu()
    );

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);

    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🎯 Spiritual Goals");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 12);
    content.addView(title);

    TextView description = new TextView(this);
    description.setText(
            "Set goals that help you grow in faith, "
                    + "prayer, Bible study, and daily living."
    );
    description.setTextSize(15);
    description.setTextColor(darkText);
    description.setPadding(0, 0, 0, 16);
    content.addView(description);

    addButton("➕ Add a Spiritual Goal", v -> {
        android.widget.EditText input =
                new android.widget.EditText(this);

        input.setHint("Enter your spiritual goal");

        new android.app.AlertDialog.Builder(this)
                .setTitle("🎯 New Goal")
                .setView(input)
                .setPositiveButton("Save", (dialog, which) -> {
                    String goal = input.getText()
                            .toString().trim();

                    if (goal.isEmpty()) {
                        android.widget.Toast.makeText(
                                this,
                                "Please enter a goal.",
                                android.widget.Toast.LENGTH_SHORT
                        ).show();
                        return;
                    }

                    android.content.SharedPreferences prefs =
                            getSharedPreferences(
                                    "spiritualGoalsPrefs",
                                    MODE_PRIVATE
                            );

                    int count = prefs.getInt("goal_count", 0);

                    prefs.edit()
                            .putString("goal_" + count, goal)
                            .putBoolean("goal_done_" + count, false)
                            .putInt("goal_count", count + 1)
                            .apply();

                    showSpiritualGoals();
                })
                .setNegativeButton("Cancel", null)
                .show();
    });

    android.content.SharedPreferences prefs =
            getSharedPreferences(
                    "spiritualGoalsPrefs",
                    MODE_PRIVATE
            );

    int count = prefs.getInt("goal_count", 0);

    if (count == 0) {
        TextView empty = new TextView(this);
        empty.setText(
                "No goals yet.\n"
                        + "Add your first spiritual goal above."
        );
        empty.setTextSize(16);
        empty.setTextColor(darkText);
        empty.setPadding(0, 24, 0, 24);
        content.addView(empty);
    } else {
        for (int i = 0; i < count; i++) {
            String goal = prefs.getString("goal_" + i, "");
            boolean done = prefs.getBoolean(
                    "goal_done_" + i,
                    false
            );

            if (goal.isEmpty()) continue;

            final int goalIndex = i;

            addCard(
                    (done ? "✅ " : "🎯 ") + goal,
                    done ? "Goal completed!" : "Tap to mark as completed.",
                    v -> {
                        prefs.edit()
                                .putBoolean(
                                        "goal_done_" + goalIndex,
                                        !done
                                )
                                .apply();

                        showSpiritualGoals();
                    }
            );
        }
    }

    // The old bottom Back to Learn & Grow button is removed.
    }


    void writePrayer() {
    android.widget.EditText input =
            new android.widget.EditText(this);

    input.setHint("Write your prayer here...");
    input.setMinLines(5);
    input.setGravity(
            android.view.Gravity.TOP
                    | android.view.Gravity.START
    );

    android.widget.ScrollView scroll =
            new android.widget.ScrollView(this);
    scroll.addView(input);

    new android.app.AlertDialog.Builder(this)
            .setTitle("🙏 Write a Prayer")
            .setView(scroll)
            .setPositiveButton("Save", (dialog, which) -> {
                String prayer = input.getText()
                        .toString().trim();

                if (prayer.isEmpty()) {
                    android.widget.Toast.makeText(
                            this,
                            "Please write your prayer first.",
                            android.widget.Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                android.content.SharedPreferences prefs =
                        getSharedPreferences(
                                "prayerJournalPrefs",
                                MODE_PRIVATE
                        );

                int count = prefs.getInt("prayer_count", 0);

                prefs.edit()
                        .putString("prayer_" + count, prayer)
                        .putInt("prayer_count", count + 1)
                        .apply();

                android.widget.Toast.makeText(
                        this,
                        "Prayer saved successfully!",
                        android.widget.Toast.LENGTH_SHORT
                ).show();

                showPrayerJournal();
            })
            .setNegativeButton("Cancel", null)
            .show();
}

void viewPrayer(int index, String prayer) {
    new android.app.AlertDialog.Builder(this)
            .setTitle("🙏 Your Prayer")
            .setMessage(prayer)
            .setPositiveButton("Close", null)
            .setNeutralButton("Edit", (dialog, which) ->
                    editPrayer(index, prayer))
            .setNegativeButton("Delete", (dialog, which) ->
                    confirmDeletePrayer(index))
            .show();
}

void editPrayer(int index, String oldPrayer) {
    android.widget.EditText input =
            new android.widget.EditText(this);

    input.setText(oldPrayer);
    input.setMinLines(5);
    input.setGravity(
            android.view.Gravity.TOP
                    | android.view.Gravity.START
    );

    new android.app.AlertDialog.Builder(this)
            .setTitle("✍️ Edit Prayer")
            .setView(input)
            .setPositiveButton("Save", (dialog, which) -> {
                String updatedPrayer =
                        input.getText().toString().trim();

                if (updatedPrayer.isEmpty()) {
                    android.widget.Toast.makeText(
                            this,
                            "Prayer cannot be empty.",
                            android.widget.Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                getSharedPreferences(
                        "prayerJournalPrefs",
                        MODE_PRIVATE
                ).edit()
                        .putString(
                                "prayer_" + index,
                                updatedPrayer
                        )
                        .apply();

                showPrayerJournal();
            })
            .setNegativeButton("Cancel", null)
            .show();
}

void confirmDeletePrayer(int index) {
    new android.app.AlertDialog.Builder(this)
            .setTitle("Delete Prayer?")
            .setMessage(
                    "Are you sure you want to delete this prayer?"
            )
            .setPositiveButton("Delete", (dialog, which) -> {
                android.content.SharedPreferences prefs =
                        getSharedPreferences(
                                "prayerJournalPrefs",
                                MODE_PRIVATE
                        );

                int count = prefs.getInt("prayer_count", 0);

                android.content.SharedPreferences.Editor editor =
                        prefs.edit();

                for (int i = index; i < count - 1; i++) {
                    String nextPrayer = prefs.getString(
                            "prayer_" + (i + 1),
                            ""
                    );

                    editor.putString(
                            "prayer_" + i,
                            nextPrayer
                    );
                }

                editor.remove("prayer_" + (count - 1));
                editor.putInt("prayer_count", count - 1);
                editor.apply();

                showPrayerJournal();
            })
            .setNegativeButton("Cancel", null)
            .show();
}
    
    void showKingdomBooks() {
stopTimer();
content.removeAllViews();

ImageButton backButton = new ImageButton(this);
backButton.setImageResource(android.R.drawable.ic_media_previous);
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setOnClickListener(v -> showLearnMenu());
content.addView(
        backButton,
        new LinearLayout.LayoutParams(60, 60)
);

TextView title = new TextView(this);
title.setText("📚 Kingdom Books");
title.setTextSize(24);
title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
title.setTextColor(darkText);
title.setPadding(0, 15, 0, 10);
content.addView(title);

TextView message = new TextView(this);
message.setText("Explore Christian books and inspiring stories.");
message.setTextSize(16);
message.setTextColor(darkText);
message.setPadding(0, 0, 0, 20);
content.addView(message);

// Display both books side by side.
LinearLayout booksRow = new LinearLayout(this);
booksRow.setOrientation(LinearLayout.HORIZONTAL);
booksRow.setGravity(android.view.Gravity.CENTER);
booksRow.setWeightSum(2);

LinearLayout.LayoutParams rowParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
rowParams.setMargins(0, 0, 0, 20);
content.addView(booksRow, rowParams);

// The Pilgrim's Progress.
LinearLayout pilgrimBook = new LinearLayout(this);
pilgrimBook.setOrientation(LinearLayout.VERTICAL);
pilgrimBook.setGravity(android.view.Gravity.CENTER);
pilgrimBook.setPadding(6, 6, 6, 6);
pilgrimBook.setOnClickListener(
        v -> PilgrimsProgressBook.open(this, content)
);

ImageView pilgrimCover = new ImageView(this);
pilgrimCover.setImageResource(
        android.R.drawable.ic_menu_view
);
pilgrimCover.setScaleType(ImageView.ScaleType.FIT_CENTER);
pilgrimCover.setContentDescription(
        "The Pilgrim's Progress book"
);

LinearLayout.LayoutParams pilgrimImageParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                180
        );
pilgrimBook.addView(pilgrimCover, pilgrimImageParams);

TextView pilgrimTitle = new TextView(this);
pilgrimTitle.setText("The Pilgrim's Progress");
pilgrimTitle.setTextSize(16);
pilgrimTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
pilgrimTitle.setTextColor(darkText);
pilgrimTitle.setGravity(android.view.Gravity.CENTER);
pilgrimTitle.setPadding(0, 8, 0, 8);
pilgrimBook.addView(pilgrimTitle);

TextView pilgrimAuthor = new TextView(this);
pilgrimAuthor.setText("By John Bunyan");
pilgrimAuthor.setTextSize(13);
pilgrimAuthor.setTextColor(darkText);
pilgrimAuthor.setGravity(android.view.Gravity.CENTER);
pilgrimBook.addView(pilgrimAuthor);

booksRow.addView(
        pilgrimBook,
        new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        )
);

// Descendants of Good.
LinearLayout descendantsBook = new LinearLayout(this);
descendantsBook.setOrientation(LinearLayout.VERTICAL);
descendantsBook.setGravity(android.view.Gravity.CENTER);
descendantsBook.setPadding(6, 6, 6, 6);
descendantsBook.setOnClickListener(
        v -> showDescendantsOfGoodChapters()
);

ImageView descendantsCover = new ImageView(this);
descendantsCover.setImageResource(
        R.drawable.descendants_of_good_cover
);
descendantsCover.setScaleType(ImageView.ScaleType.FIT_CENTER);
descendantsCover.setAdjustViewBounds(true);
descendantsCover.setContentDescription(
        "Descendants of Good book cover"
);

descendantsBook.addView(
        descendantsCover,
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                180
        )
);

TextView descendantsTitle = new TextView(this);
descendantsTitle.setText("Descendants of Good");
descendantsTitle.setTextSize(16);
descendantsTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
descendantsTitle.setTextColor(darkText);
descendantsTitle.setGravity(android.view.Gravity.CENTER);
descendantsTitle.setPadding(0, 8, 0, 8);
descendantsBook.addView(descendantsTitle);

TextView descendantsDescription = new TextView(this);
descendantsDescription.setText("Christian fiction");
descendantsDescription.setTextSize(13);
descendantsDescription.setTextColor(darkText);
descendantsDescription.setGravity(android.view.Gravity.CENTER);
descendantsBook.addView(descendantsDescription);

booksRow.addView(
        descendantsBook,
        new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        )
);

addCard(
"⏩ Continue Reading",
"Return to where you last stopped reading.",
v -> {
android.content.SharedPreferences pilgrimPrefs =
getSharedPreferences(
"PilgrimsProgressReadingProgress",
MODE_PRIVATE
);

        android.content.SharedPreferences storyPrefs =
                getSharedPreferences(
                        "DescendantsReadingProgress",
                        MODE_PRIVATE
                );

        boolean pilgrimStarted =
                pilgrimPrefs.contains("lastChapter");

        boolean descendantsStarted =
                storyPrefs.contains("lastChapter");

        if (pilgrimStarted && descendantsStarted) {
            new AlertDialog.Builder(this)
                    .setTitle("Continue Reading")
                    .setItems(
                            new String[]{
                                    "The Pilgrim's Progress",
                                    "Descendants of Good"
                            },
                            (dialog, which) -> {
                                if (which == 0) {
                                    PilgrimsProgressBook.continueReading(
                                            this, content
                                    );
                                } else {
                                    int lastChapter =
                                            storyPrefs.getInt(
                                                    "lastChapter", 0
                                            );
                                    int lastPage =
                                            storyPrefs.getInt(
                                                    "lastPage", 0
                                            );

                                    showDescendantsBookmarkedPage(
                                            lastChapter, lastPage
                                    );
                                }
                            }
                    )
                    .setNegativeButton("Cancel", null)
                    .show();

        } else if (pilgrimStarted) {
            PilgrimsProgressBook.continueReading(
                    this, content
            );

        } else if (descendantsStarted) {
            int lastChapter = storyPrefs.getInt("lastChapter", 0);
            int lastPage = storyPrefs.getInt("lastPage", 0);

            showDescendantsBookmarkedPage(
                    lastChapter, lastPage
            );

        } else {
            showMessage(
                    "Continue Reading",
                    "Open a book and start reading to save your position."
            );
        }
    }

);

addCard(
        "🔖 My Bookmarks",
        "Revisit your saved story passages.",
        v -> showDescendantsBookmarks()
);

addCard(
        "📚 More Stories Coming Soon",
        "New stories can be added to the Kingdom Books library.",
        v -> showMessage(
                "📚 More Stories",
                "More stories will be added here in the future."
        )
);

    }
     
    void showDescendantsOfGoodChapters() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);
    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setOnClickListener(v -> showKingdomBooks());

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(60, 60)
    );

    TextView title = new TextView(this);
    title.setText("📖 Descendants of Good");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView subtitle = new TextView(this);
    subtitle.setText(
            "Choose a chapter to begin reading."
    );
    subtitle.setTextSize(16);
    subtitle.setTextColor(darkText);
    subtitle.setPadding(0, 0, 0, 20);
    content.addView(subtitle);

    java.util.List<DescendantsOfGoodLibrary.Chapter> chapters =
            DescendantsOfGoodLibrary.getChapters();

    for (int i = 0; i < chapters.size(); i++) {
        final int chapterIndex = i;

        DescendantsOfGoodLibrary.Chapter chapter =
                chapters.get(i);

        addCard(
                "Chapter " + (i + 1) + ": " + chapter.title,
                chapter.subtitle,
                v -> showDescendantsOfGoodChapter(chapterIndex)
        );
    }
    }
    void showDescendantsBookmarks() {
stopTimer();
content.removeAllViews();

ImageButton backButton = new ImageButton(this);
backButton.setImageResource(android.R.drawable.ic_media_previous);
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setOnClickListener(v -> showKingdomBooks());

content.addView(
        backButton,
        new LinearLayout.LayoutParams(60, 60)
);

TextView title = new TextView(this);
title.setText("🔖 My Bookmarks");
title.setTextSize(24);
title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
title.setTextColor(darkText);
title.setPadding(0, 15, 0, 10);
content.addView(title);

android.content.SharedPreferences bookmarkPrefs =
        getSharedPreferences("DescendantsBookmarks", MODE_PRIVATE);

java.util.List<DescendantsOfGoodLibrary.Chapter> chapters =
        DescendantsOfGoodLibrary.getChapters();

boolean foundBookmark = false;
        android.content.SharedPreferences pilgrimBookmarkPrefs =
        getSharedPreferences(
                "PilgrimsProgressBookmarks",
                MODE_PRIVATE
        );

boolean foundPilgrimBookmark = false;

for (int chapterIndex = 0;
     chapterIndex < 100;
     chapterIndex++) {

    for (int pageIndex = 0;
         pageIndex < 100;
         pageIndex++) {

        String bookmarkKey =
                chapterIndex + "_" + pageIndex;

        if (pilgrimBookmarkPrefs.getBoolean(
                bookmarkKey, false)) {

            foundPilgrimBookmark = true;

            final int savedChapterIndex = chapterIndex;
            final int savedPageIndex = pageIndex;

            LinearLayout bookmarkRow =
                    new LinearLayout(this);

            bookmarkRow.setOrientation(
                    LinearLayout.HORIZONTAL
            );

            bookmarkRow.setGravity(
                    android.view.Gravity.CENTER_VERTICAL
            );

            android.widget.Button openButton =
                    new android.widget.Button(this);

            openButton.setText(
                    "The Pilgrim's Progress — Chapter "
                    + (chapterIndex + 1)
                    + " • Page "
                    + (pageIndex + 1)
            );

            openButton.setOnClickListener(v -> {
                PilgrimsProgressBook.openBookmarkedPage(
                        this,
                        content,
                        savedChapterIndex,
                        savedPageIndex
                );
            });

            android.widget.Button removeButton =
                    new android.widget.Button(this);

            removeButton.setText("Remove");

            removeButton.setOnClickListener(v -> {
                pilgrimBookmarkPrefs.edit()
                        .remove(bookmarkKey)
                        .apply();

                showDescendantsBookmarks();
            });

            bookmarkRow.addView(
                    openButton,
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    )
            );

            bookmarkRow.addView(removeButton);

            content.addView(
                    bookmarkRow,
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    )
            );
        }
    }
}

for (int i = 0; i < chapters.size(); i++) {
    final int chapterIndex = i;
    DescendantsOfGoodLibrary.Chapter chapter = chapters.get(i);

    for (int pageIndex = 0; pageIndex < chapter.pages.size(); pageIndex++) {
        final int savedPageIndex = pageIndex;
        String bookmarkKey = chapterIndex + "_" + pageIndex;

        if (bookmarkPrefs.getBoolean(bookmarkKey, false)) {
            foundBookmark = true;

            LinearLayout bookmarkRow = new LinearLayout(this);
            bookmarkRow.setOrientation(LinearLayout.HORIZONTAL);
            bookmarkRow.setGravity(android.view.Gravity.CENTER_VERTICAL);

            android.widget.Button openButton =
                    new android.widget.Button(this);
            openButton.setText(
                    chapter.title + " — Page " + (pageIndex + 1)
            );
            openButton.setOnClickListener(v -> {
                android.content.SharedPreferences storyPrefs =
                        getSharedPreferences(
                                "DescendantsReadingProgress",
                                MODE_PRIVATE
                        );

                storyPrefs.edit()
                        .putInt("lastChapter", chapterIndex)
                        .putInt("lastPage", savedPageIndex)
                        .apply();

                showDescendantsBookmarkedPage(chapterIndex, savedPageIndex);
            });

            android.widget.Button removeButton =
                    new android.widget.Button(this);
            removeButton.setText("Remove");
            removeButton.setOnClickListener(v -> {
                bookmarkPrefs.edit()
                        .remove(bookmarkKey)
                        .apply();

                showDescendantsBookmarks();
            });

            bookmarkRow.addView(
                    openButton,
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    )
            );

            bookmarkRow.addView(removeButton);

            content.addView(
                    bookmarkRow,
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    )
            );
        }
    }
}

if (!foundBookmark) {
    TextView emptyMessage = new TextView(this);
    emptyMessage.setText(
            "You haven't bookmarked any passages yet.\n\n"
                    + "Open a chapter and tap 🔖 to save a page."
    );
    emptyMessage.setTextSize(16);
    emptyMessage.setTextColor(darkText);
    emptyMessage.setPadding(0, 20, 0, 20);
    content.addView(emptyMessage);
}

    }
    void showDescendantsBookmarkedPage(int chapterIndex, int pageIndex) {
    android.content.SharedPreferences storyPrefs =
            getSharedPreferences("DescendantsReadingProgress", MODE_PRIVATE);

    storyPrefs.edit()
            .putInt("lastChapter", chapterIndex)
            .putInt("lastPage", pageIndex)
            .apply();

    showDescendantsOfGoodChapter(chapterIndex, pageIndex);
    }
    void showDescendantsOfGoodChapter(int chapterIndex) {
    showDescendantsOfGoodChapter(chapterIndex, -1);
    }
    void showDescendantsOfGoodChapter(int chapterIndex, int startingPage) {
    stopTimer();
    content.removeAllViews();

    java.util.List<DescendantsOfGoodLibrary.Chapter> chapters =
            DescendantsOfGoodLibrary.getChapters();

    if (chapterIndex < 0 || chapterIndex >= chapters.size()) {
        showDescendantsOfGoodChapters();
        return;
    }

    DescendantsOfGoodLibrary.Chapter chapter =
            chapters.get(chapterIndex);

    ImageButton backButton = new ImageButton(this);
    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setOnClickListener(
            v -> showDescendantsOfGoodChapters()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(60, 60)
    );
android.content.SharedPreferences textPrefs =
        getSharedPreferences("TextAppearancePrefs", MODE_PRIVATE);

int savedTextSize = textPrefs.getInt("textSize", 18);

String savedTextMode =
        textPrefs.getString("textMode", "Light");

int selectedTextColor = savedTextMode.equals("Dark")
        ? android.graphics.Color.WHITE
        : android.graphics.Color.BLACK;
    TextView chapterTitle = new TextView(this);
    chapterTitle.setText(chapter.title);
    chapterTitle.setTextSize(savedTextSize + 8);
    chapterTitle.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    chapterTitle.setTextColor(selectedTextColor);
    chapterTitle.setPadding(0, 15, 0, 10);

    content.addView(chapterTitle);

    TextView chapterSubtitle = new TextView(this);
    chapterSubtitle.setText(chapter.subtitle);
    chapterSubtitle.setTextSize(Math.max(12, savedTextSize - 2));
    chapterSubtitle.setTextColor(selectedTextColor);
    chapterSubtitle.setPadding(0, 0, 0, 20);

    content.addView(chapterSubtitle);

    TextView pageText = new TextView(this);
    pageText.setTextSize(savedTextSize);
    pageText.setTextColor(selectedTextColor);
    pageText.setLineSpacing(8, 1.0f);
    pageText.setPadding(0, 10, 0, 20);
    pageText.setTextIsSelectable(true);

    content.addView(
            pageText,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );
LinearLayout bookmarkRow = new LinearLayout(this);
bookmarkRow.setOrientation(LinearLayout.HORIZONTAL);
bookmarkRow.setGravity(android.view.Gravity.LEFT);

android.widget.TextView bookmarkButton = new android.widget.TextView(this);
bookmarkButton.setText("🔖");
bookmarkButton.setTextSize(28);
bookmarkButton.setPadding(8, 8, 8, 8);
bookmarkButton.setContentDescription("Bookmark this page");

bookmarkRow.addView(bookmarkButton);
        bookmarkButton.setOnClickListener(v -> {
    android.content.SharedPreferences bookmarkPrefs =
            getSharedPreferences("DescendantsBookmarks", MODE_PRIVATE);

    android.content.SharedPreferences storyPrefs =
        getSharedPreferences("DescendantsReadingProgress", MODE_PRIVATE);

int bookmarkPage = storyPrefs.getInt("lastPage", 0);
String bookmarkKey = chapterIndex + "_" + bookmarkPage;

    bookmarkPrefs.edit()
            .putBoolean(bookmarkKey, true)
            .apply();

    android.widget.Toast.makeText(
            this,
            "Page bookmarked!",
            android.widget.Toast.LENGTH_SHORT
    ).show();
});
content.addView(bookmarkRow);
    LinearLayout navigation = new LinearLayout(this);
    navigation.setOrientation(LinearLayout.HORIZONTAL);
    navigation.setGravity(android.view.Gravity.CENTER);

    android.widget.Button previousButton =
            new android.widget.Button(this);
    previousButton.setText("← Previous");

    android.widget.Button nextButton =
            new android.widget.Button(this);
    nextButton.setText("Next →");

    navigation.addView(
            previousButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    navigation.addView(
            nextButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    content.addView(navigation);

    final int[] currentPage = {0};

android.content.SharedPreferences storyPrefs =
        getSharedPreferences("DescendantsReadingProgress", MODE_PRIVATE);

int savedChapter = storyPrefs.getInt("lastChapter", 0);
int savedPage = storyPrefs.getInt("lastPage", 0);

if (startingPage >= 0) {
    currentPage[0] = Math.max(
            0,
            Math.min(startingPage, chapter.pages.size() - 1)
    );
} else if (savedChapter == chapterIndex) {
    currentPage[0] = Math.max(
            0,
            Math.min(savedPage, chapter.pages.size() - 1)
    );
}
    Runnable updatePage = () -> {
pageText.setText(chapter.pages.get(currentPage[0]));

// Save the current reading position
storyPrefs.edit()
        .putInt("lastChapter", chapterIndex)
        .putInt("lastPage", currentPage[0])
        .apply();

// Record this story page as visited
SharedPreferences visitedPagesPrefs =
        getSharedPreferences(
                "DescendantsVisitedPages",
                MODE_PRIVATE
        );

String pageKey = chapterIndex + "_" + currentPage[0];

visitedPagesPrefs.edit()
        .putBoolean(pageKey, true)
        .apply();

// Check whether every page in this chapter was visited
boolean chapterCompleted = true;

for (int i = 0; i < chapter.pages.size(); i++) {
    if (!visitedPagesPrefs.getBoolean(
            chapterIndex + "_" + i, false)) {
        chapterCompleted = false;
        break;
    }
}

// Record completed chapters
if (chapterCompleted) {
    java.util.Set<String> completedChapters =
            new java.util.HashSet<>(
                    visitedPagesPrefs.getStringSet(
                            "completedChapters",
                            java.util.Collections.emptySet()
                    )
            );

    completedChapters.add(String.valueOf(chapterIndex));

    visitedPagesPrefs.edit()
            .putStringSet(
                    "completedChapters",
                    completedChapters
            )
            .apply();

    // Count the story book once all chapters are complete
    java.util.List<DescendantsOfGoodLibrary.Chapter> allChapters =
        DescendantsOfGoodLibrary.getChapters();
    if (completedChapters.size() == allChapters.size()) {
        SharedPreferences readingPrefs =
                getSharedPreferences(
                        "BibleReadingPrefs",
                        MODE_PRIVATE
                );

        java.util.Set<String> completedStoryBooks =
                new java.util.HashSet<>(
                        readingPrefs.getStringSet(
                                "completedStoryBooks",
                                java.util.Collections.emptySet()
                        )
                );

        if (completedStoryBooks.add("Descendants of Good")) {
            readingPrefs.edit()
                    .putStringSet(
                            "completedStoryBooks",
                            completedStoryBooks
                    )
                    .putInt(
                            "storyBooksRead",
                            completedStoryBooks.size()
                    )
                    .apply();
        }
    }
}

previousButton.setEnabled(currentPage[0] > 0);

nextButton.setEnabled(
        currentPage[0] < chapter.pages.size() - 1
);

};

    previousButton.setOnClickListener(v -> {
        if (currentPage[0] > 0) {
            currentPage[0]--;
            updatePage.run();
        }
    });

    nextButton.setOnClickListener(v -> {
        if (currentPage[0] < chapter.pages.size() - 1) {
            currentPage[0]++;
            updatePage.run();
        }
    });

    updatePage.run();
    }
    void showSermons() {
    stopTimer();
    content.removeAllViews();
            ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showLearnMenu()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("🎙️ Sermons");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "🙏 Faith & Trust",
            "A message about trusting God through difficult seasons.",
            v -> showMessage(
                    "🙏 Faith & Trust",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "🔥 Growing Spiritually",
            "A message about developing a stronger relationship with God.",
            v -> showMessage(
                    "🔥 Growing Spiritually",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "❤️ Walking in Love",
            "A message about living out Christian love every day.",
            v -> showMessage(
                    "❤️ Walking in Love",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "🌱 Living With Purpose",
            "A message about living with faith, purpose, and obedience.",
            v -> showMessage(
                    "🌱 Living With Purpose",
                    "Sermon content will be added here."
            )
    );

    
    }
    void showBibleChapter(String book, int chapter) {
    stopTimer();
    content.removeAllViews();
        // Record this Bible chapter as visited
SharedPreferences chapterProgressPrefs =
        getSharedPreferences(
                "BibleChapterProgressPrefs",
                MODE_PRIVATE
        );

String chapterKey = book + "_" + chapter;

chapterProgressPrefs.edit()
        .putBoolean(chapterKey, true)
        .apply();

// Check whether every chapter in this book has been visited
int totalChapters = getChapterCount(book);
boolean allChaptersVisited = totalChapters > 0;

for (int i = 1; i <= totalChapters; i++) {
    if (!chapterProgressPrefs.getBoolean(
            book + "_" + i, false)) {
        allChaptersVisited = false;
        break;
    }
}

// Count the book only once
if (allChaptersVisited) {
    SharedPreferences readingPrefs =
            getSharedPreferences(
                    "BibleReadingPrefs",
                    MODE_PRIVATE
            );

    java.util.Set<String> completedBooks =
            new java.util.HashSet<>(
                    readingPrefs.getStringSet(
                            "completedBibleBooks",
                            new java.util.HashSet<>()
                    )
            );

    if (completedBooks.add(book)) {
        readingPrefs.edit()
                .putStringSet(
                        "completedBibleBooks",
                        completedBooks
                )
                .putInt("booksRead", completedBooks.size())
                .apply();
    }
}

    SharedPreferences biblePrefs =
            getSharedPreferences(
                    "KingdomLifePrefs",
                    MODE_PRIVATE
            );

    String translation =
        biblePrefs.getString(
                "bible_translation",
                "KJV"
        );

LinearLayout topBar =
        new LinearLayout(this);

topBar.setOrientation(
        LinearLayout.HORIZONTAL
);

topBar.setGravity(
        Gravity.LEFT | Gravity.CENTER_VERTICAL
);

ImageButton backButton =
        new ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setBackgroundColor(
        Color.TRANSPARENT
);

backButton.setContentDescription(
        "Back to chapters"
);

backButton.setOnClickListener(
        v -> showBookChapters(
                book,
                getChapterCount(book)
        )
);

topBar.addView(
        backButton,
        new LinearLayout.LayoutParams(
                70,
                70
        )
);

content.addView(topBar);

TextView title = new TextView(this);

    title.setText(
            "📖 " + book + " " + chapter +
            " — " + translation
    );

    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);


    try {

        InputStream inputStream =
                getAssets().open(
                        (translation.equals("KJV")
                                ? "kjv/"
                                : "web/")
                        + book + ".json"
                );
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(inputStream)
                );

        StringBuilder jsonText =
                new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }

        reader.close();

        JSONObject bible =
                new JSONObject(jsonText.toString());

        JSONObject selectedChapter =
                bible.getJSONObject(
                        String.valueOf(chapter)
                );

        java.util.ArrayList<String> verseNumbers =
                new java.util.ArrayList<>();

        java.util.Iterator<String> keys =
                selectedChapter.keys();

        while (keys.hasNext()) {
            verseNumbers.add(keys.next());
        }

        java.util.Collections.sort(
                verseNumbers,
                (a, b) -> Integer.compare(
                        Integer.parseInt(a),
                        Integer.parseInt(b)
                )
        );

        for (String verseNumber : verseNumbers) {

            String verseText =
                    selectedChapter.getString(verseNumber);

            LinearLayout verseLayout =
                    new LinearLayout(this);

            verseLayout.setOrientation(
                    LinearLayout.VERTICAL
            );
            android.content.SharedPreferences textPrefs =
        getSharedPreferences(
                "TextAppearancePrefs",
                MODE_PRIVATE
        );

int savedTextSize =
        textPrefs.getInt("textSize", 18);

String savedTextMode =
        textPrefs.getString("textMode", "Light");

int selectedTextColor =
        savedTextMode.equals("Dark")
                ? android.graphics.Color.WHITE
                : android.graphics.Color.BLACK;

            TextView verse = new TextView(this);

            verse.setText(
                    verseNumber + " " + verseText
            );
            String reference =
        book + " " +
        chapter + ":" +
        verseNumber;

            verse.setTextSize(savedTextSize);
verse.setTextColor(selectedTextColor);
            verse.setPadding(5, 10, 5, 5);
            String savedHighlight =
        highlightsPrefs.getString(
                reference,
                null
        );

if (savedHighlight != null) {

    try {
        String[] parts =
                savedHighlight.split("\\|", 2);

        int highlightColor =
                Integer.parseInt(parts[0]);

        verse.setBackgroundColor(
                highlightColor
        );

    } catch (Exception ignored) {
    }
            }
            

            verseLayout.addView(verse);

            LinearLayout actionRow =
        new LinearLayout(this);

actionRow.setOrientation(
        LinearLayout.HORIZONTAL
);

actionRow.setGravity(
        Gravity.LEFT | Gravity.CENTER_VERTICAL
);

actionRow.setPadding(
        0,
        0,
        0,
        5
);

// ⭐ Save Verse
Button saveButton =
        new Button(this);

saveButton.setText("⭐");
saveButton.setTextSize(15);
saveButton.setAllCaps(false);
saveButton.setTextColor(darkText);
saveButton.setBackgroundColor(
        Color.TRANSPARENT
);
saveButton.setPadding(
        0,
        0,
        0,
        0
);

saveButton.setOnClickListener(
        v -> saveVerse(
                reference,
                verseText
        )
);

actionRow.addView(
        saveButton,
        new LinearLayout.LayoutParams(
                45,
                45
        )
);

// 🔖 Bookmark
Button bookmarkButton =
        new Button(this);

bookmarkButton.setText("🔖");
bookmarkButton.setTextSize(15);
bookmarkButton.setAllCaps(false);
bookmarkButton.setTextColor(darkText);
bookmarkButton.setBackgroundColor(
        Color.TRANSPARENT
);
bookmarkButton.setPadding(
        0,
        0,
        0,
        0
);

bookmarkButton.setOnClickListener(v -> {

    if (bookmarksPrefs.contains(reference)) {

        bookmarksPrefs.edit()
                .remove(reference)
                .apply();

        showMessage(
                "🔖 Bookmark Removed",
                reference +
                " was removed from bookmarks."
        );

    } else {

        saveBookmark(reference);
    }
});

actionRow.addView(
        bookmarkButton,
        new LinearLayout.LayoutParams(
                45,
                45
        )
);

// 🖍️ Highlight
Button highlightButton =
        new Button(this);

highlightButton.setText("🖍️");
highlightButton.setTextSize(15);
highlightButton.setAllCaps(false);
highlightButton.setTextColor(darkText);
highlightButton.setBackgroundColor(
        Color.TRANSPARENT
);
highlightButton.setPadding(
        0,
        0,
        0,
        0
);

highlightButton.setOnClickListener(
        v -> showHighlightColors(
                reference,
                verseText
        )
);

actionRow.addView(
        highlightButton,
        new LinearLayout.LayoutParams(
                45,
                45
        )
);

verseLayout.addView(actionRow);



            content.addView(verseLayout);
        }

    } catch (Exception e) {

        TextView error = new TextView(this);

        error.setText(
                "Unable to load this Bible chapter."
        );

        error.setTextSize(18);
        error.setTextColor(darkText);
        error.setPadding(5, 10, 5, 20);

        content.addView(error);
    }
        }
    int getChapterCount(String book) {

    if (book.equals("Genesis")) return 50;
    if (book.equals("Exodus")) return 40;
    if (book.equals("Leviticus")) return 27;
    if (book.equals("Numbers")) return 36;
    if (book.equals("Deuteronomy")) return 34;
    if (book.equals("Joshua")) return 24;
    if (book.equals("Judges")) return 21;
    if (book.equals("Ruth")) return 4;
    if (book.equals("1 Samuel")) return 31;
    if (book.equals("2 Samuel")) return 24;
    if (book.equals("1 Kings")) return 22;
    if (book.equals("2 Kings")) return 25;
    if (book.equals("1 Chronicles")) return 29;
    if (book.equals("2 Chronicles")) return 36;
    if (book.equals("Ezra")) return 10;
    if (book.equals("Nehemiah")) return 13;
    if (book.equals("Esther")) return 10;
    if (book.equals("Job")) return 42;
    if (book.equals("Psalms")) return 150;
    if (book.equals("Proverbs")) return 31;
    if (book.equals("Ecclesiastes")) return 12;
    if (book.equals("Song of Solomon")) return 8;
    if (book.equals("Isaiah")) return 66;
    if (book.equals("Jeremiah")) return 52;
    if (book.equals("Lamentations")) return 5;
    if (book.equals("Ezekiel")) return 48;
    if (book.equals("Daniel")) return 12;
    if (book.equals("Hosea")) return 14;
    if (book.equals("Joel")) return 3;
    if (book.equals("Amos")) return 9;
    if (book.equals("Obadiah")) return 1;
    if (book.equals("Jonah")) return 4;
    if (book.equals("Micah")) return 7;
    if (book.equals("Nahum")) return 3;
    if (book.equals("Habakkuk")) return 3;
    if (book.equals("Zephaniah")) return 3;
    if (book.equals("Haggai")) return 2;
    if (book.equals("Zechariah")) return 14;
    if (book.equals("Malachi")) return 4;

    if (book.equals("Matthew")) return 28;
    if (book.equals("Mark")) return 16;
    if (book.equals("Luke")) return 24;
    if (book.equals("John")) return 21;
    if (book.equals("Acts")) return 28;
    if (book.equals("Romans")) return 16;
    if (book.equals("1 Corinthians")) return 16;
    if (book.equals("2 Corinthians")) return 13;
    if (book.equals("Galatians")) return 6;
    if (book.equals("Ephesians")) return 6;
    if (book.equals("Philippians")) return 4;
    if (book.equals("Colossians")) return 4;
    if (book.equals("1 Thessalonians")) return 5;
    if (book.equals("2 Thessalonians")) return 3;
    if (book.equals("1 Timothy")) return 6;
    if (book.equals("2 Timothy")) return 4;
    if (book.equals("Titus")) return 3;
    if (book.equals("Philemon")) return 1;
    if (book.equals("Hebrews")) return 13;
    if (book.equals("James")) return 5;
    if (book.equals("1 Peter")) return 5;
    if (book.equals("2 Peter")) return 3;
    if (book.equals("1 John")) return 5;
    if (book.equals("2 John")) return 1;
    if (book.equals("3 John")) return 1;
    if (book.equals("Jude")) return 1;
    if (book.equals("Revelation")) return 22;

    return 0;
        }
    void showHighlightColors(String reference, String verseText) {

    stopTimer();

    String[] colors = {
            "🟨 Yellow",
            "🟩 Green",
            "🟦 Blue",
            "🩷 Pink"
    };

    new android.app.AlertDialog.Builder(this)
            .setTitle("🖍️ Choose Highlight Color")
            .setItems(
                    colors,
                    (dialog, which) -> {

                        int color;

                        if (which == 0) {
    color = Color.rgb(255, 245, 157);
} else if (which == 1) {
    color = Color.rgb(200, 230, 201);
} else if (which == 2) {
    color = Color.rgb(187, 222, 251);
} else {
    color = Color.rgb(248, 187, 208);
                        }

                        saveColoredHighlight(
                                reference,
                                verseText,
                                color
                        );
                    }
            )
            .setNegativeButton("Cancel", null)
            .show();
    }
    void saveColoredHighlight(
        String reference,
        String verseText,
        int color
) {

    if (highlightsPrefs == null) {
        return;
    }

    highlightsPrefs.edit()
            .putString(
                    reference,
                    color + "|" + verseText
            )
            .apply();

    showMessage(
            "🖍️ Highlight Saved",
            reference + "\n\n" + verseText
    );
    }
    void showBookChapters(String book, int chapterCount) {
    stopTimer();
    content.removeAllViews();

    LinearLayout topBar =
        new LinearLayout(this);

topBar.setOrientation(
        LinearLayout.HORIZONTAL
);

topBar.setGravity(
        Gravity.LEFT | Gravity.CENTER_VERTICAL
);

ImageButton backButton =
        new ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setBackgroundColor(
        Color.TRANSPARENT
);

backButton.setContentDescription(
        "Back to books"
);

backButton.setOnClickListener(v -> {

    if (book.equals("Genesis") ||
        book.equals("Exodus") ||
        book.equals("Leviticus") ||
        book.equals("Numbers") ||
        book.equals("Deuteronomy") ||
        book.equals("Joshua") ||
        book.equals("Judges") ||
        book.equals("Ruth") ||
        book.equals("1 Samuel") ||
        book.equals("2 Samuel") ||
        book.equals("1 Kings") ||
        book.equals("2 Kings") ||
        book.equals("1 Chronicles") ||
        book.equals("2 Chronicles") ||
        book.equals("Ezra") ||
        book.equals("Nehemiah") ||
        book.equals("Esther") ||
        book.equals("Job") ||
        book.equals("Psalms") ||
        book.equals("Proverbs") ||
        book.equals("Ecclesiastes") ||
        book.equals("Song of Solomon") ||
        book.equals("Isaiah") ||
        book.equals("Jeremiah") ||
        book.equals("Lamentations") ||
        book.equals("Ezekiel") ||
        book.equals("Daniel") ||
        book.equals("Hosea") ||
        book.equals("Joel") ||
        book.equals("Amos") ||
        book.equals("Obadiah") ||
        book.equals("Jonah") ||
        book.equals("Micah") ||
        book.equals("Nahum") ||
        book.equals("Habakkuk") ||
        book.equals("Zephaniah") ||
        book.equals("Haggai") ||
        book.equals("Zechariah") ||
        book.equals("Malachi")) {

        showOldTestament();

    } else {

        showNewTestament();

    }
});

topBar.addView(
        backButton,
        new LinearLayout.LayoutParams(
                70,
                70
        )
);

content.addView(topBar);
        

        

    TextView title = new TextView(this);

    title.setText(
            "📖 " + book
    );

    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );

    content.addView(title);

    TextView instruction = new TextView(this);

    instruction.setText(
            "Choose a chapter:"
    );

    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(
            0,
            0,
            0,
            15
    );

    content.addView(instruction);

    LinearLayout chapterGrid =
            new LinearLayout(this);

    chapterGrid.setOrientation(
            LinearLayout.VERTICAL
    );

    for (int chapter = 1;
         chapter <= chapterCount;
         chapter += 2) {

        LinearLayout row =
                new LinearLayout(this);

        row.setOrientation(
                LinearLayout.HORIZONTAL
        );

        row.setWeightSum(2);

        final int firstChapter = chapter;

        Button firstButton =
                new Button(this);

        firstButton.setText(
                "📜 " + firstChapter
        );

        firstButton.setOnClickListener(
                v -> showBibleChapter(
                        book,
                        firstChapter
                )
        );

        row.addView(
                firstButton,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        if (chapter + 1 <= chapterCount) {

            final int secondChapter =
                    chapter + 1;

            Button secondButton =
                    new Button(this);

            secondButton.setText(
                    "📜 " + secondChapter
            );

            secondButton.setOnClickListener(
                    v -> showBibleChapter(
                            book,
                            secondChapter
                    )
            );

            row.addView(
                    secondButton,
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    )
            );
        }

        chapterGrid.addView(row);
    }

    content.addView(chapterGrid);
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

        StringBuilder jsonText =
                new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }

        reader.close();

        JSONObject bible =
                new JSONObject(jsonText.toString());

        JSONObject selectedChapter =
                bible.getJSONObject(
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

        return "ERROR: " + e.toString();
    }
    }
        void showProgress() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📊 Progress");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    // Points progress
    addCard(
            "⭐ Points",
            totalPoints + " points earned so far.",
            v -> {}
    );

    // Memory verse progress
    addCard(
            "🧠 Memory Verses",
            learnedVerses + " verse(s) learned.",
            v -> {}
    );

    // Daily streak
    addCard(
            "🔥 Daily Streak",
            dailyStreak + " day(s) streak.",
            v -> {}
    );

    // Daily challenge status
    addCard(
            "✅ Challenges",
            challengeCompletedToday
                    ? "Today's challenge completed."
                    : "Today's challenge not completed yet.",
            v -> {}
    );

    // Reading progress preferences
    android.content.SharedPreferences readingPrefs =
            getSharedPreferences(
                    "BibleReadingPrefs",
                    MODE_PRIVATE
            );

    // Bible books read
// Reuse the readingPrefs variable declared earlier

java.util.Set<String> completedBibleBooks =
        readingPrefs.getStringSet(
                "completedBibleBooks",
                java.util.Collections.emptySet()
        );

int booksRead = completedBibleBooks.size();

addCard(
        "📖 Bible Books Read",
        booksRead + " Bible book(s) read.",
        v -> {}
);


    // Kingdom books read
int spiritualBooksRead =
        readingPrefs.getInt("spiritualBooksRead", 0);

int storyBooksRead =
        readingPrefs.getInt("storyBooksRead", 0);

int kingdomBooksRead =
        spiritualBooksRead + storyBooksRead;

addCard(
        "📚 Kingdom Books Read",
        kingdomBooksRead + " book(s) read.",
        v -> {}
);

    // Return to Home
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
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    
    addCard(
            "🔊 Button Sounds",
            "Control sounds when buttons are pressed.",
            v -> showMessage(
                    "🔊 Button Sounds",
                    "Button sound controls will be available here."
            )
    );

    

    addCard(
            "📊 Progress",
            "View your points, streaks, and learning progress.",
            v -> showProgress()
    );

    
        addCard(
        "🔔 Notifications",
        "Manage reminders for your Kingdom Life activities.",
        v -> showNotificationSettings()
);
addCard(
        "🔤 Text Appearance",
        "Adjust text size and text colour.",
        v -> showTextAppearanceSettings()
);
        addCard(
        "🌞 Day / 🌙 Night Mode",
        "Switch between light and dark appearance.",
        v -> showDisplayModeSettings()
);
    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showDisplayModeSettings() {
    stopTimer();
    content.removeAllViews();
        // Top-left back arrow
android.widget.ImageButton backButton =
new android.widget.ImageButton(this);
backButton.setImageResource(android.R.drawable.ic_media_previous);
backButton.setScaleX(1.3f);
backButton.setScaleY(1.3f);
backButton.setContentDescription("Back to Settings");
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setScaleType(
android.widget.ImageView.ScaleType.CENTER_INSIDE
);
backButton.setOnClickListener(v -> showSettings());

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);
backParams.gravity = Gravity.LEFT;
content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🌞 Day / 🌙 Night Mode");
    title.setTextSize(22);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    android.content.SharedPreferences displayPrefs =
            getSharedPreferences("KingdomLifeDisplayPrefs", MODE_PRIVATE);

    String currentMode =
            displayPrefs.getString("displayMode", "AUTO");

    String[] modes = {
            "Automatic (follow time)",
            "Day Mode",
            "Night Mode"
    };

    int selectedMode = currentMode.equals("DAY") ? 1
            : currentMode.equals("NIGHT") ? 2 : 0;

    android.widget.RadioGroup group =
            new android.widget.RadioGroup(this);

    String[] values = {"AUTO", "DAY", "NIGHT"};

    for (int i = 0; i < modes.length; i++) {
        android.widget.RadioButton option =
                new android.widget.RadioButton(this);

        option.setText(modes[i]);
        option.setTextSize(16);
        option.setTextColor(darkText);
        option.setId(100 + i);
        group.addView(option);

        if (i == selectedMode) {
            option.setChecked(true);
        }
    }

    content.addView(group);

    addButton("💾 Save Display Mode", v -> {
        int checkedId = group.getCheckedRadioButtonId();

        if (checkedId == -1) {
            showMessage("Display Mode", "Please select a mode.");
            return;
        }

        String mode = values[checkedId - 100];

        displayPrefs.edit()
                .putString("displayMode", mode)
                .apply();

        showMessage(
                "Display Mode Saved",
                "Your display preference has been saved."
        );

        showHome();
    });

    }
    void showTextAppearanceSettings() {
    stopTimer();
    content.removeAllViews();

    // Top-left back arrow
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);
    backButton.setContentDescription("Back to Settings");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );
    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(v -> showSettings());

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);
    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    // Title
    TextView title = new TextView(this);
    title.setText("🔤 Text Appearance");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    // Saved preferences
    android.content.SharedPreferences prefs =
            getSharedPreferences(
                    "TextAppearancePrefs",
                    MODE_PRIVATE
            );

    int savedSize = prefs.getInt("textSize", 18);
    String savedMode = prefs.getString("textMode", "Light");

    // Text size controls
    LinearLayout textSizeRow = new LinearLayout(this);
    textSizeRow.setOrientation(LinearLayout.HORIZONTAL);
    textSizeRow.setGravity(Gravity.CENTER);
    textSizeRow.setPadding(0, 10, 0, 10);

    Button decreaseTextButton = new Button(this);
    decreaseTextButton.setText("−");
    decreaseTextButton.setTextSize(22);
    decreaseTextButton.setAllCaps(false);

    TextView textSizeValue = new TextView(this);
    textSizeValue.setText("(" + savedSize + ")");
    textSizeValue.setTextSize(20);
    textSizeValue.setTextColor(darkText);
    textSizeValue.setGravity(Gravity.CENTER);
    textSizeValue.setPadding(20, 0, 20, 0);

    Button increaseTextButton = new Button(this);
    increaseTextButton.setText("+");
    increaseTextButton.setTextSize(22);
    increaseTextButton.setAllCaps(false);

    decreaseTextButton.setOnClickListener(v -> {
        int size = prefs.getInt("textSize", 18);

        if (size > 13) {
            size--;
            prefs.edit().putInt("textSize", size).apply();
            showTextAppearanceSettings();
        }
    });

    increaseTextButton.setOnClickListener(v -> {
        int size = prefs.getInt("textSize", 18);

        if (size < 30) {
            size++;
            prefs.edit().putInt("textSize", size).apply();
            showTextAppearanceSettings();
        }
    });

    textSizeRow.addView(decreaseTextButton);
    textSizeRow.addView(textSizeValue);
    textSizeRow.addView(increaseTextButton);

    content.addView(textSizeRow);

    // Text colour mode
    TextView modeLabel = new TextView(this);
    modeLabel.setText("Text Colour Mode: " + savedMode);
    modeLabel.setTextSize(18);
    modeLabel.setTextColor(darkText);
    modeLabel.setPadding(0, 20, 0, 10);
    content.addView(modeLabel);

    Switch textColorSwitch = new Switch(this);
    textColorSwitch.setText("Dark Text Mode");
    textColorSwitch.setTextSize(18);

    textColorSwitch.setChecked(savedMode.equals("Dark"));

    textColorSwitch.setOnCheckedChangeListener(
            (buttonView, isChecked) -> {
                String mode = isChecked ? "Dark" : "Light";

                prefs.edit()
                        .putString("textMode", mode)
                        .apply();

                modeLabel.setText("Text Colour Mode: " + mode);
            }
    );

    content.addView(textColorSwitch);
    }

    void showNotificationSettings() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showSettings()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("🔔 Notifications");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "Control your Kingdom Life reminders."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(
            0,
            0,
            0,
            20
    );
    content.addView(message);

    final android.widget.Switch notificationSwitch =
            new android.widget.Switch(this);

    notificationSwitch.setText(
            "🔔 Notifications"
    );

    notificationSwitch.setTextSize(18);
    notificationSwitch.setTextColor(darkText);

    boolean notificationsEnabled =
            getSharedPreferences(
                    "KingdomLifePrefs",
                    MODE_PRIVATE
            ).getBoolean(
                    "notifications_enabled",
                    false
            );

    notificationSwitch.setChecked(
            notificationsEnabled
    );

    content.addView(
            notificationSwitch,
            new LinearLayout.LayoutParams(
                    -1,
                    60
            )
    );

    notificationSwitch.setOnCheckedChangeListener(
            (buttonView, isChecked) -> {

                android.content.SharedPreferences
                        notificationPrefs =
                        getSharedPreferences(
                                "KingdomLifePrefs",
                                MODE_PRIVATE
                        );

                notificationPrefs.edit()
                        .putBoolean(
                                "notifications_enabled",
                                isChecked
                        )
                        .apply();

                if (isChecked) {

                    scheduleKingdomLifeNotification(
                            "daily",
                            18,
                            0
                    );

                    scheduleKingdomLifeNotification(
                            "bible",
                            8,
                            0
                    );

                    scheduleKingdomLifeNotification(
                            "memory",
                            20,
                            0
                    );

                    showMessage(
                            "🔔 Notifications On",
                            "Kingdom Life reminders are now enabled."
                    );

                } else {

                    cancelKingdomLifeNotification(
                            "daily"
                    );

                    cancelKingdomLifeNotification(
                            "bible"
                    );

                    cancelKingdomLifeNotification(
                            "memory"
                    );

                    showMessage(
                            "🔕 Notifications Off",
                            "All Kingdom Life reminders are now disabled."
                    );
                }
            }
    );

    addCard(
            "⏰ Reminder Times",
            "🎯 Daily Challenge — 6:00 PM\n" +
            "📖 Bible Reading — 8:00 AM\n" +
            "🧠 Memory Verse — 8:00 PM",
            v -> {}
    );

    }
                
    void scheduleKingdomLifeNotification(
        String type,
        int hour,
        int minute
) {

    AlarmManager alarmManager =
            (AlarmManager) getSystemService(
                    ALARM_SERVICE
            );

    if (alarmManager == null) {
        return;
    }

    Intent intent =
            new Intent(
                    this,
                    KingdomLifeNotificationReceiver.class
            );

    intent.putExtra(
            "notification_type",
            type
    );

    int requestCode;

    if ("daily".equals(type)) {
        requestCode = 1001;
    } else if ("bible".equals(type)) {
        requestCode = 1002;
    } else {
        requestCode = 1003;
    }

    PendingIntent pendingIntent =
            PendingIntent.getBroadcast(
                    this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT |
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                            ? PendingIntent.FLAG_IMMUTABLE
                            : 0)
            );

    java.util.Calendar calendar =
            java.util.Calendar.getInstance();

    calendar.set(
            java.util.Calendar.HOUR_OF_DAY,
            hour
    );

    calendar.set(
            java.util.Calendar.MINUTE,
            minute
    );

    calendar.set(
            java.util.Calendar.SECOND,
            0
    );

    if (calendar.getTimeInMillis()
            <= System.currentTimeMillis()) {

        calendar.add(
                java.util.Calendar.DAY_OF_YEAR,
                1
        );
    }

    alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.getTimeInMillis(),
            AlarmManager.INTERVAL_DAY,
            pendingIntent
    );
    }
    void cancelKingdomLifeNotification(
        String type
) {

    AlarmManager alarmManager =
            (AlarmManager) getSystemService(
                    ALARM_SERVICE
            );

    if (alarmManager == null) {
        return;
    }

    Intent intent =
            new Intent(
                    this,
                    KingdomLifeNotificationReceiver.class
            );

    int requestCode;

    if ("daily".equals(type)) {
        requestCode = 1001;
    } else if ("bible".equals(type)) {
        requestCode = 1002;
    } else {
        requestCode = 1003;
    }

    PendingIntent pendingIntent =
            PendingIntent.getBroadcast(
                    this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT |
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                            ? PendingIntent.FLAG_IMMUTABLE
                            : 0)
            );

    alarmManager.cancel(pendingIntent);
    pendingIntent.cancel();
    }
    
    void checkAchievementNotifications() {

    // Points achievements
    if (totalPoints >= 5) {
        showAchievementNotification(
                "First Step",
                "You earned your first points!"
        );
    }

    if (totalPoints >= 50) {
        showAchievementNotification(
                "Point Builder",
                "You reached 50 points!"
        );
    }

    // Bible learning achievement
    if (learnedVerses >= 5) {
        showAchievementNotification(
                "Bible Learner",
                "You have learned 5 Bible verses!"
        );
    }

    // Daily streak achievement
    if (dailyStreak >= 3) {
        showAchievementNotification(
                "Streak Keeper",
                "You reached a 3-day streak!"
        );
    }

    // Daily challenge achievement
    if (challengeCompletedToday) {
        showAchievementNotification(
                "Challenge Complete",
                "You completed today's challenge!"
        );
    }

    // Bible Challenge levels
    boolean easyCompleted = prefs.getBoolean(
            "challenge_level_1_completed", false
    );

    boolean mediumCompleted = prefs.getBoolean(
            "challenge_level_2_completed", false
    );

    boolean hardCompleted = prefs.getBoolean(
            "challenge_level_3_completed", false
    );

    if (easyCompleted) {
        showAchievementNotification(
                "Easy Challenger",
                "You completed Level 1!"
        );
    }

    if (mediumCompleted) {
        showAchievementNotification(
                "Medium Challenger",
                "You completed Level 2!"
        );
    }

    if (hardCompleted) {
        showAchievementNotification(
                "Hard Challenger",
                "You completed Level 3!"
        );
    }

    if (easyCompleted && mediumCompleted && hardCompleted) {
        showAchievementNotification(
                "Challenge Master",
                "You completed all three Challenge levels!"
        );
    }

    // Bible Journey achievements
    int journeyQuestions = prefs.getInt(
            "bibleJourney_questions_completed", 0
    );

    int journeyBooks = prefs.getInt(
            "bibleJourney_books_completed", 0
    );

    if (journeyQuestions >= 100) {
        showAchievementNotification(
                "100 Questions",
                "You completed 100 Bible Journey questions!"
        );
    }

    if (journeyQuestions >= 250) {
        showAchievementNotification(
                "250 Questions",
                "You completed 250 Bible Journey questions!"
        );
    }

    if (journeyQuestions >= 500) {
        showAchievementNotification(
                "500 Questions",
                "You completed 500 Bible Journey questions!"
        );
    }

    if (journeyQuestions >= 1000) {
        showAchievementNotification(
                "1,000 Questions",
                "You completed 1,000 Bible Journey questions!"
        );
    }

    if (journeyBooks >= 5) {
        showAchievementNotification(
                "5 Books",
                "You completed 5 Bible Journey books!"
        );
    }

    if (journeyBooks >= 10) {
        showAchievementNotification(
                "10 Books",
                "You completed 10 Bible Journey books!"
        );
    }

    if (journeyBooks >= 25) {
        showAchievementNotification(
                "25 Books",
                "You completed 25 Bible Journey books!"
        );
    }

    if (journeyBooks >= 50) {
        showAchievementNotification(
                "50 Books",
                "You completed 50 Bible Journey books!"
        );
    }

    if (journeyBooks >= 66) {
        showAchievementNotification(
                "66 Books",
                "You completed all 66 Bible Journey books!"
        );
    }

    // Bible Scramble achievements
    int scrambleWordsSolved = prefs.getInt(
            "bibleScramble_words_solved", 0
    );

    if (scrambleWordsSolved >= 10) {
        showAchievementNotification(
                "The Scrambled Achiever",
                "You solved 10 different Bible Scramble words!"
        );
    }

    if (scrambleWordsSolved >= 25) {
        showAchievementNotification(
                "Master of Letters",
                "You solved 25 different Bible Scramble words!"
        );
    }

    if (scrambleWordsSolved >= 75) {
        showAchievementNotification(
                "The Word Unraveller",
                "You solved all 75 Bible Scramble words!"
        );
    }

    // NEW ACHIEVEMENT: The Big Picture
    android.content.SharedPreferences jigsawPrefs =
            getSharedPreferences(
                    "KingdomLifeJigsawPrefs",
                    MODE_PRIVATE
            );

    boolean jigsawLevel1 = jigsawPrefs.getBoolean(
            "level1RewardClaimed", false
    );

    boolean jigsawLevel2 = jigsawPrefs.getBoolean(
            "level2RewardClaimed", false
    );

    boolean jigsawLevel3 = jigsawPrefs.getBoolean(
            "level3RewardClaimed", false
    );

    if (jigsawLevel1 && jigsawLevel2 && jigsawLevel3) {
        showAchievementNotification(
                "The Big Picture",
                "You completed all three Jigsaw Puzzle levels!"
        );
    }

    // NEW ACHIEVEMENT: The Word Hearer
    int missingWordCorrect = prefs.getInt(
            "missingWord_correct_answers", 0
    );

    if (missingWordCorrect >= 25) {
        showAchievementNotification(
                "The Word Hearer",
                "You answered 25 Missing Word questions correctly!"
        );
    }

    // NEW ACHIEVEMENT: The Scripture Detective
    int referenceCorrect = prefs.getInt(
            "memory_reference_correct_answers", 0
    );

    if (referenceCorrect >= 25) {
        showAchievementNotification(
                "The Scripture Detective",
                "You answered 25 Guess the Reference questions correctly!"
        );
    }

    // NEW ACHIEVEMENT: The Verse Guardian
    int guessVerseCorrect = prefs.getInt(
            "memory_guess_correct_answers", 0
    );

    if (guessVerseCorrect >= 25) {
        showAchievementNotification(
                "The Verse Guardian",
                "You answered 25 Guess the Verse questions correctly!"
        );
    }

    // NEW ACHIEVEMENT: The Verse Finisher
    int completeVerseCorrect = prefs.getInt(
            "memory_complete_correct_answers", 0
    );

    if (completeVerseCorrect >= 25) {
        showAchievementNotification(
                "The Verse Finisher",
                "You completed 25 verses correctly!"
        );
    }
    }
    
void showAchievementNotification(
String name,
String message) {

    String notificationKey = "notified_" + name;

    if (prefs.getBoolean(notificationKey, false)) {
        return;
    }

    prefs.edit()
            .putBoolean(notificationKey, true)
            .apply();

    final int royalPurple =
            android.graphics.Color.rgb(30, 24, 55);

    final int kingdomGold =
            android.graphics.Color.rgb(184, 134, 11);

    android.widget.LinearLayout card =
            new android.widget.LinearLayout(this);

    card.setOrientation(
            android.widget.LinearLayout.VERTICAL
    );

    card.setGravity(android.view.Gravity.CENTER);
    card.setPadding(32, 30, 32, 26);

    android.graphics.drawable.GradientDrawable cardBackground =
            new android.graphics.drawable.GradientDrawable();

    cardBackground.setColor(royalPurple);
    cardBackground.setCornerRadius(24);
    cardBackground.setStroke(2, kingdomGold);

    card.setBackground(cardBackground);

    android.widget.TextView trophy =
            new android.widget.TextView(this);

    trophy.setText("🏆");
    trophy.setTextSize(44);
    trophy.setGravity(android.view.Gravity.CENTER);

    android.widget.TextView congratulations =
            new android.widget.TextView(this);

    congratulations.setText("🎉 Congratulations! 🎉");
    congratulations.setTextSize(22);
    congratulations.setTypeface(
            null, android.graphics.Typeface.BOLD
    );
    congratulations.setTextColor(kingdomGold);
    congratulations.setGravity(android.view.Gravity.CENTER);
    congratulations.setPadding(0, 12, 0, 16);

    android.widget.TextView achievementTitle =
            new android.widget.TextView(this);

    achievementTitle.setText("ACHIEVEMENT UNLOCKED");
    achievementTitle.setTextSize(13);
    achievementTitle.setTypeface(
            null, android.graphics.Typeface.BOLD
    );
    achievementTitle.setTextColor(
            android.graphics.Color.WHITE
    );
    achievementTitle.setGravity(android.view.Gravity.CENTER);

    android.widget.TextView achievementName =
            new android.widget.TextView(this);

    achievementName.setText(name);
    achievementName.setTextSize(24);
    achievementName.setTypeface(
            null, android.graphics.Typeface.BOLD
    );
    achievementName.setTextColor(kingdomGold);
    achievementName.setGravity(android.view.Gravity.CENTER);
    achievementName.setPadding(0, 12, 0, 14);

    android.widget.TextView comment =
            new android.widget.TextView(this);

    comment.setText(message);
    comment.setTextSize(16);
    comment.setTextColor(android.graphics.Color.WHITE);
    comment.setGravity(android.view.Gravity.CENTER);
    comment.setPadding(4, 0, 4, 18);

    card.addView(trophy);
    card.addView(congratulations);
    card.addView(achievementTitle);
    card.addView(achievementName);
    card.addView(comment);

    android.app.AlertDialog dialog =
            new android.app.AlertDialog.Builder(this)
                    .setView(card)
                    .setPositiveButton(
                            "CONTINUE",
                            (d, which) -> d.dismiss()
                    )
                    .create();

    dialog.setOnShowListener(d -> {
        dialog.getButton(
                android.app.AlertDialog.BUTTON_POSITIVE
        ).setTextColor(kingdomGold);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(
                    new android.graphics.drawable.ColorDrawable(
                            android.graphics.Color.TRANSPARENT
                    )
            );
        }
    });

    dialog.show();

    if (dialog.getWindow() != null) {
        dialog.getWindow().setBackgroundDrawable(
                new android.graphics.drawable.ColorDrawable(
                        android.graphics.Color.TRANSPARENT
                )
        );

        dialog.getWindow().setDimAmount(0.65f);
    }

    android.view.View decorView =
            dialog.getWindow().getDecorView();

    decorView.setAlpha(0f);
    decorView.setScaleX(0.85f);
    decorView.setScaleY(0.85f);

    decorView.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(350)
            .start();
            android.view.ViewGroup rootContainer =
                (android.view.ViewGroup)
                        decorView.getRootView();

        decorView.postDelayed(() -> {
            playAchievementCelebration(rootContainer);
        }, 200);
}
    void playAchievementCelebration(
        android.view.ViewGroup container) {

    final String[] effects = {
            "✨", "⭐", "🌟", "🎉", "💛", "🏆"
    };

    for (int i = 0; i < 16; i++) {

        final android.widget.TextView sparkle =
                new android.widget.TextView(this);

        sparkle.setText(
                effects[i % effects.length]
        );

        sparkle.setTextSize(22);

        android.widget.FrameLayout.LayoutParams params =
                new android.widget.FrameLayout.LayoutParams(
                        android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                        android.view.ViewGroup.LayoutParams.WRAP_CONTENT
                );

        params.gravity = android.view.Gravity.TOP
                | android.view.Gravity.CENTER_HORIZONTAL;

        sparkle.setTranslationX(
                (i - 8) * 30f
        );

        container.addView(sparkle, params);

        android.view.animation.Animation fall =
                new android.view.animation.TranslateAnimation(
                        0, (i % 2 == 0 ? 45 : -45),
                        -30, 260 + (i % 5) * 35
                );

        fall.setDuration(1400 + (i % 4) * 200);
        fall.setStartOffset(i * 65L);
        fall.setFillAfter(false);

        fall.setAnimationListener(
                new android.view.animation.Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(
                            android.view.animation.Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(
                            android.view.animation.Animation animation) {
                        container.removeView(sparkle);
                    }

                    @Override
                    public void onAnimationRepeat(
                            android.view.animation.Animation animation) {
                    }
                }
        );

        sparkle.startAnimation(fall);
    }
    }
    

    void showAbout() {
        showMessage(
                "ℹ️ About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, " +
                        "prayer, reflection, daily challenges, and fun Bible activities.\n\n" +
                        "Version 5"
        );
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
    instruction.setText("Choose a game category:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    addButton("🧩 Puzzle", v -> showPuzzleMenu());
    addButton("📖 Bible Quiz", v -> showBibleQuizMenu());
    addButton("⬅️ Back to Home", v -> showHome());
}

public void showPuzzleMenu() {
    stopTimer();
    content.removeAllViews();

    // Top-left back arrow
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);
    backButton.setContentDescription("Back to Categories");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );
    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(v -> showGameMenu());

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);
    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    // Title
    TextView title = new TextView(this);
    title.setText("🧩 Puzzle");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    // Existing puzzle options
    addButton("🧩 Jigsaw Puzzle", v -> showJigsawMenu());
    addButton("🔤 Missing Word", v -> showMissingWord());
    addButton("🔀 Bible Scramble", v -> showBibleScramble());
}

void showBibleQuizMenu() {
    stopTimer();
    content.removeAllViews();

    // Top-left back arrow
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setScaleX(1.5f);
    backButton.setScaleY(1.5f);
    backButton.setContentDescription("Back to Categories");
    backButton.setBackgroundColor(
            android.graphics.Color.TRANSPARENT
    );
    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(v -> showGameMenu());

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);
    backParams.gravity = Gravity.LEFT;

    content.addView(backButton, backParams);

    // Title
    TextView title = new TextView(this);
    title.setText("📖 Bible Quiz");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    // Existing quiz options
    addButton("🧠 Bible Challenge", v -> showBibleChallenge());
    addButton("📖 Bible Journey", v -> showBibleJourney());
                      }

public void showJigsawMenu() {
    stopTimer();

    BibleJigsawPuzzle jigsaw =
            new BibleJigsawPuzzle(this);

    jigsaw.showJigsawMenu();
}
    void showBibleJourney() {
    showBibleJourneyOldTestament();
    }
    private boolean handleBibleJourneySwipe(
        View v,
        MotionEvent event
) {
    switch (event.getAction()) {

        case MotionEvent.ACTION_DOWN:

            bibleJourneyTouchX =
                    event.getX();

            return true;

        case MotionEvent.ACTION_UP:

            float difference =
                    event.getX()
                    - bibleJourneyTouchX;

            if (Math.abs(difference) > 100) {

                if (difference < 0) {
                    showBibleJourneyNewTestament();
                } else {
                    showBibleJourneyOldTestament();
                }

                return true;
            }

            v.performClick();
            return true;
    }

    return true;
    }
    void showBibleJourneyOldTestament() {
    stopTimer();
    content.removeAllViews();
        
    ImageButton backButton = new ImageButton(this);

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
    TextView title = new TextView(this);
    title.setText("📜 Old Testament");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 20);
    content.addView(title);

    String[] books = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    int completedBooks =
            prefs.getInt(
                    "bibleJourney_books_completed",
                    0
            );
        String pendingBookAnimation = prefs.getString(
        "bibleJourney_pendingBookAnimation",
        ""
);

    for (int i = 0; i < books.length; i += 2) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, 5, 0, 5);

        String book1 = books[i];

        Button button1 = new Button(this);
        button1.setText(book1);
        button1.setTextSize(15);
        button1.setAllCaps(false);

        if (isBibleJourneyBookUnlocked(book1)) {

    if (i == completedBooks) {
        button1.setBackgroundColor(
                Color.rgb(255, 152, 0)
        );
    }

    button1.setOnClickListener(
            v -> showBookDifficulty(book1)
    );

    button1.setOnTouchListener(
            this::handleBibleJourneySwipe
    );
            if (book1.equals(pendingBookAnimation)) {
    animateBibleJourneyBookUnlock(button1, book1);

    prefs.edit()
            .remove("bibleJourney_pendingBookAnimation")
            .apply();

    pendingBookAnimation = "";
            }

} else {

    button1.setText("🔒 " + book1);

    button1.setOnClickListener(v -> {});
        }

        row.addView(
                button1,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        if (i + 1 < books.length) {

            String book2 = books[i + 1];

            Button button2 = new Button(this);
            button2.setText(book2);
            button2.setTextSize(15);
            button2.setAllCaps(false);

            if (isBibleJourneyBookUnlocked(book2)) {

                if (i + 1 == completedBooks) {
                    button2.setBackgroundColor(
                            Color.rgb(255, 152, 0)
                    );
                }

                button2.setOnClickListener(
                        v -> showBookDifficulty(book2)
                );
                button2.setOnTouchListener(
        this::handleBibleJourneySwipe
);
                if (book2.equals(pendingBookAnimation)) {
    animateBibleJourneyBookUnlock(button2, book2);

    prefs.edit()
            .remove("bibleJourney_pendingBookAnimation")
            .apply();

    pendingBookAnimation = "";
                }

            } else {

                button2.setText("🔒 " + book2);
                button2.setOnClickListener(v -> {});
            }

            row.addView(
                    button2,
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    )
            );
        }

            content.addView(row);
    }

    
    }
    
    
                    void showBibleJourneyNewTestament() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);
    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setOnClickListener(v -> showGameMenu());

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(60, 60)
    );

    TextView title = new TextView(this);
    title.setText("✝️ New Testament");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 20);
    content.addView(title);

    String[] books = {
            "Matthew", "Mark",
            "Luke", "John",
            "Acts", "Romans",
            "1 Corinthians", "2 Corinthians",
            "Galatians", "Ephesians",
            "Philippians", "Colossians",
            "1 Thessalonians", "2 Thessalonians",
            "1 Timothy", "2 Timothy",
            "Titus", "Philemon",
            "Hebrews", "James",
            "1 Peter", "2 Peter",
            "1 John", "2 John",
            "3 John", "Jude",
            "Revelation"
    };

    for (int i = 0; i < books.length; i += 2) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, 5, 0, 5);

        String book1 = books[i];

        Button button1 = new Button(this);
        boolean unlocked1 = isBibleJourneyBookUnlocked(book1);

        button1.setText(
                unlocked1 ? book1 : "🔒 " + book1
        );
        button1.setTextSize(15);
        button1.setAllCaps(false);
        button1.setTextColor(android.graphics.Color.BLACK);
button1.setBackgroundTintList(
        android.content.res.ColorStateList.valueOf(
                unlocked1
                        ? android.graphics.Color.rgb(255, 152, 0)
                        : android.graphics.Color.LTGRAY
        )
);
        button1.setEnabled(unlocked1);

        if (unlocked1) {
            button1.setOnClickListener(
                    v -> showBookDifficulty(book1)
            );
            button1.setOnTouchListener(
                    this::handleBibleJourneySwipe
            );
        }

        row.addView(
                button1,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        if (i + 1 < books.length) {

            String book2 = books[i + 1];

            Button button2 = new Button(this);
            boolean unlocked2 = isBibleJourneyBookUnlocked(book2);

            button2.setText(
                    unlocked2 ? book2 : "🔒 " + book2
            );
            button2.setTextSize(15);
            button2.setAllCaps(false);
            button2.setTextColor(android.graphics.Color.BLACK);
button2.setBackgroundTintList(
        android.content.res.ColorStateList.valueOf(
                unlocked2
                        ? android.graphics.Color.rgb(255, 152, 0)
                        : android.graphics.Color.LTGRAY
        )
);
            button2.setEnabled(unlocked2);

            if (unlocked2) {
                button2.setOnClickListener(
                        v -> showBookDifficulty(book2)
                );
                button2.setOnTouchListener(
                        this::handleBibleJourneySwipe
                );
            }

            row.addView(
                    button2,
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    )
            );
        }

        content.addView(row);
    }
                    }

    
    boolean isBibleJourneyDifficultyUnlocked(
        String book,
        String difficulty
) {
    if (difficulty.equals("Easy")) {
        return true;
    }

    String key =
            "bibleJourney_" +
            book +
            "_" +
            difficulty +
            "_unlocked";

    return prefs.getBoolean(key, false);
}

void unlockBibleJourneyDifficulty(
        String book,
        String difficulty
) {
    String key =
            "bibleJourney_" +
            book +
            "_" +
            difficulty +
            "_unlocked";

    String animationKey =
            "bibleJourney_" +
            book +
            "_pendingDifficultyAnimation";

    prefs.edit()
            .putBoolean(key, true)
            .putString(animationKey, difficulty)
            .apply();
}
    boolean isBibleJourneyBookUnlocked(String book) {
    if (book.equals("Genesis")) {
        return true;
    }

    String[] oldTestamentBooks = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    return prefs.getBoolean(
            "bibleJourney_" + book + "_book_unlocked",
            false
    );
    }
    boolean isBibleJourneyDifficultyCompleted(
        String book,
        String difficulty
) {
    String key = "bibleJourney_" + book + "_" + difficulty + "_completed";

    return prefs.getBoolean(key, false);
    }
    
    void showBookDifficulty(String book) {
    stopTimer();
    content.removeAllViews();
        
    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> {

                String[] newTestamentBooks = {
                        "Matthew", "Mark",
                        "Luke", "John",
                        "Acts", "Romans",
                        "1 Corinthians", "2 Corinthians",
                        "Galatians", "Ephesians",
                        "Philippians", "Colossians",
                        "1 Thessalonians", "2 Thessalonians",
                        "1 Timothy", "2 Timothy",
                        "Titus", "Philemon",
                        "Hebrews", "James",
                        "1 Peter", "2 Peter",
                        "1 John", "2 John",
                        "3 John", "Jude",
                        "Revelation"
                };

                boolean isNewTestament = false;

                for (String ntBook : newTestamentBooks) {

                    if (book.equals(ntBook)) {
                        isNewTestament = true;
                        break;
                    }
                }

                if (isNewTestament) {
                    showBibleJourneyNewTestament();
                } else {
                    showBibleJourneyOldTestament();
                }
            }
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );
    TextView title = new TextView(this);
    title.setText("📖 " + book);
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 10);
    content.addView(title);
        
    
    TextView info = new TextView(this);
    info.setText("Choose your difficulty");
    info.setTextSize(18);
    info.setTextColor(darkText);
    info.setGravity(Gravity.CENTER);
    info.setPadding(0, 0, 0, 20);
    content.addView(info);

    String animationKey =
        "bibleJourney_" +
        book +
        "_pendingDifficultyAnimation";

String pendingDifficulty =
        prefs.getString(animationKey, "");

String[] difficulties = {
        "Easy", "Medium", "Hard", "Scholar"
};

String[] labels = {
        "🟢 Easy", "🔵 Medium",
        "🟠 Hard", "🟣 Scholar"
};

for (int i = 0; i < difficulties.length; i++) {
    final String difficulty = difficulties[i];

    boolean isUnlocked =
            isBibleJourneyDifficultyUnlocked(
                    book, difficulty);

    boolean shouldAnimate =
            difficulty.equals(pendingDifficulty)
                    && isUnlocked;

    String buttonText = isUnlocked
            ? labels[i]
            : "🔒 " + difficulties[i];

    addAnimatedUnlockButton(
            buttonText,
            difficulty,
            isUnlocked,
            shouldAnimate,
            v -> {
                if (isUnlocked) {
                    startBibleJourney(book, difficulty);
                }
            },
            shouldAnimate
                    ? () -> prefs.edit()
                            .remove(animationKey)
                            .apply()
                    : null
    );
                    }
    
    }
    void startBibleJourney(String book, String difficulty) {
    stopTimer();

    currentBibleBook = book;
    currentBibleDifficulty = difficulty;

    bibleJourneyQuestion = 0;
    bibleJourneyScore = 0;

    if (book.equals("Genesis")) {
        loadGenesisQuestions(difficulty);
    }else {
    bibleJourneyQuestions.clear();
    bibleJourneyOptions.clear();
    bibleJourneyAnswers.clear();

    ArrayList<BibleJourneyData.Question> questions =
            BibleJourneyData.getQuestions(book, difficulty);

    for (BibleJourneyData.Question q : questions) {
        bibleJourneyQuestions.add(q.question);
        bibleJourneyOptions.add(q.options);
        bibleJourneyAnswers.add(q.answer);
    }

    if (questions.isEmpty()) {
        bibleJourneyQuestions.add(
                "Questions for " + book +
                " (" + difficulty + ") are coming soon."
        );

        bibleJourneyOptions.add(new String[]{
                "Continue",
                "Back",
                "Bible Journey",
                "Home"
        });

        bibleJourneyAnswers.add(0);
    }
    }
    showBibleJourneyQuestion();
    }
    void showBibleJourneyQuestion() {
    content.removeAllViews();

    if (bibleJourneyQuestions.isEmpty()) {
        TextView empty = new TextView(this);
        empty.setText("No questions available.");
        empty.setTextSize(20);
        empty.setTextColor(darkText);
        content.addView(empty);

        addButton("⬅️ Back", v -> showBookDifficulty(
                currentBibleBook
        ));
        return;
    }

    TextView title = new TextView(this);
    title.setText("📖 " + currentBibleBook);
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView difficulty = new TextView(this);
    difficulty.setText(
            "Difficulty: " + currentBibleDifficulty
    );
    difficulty.setTextSize(17);
    difficulty.setTextColor(darkText);
    difficulty.setGravity(Gravity.CENTER);
    difficulty.setPadding(0, 0, 0, 15);
    content.addView(difficulty);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " +
            (bibleJourneyQuestion + 1) +
            " of " +
            bibleJourneyQuestions.size()
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setGravity(Gravity.CENTER);
    progress.setPadding(0, 0, 0, 20);
    content.addView(progress);

    TextView question = new TextView(this);

answered = false;

question.setText(
bibleJourneyQuestions.get(bibleJourneyQuestion)
);

question.setTextSize(21);

question.setTypeface(
Typeface.DEFAULT,
Typeface.BOLD
);

question.setTextColor(android.graphics.Color.WHITE);
question.setGravity(Gravity.CENTER);
question.setPadding(16, 24, 16, 24);

android.graphics.drawable.GradientDrawable questionBackground =
new android.graphics.drawable.GradientDrawable();

questionBackground.setColor(
android.graphics.Color.rgb(30, 24, 55)
);

questionBackground.setCornerRadius(24);

questionBackground.setStroke(
3,
android.graphics.Color.rgb(212, 175, 55)
);

question.setBackground(questionBackground);

LinearLayout.LayoutParams questionParams =
new LinearLayout.LayoutParams(
LinearLayout.LayoutParams.MATCH_PARENT,
LinearLayout.LayoutParams.WRAP_CONTENT
);

questionParams.setMargins(0, 8, 0, 16);

content.addView(question, questionParams);
    String[] options =
bibleJourneyOptions.get(bibleJourneyQuestion);

Button[] answerButtons = new Button[options.length];

for (int i = 0; i < options.length; i++) {

final int selectedAnswer = i;

answerButtons[i] = new Button(this);

answerButtons[i].setText(
        (i + 1) + ". " + options[i]
);

answerButtons[i].setTextSize(16);
answerButtons[i].setTextColor(
        android.graphics.Color.WHITE
);
answerButtons[i].setAllCaps(false);

android.graphics.drawable.GradientDrawable optionBackground =
        new android.graphics.drawable.GradientDrawable();

optionBackground.setColor(
        android.graphics.Color.rgb(30, 24, 55)
);

optionBackground.setCornerRadius(24);

optionBackground.setStroke(
        2,
        android.graphics.Color.rgb(212, 175, 55)
);

answerButtons[i].setBackground(optionBackground);

LinearLayout.LayoutParams optionParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

optionParams.setMargins(0, 5, 0, 5);

content.addView(answerButtons[i], optionParams);

answerButtons[i].setOnClickListener(v ->
        checkBibleJourneyAnswer(
                selectedAnswer,
                answerButtons
        )
);

}

    android.widget.ImageButton backButton =
        new android.widget.ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setScaleX(1.5f);
backButton.setScaleY(1.5f);

backButton.setContentDescription("Back to difficulty selection");

backButton.setBackgroundColor(
        android.graphics.Color.TRANSPARENT
);

backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v ->
        showBookDifficulty(currentBibleBook)
);

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);

backParams.gravity = Gravity.LEFT;

content.addView(backButton, 0, backParams);
        }
    
    void checkBibleJourneyAnswer(
int selectedAnswer,
Button[] answerButtons
) {

if (answered) {
    return;
}

answered = true;

int correctAnswer =
        bibleJourneyAnswers.get(bibleJourneyQuestion);

boolean isCorrect = selectedAnswer == correctAnswer;

TextView feedback = new TextView(this);

feedback.setTextSize(19);
feedback.setTypeface(
        Typeface.DEFAULT,
        Typeface.BOLD
);
feedback.setTextColor(android.graphics.Color.WHITE);
feedback.setGravity(Gravity.CENTER);
feedback.setPadding(16, 18, 16, 18);

if (isCorrect) {

    bibleJourneyScore += 5;
    totalPoints += 5;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    checkAchievementNotifications();

    feedback.setText("Correct! +5 points");

} else {

    feedback.setText(
            "Incorrect!\n\n" +
            "The correct answer was:\n" +
            bibleJourneyOptions
                    .get(bibleJourneyQuestion)
                    [correctAnswer]
    );
}

android.graphics.drawable.GradientDrawable feedbackBackground =
        new android.graphics.drawable.GradientDrawable();

feedbackBackground.setColor(
        isCorrect
                ? android.graphics.Color.rgb(35, 120, 65)
                : android.graphics.Color.rgb(150, 45, 45)
);

feedbackBackground.setCornerRadius(24);

feedbackBackground.setStroke(
        2,
        android.graphics.Color.rgb(212, 175, 55)
);

feedback.setBackground(feedbackBackground);

content.addView(feedback, 5);

for (int i = 0; i < answerButtons.length; i++) {

    int buttonColor =
            android.graphics.Color.rgb(30, 24, 55);

    if (i == correctAnswer) {
        buttonColor =
                android.graphics.Color.rgb(35, 120, 65);
    }

    if (i == selectedAnswer && !isCorrect) {
        buttonColor =
                android.graphics.Color.rgb(150, 45, 45);
    }

    android.graphics.drawable.GradientDrawable answerBackground =
            new android.graphics.drawable.GradientDrawable();

    answerBackground.setColor(buttonColor);
    answerBackground.setCornerRadius(24);

    answerBackground.setStroke(
            2,
            android.graphics.Color.rgb(212, 175, 55)
    );

    answerButtons[i].setBackground(answerBackground);
    answerButtons[i].setTextColor(
            android.graphics.Color.WHITE
    );
    answerButtons[i].setEnabled(false);
}

addButton("Next Question", v -> {

    if (bibleJourneyQuestion <
            bibleJourneyQuestions.size() - 1) {

        bibleJourneyQuestion++;
        showBibleJourneyQuestion();

    } else {

        showBibleJourneyResult();
    }
});

    }
    
    void showBibleJourneyResult() {

    stopTimer();
    content.removeAllViews();
        
    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showBookDifficulty(currentBibleBook)
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );
    TextView title = new TextView(this);
    title.setText("🏆 Bible Journey Complete!");
    title.setTextSize(26);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    content.addView(title);

    TextView book = new TextView(this);
    book.setText(
            "📖 " + currentBibleBook +
            "\nDifficulty: " +
            currentBibleDifficulty
    );
    book.setTextSize(18);
    book.setTextColor(darkText);
    book.setGravity(Gravity.CENTER);
    book.setPadding(0, 0, 0, 20);
    content.addView(book);
        
        
    // Record this difficulty as completed only once.
String completedKey =
        "bibleJourney_" + currentBibleBook + "_"
        + currentBibleDifficulty + "_completed";

boolean alreadyCompleted =
        prefs.getBoolean(completedKey, false);

if (!alreadyCompleted) {

    prefs.edit()
            .putBoolean(completedKey, true)
            .apply();

    // Count completed questions only once per difficulty.
    int completedJourneyQuestions =
            prefs.getInt("bibleJourney_questions_completed", 0);

    completedJourneyQuestions += 25;

    prefs.edit()
            .putInt(
                    "bibleJourney_questions_completed",
                    completedJourneyQuestions
            )
            .apply();
    checkAchievementNotifications();
}

// Unlock the next difficulty.
if (currentBibleDifficulty.equals("Easy")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Medium"
    );

} else if (currentBibleDifficulty.equals("Medium")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Hard"
    );

} else if (currentBibleDifficulty.equals("Hard")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Scholar"
    );
}

// Check whether all four difficulties are completed.
String[] difficulties = {
        "Easy", "Medium", "Hard", "Scholar"
};
boolean allDifficultiesCompleted = true;

for (String difficulty : difficulties) {

    if (!isBibleJourneyDifficultyCompleted(
            currentBibleBook,
            difficulty
    )) {
        allDifficultiesCompleted = false;
        break;
    }
}

if (allDifficultiesCompleted) {

    String[] oldTestamentBooks = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    int bookIndex = -1;

    for (int i = 0; i < oldTestamentBooks.length; i++) {
        if (currentBibleBook.equals(oldTestamentBooks[i])) {
            bookIndex = i;
            break;
        }
    }

    // Unlock the next Old Testament book.
    if (bookIndex >= 0
            && bookIndex < oldTestamentBooks.length - 1) {

        String nextBook = oldTestamentBooks[bookIndex + 1];

prefs.edit()
        .putBoolean(
                "bibleJourney_" + nextBook + "_book_unlocked",
                true
        )
        .putString(
                "bibleJourney_pendingBookAnimation",
                nextBook
        )
        .apply();
    }

    // If all 39 Old Testament books are complete,
    // unlock all 27 New Testament books.
    boolean allOldTestamentCompleted = true;

    for (String oldBook : oldTestamentBooks) {

        for (String difficulty : difficulties) {

            if (!isBibleJourneyDifficultyCompleted(
                    oldBook,
                    difficulty
            )) {
                allOldTestamentCompleted = false;
                break;
            }
        }

        if (!allOldTestamentCompleted) {
            break;
        }
    }

    if (allOldTestamentCompleted) {

        String[] newTestamentBooks = {
                "Matthew", "Mark", "Luke", "John",
                "Acts", "Romans", "1 Corinthians",
                "2 Corinthians", "Galatians", "Ephesians",
                "Philippians", "Colossians",
                "1 Thessalonians", "2 Thessalonians",
                "1 Timothy", "2 Timothy", "Titus",
                "Philemon", "Hebrews", "James",
                "1 Peter", "2 Peter", "1 John",
                "2 John", "3 John", "Jude", "Revelation"
        };

        android.content.SharedPreferences.Editor editor =
                prefs.edit();

        for (String newBook : newTestamentBooks) {
            editor.putBoolean(
                    "bibleJourney_" + newBook + "_book_unlocked",
                    true
            );
        }

        editor.apply();
    }

    // Update the completed-book count without duplicates.
    int completedJourneyBooks = 0;

    for (String oldBook : oldTestamentBooks) {

        boolean bookComplete = true;

        for (String difficulty : difficulties) {

            if (!isBibleJourneyDifficultyCompleted(
                    oldBook,
                    difficulty
            )) {
                bookComplete = false;
                break;
            }
        }

        if (bookComplete) {
            completedJourneyBooks++;
        }
    }

    prefs.edit()
            .putInt(
                    "bibleJourney_books_completed",
                    completedJourneyBooks
            )
            .apply();
    checkAchievementNotifications();
}
    
    TextView scoreText = new TextView(this);
    scoreText.setText(
            "⭐ Score: " +
            bibleJourneyScore
    );
    scoreText.setTextSize(23);
    scoreText.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    scoreText.setTextColor(darkText);
    scoreText.setGravity(Gravity.CENTER);
    scoreText.setPadding(0, 10, 0, 25);
    content.addView(scoreText);

    addButton(
            "🔄 Play Again",
            v -> startBibleJourney(
                    currentBibleBook,
                    currentBibleDifficulty
            )
    );

    addButton(
            "📖 Choose Another Book",
            v -> showBibleJourney()
    );

    
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
        android.widget.ImageButton backButton =
        new android.widget.ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setScaleX(1.5f);
backButton.setScaleY(1.5f);

backButton.setContentDescription(
        "Exit Bible Challenge"
);

backButton.setBackgroundColor(
        android.graphics.Color.TRANSPARENT
);

backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v -> {
    stopTimer();
    showBibleQuizMenu();
});

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);

backParams.gravity = Gravity.LEFT;

content.addView(backButton, backParams);

        answered = false;
        int questionCount;

if (currentLevel == 2) {
    questionCount = level2Questions.length;
} else if (currentLevel == 3) {
    questionCount = level3Questions.length;
} else if (currentLevel == 4) {
    questionCount = BibleChallengeData.level4Questions.length;
} else if (currentLevel == 5) {
    questionCount = BibleChallengeData.level5Questions.length;
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
} else if (currentLevel == 4) {
    question.setText(BibleChallengeData.level4Questions[currentQuestion]);
} else if (currentLevel == 5) {
    question.setText(BibleChallengeData.level5Questions[currentQuestion]);
} else {
    question.setText(questions[currentQuestion]);
}
        question.setTextSize(22);
question.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
question.setTextColor(android.graphics.Color.WHITE);
question.setGravity(Gravity.CENTER);
question.setPadding(16, 24, 16, 24);

android.graphics.drawable.GradientDrawable questionBackground =
        new android.graphics.drawable.GradientDrawable();

questionBackground.setColor(
        android.graphics.Color.rgb(30, 24, 55)
);

questionBackground.setCornerRadius(24);

questionBackground.setStroke(
        3,
        android.graphics.Color.rgb(212, 175, 55)
);

question.setBackground(questionBackground);

LinearLayout.LayoutParams questionParams =
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

questionParams.setMargins(0, 8, 0, 16);

content.addView(question, questionParams);

        Button[] answerButtons = new Button[4];

        for (int i = 0; i < 4; i++) {
            final int selected = i;

            answerButtons[i] = new Button(this);
            if (currentLevel == 2) {
    answerButtons[i].setText(level2Options[currentQuestion][i]);
} else if (currentLevel == 3) {
    answerButtons[i].setText(level3Options[currentQuestion][i]);
} else if (currentLevel == 4) {
    answerButtons[i].setText(BibleChallengeData.level4Options[currentQuestion][i]);
} else if (currentLevel == 5) {
    answerButtons[i].setText(BibleChallengeData.level5Options[currentQuestion][i]);
} else {
    answerButtons[i].setText(options[currentQuestion][i]);
            }
            answerButtons[i].setTextSize(17);
            answerButtons[i].setTextColor(
        android.graphics.Color.WHITE
);

answerButtons[i].setAllCaps(false);

android.graphics.drawable.GradientDrawable optionBackground =
        new android.graphics.drawable.GradientDrawable();

optionBackground.setColor(
        android.graphics.Color.rgb(30, 24, 55)
);

optionBackground.setCornerRadius(24);

optionBackground.setStroke(
        2,
        android.graphics.Color.rgb(212, 175, 55)
);

answerButtons[i].setBackground(optionBackground);

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
} else if (currentLevel == 4) {
    correctOption = BibleChallengeData.level4Options[currentQuestion]
            [BibleChallengeData.level4Answers[currentQuestion]];
} else if (currentLevel == 5) {
    correctOption = BibleChallengeData.level5Options[currentQuestion]
            [BibleChallengeData.level5Answers[currentQuestion]];
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
} else if (currentLevel == 4) {
    correctAnswer = BibleChallengeData.level4Answers[currentQuestion];
} else if (currentLevel == 5) {
    correctAnswer = BibleChallengeData.level5Answers[currentQuestion];
} else {
    correctAnswer = answers[currentQuestion];
}

boolean isCorrect = selected == correctAnswer;

if (isCorrect) {
    score += 10;
    totalPoints += 10;
    correctAnswers++;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    checkAchievementNotifications();

    feedback.setText("Correct! +10 points");

} else {
    wrongAnswers++;

    String correctOption;

    if (currentLevel == 2) {
    correctOption =
            level2Options[currentQuestion][level2Answers[currentQuestion]];
} else if (currentLevel == 3) {
    correctOption =
            level3Options[currentQuestion][level3Answers[currentQuestion]];
} else if (currentLevel == 4) {
    correctOption =
            BibleChallengeData.level4Options[currentQuestion]
                    [BibleChallengeData.level4Answers[currentQuestion]];
} else if (currentLevel == 5) {
    correctOption =
            BibleChallengeData.level5Options[currentQuestion]
                    [BibleChallengeData.level5Answers[currentQuestion]];
} else {
    correctOption =
            options[currentQuestion][answers[currentQuestion]];
    }

    feedback.setText("Wrong! Correct answer: " + correctOption);
}

feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
feedback.setTextColor(android.graphics.Color.WHITE);
feedback.setGravity(Gravity.CENTER);
feedback.setPadding(16, 18, 16, 18);

android.graphics.drawable.GradientDrawable feedbackBackground =
        new android.graphics.drawable.GradientDrawable();

feedbackBackground.setColor(
        isCorrect
                ? android.graphics.Color.rgb(35, 120, 65)
                : android.graphics.Color.rgb(150, 45, 45)
);

feedbackBackground.setCornerRadius(24);

feedbackBackground.setStroke(
        2,
        android.graphics.Color.rgb(212, 175, 55)
);

feedback.setBackground(feedbackBackground);

content.addView(feedback, 3);

for (int i = 0; i < buttons.length; i++) {
    int buttonColor = android.graphics.Color.rgb(30, 24, 55);

    if (i == correctAnswer) {
        buttonColor = android.graphics.Color.rgb(35, 120, 65);
    }

    if (i == selected && !isCorrect) {
        buttonColor = android.graphics.Color.rgb(150, 45, 45);
    }

    android.graphics.drawable.GradientDrawable answerBackground =
            new android.graphics.drawable.GradientDrawable();

    answerBackground.setColor(buttonColor);
    answerBackground.setCornerRadius(24);

    answerBackground.setStroke(
            2,
            android.graphics.Color.rgb(212, 175, 55)
    );

    buttons[i].setBackground(answerBackground);
    buttons[i].setTextColor(android.graphics.Color.WHITE);
    buttons[i].setEnabled(false);
}

        }

    void showResults() {
stopTimer();
content.removeAllViews();

if (currentLevel == 1) {
    prefs.edit()
            .putBoolean("challenge_level_1_completed", true)
            .apply();
} else if (currentLevel == 2) {
    prefs.edit()
            .putBoolean("challenge_level_2_completed", true)
            .apply();
} else if (currentLevel == 3) {
    prefs.edit()
            .putBoolean("challenge_level_3_completed", true)
            .apply();
} else if (currentLevel == 4) {
    prefs.edit()
            .putBoolean("challenge_level_4_completed", true)
            .apply();
} else if (currentLevel == 5) {
    prefs.edit()
            .putBoolean("challenge_level_5_completed", true)
            .apply();
}

checkAchievementNotifications();

if (currentLevel == highestLevelUnlocked
        && highestLevelUnlocked < 5) {

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
    void showBibleChallenge() {
stopTimer();
content.removeAllViews();

ImageButton backButton = new ImageButton(this);
backButton.setImageResource(android.R.drawable.ic_media_previous);
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setOnClickListener(v -> showGameMenu());

content.addView(
        backButton,
        new LinearLayout.LayoutParams(60, 60)
);

TextView title = new TextView(this);
title.setText("🧠 Bible Challenge");
title.setTextSize(24);
title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
title.setTextColor(darkText);
title.setPadding(0, 15, 0, 10);
content.addView(title);

TextView description = new TextView(this);
description.setText("Test your Bible knowledge against the clock!");
description.setTextSize(17);
description.setTextColor(darkText);
description.setPadding(0, 0, 0, 20);
content.addView(description);

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

if (highestLevelUnlocked >= 4) {
    addButton("🟣 Level 4 — Expert", v -> {
        currentLevel = 4;
        startGame(8000);
    });
} else {
    addButton("🔒 Level 4 — Locked", v -> {});
}

if (highestLevelUnlocked >= 5) {
    addButton("👑 Level 5 — Scholar", v -> {
        currentLevel = 5;
        startGame(6000);
    });
} else {
    addButton("🔒 Level 5 — Locked", v -> {});
}

    }
void showBibleScramble() {
    BibleScrambleGame game = new BibleScrambleGame(this);
    game.showLevelMenu();
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
    private void addAnimatedUnlockButton(
        String text,
        String levelName,
        boolean isUnlocked,
        boolean shouldAnimate,
        View.OnClickListener listener,
        Runnable onAnimationHandled
) {
    android.widget.FrameLayout frame =
            new android.widget.FrameLayout(this);

    Button button = new Button(this);

    button.setText(text);
    button.setTextSize(17);
    button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    button.setTextColor(darkText);
    button.setAllCaps(false);
    button.setPadding(24, 16, 24, 16);

    GradientDrawable buttonBackground =
            new GradientDrawable();

    buttonBackground.setColor(
            Color.argb(225, 255, 255, 255));

    buttonBackground.setCornerRadius(32);
    button.setBackground(buttonBackground);
    button.setElevation(5);
    button.setOnClickListener(listener);

    frame.addView(
            button,
            new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
            )
    );

    LinearLayout.LayoutParams frameParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    frameParams.setMargins(12, 8, 12, 8);
    content.addView(frame, frameParams);

    if (shouldAnimate && isUnlocked) {
        TextView lockIcon = new TextView(this);
        lockIcon.setText("🔒");
        lockIcon.setTextSize(22);
        lockIcon.setGravity(Gravity.CENTER);
        lockIcon.setAlpha(1f);

        android.widget.FrameLayout.LayoutParams lockParams =
                new android.widget.FrameLayout.LayoutParams(
                        55,
                        android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                        Gravity.CENTER
                );

        frame.addView(lockIcon, lockParams);

        LevelUnlockAnimator.animateUnlock(
                lockIcon,
                button,
                this,
                levelName
        );

        if (onAnimationHandled != null) {
            onAnimationHandled.run();
        }
    }
    }
    private void animateBibleJourneyBookUnlock(
        Button bookButton,
        String bookName
) {
    if (bookButton == null) {
        return;
    }

    android.view.ViewParent parent = bookButton.getParent();

    if (!(parent instanceof android.widget.LinearLayout)) {
        return;
    }

    android.widget.LinearLayout row =
            (android.widget.LinearLayout) parent;

    int index = row.indexOfChild(bookButton);

    if (index < 0) {
        return;
    }

    android.view.ViewGroup.LayoutParams originalParams =
            bookButton.getLayoutParams();

    android.widget.FrameLayout frame =
            new android.widget.FrameLayout(this);

    row.removeView(bookButton);

    frame.addView(
            bookButton,
            new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
            )
    );

    TextView lockIcon = new TextView(this);
    lockIcon.setText("🔒");
    lockIcon.setTextSize(18);
    lockIcon.setGravity(Gravity.CENTER);

    frame.addView(
            lockIcon,
            new android.widget.FrameLayout.LayoutParams(
                    45,
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    Gravity.CENTER
            )
    );

    row.addView(frame, index, originalParams);

    LevelUnlockAnimator.animateUnlock(
            lockIcon,
            bookButton,
            this,
            bookName
    );
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
    new MissingWordGame(this).showLevelMenu();
}
            
    void showHighlights() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showNotesHighlights()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("🖍️ Highlights");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    if (highlightsPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No highlighted verses yet.\n\n" +
                "Highlight a verse from the Bible reader and it will appear here."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(
                10,
                10,
                10,
                20
        );
        content.addView(message);

    } else {

        for (
                java.util.Map.Entry<String, ?> entry :
                highlightsPrefs.getAll().entrySet()
        ) {

            String reference = entry.getKey();

            String savedHighlight =
                    entry.getValue().toString();

            String verseText =
                    savedHighlight;

            try {

                String[] parts =
                        savedHighlight.split(
                                "\\|",
                                2
                        );

                if (parts.length == 2) {
                    verseText = parts[1];
                }

            } catch (Exception ignored) {
            }

            addCard(
                    "🖍️ " + reference,
                    verseText,
                    v -> {}
            );
        }
    }
    }
    void saveBookmark(String reference) {

    if (bookmarksPrefs == null) {
        return;
    }

    bookmarksPrefs.edit()
            .putString(reference, reference)
            .apply();

    showMessage(
            "🔖 Bookmark Saved",
            reference + " has been bookmarked."
    );
}

void removeBookmark(String reference) {

    if (bookmarksPrefs == null) {
        return;
    }

    bookmarksPrefs.edit()
            .remove(reference)
            .apply();

    showBookmarks();
}

void showBookmarks() {
    stopTimer();
    content.removeAllViews();

    ImageButton backButton = new ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(
            Color.TRANSPARENT
    );

    backButton.setOnClickListener(
            v -> showMoreMenu()
    );

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(
                    60,
                    60
            )
    );

    TextView title = new TextView(this);
    title.setText("🔖 Bible Bookmarks");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    if (bookmarksPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No bookmarks saved yet.\n\n" +
                "Tap 🔖 beside a Bible verse to save your reading location."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(
                10,
                10,
                10,
                20
        );
        content.addView(message);

    } else {

        for (
                java.util.Map.Entry<String, ?> entry :
                bookmarksPrefs.getAll().entrySet()
        ) {

            String reference = entry.getKey();

            addCard(
                    "🔖 " + reference,
                    "Tap to return to this Bible location.",
                    v -> {

                        try {

                            int colonIndex =
                                    reference.lastIndexOf(":");

                            int spaceIndex =
                                    reference.lastIndexOf(" ");

                            if (
                                    colonIndex > spaceIndex &&
                                    spaceIndex > 0
                            ) {

                                String book =
                                        reference.substring(
                                                0,
                                                spaceIndex
                                        );

                                int chapter =
                                        Integer.parseInt(
                                                reference.substring(
                                                        spaceIndex + 1,
                                                        colonIndex
                                                )
                                        );

                                showBibleChapter(
                                        book,
                                        chapter
                                );
                            }

                        } catch (Exception ignored) {
                        }
                    }
            );

            addButton(
                    "🗑️ Remove " + reference,
                    v -> removeBookmark(reference)
            );
        }
    }
                                }
                            
    void showDailyChallenge() {
    stopTimer();
    content.removeAllViews();

    String today =
            new java.text.SimpleDateFormat(
                    "yyyy-MM-dd",
                    java.util.Locale.getDefault()
            ).format(new java.util.Date());

    boolean completedToday =
            today.equals(lastChallengeDate);

    int dayNumber =
            Math.abs(today.hashCode()) % 5;

    String challengeTitle;
    String challengeText;

    if (dayNumber == 0) {

        challengeTitle = "🙏 Prayer Challenge";
        challengeText =
                "Spend a few quiet minutes talking to God today.";

    } else if (dayNumber == 1) {

        challengeTitle = "❤️ Love Challenge";
        challengeText =
                "Show kindness and encouragement to someone today.";

    } else if (dayNumber == 2) {

        challengeTitle = "📖 Scripture Challenge";
        challengeText =
                "Read a Bible passage and think about one lesson from it.";

    } else if (dayNumber == 3) {

        challengeTitle = "🤝 Kindness Challenge";
        challengeText =
                "Do one helpful thing for someone without expecting anything in return.";

    } else {

        challengeTitle = "🌟 Gratitude Challenge";
        challengeText =
                "Think of three things you are thankful to God for today.";
    }

    TextView title = new TextView(this);
    title.setText("🎯 Daily Challenge");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            challengeTitle,
            challengeText,
            v -> {}
    );

    if (completedToday) {

        addCard(
                "✅ Completed",
                "Today's challenge is complete.\n\n" +
                "Come back tomorrow for another challenge!",
                v -> {}
        );

    } else {

        addButton(
                "✅ Complete Challenge",
                v -> completeDailyChallenge(today)
        );
    }

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    
    void completeDailyChallenge(String today) {

    if (prefs == null) {
        return;
    }

    String lastDate =
            prefs.getString(
                    "lastChallengeDate",
                    ""
            );

    // Prevent an invalid future completion date
    if (!lastDate.isEmpty() &&
            lastDate.compareTo(today) > 0) {

        lastDate = "";
        dailyStreak = 0;

        prefs.edit()
                .putString(
                        "lastChallengeDate",
                        ""
                )
                .putInt(
                        "dailyStreak",
                        0
                )
                .apply();
    }

    // Already completed today's challenge
    if (today.equals(lastDate)) {
        showDailyChallenge();
        return;
    }

    String yesterday =
            new java.text.SimpleDateFormat(
                    "yyyy-MM-dd",
                    java.util.Locale.getDefault()
            ).format(
                    new java.util.Date(
                            System.currentTimeMillis()
                                    - (24L * 60L * 60L * 1000L)
                    )
            );

    if (yesterday.equals(lastDate)) {
        dailyStreak++;
    } else {
        dailyStreak = 1;
    }

    totalPoints += 10;

    lastChallengeDate = today;
    challengeCompletedToday = true;

    prefs.edit()
            .putInt(
                    "dailyStreak",
                    dailyStreak
            )
            .putInt(
                    "totalPoints",
                    totalPoints
            )
            .putString(
                    "lastChallengeDate",
                    lastChallengeDate
            )
            .apply();
        checkAchievementNotifications();

    showMessage(
            "🎉 Challenge Complete!",
            "+10 points earned!\n\n" +
            "🔥 Daily streak: " +
            dailyStreak +
            " day(s)"
    );

    showDailyChallenge();
    }
    void showExplore() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Explore");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText(
            "Search for a Kingdom Life feature."
    );
    instruction.setTextSize(17);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Search features...");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
            "🔎 Search",
            v -> {

                String query =
                        searchInput.getText()
                                .toString()
                                .trim()
                                .toLowerCase();

                if (query.isEmpty()) {

                    showMessage(
                            "🔎 Explore",
                            "Please type a feature to search for."
                    );

                    return;
                }

                showExploreResults(query);
            }
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showExploreResults(String query) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Explore Results");
    title.setTextSize(24);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setPadding(
            0,
            15,
            0,
            20
    );
    content.addView(title);

    boolean found = false;

    if (query.contains("bible") ||
            query.contains("kjv")) {

        addCard(
                "📖 Holy Bible — KJV",
                "Read the King James Version of the Bible.",
                v -> showBible()
        );
        found = true;
    }

    if (query.contains("web") ||
            query.contains("world english")) {

        addCard(
                "🌍 Holy Bible — WEB",
                "Read the World English Bible translation.",
                v -> {
                    getSharedPreferences(
                            "KingdomLifePrefs",
                            MODE_PRIVATE
                    ).edit()
                            .putString(
                                    "bible_translation",
                                    "WEB"
                            )
                            .apply();

                    showBible();
                }
        );
        found = true;
    }

    if (query.contains("memory") ||
            query.contains("verse")) {

        addCard(
                "🧠 Memory Verse",
                "Practice and learn Bible verses.",
                v -> showMemoryVerse()
        );
        found = true;
    }

    if (query.contains("quiz") ||
            query.contains("game")) {

        addCard(
                "🎮 Bible Games",
                "Test your Bible knowledge with different challenges.",
                v -> showGameMenu()
        );
        found = true;
    }

    if (query.contains("puzzle") ||
            query.contains("scramble")) {

        addCard(
                "🧩 Bible Puzzle",
                "Try Bible puzzle challenges.",
                v -> showGameMenu()
        );
        found = true;
    }

    if (query.contains("bible challenge")) {

        addCard(
                "🧠 Bible Challenge",
                "Test your Bible knowledge with different challenge levels.",
                v -> showBibleChallenge()
        );
        found = true;
    }

    if (query.contains("journey")) {

        addCard(
                "📖 Bible Journey",
                "Travel through the 66 books of the Bible and test your knowledge.",
                v -> showBibleJourney()
        );
        found = true;
    }

    if (query.contains("story") ||
query.contains("stories") ||
query.contains("spiritual") ||
query.contains("growth") ||
query.contains("kingdom books") ||
query.contains("books")) {

    addCard(
            "📚 Kingdom Books",
            "Read Christian books, inspiring stories, and lessons.",
            v -> showKingdomBooks()
    );
    found = true;
    }
    if (query.contains("sermon") ||
            query.contains("sermons")) {

        addCard(
                "🎙️ Sermons",
                "Listen to sermons and messages for spiritual encouragement.",
                v -> showSermons()
        );
        found = true;
    }

    if (query.contains("dictionary")) {

        addCard(
                "📚 Bible Dictionary",
                "Search Bible words and their meanings.",
                v -> showBibleDictionary()
        );
        found = true;
    }

    if (query.contains("bookmark")) {

        addCard(
                "🔖 Bookmarks",
                "Return quickly to saved Bible locations.",
                v -> showBookmarks()
        );
        found = true;
    }

    if (query.contains("note") ||
            query.contains("highlight")) {

        addCard(
                "📝 Notes & Highlights",
                "View your saved notes and highlighted verses.",
                v -> showNotesHighlights()
        );
        found = true;
    }

    if (query.contains("saved") ||
            query.contains("saved verse")) {

        addCard(
                "⭐ Saved Verses",
                "View your saved Bible verses.",
                v -> showSavedVerses()
        );
        found = true;
    }

    if (query.contains("daily challenge")) {

        addCard(
                "🎯 Daily Challenge",
                "Complete today's faith-building challenge.",
                v -> showDailyChallenge()
        );
        found = true;
    }

    if (query.contains("progress") ||
            query.contains("points") ||
            query.contains("streak")) {

        addCard(
                "📊 Progress",
                "View your points, streaks, and learning progress.",
                v -> showProgress()
        );
        found = true;
    }

    if (query.contains("achievement")) {

    addCard(
            "🏆 Achievements",
            "View your unlocked and locked achievements.",
            v -> startActivity(
                    new android.content.Intent(
                            MainActivity.this,
                            AchievementsActivity.class
                    )
            )
    );

    found = true;
    }
    if (query.contains("notification") ||
            query.contains("notifications")) {

        addCard(
                "🔔 Notifications",
                "Manage your notification settings.",
                v -> showSettings()
        );
        found = true;
    }

    if (query.contains("setting") ||
            query.contains("sound")) {

        addCard(
                "⚙️ Settings",
                "Manage Kingdom Life settings.",
                v -> showSettings()
        );
        found = true;
    }
        // Missing Word
if (query.contains("missing word") ||
        query.contains("missing")) {

    addCard(
            "🔤 Missing Word",
            "Complete Bible verses by finding the missing words.",
            v -> showPuzzleMenu()
    );
    found = true;
}

// Bible Scramble
if (query.contains("bible scramble") ||
        query.contains("scramble")) {

    addCard(
            "🔀 Bible Scramble",
            "Arrange scrambled letters to discover Bible words.",
            v -> showPuzzleMenu()
    );
    found = true;
}

// Bible Jigsaw Puzzle
if (query.contains("jigsaw")) {

    addCard(
            "🧩 Bible Jigsaw Puzzle",
            "Complete Bible picture puzzles and unlock new levels.",
            v -> showJigsawMenu()
    );
    found = true;
}

// Guess the Reference
if (query.contains("guess the reference") ||
        query.contains("guess reference")) {

    addCard(
            "📖 Guess the Reference",
            "Identify the Bible reference for each verse.",
            v -> showGameMenu()
    );
    found = true;
}

// Guess the Verse
if (query.contains("guess the verse")) {

    addCard(
            "📜 Guess the Verse",
            "Test your knowledge of Bible verses.",
            v -> showGameMenu()
    );
    found = true;
}

// Complete the Verse
if (query.contains("complete the verse")) {

    addCard(
            "✍️ Complete the Verse",
            "Finish Bible verses from memory.",
            v -> showGameMenu()
    );
    found = true;
}

// Prayer Journal
if (query.contains("prayer journal") ||
        query.equals("prayer")) {

    addCard(
            "🙏 Prayer Journal",
            "Record and revisit your prayer entries.",
            v -> showLearnMenu()
    );
    found = true;
}

// Spiritual Goals
if (query.contains("spiritual goals") ||
        query.contains("spiritual goal")) {

    addCard(
            "🎯 Spiritual Goals",
            "Set and track your personal spiritual goals.",
            v -> showLearnMenu()
    );
    found = true;
}

// Backup and Restore
if (query.contains("backup") ||
        query.contains("restore")) {

    addCard(
            "💾 Backup & Restore",
            "Access your saved-data backup and restore tools.",
            v -> showSettings()
    );
    found = true;
}

    if (!found) {

        addCard(
                "🔎 No Feature Found",
                "No matching feature was found. Try another search.",
                v -> {}
        );
    }

    addButton(
            "🔎 Search Again",
            v -> showExplore()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }

    public void startJigsawPuzzle(
        int level,
        String difficulty,
        String imageName
) {
    int imageId = getResources().getIdentifier(
            imageName,
            "drawable",
            getPackageName()
    );

    if (imageId == 0) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Image Not Found")
                .setMessage("The puzzle image could not be loaded.")
                .setPositiveButton("OK", null)
                .show();
        return;
    }

    Bitmap puzzleBitmap = BitmapFactory.decodeResource(
            getResources(),
            imageId
    );

    if (puzzleBitmap == null) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Puzzle Error")
                .setMessage("Unable to load the puzzle image.")
                .setPositiveButton("OK", null)
                .show();
        return;
    }

    showJigsawBoard(level, difficulty, puzzleBitmap);
    }
            
           private void showJigsawBoard(
        int level,
        String difficulty,
        Bitmap bitmap
) {
    content.removeAllViews();
    content.setOrientation(LinearLayout.VERTICAL);
               // Top-left back arrow
android.widget.ImageButton backButton =
new android.widget.ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);
backButton.setScaleX(1.3f);
backButton.setScaleY(1.3f);
backButton.setContentDescription("Back to Jigsaw Levels");
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v -> showJigsawMenu());

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);
backParams.gravity = Gravity.LEFT;

content.addView(backButton, backParams);

    TextView title = new TextView(this);
    title.setText("🧩 " + difficulty + " Jigsaw Puzzle");
    title.setTextSize(22);
    title.setTypeface(null, Typeface.BOLD);
    title.setTextColor(Color.WHITE);
    title.setGravity(Gravity.CENTER);
    title.setPadding(8, 10, 8, 6);
    content.addView(title);

    TextView instructions = new TextView(this);
    instructions.setText("Drag each piece onto the matching picture.");
    instructions.setTextColor(Color.WHITE);
    instructions.setGravity(Gravity.CENTER);
    instructions.setPadding(8, 4, 8, 8);
    content.addView(instructions);

    JigsawBoard board =
        new JigsawBoard(this, bitmap, difficulty, level);

    content.addView(board, new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            0,
            1f
    ));

           }

class JigsawBoard extends View {

    private final Bitmap image;
    private final int levelNumber;
    private final String storyDescription;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int columns;
    private final int rows;
    private final int count;
    private final int[][] horizontal;
private final int[][] vertical;

    private float cell;
private float cellWidth;
private float cellHeight;

private float boardCellWidth;
private float boardCellHeight;

private float boardLeft;
private float boardTop;
private float trayTop;
private float trayScroll;
    private int trayColumns;
private int trayRows;

    private float[] xPositions;
    private float[] yPositions;
    private float[] homeX;
private float[] homeY;
    private boolean[] locked;
    private boolean[] placed;

    private int selected = -1;
    private boolean draggingFromTray;
    private float downX;
    private float downY;
    private float dragX;
private float dragY;
    private float offsetX;
    private float offsetY;
    private int completed;
    private boolean victoryShown;

    private final float gap = 8f;
private final float margin = 6f;
    private final float tabRatio = 0.14f;

    JigsawBoard(
        android.content.Context context,
        Bitmap bitmap,
        String difficulty,
        int level
) {
        super(context);

        image = bitmap;
levelNumber = level;
        storyDescription = BibleJigsawData.getStoryDescription(levelNumber);

        if ("Easy".equals(difficulty)) {
            columns = 4;
            rows = 3;
        } else if ("Medium".equals(difficulty)) {
            columns = 6;
            rows = 4;
        } else {
            columns = 8;
            rows = 6;
        }

        count = columns * rows;
        horizontal = new int[rows + 1][columns];
vertical = new int[rows][columns + 1];

java.util.Random random = new java.util.Random();

for (int r = 1; r < rows; r++) {
    for (int c = 0; c < columns; c++) {
        horizontal[r][c] = random.nextBoolean() ? 1 : -1;
    }
}

for (int r = 0; r < rows; r++) {
    for (int c = 1; c < columns; c++) {
        vertical[r][c] = random.nextBoolean() ? 1 : -1;
    }
     }

        xPositions = new float[count];
yPositions = new float[count];
homeX = new float[count];
homeY = new float[count];
        locked = new boolean[count];
        placed = new boolean[count];

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setFocusable(true);
    }
    
private void showCompletedPicture() {
    content.removeAllViews();
    content.setOrientation(LinearLayout.VERTICAL);

    // Identify the completed level
final int level = levelNumber;

    android.content.SharedPreferences jigsawPrefs =
            getSharedPreferences(
                    "KingdomLifeJigsawPrefs",
                    MODE_PRIVATE
            );

    int highestUnlocked =
            jigsawPrefs.getInt("highestUnlockedLevel", 1);

    String rewardKey = "level" + level + "RewardClaimed";

    boolean alreadyClaimed =
            jigsawPrefs.getBoolean(rewardKey, false);

    int reward = level * 10;

    // Award points only once per level
    // Award points only once per level
if (!alreadyClaimed) {
totalPoints += reward;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    jigsawPrefs.edit()
            .putBoolean(rewardKey, true)
            .apply();

    checkAchievementNotifications();
}

// Unlock the next level independently of reward claiming
int nextUnlockedLevel =
        Math.max(highestUnlocked, level + 1);

jigsawPrefs.edit()
        .putInt("highestUnlockedLevel", nextUnlockedLevel)
        .apply();
    TextView title = new TextView(MainActivity.this);
    title.setText("✨‘‘ Puzzle Completed!");
    title.setTextSize(24);
    title.setTypeface(null, Typeface.BOLD);
    title.setTextColor(Color.WHITE);
    title.setGravity(Gravity.CENTER);
    title.setPadding(12, 20, 12, 12);
    content.addView(title);

    ImageView finishedImage = new ImageView(MainActivity.this);
    finishedImage.setImageBitmap(image);
    finishedImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
    finishedImage.setAdjustViewBounds(true);

    LinearLayout.LayoutParams imageParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1f
            );

    imageParams.setMargins(12, 8, 12, 8);
    content.addView(finishedImage, imageParams);

    TextView story = new TextView(MainActivity.this);
    story.setText(storyDescription);
    story.setTextColor(Color.WHITE);
    story.setTextSize(15);
    story.setGravity(Gravity.CENTER);
    story.setPadding(20, 12, 20, 12);
    content.addView(story);

    TextView message = new TextView(MainActivity.this);

    if (alreadyClaimed) {
    message.setText(
            "🎉 Congratulations! 🎉\n\n"
            + "🧩 You completed all "
            + count + " pieces!\n\n"
            + "🏆 You've already claimed this level's reward."
            + (level < 90
                    ? "\n\n➡️ Level " + (level + 1) + " is next!"
                    : "\n\n👑 You've completed all currently available "
                    + "Jigsaw levels!")
    );
} else {
    message.setText(
            "🎉 CONGRATULATIONS! 🎉\n\n"
            + "🧩 You completed all " + count + " pieces!\n\n"
            + "🏆 Reward: +" + reward + " points!\n\n"
            + (level < 90
                    ? "🔓 Level " + (level + 1)
                    + " is now unlocked!\n\n"
                    + "🌟 Keep going, champion!"
                    : "👑 You've completed all currently available "
                    + "Jigsaw levels!\n\n"
                    + "✨ What an amazing achievement!")
    );
    }
message.setTextColor(Color.WHITE);
message.setTextSize(16);
message.setGravity(Gravity.CENTER);
message.setPadding(12, 8, 12, 16);
content.addView(message);

Button continueButton = new Button(MainActivity.this);

if (level < 90) {
    continueButton.setText("➡️ Continue to Level " + (level + 1));
    continueButton.setOnClickListener(v -> showJigsawMenu());
} else {
    continueButton.setText("👑 Return to Jigsaw Menu");
    continueButton.setOnClickListener(v -> showJigsawMenu());
}

content.addView(continueButton);
}
        @Override
protected void onSizeChanged(int w, int h, int oldW, int oldH) {
    super.onSizeChanged(w, h, oldW, oldH);
    if (w <= 0 || h <= 0) return;

    float availableBoardWidth = Math.max(1f, w - 2f * margin);
    float imageRatio = (float) image.getWidth() / (float) image.getHeight();

    float maxBoardHeightForOneRow = Math.max(
            1f,
            (h - 2f * margin - 28f) * rows / (rows + 1f)
    );

    float availableBoardHeight = Math.min(
            h * 0.80f,
            maxBoardHeightForOneRow
    );

    // Make the board narrower and slightly taller.
float boardWidth = availableBoardWidth * 0.70f;
float boardHeight = (boardWidth / imageRatio) * 1.10f;

if (boardHeight > availableBoardHeight) {
    boardHeight = availableBoardHeight;
}
    boardCellWidth = boardWidth / columns;
    boardCellHeight = boardHeight / rows;

    // Keep tray piece dimensions independent from board dimensions.
    cellWidth = boardCellWidth;
    cellHeight = boardCellHeight;
    cell = Math.min(cellWidth, cellHeight);

    boardLeft = (w - boardWidth) / 2f;
    boardTop = margin;
    trayTop = boardTop + boardHeight + 15f;

    trayColumns = Math.max(
            1,
            (int) Math.floor(
                    (w - 2f * margin + gap) / (cellWidth + gap)
            )
    );

    trayRows = (int) Math.ceil(
            (double) count / (double) trayColumns
    );

    java.util.ArrayList<Integer> order = new java.util.ArrayList<>();
    for (int i = 0; i < count; i++) {
        order.add(i);
    }
    java.util.Collections.shuffle(order);

    for (int slot = 0; slot < count; slot++) {
        int index = order.get(slot);
        int trayRow = slot / trayColumns;
        int trayCol = slot % trayColumns;

        homeX[index] = margin + trayCol * (cellWidth + gap);
        homeY[index] = trayTop + trayRow * (cellHeight + gap);

        xPositions[index] = homeX[index];
        yPositions[index] = homeY[index];
    }

    trayScroll = 0f;
    invalidate();
}
    private float getMaxTrayScroll() {
        float trayContentHeight = trayRows * cellHeight + Math.max(0, trayRows - 1) * gap;
        float visibleTrayHeight = Math.max(0f, getHeight() - trayTop - margin);
        return Math.max(0f, trayContentHeight - visibleTrayHeight);
    }

    private Path piecePath(int index, float x, float y, float w, float h) {
    int row = index / columns;
    int col = index % columns;

    float tab = Math.min(w, h) * 0.22f;

    Path p = new Path();
    p.moveTo(x, y);

    p.lineTo(x + w * 0.32f, y);

    if (row > 0) {
        int direction = -horizontal[row][col];
        p.cubicTo(
                x + w * 0.32f, y + direction * tab,
                x + w * 0.68f, y + direction * tab,
                x + w * 0.68f, y
        );
    }

    p.lineTo(x + w, y);
    p.lineTo(x + w, y + h * 0.32f);

    if (col < columns - 1) {
        int direction = vertical[row][col + 1];
        p.cubicTo(
                x + w + direction * tab, y + h * 0.32f,
                x + w + direction * tab, y + h * 0.68f,
                x + w, y + h * 0.68f
        );
    }

    p.lineTo(x + w, y + h);
    p.lineTo(x + w * 0.68f, y + h);

    if (row < rows - 1) {
        int direction = horizontal[row + 1][col];
        p.cubicTo(
                x + w * 0.68f, y + h + direction * tab,
                x + w * 0.32f, y + h + direction * tab,
                x + w * 0.32f, y + h
        );
    }

    p.lineTo(x, y + h);
    p.lineTo(x, y + h * 0.68f);

    if (col > 0) {
        int direction = -vertical[row][col];
        p.cubicTo(
                x - direction * tab, y + h * 0.68f,
                x - direction * tab, y + h * 0.32f,
                x, y + h * 0.32f
        );
    }

    p.close();
    return p;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.rgb(24, 29, 42));

Rect target = new Rect(
        (int) boardLeft,
        (int) boardTop,
        (int) (boardLeft + columns * cellWidth),
        (int) (boardTop + rows * cellHeight)
);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setAlpha(95);
        canvas.drawBitmap(image, null, target, paint);
        paint.setAlpha(255);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2f);
        paint.setColor(Color.WHITE);
        canvas.drawRect(target, paint);

        // Tray background and border.
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(34, 40, 56));
        canvas.drawRect(0f, trayTop, getWidth(), getHeight(), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.5f);
        paint.setColor(Color.rgb(112, 125, 151));
        canvas.drawRect(1f, trayTop, getWidth() - 1f, getHeight() - 1f, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(16f);
        canvas.drawText("Pieces placed: " + completed + " / " + count,
                margin, trayTop - 10f, paint);

        // Pieces already placed stay fixed on the picture.
        for (int i = 0; i < count; i++) {
            if (!placed[i]) continue;
            int row = i / columns;
            int col = i % columns;
            drawPuzzlePiece(canvas, i,
        boardLeft + col * boardCellWidth,
        boardTop + row * boardCellHeight);
        }

        // The tray is a multi-row grid and scrolls vertically.
        canvas.save();
        canvas.clipRect(0f, trayTop, getWidth(), getHeight());
        canvas.translate(0f, -trayScroll);
        for (int i = 0; i < count; i++) {
            if (placed[i] || selected == i) continue;
            drawPuzzlePiece(canvas, i, xPositions[i], yPositions[i]);
        }
        canvas.restore();

        // Draw the selected piece above the tray and board while dragging.
        if (selected >= 0 && selected < count && !placed[selected]) {
            drawPuzzlePiece(canvas, selected,
                    dragX - offsetX, dragY - offsetY);
        }
    }

    private void drawPuzzlePiece(Canvas canvas, int index, float x, float y) {
    int row = index / columns;
    int col = index % columns;

    boolean onBoard = placed[index] || index == selected && !draggingFromTray;

    float w = onBoard ? boardCellWidth : cellWidth;
    float h = onBoard ? boardCellHeight : cellHeight;

    Path path = piecePath(index, x, y, w, h);

    canvas.save();
    canvas.clipPath(path);

    Rect source = new Rect(
            col * image.getWidth() / columns,
            row * image.getHeight() / rows,
            (col + 1) * image.getWidth() / columns,
            (row + 1) * image.getHeight() / rows
    );

    Rect destination = new Rect(
            (int) x,
            (int) y,
            (int) (x + w),
            (int) (y + h)
    );

    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.WHITE);
    paint.setAlpha(255);

    canvas.drawBitmap(image, source, destination, paint);
    canvas.restore();

    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(2f);
    paint.setColor(Color.WHITE);
    canvas.drawPath(path, paint);

    paint.setStyle(Paint.Style.FILL);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int action = event.getActionMasked();

        if (action == MotionEvent.ACTION_DOWN) {
            downX = x;
            downY = y;
            dragX = x;
            dragY = y;
            selected = -1;
            draggingFromTray = false;

            if (y >= trayTop && y <= getHeight()) {
                // Positions are stored in tray-content coordinates. Convert
                // the piece's Y position to the visible screen position.
                for (int i = count - 1; i >= 0; i--) {
                    if (placed[i]) continue;
                    float screenY = yPositions[i] - trayScroll;
                    if (x >= xPositions[i] && x <= xPositions[i] + cellWidth
                            && y >= screenY && y <= screenY + cellHeight) {
                        selected = i;
                        draggingFromTray = true;
                        offsetX = x - xPositions[i];
                        offsetY = y - screenY;
                        invalidate();
                        return true;
                    }
                }
            }
            return true;
        }

        if (action == MotionEvent.ACTION_MOVE) {
            dragX = x;
            dragY = y;

            if (selected >= 0 && !placed[selected]) {
                // While dragging, positions use screen coordinates so snap
                // testing compares directly with the board target.
                xPositions[selected] = x - offsetX;
                yPositions[selected] = y - offsetY;
                draggingFromTray = y >= trayTop;
            } else if (downY >= trayTop) {
                // Vertical scrolling: swipe up to see later rows.
                trayScroll = Math.max(0f, Math.min(getMaxTrayScroll(),
                        trayScroll - (y - downY)));
                downY = y;
            }
            invalidate();
            return true;
        }

        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            if (action == MotionEvent.ACTION_UP
                    && selected >= 0 && selected < count && !placed[selected]) {
                int row = selected / columns;
                int col = selected % columns;
                float targetX = boardLeft + col * boardCellWidth;
float targetY = boardTop + row * boardCellHeight;
                if (!draggingFromTray
        && Math.abs(xPositions[selected] - targetX) < boardCellWidth * 0.35f
        && Math.abs(yPositions[selected] - targetY) < boardCellHeight * 0.35f) {
                    xPositions[selected] = targetX;
                    yPositions[selected] = targetY;
                    placed[selected] = true;
                    locked[selected] = true;
                    completed++;
                    if (completed == count && !victoryShown) {
                        victoryShown = true;
                        post(this::showCompletedPicture);
                    }
                } else {
                    xPositions[selected] = homeX[selected];
                    yPositions[selected] = homeY[selected];
                }
            } else if (selected >= 0 && selected < count && !placed[selected]) {
                xPositions[selected] = homeX[selected];
            }

            selected = -1;
            draggingFromTray = false;
            invalidate();
            return true;
        }
        return true;
    }

}

    @Override
protected void onActivityResult(
        int requestCode,
        int resultCode,
        android.content.Intent data) {

    super.onActivityResult(
            requestCode,
            resultCode,
            data
    );

    if (resultCode != RESULT_OK || data == null) {
        return;
    }

    android.net.Uri uri = data.getData();

    if (uri == null) {
        return;
    }

    if (requestCode == 7101) {
        writeBackup(uri);

    } else if (requestCode == 7102) {
        readBackup(uri);
    }
}
  }
