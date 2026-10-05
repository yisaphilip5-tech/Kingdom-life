
package com.kingdomlife.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Space;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

    LinearLayout content;
  SharedPreferences prefs;
    SharedPreferences savedVersesPrefs;
    SharedPreferences notesPrefs;
    SharedPreferences highlightsPrefs;
    SharedPreferences bookmarksPrefs;
    SharedPreferences challengePrefs;

    int darkText = Color.rgb(45, 45, 45);
    int cardColor = Color.rgb(245, 247, 250);
String[] scrambleWords = {
    "JESUS",
    "MOSES",
    "DAVID",
    "NOAH",
    "ABRAHAM",
    "SAMSON",
    "SOLOMON",
    "JERUSALEM",
    "BETHLEHEM",
    "NAZARETH",
    "GALILEE",
    "JORDAN",
    "GENESIS",
    "EXODUS",
    "PSALMS",
    "PROVERBS",
    "MATTHEW",
    "MARK",
    "LUKE",
    "JOHN",
    "PETER",
    "PAUL",
    "STEPHEN",
    "ELIJAH",
    "DANIEL"
};
    String[] questions = {
        "Who built the ark?",
        "Which Bible book comes first?",
        "Who was swallowed by a great fish?",
        "Who defeated Goliath?",
        "How many disciples did Jesus choose?",
        "Who led the Israelites out of Egypt?",
        "What was the first miracle of Jesus recorded in John?",
        "Who was the mother of Jesus?",
        "Who betrayed Jesus?",
        "What did David use to defeat Goliath?",
        "Who received the Ten Commandments?",
        "Which New Testament book has only one chapter and is addressed to Philemon?",
        "Who was known for his great wisdom?",
        "Where was Jesus born?",
        "Who denied Jesus three times?"
};

String[][] options = {
        {"Moses", "Noah", "David", "Abraham"},
        {"Exodus", "Genesis", "Matthew", "Psalms"},
        {"Jonah", "Peter", "Paul", "Daniel"},
        {"Solomon", "David", "Samuel", "Joshua"},
        {"10", "11", "12", "14"},
        {"Moses", "Joshua", "Aaron", "Samuel"},
        {"Walking on water", "Turning water into wine", "Healing a blind man", "Feeding 5,000"},
        {"Mary", "Martha", "Elizabeth", "Sarah"},
        {"Peter", "Judas Iscariot", "Thomas", "John"},
        {"A sword", "A spear", "A sling and stones", "A bow"},
        {"David", "Moses", "Solomon", "Joshua"},
        {"Philemon", "Romans", "Genesis", "Revelation"},
        {"Solomon", "Samson", "Paul", "Isaiah"},
        {"Jerusalem", "Nazareth", "Bethlehem", "Capernaum"},
        {"John", "Peter", "James", "Matthew"}
};

int[] answers = {
        1,
        1,
        0,
        1,
        2,
        0,
        1,
        0,
        1,
        2,
        1,
        0,
        0,
        2,
        1
};
String[] level2Questions = {
        "Which prophet confronted the prophets of Baal on Mount Carmel?",
        "Who interpreted Pharaoh's dreams in Egypt?",
        "Which judge of Israel was known for his great strength?",
        "Who was the father of King Solomon?",
        "Which disciple was also called Didymus?"
};

String[][] level2Options = {
        {"Elijah", "Isaiah", "Jeremiah", "Ezekiel"},
        {"Joseph", "Daniel", "Moses", "Aaron"},
        {"Gideon", "Samson", "Samuel", "Jephthah"},
        {"Saul", "David", "Samuel", "Jesse"},
        {"Peter", "Thomas", "Andrew", "Philip"}
};

int[] level2Answers = {0, 0, 1, 1, 1};
    String[] level3Questions = {
        "Which king of Judah was shown the shadow moving backward as a sign?",
        "Which prophet married Gomer?",
        "Who was the first Christian martyr recorded in Acts?",
        "Which judge made a vow before going into battle against the Ammonites?",
        "Which king asked God for wisdom rather than riches or long life?"
};

String[][] level3Options = {
        {"Hezekiah", "Josiah", "Uzziah", "Manasseh"},
        {"Hosea", "Amos", "Joel", "Micah"},
        {"Stephen", "James", "Barnabas", "Philip"},
        {"Jephthah", "Gideon", "Samson", "Ehud"},
        {"Solomon", "David", "Saul", "Rehoboam"}
};

int[] level3Answers = {0, 0, 0, 0, 0};
    int currentQuestion = 0;
    int currentLevel = 1;
    int highestLevelUnlocked = 1;
    int score = 0;
    int scrambleQuestion = 0;
int scrambleScore = 0;
  int totalPoints = 0;
  int learnedVerses = 0;
  int dailyStreak = 0;
    
  boolean challengeCompletedToday = false;
  String lastChallengeDate = "";
    int correctAnswers = 0;
int wrongAnswers = 0;

boolean answered = false;
CountDownTimer timer;

int timeLimit = 30000;

// Bible Journey
String currentBibleBook = "";
String currentBibleDifficulty = "";

int bibleJourneyQuestion = 0;
int bibleJourneyScore = 0;

