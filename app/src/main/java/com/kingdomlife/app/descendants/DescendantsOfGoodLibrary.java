package com.kingdomlife.app.descendants;

import java.util.ArrayList;
import java.util.List;

public final class DescendantsOfGoodLibrary {

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
                Chapter01DawnOfGood.TITLE,
                Chapter01DawnOfGood.SUBTITLE,
                Chapter01DawnOfGood.PAGES
        ));

        chapters.add(new Chapter(
                Chapter02TheCallBegins.TITLE,
                Chapter02TheCallBegins.SUBTITLE,
                Chapter02TheCallBegins.PAGES
        ));

        return chapters;
    }

    private DescendantsOfGoodLibrary() {
        // Prevent instantiation.
    }
}
