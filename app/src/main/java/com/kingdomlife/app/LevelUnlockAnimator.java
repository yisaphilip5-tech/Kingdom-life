package com.kingdomlife.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public final class LevelUnlockAnimator {

    private static final int GOLD =
            Color.rgb(212, 175, 55);

    private LevelUnlockAnimator() {
        // Utility class.
    }

    public static void animateUnlock(
            View lockIcon,
            TextView levelTitle,
            MainActivity activity,
            String levelName
    ) {
        if (lockIcon == null
                || levelTitle == null
                || activity == null) {
            return;
        }

        // Prevent duplicate animations on the same view.
        if (lockIcon.getTag() != null
                && Boolean.TRUE.equals(lockIcon.getTag())) {
            return;
        }

        lockIcon.setTag(Boolean.TRUE);

        levelTitle.animate().cancel();
        lockIcon.animate().cancel();

        Toast.makeText(
                activity,
                "🎉 " + levelName + " Unlocked!",
                Toast.LENGTH_SHORT
        ).show();

        // Briefly highlight the newly unlocked level.
        levelTitle.setTextColor(GOLD);

        levelTitle.animate()
                .alpha(0.5f)
                .setDuration(180)
                .withEndAction(() ->
                        levelTitle.animate()
                                .alpha(1f)
                                .setDuration(250)
                                .start()
                )
                .start();

        // Open, rotate, drop, and fade away the lock.
        lockIcon.animate()
                .rotation(-25f)
                .setDuration(180)
                .setInterpolator(
                        new AccelerateInterpolator()
                )
                .withEndAction(() ->
                        lockIcon.animate()
                                .translationY(80f)
                                .rotation(35f)
                                .alpha(0f)
                                .setDuration(550)
                                .setInterpolator(
                                        new AccelerateInterpolator()
                                )
                                .setListener(
                                        new AnimatorListenerAdapter() {
                                            @Override
                                            public void onAnimationEnd(
                                                    Animator animation) {
                                                lockIcon.setVisibility(
                                                        View.GONE
                                                );

                                                lockIcon.setAlpha(1f);
                                                lockIcon.setTranslationY(0f);
                                                lockIcon.setRotation(0f);
                                            }
                                        }
                                )
                                .start()
                )
                .start();
    }
}
