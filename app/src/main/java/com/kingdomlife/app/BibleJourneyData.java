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

            questions.add(new Question(
        "Who led the Israelites out of Egypt?",
        new String[]{
                "Moses", "Joseph", "Joshua", "Aaron"
        },
        0
));

questions.add(new Question(
        "Who was Moses' brother?",
        new String[]{
                "Aaron", "Joshua", "Caleb", "Gershom"
        },
        0
));

questions.add(new Question(
        "Who was Moses' sister?",
        new String[]{
                "Miriam", "Zipporah", "Deborah", "Hannah"
        },
        0
));

questions.add(new Question(
        "Who was Moses' wife?",
        new String[]{
                "Zipporah", "Miriam", "Rahab", "Ruth"
        },
        0
));

questions.add(new Question(
        "What was Moses' firstborn son's name mentioned in Exodus?",
        new String[]{
                "Gershom", "Eliezer", "Joshua", "Aaron"
        },
        0
));

questions.add(new Question(
        "Where was Moses when God appeared to him in the burning bush?",
        new String[]{
                "Mount Horeb", "Mount Sinai", "Mount Carmel", "Mount Zion"
        },
        0
));

questions.add(new Question(
        "What was Moses tending when God appeared to him?",
        new String[]{
                "Sheep", "Camels", "Cattle", "Goats"
        },
        0
));

questions.add(new Question(
        "What appeared to Moses but was not consumed by the fire?",
        new String[]{
                "A bush", "A tree", "A mountain", "A tent"
        },
        0
));

questions.add(new Question(
        "What did God tell Moses to remove from his feet?",
        new String[]{
                "His sandals", "His robe", "His belt", "His cloak"
        },
        0
));

questions.add(new Question(
        "What was Moses' staff turned into?",
        new String[]{
                "A serpent", "A dove", "A lamb", "A fish"
        },
        0
));

questions.add(new Question(
        "Who was the king of Egypt during the Exodus?",
        new String[]{
                "Pharaoh", "Nebuchadnezzar", "Herod", "Cyrus"
        },
        0
));

questions.add(new Question(
        "What was the first plague upon Egypt?",
        new String[]{
                "Water turned to blood",
                "Frogs",
                "Darkness",
                "Locusts"
        },
        0
));

questions.add(new Question(
        "What covered Egypt during the second plague?",
        new String[]{
                "Frogs", "Locusts", "Flies", "Hail"
        },
        0
));

questions.add(new Question(
        "What did the Israelites put on their doorposts during the first Passover?",
        new String[]{
                "Blood of a lamb",
                "Oil",
                "Water",
                "Ashes"
        },
        0
));

questions.add(new Question(
        "What sea did the Israelites cross when leaving Egypt?",
        new String[]{
                "Red Sea", "Dead Sea", "Sea of Galilee", "Mediterranean Sea"
        },
        0
));

questions.add(new Question(
        "What did God use to lead Israel by night?",
        new String[]{
                "A pillar of fire",
                "A star",
                "The moon",
                "A lamp"
        },
        0
));

questions.add(new Question(
        "What did God use to lead Israel by day?",
        new String[]{
                "A pillar of cloud",
                "A pillar of fire",
                "A rainbow",
                "A bright star"
        },
        0
));

questions.add(new Question(
        "What food did God provide for Israel in the wilderness?",
        new String[]{
                "Manna", "Bread from Egypt", "Figs", "Olives"
        },
        0
));

questions.add(new Question(
        "What came from the rock when Moses struck it?",
        new String[]{
                "Water", "Oil", "Honey", "Milk"
        },
        0
));

questions.add(new Question(
        "What did Moses receive from God on Mount Sinai?",
        new String[]{
                "The Ten Commandments",
                "The crown of Israel",
                "A sword",
                "A royal robe"
        },
        0
));

questions.add(new Question(
        "What did the Israelites make while Moses was on Mount Sinai?",
        new String[]{
                "A golden calf",
                "A golden crown",
                "A bronze serpent",
                "A golden throne"
        },
        0
));

questions.add(new Question(
        "What material was the ark of the covenant made from?",
        new String[]{
                "Acacia wood",
                "Cedar",
                "Olive wood",
                "Oak"
        },
        0
));

questions.add(new Question(
        "What covered the ark of the covenant?",
        new String[]{
                "Gold", "Silver", "Bronze", "Iron"
        },
        0
));

questions.add(new Question(
        "Who served as Israel's first high priest in Exodus?",
        new String[]{
                "Aaron", "Moses", "Joshua", "Eleazar"
        },
        0
));

questions.add(new Question(
        "What did Moses' face do after he spoke with God?",
        new String[]{
                "It shone", "It became dark", "It changed color", "It became scarred"
        },
        0
));
                

        if (difficulty.equals("Medium")) {

    questions.add(new Question(
            "Why did Moses initially hesitate to go to Pharaoh?",
            new String[]{
                    "He felt unable to speak well",
                    "He was afraid of the desert",
                    "He did not know where Egypt was",
                    "He wanted to remain a shepherd"
            },
            0
    ));

    questions.add(new Question(
            "Who did God appoint to speak alongside Moses?",
            new String[]{
                    "Joshua",
                    "Aaron",
                    "Caleb",
                    "Hur"
            },
            1
    ));

    questions.add(new Question(
            "What happened to the water in Egypt during the first plague?",
            new String[]{
                    "It disappeared",
                    "It became bitter",
                    "It became blood",
                    "It froze"
            },
            2
    ));

    questions.add(new Question(
            "Which plague came immediately after the plague of frogs?",
            new String[]{
                    "Flies",
                    "Hail",
                    "Locusts",
                    "Lice"
            },
            3
    ));

    questions.add(new Question(
            "What distinction did God make during some of the plagues between Israel and Egypt?",
            new String[]{
                    "The Israelites were spared from certain plagues",
                    "The Israelites received extra food",
                    "The Israelites were moved to another country",
                    "The Israelites were given Egyptian soldiers"
            },
            0
    ));

    questions.add(new Question(
            "What did Pharaoh do after the plague of darkness?",
            new String[]{
                    "He released all the Israelites immediately",
                    "He told Moses to leave Egypt",
                    "He left Egypt himself",
                    "He destroyed the Israelites' homes"
            },
            1
    ));

    questions.add(new Question(
            "What did the Israelites ask the Egyptians for before leaving Egypt?",
            new String[]{
                    "Animals and land",
                    "Weapons and chariots",
                    "Silver, gold, and clothing",
                    "Food and houses"
            },
            2
    ));

    questions.add(new Question(
            "Why did the Israelites become afraid when they saw Pharaoh's army near the Red Sea?",
            new String[]{
                    "They had run out of food",
                    "They could not find Moses",
                    "They were attacked by another nation",
                    "They believed they would be trapped"
            },
            3
    ));

    questions.add(new Question(
            "What did Moses stretch out over the Red Sea?",
            new String[]{
                    "His hand with his staff",
                    "His robe",
                    "A branch",
                    "A sword"
            },
            0
    ));

    questions.add(new Question(
            "What happened to Pharaoh's army when it followed Israel into the sea?",
            new String[]{
                    "They escaped through another path",
                    "The waters returned over them",
                    "They surrendered to Moses",
                    "They crossed before Israel"
            },
            1
    ));

    questions.add(new Question(
            "What did the Israelites complain about when they reached the wilderness of Sin?",
            new String[]{
                    "They had no clothing",
                    "They had no weapons",
                    "They had no food",
                    "They had no animals"
            },
            2
    ));

    questions.add(new Question(
            "On which day were the Israelites instructed to gather twice as much manna?",
            new String[]{
                    "The seventh day",
                    "The first day",
                    "The third day",
                    "The sixth day"
            },
            3
    ));

    questions.add(new Question(
            "Why were the Israelites told not to gather manna on the seventh day?",
            new String[]{
                    "It was the Sabbath",
                    "It was a day of battle",
                    "The manna stopped permanently",
                    "Moses commanded them to fast"
            },
            0
    ));

    questions.add(new Question(
            "Who helped Moses keep his hands raised during the battle with Amalek?",
            new String[]{
                    "Joshua and Caleb",
                    "Aaron and Hur",
                    "Eleazar and Aaron",
                    "Miriam and Zipporah"
            },
            1
    ));

    questions.add(new Question(
            "Who advised Moses to appoint judges over the people?",
            new String[]{
                    "Aaron",
                    "Joshua",
                    "Jethro",
                    "Hur"
            },
            2
    ));

    questions.add(new Question(
            "What did the people promise when Moses presented God's covenant to them?",
            new String[]{
                    "They would build a palace",
                    "They would return to Egypt",
                    "They would choose a king",
                    "They would obey what God had spoken"
            },
            3
    ));

    questions.add(new Question(
            "How long was Moses on Mount Sinai when he received God's instructions?",
            new String[]{
                    "Forty days and forty nights",
                    "Seven days and seven nights",
                    "Twelve days",
                    "Seventy days"
            },
            0
    ));

    questions.add(new Question(
            "Who made the golden calf while Moses was on the mountain?",
            new String[]{
                    "Joshua",
                    "Aaron",
                    "Hur",
                    "Jethro"
            },
            1
    ));

    questions.add(new Question(
            "What did Aaron use to make the golden calf?",
            new String[]{
                    "Gold from the tabernacle",
                    "Gold from Pharaoh",
                    "Gold earrings from the people",
                    "Gold from Moses' possessions"
            },
            2
    ));

    questions.add(new Question(
            "What did Moses do with the first tablets when he saw the golden calf?",
            new String[]{
                    "He hid them in the tabernacle",
                    "He gave them to Aaron",
                    "He carried them back to Egypt",
                    "He broke them at the foot of the mountain"
            },
            3
    ));

    questions.add(new Question(
            "What did Moses ask God to show him in Exodus 33?",
            new String[]{
                    "His glory",
                    "The promised land",
                    "The future of Israel",
                    "The location of Pharaoh"
            },
            0
    ));

    questions.add(new Question(
            "What was placed inside the Ark of the Covenant according to God's instructions?",
            new String[]{
                    "A golden calf",
                    "The testimony",
                    "Moses' staff",
                    "Aaron's garments"
            },
            1
    ));

    questions.add(new Question(
            "What separated the Holy Place from the Most Holy Place in the tabernacle?",
            new String[]{
                    "A wooden wall",
                    "A curtain of wool",
                    "A veil",
                    "A stone gate"
            },
            2
    ));

    questions.add(new Question(
            "What was the lampstand in the tabernacle made from?",
            new String[]{
                    "Silver",
                    "Bronze",
                    "Acacia wood",
                    "Pure gold"
            },
            3
    ));

    questions.add(new Question(
            "What happened to Moses' face after he came down from Mount Sinai with the second tablets?",
            new String[]{
                    "His face shone",
                    "His face became dark",
                    "His face was covered with ashes",
                    "His face became scarred"
            },
            0
    ));

                }

                if (difficulty.equals("Hard")) {

                    questions.add(new Question(
        "Why did God tell Moses to stretch out his hand over the sea before the Israelites crossed?",
        new String[]{
                "So the waters would divide",
                "So Pharaoh would stop his army",
                "So the Israelites would become invisible",
                "So the Egyptians would turn back"
        },
        0
));

questions.add(new Question(
        "What does Exodus say happened when the pillar of cloud came between Israel and the Egyptians?",
        new String[]{
                "It led the Egyptians into the sea",
                "It gave light to the Egyptians",
                "It separated the two groups",
                "It disappeared completely"
        },
        2
));

questions.add(new Question(
        "Why did the Israelites murmur against Moses at Marah?",
        new String[]{
                "There was no bread",
                "The water was bitter",
                "The Egyptians had returned",
                "They had lost their animals"
        },
        1
));

questions.add(new Question(
        "What did God use to make the bitter waters at Marah sweet?",
        new String[]{
                "A branch",
                "A stone",
                "A staff",
                "A piece of wood"
        },
        3
));

questions.add(new Question(
        "What happened to the manna when some Israelites kept it until the next morning, contrary to Moses' instruction?",
        new String[]{
                "It became larger",
                "It bred worms and became foul",
                "It turned into water",
                "It disappeared without trace"
        },
        1
));

questions.add(new Question(
        "What happened to the manna kept from the sixth day?",
        new String[]{
                "It became twice as much",
                "It became bitter",
                "It remained good for the Sabbath",
                "It disappeared at sunrise"
        },
        2
));

questions.add(new Question(
        "Why did Moses call the place where Israel fought Amalek Rephidim-related by names such as Massah and Meribah?",
        new String[]{
                "Israel tempted the LORD and questioned His presence",
                "Israel defeated Amalek there",
                "Moses received the Ten Commandments there",
                "The tabernacle was built there"
        },
        0
));

questions.add(new Question(
        "What did Moses' father-in-law observe about Moses' work of judging the people?",
        new String[]{
                "Moses was refusing to help the people",
                "Moses was doing too little",
                "Moses was carrying the responsibility alone",
                "Moses had appointed too many judges"
        },
        2
));

questions.add(new Question(
        "What qualifications did Jethro recommend for the men Moses appointed as rulers?",
        new String[]{
                "They should be wealthy and powerful",
                "They should fear God, be truthful, and hate covetousness",
                "They should be related to Moses",
                "They should have been Egyptian officials"
        },
        1
));

questions.add(new Question(
        "What did God say Israel would be to Him if they obeyed His covenant?",
        new String[]{
                "A kingdom of priests and an holy nation",
                "A nation greater than every kingdom",
                "A nation without enemies",
                "A nation ruled directly by Moses"
        },
        0
));

questions.add(new Question(
        "Why were the Israelites instructed to sanctify themselves before meeting God at Mount Sinai?",
        new String[]{
                "They were preparing for battle",
                "They were preparing to enter Egypt",
                "They were preparing to meet the LORD",
                "They were preparing to build houses"
        },
        2
));

questions.add(new Question(
        "What happened when the trumpet sounded long at Mount Sinai?",
        new String[]{
                "The people were commanded to return to Egypt",
                "Moses came down from the mountain",
                "Pharaoh arrived at the camp",
                "The people could go up toward the mountain"
        },
        3
));

questions.add(new Question(
        "Which commandment specifically forbids making a graven image?",
        new String[]{
                "The first commandment",
                "The second commandment",
                "The fourth commandment",
                "The fifth commandment"
        },
        1
));

questions.add(new Question(
        "What reason did God give for remembering the Sabbath in Exodus 20?",
        new String[]{
                "Because Israel was created in Egypt",
                "Because Moses rested after the Exodus",
                "Because God made heaven and earth in six days and rested the seventh",
                "Because Pharaoh had given Israel that day"
        },
        2
));

questions.add(new Question(
        "What did the Israelites do when they saw the thunderings, lightning, trumpet sound, and smoking mountain?",
        new String[]{
                "They stood far off",
                "They climbed the mountain",
                "They demanded to see God",
                "They returned immediately to Egypt"
        },
        0
));

questions.add(new Question(
        "What did God command concerning an altar made of stone?",
        new String[]{
                "It had to be covered with gold",
                "It had to be built only by Aaron",
                "It had to be placed inside the tabernacle",
                "It was not to be built with hewn stone"
        },
        3
));

questions.add(new Question(
        "What did God command about lending money to the poor among His people?",
        new String[]{
                "They were to charge whatever interest they wanted",
                "They were not to act as a usurer toward him",
                "They were forbidden to lend at all",
                "They were to demand double repayment"
        },
        1
));

questions.add(new Question(
        "What was the blood used for when Moses confirmed the covenant with the people?",
        new String[]{
                "It was sprinkled upon the people",
                "It was poured into the sea",
                "It was placed inside the ark",
                "It was used to mark the mountain"
        },
        0
));

questions.add(new Question(
        "Who went up with Moses when he went higher on Mount Sinai?",
        new String[]{
                "Aaron, Nadab, and Abihu, with seventy elders",
                "Joshua and Caleb only",
                "Aaron and Miriam only",
                "Jethro and Joshua"
        },
        0
));

questions.add(new Question(
        "What did the elders of Israel see under the feet of the God of Israel?",
        new String[]{
                "A pavement of sapphire, as clear as the sky",
                "A pavement of gold",
                "A pavement of bronze",
                "A pavement of precious stones of many colors"
        },
        0
));

questions.add(new Question(
        "What did God give Moses on Mount Sinai after calling him into the cloud?",
        new String[]{
                "The plans for Egypt's army",
                "The tables of stone containing the law and commandments",
                "A map of the promised land",
                "A sword for Joshua"
        },
        1
));

questions.add(new Question(
        "What did Aaron tell the Israelites to bring when they demanded gods to go before them?",
        new String[]{
                "Their silver coins",
                "Their weapons",
                "The golden earrings of their wives, sons, and daughters",
                "Their livestock"
        },
        2
));

questions.add(new Question(
        "What did Moses do when he saw the calf and the dancing?",
        new String[]{
                "He immediately crowned Aaron",
                "He threw the tables from his hands and broke them beneath the mount",
                "He left Israel permanently",
                "He ordered Joshua to destroy the tabernacle"
        },
        1
));

questions.add(new Question(
        "What did Moses do with the golden calf after destroying it?",
        new String[]{
                "He burned it, ground it to powder, scattered it upon the water, and made Israel drink it",
                "He buried it under the mountain",
                "He gave it to Aaron",
                "He carried it back to Pharaoh"
        },
        0
));

questions.add(new Question(
        "What did Moses place over his face after speaking with the LORD?",
        new String[]{
                "A crown",
                "A veil",
                "A priestly robe",
                "A helmet"
        },
        1
        ));

                }
