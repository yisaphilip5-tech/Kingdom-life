package com.kingdomlife.app;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kingdomlife.app.descendants.DescendantsOfGoodLibrary;
import com.kingdomlife.app.success.SuccessIsMyBirthrightLibrary;

public class KingdomBooksActivity extends Activity {

private LinearLayout content;

private final int PURPLE = Color.rgb(30, 24, 55);
private final int GOLD = Color.rgb(184, 134, 11);
private final int DARK_TEXT = Color.rgb(45, 45, 45);

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ScrollView scrollView = new ScrollView(this);

    content = new LinearLayout(this);
    content.setOrientation(LinearLayout.VERTICAL);
    content.setPadding(20, 15, 20, 25);

    scrollView.addView(content);
    setContentView(scrollView);

applyKingdomBackground();

showKingdomBooks();
}

private int dp(float value) {
    return (int) (value * getResources()
            .getDisplayMetrics().density + 0.5f);
}

private GradientDrawable makeBackground(
        int backgroundColor, int strokeColor) {

    GradientDrawable drawable = new GradientDrawable();
    drawable.setColor(backgroundColor);
    drawable.setCornerRadius(dp(18));
    drawable.setStroke(dp(2), strokeColor);

    return drawable;
}

private void addCard(
        String heading,
        String message,
        View.OnClickListener listener) {

    LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setPadding(dp(10), dp(8), dp(10), dp(8));
    card.setBackground(makeBackground(Color.WHITE, GOLD));
    card.setElevation(dp(3));

    TextView title = new TextView(this);
    title.setText(heading);
    title.setTextSize(16);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(PURPLE);

    TextView description = new TextView(this);
    description.setText(message);
    description.setTextSize(12);
    description.setTextColor(DARK_TEXT);
    description.setPadding(0, dp(4), 0, 0);

    card.addView(title);
    card.addView(description);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    params.setMargins(0, 0, 0, dp(8));

    content.addView(card, params);

    card.setOnClickListener(listener);
}
private void applyKingdomBackground() {

    android.content.SharedPreferences displayPrefs =
            getSharedPreferences(
                    "KingdomLifeDisplayPrefs",
                    MODE_PRIVATE
            );

    String displayMode =
            displayPrefs.getString("displayMode", "AUTO");

    if (displayMode.equals("DAY")) {

        content.setBackgroundResource(
                R.drawable.kingdom_home_bg
        );

    } else if (displayMode.equals("NIGHT")) {

        content.setBackgroundResource(
                R.drawable.kingdom_night_bg
        );

    } else {

        int hour = java.util.Calendar.getInstance()
                .get(java.util.Calendar.HOUR_OF_DAY);

        if (hour >= 6 && hour < 18) {
            content.setBackgroundResource(
                    R.drawable.kingdom_home_bg
            );
        } else {
            content.setBackgroundResource(
                    R.drawable.kingdom_night_bg
            );
        }
    }
}

public void showKingdomBooks() {
    content.removeAllViews();

    // Back button
    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );
    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setOnClickListener(v -> finish());

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(dp(60), dp(60))
    );

    // Heading
    TextView title = new TextView(this);
    title.setText("📚 Kingdom Books");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(DARK_TEXT);
    title.setPadding(0, dp(15), 0, dp(10));
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "Explore Christian books and inspiring stories."
    );
    message.setTextSize(16);
    message.setTextColor(DARK_TEXT);
    message.setPadding(0, 0, 0, dp(20));
    content.addView(message);

    // First row
    LinearLayout firstRow = createBooksRow();
    

    addBookCover(
            firstRow,
            android.R.drawable.ic_menu_view,
            "The Pilgrim's Progress",
            "By John Bunyan",
            v -> PilgrimsProgressBook.open(this, content)
    );

    addBookCover(
            firstRow,
            R.drawable.descendants_of_good_cover,
            "Descendants of Good",
            "Christian fiction",
           v -> showDescendantsOfGoodChapters());

    // Second row
    LinearLayout secondRow = createBooksRow();
    
    addBookCover(secondRow,
        R.drawable.success_is_my_birthright_cover,
        "Success Is My Birthright",
        "Christian living and success",
        v -> showSuccessBookChapters());

    addBookCover(
            secondRow,
            R.drawable.how_to_live_a_godly_life_cover,
            "How to Live a Godly Life the Christ Way",
            "Faith, obedience, love and victory",
            v -> showComingSoon(
                    "How to Live a Godly Life the Christ Way"
            )
    );

    // Spacing below the book covers
    View spacing = new View(this);
    content.addView(
            spacing,
            new LinearLayout.LayoutParams(
                    1, dp(15)
            )
    );
