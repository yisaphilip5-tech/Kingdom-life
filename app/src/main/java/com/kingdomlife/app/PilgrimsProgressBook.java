package com.kingdomlife.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PilgrimsProgressBook {

private static Activity activity;
private static LinearLayout content;
private static WebView bookView;
private static TextView pageIndicator;
private static Button previousButton;
private static Button nextButton;

private static JSONArray chapters = new JSONArray();
private static int chapterIndex = 0;
private static int pageIndex = 0;
private static int totalPages = 1;
private static boolean readerReady = false;
    private static boolean resumeWhenReady = false;
    private static int pendingBookmarkChapter = -1;
private static int pendingBookmarkPage = -1;

private static final int PURPLE = Color.rgb(30, 24, 55);
private static final int GOLD = Color.rgb(184, 134, 11);

public static void open(Activity a, LinearLayout container) {

    activity = a;
    content = container;

    chapters = new JSONArray();
    chapterIndex = 0;
    pageIndex = 0;
    totalPages = 1;
    readerReady = false;

    content.removeAllViews();
    content.setOrientation(LinearLayout.VERTICAL);

    // Back button
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(activity);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setScaleX(1.3f);
    backButton.setScaleY(1.3f);
    backButton.setContentDescription("Back to Spiritual Books");
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setScaleType(
            android.widget.ImageView.ScaleType.CENTER_INSIDE
    );

    backButton.setOnClickListener(v -> returnToBooks());

    LinearLayout.LayoutParams backParams =
            new LinearLayout.LayoutParams(100, 70);
    backParams.gravity = Gravity.LEFT;
    content.addView(backButton, backParams);

    // Book title
    TextView title = new TextView(activity);
    title.setText("The Pilgrim's Progress");
    title.setTextSize(24);
    title.setTypeface(null, Typeface.BOLD);
    title.setTextColor(GOLD);
    title.setGravity(Gravity.CENTER);
    title.setPadding(8, 12, 8, 12);
    content.addView(title);

    // Simple loading message
    LinearLayout loadingPanel = new LinearLayout(activity);
    loadingPanel.setOrientation(LinearLayout.VERTICAL);
    loadingPanel.setGravity(Gravity.CENTER);

    TextView loadingText = new TextView(activity);
    loadingText.setText("Loading book...");
    loadingText.setTextSize(19);
    loadingText.setTypeface(null, Typeface.BOLD);
    loadingText.setTextColor(GOLD);
    loadingText.setGravity(Gravity.CENTER);

    loadingPanel.addView(
            loadingText,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );

    content.addView(
            loadingPanel,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
            )
    );

    // Load the book HTML
    bookView = new WebView(activity);
    bookView.setBackgroundColor(Color.WHITE);
    bookView.setVisibility(View.GONE);

    WebSettings settings = bookView.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setAllowFileAccess(true);
    settings.setDomStorageEnabled(true);

    bookView.addJavascriptInterface(
            new BookBridge(), "AndroidBook"
    );

    bookView.setWebViewClient(new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            if (url != null &&
                    url.endsWith("PilgrimsProgress.html")) {
                extractChapters();
            }
        }
    });

    content.addView(
            bookView,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
            )
    );

    bookView.loadUrl(
            "file:///android_asset/PilgrimsProgress.html"
    );
}
    
public static void continueReading(Activity a, LinearLayout container) {
pendingBookmarkChapter = -1;
pendingBookmarkPage = -1;
resumeWhenReady = true;

open(a, container);

}
    public static void openBookmarkedPage(
        Activity a,
        LinearLayout container,
        int savedChapter,
        int savedPage) {

    resumeWhenReady = true;
    pendingBookmarkChapter = Math.max(0, savedChapter);
    pendingBookmarkPage = Math.max(0, savedPage);

    open(a, container);
    }
    