if (difficulty.equals("Scholar")) {
    questions.add(new Question(
        "Why did God lead Israel by the way of the wilderness toward the Red Sea instead of the shorter route through the land of the Philistines?",
        new String[]{
                "The shorter route was blocked by the Egyptians",
                "God knew the people might turn back when faced with war",
                "Moses did not know the shorter route",
                "There was no water along the shorter route"
        },
        1
));

questions.add(new Question(
        "What connection did Moses make between Israel's departure from Egypt and Joseph's final request?",
        new String[]{
                "Joseph had asked that his bones be carried up when God visited Israel",
                "Joseph had instructed Israel to take Egyptian weapons",
                "Joseph had commanded Moses to celebrate Passover",
                "Joseph had chosen the route through the wilderness"
        },
        0
));

questions.add(new Question(
        "At the Red Sea, what did Moses tell the Israelites they would see when they stood still?",
        new String[]{
                "A new path into Egypt",
                "Pharaoh surrendering",
                "The salvation of the LORD",
                "Joshua leading the army"
        },
        2
));

questions.add(new Question(
        "Why did the waters of the Red Sea return over the Egyptians?",
        new String[]{
                "Moses struck the water a second time",
                "The Egyptians had reached the opposite shore",
                "The Israelites caused the waters to return",
                "The LORD caused the sea to return to its strength"
        },
        3
));

questions.add(new Question(
        "What did the manna demonstrate about gathering food on the sixth and seventh days?",
        new String[]{
                "Israel was to gather twice as much on the sixth day because the seventh was the Sabbath",
                "Israel was forbidden to gather anything on the sixth day",
                "Israel was required to gather twice as much every day",
                "The manna stopped permanently on the seventh day"
        },
        0
));

questions.add(new Question(
        "Why was the manna kept in a pot before the LORD?",
        new String[]{
                "It was used as food for Aaron",
                "It was kept as a memorial for future generations",
                "It was used during battles",
                "It was exchanged for animals"
        },
        1
));

questions.add(new Question(
        "What did Moses name the place where Israel tested the LORD by asking whether He was among them?",
        new String[]{
                "Rephidim",
                "Marah",
                "Massah and Meribah",
                "Sinai"
        },
        2
));

questions.add(new Question(
        "What did Aaron and Hur do during Israel's battle with Amalek?",
        new String[]{
                "They commanded Joshua's army",
                "They led Israel around the enemy",
                "They built an altar",
                "They supported Moses' hands when he became tired"
        },
        3
));

questions.add(new Question(
        "What principle was behind Jethro's advice about appointing rulers over Israel?",
        new String[]{
                "Only Moses should handle every dispute",
                "Responsibility could be shared while difficult matters were brought to Moses",
                "Aaron should replace Moses as judge",
                "Every family should appoint its own king"
        },
        1
));

questions.add(new Question(
        "What did God describe Israel as being if they obeyed His covenant?",
        new String[]{
                "A kingdom of priests and an holy nation",
                "The greatest army on earth",
                "A nation without enemies",
                "A kingdom ruled by Moses"
        },
        0
));

questions.add(new Question(
        "Why was the people commanded to stay within the boundary around Mount Sinai?",
        new String[]{
                "The mountain belonged to Moses",
                "They were preparing for war",
                "They were not to approach God's holy presence improperly",
                "The mountain was controlled by Pharaoh"
        },
        2
));

questions.add(new Question(
        "What happened when the people heard the thunderings, the noise of the trumpet, and saw the mountain smoking?",
        new String[]{
                "They climbed the mountain",
                "They asked Aaron to lead them",
                "They returned immediately to Egypt",
                "They removed themselves and stood afar off"
        },
        3
));

questions.add(new Question(
        "What does the commandment concerning the Sabbath connect with God's work of creation?",
        new String[]{
                "Israel was to rest on the seventh day because God made heaven and earth in six days and rested the seventh",
                "Israel was to rest because Pharaoh had given them the day",
                "Israel was to rest only during the wilderness journey",
                "Israel was to rest because Moses commanded it after the Red Sea"
        },
        0
));

questions.add(new Question(
        "What did Moses do with the blood when he confirmed the covenant with Israel?",
        new String[]{
                "He poured it into the Red Sea",
                "He sprinkled it upon the people",
                "He placed it inside the ark",
                "He gave it to Aaron to drink"
        },
        1
));

questions.add(new Question(
        "Who went up with Moses and saw the God of Israel when the covenant was confirmed?",
        new String[]{
                "Joshua and Caleb only",
                "Aaron and Miriam only",
                "Aaron, Nadab, Abihu, and seventy of the elders of Israel",
                "Jethro and Joshua"
        },
        2
));

questions.add(new Question(
        "What did the elders see beneath the feet of the God of Israel?",
        new String[]{
                "A pavement of gold",
                "A pavement of bronze",
                "A pavement of precious stones",
                "A paved work of sapphire stone, as it were the body of heaven in his clearness"
        },
        3
));

questions.add(new Question(
        "What was the purpose of the testimony that God commanded Moses to put into the ark?",
        new String[]{
                "It was to be kept as part of the covenant testimony",
                "It was to be used as a weapon",
                "It was to identify Aaron as king",
                "It was to replace the altar"
        },
        0
));

questions.add(new Question(
        "Why was the golden calf especially serious in light of the covenant Israel had just received?",
        new String[]{
                "Israel had already entered Canaan",
                "It directly contradicted God's commands concerning other gods and graven images",
                "Aaron had secretly made it before Moses received the law",
                "The calf was made from Egyptian weapons"
        },
        1
));

questions.add(new Question(
        "What did Aaron say when Moses confronted him about the golden calf?",
        new String[]{
                "He blamed Joshua completely",
                "He said the people had refused to obey him",
                "He described how the people's gold was gathered and the calf came forth",
                "He said Moses had commanded him to make it"
        },
        2
));

questions.add(new Question(
        "What did Moses do to the golden calf after coming down from the mountain?",
        new String[]{
                "He placed it inside the ark",
                "He returned it to the people",
                "He buried it intact",
                "He burned it, ground it to powder, scattered it on the water, and made the Israelites drink it"
        },
        3
));

questions.add(new Question(
        "What did Moses ask God concerning His presence after Israel's sin with the golden calf?",
        new String[]{
                "That God's presence would go with Israel",
                "That Israel should return to Egypt",
                "That Aaron should lead Israel instead",
                "That Israel should remain permanently at Sinai"
        },
        0
));

questions.add(new Question(
        "When Moses asked to see God's glory, what did God say Moses could not see?",
        new String[]{
                "His goodness",
                "His face",
                "His glory passing by",
                "The place where He would stand"
        },
        1
));

questions.add(new Question(
        "What happened to Moses' face after he came down from Mount Sinai after speaking with the LORD?",
        new String[]{
                "It became covered with ashes",
                "It became dark",
                "The skin of his face shone",
                "It became scarred"
        },
        2
));

questions.add(new Question(
        "Why did Moses tell the people to stop bringing materials for the tabernacle?",
        new String[]{
                "The tabernacle had been cancelled",
                "Aaron had forbidden further offerings",
                "The craftsmen refused to continue",
                "They had brought more than enough for the work"
        },
        3
));

questions.add(new Question(
        "What happened when the tabernacle was finally completed?",
        new String[]{
                "The glory of the LORD filled the tabernacle",
                "Pharaoh returned to Egypt",
                "Moses became king",
                "Israel immediately entered Canaan"
        },
        0
));
                
}
        }
if (book.equals("Leviticus")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
        "What was the main purpose of the book of Leviticus?",
        new String[]{
                "To give laws and instructions for worship and holy living",
                "To describe the reign of David",
                "To record the creation of the world",
                "To tell the story of Israel's kings"
        },
        0
));

questions.add(new Question(
        "From where did the LORD speak to Moses at the beginning of Leviticus?",
        new String[]{
                "Mount Sinai",
                "The tabernacle of the congregation",
                "The Jordan River",
                "Jericho"
        },
        1
));

questions.add(new Question(
        "What animal could be offered as a burnt offering from the herd?",
        new String[]{
                "A bullock",
                "A camel",
                "A donkey",
                "A horse"
        },
        0
));

questions.add(new Question(
        "What type of offering included fine flour and oil?",
        new String[]{
                "Peace offering",
                "Sin offering",
                "Meat offering",
                "Trespass offering"
        },
        2
));

questions.add(new Question(
        "What ingredient were the Israelites specifically forbidden to leave out of the meat offering?",
        new String[]{
                "Oil",
                "Salt",
                "Flour",
                "Honey"
        },
        1
));

questions.add(new Question(
        "What were the Israelites forbidden to add to their meat offering?",
        new String[]{
                "Oil",
                "Salt",
                "Frankincense",
                "Leaven"
        },
        3
));

questions.add(new Question(
        "Which offering was associated with fellowship and thanksgiving?",
        new String[]{
                "Peace offering",
                "Sin offering",
                "Burnt offering",
                "Trespass offering"
        },
        0
));

questions.add(new Question(
        "Who was appointed as Israel's first high priest?",
        new String[]{
                "Moses",
                "Joshua",
                "Aaron",
                "Eleazar"
        },
        2
));

questions.add(new Question(
        "What did Moses place on Aaron and his sons during their consecration?",
        new String[]{
                "The priestly garments",
                "A crown of gold",
                "A sword",
                "A royal robe"
        },
        0
));

questions.add(new Question(
        "What happened when Aaron offered the first sacrifices at the tabernacle?",
        new String[]{
                "The Israelites left the camp",
                "Fire came out from before the LORD and consumed the offering",
                "Moses became high priest",
                "The tabernacle was moved"
        },
        1
));

questions.add(new Question(
        "Which two sons of Aaron offered strange fire before the LORD?",
        new String[]{
                "Eleazar and Ithamar",
                "Nadab and Abihu",
                "Korah and Dathan",
                "Joshua and Caleb"
        },
        1
));

questions.add(new Question(
        "What happened to Nadab and Abihu after they offered strange fire?",
        new String[]{
                "They became high priests",
                "They were sent to Egypt",
                "Fire from the LORD consumed them",
                "They became judges"
        },
        2
));

questions.add(new Question(
        "What were the priests told not to drink before entering the tabernacle?",
        new String[]{
                "Wine or strong drink",
                "Water",
                "Milk",
                "Grape juice"
        },
        0
));

questions.add(new Question(
        "Which animal was considered clean and could be eaten according to Leviticus 11?",
        new String[]{
                "Pig",
                "Camel",
                "Cattle",
                "Hare"
        },
        2
));

questions.add(new Question(
        "Why was the pig considered unclean?",
        new String[]{
                "It had no horns",
                "It divided the hoof but did not chew the cud",
                "It lived near water",
                "It was too large"
        },
        1
));

questions.add(new Question(
        "What was the purpose of the Day of Atonement?",
        new String[]{
                "To celebrate Israel's victory over Egypt",
                "To appoint a new king",
                "To make atonement for the sins of the people",
                "To begin the harvest"
        },
        2
));

questions.add(new Question(
        "Who was allowed to enter the Most Holy Place on the Day of Atonement?",
        new String[]{
                "The high priest",
                "Every Israelite",
                "Joshua",
                "The elders"
        },
        0
));

questions.add(new Question(
        "What animal was sent into the wilderness as part of the Day of Atonement ceremony?",
        new String[]{
                "A bullock",
                "A goat",
                "A ram",
                "A lamb"
        },
        1
));

questions.add(new Question(
        "What command did God give Israel concerning the shedding of blood?",
        new String[]{
                "They were to drink blood during sacrifices",
                "They were forbidden to eat blood",
                "Only priests could eat blood",
                "Blood could be eaten during festivals"
        },
        1
));

questions.add(new Question(
        "What important command appears in Leviticus 19 concerning other people?",
        new String[]{
                "Love thy neighbour as thyself",
                "Build a palace",
                "Choose a king",
                "Return to Egypt"
        },
        0
));

questions.add(new Question(
        "What did God command Israel to do with the Sabbath?",
        new String[]{
                "Ignore it during harvest",
                "Keep it holy",
                "Celebrate it only once a year",
                "Use it for military training"
        },
        1
));

questions.add(new Question(
        "What did God command Israel to do with the corners of their fields during harvest?",
        new String[]{
                "Harvest every part",
                "Burn the corners",
                "Leave them for the poor and the stranger",
                "Give them to Egypt"
        },
        2
));

questions.add(new Question(
        "What happened to Hebrew servants during the Year of Jubilee?",
        new String[]{
                "They were released according to God's law",
                "They became priests",
                "They were sent to Egypt",
                "They had to serve another fifty years"
        },
        0
));

