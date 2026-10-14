package com.kingdomlife.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class BibleJigsawPuzzle extends View {

    private final MainActivity activity;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public BibleJigsawPuzzle(MainActivity activity) {
    super(activity);
    this.activity = activity;
    setLayerType(View.LAYER_TYPE_SOFTWARE, null);

    setVisibility(View.VISIBLE);
    setBackgroundColor(Color.rgb(220, 240, 220));
    setMinimumHeight(1000);
    setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();

        // Background follows the saved display preference
android.content.SharedPreferences prefs =
        getContext().getSharedPreferences(
                "KingdomLifeDisplayPrefs",
                android.content.Context.MODE_PRIVATE
        );

String mode = prefs.getString("displayMode", "AUTO");

if (mode.equals("NIGHT")) {
    canvas.drawColor(Color.rgb(25, 35, 45));
} else {
    canvas.drawColor(Color.rgb(220, 240, 220));
}

        paint.setColor(Color.rgb(30, 90, 50));
        paint.setTextSize(32f);

        canvas.drawText("Bible Jigsaw Map", 20f, 50f, paint);

        paint.setTextSize(20f);
        canvas.drawText(
                "Map view size: " + (int) width + " x " + (int) height,
                20f,
                90f,
                paint
        );

        // Temporary winding path
        Path path = new Path();
        path.moveTo(width / 2f, 140f);
        path.cubicTo(
                width * 0.9f, 200f,
                width * 0.1f, 260f,
                width / 2f, 320f
        );

        paint.setColor(Color.rgb(190, 140, 40));
        paint.setStrokeWidth(12f);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL);

        // Temporary round markers
        paint.setColor(Color.rgb(255, 210, 70));
        canvas.drawCircle(width / 2f, 140f, 30f, paint);
        canvas.drawCircle(width * 0.8f, 230f, 30f, paint);
        canvas.drawCircle(width / 2f, 320f, 30f, paint);
    }
}
