package com.kingdomlife.app;

import java.util.ArrayList;
import java.util.HashMap;

public class BibleJourneyData {

    public static class Question {
        public String question;
        public String[] options;
        public int answer;

        public Question(String question, String[] options, int answer) {
            this.question = question;
            this.options = options;
            this.answer = answer;
        }
    }

    public static ArrayList<Question> getQuestions(
            String book,
            String difficulty
    ) {

        ArrayList<Question> questions = new ArrayList<>();

        if (book.equals("Exodus")) {

            if (difficulty.equals("Easy")) {

                questions.add(new Question(
                        "Who led the Israelites out of Egypt?",
                        new String[]{
                                "Moses",
                                "Joseph",
                                "Joshua",
                                "Aaron"
                        },
                        0
                ));

            }

        }

        return questions;
    }
}
