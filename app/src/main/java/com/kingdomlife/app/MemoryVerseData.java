package com.kingdomlife.app;

public class MemoryVerseData {

    public static class MemoryVerse {
        public String reference;
        public String verse;

        public MemoryVerse(
                String reference,
                String verse
        ) {
            this.reference = reference;
            this.verse = verse;
        }
    }

    // Guess the Verse — Level 1
    public static final MemoryVerse[] GUESS_VERSE_LEVEL_1 = {

        new MemoryVerse(
                "Psalm 23:1",
                "The LORD is my shepherd; I shall not want."
        ),

        new MemoryVerse(
                "Philippians 4:13",
                "I can do all things through Christ which strengtheneth me."
        ),

        new MemoryVerse(
                "Proverbs 3:5",
                "Trust in the LORD with all thine heart; and lean not unto thine own understanding."
        ),

        new MemoryVerse(
                "John 3:16",
                "For God so loved the world, that he gave his only begotten Son..."
        ),

        new MemoryVerse(
                "Psalm 119:105",
                "Thy word is a lamp unto my feet, and a light unto my path."
        )
    };
}
