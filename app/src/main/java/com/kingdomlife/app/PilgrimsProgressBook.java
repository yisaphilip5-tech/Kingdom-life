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
public static void continueReading(
        Activity a,
        LinearLayout container) {

    resumeWhenReady = true;
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
            android.content.SharedPreferences prefs =
                    activity.getSharedPreferences(
                            "PilgrimsProgressReadingProgress",
                            Activity.MODE_PRIVATE
                    );

            int savedChapter = prefs.getInt("lastChapter", 0);
            int savedPage = prefs.getInt("lastPage", 0);

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


    private static void loadReaderHtml() {
try {
String chapterJson = chapters.toString();

    String html =
            "<!DOCTYPE html><html><head>" +
            "<meta name='viewport' content='width=device-width, initial-scale=1'>" +
            "<style>" +
            "*{box-sizing:border-box;}" +
            "html,body{margin:0;padding:0;width:100%;height:100%;overflow:hidden;background:#fff;}" +
            "#viewport{width:100%;height:100%;min-height:100vh;padding:14px;overflow:hidden;}" +
            "#page{width:100%;height:100%;overflow:hidden;" +
            "font-family:Georgia,serif;font-size:18px;line-height:1.5;color:#222;}" +
            "#page h1,#page h2,#page h3,#page h4{margin-top:0;}" +
            "#page img{max-width:100%;height:auto;}" +
            "#page p{margin:0 0 12px 0;}" +
            "#measure{position:absolute;left:-10000px;top:0;visibility:hidden;" +
            "width:calc(100vw - 28px);font-family:Georgia,serif;" +
            "font-size:18px;line-height:1.5;}" +
            "</style></head><body>" +
            "<div id='viewport'><div id='page'></div></div>" +
            "<div id='measure'></div>" +
            "<script>" +
            "var allChapters=" + chapterJson + ";" +
            "var currentChapter=" + chapterIndex + ";" +
            "var currentPage=" + pageIndex + ";" +
            "var pages=[];" +

            "function makePages(){" +
"var c=allChapters[currentChapter];" +
"var source=document.createElement('div');" +
"source.innerHTML='<h2>'+c.title+'</h2>'+c.html;" +
"var measure=document.getElementById('measure');" +
"var viewport=document.getElementById('viewport');" +
"var available=viewport.clientHeight-28;" +
"measure.style.width=(viewport.clientWidth-28)+'px';" +
"measure.style.height=available+'px';" +
"measure.style.overflow='hidden';" +
"measure.style.padding='0';" +
"measure.style.visibility='hidden';" +
"measure.style.position='absolute';" +
"measure.innerHTML='';" +
"pages=[];" +
"var currentHtml='';" +
"function fits(html){" +
"measure.innerHTML=html;" +
"return measure.scrollHeight<=measure.clientHeight+1;" +
"}" +
"function savePage(){" +
"if(currentHtml.trim()!=='')pages.push(currentHtml);" +
"currentHtml='';" +
"}" +
"var blocks=Array.from(source.childNodes);" +
"blocks.forEach(function(node){" +
"if(node.nodeType===3&&!node.textContent.trim())return;" +
"var html=node.nodeType===3?" +
"'<p>'+node.textContent+'</p>':node.outerHTML;" +
"var candidate=currentHtml+html;" +
"if(fits(candidate)){" +
"currentHtml=candidate;" +
"return;" +
"}" +
"if(currentHtml!=='')savePage();" +
"if(fits(html)){" +
"currentHtml=html;" +
"return;" +
"}" +
"var text=node.textContent||'';" +
"var words=text.trim().split(/\\s+/);" +
"var chunk='';" +
"words.forEach(function(word){" +
"var next=chunk?chunk+' '+word:word;" +
"var paragraph='<p>'+next+'</p>';" +
"if(!fits(currentHtml+paragraph)&&chunk!==''){" +
"currentHtml+='<p>'+chunk+'</p>';" +
"savePage();" +
"chunk=word;" +
"}else{" +
"chunk=next;" +
"}" +
"});" +
"if(chunk!==''){" +
"var paragraph='<p>'+chunk+'</p>';" +
"if(!fits(currentHtml+paragraph)&&currentHtml!=='')savePage();" +
"currentHtml+=paragraph;" +
"}" +
"});" +
"if(currentHtml.trim()!=='')pages.push(currentHtml);" +
"if(pages.length===0)pages.push(source.innerHTML);" +
"currentPage=Math.max(0,Math.min(currentPage,pages.length-1));" +
"showPage();" +
"AndroidBook.pageCount(pages.length);" +
"}" +

            "function showPage(){" +
"var page=document.getElementById('page');" +
"page.innerHTML=pages[currentPage]||'';" +
"AndroidBook.pageChanged(currentPage);" +
"}" +

"function goPage(p){" +
"var target=parseInt(p,10);" +
"if(isNaN(target))return;" +
"currentPage=Math.max(0,Math.min(target,pages.length-1));" +
"showPage();" +
"}" +

"window.onload=function(){setTimeout(makePages,100);};" +
"window.onresize=function(){" +
"setTimeout(function(){" +
"var oldPage=currentPage;" +
"makePages();" +
"currentPage=Math.max(0,Math.min(oldPage,pages.length-1));" +
"showPage();" +
"},150);" +
"};" +
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
if (activity instanceof MainActivity) {
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
