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

    TextView title = new TextView(activity);
    title.setText("The Pilgrim's Progress");
    title.setTextSize(24);
    title.setTypeface(null, Typeface.BOLD);
    title.setTextColor(GOLD);
    title.setGravity(Gravity.CENTER);
    title.setPadding(8, 12, 8, 12);
    content.addView(title);

    bookView = new WebView(activity);
    bookView.setBackgroundColor(Color.WHITE);

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

        showChapterList();

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

    Button back = new Button(activity);
    back.setText("Back to Spiritual Books");
    back.setAllCaps(false);
    back.setOnClickListener(v -> returnToBooks());

    content.addView(
            back,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );
}

private static void showReader() {
    readerReady = false;
    content.removeAllViews();

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

private static void loadReaderHtml() {
try {
String chapterJson = chapters.toString();
    String html =
            "<!DOCTYPE html><html><head>" +
            "<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>" +
            "<style>" +
            "*{box-sizing:border-box;}" +
            "html,body{margin:0;padding:0;width:100%;height:100%;overflow:hidden;background:#fff;}" +
            "#viewport{width:100%;height:100%;overflow:hidden;padding:14px;}" +
            "#pages{" +
            "height:100%;" +
            "column-width:100%;" +
            "column-gap:28px;" +
            "column-fill:auto;" +
            "font-family:Georgia,serif;" +
            "font-size:18px;" +
            "line-height:1.55;" +
            "color:#222;" +
            "}" +
            "#pages>*{max-width:100%;}" +
            "h1,h2,h3,h4{break-after:avoid-column;}" +
            "p{orphans:2;widows:2;}" +
            "img{max-width:100%;height:auto;}" +
            "a{color:#6b4b00;}" +
            "</style></head><body>" +
            "<div id='viewport'><div id='pages'></div></div>" +
            "<script>" +
            "var allChapters=" + chapterJson + ";" +
            "var currentChapter=" + chapterIndex + ";" +
            "var currentPage=0;" +
            "var pagesCount=1;" +

            "function renderChapter(){" +
            "var c=allChapters[currentChapter];" +
            "var viewport=document.getElementById('viewport');" +
            "var box=document.getElementById('pages');" +
            "var pageWidth=viewport.clientWidth-28;" +
            "var pageHeight=viewport.clientHeight-28;" +

            "box.style.transform='none';" +
            "box.style.width=pageWidth+'px';" +
            "box.style.height=pageHeight+'px';" +
            "box.style.columnWidth=pageWidth+'px';" +
            "box.style.columnGap='28px';" +
            "box.style.columnFill='auto';" +
            "box.innerHTML='<h2>'+c.title+'</h2>'+c.html;" +

            "requestAnimationFrame(function(){" +
            "var actualWidth=box.scrollWidth;" +
            "pagesCount=Math.max(1,Math.round((actualWidth+28)/(pageWidth+28)));" +
            "currentPage=Math.min(currentPage,pagesCount-1);" +
            "showPage();" +
            "AndroidBook.pageCount(pagesCount);" +
            "});" +
            "}" +

            "function showPage(){" +
            "var box=document.getElementById('pages');" +
            "var viewport=document.getElementById('viewport');" +
            "var pageWidth=viewport.clientWidth-28;" +
            "box.style.transform='translateX(-'+(currentPage*(pageWidth+28))+'px)';" +
            "AndroidBook.pageChanged(currentPage);" +
            "}" +

            "function goPage(p){" +
            "currentPage=Math.max(0,Math.min(p,pagesCount-1));" +
            "showPage();" +
            "}" +

            "function resizeBook(){" +
            "currentPage=0;" +
            "renderChapter();" +
            "}" +

            "window.onload=renderChapter;" +
            "window.onresize=resizeBook;" +
            "</script></body></html>";

    bookView.loadDataWithBaseURL(
            "file:///android_asset/",
            html,
            "text/html",
            "UTF-8",
            null
    );

} catch (Exception e) {
    Toast.makeText(
            activity,
            "Could not open this chapter.",
            Toast.LENGTH_LONG
    ).show();
}

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
        Toast.makeText(
                activity,
                "You have reached the end of the book.",
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

private static GradientDrawable makeBackground(
        int backgroundColor, int strokeColor) {

    GradientDrawable drawable = new GradientDrawable();
    drawable.setColor(backgroundColor);
    drawable.setCornerRadius(18);
    drawable.setStroke(2, strokeColor);
    return drawable;
}

private static void returnToBooks() {
    if (activity instanceof MainActivity) {
        ((MainActivity) activity).showSpiritualBooks();
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
            updateIndicator();
        });
    }
}

                }