addCard(
        "⏩ Continue Reading",
        "Return to where you last stopped reading.",
        v -> continueReading()
);
addCard(
        "📚 My Library",
        "View your books and reading status.",
        v -> showKingdomLibrary()
);
addCard(
        "🔖 My Bookmarks",
        "Open and manage your saved reading pages.",
        v -> showKingdomBookmarks()
);
}

private LinearLayout createBooksRow() {
    LinearLayout row = new LinearLayout(this);
    row.setOrientation(LinearLayout.HORIZONTAL);
    row.setGravity(Gravity.CENTER);
    row.setWeightSum(2);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    params.setMargins(0, 0, 0, dp(20));

    content.addView(row, params);

    return row;
}
private void continueReading() {

    android.content.SharedPreferences pilgrimPrefs =
            getSharedPreferences(
                    "PilgrimsProgressReadingProgress",
                    MODE_PRIVATE
            );

    android.content.SharedPreferences descendantsPrefs =
            getSharedPreferences(
                    "DescendantsReadingProgress",
                    MODE_PRIVATE
            );

    android.content.SharedPreferences successPrefs =
            getSharedPreferences(
                    "SuccessBirthrightReadingProgress",
                    MODE_PRIVATE
            );

    java.util.ArrayList<String> availableBooks =
            new java.util.ArrayList<>();

    if (pilgrimPrefs.contains("lastChapter")) {
        availableBooks.add("The Pilgrim's Progress");
    }

    if (descendantsPrefs.contains("lastChapter")) {
        availableBooks.add("Descendants of Good");
    }

    if (successPrefs.contains("lastChapter")) {
        availableBooks.add("Success Is My Birthright");
    }

    if (availableBooks.isEmpty()) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Continue Reading")
                .setMessage(
                        "Open a book and start reading to save your position."
                )
                .setPositiveButton("OK", null)
                .show();
        return;
    }

    if (availableBooks.size() == 1) {
        openSavedBook(availableBooks.get(0));
        return;
    }

    new android.app.AlertDialog.Builder(this)
            .setTitle("Continue Reading")
            .setItems(
                    availableBooks.toArray(new String[0]),
                    (dialog, which) ->
                            openSavedBook(availableBooks.get(which))
            )
            .setNegativeButton("Cancel", null)
            .show();
}

private void openSavedBook(String bookName) {

    if (bookName.equals("The Pilgrim's Progress")) {

        PilgrimsProgressBook.continueReading(this, content);

    } else if (bookName.equals("Descendants of Good")) {

        android.content.SharedPreferences prefs =
                getSharedPreferences(
                        "DescendantsReadingProgress",
                        MODE_PRIVATE
                );

        int chapterIndex = prefs.getInt("lastChapter", 0);

        showDescendantsOfGoodChapter(chapterIndex);

    } else if (bookName.equals("Success Is My Birthright")) {

        android.content.SharedPreferences prefs =
                getSharedPreferences(
                        "SuccessBirthrightReadingProgress",
                        MODE_PRIVATE
                );

        int chapterIndex = prefs.getInt("lastChapter", 0);

        showSuccessBookChapter(chapterIndex);

    } else {

        showComingSoon(bookName);
    }
}
public void showKingdomLibrary() {

    content.removeAllViews();

    addBackButton();

    TextView title = new TextView(this);
    title.setText("📚 My Library");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(DARK_TEXT);
    title.setPadding(0, dp(15), 0, dp(20));
    content.addView(title);

    android.content.SharedPreferences readingPrefs =
            getSharedPreferences("BibleReadingPrefs", MODE_PRIVATE);

    java.util.Set<String> completedBooks =
            new java.util.HashSet<>(
                    readingPrefs.getStringSet(
                            "completedStoryBooks",
                            java.util.Collections.emptySet()
                    )
            );

    addLibraryBook(
            R.drawable.descendants_of_good_cover,
            "Descendants of Good",
            "DescendantsReadingProgress",
            completedBooks
    );

    addLibraryBook(
            R.drawable.success_is_my_birthright_cover,
            "Success Is My Birthright",
            "SuccessBirthrightReadingProgress",
            completedBooks
    );

    addLibraryBook(
            R.drawable.how_to_live_a_godly_life_cover,
            "How to Live a Godly Life the Christ Way",
            "GodlyLifeReadingProgress",
            completedBooks
    );

    addLibraryBook(
            android.R.drawable.ic_menu_view,
            "The Pilgrim's Progress",
            "PilgrimsProgressReadingProgress",
            completedBooks
    );
}