private static void extractChapters() {
String script =
"(function() {" +
"var headings = Array.from(document.querySelectorAll('h1,h2,h3,h4'));" +
"headings = headings.filter(function(h) {" +
"return /^\\s*CHAPTER\\s+[IVXLCDM0-9]+\\b/i.test(h.textContent.trim());" +
"});" +
"var result = [];" +
"headings.forEach(function(h, i) {" +
"var box = document.createElement('div');" +
"var n = h.nextSibling;" +
"while (n && n !== headings[i + 1]) {" +
"box.appendChild(n.cloneNode(true));" +
"n = n.nextSibling;" +
"}" +
"result.push({" +
"title: h.textContent.trim()," +
"html: box.innerHTML" +
"});" +
"});" +
"return JSON.stringify(result);" +
"})()";

bookView.evaluateJavascript(script, value -> {
    try {
        if (value == null || value.equals("null")) {
            Toast.makeText(
                    activity,
                    "Could not read the book HTML.",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        Object decoded = new JSONTokener(value).nextValue();
        chapters = new JSONArray(decoded.toString());

        if (chapters.length() == 0) {
            Toast.makeText(
                    activity,
                    "No chapter headings were found. Please send me the next error message.",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

                if (resumeWhenReady) {
int savedChapter;
int savedPage;

if (pendingBookmarkChapter >= 0) {
    // Open the exact bookmarked chapter and page.
    savedChapter = pendingBookmarkChapter;
    savedPage = pendingBookmarkPage;

    pendingBookmarkChapter = -1;
    pendingBookmarkPage = -1;
} else {
    // Continue from the last reading position.
    android.content.SharedPreferences prefs =
            activity.getSharedPreferences(
                    "PilgrimsProgressReadingProgress",
                    Activity.MODE_PRIVATE
            );

    savedChapter = prefs.getInt("lastChapter", 0);
    savedPage = prefs.getInt("lastPage", 0);
}

chapterIndex = Math.max(
        0,
        Math.min(savedChapter, chapters.length() - 1)
);

pageIndex = Math.max(0, savedPage);
resumeWhenReady = false;

showReader();

} else {
showChapterList();
                }

    } catch (Exception e) {
        Toast.makeText(
                activity,
                "Could not load chapters: " + e.getMessage(),
                Toast.LENGTH_LONG
        ).show();
    }
});

}
private static void showChapterList() {
    readerReady = false;
    content.removeAllViews();
    // Top-left back arrow
android.widget.ImageButton backButton =
new android.widget.ImageButton(activity);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);
backButton.setScaleX(1.3f);
backButton.setScaleY(1.3f);
backButton.setContentDescription("Back to Spiritual Books");
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v -> returnToBooks());

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);
backParams.gravity = Gravity.LEFT;

content.addView(backButton, backParams);

    TextView heading = new TextView(activity);
    heading.setText("Choose a Chapter");
    heading.setTextColor(GOLD);
    heading.setTextSize(23);
    heading.setTypeface(null, Typeface.BOLD);
    heading.setGravity(Gravity.CENTER);
    heading.setPadding(8, 12, 8, 16);
    content.addView(heading);

    LinearLayout list = new LinearLayout(activity);
    list.setOrientation(LinearLayout.VERTICAL);

    android.widget.ScrollView scroll =
            new android.widget.ScrollView(activity);

    scroll.addView(list);

    content.addView(
            scroll,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
            )
    );

    for (int i = 0; i < chapters.length(); i++) {
        final int selected = i;

        String chapterTitle = chapters.optJSONObject(i)
                .optString("title", "Chapter " + (i + 1));

        Button item = new Button(activity);
        item.setText(chapterTitle);
        item.setTextColor(GOLD);
        item.setAllCaps(false);
        item.setTextSize(17);
        item.setBackground(makeBackground(PURPLE, GOLD));
        item.setPadding(12, 12, 12, 12);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(8, 5, 8, 5);
        list.addView(item, params);

        item.setOnClickListener(v -> {
            chapterIndex = selected;
            pageIndex = 0;
            showReader();
        });
    }

}

private static void showReader() {
    readerReady = false;
    content.removeAllViews();
    // Top-left back arrow
android.widget.ImageButton backButton =
new android.widget.ImageButton(activity);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);
backButton.setScaleX(1.3f);
backButton.setScaleY(1.3f);
backButton.setContentDescription("Back to Chapter List");
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v -> showChapterList());

LinearLayout.LayoutParams backParams =
        new LinearLayout.LayoutParams(100, 70);
backParams.gravity = Gravity.LEFT;

content.addView(backButton, backParams);

    bookView = new WebView(activity);
    bookView.setBackgroundColor(Color.WHITE);

    WebSettings settings = bookView.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setAllowFileAccess(true);
    settings.setDomStorageEnabled(true);

    bookView.addJavascriptInterface(
            new BookBridge(), "AndroidBook"
    );

    content.addView(
            bookView,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
            )
    );

    LinearLayout controls = new LinearLayout(activity);
    controls.setOrientation(LinearLayout.VERTICAL);
    controls.setPadding(5, 5, 5, 5);
    controls.setBackgroundColor(PURPLE);

    pageIndicator = new TextView(activity);
    pageIndicator.setTextColor(GOLD);
    pageIndicator.setGravity(Gravity.CENTER);
    pageIndicator.setTextSize(14);
    pageIndicator.setPadding(4, 5, 4, 5);

    controls.addView(
            pageIndicator,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );
