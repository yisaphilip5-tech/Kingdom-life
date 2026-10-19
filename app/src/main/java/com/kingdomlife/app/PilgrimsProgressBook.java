package com.kingdomlife.app;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PilgrimsProgressBook {

public static void open(Activity activity, LinearLayout content) {
    content.removeAllViews();

    ImageButton backButton = new ImageButton(activity);
    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setContentDescription("Back to Spiritual Books");

    backButton.setOnClickListener(v -> {
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).showSpiritualBooks();
        }
    });

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(60, 60)
    );

    TextView title = new TextView(activity);
    title.setText("The Pilgrim's Progress");
    title.setTextSize(24);
    title.setTextColor(Color.rgb(184, 134, 11));
    title.setPadding(0, 10, 0, 15);
    content.addView(title);

    WebView bookView = new WebView(activity);
    bookView.setBackgroundColor(Color.WHITE);

    WebSettings settings = bookView.getSettings();
    settings.setJavaScriptEnabled(false);
    settings.setAllowFileAccess(true);

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

}
