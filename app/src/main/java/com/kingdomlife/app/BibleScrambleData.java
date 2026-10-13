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

            default:
                return getWordsForLevel(1);
        }
    }
}