ArrayList<String> bibleJourneyQuestions = new ArrayList<>();
ArrayList<String[]> bibleJourneyOptions = new ArrayList<>();
ArrayList<Integer> bibleJourneyAnswers = new ArrayList<>();
    void loadGenesisQuestions(String difficulty) {

    bibleJourneyQuestions.clear();
    bibleJourneyOptions.clear();
    bibleJourneyAnswers.clear();

    if (difficulty.equals("Easy")) {

    bibleJourneyQuestions.add("Who created the heavens and the earth?");
    bibleJourneyOptions.add(new String[]{
            "God", "Moses", "Abraham", "Noah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was the first man?");
    bibleJourneyOptions.add(new String[]{
            "Noah", "Adam", "Abraham", "Jacob"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("Who was the first woman?");
    bibleJourneyOptions.add(new String[]{
            "Sarah", "Rachel", "Eve", "Rebekah"
    });
    bibleJourneyAnswers.add(2);

    bibleJourneyQuestions.add("Who built the ark?");
    bibleJourneyOptions.add(new String[]{
            "Abraham", "Noah", "Isaac", "Jacob"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("What was the name of Adam's wife?");
    bibleJourneyOptions.add(new String[]{
            "Eve", "Sarah", "Leah", "Rachel"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Cain's brother?");
    bibleJourneyOptions.add(new String[]{
            "Abel", "Seth", "Enoch", "Noah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who killed Abel?");
    bibleJourneyOptions.add(new String[]{
            "Seth", "Cain", "Noah", "Lamech"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("What sign did God give after the flood?");
    bibleJourneyOptions.add(new String[]{
            "A rainbow", "A star", "A cloud", "A pillar of fire"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Abraham's wife?");
    bibleJourneyOptions.add(new String[]{
            "Rachel", "Sarah", "Leah", "Rebekah"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("Who was Abraham's promised son through Sarah?");
    bibleJourneyOptions.add(new String[]{
            "Ishmael", "Isaac", "Jacob", "Joseph"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("Who was Isaac's wife?");
    bibleJourneyOptions.add(new String[]{
            "Rebekah", "Sarah", "Rachel", "Leah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Isaac's firstborn son?");
    bibleJourneyOptions.add(new String[]{
            "Jacob", "Joseph", "Esau", "Judah"
    });
    bibleJourneyAnswers.add(2);

    bibleJourneyQuestions.add("Who was Jacob's twin brother?");
    bibleJourneyOptions.add(new String[]{
            "Joseph", "Esau", "Benjamin", "Reuben"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("What new name was given to Jacob?");
    bibleJourneyOptions.add(new String[]{
            "Israel", "Judah", "Ephraim", "Benjamin"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Jacob's beloved son from Rachel?");
    bibleJourneyOptions.add(new String[]{
            "Joseph", "Judah", "Levi", "Reuben"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Joseph's younger full brother?");
    bibleJourneyOptions.add(new String[]{
            "Benjamin", "Judah", "Dan", "Gad"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph's brothers do to him?");
    bibleJourneyOptions.add(new String[]{
            "Sold him", "Crowned him", "Made him king", "Sent him to Canaan"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("To which country was Joseph taken?");
    bibleJourneyOptions.add(new String[]{
            "Egypt", "Moab", "Philistia", "Assyria"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Joseph's father?");
    bibleJourneyOptions.add(new String[]{
            "Isaac", "Jacob", "Abraham", "Esau"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("What did Joseph's brothers dip his coat in?");
    bibleJourneyOptions.add(new String[]{
            "Blood", "Water", "Oil", "Wine"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who interpreted dreams in Genesis?");
    bibleJourneyOptions.add(new String[]{
            "Joseph", "Moses", "Joshua", "Aaron"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did God create on the first day?");
    bibleJourneyOptions.add(new String[]{
            "Light", "Animals", "The sun", "Man"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did God create on the sixth day?");
    bibleJourneyOptions.add(new String[]{
            "Man", "The moon", "The sea", "Light"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What garden did God place Adam and Eve in?");
    bibleJourneyOptions.add(new String[]{
            "Garden of Eden", "Garden of Gethsemane", "Garden of Egypt", "Garden of Bethel"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did God tell Noah to build?");
    bibleJourneyOptions.add(new String[]{
            "An ark", "A temple", "A tower", "A palace"
    });
    bibleJourneyAnswers.add(0);

    } else if (difficulty.equals("Medium")) {

    bibleJourneyQuestions.add("What was the name of Abraham's nephew?");
    bibleJourneyOptions.add(new String[]{
            "Lot", "Laban", "Esau", "Ishmael"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Why did Abraham and Lot separate?");
    bibleJourneyOptions.add(new String[]{
            "Their herdsmen quarreled", "God commanded them to separate",
            "Lot wanted to leave Canaan", "Abraham became angry with Lot"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Which cities were destroyed when Lot lived nearby?");
    bibleJourneyOptions.add(new String[]{
            "Sodom and Gomorrah", "Jericho and Ai",
            "Bethel and Shechem", "Babel and Nineveh"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Lot's wife become when she looked back?");
    bibleJourneyOptions.add(new String[]{
            "A pillar of salt", "A pillar of stone",
            "A cloud of smoke", "A heap of ashes"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of Abraham's first son?");
    bibleJourneyOptions.add(new String[]{
            "Isaac", "Ishmael", "Jacob", "Esau"
    });
    bibleJourneyAnswers.add(1);

    bibleJourneyQuestions.add("Who was Ishmael's mother?");
    bibleJourneyOptions.add(new String[]{
            "Hagar", "Sarah", "Rebekah", "Keturah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was Abraham's original name?");
    bibleJourneyOptions.add(new String[]{
            "Abram", "Abner", "Amram", "Amon"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was Sarah's original name?");
    bibleJourneyOptions.add(new String[]{
            "Sarai", "Sharon", "Serah", "Salome"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did God change Abram's name to?");
    bibleJourneyOptions.add(new String[]{
            "Abraham", "Israel", "Isaac", "Abimelech"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did God change Sarai's name to?");
    bibleJourneyOptions.add(new String[]{
            "Sarah", "Rachel", "Rebekah", "Miriam"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of Isaac's twin brother?");
    bibleJourneyOptions.add(new String[]{
            "Esau", "Jacob", "Joseph", "Benjamin"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Esau sell to Jacob?");
    bibleJourneyOptions.add(new String[]{
            "His birthright", "His coat", "His flock", "His tent"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What food did Jacob give Esau in exchange for his birthright?");
    bibleJourneyOptions.add(new String[]{
            "Bread and pottage of lentils", "Meat and milk",
            "Figs and honey", "Grapes and bread"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Jacob's father-in-law?");
    bibleJourneyOptions.add(new String[]{
            "Laban", "Lot", "Abimelech", "Bethuel"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Jacob's first wife?");
    bibleJourneyOptions.add(new String[]{
            "Leah", "Rachel", "Rebekah", "Bilhah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Jacob's second wife?");
    bibleJourneyOptions.add(new String[]{
            "Rachel", "Leah", "Zilpah", "Dinah"
    });
   

    } else if (difficulty.equals("Hard")) {

    bibleJourneyQuestions.add("What did God command Abraham to take for the sacrifice of Isaac?");
    bibleJourneyOptions.add(new String[]{
            "Isaac", "Ishmael", "Lot", "Eliezer"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("On what mountain did Abraham go to offer Isaac?");
    bibleJourneyOptions.add(new String[]{
            "Moriah", "Sinai", "Carmel", "Ararat"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was the father of Rebekah?");
    bibleJourneyOptions.add(new String[]{
            "Bethuel", "Laban", "Nahor", "Terah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was Rebekah's brother?");
    bibleJourneyOptions.add(new String[]{
            "Laban", "Lot", "Eli", "Ishmael"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Jacob see in his dream at Bethel?");
    bibleJourneyOptions.add(new String[]{
            "A ladder reaching to heaven", "A burning bush",
            "A great flood", "A golden calf"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Jacob call the place where he dreamed of the ladder?");
    bibleJourneyOptions.add(new String[]{
            "Bethel", "Beersheba", "Hebron", "Shechem"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How many years did Jacob agree to serve Laban for Rachel?");
    bibleJourneyOptions.add(new String[]{
            "Seven", "Five", "Ten", "Fourteen"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Laban give Jacob instead of Rachel first?");
    bibleJourneyOptions.add(new String[]{
            "Leah", "Bilhah", "Zilpah", "Dinah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of Rachel's first son?");
    bibleJourneyOptions.add(new String[]{
            "Joseph", "Benjamin", "Dan", "Naphtali"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of Rachel's second son?");
    bibleJourneyOptions.add(new String[]{
            "Benjamin", "Joseph", "Judah", "Gad"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of the place where Jacob wrestled with a man?");
    bibleJourneyOptions.add(new String[]{
            "Peniel", "Bethel", "Shechem", "Hebron"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What new name was Jacob given after wrestling?");
    bibleJourneyOptions.add(new String[]{
            "Israel", "Edom", "Judah", "Joseph"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph dream about that his brothers would bow before?");
    bibleJourneyOptions.add(new String[]{
            "Sheaves of grain", "Stars only", "Sheep", "Trees"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How many stars appeared in Joseph's second dream?");
    bibleJourneyOptions.add(new String[]{
            "Eleven", "Twelve", "Seven", "Ten"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Jacob give Joseph that angered his brothers?");
    bibleJourneyOptions.add(new String[]{
            "A special coat", "A sword", "A flock", "A crown"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who bought Joseph after he was taken to Egypt?");
    bibleJourneyOptions.add(new String[]{
            "Potiphar", "Pharaoh", "Laban", "Abimelech"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What position did Joseph receive in prison?");
    bibleJourneyOptions.add(new String[]{
            "He was put in charge of the prisoners",
            "He became Pharaoh's guard",
            "He became a priest",
            "He became a soldier"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Which two servants of Pharaoh were imprisoned with Joseph?");
    bibleJourneyOptions.add(new String[]{
            "The butler and the baker",
            "The captain and the guard",
            "The priest and the scribe",
            "The shepherd and the steward"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did the chief butler forget to do after being restored?");
    bibleJourneyOptions.add(new String[]{
            "Remember Joseph", "Return to prison",
            "Tell Pharaoh about his dream", "Leave Egypt"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How old was Joseph when he stood before Pharaoh?");
    bibleJourneyOptions.add(new String[]{
            "Thirty", "Twenty", "Seventeen", "Forty"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How many years of famine followed the seven years of plenty?");
    bibleJourneyOptions.add(new String[]{
            "Seven", "Five", "Three", "Ten"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph's brothers take back to Jacob as evidence that Joseph was dead?");
    bibleJourneyOptions.add(new String[]{
            "His coat", "His sandals", "His staff", "His belt"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Which brother remained with Jacob when the brothers first went to Egypt?");
    bibleJourneyOptions.add(new String[]{
            "Benjamin", "Joseph", "Simeon", "Judah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Which brother offered himself as a substitute for Benjamin?");
    bibleJourneyOptions.add(new String[]{
            "Judah", "Reuben", "Simeon", "Levi"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph's brothers place in Benjamin's sack?");
    bibleJourneyOptions.add(new String[]{
            "Joseph's silver cup", "A gold ring",
            "A royal robe", "A loaf of bread"
    });
    bibleJourneyAnswers.add(0);

     } else if (difficulty.equals("Scholar")) {

    bibleJourneyQuestions.add("What did Noah's sons Shem and Japheth use to cover Noah?");
    bibleJourneyOptions.add(new String[]{
            "A garment", "A curtain", "A tent", "A cloak of Joseph"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Noah say would happen to Canaan?");
    bibleJourneyOptions.add(new String[]{
            "He would be a servant of servants", "He would become king",
            "He would inherit the ark", "He would become a priest"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of Noah's son who saw his father's nakedness?");
    bibleJourneyOptions.add(new String[]{
            "Ham", "Shem", "Japheth", "Canaan"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Which descendant of Cush is described as a mighty hunter before the LORD?");
    bibleJourneyOptions.add(new String[]{
            "Nimrod", "Canaan", "Phut", "Seba"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did the people of Babel say they wanted to build?");
    bibleJourneyOptions.add(new String[]{
            "A city and a tower", "An ark and a temple",
            "A palace and an altar", "A wall and a gate"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Why did the LORD confuse the language of the people at Babel?");
    bibleJourneyOptions.add(new String[]{
            "To prevent them from understanding one another",
            "Because they refused to build an altar",
            "Because they attacked Abraham",
            "Because they worshipped the sun"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What relationship did Abram say Sarai had to him?");
    bibleJourneyOptions.add(new String[]{
            "She was his half-sister", "She was his cousin",
            "She was his aunt", "She was his niece"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Abram tell Sarai to say about their relationship in Egypt?");
    bibleJourneyOptions.add(new String[]{
            "That she was his sister", "That she was his wife",
            "That she was his servant", "That she was his daughter"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Melchizedek bring out to Abram?");
    bibleJourneyOptions.add(new String[]{
            "Bread and wine", "Bread and water",
            "Wine and oil", "Milk and honey"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What was the name of the Egyptian servant given to Sarai?");
    bibleJourneyOptions.add(new String[]{
            "Hagar", "Keturah", "Bilhah", "Zilpah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What name did Hagar give to the LORD who spoke to her?");
    bibleJourneyOptions.add(new String[]{
            "El Roi", "El Shaddai", "Jehovah Jireh", "Jehovah Nissi"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("At what age was Abraham circumcised?");
    bibleJourneyOptions.add(new String[]{
            "Ninety-nine", "Seventy-five", "Eighty-six", "One hundred"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("At what age was Ishmael circumcised?");
    bibleJourneyOptions.add(new String[]{
            "Thirteen", "Twelve", "Fourteen", "Seventeen"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How many men did Abraham initially ask the LORD to spare Sodom for if found righteous?");
    bibleJourneyOptions.add(new String[]{
            "Fifty", "Forty", "Thirty", "Ten"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("How many righteous people did Abraham finally ask about before stopping his requests?");
    bibleJourneyOptions.add(new String[]{
            "Ten", "Five", "Seven", "Twenty"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Lot offer the men of Sodom instead of his visitors?");
    bibleJourneyOptions.add(new String[]{
            "His two daughters", "His servants",
            "His livestock", "His house"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What happened to Lot's wife because she looked back?");
    bibleJourneyOptions.add(new String[]{
            "She became a pillar of salt", "She became blind",
            "She fell into the sea", "She became a pillar of stone"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Abraham call the place where God provided a ram instead of Isaac?");
    bibleJourneyOptions.add(new String[]{
            "Jehovah-jireh", "Bethel", "Peniel", "Beer-sheba"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("Who was the servant Abraham sent to find a wife for Isaac?");
    bibleJourneyOptions.add(new String[]{
            "His eldest servant of his house", "Lot",
            "Eliezer of Damascus", "Laban"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What sign did Rebekah give that identified her as the woman chosen for Isaac?");
    bibleJourneyOptions.add(new String[]{
            "She offered water to Abraham's servant and his camels",
            "She brought bread to the servant",
            "She gave him a ring immediately",
            "She invited him into her father's house first"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Isaac call the well where the Philistines contended with his servants?");
    bibleJourneyOptions.add(new String[]{
            "Sitnah", "Esek", "Rehoboth", "Shibah"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Jacob place under his head when he dreamed at Bethel?");
    bibleJourneyOptions.add(new String[]{
            "A stone", "A piece of wood", "His staff", "A rolled garment"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What wages did Jacob agree to receive for keeping Laban's spotted and speckled animals?");
    bibleJourneyOptions.add(new String[]{
            "The speckled, spotted and brown animals",
            "Only the strongest sheep",
            "Half of Laban's flock",
            "All the firstborn animals"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph's brothers do with him before selling him?");
    bibleJourneyOptions.add(new String[]{
            "They cast him into a pit", "They chained him to a tree",
            "They hid him in a house", "They left him in the wilderness"
    });
    bibleJourneyAnswers.add(0);

    bibleJourneyQuestions.add("What did Joseph require his brothers to bring to Egypt when they returned for more grain?");
    bibleJourneyOptions.add(new String[]{
            "Benjamin", "Reuben", "Jacob", "Judah"
    });
    bibleJourneyAnswers.add(0);
    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

    NotificationChannel channel =
            new NotificationChannel(
                    "kingdom_life_reminders",
                    "Kingdom Life Reminders",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

    channel.setDescription(
            "Reminders for Bible reading, Memory Verse, and Daily Challenge."
    );

    NotificationManager manager =
            getSystemService(NotificationManager.class);

    if (manager != null) {
        manager.createNotificationChannel(channel);
    }
            if (Build.VERSION.SDK_INT >= 33) {

    if (checkSelfPermission(
            "android.permission.POST_NOTIFICATIONS"
    ) != PackageManager.PERMISSION_GRANTED) {

        requestPermissions(
                new String[]{
                        "android.permission.POST_NOTIFICATIONS"
                },
                2001
        );
    }
            }
        }
        savedVersesPrefs = getSharedPreferences(
        "saved_verses",
        MODE_PRIVATE
);
        notesPrefs = getSharedPreferences(
        "bible_notes",
        MODE_PRIVATE
);
        highlightsPrefs = getSharedPreferences(
        "bible_highlights",
        MODE_PRIVATE
);
        bookmarksPrefs = getSharedPreferences(
        "bible_bookmarks",
        MODE_PRIVATE
);
        challengePrefs = getSharedPreferences(
        "daily_challenge",
        MODE_PRIVATE
);
      prefs = getSharedPreferences("KingdomLifePrefs", MODE_PRIVATE);
dailyStreak = prefs.getInt("dailyStreak", 0);
totalPoints = prefs.getInt("totalPoints", 0);
learnedVerses = prefs.getInt("learnedVerses", 0);
        SharedPreferences savedVersesPrefs;
lastChallengeDate = prefs.getString("lastChallengeDate", "");

String today =
        new java.text.SimpleDateFormat(
                "yyyy-MM-dd",
                java.util.Locale.getDefault()
        ).format(new java.util.Date());

challengeCompletedToday =
        today.equals(lastChallengeDate);

highestLevelUnlocked = prefs.getInt("highestLevelUnlocked", 1);
        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(0, 0, 0, 80);
        main.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("Kingdom Life");
        title.setTextSize(28);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 30, 0, 15);

        main.addView(title);

        ScrollView scrollView = new ScrollView(this);

content = new LinearLayout(this);
content.setOrientation(LinearLayout.VERTICAL);
content.setPadding(20, 10, 20, 25);

scrollView.addView(content);

main.addView(scrollView, new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        0,
        1
));
        LinearLayout bottomNav = new LinearLayout(this);
bottomNav.setOrientation(LinearLayout.HORIZONTAL);
bottomNav.setGravity(Gravity.CENTER);
bottomNav.setPadding(4, 4, 4, 4);

String[] navItems = {
        "🏠\nHome",
        "📖\nLearn",
        "🔎\nExplore",
        "🏆\nAchievements",
        "⋯\nMore"
};

for (String item : navItems) {

    Button navButton = new Button(this);

    navButton.setText(item);
    navButton.setTextSize(11);
    navButton.setAllCaps(false);
    navButton.setTextColor(Color.WHITE);
    navButton.setGravity(Gravity.CENTER);

    GradientDrawable navBackground =
            new GradientDrawable();

    navBackground.setColor(
            Color.argb(220, 0, 0, 0)
    );

    navBackground.setCornerRadius(18);

    navButton.setBackground(navBackground);

    LinearLayout.LayoutParams navParams =
            new LinearLayout.LayoutParams(
                    0,
                    60,
                    1
            );

    navParams.setMargins(2, 2, 2, 2);

    bottomNav.addView(navButton, navParams);

    if (item.contains("Home")) {

        navButton.setOnClickListener(v ->
                showHome()
        );

    } else if (item.contains("Learn")) {

    navButton.setOnClickListener(v ->
            showLearnMenu()
    );

    } else if (item.contains("Explore")) {

    navButton.setOnClickListener(v ->
            showExplore()
    );

    } else if (item.contains("Achievements")) {

        navButton.setOnClickListener(v ->
                showAchievements()
        );

    } else {

    navButton.setOnClickListener(v ->
            showMoreMenu()
    );
    }
}

main.addView(bottomNav);
    setContentView(main);

content.removeAllViews();

TextView loading = new TextView(this);
loading.setText("✝️\n\nKingdom Life\n\nLoading...");
loading.setTextSize(24);
loading.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
loading.setTextColor(darkText);
loading.setGravity(Gravity.CENTER);
loading.setPadding(0, 80, 0, 80);

content.addView(loading);

new Handler().postDelayed(() -> {
    showHome();
}, 1200);
    }

    void showHome() {
        stopTimer();
content.removeAllViews();
        content.setPadding(12, 0, 12, 12);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

if (hour >= 6 && hour < 18) {
    content.setBackgroundResource(R.drawable.kingdom_home_bg);
} else {
    content.setBackgroundResource(R.drawable.kingdom_night_bg);
}

/* ===== KINGDOM LIFE HEADER ===== */

LinearLayout header = new LinearLayout(this);
header.setOrientation(LinearLayout.HORIZONTAL);
header.setGravity(Gravity.CENTER_VERTICAL);
header.setPadding(5, 15, 5, 5);

LinearLayout titleArea = new LinearLayout(this);
titleArea.setOrientation(LinearLayout.VERTICAL);
titleArea.setGravity(Gravity.CENTER_VERTICAL);

TextView kingdomTitle = new TextView(this);
kingdomTitle.setText("👑 Kingdom Life");
kingdomTitle.setTextSize(28);
kingdomTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
kingdomTitle.setTextColor(darkText);

titleArea.addView(kingdomTitle);

TextView kingdomSubtitle = new TextView(this);
kingdomSubtitle.setText("Grow in faith. Live with purpose.");
kingdomSubtitle.setTextSize(15);
kingdomSubtitle.setTextColor(darkText);

titleArea.addView(kingdomSubtitle);

LinearLayout.LayoutParams titleParams =
        new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        );

header.addView(titleArea, titleParams);

Button settingsButton = new Button(this);
settingsButton.setText("⚙️");
settingsButton.setTextSize(20);
settingsButton.setAllCaps(false);
settingsButton.setTextColor(darkText);
settingsButton.setBackgroundColor(Color.TRANSPARENT);

settingsButton.setOnClickListener(v -> showSettings());

header.addView(settingsButton);

content.addView(header);
        Space headerSpace = new Space(this);

content.addView(
        headerSpace,
        new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                12
        )
);

/* ===== DATE ===== */

TextView dateText = new TextView(this);

String currentDate = new SimpleDateFormat(
        "EEEE, MMMM d, yyyy",
        Locale.getDefault()
).format(new Date());

dateText.setText("📅 " + currentDate);
dateText.setTextSize(15);
dateText.setTextColor(darkText);
dateText.setGravity(Gravity.CENTER);
dateText.setPadding(0, 5, 0, 15);

content.addView(dateText);

/* ===== WELCOME ===== */

TextView welcome = new TextView(this);
welcome.setText("🌅 Welcome to Kingdom Life");
welcome.setTextSize(22);
welcome.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
welcome.setTextColor(darkText);
welcome.setPadding(5, 10, 5, 18);

content.addView(welcome);



        addCard(
                "📖 Verse of the Day",
                "Jeremiah 29:11 — KJV\n\nFor I know the thoughts that I think toward you, saith the LORD, thoughts of peace, and not of evil, to give you an expected end.",
                v -> showVerse()
        );

        addCard(
                "🙏 Prayer for the Day",
                "Take a moment to pray for guidance, strength, wisdom, and peace today.",
                v -> showPrayer()
        );

        addCard(
                "💭 Food for Thought",
                "How can you show kindness, patience, and faith to someone today?",
                v -> showThought()
        );
String[] dailyChallenges = {
        "Read today's verse, say a short prayer, and do one act of kindness.",
        "Read a Bible passage, thank God for three things, and encourage someone.",
        "Spend a few quiet minutes in prayer and help someone who needs it.",
        "Read today's verse twice, reflect on it, and show patience to someone.",
        "Say a prayer for someone else and do one helpful thing without being asked.",
        "Read a Bible passage and write down one thing you learned from it.",
        "Thank God for the week, read today's verse, and encourage someone."
};

int challengeIndex = (int) (
        System.currentTimeMillis() / (1000L * 60 * 60 * 24)
        % dailyChallenges.length
);


        addHomeButtonGrid();

addCard(
        "▶️ Continue Learning",
        "Continue your Bible learning journey from where you left off.",
        v -> showBible()
);

        
    }
    void addCard(String heading, String message, View.OnClickListener listener) {

    LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setPadding(28, 22, 28, 22);

    // Soft rounded background
    GradientDrawable cardBackground = new GradientDrawable();
    cardBackground.setColor(Color.argb(225, 255, 255, 255));
    cardBackground.setCornerRadius(32);
    card.setBackground(cardBackground);

    // Subtle depth
    card.setElevation(6);

    card.setOnClickListener(listener);

    LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );

    cardParams.setMargins(12, 10, 12, 10);

    TextView headingView = new TextView(this);
    headingView.setText(heading);
    headingView.setTextSize(20);
    headingView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    headingView.setTextColor(darkText);
    headingView.setGravity(Gravity.CENTER_VERTICAL);

    card.addView(headingView);

    TextView messageView = new TextView(this);
    messageView.setText(message);
    messageView.setTextSize(16);
    messageView.setTextColor(darkText);
    messageView.setPadding(0, 10, 0, 0);

    card.addView(messageView);

    content.addView(card, cardParams);
    }
void addHomeButtonGrid() {

    LinearLayout grid = new LinearLayout(this);
    grid.setOrientation(LinearLayout.VERTICAL);

    LinearLayout.LayoutParams gridParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    gridParams.setMargins(8, 8, 8, 8);

    // FIRST ROW
    LinearLayout row1 = new LinearLayout(this);
    row1.setOrientation(LinearLayout.HORIZONTAL);

    row1.addView(createHomeSquareButton(
            "📖\nBible Quiz",
            v -> showGameMenu()
    ));

    row1.addView(createHomeSquareButton(
            "🧠\nMemory Verse",
            v -> showMemoryVerse()
    ));

    row1.addView(createHomeSquareButton(
            "🧩\nPuzzle",
            v -> showGameMenu()
    ));

    grid.addView(row1);

    // SECOND ROW
    LinearLayout row2 = new LinearLayout(this);
    row2.setOrientation(LinearLayout.HORIZONTAL);
    
row2.addView(createHomeSquareButton(
        "🎯\nDaily Challenge",
        v -> showDailyChallenge()
));
    row2.addView(createHomeSquareButton(
            "📊\nProgress",
            v -> showProgress()
    ));

    row2.addView(createHomeSquareButton(
            "🏆\nAchievements",
            v -> showAchievements()
    ));

    grid.addView(row2);

    content.addView(grid, gridParams);
    }
    View createHomeSquareButton(
        String text,
        View.OnClickListener listener
) {

    Button button = new Button(this);

    button.setText(text);
    button.setTextSize(14);
    button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    button.setTextColor(Color.WHITE);
    button.setGravity(Gravity.CENTER);
    button.setAllCaps(false);

    GradientDrawable background = new GradientDrawable();
    background.setColor(Color.argb(220, 0, 0, 0));
    background.setCornerRadius(24);

    button.setBackground(background);
    button.setElevation(4);
    button.setOnClickListener(listener);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    0,
                    120,
                    1
            );

    params.setMargins(4, 4, 4, 4);

    button.setLayoutParams(params);

    return button;
    }
    void showVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Verse of the Day");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView verse = new TextView(this);
    String[] dailyVerses = {
        "Joshua 1:9 — KJV\n\n" +
        "Have not I commanded thee? Be strong and of a good courage; " +
        "be not afraid, neither be thou dismayed: for the LORD thy God is with thee whithersoever thou goest.",

        "Psalm 23:1 — KJV\n\n" +
        "The LORD is my shepherd; I shall not want.",

        "Proverbs 3:5 — KJV\n\n" +
        "Trust in the LORD with all thine heart; and lean not unto thine own understanding.",

        "Isaiah 41:10 — KJV\n\n" +
        "Fear thou not; for I am with thee: be not dismayed; for I am thy God: " +
        "I will strengthen thee; yea, I will help thee; yea, I will uphold thee with the right hand of my righteousness.",

        "Philippians 4:13 — KJV\n\n" +
        "I can do all things through Christ which strengtheneth me.",

        "Psalm 119:105 — KJV\n\n" +
        "Thy word is a lamp unto my feet, and a light unto my path.",

        "Romans 8:28 — KJV\n\n" +
        "And we know that all things work together for good to them that love God, " +
        "to them who are the called according to his purpose."
};

int verseIndex = (int) (
        System.currentTimeMillis() / (1000L * 60 * 60 * 24)
        % dailyVerses.length
);

verse.setText(dailyVerses[verseIndex]);
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 25);
    content.addView(verse);

    addButton("🧠 Mark as Learned", v -> {
      learnedVerses++;
totalPoints += 5;

prefs.edit()
        .putInt("learnedVerses", learnedVerses)
        .putInt("totalPoints", totalPoints)
        .apply();
        showMessage(
                "✅ Verse Learned",
                "Jeremiah 29:11 has been marked as learned.\n\n" +
                "+5 points"
        );
    });

    addButton("⬅️ Back to Home", v -> showHome());
    }

    void showThought() {
    String[] dailyThoughts = {
            "💭 Food for Thought\n\n" +
            "Kindness does not always require something big. " +
            "A simple word of encouragement, patience, or helping someone can make a difference.\n\n" +
            "Reflection:\nWhat is one good thing you can do for someone today?",

            "💭 Food for Thought\n\n" +
            "Your words can bring hope to someone who needs encouragement.\n\n" +
            "Reflection:\nHow can you use your words to encourage someone today?",

            "💭 Food for Thought\n\n" +
            "Patience helps us respond with wisdom instead of reacting in anger.\n\n" +
            "Reflection:\nIs there a situation where you can practice more patience?",

            "💭 Food for Thought\n\n" +
            "Gratitude helps us notice the good things we often overlook.\n\n" +
            "Reflection:\nWhat are three things you are thankful for today?",

            "💭 Food for Thought\n\n" +
            "Forgiveness can help us let go of anger and choose peace.\n\n" +
            "Reflection:\nIs there someone you can choose to forgive?",

            "💭 Food for Thought\n\n" +
            "Serving others is one way to show love through action.\n\n" +
            "Reflection:\nWhat helpful thing can you do for someone today?",

            "💭 Food for Thought\n\n" +
            "Doing what is right matters even when nobody is watching.\n\n" +
            "Reflection:\nWhat good choice can you make today?"
    };

    int thoughtIndex = (int) (
            System.currentTimeMillis() / (1000L * 60 * 60 * 24)
            % dailyThoughts.length
    );

    showMessage(
            "💭 Food for Thought",
            dailyThoughts[thoughtIndex]
    );
    }
  void showPrayer() {
    String[] dailyPrayers = {
            "Lord, guide us today and give us wisdom in every decision we make. " +
            "Strengthen our faith, help us walk in love and truth, and give us peace.\n\nAmen.",

            "Lord, thank You for this new day. Help us to be grateful, kind, and faithful " +
            "in everything we do. Give us strength to make good choices today.\n\nAmen.",

            "Lord, give us courage when we face difficult moments. Help us trust You, " +
            "learn from our challenges, and continue doing what is right.\n\nAmen.",

            "Lord, help us treat others with patience, respect, and kindness. " +
            "Teach us to be a source of encouragement and peace wherever we go.\n\nAmen.",

            "Lord, give us wisdom in our studies, work, friendships, and decisions. " +
            "Help us use what we learn to make a positive difference.\n\nAmen.",

            "Lord, help us forgive, show compassion, and choose peace. " +
            "Guide our hearts and actions throughout this day.\n\nAmen.",

            "Lord, thank You for bringing us through another week. " +
            "Help us reflect on what we have learned and prepare our hearts for the days ahead.\n\nAmen."
    };

    int prayerIndex = (int) (
            System.currentTimeMillis() / (1000L * 60 * 60 * 24)
            % dailyPrayers.length
    );

    showMessage(
            "🙏 Prayer for the Day",
            dailyPrayers[prayerIndex]
    );
  }

    void showMemoryVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🧠 Memory Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a Memory Verse challenge:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 20);
    content.addView(instruction);

    addButton("📖 Guess the Verse", v -> showGuessVerse());

    addButton("✍️ Complete the Verse", v -> showCompleteVerse());

    addButton("🔄 Guess the Reference", v -> showGuessReference());

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showBible() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Holy Bible — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "King James Version\n\n" +
            "The complete Bible will be organized here by:\n\n" +
            "📚 Old Testament\n" +
            "📚 New Testament\n\n" +
            "Choose a book and chapter to begin reading."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(0, 10, 0, 20);
    content.addView(message);

    addButton(
        "📚 Old Testament",
        v -> showOldTestament()
);
        addButton(
        "🔎 Search Bible",
        v -> showBibleSearch()
);

    addButton(
        "📚 New Testament",
        v -> showNewTestament()
);

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showOldTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 Old Testament");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String[] books = {
            "Genesis",
            "Exodus",
            "Leviticus",
            "Numbers",
            "Deuteronomy",
            "Joshua",
            "Judges",
            "Ruth",
            "1 Samuel",
            "2 Samuel",
            "1 Kings",
            "2 Kings",
            "1 Chronicles",
            "2 Chronicles",
            "Ezra",
            "Nehemiah",
            "Esther",
            "Job",
            "Psalms",
            "Proverbs",
            "Ecclesiastes",
            "Song of Solomon",
            "Isaiah",
            "Jeremiah",
            "Lamentations",
            "Ezekiel",
            "Daniel",
            "Hosea",
            "Joel",
            "Amos",
            "Obadiah",
            "Jonah",
            "Micah",
            "Nahum",
            "Habakkuk",
            "Zephaniah",
            "Haggai",
            "Zechariah",
            "Malachi"
    };

    for (String book : books) {

    if (book.equals("Genesis")) {

        addButton(
                "📖 " + book,
                v -> showBookChapters("Genesis", 50)
        );

    } else if (book.equals("Exodus")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Exodus", 40)
    );

} else if (book.equals("Leviticus")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Leviticus", 27)
    );

} else if (book.equals("Numbers")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Numbers", 36)
    );

} else if (book.equals("Deuteronomy")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Deuteronomy", 34)
    );

} else if (book.equals("Joshua")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Joshua", 24)
    );

} else if (book.equals("Judges")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Judges", 21)
    );

} else if (book.equals("Ruth")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ruth", 4)
    );

} else if (book.equals("1 Samuel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Samuel", 31)
    );

} else if (book.equals("2 Samuel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Samuel", 24)
    );

} else if (book.equals("1 Kings")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Kings", 22)
    );

} else if (book.equals("2 Kings")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Kings", 25)
    );

} else if (book.equals("1 Chronicles")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Chronicles", 29)
    );

} else if (book.equals("2 Chronicles")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Chronicles", 36)
    );

} else if (book.equals("Ezra")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ezra", 10)
    );

} else if (book.equals("Nehemiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Nehemiah", 13)
    );

} else if (book.equals("Esther")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Esther", 10)
    );

} else if (book.equals("Job")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Job", 42)
    );
        
} else if (book.equals("Psalms")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Psalms", 150)
    );

} else if (book.equals("Proverbs")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Proverbs", 31)
    );

} else if (book.equals("Ecclesiastes")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ecclesiastes", 12)
    );

} else if (book.equals("Song of Solomon")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Song of Solomon", 8)
    );

} else if (book.equals("Isaiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Isaiah", 66)
    );

} else if (book.equals("Jeremiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Jeremiah", 52)
    );

} else if (book.equals("Lamentations")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Lamentations", 5)
    );

} else if (book.equals("Ezekiel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ezekiel", 48)
    );

} else if (book.equals("Daniel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Daniel", 12)
    );

} else if (book.equals("Hosea")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Hosea", 14)
    );

} else if (book.equals("Joel")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Joel", 3)
    );

} else if (book.equals("Amos")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Amos", 9)
    );

} else if (book.equals("Obadiah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Obadiah", 1)
    );

} else if (book.equals("Jonah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Jonah", 4)
    );

} else if (book.equals("Micah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Micah", 7)
    );

} else if (book.equals("Nahum")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Nahum", 3)
    );

} else if (book.equals("Habakkuk")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Habakkuk", 3)
    );

} else if (book.equals("Zephaniah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Zephaniah", 3)
    );

} else if (book.equals("Haggai")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Haggai", 2)
    );

} else if (book.equals("Zechariah")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Zechariah", 14)
    );

} else if (book.equals("Malachi")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Malachi", 4)
    );


} else {

    addButton(
            "📖 " + book,
            v -> showMessage(
                    "📖 " + book,
                    "Chapters for " + book + " will be added next."
            )
    );
    }
    }
        addButton(
            "⬅️ Back to Bible",
            v -> showBible()
    );
    }
        void showNewTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 New Testament");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String[] books = {
            "Matthew",
            "Mark",
            "Luke",
            "John",
            "Acts",
            "Romans",
            "1 Corinthians",
            "2 Corinthians",
            "Galatians",
            "Ephesians",
            "Philippians",
            "Colossians",
            "1 Thessalonians",
            "2 Thessalonians",
            "1 Timothy",
            "2 Timothy",
            "Titus",
            "Philemon",
            "Hebrews",
            "James",
            "1 Peter",
            "2 Peter",
            "1 John",
            "2 John",
            "3 John",
            "Jude",
            "Revelation"
    };

    for (String book : books) {

    if (book.equals("Matthew")) {

        addButton(
                "📖 " + book,
                v -> showBookChapters("Matthew", 28)
        );

    } else if (book.equals("Mark")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Mark", 16)
    );

} else if (book.equals("Luke")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Luke", 24)
    );

} else if (book.equals("John")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("John", 21)
    );

} else if (book.equals("Acts")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Acts", 28)
    );

} else if (book.equals("Romans")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Romans", 16)
    );

} else if (book.equals("1 Corinthians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Corinthians", 16)
    );

} else if (book.equals("2 Corinthians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Corinthians", 13)
    );

} else if (book.equals("Galatians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Galatians", 6)
    );

} else if (book.equals("Ephesians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Ephesians", 6)
    );

} else if (book.equals("Philippians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Philippians", 4)
    );

} else if (book.equals("Colossians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Colossians", 4)
    );

} else if (book.equals("1 Thessalonians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Thessalonians", 5)
    );

} else if (book.equals("2 Thessalonians")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Thessalonians", 3)
    );

} else if (book.equals("1 Timothy")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Timothy", 6)
    );

} else if (book.equals("2 Timothy")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Timothy", 4)
    );

} else if (book.equals("Titus")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Titus", 3)
    );

} else if (book.equals("Philemon")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Philemon", 1)
    );

} else if (book.equals("Hebrews")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Hebrews", 13)
    );

} else if (book.equals("James")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("James", 5)
    );

} else if (book.equals("1 Peter")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 Peter", 5)
    );

} else if (book.equals("2 Peter")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 Peter", 3)
    );

} else if (book.equals("1 John")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("1 John", 5)
    );

} else if (book.equals("2 John")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("2 John", 1)
    );

} else if (book.equals("3 John")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("3 John", 1)
    );

} else if (book.equals("Jude")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Jude", 1)
    );

} else if (book.equals("Revelation")) {

    addButton(
            "📖 " + book,
            v -> showBookChapters("Revelation", 22)
    );

} else {

        addButton(
                "📖 " + book,
                v -> showMessage(
                        "📖 " + book,
                        "Chapters for " + book + " will be added next."
                )
        );
    }
    }
           }
    void showGenesisChapters() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Genesis");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a chapter:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    for (int chapter = 1; chapter <= 50; chapter++) {

        final int selectedChapter = chapter;

        addButton(
        "📜 Chapter " + chapter,
        v -> showBibleChapter("Genesis", selectedChapter)
);
    }

    addButton(
            "⬅️ Back to Old Testament",
            v -> showOldTestament()
    );
    }
    void showBibleSearch() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Search Bible — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Enter a word or phrase");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
        "🔎 Search",
        v -> {
            String query = searchInput.getText().toString().trim();

            if (query.isEmpty()) {
                showMessage(
                        "🔎 Bible Search",
                        "Please enter a word or phrase to search."
                );
                return;
            }

            showBibleSearchResults(query);
        }
);

    addButton(
            "⬅️ Back to Bible",
            v -> showBible()
    );
    }
    void showBibleSearchResults(String query) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Search Results");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String searchText = query.toLowerCase();
    int resultCount = 0;

    try {

        String[] books = {
                "Genesis", "Exodus", "Leviticus", "Numbers",
                "Deuteronomy", "Joshua", "Judges", "Ruth",
                "1 Samuel", "2 Samuel", "1 Kings", "2 Kings",
                "1 Chronicles", "2 Chronicles", "Ezra", "Nehemiah",
                "Esther", "Job", "Psalms", "Proverbs",
                "Ecclesiastes", "Song of Solomon", "Isaiah", "Jeremiah",
                "Lamentations", "Ezekiel", "Daniel", "Hosea",
                "Joel", "Amos", "Obadiah", "Jonah", "Micah",
                "Nahum", "Habakkuk", "Zephaniah", "Haggai",
                "Zechariah", "Malachi",

                "Matthew", "Mark", "Luke", "John", "Acts",
                "Romans", "1 Corinthians", "2 Corinthians",
                "Galatians", "Ephesians", "Philippians", "Colossians",
                "1 Thessalonians", "2 Thessalonians", "1 Timothy",
                "2 Timothy", "Titus", "Philemon", "Hebrews", "James",
                "1 Peter", "2 Peter", "1 John", "2 John",
                "3 John", "Jude", "Revelation"
        };

        for (String book : books) {

            InputStream inputStream =
                    getAssets().open("kjv/" + book + ".json");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(inputStream)
                    );

            StringBuilder jsonText =
                    new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }

            reader.close();

            JSONObject bible =
                    new JSONObject(jsonText.toString());

            java.util.Iterator<String> chapters =
                    bible.keys();

            while (chapters.hasNext()) {

                String chapterNumber = chapters.next();

                JSONObject chapter =
                        bible.getJSONObject(chapterNumber);

                java.util.Iterator<String> verses =
                        chapter.keys();

                while (verses.hasNext()) {

                    String verseNumber = verses.next();

                    String verseText =
                            chapter.getString(verseNumber);

                    if (verseText.toLowerCase()
                            .contains(searchText)) {

                        TextView result = new TextView(this);

                        result.setText(
                                "📖 " + book +
                                " " + chapterNumber +
                                ":" + verseNumber +
                                "\n" + verseText
                        );

                        result.setTextSize(17);
                        result.setTextColor(darkText);
                        result.setPadding(
                                10, 12, 10, 12
                        );

                        content.addView(result);

                        resultCount++;

                        if (resultCount >= 50) {
                            break;
                        }
                    }
                }

                if (resultCount >= 50) {
                    break;
                }
            }

            if (resultCount >= 50) {
                break;
            }
        }

        if (resultCount == 0) {

            TextView none = new TextView(this);

            none.setText(
                    "No verses found for: " + query
            );

            none.setTextSize(18);
            none.setTextColor(darkText);
            none.setPadding(10, 20, 10, 20);

            content.addView(none);
        }

    } catch (Exception e) {

        TextView error = new TextView(this);

        error.setText(
                "Unable to search the Bible.\n\n" +
                e.toString()
        );

        error.setTextSize(16);
        error.setTextColor(darkText);
        error.setPadding(10, 20, 10, 20);

        content.addView(error);
    }

    addButton(
            "⬅️ Back to Search",
            v -> showBibleSearch()
    );
        }
    void saveVerse(String reference, String verseText) {

    if (savedVersesPrefs == null) {
        return;
    }

    savedVersesPrefs.edit()
            .putString(reference, verseText)
            .apply();

    showMessage(
            "⭐ Verse Saved",
            reference + "\n\n" + verseText
    );
    }
    void saveNote(String reference, String noteText) {

    if (notesPrefs == null) {
        return;
    }

    String key = reference + "_" + System.currentTimeMillis();

    notesPrefs.edit()
            .putString(key, noteText)
            .apply();

    showMessage(
            "📝 Note Saved",
            noteText
    );
    }
    void saveHighlight(String reference, String verseText) {

    if (highlightsPrefs == null) {
        return;
    }

    String key =
            reference + "_" + System.currentTimeMillis();

    highlightsPrefs.edit()
            .putString(key, verseText)
            .apply();

    showMessage(
            "🖍️ Verse Highlighted",
            reference + "\n\n" + verseText
    );
    }
    void showSavedVerses() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("⭐ Saved Verses");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    if (savedVersesPrefs.getAll().isEmpty()) {

    TextView message = new TextView(this);
    message.setText(
            "No saved verses yet.\n\n" +
            "Save a verse from the Bible reader and it will appear here."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(10, 10, 10, 20);
    content.addView(message);

} else {

    for (java.util.Map.Entry<String, ?> entry :
            savedVersesPrefs.getAll().entrySet()) {

        String reference = entry.getKey();
        String verseText = entry.getValue().toString();

        addCard(
                "⭐ " + reference,
                verseText,
                v -> {}
        );
    }
    }
    addButton(
            "⬅️ Back to More",
            v -> showMoreMenu()
    );
    }
    void showBibleDictionary() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 Bible Dictionary");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView message = new TextView(this);
    message.setText(
            "Search Bible words and terms to learn their meanings."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(10, 10, 10, 20);
    content.addView(message);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Enter a Bible word");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
        "🔎 Search Dictionary",
        v -> {
            String query =
                    searchInput.getText().toString().trim();

            if (query.isEmpty()) {
                showMessage(
                        "📚 Bible Dictionary",
                        "Please enter a Bible word to search."
                );
                return;
            }

            showDictionaryResult(query);
        }
);

    addButton(
            "⬅️ Back to More",
            v -> showMoreMenu()
    );
    }
    void showDictionaryResult(String query) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 Bible Dictionary");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    String word = query.toLowerCase();

    String meaning = null;

    if (word.equals("faith")) {
        meaning = "Trust and confidence in God and His promises.";
    } else if (word.equals("grace")) {
        meaning = "God's undeserved favor and kindness toward people.";
    } else if (word.equals("prayer")) {
        meaning = "Communication with God through speaking, asking, thanking, and worship.";
    } else if (word.equals("love")) {
        meaning = "Selfless care, affection, and devotion toward God and others.";
    } else if (word.equals("sin")) {
        meaning = "Disobedience or wrongdoing against God's will.";
    } else if (word.equals("salvation")) {
        meaning = "Deliverance from sin and reconciliation with God.";
    } else if (word.equals("wisdom")) {
        meaning = "The ability to understand and apply what is right according to God.";
    } else if (word.equals("forgiveness")) {
        meaning = "Choosing to release someone from the debt of their wrongdoing.";
    } else if (word.equals("hope")) {
        meaning = "Confident expectation and trust in God's promises.";
    } else if (word.equals("peace")) {
        meaning = "A state of calm, reconciliation, and trust in God.";
    }

    if (meaning != null) {

        addCard(
                "🔤 " + query,
                meaning,
                v -> {}
        );

    } else {

        addCard(
                "🔎 No Entry Found",
                "No dictionary entry was found for \"" +
                        query +
                        "\" yet.",
                v -> {}
        );
    }

    addButton(
            "🔎 Search Again",
            v -> showBibleDictionary()
    );

    addButton(
            "⬅️ Back to More",
            v -> showMoreMenu()
    );
    }
    void showMoreMenu() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("⋯ More");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    addButton(
            "⭐ Saved Verses",
            v -> showSavedVerses()
    );
        addButton(
        "🔖 Bookmarks",
        v -> showBookmarks()
);
        addButton(
        "📝 Notes & Highlights",
        v -> showNotesHighlights()
);

    addButton(
            "📚 Bible Dictionary",
            v -> showBibleDictionary()
    );

    addButton(
            "⚙️ Settings",
            v -> showSettings()
    );

    addButton(
            "ℹ️ About Kingdom Life",
            v -> showAbout()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showNotesHighlights() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📝 Notes & Highlights");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    if (notesPrefs.getAll().isEmpty()) {

    TextView message = new TextView(this);
    message.setText(
            "No notes saved yet.\n\n" +
            "Add a note and it will appear here."
    );
    message.setTextSize(18);
    message.setTextColor(darkText);
    message.setPadding(10, 10, 10, 20);
    content.addView(message);

} else {

    for (java.util.Map.Entry<String, ?> entry :
            notesPrefs.getAll().entrySet()) {

        String noteText =
                entry.getValue().toString();

        addCard(
                "📝 Note",
                noteText,
                v -> {}
        );
    }
    }
    addButton(
        "📝 Add Note",
        v -> {

            EditText noteInput = new EditText(this);

            noteInput.setHint("Write your note here");
            noteInput.setTextSize(18);

            content.addView(noteInput);

            addButton(
                    "💾 Save Note",
                    saveView -> {

                        String noteText =
                                noteInput.getText().toString().trim();

                        if (noteText.isEmpty()) {
                            showMessage(
                                    "📝 Add Note",
                                    "Please write a note first."
                            );
                            return;
                        }

                        saveNote(
                                "General Note",
                                noteText
                        );
                    }
            );
        }
);

    addButton(
        "🖍️ Highlights",
        v -> showHighlights()
);
    addButton(
            "⬅️ Back to More",
            v -> showMoreMenu()
    );
    }
    void showLearnMenu() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Learn & Grow");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "📚 Spiritual Growth Books",
            "Read books and resources that help you grow in faith.",
            v -> showSpiritualBooks()
    );

    addCard(
            "🎙️ Sermons",
            "Listen to sermons and messages for spiritual encouragement.",
            v -> showSermons()
    );

    addCard(
            "📖 Bible Study",
            "Explore the Bible and deepen your understanding of Scripture.",
            v -> showBible()
    );

    addCard(
            "🧠 Memory Verse",
            "Practice Scripture and strengthen your Bible memory.",
            v -> showMemoryVerse()
    );

    addCard(
            "🎯 Daily Challenge",
            "Complete a daily faith-building challenge.",
            v -> showDailyChallenge()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showSpiritualBooks() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📚 Spiritual Growth Books");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "📖 Growing in Faith",
            "Learn practical ways to strengthen your faith and walk with God.",
            v -> showMessage(
                    "📖 Growing in Faith",
                    "Book content will be added here."
            )
    );

    addCard(
            "🙏 The Power of Prayer",
            "Explore the importance of prayer and developing a consistent prayer life.",
            v -> showMessage(
                    "🙏 The Power of Prayer",
                    "Book content will be added here."
            )
    );

    addCard(
            "❤️ Living With Love",
            "Learn how Christian love can shape everyday life and relationships.",
            v -> showMessage(
                    "❤️ Living With Love",
                    "Book content will be added here."
            )
    );

    addCard(
            "🌱 Christian Character",
            "Study qualities that help believers grow spiritually and live with purpose.",
            v -> showMessage(
                    "🌱 Christian Character",
                    "Book content will be added here."
            )
    );

    addButton(
            "⬅️ Back to Learn",
            v -> showLearnMenu()
    );
    }
    void showSermons() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🎙️ Sermons");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "🙏 Faith & Trust",
            "A message about trusting God through difficult seasons.",
            v -> showMessage(
                    "🙏 Faith & Trust",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "🔥 Growing Spiritually",
            "A message about developing a stronger relationship with God.",
            v -> showMessage(
                    "🔥 Growing Spiritually",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "❤️ Walking in Love",
            "A message about living out Christian love every day.",
            v -> showMessage(
                    "❤️ Walking in Love",
                    "Sermon content will be added here."
            )
    );

    addCard(
            "🌱 Living With Purpose",
            "A message about living with faith, purpose, and obedience.",
            v -> showMessage(
                    "🌱 Living With Purpose",
                    "Sermon content will be added here."
            )
    );

    addButton(
            "⬅️ Back to Learn",
            v -> showLearnMenu()
    );
    }
    void showBibleChapter(String book, int chapter) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 " + book + " " + chapter + " — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    try {

        InputStream inputStream =
                getAssets().open("kjv/" + book + ".json");

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(inputStream)
                );

        StringBuilder jsonText =
                new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }

        reader.close();

        JSONObject bible =
                new JSONObject(jsonText.toString());

        JSONObject selectedChapter =
                bible.getJSONObject(
                        String.valueOf(chapter)
                );

        java.util.ArrayList<String> verseNumbers =
                new java.util.ArrayList<>();

        java.util.Iterator<String> keys =
                selectedChapter.keys();

        while (keys.hasNext()) {
            verseNumbers.add(keys.next());
        }

        java.util.Collections.sort(
                verseNumbers,
                (a, b) -> Integer.compare(
                        Integer.parseInt(a),
                        Integer.parseInt(b)
                )
        );

        for (String verseNumber : verseNumbers) {

            String verseText =
                    selectedChapter.getString(verseNumber);

            LinearLayout verseLayout =
                    new LinearLayout(this);

            verseLayout.setOrientation(
                    LinearLayout.VERTICAL
            );

            TextView verse = new TextView(this);

            verse.setText(
                    verseNumber + " " + verseText
            );
            String reference =
        book + " " +
        chapter + ":" +
        verseNumber;

            verse.setTextSize(18);
            verse.setTextColor(darkText);
            verse.setPadding(5, 10, 5, 5);
            String savedHighlight =
        highlightsPrefs.getString(
                reference,
                null
        );

if (savedHighlight != null) {

    try {
        String[] parts =
                savedHighlight.split("\\|", 2);

        int highlightColor =
                Integer.parseInt(parts[0]);

        verse.setBackgroundColor(
                highlightColor
        );

    } catch (Exception ignored) {
    }
            }
            

            verseLayout.addView(verse);

            LinearLayout actionRow = new LinearLayout(this);

actionRow.setOrientation(
        LinearLayout.HORIZONTAL
);

actionRow.setGravity(
        Gravity.LEFT | Gravity.CENTER_VERTICAL
);

actionRow.setPadding(0, 0, 0, 5);

// ⭐ Save Verse
Button saveButton = new Button(this);

saveButton.setText("⭐");
saveButton.setTextSize(18);
saveButton.setAllCaps(false);
saveButton.setTextColor(darkText);
saveButton.setBackgroundColor(Color.TRANSPARENT);
saveButton.setPadding(5, 0, 5, 0);

saveButton.setOnClickListener(
        v -> saveVerse(
                reference,
                verseText
        )
);

actionRow.addView(saveButton);

// 🔖 Bookmark
Button bookmarkButton = new Button(this);

bookmarkButton.setText("🔖");
bookmarkButton.setTextSize(18);
bookmarkButton.setAllCaps(false);
bookmarkButton.setTextColor(darkText);
bookmarkButton.setBackgroundColor(Color.TRANSPARENT);
bookmarkButton.setPadding(5, 0, 5, 0);

bookmarkButton.setOnClickListener(v -> {

    if (bookmarksPrefs.contains(reference)) {

        bookmarksPrefs.edit()
                .remove(reference)
                .apply();

        showMessage(
                "🔖 Bookmark Removed",
                reference + " was removed from bookmarks."
        );

    } else {

        saveBookmark(reference);
    }
});

actionRow.addView(bookmarkButton);

// 🖍️ Highlight
Button highlightButton = new Button(this);

highlightButton.setText("🖍️");
highlightButton.setTextSize(18);
highlightButton.setAllCaps(false);
highlightButton.setTextColor(darkText);
highlightButton.setBackgroundColor(Color.TRANSPARENT);
highlightButton.setPadding(5, 0, 5, 0);

highlightButton.setOnClickListener(
        v -> showHighlightColors(
                reference,
                verseText
        )
);

actionRow.addView(highlightButton);

verseLayout.addView(actionRow);

            content.addView(verseLayout);
        }

    } catch (Exception e) {

        TextView error = new TextView(this);

        error.setText(
                "Unable to load this Bible chapter."
        );

        error.setTextSize(18);
        error.setTextColor(darkText);
        error.setPadding(5, 10, 5, 20);

        content.addView(error);
    }

    addButton(
            "⬅️ Back to Chapters",
            v -> showBookChapters(
                    book,
                    getChapterCount(book)
            )
    );
        }
    int getChapterCount(String book) {

    if (book.equals("Genesis")) return 50;
    if (book.equals("Exodus")) return 40;
    if (book.equals("Leviticus")) return 27;
    if (book.equals("Numbers")) return 36;
    if (book.equals("Deuteronomy")) return 34;
    if (book.equals("Joshua")) return 24;
    if (book.equals("Judges")) return 21;
    if (book.equals("Ruth")) return 4;
    if (book.equals("1 Samuel")) return 31;
    if (book.equals("2 Samuel")) return 24;
    if (book.equals("1 Kings")) return 22;
    if (book.equals("2 Kings")) return 25;
    if (book.equals("1 Chronicles")) return 29;
    if (book.equals("2 Chronicles")) return 36;
    if (book.equals("Ezra")) return 10;
    if (book.equals("Nehemiah")) return 13;
    if (book.equals("Esther")) return 10;
    if (book.equals("Job")) return 42;
    if (book.equals("Psalms")) return 150;
    if (book.equals("Proverbs")) return 31;
    if (book.equals("Ecclesiastes")) return 12;
    if (book.equals("Song of Solomon")) return 8;
    if (book.equals("Isaiah")) return 66;
    if (book.equals("Jeremiah")) return 52;
    if (book.equals("Lamentations")) return 5;
    if (book.equals("Ezekiel")) return 48;
    if (book.equals("Daniel")) return 12;
    if (book.equals("Hosea")) return 14;
    if (book.equals("Joel")) return 3;
    if (book.equals("Amos")) return 9;
    if (book.equals("Obadiah")) return 1;
    if (book.equals("Jonah")) return 4;
    if (book.equals("Micah")) return 7;
    if (book.equals("Nahum")) return 3;
    if (book.equals("Habakkuk")) return 3;
    if (book.equals("Zephaniah")) return 3;
    if (book.equals("Haggai")) return 2;
    if (book.equals("Zechariah")) return 14;
    if (book.equals("Malachi")) return 4;

    if (book.equals("Matthew")) return 28;
    if (book.equals("Mark")) return 16;
    if (book.equals("Luke")) return 24;
    if (book.equals("John")) return 21;
    if (book.equals("Acts")) return 28;
    if (book.equals("Romans")) return 16;
    if (book.equals("1 Corinthians")) return 16;
    if (book.equals("2 Corinthians")) return 13;
    if (book.equals("Galatians")) return 6;
    if (book.equals("Ephesians")) return 6;
    if (book.equals("Philippians")) return 4;
    if (book.equals("Colossians")) return 4;
    if (book.equals("1 Thessalonians")) return 5;
    if (book.equals("2 Thessalonians")) return 3;
    if (book.equals("1 Timothy")) return 6;
    if (book.equals("2 Timothy")) return 4;
    if (book.equals("Titus")) return 3;
    if (book.equals("Philemon")) return 1;
    if (book.equals("Hebrews")) return 13;
    if (book.equals("James")) return 5;
    if (book.equals("1 Peter")) return 5;
    if (book.equals("2 Peter")) return 3;
    if (book.equals("1 John")) return 5;
    if (book.equals("2 John")) return 1;
    if (book.equals("3 John")) return 1;
    if (book.equals("Jude")) return 1;
    if (book.equals("Revelation")) return 22;

    return 0;
        }
    void showHighlightColors(String reference, String verseText) {

    stopTimer();

    String[] colors = {
            "🟨 Yellow",
            "🟩 Green",
            "🟦 Blue",
            "🩷 Pink"
    };

    new android.app.AlertDialog.Builder(this)
            .setTitle("🖍️ Choose Highlight Color")
            .setItems(
                    colors,
                    (dialog, which) -> {

                        int color;

                        if (which == 0) {
    color = Color.rgb(255, 245, 157);
} else if (which == 1) {
    color = Color.rgb(200, 230, 201);
} else if (which == 2) {
    color = Color.rgb(187, 222, 251);
} else {
    color = Color.rgb(248, 187, 208);
                        }

                        saveColoredHighlight(
                                reference,
                                verseText,
                                color
                        );
                    }
            )
            .setNegativeButton("Cancel", null)
            .show();
    }
    void saveColoredHighlight(
        String reference,
        String verseText,
        int color
) {

    if (highlightsPrefs == null) {
        return;
    }

    highlightsPrefs.edit()
            .putString(
                    reference,
                    color + "|" + verseText
            )
            .apply();

    showMessage(
            "🖍️ Highlight Saved",
            reference + "\n\n" + verseText
    );
    }
    void showBookChapters(String book, int chapterCount) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 " + book);
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose a chapter:");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    for (int chapter = 1; chapter <= chapterCount; chapter++) {

        final int selectedChapter = chapter;

        addButton(
                "📜 Chapter " + chapter,
                v -> showBibleChapter(book, selectedChapter)
        );
    }

    addButton(
            "⬅️ Back",
            v -> showBible()
    );
    }
    void showGenesisChapter1() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Genesis 1 — KJV");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView chapterText = new TextView(this);
    chapterText.setText(
            getKJVChapter("Genesis", 1)
    );
    chapterText.setTextSize(18);
    chapterText.setTextColor(darkText);
    chapterText.setPadding(5, 10, 5, 20);

    content.addView(chapterText);

    addButton(
            "⬅️ Back to Genesis",
            v -> showGenesisChapters()
    );
    }
    String getKJVChapter(String book, int chapter) {

    try {

        InputStream inputStream =
                getAssets().open("kjv/" + book + ".json");

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(inputStream)
                );

        StringBuilder jsonText =
                new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }

        reader.close();

        JSONObject bible =
                new JSONObject(jsonText.toString());

        JSONObject selectedChapter =
                bible.getJSONObject(
                        String.valueOf(chapter)
                );

        StringBuilder result =
                new StringBuilder();

        java.util.Iterator<String> keys =
                selectedChapter.keys();

        while (keys.hasNext()) {

            String verseNumber = keys.next();

            result.append(verseNumber)
                    .append(" ")
                    .append(selectedChapter.getString(verseNumber))
                    .append("\n\n");
        }

        return result.toString().trim();

    } catch (Exception e) {

        return "ERROR: " + e.toString();
    }
    }
        
  void showProgress() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Progress");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard("⭐ Points", totalPoints + " points earned so far.", v -> {});
addCard("🎮 Game Scores", "Complete Bible games to build your score.", v -> {});
addCard("🧠 Memory Verses", learnedVerses + " verse(s) learned.", v -> {});
addCard("🔥 Daily Streak", dailyStreak + " day(s) streak.", v -> {});
addCard(
        "✅ Challenges",
        challengeCompletedToday
                ? "Today's challenge completed."
                : "Today's challenge not completed yet.",
        v -> {}
);
TextView achievementTitle = new TextView(this);
achievementTitle.setText("🏆 Achievements");
achievementTitle.setTextSize(22);
achievementTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
achievementTitle.setTextColor(darkText);
achievementTitle.setPadding(0, 20, 0, 10);
content.addView(achievementTitle);

addCard(
        totalPoints >= 5 ? "✅ First Step" : "🔒 First Step",
        totalPoints >= 5
                ? "You earned your first points!"
                : "Earn 5 points to unlock this achievement.",
        v -> {}
);

addCard(
        learnedVerses >= 5 ? "✅ Bible Learner" : "🔒 Bible Learner",
        learnedVerses >= 5
                ? "You have learned 5 Bible verses!"
                : "Learn 5 Bible verses to unlock this achievement.",
        v -> {}
);

addCard(
        dailyStreak >= 3 ? "✅ Streak Keeper" : "🔒 Streak Keeper",
        dailyStreak >= 3
                ? "You reached a 3-day streak!"
                : "Reach a 3-day streak to unlock this achievement.",
        v -> {}
);

addCard(
        totalPoints >= 50 ? "✅ Point Builder" : "🔒 Point Builder",
        totalPoints >= 50
                ? "You reached 50 points!"
                : "Earn 50 points to unlock this achievement.",
        v -> {}
);

addCard(
        challengeCompletedToday ? "✅ Challenge Complete" : "🔒 Challenge Complete",
        challengeCompletedToday
                ? "You completed today's challenge!"
                : "Complete today's challenge to unlock this achievement.",
        v -> {}
);
addCard(
        correctAnswers > 0
                ? "✅ Quiz Starter"
                : "🔒 Quiz Starter",
        correctAnswers > 0
                ? "You answered a Bible Quiz question correctly!"
                : "Answer a Bible Quiz question correctly to unlock this achievement.",
        v -> {}
);
      addCard(
        scrambleScore > 0
                ? "✅ Puzzle Solver"
                : "🔒 Puzzle Solver",
        scrambleScore > 0
                ? "You earned points from a Bible puzzle!"
                : "Earn points from a Bible puzzle to unlock this achievement.",
        v -> {}
);
      addCard(
        totalPoints >= 5
                ? "✅ Word Finder"
                : "🔒 Word Finder",
        totalPoints >= 5
                ? "You earned points from Missing Word!"
                : "Answer a Missing Word question correctly to unlock this achievement.",
        v -> {}
);
      addCard(
        learnedVerses >= 10
                ? "✅ Memory Master"
                : "🔒 Memory Master",
        learnedVerses >= 10
                ? "You have learned 10 Bible verses!"
                : "Learn 10 Bible verses to unlock this achievement.",
        v -> {}
);
      addCard(
        dailyStreak >= 7
                ? "✅ Streak Champion"
                : "🔒 Streak Champion",
        dailyStreak >= 7
                ? "You reached a 7-day streak!"
                : "Reach a 7-day streak to unlock this achievement.",
        v -> {}
);
      addCard(
        totalPoints >= 100
                ? "✅ 100 Point Milestone"
                : "🔒 100 Point Milestone",
        totalPoints >= 100
                ? "You reached 100 total points!"
                : "Earn 100 points to unlock this achievement.",
        v -> {}
);
addButton("⬅️ Back to Home", v -> showHome());
  }
    void showSettings() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("⚙️ Settings");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    
    addCard(
            "🔊 Button Sounds",
            "Control sounds when buttons are pressed.",
            v -> showMessage(
                    "🔊 Button Sounds",
                    "Button sound controls will be available here."
            )
    );

    addCard(
            "🌅 Day & Night Background",
            "Kingdom Life automatically changes the home background based on the time.",
            v -> showMessage(
                    "🌅 Day & Night",
                    "Day background: 6:00 AM – 5:59 PM\n" +
                    "Night background: 6:00 PM – 5:59 AM"
            )
    );

    addCard(
            "📊 Progress",
            "View your points, streaks, and learning progress.",
            v -> showProgress()
    );

    addCard(
            "🏆 Achievements",
            "View your unlocked and locked achievements.",
            v -> showAchievements()
    );
        addCard(
        "🔔 Notifications",
        "Manage reminders for your Kingdom Life activities.",
        v -> showNotificationSettings()
);

    addButton("⬅️ Back to Home", v -> showHome());
    }
    void showNotificationSettings() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔔 Notifications");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            "🎯 Daily Challenge Reminder",
            "Get a daily reminder to complete your challenge.",
            v -> {

                scheduleKingdomLifeNotification(
                        "daily",
                        18,
                        0
                );

                showMessage(
                        "🔔 Reminder Enabled",
                        "Daily Challenge reminder set for 6:00 PM."
                );
            }
    );

    addCard(
            "📖 Bible Reading Reminder",
            "Get a daily reminder to spend time reading the Bible.",
            v -> {

                scheduleKingdomLifeNotification(
                        "bible",
                        8,
                        0
                );

                showMessage(
                        "🔔 Reminder Enabled",
                        "Bible Reading reminder set for 8:00 AM."
                );
            }
    );

    addCard(
            "🧠 Memory Verse Reminder",
            "Get a daily reminder to practice your Memory Verse.",
            v -> {

                scheduleKingdomLifeNotification(
                        "memory",
                        20,
                        0
                );

                showMessage(
                        "🔔 Reminder Enabled",
                        "Memory Verse reminder set for 8:00 PM."
                );
            }
    );

    addButton(
            "🔕 Turn Off All Reminders",
            v -> {

                cancelKingdomLifeNotification("daily");
                cancelKingdomLifeNotification("bible");
                cancelKingdomLifeNotification("memory");

                showMessage(
                        "🔕 Reminders Disabled",
                        "All Kingdom Life reminders have been turned off."
                );
            }
    );

    addButton(
            "⬅️ Back to Settings",
            v -> showSettings()
    );
    }
    void scheduleKingdomLifeNotification(
        String type,
        int hour,
        int minute
) {

    AlarmManager alarmManager =
            (AlarmManager) getSystemService(
                    ALARM_SERVICE
            );

    if (alarmManager == null) {
        return;
    }

    Intent intent =
            new Intent(
                    this,
                    KingdomLifeNotificationReceiver.class
            );

    intent.putExtra(
            "notification_type",
            type
    );

    int requestCode;

    if ("daily".equals(type)) {
        requestCode = 1001;
    } else if ("bible".equals(type)) {
        requestCode = 1002;
    } else {
        requestCode = 1003;
    }

    PendingIntent pendingIntent =
            PendingIntent.getBroadcast(
                    this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT |
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                            ? PendingIntent.FLAG_IMMUTABLE
                            : 0)
            );

    java.util.Calendar calendar =
            java.util.Calendar.getInstance();

    calendar.set(
            java.util.Calendar.HOUR_OF_DAY,
            hour
    );

    calendar.set(
            java.util.Calendar.MINUTE,
            minute
    );

    calendar.set(
            java.util.Calendar.SECOND,
            0
    );

    if (calendar.getTimeInMillis()
            <= System.currentTimeMillis()) {

        calendar.add(
                java.util.Calendar.DAY_OF_YEAR,
                1
        );
    }

    alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.getTimeInMillis(),
            AlarmManager.INTERVAL_DAY,
            pendingIntent
    );
    }
    void cancelKingdomLifeNotification(
        String type
) {

    AlarmManager alarmManager =
            (AlarmManager) getSystemService(
                    ALARM_SERVICE
            );

    if (alarmManager == null) {
        return;
    }

    Intent intent =
            new Intent(
                    this,
                    KingdomLifeNotificationReceiver.class
            );

    int requestCode;

    if ("daily".equals(type)) {
        requestCode = 1001;
    } else if ("bible".equals(type)) {
        requestCode = 1002;
    } else {
        requestCode = 1003;
    }

    PendingIntent pendingIntent =
            PendingIntent.getBroadcast(
                    this,
                    requestCode,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT |
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                            ? PendingIntent.FLAG_IMMUTABLE
                            : 0)
            );

    alarmManager.cancel(pendingIntent);
    pendingIntent.cancel();
    }
    void showAchievements() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Achievements");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            totalPoints >= 5 ? "✅ First Step" : "🔒 First Step",
            totalPoints >= 5
                    ? "You earned your first points!"
                    : "Earn 5 points to unlock this achievement.",
            v -> {}
    );

    addCard(
            learnedVerses >= 5 ? "✅ Bible Learner" : "🔒 Bible Learner",
            learnedVerses >= 5
                    ? "You have learned 5 Bible verses!"
                    : "Learn 5 Bible verses to unlock this achievement.",
            v -> {}
    );

    addCard(
            dailyStreak >= 3 ? "✅ Streak Keeper" : "🔒 Streak Keeper",
            dailyStreak >= 3
                    ? "You reached a 3-day streak!"
                    : "Reach a 3-day streak to unlock this achievement.",
            v -> {}
    );

    addCard(
            totalPoints >= 50 ? "✅ Point Builder" : "🔒 Point Builder",
            totalPoints >= 50
                    ? "You reached 50 points!"
                    : "Earn 50 points to unlock this achievement.",
            v -> {}
    );

    addCard(
            challengeCompletedToday
                    ? "✅ Challenge Complete"
                    : "🔒 Challenge Complete",
            challengeCompletedToday
                    ? "You completed today's challenge!"
                    : "Complete today's challenge to unlock this achievement.",
            v -> {}
    );

    addButton("⬅️ Back to Progress", v -> showProgress());
    }
    void showAbout() {
        showMessage(
                "ℹ️ About Kingdom Life",
                "Kingdom Life is a Christian app designed to encourage Bible learning, " +
                        "prayer, reflection, daily challenges, and fun Bible activities.\n\n" +
                        "Version 2.2"
        );
    }
    void showGuessVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Guess the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which verse belongs to this reference?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView reference = new TextView(this);
    reference.setText("📖 Jeremiah 29:11 — KJV");
    reference.setTextSize(21);
    reference.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    reference.setTextColor(darkText);
    reference.setGravity(Gravity.CENTER);
    reference.setPadding(10, 15, 10, 20);
    content.addView(reference);

    String[] choices = {
            "For I know the thoughts that I think toward you, saith the LORD, thoughts of peace, and not of evil, to give you an expected end.",
            "The LORD is my shepherd; I shall not want.",
            "I can do all things through Christ which strengtheneth me.",
            "Trust in the LORD with all thine heart; and lean not unto thine own understanding."
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(15);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;
              prefs.edit()
        .putInt("totalPoints", totalPoints)
        .apply();
    feedback.setText("✅ Correct! Excellent memory!\n+10 points");
            } else {
                feedback.setText("❌ Not quite. Try to remember Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
       

    void showCompleteVerse() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("✍️ Complete the Verse");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Choose the missing words from Jeremiah 29:11.");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "📖 Jeremiah 29:11 — KJV\n\n" +
            "For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an ________ end."
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "expected",
            "peaceful",
            "wonderful",
            "joyful"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    feedback.setText("✅ Correct! The missing word is \"expected\".\n+10 points");
} else {
    feedback.setText("❌ Not quite. The correct answer is \"expected\".");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
    }
  void showGuessReference() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔄 Guess the Reference");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Which Bible reference contains this verse?");
    instruction.setTextSize(18);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    TextView verse = new TextView(this);
    verse.setText(
            "\"For I know the thoughts that I think toward you, saith the LORD, " +
            "thoughts of peace, and not of evil, to give you an expected end.\""
    );
    verse.setTextSize(18);
    verse.setTextColor(darkText);
    verse.setPadding(10, 15, 10, 20);
    content.addView(verse);

    String[] choices = {
            "Jeremiah 29:11",
            "Psalm 23:1",
            "John 3:16",
            "Philippians 4:13"
    };

    int correctAnswer = 0;

    TextView feedback = new TextView(this);
    feedback.setTextSize(18);
    feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    feedback.setTextColor(darkText);
    feedback.setPadding(0, 15, 0, 15);

    Button[] buttons = new Button[choices.length];

    for (int i = 0; i < choices.length; i++) {
        final int selected = i;

        buttons[i] = new Button(this);
        buttons[i].setText(choices[i]);
        buttons[i].setTextSize(17);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0, 6, 0, 6);
        content.addView(buttons[i], params);

        buttons[i].setOnClickListener(v -> {
            if (selected == correctAnswer) {
    totalPoints += 10;

    prefs.edit()
            .putInt("totalPoints", totalPoints)
            .apply();

    feedback.setText("✅ Correct! Jeremiah 29:11.\n+10 points");
} else {
    feedback.setText("❌ Not quite. The correct answer is Jeremiah 29:11.");
            }

            for (Button button : buttons) {
                button.setEnabled(false);
            }
        });
    }

    content.addView(feedback);

    addButton("⬅️ Back to Memory Verse", v -> showMemoryVerse());
                                  }
    void showGameMenu() {
        stopTimer();
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText("🎮 Bible Games");
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 20);

        content.addView(title);

        TextView instruction = new TextView(this);
        instruction.setText("Choose a difficulty level:");
        instruction.setTextSize(18);
        instruction.setTextColor(darkText);
        instruction.setPadding(0, 0, 0, 15);

        content.addView(instruction);
        

        addButton("🧠 Bible Challenge", v -> showBibleChallenge());
addButton("🧩 Bible Scramble", v -> showBibleScramble());
        addButton("🔤 Missing Word", v -> showMissingWord());
        addButton("📖 Bible Journey", v -> showBibleJourney());
        addButton("⬅️ Back to Home", v -> showHome());
    }
    void showBibleJourney() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 Bible Journey");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 10);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText("Swipe between the Old Testament and New Testament");
    instruction.setTextSize(17);
    instruction.setTextColor(darkText);
    instruction.setGravity(Gravity.CENTER);
    instruction.setPadding(0, 0, 0, 20);
    content.addView(instruction);

    addButton("📜 Old Testament", v -> showBibleJourneyOldTestament());

    addButton("✝️ New Testament", v -> showBibleJourneyNewTestament());

    addButton("⬅️ Back to Games", v -> showGameMenu());
    }
    void showBibleJourneyOldTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📜 Old Testament");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 20);
    content.addView(title);

    String[] books = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    for (int i = 0; i < books.length; i += 2) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, 5, 0, 5);

        String book1 = books[i];

        Button button1 = new Button(this);
        button1.setText(book1);
        button1.setTextSize(15);
        button1.setAllCaps(false);

        if (isBibleJourneyBookUnlocked(book1)) {
    button1.setOnClickListener(v -> showBookDifficulty(book1));
} else {
    button1.setText("🔒 " + book1);
    button1.setOnClickListener(v -> {});
        }
        row.addView(button1, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        if (i + 1 < books.length) {

            String book2 = books[i + 1];

            Button button2 = new Button(this);
            button2.setText(book2);
            button2.setTextSize(15);
            button2.setAllCaps(false);

            if (isBibleJourneyBookUnlocked(book2)) {
    button2.setOnClickListener(v -> showBookDifficulty(book2));
} else {
    button2.setText("🔒 " + book2);
    button2.setOnClickListener(v -> {});
            }
            row.addView(button2, new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            ));
        }

        content.addView(row);
    }

    addButton("✝️ New Testament →", v -> showBibleJourneyNewTestament());
    addButton("⬅️ Back to Bible Journey", v -> showBibleJourney());
    }
    void showBibleJourneyNewTestament() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("✝️ New Testament");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 20);
    content.addView(title);

    String[] books = {
            "Matthew", "Mark",
            "Luke", "John",
            "Acts", "Romans",
            "1 Corinthians", "2 Corinthians",
            "Galatians", "Ephesians",
            "Philippians", "Colossians",
            "1 Thessalonians", "2 Thessalonians",
            "1 Timothy", "2 Timothy",
            "Titus", "Philemon",
            "Hebrews", "James",
            "1 Peter", "2 Peter",
            "1 John", "2 John",
            "3 John", "Jude",
            "Revelation"
    };

    for (int i = 0; i < books.length; i += 2) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, 5, 0, 5);

        String book1 = books[i];

        Button button1 = new Button(this);
        button1.setText(book1);
        button1.setTextSize(15);
        button1.setAllCaps(false);

        button1.setOnClickListener(v -> showBookDifficulty(book1));

        row.addView(button1, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        if (i + 1 < books.length) {

            String book2 = books[i + 1];

            Button button2 = new Button(this);
            button2.setText(book2);
            button2.setTextSize(15);
            button2.setAllCaps(false);

            button2.setOnClickListener(v -> showBookDifficulty(book2));

            row.addView(button2, new LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            ));
        }

        content.addView(row);
    }

    addButton("← Old Testament", v -> showBibleJourneyOldTestament());
    addButton("⬅️ Back to Bible Journey", v -> showBibleJourney());
    }
    boolean isBibleJourneyDifficultyUnlocked(
        String book,
        String difficulty
) {
    if (difficulty.equals("Easy")) {
        return true;
    }

    String key =
            "bibleJourney_" +
            book +
            "_" +
            difficulty +
            "_unlocked";

    return prefs.getBoolean(key, false);
}

void unlockBibleJourneyDifficulty(
        String book,
        String difficulty
) {
    String key =
            "bibleJourney_" +
            book +
            "_" +
            difficulty +
            "_unlocked";

    prefs.edit()
            .putBoolean(key, true)
            .apply();
}
    boolean isBibleJourneyBookUnlocked(String book) {
    if (book.equals("Genesis")) {
        return true;
    }

    String[] oldTestamentBooks = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    return prefs.getBoolean(
            "bibleJourney_" + book + "_book_unlocked",
            false
    );
    }
    void showBookDifficulty(String book) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("📖 " + book);
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 20, 0, 10);
    content.addView(title);

    TextView info = new TextView(this);
    info.setText("Choose your difficulty");
    info.setTextSize(18);
    info.setTextColor(darkText);
    info.setGravity(Gravity.CENTER);
    info.setPadding(0, 0, 0, 20);
    content.addView(info);

    if (isBibleJourneyDifficultyUnlocked(book, "Easy")) {
    addButton(
            "🟢 Easy",
            v -> startBibleJourney(book, "Easy")
    );
} else {
    addButton("🔒 Easy", v -> {});
}

if (isBibleJourneyDifficultyUnlocked(book, "Medium")) {
    addButton(
            "🔵 Medium",
            v -> startBibleJourney(book, "Medium")
    );
} else {
    addButton("🔒 Medium", v -> {});
}

if (isBibleJourneyDifficultyUnlocked(book, "Hard")) {
    addButton(
            "🟠 Hard",
            v -> startBibleJourney(book, "Hard")
    );
} else {
    addButton("🔒 Hard", v -> {});
}

if (isBibleJourneyDifficultyUnlocked(book, "Scholar")) {
    addButton(
            "🟣 Scholar",
            v -> startBibleJourney(book, "Scholar")
    );
} else {
    addButton("🔒 Scholar", v -> {});
}
    addButton("⬅️ Back", v -> {
    if (book.equals("Genesis")) {
        showBibleJourneyOldTestament();
    } else if (book.equals("Revelation")) {
        showBibleJourneyNewTestament();
    } else {
        showBibleJourney();
    }
});
    }
    void startBibleJourney(String book, String difficulty) {
    stopTimer();

    currentBibleBook = book;
    currentBibleDifficulty = difficulty;

    bibleJourneyQuestion = 0;
    bibleJourneyScore = 0;

    if (book.equals("Genesis")) {
        loadGenesisQuestions(difficulty);
    }else {
    bibleJourneyQuestions.clear();
    bibleJourneyOptions.clear();
    bibleJourneyAnswers.clear();

    ArrayList<BibleJourneyData.Question> questions =
            BibleJourneyData.getQuestions(book, difficulty);

    for (BibleJourneyData.Question q : questions) {
        bibleJourneyQuestions.add(q.question);
        bibleJourneyOptions.add(q.options);
        bibleJourneyAnswers.add(q.answer);
    }

    if (questions.isEmpty()) {
        bibleJourneyQuestions.add(
                "Questions for " + book +
                " (" + difficulty + ") are coming soon."
        );

        bibleJourneyOptions.add(new String[]{
                "Continue",
                "Back",
                "Bible Journey",
                "Home"
        });

        bibleJourneyAnswers.add(0);
    }
    }
    showBibleJourneyQuestion();
    }
    void showBibleJourneyQuestion() {
    content.removeAllViews();

    if (bibleJourneyQuestions.isEmpty()) {
        TextView empty = new TextView(this);
        empty.setText("No questions available.");
        empty.setTextSize(20);
        empty.setTextColor(darkText);
        content.addView(empty);

        addButton("⬅️ Back", v -> showBookDifficulty(
                currentBibleBook
        ));
        return;
    }

    TextView title = new TextView(this);
    title.setText("📖 " + currentBibleBook);
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView difficulty = new TextView(this);
    difficulty.setText(
            "Difficulty: " + currentBibleDifficulty
    );
    difficulty.setTextSize(17);
    difficulty.setTextColor(darkText);
    difficulty.setGravity(Gravity.CENTER);
    difficulty.setPadding(0, 0, 0, 15);
    content.addView(difficulty);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " +
            (bibleJourneyQuestion + 1) +
            " of " +
            bibleJourneyQuestions.size()
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setGravity(Gravity.CENTER);
    progress.setPadding(0, 0, 0, 20);
    content.addView(progress);

    TextView question = new TextView(this);
    question.setText(
            bibleJourneyQuestions.get(bibleJourneyQuestion)
    );
    question.setTextSize(21);
    question.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    question.setTextColor(darkText);
    question.setGravity(Gravity.CENTER);
    question.setPadding(10, 15, 10, 25);
    content.addView(question);

    String[] options =
            bibleJourneyOptions.get(bibleJourneyQuestion);

    for (int i = 0; i < options.length; i++) {

        final int selectedAnswer = i;

        addButton(
                (i + 1) + ". " + options[i],
                v -> checkBibleJourneyAnswer(selectedAnswer)
        );
    }

    addButton(
            "⬅️ Exit Game",
            v -> showBookDifficulty(currentBibleBook)
    );
        }
    void checkBibleJourneyAnswer(int selectedAnswer) {

    int correctAnswer =
            bibleJourneyAnswers.get(bibleJourneyQuestion);

    if (selectedAnswer == correctAnswer) {

        bibleJourneyScore += 5;
        totalPoints += 5;

        prefs.edit()
                .putInt("totalPoints", totalPoints)
                .apply();

        TextView feedback = new TextView(this);
        feedback.setText("🎉 Correct! +5 points");
        feedback.setTextSize(20);
        feedback.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);

        content.addView(feedback, 5);

    } else {

        TextView feedback = new TextView(this);
        feedback.setText(
                "❌ Incorrect!\n\n" +
                "The correct answer was:\n" +
                bibleJourneyOptions
                        .get(bibleJourneyQuestion)
                        [correctAnswer]
        );
        feedback.setTextSize(19);
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);

        content.addView(feedback, 5);
    }

    addButton("➡️ Next Question", v -> {

        if (bibleJourneyQuestion <
                bibleJourneyQuestions.size() - 1) {

            bibleJourneyQuestion++;
            showBibleJourneyQuestion();

        } else {

            showBibleJourneyResult();
        }
    });
    }
    void showBibleJourneyResult() {

    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Bible Journey Complete!");
    title.setTextSize(26);
    title.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    content.addView(title);

    TextView book = new TextView(this);
    book.setText(
            "📖 " + currentBibleBook +
            "\nDifficulty: " +
            currentBibleDifficulty
    );
    book.setTextSize(18);
    book.setTextColor(darkText);
    book.setGravity(Gravity.CENTER);
    book.setPadding(0, 0, 0, 20);
    content.addView(book);
        
if (currentBibleDifficulty.equals("Easy")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Medium"
    );

} else if (currentBibleDifficulty.equals("Medium")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Hard"
    );

} else if (currentBibleDifficulty.equals("Hard")) {

    unlockBibleJourneyDifficulty(
            currentBibleBook,
            "Scholar"
    );
    } else if (currentBibleDifficulty.equals("Scholar")) {

    String[] oldTestamentBooks = {
            "Genesis", "Exodus",
            "Leviticus", "Numbers",
            "Deuteronomy", "Joshua",
            "Judges", "Ruth",
            "1 Samuel", "2 Samuel",
            "1 Kings", "2 Kings",
            "1 Chronicles", "2 Chronicles",
            "Ezra", "Nehemiah",
            "Esther", "Job",
            "Psalms", "Proverbs",
            "Ecclesiastes", "Song of Solomon",
            "Isaiah", "Jeremiah",
            "Lamentations", "Ezekiel",
            "Daniel", "Hosea",
            "Joel", "Amos",
            "Obadiah", "Jonah",
            "Micah", "Nahum",
            "Habakkuk", "Zephaniah",
            "Haggai", "Zechariah",
            "Malachi"
    };

    for (int i = 0; i < oldTestamentBooks.length - 1; i++) {

        if (currentBibleBook.equals(oldTestamentBooks[i])) {

            String nextBook = oldTestamentBooks[i + 1];

            prefs.edit()
                    .putBoolean(
                            "bibleJourney_" + nextBook + "_book_unlocked",
                            true
                    )
                    .apply();

            break;
        }
    }
}
    TextView scoreText = new TextView(this);
    scoreText.setText(
            "⭐ Score: " +
            bibleJourneyScore
    );
    scoreText.setTextSize(23);
    scoreText.setTypeface(
            Typeface.DEFAULT,
            Typeface.BOLD
    );
    scoreText.setTextColor(darkText);
    scoreText.setGravity(Gravity.CENTER);
    scoreText.setPadding(0, 10, 0, 25);
    content.addView(scoreText);

    addButton(
            "🔄 Play Again",
            v -> startBibleJourney(
                    currentBibleBook,
                    currentBibleDifficulty
            )
    );

    addButton(
            "📖 Choose Another Book",
            v -> showBibleJourney()
    );

    addButton(
            "⬅️ Back to Games",
            v -> showGameMenu()
    );
    }

    void startGame(int milliseconds) {
        stopTimer();

        timeLimit = milliseconds;
       currentQuestion = 0;
score = 0;
correctAnswers = 0;
wrongAnswers = 0; 

        showQuestion();
    }

    void showQuestion() {
        stopTimer();
        content.removeAllViews();

        answered = false;
        int questionCount;

if (currentLevel == 2) {
    questionCount = level2Questions.length;
} else if (currentLevel == 3) {
    questionCount = level3Questions.length;
} else {
    questionCount = questions.length;
}
TextView levelText = new TextView(this);
levelText.setText("🏆 Level " + currentLevel);
levelText.setTextSize(20);
levelText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
levelText.setTextColor(darkText);
levelText.setPadding(0, 10, 0, 5);

content.addView(levelText);
        TextView progress = new TextView(this);
        progress.setText("Question " + (currentQuestion + 1) + " of " + questionCount);
        progress.setTextSize(18);
        progress.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        progress.setTextColor(darkText);
        progress.setPadding(0, 10, 0, 10);

        content.addView(progress);

        TextView timerText = new TextView(this);
        timerText.setTextSize(18);
        timerText.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        timerText.setTextColor(darkText);
        timerText.setGravity(Gravity.CENTER);
        timerText.setPadding(0, 5, 0, 15);

        content.addView(timerText);

        TextView question = new TextView(this);
        if (currentLevel == 2) {
    question.setText(level2Questions[currentQuestion]);
} else if (currentLevel == 3) {
    question.setText(level3Questions[currentQuestion]);
} else {
    question.setText(questions[currentQuestion]);
        }
        question.setTextSize(22);
        question.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        question.setTextColor(darkText);
        question.setPadding(0, 10, 0, 20);

        content.addView(question);

        Button[] answerButtons = new Button[4];

        for (int i = 0; i < 4; i++) {
            final int selected = i;

            answerButtons[i] = new Button(this);
            if (currentLevel == 2) {
    answerButtons[i].setText(level2Options[currentQuestion][i]);
} else if (currentLevel == 3) {
    answerButtons[i].setText(level3Options[currentQuestion][i]);
} else {
    answerButtons[i].setText(options[currentQuestion][i]);
            }
            answerButtons[i].setTextSize(17);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(0, 5, 0, 5);

            content.addView(answerButtons[i], params);

            answerButtons[i].setOnClickListener(v ->
                    answerQuestion(selected, answerButtons)
            );
        }

        TextView result = new TextView(this);
        result.setTextSize(18);
        result.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        result.setPadding(0, 15, 0, 10);
        content.addView(result);

        LinearLayout navigation = new LinearLayout(this);
        navigation.setOrientation(LinearLayout.HORIZONTAL);

        Button previous = new Button(this);
        previous.setText("← Previous");
        previous.setTextSize(15);
        previous.setEnabled(currentQuestion > 0);

        Button next = new Button(this);
        next.setText(currentQuestion == questionCount - 1
        ? "Finish →"
        : "Next →");
        next.setTextSize(15);

        navigation.addView(previous, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        navigation.addView(next, new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        content.addView(navigation);

        previous.setOnClickListener(v -> {
            if (currentQuestion > 0) {
                currentQuestion--;
                showQuestion();
            }
        });

        next.setOnClickListener(v -> {
            if (currentQuestion < questionCount - 1) {
    currentQuestion++;
    showQuestion();
} else {
    showResults();
            }
        });

        timer = new CountDownTimer(timeLimit, 1000) {

            public void onTick(long millisUntilFinished) {
                timerText.setText("⏱️ Time: "
                        + ((millisUntilFinished + 999) / 1000)
                        + " seconds");
            }

            public void onFinish() {
                if (!answered) {
                    answered = true;
                    wrongAnswers++;
                    String correctOption;

if (currentLevel == 2) {
    correctOption = level2Options[currentQuestion][level2Answers[currentQuestion]];
} else if (currentLevel == 3) {
    correctOption = level3Options[currentQuestion][level3Answers[currentQuestion]];
} else {
    correctOption = options[currentQuestion][answers[currentQuestion]];
}

result.setText("⏰ Time's up! The correct answer is: " + correctOption);

                    for (Button button : answerButtons) {
                        button.setEnabled(false);
                    }
                }
            }
        }.start();
    }

    void answerQuestion(int selected, Button[] buttons) {
        if (answered) {
            return;
        }

        answered = true;
        stopTimer();

        TextView feedback = new TextView(this);
        feedback.setTextSize(18);

        int correctAnswer;

if (currentLevel == 2) {
    correctAnswer = level2Answers[currentQuestion];
} else if (currentLevel == 3) {
    correctAnswer = level3Answers[currentQuestion];
} else {
    correctAnswer = answers[currentQuestion];
}

if (selected == correctAnswer) {
    score += 10;
    totalPoints += 10;
    correctAnswers++;
          prefs.edit()
        .putInt("totalPoints", totalPoints)
        .apply();
            feedback.setText("✅ Correct! +10 points");
        } else {
            wrongAnswers++;
            String correctOption;

if (currentLevel == 2) {
    correctOption = level2Options[currentQuestion][level2Answers[currentQuestion]];
} else if (currentLevel == 3) {
    correctOption = level3Options[currentQuestion][level3Answers[currentQuestion]];
} else {
    correctOption = options[currentQuestion][answers[currentQuestion]];
}

feedback.setText("❌ Wrong! Correct answer: " + correctOption);
        }

        feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        feedback.setTextColor(darkText);

        content.addView(feedback, 3);

        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    void showResults() {
        stopTimer();
        content.removeAllViews();
        if (currentLevel == highestLevelUnlocked && highestLevelUnlocked < 3) {
    highestLevelUnlocked++;

    prefs.edit()
            .putInt("highestLevelUnlocked", highestLevelUnlocked)
            .apply();
        }

        TextView title = new TextView(this);
        title.setText("🏆 Game Complete!");
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 20, 0, 20);

        content.addView(title);

        TextView results = new TextView(this);
        results.setText(
                "Score: " + score + "\n\n" +
                        "✅ Correct: " + correctAnswers + "\n" +
                        "❌ Wrong: " + wrongAnswers + "\n\n" +
                        "Great job! Keep learning God's Word."
        );
        results.setTextSize(20);
        results.setTextColor(darkText);
        results.setGravity(Gravity.CENTER);
        results.setPadding(0, 10, 0, 25);

        content.addView(results);

        addButton("🔄 Play Again", v -> startGame(timeLimit));

        addButton("⬅️ Back to Games", v -> showGameMenu());

        addButton("🏠 Back to Home", v -> showHome());
    }
    void showBibleChallenge() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🧠 Bible Challenge");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView description = new TextView(this);
    description.setText("Test your Bible knowledge against the clock!");
    description.setTextSize(17);
    description.setTextColor(darkText);
    description.setPadding(0, 0, 0, 20);
    content.addView(description);
        addButton("🟢 Level 1 — Easy", v -> {
    currentLevel = 1;
    startGame(30000);
});

        if (highestLevelUnlocked >= 2) {
    addButton("🟡 Level 2 — Medium", v -> {
        currentLevel = 2;
        startGame(20000);
    });
} else {
    addButton("🔒 Level 2 — Locked", v -> {});
                  }

        if (highestLevelUnlocked >= 3) {
    addButton("🔴 Level 3 — Hard", v -> {
        currentLevel = 3;
        startGame(10000);
    });
} else {
    addButton("🔒 Level 3 — Locked", v -> {});
        }
        addButton("⬅️ Back", v -> showGameMenu());
    }
void showBibleScramble() {
    stopTimer();
    content.removeAllViews();

    scrambleQuestion = 0;
    scrambleScore = 0;

    showScrambleQuestion();
}
    void showScrambleQuestion() {
    content.removeAllViews();

    String word = scrambleWords[scrambleQuestion];

    TextView title = new TextView(this);
    title.setText("🧩 Bible Scramble");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " + (scrambleQuestion + 1) + " of 25"
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setPadding(0, 0, 0, 15);
    content.addView(progress);

    TextView scrambled = new TextView(this);
    scrambled.setText("Unscramble: " + scrambleWord(word));
    scrambled.setTextSize(26);
    scrambled.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    scrambled.setTextColor(darkText);
    scrambled.setGravity(Gravity.CENTER);
    scrambled.setPadding(0, 20, 0, 25);
    content.addView(scrambled);
EditText answerInput = new EditText(this);
answerInput.setHint("Type your answer here");
answerInput.setTextSize(18);
answerInput.setSingleLine(true);
content.addView(answerInput);
    addButton("✅ Submit Answer", v -> {
    String userAnswer = answerInput.getText().toString().trim();

    if (userAnswer.equalsIgnoreCase(word)) {
        scrambleScore += 5;
        totalPoints += 5;

        prefs.edit()
                .putInt("totalPoints", totalPoints)
                .apply();

        TextView feedback = new TextView(this);
        feedback.setText("🎉 Correct! +5 points");
        feedback.setTextSize(20);
        feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);
        content.addView(feedback, 3);

        answerInput.setEnabled(false);
        addButton("➡️ Next Question", nextView -> {
    if (scrambleQuestion < scrambleWords.length - 1) {
        scrambleQuestion++;
        showScrambleQuestion();
    } else {
        showScrambleFinalResult();
    }
});
    } else {
        TextView feedback = new TextView(this);
        feedback.setText("❌ Not quite. Try again!");
        feedback.setTextSize(18);
        feedback.setTextColor(darkText);
        feedback.setGravity(Gravity.CENTER);
        feedback.setPadding(0, 15, 0, 15);
        content.addView(feedback, 3);
    }
});

    addButton("➡️ Skip", v -> {
        if (scrambleQuestion < scrambleWords.length - 1) {
            scrambleQuestion++;
            showScrambleQuestion();
        } else {
            showScrambleFinalResult();
        }
    });

    addButton("⬅️ Back to Games", v -> showGameMenu());
    }
    String scrambleWord(String word) {
    char[] letters = word.toCharArray();

    for (int i = letters.length - 1; i > 0; i--) {
        int j = (int) (Math.random() * (i + 1));

        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }

    return new String(letters);
    }
    void showScrambleFinalResult() {
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🏆 Scramble Complete!");
    title.setTextSize(26);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setGravity(Gravity.CENTER);
    title.setPadding(0, 25, 0, 20);
    content.addView(title);

    TextView result = new TextView(this);
    result.setText(
            "You completed all 25 questions!\n\n" +
            "🧩 Scramble Score: " + scrambleScore + "\n" +
            "⭐ Total Points: " + totalPoints
    );
    result.setTextSize(20);
    result.setTextColor(darkText);
    result.setGravity(Gravity.CENTER);
    result.setPadding(0, 10, 0, 30);
    content.addView(result);

    addButton("🔄 Play Again", v -> showBibleScramble());
    addButton("⬅️ Back to Games", v -> showGameMenu());
    addButton("🏠 Back to Home", v -> showHome());
    }
    
    void addButton(String text, View.OnClickListener listener) {
    Button button = new Button(this);

    button.setText(text);
    button.setTextSize(17);
    button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    button.setTextColor(darkText);
    button.setAllCaps(false);
    button.setPadding(24, 16, 24, 16);

    // Rounded button background
    GradientDrawable buttonBackground = new GradientDrawable();
    buttonBackground.setColor(Color.argb(225, 255, 255, 255));
    buttonBackground.setCornerRadius(32);
    button.setBackground(buttonBackground);

    // Subtle depth
    button.setElevation(5);

    button.setOnClickListener(listener);

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );

    params.setMargins(12, 8, 12, 8);

    content.addView(button, params);
    }
    void addFeatureGrid() {

    LinearLayout grid = new LinearLayout(this);
    grid.setOrientation(LinearLayout.VERTICAL);

    LinearLayout row1 = new LinearLayout(this);
    row1.setOrientation(LinearLayout.HORIZONTAL);

    LinearLayout row2 = new LinearLayout(this);
    row2.setOrientation(LinearLayout.HORIZONTAL);

    LinearLayout row3 = new LinearLayout(this);
    row3.setOrientation(LinearLayout.HORIZONTAL);

    String[] titles = {
            "🎮 Bible Quiz",
            "🧠 Memory Verse",
            "🧩 Bible Puzzles",
            "🎯 Daily Challenge",
            "📈 Progress",
            "🏆 Achievements"
    };

    View.OnClickListener[] actions = {
            v -> showGameMenu(),
            v -> showMemoryVerse(),
            v -> showGameMenu(),
            v -> showMessage("🎯 Daily Challenge",
                    "Complete today's challenge to earn points and build your streak."),
            v -> showProgress(),
            v -> showProgress()
    };

    for (int i = 0; i < titles.length; i++) {

        Button button = new Button(this);
        button.setText(titles[i]);
        button.setTextSize(14);
        button.setAllCaps(false);
        button.setOnClickListener(actions[i]);
        button.setTextColor(Color.WHITE);
button.setGravity(Gravity.CENTER);

GradientDrawable buttonBackground = new GradientDrawable();
buttonBackground.setColor(Color.argb(220, 0, 0, 0));
buttonBackground.setCornerRadius(24);

button.setBackground(buttonBackground);
button.setElevation(4);

        LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
                0,
                110,
                1
        );

        params.setMargins(6, 6, 6, 6);

        if (i < 2) {
            row1.addView(button, params);
        } else if (i < 4) {
            row2.addView(button, params);
        } else {
            row3.addView(button, params);
        }
    }

    grid.addView(row1);
    grid.addView(row2);
    grid.addView(row3);

    content.addView(grid);
    }
    void showMessage(String heading, String message) {
        content.removeAllViews();

        TextView title = new TextView(this);
        title.setText(heading);
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(darkText);
        title.setPadding(0, 15, 0, 15);

        content.addView(title);

        TextView text = new TextView(this);
        text.setText(message);
        text.setTextSize(18);
        text.setTextColor(darkText);
        text.setPadding(0, 10, 0, 25);

        content.addView(text);

        addButton("⬅️ Back to Home", v -> showHome());
    }

    void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onDestroy() {
        stopTimer();
        super.onDestroy();
    }
    
    void showMissingWord() {
    stopTimer();
    content.removeAllViews();

    final String[][] questions = {
            {"Trust in the Lord with all your ___",
             "heart", "mind", "strength", "soul", "Proverbs 3:5"},

            {"I can do all things through Christ which ___ me",
             "strengtheneth", "guideth", "teacheth", "keepeth", "Philippians 4:13"},

            {"The Lord is my ___; I shall not want",
             "shepherd", "refuge", "strength", "rock", "Psalm 23:1"},

            {"Be strong and of a good ___",
             "courage", "faith", "hope", "heart", "Joshua 1:9"},

            {"And we know that all things work together for ___",
             "good", "peace", "love", "wisdom", "Romans 8:28"},

            {"Thy word is a ___ unto my feet",
             "lamp", "light", "guide", "shield", "Psalm 119:105"},

            {"Fear thou not; for I am with ___",
             "thee", "you", "him", "them", "Isaiah 41:10"},

            {"But seek ye first the kingdom of ___",
             "God", "heaven", "Christ", "glory", "Matthew 6:33"},

            {"If any of you lack ___, let him ask of God",
             "wisdom", "faith", "strength", "knowledge", "James 1:5"},

            {"Let all your things be done with ___",
             "charity", "faith", "joy", "peace", "1 Corinthians 16:14"},

            {"The joy of the Lord is your ___",
             "strength", "peace", "refuge", "salvation", "Nehemiah 8:10"},

            {"God is our refuge and ___",
             "strength", "shield", "rock", "helper", "Psalm 46:1"},

            {"The fear of the Lord is the beginning of ___",
             "wisdom", "knowledge", "understanding", "faith", "Proverbs 9:10"},

            {"Create in me a clean ___, O God",
             "heart", "spirit", "mind", "soul", "Psalm 51:10"},

            {"This is the day which the Lord hath ___",
             "made", "given", "blessed", "chosen", "Psalm 118:24"},

            {"Cast thy burden upon the Lord, and he shall ___ thee",
             "sustain", "strengthen", "guide", "comfort", "Psalm 55:22"},

            {"The Lord is good, a strong hold in the day of ___",
             "trouble", "battle", "sorrow", "fear", "Nahum 1:7"},

            {"Walk by ___, not by sight",
             "faith", "hope", "love", "wisdom", "2 Corinthians 5:7"},

            {"Rejoice in the Lord ___",
             "alway", "always", "daily", "forever", "Philippians 4:4"},

            {"Pray without ___",
             "ceasing", "stopping", "fear", "doubt", "1 Thessalonians 5:17"},

            {"Let your light so ___ before men",
             "shine", "glow", "stand", "rise", "Matthew 5:16"},

            {"Blessed are the ___ in heart",
             "pure", "humble", "meek", "faithful", "Matthew 5:8"},

            {"The Lord is my light and my ___",
             "salvation", "strength", "refuge", "shield", "Psalm 27:1"},

            {"Wait on the Lord: be of good ___",
             "courage", "hope", "faith", "cheer", "Psalm 27:14"},

            {"Whatsoever ye do, do it ___",
             "heartily", "faithfully", "quickly", "joyfully", "Colossians 3:23"}
    };

    showMissingWordQuestion(questions, 0);
}

void showMissingWordQuestion(String[][] questions, int questionIndex) {
    content.removeAllViews();

    String[] q = questions[questionIndex];
    final boolean[] answered = {false};

    TextView title = new TextView(this);
    title.setText("🔤 Missing Word");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 15);
    content.addView(title);

    TextView progress = new TextView(this);
    progress.setText(
            "Question " + (questionIndex + 1) + " of " + questions.length
    );
    progress.setTextSize(18);
    progress.setTextColor(darkText);
    progress.setPadding(0, 0, 0, 15);
    content.addView(progress);

    TextView reference = new TextView(this);
    reference.setText("📖 " + q[5]);
    reference.setTextSize(16);
    reference.setTextColor(darkText);
    reference.setGravity(Gravity.CENTER);
    reference.setPadding(0, 0, 0, 15);
    content.addView(reference);

    TextView verse = new TextView(this);
    verse.setText(q[0]);
    verse.setTextSize(21);
    verse.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    verse.setTextColor(darkText);
    verse.setGravity(Gravity.CENTER);
    verse.setPadding(0, 15, 0, 25);
    content.addView(verse);

    Button[] answerButtons = new Button[4];

    for (int i = 0; i < 4; i++) {
        final int selected = i;

        answerButtons[i] = new Button(this);
        answerButtons[i].setText(
                (char)('A' + i) + ". " + q[i + 1]
        );
        answerButtons[i].setTextSize(17);
        answerButtons[i].setAllCaps(false);

        content.addView(answerButtons[i]);

        answerButtons[i].setOnClickListener(v -> {
            if (answered[0]) {
                return;
            }

            answered[0] = true;

            for (Button button : answerButtons) {
                button.setEnabled(false);
            }

            TextView feedback = new TextView(this);
            feedback.setTextSize(19);
            feedback.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            feedback.setTextColor(darkText);
            feedback.setGravity(Gravity.CENTER);
            feedback.setPadding(0, 15, 0, 15);

            if (selected == 0) {
                totalPoints += 5;

                prefs.edit()
                        .putInt("totalPoints", totalPoints)
                        .apply();

                feedback.setText(
                        "🎉 Correct! +5 points\n\n" +
                        "⭐ Total Points: " + totalPoints
                );
            } else {
                feedback.setText(
                        "❌ Not quite.\n\n" +
                        "The correct answer is: " + q[1]
                );
            }

            content.addView(feedback);

            if (questionIndex < questions.length - 1) {
                addButton(
                        "➡️ Next Question",
                        nextView -> showMissingWordQuestion(
                                questions,
                                questionIndex + 1
                        )
                );
            } else {
                addButton(
                        "🏆 Finish",
                        finishView -> showMessage(
                                "🏆 Missing Word Complete!",
                                "You completed all 25 questions!\n\n" +
                                "⭐ Total Points: " + totalPoints
                        )
                );
            }
        });
    }

    addButton("⬅️ Back to Games", v -> showGameMenu());
            }
    void showHighlights() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🖍️ Highlights");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    if (highlightsPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No highlighted verses yet.\n\n" +
                "Highlight a verse from the Bible reader and it will appear here."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(10, 10, 10, 20);
        content.addView(message);

    } else {

        for (java.util.Map.Entry<String, ?> entry :
                highlightsPrefs.getAll().entrySet()) {

            String reference = entry.getKey();
            String savedHighlight =
                    entry.getValue().toString();

            String verseText = savedHighlight;

            try {
                String[] parts =
                        savedHighlight.split("\\|", 2);

                if (parts.length == 2) {
                    verseText = parts[1];
                }
            } catch (Exception ignored) {
            }

            addCard(
                    "🖍️ " + reference,
                    verseText,
                    v -> {}
            );
        }
    }

    addButton(
            "⬅️ Back to Notes & Highlights",
            v -> showNotesHighlights()
    );
    }
    void saveBookmark(String reference) {

    if (bookmarksPrefs == null) {
        return;
    }

    bookmarksPrefs.edit()
            .putString(reference, reference)
            .apply();

    showMessage(
            "🔖 Bookmark Saved",
            reference + " has been bookmarked."
    );
}

void removeBookmark(String reference) {

    if (bookmarksPrefs == null) {
        return;
    }

    bookmarksPrefs.edit()
            .remove(reference)
            .apply();

    showBookmarks();
}

void showBookmarks() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔖 Bible Bookmarks");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    if (bookmarksPrefs.getAll().isEmpty()) {

        TextView message = new TextView(this);
        message.setText(
                "No bookmarks saved yet.\n\n" +
                "Tap 🔖 beside a Bible verse to save your reading location."
        );
        message.setTextSize(18);
        message.setTextColor(darkText);
        message.setPadding(10, 10, 10, 20);
        content.addView(message);

    } else {

        for (java.util.Map.Entry<String, ?> entry :
                bookmarksPrefs.getAll().entrySet()) {

            String reference = entry.getKey();

            addCard(
                    "🔖 " + reference,
                    "Tap to return to this Bible location.",
                    v -> {

                        try {

                            int colonIndex =
                                    reference.lastIndexOf(":");

                            int spaceIndex =
                                    reference.lastIndexOf(" ");

                            if (colonIndex > spaceIndex &&
                                spaceIndex > 0) {

                                String book =
                                        reference.substring(
                                                0,
                                                spaceIndex
                                        );

                                int chapter =
                                        Integer.parseInt(
                                                reference.substring(
                                                        spaceIndex + 1,
                                                        colonIndex
                                                )
                                        );

                                showBibleChapter(
                                        book,
                                        chapter
                                );
                            }

                        } catch (Exception ignored) {
                        }
                    }
            );

            addButton(
                    "🗑️ Remove " + reference,
                    v -> removeBookmark(reference)
            );
        }
    }

    addButton(
            "⬅️ Back to More",
            v -> showMoreMenu()
    );
    }
    void showDailyChallenge() {
    stopTimer();
    content.removeAllViews();

    String today =
            new java.text.SimpleDateFormat(
                    "yyyy-MM-dd",
                    java.util.Locale.getDefault()
            ).format(new java.util.Date());

    boolean completedToday =
        today.equals(lastChallengeDate);

    int dayNumber =
            Math.abs(today.hashCode()) % 5;

    String challengeTitle;
    String challengeText;

    if (dayNumber == 0) {

        challengeTitle = "🙏 Prayer Challenge";
        challengeText =
                "Spend a few quiet minutes talking to God today.";

    } else if (dayNumber == 1) {

        challengeTitle = "❤️ Love Challenge";
        challengeText =
                "Show kindness and encouragement to someone today.";

    } else if (dayNumber == 2) {

        challengeTitle = "📖 Scripture Challenge";
        challengeText =
                "Read a Bible passage and think about one lesson from it.";

    } else if (dayNumber == 3) {

        challengeTitle = "🤝 Kindness Challenge";
        challengeText =
                "Do one helpful thing for someone without expecting anything in return.";

    } else {

        challengeTitle = "🌟 Gratitude Challenge";
        challengeText =
                "Think of three things you are thankful to God for today.";
    }

    TextView title = new TextView(this);
    title.setText("🎯 Daily Challenge");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    addCard(
            challengeTitle,
            challengeText,
            v -> {}
    );

    if (completedToday) {

        addCard(
                "✅ Completed",
                "Today's challenge is complete.\n\n" +
                "Come back tomorrow for another challenge!",
                v -> {}
        );

    } else {

        addButton(
                "✅ Complete Challenge",
                v -> completeDailyChallenge(today)
        );
    }

    addCard(
            "⭐ Points",
            totalPoints + " points earned so far.",
            v -> {}
    );

    addCard(
            "🔥 Daily Streak",
            dailyStreak + " day(s) streak.",
            v -> {}
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
        }
    void completeDailyChallenge(String today) {

    if (prefs == null) {
        return;
    }

    String lastDate =
            prefs.getString(
                    "lastChallengeDate",
                    ""
            );

    if (today.equals(lastDate)) {
        showDailyChallenge();
        return;
    }

    String yesterday =
            new java.text.SimpleDateFormat(
                    "yyyy-MM-dd",
                    java.util.Locale.getDefault()
            ).format(
                    new java.util.Date(
                            System.currentTimeMillis()
                                    - (24L * 60L * 60L * 1000L)
                    )
            );

    if (yesterday.equals(lastDate)) {
        dailyStreak++;
    } else {
        dailyStreak = 1;
    }

    totalPoints += 10;

    lastChallengeDate = today;
    challengeCompletedToday = true;

    prefs.edit()
            .putInt(
                    "dailyStreak",
                    dailyStreak
            )
            .putInt(
                    "totalPoints",
                    totalPoints
            )
            .putString(
                    "lastChallengeDate",
                    lastChallengeDate
            )
            .apply();

    showMessage(
            "🎉 Challenge Complete!",
            "+10 points earned!\n\n" +
            "🔥 Daily streak: " +
            dailyStreak +
            " day(s)"
    );

    showDailyChallenge();
    }
    void showExplore() {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Explore");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 10);
    content.addView(title);

    TextView instruction = new TextView(this);
    instruction.setText(
            "Search for a Kingdom Life feature."
    );
    instruction.setTextSize(17);
    instruction.setTextColor(darkText);
    instruction.setPadding(0, 0, 0, 15);
    content.addView(instruction);

    EditText searchInput = new EditText(this);
    searchInput.setHint("Search features...");
    searchInput.setTextSize(18);
    searchInput.setSingleLine(true);
    content.addView(searchInput);

    addButton(
            "🔎 Search",
            v -> {

                String query =
                        searchInput.getText()
                                .toString()
                                .trim()
                                .toLowerCase();

                if (query.isEmpty()) {

                    showMessage(
                            "🔎 Explore",
                            "Please type a feature to search for."
                    );

                    return;
                }

                showExploreResults(query);
            }
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
    }
    void showExploreResults(String query) {
    stopTimer();
    content.removeAllViews();

    TextView title = new TextView(this);
    title.setText("🔎 Explore Results");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
    title.setTextColor(darkText);
    title.setPadding(0, 15, 0, 20);
    content.addView(title);

    boolean found = false;

    if (query.contains("bible")) {
        addCard(
                "📖 Holy Bible",
                "Read the King James Version of the Bible.",
                v -> showBible()
        );
        found = true;
    }

    if (query.contains("memory") || query.contains("verse")) {
        addCard(
                "🧠 Memory Verse",
                "Practice and learn Bible verses.",
                v -> showMemoryVerse()
        );
        found = true;
    }

    if (query.contains("quiz") || query.contains("game")) {
        addCard(
                "🎮 Bible Games",
                "Test your Bible knowledge with different challenges.",
                v -> showGameMenu()
        );
        found = true;
    }

    if (query.contains("puzzle") || query.contains("scramble")) {
        addCard(
                "🧩 Bible Puzzle",
                "Try Bible puzzle challenges.",
                v -> showGameMenu()
        );
        found = true;
    }

    if (query.contains("dictionary")) {
        addCard(
                "📚 Bible Dictionary",
                "Search Bible words and their meanings.",
                v -> showBibleDictionary()
        );
        found = true;
    }

    if (query.contains("bookmark")) {
        addCard(
                "🔖 Bookmarks",
                "Return quickly to saved Bible locations.",
                v -> showBookmarks()
        );
        found = true;
    }

    if (query.contains("note") ||
            query.contains("highlight")) {

        addCard(
                "📝 Notes & Highlights",
                "View your saved notes and highlighted verses.",
                v -> showNotesHighlights()
        );
        found = true;
    }

    if (query.contains("challenge")) {
        addCard(
                "🎯 Daily Challenge",
                "Complete today's faith-building challenge.",
                v -> showDailyChallenge()
        );
        found = true;
    }

    if (query.contains("progress") ||
            query.contains("points") ||
            query.contains("streak")) {

        addCard(
                "📊 Progress",
                "View your points, streaks, and learning progress.",
                v -> showProgress()
        );
        found = true;
    }

    if (query.contains("achievement")) {
        addCard(
                "🏆 Achievements",
                "View your unlocked and locked achievements.",
                v -> showAchievements()
        );
        found = true;
    }

    if (query.contains("setting") ||
            query.contains("sound")) {

        addCard(
                "⚙️ Settings",
                "Manage Kingdom Life settings.",
                v -> showSettings()
        );
        found = true;
    }

    if (!found) {

        addCard(
                "🔎 No Feature Found",
                "No matching feature was found. Try another search.",
                v -> {}
        );
    }

    addButton(
            "🔎 Search Again",
            v -> showExplore()
    );

    addButton(
            "⬅️ Back to Home",
            v -> showHome()
    );
        }
  }
