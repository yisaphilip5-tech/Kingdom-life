package com.kingdomlife.app;

import java.util.ArrayList;
import java.util.List;

public class AchievementData {

    public final String key;
    public final String name;
    public final String description;
    public final int badgeResource;
    public final int target;
    public final String category;

    public AchievementData(
            String key,
            String name,
            String description,
            int badgeResource,
            int target,
            String category
    ) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.badgeResource = badgeResource;
        this.target = target;
        this.category = category;
    }

    public static List<AchievementData> getAll() {

        List<AchievementData> achievements =
                new ArrayList<>();

        // POINTS AND DAILY PROGRESS

        achievements.add(new AchievementData(
                "first_step",
                "First Step",
                "Earn your first 5 points.",
                R.drawable.word_student,
                5,
                "Points"
        ));

        achievements.add(new AchievementData(
                "bible_learner",
                "Bible Learner",
                "Learn 5 Bible verses.",
                R.drawable.scripture_explorer,
                5,
                "Bible Learning"
        ));

        achievements.add(new AchievementData(
                "streak_keeper",
                "Streak Keeper",
                "Reach a 3-day streak.",
                R.drawable.streak_champion,
                3,
                "Daily Progress"
        ));

        achievements.add(new AchievementData(
                "point_builder",
                "Point Builder",
                "Earn 50 points.",
                R.drawable.level_up,
                50,
                "Points"
        ));

        achievements.add(new AchievementData(
                "challenge_complete",
                "Challenge Complete",
                "Complete today's challenge.",
                R.drawable.challenge_conqueror,
                1,
                "Daily Challenge"
        ));

        // BIBLE CHALLENGE

        achievements.add(new AchievementData(
                "easy_challenger",
                "Easy Challenger",
                "Complete Bible Challenge Level 1.",
                R.drawable.bible_challenge_master,
                1,
                "Bible Challenge"
        ));

        achievements.add(new AchievementData(
                "medium_challenger",
                "Medium Challenger",
                "Complete Bible Challenge Level 2.",
                R.drawable.bible_challenge_master,
                2,
                "Bible Challenge"
        ));

        achievements.add(new AchievementData(
                "hard_challenger",
                "Hard Challenger",
                "Complete Bible Challenge Level 3.",
                R.drawable.bible_challenge_master,
                3,
                "Bible Challenge"
        ));

        achievements.add(new AchievementData(
                "challenge_master",
                "Challenge Master",
                "Complete the original three Challenge levels.",
                R.drawable.challenge_conqueror,
                3,
                "Bible Challenge"
        ));

        // BIBLE JOURNEY QUESTIONS

        achievements.add(new AchievementData(
                "questions_100",
                "100 Questions",
                "Complete 100 Bible Journey questions.",
                R.drawable.bible_journey_master,
                100,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "questions_250",
                "250 Questions",
                "Complete 250 Bible Journey questions.",
                R.drawable.bible_journey_master,
                250,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "questions_500",
                "500 Questions",
                "Complete 500 Bible Journey questions.",
                R.drawable.bible_journey_master,
                500,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "questions_1000",
                "1,000 Questions",
                "Complete 1,000 Bible Journey questions.",
                R.drawable.bible_journey_master,
                1000,
                "Bible Journey"
        ));

        // BIBLE JOURNEY BOOKS

        achievements.add(new AchievementData(
                "books_5",
                "5 Books",
                "Complete 5 Bible Journey books.",
                R.drawable.scripture_explorer,
                5,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "books_10",
                "10 Books",
                "Complete 10 Bible Journey books.",
                R.drawable.scripture_explorer,
                10,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "books_25",
                "25 Books",
                "Complete 25 Bible Journey books.",
                R.drawable.scripture_explorer,
                25,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "books_50",
                "50 Books",
                "Complete 50 Bible Journey books.",
                R.drawable.scripture_explorer,
                50,
                "Bible Journey"
        ));

        achievements.add(new AchievementData(
                "books_66",
                "66 Books",
                "Complete all 66 Bible Journey books.",
                R.drawable.kingdom_champion,
                66,
                "Bible Journey"
        ));

        // BIBLE SCRAMBLE

        achievements.add(new AchievementData(
                "scramble_10_words",
                "The Scrambled Achiever",
                "Solve 10 Bible Scramble words.",
                R.drawable.bible_scramble_master,
                10,
                "Bible Scramble"
        ));

        achievements.add(new AchievementData(
                "scramble_25_words",
                "Master of Letters",
                "Solve 25 Bible Scramble words.",
                R.drawable.word_weaver,
                25,
                "Bible Scramble"
        ));

        achievements.add(new AchievementData(
                "scramble_75_words",
                "The Word Unraveller",
                "Solve 75 Bible Scramble words.",
                R.drawable.bible_scramble_master,
                75,
                "Bible Scramble"
        ));

        achievements.add(new AchievementData(
                "scramble_100_words",
                "Word Collector",
                "Solve 100 Bible Scramble words.",
                R.drawable.word_weaver,
                100,
                "Bible Scramble"
        ));

        achievements.add(new AchievementData(
                "scramble_200_words",
                "Word Conqueror",
                "Solve 200 Bible Scramble words.",
                R.drawable.bible_scramble_master,
                200,
                "Bible Scramble"
        ));

        achievements.add(new AchievementData(
                "scramble_250_words",
                "Bible Scramble Legend",
                "Solve all 250 Bible Scramble words.",
                R.drawable.kingdom_champion,
                250,
                "Bible Scramble"
        ));

        // JIGSAW PUZZLE

        achievements.add(new AchievementData(
                "big_picture",
                "The Big Picture",
                "Complete the original three Jigsaw Puzzle levels.",
                R.drawable.puzzle_pro,
                3,
                "Jigsaw Puzzle"
        ));

        achievements.add(new AchievementData(
                "jigsaw_10_levels",
                "Puzzle Beginner",
                "Complete 10 Jigsaw Puzzle levels.",
                R.drawable.puzzle_pro,
                10,
                "Jigsaw Puzzle"
        ));

        achievements.add(new AchievementData(
                "jigsaw_25_levels",
                "Puzzle Explorer",
                "Complete 25 Jigsaw Puzzle levels.",
                R.drawable.puzzle_pro,
                25,
                "Jigsaw Puzzle"
        ));

        achievements.add(new AchievementData(
                "jigsaw_50_levels",
                "Puzzle Champion",
                "Complete 50 Jigsaw Puzzle levels.",
                R.drawable.puzzle_pro,
                50,
                "Jigsaw Puzzle"
        ));

        achievements.add(new AchievementData(
                "jigsaw_75_levels",
                "Puzzle Master",
                "Complete 75 Jigsaw Puzzle levels.",
                R.drawable.puzzle_pro,
                75,
                "Jigsaw Puzzle"
        ));

        achievements.add(new AchievementData(
                "jigsaw_90_levels",
                "Jigsaw Legend",
                "Complete all 90 Jigsaw Puzzle levels.",
                R.drawable.kingdom_champion,
                90,
                "Jigsaw Puzzle"
        ));

        // MISSING WORD

        achievements.add(new AchievementData(
                "word_hearer",
                "The Word Hearer",
                "Answer 25 Missing Word questions correctly.",
                R.drawable.missing_word_master,
                25,
                "Missing Word"
        ));

        // GUESS THE REFERENCE

        achievements.add(new AchievementData(
                "scripture_detective",
                "The Scripture Detective",
                "Answer 25 Guess the Reference questions correctly.",
                R.drawable.memory_verse_master,
                25,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "reference_50",
                "Reference Explorer",
                "Answer 50 Guess the Reference questions correctly.",
                R.drawable.memory_verse_master,
                50,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "reference_100",
                "Reference Master",
                "Answer 100 Guess the Reference questions correctly.",
                R.drawable.kingdom_champion,
                100,
                "Memory Verse"
        ));

        // GUESS THE VERSE

        achievements.add(new AchievementData(
                "verse_guardian",
                "The Verse Guardian",
                "Answer 25 Guess the Verse questions correctly.",
                R.drawable.memory_verse_master,
                25,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "guess_verse_50",
                "Verse Explorer",
                "Answer 50 Guess the Verse questions correctly.",
                R.drawable.memory_verse_master,
                50,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "guess_verse_100",
                "Verse Champion",
                "Answer 100 Guess the Verse questions correctly.",
                R.drawable.kingdom_champion,
                100,
                "Memory Verse"
        ));

        // COMPLETE THE VERSE

        achievements.add(new AchievementData(
                "verse_finisher",
                "The Verse Finisher",
                "Complete 25 verses correctly.",
                R.drawable.word_student,
                25,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "complete_verse_50",
                "Verse Completer",
                "Complete 50 verses correctly.",
                R.drawable.word_student,
                50,
                "Memory Verse"
        ));

        achievements.add(new AchievementData(
                "complete_verse_100",
                "Scripture Finisher",
                "Complete 100 verses correctly.",
                R.drawable.kingdom_champion,
                100,
                "Memory Verse"
        ));

        // OTHER ACHIEVEMENTS

        achievements.add(new AchievementData(
        "word_student",
        "Word Student",
        "Complete all 30 Memory Verse levels across Guess the Verse, Complete the Verse, and Guess Reference.",
        R.drawable.word_student,
        30,
        "Memory Verse"
));

        achievements.add(new AchievementData(
                "finisher",
                "Finisher",
                "Complete all game modes and their required levels.",
                R.drawable.finisher,
                1,
                "All Games"
        ));

        achievements.add(new AchievementData(
                "gods_vessel_15",
                "God's Vessel",
                "Learn 15 Bible verses.",
                R.drawable.gods_vessel,
                15,
                "Bible Learning"
        ));

        achievements.add(new AchievementData(
                "gods_vessel_25",
                "God's Vessel: Faithful",
                "Learn 25 Bible verses.",
                R.drawable.gods_vessel,
                25,
                "Bible Learning"
        ));

        achievements.add(new AchievementData(
                "bible_challenge_master",
                "Bible Challenge Master",
                "Complete all five Bible Challenge levels.",
                R.drawable.bible_challenge_master,
                5,
                "Bible Challenge"
        ));

        return achievements;
    }
}
