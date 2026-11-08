package com.kingdomlife.app.godlylife;

import java.util.ArrayList;
import java.util.List;

public final class HowToLiveAGodlyLifeLibrary {

    // Book introduction
    public static final String INTRODUCTION_TITLE =
            HowToLiveAGodlyLifeIntroduction.TITLE;

    public static final String INTRODUCTION_CONTENT =
            HowToLiveAGodlyLifeIntroduction.CONTENT;

    // Chapter data structure
    public static final class Chapter {
        public final String title;
        public final String subtitle;
        public final List<String> pages;

        public Chapter(String title, String subtitle, List<String> pages) {
            this.title = title;
            this.subtitle = subtitle;
            this.pages = pages;
        }
    }

    // All six chapters
    public static List<Chapter> getChapters() {

        List<Chapter> chapters = new ArrayList<>();

        chapters.add(new Chapter(
                Chapter01UnderstandingTheChristWay.TITLE,
                Chapter01UnderstandingTheChristWay.SUBTITLE,
                Chapter01UnderstandingTheChristWay.PAGES
        ));

        chapters.add(new Chapter(
                Chapter02HolinessAndPurity.TITLE,
                Chapter02HolinessAndPurity.SUBTITLE,
                Chapter02HolinessAndPurity.PAGES
        ));

        chapters.add(new Chapter(
                Chapter03SpiritualGrowth.TITLE,
                Chapter03SpiritualGrowth.SUBTITLE,
                Chapter03SpiritualGrowth.PAGES
        ));

        chapters.add(new Chapter(
                Chapter04PractisingTheChristianLife.TITLE,
                Chapter04PractisingTheChristianLife.SUBTITLE,
                Chapter04PractisingTheChristianLife.PAGES
        ));

        chapters.add(new Chapter(
                Chapter05RemainingInChrist.TITLE,
                Chapter05RemainingInChrist.SUBTITLE,
                Chapter05RemainingInChrist.PAGES
        ));

        chapters.add(new Chapter(
                Chapter06SalvationAndTheNewLife.TITLE,
                Chapter06SalvationAndTheNewLife.SUBTITLE,
                Chapter06SalvationAndTheNewLife.PAGES
        ));

        return chapters;
    }

    private HowToLiveAGodlyLifeLibrary() {
        // Prevent instantiation.
    }
}
