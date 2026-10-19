package com.kingdomlife.app;

public class PilgrimsProgressData {

    public static final String BOOK_TITLE = "The Pilgrim's Progress";
    public static final String AUTHOR = "John Bunyan";

    public static final String[] CHAPTER_TITLES = {
            "Part One — The Pilgrim's Journey",
            "Part Two — The Journey Continued"
    };

    public static final String[] CHAPTER_CONTENT = {
            "A man named Christian learns that he carries a great burden. " +
            "He begins searching for a way to find deliverance and reach " +
            "the Celestial City. His journey will test his faith, courage, " +
            "and perseverance.",

            "The journey continues with further lessons about faith, " +
            "family, perseverance, and the challenges faced by pilgrims " +
            "on their way toward the Celestial City."
    };

    private PilgrimsProgressData() {
        // Prevent creation of unnecessary instances.
    }
}
