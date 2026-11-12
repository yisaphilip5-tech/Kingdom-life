package com.kingdomlife.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import android.content.SharedPreferences;
import java.util.Calendar;

public class KingdomSermonsActivity extends Activity {

    private LinearLayout content;

    private final int PURPLE = Color.rgb(45, 30, 75);
    private final int GOLD = Color.rgb(184, 134, 11);
    private final int DARK_TEXT = Color.rgb(35, 30, 45);

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ScrollView scrollView = new ScrollView(this);

    content = new LinearLayout(this);
    content.setOrientation(LinearLayout.VERTICAL);
    content.setPadding(20, 15, 20, 25);

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

    showSermonChoices();
}

    private void applyKingdomBackground() {

        SharedPreferences prefs = getSharedPreferences(
                "KingdomLifeDisplayPrefs",
                MODE_PRIVATE
        );

        String mode = prefs.getString("displayMode", "AUTO");

        boolean isNight;

        if (mode.equals("NIGHT")) {
            isNight = true;
        } else if (mode.equals("DAY")) {
            isNight = false;
        } else {
            int hour = Calendar.getInstance()
                    .get(Calendar.HOUR_OF_DAY);

            isNight = hour < 6 || hour >= 18;
        }

        content.setBackgroundResource(
                isNight
                        ? R.drawable.kingdom_night_bg
                        : R.drawable.kingdom_home_bg
        );
    }

    private void showSermonChoices() {

        content.removeAllViews();

        ImageButton backButton = new ImageButton(this);

backButton.setImageResource(
        android.R.drawable.ic_media_previous
);

backButton.setBackgroundColor(Color.TRANSPARENT);
backButton.setContentDescription("Back");

backButton.setOnClickListener(v -> finish());

content.addView(
        backButton,
        new LinearLayout.LayoutParams(
                dp(60),
                dp(60)
        )
);
        TextView title = new TextView(this);
        title.setText("Kingdom Sermons");
        title.setTextSize(27);
        title.setTextColor(Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 25, 0, 10);

        content.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Choose how you would like to receive the teachings.");
        subtitle.setTextSize(15);
        subtitle.setTextColor(Color.WHITE);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(10, 0, 10, 35);

        content.addView(subtitle);

        addChoiceCard(
                "📖  Written Sermons",
                "Read monthly teachings and explore the Word of God.",
                v -> startActivity(
                        new Intent(
                                KingdomSermonsActivity.this,
                                SermonsActivity.class
                        )
                )
        );

        addChoiceCard(
                "🎧  Audio Sermons",
                "Listen to sermons and explore available audio teachings.",
                v -> startActivity(
                        new Intent(
                                KingdomSermonsActivity.this,
                                AudioSermonsActivity.class
                        )
                )
        );
    }

    private void addChoiceCard(
            String heading,
            String description,
            View.OnClickListener listener
    ) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 22, 20, 22);

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.argb(235, 255, 255, 255));
        background.setCornerRadius(22);
        background.setStroke(3, GOLD);

        card.setBackground(background);
        card.setElevation(7);

        TextView title = new TextView(this);
        title.setText(heading);
        title.setTextSize(21);
        title.setTextColor(PURPLE);
        title.setTypeface(null, Typeface.BOLD);

        card.addView(title);

        TextView detail = new TextView(this);
        detail.setText(description);
        detail.setTextSize(15);
        detail.setTextColor(DARK_TEXT);
        detail.setPadding(0, 10, 0, 5);

        card.addView(detail);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 0, 0, 22);

        content.addView(card, params);

        card.setOnClickListener(listener);
    }
          }
