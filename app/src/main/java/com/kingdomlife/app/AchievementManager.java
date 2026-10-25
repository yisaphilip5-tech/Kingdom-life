package com.kingdomlife.app;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class AchievementManager {

    private static final String PREFS_NAME = "KingdomLifePrefs";

    private static final String INITIALIZED_KEY =
            "achievement_states_initialized";

    private final SharedPreferences prefs;

    public AchievementManager(Context context) {
        prefs = context.getApplicationContext()
                .getSharedPreferences(
                        PREFS_NAME,
                        Context.MODE_PRIVATE
                );
    }

    public boolean isUnlocked(String achievementKey) {
        return prefs.getBoolean(
                "achievement_unlocked_" + achievementKey,
                false
        );
    }

    public void setUnlocked(
            String achievementKey,
            boolean unlocked
    ) {
        prefs.edit()
                .putBoolean(
                        "achievement_unlocked_" + achievementKey,
                        unlocked
                )
                .apply();
    }

    public List<String> updateAchievementStates(
            List<AchievementData> achievements,
            boolean[] unlockedStates
    ) {
        List<String> newlyUnlocked = new ArrayList<>();

        if (achievements == null
                || unlockedStates == null
                || achievements.size() != unlockedStates.length) {
            throw new IllegalArgumentException(
                    "Achievement definitions and unlock states must match."
            );
        }

        boolean initialized = prefs.getBoolean(
                INITIALIZED_KEY,
                false
        );

        SharedPreferences.Editor editor = prefs.edit();

        for (int i = 0; i < achievements.size(); i++) {
            AchievementData achievement = achievements.get(i);

            String stateKey =
                    "achievement_unlocked_" + achievement.key;

            boolean previouslyUnlocked = prefs.getBoolean(
                    stateKey,
                    false
            );

            boolean currentlyUnlocked = unlockedStates[i];

            if (!initialized) {
                // Establish the initial state without triggering
                // notifications for achievements already earned.
                editor.putBoolean(
                        stateKey,
                        currentlyUnlocked
                );
            } else {
                if (currentlyUnlocked && !previouslyUnlocked) {
                    newlyUnlocked.add(achievement.key);

                    editor.putBoolean(
                            "pending_achievement_animation_"
                                    + achievement.key,
                            true
                    );
                }

                editor.putBoolean(
                        stateKey,
                        currentlyUnlocked
                );
            }
        }

        editor.putBoolean(INITIALIZED_KEY, true);
        editor.apply();

        return newlyUnlocked;
    }

    public boolean consumePendingAnimation(
            String achievementKey
    ) {
        String pendingKey =
                "pending_achievement_animation_" + achievementKey;

        boolean pending = prefs.getBoolean(
                pendingKey,
                false
        );

        if (pending) {
            prefs.edit()
                    .putBoolean(pendingKey, false)
                    .apply();
        }

        return pending;
    }
}