Button bookmarkButton = new Button(activity);
bookmarkButton.setText("🔖 Bookmark This Page");
bookmarkButton.setAllCaps(false);

controls.addView(
        bookmarkButton,
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
);

bookmarkButton.setOnClickListener(v -> {
    android.content.SharedPreferences bookmarkPrefs =
            activity.getSharedPreferences(
                    "PilgrimsProgressBookmarks",
                    Activity.MODE_PRIVATE
            );

    String bookmarkKey = chapterIndex + "_" + pageIndex;

    bookmarkPrefs.edit()
            .putBoolean(bookmarkKey, true)
            .apply();

    Toast.makeText(
            activity,
            "Bookmark saved for Chapter " + (chapterIndex + 1)
                    + ", Page " + (pageIndex + 1),
            Toast.LENGTH_SHORT
    ).show();
});
    LinearLayout buttons = new LinearLayout(activity);
    buttons.setOrientation(LinearLayout.HORIZONTAL);

    previousButton = new Button(activity);
    previousButton.setText("Previous Page");
    previousButton.setAllCaps(false);

    nextButton = new Button(activity);
    nextButton.setText("Next Page");
    nextButton.setAllCaps(false);

    Button chapterListButton = new Button(activity);
    chapterListButton.setText("Chapter List");
    chapterListButton.setAllCaps(false);

    buttons.addView(
            previousButton,
            new LinearLayout.LayoutParams(0,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1)
    );

    buttons.addView(
            nextButton,
            new LinearLayout.LayoutParams(0,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1)
    );

    controls.addView(buttons);

    controls.addView(
            chapterListButton,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );

    content.addView(
            controls,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );

    previousButton.setOnClickListener(v -> previousPage());
    nextButton.setOnClickListener(v -> nextPage());
    chapterListButton.setOnClickListener(v -> showChapterList());

    loadReaderHtml();
}

