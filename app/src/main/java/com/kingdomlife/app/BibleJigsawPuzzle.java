package com.kingdomlife.app;

import android.app.Activity;
import android.widget.LinearLayout;

public class BibleJigsawPuzzle {

    private final Activity activity;
    private final LinearLayout content;

    public BibleJigsawPuzzle(
            Activity activity,
            LinearLayout content
    ) {
        this.activity = activity;
        this.content = content;
    }

}
