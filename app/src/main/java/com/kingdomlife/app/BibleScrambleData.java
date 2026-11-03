package com.kingdomlife.app;

public class BibleScrambleData {

    public static String[] getWordsForLevel(int level) {

        switch (level) {

            case 1:
                return new String[]{
                        "JESUS",
                        "MOSES",
                        "DAVID",
                        "NOAH",
                        "FAITH",
                        "GRACE",
                        "PRAYER",
                        "ANGEL",
                        "CROSS",
                        "BIBLE",
                        "PEACE",
                        "PRAISE",
                        "HEAVEN",
                        "GOSPEL",
                        "SHEPHERD",
                        "PROPHET",
                        "DISCIPLE",
                        "MIRACLE",
                        "KINGDOM",
                        "SALVATION",
                        "ABRAHAM",
                        "JERUSALEM",
                        "SAMUEL",
                        "DANIEL",
                        "ESTHER"
                };

            case 2:
                return new String[]{
                        "GENESIS",
                        "EXODUS",
                        "LEVITICUS",
                        "NUMBERS",
                        "DEUTERONOMY",
                        "JOSHUA",
                        "JUDGES",
                        "RUTH",
                        "CHRONICLES",
                        "NEHEMIAH",
                        "EZRA",
                        "ISAIAH",
                        "JEREMIAH",
                        "EZEKIEL",
                        "HABAKKUK",
                        "ZEPHANIAH",
                        "MALACHI",
                        "MATTHEW",
                        "MARK",
                        "LUKE",
                        "JOHN",
                        "ACTS",
                        "ROMANS",
                        "PHILEMON",
                        "REVELATION"
                };

            case 3:
                return new String[]{
                        "RIGHTEOUSNESS",
                        "RESURRECTION",
                        "SANCTIFICATION",
                        "EVANGELIST",
                        "CORINTHIANS",
                        "THESSALONIANS",
                        "PHILIPPIANS",
                        "COLOSSIANS",
                        "MELCHIZEDEK",
                        "NEBUCHADNEZZAR",
                        "BETHLEHEM",
                        "GETHSEMANE",
                        "TABERNACLE",
                        "COVENANT",
                        "TESTAMENT",
                        "APOSTLE",
                        "DISCERNMENT",
                        "PERSEVERANCE",
                        "FORGIVENESS",
                        "CONSECRATION",
                        "PROCLAMATION",
                        "RECONCILIATION",
                        "INTERCESSION",
                        "OMNIPOTENT",
                        "OMNIPRESENT"
                };
                case 4:
return new String[]{
"JUSTIFICATION",
"GLORIFICATION",
"REGENERATION",
"PROPITIATION",
"IMPUTATION",
"TRANSGRESSION",
"INIQUITY",
"BENEDICTION",
"SUPPLICATION",
"EXHORTATION",
"EDIFICATION",
"ECCLESIASTES",
"LAMENTATIONS",
"DEUTERONOMY",
"ZECHARIAH",
"ZERUBBABEL",
"MEPHIBOSHETH",
"BARTHOLOMEW",
"CAPPADOCIA",
"EPAPHRODITUS",
"ONESIMUS",
"MELCHIZEDEK",
"ARMAGEDDON",
"APOCALYPSE",
"IMMANUEL"
};

        case 5:
return new String[]{
"MAHERSHALALHASHBAZ",
"CHEMARIM",
"HUPPAH",
"TIRHAKAH",
"AHASUERUS",
"MEHETABEL",
"ZAPHNATHPAANEAH",
"KIRJATHJEARIM",
"KIRIATHAIM",
"ENROGEL",
"BAALZEPHON",
"POTIPHAR",
"ZELPHEHAD",
"MIZRAIM",
"JECONIAH",
"JEHOIACHIN",
"ZERAH",
"ABISHAG",
"ELISHAMA",
"SHISHAK",
"TATTENAI",
"SHEALTIEL",
"ELIHOREPH",
"BENAIAH",
"JEHOZADAK"
};
        

                        default:
                return getWordsForLevel(1);
        }
    }

    // Returns one word for each of the 125 individual levels.
    public static String getWordForLevel(int level) {

        if (level < 1 || level > 125) {
            return null;
        }

        int originalLevel = ((level - 1) / 25) + 1;
        int questionIndex = (level - 1) % 25;

        String[] words = getWordsForLevel(originalLevel);

        return words[questionIndex];
    }
}