private void addLibraryBook(
        int coverResource,
        String bookName,
        String progressPrefsName,
        java.util.Set<String> completedBooks) {

    android.content.SharedPreferences progressPrefs =
            getSharedPreferences(progressPrefsName, MODE_PRIVATE);

    String status;

    if (completedBooks.contains(bookName)) {
        status = "Completed";
    } else if (progressPrefs.contains("lastChapter")) {
        status = "In Progress";
    } else {
        status = "Not Started";
    }

    LinearLayout bookRow = new LinearLayout(this);
    bookRow.setOrientation(LinearLayout.HORIZONTAL);
    bookRow.setGravity(Gravity.CENTER_VERTICAL);
    bookRow.setPadding(dp(8), dp(8), dp(8), dp(8));

    ImageView cover = new ImageView(this);
    cover.setImageResource(coverResource);
    cover.setScaleType(ImageView.ScaleType.FIT_CENTER);

    bookRow.addView(
            cover,
            new LinearLayout.LayoutParams(dp(100), dp(130))
    );

    LinearLayout details = new LinearLayout(this);
    details.setOrientation(LinearLayout.VERTICAL);
    details.setPadding(dp(12), 0, 0, 0);

    TextView name = new TextView(this);
    name.setText(bookName);
    name.setTextSize(16);
    name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    name.setTextColor(DARK_TEXT);

    TextView readingStatus = new TextView(this);
    readingStatus.setText(status);
    readingStatus.setTextSize(14);
    readingStatus.setTextColor(DARK_TEXT);
    readingStatus.setPadding(0, dp(8), 0, 0);

    details.addView(name);
    details.addView(readingStatus);

    bookRow.addView(
            details,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    bookRow.setOnClickListener(v -> {

    if (bookName.equals("The Pilgrim's Progress")) {

        PilgrimsProgressBook.open(this, content);

    } else if (bookName.equals("Descendants of Good")) {

        showDescendantsOfGoodChapters();

    } else if (bookName.equals("Success Is My Birthright")) {

        showSuccessBookChapters();

    } else {

        showComingSoon(bookName);
    }
});
}

private void addBackButton() {

    android.widget.ImageButton backButton =
            new android.widget.ImageButton(this);

    backButton.setImageResource(
            android.R.drawable.ic_media_previous
    );

    backButton.setBackgroundColor(Color.TRANSPARENT);
    backButton.setContentDescription("Back to Kingdom Books");
    backButton.setOnClickListener(v -> showKingdomBooks());

    content.addView(
            backButton,
            new LinearLayout.LayoutParams(dp(60), dp(60))
    );
}

private void addBookCover(
        LinearLayout row,
        int imageResource,
        String bookTitle,
        String description,
        View.OnClickListener listener) {

    LinearLayout book = new LinearLayout(this);
    book.setOrientation(LinearLayout.VERTICAL);
    book.setGravity(Gravity.CENTER);
    book.setPadding(dp(6), dp(6), dp(6), dp(6));
    book.setClickable(true);
    book.setFocusable(true);
    book.setOnClickListener(listener);

    ImageView cover = new ImageView(this);
    cover.setImageResource(imageResource);
    cover.setScaleType(ImageView.ScaleType.FIT_CENTER);
    cover.setAdjustViewBounds(true);
    cover.setContentDescription(bookTitle + " book cover");

    book.addView(
            cover,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    dp(130)
            )
    );

    TextView name = new TextView(this);
    name.setText(bookTitle);
    name.setTextSize(14);
    name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    name.setTextColor(DARK_TEXT);
    name.setGravity(Gravity.CENTER);
    name.setPadding(0, dp(4), 0, dp(4));

    book.addView(name);

    TextView details = new TextView(this);
    details.setText(description);
    details.setTextSize(11);
    details.setTextColor(DARK_TEXT);
    details.setGravity(Gravity.CENTER);

    book.addView(details);

    row.addView(
            book,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );
}

