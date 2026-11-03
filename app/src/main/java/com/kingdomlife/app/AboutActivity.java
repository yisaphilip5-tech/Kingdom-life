package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.view.ViewGroup;

import java.util.Calendar;

public class AboutActivity extends Activity {

private LinearLayout rootLayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    createAboutPage();
}

private void createAboutPage() {

    rootLayout = new LinearLayout(this);
rootLayout.setOrientation(LinearLayout.VERTICAL);

rootLayout.setPadding(12, 12, 12, 12);

// Keep the About screen clear of the phone's system bars.
rootLayout.setOnApplyWindowInsetsListener((view, insets) -> {
    view.setPadding(
            12 + insets.getSystemWindowInsetLeft(),
            12 + insets.getSystemWindowInsetTop(),
            12 + insets.getSystemWindowInsetRight(),
            12 + insets.getSystemWindowInsetBottom()
    );

    return insets;
});

applyDisplayBackground();

// Top-left back arrow
android.widget.ImageButton backButton =
        new android.widget.ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);
backButton.setScaleX(1.8f);
backButton.setScaleY(1.8f);
backButton.setContentDescription("Back to previous screen");
backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setScaleType(
        android.widget.ImageView.ScaleType.CENTER_INSIDE
);

backButton.setOnClickListener(v -> finish());

LinearLayout.LayoutParams arrowParams =
        new LinearLayout.LayoutParams(70, 70);

arrowParams.setMargins(4, 0, 0, 6);

rootLayout.addView(backButton, arrowParams);

    ScrollView scrollView = new ScrollView(this);
    scrollView.setFillViewport(true);

    LinearLayout aboutLayout = new LinearLayout(this);
    aboutLayout.setOrientation(LinearLayout.VERTICAL);
    aboutLayout.setPadding(4, 8, 4, 16);

    addSection(
            aboutLayout,
            "ℹ️ About Kingdom Life",
            "Kingdom Life is a Christian app created to encourage people to grow in their knowledge of God's Word, strengthen their faith and develop a closer walk with Him."
    );

    addSection(
            aboutLayout,
            "🎯 Our Mission",
            "Our mission is to encourage spiritual growth through Bible learning, prayer, reflection and activities that help users understand and apply God's Word in their daily lives."
    );

    addSection(
            aboutLayout,
            "🌟 Our Vision",
            "Our vision is to build a helpful and engaging Christian learning experience that inspires people to grow in faith, live according to God's Word and make a positive difference in the world."
    );

    addSection(
            aboutLayout,
            "👑 Our Motto",
            "Grow in faith. Live with purpose."
    );

    addSection(
            aboutLayout,
            "🙏 Acknowledgements",
            "First and foremost, we give all glory, honour and thanksgiving to God Almighty, whose grace, wisdom and strength have made the development of Kingdom Life possible. We acknowledge His guidance throughout this journey and recognise that every good achievement comes through Him.\n\n" +
            "We also sincerely appreciate everyone who contributed ideas, corrections, constructive feedback and suggestions during the development of this app. Your contributions helped us identify areas for improvement and make Kingdom Life better.\n\n" +
            "To everyone who played a part, whether through direct assistance, encouragement or valuable suggestions, we are truly grateful.\n\n" +
            "To God be all the glory."
    );

    addSection(
            aboutLayout,
            "📱 App Information",
            "Kingdom Life\nVersion 5"
    );

    addSection(
            aboutLayout,
            "🔒 Privacy",
            "Kingdom Life may store information such as saved verses, notes, bookmarks and learning progress on your device to support its features. Please avoid entering sensitive personal information into the app."
    );

    scrollView.addView(aboutLayout);

    rootLayout.addView(
            scrollView,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    0,
                    1
            )
    );

    setContentView(rootLayout);
}

private void addSection(
        LinearLayout parent,
        String heading,
        String description
) {

    LinearLayout section = new LinearLayout(this);
    section.setOrientation(LinearLayout.VERTICAL);
    section.setPadding(16, 14, 16, 14);

    GradientDrawable background = new GradientDrawable();
    background.setColor(Color.argb(235, 255, 255, 255));
    background.setCornerRadius(24);
    background.setStroke(2, Color.rgb(184, 134, 11));

    section.setBackground(background);
    section.setElevation(5);

    TextView title = new TextView(this);
    title.setText(heading);
    title.setTextSize(19);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(Color.rgb(75, 35, 115));
    title.setPadding(0, 0, 0, 10);

    section.addView(title);

    TextView text = new TextView(this);
    text.setText(description);
    text.setTextSize(16);
    text.setTextColor(Color.rgb(45, 45, 45));
    text.setLineSpacing(4, 1.0f);

    section.addView(text);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    params.setMargins(4, 7, 4, 7);

    parent.addView(section, params);
}

private void applyDisplayBackground() {

    SharedPreferences displayPrefs =
            getSharedPreferences(
                    "KingdomLifeDisplayPrefs",
                    MODE_PRIVATE
            );

    String displayMode =
            displayPrefs.getString("displayMode", "AUTO");

    if (displayMode.equals("DAY")) {

        rootLayout.setBackgroundResource(
                R.drawable.kingdom_home_bg
        );

    } else if (displayMode.equals("NIGHT")) {

        rootLayout.setBackgroundResource(
                R.drawable.kingdom_night_bg
        );

    } else {

        int hour = Calendar.getInstance()
                .get(Calendar.HOUR_OF_DAY);

        if (hour >= 6 && hour < 18) {

            rootLayout.setBackgroundResource(
                    R.drawable.kingdom_home_bg
            );

        } else {

            rootLayout.setBackgroundResource(
                    R.drawable.kingdom_night_bg
            );
        }
    }
}

                     }
