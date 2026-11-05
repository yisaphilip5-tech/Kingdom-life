package com.kingdomlife.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.media3.common.Player;

import java.util.Locale;

public class AudioBiblePlayerView extends LinearLayout {

    private static final int PURPLE = Color.rgb(30, 24, 55);
    private static final int GOLD = Color.rgb(184, 134, 11);
    private static final int WHITE = Color.WHITE;

    private AudioBibleManager manager;

    private TextView chapterTitle;
    private TextView playButton;
    private TextView speedButton;
    private TextView currentTime;
    private TextView totalTime;

    private SeekBar progressBar;

    private String translation;
    private String book;
    private int chapter;

    private boolean isDragging = false;
    private boolean hasStarted = false;

    public interface OnChapterChangedListener {
        void onChapterChanged(String book, int chapter);
    }

    private OnChapterChangedListener chapterChangedListener;

    public AudioBiblePlayerView(
            Context context,
            AudioBibleManager manager,
            String translation,
            String book,
            int chapter
    ) {

        super(context);

        this.manager = manager;
        this.translation = translation;
        this.book = book;
        this.chapter = chapter;

        setOrientation(VERTICAL);
        setPadding(18, 18, 18, 18);
        setBackground(createPanelBackground());

        setElevation(5);

        createPlayerInterface();

        manager.setPlaybackListener(
                new AudioBibleManager.PlaybackListener() {

            @Override
            public void onPlaybackChanged(
                    boolean isPlaying,
                    int playbackState,
                    long position,
                    long duration
            ) {

                updatePlaybackState(
                        isPlaying,
                        playbackState,
                        position,
                        duration
                );
            }

            @Override
            public void onChapterChanged(
                    String newBook,
                    int newChapter
            ) {

                book = newBook;
                chapter = newChapter;

                updateChapterTitle();

                if (chapterChangedListener != null) {
                    chapterChangedListener.onChapterChanged(
                            newBook,
                            newChapter
                    );
                }
            }

            @Override
            public void onError(String message) {

                chapterTitle.setText(message);
            }
        });

    }

    private GradientDrawable createPanelBackground() {

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(PURPLE);
        background.setCornerRadius(22);
        background.setStroke(2, GOLD);

        return background;
    }

    private void createPlayerInterface() {

        TextView heading = new TextView(getContext());

        heading.setText("♫  AUDIO BIBLE");
        heading.setTextColor(GOLD);
        heading.setTextSize(13);
        heading.setTypeface(null, Typeface.BOLD);

        addView(heading);

        chapterTitle = new TextView(getContext());

        chapterTitle.setTextColor(WHITE);
        chapterTitle.setTextSize(17);
        chapterTitle.setTypeface(null, Typeface.BOLD);

        LayoutParams titleParams =
                new LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT
                );

        titleParams.topMargin = 8;

        addView(chapterTitle, titleParams);

        updateChapterTitle();

        // Progress bar

        progressBar = new SeekBar(getContext());

        progressBar.setMax(1000);

        progressBar.setProgressTintList(
                android.content.res.ColorStateList.valueOf(GOLD)
        );

        progressBar.setThumbTintList(
                android.content.res.ColorStateList.valueOf(GOLD)
        );