private void showComingSoon(String bookName) {
    new android.app.AlertDialog.Builder(this)
            .setTitle(bookName)
            .setMessage(
                    "This book's reader is being connected."
            )
            .setPositiveButton("OK", null)
            .show();
}
private void showKingdomBookmarks() {
    content.removeAllViews();

    addBackButton();

    TextView title = new TextView(this);
    title.setText("🔖 My Bookmarks");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(DARK_TEXT);
    title.setPadding(0, dp(15), 0, dp(10));
    content.addView(title);

    android.content.SharedPreferences pilgrimPrefs =
            getSharedPreferences(
                    "PilgrimsProgressBookmarks",
                    MODE_PRIVATE
            );

    android.content.SharedPreferences descendantsPrefs =
            getSharedPreferences(
                    "DescendantsBookmarks",
                    MODE_PRIVATE
            );

    android.content.SharedPreferences successPrefs =
            getSharedPreferences(
                    "SuccessBirthrightBookmarks",
                    MODE_PRIVATE
            );

    boolean foundBookmark = false;

    // The Pilgrim's Progress bookmarks.
    for (int chapterIndex = 0; chapterIndex < 100; chapterIndex++) {
        for (int pageIndex = 0; pageIndex < 100; pageIndex++) {

            String key = chapterIndex + "_" + pageIndex;

            if (pilgrimPrefs.getBoolean(key, false)) {
                foundBookmark = true;

                final int savedChapter = chapterIndex;
                final int savedPage = pageIndex;

                LinearLayout row = createBookmarkRow();

                android.widget.Button openButton =
                        new android.widget.Button(this);

                openButton.setText(
                        "The Pilgrim's Progress — Chapter "
                                + (chapterIndex + 1)
                                + " • Page "
                                + (pageIndex + 1)
                );

                openButton.setOnClickListener(v ->
                        PilgrimsProgressBook.openBookmarkedPage(
                                this,
                                content,
                                savedChapter,
                                savedPage
                        )
                );

                android.widget.Button removeButton =
                        new android.widget.Button(this);

                removeButton.setText("Remove");

                removeButton.setOnClickListener(v -> {
                    pilgrimPrefs.edit()
                            .remove(key)
                            .apply();

                    showKingdomBookmarks();
                });

                addBookmarkButtons(row, openButton, removeButton);
            }
        }
    }

    // Descendants of Good bookmarks.
    java.util.List<DescendantsOfGoodLibrary.Chapter>
            descendantsChapters =
            DescendantsOfGoodLibrary.getChapters();

    for (int i = 0; i < descendantsChapters.size(); i++) {
        final int chapterIndex = i;

        DescendantsOfGoodLibrary.Chapter chapter =
                descendantsChapters.get(i);

        for (int pageIndex = 0;
             pageIndex < chapter.pages.size();
             pageIndex++) {

            String key = chapterIndex + "_" + pageIndex;

            if (descendantsPrefs.getBoolean(key, false)) {
                foundBookmark = true;

                final int savedPage = pageIndex;

                LinearLayout row = createBookmarkRow();

                android.widget.Button openButton =
                        new android.widget.Button(this);

                openButton.setText(
                        "Descendants of Good — "
                                + chapter.title
                                + " • Page "
                                + (pageIndex + 1)
                );

                openButton.setOnClickListener(v ->
        showDescendantsBookmarkedPage(
                chapterIndex,
                savedPage
        )
);

                android.widget.Button removeButton =
                        new android.widget.Button(this);

                removeButton.setText("Remove");

                removeButton.setOnClickListener(v -> {
                    descendantsPrefs.edit()
                            .remove(key)
                            .apply();

                    showKingdomBookmarks();
                });

                addBookmarkButtons(row, openButton, removeButton);
            }
        }
    }

    // Success Is My Birthright bookmarks.
    java.util.List<SuccessIsMyBirthrightLibrary.Chapter>
            successChapters =
            SuccessIsMyBirthrightLibrary.getChapters();

    for (int i = 0; i < successChapters.size(); i++) {
        final int chapterIndex = i;

        SuccessIsMyBirthrightLibrary.Chapter chapter =
                successChapters.get(i);

        for (int pageIndex = 0;
             pageIndex < chapter.pages.size();
             pageIndex++) {
            final int savedPageIndex = pageIndex;

            String key = chapterIndex + "_" + pageIndex;

            if (successPrefs.getBoolean(key, false)) {
                foundBookmark = true;

                LinearLayout row = createBookmarkRow();

                android.widget.Button openButton =
                        new android.widget.Button(this);

                openButton.setText(
                        "Success Is My Birthright — "
                                + chapter.title
                                + " • Page "
                                + (pageIndex + 1)
                );

                openButton.setOnClickListener(v ->
        showSuccessBookBookmarkedPage(
                chapterIndex,
                savedPageIndex
        )
);
                android.widget.Button removeButton =
                        new android.widget.Button(this);

                removeButton.setText("Remove");

                removeButton.setOnClickListener(v -> {
                    successPrefs.edit()
                            .remove(key)
                            .apply();

                    showKingdomBookmarks();
                });

                addBookmarkButtons(row, openButton, removeButton);
            }
        }
    }

    if (!foundBookmark) {
        TextView emptyMessage = new TextView(this);

        emptyMessage.setText(
                "You haven't bookmarked any passages yet.\n\n"
                        + "Open a chapter and tap 🔖 to save a page."
        );

        emptyMessage.setTextSize(16);
        emptyMessage.setTextColor(DARK_TEXT);
        emptyMessage.setPadding(0, dp(20), 0, dp(20));

        content.addView(emptyMessage);
    }
}
private LinearLayout createBookmarkRow() {
    LinearLayout row = new LinearLayout(this);
    row.setOrientation(LinearLayout.HORIZONTAL);
    row.setGravity(android.view.Gravity.CENTER_VERTICAL);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    params.setMargins(0, 0, 0, dp(10));

    content.addView(row, params);

    return row;
}