questions.add(new Question(
        "What did God promise Israel if they obeyed His statutes and commandments?",
        new String[]{
                "They would receive blessing, including rain and fruitful harvests",
                "They would never have to work again",
                "They would become rulers of Egypt",
                "They would never face any enemies"
        },
        0
));
}
}
        if (book.equals("Numbers")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Why is the fourth book of the Bible called Numbers?",
                new String[]{
                        "Because Israel was numbered in censuses",
                        "Because Moses counted the Ten Commandments",
                        "Because the priests counted sacrifices",
                        "Because the Israelites counted their enemies"
                },
                0
        ));

        questions.add(new Question(
                "Who was the brother of Moses?",
                new String[]{
                        "Joshua",
                        "Aaron",
                        "Caleb",
                        "Eleazar"
                },
                1
        ));

        questions.add(new Question(
                "Who was Moses' sister?",
                new String[]{
                        "Miriam",
                        "Deborah",
                        "Ruth",
                        "Hannah"
                },
                0
        ));

        questions.add(new Question(
                "What did God command Moses to do with the Israelites?",
                new String[]{
                        "Build a palace",
                        "Count and organize them",
                        "Send them back to Egypt",
                        "Make them soldiers only"
                },
                1
        ));

        questions.add(new Question(
                "Which tribe was set apart for the service of the tabernacle?",
                new String[]{
                        "Judah",
                        "Benjamin",
                        "Levi",
                        "Dan"
                },
                2
        ));

        questions.add(new Question(
                "Who was the father of Moses, Aaron, and Miriam?",
                new String[]{
                        "Amram",
                        "Korah",
                        "Caleb",
                        "Elkanah"
                },
                0
        ));

        questions.add(new Question(
                "What was placed over the tabernacle when Israel camped?",
                new String[]{
                        "A cloud",
                        "A wall of fire",
                        "A golden roof",
                        "A stone covering"
                },
                0
        ));

        questions.add(new Question(
                "What happened when the cloud was taken up from the tabernacle?",
                new String[]{
                        "Israel stopped moving",
                        "Israel journeyed onward",
                        "Moses returned to Egypt",
                        "The priests left the camp"
                },
                1
        ));

        questions.add(new Question(
                "Who was the firstborn son of Aaron?",
                new String[]{
                        "Ithamar",
                        "Eleazar",
                        "Nadab",
                        "Phinehas"
                },
                2
        ));

        questions.add(new Question(
                "Which tribe was not counted with the other tribes for military service?",
                new String[]{
                        "Judah",
                        "Levi",
                        "Reuben",
                        "Simeon"
                },
                1
        ));

        questions.add(new Question(
                "What did the Israelites do when the Passover was observed in the wilderness?",
                new String[]{
                        "They observed the Passover according to God's command",
                        "They ignored the Passover",
                        "They returned to Egypt",
                        "They built a new altar to Pharaoh"
                },
                0
        ));

        questions.add(new Question(
                "What did the Israelites complain about in Numbers 11?",
                new String[]{
                        "They wanted a king",
                        "They wanted meat",
                        "They wanted gold",
                        "They wanted to return to Canaan"
                },
                1
        ));

        questions.add(new Question(
                "What food did God provide for Israel in the wilderness?",
                new String[]{
                        "Bread from Egypt",
                        "Fish",
                        "Manna",
                        "Grapes"
                },
                2
        ));
                questions.add(new Question(
                "What happened when the people complained about the manna?",
                new String[]{
                        "God sent quail",
                        "God sent horses",
                        "God sent grapes",
                        "God sent bread from Egypt"
                },
                0
        ));

        questions.add(new Question(
                "Who were the twelve men sent to spy out the land of Canaan?",
                new String[]{
                        "Priests",
                        "Spies from the tribes of Israel",
                        "Kings of Canaan",
                        "Egyptian soldiers"
                },
                1
        ));

        questions.add(new Question(
                "Which two spies brought a good report about Canaan?",
                new String[]{
                        "Joshua and Caleb",
                        "Moses and Aaron",
                        "Nadab and Abihu",
                        "Korah and Dathan"
                },
                0
        ));

        questions.add(new Question(
                "What did the ten spies say about the people of Canaan?",
                new String[]{
                        "They were weak and afraid",
                        "They were unable to fight",
                        "They were strong and difficult to overcome",
                        "They had already left the land"
                },
                2
        ));

        questions.add(new Question(
                "What did the Israelites want to do after hearing the spies' report?",
                new String[]{
                        "Choose a captain and return to Egypt",
                        "Build the tabernacle",
                        "Crown Joshua king",
                        "Attack the Egyptians"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the ten spies who brought the evil report?",
                new String[]{
                        "They became priests",
                        "They died by a plague before the LORD",
                        "They returned to Egypt",
                        "They became kings"
                },
                1
        ));

        questions.add(new Question(
                "Why were the Israelites told they would wander in the wilderness?",
                new String[]{
                        "Because they refused to trust God and enter Canaan",
                        "Because Moses wanted to leave Canaan",
                        "Because Egypt attacked them",
                        "Because Joshua lost the way"
                },
                0
        ));

        questions.add(new Question(
                "Who rebelled against Moses and Aaron in Numbers 16?",
                new String[]{
                        "Joshua",
                        "Korah",
                        "Caleb",
                        "Eleazar"
                },
                1
        ));

        questions.add(new Question(
                "What happened to Korah and those who joined his rebellion?",
                new String[]{
                        "They became leaders",
                        "The earth opened and swallowed them",
                        "They escaped into Egypt",
                        "They were made priests"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses strike when God commanded him to speak to the rock?",
                new String[]{
                        "A tree",
                        "The tabernacle",
                        "The rock",
                        "The altar"
                },
                2
        ));

        questions.add(new Question(
                "Who was chosen to succeed Moses as leader of Israel?",
                new String[]{
                        "Joshua",
                        "Aaron",
                        "Caleb",
                        "Eleazar"
                },
                0
        ));

        questions.add(new Question(
                "What did Aaron's rod do that showed God's chosen priesthood?",
                new String[]{
                        "It became a serpent",
                        "It blossomed, produced flowers, and yielded almonds",
                        "It turned into gold",
                        "It split the Red Sea"
                },
                1
        ));
                }
        }
        if (book.equals("Deuteronomy")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "What does the name Deuteronomy commonly mean?",
                new String[]{
                        "Second law",
                        "First journey",
                        "Book of kings",
                        "Song of Moses"
                },
                0
        ));

        questions.add(new Question(
                "Who spoke the words recorded in Deuteronomy?",
                new String[]{
                        "Joshua",
                        "Moses",
                        "Aaron",
                        "Caleb"
                },
                1
        ));

        questions.add(new Question(
                "Where were the Israelites when Moses gave the speeches recorded in Deuteronomy?",
                new String[]{
                        "On the plains of Moab",
                        "In Egypt",
                        "At Mount Sinai",
                        "In Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses remind Israel about God's command to enter Canaan?",
                new String[]{
                        "They were forbidden to enter",
                        "They were commanded to go up and possess the land",
                        "They were told to return to Egypt",
                        "They were told to remain at Sinai"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses repeatedly tell Israel to remember?",
                new String[]{
                        "The greatness of Egypt",
                        "The LORD their God and His works",
                        "The kings of Canaan",
                        "Their former enemies"
                },
                1
        ));

        questions.add(new Question(
                "What is the first commandment in the Ten Commandments?",
                new String[]{
                        "Thou shalt not kill",
                        "Thou shalt not steal",
                        "Thou shalt have no other gods before me",
                        "Remember the sabbath day"
                },
                2
        ));

        questions.add(new Question(
                "What were the Israelites commanded to teach their children diligently?",
                new String[]{
                        "The commandments of God",
                        "The laws of Egypt",
                        "The history of Babylon",
                        "The names of Canaanite kings"
                },
                0
        ));

        questions.add(new Question(
                "What were the Israelites told to bind God's words upon their hands and between their eyes?",
                new String[]{
                        "Their weapons",
                        "His commandments",
                        "Their clothing",
                        "Their money"
                },
                1
        ));

        questions.add(new Question(
                "What warning did Moses give Israel about serving other gods?",
                new String[]{
                        "It would bring them away from the LORD",
                        "It would make them stronger",
                        "It would give them more land",
                        "It would make them priests"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses say Israel should do when they entered the promised land?",
                new String[]{
                        "Forget God",
                        "Obey God's commandments",
                        "Return to Egypt",
                        "Build Egyptian temples"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses tell Israel about the LORD's commandments?",
                new String[]{
                        "They were impossible to understand",
                        "They were to be obeyed",
                        "They belonged only to Egypt",
                        "They were temporary stories"
                },
                1
        ));

        questions.add(new Question(
                "What kind of land did Moses describe the promised land as?",
                new String[]{
                        "A land flowing with milk and honey",
                        "A land without water",
                        "A land covered by snow",
                        "A land filled with deserts only"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses warn Israel not to forget when they became prosperous?",
                new String[]{
                        "The LORD who brought them out of Egypt",
                        "The king of Egypt",
                        "The cities of Babylon",
                        "The Philistine army"
                },
                0
        ));
                questions.add(new Question(
                "What did Moses say about the LORD's faithfulness to His covenant?",
                new String[]{
                        "He is faithful and keeps His covenant",
                        "He forgets His covenant",
                        "He changes His commandments daily",
                        "He only remembers the wealthy"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses tell Israel about the nations they would face in Canaan?",
                new String[]{
                        "God would drive them out before Israel",
                        "Israel had to return to Egypt",
                        "They would rule Israel",
                        "They could never be defeated"
                },
                0
        ));

        questions.add(new Question(
                "Why did Moses say God chose Israel?",
                new String[]{
                        "Because they were the largest nation",
                        "Because of God's love and His promise to their fathers",
                        "Because they were stronger than Egypt",
                        "Because they had the largest army"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses say man does not live by bread alone?",
                new String[]{
                        "But by every word that proceeds from the mouth of the LORD",
                        "But by riches",
                        "But by military strength",
                        "But by wisdom alone"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses tell Israel to remember about the wilderness?",
                new String[]{
                        "How the LORD their God had led them",
                        "How Egypt had protected them",
                        "How they became kings",
                        "How they built Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses say happened to Israel's clothing during the forty years in the wilderness?",
                new String[]{
                        "It was replaced every year",
                        "It did not wear out",
                        "It was destroyed by rain",
                        "It was exchanged with Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses tell Israel to fear and serve?",
                new String[]{
                        "The kings of Canaan",
                        "The LORD their God",
                        "The Egyptian army",
                        "The priests of Moab"
                },
                1
        ));

        questions.add(new Question(
                "What did Moses command Israel to do with the words of God?",
                new String[]{
                        "Keep them in their hearts",
                        "Hide them from their children",
                        "Give them to Egypt",
                        "Write them only on weapons"
                },
                0
        ));

        questions.add(new Question(
                "What did Moses say about God's commandments and statutes?",
                new String[]{
                        "They were to be obeyed carefully",
                        "They were optional",
                        "Only priests could obey them",
                        "They applied only in Egypt"
                },
                0
        ));

        questions.add(new Question(
                "What mountain did Moses ascend before his death?",
                new String[]{
                        "Mount Carmel",
                        "Mount Nebo",
                        "Mount Zion",
                        "Mount Tabor"
                },
                1
        ));

        questions.add(new Question(
                "From Mount Nebo, what did Moses see?",
                new String[]{
                        "The promised land",
                        "Egypt",
                        "Babylon",
                        "The Red Sea"
                },
                0
        ));

        questions.add(new Question(
                "Who became the leader of Israel after Moses?",
                new String[]{
                        "Aaron",
                        "Caleb",
                        "Joshua",
                        "Eleazar"
                },
                2
        ));
    }
}
        if (book.equals("Joshua")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who became the leader of Israel after Moses?",
                new String[]{
                        "Joshua",
                        "Caleb",
                        "Aaron",
                        "Eleazar"
                },
                0
        ));

        questions.add(new Question(
                "What did God command Joshua to do after Moses died?",
                new String[]{
                        "Return to Egypt",
                        "Build a new tabernacle",
                        "Lead Israel across the Jordan",
                        "Choose a new priest"
                },
                2
        ));

        questions.add(new Question(
                "What river did the Israelites cross to enter the Promised Land?",
                new String[]{
                        "Nile River",
                        "Euphrates River",
                        "Red Sea",
                        "Jordan River"
                },
                3
        ));

        questions.add(new Question(
                "What city did the Israelites attack after crossing the Jordan?",
                new String[]{
                        "Ai",
                        "Jericho",
                        "Hebron",
                        "Gibeon"
                },
                1
        ));

        questions.add(new Question(
                "How many times did Israel march around Jericho on each of the first six days?",
                new String[]{
                        "Seven times",
                        "Three times",
                        "Once",
                        "Twice"
                },
                2
        ));

        questions.add(new Question(
                "What did the priests carry around Jericho?",
                new String[]{
                        "The ark of the covenant",
                        "The tablets of stone",
                        "A golden altar",
                        "A bronze serpent"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the walls of Jericho?",
                new String[]{
                        "They became higher",
                        "They caught fire",
                        "They were rebuilt",
                        "They fell down"
                },
                3
        ));

        questions.add(new Question(
                "Who hid the Israelite spies in Jericho?",
                new String[]{
                        "Deborah",
                        "Rahab",
                        "Miriam",
                        "Ruth"
                },
                1
        ));

        questions.add(new Question(
                "Where did Rahab hide the spies?",
                new String[]{
                        "Under stalks of flax on the roof",
                        "Inside a cave",
                        "Behind the city gate",
                        "Inside the city wall"
                },
                0
        ));

        questions.add(new Question(
                "What did Rahab ask the spies to remember when Jericho was taken?",
                new String[]{
                        "Her wealth",
                        "Her neighbours",
                        "Her place in the city",
                        "Her and her family's safety"
                },
                3
        ));

        questions.add(new Question(
                "What sign did Rahab use to identify her house?",
                new String[]{
                        "A white cloth",
                        "A blue flag",
                        "A scarlet cord",
                        "A golden lamp"
                },
                2
        ));

        questions.add(new Question(
                "What did Joshua tell the people to do when they crossed the Jordan?",
                new String[]{
                        "Build houses immediately",
                        "Follow the priests carrying the ark",
                        "Return to the wilderness",
                        "March toward Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the Jordan River when the priests carrying the ark stepped into it?",
                new String[]{
                        "It became deeper",
                        "It changed direction",
                        "It dried up forever",
                        "The waters stopped and stood up"
                },
                3
        ));

        questions.add(new Question(
                "What did the Israelites take from the Jordan after crossing?",
                new String[]{
                        "Twelve baskets",
                        "Twelve swords",
                        "Twelve stones",
                        "Twelve tents"
                },
                2
        ));

        questions.add(new Question(
                "Why did Joshua set up the twelve stones?",
                new String[]{
                        "As a memorial for future generations",
                        "To mark the location of Jericho",
                        "To build an altar",
                        "To divide the land"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the manna after Israel ate the produce of Canaan?",
                new String[]{
                        "It became more abundant",
                        "It changed into bread",
                        "It fell only on the Sabbath",
                        "It ceased the next day"
                },
                3
        ));

        questions.add(new Question(
                "Whom did Joshua encounter near Jericho with a drawn sword?",
                new String[]{
                        "The king of Jericho",
                        "The commander of the LORD's army",
                        "Caleb",
                        "An Egyptian soldier"
                },
                1
        ));

        questions.add(new Question(
                "What did the commander of the LORD's army tell Joshua to remove?",
                new String[]{
                        "His robe",
                        "His sword",
                        "His sandals",
                        "His crown"
                },
                2
        ));

        questions.add(new Question(
                "What happened to the sun during the battle at Gibeon?",
                new String[]{
                        "It stood still",
                        "It became dark",
                        "It rose twice",
                        "It disappeared"
                },
                0
        ));

        questions.add(new Question(
                "Who asked Joshua for help against the five Amorite kings?",
                new String[]{
                        "The Egyptians",
                        "The Philistines",
                        "The Moabites",
                        "The Gibeonites"
                },
                3
        ));

        questions.add(new Question(
                "What did Joshua command concerning the five Amorite kings hiding in a cave?",
                new String[]{
                        "Let them escape",
                        "Bring them out of the cave",
                        "Send them back to Egypt",
                        "Make them priests"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the five Amorite kings after Joshua captured them?",
                new String[]{
                        "They became allies of Israel",
                        "They were sent into exile",
                        "They were executed",
                        "They became judges"
                },
                2
        ));

        questions.add(new Question(
                "What city did Israel conquer after Jericho?",
                new String[]{
                        "Bethlehem",
                        "Nazareth",
                        "Damascus",
                        "Ai"
                },
                3
        ));

        questions.add(new Question(
                "Who caused Israel's defeat at Ai by taking things that had been forbidden?",
                new String[]{
                        "Achan",
                        "Korah",
                        "Gehazi",
                        "Absalom"
                },
                0
        ));

        questions.add(new Question(
                "What did Joshua do at Mount Ebal?",
                new String[]{
                        "Built a palace",
                        "Built an altar and read the law",
                        "Established a military camp",
                        "Divided the Jordan River"
                },
                1
        ));

    }
                    }
        
        if (book.equals("Judges")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "What was the main problem Israel repeatedly faced during the time of the judges?",
                new String[]{
                        "They had no food",
                        "They turned away from the LORD",
                        "They could not build cities",
                        "They had no priests"
                },
                1
        ));

        questions.add(new Question(
                "Who was the first judge mentioned in the book of Judges?",
                new String[]{
                        "Gideon",
                        "Samson",
                        "Othniel",
                        "Deborah"
                },
                2
        ));

        questions.add(new Question(
                "Which enemy did Othniel deliver Israel from?",
                new String[]{
                        "The king of Mesopotamia",
                        "The Philistines",
                        "The Midianites",
                        "The Moabites"
                },
                0
        ));

        questions.add(new Question(
                "Who was the left-handed judge who killed King Eglon?",
                new String[]{
                        "Barak",
                        "Ehud",
                        "Jephthah",
                        "Shamgar"
                },
                1
        ));

        questions.add(new Question(
                "Which king was killed by Ehud?",
                new String[]{
                        "Eglon",
                        "Jabin",
                        "Abimelech",
                        "Sisera"
                },
                0
        ));

        questions.add(new Question(
                "Who was the woman who served as a judge of Israel?",
                new String[]{
                        "Jael",
                        "Deborah",
                        "Delilah",
                        "Hannah"
                },
                1
        ));

        questions.add(new Question(
                "Who was the military leader who fought alongside Deborah?",
                new String[]{
                        "Gideon",
                        "Jephthah",
                        "Barak",
                        "Samson"
                },
                2
        ));

        questions.add(new Question(
                "Who killed Sisera?",
                new String[]{
                        "Deborah",
                        "Jael",
                        "Delilah",
                        "Ruth"
                },
                1
        ));

        questions.add(new Question(
                "What did Gideon use to test whether God was with him?",
                new String[]{
                        "A fleece",
                        "A trumpet",
                        "A staff",
                        "A stone"
                },
                0
        ));

        questions.add(new Question(
                "What name did the angel of the LORD call Gideon?",
                new String[]{
                        "Mighty warrior",
                        "King of Israel",
                        "Prophet of God",
                        "Prince of Judah"
                },
                0
        ));

        questions.add(new Question(
                "What did Gideon destroy that belonged to his father?",
                new String[]{
                        "A palace",
                        "An idol altar dedicated to Baal",
                        "A city wall",
                        "A military camp"
                },
                1
        ));

        questions.add(new Question(
                "How many men did Gideon eventually lead into battle against Midian?",
                new String[]{
                        "300",
                        "1,000",
                        "3,000",
                        "12,000"
                },
                0
        ));

        questions.add(new Question(
                "What did Gideon's men carry when they surrounded the Midianite camp?",
                new String[]{
                        "Swords and shields",
                        "Bows and arrows",
                        "Trumpets, empty jars, and torches",
                        "Spears and chariots"
                },
                2
        ));

        questions.add(new Question(
                "What happened when Gideon's men broke their jars and blew their trumpets?",
                new String[]{
                        "The Midianites fled in confusion",
                        "The Jordan River stopped",
                        "Jericho's walls fell",
                        "Rain began to fall"
                },
                0
        ));

        questions.add(new Question(
                "Which judge made a vow concerning whatever came out of his house first?",
                new String[]{
                        "Samson",
                        "Jephthah",
                        "Gideon",
                        "Ehud"
                },
                1
        ));

        questions.add(new Question(
                "Who was known for his extraordinary strength?",
                new String[]{
                        "Barak",
                        "Othniel",
                        "Samson",
                        "Shamgar"
                },
                2
        ));

        questions.add(new Question(
                "What was the secret of Samson's great strength connected to?",
                new String[]{
                        "His uncut hair",
                        "His sword",
                        "His royal clothing",
                        "His shield"
                },
                0
        ));

        questions.add(new Question(
                "Who betrayed Samson by discovering the secret of his strength?",
                new String[]{
                        "Jael",
                        "Deborah",
                        "Delilah",
                        "Rahab"
                },
                2
        ));

        questions.add(new Question(
                "What happened after Samson's hair began to grow again?",
                new String[]{
                        "He became king",
                        "His strength returned",
                        "He left Israel",
                        "He became a priest"
                },
                1
        ));

        questions.add(new Question(
                "What did Samson pull down at the end of his life?",
                new String[]{
                        "The gates of Jerusalem",
                        "The walls of Jericho",
                        "The pillars of a Philistine temple",
                        "The tower of Shechem"
                },
                2
        ));

        questions.add(new Question(
                "Which people were among Israel's enemies during the period of the judges?",
                new String[]{
                        "Philistines",
                        "Romans",
                        "Persians",
                        "Assyrians"
                },
                0
        ));

        questions.add(new Question(
                "What usually happened after Israel cried out to God for help?",
                new String[]{
                        "God raised up a deliverer",
                        "Israel left the Promised Land",
                        "The people chose a king",
                        "The tabernacle was destroyed"
                },
                0
        ));

        questions.add(new Question(
                "What did the Israelites repeatedly do after a judge died?",
                new String[]{
                        "Build a temple",
                        "Return to doing evil",
                        "Move to Egypt",
                        "Choose a prophet"
                },
                1
        ));

        questions.add(new Question(
                "What statement describes the condition of Israel near the end of Judges?",
                new String[]{
                        "Everyone obeyed the king",
                        "Israel had become a great empire",
                        "There was no king in Israel",
                        "Jerusalem had been rebuilt"
                },
                2
        ));

        questions.add(new Question(
                "What is a major lesson repeated throughout the book of Judges?",
                new String[]{
                        "Israel needed to remain faithful to God",
                        "Israel needed more horses",
                        "Israel needed to leave Canaan",
                        "Israel needed to build larger cities"
                },
                0
        ));

    }
            }
        if (book.equals("Ruth")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who was Ruth's mother-in-law?",
                new String[]{
                        "Naomi",
                        "Hannah",
                        "Deborah",
                        "Miriam"
                },
                0
        ));

        questions.add(new Question(
                "Where did Naomi and her family move from?",
                new String[]{
                        "Egypt",
                        "Moab",
                        "Bethlehem",
                        "Jericho"
                },
                1
        ));

        questions.add(new Question(
                "Who was Ruth's husband who died?",
                new String[]{
                        "Boaz",
                        "Elimelech",
                        "Mahlon",
                        "Obed"
                },
                2
        ));

        questions.add(new Question(
                "What did Ruth decide to do when Naomi returned to Bethlehem?",
                new String[]{
                        "Return to Moab",
                        "Go to Egypt",
                        "Stay in Jerusalem",
                        "Go with Naomi"
                },
                3
        ));

        questions.add(new Question(
                "What was Ruth doing when Boaz first noticed her?",
                new String[]{
                        "Gathering grain in the field",
                        "Drawing water",
                        "Selling bread",
                        "Caring for sheep"
                },
                0
        ));

        questions.add(new Question(
                "Whose field did Ruth happen to gather grain in?",
                new String[]{
                        "Elimelech's",
                        "Boaz's",
                        "Jesse's",
                        "Saul's"
                },
                1
        ));

        questions.add(new Question(
                "What was Boaz known for among the people of Bethlehem?",
                new String[]{
                        "Being a mighty warrior",
                        "Being a priest",
                        "Being a wealthy and respected man",
                        "Being a king"
                },
                2
        ));

        questions.add(new Question(
                "What did Boaz tell Ruth to do while gathering grain?",
                new String[]{
                        "Stay close to his young women",
                        "Return to Moab",
                        "Work in another field",
                        "Leave before sunset"
                },
                0
        ));

        questions.add(new Question(
                "Why was Boaz impressed by Ruth?",
                new String[]{
                        "She was wealthy",
                        "She had become a queen",
                        "She was a skilled warrior",
                        "She had remained loyal to Naomi"
                },
                3
        ));

        questions.add(new Question(
                "What did Ruth gather while working in Boaz's field?",
                new String[]{
                        "Olives",
                        "Grapes",
                        "Grain",
                        "Figs"
                },
                2
        ));

        questions.add(new Question(
                "What did Naomi tell Ruth to do at the threshing floor?",
                new String[]{
                        "Ask Boaz to be her redeemer",
                        "Leave Bethlehem",
                        "Return to Moab",
                        "Build an altar"
                },
                0
        ));

        questions.add(new Question(
                "What did Ruth ask Boaz to spread over her?",
                new String[]{
                        "His cloak",
                        "A blanket",
                        "His robe",
                        "A veil"
                },
                0
        ));

        questions.add(new Question(
                "What did Boaz promise to do for Ruth?",
                new String[]{
                        "Send her back to Moab",
                        "Buy her a field only",
                        "Act as her redeemer if the nearer relative would not",
                        "Make her a servant"
                },
                2
        ));

        questions.add(new Question(
                "What did Boaz first have to do before marrying Ruth?",
                new String[]{
                        "Become a priest",
                        "Speak with the nearer relative",
                        "Move to Moab",
                        "Ask the king"
                },
                1
        ));

        questions.add(new Question(
                "Where did Boaz settle the matter with the nearer relative?",
                new String[]{
                        "At the city gate",
                        "At the temple",
                        "At Naomi's house",
                        "At the threshing floor"
                },
                0
        ));

        questions.add(new Question(
                "What did the nearer relative do when Boaz explained the situation?",
                new String[]{
                        "He agreed to marry Ruth",
                        "He refused to redeem the property",
                        "He left Bethlehem",
                        "He became angry with Naomi"
                },
                1
        ));

        questions.add(new Question(
                "Whom did Boaz marry?",
                new String[]{
                        "Naomi",
                        "Orpah",
                        "Ruth",
                        "Deborah"
                },
                2
        ));

        questions.add(new Question(
                "What son was born to Ruth and Boaz?",
                new String[]{
                        "Obed",
                        "Jesse",
                        "David",
                        "Mahlon"
                },
                0
        ));

        questions.add(new Question(
                "Who was Obed's son?",
                new String[]{
                        "Solomon",
                        "Jesse",
                        "David",
                        "Saul"
                },
                1
        ));

        questions.add(new Question(
                "Who was Jesse's famous son?",
                new String[]{
                        "Samuel",
                        "Jonathan",
                        "David",
                        "Solomon"
                },
                2
        ));

        questions.add(new Question(
                "Ruth was originally from which people?",
                new String[]{
                        "Moab",
                        "Egypt",
                        "Philistia",
                        "Edom"
                },
                0
        ));

        questions.add(new Question(
                "What was Naomi's husband's name?",
                new String[]{
                        "Boaz",
                        "Elimelech",
                        "Obed",
                        "Jesse"
                },
                1
        ));

        questions.add(new Question(
                "What was the name of Ruth's sister-in-law who returned to Moab?",
                new String[]{
                        "Orpah",
                        "Hannah",
                        "Tamar",
                        "Leah"
                },
                0
        ));

        questions.add(new Question(
                "What role did Boaz have in relation to Naomi's family?",
                new String[]{
                        "He was a priest",
                        "He was a king",
                        "He was a near relative and redeemer",
                        "He was a judge"
                },
                2
        ));

        questions.add(new Question(
                "Ruth became an ancestor of which famous king of Israel?",
                new String[]{
                        "Saul",
                        "David",
                        "Solomon",
                        "Hezekiah"
                },
                1
        ));

    }
        }
        if (book.equals("1 Samuel")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who was the mother of Samuel?",
                new String[]{
                        "Hannah",
                        "Deborah",
                        "Ruth",
                        "Abigail"
                },
                0
        ));

        questions.add(new Question(
                "What did Hannah pray to God for?",
                new String[]{
                        "A new house",
                        "A son",
                        "A kingdom",
                        "A victory in battle"
                },
                1
        ));

        questions.add(new Question(
                "Who was the priest serving at the tabernacle when Hannah prayed?",
                new String[]{
                        "Eli",
                        "Samuel",
                        "Aaron",
                        "Phinehas"
                },
                0
        ));

        questions.add(new Question(
                "What did Hannah promise to do if God gave her a son?",
                new String[]{
                        "Make him a king",
                        "Send him to Egypt",
                        "Give him to the LORD for his whole life",
                        "Make him a soldier"
                },
                2
        ));

        questions.add(new Question(
                "What was Hannah's son's name?",
                new String[]{
                        "Samuel",
                        "Saul",
                        "Jonathan",
                        "David"
                },
                0
        ));

        questions.add(new Question(
                "Who called Samuel during the night?",
                new String[]{
                        "Saul",
                        "Eli",
                        "David",
                        "Jonathan"
                },
                1
        ));

        questions.add(new Question(
                "What did Samuel eventually understand when he heard the voice calling him?",
                new String[]{
                        "It was Eli",
                        "It was Saul",
                        "The LORD was calling him",
                        "It was his mother"
                },
                2
        ));

        questions.add(new Question(
                "What did Samuel say when the LORD called him?",
                new String[]{
                        "Speak, LORD, for your servant hears",
                        "I am ready to fight",
                        "Send me to Egypt",
                        "Here is the king"
                },
                0
        ));

        questions.add(new Question(
                "What sacred object did Israel take into battle against the Philistines?",
                new String[]{
                        "The bronze serpent",
                        "The ark of the covenant",
                        "The golden calf",
                        "Moses' staff"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the ark when the Philistines captured it?",
                new String[]{
                        "It was destroyed",
                        "It was hidden by Samuel",
                        "It was taken to the land of the Philistines",
                        "It was returned immediately"
                },
                2
        ));

        questions.add(new Question(
                "What happened to the Philistine god Dagon when the ark was placed beside it?",
                new String[]{
                        "Dagon fell before the ark",
                        "Dagon became larger",
                        "Dagon was moved to Jerusalem",
                        "Dagon was covered with gold"
                },
                0
        ));

        questions.add(new Question(
                "Who was Israel's first king?",
                new String[]{
                        "David",
                        "Saul",
                        "Samuel",
                        "Jonathan"
                },
                1
        ));

        questions.add(new Question(
                "Which tribe was Saul from?",
                new String[]{
                        "Judah",
                        "Levi",
                        "Benjamin",
                        "Ephraim"
                },
                2
        ));

        questions.add(new Question(
                "What was Saul doing when Samuel first anointed him as king?",
                new String[]{
                        "Looking for his father's lost donkeys",
                        "Fighting the Philistines",
                        "Building an altar",
                        "Gathering grain"
                },
                0
        ));

        questions.add(new Question(
                "Who was Saul's son and David's close friend?",
                new String[]{
                        "Ish-bosheth",
                        "Jonathan",
                        "Abner",
                        "Eliab"
                },
                1
        ));

        questions.add(new Question(
                "What did David use to defeat Goliath?",
                new String[]{
                        "A sword",
                        "A spear",
                        "A sling and a stone",
                        "A bow and arrows"
                },
                2
        ));

        questions.add(new Question(
                "Who was Goliath?",
                new String[]{
                        "A Philistine warrior",
                        "An Israelite priest",
                        "A king of Moab",
                        "A judge of Israel"
                },
                0
        ));

        questions.add(new Question(
                "How many stones did David take from the brook before facing Goliath?",
                new String[]{
                        "One",
                        "Five",
                        "Ten",
                        "Twelve"
                },
                1
        ));

        questions.add(new Question(
                "What did David cut off after defeating Goliath?",
                new String[]{
                        "His shield",
                        "His hand",
                        "His head",
                        "His robe"
                },
                2
        ));

        questions.add(new Question(
                "Why did Saul become jealous of David?",
                new String[]{
                        "People praised David's victories",
                        "David became a priest",
                        "David left Israel",
                        "David refused to fight"
                },
                0
        ));

        questions.add(new Question(
                "What did Saul throw at David when he tried to kill him?",
                new String[]{
                        "A spear",
                        "A sword",
                        "A stone",
                        "A staff"
                },
                0
        ));

        questions.add(new Question(
                "Who helped David escape from Saul by warning him of Saul's plans?",
                new String[]{
                        "Jonathan",
                        "Goliath",
                        "Eli",
                        "Abner"
                },
                0
        ));

        questions.add(new Question(
                "What did David do when he found Saul sleeping in the cave?",
                new String[]{
                        "He killed Saul",
                        "He took Saul's kingdom",
                        "He spared Saul's life",
                        "He captured Saul"
                },
                2
        ));

        questions.add(new Question(
                "What did Samuel use to anoint David?",
                new String[]{
                        "A horn of oil",
                        "A golden cup",
                        "A bronze bowl",
                        "A jar of water"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Saul and Jonathan near the end of 1 Samuel?",
                new String[]{
                        "They became priests",
                        "They died in battle",
                        "They moved to Moab",
                        "They crowned David"
                },
                1
        ));

    }
        }
        if (book.equals("2 Samuel")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who became king of Judah after Saul died?",
                new String[]{
                        "David",
                        "Jonathan",
                        "Abner",
                        "Ish-bosheth"
                },
                0
        ));

        questions.add(new Question(
                "Over which tribe was David first made king?",
                new String[]{
                        "Benjamin",
                        "Judah",
                        "Levi",
                        "Ephraim"
                },
                1
        ));

        questions.add(new Question(
                "How long did David reign in Hebron over Judah?",
                new String[]{
                        "Three years",
                        "Seven years",
                        "Seven years and six months",
                        "Forty years"
                },
                2
        ));

        questions.add(new Question(
                "Where was David eventually made king over all Israel?",
                new String[]{
                        "Jerusalem",
                        "Hebron",
                        "Bethlehem",
                        "Gibeon"
                },
                0
        ));

        questions.add(new Question(
                "What city did David capture and make his capital?",
                new String[]{
                        "Jericho",
                        "Jerusalem",
                        "Samaria",
                        "Gaza"
                },
                1
        ));

        questions.add(new Question(
                "What sacred object did David bring to Jerusalem?",
                new String[]{
                        "The ark of the covenant",
                        "The bronze serpent",
                        "Moses' staff",
                        "The tablets of stone"
                },
                0
        ));

        questions.add(new Question(
                "How did David celebrate when the ark was brought to Jerusalem?",
                new String[]{
                        "He remained silent",
                        "He danced before the LORD",
                        "He left the city",
                        "He built a new palace"
                },
                1
        ));

        questions.add(new Question(
                "Who touched the ark and died?",
                new String[]{
                        "Uzzah",
                        "Joab",
                        "Abner",
                        "Nathan"
                },
                0
        ));

        questions.add(new Question(
                "Who was the prophet who told David about God's covenant with him?",
                new String[]{
                        "Samuel",
                        "Nathan",
                        "Elijah",
                        "Gad"
                },
                1
        ));

        questions.add(new Question(
                "What did David want to build for the LORD?",
                new String[]{
                        "A palace",
                        "A city wall",
                        "A temple",
                        "A new army camp"
                },
                2
        ));

        questions.add(new Question(
                "Who did David show kindness to because of his friendship with Jonathan?",
                new String[]{
                        "Mephibosheth",
                        "Absalom",
                        "Amnon",
                        "Adonijah"
                },
                0
        ));

        questions.add(new Question(
                "What was special about Mephibosheth?",
                new String[]{
                        "He was a priest",
                        "He was Jonathan's son and was lame in his feet",
                        "He was a Philistine king",
                        "He was David's brother"
                },
                1
        ));

        questions.add(new Question(
                "Who was the wife of Uriah whom David took?",
                new String[]{
                        "Bathsheba",
                        "Abigail",
                        "Michal",
                        "Tamar"
                },
                0
        ));

        questions.add(new Question(
                "What was Uriah's occupation?",
                new String[]{
                        "Priest",
                        "Prophet",
                        "Soldier",
                        "Farmer"
                },
                2
        ));

        questions.add(new Question(
                "What did David arrange concerning Uriah?",
                new String[]{
                        "He sent him to Egypt",
                        "He placed him in the most dangerous part of the battle",
                        "He made him king",
                        "He sent him to Bethlehem"
                },
                1
        ));

        questions.add(new Question(
                "Who confronted David about his sin involving Bathsheba and Uriah?",
                new String[]{
                        "Nathan the prophet",
                        "Samuel",
                        "Joab",
                        "Abner"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the child born to David and Bathsheba?",
                new String[]{
                        "He became king",
                        "He became a priest",
                        "He died",
                        "He became a soldier"
                },
                2
        ));

        questions.add(new Question(
                "What son of David rebelled against him?",
                new String[]{
                        "Solomon",
                        "Absalom",
                        "Jonathan",
                        "Mephibosheth"
                },
                1
        ));

        questions.add(new Question(
                "What was notable about Absalom's hair?",
                new String[]{
                        "He shaved it every year",
                        "It was very long and heavy",
                        "It was completely white",
                        "He wore a crown in it"
                },
                1
        ));

        questions.add(new Question(
                "Who was David's military commander during Absalom's rebellion?",
                new String[]{
                        "Joab",
                        "Nathan",
                        "Zadok",
                        "Abiathar"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Absalom during the battle?",
                new String[]{
                        "He escaped to Egypt",
                        "His hair became caught in a tree",
                        "He became king",
                        "He surrendered to David"
                },
                1
        ));

        questions.add(new Question(
                "Who killed Absalom?",
                new String[]{
                        "David",
                        "Joab",
                        "Abner",
                        "Mephibosheth"
                },
                1
        ));

        questions.add(new Question(
                "How did David react when he heard that Absalom had died?",
                new String[]{
                        "He celebrated",
                        "He became angry with Israel",
                        "He mourned deeply",
                        "He immediately left Jerusalem"
                },
                2
        ));

        questions.add(new Question(
                "How many years did David reign as king in total?",
                new String[]{
                        "20 years",
                        "30 years",
                        "40 years",
                        "70 years"
                },
                2
        ));

        questions.add(new Question(
                "Where was David buried?",
                new String[]{
                        "Jerusalem",
                        "Bethlehem",
                        "Hebron",
                        "Gibeah"
                },
                0
        ));

    }
            }
        if (book.equals("1 Kings")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who became king of Israel after David?",
                new String[]{
                        "Solomon",
                        "Absalom",
                        "Adonijah",
                        "Rehoboam"
                },
                0
        ));

        questions.add(new Question(
                "What did Solomon ask God for?",
                new String[]{
                        "Long life",
                        "An understanding heart to judge the people",
                        "Great wealth",
                        "A large army"
                },
                1
        ));

        questions.add(new Question(
                "Where did Solomon receive God's appearance and offer?",
                new String[]{
                        "Gibeon",
                        "Jerusalem",
                        "Bethlehem",
                        "Hebron"
                },
                0
        ));

        questions.add(new Question(
                "What did Solomon build for the LORD in Jerusalem?",
                new String[]{
                        "A palace",
                        "A fortress",
                        "The temple",
                        "A city wall"
                },
                2
        ));

        questions.add(new Question(
                "Who visited Solomon to test his wisdom?",
                new String[]{
                        "The queen of Sheba",
                        "The queen of Egypt",
                        "The queen of Moab",
                        "The queen of Tyre"
                },
                0
        ));

        questions.add(new Question(
                "What was Solomon especially famous for?",
                new String[]{
                        "His military strength",
                        "His wisdom",
                        "His ability to fight giants",
                        "His farming"
                },
                1
        ));

        questions.add(new Question(
                "What did Solomon's temple contain in the Most Holy Place?",
                new String[]{
                        "The ark of the covenant",
                        "David's sword",
                        "A golden throne",
                        "Moses' staff"
                },
                0
        ));

        questions.add(new Question(
                "Who became king of Israel after Solomon?",
                new String[]{
                        "Jeroboam",
                        "Rehoboam",
                        "Ahab",
                        "Jehoshaphat"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the kingdom after Solomon's death?",
                new String[]{
                        "It was united forever",
                        "It was divided into two kingdoms",
                        "It was conquered by Egypt",
                        "It disappeared completely"
                },
                1
        ));

        questions.add(new Question(
                "Who became king over the northern kingdom of Israel?",
                new String[]{
                        "Jeroboam",
                        "Rehoboam",
                        "Solomon",
                        "David"
                },
                0
        ));

        questions.add(new Question(
                "Who remained king over Judah?",
                new String[]{
                        "Jeroboam",
                        "Rehoboam",
                        "Ahab",
                        "Omri"
                },
                1
        ));

        questions.add(new Question(
                "What did Jeroboam set up at Bethel and Dan?",
                new String[]{
                        "Altars to the LORD",
                        "Golden calves",
                        "Stone memorials",
                        "Cities of refuge"
                },
                1
        ));

        questions.add(new Question(
                "Who was the prophet who confronted King Ahab?",
                new String[]{
                        "Elijah",
                        "Samuel",
                        "Nathan",
                        "Elisha"
                },
                0
        ));

        questions.add(new Question(
                "Who was Ahab's wife?",
                new String[]{
                        "Bathsheba",
                        "Jezebel",
                        "Ruth",
                        "Abigail"
                },
                1
        ));

        questions.add(new Question(
                "What did Elijah announce would happen because of Israel's sin?",
                new String[]{
                        "There would be no rain for a period of time",
                        "Jerusalem would fall immediately",
                        "Israel would leave Canaan",
                        "The temple would be destroyed"
                },
                0
        ));

        questions.add(new Question(
                "Where did Elijah stay during part of the drought?",
                new String[]{
                        "By the brook Cherith",
                        "In Jerusalem",
                        "At Mount Sinai",
                        "In Bethlehem"
                },
                0
        ));

        questions.add(new Question(
                "Who provided food for Elijah at the brook?",
                new String[]{
                        "Priests",
                        "Ravens",
                        "Soldiers",
                        "Shepherds"
                },
                1
        ));

        questions.add(new Question(
                "What did Elijah ask the widow of Zarephath to make first?",
                new String[]{
                        "A loaf of bread",
                        "A new garment",
                        "A sacrifice at Jerusalem",
                        "A tent"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the widow's son?",
                new String[]{
                        "He became king",
                        "He died and Elijah prayed for him",
                        "He became a prophet",
                        "He went to Egypt"
                },
                1
        ));

        questions.add(new Question(
                "Where did Elijah challenge the prophets of Baal?",
                new String[]{
                        "Mount Carmel",
                        "Mount Sinai",
                        "Mount Nebo",
                        "Mount Zion"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Elijah's sacrifice on Mount Carmel?",
                new String[]{
                        "It was consumed by fire from the LORD",
                        "It was destroyed by rain",
                        "It disappeared",
                        "The priests of Baal took it"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the prophets of Baal after the contest?",
                new String[]{
                        "They became priests",
                        "They were executed",
                        "They fled to Egypt",
                        "They joined Elijah"
                },
                1
        ));

        questions.add(new Question(
                "What did Elijah hear after the strong wind, earthquake, and fire?",
                new String[]{
                        "A loud trumpet",
                        "A still small voice",
                        "A battle cry",
                        "A great shout"
                },
                1
        ));

        questions.add(new Question(
                "Who was the man who owned the vineyard Ahab wanted?",
                new String[]{
                        "Naboth",
                        "Obadiah",
                        "Ben-Hadad",
                        "Micaiah"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Ahab near the end of 1 Kings?",
                new String[]{
                        "He became a priest",
                        "He died in battle",
                        "He moved to Judah",
                        "He surrendered his kingdom"
                },
                1
        ));

    }
        }
    if (book.equals("2 Kings")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who succeeded Elijah as a prophet?",
                new String[]{
                        "Elisha",
                        "Isaiah",
                        "Jeremiah",
                        "Samuel"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Elijah at the end of his ministry?",
                new String[]{
                        "He died in Jerusalem",
                        "He was taken up into heaven",
                        "He became king",
                        "He moved to Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What did Elisha ask Elijah for before Elijah was taken away?",
                new String[]{
                        "His sword",
                        "A new house",
                        "A double portion of his spirit",
                        "His wealth"
                },
                2
        ));

        questions.add(new Question(
                "What did Elisha use to heal the waters at Jericho?",
                new String[]{
                        "Oil",
                        "Flour",
                        "Blood",
                        "Salt"
                },
                3
        ));

        questions.add(new Question(
                "Who was the commander of the Syrian army who had leprosy?",
                new String[]{
                        "Ben-Hadad",
                        "Naaman",
                        "Jehu",
                        "Hazael"
                },
                1
        ));

        questions.add(new Question(
                "What did Elisha tell Naaman to do to be healed?",
                new String[]{
                        "Wash seven times in the Jordan",
                        "Offer a bull",
                        "Fast for seven days",
                        "Go to Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "What happened when Naaman obeyed Elisha?",
                new String[]{
                        "He became king",
                        "He received a new army",
                        "His leprosy was healed",
                        "He returned immediately to Syria"
                },
                2
        ));

        questions.add(new Question(
                "What did Gehazi do after Naaman was healed?",
                new String[]{
                        "He returned to Syria",
                        "He asked Naaman for gifts",
                        "He became a prophet",
                        "He built an altar"
                },
                1
        ));

        questions.add(new Question(
                "What happened to Gehazi because of his greed?",
                new String[]{
                        "He became king",
                        "He lost his house",
                        "He was sent to Egypt",
                        "He received leprosy"
                },
                3
        ));

        questions.add(new Question(
                "What floated after Elisha threw a stick into the water?",
                new String[]{
                        "A sword",
                        "A stone",
                        "An axe head",
                        "A shield"
                },
                2
        ));

        questions.add(new Question(
                "What did Elisha's servant see when God opened his eyes?",
                new String[]{
                        "Horses and chariots of fire",
                        "The walls of Jericho",
                        "A large Egyptian army",
                        "A cloud of ravens"
                },
                0
        ));

        questions.add(new Question(
                "Who was the wicked queen who opposed God's prophets?",
                new String[]{
                        "Athaliah",
                        "Jezebel",
                        "Maacah",
                        "Bathsheba"
                },
                1
        ));

        questions.add(new Question(
                "Who became king of Israel after Joram?",
                new String[]{
                        "Ahab",
                        "Ahaziah",
                        "Jehu",
                        "Jeroboam"
                },
                2
        ));

        questions.add(new Question(
                "What happened to Jezebel?",
                new String[]{
                        "She became a prophet",
                        "She escaped to Egypt",
                        "She became queen of Judah",
                        "She was killed after being thrown from a window"
                },
                3
        ));

        questions.add(new Question(
                "Which kingdom was conquered by Assyria?",
                new String[]{
                        "The kingdom of Judah",
                        "The northern kingdom of Israel",
                        "The kingdom of Edom",
                        "The kingdom of Moab"
                },
                1
        ));

        questions.add(new Question(
                "Which king of Judah repaired the temple and found the Book of the Law?",
                new String[]{
                        "Josiah",
                        "Hezekiah",
                        "Manasseh",
                        "Uzziah"
                },
                0
        ));

        questions.add(new Question(
                "Which king of Judah trusted God during the Assyrian threat?",
                new String[]{
                        "Ahaz",
                        "Manasseh",
                        "Jehoiakim",
                        "Hezekiah"
                },
                3
        ));

        questions.add(new Question(
                "What did Hezekiah show the Babylonian visitors?",
                new String[]{
                        "His army",
                        "The ark of the covenant",
                        "The treasures of his kingdom",
                        "The temple priests"
                },
                2
        ));

        questions.add(new Question(
                "Who was the wicked king who followed Hezekiah?",
                new String[]{
                        "Josiah",
                        "Amon",
                        "Jehoahaz",
                        "Manasseh"
                },
                3
        ));

        questions.add(new Question(
                "What did Josiah do when he heard the words of the Book of the Law?",
                new String[]{
                        "He tore his clothes",
                        "He left Jerusalem",
                        "He built a palace",
                        "He became king"
                },
                0
        ));

        questions.add(new Question(
                "What did Josiah remove from Judah?",
                new String[]{
                        "The temple",
                        "The priests",
                        "Idols and false worship",
                        "The city walls"
                },
                2
        ));

        questions.add(new Question(
                "Which empire eventually conquered Jerusalem?",
                new String[]{
                        "Egypt",
                        "Assyria",
                        "Philistia",
                        "Babylon"
                },
                3
        ));

        questions.add(new Question(
                "What happened to the temple in Jerusalem after Babylon conquered the city?",
                new String[]{
                        "It was destroyed",
                        "It was expanded",
                        "It became a palace",
                        "It was moved to Babylon"
                },
                0
        ));

        questions.add(new Question(
                "Who was the last king of Judah before Jerusalem was destroyed?",
                new String[]{
                        "Josiah",
                        "Zedekiah",
                        "Hezekiah",
                        "Jehoiakim"
                },
                1
        ));

        questions.add(new Question(
                "Where were many people of Judah taken after Jerusalem was conquered?",
                new String[]{
                        "Egypt",
                        "Moab",
                        "Babylon",
                        "Philistia"
                },
                2
        ));

    }
    }
        if (book.equals("1 Chronicles")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "What is the main focus of the early chapters of 1 Chronicles?",
                new String[]{
                        "Genealogies",
                        "The life of Elijah",
                        "The exile in Babylon",
                        "The ministry of Jesus"
                },
                0
        ));

        questions.add(new Question(
                "Who was the first man listed in the genealogies?",
                new String[]{
                        "Noah",
                        "Abraham",
                        "Adam",
                        "David"
                },
                2
        ));

        questions.add(new Question(
                "Which of Noah's sons was an ancestor in the line leading to Abraham?",
                new String[]{
                        "Ham",
                        "Shem",
                        "Japheth",
                        "Canaan"
                },
                1
        ));

        questions.add(new Question(
                "Who was the father of Isaac?",
                new String[]{
                        "Jacob",
                        "Esau",
                        "Ishmael",
                        "Abraham"
                },
                3
        ));

        questions.add(new Question(
                "Who was the father of the twelve tribes of Israel?",
                new String[]{
                        "Isaac",
                        "Jacob",
                        "Joseph",
                        "Moses"
                },
                1
        ));

        questions.add(new Question(
                "Which tribe was David from?",
                new String[]{
                        "Judah",
                        "Levi",
                        "Benjamin",
                        "Ephraim"
                },
                0
        ));

        questions.add(new Question(
                "Who became king over all Israel?",
                new String[]{
                        "Saul",
                        "Samuel",
                        "David",
                        "Solomon"
                },
                2
        ));

        questions.add(new Question(
                "Which city did David capture and make his royal city?",
                new String[]{
                        "Hebron",
                        "Jericho",
                        "Bethel",
                        "Jerusalem"
                },
                3
        ));

        questions.add(new Question(
                "What did David want to bring to Jerusalem?",
                new String[]{
                        "The ark of God",
                        "Moses' staff",
                        "The golden calf",
                        "The bronze serpent"
                },
                0
        ));

        questions.add(new Question(
                "What happened when Uzza reached out to steady the ark?",
                new String[]{
                        "He became a priest",
                        "He moved the ark successfully",
                        "He was struck down",
                        "He became king"
                },
                2
        ));

        questions.add(new Question(
                "Where was the ark kept after the first attempt to bring it to Jerusalem?",
                new String[]{
                        "The house of Jesse",
                        "The house of Obed-edom",
                        "The temple",
                        "The house of Nathan"
                },
                1
        ));

        questions.add(new Question(
                "How long did the ark remain in the house of Obed-edom?",
                new String[]{
                        "One month",
                        "Six months",
                        "One year",
                        "Three months"
                },
                3
        ));

        questions.add(new Question(
                "What happened to Obed-edom's household while the ark was there?",
                new String[]{
                        "They became soldiers",
                        "They left Jerusalem",
                        "They were blessed",
                        "They were punished"
                },
                2
        ));

        questions.add(new Question(
                "Who was David's commander of the army?",
                new String[]{
                        "Joab",
                        "Abner",
                        "Jonathan",
                        "Benaiah"
                },
                0
        ));

        questions.add(new Question(
                "How did David and Israel celebrate when the ark was successfully brought to Jerusalem?",
                new String[]{
                        "They remained silent",
                        "They fled the city",
                        "They mourned",
                        "They celebrated with singing and music"
                },
                3
        ));

        questions.add(new Question(
                "Who wanted to build a house for the LORD?",
                new String[]{
                        "Saul",
                        "David",
                        "Samuel",
                        "Joab"
                },
                1
        ));

        questions.add(new Question(
                "Which prophet gave David God's message about the future temple?",
                new String[]{
                        "Gad",
                        "Samuel",
                        "Nathan",
                        "Elijah"
                },
                2
        ));

        questions.add(new Question(
                "Who was chosen to build the temple?",
                new String[]{
                        "Solomon",
                        "Absalom",
                        "Adonijah",
                        "Amnon"
                },
                0
        ));

        questions.add(new Question(
                "What did David prepare for the future temple?",
                new String[]{
                        "Only soldiers",
                        "A new palace",
                        "Foreign armies",
                        "Materials and plans"
                },
                3
        ));

        questions.add(new Question(
                "Which tribe was set apart for service in the tabernacle and temple?",
                new String[]{
                        "Judah",
                        "Levi",
                        "Benjamin",
                        "Dan"
                },
                1
        ));

        questions.add(new Question(
                "What did David tell Solomon to do?",
                new String[]{
                        "Seek the LORD and keep His commandments",
                        "Conquer Egypt",
                        "Build a large army",
                        "Return to Hebron"
                },
                0
        ));

        questions.add(new Question(
                "What did David give Solomon concerning the temple?",
                new String[]{
                        "A foreign army",
                        "A golden calf",
                        "Plans and instructions",
                        "A new kingdom"
                },
                2
        ));

        questions.add(new Question(
                "Who succeeded David as king?",
                new String[]{
                        "Rehoboam",
                        "Absalom",
                        "Adonijah",
                        "Solomon"
                },
                3
        ));

        questions.add(new Question(
                "What did David do when he gathered the leaders of Israel near the end of his life?",
                new String[]{
                        "He encouraged them to remain faithful to God",
                        "He told them to leave Jerusalem",
                        "He ordered them to destroy the temple",
                        "He sent them to Egypt"
                },
                0
        ));

        questions.add(new Question(
                "What did David praise God for when he prayed before the assembly?",
                new String[]{
                        "His military victories only",
                        "God's greatness, power, and glory",
                        "His palace",
                        "His wealth"
                },
                1
        ));

    }
}
        if (book.equals("2 Chronicles")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who became king after David?",
                new String[]{
                        "Solomon",
                        "Rehoboam",
                        "Jeroboam",
                        "Abijah"
                },
                0
        ));

        questions.add(new Question(
                "Where did Solomon go to offer sacrifices at the beginning of his reign?",
                new String[]{
                        "Jerusalem",
                        "Hebron",
                        "Gibeon",
                        "Bethel"
                },
                2
        ));

        questions.add(new Question(
                "What did Solomon ask God for?",
                new String[]{
                        "Great wealth",
                        "Wisdom and knowledge",
                        "A large army",
                        "Long life"
                },
                1
        ));

        questions.add(new Question(
                "What major building did Solomon construct?",
                new String[]{
                        "A fortress",
                        "A palace for David",
                        "A city wall",
                        "The temple of the LORD"
                },
                3
        ));

        questions.add(new Question(
                "What happened when Solomon finished dedicating the temple?",
                new String[]{
                        "The kingdom was divided",
                        "The army arrived",
                        "Fire came down from heaven",
                        "The temple was destroyed"
                },
                2
        ));

        questions.add(new Question(
                "What filled the temple when God's glory appeared?",
                new String[]{
                        "The glory of the LORD",
                        "Smoke from a battle",
                        "Rain",
                        "Dust"
                },
                0
        ));

        questions.add(new Question(
                "What did Solomon pray for the people during the temple dedication?",
                new String[]{
                        "That they would become wealthy",
                        "That they would conquer Egypt",
                        "That they would never leave Jerusalem",
                        "That God would hear and forgive them"
                },
                3
        ));

        questions.add(new Question(
                "Who became king after Solomon?",
                new String[]{
                        "Jeroboam",
                        "Rehoboam",
                        "Abijah",
                        "Asa"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the kingdom during Rehoboam's reign?",
                new String[]{
                        "It was attacked by Egypt",
                        "It became larger",
                        "It was united with Syria",
                        "It was divided"
                },
                3
        ));

        questions.add(new Question(
                "Which Egyptian king attacked Jerusalem during Rehoboam's reign?",
                new String[]{
                        "Shishak",
                        "Pharaoh Neco",
                        "Nabopolassar",
                        "Ben-Hadad"
                },
                0
        ));

        questions.add(new Question(
                "Which king of Judah followed Rehoboam?",
                new String[]{
                        "Jehoshaphat",
                        "Abijah",
                        "Asa",
                        "Uzziah"
                },
                1
        ));

        questions.add(new Question(
                "What did King Asa remove from Judah?",
                new String[]{
                        "The temple",
                        "The priests",
                        "Idols and foreign altars",
                        "The city walls"
                },
                2
        ));

        questions.add(new Question(
                "What did Asa rely on when an Ethiopian army came against Judah?",
                new String[]{
                        "The LORD",
                        "Egypt",
                        "Syria",
                        "Philistia"
                },
                0
        ));

        questions.add(new Question(
                "Which king of Judah became known for seeking God and teaching the people God's law?",
                new String[]{
                        "Manasseh",
                        "Jehoshaphat",
                        "Ahaz",
                        "Jehoiakim"
                },
                1
        ));

        questions.add(new Question(
                "What did Jehoshaphat do when Judah faced a great enemy army?",
                new String[]{
                        "He fled Jerusalem",
                        "He asked Egypt for help",
                        "He sought the LORD",
                        "He surrendered immediately"
                },
                2
        ));

        questions.add(new Question(
                "What did the people of Judah do when Jehoshaphat's army faced the enemy?",
                new String[]{
                        "They praised the LORD",
                        "They abandoned the city",
                        "They built a fortress",
                        "They returned to Egypt"
                },
                0
        ));

        questions.add(new Question(
                "Which king of Judah became known for his great wealth and military strength?",
                new String[]{
                        "Uzziah",
                        "Joash",
                        "Hezekiah",
                        "Josiah"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Uzziah when he became proud and tried to burn incense in the temple?",
                new String[]{
                        "He became a priest",
                        "He was made king of Israel",
                        "He was struck with leprosy",
                        "He was sent to Egypt"
                },
                2
        ));

        questions.add(new Question(
                "Which king repaired the temple after it had been neglected?",
                new String[]{
                        "Joash",
                        "Ahaz",
                        "Manasseh",
                        "Zedekiah"
                },
                0
        ));

        questions.add(new Question(
                "Which king led major religious reforms and restored proper worship?",
                new String[]{
                        "Ahaz",
                        "Hezekiah",
                        "Jehoiakim",
                        "Amon"
                },
                1
        ));

        questions.add(new Question(
                "What did Hezekiah do with the bronze serpent that had become an object of worship?",
                new String[]{
                        "He moved it into the temple",
                        "He gave it to the priests",
                        "He destroyed it",
                        "He sent it to Egypt"
                },
                2
        ));

        questions.add(new Question(
                "Which king found the Book of the Law and led major reforms?",
                new String[]{
                        "Josiah",
                        "Manasseh",
                        "Ahaz",
                        "Amon"
                },
                0
        ));

        questions.add(new Question(
                "What did Josiah do when he heard the words of the Law?",
                new String[]{
                        "He built a palace",
                        "He tore his clothes",
                        "He fled Jerusalem",
                        "He made a treaty with Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What major event did Josiah restore in Judah?",
                new String[]{
                        "The building of Solomon's palace",
                        "The conquest of Egypt",
                        "The Passover",
                        "The rebuilding of Jericho"
                },
                2
        ));

        questions.add(new Question(
                "Who eventually conquered Jerusalem and destroyed the temple?",
                new String[]{
                        "Egypt",
                        "Assyria",
                        "Philistia",
                        "Babylon"
                },
                3
        ));

    }
    }
        if (book.equals("Ezra")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Which king allowed the Jews to return to Jerusalem and rebuild the temple?",
                new String[]{
                        "Cyrus",
                        "Darius",
                        "Nebuchadnezzar",
                        "Artaxerxes"
                },
                0
        ));

        questions.add(new Question(
                "Why were the Jews returning to Jerusalem?",
                new String[]{
                        "To build an army",
                        "To rebuild the temple",
                        "To conquer Babylon",
                        "To become merchants"
                },
                1
        ));

        questions.add(new Question(
                "Who led the first group of exiles back to Jerusalem?",
                new String[]{
                        "Ezra",
                        "Nehemiah",
                        "Zerubbabel",
                        "Mordecai"
                },
                2
        ));

        questions.add(new Question(
                "Who served as high priest during the rebuilding of the temple?",
                new String[]{
                        "Ezra",
                        "Haggai",
                        "Joshua",
                        "Zechariah"
                },
                2
        ));

        questions.add(new Question(
                "What did the people do when the foundation of the temple was laid?",
                new String[]{
                        "They shouted and praised the LORD",
                        "They stopped the work",
                        "They returned to Babylon",
                        "They built a palace"
                },
                0
        ));

        questions.add(new Question(
                "Who opposed the rebuilding of the temple?",
                new String[]{
                        "The priests",
                        "The surrounding peoples",
                        "The Levites",
                        "The returning Jews"
                },
                1
        ));

        questions.add(new Question(
                "Which prophets encouraged the Jews to continue rebuilding?",
                new String[]{
                        "Isaiah and Jeremiah",
                        "Elijah and Elisha",
                        "Nathan and Gad",
                        "Haggai and Zechariah"
                },
                3
        ));

        questions.add(new Question(
                "Who ordered that the records be searched to confirm Cyrus's decree?",
                new String[]{
                        "Darius",
                        "Cyrus",
                        "Artaxerxes",
                        "Ahasuerus"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the temple after the work was completed?",
                new String[]{
                        "It was abandoned",
                        "It was dedicated",
                        "It was destroyed",
                        "It became a palace"
                },
                1
        ));

        questions.add(new Question(
                "What feast did the returned Jews celebrate after the temple was completed?",
                new String[]{
                        "Passover",
                        "Purim",
                        "Pentecost",
                        "Day of Atonement"
                },
                0
        ));

        questions.add(new Question(
                "Who was Ezra?",
                new String[]{
                        "A soldier",
                        "A priest and skilled scribe",
                        "A king",
                        "A governor"
                },
                1
        ));

        questions.add(new Question(
                "What did Ezra set his heart to study and teach?",
                new String[]{
                        "Military strategy",
                        "Persian law",
                        "The Law of the LORD",
                        "Egyptian history"
                },
                2
        ));

        questions.add(new Question(
                "What did Ezra confess on behalf of the people?",
                new String[]{
                        "Their sins",
                        "Their lack of money",
                        "Their military weakness",
                        "Their lack of land"
                },
                0
        ));

        questions.add(new Question(
                "What problem did Ezra discover among some of the returned people?",
                new String[]{
                        "They had stopped farming",
                        "They had destroyed the temple",
                        "They had left Jerusalem",
                        "They had married people from surrounding nations"
                },
                3
        ));

        questions.add(new Question(
                "How did Ezra respond when he learned about the people's sin?",
                new String[]{
                        "He prayed and confessed before God",
                        "He left Jerusalem",
                        "He became king",
                        "He ordered the temple destroyed"
                },
                0
        ));

        questions.add(new Question(
                "What did Ezra teach the people?",
                new String[]{
                        "The laws of Persia",
                        "The Law of Moses",
                        "Military strategy",
                        "The history of Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What did the people promise after hearing Ezra?",
                new String[]{
                        "To return to Babylon",
                        "To stop worshipping God",
                        "To separate themselves from sinful practices",
                        "To build a palace"
                },
                2
        ));

        questions.add(new Question(
                "What was rebuilt first in Jerusalem before the temple was completed?",
                new String[]{
                        "The altar",
                        "The palace",
                        "The city wall",
                        "The king's house"
                },
                0
        ));

        questions.add(new Question(
                "What did the priests and Levites do after the temple was completed?",
                new String[]{
                        "They became soldiers",
                        "They abandoned Jerusalem",
                        "They returned to Babylon",
                        "They were organized for worship"
                },
                3
        ));

        questions.add(new Question(
                "Why did the people rejoice when the temple was completed?",
                new String[]{
                        "Because the LORD had helped them",
                        "Because Persia had become weak",
                        "Because they had gained wealth",
                        "Because they had conquered another nation"
                },
                0
        ));

        questions.add(new Question(
                "From which empire did Ezra travel to Jerusalem?",
                new String[]{
                        "Egypt",
                        "Persia",
                        "Assyria",
                        "Philistia"
                },
                1
        ));

        questions.add(new Question(
                "What did Ezra carry with him to Jerusalem?",
                new String[]{
                        "The law of God",
                        "A large army",
                        "A royal crown",
                        "David's weapons"
                },
                0
        ));

        questions.add(new Question(
                "Who gave Ezra authority to teach God's law?",
                new String[]{
                        "King Saul",
                        "King David",
                        "King Artaxerxes",
                        "King Hezekiah"
                },
                2
        ));

        questions.add(new Question(
                "What was one major purpose of Ezra's ministry?",
                new String[]{
                        "To become king",
                        "To conquer Persia",
                        "To rebuild Babylon",
                        "To teach God's law and restore obedience"
                },
                3
        ));

        questions.add(new Question(
                "What did the people do after the temple was dedicated?",
                new String[]{
                        "They offered sacrifices and celebrated",
                        "They returned immediately to Babylon",
                        "They abandoned Jerusalem",
                        "They stopped worshipping God"
                },
                0
        ));

    }
            }
        if (book.equals("Nehemiah")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "What was Nehemiah's position in the Persian king's court?",
                new String[]{
                        "Cupbearer",
                        "General",
                        "Priest",
                        "Scribe"
                },
                0
        ));

        questions.add(new Question(
                "Which king did Nehemiah serve?",
                new String[]{
                        "Cyrus",
                        "Artaxerxes",
                        "Darius",
                        "Nebuchadnezzar"
                },
                1
        ));

        questions.add(new Question(
                "What news about Jerusalem caused Nehemiah to weep?",
                new String[]{
                        "The temple had been moved",
                        "The people had become wealthy",
                        "The walls were broken down and the gates burned",
                        "The king had left Persia"
                },
                2
        ));

        questions.add(new Question(
                "What did Nehemiah do after hearing the news?",
                new String[]{
                        "He went to war",
                        "He returned to Egypt",
                        "He became king",
                        "He prayed and fasted"
                },
                3
        ));

        questions.add(new Question(
                "What did Nehemiah ask the king for?",
                new String[]{
                        "Permission to rebuild Jerusalem",
                        "A new army",
                        "A new throne",
                        "More land in Persia"
                },
                0
        ));

        questions.add(new Question(
                "What did Nehemiah inspect secretly at night?",
                new String[]{
                        "The temple treasures",
                        "The walls of Jerusalem",
                        "The king's army",
                        "The city of Babylon"
                },
                1
        ));

        questions.add(new Question(
                "Who mocked Nehemiah and the Jews?",
                new String[]{
                        "Cyrus and Darius",
                        "Ezra and Joshua",
                        "Haggai and Zechariah",
                        "Sanballat and Tobiah"
                },
                3
        ));

        questions.add(new Question(
                "What did the people rebuild?",
                new String[]{
                        "The temple only",
                        "The walls of Jerusalem",
                        "The palace",
                        "The king's throne"
                },
                1
        ));

        questions.add(new Question(
                "How did the workers protect themselves from enemies?",
                new String[]{
                        "They carried weapons while building",
                        "They left Jerusalem",
                        "They asked Egypt for soldiers",
                        "They stopped rebuilding"
                },
                0
        ));

        questions.add(new Question(
                "What did Nehemiah tell the people when they were afraid?",
                new String[]{
                        "Return to Persia",
                        "Stop building",
                        "Remember the LORD and fight for your families",
                        "Hide in the temple"
                },
                2
        ));

        questions.add(new Question(
                "What problem did Nehemiah address among some wealthy Jews?",
                new String[]{
                        "They were charging excessive interest and exploiting the poor",
                        "They refused to build the walls",
                        "They destroyed the temple",
                        "They left Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "What did Nehemiah refuse to do when enemies tried to lure him away?",
                new String[]{
                        "Pray",
                        "Leave the work",
                        "Speak to the people",
                        "Enter Jerusalem"
                },
                1
        ));

        questions.add(new Question(
                "What did Sanballat accuse Nehemiah of planning?",
                new String[]{
                        "Destroying the temple",
                        "Stealing the Law",
                        "Rebellion against the king",
                        "Leaving Jerusalem"
                },
                2
        ));

        questions.add(new Question(
                "How long did it take to rebuild Jerusalem's wall?",
                new String[]{
                        "70 days",
                        "40 days",
                        "120 days",
                        "52 days"
                },
                3
        ));

        questions.add(new Question(
                "What happened when the enemies heard the wall was completed?",
                new String[]{
                        "They were afraid",
                        "They became kings",
                        "They destroyed the wall",
                        "They entered the temple"
                },
                0
        ));

        questions.add(new Question(
                "Who read the Book of the Law to the people?",
                new String[]{
                        "Nehemiah",
                        "Ezra",
                        "Sanballat",
                        "Tobiah"
                },
                1
        ));

        questions.add(new Question(
                "Where did Ezra read the Law to the people?",
                new String[]{
                        "Inside Babylon",
                        "At the king's palace",
                        "Before the Water Gate",
                        "On Mount Sinai"
                },
                2
        ));

        questions.add(new Question(
                "What did the people do when they understood the Law?",
                new String[]{
                        "They went to war",
                        "They left Jerusalem",
                        "They built a palace",
                        "They wept"
                },
                3
        ));

        questions.add(new Question(
                "What did the leaders tell the people to do instead of weeping?",
                new String[]{
                        "Celebrate and rejoice",
                        "Leave Jerusalem",
                        "Fast for forty days",
                        "Stop reading the Law"
                },
                0
        ));

        questions.add(new Question(
                "What feast did the people celebrate after hearing the Law?",
                new String[]{
                        "Passover",
                        "The Feast of Tabernacles",
                        "Purim",
                        "Pentecost"
                },
                1
        ));

        questions.add(new Question(
                "What did the people confess during their national prayer?",
                new String[]{
                        "Their military victories",
                        "Their wealth",
                        "Their sins and the sins of their ancestors",
                        "Their success in Persia"
                },
                2
        ));

        questions.add(new Question(
                "What did the people make with God?",
                new String[]{
                        "A military alliance",
                        "A trade agreement",
                        "A royal treaty",
                        "A covenant"
                },
                3
        ));

        questions.add(new Question(
                "What did Nehemiah do when he discovered people violating the Sabbath?",
                new String[]{
                        "He confronted them and ordered the gates closed",
                        "He left Jerusalem",
                        "He became king",
                        "He destroyed the temple"
                },
                0
        ));

        questions.add(new Question(
                "What did Nehemiah want the people to remember?",
                new String[]{
                        "To become wealthy",
                        "To remain faithful to God",
                        "To conquer Persia",
                        "To leave Jerusalem"
                },
                1
        ));

        questions.add(new Question(
                "What was one major result of Nehemiah's leadership?",
                new String[]{
                        "Israel conquered Egypt",
                        "Persia was destroyed",
                        "Jerusalem's walls were rebuilt",
                        "The temple was moved"
                },
                2
        ));

    }
}
        if (book.equals("Esther")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who was the king during the time of Esther?",
                new String[]{
                        "Ahasuerus",
                        "Darius",
                        "Cyrus",
                        "Nebuchadnezzar"
                },
                0
        ));

        questions.add(new Question(
                "What was the name of Esther's cousin who raised her?",
                new String[]{
                        "Haman",
                        "Mordecai",
                        "Hathach",
                        "Memucan"
                },
                1
        ));

        questions.add(new Question(
                "What was Esther's Hebrew name?",
                new String[]{
                        "Hadassah",
                        "Hannah",
                        "Deborah",
                        "Miriam"
                },
                0
        ));

        questions.add(new Question(
                "Why was Queen Vashti removed from her position?",
                new String[]{
                        "She left the kingdom",
                        "She refused to attend the king's banquet",
                        "She betrayed the king",
                        "She refused to pay taxes"
                },
                1
        ));

        questions.add(new Question(
                "Who became queen after Vashti?",
                new String[]{
                        "Ruth",
                        "Deborah",
                        "Esther",
                        "Hannah"
                },
                2
        ));

        questions.add(new Question(
                "What did Esther initially keep secret?",
                new String[]{
                        "Her age",
                        "Her family wealth",
                        "Her Jewish identity",
                        "Her royal position"
                },
                2
        ));

        questions.add(new Question(
                "Who was the enemy of the Jews in Esther?",
                new String[]{
                        "Haman",
                        "Sanballat",
                        "Goliath",
                        "Pharaoh"
                },
                0
        ));

        questions.add(new Question(
                "What position did Haman hold?",
                new String[]{
                        "High priest",
                        "Governor",
                        "King",
                        "A high position under the king"
                },
                3
        ));

        questions.add(new Question(
                "Why did Haman become angry with Mordecai?",
                new String[]{
                        "Mordecai would not bow to him",
                        "Mordecai stole his property",
                        "Mordecai attacked his family",
                        "Mordecai refused to work for him"
                },
                0
        ));

        questions.add(new Question(
                "What did Haman plan against the Jews?",
                new String[]{
                        "To enslave them",
                        "To drive them out of Persia",
                        "To destroy them",
                        "To imprison their leaders"
                },
                2
        ));

        questions.add(new Question(
                "What did Esther ask the Jews to do before she approached the king?",
                new String[]{
                        "Build an altar",
                        "Fast for three days",
                        "Leave the city",
                        "Prepare an army"
                },
                1
        ));

        questions.add(new Question(
                "What did Esther risk by approaching the king without being summoned?",
                new String[]{
                        "Her crown only",
                        "Her wealth",
                        "Her life",
                        "Her family"
                },
                2
        ));

        questions.add(new Question(
                "What did the king extend toward Esther?",
                new String[]{
                        "His sword",
                        "His golden scepter",
                        "His crown",
                        "His robe"
                },
                1
        ));

        questions.add(new Question(
                "How many banquets did Esther prepare for the king and Haman before revealing Haman's plan?",
                new String[]{
                        "One",
                        "Two",
                        "Three",
                        "Four"
                },
                1
        ));

        questions.add(new Question(
                "What did Haman prepare for Mordecai?",
                new String[]{
                        "A prison",
                        "A throne",
                        "A large banquet",
                        "A gallows"
                },
                3
        ));

        questions.add(new Question(
                "What happened to Haman's plan after the king learned what he had done?",
                new String[]{
                        "Haman was honored",
                        "Haman was sent away",
                        "Haman was executed",
                        "Haman became king"
                },
                2
        ));

        questions.add(new Question(
                "Who was honored instead of Haman?",
                new String[]{
                        "Mordecai",
                        "Hathach",
                        "Memucan",
                        "Bigthan"
                },
                0
        ));

        questions.add(new Question(
                "What did the king give Mordecai?",
                new String[]{
                        "Haman's house and position",
                        "The temple",
                        "The kingdom",
                        "A priestly robe"
                },
                0
        ));

        questions.add(new Question(
                "What did Esther ask the king to do concerning the Jews?",
                new String[]{
                        "Allow them to leave Persia",
                        "Protect them from destruction",
                        "Make them soldiers",
                        "Give them land in Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What was the result when the Jews defended themselves?",
                new String[]{
                        "They were defeated",
                        "They escaped to Egypt",
                        "They defeated those who attacked them",
                        "They surrendered"
                },
                2
        ));

        questions.add(new Question(
                "What feast was established to remember the Jews' deliverance?",
                new String[]{
                        "Passover",
                        "Pentecost",
                        "Purim",
                        "Tabernacles"
                },
                2
        ));

        questions.add(new Question(
                "Who was Mordecai's cousin?",
                new String[]{
                        "Esther",
                        "Vashti",
                        "Zeresh",
                        "Hannah"
                },
                0
        ));

        questions.add(new Question(
                "What was Esther's position among the Persian people?",
                new String[]{
                        "Prophetess",
                        "Queen",
                        "Priestess",
                        "Governor"
                },
                1
        ));

        questions.add(new Question(
                "What happened to Mordecai after Haman was removed?",
                new String[]{
                        "He became a prisoner",
                        "He left Persia",
                        "He was given authority in the kingdom",
                        "He became a priest"
                },
                2
        ));

        questions.add(new Question(
                "What is the major theme of Esther?",
                new String[]{
                        "Israel's journey through the wilderness",
                        "The rebuilding of the temple",
                        "The creation of the world",
                        "Deliverance of the Jewish people"
                },
                3
        ));

    }
        }
        if (book.equals("Job")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who was Job?",
                new String[]{
                        "A wealthy and upright man",
                        "A king of Israel",
                        "A priest in Jerusalem",
                        "A military commander"
                },
                0
        ));

        questions.add(new Question(
                "Where did Job live?",
                new String[]{
                        "Jerusalem",
                        "Egypt",
                        "The land of Uz",
                        "Moab"
                },
                2
        ));

        questions.add(new Question(
                "How is Job described at the beginning of the book?",
                new String[]{
                        "As a mighty warrior",
                        "As blameless and upright",
                        "As a king",
                        "As a prophet"
                },
                1
        ));

        questions.add(new Question(
                "How many sons did Job have?",
                new String[]{
                        "Five",
                        "Seven",
                        "Ten",
                        "Twelve"
                },
                2
        ));

        questions.add(new Question(
                "How many daughters did Job have?",
                new String[]{
                        "Two",
                        "Three",
                        "Four",
                        "Seven"
                },
                1
        ));

        questions.add(new Question(
                "What did Job regularly do for his children?",
                new String[]{
                        "Prayed and offered sacrifices for them",
                        "Trained them for battle",
                        "Sent them away",
                        "Made them servants"
                },
                0
        ));

        questions.add(new Question(
                "What happened to Job's possessions?",
                new String[]{
                        "They were greatly increased",
                        "He gave them to the king",
                        "He sold them",
                        "They were stolen and destroyed"
                },
                3
        ));

        questions.add(new Question(
                "What happened to Job's children?",
                new String[]{
                        "They moved away",
                        "They became rulers",
                        "They all died",
                        "They became soldiers"
                },
                2
        ));

        questions.add(new Question(
                "What physical suffering came upon Job?",
                new String[]{
                        "Boils",
                        "Blindness",
                        "A broken leg",
                        "Deafness"
                },
                0
        ));

        questions.add(new Question(
                "Who was Job's wife?",
                new String[]{
                        "Naomi",
                        "Sarah",
                        "Esther",
                        "The book does not give her name"
                },
                3
        ));

        questions.add(new Question(
                "How did Job respond when he lost his possessions and children?",
                new String[]{
                        "He immediately left his home",
                        "He worshipped God",
                        "He cursed God",
                        "He became king"
                },
                1
        ));

        questions.add(new Question(
                "Who came to comfort Job?",
                new String[]{
                        "Two priests",
                        "Seven kings",
                        "Three friends",
                        "Twelve apostles"
                },
                2
        ));

        questions.add(new Question(
                "Which of these was one of Job's friends?",
                new String[]{
                        "Joshua",
                        "Eliphaz",
                        "Samuel",
                        "Nathan"
                },
                1
        ));

        questions.add(new Question(
                "Which friend spoke to Job after Eliphaz?",
                new String[]{
                        "Bildad",
                        "Moses",
                        "David",
                        "Isaiah"
                },
                0
        ));

        questions.add(new Question(
                "Which friend was also among those who spoke to Job?",
                new String[]{
                        "Caleb",
                        "Aaron",
                        "Zophar",
                        "Jeremiah"
                },
                2
        ));

        questions.add(new Question(
                "What did Job's friends often believe about his suffering?",
                new String[]{
                        "He was becoming king",
                        "He was being punished for wrongdoing",
                        "He had become a prophet",
                        "He was moving to Egypt"
                },
                1
        ));

        questions.add(new Question(
                "What did Job question during his suffering?",
                new String[]{
                        "Why Israel had a king",
                        "Why Jerusalem was rebuilt",
                        "Why Egypt had no rain",
                        "Why he had been born and why he was suffering"
                },
                3
        ));

        questions.add(new Question(
                "Who eventually spoke to Job from a whirlwind?",
                new String[]{
                        "An angel",
                        "Moses",
                        "The LORD",
                        "Elijah"
                },
                2
        ));

        questions.add(new Question(
                "What did God question Job about?",
                new String[]{
                        "His knowledge of creation and God's works",
                        "His military strength",
                        "His wealth",
                        "His family history"
                },
                0
        ));

        questions.add(new Question(
                "What did Job say after God spoke to him?",
                new String[]{
                        "He became king",
                        "He repented in dust and ashes",
                        "He left Uz",
                        "He challenged his friends"
                },
                1
        ));

        questions.add(new Question(
                "What did God say about Job to his friends?",
                new String[]{
                        "Job had become a king",
                        "Job had been a priest",
                        "Job had spoken what was right",
                        "Job had never suffered"
                },
                2
        ));

        questions.add(new Question(
                "What did God command Job's friends to offer?",
                new String[]{
                        "A golden crown",
                        "A new temple",
                        "A military sacrifice",
                        "A burnt offering"
                },
                3
        ));

        questions.add(new Question(
                "What happened to Job after his trial?",
                new String[]{
                        "God restored and blessed him",
                        "He lost everything permanently",
                        "He became king of Israel",
                        "He moved to Egypt"
                },
                0
        ));

        questions.add(new Question(
                "How many children did Job have after his restoration?",
                new String[]{
                        "Five",
                        "Seven",
                        "Ten",
                        "Twelve"
                },
                2
        ));

        questions.add(new Question(
                "What is one major lesson from Job?",
                new String[]{
                        "Wealth guarantees happiness",
                        "Friends are always correct",
                        "Trust God even during suffering and uncertainty",
                        "Suffering always means a person has sinned"
                },
                2
        ));

    }
}
        if (book.equals("Psalms")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "How many Psalms are in the Book of Psalms?",
                new String[]{
                        "50",
                        "100",
                        "150",
                        "200"
                },
                2
        ));

        questions.add(new Question(
                "Who is named as the author of many Psalms?",
                new String[]{
                        "David",
                        "Moses",
                        "Solomon",
                        "Isaiah"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 23 begins with which famous statement?",
                new String[]{
                        "The LORD is my light",
                        "Blessed is the man",
                        "God is our refuge",
                        "The LORD is my shepherd"
                },
                3
        ));

        questions.add(new Question(
                "According to Psalm 23, what does the LORD make the psalmist lie down in?",
                new String[]{
                        "Green pastures",
                        "A strong city",
                        "A wilderness",
                        "A royal palace"
                },
                0
        ));

        questions.add(new Question(
                "According to Psalm 23, beside what does the LORD lead the psalmist?",
                new String[]{
                        "The sea",
                        "Still waters",
                        "The Jordan",
                        "The river of life"
                },
                1
        ));

        questions.add(new Question(
                "Psalm 1 compares the righteous person to what?",
                new String[]{
                        "A strong tower",
                        "A mighty lion",
                        "A tree planted by rivers of water",
                        "A burning lamp"
                },
                2
        ));

        questions.add(new Question(
                "According to Psalm 1, what happens to the wicked?",
                new String[]{
                        "They become kings",
                        "They prosper forever",
                        "They become priests",
                        "They are like chaff driven by the wind"
                },
                3
        ));

        questions.add(new Question(
                "Psalm 27 says, 'The LORD is my light and my ____.'",
                new String[]{
                        "salvation",
                        "shepherd",
                        "strength",
                        "refuge"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 46 describes God as our refuge and what?",
                new String[]{
                        "King",
                        "Strength",
                        "Shepherd",
                        "Judge"
                },
                1
        ));

        questions.add(new Question(
                "Psalm 51 is strongly associated with David's repentance after his sin involving whom?",
                new String[]{
                        "Bathsheba",
                        "Ruth",
                        "Abigail",
                        "Miriam"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 51 asks God to create in David what kind of heart?",
                new String[]{
                        "A wise heart",
                        "A clean heart",
                        "A strong heart",
                        "A joyful heart"
                },
                1
        ));

        questions.add(new Question(
                "Psalm 91 speaks about dwelling in the secret place of whom?",
                new String[]{
                        "The Almighty",
                        "The king",
                        "The priest",
                        "The prophet"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 100 calls people to serve the LORD with what?",
                new String[]{
                        "Fear",
                        "Silence",
                        "Gladness",
                        "Wealth"
                },
                2
        ));

        questions.add(new Question(
                "Psalm 103 tells God's people not to forget all His what?",
                new String[]{
                        "Commandments",
                        "Benefits",
                        "Prophets",
                        "Battles"
                },
                1
        ));

        questions.add(new Question(
                "Psalm 119 is especially focused on what?",
                new String[]{
                        "The temple",
                        "The kings of Israel",
                        "God's word and law",
                        "The creation of the world"
                },
                2
        ));

        questions.add(new Question(
                "Psalm 119 says God's word is a lamp to what?",
                new String[]{
                        "My feet",
                        "My house",
                        "My heart",
                        "My nation"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 121 says the psalmist's help comes from whom?",
                new String[]{
                        "The mountains",
                        "The LORD",
                        "The king",
                        "The priests"
                },
                1
        ));

        questions.add(new Question(
                "According to Psalm 121, the LORD neither slumbers nor what?",
                new String[]{
                        "Sleeps",
                        "Speaks",
                        "Works",
                        "Travels"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 133 describes how good and pleasant it is for what to dwell together in unity?",
                new String[]{
                        "Kings",
                        "Priests",
                        "Brothers",
                        "Nations"
                },
                2
        ));

        questions.add(new Question(
                "Psalm 136 repeatedly emphasizes that God's mercy endures how long?",
                new String[]{
                        "Forever",
                        "For a generation",
                        "For a thousand years",
                        "Until judgment"
                },
                0
        ));

        questions.add(new Question(
                "Psalm 139 says God knows when the psalmist sits down and when he does what?",
                new String[]{
                        "Prays",
                        "Rises up",
                        "Sleeps",
                        "Travels"
                },
                1
        ));

        questions.add(new Question(
                "Psalm 150 begins by calling people to praise God where?",
                new String[]{
                        "In His sanctuary",
                        "At the city gate",
                        "On Mount Sinai",
                        "In the palace"
                },
                0
        ));

        questions.add(new Question(
                "What instrument is mentioned in Psalm 150?",
                new String[]{
                        "Trumpet",
                        "Flute",
                        "Harp",
                        "All of these"
                },
                3
        ));

        questions.add(new Question(
                "Psalm 150 ends by saying what should praise the LORD?",
                new String[]{
                        "The priests",
                        "Every living thing that has breath",
                        "Only Israel",
                        "The angels alone"
                },
                1
        ));

        questions.add(new Question(
                "Many Psalms are written as prayers, songs, or what?",
                new String[]{
                        "Poems",
                        "Laws",
                        "Genealogies",
                        "Historical records"
                },
                0
        ));

    }
            }
        if (book.equals("Proverbs")) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who is traditionally associated with writing many of the Proverbs?",
                new String[]{
                        "David",
                        "Solomon",
                        "Moses",
                        "Joshua"
                },
                1
        ));

        questions.add(new Question(
                "What is described as the beginning of knowledge?",
                new String[]{
                        "Wisdom",
                        "Understanding",
                        "The fear of the LORD",
                        "Wealth"
                },
                2
        ));

        questions.add(new Question(
                "Proverbs contrasts wisdom with what?",
                new String[]{
                        "Foolishness",
                        "Strength",
                        "Riches",
                        "Kingship"
                },
                0
        ));

        questions.add(new Question(
                "Proverbs 3 tells the reader to trust in the LORD with all their what?",
                new String[]{
                        "Strength",
                        "Heart",
                        "Mind",
                        "Wealth"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs 3 warns against leaning on your own what?",
                new String[]{
                        "Understanding",
                        "Strength",
                        "Wisdom",
                        "Power"
                },
                0
        ));

        questions.add(new Question(
                "Proverbs 3 says to acknowledge God in all your ways, and He will what?",
                new String[]{
                        "Give you riches",
                        "Make you king",
                        "Direct your paths",
                        "Remove every enemy"
                },
                2
        ));

        questions.add(new Question(
                "According to Proverbs, what should a person not withhold from those to whom it is due?",
                new String[]{
                        "Wisdom",
                        "Good",
                        "Food",
                        "Gold"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs teaches that a soft answer turns away what?",
                new String[]{
                        "Fear",
                        "Trouble",
                        "Wrath",
                        "Poverty"
                },
                2
        ));

        questions.add(new Question(
                "What does Proverbs say a merry heart does like a medicine?",
                new String[]{
                        "Good",
                        "Nothing",
                        "Little",
                        "Much"
                },
                0
        ));

        questions.add(new Question(
                "According to Proverbs, pride goes before what?",
                new String[]{
                        "Victory",
                        "Destruction",
                        "Wisdom",
                        "Riches"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs says a haughty spirit comes before what?",
                new String[]{
                        "A fall",
                        "Success",
                        "Honor",
                        "Wisdom"
                },
                0
        ));

        questions.add(new Question(
                "What does Proverbs say is better than great riches?",
                new String[]{
                        "A good name",
                        "A large house",
                        "A strong army",
                        "A powerful position"
                },
                0
        ));

        questions.add(new Question(
                "Proverbs teaches that whoever is slow to anger is better than whom?",
                new String[]{
                        "A wise man",
                        "A mighty man",
                        "A rich man",
                        "A king"
                },
                1
        ));

        questions.add(new Question(
                "According to Proverbs, what does the diligent hand make?",
                new String[]{
                        "Poor",
                        "Rich",
                        "Angry",
                        "Fearful"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs contrasts the diligent with what kind of person?",
                new String[]{
                        "Lazy",
                        "Wise",
                        "Faithful",
                        "Generous"
                },
                0
        ));

        questions.add(new Question(
                "What does Proverbs say about a friend who loves at all times?",
                new String[]{
                        "He is a brother",
                        "He is a king",
                        "He is a stranger",
                        "He is a servant"
                },
                0
        ));

        questions.add(new Question(
                "According to Proverbs, what is more valuable than rubies?",
                new String[]{
                        "Silver",
                        "Wisdom",
                        "Gold",
                        "Land"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs says the fear of the LORD is the beginning of what?",
                new String[]{
                        "Knowledge",
                        "Wealth",
                        "Power",
                        "Victory"
                },
                0
        ));

        questions.add(new Question(
                "What animal does Proverbs use as an example of diligence?",
                new String[]{
                        "Lion",
                        "Horse",
                        "Ant",
                        "Eagle"
                },
                2
        ));

        questions.add(new Question(
                "Proverbs warns that whoever digs a pit may fall into what?",
                new String[]{
                        "The same pit",
                        "A river",
                        "A prison",
                        "A valley"
                },
                0
        ));

        questions.add(new Question(
                "According to Proverbs, what does a faithful witness not do?",
                new String[]{
                        "Speak truth",
                        "Lie",
                        "Help others",
                        "Give advice"
                },
                1
        ));

        questions.add(new Question(
                "Proverbs says a good name is rather to be chosen than what?",
                new String[]{
                        "Great riches",
                        "Wisdom",
                        "Knowledge",
                        "Long life"
                },
                0
        ));

        questions.add(new Question(
                "What does Proverbs say about whoever walks with wise people?",
                new String[]{
                        "They become wealthy",
                        "They become wise",
                        "They become rulers",
                        "They become famous"
                },
                1
        ));

        questions.add(new Question(
                "According to Proverbs, what does a gentle tongue do?",
                new String[]{
                        "Breaks a bone",
                        "Creates wealth",
                        "Is a tree of life",
                        "Makes a person king"
                },
                2
        ));

        questions.add(new Question(
                "What is one major theme of Proverbs?",
                new String[]{
                        "Wisdom for righteous living",
                        "The history of Israel's kings",
                        "The rebuilding of Jerusalem",
                        "The journeys of Paul"
                },
                0
        ));

    }
 }
        questions.add(new Question(
        "Who is traditionally identified as the speaker in Ecclesiastes?",
        new String[]{"David", "Solomon", "Moses", "Isaiah"},
        1));

questions.add(new Question(
        "What does Ecclesiastes repeatedly say about life \"under the sun\"?",
        new String[]{"It is vanity", "It is always easy", "It is without purpose", "It is perfect"},
        0));

questions.add(new Question(
        "What is said to be a time for every purpose under heaven?",
        new String[]{"A season", "A day", "A generation", "An hour"},
        0));

questions.add(new Question(
        "According to Ecclesiastes, there is a time to be born and a time to do what?",
        new String[]{"To sleep", "To die", "To travel", "To rejoice"},
        1));

questions.add(new Question(
        "What does Ecclesiastes say there is a time to plant and a time to do?",
        new String[]{"Gather", "Build", "Uproot", "Celebrate"},
        2));

questions.add(new Question(
        "What is better than two according to Ecclesiastes 4?",
        new String[]{"One", "Three", "Four", "Ten"},
        1));

questions.add(new Question(
        "Why are two better than one?",
        new String[]{"They can help one another", "They become wealthy faster", "They never disagree", "They always travel together"},
        0));

questions.add(new Question(
        "What does a threefold cord say about its strength?",
        new String[]{"It is quickly broken", "It is easily hidden", "It is not quickly broken", "It cannot be tied"},
        2));

questions.add(new Question(
        "What is better than the sacrifice of fools?",
        new String[]{"A large offering", "To draw near to hear", "A long prayer", "A celebration"},
        1));

questions.add(new Question(
        "What does Ecclesiastes advise concerning our words before God?",
        new String[]{"Be quick to speak", "Speak continually", "Be careful and not rash", "Never speak"},
        2));

questions.add(new Question(
        "What should a person do when going into the house of God?",
        new String[]{"Be ready to hear", "Bring many gifts", "Speak loudly", "Avoid listening"},
        0));

questions.add(new Question(
        "What does Ecclesiastes say about the love of money?",
        new String[]{"It satisfies completely", "It is the root of all wisdom", "It is always harmless", "It does not satisfy the one who loves it"},
        3));

questions.add(new Question(
        "What happens to the laborer who works hard according to Ecclesiastes?",
        new String[]{"His sleep is sweet", "He never sleeps", "He becomes king", "He loses his home"},
        0));

questions.add(new Question(
        "What is better than the day of one's birth?",
        new String[]{"The day of one's death", "The day of wealth", "The day of marriage", "The day of victory"},
        0));

questions.add(new Question(
        "According to Ecclesiastes, who is better than a living dog?",
        new String[]{"A strong lion", "A dead lion", "A wise man", "A rich man"},
        1));

questions.add(new Question(
        "What does Ecclesiastes say about wisdom compared with foolishness?",
        new String[]{"Wisdom is better", "They are exactly equal", "Foolishness is always better", "Neither has value"},
        0));

questions.add(new Question(
        "What can make the wise man's heart stronger according to Ecclesiastes?",
        new String[]{"Correction", "Wealth", "Fame", "Sleep"},
        0));

questions.add(new Question(
        "What does Ecclesiastes say about the righteous and the wicked?",
        new String[]{"Only the wicked die", "Only the righteous die", "Both can experience death", "Neither experiences death"},
        2));

questions.add(new Question(
        "What should a person do with the bread they have?",
        new String[]{"Eat it with joy", "Hide it", "Sell it immediately", "Throw it away"},
        0));

questions.add(new Question(
        "What should be done with one's seed according to Ecclesiastes 11?",
        new String[]{"Keep it forever", "Sow it", "Burn it", "Hide it underground"},
        1));

questions.add(new Question(
        "What does Ecclesiastes tell young people to do in their youth?",
        new String[]{"Remember their Creator", "Avoid all joy", "Seek riches first", "Leave their families"},
        0));

questions.add(new Question(
        "What happens to the body when a person dies according to Ecclesiastes?",
        new String[]{"It becomes immortal on earth", "The dust returns to the earth", "It disappears completely", "It becomes stronger"},
        1));

questions.add(new Question(
        "What returns to God who gave it?",
        new String[]{"The silver", "The body", "The spirit", "The wealth"},
        2));

questions.add(new Question(
        "What is the conclusion of the whole matter?",
        new String[]{"Seek wealth and fame", "Fear God and keep His commandments", "Avoid work", "Live only for pleasure"},
        1));
    }
}
        return questions;
}
}