private static void extractChapters() {

    String script =
    "(function() {" +
    "var allHeadings = Array.from(document.querySelectorAll('h1,h2,h3,h4'));" +
    "var result = [];" +
    "var currentPart = 'Part I';" +

    "allHeadings.forEach(function(h) {" +
        "var headingText = h.textContent.trim();" +

        "if (/^PART\\s+I\\.?$/i.test(headingText)) {" +
            "currentPart = 'Part I';" +
            "return;" +
        "}" +

        "if (/^PART\\s+II\\.?$/i.test(headingText)) {" +
            "currentPart = 'Part II';" +
            "return;" +
        "}" +

        "if (!/^CHAPTER\\s+[IVXLCDM0-9]+\\b/i.test(headingText)) return;" +

        "var box = document.createElement('div');" +
        "var n = h.nextSibling;" +

        "while (n) {" +
            "if (n.nodeType === 1 &&" +
                "/^CHAPTER\\s+[IVXLCDM0-9]+\\b/i.test(n.textContent.trim()) &&" +
                "/^(H1|H2|H3|H4)$/.test(n.tagName)) break;" +

            "var next = n.nextSibling;" +

            "if (n.nodeType === 1 &&" +
                "/^(H1|H2|H3|H4)$/.test(n.tagName) &&" +
                "/^(PART\\s+I\\.?|PART\\s+II\\.?|THE PILGRIM'S PROGRESS\\.?$)/i.test(n.textContent.trim())) {" +
                "n = next;" +
                "continue;" +
            "}" +

            "box.appendChild(n.cloneNode(true));" +
            "n = next;" +
        "}" +

        "result.push({" +
            "title: currentPart + ' — ' + headingText.replace(/\\.$/, '')," +
            "html: box.innerHTML" +
        "});" +
    "});" +

    "return JSON.stringify(result);" +
    "})()";

    bookView.evaluateJavascript(script, value -> {

        try {
            if (value == null || value.equals("null")) {
                Toast.makeText(
                        activity,
                        "Could not read the book HTML.",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            Object decoded = new JSONTokener(value).nextValue();
            chapters = new JSONArray(decoded.toString());

            if (chapters.length() == 0) {
                Toast.makeText(
                        activity,
                        "No chapter headings were found.",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            if (resumeWhenReady) {

                int savedChapter;
                int savedPage;

                if (pendingBookmarkChapter >= 0) {
                    savedChapter = pendingBookmarkChapter;
                    savedPage = pendingBookmarkPage;

                    pendingBookmarkChapter = -1;
                    pendingBookmarkPage = -1;

                } else {
                    android.content.SharedPreferences prefs =
                            activity.getSharedPreferences(
                                    "PilgrimsProgressReadingProgress",
                                    Activity.MODE_PRIVATE
                            );

                    savedChapter = prefs.getInt("lastChapter", 0);
                    savedPage = prefs.getInt("lastPage", 0);
                }

                chapterIndex = Math.max(
                        0,
                        Math.min(savedChapter, chapters.length() - 1)
                );

                pageIndex = Math.max(0, savedPage);
                resumeWhenReady = false;

                showReader();

            } else {
                showChapterList();
            }

        } catch (Exception e) {
            Toast.makeText(
                    activity,
                    "Could not load chapters: " + e.getMessage(),
                    Toast.LENGTH_LONG
            ).show();
        }
    });
}
    
private static void previousPage() {
    if (pageIndex > 0) {
        pageIndex--;
        navigateToPage();
    } else if (chapterIndex > 0) {
        chapterIndex--;
        pageIndex = 0;
        showReader();
    }
}

private static void nextPage() {
    if (pageIndex < totalPages - 1) {
        pageIndex++;
        navigateToPage();
    } else if (chapterIndex < chapters.length() - 1) {
        chapterIndex++;
        pageIndex = 0;
        showReader();
    } else {
android.content.SharedPreferences readingPrefs =
activity.getSharedPreferences(
"BibleReadingPrefs",
Activity.MODE_PRIVATE
);

java.util.Set<String> completedStoryBooks =
        new java.util.HashSet<>(
                readingPrefs.getStringSet(
                        "completedStoryBooks",
                        java.util.Collections.emptySet()
                )
        );

completedStoryBooks.add("The Pilgrim's Progress");

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

Toast.makeText(
        activity,
        "You have reached the end of the book!",
        Toast.LENGTH_SHORT
).show();

    }
}

private static void navigateToPage() {
if (bookView != null) {
bookView.evaluateJavascript(
"goPage(" + pageIndex + ")",
null
);
}

saveReadingPosition();
updateIndicator();

}
private static void updateIndicator() {
    if (pageIndicator == null) return;

    pageIndicator.setText(
            "Chapter " + (chapterIndex + 1) +
            " of " + chapters.length() +
            "  •  Page " + (pageIndex + 1) +
            " of " + totalPages
    );

    if (previousButton != null) {
        previousButton.setEnabled(
                pageIndex > 0 || chapterIndex > 0
        );
    }

    if (nextButton != null) {
        nextButton.setEnabled(
                pageIndex < totalPages - 1 ||
                chapterIndex < chapters.length() - 1
        );
    }
}
private static void saveReadingPosition() {
if (activity == null) return;

android.content.SharedPreferences prefs =
        activity.getSharedPreferences(
                "PilgrimsProgressReadingProgress",
                Activity.MODE_PRIVATE
        );

prefs.edit()
        .putInt("lastChapter", chapterIndex)
        .putInt("lastPage", pageIndex)
        .apply();

}
private static GradientDrawable makeBackground(
        int backgroundColor, int strokeColor) {

    GradientDrawable drawable = new GradientDrawable();
    drawable.setColor(backgroundColor);
    drawable.setCornerRadius(18);
    drawable.setStroke(2, strokeColor);
    return drawable;
}

private static void returnToBooks() {

    if (activity instanceof KingdomBooksActivity) {

        ((KingdomBooksActivity) activity).showKingdomBooks();

    } else if (activity instanceof MainActivity) {

        ((MainActivity) activity).showKingdomBooks();
    }
}

private static class BookBridge {

    @JavascriptInterface
    public void pageCount(int count) {
        activity.runOnUiThread(() -> {
            totalPages = Math.max(1, count);
            readerReady = true;
            updateIndicator();
        });
    }

    @JavascriptInterface
public void pageChanged(int page) {
activity.runOnUiThread(() -> {
pageIndex = Math.max(0, page);
saveReadingPosition();
updateIndicator();
});
}
}

                }
