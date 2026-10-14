package com.kingdomlife.app;

import java.util.ArrayList;

public class GenesisJourneyData {

public static void loadGenesisQuestions(
        String difficulty,
        ArrayList<String> bibleJourneyQuestions,
        ArrayList<String[]> bibleJourneyOptions,
        ArrayList<Integer> bibleJourneyAnswers) {

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
bibleJourneyAnswers.add(0);  
      
   bibleJourneyQuestions.add("What was the sign of God's covenant with Abraham?");  
bibleJourneyOptions.add(new String[]{  
        "The rainbow", "The Sabbath", "Circumcision", "The Passover"  
});  
bibleJourneyAnswers.add(2);

bibleJourneyQuestions.add("Who was the king of Salem who blessed Abram?");
bibleJourneyOptions.add(new String[]{
"Abimelech", "Melchizedek", "Pharaoh", "Bera"
});
bibleJourneyAnswers.add(1);

bibleJourneyQuestions.add("How many trained servants did Abram take to rescue Lot?");  
bibleJourneyOptions.add(new String[]{  
        "120", "300", "318", "400"  
});  
bibleJourneyAnswers.add(2);  

bibleJourneyQuestions.add("What did God promise Abraham would be as numerous as the stars?");  
bibleJourneyOptions.add(new String[]{  
        "His descendants", "His servants", "His possessions", "His cattle"  
});  
bibleJourneyAnswers.add(0);  

bibleJourneyQuestions.add("What was the name of Isaac's mother?");  
bibleJourneyOptions.add(new String[]{  
        "Rebekah", "Hagar", "Sarah", "Keturah"  
});  
bibleJourneyAnswers.add(2);  

bibleJourneyQuestions.add("Where did Abraham send his servant to find a wife for Isaac?");  
bibleJourneyOptions.add(new String[]{  
        "Egypt", "The land of his kindred", "Sodom", "Canaan"  
});  
bibleJourneyAnswers.add(1);  

bibleJourneyQuestions.add("What did Jacob see in his dream at Bethel?");  
bibleJourneyOptions.add(new String[]{  
        "A burning bush", "A ladder reaching to heaven", "A great river", "A heavenly army"  
});  
bibleJourneyAnswers.add(1);  

bibleJourneyQuestions.add("What new name did God give Jacob?");  
bibleJourneyOptions.add(new String[]{  
        "Israel", "Ephraim", "Judah", "Benjamin"  
});  
bibleJourneyAnswers.add(0);  

bibleJourneyQuestions.add("What did Joseph's brothers dip his coat in?");  
bibleJourneyOptions.add(new String[]{  
        "Oil", "Water", "Blood", "Wine"  
});  
bibleJourneyAnswers.add(2);  

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
}