private void addBookmarkButtons(
        LinearLayout row,
        android.widget.Button openButton,
        android.widget.Button removeButton) {

    row.addView(
            openButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    row.addView(removeButton);
}
private void showDescendantsOfGoodChapters() {
    content.removeAllViews();

    addBackButton();

    TextView title = new TextView(this);
    title.setText("📖 Descendants of Good");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(DARK_TEXT);
    title.setPadding(0, dp(15), 0, dp(10));
    content.addView(title);

    TextView subtitle = new TextView(this);
    subtitle.setText("Choose a chapter to begin reading.");
    subtitle.setTextSize(16);
    subtitle.setTextColor(DARK_TEXT);
    subtitle.setPadding(0, 0, 0, dp(20));
    content.addView(subtitle);

    java.util.List<DescendantsOfGoodLibrary.Chapter> chapters =
            DescendantsOfGoodLibrary.getChapters();

    for (int i = 0; i < chapters.size(); i++) {
        final int chapterIndex = i;

        DescendantsOfGoodLibrary.Chapter chapter =
                chapters.get(i);

        addCard(
                "Chapter " + (i + 1) + ": " + chapter.title,
                chapter.subtitle,
                v -> showDescendantsOfGoodChapter(chapterIndex)
        );
    }
}
private void showDescendantsOfGoodChapter(int chapterIndex) {
    showDescendantsOfGoodChapter(chapterIndex, -1);
}

private void showDescendantsBookmarkedPage(
        int chapterIndex, int pageIndex) {

    android.content.SharedPreferences storyPrefs =
            getSharedPreferences(
                    "DescendantsReadingProgress",
                    MODE_PRIVATE
            );

    storyPrefs.edit()
            .putInt("lastChapter", chapterIndex)
            .putInt("lastPage", pageIndex)
            .apply();

    showDescendantsOfGoodChapter(chapterIndex, pageIndex);
}

private void showDescendantsOfGoodChapter(
        int chapterIndex, int startingPage) {

    content.removeAllViews();

    java.util.List<DescendantsOfGoodLibrary.Chapter> chapters =
            DescendantsOfGoodLibrary.getChapters();

    if (chapterIndex < 0 || chapterIndex >= chapters.size()) {
        showDescendantsOfGoodChapters();
        return;
    }

    DescendantsOfGoodLibrary.Chapter chapter =
            chapters.get(chapterIndex);

    if (chapter.pages == null || chapter.pages.isEmpty()) {
        showDescendantsOfGoodChapters();
        return;
    }

    addBackButton();

    android.content.SharedPreferences textPrefs =
            getSharedPreferences(
                    "TextAppearancePrefs",
                    MODE_PRIVATE
            );

    int savedTextSize = textPrefs.getInt("textSize", 18);

    String savedTextMode =
            textPrefs.getString("textMode", "Light");

    int selectedTextColor = savedTextMode.equals("Dark")
            ? Color.WHITE
            : Color.BLACK;

    TextView chapterTitle = new TextView(this);
    chapterTitle.setText(chapter.title);
    chapterTitle.setTextSize(savedTextSize + 8);
    chapterTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    chapterTitle.setTextColor(selectedTextColor);
    chapterTitle.setPadding(0, dp(15), 0, dp(10));
    content.addView(chapterTitle);

    TextView chapterSubtitle = new TextView(this);
    chapterSubtitle.setText(chapter.subtitle);
    chapterSubtitle.setTextSize(Math.max(12, savedTextSize - 2));
    chapterSubtitle.setTextColor(selectedTextColor);
    chapterSubtitle.setPadding(0, 0, 0, dp(20));
    content.addView(chapterSubtitle);

    TextView pageText = new TextView(this);
    pageText.setTextSize(savedTextSize);
    pageText.setTextColor(selectedTextColor);
    pageText.setLineSpacing(dp(8), 1.0f);
    pageText.setPadding(0, dp(10), 0, dp(20));
    pageText.setTextIsSelectable(true);

    content.addView(
            pageText,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );

    final int[] currentPage = {0};

    android.content.SharedPreferences storyPrefs =
            getSharedPreferences(
                    "DescendantsReadingProgress",
                    MODE_PRIVATE
            );

    int savedChapter = storyPrefs.getInt("lastChapter", 0);
    int savedPage = storyPrefs.getInt("lastPage", 0);

    if (startingPage >= 0) {
        currentPage[0] = Math.max(
                0,
                Math.min(startingPage, chapter.pages.size() - 1)
        );
    } else if (savedChapter == chapterIndex) {
        currentPage[0] = Math.max(
                0,
                Math.min(savedPage, chapter.pages.size() - 1)
        );
    }

    LinearLayout bookmarkRow = new LinearLayout(this);
    bookmarkRow.setOrientation(LinearLayout.HORIZONTAL);
    bookmarkRow.setGravity(android.view.Gravity.LEFT);

    TextView bookmarkButton = new TextView(this);
    bookmarkButton.setText("🔖");
    bookmarkButton.setTextSize(28);
    bookmarkButton.setPadding(
            dp(8), dp(8), dp(8), dp(8)
    );
    bookmarkButton.setContentDescription("Bookmark this page");

    bookmarkRow.addView(bookmarkButton);
    content.addView(bookmarkRow);

    bookmarkButton.setOnClickListener(v -> {
        android.content.SharedPreferences bookmarkPrefs =
                getSharedPreferences(
                        "DescendantsBookmarks",
                        MODE_PRIVATE
                );

        String bookmarkKey =
                chapterIndex + "_" + currentPage[0];

        bookmarkPrefs.edit()
                .putBoolean(bookmarkKey, true)
                .apply();

        android.widget.Toast.makeText(
                this,
                "Page bookmarked!",
                android.widget.Toast.LENGTH_SHORT
        ).show();
    });

    LinearLayout navigation = new LinearLayout(this);
    navigation.setOrientation(LinearLayout.HORIZONTAL);
    navigation.setGravity(android.view.Gravity.CENTER);

    android.widget.Button previousButton =
            new android.widget.Button(this);
    previousButton.setText("← Previous");

    android.widget.Button nextButton =
            new android.widget.Button(this);
    nextButton.setText("Next →");

    navigation.addView(
            previousButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    navigation.addView(
            nextButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    content.addView(navigation);

    Runnable updatePage = () -> {

        pageText.setText(chapter.pages.get(currentPage[0]));

        // Save reading position.
        storyPrefs.edit()
                .putInt("lastChapter", chapterIndex)
                .putInt("lastPage", currentPage[0])
                .apply();

        // Record visited page.
        android.content.SharedPreferences visitedPagesPrefs =
                getSharedPreferences(
                        "DescendantsVisitedPages",
                        MODE_PRIVATE
                );

        String pageKey =
                chapterIndex + "_" + currentPage[0];

        visitedPagesPrefs.edit()
                .putBoolean(pageKey, true)
                .apply();

        // Check whether every page in this chapter was visited.
        boolean chapterCompleted = true;

        for (int i = 0; i < chapter.pages.size(); i++) {
            if (!visitedPagesPrefs.getBoolean(
                    chapterIndex + "_" + i,
                    false)) {

                chapterCompleted = false;
                break;
            }
        }

        if (chapterCompleted) {

            java.util.Set<String> completedChapters =
                    new java.util.HashSet<>(
                            visitedPagesPrefs.getStringSet(
                                    "completedChapters",
                                    java.util.Collections.emptySet()
                            )
                    );

            completedChapters.add(
                    String.valueOf(chapterIndex)
            );

            visitedPagesPrefs.edit()
                    .putStringSet(
                            "completedChapters",
                            completedChapters
                    )
                    .apply();

            // Check whether the entire book is complete.
            if (completedChapters.size() == chapters.size()) {

                android.content.SharedPreferences readingPrefs =
                        getSharedPreferences(
                                "BibleReadingPrefs",
                                MODE_PRIVATE
                        );

                java.util.Set<String> completedStoryBooks =
                        new java.util.HashSet<>(
                                readingPrefs.getStringSet(
                                        "completedStoryBooks",
                                        java.util.Collections.emptySet()
                                )
                        );

                if (completedStoryBooks.add(
                        "Descendants of Good")) {

                    readingPrefs.edit()
                            .putStringSet(
                                    "completedStoryBooks",
                                    completedStoryBooks
                            )
                            .putInt(
                                    "storyBooksRead",
                                    completedStoryBooks.size()
                            )
                            .apply();
                }
            }
        }

        previousButton.setEnabled(currentPage[0] > 0);

        nextButton.setEnabled(
                currentPage[0] < chapter.pages.size() - 1
        );
    };

    previousButton.setOnClickListener(v -> {
        if (currentPage[0] > 0) {
            currentPage[0]--;
            updatePage.run();
        }
    });

    nextButton.setOnClickListener(v -> {
        if (currentPage[0] < chapter.pages.size() - 1) {
            currentPage[0]++;
            updatePage.run();
        }
    });

    updatePage.run();
}
private void showSuccessBookChapters() {
    content.removeAllViews();

    addBackButton();

    java.util.List<SuccessIsMyBirthrightLibrary.Chapter> chapters =
            SuccessIsMyBirthrightLibrary.getChapters();

    TextView heading = new TextView(this);
    heading.setText("Success Is My Birthright");
    heading.setTextSize(24);
    heading.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    heading.setTextColor(DARK_TEXT);
    heading.setPadding(0, dp(20), 0, dp(15));
    content.addView(heading);

    TextView description = new TextView(this);
    description.setText(
            "Understanding Success Through God's Principles"
    );
    description.setTextSize(15);
    description.setTextColor(DARK_TEXT);
    description.setPadding(0, 0, 0, dp(20));
    content.addView(description);

    for (int i = 0; i < chapters.size(); i++) {
        final int chapterIndex = i;

        SuccessIsMyBirthrightLibrary.Chapter chapter =
                chapters.get(i);

        addCard(
                "Chapter " + (i + 1),
                chapter.title,
                v -> showSuccessBookChapter(chapterIndex)
        );
    }
}
private void showSuccessBookChapter(int chapterIndex) {
    showSuccessBookChapter(chapterIndex, -1);
}

private void showSuccessBookBookmarkedPage(
        int chapterIndex, int pageIndex) {

    android.content.SharedPreferences bookPrefs =
            getSharedPreferences(
                    "SuccessBirthrightReadingProgress",
                    MODE_PRIVATE
            );

    bookPrefs.edit()
            .putInt("lastChapter", chapterIndex)
            .putInt("lastPage", pageIndex)
            .apply();

    showSuccessBookChapter(chapterIndex, pageIndex);
}

private void showSuccessBookChapter(
        int chapterIndex, int startingPage) {

    content.removeAllViews();

    java.util.List<SuccessIsMyBirthrightLibrary.Chapter> chapters =
            SuccessIsMyBirthrightLibrary.getChapters();

    if (chapterIndex < 0 || chapterIndex >= chapters.size()) {
        showSuccessBookChapters();
        return;
    }

    SuccessIsMyBirthrightLibrary.Chapter chapter =
            chapters.get(chapterIndex);

    if (chapter.pages == null || chapter.pages.isEmpty()) {
        TextView unavailable = new TextView(this);
        unavailable.setText(
                "This chapter does not contain any pages yet."
        );
        unavailable.setTextSize(16);
        unavailable.setTextColor(DARK_TEXT);
        content.addView(unavailable);
        addBackButton();
        return;
    }

    addBackButton();

    android.content.SharedPreferences textPrefs =
            getSharedPreferences(
                    "TextAppearancePrefs",
                    MODE_PRIVATE
            );

    int savedTextSize = textPrefs.getInt("textSize", 18);

    String savedTextMode =
            textPrefs.getString("textMode", "Light");

    int selectedTextColor = savedTextMode.equals("Dark")
            ? Color.WHITE
            : Color.BLACK;

    TextView chapterTitle = new TextView(this);
    chapterTitle.setText(chapter.title);
    chapterTitle.setTextSize(savedTextSize + 8);
    chapterTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    chapterTitle.setTextColor(selectedTextColor);
    chapterTitle.setPadding(0, dp(15), 0, dp(10));
    content.addView(chapterTitle);

    TextView chapterSubtitle = new TextView(this);
    chapterSubtitle.setText(chapter.subtitle);
    chapterSubtitle.setTextSize(
            Math.max(12, savedTextSize - 2)
    );
    chapterSubtitle.setTextColor(selectedTextColor);
    chapterSubtitle.setPadding(0, 0, 0, dp(20));
    content.addView(chapterSubtitle);

    TextView pageText = new TextView(this);
    pageText.setTextSize(savedTextSize);
    pageText.setTextColor(selectedTextColor);
    pageText.setLineSpacing(dp(8), 1.0f);
    pageText.setPadding(0, dp(10), 0, dp(20));
    pageText.setTextIsSelectable(true);

    content.addView(
            pageText,
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            )
    );

    final int[] currentPage = {0};

    android.content.SharedPreferences bookPrefs =
            getSharedPreferences(
                    "SuccessBirthrightReadingProgress",
                    MODE_PRIVATE
            );

    int savedChapter = bookPrefs.getInt("lastChapter", 0);
    int savedPage = bookPrefs.getInt("lastPage", 0);

    if (startingPage >= 0) {
        currentPage[0] = Math.max(
                0,
                Math.min(startingPage, chapter.pages.size() - 1)
        );
    } else if (savedChapter == chapterIndex) {
        currentPage[0] = Math.max(
                0,
                Math.min(savedPage, chapter.pages.size() - 1)
        );
    }

    // Bookmark button.
    LinearLayout bookmarkRow = new LinearLayout(this);
    bookmarkRow.setOrientation(LinearLayout.HORIZONTAL);

    TextView bookmarkButton = new TextView(this);
    bookmarkButton.setText("🔖");
    bookmarkButton.setTextSize(28);
    bookmarkButton.setPadding(
            dp(8), dp(8), dp(8), dp(8)
    );
    bookmarkButton.setContentDescription("Bookmark this page");

    bookmarkRow.addView(bookmarkButton);
    content.addView(bookmarkRow);

    bookmarkButton.setOnClickListener(v -> {
        String key = chapterIndex + "_" + currentPage[0];

        getSharedPreferences(
                "SuccessBirthrightBookmarks",
                MODE_PRIVATE
        ).edit()
                .putBoolean(key, true)
                .apply();

        android.widget.Toast.makeText(
                this,
                "Page bookmarked!",
                android.widget.Toast.LENGTH_SHORT
        ).show();
    });

    // Page navigation.
    LinearLayout navigation = new LinearLayout(this);
    navigation.setOrientation(LinearLayout.HORIZONTAL);
    navigation.setGravity(android.view.Gravity.CENTER);

    android.widget.Button previousButton =
            new android.widget.Button(this);
    previousButton.setText("← Previous");

    android.widget.Button nextButton =
            new android.widget.Button(this);
    nextButton.setText("Next →");

    navigation.addView(
            previousButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    navigation.addView(
            nextButton,
            new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            )
    );

    content.addView(navigation);

    Runnable updatePage = () -> {

        pageText.setText(chapter.pages.get(currentPage[0]));

        // Save reading position.
        bookPrefs.edit()
                .putInt("lastChapter", chapterIndex)
                .putInt("lastPage", currentPage[0])
                .apply();

        // Record visited pages.
        android.content.SharedPreferences visitedPrefs =
                getSharedPreferences(
                        "SuccessBirthrightVisitedPages",
                        MODE_PRIVATE
                );

        String pageKey = chapterIndex + "_" + currentPage[0];

        visitedPrefs.edit()
                .putBoolean(pageKey, true)
                .apply();

        // Check chapter completion.
        boolean chapterCompleted = true;

        for (int i = 0; i < chapter.pages.size(); i++) {
            if (!visitedPrefs.getBoolean(
                    chapterIndex + "_" + i,
                    false
            )) {
                chapterCompleted = false;
                break;
            }
        }

        if (chapterCompleted) {

            java.util.Set<String> completedChapters =
                    new java.util.HashSet<>(
                            visitedPrefs.getStringSet(
                                    "completedChapters",
                                    java.util.Collections.emptySet()
                            )
                    );

            completedChapters.add(
                    String.valueOf(chapterIndex)
            );

            visitedPrefs.edit()
                    .putStringSet(
                            "completedChapters",
                            completedChapters
                    )
                    .apply();

            // Check completion of the entire book.
            if (completedChapters.size() == chapters.size()) {

                android.content.SharedPreferences readingPrefs =
                        getSharedPreferences(
                                "BibleReadingPrefs",
                                MODE_PRIVATE
                        );

                java.util.Set<String> completedStoryBooks =
                        new java.util.HashSet<>(
                                readingPrefs.getStringSet(
                                        "completedStoryBooks",
                                        java.util.Collections.emptySet()
                                )
                        );

                if (completedStoryBooks.add(
                        "Success Is My Birthright")) {

                    readingPrefs.edit()
                            .putStringSet(
                                    "completedStoryBooks",
                                    completedStoryBooks
                            )
                            .putInt(
                                    "storyBooksRead",
                                    completedStoryBooks.size()
                            )
                            .apply();
                }
            }
        }

        previousButton.setEnabled(currentPage[0] > 0);

        nextButton.setEnabled(
                currentPage[0] < chapter.pages.size() - 1
        );
    };

    previousButton.setOnClickListener(v -> {
        if (currentPage[0] > 0) {
            currentPage[0]--;
            updatePage.run();
        }
    });

    nextButton.setOnClickListener(v -> {
        if (currentPage[0] < chapter.pages.size() - 1) {
            currentPage[0]++;
            updatePage.run();
        }
    });

    updatePage.run();
}
}
