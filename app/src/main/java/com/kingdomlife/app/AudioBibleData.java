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

    private static final String WEB_BASE_URL =
        "https://ebible.org/eng-web/audio/";
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

    if (translation == null || book == null) {
        return null;
    }

    // KJV AUDIO
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

    // WEB AUDIO
    if (TRANSLATION_WEB.equalsIgnoreCase(translation)) {

        int bookIndex = -1;
        int previousChapters = 0;

        for (int i = 0; i < BOOKS.length; i++) {

            if (BOOKS[i].name.equalsIgnoreCase(book.name)) {
                bookIndex = i;
                break;
            }

            previousChapters += BOOKS[i].chapters;
        }

        if (bookIndex == -1) {
            return null;
        }
        // WEB Updated audio: Mark through Romans
if (bookIndex >= 40 && bookIndex <= 44) {

    int webuBookNumber = 71 + (bookIndex - 40);

    String fileName = String.format(
            Locale.US,
            "WEB-%03d-%s_%02d.mp3",
            webuBookNumber,
            book.name,
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
// WEB Updated audio: 1 Corinthians through Philippians
if (bookIndex >= 45 && bookIndex <= 49) {

    int webuBookNumber = 76 + (bookIndex - 45);
    String audioBookCode = "";

    switch (bookIndex) {
        case 45:
            audioBookCode = "1_Cor";
            break;
        case 46:
            audioBookCode = "2_Cor";
            break;
        case 47:
            audioBookCode = "Gal";
            break;
        case 48:
            audioBookCode = "Eph";
            break;
        case 49:
            audioBookCode = "PHN";
            break;
    }

    String fileName = String.format(
            Locale.US,
            "WEB-%03d-%s_%02d.mp3",
            webuBookNumber,
            audioBookCode,
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
// WEB Updated audio: Colossians through 2 Timothy
if (bookIndex >= 50 && bookIndex <= 54) {

    int webuBookNumber = 81 + (bookIndex - 50);
    String audioBookCode = "";

    switch (bookIndex) {
        case 50:
            audioBookCode = "COL";
            break;
        case 51:
            audioBookCode = "1TH";
            break;
        case 52:
            audioBookCode = "2TH";
            break;
        case 53:
            audioBookCode = "1TI";
            break;
        case 54:
            audioBookCode = "2TI";
            break;
    }

    String fileName = String.format(
            Locale.US,
            "WEB-%03d-%s_%02d.mp3",
            webuBookNumber,
            audioBookCode,
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
// WEB Updated audio: Titus through 1 Peter
if (bookIndex >= 55 && bookIndex <= 59) {

    int webuBookNumber = 86 + (bookIndex - 55);
    String audioBookCode = "";

    switch (bookIndex) {
        case 55: audioBookCode = "TIT"; break;
        case 56: audioBookCode = "PHM"; break;
        case 57: audioBookCode = "HEB"; break;
        case 58: audioBookCode = "JAS"; break;
        case 59: audioBookCode = "1PE"; break;
    }

    String fileName = String.format(
            Locale.US,
            "WEB-%03d-%s_%02d.mp3",
            webuBookNumber,
            audioBookCode,
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
 // WEB Updated audio: 2 Peter through Jude
if (bookIndex >= 60 && bookIndex <= 64) {

    int webuBookNumber = 91 + (bookIndex - 60);
    String audioBookCode = "";

    switch (bookIndex) {
        case 60: audioBookCode = "2PE"; break;
        case 61: audioBookCode = "1JN"; break;
        case 62: audioBookCode = "2JN"; break;
        case 63: audioBookCode = "3JN"; break;
        case 64: audioBookCode = "JUD"; break;
    }

    String fileName = String.format(
            Locale.US,
            "WEB-%03d-%s_%02d.mp3",
            webuBookNumber,
            audioBookCode,
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
// WEB Updated audio: Revelation
if (bookIndex == 65) {

    String fileName = String.format(
            Locale.US,
            "WEB-096-REV_%02d.mp3",
            chapter
    );

    return "https://ebible.org/engwebu/mp3/" + fileName;
}
        
        

        int trackNumber = previousChapters + chapter;
        int webTrackNumber = trackNumber;

if ((bookIndex == 22 && chapter >= 17) || bookIndex > 22) {
    webTrackNumber--;
}

        String audioBookName =
                getWebBookTitle(book.name);

        String folderName =
                String.format(Locale.US, "%02d", bookIndex + 1)
                + "_"
                + audioBookName.replace(" ", "_");


String fileName;

if (book.name.equals("Genesis")) {

    fileName = "01_"
            + String.format(Locale.US, "%02d", chapter)
            + "_Genesis_Chapter_"
            + numberToWords(chapter)
            + ".mp3";

}
else if (book.name.equals("Psalms")) {

    fileName = String.format(Locale.US, "%04d", trackNumber)
            + " Psalms-"
            + numberToWords(chapter)
            + ".mp3";

}
else if (bookIndex == 8) {

    // 1 Samuel
    fileName = "09_"
            + String.format(Locale.US, "%02d", chapter + 36)
            + "_First_Samuel_Chapter_"
            + numberToWords(chapter).replace(" ", "_")
            + ".mp3";

}
else if (bookIndex >= 9 && bookIndex <= 12) {

    // 2 Samuel through 1 Chronicles
    fileName = "01 "
            + String.format(Locale.US, "%04d", trackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
    
else if (bookIndex == 13 || bookIndex == 14) {

    // 2 Chronicles and Ezra
    fileName = String.format(Locale.US, "%04d", trackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
else if (bookIndex >= 15 && bookIndex <= 17) {

    // Nehemiah, Esther and Job
    fileName = "01 "
            + String.format(Locale.US, "%04d", trackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
    
else if (bookIndex == 19) {

    // Proverbs
    fileName = String.format(Locale.US, "%04d", trackNumber)
            + " Proverbs-Chapter "
            + String.format(Locale.US, "%03d", chapter)
            + ".mp3";

}
else if (bookIndex == 20 || bookIndex == 21) {

    // Ecclesiastes and Song of Solomon
    fileName = String.format(Locale.US, "%04d", trackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
else if (bookIndex >= 22 && bookIndex <= 28) {
    // Isaiah and Jeremiah
    fileName = "01 "
            + String.format(Locale.US, "%04d", webTrackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
    
else if (bookIndex >= 29 && bookIndex <= 39) {

    // Amos, Obadiah, Jonah, Micah and Nahum
    fileName = "01 "
            + String.format(Locale.US, "%04d", webTrackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";

}
    
    
else if (bookIndex < 39) {

    // Earlier Old Testament books
    fileName = String.format(Locale.US, "%02d", bookIndex + 1)
            + "_"
            + String.format(Locale.US, "%02d", chapter)
            + "_"
            + audioBookName.replace(" ", "_")
            + "_Chapter_"
            + numberToWords(chapter).replace(" ", "_")
            + ".mp3";

}
else {

    // New Testament
    fileName = "01 "
            + String.format(Locale.US, "%04d", trackNumber)
            + " "
            + audioBookName
            + "-Chapter "
            + numberToWords(chapter)
            + ".mp3";
}
        
        

        return WEB_BASE_URL
                + folderName
                + "/"
                + fileName.replace(" ", "%20");
    }

    return null;
}
    private static String getWebBookTitle(String bookName) {

    switch (bookName) {

        case "1 Samuel": return "First Samuel";
        case "2 Samuel": return "Second Samuel";

        case "1 Kings": return "First Kings";
        case "2 Kings": return "Second Kings";

        case "1 Chronicles": return "First Chronicles";
        case "2 Chronicles": return "Second Chronicles";

        case "1 Corinthians": return "First Corinthians";
        case "2 Corinthians": return "Second Corinthians";

        case "1 Thessalonians": return "First Thessalonians";
        case "2 Thessalonians": return "Second Thessalonians";

        case "1 Timothy": return "First Timothy";
        case "2 Timothy": return "Second Timothy";

        case "1 Peter": return "First Peter";
        case "2 Peter": return "Second Peter";

        case "1 John": return "First John";
        case "2 John": return "Second John";
        case "3 John": return "Third John";

        case "Revelation": return "Revelations";

        default:
            return bookName;
    }
}

private static String numberToWords(int number) {

    String[] ones = {
            "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"
    };

    if (number < 20) {
        return ones[number];
    }

    if (number < 100) {

        return tens[number / 10]
                + (number % 10 == 0
                ? ""
                : " " + ones[number % 10]);
    }

    if (number < 1000) {

        return ones[number / 100]
                + " Hundred"
                + (number % 100 == 0
                ? ""
                : " " + numberToWords(number % 100));
    }

    return "";
}
}
