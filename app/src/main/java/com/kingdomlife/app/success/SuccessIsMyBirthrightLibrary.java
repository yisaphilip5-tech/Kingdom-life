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

        return chapters;
    }

    private SuccessIsMyBirthrightLibrary() {
        // Prevent instantiation.
    }
}
