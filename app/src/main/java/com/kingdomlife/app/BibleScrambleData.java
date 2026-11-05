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
"JABEZ",
"ZECHARIAH",
"ZERUBBABEL",
"MEPHIBOSHETH",
"BARTHOLOMEW",
"CAPPADOCIA",
"EPAPHRODITUS",
"ONESIMUS",
"BEZALEEL",
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
"ZELOPHEHAD",
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
                            case 6:
                return new String[]{
                        "ADAM", "EVE", "CAIN", "ABEL", "SETH",
                        "ENOCH", "METHUSELAH", "LAMECH", "JETHRO", "AARON",
                        "MIRIAM", "CALEB", "GIDEON", "SAMSON", "DELILAH",
                        "DEBORAH", "BARAK", "JEHOSHAPHAT", "HEZEKIAH", "JOSIAH",
                        "JOAB", "ABSALOM", "SOLOMON", "REHOBOAM", "JEROBOAM"
                };

            case 7:
                return new String[]{
                        "ELIZABETH", "ZACHARIAS", "SIMEON", "ANNA", "NICODEMUS",
                        "BARNABAS", "SILAS", "TIMOTHY", "TITUS", "STEPHEN",
                        "PHILIP", "MATTHIAS", "THOMAS", "ANDREW", "JAMES",
                        "JUDE", "MARTHA", "MARYMAGDALENE", "LAZARUS", "ZACCHAEUS",
                        "BARTIMAEUS", "HEROD", "PILATE", "CAIAPHAS", "GAMALIEL"
                };

            case 8:
                return new String[]{
                        "NAZARETH", "CANA", "CAPERNAUM", "BETHANY", "JERICHO",
                        "JOPPA", "DAMASCUS", "ANTIOCH", "EPHESUS", "CORINTH",
                        "GALATIA", "THYATIRA", "PHILIPPI", "SMYRNA", "PERGAMOS",
                        "SARDIS", "LAODICEA", "PATMOS", "GOLGOTHA", "GABBATHA",
                        "SILOAM", "BETHESDA", "PISIDIA", "ICONIUM", "LYSTRA"
                };

            case 9:
                return new String[]{
                        "ALTAR", "CENSER", "EPHOD", "URIM", "THUMMIM",
                        "MANNA", "MAMMON", "TALENT", "DENARIUS", "SHEKEL",
                        "SABBATH", "PASSOVER", "PENTECOST", "JUBILEE", "CIRCUMCISION",
                        "INCENSE", "MYRRH", "FRANKINCENSE", "HYSSOP", "MUSTARDSEED",
                        "VINEYARD", "LAVER", "MERCYSEAT", "BREASTPLATE", "CROWN"
                };

            case 10:
                return new String[]{
                        "HOSANNA", "ALLELUIA", "AMEN", "MARANATHA", "SHILOH",
                        "EBENEZER", "SELAH", "SHIBBOLETH", "GILEAD", "HOREB",
                        "SINAI", "ARARAT", "PISGAH", "MORIAH", "CARMEL",
                        "ZION", "OLIVET", "HERMON", "NEBO", "PENUEL",
                        "MAHANAIM", "SUCCOTH", "ETHAM", "ELIM", "REPHIDIM"
                };
        

                        default:
                return getWordsForLevel(1);
        }
    }

    // Returns one word for each of the 250 individual levels.
    public static String getWordForLevel(int level) {

        if (level < 1 || level > 250) {
            return null;
        }

        int originalLevel = ((level - 1) / 25) + 1;
        int questionIndex = (level - 1) % 25;

        String[] words = getWordsForLevel(originalLevel);

        return words[questionIndex];
    }
}
