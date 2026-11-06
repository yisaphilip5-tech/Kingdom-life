package com.kingdomlife.app.success;

import java.util.ArrayList;
import java.util.List;

public final class SuccessIsMyBirthrightLibrary {

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

    public static List<Chapter> getChapters() {
        List<Chapter> chapters = new ArrayList<>();

        chapters.add(new Chapter(
                Chapter01WhatIsSuccess.TITLE,
                Chapter01WhatIsSuccess.SUBTITLE,
                Chapter01WhatIsSuccess.PAGES
        ));
        chapters.add(new Chapter(
        Chapter02GoodSuccessAndBadSuccess.TITLE,
        Chapter02GoodSuccessAndBadSuccess.SUBTITLE,
        Chapter02GoodSuccessAndBadSuccess.PAGES
));
        chapters.add(new Chapter(
        Chapter03ResultsOfGoodSuccess.TITLE,
        Chapter03ResultsOfGoodSuccess.SUBTITLE,
        Chapter03ResultsOfGoodSuccess.PAGES
));
        chapters.add(new Chapter(
        Chapter04HowToObtainGoodSuccess.TITLE,
        Chapter04HowToObtainGoodSuccess.SUBTITLE,
        Chapter04HowToObtainGoodSuccess.PAGES
));
        chapters.add(new Chapter(
        Chapter05UnderstandingSuccess.TITLE,
        Chapter05UnderstandingSuccess.SUBTITLE,
        Chapter05UnderstandingSuccess.PAGES
));
        chapters.add(new Chapter(
        Chapter06WordOfGodOurGuide.TITLE,
        Chapter06WordOfGodOurGuide.SUBTITLE,
        Chapter06WordOfGodOurGuide.PAGES
));
        chapters.add(new Chapter(
        Chapter07FoundationOfSuccessfulLife.TITLE,
        Chapter07FoundationOfSuccessfulLife.SUBTITLE,
        Chapter07FoundationOfSuccessfulLife.PAGES
));
        chapters.add(new Chapter(
        Chapter08DiscoveringPurposeAndDirection.TITLE,
        Chapter08DiscoveringPurposeAndDirection.SUBTITLE,
        Chapter08DiscoveringPurposeAndDirection.PAGES
));
        chapters.add(new Chapter(
        Chapter09DisciplineDiligenceConsistency.TITLE,
        Chapter09DisciplineDiligenceConsistency.SUBTITLE,
        Chapter09DisciplineDiligenceConsistency.PAGES
));
        chapters.add(new Chapter(
        Chapter10OvercomingObstacles.TITLE,
        Chapter10OvercomingObstacles.SUBTITLE,
        Chapter10OvercomingObstacles.PAGES
));

        return chapters;
    }

    private SuccessIsMyBirthrightLibrary() {
        // Prevent instantiation.
    }
}
