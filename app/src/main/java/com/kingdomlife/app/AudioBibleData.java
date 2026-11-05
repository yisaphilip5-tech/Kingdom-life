package com.kingdomlife.app;

import java.util.Locale;

public final class AudioBibleData {

private AudioBibleData() {
    // Prevent object creation.
}

public static class Book {

    public final String name;
    public final String audioCode;
    public final int chapters;

    public Book(String name, String audioCode, int chapters) {
        this.name = name;
        this.audioCode = audioCode;
        this.chapters = chapters;
    }
}

public static final Book[] BOOKS = {

        // OLD TESTAMENT

        new Book("Genesis", "GEN", 50),
        new Book("Exodus", "EXO", 40),
        new Book("Leviticus", "LEV", 27),
        new Book("Numbers", "NUM", 36),
        new Book("Deuteronomy", "DEU", 34),
        new Book("Joshua", "JOS", 24),
        new Book("Judges", "JDG", 21),
        new Book("Ruth", "RUT", 4),
        new Book("1 Samuel", "1SA", 31),
        new Book("2 Samuel", "2SA", 24),
        new Book("1 Kings", "1KI", 22),
        new Book("2 Kings", "2KI", 25),
        new Book("1 Chronicles", "1CH", 29),
        new Book("2 Chronicles", "2CH", 36),
        new Book("Ezra", "EZR", 10),
        new Book("Nehemiah", "NEH", 13),
        new Book("Esther", "EST", 10),
        new Book("Job", "JOB", 42),
        new Book("Psalms", "PSA", 150),
        new Book("Proverbs", "PRO", 31),
        new Book("Ecclesiastes", "ECC", 12),
        new Book("Song of Solomon", "SNG", 8),
        new Book("Isaiah", "ISA", 66),
        new Book("Jeremiah", "JER", 52),
        new Book("Lamentations", "LAM", 5),
        new Book("Ezekiel", "EZK", 48),
        new Book("Daniel", "DAN", 12),
        new Book("Hosea", "HOS", 14),
        new Book("Joel", "JOL", 3),
        new Book("Amos", "AMO", 9),
        new Book("Obadiah", "OBA", 1),
        new Book("Jonah", "JON", 4),
        new Book("Micah", "MIC", 7),
        new Book("Nahum", "NAM", 3),
        new Book("Habakkuk", "HAB", 3),
        new Book("Zephaniah", "ZEP", 3),
        new Book("Haggai", "HAG", 2),
        new Book("Zechariah", "ZEC", 14),
        new Book("Malachi", "MAL", 4),

        // NEW TESTAMENT

        new Book("Matthew", "MAT", 28),
        new Book("Mark", "MRK", 16),
        new Book("Luke", "LUK", 24),
        new Book("John", "JHN", 21),
        new Book("Acts", "ACT", 28),
        new Book("Romans", "ROM", 16),
        new Book("1 Corinthians", "1CO", 16),
        new Book("2 Corinthians", "2CO", 13),
        new Book("Galatians", "GAL", 6),
        new Book("Ephesians", "EPH", 6),
        new Book("Philippians", "PHP", 4),
        new Book("Colossians", "COL", 4),
        new Book("1 Thessalonians", "1TH", 5),
        new Book("2 Thessalonians", "2TH", 3),
        new Book("1 Timothy", "1TI", 6),
        new Book("2 Timothy", "2TI", 4),
        new Book("Titus", "TIT", 3),
        new Book("Philemon", "PHM", 1),
        new Book("Hebrews", "HEB", 13),
        new Book("James", "JAS", 5),
        new Book("1 Peter", "1PE", 5),
        new Book("2 Peter", "2PE", 3),
        new Book("1 John", "1JN", 5),
        new Book("2 John", "2JN", 1),
        new Book("3 John", "3JN", 1),
        new Book("Jude", "JUD", 1),
        new Book("Revelation", "REV", 22)
};

public static final String TRANSLATION_KJV = "KJV";
public static final String TRANSLATION_WEB = "WEB";

private static final String KJV_BASE_URL =
        "https://www.publicdomainaudiobibles.com/content/mp3/KJV/";

public static int getBookCount() {
    return BOOKS.length;
}

public static Book getBook(int position) {

    if (position < 0 || position >= BOOKS.length) {
        return null;
    }

    return BOOKS[position];
}

public static Book findBook(String bookName) {

    if (bookName == null) {
        return null;
    }

    for (Book book : BOOKS) {

        if (book.name.equalsIgnoreCase(bookName.trim())) {
            return book;
        }
    }

    return null;
}

public static int getChapterCount(String bookName) {

    Book book = findBook(bookName);

    return book == null ? 0 : book.chapters;
}

public static boolean isValidChapter(
        String bookName,
        int chapter) {

    Book book = findBook(bookName);

    return book != null
            && chapter >= 1
            && chapter <= book.chapters;
}

public static String getAudioUrl(
        String translation,
        String bookName,
        int chapter) {

    if (!isValidChapter(bookName, chapter)) {
        return null;
    }

    Book book = findBook(bookName);

    if (translation == null) {
        return null;
    }

    if (TRANSLATION_KJV.equalsIgnoreCase(translation)) {

        return KJV_BASE_URL
                + book.audioCode
                + String.format(
                        Locale.US,
                        "%02d",
                        chapter
                )
                + ".mp3";
    }

    // WEB audio URL will be added after its
    // exact chapter-file structure is verified.

    return null;
}

        }
