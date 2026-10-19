package com.kingdomlife.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PilgrimsProgressBook {

    public static void open(Activity activity, LinearLayout content) {
        content.removeAllViews();

        TextView title = new TextView(activity);
        title.setText("The Pilgrim's Progress");
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(Color.rgb(184, 134, 11));
        title.setPadding(0, 20, 0, 15);
        content.addView(title);

        TextView author = new TextView(activity);
        author.setText("By John Bunyan");
        author.setTextSize(16);
        author.setTextColor(Color.DKGRAY);
        author.setPadding(0, 0, 0, 20);
        content.addView(author);

        TextView introduction = new TextView(activity);
        introduction.setText(
                "Welcome to The Pilgrim's Progress.\n\n" +
                "This classic Christian allegory follows a pilgrim " +
                "on his journey toward the Celestial City.\n\n" +
                "Along the way, he faces difficulties, temptations, " +
                "and choices that test his faith.\n\n" +
                "The book explores perseverance, faith in God, " +
                "and the challenges of the Christian journey.\n\n" +
                "The reading chapters will be added next."
        );
        introduction.setTextSize(18);
        introduction.setTextColor(Color.DKGRAY);
        introduction.setLineSpacing(6, 1.0f);
        introduction.setPadding(0, 10, 0, 25);
        content.addView(introduction);
    }
}