        progressBar.setProgressBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        Color.LTGRAY
                )
        );

        LayoutParams progressParams =
                new LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT
                );

        progressParams.topMargin = 8;

        addView(progressBar, progressParams);

        progressBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(
                    SeekBar seekBar,
                    int progress,
                    boolean fromUser
            ) {

                if (fromUser) {
                    long duration = manager.getDuration();

                    long position =
                            duration * progress / 1000;

                    currentTime.setText(
                            formatTime(position)
                    );
                }
            }

            @Override
            public void onStartTrackingTouch(
                    SeekBar seekBar
            ) {

                isDragging = true;
            }

            @Override
            public void onStopTrackingTouch(
                    SeekBar seekBar
            ) {

                long duration = manager.getDuration();

                long position =
                        duration * seekBar.getProgress() / 1000;

                manager.seekTo(position);

                isDragging = false;
            }
        });

        // Time row

        LinearLayout timeRow =
                new LinearLayout(getContext());

        timeRow.setOrientation(HORIZONTAL);
        timeRow.setGravity(Gravity.CENTER_VERTICAL);

        currentTime = new TextView(getContext());
        currentTime.setText("00:00");
        currentTime.setTextColor(WHITE);
        currentTime.setTextSize(12);

        totalTime = new TextView(getContext());
        totalTime.setText("00:00");
        totalTime.setTextColor(WHITE);
        totalTime.setTextSize(12);

        timeRow.addView(
                currentTime,
                new LayoutParams(
                        0,
                        LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        timeRow.addView(totalTime);

        addView(timeRow);

        // Playback controls

        LinearLayout controls =
                new LinearLayout(getContext());

        controls.setOrientation(HORIZONTAL);
        controls.setGravity(Gravity.CENTER);

        TextView previousButton =
                createControlButton("|◀");

        playButton =
                createControlButton("▶");

        TextView nextButton =
                createControlButton("▶|");

        speedButton =
                createControlButton("1.0×");

        LayoutParams controlParams =
                new LayoutParams(
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );

        controlParams.setMargins(7, 12, 7, 4);

        controls.addView(previousButton, controlParams);
        controls.addView(playButton, controlParams);
        controls.addView(nextButton, controlParams);
        controls.addView(speedButton, controlParams);

        addView(controls);

        // Button actions

        previousButton.setOnClickListener(v -> {

            manager.previousChapter();
        });

        playButton.setOnClickListener(v -> {

            if (manager.isPlaying()) {

                manager.pause();

            } else if (!hasStarted) {

                hasStarted = true;

                manager.playChapter(
                        translation,
                        book,
                        chapter
                );

            } else {

                manager.play();
            }
        });

        nextButton.setOnClickListener(v -> {

            manager.nextChapter();
        });

        speedButton.setOnClickListener(v -> {

            manager.changePlaybackSpeed();

            speedButton.setText(
                    String.format(
                            Locale.US,
                            "%.2f×",
                            manager.getPlaybackSpeed()
                    )
            );
        });

    }

    private TextView createControlButton(String text) {

        TextView button = new TextView(getContext());

        button.setText(text);
        button.setTextColor(GOLD);
        button.setTextSize(16);
        button.setTypeface(null, Typeface.BOLD);

        button.setGravity(Gravity.CENTER);

        button.setPadding(13, 10, 13, 10);

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(
                Color.rgb(45, 36, 75)
        );

        background.setCornerRadius(14);

        background.setStroke(1, GOLD);

        button.setBackground(background);

        return button;
    }

    private void updateChapterTitle() {

        if (chapterTitle != null) {

            chapterTitle.setText(
                    book + " " + chapter + " — " + translation
            );
        }
    }

    private void updatePlaybackState(
            boolean isPlaying,
            int playbackState,
            long position,
            long duration
    ) {

        playButton.setText(
                isPlaying ? "Ⅱ" : "▶"
        );

        if (!isDragging) {

            if (duration > 0) {

                int progress = (int) (
                        position * 1000 / duration
                );

                progressBar.setProgress(progress);

            } else {

                progressBar.setProgress(0);
            }

            currentTime.setText(
                    formatTime(position)
            );
        }

        totalTime.setText(
                formatTime(duration)
        );

        if (playbackState == Player.STATE_ENDED) {
            playButton.setText("▶");
        }
    }

    private String formatTime(long milliseconds) {

        if (milliseconds < 0) {
            milliseconds = 0;
        }

        long seconds = milliseconds / 1000;

        long minutes = seconds / 60;

        seconds = seconds % 60;

        long hours = minutes / 60;

        minutes = minutes % 60;

        if (hours > 0) {

            return String.format(
                    Locale.US,
                    "%d:%02d:%02d",
                    hours,
                    minutes,
                    seconds
            );
        }

        return String.format(
                Locale.US,
                "%02d:%02d",
                minutes,
                seconds
        );
    }

    public void setOnChapterChangedListener(
            OnChapterChangedListener listener
    ) {

        this.chapterChangedListener = listener;
    }
                  }
