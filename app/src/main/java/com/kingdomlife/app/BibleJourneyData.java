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

        DataPart1.addQuestions(questions, book, difficulty);
        DataPart2.addQuestions(questions, book, difficulty);
        DataPart3.addQuestions(questions, book, difficulty);
        DataPart4.addQuestions(questions, book, difficulty);
        DataPart5.addQuestions(questions, book, difficulty);
        DataPart6.addQuestions(questions, book, difficulty);
        DataPart7.addQuestions(questions, book, difficulty);
        DataPart8.addQuestions(questions, book, difficulty);

        return questions;
    }

    private static class DataPart1 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Exodus")) {
                addBookExodusQuestions(questions, difficulty);
            }

            else if (book.equals("Leviticus")) {
                addBookLeviticusQuestions(questions, difficulty);
            }

            else if (book.equals("Numbers")) {
                addBookNumbersQuestions(questions, difficulty);
            }

            else if (book.equals("Deuteronomy")) {
                addBookDeuteronomyQuestions(questions, difficulty);
            }

            else if (book.equals("Joshua")) {
                addBookJoshuaQuestions(questions, difficulty);
            }

            else if (book.equals("Judges")) {
                addBookJudgesQuestions(questions, difficulty);
            }

            else if (book.equals("Ruth")) {
                addBookRuthQuestions(questions, difficulty);
            }

        }

        private static void addBookExodusQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookLeviticusQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookNumbersQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookDeuteronomyQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookJoshuaQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookJudgesQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookRuthQuestions(ArrayList<Question> questions, String difficulty) {

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

    }

    private static class DataPart2 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("1 Samuel")) {
                addBook1SamuelQuestions(questions, difficulty);
            }

            else if (book.equals("2 Samuel")) {
                addBook2SamuelQuestions(questions, difficulty);
            }

            else if (book.equals("1 Kings")) {
                addBook1KingsQuestions(questions, difficulty);
            }

            else if (book.equals("2 Kings")) {
                addBook2KingsQuestions(questions, difficulty);
            }

            else if (book.equals("1 Chronicles")) {
                addBook1ChroniclesQuestions(questions, difficulty);
            }

            else if (book.equals("2 Chronicles")) {
                addBook2ChroniclesQuestions(questions, difficulty);
            }

            else if (book.equals("Ezra")) {
                addBookEzraQuestions(questions, difficulty);
            }

        }

        private static void addBook1SamuelQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBook2SamuelQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBook1KingsQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBook2KingsQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBook1ChroniclesQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBook2ChroniclesQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookEzraQuestions(ArrayList<Question> questions, String difficulty) {

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

    }

    private static class DataPart3 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Nehemiah")) {
                addBookNehemiahQuestions(questions, difficulty);
            }

            else if (book.equals("Esther")) {
                addBookEstherQuestions(questions, difficulty);
            }

            else if (book.equals("Job")) {
                addBookJobQuestions(questions, difficulty);
            }

            else if (book.equals("Psalms")) {
                addBookPsalmsQuestions(questions, difficulty);
            }

            else if (book.equals("Proverbs")) {
                addBookProverbsQuestions(questions, difficulty);
            }

            else if (book.equals("Ecclesiastes")) {
                addBookEcclesiastesQuestions(questions, difficulty);
            }

            else if (book.equals("Song of Solomon")) {
                addBookSongofSolomonQuestions(questions, difficulty);
            }

        }

        private static void addBookNehemiahQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookEstherQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookJobQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookPsalmsQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookProverbsQuestions(ArrayList<Question> questions, String difficulty) {

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

        private static void addBookEcclesiastesQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is traditionally identified with the authorship of Ecclesiastes?",
                            new String[]{
                                    "Moses",
                                    "Solomon",
                                    "David",
                                    "Isaiah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What word is repeatedly used to describe life in Ecclesiastes?",
                            new String[]{
                                    "Victory",
                                    "Vanity",
                                    "Wisdom",
                                    "Blessing"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Ecclesiastes says there is a time for every what under heaven?",
                            new String[]{
                                    "Purpose",
                                    "King",
                                    "Nation",
                                    "Treasure"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "There is a time to be born and a time to do what?",
                            new String[]{
                                    "Rejoice",
                                    "Travel",
                                    "Die",
                                    "Build"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "There is a time to plant and a time to do what?",
                            new String[]{
                                    "Uproot",
                                    "Harvest",
                                    "Sleep",
                                    "Celebrate"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "According to Ecclesiastes, what is better than one?",
                            new String[]{
                                    "Ten",
                                    "Two",
                                    "Five",
                                    "Seven"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Why are two better than one?",
                            new String[]{
                                    "They can help each other",
                                    "They become kings",
                                    "They never disagree",
                                    "They always become wealthy"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "A threefold cord is not quickly what?",
                            new String[]{
                                    "Tied",
                                    "Hidden",
                                    "Broken",
                                    "Found"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should a person be ready to do when entering the house of God?",
                            new String[]{
                                    "Speak",
                                    "Hear",
                                    "Sing",
                                    "Run"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say about the laborer's sleep?",
                            new String[]{
                                    "It is sweet",
                                    "It is short",
                                    "It is troubled",
                                    "It is dangerous"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say about the love of money?",
                            new String[]{
                                    "It always brings joy",
                                    "It satisfies everyone",
                                    "It is harmless",
                                    "It does not satisfy the one who loves it"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What is better than the day of one's birth?",
                            new String[]{
                                    "The day of one's death",
                                    "The day of wealth",
                                    "The day of victory",
                                    "The day of marriage"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is better than a living dog according to Ecclesiastes?",
                            new String[]{
                                    "A rich man",
                                    "A dead lion",
                                    "A wise king",
                                    "A strong warrior"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What is better than the sacrifice of fools?",
                            new String[]{
                                    "To draw near to hear",
                                    "A large offering",
                                    "A long prayer",
                                    "A great celebration"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say wisdom is better than?",
                            new String[]{
                                    "Food",
                                    "Strength",
                                    "Foolishness",
                                    "Sleep"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should a person do with the bread they have?",
                            new String[]{
                                    "Hide it",
                                    "Eat it with joy",
                                    "Sell it",
                                    "Throw it away"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should a person do with their seed according to Ecclesiastes 11?",
                            new String[]{
                                    "Sow it",
                                    "Burn it",
                                    "Hide it",
                                    "Sell it"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes tell young people to remember?",
                            new String[]{
                                    "Their riches",
                                    "Their enemies",
                                    "Their Creator",
                                    "Their kings"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What returns to the earth when a person dies?",
                            new String[]{
                                    "The spirit",
                                    "The soul",
                                    "The dust",
                                    "The wisdom"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What returns to God who gave it?",
                            new String[]{
                                    "The spirit",
                                    "The body",
                                    "The silver",
                                    "The wealth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say about everything there is a time for?",
                            new String[]{
                                    "Only work",
                                    "Every purpose",
                                    "Only prayer",
                                    "Only celebration"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say is better than great riches?",
                            new String[]{
                                    "A large house",
                                    "A good name",
                                    "A powerful army",
                                    "A long journey"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What can make a person's sleep sweet?",
                            new String[]{
                                    "Hard work",
                                    "Fame",
                                    "Riches",
                                    "Power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ecclesiastes say happens to both the wise and the foolish?",
                            new String[]{
                                    "Both become kings",
                                    "Both become rich",
                                    "Both eventually die",
                                    "Both become famous"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is the conclusion of the whole matter?",
                            new String[]{
                                    "Seek wealth and fame",
                                    "Fear God and keep His commandments",
                                    "Avoid work",
                                    "Live only for pleasure"
                            },
                            1
                    ));

                }
        }

        private static void addBookSongofSolomonQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "What is another name for the book Song of Solomon?",
                            new String[]{
                                    "Song of Songs",
                                    "Book of Love",
                                    "Song of David",
                                    "The Royal Song"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is named as the author of the Song of Solomon?",
                            new String[]{
                                    "David",
                                    "Moses",
                                    "Solomon",
                                    "Samuel"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is said to be better than wine?",
                            new String[]{
                                    "The beloved's love",
                                    "The king's riches",
                                    "The garden's fruit",
                                    "The singer's wisdom"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How does the beloved describe her appearance?",
                            new String[]{
                                    "White and bright",
                                    "Black but comely",
                                    "Red and golden",
                                    "Purple and white"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Why does the beloved say she is dark?",
                            new String[]{
                                    "She had travelled in the desert",
                                    "She had been in the palace",
                                    "She had been working in the vineyards",
                                    "She had been in the garden"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where does the beloved say her beloved feeds his flock?",
                            new String[]{
                                    "Among the lilies",
                                    "Near the palace",
                                    "Beside the river",
                                    "Under the fig trees"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does the beloved compare her beloved to among the young men?",
                            new String[]{
                                    "A lion",
                                    "An apple tree",
                                    "A cedar tree",
                                    "A mighty river"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where does the beloved say she sat down?",
                            new String[]{
                                    "At the palace gate",
                                    "Among the olive trees",
                                    "Under his shadow",
                                    "Beside the river"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the beloved's beloved bring her?",
                            new String[]{
                                    "A crown",
                                    "A banner of love",
                                    "A golden necklace",
                                    "A basket of bread"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What season is described as having arrived?",
                            new String[]{
                                    "Winter",
                                    "Summer",
                                    "Autumn",
                                    "Spring"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What flowers are mentioned as appearing on the earth?",
                            new String[]{
                                    "Lilies",
                                    "Roses",
                                    "Violets",
                                    "Daffodils"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What small creatures are told to be caught because they spoil the vines?",
                            new String[]{
                                    "Young lions",
                                    "Ravens",
                                    "Little foxes",
                                    "Wild goats"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does the beloved compare her beloved's voice to?",
                            new String[]{
                                    "Thunder",
                                    "The sound of rain",
                                    "A trumpet",
                                    "Music"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the beloved compare her eyes to?",
                            new String[]{
                                    "Stars",
                                    "Doves",
                                    "Lamps",
                                    "Rivers"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the beloved compare her hair to?",
                            new String[]{
                                    "A flock of goats",
                                    "A field of wheat",
                                    "A crown of gold",
                                    "A river of water"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What are the beloved's teeth compared to?",
                            new String[]{
                                    "Pearls",
                                    "Stones",
                                    "Ivory towers",
                                    "A flock of sheep"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What is the beloved's neck compared to?",
                            new String[]{
                                    "A cedar tree",
                                    "The tower of David",
                                    "A silver mountain",
                                    "A golden chain"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the beloved's beloved call her?",
                            new String[]{
                                    "His servant",
                                    "His daughter",
                                    "His sister and spouse",
                                    "His queen alone"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does the beloved say her beloved is among the trees of the wood?",
                            new String[]{
                                    "Like an apple tree",
                                    "Like an olive tree",
                                    "Like a palm tree",
                                    "Like a cedar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does the beloved say about her heart?",
                            new String[]{
                                    "It is filled with fear",
                                    "It is wounded by love",
                                    "It is filled with riches",
                                    "It is hidden from everyone"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the beloved ask her beloved to do until the day breaks?",
                            new String[]{
                                    "Return to the palace",
                                    "Sleep in the city",
                                    "Come quickly to the mountains",
                                    "Gather the harvest"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is compared to a flock of goats in Song of Solomon?",
                            new String[]{
                                    "The beloved's hair",
                                    "The beloved's eyes",
                                    "The beloved's teeth",
                                    "The beloved's hands"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is compared to a flock of sheep that are even shorn?",
                            new String[]{
                                    "Her hair",
                                    "Her teeth",
                                    "Her eyes",
                                    "Her lips"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the beloved say her beloved is altogether?",
                            new String[]{
                                    "Strong",
                                    "Rich",
                                    "Lovely",
                                    "Wise"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Song of Solomon say is as strong as death?",
                            new String[]{
                                    "Wisdom",
                                    "Love",
                                    "Hope",
                                    "Friendship"
                            },
                            1
                    ));

                }
        }

    }

    private static class DataPart4 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Isaiah")) {
                addBookIsaiahQuestions(questions, difficulty);
            }

            else if (book.equals("Jeremiah")) {
                addBookJeremiahQuestions(questions, difficulty);
            }

            else if (book.equals("Lamentations")) {
                addBookLamentationsQuestions(questions, difficulty);
            }

            else if (book.equals("Ezekiel")) {
                addBookEzekielQuestions(questions, difficulty);
            }

            else if (book.equals("Daniel")) {
                addBookDanielQuestions(questions, difficulty);
            }

            else if (book.equals("Hosea")) {
                addBookHoseaQuestions(questions, difficulty);
            }

            else if (book.equals("Joel")) {
                addBookJoelQuestions(questions, difficulty);
            }

        }

        private static void addBookIsaiahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is named as the prophet who received the vision of Isaiah?",
                            new String[]{
                                    "Isaiah the son of Amoz",
                                    "Jeremiah the son of Hilkiah",
                                    "Ezekiel the priest",
                                    "Daniel the prince"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "In the year King Uzziah died, what did Isaiah see?",
                            new String[]{
                                    "A great army",
                                    "The Lord sitting upon a throne",
                                    "A burning city",
                                    "A golden altar"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the seraphim cry to one another?",
                            new String[]{
                                    "Praise the Lord",
                                    "Glory to the King",
                                    "Holy, holy, holy",
                                    "Blessed is His name"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did one of the seraphim use to touch Isaiah's lips?",
                            new String[]{
                                    "A golden branch",
                                    "A burning coal",
                                    "A sword",
                                    "A scroll"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Isaiah say when the Lord asked whom He should send?",
                            new String[]{
                                    "Here am I; send me",
                                    "I will go tomorrow",
                                    "Send another prophet",
                                    "I am not ready"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What sign was given concerning a virgin who would conceive?",
                            new String[]{
                                    "She would have twins",
                                    "She would bear a son",
                                    "She would become queen",
                                    "She would see an angel"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What name is given to the child in Isaiah 7:14?",
                            new String[]{
                                    "Messiah",
                                    "Immanuel",
                                    "Wonderful",
                                    "Counsellor"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "According to Isaiah, what people that walked in darkness saw a great light?",
                            new String[]{
                                    "The people of Israel",
                                    "The people of Judah",
                                    "The people of the land",
                                    "The people that walked in darkness"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What name in Isaiah 9:6 means that the coming child would be a mighty ruler?",
                            new String[]{
                                    "Everlasting Father",
                                    "Prince of Peace",
                                    "The mighty God",
                                    "Wonderful"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What animal is mentioned as dwelling with the lamb in Isaiah's peaceful kingdom?",
                            new String[]{
                                    "Lion",
                                    "Bear",
                                    "Wolf",
                                    "Leopard"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "According to Isaiah, what would the lion eat like the ox?",
                            new String[]{
                                    "Grass",
                                    "Grain",
                                    "Hay",
                                    "Leaves"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Isaiah say will spring up in the wilderness?",
                            new String[]{
                                    "A city",
                                    "Water",
                                    "A palace",
                                    "A great army"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Isaiah say would be made straight?",
                            new String[]{
                                    "The mountains",
                                    "The rivers",
                                    "The highway for our God",
                                    "The walls of Jerusalem"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is compared to grass that withers in Isaiah 40?",
                            new String[]{
                                    "The glory of man",
                                    "The word of God",
                                    "The strength of angels",
                                    "The beauty of Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Isaiah say about the word of our God?",
                            new String[]{
                                    "It changes with time",
                                    "It shall stand for ever",
                                    "It belongs only to kings",
                                    "It will disappear"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Those that wait upon the Lord shall renew what?",
                            new String[]{
                                    "Their wealth",
                                    "Their houses",
                                    "Their strength",
                                    "Their wisdom"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "According to Isaiah 41, God says, 'Fear thou not; for I am with thee.' What does He tell His people not to do?",
                            new String[]{
                                    "Be afraid",
                                    "Leave Jerusalem",
                                    "Build an altar",
                                    "Go to war"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is called God's servant in Isaiah 42?",
                            new String[]{
                                    "Israel",
                                    "David",
                                    "Moses",
                                    "Samuel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Isaiah say God can do with sins that are like scarlet?",
                            new String[]{
                                    "Make them forgotten by men",
                                    "Make them white as snow",
                                    "Hide them in the earth",
                                    "Turn them into gold"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Isaiah 53 say was laid upon the suffering servant?",
                            new String[]{
                                    "The riches of kings",
                                    "The crown of David",
                                    "The iniquity of us all",
                                    "The judgment of angels"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "By whose stripes does Isaiah say we are healed?",
                            new String[]{
                                    "His",
                                    "The priests'",
                                    "The king's",
                                    "The prophets'"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the suffering servant do when he was oppressed and afflicted?",
                            new String[]{
                                    "He fought back",
                                    "He opened not his mouth",
                                    "He called for soldiers",
                                    "He fled to Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Isaiah 55 invite those who are thirsty to do?",
                            new String[]{
                                    "Come to the waters",
                                    "Climb the mountain",
                                    "Build an altar",
                                    "Go into the wilderness"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Isaiah say God's thoughts are compared with man's thoughts?",
                            new String[]{
                                    "They are exactly the same",
                                    "They are lower",
                                    "They are higher",
                                    "They are weaker"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Isaiah 6 record Isaiah saying after seeing the Lord?",
                            new String[]{
                                    "I am a king",
                                    "Woe is me! for I am undone",
                                    "I have no fear",
                                    "I will build a temple"
                            },
                            1
                    ));

                }
        }

        private static void addBookJeremiahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was the father of Jeremiah?",
                            new String[]{
                                    "Hilkiah",
                                    "Amoz",
                                    "Buzi",
                                    "Jesse"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Jeremiah was from which town?",
                            new String[]{
                                    "Bethlehem",
                                    "Anathoth",
                                    "Jericho",
                                    "Hebron"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was Jeremiah called to be?",
                            new String[]{
                                    "A king",
                                    "A priest only",
                                    "A prophet to the nations",
                                    "A military commander"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did God tell Jeremiah before he was born?",
                            new String[]{
                                    "He would become king",
                                    "He was known and sanctified",
                                    "He would build Jerusalem",
                                    "He would become wealthy"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jeremiah say when he felt too young to speak?",
                            new String[]{
                                    "I cannot speak: for I am a child",
                                    "I have no message",
                                    "I am afraid of the king",
                                    "I need more training"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God touch when appointing Jeremiah?",
                            new String[]{
                                    "His eyes",
                                    "His forehead",
                                    "His mouth",
                                    "His hands"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jeremiah see in his first vision?",
                            new String[]{
                                    "A burning bush",
                                    "A rod of an almond tree",
                                    "A ladder",
                                    "A golden lampstand"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jeremiah see in another vision?",
                            new String[]{
                                    "A seething pot facing toward the north",
                                    "A rainbow",
                                    "A giant sword",
                                    "A river of fire"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God say His people had forsaken?",
                            new String[]{
                                    "The temple",
                                    "The living fountain of waters",
                                    "Their land",
                                    "Their king"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What two things had God's people committed according to Jeremiah 2:13?",
                            new String[]{
                                    "They rejected the law and the prophets",
                                    "They forsook the fountain of living waters and made broken cisterns",
                                    "They left Jerusalem and built another city",
                                    "They stopped offering sacrifices and stopped praying"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jeremiah compare Judah's sin to?",
                            new String[]{
                                    "A broken sword",
                                    "A stubborn animal",
                                    "A great storm",
                                    "A false crown"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jeremiah see at the potter's house?",
                            new String[]{
                                    "The potter working on the wheels",
                                    "A golden vessel",
                                    "A burning furnace",
                                    "A broken altar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened to the vessel the potter made?",
                            new String[]{
                                    "It disappeared",
                                    "It became gold",
                                    "It was marred in the potter's hand",
                                    "It was stolen"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jeremiah buy as a sign of restoration?",
                            new String[]{
                                    "A field",
                                    "A house",
                                    "A vineyard",
                                    "A flock of sheep"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jeremiah hide in a clay vessel?",
                            new String[]{
                                    "A scroll",
                                    "A field deed",
                                    "A sword",
                                    "A crown"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jeremiah's cousin Hanameel offer him?",
                            new String[]{
                                    "A priesthood",
                                    "A field in Anathoth",
                                    "A place in the palace",
                                    "A flock"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did God promise to write on the hearts of His people?",
                            new String[]{
                                    "His law",
                                    "Their names",
                                    "Their history",
                                    "Their victories"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What famous promise appears in Jeremiah 29:11?",
                            new String[]{
                                    "God would make them kings",
                                    "God had thoughts of peace toward them",
                                    "God would remove every enemy immediately",
                                    "God would give them riches"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "According to Jeremiah 29:12, what would God's people do when they called upon Him?",
                            new String[]{
                                    "They would find treasure",
                                    "They would be taken to Jerusalem",
                                    "They would pray unto Him",
                                    "They would become rulers"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jeremiah say God's people would do when they searched for Him with all their heart?",
                            new String[]{
                                    "Find Him",
                                    "Become kings",
                                    "Receive gold",
                                    "Leave Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jeremiah put around his neck as commanded by God?",
                            new String[]{
                                    "A golden chain",
                                    "A yoke",
                                    "A priestly robe",
                                    "A crown"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who burned Jeremiah's scroll after hearing its words?",
                            new String[]{
                                    "King Josiah",
                                    "King Zedekiah",
                                    "King Jehoiakim",
                                    "King Hezekiah"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What happened to Jeremiah when he was thrown into the dungeon?",
                            new String[]{
                                    "He escaped immediately",
                                    "He sank in the mire",
                                    "He was taken to Egypt",
                                    "He was crowned king"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who helped rescue Jeremiah from the dungeon?",
                            new String[]{
                                    "Ebed-melech",
                                    "Baruch",
                                    "Gedaliah",
                                    "Hanameel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Jeremiah told to do with the Rechabites?",
                            new String[]{
                                    "Give them land",
                                    "Bring them into the temple and offer them wine",
                                    "Make them soldiers",
                                    "Send them to Egypt"
                            },
                            1
                    ));

                }
        }

        private static void addBookLamentationsQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is traditionally associated with the book of Lamentations?",
                            new String[]{
                                    "Jeremiah",
                                    "Isaiah",
                                    "Ezekiel",
                                    "Daniel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is the main subject of Lamentations?",
                            new String[]{
                                    "The building of the temple",
                                    "The fall and suffering of Jerusalem",
                                    "The life of King David",
                                    "The creation of the world"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How is Jerusalem described at the beginning of Lamentations?",
                            new String[]{
                                    "A joyful city",
                                    "A mighty kingdom",
                                    "A lonely city",
                                    "A prosperous nation"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What has Jerusalem become according to Lamentations 1?",
                            new String[]{
                                    "A widow",
                                    "A queen",
                                    "A fortress",
                                    "A palace"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Why does Jerusalem weep?",
                            new String[]{
                                    "Because there is no rain",
                                    "Because her lovers have forsaken her",
                                    "Because the king has left",
                                    "Because the temple is being rebuilt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What had Jerusalem's enemies done to her sanctuary?",
                            new String[]{
                                    "They protected it",
                                    "They decorated it",
                                    "They entered it",
                                    "They rebuilt it"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Jerusalem remember in her suffering?",
                            new String[]{
                                    "Her former pleasant things",
                                    "Her armies",
                                    "Her future kings",
                                    "Her treasures"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What had Jerusalem's adversaries become?",
                            new String[]{
                                    "Friends",
                                    "The head",
                                    "Priests",
                                    "Servants"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Lamentations say happened because Jerusalem had sinned grievously?",
                            new String[]{
                                    "She became famous",
                                    "She became prosperous",
                                    "She was removed",
                                    "She became a kingdom"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does the writer ask God to look upon?",
                            new String[]{
                                    "His crown",
                                    "His palace",
                                    "His affliction",
                                    "His army"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "In Lamentations 2, what has the Lord cast down from heaven?",
                            new String[]{
                                    "The beauty of Israel",
                                    "The walls of Babylon",
                                    "The throne of Egypt",
                                    "The army of Assyria"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord become like an enemy toward Jerusalem?",
                            new String[]{
                                    "He protected her",
                                    "He swallowed up Israel",
                                    "He crowned her",
                                    "He strengthened her"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the Lord's altar and sanctuary?",
                            new String[]{
                                    "They were enlarged",
                                    "They were hidden",
                                    "They were cast off",
                                    "They were rebuilt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the elders of the daughter of Zion do?",
                            new String[]{
                                    "They sat upon the ground",
                                    "They went to war",
                                    "They built houses",
                                    "They crowned a king"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the children ask their mothers for?",
                            new String[]{
                                    "Gold and silver",
                                    "Bread and wine",
                                    "Corn and wine",
                                    "Clothing and shoes"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Lamentations 3 say about the Lord's compassions?",
                            new String[]{
                                    "They fail completely",
                                    "They are hidden",
                                    "They fail not",
                                    "They belong only to kings"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "They are new every what?",
                            new String[]{
                                    "Morning",
                                    "Year",
                                    "Sabbath",
                                    "Evening"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Lamentations 3 say is great?",
                            new String[]{
                                    "Our strength",
                                    "Thy faithfulness",
                                    "Our riches",
                                    "The army"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the writer say the Lord is unto them that wait for Him?",
                            new String[]{
                                    "A king",
                                    "A warrior",
                                    "Good",
                                    "A judge only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is it good for a man to do?",
                            new String[]{
                                    "To wait quietly for the salvation of the Lord",
                                    "To gather riches",
                                    "To build a palace",
                                    "To flee from Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Lamentations say a person should put his mouth in?",
                            new String[]{
                                    "The dust",
                                    "The water",
                                    "The fire",
                                    "The temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should a person search and turn again unto?",
                            new String[]{
                                    "The king",
                                    "The Lord",
                                    "The temple",
                                    "The army"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Lamentations 4 describe as darker than snow?",
                            new String[]{
                                    "The streets",
                                    "The Nazarites",
                                    "The gates",
                                    "The walls"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Lamentations 5 ask God to remember?",
                            new String[]{
                                    "Their wealth",
                                    "Their enemies",
                                    "What has happened to them",
                                    "Their former kings"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "How does Lamentations end?",
                            new String[]{
                                    "With a request for restoration",
                                    "With a new king",
                                    "With a military victory",
                                    "With the rebuilding of the temple"
                            },
                            0
                    ));

                }
        }

        private static void addBookEzekielQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Where was Ezekiel when he received his visions?",
                            new String[]{
                                    "In Jerusalem",
                                    "By the river Chebar",
                                    "In Bethlehem",
                                    "On Mount Sinai"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was Ezekiel's occupation before becoming a prophet?",
                            new String[]{
                                    "King",
                                    "Soldier",
                                    "Priest",
                                    "Merchant"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Ezekiel see when the heavens were opened?",
                            new String[]{
                                    "Visions of God",
                                    "A great army",
                                    "A burning city",
                                    "The temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What unusual creatures did Ezekiel see in his first vision?",
                            new String[]{
                                    "Serpents",
                                    "Living creatures",
                                    "Lions only",
                                    "Eagles only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many faces did each living creature have?",
                            new String[]{
                                    "Two",
                                    "Three",
                                    "Four",
                                    "Six"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Ezekiel see above the heads of the living creatures?",
                            new String[]{
                                    "A firmament",
                                    "A mountain",
                                    "A golden temple",
                                    "A cloud of smoke"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was above the firmament Ezekiel saw?",
                            new String[]{
                                    "A throne",
                                    "A river",
                                    "A city",
                                    "An altar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God call Ezekiel when sending him to Israel?",
                            new String[]{
                                    "Son of man",
                                    "King of Israel",
                                    "Son of David",
                                    "Servant of Moses"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Ezekiel eat from the scroll God gave him?",
                            new String[]{
                                    "Bread",
                                    "Honey",
                                    "The scroll",
                                    "A piece of fruit"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "How did the scroll taste to Ezekiel?",
                            new String[]{
                                    "As bitter as herbs",
                                    "As sweet as honey",
                                    "As salty as the sea",
                                    "As sour as vinegar"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was Ezekiel appointed to be for the house of Israel?",
                            new String[]{
                                    "A watchman",
                                    "A king",
                                    "A priest",
                                    "A commander"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should a watchman do when he sees the sword coming?",
                            new String[]{
                                    "Hide himself",
                                    "Warn the people",
                                    "Leave the city",
                                    "Call the king"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Ezekiel use to demonstrate the siege of Jerusalem?",
                            new String[]{
                                    "A wooden model",
                                    "A brick",
                                    "A stone altar",
                                    "A golden plate"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the hair Ezekiel was commanded to shave?",
                            new String[]{
                                    "It was divided into portions",
                                    "It was buried in gold",
                                    "It was burned completely",
                                    "It was placed in the temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Ezekiel see in the valley of dry bones?",
                            new String[]{
                                    "A dead army",
                                    "A new temple",
                                    "A great river",
                                    "A living forest"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God ask Ezekiel about the dry bones?",
                            new String[]{
                                    "Can these bones live?",
                                    "Where are these bones from?",
                                    "Who buried these bones?",
                                    "Can these bones speak?"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened when Ezekiel prophesied to the dry bones?",
                            new String[]{
                                    "They disappeared",
                                    "They came together",
                                    "They turned to stone",
                                    "They were buried"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What entered the bodies of the dry bones?",
                            new String[]{
                                    "Water",
                                    "Fire",
                                    "Breath",
                                    "Blood"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the dry bones represent?",
                            new String[]{
                                    "The whole house of Israel",
                                    "The army of Babylon",
                                    "The priests of Jerusalem",
                                    "The kings of Judah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Ezekiel see concerning two sticks?",
                            new String[]{
                                    "They were burned",
                                    "They were joined together",
                                    "They were hidden",
                                    "They were broken"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the two sticks represent?",
                            new String[]{
                                    "Judah and Israel",
                                    "Egypt and Babylon",
                                    "David and Saul",
                                    "Priests and prophets"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God promise to give His people in Ezekiel 36?",
                            new String[]{
                                    "A new heart and a new spirit",
                                    "A new palace",
                                    "A new army",
                                    "A new king immediately"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would God sprinkle upon His people to cleanse them?",
                            new String[]{
                                    "Oil",
                                    "Water",
                                    "Blood",
                                    "Dust"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Ezekiel see flowing from the temple in his later vision?",
                            new String[]{
                                    "A river",
                                    "Fire",
                                    "Oil",
                                    "Wine"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How did the water from the temple affect the Dead Sea?",
                            new String[]{
                                    "It became deeper",
                                    "It became salty",
                                    "It was healed and became fresh",
                                    "It disappeared"
                            },
                            2
                    ));

                }
        }

        private static void addBookDanielQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was taken captive to Babylon with Daniel?",
                            new String[]{
                                    "Jeremiah",
                                    "Ezekiel",
                                    "Hananiah, Mishael, and Azariah",
                                    "Ezra"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What new name was Daniel given in Babylon?",
                            new String[]{
                                    "Belteshazzar",
                                    "Shadrach",
                                    "Meshach",
                                    "Abednego"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Daniel resolve not to do with the king's food?",
                            new String[]{
                                    "Eat it",
                                    "Sell it",
                                    "Share it",
                                    "Cook it"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Daniel request instead of the king's food?",
                            new String[]{
                                    "Bread and honey",
                                    "Vegetables and water",
                                    "Meat and milk",
                                    "Fruit and wine"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How long was Daniel tested with the different diet?",
                            new String[]{
                                    "Seven days",
                                    "Ten days",
                                    "Twenty days",
                                    "Forty days"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Daniel and his friends excel in?",
                            new String[]{
                                    "Wisdom and knowledge",
                                    "Warfare",
                                    "Farming",
                                    "Trade"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Nebuchadnezzar dream about?",
                            new String[]{
                                    "A great river",
                                    "A great image",
                                    "A burning temple",
                                    "A mighty tree only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What material was the head of the great image made of?",
                            new String[]{
                                    "Silver",
                                    "Gold",
                                    "Bronze",
                                    "Iron"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the great image in Nebuchadnezzar's dream?",
                            new String[]{
                                    "It became gold",
                                    "A stone struck it and broke it",
                                    "It walked away",
                                    "It disappeared into water"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Nebuchadnezzar build for people to worship?",
                            new String[]{
                                    "A golden image",
                                    "A silver altar",
                                    "A stone temple",
                                    "A golden throne"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who were thrown into the fiery furnace?",
                            new String[]{
                                    "Daniel, Ezra, and Nehemiah",
                                    "Shadrach, Meshach, and Abednego",
                                    "Peter, James, and John",
                                    "Moses, Aaron, and Hur"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the three men in the fiery furnace?",
                            new String[]{
                                    "They escaped through a door",
                                    "They were unharmed",
                                    "They became invisible",
                                    "They were taken to Jerusalem"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many figures did Nebuchadnezzar see walking in the fire?",
                            new String[]{
                                    "Two",
                                    "Three",
                                    "Four",
                                    "Five"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What happened to Nebuchadnezzar after his pride?",
                            new String[]{
                                    "He became a priest",
                                    "He was driven from men",
                                    "He became richer",
                                    "He left Babylon willingly"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Nebuchadnezzar eat during his humbling?",
                            new String[]{
                                    "Bread",
                                    "Grass",
                                    "Fruit",
                                    "Fish"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who saw the handwriting on the wall?",
                            new String[]{
                                    "Belshazzar",
                                    "Cyrus",
                                    "Darius",
                                    "Nebuchadnezzar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was written on the wall?",
                            new String[]{
                                    "MENE, MENE, TEKEL, UPHARSIN",
                                    "HOLY, HOLY, HOLY",
                                    "KING OF KINGS",
                                    "DANIEL, DANIEL, DANIEL"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Daniel thrown into because he prayed to God?",
                            new String[]{
                                    "A furnace",
                                    "A dungeon",
                                    "A den of lions",
                                    "A prison"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "How often did Daniel pray?",
                            new String[]{
                                    "Once a day",
                                    "Twice a day",
                                    "Three times a day",
                                    "Seven times a day"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Daniel do when he prayed?",
                            new String[]{
                                    "Faced toward Jerusalem",
                                    "Faced toward Babylon",
                                    "Went into the temple",
                                    "Climbed a mountain"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who protected Daniel in the lions' den?",
                            new String[]{
                                    "The king",
                                    "An angel",
                                    "Daniel's friends",
                                    "The priests"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Daniel after spending the night in the lions' den?",
                            new String[]{
                                    "He was unharmed",
                                    "He became king",
                                    "He fled Babylon",
                                    "He was imprisoned again"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Daniel see in a night vision in chapter 7?",
                            new String[]{
                                    "Four great beasts",
                                    "Four rivers",
                                    "Four temples",
                                    "Four kings only"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who came with the clouds of heaven in Daniel's vision?",
                            new String[]{
                                    "A king of Babylon",
                                    "One like the Son of man",
                                    "A mighty angel",
                                    "A priest"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Daniel do when he received understanding of visions?",
                            new String[]{
                                    "He praised God",
                                    "He became angry",
                                    "He left Babylon",
                                    "He hid the visions"
                            },
                            0
                    ));

                }
        }

        private static void addBookHoseaQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was Hosea?",
                            new String[]{
                                    "A prophet",
                                    "A king",
                                    "A priest only",
                                    "A soldier"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was Hosea's father?",
                            new String[]{
                                    "Beeri",
                                    "Amoz",
                                    "Hilkiah",
                                    "Jesse"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God command Hosea to take as his wife?",
                            new String[]{
                                    "A faithful priest's daughter",
                                    "A wife of whoredoms",
                                    "A princess",
                                    "A widow"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was the name of Hosea's first son?",
                            new String[]{
                                    "Lo-ammi",
                                    "Jezreel",
                                    "Lo-ruhamah",
                                    "Ephraim"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the name Jezreel refer to?",
                            new String[]{
                                    "A valley or place",
                                    "A king",
                                    "A priest",
                                    "A mountain"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was the name of Hosea's daughter?",
                            new String[]{
                                    "Gomer",
                                    "Jezreel",
                                    "Lo-ruhamah",
                                    "Ruth"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Lo-ruhamah mean?",
                            new String[]{
                                    "Loved",
                                    "Not beloved",
                                    "God is great",
                                    "Peace"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was the name of Hosea's second son?",
                            new String[]{
                                    "Lo-ammi",
                                    "Jezreel",
                                    "Ephraim",
                                    "Amos"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Lo-ammi mean?",
                            new String[]{
                                    "Not my people",
                                    "My beloved",
                                    "God is with us",
                                    "The Lord saves"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God promise would happen to the children of Israel?",
                            new String[]{
                                    "They would become as the sand of the sea",
                                    "They would disappear",
                                    "They would become Egyptians",
                                    "They would never multiply"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Israel do according to Hosea?",
                            new String[]{
                                    "They were faithful",
                                    "They committed spiritual adultery",
                                    "They rebuilt the temple",
                                    "They left Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Israel forget according to Hosea?",
                            new String[]{
                                    "Her Creator",
                                    "Her enemies",
                                    "Her army",
                                    "Her kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Israel sow according to Hosea 8?",
                            new String[]{
                                    "Wind",
                                    "Rain",
                                    "Peace",
                                    "Wisdom"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would Israel reap after sowing the wind?",
                            new String[]{
                                    "A harvest of grain",
                                    "The whirlwind",
                                    "Peace",
                                    "A new kingdom"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Hosea say God desired rather than sacrifice?",
                            new String[]{
                                    "Mercy",
                                    "Gold",
                                    "Fame",
                                    "Military strength"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God say He desired rather than burnt offerings?",
                            new String[]{
                                    "The knowledge of God",
                                    "More priests",
                                    "More silver",
                                    "A larger temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Israel make according to Hosea 8?",
                            new String[]{
                                    "A golden calf",
                                    "A golden crown",
                                    "A golden temple",
                                    "A golden sword"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Israel do with the calf?",
                            new String[]{
                                    "They worshipped it",
                                    "They destroyed it",
                                    "They sold it",
                                    "They buried it"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Hosea compare Israel to in her unfaithfulness?",
                            new String[]{
                                    "A faithful wife",
                                    "A backsliding heifer",
                                    "A strong lion",
                                    "A fruitful vine"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Hosea say Israel was like?",
                            new String[]{
                                    "A cake not turned",
                                    "A perfect loaf",
                                    "A broken sword",
                                    "A new vessel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Hosea tell Israel to do?",
                            new String[]{
                                    "Return unto the Lord",
                                    "Leave Jerusalem",
                                    "Build an army",
                                    "Seek Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Hosea 14 say Israel should take with them when returning to God?",
                            new String[]{
                                    "Words",
                                    "Gold",
                                    "Weapons",
                                    "Animals"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Hosea say God will heal?",
                            new String[]{
                                    "Their palaces",
                                    "Their backsliding",
                                    "Their armies",
                                    "Their crops"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would Israel's branches spread?",
                            new String[]{
                                    "Their fragrance",
                                    "Their wealth",
                                    "Their armies",
                                    "Their laws"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Hosea ultimately call God's people to do?",
                            new String[]{
                                    "Return to the Lord",
                                    "Become warriors",
                                    "Build another city",
                                    "Seek political power"
                            },
                            0
                    ));

                }
        }

        private static void addBookJoelQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is named as the father of Joel?",
                            new String[]{
                                    "Amoz",
                                    "Pethuel",
                                    "Hilkiah",
                                    "Beeri"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What major disaster is described at the beginning of Joel?",
                            new String[]{
                                    "A great flood",
                                    "A royal rebellion",
                                    "An invasion of locusts",
                                    "A battle at Jerusalem"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the locusts consume?",
                            new String[]{
                                    "The crops and vegetation",
                                    "The walls of Jerusalem",
                                    "The temple vessels",
                                    "The houses of the kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Joel call the people to proclaim?",
                            new String[]{
                                    "A coronation",
                                    "A battle",
                                    "A feast",
                                    "A fast"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "Who were called to sanctify a fast?",
                            new String[]{
                                    "Only the priests",
                                    "Only the king's family",
                                    "The elders and inhabitants of the land",
                                    "Foreign armies"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where did Joel tell the priests to weep?",
                            new String[]{
                                    "Between the porch and the altar",
                                    "At the gates of Jerusalem",
                                    "On Mount Zion",
                                    "Beside the Jordan"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How does Joel describe the Lord?",
                            new String[]{
                                    "Rich in gold",
                                    "Slow to anger and great in mercy",
                                    "A mighty warrior only",
                                    "Hidden from Israel"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did God promise to restore after the locusts had eaten?",
                            new String[]{
                                    "The throne of David",
                                    "The temple vessels",
                                    "The years",
                                    "The land of Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did God promise to pour out upon all flesh?",
                            new String[]{
                                    "Gold",
                                    "Rain",
                                    "His spirit",
                                    "Fire"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who would prophesy according to Joel?",
                            new String[]{
                                    "Kings only",
                                    "Sons and daughters",
                                    "Foreign armies",
                                    "Priests only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would the old men dream?",
                            new String[]{
                                    "Dreams",
                                    "Battles",
                                    "Songs",
                                    "Visions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would the young men see?",
                            new String[]{
                                    "Kings",
                                    "Angels",
                                    "Visions",
                                    "Signs"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would happen to the sun before the great and terrible day of the Lord?",
                            new String[]{
                                    "It would become brighter",
                                    "It would turn blue",
                                    "It would disappear forever",
                                    "It would be turned into darkness"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What would the moon be turned into?",
                            new String[]{
                                    "Silver",
                                    "Blood",
                                    "Fire",
                                    "Darkness"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who shall be delivered according to Joel?",
                            new String[]{
                                    "Whosoever shall call on the name of the Lord",
                                    "Only the kings",
                                    "Only the priests",
                                    "Only the soldiers"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Joel say God would gather the nations into?",
                            new String[]{
                                    "The valley of Hebron",
                                    "The valley of Jehoshaphat",
                                    "The valley of Shiloh",
                                    "The valley of Achor"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Joel tell the nations to beat their plowshares into?",
                            new String[]{
                                    "Crowns",
                                    "Shields",
                                    "Swords",
                                    "Altars"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Joel tell the nations to turn their pruninghooks into?",
                            new String[]{
                                    "Bows",
                                    "Swords",
                                    "Spears",
                                    "Shields"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What is said about the valley of decision?",
                            new String[]{
                                    "It is empty",
                                    "It belongs to Egypt",
                                    "It is in Babylon",
                                    "It is full of people"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What does Joel say shall dwell in Zion?",
                            new String[]{
                                    "The Lord",
                                    "Foreign armies",
                                    "The Egyptians",
                                    "The kings of Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What were the priests told to do besides sanctifying a fast?",
                            new String[]{
                                    "Build an altar",
                                    "Gather the congregation",
                                    "Prepare for battle",
                                    "Leave Jerusalem"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Joel say was cut off from the mouths of the drinkers of wine?",
                            new String[]{
                                    "New wine",
                                    "Bread",
                                    "Water",
                                    "Milk"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Joel say the Lord would cause to come down for His people?",
                            new String[]{
                                    "A crown of gold",
                                    "A new king",
                                    "The former rain and the latter rain",
                                    "The armies of Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would Israel know after God's restoration?",
                            new String[]{
                                    "That their enemies were stronger",
                                    "That Jerusalem was empty",
                                    "That they were warriors",
                                    "That the Lord was in the midst of Israel"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Joel say would happen to the land after God's blessing?",
                            new String[]{
                                    "The land would be barren",
                                    "The floors would be full of wheat",
                                    "The people would leave",
                                    "The temple would disappear"
                            },
                            1
                    ));

                }
        }

    }

    private static class DataPart5 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Amos")) {
                addBookAmosQuestions(questions, difficulty);
            }

            else if (book.equals("Obadiah")) {
                addBookObadiahQuestions(questions, difficulty);
            }

            else if (book.equals("Jonah")) {
                addBookJonahQuestions(questions, difficulty);
            }

            else if (book.equals("Micah")) {
                addBookMicahQuestions(questions, difficulty);
            }

            else if (book.equals("Nahum")) {
                addBookNahumQuestions(questions, difficulty);
            }

            else if (book.equals("Habakkuk")) {
                addBookHabakkukQuestions(questions, difficulty);
            }

            else if (book.equals("Zephaniah")) {
                addBookZephaniahQuestions(questions, difficulty);
            }

        }

        private static void addBookAmosQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Where was Amos from?",
                            new String[]{
                                    "Bethlehem",
                                    "Anathoth",
                                    "Tekoa",
                                    "Jericho"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What was Amos among before becoming known as a prophet?",
                            new String[]{
                                    "The herdmen",
                                    "The priests",
                                    "The soldiers",
                                    "The kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "During whose reign in Judah did Amos prophesy?",
                            new String[]{
                                    "Josiah",
                                    "Uzziah",
                                    "Hezekiah",
                                    "David"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which king of Israel is also mentioned in the introduction to Amos?",
                            new String[]{
                                    "Jeroboam the son of Joash",
                                    "Saul",
                                    "Ahab",
                                    "Jehu"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "From where did the Lord roar according to Amos?",
                            new String[]{
                                    "Samaria",
                                    "Babylon",
                                    "Jerusalem",
                                    "Zion"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What would happen to the habitations of the shepherds?",
                            new String[]{
                                    "They would flourish",
                                    "They would mourn",
                                    "They would become cities",
                                    "They would be rebuilt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would happen to the top of Carmel?",
                            new String[]{
                                    "It would be crowned",
                                    "It would become a city",
                                    "It would wither",
                                    "It would be covered with gold"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Which nation is mentioned first among those judged in Amos?",
                            new String[]{
                                    "Syria",
                                    "Egypt",
                                    "Moab",
                                    "Edom"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Damascus use to thresh Gilead?",
                            new String[]{
                                    "Wooden tools",
                                    "Threshing instruments of iron",
                                    "Swords of gold",
                                    "Stone knives"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Gaza do according to Amos?",
                            new String[]{
                                    "Built the temple",
                                    "Helped Israel",
                                    "Carried away the whole captivity",
                                    "Destroyed Jerusalem"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Whom did Edom pursue with the sword?",
                            new String[]{
                                    "His brother",
                                    "The king of Judah",
                                    "The priests",
                                    "The Philistines"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "For how many transgressions did Amos repeatedly use the phrase 'for three transgressions ... and for four'?",
                            new String[]{
                                    "Only Israel",
                                    "Only Judah",
                                    "Several nations",
                                    "Only Jerusalem"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "For what did Israel sell the righteous?",
                            new String[]{
                                    "A pair of shoes",
                                    "A field",
                                    "A loaf of bread",
                                    "A piece of gold"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Israel trample upon according to Amos?",
                            new String[]{
                                    "The temple",
                                    "The head of the poor",
                                    "The king's crown",
                                    "The walls of Jerusalem"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What kind of famine did Amos say God would send?",
                            new String[]{
                                    "A famine of bread",
                                    "A famine of animals",
                                    "A famine of hearing the words of the Lord",
                                    "A famine of water only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Amos see in one of his visions?",
                            new String[]{
                                    "Locusts",
                                    "A golden crown",
                                    "A river",
                                    "A mountain"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Amos see in another vision?",
                            new String[]{
                                    "A ladder",
                                    "A plumbline",
                                    "A golden altar",
                                    "A chariot"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who told Amos to flee to Judah?",
                            new String[]{
                                    "King Jeroboam",
                                    "Amaziah the priest of Bethel",
                                    "The king of Judah",
                                    "A Levite"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Amos say he was not?",
                            new String[]{
                                    "A king",
                                    "A priest",
                                    "A prophet",
                                    "A soldier"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Amos say he was before the Lord took him?",
                            new String[]{
                                    "A herdman",
                                    "A king",
                                    "A merchant",
                                    "A soldier"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What else did Amos say he did besides being a herdman?",
                            new String[]{
                                    "Gathered sycomore fruit",
                                    "Built houses",
                                    "Worked as a priest",
                                    "Served in the army"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Amos see concerning summer fruit?",
                            new String[]{
                                    "A basket of summer fruit",
                                    "A field of wheat",
                                    "A vineyard",
                                    "A basket of bread"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God say would happen to the songs of the temple?",
                            new String[]{
                                    "They would become songs of victory",
                                    "They would become louder",
                                    "They would be turned into mourning",
                                    "They would be sung in Babylon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Amos say God would raise up from the house of David?",
                            new String[]{
                                    "A new temple",
                                    "A palace in Egypt",
                                    "The tabernacle of David",
                                    "A new army"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would happen when God restored Israel according to Amos?",
                            new String[]{
                                    "The plowman would overtake the reaper",
                                    "The land would become a desert",
                                    "The people would leave Israel",
                                    "The temple would disappear"
                            },
                            0
                    ));

                }
        }

        private static void addBookObadiahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "What nation is the main subject of Obadiah's prophecy?",
                            new String[]{
                                    "Edom",
                                    "Egypt",
                                    "Babylon",
                                    "Moab"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God say He would make Edom among the heathen?",
                            new String[]{
                                    "Great and powerful",
                                    "Small",
                                    "Rich",
                                    "Untouchable"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What had deceived the heart of Edom?",
                            new String[]{
                                    "Fear",
                                    "Poverty",
                                    "Pride",
                                    "Hunger"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What bird is mentioned when describing Edom's exaltation?",
                            new String[]{
                                    "Dove",
                                    "Eagle",
                                    "Raven",
                                    "Sparrow"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where did Edom dwell according to Obadiah?",
                            new String[]{
                                    "In the clefts of the rock",
                                    "Beside the sea",
                                    "In the plains",
                                    "In the wilderness"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Edom say in its heart?",
                            new String[]{
                                    "Who shall save us?",
                                    "Who shall feed us?",
                                    "Who shall bring me down to the ground?",
                                    "Who shall rule Jerusalem?"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Lord say would happen even though Edom exalted itself as the eagle?",
                            new String[]{
                                    "Edom would become stronger",
                                    "Edom would receive riches",
                                    "Edom would rule Israel",
                                    "The Lord would bring Edom down"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What example does Obadiah use to describe the destruction of Edom?",
                            new String[]{
                                    "Thieves and robbers",
                                    "Farmers and shepherds",
                                    "Kings and priests",
                                    "Sailors and merchants"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would grape gatherers normally leave behind?",
                            new String[]{
                                    "The vines",
                                    "Some grapes",
                                    "The branches",
                                    "The baskets"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Whose hidden things are said to be searched out?",
                            new String[]{
                                    "Jacob's",
                                    "David's",
                                    "Esau's",
                                    "Moses'"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What happened to the men who were at peace with Edom?",
                            new String[]{
                                    "They deceived Edom",
                                    "They joined Edom permanently",
                                    "They fled to Egypt",
                                    "They became priests"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the men who ate Edom's bread do?",
                            new String[]{
                                    "They praised Edom",
                                    "They brought gifts",
                                    "They laid a wound under Edom",
                                    "They built its walls"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did God say He would destroy out of Edom?",
                            new String[]{
                                    "The vineyards",
                                    "The wise men",
                                    "The sheep",
                                    "The gates"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was the name of the place whose mighty men would be dismayed?",
                            new String[]{
                                    "Teman",
                                    "Bethel",
                                    "Shiloh",
                                    "Hebron"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Why would shame cover Edom?",
                            new String[]{
                                    "Because of its poverty",
                                    "Because it lost its crops",
                                    "Because of violence against Jacob",
                                    "Because it abandoned its cities"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What happened to Jerusalem when strangers entered its gates?",
                            new String[]{
                                    "They cast lots upon Jerusalem",
                                    "They crowned a king",
                                    "They rebuilt the temple",
                                    "They planted vineyards"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Edom not have done on the day of Judah's destruction?",
                            new String[]{
                                    "Prayed for Judah",
                                    "Rejoiced over the children of Judah",
                                    "Helped Judah",
                                    "Returned to Judah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should Edom not have done in the day of Judah's distress?",
                            new String[]{
                                    "Spoken proudly",
                                    "Gone home",
                                    "Built an altar",
                                    "Gathered its armies"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Edom not have done in the day of Jerusalem's calamity?",
                            new String[]{
                                    "Watched from a distance",
                                    "Entered the gates of God's people",
                                    "Prayed for peace",
                                    "Returned home"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Edom do concerning the substance of Jerusalem?",
                            new String[]{
                                    "It carried away the substance",
                                    "It protected the substance",
                                    "It returned the substance",
                                    "It buried the substance"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Edom do concerning those who escaped?",
                            new String[]{
                                    "It protected them",
                                    "It welcomed them",
                                    "It stood in the way to cut off those who escaped",
                                    "It sent them to Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would come upon Mount Zion according to Obadiah?",
                            new String[]{
                                    "Deliverance",
                                    "Famine",
                                    "Darkness",
                                    "A great storm"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who would possess the mount of Esau?",
                            new String[]{
                                    "The Egyptians",
                                    "The house of Jacob",
                                    "The Philistines",
                                    "The Moabites"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would the house of Jacob be like among the nations?",
                            new String[]{
                                    "Fire",
                                    "Water",
                                    "Snow",
                                    "Wind"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "According to the final verse of Obadiah, whose shall the kingdom be?",
                            new String[]{
                                    "Jacob's",
                                    "Edom's",
                                    "The Lord's",
                                    "Jerusalem's"
                            },
                            2
                    ));

                }
        }

        private static void addBookJonahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was Jonah's father?",
                            new String[]{
                                    "Amittai",
                                    "Elijah",
                                    "Amoz",
                                    "Hilkiah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Which city did God command Jonah to go to?",
                            new String[]{
                                    "Jerusalem",
                                    "Nineveh",
                                    "Joppa",
                                    "Tarshish"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where did Jonah try to flee?",
                            new String[]{
                                    "Egypt",
                                    "Samaria",
                                    "Tarshish",
                                    "Babylon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where did Jonah go before finding a ship?",
                            new String[]{
                                    "Joppa",
                                    "Nineveh",
                                    "Jerusalem",
                                    "Bethel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord send upon the sea?",
                            new String[]{
                                    "A great wind",
                                    "A swarm of locusts",
                                    "A great earthquake",
                                    "A cloud of fire"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened to the sea during the storm?",
                            new String[]{
                                    "It became completely dry",
                                    "It became calm immediately",
                                    "There was a mighty tempest",
                                    "It turned into blood"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What were the mariners doing during the storm?",
                            new String[]{
                                    "Sleeping",
                                    "Crying every man unto his god",
                                    "Building another ship",
                                    "Eating"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the mariners throw into the sea?",
                            new String[]{
                                    "Their weapons",
                                    "Their clothing",
                                    "The cargo",
                                    "Their food only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where was Jonah while the storm was raging?",
                            new String[]{
                                    "On the highest part of the ship",
                                    "In the sides of the ship",
                                    "On the shore",
                                    "In the water"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was Jonah doing while the ship was in danger?",
                            new String[]{
                                    "Praying",
                                    "Calling the sailors",
                                    "Fast asleep",
                                    "Preparing to swim"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "How did the sailors determine who was responsible for the trouble?",
                            new String[]{
                                    "They cast lots",
                                    "They asked the king",
                                    "They searched the ship",
                                    "They followed the wind"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jonah say he feared?",
                            new String[]{
                                    "The king of Nineveh",
                                    "The Lord, the God of heaven",
                                    "The sailors",
                                    "The people of Joppa"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jonah tell the sailors to do to him?",
                            new String[]{
                                    "Take him to Nineveh",
                                    "Give him food",
                                    "Cast him into the sea",
                                    "Return him to Joppa"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What happened to the sea after Jonah was cast into it?",
                            new String[]{
                                    "It became calm",
                                    "It became darker",
                                    "The storm became stronger",
                                    "The ship broke apart"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord prepare to swallow Jonah?",
                            new String[]{
                                    "A whale",
                                    "A great fish",
                                    "A serpent",
                                    "A great bird"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How long was Jonah in the belly of the fish?",
                            new String[]{
                                    "One day and one night",
                                    "Seven days",
                                    "Three days and three nights",
                                    "Forty days"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where did Jonah pray to the Lord?",
                            new String[]{
                                    "Out of the fish's belly",
                                    "From the temple",
                                    "From Jerusalem",
                                    "From the ship"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jonah say belongs unto the Lord?",
                            new String[]{
                                    "The kingdom",
                                    "Salvation",
                                    "Nineveh",
                                    "The sea only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Jonah after the fish received God's command?",
                            new String[]{
                                    "The fish carried him to Joppa",
                                    "The fish returned to the sea",
                                    "The fish vomited Jonah upon the dry land",
                                    "The fish took Jonah to Nineveh"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did God tell Jonah to do after the fish released him?",
                            new String[]{
                                    "Go to Nineveh",
                                    "Return to Joppa",
                                    "Go to Jerusalem",
                                    "Stay in the wilderness"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How long did Jonah say it would be before Nineveh would be overthrown?",
                            new String[]{
                                    "Seven days",
                                    "Forty days",
                                    "Three days",
                                    "One hundred days"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the people of Nineveh believe?",
                            new String[]{
                                    "The king only",
                                    "Jonah only",
                                    "God",
                                    "The sailors"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the king of Nineveh proclaim?",
                            new String[]{
                                    "A fast",
                                    "A feast",
                                    "A war",
                                    "A journey"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God see when He saw Nineveh's response?",
                            new String[]{
                                    "Their riches",
                                    "Their buildings",
                                    "Their cattle",
                                    "Their works, that they turned from their evil way"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "How did Jonah react when God spared Nineveh?",
                            new String[]{
                                    "He became angry",
                                    "He celebrated",
                                    "He immediately returned home",
                                    "He became king"
                            },
                            0
                    ));

                }
        }

        private static void addBookMicahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Where was Micah from?",
                            new String[]{
                                    "Moresheth",
                                    "Jerusalem",
                                    "Bethel",
                                    "Samaria"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "During whose reigns did Micah prophesy?",
                            new String[]{
                                    "David, Solomon, and Rehoboam",
                                    "Uzziah, Jotham, Ahaz, and Hezekiah",
                                    "Saul, David, and Solomon",
                                    "Josiah, Jehoiakim, and Zedekiah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which two cities are specifically mentioned in the opening chapter?",
                            new String[]{
                                    "Bethlehem and Hebron",
                                    "Jericho and Bethel",
                                    "Samaria and Jerusalem",
                                    "Nineveh and Babylon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Micah say would happen to Samaria?",
                            new String[]{
                                    "It would become a great kingdom",
                                    "It would be rebuilt immediately",
                                    "It would become the capital of Judah",
                                    "It would become as an heap of the field"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Micah say the mountains would do at the presence of the Lord?",
                            new String[]{
                                    "Melt",
                                    "Rise higher",
                                    "Become covered with snow",
                                    "Turn into cities"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the people of Israel devise upon their beds?",
                            new String[]{
                                    "Songs of praise",
                                    "Evil",
                                    "Plans for rebuilding",
                                    "Prayers"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the people covet and take by violence?",
                            new String[]{
                                    "Houses and fields",
                                    "Crowns and robes",
                                    "Temple vessels",
                                    "Ships and livestock"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Micah say false prophets would prophesy when given something to eat?",
                            new String[]{
                                    "Peace only",
                                    "Judgment",
                                    "They would prepare war",
                                    "They would proclaim a feast"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the rulers of Jacob hate?",
                            new String[]{
                                    "Wisdom",
                                    "The good",
                                    "Riches",
                                    "Foreign nations"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the heads of Jacob judge for?",
                            new String[]{
                                    "A reward",
                                    "A crown",
                                    "A sacrifice",
                                    "A field"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the priests teach for?",
                            new String[]{
                                    "Gold",
                                    "A reward",
                                    "Hire",
                                    "Land"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Micah say Zion would be plowed like?",
                            new String[]{
                                    "A vineyard",
                                    "A field",
                                    "A garden",
                                    "A pasture"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would happen to the mountain of the house of the Lord in the latter days?",
                            new String[]{
                                    "It would be established in the top of the mountains",
                                    "It would be destroyed",
                                    "It would become a wilderness",
                                    "It would be moved to Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would the nations beat their swords into?",
                            new String[]{
                                    "Crowns",
                                    "Spears",
                                    "Plowshares",
                                    "Altars"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would the nations beat their spears into?",
                            new String[]{
                                    "Pruninghooks",
                                    "Swords",
                                    "Shields",
                                    "Bows"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What city is named as the birthplace of a ruler in Israel?",
                            new String[]{
                                    "Jerusalem",
                                    "Bethlehem Ephratah",
                                    "Samaria",
                                    "Hebron"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "From where were the ruler's goings forth said to have been?",
                            new String[]{
                                    "From Mount Zion",
                                    "From Jerusalem",
                                    "From ancient days",
                                    "From Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Which enemy is mentioned in Micah 5 as coming into the land?",
                            new String[]{
                                    "The Egyptians",
                                    "The Philistines",
                                    "The Assyrian",
                                    "The Moabites"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Lord require according to Micah 6:8?",
                            new String[]{
                                    "To build a great temple",
                                    "To do justly, love mercy, and walk humbly with God",
                                    "To become a warrior",
                                    "To bring many animals as sacrifices"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Micah say God had shown man?",
                            new String[]{
                                    "What is good",
                                    "The future of every nation",
                                    "The location of the ark",
                                    "The names of all kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Which king is mentioned together with Omri as an example of wickedness?",
                            new String[]{
                                    "Ahab",
                                    "Hezekiah",
                                    "Jotham",
                                    "Josiah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Micah say God would cast the sins of His people into?",
                            new String[]{
                                    "The wilderness",
                                    "The deep of the sea",
                                    "The fire",
                                    "The valley"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What question does Micah ask about God in the final chapter?",
                            new String[]{
                                    "Who is like unto thee?",
                                    "Who shall build Jerusalem?",
                                    "Who shall rule Israel?",
                                    "Who shall conquer Assyria?"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Micah say God pardons?",
                            new String[]{
                                    "The sins of the nations only",
                                    "Iniquity",
                                    "Only the sins of kings",
                                    "Only the sins of priests"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To whom did Micah say God would perform truth and mercy?",
                            new String[]{
                                    "Moses and Aaron",
                                    "David and Solomon",
                                    "Jacob and Abraham",
                                    "Joshua and Caleb"
                            },
                            2
                    ));

                }
        }

        private static void addBookNahumQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is named as the prophet in the book of Nahum?",
                            new String[]{
                                    "Nahum the Elkoshite",
                                    "Nahum the Bethlehemite",
                                    "Nahum the priest",
                                    "Nahum the Levite"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What city is the main subject of Nahum's prophecy?",
                            new String[]{
                                    "Jerusalem",
                                    "Nineveh",
                                    "Samaria",
                                    "Babylon"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How does Nahum describe the Lord?",
                            new String[]{
                                    "Slow to anger",
                                    "Unconcerned with evil",
                                    "Unable to judge nations",
                                    "Hidden from mankind"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Nahum say the Lord is in the day of trouble?",
                            new String[]{
                                    "A king",
                                    "A strong hold",
                                    "A warrior",
                                    "A judge only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does the Lord know according to Nahum?",
                            new String[]{
                                    "Only Israel",
                                    "Those that trust in him",
                                    "Only the kings",
                                    "Only the prophets"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happens to the mountains at the presence of the Lord?",
                            new String[]{
                                    "They melt",
                                    "They grow higher",
                                    "They become cities",
                                    "They disappear into the sea"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happens to the hills according to Nahum?",
                            new String[]{
                                    "They rejoice",
                                    "They become green",
                                    "They melt",
                                    "They are rebuilt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Nahum say happens to the earth at the presence of the Lord?",
                            new String[]{
                                    "It burns forever",
                                    "It is lifted up",
                                    "It is made glad",
                                    "It is burned"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What does Nahum say will happen to the Lord's adversaries?",
                            new String[]{
                                    "They will receive crowns",
                                    "He will make an utter end of the place thereof",
                                    "They will rule Israel",
                                    "They will become priests"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Nahum say will not rise up the second time?",
                            new String[]{
                                    "Affliction",
                                    "Rain",
                                    "A king",
                                    "The temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to break from Judah?",
                            new String[]{
                                    "Its walls",
                                    "The yoke of the enemy",
                                    "Its temple",
                                    "Its fields"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Nahum tell Judah to behold upon the mountains?",
                            new String[]{
                                    "The feet of him that bringeth good tidings",
                                    "A great army",
                                    "A golden crown",
                                    "The king of Assyria"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Nahum tell Judah to perform?",
                            new String[]{
                                    "A military parade",
                                    "A feast",
                                    "Thy vows",
                                    "A royal ceremony"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What was Nineveh compared to in Nahum chapter 2?",
                            new String[]{
                                    "A garden",
                                    "A strong fortress",
                                    "A den of lions",
                                    "A vineyard"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What color were the shields of the mighty men described in Nahum?",
                            new String[]{
                                    "Red",
                                    "Blue",
                                    "White",
                                    "Gold"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the chariots do in the streets?",
                            new String[]{
                                    "They stood still",
                                    "They raged",
                                    "They disappeared",
                                    "They were burned"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the gates of the rivers?",
                            new String[]{
                                    "They were strengthened",
                                    "They were closed by the king",
                                    "They were opened",
                                    "They were moved"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the king's palace do according to Nahum?",
                            new String[]{
                                    "It melted",
                                    "It was rebuilt",
                                    "It became a temple",
                                    "It was moved to Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Nahum say Nineveh had multiplied like?",
                            new String[]{
                                    "Shepherds",
                                    "Merchants",
                                    "Locusts",
                                    "Priests"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Nahum call Nineveh in chapter 3?",
                            new String[]{
                                    "The holy city",
                                    "The bloody city",
                                    "The city of peace",
                                    "The city of David"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was Nineveh said to be full of?",
                            new String[]{
                                    "Lies and robbery",
                                    "Gold and silver",
                                    "Wisdom and knowledge",
                                    "Peace and righteousness"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What ancient Egyptian city is compared with Nineveh?",
                            new String[]{
                                    "Memphis",
                                    "Thebes",
                                    "Alexandria",
                                    "Goshen"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Thebes according to Nahum?",
                            new String[]{
                                    "It became the capital of Judah",
                                    "It was stronger than Nineveh",
                                    "It was carried away into captivity",
                                    "It was rebuilt by Israel"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Nahum say about the wound of Nineveh?",
                            new String[]{
                                    "It had no healing",
                                    "It would heal quickly",
                                    "It was only temporary",
                                    "It would be forgotten"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would people do when they heard of Nineveh's destruction?",
                            new String[]{
                                    "Build another city",
                                    "Clap their hands",
                                    "Travel to Nineveh",
                                    "Crown its king"
                            },
                            1
                    ));

                }
        }

        private static void addBookHabakkukQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is named as the prophet in this book?",
                            new String[]{
                                    "Habakkuk",
                                    "Zephaniah",
                                    "Nahum",
                                    "Micah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Habakkuk cry out to the Lord about?",
                            new String[]{
                                    "A famine",
                                    "Violence",
                                    "A broken temple",
                                    "A failed harvest"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say was slack?",
                            new String[]{
                                    "The temple",
                                    "The priesthood",
                                    "The law",
                                    "The kingdom"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What nation did God say He was raising up?",
                            new String[]{
                                    "The Egyptians",
                                    "The Philistines",
                                    "The Moabites",
                                    "The Chaldeans"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "How did Habakkuk describe the Chaldeans?",
                            new String[]{
                                    "Bitter and hasty",
                                    "Peaceful and gentle",
                                    "Weak and fearful",
                                    "Poor and helpless"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What animals were the horses of the Chaldeans compared to?",
                            new String[]{
                                    "Lions and bears",
                                    "Leopards and evening wolves",
                                    "Sheep and goats",
                                    "Eagles and doves"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What bird was used to describe the speed of the horsemen?",
                            new String[]{
                                    "Raven",
                                    "Dove",
                                    "Eagle",
                                    "Sparrow"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Chaldeans gather like sand?",
                            new String[]{
                                    "Captives",
                                    "Gold",
                                    "Horses",
                                    "Weapons"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Chaldeans scoff at?",
                            new String[]{
                                    "Priests",
                                    "Kings",
                                    "Farmers",
                                    "Prophets"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say he would stand upon to watch for God's answer?",
                            new String[]{
                                    "The temple",
                                    "The wall",
                                    "The mountain",
                                    "The river"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord tell Habakkuk to write?",
                            new String[]{
                                    "The names of the kings",
                                    "The law of Moses",
                                    "The vision",
                                    "A song"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where was Habakkuk told to make the vision plain?",
                            new String[]{
                                    "Upon tables",
                                    "Upon stones",
                                    "Upon the temple wall",
                                    "Upon parchment only"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should a person do if the vision seems to tarry?",
                            new String[]{
                                    "Forget it",
                                    "Wait for it",
                                    "Change it",
                                    "Hide it"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Habakkuk 2:4 say the just shall live by?",
                            new String[]{
                                    "His works",
                                    "His strength",
                                    "His faith",
                                    "His riches"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Habakkuk pronounce against the person who increases what is not his?",
                            new String[]{
                                    "A blessing",
                                    "A reward",
                                    "A feast",
                                    "A woe"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say the stone would cry out of?",
                            new String[]{
                                    "The wall",
                                    "The mountain",
                                    "The temple",
                                    "The field"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say the beam would answer?",
                            new String[]{
                                    "The stone",
                                    "The king",
                                    "The prophet",
                                    "The priest"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say the earth would be filled with?",
                            new String[]{
                                    "The knowledge of the glory of the Lord",
                                    "Gold and silver",
                                    "The armies of Israel",
                                    "Great cities"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say about the cup in His right hand?",
                            new String[]{
                                    "It was full of water",
                                    "It was full of wine",
                                    "It was empty",
                                    "It was made of gold"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say about graven images?",
                            new String[]{
                                    "They can teach",
                                    "There is no breath in them",
                                    "They speak to prophets",
                                    "They protect cities"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where is the Lord according to Habakkuk 2:20?",
                            new String[]{
                                    "In His holy temple",
                                    "On Mount Carmel",
                                    "In Jerusalem's gates",
                                    "In the wilderness"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is Habakkuk chapter 3 described as?",
                            new String[]{
                                    "A royal decree",
                                    "A prayer of Habakkuk",
                                    "A song of David",
                                    "A prophecy of Micah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "From where did God come according to Habakkuk's prayer?",
                            new String[]{
                                    "Egypt",
                                    "Jerusalem",
                                    "Teman",
                                    "Babylon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "From which mountain did the Holy One come?",
                            new String[]{
                                    "Mount Sinai",
                                    "Mount Carmel",
                                    "Mount Zion",
                                    "Mount Paran"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Habakkuk say he would do even if the fig tree did not blossom?",
                            new String[]{
                                    "Rejoice in the Lord",
                                    "Leave the land",
                                    "Build another city",
                                    "Ask for another king"
                            },
                            0
                    ));

                }
        }

        private static void addBookZephaniahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was Zephaniah's father?",
                            new String[]{
                                    "Cushi",
                                    "Gedaliah",
                                    "Amariah",
                                    "Hezekiah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was Zephaniah's great-grandfather?",
                            new String[]{
                                    "Josiah",
                                    "Hezekiah",
                                    "Amon",
                                    "Cushi"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "During whose reign did Zephaniah prophesy?",
                            new String[]{
                                    "Hezekiah",
                                    "Manasseh",
                                    "Josiah",
                                    "Amon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Josiah was the son of whom?",
                            new String[]{
                                    "Hezekiah",
                                    "Amon",
                                    "Cushi",
                                    "Gedaliah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord say He would utterly consume from the face of the land?",
                            new String[]{
                                    "All things",
                                    "Only the wicked",
                                    "Only the animals",
                                    "Only Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Which three kinds of creatures are specifically mentioned in Zephaniah 1:3?",
                            new String[]{
                                    "Lions, bears, and wolves",
                                    "Man, beast, birds, and fish",
                                    "Sheep, goats, and cattle",
                                    "Horses, camels, and donkeys"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Against which kingdom would the Lord stretch out His hand?",
                            new String[]{
                                    "Israel",
                                    "Egypt",
                                    "Judah",
                                    "Moab"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What false god is specifically mentioned in Zephaniah?",
                            new String[]{
                                    "Baal",
                                    "Dagon",
                                    "Chemosh",
                                    "Molech"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did some people worship upon the housetops?",
                            new String[]{
                                    "The sun and moon",
                                    "The host of heaven",
                                    "The king",
                                    "The temple"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did some people swear by?",
                            new String[]{
                                    "The Lord and Malcham",
                                    "David and Solomon",
                                    "Baal and Dagon",
                                    "Egypt and Assyria"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say He would search Jerusalem with?",
                            new String[]{
                                    "A sword",
                                    "A lamp",
                                    "Fire",
                                    "A net"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What day is repeatedly emphasized in Zephaniah?",
                            new String[]{
                                    "The Sabbath",
                                    "The Day of the Lord",
                                    "The Day of Atonement",
                                    "The Feast Day"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How does Zephaniah describe the great day of the Lord?",
                            new String[]{
                                    "A day of joy only",
                                    "A day of peace",
                                    "A day of wrath and trouble",
                                    "A day of harvest"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Zephaniah tell people to seek?",
                            new String[]{
                                    "The Lord",
                                    "Gold",
                                    "Military strength",
                                    "Political power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What else were the meek of the earth told to seek?",
                            new String[]{
                                    "Wealth",
                                    "Righteousness and meekness",
                                    "Fame",
                                    "Victory in war"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What city is specifically mentioned as facing judgment in chapter 2?",
                            new String[]{
                                    "Gaza",
                                    "Jerusalem",
                                    "Nineveh",
                                    "Damascus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would happen to Gaza?",
                            new String[]{
                                    "It would become a great kingdom",
                                    "It would be forsaken",
                                    "It would rule Judah",
                                    "It would be rebuilt immediately"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which people are mentioned as inhabiting the seacoast?",
                            new String[]{
                                    "The Philistines",
                                    "The Moabites",
                                    "The Ammonites",
                                    "The Egyptians"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Moab's reproach become like?",
                            new String[]{
                                    "The reproach of Egypt",
                                    "The reproach of Assyria",
                                    "The reproach of Israel",
                                    "The reproach of Babylon"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Ammon's reproach become like?",
                            new String[]{
                                    "The reproach of Israel",
                                    "The reproach of Judah",
                                    "The reproach of Egypt",
                                    "The reproach of Nineveh"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What city is called the rejoicing city that dwelt carelessly?",
                            new String[]{
                                    "Nineveh",
                                    "Jerusalem",
                                    "Gaza",
                                    "Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Nineveh say in her heart?",
                            new String[]{
                                    "I am, and there is none beside me",
                                    "The Lord is with me",
                                    "Jerusalem shall rule me",
                                    "I shall serve Judah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God promise to leave in the midst of Israel?",
                            new String[]{
                                    "A remnant",
                                    "A great army",
                                    "A royal palace",
                                    "A foreign king"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would the remnant of Israel do?",
                            new String[]{
                                    "Build an empire",
                                    "Feed and lie down safely",
                                    "Leave Jerusalem",
                                    "Conquer Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did God promise to do for His people at the end of Zephaniah?",
                            new String[]{
                                    "Gather them",
                                    "Scatter them",
                                    "Send them to Egypt",
                                    "Make them soldiers"
                            },
                            0
                    ));

                }
        }

    }

    private static class DataPart6 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Haggai")) {
                addBookHaggaiQuestions(questions, difficulty);
            }

            else if (book.equals("Zechariah")) {
                addBookZechariahQuestions(questions, difficulty);
            }

            else if (book.equals("Malachi")) {
                addBookMalachiQuestions(questions, difficulty);
            }

            else if (book.equals("Matthew")) {
                addBookMatthewQuestions(questions, difficulty);
            }

            else if (book.equals("Mark")) {
                addBookMarkQuestions(questions, difficulty);
            }

            else if (book.equals("Luke")) {
                addBookLukeQuestions(questions, difficulty);
            }

            else if (book.equals("John")) {
                addBookJohnQuestions(questions, difficulty);
            }

        }

        private static void addBookHaggaiQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was the prophet who spoke the messages recorded in this book?",
                            new String[]{
                                    "Haggai",
                                    "Zechariah",
                                    "Malachi",
                                    "Micah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "In whose reign did Haggai prophesy?",
                            new String[]{
                                    "Cyrus",
                                    "Darius",
                                    "Artaxerxes",
                                    "Nebuchadnezzar"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was governor of Judah when Haggai prophesied?",
                            new String[]{
                                    "Zerubbabel",
                                    "Joshua",
                                    "Ezra",
                                    "Nehemiah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the high priest mentioned in Haggai?",
                            new String[]{
                                    "Eli",
                                    "Aaron",
                                    "Joshua",
                                    "Zadok"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the people say about the time to build the Lord's house?",
                            new String[]{
                                    "The time had come",
                                    "The time had not come",
                                    "It was already finished",
                                    "It would never come"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What were the people dwelling in while the Lord's house lay waste?",
                            new String[]{
                                    "Walled houses",
                                    "Tents",
                                    "Ceiled houses",
                                    "Palaces"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Haggai tell the people to consider?",
                            new String[]{
                                    "Their ways",
                                    "Their enemies",
                                    "Their wealth",
                                    "Their kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What had the people sown, according to Haggai?",
                            new String[]{
                                    "Much",
                                    "Little",
                                    "Nothing",
                                    "Enough"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the people earn for their wages?",
                            new String[]{
                                    "A full reward",
                                    "A treasure",
                                    "Little",
                                    "Double wages"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Why did the heavens over the people stay from dew?",
                            new String[]{
                                    "Because there was no rain in Egypt",
                                    "Because of their disobedience concerning the Lord's house",
                                    "Because the king stopped the rain",
                                    "Because of war"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord tell the people to bring from the mountains?",
                            new String[]{
                                    "Gold",
                                    "Water",
                                    "Timber",
                                    "Stone only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to be with the people?",
                            new String[]{
                                    "His Spirit",
                                    "His army",
                                    "His angels only",
                                    "His treasure"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened when the people obeyed the voice of the Lord?",
                            new String[]{
                                    "They left Jerusalem",
                                    "They feared the Lord",
                                    "They built a palace",
                                    "They went to Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who stirred up the spirit of Zerubbabel?",
                            new String[]{
                                    "The king",
                                    "Joshua",
                                    "The Lord",
                                    "Haggai"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who stirred up the spirit of Joshua the high priest?",
                            new String[]{
                                    "The Lord",
                                    "Zerubbabel",
                                    "Haggai",
                                    "Darius"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who stirred up the spirit of the remnant of the people?",
                            new String[]{
                                    "Joshua",
                                    "The Lord",
                                    "Zerubbabel",
                                    "The elders"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "When did the people come and work in the house of the Lord?",
                            new String[]{
                                    "On the same day they heard the message",
                                    "One year later",
                                    "After the king returned",
                                    "At the beginning of winter"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What question did Haggai ask about the former glory of the house?",
                            new String[]{
                                    "Who built it?",
                                    "Who remembers it?",
                                    "Where was it located?",
                                    "Why was it destroyed?"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How did the present house appear in comparison with the former house?",
                            new String[]{
                                    "It was larger",
                                    "It was smaller",
                                    "It was exactly the same",
                                    "It was completely finished"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to give in the latter house?",
                            new String[]{
                                    "Peace",
                                    "Gold",
                                    "A king",
                                    "More land"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say belonged to Him?",
                            new String[]{
                                    "Only silver",
                                    "Only gold",
                                    "The silver and the gold",
                                    "The temple vessels only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to shake?",
                            new String[]{
                                    "The heavens and the earth",
                                    "Only Jerusalem",
                                    "Only the temple",
                                    "Only the nations"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was called the Lord's servant?",
                            new String[]{
                                    "Joshua",
                                    "Zerubbabel",
                                    "Haggai",
                                    "Darius"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord say He would make Zerubbabel like?",
                            new String[]{
                                    "A crown",
                                    "A sword",
                                    "A signet",
                                    "A priest"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "On what day did Haggai receive his final message recorded in the book?",
                            new String[]{
                                    "The seventh day",
                                    "The twenty-fourth day of the ninth month",
                                    "The first day of the first month",
                                    "The tenth day of the seventh month"
                            },
                            1
                    ));

                }
        }

        private static void addBookZechariahQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who was the prophet who received the visions recorded in this book?",
                            new String[]{
                                    "Zechariah",
                                    "Haggai",
                                    "Malachi",
                                    "Habakkuk"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "In whose reign did Zechariah begin to prophesy?",
                            new String[]{
                                    "Cyrus",
                                    "Darius",
                                    "Ahasuerus",
                                    "Nebuchadnezzar"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was the father of Zechariah?",
                            new String[]{
                                    "Berechiah",
                                    "Iddo",
                                    "Joshua",
                                    "Zerubbabel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord tell the people to do?",
                            new String[]{
                                    "Return unto Him",
                                    "Return to Egypt",
                                    "Build a palace",
                                    "Fight Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say He would do if they returned to Him?",
                            new String[]{
                                    "Leave them",
                                    "Return unto them",
                                    "Send them away",
                                    "Give them to Persia"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "In Zechariah's first vision, what animals were seen among the myrtle trees?",
                            new String[]{
                                    "Horses",
                                    "Lions",
                                    "Camels",
                                    "Donkeys"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What color were some of the horses in the first vision?",
                            new String[]{
                                    "Black",
                                    "Red",
                                    "White",
                                    "Green"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many horns did Zechariah see?",
                            new String[]{
                                    "Two",
                                    "Three",
                                    "Four",
                                    "Seven"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the four horns represent?",
                            new String[]{
                                    "The four seasons",
                                    "Powers that scattered Judah, Israel, and Jerusalem",
                                    "Four priests",
                                    "Four temples"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Zechariah see in his next vision?",
                            new String[]{
                                    "A measuring line",
                                    "A golden crown",
                                    "A sword",
                                    "A scroll"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was the young man going to measure?",
                            new String[]{
                                    "Babylon",
                                    "Jerusalem",
                                    "Egypt",
                                    "Samaria"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to be around Jerusalem?",
                            new String[]{
                                    "A river",
                                    "A wall of fire",
                                    "A mountain",
                                    "A great army"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Joshua the high priest have on his head in the vision?",
                            new String[]{
                                    "A golden crown",
                                    "A mitre",
                                    "A helmet",
                                    "A royal cap"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who stood before Joshua in the vision to accuse him?",
                            new String[]{
                                    "Satan",
                                    "Darius",
                                    "Haggai",
                                    "The king of Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What kind of garments was Joshua wearing?",
                            new String[]{
                                    "Royal garments",
                                    "Filthy garments",
                                    "Priestly garments of gold",
                                    "Military clothing"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to remove from Joshua?",
                            new String[]{
                                    "His crown",
                                    "His iniquity",
                                    "His priesthood",
                                    "His garments"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Zechariah see in the vision of chapter 4?",
                            new String[]{
                                    "A flying scroll",
                                    "A candlestick and two olive trees",
                                    "A chariot",
                                    "A measuring line"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the seven lamps represent?",
                            new String[]{
                                    "The seven nations",
                                    "The seven eyes of the Lord",
                                    "The seven priests",
                                    "The seven feasts"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord say would make Zerubbabel's work succeed?",
                            new String[]{
                                    "Military strength",
                                    "Human wisdom",
                                    "Not by might, nor by power, but by His spirit",
                                    "The king of Persia"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What was the first thing Zechariah saw in chapter 5?",
                            new String[]{
                                    "A flying roll",
                                    "A golden altar",
                                    "A horse",
                                    "A crown"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was written on the flying roll?",
                            new String[]{
                                    "The names of kings",
                                    "A curse",
                                    "The law of Moses",
                                    "A prayer"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many chariots appeared in Zechariah's vision in chapter 6?",
                            new String[]{
                                    "Two",
                                    "Three",
                                    "Four",
                                    "Seven"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did the Lord tell His people to show toward one another?",
                            new String[]{
                                    "Judgment only",
                                    "Truth, mercy, and compassion",
                                    "Military strength",
                                    "Wealth"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord promise would happen to Jerusalem?",
                            new String[]{
                                    "It would become a desolation forever",
                                    "It would be called a city of truth",
                                    "It would be abandoned immediately",
                                    "It would become part of Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the people of many nations seek to do in the days described by Zechariah?",
                            new String[]{
                                    "Go to Jerusalem to seek the Lord",
                                    "Destroy Jerusalem",
                                    "Leave Judah",
                                    "Build Babylon"
                            },
                            0
                    ));

                }
        }

        private static void addBookMalachiQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who is named as the messenger in this book?",
                            new String[]{
                                    "Malachi",
                                    "Haggai",
                                    "Zechariah",
                                    "Ezra"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say about His love for Jacob?",
                            new String[]{
                                    "He had forgotten Jacob",
                                    "He loved Jacob",
                                    "He rejected Jacob",
                                    "He feared Jacob"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was Jacob's brother?",
                            new String[]{
                                    "Isaac",
                                    "Esau",
                                    "Joseph",
                                    "Aaron"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the priests despise?",
                            new String[]{
                                    "The name of the Lord",
                                    "The king of Persia",
                                    "The city of Jerusalem",
                                    "The people of Judah"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the priests offer upon the altar?",
                            new String[]{
                                    "Perfect animals only",
                                    "Polluted bread and blemished animals",
                                    "Gold and silver",
                                    "Fresh grain only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What kind of animal did the people offer as sacrifices?",
                            new String[]{
                                    "Blemished animals",
                                    "Only firstborn animals",
                                    "Only birds",
                                    "Only lambs"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say His name would be among the Gentiles?",
                            new String[]{
                                    "Forgotten",
                                    "Great",
                                    "Hidden",
                                    "Feared only in Judah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord desire to see among the nations?",
                            new String[]{
                                    "Pure offerings",
                                    "Military armies",
                                    "Royal palaces",
                                    "Large cities"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What had the priests caused people to stumble in?",
                            new String[]{
                                    "The law",
                                    "The desert",
                                    "War",
                                    "Famine"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What covenant did Levi have with the Lord?",
                            new String[]{
                                    "A covenant of peace",
                                    "A covenant of gold",
                                    "A covenant of war",
                                    "A covenant of kingship"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say He hated?",
                            new String[]{
                                    "Prayer",
                                    "Putting away and treachery",
                                    "Giving offerings",
                                    "The Sabbath"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the people ask when they had wearied the Lord?",
                            new String[]{
                                    "How have we wearied him?",
                                    "Where is the temple?",
                                    "Who is our king?",
                                    "When will the harvest come?"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the people say was evil in the sight of the Lord?",
                            new String[]{
                                    "Serving God",
                                    "Doing evil",
                                    "Giving offerings",
                                    "Keeping the law"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to send before the day of the Lord?",
                            new String[]{
                                    "Elijah the prophet",
                                    "Moses",
                                    "Joshua",
                                    "David"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would Elijah turn the heart of the fathers toward?",
                            new String[]{
                                    "Their riches",
                                    "Their children",
                                    "Their enemies",
                                    "Their kings"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would the hearts of the children be turned toward?",
                            new String[]{
                                    "Their fathers",
                                    "Their enemies",
                                    "Their kings",
                                    "Their riches"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord say would come upon the proud and wicked?",
                            new String[]{
                                    "A blessing",
                                    "A burning judgment",
                                    "A royal feast",
                                    "A new kingdom"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What would the day that burns as an oven do to the wicked?",
                            new String[]{
                                    "Make them kings",
                                    "Leave them untouched",
                                    "Burn them up",
                                    "Send them to Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What would arise with healing in his wings?",
                            new String[]{
                                    "The sun of righteousness",
                                    "The moon",
                                    "A new king",
                                    "The angel of the Lord"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would the righteous do when the Sun of righteousness arose?",
                            new String[]{
                                    "Hide in the temple",
                                    "Go forth and grow up as calves of the stall",
                                    "Leave Jerusalem",
                                    "Build an altar"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What law did the Lord tell His people to remember?",
                            new String[]{
                                    "The law of Moses",
                                    "The law of Babylon",
                                    "The law of Persia",
                                    "The law of Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Lord promise to send before the great and dreadful day?",
                            new String[]{
                                    "Elijah the prophet",
                                    "A Persian army",
                                    "A new priest",
                                    "A king from Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What would happen if the people's hearts were not turned?",
                            new String[]{
                                    "The Lord would send a curse",
                                    "They would receive riches",
                                    "The temple would become larger",
                                    "They would conquer Babylon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Malachi repeatedly challenge the people to bring to God?",
                            new String[]{
                                    "Their best offerings",
                                    "Only money",
                                    "Military weapons",
                                    "Foreign idols"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is the final word of the Old Testament book of Malachi?",
                            new String[]{
                                    "Peace",
                                    "Amen",
                                    "Curse",
                                    "Glory"
                            },
                            2
                    ));

                }
        }

        private static void addBookMatthewQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the Gospel of Matthew?",
                            new String[]{
                                    "Matthew",
                                    "Mark",
                                    "Luke",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Matthew's occupation before following Jesus?",
                            new String[]{
                                    "Fisherman",
                                    "Tax collector",
                                    "Carpenter",
                                    "Shepherd"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was the mother of Jesus?",
                            new String[]{
                                    "Elizabeth",
                                    "Martha",
                                    "Mary",
                                    "Salome"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where was Jesus born?",
                            new String[]{
                                    "Nazareth",
                                    "Jerusalem",
                                    "Bethlehem",
                                    "Capernaum"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who was the earthly father of Jesus?",
                            new String[]{
                                    "Joseph",
                                    "Zechariah",
                                    "Joachim",
                                    "Simeon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who visited Jesus after His birth and brought gifts?",
                            new String[]{
                                    "The shepherds only",
                                    "Wise men from the east",
                                    "Roman soldiers",
                                    "The priests"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which ruler sought to destroy the child Jesus?",
                            new String[]{
                                    "Pilate",
                                    "Caesar Augustus",
                                    "Herod",
                                    "Caiaphas"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Where did Joseph take Jesus and Mary to escape Herod?",
                            new String[]{
                                    "Egypt",
                                    "Syria",
                                    "Galilee",
                                    "Samaria"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who baptized Jesus?",
                            new String[]{
                                    "Peter",
                                    "John the Baptist",
                                    "James",
                                    "Andrew"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What descended upon Jesus like a dove after His baptism?",
                            new String[]{
                                    "The Holy Spirit",
                                    "Fire",
                                    "An angel",
                                    "A cloud"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How long did Jesus fast in the wilderness?",
                            new String[]{
                                    "Seven days",
                                    "Forty days and forty nights",
                                    "Thirty days",
                                    "Three days"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who tempted Jesus in the wilderness?",
                            new String[]{
                                    "Herod",
                                    "Satan",
                                    "Pilate",
                                    "Caiaphas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus call Peter and Andrew when He first called them?",
                            new String[]{
                                    "Teachers of Israel",
                                    "Fishers of men",
                                    "Sons of thunder",
                                    "Servants of Rome"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What famous teaching begins Matthew chapters 5–7?",
                            new String[]{
                                    "The Sermon on the Mount",
                                    "The Olivet Discourse",
                                    "The Farewell Discourse",
                                    "The Upper Room Teaching"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What prayer did Jesus teach His disciples?",
                            new String[]{
                                    "The Prayer of Jabez",
                                    "The Lord's Prayer",
                                    "David's Prayer",
                                    "Solomon's Prayer"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus say His followers should be to the world?",
                            new String[]{
                                    "Salt and light",
                                    "Kings and rulers",
                                    "Warriors and judges",
                                    "Priests and prophets"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who walked on the water toward Jesus?",
                            new String[]{
                                    "John",
                                    "James",
                                    "Peter",
                                    "Andrew"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jesus feed five thousand men with?",
                            new String[]{
                                    "Seven loaves and two fish",
                                    "Five loaves and two fish",
                                    "Two loaves and five fish",
                                    "Ten loaves and five fish"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who confessed that Jesus was the Christ, the Son of the living God?",
                            new String[]{
                                    "Peter",
                                    "John",
                                    "Thomas",
                                    "Matthew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Which disciple betrayed Jesus?",
                            new String[]{
                                    "Thomas",
                                    "Judas Iscariot",
                                    "Philip",
                                    "Bartholomew"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "For how many pieces of silver did Judas agree to betray Jesus?",
                            new String[]{
                                    "Ten",
                                    "Twenty",
                                    "Thirty",
                                    "Forty"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jesus pray in the garden before His arrest?",
                            new String[]{
                                    "Thy will be done",
                                    "Give me strength to escape",
                                    "Destroy my enemies",
                                    "Send an army"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who sentenced Jesus to be crucified?",
                            new String[]{
                                    "Herod",
                                    "Pilate",
                                    "Caiaphas",
                                    "Annas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Jesus on the third day after His death?",
                            new String[]{
                                    "He remained in the tomb",
                                    "He was taken to Egypt",
                                    "He rose from the dead",
                                    "He returned to Nazareth"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What command did Jesus give His disciples at the end of Matthew?",
                            new String[]{
                                    "Go and make disciples of all nations",
                                    "Return to Galilee and remain there",
                                    "Build a temple",
                                    "Go back to fishing"
                            },
                            0
                    ));

                }
        }

        private static void addBookMarkQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the Gospel of Mark?",
                            new String[]{
                                    "Mark",
                                    "Matthew",
                                    "Luke",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the father of John Mark?",
                            new String[]{
                                    "Zebedee",
                                    "No father is named in Mark",
                                    "Alphaeus",
                                    "Jonah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who baptized people in the wilderness?",
                            new String[]{
                                    "Peter",
                                    "John the Baptist",
                                    "Andrew",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did John the Baptist wear?",
                            new String[]{
                                    "Fine linen",
                                    "Camel's hair",
                                    "Wool",
                                    "Purple cloth"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did John the Baptist eat?",
                            new String[]{
                                    "Bread and fish",
                                    "Locusts and wild honey",
                                    "Dates and figs",
                                    "Manna"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Jesus immediately after His baptism?",
                            new String[]{
                                    "He went to Jerusalem",
                                    "The Spirit drove Him into the wilderness",
                                    "He returned to Nazareth",
                                    "He called Paul"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many days was Jesus tempted in the wilderness?",
                            new String[]{
                                    "Seven",
                                    "Thirty",
                                    "Forty",
                                    "Fifty"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who were the first two disciples Jesus called in Mark?",
                            new String[]{
                                    "Peter and Andrew",
                                    "James and John",
                                    "Matthew and Thomas",
                                    "Philip and Bartholomew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Simon Peter doing when Jesus called him?",
                            new String[]{
                                    "Collecting taxes",
                                    "Casting a net into the sea",
                                    "Praying in the temple",
                                    "Selling bread"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus do to the man with the withered hand?",
                            new String[]{
                                    "He healed him",
                                    "He sent him away",
                                    "He told him to wait",
                                    "He gave him money"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How many apostles did Jesus appoint?",
                            new String[]{
                                    "Seven",
                                    "Ten",
                                    "Twelve",
                                    "Seventy"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Jesus calm while He and His disciples were in a ship?",
                            new String[]{
                                    "A fire",
                                    "A storm",
                                    "An earthquake",
                                    "A flood"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus say to the storm?",
                            new String[]{
                                    "Peace, be still",
                                    "Come forth",
                                    "Follow me",
                                    "Be healed"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus use to feed the five thousand in Mark?",
                            new String[]{
                                    "Five loaves and two fish",
                                    "Seven loaves and one fish",
                                    "Two loaves and five fish",
                                    "Ten loaves and two fish"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who came down through the roof because his friends wanted Jesus to heal him?",
                            new String[]{
                                    "A blind man",
                                    "A paralysed man",
                                    "A leper",
                                    "A deaf man"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus do for Bartimaeus?",
                            new String[]{
                                    "He healed his blindness",
                                    "He gave him food",
                                    "He made him a disciple",
                                    "He sent him to Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was Bartimaeus?",
                            new String[]{
                                    "A blind beggar",
                                    "A Roman soldier",
                                    "A fisherman",
                                    "A priest"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Peter say Jesus was?",
                            new String[]{
                                    "A prophet only",
                                    "The Christ",
                                    "A Roman king",
                                    "Elijah"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which disciple betrayed Jesus?",
                            new String[]{
                                    "Peter",
                                    "Judas Iscariot",
                                    "John",
                                    "Thomas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Judas use as a sign to identify Jesus?",
                            new String[]{
                                    "A handshake",
                                    "A kiss",
                                    "A wave",
                                    "A spoken command"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who denied Jesus three times?",
                            new String[]{
                                    "Peter",
                                    "James",
                                    "Andrew",
                                    "Matthew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the Roman governor who questioned Jesus?",
                            new String[]{
                                    "Herod",
                                    "Pilate",
                                    "Felix",
                                    "Festus"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to the temple veil when Jesus died?",
                            new String[]{
                                    "It was hidden",
                                    "It was torn in two",
                                    "It was burned",
                                    "It was removed by priests"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who discovered that Jesus' tomb was empty?",
                            new String[]{
                                    "Mary Magdalene and other women",
                                    "Peter alone",
                                    "Pilate",
                                    "The Roman governor"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the angel tell the women about Jesus?",
                            new String[]{
                                    "He is still in the tomb",
                                    "He is risen",
                                    "He has gone to Egypt",
                                    "He is in Jerusalem"
                            },
                            1
                    ));

                }
        }

        private static void addBookLukeQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the Gospel of Luke?",
                            new String[]{
                                    "Luke",
                                    "Matthew",
                                    "Mark",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Luke's occupation according to Colossians?",
                            new String[]{
                                    "Fisherman",
                                    "Physician",
                                    "Tax collector",
                                    "Priest"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To whom is the Gospel of Luke addressed?",
                            new String[]{
                                    "Theophilus",
                                    "Peter",
                                    "Paul",
                                    "Timothy"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the father of John the Baptist?",
                            new String[]{
                                    "Joseph",
                                    "Zechariah",
                                    "Simeon",
                                    "Jairus"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was the mother of John the Baptist?",
                            new String[]{
                                    "Elizabeth",
                                    "Mary",
                                    "Martha",
                                    "Anna"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who announced to Mary that she would have Jesus?",
                            new String[]{
                                    "Michael",
                                    "Gabriel",
                                    "Raphael",
                                    "An angel named Uriel"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where was Jesus laid after His birth?",
                            new String[]{
                                    "In a palace",
                                    "In a manger",
                                    "In the temple",
                                    "In a house"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who came to see the newborn Jesus after hearing the announcement from angels?",
                            new String[]{
                                    "Shepherds",
                                    "Wise men",
                                    "Roman soldiers",
                                    "Priests from Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Simeon do when he saw the infant Jesus?",
                            new String[]{
                                    "He fled",
                                    "He took Jesus in his arms and blessed God",
                                    "He returned to Galilee",
                                    "He became angry"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was the prophetess who spoke about Jesus in the temple?",
                            new String[]{
                                    "Anna",
                                    "Deborah",
                                    "Hannah",
                                    "Miriam"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How old was Jesus when His parents found Him in the temple?",
                            new String[]{
                                    "Seven",
                                    "Twelve",
                                    "Thirteen",
                                    "Thirty"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus say He must be about when He was found in the temple?",
                            new String[]{
                                    "His Father's business",
                                    "His disciples",
                                    "His journey to Egypt",
                                    "The Roman government"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who preached repentance in the region around the Jordan?",
                            new String[]{
                                    "Peter",
                                    "John the Baptist",
                                    "Paul",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus do after His baptism before beginning His ministry?",
                            new String[]{
                                    "He went into the wilderness",
                                    "He went to Rome",
                                    "He became a priest",
                                    "He returned to Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How many apostles did Jesus choose?",
                            new String[]{
                                    "Seven",
                                    "Twelve",
                                    "Twenty-four",
                                    "Seventy"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who climbed a sycomore tree to see Jesus?",
                            new String[]{
                                    "Zacchaeus",
                                    "Jairus",
                                    "Bartimaeus",
                                    "Nicodemus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Zacchaeus's occupation?",
                            new String[]{
                                    "Fisherman",
                                    "Chief publican",
                                    "Priest",
                                    "Carpenter"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who helped the wounded man in the parable of the Good Samaritan?",
                            new String[]{
                                    "A priest",
                                    "A Samaritan",
                                    "A Levite",
                                    "A Roman soldier"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the father do when the prodigal son returned?",
                            new String[]{
                                    "He rejected him",
                                    "He ran to him and welcomed him",
                                    "He sent him away",
                                    "He demanded payment"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was raised from the dead in one of Jesus' parables?",
                            new String[]{
                                    "Lazarus",
                                    "The prodigal son's brother",
                                    "The widow's son",
                                    "Jairus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who betrayed Jesus?",
                            new String[]{
                                    "Peter",
                                    "Judas Iscariot",
                                    "Thomas",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who denied Jesus three times?",
                            new String[]{
                                    "Peter",
                                    "John",
                                    "Andrew",
                                    "Matthew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the Roman governor who questioned Jesus?",
                            new String[]{
                                    "Herod",
                                    "Pilate",
                                    "Felix",
                                    "Festus"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus promise the repentant criminal on the cross?",
                            new String[]{
                                    "A place in Jerusalem",
                                    "Paradise",
                                    "A position among the apostles",
                                    "A return to Galilee"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus do after rising from the dead?",
                            new String[]{
                                    "He appeared to His disciples",
                                    "He immediately left the earth",
                                    "He returned to Egypt",
                                    "He went to Rome"
                            },
                            0
                    ));

                }
        }

        private static void addBookJohnQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the Gospel of John?",
                            new String[]{
                                    "John",
                                    "Matthew",
                                    "Mark",
                                    "Luke"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does John say was in the beginning with God?",
                            new String[]{
                                    "The Law",
                                    "The Word",
                                    "The Temple",
                                    "The Kingdom"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was the Word according to John 1?",
                            new String[]{
                                    "John the Baptist",
                                    "Jesus Christ",
                                    "Moses",
                                    "Peter"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was sent from God to bear witness of the Light?",
                            new String[]{
                                    "John",
                                    "Peter",
                                    "James",
                                    "Andrew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was John the Baptist's purpose according to John's Gospel?",
                            new String[]{
                                    "To become king",
                                    "To bear witness of the Light",
                                    "To build the temple",
                                    "To lead an army"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did John the Baptist call Jesus?",
                            new String[]{
                                    "The King of Israel",
                                    "The Lamb of God",
                                    "The Son of David",
                                    "The Prophet"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who came to Jesus by night to ask questions?",
                            new String[]{
                                    "Nicodemus",
                                    "Jairus",
                                    "Zacchaeus",
                                    "Thomas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus tell Nicodemus a person must be?",
                            new String[]{
                                    "Born again",
                                    "A priest",
                                    "A Roman citizen",
                                    "A fisherman"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Jesus meet at Jacob's well?",
                            new String[]{
                                    "A Samaritan woman",
                                    "Mary Magdalene",
                                    "Martha",
                                    "Elizabeth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus offer the Samaritan woman?",
                            new String[]{
                                    "Living water",
                                    "Gold",
                                    "Bread",
                                    "A new house"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What miracle did Jesus perform at Cana?",
                            new String[]{
                                    "He healed a blind man",
                                    "He turned water into wine",
                                    "He fed five thousand",
                                    "He calmed a storm"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How many waterpots were at the wedding in Cana?",
                            new String[]{
                                    "Four",
                                    "Six",
                                    "Seven",
                                    "Twelve"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was raised from the dead by Jesus in John 11?",
                            new String[]{
                                    "Jairus",
                                    "Lazarus",
                                    "Stephen",
                                    "Zacchaeus"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who were Lazarus's sisters?",
                            new String[]{
                                    "Mary and Martha",
                                    "Mary and Elizabeth",
                                    "Martha and Anna",
                                    "Salome and Mary"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus say before raising Lazarus?",
                            new String[]{
                                    "I am the resurrection, and the life",
                                    "I am the good shepherd",
                                    "I am the bread of life",
                                    "I am the door"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus wash for His disciples?",
                            new String[]{
                                    "Their hands",
                                    "Their feet",
                                    "Their clothes",
                                    "Their faces"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which disciple objected when Jesus wanted to wash his feet?",
                            new String[]{
                                    "Peter",
                                    "John",
                                    "Thomas",
                                    "Andrew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who betrayed Jesus?",
                            new String[]{
                                    "Peter",
                                    "Judas Iscariot",
                                    "Thomas",
                                    "Philip"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which disciple doubted that Jesus had risen until he saw Him?",
                            new String[]{
                                    "Andrew",
                                    "Thomas",
                                    "James",
                                    "Matthew"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Thomas call Jesus when he saw Him risen?",
                            new String[]{
                                    "My Lord and my God",
                                    "My King and my Priest",
                                    "The Son of David",
                                    "The Lamb of God"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus say He was in John 10?",
                            new String[]{
                                    "The good shepherd",
                                    "The great prophet",
                                    "The true priest",
                                    "The king of Rome"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus say He was in John 14?",
                            new String[]{
                                    "The temple",
                                    "The way, the truth, and the life",
                                    "The door of Jerusalem",
                                    "The law of Moses"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus say He was in John 15?",
                            new String[]{
                                    "The true vine",
                                    "The true temple",
                                    "The true priest",
                                    "The true prophet"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who denied Jesus three times?",
                            new String[]{
                                    "John",
                                    "Peter",
                                    "Thomas",
                                    "Judas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Jesus command His disciples to do to one another?",
                            new String[]{
                                    "Love one another",
                                    "Judge one another",
                                    "Rule one another",
                                    "Avoid one another"
                            },
                            0
                    ));

                }
        }

    }

    private static class DataPart7 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Acts")) {
                addBookActsQuestions(questions, difficulty);
            }

            else if (book.equals("Romans")) {
                addBookRomansQuestions(questions, difficulty);
            }

            else if (book.equals("1 Corinthians")) {
                addBook1CorinthiansQuestions(questions, difficulty);
            }

            else if (book.equals("2 Corinthians")) {
                addBook2CorinthiansQuestions(questions, difficulty);
            }

            else if (book.equals("Galatians")) {
                addBookGalatiansQuestions(questions, difficulty);
            }

            else if (book.equals("Ephesians")) {
                addBookEphesiansQuestions(questions, difficulty);
            }

            else if (book.equals("Philippians")) {
                addBookPhilippiansQuestions(questions, difficulty);
            }

        }

        private static void addBookActsQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the book of Acts?",
                            new String[]{
                                    "Luke",
                                    "Paul",
                                    "Peter",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom is Acts addressed?",
                            new String[]{
                                    "Timothy",
                                    "Theophilus",
                                    "Titus",
                                    "Silas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened to Jesus before His ascension?",
                            new String[]{
                                    "He appeared to His apostles",
                                    "He went to Rome",
                                    "He returned to Egypt",
                                    "He became king of Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where did Jesus tell His disciples to wait for the promise of the Father?",
                            new String[]{
                                    "Jerusalem",
                                    "Bethlehem",
                                    "Nazareth",
                                    "Capernaum"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened to Jesus as the disciples watched?",
                            new String[]{
                                    "He disappeared into the temple",
                                    "He was taken up",
                                    "He sailed across the sea",
                                    "He returned to Nazareth"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was chosen to replace Judas among the apostles?",
                            new String[]{
                                    "Matthias",
                                    "Barnabas",
                                    "Silas",
                                    "Stephen"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened on the Day of Pentecost?",
                            new String[]{
                                    "The disciples received the Holy Spirit",
                                    "The temple was destroyed",
                                    "Paul became an apostle",
                                    "Peter went to Rome"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What appeared upon the disciples at Pentecost?",
                            new String[]{
                                    "Clouds",
                                    "Cloven tongues like as of fire",
                                    "Gold crowns",
                                    "White garments"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happened when the disciples were filled with the Holy Ghost?",
                            new String[]{
                                    "They spoke with other tongues",
                                    "They became invisible",
                                    "They left Jerusalem",
                                    "They built an altar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who preached to the crowd on the Day of Pentecost?",
                            new String[]{
                                    "Peter",
                                    "John",
                                    "James",
                                    "Matthew"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "About how many people were added to the church after Peter's sermon?",
                            new String[]{
                                    "About 300",
                                    "About 3,000",
                                    "About 30,000",
                                    "About 700"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What was the name of the lame man healed at the temple gate?",
                            new String[]{
                                    "No name is given",
                                    "Bartimaeus",
                                    "Lazarus",
                                    "Jairus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "At which gate was the lame man sitting?",
                            new String[]{
                                    "Beautiful",
                                    "Eastern",
                                    "Golden",
                                    "Sheep"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the first Christian martyr recorded in Acts?",
                            new String[]{
                                    "Stephen",
                                    "James",
                                    "Peter",
                                    "Barnabas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who witnessed the stoning of Stephen?",
                            new String[]{
                                    "Saul",
                                    "Peter",
                                    "John",
                                    "Barnabas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Saul doing when Jesus appeared to him?",
                            new String[]{
                                    "Travelling to Damascus",
                                    "Sailing to Rome",
                                    "Praying in Jerusalem",
                                    "Preaching in Galilee"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened to Saul when the heavenly light appeared?",
                            new String[]{
                                    "He became blind",
                                    "He became king",
                                    "He was imprisoned",
                                    "He immediately preached in Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was sent to Saul after his encounter with Jesus?",
                            new String[]{
                                    "Ananias",
                                    "Barnabas",
                                    "Peter",
                                    "Silas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What was Saul also known as?",
                            new String[]{
                                    "Paul",
                                    "Silas",
                                    "Apollos",
                                    "Titus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was the Roman centurion who received Peter's ministry?",
                            new String[]{
                                    "Cornelius",
                                    "Felix",
                                    "Festus",
                                    "Julius"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What vision did Peter receive concerning clean and unclean animals?",
                            new String[]{
                                    "A sheet lowered from heaven",
                                    "A burning bush",
                                    "A ladder",
                                    "A golden altar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where were the disciples first called Christians?",
                            new String[]{
                                    "Jerusalem",
                                    "Antioch",
                                    "Rome",
                                    "Damascus"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who travelled with Paul on his first missionary journey?",
                            new String[]{
                                    "Barnabas",
                                    "Peter",
                                    "Thomas",
                                    "Philip"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened when Paul and Silas were praying and singing in prison?",
                            new String[]{
                                    "An earthquake opened the doors",
                                    "The guards left",
                                    "The prison caught fire",
                                    "The governor released them immediately"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Philippian jailer ask Paul and Silas?",
                            new String[]{
                                    "What must I do to be saved?",
                                    "Where should I go?",
                                    "Who is your king?",
                                    "Why are you here?"
                            },
                            0
                    ));

                }
        }

        private static void addBookRomansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the book of Romans?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was the letter to the Romans written?",
                            new String[]{
                                    "The church at Corinth",
                                    "The saints at Rome",
                                    "The church at Ephesus",
                                    "The believers at Philippi"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Paul described himself as what at the beginning of Romans?",
                            new String[]{
                                    "A servant of Jesus Christ",
                                    "A king of Israel",
                                    "A priest of Jerusalem",
                                    "A Roman governor"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he was not ashamed of?",
                            new String[]{
                                    "The law",
                                    "The gospel of Christ",
                                    "His Roman citizenship",
                                    "His Jewish heritage"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What is the power of God unto salvation?",
                            new String[]{
                                    "The law",
                                    "The gospel",
                                    "The temple",
                                    "The priesthood"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who shall live by faith?",
                            new String[]{
                                    "The just",
                                    "The kings",
                                    "The priests",
                                    "The Romans"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Paul say all have done?",
                            new String[]{
                                    "All have become kings",
                                    "All have sinned",
                                    "All have become priests",
                                    "All have kept the law perfectly"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What is the result of sin according to Romans 6:23?",
                            new String[]{
                                    "The wages of sin is death",
                                    "The wages of sin is wealth",
                                    "The wages of sin is honour",
                                    "The wages of sin is peace"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is the gift of God?",
                            new String[]{
                                    "Long life",
                                    "Eternal life through Jesus Christ",
                                    "Earthly riches",
                                    "Political power"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who is given as the example of justification by faith in Romans 4?",
                            new String[]{
                                    "Abraham",
                                    "Moses",
                                    "David",
                                    "Solomon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Adam bring into the world through sin?",
                            new String[]{
                                    "Death",
                                    "Wealth",
                                    "The law",
                                    "The priesthood"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Paul say believers should present their bodies as?",
                            new String[]{
                                    "A living sacrifice",
                                    "A royal garment",
                                    "A temple offering",
                                    "A military weapon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers be transformed by?",
                            new String[]{
                                    "The renewing of their mind",
                                    "The traditions of men",
                                    "Roman law",
                                    "Earthly riches"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Paul say about love?",
                            new String[]{
                                    "Love worketh no ill to his neighbour",
                                    "Love is only for family",
                                    "Love is unnecessary",
                                    "Love belongs only to leaders"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do toward their enemies?",
                            new String[]{
                                    "Feed them if they are hungry",
                                    "Avoid them forever",
                                    "Punish them",
                                    "Take their possessions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Paul say believers should overcome evil with?",
                            new String[]{
                                    "Power",
                                    "Good",
                                    "Law",
                                    "Judgment"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What authority does Paul say is ordained by God?",
                            new String[]{
                                    "Governmental authority",
                                    "Military authority only",
                                    "Temple authority",
                                    "Foreign authority"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Paul say believers should owe one another?",
                            new String[]{
                                    "Nothing except to love one another",
                                    "Money",
                                    "Food",
                                    "Taxes only"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do instead of making provision for the flesh?",
                            new String[]{
                                    "Put on the Lord Jesus Christ",
                                    "Return to the law",
                                    "Leave society",
                                    "Seek earthly wealth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do about those who are weak in faith?",
                            new String[]{
                                    "Receive them",
                                    "Reject them",
                                    "Ignore them",
                                    "Punish them"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is the foundation of Christian unity according to Romans?",
                            new String[]{
                                    "Christ",
                                    "Moses",
                                    "Abraham",
                                    "David"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul want the believers in Rome to be filled with?",
                            new String[]{
                                    "All joy and peace in believing",
                                    "Earthly riches",
                                    "Military strength",
                                    "Political authority"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who helped Paul write the letter's final greeting?",
                            new String[]{
                                    "Tertius",
                                    "Silas",
                                    "Barnabas",
                                    "Timothy"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was Phoebe described as?",
                            new String[]{
                                    "A servant of the church at Cenchrea",
                                    "A Roman governor",
                                    "A priest in Jerusalem",
                                    "A queen of Rome"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say would soon happen to Satan?",
                            new String[]{
                                    "He would be bruised under the believers' feet",
                                    "He would become king",
                                    "He would rule Rome",
                                    "He would leave the earth immediately"
                            },
                            0
                    ));

                }
        }

        private static void addBook1CorinthiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 1 Corinthians?",
                            new String[]{
                                    "Peter",
                                    "Paul",
                                    "John",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To which city was 1 Corinthians addressed?",
                            new String[]{
                                    "Corinth",
                                    "Rome",
                                    "Ephesus",
                                    "Philippi"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul urge the believers to have among themselves in 1 Corinthians 1?",
                            new String[]{
                                    "Wealth",
                                    "Political power",
                                    "The same mind and judgment",
                                    "Military strength"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say was the power of God?",
                            new String[]{
                                    "The wisdom of the world",
                                    "The preaching of the cross",
                                    "The law of Moses",
                                    "The traditions of men"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who planted, while Apollos watered?",
                            new String[]{
                                    "Peter",
                                    "Barnabas",
                                    "Paul",
                                    "Timothy"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who gives the increase according to 1 Corinthians 3?",
                            new String[]{
                                    "God",
                                    "Paul",
                                    "Apollos",
                                    "The church"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say believers are collectively?",
                            new String[]{
                                    "A kingdom of soldiers",
                                    "The temple of God",
                                    "A school of prophets",
                                    "A house of kings"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say the body of a believer is the temple of?",
                            new String[]{
                                    "The Holy Ghost",
                                    "An angel",
                                    "The law",
                                    "Moses"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell believers to flee?",
                            new String[]{
                                    "Work",
                                    "Wisdom",
                                    "Idolatry",
                                    "Prayer"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What kind of race did Paul use as an example of disciplined Christian living?",
                            new String[]{
                                    "A chariot race",
                                    "A race for a prize",
                                    "A race across the sea",
                                    "A race between kings"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say Israel's experiences were written for?",
                            new String[]{
                                    "Their entertainment",
                                    "Their political instruction",
                                    "Our examples",
                                    "The Roman government"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say believers should do when tempted?",
                            new String[]{
                                    "Trust that God will provide a way to escape",
                                    "Give up immediately",
                                    "Follow the temptation",
                                    "Return to Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Jesus establish in the night in which He was betrayed?",
                            new String[]{
                                    "A new kingdom",
                                    "The Lord's Supper",
                                    "A Roman council",
                                    "A school"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "According to 1 Corinthians 12, believers are compared to what?",
                            new String[]{
                                    "A city",
                                    "A temple made of stones",
                                    "One body with many members",
                                    "A flock without a shepherd"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Which chapter contains the famous teaching about charity?",
                            new String[]{
                                    "1 Corinthians 5",
                                    "1 Corinthians 8",
                                    "1 Corinthians 10",
                                    "1 Corinthians 13"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What does charity do according to 1 Corinthians 13?",
                            new String[]{
                                    "Never faileth",
                                    "Always seeks riches",
                                    "Rules by force",
                                    "Avoids everyone"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say was the greatest of faith, hope, and charity?",
                            new String[]{
                                    "Faith",
                                    "Hope",
                                    "Charity",
                                    "Knowledge"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Which gift did Paul say edifies the church when used properly?",
                            new String[]{
                                    "Prophecy",
                                    "Wealth",
                                    "Military authority",
                                    "Political influence"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul teach about the resurrection in 1 Corinthians 15?",
                            new String[]{
                                    "It is unnecessary",
                                    "The dead are raised",
                                    "Only kings are raised",
                                    "It happened only to angels"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who is described as the firstfruits of them that slept?",
                            new String[]{
                                    "Moses",
                                    "Abraham",
                                    "Jesus Christ",
                                    "David"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Paul say is the last enemy that shall be destroyed?",
                            new String[]{
                                    "Death",
                                    "Sin",
                                    "Rome",
                                    "Suffering"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell the Corinthians to do concerning the work of the Lord?",
                            new String[]{
                                    "Stop working",
                                    "Be discouraged",
                                    "Be steadfast and unmoveable",
                                    "Return to the law"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What collection did Paul instruct the churches to make?",
                            new String[]{
                                    "A collection for the saints",
                                    "A collection for Roman soldiers",
                                    "A collection for the temple in Corinth",
                                    "A collection for kings"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Paul hope would come to Corinth?",
                            new String[]{
                                    "John",
                                    "Apollos",
                                    "Stephen",
                                    "Philip"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "How did Paul end the letter's final greeting?",
                            new String[]{
                                    "The Lord is risen",
                                    "Peace with Rome",
                                    "The grace of our Lord Jesus Christ be with you",
                                    "Remember Moses"
                            },
                            2
                    ));
                }
        }

        private static void addBook2CorinthiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 2 Corinthians?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "Jude"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was 2 Corinthians primarily addressed?",
                            new String[]{
                                    "The church at Rome",
                                    "The church at Corinth",
                                    "The church at Jerusalem",
                                    "The church at Philippi"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does God give to His people in times of trouble according to 2 Corinthians 1?",
                            new String[]{
                                    "Earthly riches",
                                    "Political power",
                                    "Comfort",
                                    "Military protection"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say God comforts us with?",
                            new String[]{
                                    "The comfort with which we ourselves are comforted",
                                    "The wisdom of kings",
                                    "The treasures of the temple",
                                    "The strength of armies"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say we have as a treasure in earthen vessels?",
                            new String[]{
                                    "Gold",
                                    "The excellency of the power of God",
                                    "The law of Moses",
                                    "The wisdom of Rome"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happens to the outward man according to 2 Corinthians 4?",
                            new String[]{
                                    "He becomes king",
                                    "He becomes wealthy",
                                    "He perishes",
                                    "He becomes an angel"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What is renewed day by day?",
                            new String[]{
                                    "The inward man",
                                    "The temple",
                                    "The Roman empire",
                                    "The body of Moses"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What kind of creature is someone who is in Christ?",
                            new String[]{
                                    "An earthly ruler",
                                    "A new creature",
                                    "A Roman citizen",
                                    "A priest of Israel"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What ministry did God give Paul and others in 2 Corinthians 5?",
                            new String[]{
                                    "The ministry of reconciliation",
                                    "The ministry of taxation",
                                    "The ministry of war",
                                    "The ministry of farming"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say Christ was made to be for us?",
                            new String[]{
                                    "A king of Rome",
                                    "A prophet only",
                                    "Sin for us",
                                    "A soldier"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul urge believers not to receive in vain?",
                            new String[]{
                                    "The grace of God",
                                    "The law",
                                    "Gold",
                                    "Earthly authority"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What kind of sorrow worketh repentance?",
                            new String[]{
                                    "Worldly sorrow",
                                    "Godly sorrow",
                                    "Political sorrow",
                                    "Temporary sorrow"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Which churches were praised for their generosity in 2 Corinthians 8?",
                            new String[]{
                                    "The churches of Judea",
                                    "The churches of Rome",
                                    "The churches of Macedonia",
                                    "The churches of Egypt"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say God loves?",
                            new String[]{
                                    "A cheerful giver",
                                    "A wealthy ruler",
                                    "A famous teacher",
                                    "A powerful soldier"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say God is able to make abound toward believers?",
                            new String[]{
                                    "Political influence",
                                    "All grace",
                                    "Earthly fame",
                                    "Military strength"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What kind of weapons does Paul describe in 2 Corinthians 10?",
                            new String[]{
                                    "Carnal weapons",
                                    "Roman weapons",
                                    "Spiritual weapons",
                                    "Weapons of gold"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Paul say spiritual weapons are mighty through?",
                            new String[]{
                                    "God",
                                    "Rome",
                                    "Human wisdom",
                                    "Military training"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul fear the Corinthians might be deceived by?",
                            new String[]{
                                    "The simplicity that is in Christ",
                                    "The law of Rome",
                                    "The wealth of Corinth",
                                    "The wisdom of philosophers"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul call some false teachers who came among the Corinthians?",
                            new String[]{
                                    "False apostles",
                                    "Roman governors",
                                    "Priests of Baal",
                                    "Kings of Israel"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul have in his flesh that he called a thorn?",
                            new String[]{
                                    "A crown",
                                    "A thorn in the flesh",
                                    "A broken sword",
                                    "A chain of gold"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did the Lord say to Paul concerning His grace?",
                            new String[]{
                                    "It is sufficient",
                                    "It is temporary",
                                    "It is only for kings",
                                    "It is hidden"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say was made perfect in weakness?",
                            new String[]{
                                    "The law",
                                    "Christ's strength",
                                    "Human wisdom",
                                    "Earthly power"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul tell the Corinthians to examine?",
                            new String[]{
                                    "Their wealth",
                                    "Their houses",
                                    "Themselves, whether they be in the faith",
                                    "Their political leaders"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul wish for the Corinthians in his closing words?",
                            new String[]{
                                    "The grace of the Lord Jesus Christ",
                                    "Earthly riches",
                                    "Military protection",
                                    "A Roman position"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul encourage the Corinthians to do in 2 Corinthians 13?",
                            new String[]{
                                    "Seek earthly power",
                                    "Live in peace",
                                    "Return to Egypt",
                                    "Avoid one another"
                            },
                            1
                    ));
                }
        }

        private static void addBookGalatiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the book of Galatians?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was Galatians written?",
                            new String[]{
                                    "The Romans",
                                    "The Galatians",
                                    "The Corinthians",
                                    "The Philippians"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul marvel that the Galatians were so soon removed from?",
                            new String[]{
                                    "The law of Moses",
                                    "The traditions of Israel",
                                    "Him that called them into the grace of Christ",
                                    "The city of Jerusalem"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say should happen to anyone preaching another gospel?",
                            new String[]{
                                    "Let him be accursed",
                                    "Let him become a king",
                                    "Let him teach in Jerusalem",
                                    "Let him receive a reward"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Paul said his gospel was not after what?",
                            new String[]{
                                    "The Scriptures",
                                    "Man",
                                    "Christ",
                                    "Faith"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Whom did Paul rebuke at Antioch?",
                            new String[]{
                                    "Barnabas",
                                    "James",
                                    "Peter",
                                    "Timothy"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say about his life in Galatians 2:20?",
                            new String[]{
                                    "I live by the law",
                                    "I live for myself",
                                    "I live in the flesh only",
                                    "Christ liveth in me"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "How does Paul say a person is justified?",
                            new String[]{
                                    "By the works of the law",
                                    "By faith of Jesus Christ",
                                    "By earthly wealth",
                                    "By keeping Roman customs"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who is given as an example of one who believed God?",
                            new String[]{
                                    "Abraham",
                                    "Pharaoh",
                                    "Pilate",
                                    "Herod"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Abraham believe, and it was counted to him for righteousness?",
                            new String[]{
                                    "The law",
                                    "The prophets",
                                    "God",
                                    "The Roman government"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul call the law in relation to Christ?",
                            new String[]{
                                    "A king",
                                    "A schoolmaster",
                                    "A temple",
                                    "A prophet"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "In Christ Jesus, what does Paul say makes a person a child of God?",
                            new String[]{
                                    "Faith",
                                    "Wealth",
                                    "Family name",
                                    "Political position"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What are believers described as through Christ?",
                            new String[]{
                                    "Servants of Rome",
                                    "Children of God",
                                    "Kings of Israel",
                                    "Priests of Egypt"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say Christ has given believers?",
                            new String[]{
                                    "Political authority",
                                    "Earthly riches",
                                    "Liberty",
                                    "Military power"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul warn believers not to use their liberty as?",
                            new String[]{
                                    "An occasion to the flesh",
                                    "A reason to pray",
                                    "A reason to love",
                                    "A way to serve"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What command summarizes the law according to Galatians 5?",
                            new String[]{
                                    "Love thy neighbour as thyself",
                                    "Build the temple",
                                    "Keep Roman customs",
                                    "Seek earthly riches"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Which of these is a fruit of the Spirit?",
                            new String[]{
                                    "Pride",
                                    "Hatred",
                                    "Love",
                                    "Envy"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Which of these is listed among the works of the flesh?",
                            new String[]{
                                    "Love",
                                    "Joy",
                                    "Peace",
                                    "Idolatry"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What should believers do when someone is overtaken in a fault?",
                            new String[]{
                                    "Restore such a one in the spirit of meekness",
                                    "Cast them out immediately",
                                    "Ignore them",
                                    "Judge them publicly"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What are believers told to bear for one another?",
                            new String[]{
                                    "Riches",
                                    "Burdens",
                                    "Weapons",
                                    "Titles"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does a person reap according to Galatians 6?",
                            new String[]{
                                    "What he sows",
                                    "What his neighbour sows",
                                    "Only what he asks for",
                                    "Nothing"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers not become weary in?",
                            new String[]{
                                    "Travel",
                                    "Well doing",
                                    "Eating",
                                    "Building"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What happens to the person who sows to the Spirit?",
                            new String[]{
                                    "He receives earthly riches",
                                    "He becomes a ruler",
                                    "He shall of the Spirit reap life everlasting",
                                    "He becomes famous"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What does Paul say matters in Christ Jesus?",
                            new String[]{
                                    "Being a new creature",
                                    "Being wealthy",
                                    "Being famous",
                                    "Being politically powerful"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he bore in his body?",
                            new String[]{
                                    "The marks of the Lord Jesus",
                                    "The crown of David",
                                    "The seal of Rome",
                                    "The law of Moses"
                            },
                            0
                    ));
                }
        }

        private static void addBookEphesiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the book of Ephesians?",
                            new String[]{
                                    "Peter",
                                    "Paul",
                                    "John",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To whom was Ephesians addressed?",
                            new String[]{
                                    "The saints at Ephesus",
                                    "The church at Corinth",
                                    "The Romans",
                                    "The Galatians"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What has God blessed believers with in heavenly places?",
                            new String[]{
                                    "Earthly riches",
                                    "Political power",
                                    "All spiritual blessings",
                                    "Military strength"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "According to Ephesians 2, believers are saved by what?",
                            new String[]{
                                    "Grace through faith",
                                    "Works of the law",
                                    "Earthly wisdom",
                                    "Human strength"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does Ephesians 2 say salvation is not of?",
                            new String[]{
                                    "Faith",
                                    "God",
                                    "Works",
                                    "Grace"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What are believers described as God's workmanship?",
                            new String[]{
                                    "Created in Christ Jesus unto good works",
                                    "Created for earthly riches",
                                    "Created to rule nations",
                                    "Created to build temples"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Christ break down between Jews and Gentiles?",
                            new String[]{
                                    "The wall of partition",
                                    "The temple wall",
                                    "The city gate",
                                    "The Roman wall"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say believers should walk worthy of?",
                            new String[]{
                                    "Their riches",
                                    "The vocation wherewith they were called",
                                    "Their nationality",
                                    "Their education"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers endeavor to keep?",
                            new String[]{
                                    "The traditions of Rome",
                                    "The unity of the Spirit",
                                    "Their earthly possessions",
                                    "Political peace"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Christ give some people to be?",
                            new String[]{
                                    "Apostles",
                                    "Kings of Rome",
                                    "Military leaders",
                                    "Tax collectors"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers put off concerning their former conversation?",
                            new String[]{
                                    "The old man",
                                    "The new man",
                                    "The Holy Spirit",
                                    "Faith"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers put on?",
                            new String[]{
                                    "The old nature",
                                    "The new man",
                                    "Earthly riches",
                                    "Roman clothing"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers not let go down upon their wrath?",
                            new String[]{
                                    "The moon",
                                    "The stars",
                                    "The sun",
                                    "The light"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should believers not give place to?",
                            new String[]{
                                    "The devil",
                                    "The poor",
                                    "The stranger",
                                    "The teacher"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers be kind and tenderhearted toward one another in?",
                            new String[]{
                                    "Forgiving one another",
                                    "Judging one another",
                                    "Competing with one another",
                                    "Avoiding one another"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers be filled with according to Ephesians 5?",
                            new String[]{
                                    "Wine",
                                    "The Spirit",
                                    "Gold",
                                    "Knowledge of Rome"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers give thanks for?",
                            new String[]{
                                    "All things",
                                    "Only good weather",
                                    "Only riches",
                                    "Political success"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What relationship does Paul use to teach about Christ and the church?",
                            new String[]{
                                    "King and soldier",
                                    "Shepherd and city",
                                    "Husband and wife",
                                    "Teacher and student"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should husbands do for their wives?",
                            new String[]{
                                    "Love them",
                                    "Rule them harshly",
                                    "Ignore them",
                                    "Avoid them"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should children do according to Ephesians 6?",
                            new String[]{
                                    "Obey their parents",
                                    "Leave their families",
                                    "Rule their parents",
                                    "Avoid instruction"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should fathers not provoke their children to?",
                            new String[]{
                                    "Wisdom",
                                    "Wrath",
                                    "Faith",
                                    "Joy"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should servants do toward their masters?",
                            new String[]{
                                    "Obey them",
                                    "Fight them",
                                    "Ignore them",
                                    "Rule them"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers put on to stand against the wiles of the devil?",
                            new String[]{
                                    "The armour of God",
                                    "Roman armour",
                                    "Royal clothing",
                                    "A crown"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is described as the shield of the armour of God?",
                            new String[]{
                                    "Hope",
                                    "Faith",
                                    "Love",
                                    "Knowledge"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers do always?",
                            new String[]{
                                    "Pray",
                                    "Travel",
                                    "Fight",
                                    "Fast from everything"
                            },
                            0
                    ));
                }
        }

        private static void addBookPhilippiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote Philippians?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To which church was Philippians written?",
                            new String[]{
                                    "Ephesus",
                                    "Philippi",
                                    "Corinth",
                                    "Galatia"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say he was confident God would perform until the day of Jesus Christ?",
                            new String[]{
                                    "A good work",
                                    "A political reform",
                                    "A military victory",
                                    "A new temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say had happened to him for the furtherance of the gospel?",
                            new String[]{
                                    "His bonds",
                                    "His riches",
                                    "His travels",
                                    "His education"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he wanted Christ to be magnified in?",
                            new String[]{
                                    "His body",
                                    "His house",
                                    "His city",
                                    "His possessions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "For Paul, to live was what?",
                            new String[]{
                                    "Gain",
                                    "Christ",
                                    "Wealth",
                                    "Power"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "For Paul, to die was what?",
                            new String[]{
                                    "Defeat",
                                    "Gain",
                                    "Punishment",
                                    "Loss"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul urge the Philippians to let be in them?",
                            new String[]{
                                    "The mind of Christ",
                                    "The wisdom of Rome",
                                    "The spirit of competition",
                                    "The desire for wealth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Christ take upon Himself according to Philippians 2?",
                            new String[]{
                                    "The form of a servant",
                                    "The form of a king",
                                    "The form of an angel",
                                    "The form of a soldier"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What happened because Christ humbled Himself and became obedient unto death?",
                            new String[]{
                                    "God highly exalted Him",
                                    "He became a Roman ruler",
                                    "He received earthly wealth",
                                    "He returned to Nazareth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do without murmurings and disputings?",
                            new String[]{
                                    "Work out their own salvation",
                                    "Build a temple",
                                    "Gather riches",
                                    "Avoid prayer"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do in the midst of a crooked and perverse nation?",
                            new String[]{
                                    "Hide",
                                    "Shine as lights",
                                    "Become rulers",
                                    "Return to Jerusalem"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who did Paul describe as a fellow labourer?",
                            new String[]{
                                    "Timotheus",
                                    "Pilate",
                                    "Herod",
                                    "Caiaphas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul count as loss for Christ?",
                            new String[]{
                                    "The things that were gain to him",
                                    "The gospel",
                                    "His faith",
                                    "His hope"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul count all things as for the excellency of the knowledge of Christ?",
                            new String[]{
                                    "Dung",
                                    "Treasure",
                                    "Wisdom",
                                    "Gold"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he was pressing toward?",
                            new String[]{
                                    "The mark for the prize of the high calling of God",
                                    "Earthly riches",
                                    "Political authority",
                                    "A Roman crown"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where does Paul say the believer's conversation is?",
                            new String[]{
                                    "In heaven",
                                    "In Rome",
                                    "In Jerusalem",
                                    "In Corinth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell the Philippians to rejoice in?",
                            new String[]{
                                    "The Lord",
                                    "Their wealth",
                                    "Their position",
                                    "Their possessions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers' moderation be known unto?",
                            new String[]{
                                    "All men",
                                    "Only the apostles",
                                    "Only their families",
                                    "Only the church leaders"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers be careful for?",
                            new String[]{
                                    "Nothing",
                                    "Everything",
                                    "Only money",
                                    "Only food"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers make known unto God?",
                            new String[]{
                                    "Their requests",
                                    "Their wealth",
                                    "Their political views",
                                    "Their achievements"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What will keep hearts and minds according to Philippians 4?",
                            new String[]{
                                    "The peace of God",
                                    "Earthly wealth",
                                    "Military power",
                                    "Human wisdom"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers think about according to Philippians 4?",
                            new String[]{
                                    "Things that are true, honest, just, pure, lovely, and of good report",
                                    "Only earthly things",
                                    "Only riches",
                                    "Only political matters"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he had learned to be in whatever state he was?",
                            new String[]{
                                    "Content",
                                    "Angry",
                                    "Famous",
                                    "Rich"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he could do through Christ?",
                            new String[]{
                                    "All things",
                                    "Only travel",
                                    "Only preach",
                                    "Only suffer"
                            },
                            0
                    ));
                }
        }

    }

    private static class DataPart8 {

        static void addQuestions(ArrayList<Question> questions, String book, String difficulty) {

            if (book.equals("Colossians")) {
                addBookColossiansQuestions(questions, difficulty);
            }

            else if (book.equals("1 Thessalonians")) {
                addBook1ThessaloniansQuestions(questions, difficulty);
            }

            else if (book.equals("2 Thessalonians")) {
                addBook2ThessaloniansQuestions(questions, difficulty);
            }

            else if (book.equals("1 Timothy")) {
                addBook1TimothyQuestions(questions, difficulty);
            }

            else if (book.equals("2 Timothy")) {
                addBook2TimothyQuestions(questions, difficulty);
            }

            else if (book.equals("Titus")) {
                addBookTitusQuestions(questions, difficulty);
            }

            else if (book.equals("Philemon")) {
                addBookPhilemonQuestions(questions, difficulty);
            }

        }

        private static void addBookColossiansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote Colossians?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was Colossians written?",
                            new String[]{
                                    "The saints at Colosse",
                                    "The church at Rome",
                                    "The Galatians",
                                    "The Corinthians"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he heard about the Colossians?",
                            new String[]{
                                    "Their faith in Christ Jesus and love toward all the saints",
                                    "Their wealth",
                                    "Their military victories",
                                    "Their political influence"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is described as the image of the invisible God?",
                            new String[]{
                                    "Moses",
                                    "Jesus Christ",
                                    "Paul",
                                    "Abraham"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who is described as the firstborn of every creature?",
                            new String[]{
                                    "Adam",
                                    "David",
                                    "Christ",
                                    "Moses"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "By whom were all things created?",
                            new String[]{
                                    "Christ",
                                    "Paul",
                                    "Moses",
                                    "Angels"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is Christ the head of?",
                            new String[]{
                                    "The Roman Empire",
                                    "The body, the church",
                                    "The temple at Jerusalem",
                                    "The nation of Israel"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say was hid in Christ?",
                            new String[]{
                                    "All the treasures of wisdom and knowledge",
                                    "Earthly riches",
                                    "Roman law",
                                    "Military power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers beware of being spoiled through?",
                            new String[]{
                                    "Philosophy and vain deceit",
                                    "Prayer",
                                    "Faith",
                                    "Love"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers seek according to Colossians 3?",
                            new String[]{
                                    "Those things which are above",
                                    "Earthly riches",
                                    "Political power",
                                    "Fame"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where is Christ seated?",
                            new String[]{
                                    "At the right hand of God",
                                    "At the gate of Jerusalem",
                                    "On David's throne in Rome",
                                    "In the temple"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers mortify?",
                            new String[]{
                                    "Their members which are upon the earth",
                                    "Their faith",
                                    "Their hope",
                                    "Their prayers"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers put on above all things?",
                            new String[]{
                                    "Charity",
                                    "Wealth",
                                    "Power",
                                    "Knowledge"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should rule in believers' hearts?",
                            new String[]{
                                    "The peace of God",
                                    "Fear",
                                    "Anger",
                                    "Earthly ambition"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should dwell in believers richly?",
                            new String[]{
                                    "The word of Christ",
                                    "Earthly wealth",
                                    "Roman law",
                                    "Human philosophy"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do in word or deed?",
                            new String[]{
                                    "Do all in the name of the Lord Jesus",
                                    "Do everything for fame",
                                    "Follow Roman customs",
                                    "Seek political power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should wives do according to Colossians 3?",
                            new String[]{
                                    "Submit to their own husbands",
                                    "Rule every household",
                                    "Avoid their husbands",
                                    "Leave their families"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should husbands do?",
                            new String[]{
                                    "Love their wives",
                                    "Ignore their wives",
                                    "Rule harshly",
                                    "Avoid their families"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should children do?",
                            new String[]{
                                    "Obey their parents",
                                    "Rule their parents",
                                    "Leave home immediately",
                                    "Ignore instruction"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should fathers not provoke their children to?",
                            new String[]{
                                    "Anger",
                                    "Faith",
                                    "Wisdom",
                                    "Joy"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should servants do?",
                            new String[]{
                                    "Obey their masters",
                                    "Fight their masters",
                                    "Ignore their masters",
                                    "Rule their masters"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers continue in?",
                            new String[]{
                                    "Prayer",
                                    "Wealth",
                                    "Political activity",
                                    "Earthly ambition"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers walk in toward outsiders?",
                            new String[]{
                                    "Wisdom",
                                    "Anger",
                                    "Fear",
                                    "Pride"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers' speech always be?",
                            new String[]{
                                    "With grace, seasoned with salt",
                                    "Harsh and angry",
                                    "Long and complicated",
                                    "Silent"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was described as a faithful and beloved brother?",
                            new String[]{
                                    "Tychicus",
                                    "Pilate",
                                    "Herod",
                                    "Caiaphas"
                            },
                            0
                    ));
                }
        }

        private static void addBook1ThessaloniansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 1 Thessalonians?",
                            new String[]{
                                    "Peter",
                                    "Paul",
                                    "James",
                                    "John"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To which church was 1 Thessalonians written?",
                            new String[]{
                                    "The church at Corinth",
                                    "The church at Ephesus",
                                    "The church of the Thessalonians",
                                    "The church at Rome"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul remember about the Thessalonians?",
                            new String[]{
                                    "Their work of faith",
                                    "Their military victories",
                                    "Their earthly riches",
                                    "Their political influence"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did the Thessalonians turn to from idols?",
                            new String[]{
                                    "The law of Moses",
                                    "The living and true God",
                                    "The Roman government",
                                    "The temple"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What were the Thessalonians waiting for from heaven?",
                            new String[]{
                                    "An earthly king",
                                    "A new temple",
                                    "God's kingdom",
                                    "His Son"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "Who did Paul say delivered believers from the wrath to come?",
                            new String[]{
                                    "Jesus",
                                    "Moses",
                                    "David",
                                    "Peter"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he had been gentle among the Thessalonians as a?",
                            new String[]{
                                    "King",
                                    "Soldier",
                                    "Nursing mother",
                                    "Judge"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say he worked night and day so he would not be chargeable to them?",
                            new String[]{
                                    "Preaching only",
                                    "Eating only",
                                    "Travelling",
                                    "Laboring"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Paul say the Thessalonians received as the word of God?",
                            new String[]{
                                    "The word of God",
                                    "The traditions of men",
                                    "Roman law",
                                    "The wisdom of philosophers"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Paul send to strengthen and comfort the Thessalonians?",
                            new String[]{
                                    "Silas",
                                    "Timotheus",
                                    "Apollos",
                                    "Barnabas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say is the will of God for believers concerning their holiness?",
                            new String[]{
                                    "Their sanctification",
                                    "Their wealth",
                                    "Their political influence",
                                    "Their education"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers abstain from according to 1 Thessalonians 4?",
                            new String[]{
                                    "Prayer",
                                    "Work",
                                    "Fornication",
                                    "Fellowship"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say God has called believers unto?",
                            new String[]{
                                    "Holiness",
                                    "Earthly riches",
                                    "Political authority",
                                    "Military service"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say believers should do more and more concerning love?",
                            new String[]{
                                    "Avoid one another",
                                    "Increase in love",
                                    "Seek wealth",
                                    "Compete with one another"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul encourage believers to study to be quiet?",
                            new String[]{
                                    "Yes",
                                    "No",
                                    "Only on the Sabbath",
                                    "Only during prayer"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell believers to do with their own hands?",
                            new String[]{
                                    "Rule nations",
                                    "Build temples",
                                    "Work",
                                    "Write laws"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say believers should not sorrow as others who have no what?",
                            new String[]{
                                    "Faith",
                                    "Hope",
                                    "Riches",
                                    "Knowledge"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What will happen to the dead in Christ when the Lord descends from heaven?",
                            new String[]{
                                    "They shall rise first",
                                    "They shall remain in the grave",
                                    "They shall become angels",
                                    "They shall return to Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where will believers be caught up to meet the Lord?",
                            new String[]{
                                    "At the temple",
                                    "In the air",
                                    "In Jerusalem",
                                    "On Mount Sinai"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers do concerning the coming day of the Lord?",
                            new String[]{
                                    "Be watchful and sober",
                                    "Stop working",
                                    "Hide from everyone",
                                    "Return to Egypt"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do without ceasing?",
                            new String[]{
                                    "Travel",
                                    "Pray",
                                    "Fast",
                                    "Work"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should believers do in every thing?",
                            new String[]{
                                    "Give thanks",
                                    "Complain",
                                    "Seek riches",
                                    "Avoid others"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers not quench?",
                            new String[]{
                                    "Faith",
                                    "Love",
                                    "The Spirit",
                                    "Hope"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should believers prove?",
                            new String[]{
                                    "All things",
                                    "Only miracles",
                                    "Only teachings",
                                    "Only prophecies"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul ask the Thessalonians to pray for?",
                            new String[]{
                                    "His wealth",
                                    "His journey to Rome",
                                    "His political position",
                                    "The word of the Lord to have free course"
                            },
                            3
                    ));
                }
        }

        private static void addBook2ThessaloniansQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 2 Thessalonians?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "James",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was 2 Thessalonians written?",
                            new String[]{
                                    "The Romans",
                                    "The Thessalonians",
                                    "The Galatians",
                                    "The Ephesians"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say was growing exceedingly among the Thessalonians?",
                            new String[]{
                                    "Their wealth",
                                    "Their political influence",
                                    "Their faith",
                                    "Their army"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say was abounding toward one another?",
                            new String[]{
                                    "Their love",
                                    "Their riches",
                                    "Their knowledge of Rome",
                                    "Their possessions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say the Thessalonians were enduring?",
                            new String[]{
                                    "Persecutions and tribulations",
                                    "Famine only",
                                    "Political disputes",
                                    "A journey"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "When will the Lord Jesus be revealed from heaven?",
                            new String[]{
                                    "With the angels of God",
                                    "With the temple priests",
                                    "With the kings of Israel",
                                    "With the Roman army"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "With what will the Lord Jesus be revealed?",
                            new String[]{
                                    "A crown only",
                                    "A sword",
                                    "Flaming fire",
                                    "A trumpet only"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul say believers should not be soon shaken or troubled about?",
                            new String[]{
                                    "The day of Christ",
                                    "Their daily work",
                                    "Their food",
                                    "Their clothing"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What must come before the day of Christ?",
                            new String[]{
                                    "A new temple",
                                    "A falling away",
                                    "A Roman victory",
                                    "A new king"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who is described as the man of sin?",
                            new String[]{
                                    "The son of perdition",
                                    "The son of David",
                                    "The son of Abraham",
                                    "The son of Peter"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does the man of sin exalt himself above?",
                            new String[]{
                                    "The poor",
                                    "All that is called God",
                                    "The Roman government",
                                    "The apostles"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say the Lord shall destroy with the spirit of His mouth?",
                            new String[]{
                                    "The man of sin",
                                    "Rome",
                                    "The temple",
                                    "The church"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did God call the Thessalonians to obtain?",
                            new String[]{
                                    "The glory of our Lord Jesus Christ",
                                    "Earthly riches",
                                    "Political authority",
                                    "The kingdom of Rome"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul ask the Thessalonians to hold fast to?",
                            new String[]{
                                    "The traditions which they had been taught",
                                    "Roman customs",
                                    "Earthly wealth",
                                    "Political laws"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul ask the Lord to direct into?",
                            new String[]{
                                    "The love of God",
                                    "The wealth of kings",
                                    "The wisdom of Rome",
                                    "Military strength"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul command concerning people who refused to work?",
                            new String[]{
                                    "Let them become rulers",
                                    "Let them work",
                                    "Give them political positions",
                                    "Ignore the matter"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say, 'If any would not work'?",
                            new String[]{
                                    "Neither should he eat",
                                    "He should become a teacher",
                                    "He should receive riches",
                                    "He should leave the church"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What were some believers doing that Paul said they should not?",
                            new String[]{
                                    "Praying",
                                    "Working",
                                    "Working not at all",
                                    "Giving thanks"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What were some people doing instead of working?",
                            new String[]{
                                    "Working miracles",
                                    "Being busybodies",
                                    "Preaching the gospel",
                                    "Helping the poor"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul command such people to do?",
                            new String[]{
                                    "Work with quietness",
                                    "Travel to Rome",
                                    "Become rulers",
                                    "Leave their families"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers not be weary in?",
                            new String[]{
                                    "Well doing",
                                    "Travelling",
                                    "Eating",
                                    "Sleeping"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers do if someone does not obey Paul's word?",
                            new String[]{
                                    "Note that man",
                                    "Make him king",
                                    "Give him riches",
                                    "Send him to Rome"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How should believers regard such a person?",
                            new String[]{
                                    "As an enemy",
                                    "As a brother",
                                    "As a stranger forever",
                                    "As a ruler"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul desire the Lord to give the Thessalonians?",
                            new String[]{
                                    "Peace always by all means",
                                    "Earthly riches",
                                    "Military protection",
                                    "Political power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How did Paul identify his greeting at the end of the letter?",
                            new String[]{
                                    "With his own hand",
                                    "Through Peter",
                                    "Through Timothy only",
                                    "By a Roman messenger"
                            },
                            0
                    ));
                }
        }

        private static void addBook1TimothyQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 1 Timothy?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was 1 Timothy written?",
                            new String[]{
                                    "Titus",
                                    "Timothy",
                                    "Philemon",
                                    "Silas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul call Timothy?",
                            new String[]{
                                    "His beloved son in the faith",
                                    "His brother in Rome",
                                    "His fellow king",
                                    "His servant in Jerusalem"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where did Paul urge Timothy to remain?",
                            new String[]{
                                    "Jerusalem",
                                    "Corinth",
                                    "Ephesus",
                                    "Rome"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to charge some people not to teach?",
                            new String[]{
                                    "Other doctrine",
                                    "The gospel",
                                    "Prayer",
                                    "Faith"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is the end of the commandment according to 1 Timothy?",
                            new String[]{
                                    "Charity out of a pure heart",
                                    "Earthly riches",
                                    "Political authority",
                                    "Military strength"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Paul say Christ Jesus came into the world to save?",
                            new String[]{
                                    "Kings",
                                    "Sinners",
                                    "Soldiers",
                                    "Pharisees only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say he was appointed as?",
                            new String[]{
                                    "A preacher and an apostle",
                                    "A Roman governor",
                                    "A temple guard",
                                    "A king"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers pray for kings and those in authority?",
                            new String[]{
                                    "That we may lead a quiet and peaceable life",
                                    "That they become rich",
                                    "That they conquer nations",
                                    "That they build temples"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How many mediators are there between God and men?",
                            new String[]{
                                    "Two",
                                    "Many",
                                    "One",
                                    "Seven"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who is the mediator between God and men?",
                            new String[]{
                                    "Moses",
                                    "Jesus Christ",
                                    "Paul",
                                    "Abraham"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What does Paul say women should adorn themselves with?",
                            new String[]{
                                    "Modest apparel",
                                    "Gold only",
                                    "Royal clothing",
                                    "Military clothing"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What office is described in 1 Timothy 3 as a good work?",
                            new String[]{
                                    "The office of a bishop",
                                    "The office of a king",
                                    "The office of a soldier",
                                    "The office of a tax collector"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should a bishop be able to do?",
                            new String[]{
                                    "Rule a nation",
                                    "Teach",
                                    "Lead an army",
                                    "Collect taxes"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should a bishop have concerning his own house?",
                            new String[]{
                                    "His children in subjection with all gravity",
                                    "A large amount of wealth",
                                    "A military guard",
                                    "A royal palace"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What office is also mentioned in 1 Timothy 3?",
                            new String[]{
                                    "Deacon",
                                    "Governor",
                                    "Soldier",
                                    "King"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul call the church of the living God?",
                            new String[]{
                                    "The pillar and ground of the truth",
                                    "The kingdom of Rome",
                                    "The house of David",
                                    "The temple of Solomon"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say some would depart from in the latter times?",
                            new String[]{
                                    "The faith",
                                    "Their families",
                                    "Their work",
                                    "Their cities"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to refuse?",
                            new String[]{
                                    "Faith",
                                    "Fellowship",
                                    "Profane and old wives' fables",
                                    "Prayer"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should Timothy exercise himself unto?",
                            new String[]{
                                    "Godliness",
                                    "Military strength",
                                    "Political influence",
                                    "Earthly riches"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is profitable unto all things?",
                            new String[]{
                                    "Godliness",
                                    "Wealth",
                                    "Education",
                                    "Political power"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say is the love of money?",
                            new String[]{
                                    "The root of all evil",
                                    "The root of all wisdom",
                                    "A spiritual gift",
                                    "A sign of salvation"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to flee?",
                            new String[]{
                                    "These things",
                                    "Prayer",
                                    "Faith",
                                    "Good works"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to follow?",
                            new String[]{
                                    "Righteousness, godliness, faith, love, patience, meekness",
                                    "Wealth and power",
                                    "Earthly fame",
                                    "Political authority"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to fight?",
                            new String[]{
                                    "The good fight of faith",
                                    "The Roman army",
                                    "The Pharisees",
                                    "Earthly kingdoms"
                            },
                            0
                    ));
                }
        }

        private static void addBook2TimothyQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote 2 Timothy?",
                            new String[]{
                                    "Peter",
                                    "Paul",
                                    "John",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "To whom was 2 Timothy written?",
                            new String[]{
                                    "Titus",
                                    "Philemon",
                                    "Timothy",
                                    "Silas"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul remind Timothy to stir up?",
                            new String[]{
                                    "The gift of God",
                                    "His wealth",
                                    "His political influence",
                                    "His earthly possessions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What spirit has God given believers?",
                            new String[]{
                                    "A spirit of fear",
                                    "A spirit of anger",
                                    "A spirit of fear and doubt",
                                    "The spirit of power, love, and a sound mind"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy not to be ashamed of?",
                            new String[]{
                                    "The testimony of our Lord",
                                    "His education",
                                    "His family",
                                    "His occupation"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who saved us and called us with an holy calling?",
                            new String[]{
                                    "Moses",
                                    "God",
                                    "Peter",
                                    "Timothy"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say he knew whom he had believed?",
                            new String[]{
                                    "Rome",
                                    "Timothy",
                                    "God",
                                    "The church"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to hold fast?",
                            new String[]{
                                    "The form of sound words",
                                    "Earthly riches",
                                    "Roman customs",
                                    "Political traditions"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Timothy receive from Paul?",
                            new String[]{
                                    "A crown",
                                    "A palace",
                                    "A military command",
                                    "The good thing committed unto him"
                            },
                            3
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to be strong in?",
                            new String[]{
                                    "The grace that is in Christ Jesus",
                                    "The power of Rome",
                                    "Human wisdom",
                                    "Earthly wealth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should a good soldier of Jesus Christ avoid being entangled with?",
                            new String[]{
                                    "The affairs of this life",
                                    "Prayer",
                                    "Faith",
                                    "Good works"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What must a man do to be crowned?",
                            new String[]{
                                    "Become wealthy",
                                    "Strive lawfully",
                                    "Become famous",
                                    "Become a ruler"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to remember?",
                            new String[]{
                                    "Jesus Christ, of the seed of David, was raised from the dead",
                                    "The kings of Rome",
                                    "The temple of Solomon",
                                    "The law of Caesar"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What kind of workman should Timothy be?",
                            new String[]{
                                    "A wealthy workman",
                                    "A Roman workman",
                                    "A workman that needeth not to be ashamed",
                                    "A political workman"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What should Timothy rightly divide?",
                            new String[]{
                                    "The word of truth",
                                    "The Roman law",
                                    "The temple",
                                    "The nation"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Timothy flee?",
                            new String[]{
                                    "Prayer",
                                    "Youthful lusts",
                                    "Faith",
                                    "Good works"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should Timothy follow with them that call on the Lord?",
                            new String[]{
                                    "Righteousness, faith, charity, peace",
                                    "Wealth, fame, power, honor",
                                    "Politics, education, riches, strength",
                                    "Travel, work, trade, business"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should the servant of the Lord be gentle toward?",
                            new String[]{
                                    "All men",
                                    "Only rulers",
                                    "Only church leaders",
                                    "Only family members"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Timothy continue in?",
                            new String[]{
                                    "Earthly traditions",
                                    "The things which he had learned",
                                    "Political teachings",
                                    "Roman customs"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What Scripture is described as being given by inspiration of God?",
                            new String[]{
                                    "The Scriptures",
                                    "Roman law",
                                    "Philosophy",
                                    "Greek poetry"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What is Scripture profitable for?",
                            new String[]{
                                    "Doctrine, reproof, correction, instruction in righteousness",
                                    "Political leadership only",
                                    "Building cities",
                                    "Military training"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul tell Timothy to preach?",
                            new String[]{
                                    "The word",
                                    "Roman law",
                                    "Philosophy",
                                    "Political speeches"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say people would have itching ears for?",
                            new String[]{
                                    "Riches",
                                    "Teachers",
                                    "Military leaders",
                                    "Kings"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say he had fought?",
                            new String[]{
                                    "A good fight",
                                    "A political battle",
                                    "A Roman war",
                                    "A physical contest"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What crown did Paul say was laid up for him?",
                            new String[]{
                                    "A crown of gold",
                                    "A crown of righteousness",
                                    "A crown of David",
                                    "A crown of kingship"
                            },
                            1
                    ));
                }
        }

        private static void addBookTitusQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote Titus?",
                            new String[]{
                                    "Paul",
                                    "Peter",
                                    "John",
                                    "James"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "To whom was Titus written?",
                            new String[]{
                                    "Timothy",
                                    "Titus",
                                    "Philemon",
                                    "Silas"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Where did Paul leave Titus?",
                            new String[]{
                                    "Crete",
                                    "Rome",
                                    "Ephesus",
                                    "Corinth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Why did Paul leave Titus in Crete?",
                            new String[]{
                                    "To collect taxes",
                                    "To lead an army",
                                    "To set in order the things that were wanting",
                                    "To build a palace"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What was Titus instructed to ordain in every city?",
                            new String[]{
                                    "Kings",
                                    "Elders",
                                    "Soldiers",
                                    "Governors"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should an elder be according to Titus 1?",
                            new String[]{
                                    "Blameless",
                                    "Wealthy",
                                    "Famous",
                                    "Powerful"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should an elder hold fast?",
                            new String[]{
                                    "The traditions of Rome",
                                    "The faithful word",
                                    "Political laws",
                                    "Earthly riches"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What kind of people did Paul say there were many in Crete?",
                            new String[]{
                                    "Unruly and vain talkers and deceivers",
                                    "Kings and soldiers",
                                    "Prophets and priests",
                                    "Farmers and fishermen"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Titus teach older men to be?",
                            new String[]{
                                    "Sober, grave, temperate, sound in faith, charity, and patience",
                                    "Rich and powerful",
                                    "Political and influential",
                                    "Famous and educated"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should older women teach younger women?",
                            new String[]{
                                    "To be wealthy",
                                    "To love their husbands and children",
                                    "To become rulers",
                                    "To avoid their families"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What should younger women be taught to love?",
                            new String[]{
                                    "Their own husbands",
                                    "Earthly riches",
                                    "Political authority",
                                    "Fame"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should younger men be sober-minded in?",
                            new String[]{
                                    "All things",
                                    "Money only",
                                    "Politics only",
                                    "Travel only"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Titus show himself as a pattern of?",
                            new String[]{
                                    "Good works",
                                    "Political leadership",
                                    "Military strength",
                                    "Earthly success"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should servants be obedient to their own?",
                            new String[]{
                                    "Masters",
                                    "Kings",
                                    "Governors",
                                    "Neighbours"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What has the grace of God appeared to?",
                            new String[]{
                                    "All men",
                                    "Only kings",
                                    "Only the apostles",
                                    "Only the Jews"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What does the grace of God teach believers to deny?",
                            new String[]{
                                    "Ungodliness and worldly lusts",
                                    "Prayer and faith",
                                    "Good works",
                                    "Love"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How should believers live in this present world?",
                            new String[]{
                                    "Soberly, righteously, and godly",
                                    "Richly, proudly, and powerfully",
                                    "Quietly, politically, and wisely",
                                    "Fiercely, boldly, and proudly"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What are believers looking for?",
                            new String[]{
                                    "The blessed hope",
                                    "Earthly riches",
                                    "Political power",
                                    "A new kingdom on earth"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who is called the great God and our Saviour?",
                            new String[]{
                                    "Jesus Christ",
                                    "Moses",
                                    "David",
                                    "Paul"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Christ give Himself for us to redeem us from?",
                            new String[]{
                                    "All iniquity",
                                    "Roman rule",
                                    "Poverty",
                                    "Earthly suffering"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What kind of people did Christ purify unto Himself?",
                            new String[]{
                                    "A peculiar people",
                                    "A political army",
                                    "A wealthy nation",
                                    "A royal family"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Titus affirm constantly?",
                            new String[]{
                                    "That they which have believed in God might be careful to maintain good works",
                                    "That believers should seek riches",
                                    "That Christians should become rulers",
                                    "That believers should avoid work"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers be ready to do?",
                            new String[]{
                                    "Every good work",
                                    "Every political task",
                                    "Every military task",
                                    "Every business venture"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should believers avoid concerning foolish questions?",
                            new String[]{
                                    "They should avoid them",
                                    "They should debate them constantly",
                                    "They should write books about them",
                                    "They should teach them"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What should Titus reject after the first and second admonition?",
                            new String[]{
                                    "An heretick",
                                    "A poor man",
                                    "A stranger",
                                    "A new believer"
                            },
                            0
                    ));
                }
        }

        private static void addBookPhilemonQuestions(ArrayList<Question> questions, String difficulty) {

                if (difficulty.equals("Easy")) {

                    questions.add(new Question(
                            "Who wrote the letter to Philemon?",
                            new String[]{
                                    "Peter",
                                    "Paul",
                                    "John",
                                    "James"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was Philemon?",
                            new String[]{
                                    "A Roman governor",
                                    "A soldier",
                                    "A fellow labourer of Paul",
                                    "A king"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "Who was the person at the center of Paul's request to Philemon?",
                            new String[]{
                                    "Onesimus",
                                    "Timothy",
                                    "Titus",
                                    "Silas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How did Paul describe Onesimus?",
                            new String[]{
                                    "His son",
                                    "His brother in Rome",
                                    "His fellow king",
                                    "His Roman master"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Where was Paul when he wrote to Philemon?",
                            new String[]{
                                    "In prison",
                                    "In Jerusalem",
                                    "In Corinth",
                                    "In Galilee"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say had happened to Onesimus?",
                            new String[]{
                                    "He had become a king",
                                    "He had become a Roman soldier",
                                    "He had become useful",
                                    "He had become a governor"
                            },
                            2
                    ));

                    questions.add(new Question(
                            "What did Paul ask Philemon to receive Onesimus as?",
                            new String[]{
                                    "A stranger",
                                    "A beloved brother",
                                    "A Roman citizen",
                                    "A servant only"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "What did Paul say Onesimus might have wronged Philemon in?",
                            new String[]{
                                    "Anything",
                                    "Nothing",
                                    "Only money",
                                    "Only food"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who did Paul say would repay anything Onesimus owed?",
                            new String[]{
                                    "Paul",
                                    "Timothy",
                                    "Titus",
                                    "Onesimus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say Philemon owed him?",
                            new String[]{
                                    "His own self",
                                    "Money",
                                    "A house",
                                    "A position"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul ask Philemon to do for him?",
                            new String[]{
                                    "Prepare him a lodging",
                                    "Build him a temple",
                                    "Send him to Rome",
                                    "Give him a crown"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul hope to receive through Philemon's prayers?",
                            new String[]{
                                    "His release",
                                    "A crown",
                                    "Riches",
                                    "A political position"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was described as a fellow prisoner with Paul?",
                            new String[]{
                                    "Epaphras",
                                    "Peter",
                                    "Timothy",
                                    "Titus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who else sent greetings to Philemon?",
                            new String[]{
                                    "Marcus",
                                    "Pilate",
                                    "Herod",
                                    "Caiaphas"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was described as Paul's fellow labourer?",
                            new String[]{
                                    "Demas",
                                    "Archippus",
                                    "Luke",
                                    "Epaphras"
                            },
                            1
                    ));

                    questions.add(new Question(
                            "Who was described as a fellow soldier?",
                            new String[]{
                                    "Archippus",
                                    "Demas",
                                    "Onesimus",
                                    "Tychicus"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Who was with Paul when he wrote the letter?",
                            new String[]{
                                    "Timothy",
                                    "Peter",
                                    "James",
                                    "John"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul hear about Philemon?",
                            new String[]{
                                    "His love and faith toward the Lord Jesus and all saints",
                                    "His wealth",
                                    "His political success",
                                    "His military achievements"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul want Philemon's communication of faith to become?",
                            new String[]{
                                    "Effectual",
                                    "Political",
                                    "Financial",
                                    "Military"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he had great joy and consolation in?",
                            new String[]{
                                    "Philemon's love",
                                    "Philemon's wealth",
                                    "Philemon's position",
                                    "Philemon's house"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "Whose heart had been refreshed by Philemon?",
                            new String[]{
                                    "The saints",
                                    "Roman soldiers",
                                    "Kings",
                                    "Pharisees"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "How did Paul prefer to make his request to Philemon?",
                            new String[]{
                                    "For love's sake",
                                    "By force",
                                    "By law",
                                    "By political authority"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say he could have commanded Philemon to do?",
                            new String[]{
                                    "That which is convenient",
                                    "That which is unlawful",
                                    "That which is political",
                                    "That which is profitable"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul ask Philemon to do concerning Onesimus?",
                            new String[]{
                                    "Receive him as himself",
                                    "Send him away",
                                    "Punish him",
                                    "Ignore him"
                            },
                            0
                    ));

                    questions.add(new Question(
                            "What did Paul say the grace of the Lord Jesus Christ should be with?",
                            new String[]{
                                    "Your spirit",
                                    "Your house",
                                    "Your nation",
                                    "Your possessions"
                            },
                            0
                    ));
                }
        }
        private static void addBookHebrewsQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who is the Son of God described in Hebrews?",
                new String[]{
                        "Jesus Christ",
                        "Moses",
                        "Aaron",
                        "Joshua"
                },
                0
        ));

        questions.add(new Question(
                "Who was faithful as a servant over God's house?",
                new String[]{
                        "David",
                        "Moses",
                        "Samuel",
                        "Elijah"
                },
                1
        ));

        questions.add(new Question(
                "Who is faithful over God's house as a Son?",
                new String[]{
                        "Aaron",
                        "Joshua",
                        "Christ",
                        "Samuel"
                },
                2
        ));

        questions.add(new Question(
                "What did the Israelites fail to enter because of unbelief?",
                new String[]{
                        "The promised land",
                        "Egypt",
                        "Babylon",
                        "Rome"
                },
                0
        ));

        questions.add(new Question(
                "What does Hebrews say is living and powerful?",
                new String[]{
                        "The temple",
                        "The law",
                        "The word of God",
                        "The priesthood"
                },
                2
        ));

        questions.add(new Question(
                "What is Jesus called in Hebrews?",
                new String[]{
                        "A Roman governor",
                        "A great High Priest",
                        "A temple guard",
                        "A prophet of Baal"
                },
                1
        ));

        questions.add(new Question(
                "What should believers approach boldly?",
                new String[]{
                        "The throne of grace",
                        "The Roman court",
                        "The temple gate",
                        "The throne of Caesar"
                },
                0
        ));

        questions.add(new Question(
                "Who was the king and priest of Salem?",
                new String[]{
                        "Aaron",
                        "Zadok",
                        "Melchisedec",
                        "Eli"
                },
                2
        ));

        questions.add(new Question(
                "What does Hebrews say faith is?",
                new String[]{
                        "The evidence of things hoped for",
                        "Earthly wisdom",
                        "A political power",
                        "A type of sacrifice"
                },
                0
        ));

        questions.add(new Question(
                "Who built an ark by faith?",
                new String[]{
                        "Abraham",
                        "Noah",
                        "Moses",
                        "Isaac"
                },
                1
        ));

        questions.add(new Question(
                "Who went out without knowing where he was going?",
                new String[]{
                        "Abraham",
                        "David",
                        "Joseph",
                        "Samuel"
                },
                0
        ));

        questions.add(new Question(
                "Who received strength to conceive because she judged God faithful?",
                new String[]{
                        "Rachel",
                        "Hannah",
                        "Sarah",
                        "Leah"
                },
                2
        ));

        questions.add(new Question(
                "Who offered up Isaac by faith?",
                new String[]{
                        "Jacob",
                        "Abraham",
                        "Moses",
                        "Joseph"
                },
                1
        ));

        questions.add(new Question(
                "Who chose to suffer with God's people?",
                new String[]{
                        "Aaron",
                        "Joshua",
                        "Moses",
                        "Caleb"
                },
                2
        ));

        questions.add(new Question(
                "What happened to the walls of Jericho by faith?",
                new String[]{
                        "They fell down",
                        "They became stronger",
                        "They were rebuilt",
                        "They caught fire"
                },
                0
        ));

        questions.add(new Question(
                "What does Hebrews tell believers to lay aside?",
                new String[]{
                        "Their possessions",
                        "Every weight and sin",
                        "Their families",
                        "Their homes"
                },
                1
        ));

        questions.add(new Question(
                "Who should believers look unto?",
                new String[]{
                        "Jesus",
                        "Moses",
                        "David",
                        "Abraham"
                },
                0
        ));

        questions.add(new Question(
                "Whom does the Lord chasten?",
                new String[]{
                        "Only kings",
                        "Only priests",
                        "Those He loves",
                        "Only sinners"
                },
                2
        ));

        questions.add(new Question(
                "What should believers follow with all men?",
                new String[]{
                        "Riches",
                        "Peace",
                        "Power",
                        "Fame"
                },
                1
        ));

        questions.add(new Question(
                "What should believers not forget to show to strangers?",
                new String[]{
                        "Hospitality",
                        "Anger",
                        "Fear",
                        "Wealth"
                },
                0
        ));

        questions.add(new Question(
                "Whom does Hebrews tell believers to remember?",
                new String[]{
                        "Those in bonds",
                        "Roman soldiers",
                        "Kings",
                        "Merchants"
                },
                0
        ));

        questions.add(new Question(
                "What does Hebrews say about marriage?",
                new String[]{
                        "It is forbidden",
                        "It is honourable in all",
                        "It is only for priests",
                        "It should be avoided"
                },
                1
        ));

        questions.add(new Question(
                "What should believers be content with?",
                new String[]{
                        "Such things as they have",
                        "Great riches",
                        "Political power",
                        "Military strength"
                },
                0
        ));

        questions.add(new Question(
                "Who is the same yesterday, today, and forever?",
                new String[]{
                        "Moses",
                        "Abraham",
                        "David",
                        "Jesus Christ"
                },
                3
        ));

        questions.add(new Question(
                "What should believers continually offer to God?",
                new String[]{
                        "The sacrifice of praise",
                        "Gold",
                        "Animals",
                        "Political gifts"
                },
                0
        ));
    }
        }
        private static void addBookJamesQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote the letter of James?",
                new String[]{
                        "Peter",
                        "James",
                        "Paul",
                        "John"
                },
                1
        ));

        questions.add(new Question(
                "What should believers count as joy when they fall into trials?",
                new String[]{
                        "The testing of their faith",
                        "Their wealth",
                        "Their popularity",
                        "Their success"
                },
                0
        ));

        questions.add(new Question(
                "What does the testing of faith produce?",
                new String[]{
                        "Riches",
                        "Power",
                        "Patience",
                        "Fame"
                },
                2
        ));

        questions.add(new Question(
                "What should a person ask God for if they lack it?",
                new String[]{
                        "Wisdom",
                        "Gold",
                        "Fame",
                        "Power"
                },
                0
        ));

        questions.add(new Question(
                "How does God give wisdom?",
                new String[]{
                        "Sparingly",
                        "Only to kings",
                        "Liberally",
                        "Only to priests"
                },
                2
        ));

        questions.add(new Question(
                "What is a person who doubts compared to?",
                new String[]{
                        "A strong tree",
                        "A wave of the sea",
                        "A mountain",
                        "A burning fire"
                },
                1
        ));

        questions.add(new Question(
                "What does the rich man eventually do?",
                new String[]{
                        "Fades away",
                        "Becomes king",
                        "Builds a temple",
                        "Becomes a priest"
                },
                0
        ));

        questions.add(new Question(
                "What crown is promised to those who love God?",
                new String[]{
                        "A crown of gold",
                        "A crown of life",
                        "A crown of silver",
                        "A crown of victory"
                },
                1
        ));

        questions.add(new Question(
                "What does James say happens when a person is tempted?",
                new String[]{
                        "God causes the temptation",
                        "The person's own lust draws them away",
                        "Angels cause it",
                        "Kings cause it"
                },
                1
        ));

        questions.add(new Question(
                "What comes down from the Father of lights?",
                new String[]{
                        "Every good and perfect gift",
                        "Earthly riches",
                        "Military power",
                        "Political authority"
                },
                0
        ));

        questions.add(new Question(
                "What should believers be swift to do?",
                new String[]{
                        "Speak",
                        "Judge",
                        "Hear",
                        "Argue"
                },
                2
        ));

        questions.add(new Question(
                "What should believers be slow to do?",
                new String[]{
                        "Speak",
                        "Pray",
                        "Love",
                        "Help"
                },
                0
        ));

        questions.add(new Question(
                "What should believers be slow to become?",
                new String[]{
                        "Happy",
                        "Angry",
                        "Wise",
                        "Hopeful"
                },
                1
        ));

        questions.add(new Question(
                "What kind of religion does James describe as pure?",
                new String[]{
                        "Visiting the fatherless and widows",
                        "Building large houses",
                        "Gaining wealth",
                        "Winning arguments"
                },
                0
        ));

        questions.add(new Question(
                "What does James warn believers not to show?",
                new String[]{
                        "Mercy",
                        "Partiality",
                        "Kindness",
                        "Patience"
                },
                1
        ));

        questions.add(new Question(
                "What is called the royal law?",
                new String[]{
                        "Love your neighbour as yourself",
                        "Build the temple",
                        "Obey Caesar",
                        "Become wealthy"
                },
                0
        ));

        questions.add(new Question(
                "What is faith without works?",
                new String[]{
                        "Powerful",
                        "Complete",
                        "Dead",
                        "Perfect"
                },
                2
        ));

        questions.add(new Question(
                "Who is an example of faith shown by works?",
                new String[]{
                        "Abraham",
                        "Pilate",
                        "Herod",
                        "Caiaphas"
                },
                0
        ));

        questions.add(new Question(
                "What part of the body does James compare to a fire?",
                new String[]{
                        "The eye",
                        "The tongue",
                        "The hand",
                        "The foot"
                },
                1
        ));

        questions.add(new Question(
                "What can a little fire do?",
                new String[]{
                        "Burn a great forest",
                        "Calm the sea",
                        "Build a house",
                        "Create rain"
                },
                0
        ));

        questions.add(new Question(
                "What does James say no man can tame?",
                new String[]{
                        "The wind",
                        "The sea",
                        "The tongue",
                        "The earth"
                },
                2
        ));

        questions.add(new Question(
                "What is friendship with the world called?",
                new String[]{
                        "Friendship with God",
                        "Enmity with God",
                        "A blessing",
                        "A command"
                },
                1
        ));

        questions.add(new Question(
                "What happens when believers draw near to God?",
                new String[]{
                        "God draws near to them",
                        "They become kings",
                        "They become rich",
                        "They never face trials"
                },
                0
        ));

        questions.add(new Question(
                "What should a person do when suffering?",
                new String[]{
                        "Complain",
                        "Hide",
                        "Pray",
                        "Give up"
                },
                2
        ));

        questions.add(new Question(
                "Whom should a sick person call for?",
                new String[]{
                        "The elders of the church",
                        "Roman soldiers",
                        "Merchants",
                        "Kings"
                },
                0
        ));
    }
        }
        private static void addBook1PeterQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote 1 Peter?",
                new String[]{
                        "Paul",
                        "Peter",
                        "James",
                        "John"
                },
                1
        ));

        questions.add(new Question(
                "To whom was 1 Peter written?",
                new String[]{
                        "Kings of Israel",
                        "Roman soldiers",
                        "Strangers scattered in different regions",
                        "Egyptian priests"
                },
                2
        ));

        questions.add(new Question(
                "What does Peter say believers have through Christ's resurrection?",
                new String[]{
                        "A living hope",
                        "Earthly riches",
                        "Political power",
                        "A Roman title"
                },
                0
        ));

        questions.add(new Question(
                "What is reserved in heaven for believers?",
                new String[]{
                        "A palace",
                        "An inheritance",
                        "A crown of gold",
                        "A kingdom on earth"
                },
                1
        ));

        questions.add(new Question(
                "What is described as more precious than gold?",
                new String[]{
                        "The trial of faith",
                        "Political power",
                        "Earthly wealth",
                        "Military strength"
                },
                0
        ));

        questions.add(new Question(
                "In what should believers be holy?",
                new String[]{
                        "Only their homes",
                        "All manner of conversation",
                        "Only their work",
                        "Only their speech"
                },
                1
        ));

        questions.add(new Question(
                "What redeemed believers from their former way of life?",
                new String[]{
                        "Silver",
                        "Gold",
                        "The precious blood of Christ",
                        "Earthly sacrifices"
                },
                2
        ));

        questions.add(new Question(
                "What should believers desire like newborn babies?",
                new String[]{
                        "The sincere milk of the word",
                        "Gold",
                        "Bread only",
                        "Earthly wisdom"
                },
                0
        ));

        questions.add(new Question(
                "What kind of stone is Christ called?",
                new String[]{
                        "A golden stone",
                        "A living stone",
                        "A broken stone",
                        "A royal stone"
                },
                1
        ));

        questions.add(new Question(
                "What are believers described as?",
                new String[]{
                        "Roman citizens",
                        "Temple guards",
                        "A royal priesthood",
                        "Military leaders"
                },
                2
        ));

        questions.add(new Question(
                "What should believers abstain from because they war against the soul?",
                new String[]{
                        "Fleshly lusts",
                        "Prayer",
                        "Good works",
                        "Spiritual gifts"
                },
                0
        ));

        questions.add(new Question(
                "What should servants be subject to?",
                new String[]{
                        "Kings only",
                        "Their masters",
                        "Roman soldiers",
                        "Their neighbours"
                },
                1
        ));

        questions.add(new Question(
                "What example did Christ leave for believers?",
                new String[]{
                        "An example of gaining riches",
                        "An example of ruling Rome",
                        "An example of suffering patiently",
                        "An example of becoming famous"
                },
                2
        ));

        questions.add(new Question(
                "What should wives have according to Peter?",
                new String[]{
                        "A gentle and quiet spirit",
                        "Political authority",
                        "Military power",
                        "Great riches"
                },
                0
        ));

        questions.add(new Question(
                "What should husbands give to their wives?",
                new String[]{
                        "Commands only",
                        "Understanding and honour",
                        "Wealth only",
                        "Dishonour"
                },
                1
        ));

        questions.add(new Question(
                "What should believers be ready to give to anyone who asks?",
                new String[]{
                        "An answer concerning their hope",
                        "Money",
                        "Political advice",
                        "Military orders"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do when they suffer for righteousness?",
                new String[]{
                        "Give up",
                        "Seek revenge",
                        "Count themselves blessed",
                        "Hide from everyone"
                },
                2
        ));

        questions.add(new Question(
                "What should believers cast upon God?",
                new String[]{
                        "Their riches",
                        "Their cares",
                        "Their houses",
                        "Their possessions"
                },
                1
        ));

        questions.add(new Question(
                "Why should believers cast their cares upon God?",
                new String[]{
                        "Because He makes everyone rich",
                        "Because trials disappear",
                        "Because He cares for them",
                        "Because they become kings"
                },
                2
        ));

        questions.add(new Question(
                "What does Peter compare the devil to?",
                new String[]{
                        "A roaring lion",
                        "A great eagle",
                        "A wolf",
                        "A serpent"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do concerning the devil?",
                new String[]{
                        "Follow him",
                        "Resist him",
                        "Ignore him",
                        "Make peace with him"
                },
                1
        ));

        questions.add(new Question(
                "What does Peter tell believers to be?",
                new String[]{
                        "Rich and powerful",
                        "Silent and fearful",
                        "Sober and vigilant",
                        "Famous and respected"
                },
                2
        ));

        questions.add(new Question(
                "Who is called the chief Shepherd?",
                new String[]{
                        "Peter",
                        "Moses",
                        "Paul",
                        "Christ"
                },
                3
        ));

        questions.add(new Question(
                "What will believers receive from the chief Shepherd?",
                new String[]{
                        "A crown of glory",
                        "A crown of silver",
                        "A Roman crown",
                        "A crown of gold"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do after humbling themselves under God's mighty hand?",
                new String[]{
                        "Seek earthly riches",
                        "Wait for God to exalt them in due time",
                        "Become rulers",
                        "Avoid other believers"
                },
                1
        ));
    }
            }
        private static void addBook2PeterQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote 2 Peter?",
                new String[]{
                        "John",
                        "Peter",
                        "Paul",
                        "James"
                },
                1
        ));

        questions.add(new Question(
                "What does Peter say God has given believers?",
                new String[]{
                        "All things that pertain to life and godliness",
                        "Earthly riches",
                        "Political power",
                        "Roman citizenship"
                },
                0
        ));

        questions.add(new Question(
                "What should believers add to their faith?",
                new String[]{
                        "Gold",
                        "Fame",
                        "Virtue",
                        "Military strength"
                },
                2
        ));

        questions.add(new Question(
                "What should be added to virtue?",
                new String[]{
                        "Knowledge",
                        "Riches",
                        "Power",
                        "Fame"
                },
                0
        ));

        questions.add(new Question(
                "What should be added to knowledge?",
                new String[]{
                        "Patience",
                        "Temperance",
                        "Wealth",
                        "Fame"
                },
                1
        ));

        questions.add(new Question(
                "What should be added to temperance?",
                new String[]{
                        "Godliness",
                        "Riches",
                        "Political power",
                        "Wisdom of men"
                },
                0
        ));

        questions.add(new Question(
                "What should be added to godliness?",
                new String[]{
                        "Brotherly kindness",
                        "Earthly honour",
                        "Military strength",
                        "Silver"
                },
                0
        ));

        questions.add(new Question(
                "What should be added to brotherly kindness?",
                new String[]{
                        "Fame",
                        "Charity",
                        "Power",
                        "Gold"
                },
                1
        ));

        questions.add(new Question(
                "What does Peter say will never fall if believers do these things?",
                new String[]{
                        "Their riches",
                        "Their faith",
                        "Their calling and election",
                        "Their houses"
                },
                2
        ));

        questions.add(new Question(
                "What does Peter say he will always remind believers of?",
                new String[]{
                        "These things",
                        "Roman laws",
                        "Earthly customs",
                        "Military rules"
                },
                0
        ));

        questions.add(new Question(
                "What did Peter say he would shortly put off?",
                new String[]{
                        "His house",
                        "His earthly riches",
                        "His tabernacle",
                        "His clothing"
                },
                2
        ));

        questions.add(new Question(
                "What did Peter say he was not following when he taught about Christ's power and coming?",
                new String[]{
                        "Fables",
                        "The law",
                        "The prophets",
                        "The Psalms"
                },
                0
        ));

        questions.add(new Question(
                "What did Peter and the others see Jesus receive from God the Father?",
                new String[]{
                        "A crown",
                        "Honour and glory",
                        "A kingdom",
                        "A sword"
                },
                1
        ));

        questions.add(new Question(
                "What came to Jesus from the excellent glory?",
                new String[]{
                        "A voice",
                        "A trumpet",
                        "A cloud",
                        "A star"
                },
                0
        ));

        questions.add(new Question(
                "What does Peter call the word of prophecy?",
                new String[]{
                        "A golden treasure",
                        "A light that shines in a dark place",
                        "A royal command",
                        "A worldly law"
                },
                1
        ));

        questions.add(new Question(
                "What does Peter say no prophecy of Scripture is of?",
                new String[]{
                        "Private interpretation",
                        "Great importance",
                        "God's power",
                        "Public teaching"
                },
                0
        ));

        questions.add(new Question(
                "Who moved holy men of God to speak?",
                new String[]{
                        "Kings",
                        "Angels",
                        "The Holy Ghost",
                        "Roman governors"
                },
                2
        ));

        questions.add(new Question(
                "What kind of teachers does Peter warn would arise?",
                new String[]{
                        "False teachers",
                        "Wise kings",
                        "Faithful prophets",
                        "Roman priests"
                },
                0
        ));

        questions.add(new Question(
                "What would false teachers secretly bring in?",
                new String[]{
                        "New songs",
                        "Damnable heresies",
                        "New laws",
                        "Earthly riches"
                },
                1
        ));

        questions.add(new Question(
                "What did God do to the angels that sinned?",
                new String[]{
                        "He made them kings",
                        "He sent them to Jerusalem",
                        "He cast them down to hell",
                        "He gave them riches"
                },
                2
        ));

        questions.add(new Question(
                "Who did God preserve during the flood?",
                new String[]{
                        "Abraham",
                        "Noah",
                        "Moses",
                        "David"
                },
                1
        ));

        questions.add(new Question(
                "What happened to the cities of Sodom and Gomorrha?",
                new String[]{
                        "They became wealthy",
                        "They were destroyed",
                        "They became kingdoms",
                        "They were rebuilt by Peter"
                },
                1
        ));

        questions.add(new Question(
                "What does Peter compare false teachers to?",
                new String[]{
                        "Clouds without water",
                        "Rivers of living water",
                        "Mountains",
                        "Golden vessels"
                },
                0
        ));

        questions.add(new Question(
                "What does Peter say the Lord is not slack concerning?",
                new String[]{
                        "His promise",
                        "His kingdom",
                        "His riches",
                        "His angels"
                },
                0
        ));

        questions.add(new Question(
                "What does Peter say believers should look for according to God's promise?",
                new String[]{
                        "A new heaven and a new earth",
                        "A new Roman Empire",
                        "A new temple in Egypt",
                        "A new earthly king"
                },
                0
        ));
    }
        }
        private static void addBook1JohnQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote 1 John?",
                new String[]{
                        "John",
                        "Peter",
                        "Paul",
                        "James"
                },
                0
        ));

        questions.add(new Question(
                "What does John say he and the others had seen and heard?",
                new String[]{
                        "Only visions",
                        "The Word of life",
                        "Roman soldiers",
                        "Earthly riches"
                },
                1
        ));

        questions.add(new Question(
                "What is God described as?",
                new String[]{
                        "A consuming fire",
                        "Light",
                        "A mighty king",
                        "A great warrior"
                },
                1
        ));

        questions.add(new Question(
                "What is there no darkness in?",
                new String[]{
                        "The world",
                        "The heavens",
                        "God",
                        "The sea"
                },
                2
        ));

        questions.add(new Question(
                "What should believers do if they say they have fellowship with God?",
                new String[]{
                        "Walk in the light",
                        "Seek riches",
                        "Become famous",
                        "Avoid other believers"
                },
                0
        ));

        questions.add(new Question(
                "What cleanses believers from all sin?",
                new String[]{
                        "The law",
                        "The blood of Jesus Christ",
                        "Silver",
                        "Good reputation"
                },
                1
        ));

        questions.add(new Question(
                "What does John say if we confess our sins?",
                new String[]{
                        "God is faithful and just to forgive us",
                        "We become kings",
                        "We receive earthly riches",
                        "We never face trials"
                },
                0
        ));

        questions.add(new Question(
                "Who is our advocate with the Father?",
                new String[]{
                        "Moses",
                        "Peter",
                        "Jesus Christ the righteous",
                        "Paul"
                },
                2
        ));

        questions.add(new Question(
                "What is Jesus Christ called in relation to our sins?",
                new String[]{
                        "The prophet of Israel",
                        "The propitiation for our sins",
                        "The king of Rome",
                        "The high priest of Egypt"
                },
                1
        ));

        questions.add(new Question(
                "How do we know that we know Christ?",
                new String[]{
                        "If we keep his commandments",
                        "If we become wealthy",
                        "If we become famous",
                        "If we rule others"
                },
                0
        ));

        questions.add(new Question(
                "What does John call the commandment he writes?",
                new String[]{
                        "A new commandment",
                        "A Roman command",
                        "An earthly command",
                        "A military command"
                },
                0
        ));

        questions.add(new Question(
                "What should a believer not love?",
                new String[]{
                        "The brethren",
                        "The word of God",
                        "The world",
                        "Prayer"
                },
                2
        ));

        questions.add(new Question(
                "What does John say is not of the Father?",
                new String[]{
                        "The love of the brethren",
                        "The lust of the flesh",
                        "Faith",
                        "Righteousness"
                },
                1
        ));

        questions.add(new Question(
                "What passes away?",
                new String[]{
                        "The world and its lust",
                        "The word of God",
                        "Faith",
                        "God's love"
                },
                0
        ));

        questions.add(new Question(
                "Who abides for ever?",
                new String[]{
                        "The rich",
                        "He that does the will of God",
                        "Kings",
                        "Roman citizens"
                },
                1
        ));

        questions.add(new Question(
                "What does John warn about concerning the last time?",
                new String[]{
                        "Many antichrists would come",
                        "The temple would become richer",
                        "Rome would become holy",
                        "Everyone would become a prophet"
                },
                0
        ));

        questions.add(new Question(
                "What does John say believers have from the Holy One?",
                new String[]{
                        "An anointing",
                        "A crown",
                        "A kingdom",
                        "Earthly wealth"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do because the Father has bestowed His love upon them?",
                new String[]{
                        "Call themselves kings",
                        "Be called the sons of God",
                        "Seek worldly honour",
                        "Avoid prayer"
                },
                1
        ));

        questions.add(new Question(
                "What does John say we shall be like when Christ appears?",
                new String[]{
                        "We shall be like him",
                        "We shall be angels",
                        "We shall be kings of Rome",
                        "We shall become prophets"
                },
                0
        ));

        questions.add(new Question(
                "What does everyone who has this hope in Christ do?",
                new String[]{
                        "Purifies himself",
                        "Seeks riches",
                        "Avoids other believers",
                        "Becomes famous"
                },
                0
        ));

        questions.add(new Question(
                "What does John say Cain was?",
                new String[]{
                        "A prophet",
                        "Of that wicked one",
                        "A king",
                        "A priest"
                },
                1
        ));

        questions.add(new Question(
                "How should believers love?",
                new String[]{
                        "In word only",
                        "In wealth",
                        "In deed and in truth",
                        "In secret only"
                },
                2
        ));

        questions.add(new Question(
                "What does John say God is greater than?",
                new String[]{
                        "Our heart",
                        "The world",
                        "The heavens",
                        "The angels"
                },
                0
        ));

        questions.add(new Question(
                "What is the commandment of God according to 1 John 3:23?",
                new String[]{
                        "Believe on the name of Jesus Christ and love one another",
                        "Build a temple",
                        "Become wealthy",
                        "Rule over nations"
                },
                0
        ));

        questions.add(new Question(
                "What does perfect love cast out?",
                new String[]{
                        "Faith",
                        "Fear",
                        "Hope",
                        "Knowledge"
                },
                1
        ));
    }
            }
        private static void addBook2JohnQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote 2 John?",
                new String[]{
                        "Peter",
                        "John",
                        "Paul",
                        "James"
                },
                1
        ));

        questions.add(new Question(
                "To whom is 2 John addressed?",
                new String[]{
                        "The elect lady and her children",
                        "The church at Rome",
                        "The kings of Israel",
                        "The apostles only"
                },
                0
        ));

        questions.add(new Question(
                "What does John say he rejoiced to find among her children?",
                new String[]{
                        "They were wealthy",
                        "They were famous",
                        "They walked in truth",
                        "They were powerful"
                },
                2
        ));

        questions.add(new Question(
                "What commandment does John say believers have had from the beginning?",
                new String[]{
                        "Love one another",
                        "Build a temple",
                        "Become rich",
                        "Rule nations"
                },
                0
        ));

        questions.add(new Question(
                "What does John say is love?",
                new String[]{
                        "Walking after his commandments",
                        "Having earthly riches",
                        "Becoming famous",
                        "Avoiding other believers"
                },
                0
        ));

        questions.add(new Question(
                "Who does John warn many deceivers will not confess?",
                new String[]{
                        "Moses",
                        "Jesus Christ coming in the flesh",
                        "Peter",
                        "Abraham"
                },
                1
        ));

        questions.add(new Question(
                "What does John call such a deceiver?",
                new String[]{
                        "A false prophet",
                        "An antichrist",
                        "A Roman ruler",
                        "A false priest"
                },
                1
        ));

        questions.add(new Question(
                "What should believers watch themselves against?",
                new String[]{
                        "Losing the things they have worked for",
                        "Becoming rich",
                        "Becoming famous",
                        "Having too many friends"
                },
                0
        ));

        questions.add(new Question(
                "What should believers receive if they abide in the doctrine of Christ?",
                new String[]{
                        "They have both the Father and the Son",
                        "Earthly riches",
                        "Political authority",
                        "A crown immediately"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do concerning someone who does not bring the doctrine of Christ?",
                new String[]{
                        "Welcome him into their house",
                        "Give him money",
                        "Do not receive him into their house",
                        "Make him a leader"
                },
                2
        ));

        questions.add(new Question(
                "What should believers not say to someone who brings false doctrine?",
                new String[]{
                        "Hello",
                        "God bless you",
                        "Goodbye",
                        "Welcome"
                },
                1
        ));

        questions.add(new Question(
                "Why should believers not welcome a false teacher?",
                new String[]{
                        "They would become wealthy",
                        "They would become partakers of his evil deeds",
                        "They would lose their homes",
                        "They would become famous"
                },
                1
        ));

        questions.add(new Question(
                "What did John hope to come and speak about?",
                new String[]{
                        "Many earthly things",
                        "Many spiritual things",
                        "Many political matters",
                        "Many business matters"
                },
                1
        ));

        questions.add(new Question(
                "How did John want to speak to them?",
                new String[]{
                        "Face to face",
                        "Through a king",
                        "Through soldiers",
                        "By sending money"
                },
                0
        ));

        questions.add(new Question(
                "What did John say their joy would be?",
                new String[]{
                        "Complete",
                        "Small",
                        "Temporary",
                        "Hidden"
                },
                0
        ));

        questions.add(new Question(
                "Who sent greetings to the elect lady's children?",
                new String[]{
                        "The children of her elect sister",
                        "The Roman soldiers",
                        "The elders of Jerusalem",
                        "The kings of Israel"
                },
                0
        ));

        questions.add(new Question(
                "What word appears repeatedly in 2 John concerning Christian living?",
                new String[]{
                        "Love",
                        "Gold",
                        "War",
                        "Power"
                },
                0
        ));

        questions.add(new Question(
                "What did John say he had received from the Father?",
                new String[]{
                        "A new commandment",
                        "A crown",
                        "A kingdom",
                        "A sword"
                },
                0
        ));

        questions.add(new Question(
                "What truth does John say would abide with believers?",
                new String[]{
                        "Truth",
                        "Wealth",
                        "Political power",
                        "Earthly fame"
                },
                0
        ));

        questions.add(new Question(
                "Where does John say truth and love should be found?",
                new String[]{
                        "Among God's people",
                        "Only in kings",
                        "Only in priests",
                        "Only in Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "What does John say about those who do not abide in Christ's doctrine?",
                new String[]{
                        "They have God",
                        "They have no God",
                        "They become apostles",
                        "They become kings"
                },
                1
        ));

        questions.add(new Question(
                "Who has both the Father and the Son?",
                new String[]{
                        "He that abides in the doctrine of Christ",
                        "Every Roman citizen",
                        "Every rich person",
                        "Every ruler"
                },
                0
        ));

        questions.add(new Question(
                "What did John say he did not want to use?",
                new String[]{
                        "Paper and ink",
                        "Gold and silver",
                        "A sword",
                        "A scroll"
                },
                0
        ));

        questions.add(new Question(
                "What did John hope their joy would be?",
                new String[]{
                        "Complete",
                        "Hidden",
                        "Temporary",
                        "Small"
                },
                0
        ));

        questions.add(new Question(
                "What is the main Christian command emphasized in 2 John?",
                new String[]{
                        "Love one another",
                        "Build cities",
                        "Become wealthy",
                        "Rule nations"
                },
                0
        ));
    }
        }
        private static void addBook3JohnQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote 3 John?",
                new String[]{
                        "Peter",
                        "John",
                        "Paul",
                        "James"
                },
                1
        ));

        questions.add(new Question(
                "To whom is 3 John addressed?",
                new String[]{
                        "Gaius",
                        "Diotrephes",
                        "Demetrius",
                        "Timothy"
                },
                0
        ));

        questions.add(new Question(
                "What does John say he wishes above all things for Gaius?",
                new String[]{
                        "That he may prosper and be in health",
                        "That he may become king",
                        "That he may become wealthy",
                        "That he may become famous"
                },
                0
        ));

        questions.add(new Question(
                "What did John rejoice to hear about Gaius?",
                new String[]{
                        "He was very rich",
                        "His children walked in truth",
                        "He had become a ruler",
                        "He had built a church"
                },
                1
        ));

        questions.add(new Question(
                "What did Gaius do for the brethren and strangers?",
                new String[]{
                        "He showed hospitality",
                        "He ignored them",
                        "He sent them away",
                        "He charged them money"
                },
                0
        ));

        questions.add(new Question(
                "What did the brethren testify about Gaius?",
                new String[]{
                        "His wealth",
                        "His fame",
                        "His truth",
                        "His political influence"
                },
                2
        ));

        questions.add(new Question(
                "Who loved to have the preeminence?",
                new String[]{
                        "Gaius",
                        "Demetrius",
                        "Diotrephes",
                        "John"
                },
                2
        ));

        questions.add(new Question(
                "What did Diotrephes refuse to receive?",
                new String[]{
                        "The brethren",
                        "Money",
                        "Letters from John",
                        "Food"
                },
                2
        ));

        questions.add(new Question(
                "What did Diotrephes do to those who wanted to receive the brethren?",
                new String[]{
                        "He praised them",
                        "He cast them out of the church",
                        "He gave them gifts",
                        "He made them leaders"
                },
                1
        ));

        questions.add(new Question(
                "What did John say he would do if he came?",
                new String[]{
                        "Remember Diotrephes' deeds",
                        "Give him money",
                        "Make him an apostle",
                        "Ignore him"
                },
                0
        ));

        questions.add(new Question(
                "What should believers follow?",
                new String[]{
                        "That which is good",
                        "Wealth",
                        "Political power",
                        "Fame"
                },
                0
        ));

        questions.add(new Question(
                "Who does John say has not seen God?",
                new String[]{
                        "He that does evil",
                        "He that does good",
                        "Gaius",
                        "Demetrius"
                },
                0
        ));

        questions.add(new Question(
                "Who had a good report from everyone?",
                new String[]{
                        "Diotrephes",
                        "Demetrius",
                        "Pilate",
                        "Herod"
                },
                1
        ));

        questions.add(new Question(
                "Who also gave a good report of Demetrius?",
                new String[]{
                        "The truth itself",
                        "The Roman governor",
                        "The soldiers",
                        "The kings"
                },
                0
        ));

        questions.add(new Question(
                "Who said he had many things to write?",
                new String[]{
                        "Gaius",
                        "Demetrius",
                        "John",
                        "Diotrephes"
                },
                2
        ));

        questions.add(new Question(
                "What did John not want to write with?",
                new String[]{
                        "Pen and ink",
                        "Gold and silver",
                        "A sword",
                        "A scroll"
                },
                0
        ));

        questions.add(new Question(
                "How did John hope to speak with Gaius?",
                new String[]{
                        "Face to face",
                        "Through a messenger only",
                        "Through a king",
                        "By letter only"
                },
                0
        ));

        questions.add(new Question(
                "What did John wish Gaius?",
                new String[]{
                        "Peace",
                        "Riches",
                        "Power",
                        "Fame"
                },
                0
        ));

        questions.add(new Question(
                "Who sent greetings to Gaius?",
                new String[]{
                        "The friends",
                        "The Roman soldiers",
                        "The kings",
                        "The merchants"
                },
                0
        ));

        questions.add(new Question(
                "What did Gaius show toward strangers?",
                new String[]{
                        "Faithfulness",
                        "Anger",
                        "Fear",
                        "Dishonesty"
                },
                0
        ));

        questions.add(new Question(
                "Why did the brethren go forth?",
                new String[]{
                        "For the sake of the Name",
                        "To become rich",
                        "To gain political power",
                        "To conquer cities"
                },
                0
        ));

        questions.add(new Question(
                "What should believers do for travelling brethren?",
                new String[]{
                        "Support them",
                        "Ignore them",
                        "Charge them money",
                        "Send them away"
                },
                0
        ));

        questions.add(new Question(
                "What kind of example was Gaius?",
                new String[]{
                        "An example of faithfulness",
                        "An example of pride",
                        "An example of greed",
                        "An example of rebellion"
                },
                0
        ));

        questions.add(new Question(
                "What was wrong with Diotrephes?",
                new String[]{
                        "He loved to have the preeminence",
                        "He was too quiet",
                        "He gave too much",
                        "He helped too many people"
                },
                0
        ));

        questions.add(new Question(
                "What does John encourage believers to imitate?",
                new String[]{
                        "Good",
                        "Wealth",
                        "Power",
                        "Fame"
                },
                0
        ));
    }
            }
        private static void addBookJudeQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who wrote the book of Jude?",
                new String[]{
                        "Peter",
                        "Jude",
                        "Paul",
                        "John"
                },
                1
        ));

        questions.add(new Question(
                "How does Jude describe himself?",
                new String[]{
                        "A servant of Jesus Christ and brother of James",
                        "A king of Israel",
                        "A Roman governor",
                        "A priest of Jerusalem"
                },
                0
        ));

        questions.add(new Question(
                "To whom is Jude's letter written?",
                new String[]{
                        "The kings of Israel",
                        "The Roman church",
                        "Them that are sanctified by God",
                        "The priests of Jerusalem"
                },
                2
        ));

        questions.add(new Question(
                "What does Jude tell believers to earnestly contend for?",
                new String[]{
                        "Earthly riches",
                        "The faith",
                        "Political power",
                        "Military victory"
                },
                1
        ));

        questions.add(new Question(
                "What had been delivered to the saints?",
                new String[]{
                        "The faith",
                        "A kingdom",
                        "A crown",
                        "A temple"
                },
                0
        ));

        questions.add(new Question(
                "What kind of people had crept in unnoticed?",
                new String[]{
                        "Faithful teachers",
                        "Angels",
                        "Certain men",
                        "Roman soldiers"
                },
                2
        ));

        questions.add(new Question(
                "What did Jude say these ungodly men turned the grace of God into?",
                new String[]{
                        "A reason to pray",
                        "Lasciviousness",
                        "A form of wisdom",
                        "A spiritual gift"
                },
                1
        ));

        questions.add(new Question(
                "Who did Jude say these ungodly men denied?",
                new String[]{
                        "The only Lord God and our Lord Jesus Christ",
                        "Moses",
                        "Abraham",
                        "The prophets"
                },
                0
        ));

        questions.add(new Question(
                "What happened to the angels who kept not their first estate?",
                new String[]{
                        "They became kings",
                        "They were given riches",
                        "They were forgiven immediately",
                        "They are reserved in everlasting chains"
                },
                3
        ));

        questions.add(new Question(
                "Which cities are given as an example of judgment?",
                new String[]{
                        "Jerusalem and Bethlehem",
                        "Sodom and Gomorrha",
                        "Rome and Corinth",
                        "Egypt and Babylon"
                },
                1
        ));

        questions.add(new Question(
                "Who disputed with the devil about the body of Moses?",
                new String[]{
                        "Michael the archangel",
                        "Gabriel",
                        "Peter",
                        "Moses"
                },
                0
        ));

        questions.add(new Question(
                "What did Michael say to the devil?",
                new String[]{
                        "Be gone forever",
                        "You are defeated",
                        "The Lord rebuke thee",
                        "Leave this place"
                },
                2
        ));

        questions.add(new Question(
                "What does Jude compare the false teachers to?",
                new String[]{
                        "Faithful shepherds",
                        "Rocks in the sea",
                        "Wise kings",
                        "Clouds without water"
                },
                3
        ));

        questions.add(new Question(
                "What kind of trees are the false teachers compared to?",
                new String[]{
                        "Fruitful trees",
                        "Trees whose fruit withereth",
                        "Olive trees",
                        "Cedars of Lebanon"
                },
                1
        ));

        questions.add(new Question(
                "What are the false teachers compared to when they are described as wandering stars?",
                new String[]{
                        "Stars that give light",
                        "The sun",
                        "Wandering stars",
                        "The moon"
                },
                2
        ));

        questions.add(new Question(
                "Who prophesied that the Lord would come with ten thousands of his saints?",
                new String[]{
                        "Enoch",
                        "Moses",
                        "David",
                        "Isaiah"
                },
                0
        ));

        questions.add(new Question(
                "What did Enoch say the Lord would execute upon the ungodly?",
                new String[]{
                        "Great riches",
                        "Judgment",
                        "A new kingdom",
                        "Peace"
                },
                1
        ));

        questions.add(new Question(
                "What should believers do to themselves in relation to their most holy faith?",
                new String[]{
                        "Build themselves up",
                        "Make themselves wealthy",
                        "Hide themselves",
                        "Separate from everyone"
                },
                0
        ));

        questions.add(new Question(
                "What should believers pray in?",
                new String[]{
                        "Their own wisdom",
                        "The law",
                        "The Holy Ghost",
                        "Earthly power"
                },
                2
        ));

        questions.add(new Question(
                "What should believers keep themselves in?",
                new String[]{
                        "The love of God",
                        "Earthly riches",
                        "Political power",
                        "Human wisdom"
                },
                0
        ));

        questions.add(new Question(
                "What should believers look for concerning Jesus Christ?",
                new String[]{
                        "His earthly kingdom",
                        "The mercy of our Lord Jesus Christ unto eternal life",
                        "His earthly riches",
                        "His political authority"
                },
                1
        ));

        questions.add(new Question(
                "What should believers have compassion on?",
                new String[]{
                        "Those who doubt",
                        "Kings",
                        "Roman soldiers",
                        "The wealthy"
                },
                0
        ));

        questions.add(new Question(
                "What should believers save others from?",
                new String[]{
                        "Earthly poverty",
                        "Political trouble",
                        "Fear of people",
                        "The fire"
                },
                3
        ));

        questions.add(new Question(
                "What should believers hate even while showing mercy?",
                new String[]{
                        "The clothing",
                        "The garment spotted by the flesh",
                        "The word of God",
                        "The church"
                },
                1
        ));

        questions.add(new Question(
                "Who is able to keep believers from falling?",
                new String[]{
                        "The angels",
                        "Moses",
                        "God",
                        "The apostles"
                },
                2
        ));
    }
        }
        private static void addBookRevelationQuestions(ArrayList<Question> questions, String difficulty) {

    if (difficulty.equals("Easy")) {

        questions.add(new Question(
                "Who received the Revelation?",
                new String[]{
                        "Peter",
                        "John",
                        "Paul",
                        "James"
                },
                1
        ));

        questions.add(new Question(
                "Where was John when he received the Revelation?",
                new String[]{
                        "Patmos",
                        "Jerusalem",
                        "Rome",
                        "Ephesus"
                },
                0
        ));

        questions.add(new Question(
                "What is the first church addressed in Revelation?",
                new String[]{
                        "Smyrna",
                        "Pergamos",
                        "Ephesus",
                        "Laodicea"
                },
                2
        ));

        questions.add(new Question(
                "How many churches are addressed in Revelation chapters 2 and 3?",
                new String[]{
                        "Seven",
                        "Five",
                        "Ten",
                        "Twelve"
                },
                0
        ));

        questions.add(new Question(
                "What does Jesus call Himself in the message to the church at Smyrna?",
                new String[]{
                        "The beginning and the end",
                        "The first and the last",
                        "The great prophet",
                        "The King of Rome"
                },
                1
        ));

        questions.add(new Question(
                "What did John see in heaven after the messages to the churches?",
                new String[]{
                        "A throne",
                        "A temple",
                        "A city",
                        "A mountain"
                },
                0
        ));

        questions.add(new Question(
                "How many elders were around the throne?",
                new String[]{
                        "Twelve",
                        "Twenty-four",
                        "Forty",
                        "Seventy"
                },
                1
        ));

        questions.add(new Question(
                "How many living creatures were around the throne?",
                new String[]{
                        "Two",
                        "Seven",
                        "Four",
                        "Twelve"
                },
                2
        ));

        questions.add(new Question(
                "Who was worthy to open the book?",
                new String[]{
                        "The Lion of the tribe of Judah",
                        "Michael",
                        "Peter",
                        "John"
                },
                0
        ));

        questions.add(new Question(
                "What did John see standing in the midst of the throne?",
                new String[]{
                        "A king",
                        "A lamb as it had been slain",
                        "An angel",
                        "A prophet"
                },
                1
        ));

        questions.add(new Question(
                "How many seals were on the book?",
                new String[]{
                        "Four",
                        "Seven",
                        "Ten",
                        "Twelve"
                },
                1
        ));

        questions.add(new Question(
                "What appeared when the first seal was opened?",
                new String[]{
                        "A white horse",
                        "A red dragon",
                        "A great eagle",
                        "A golden city"
                },
                0
        ));

        questions.add(new Question(
                "What appeared when the second seal was opened?",
                new String[]{
                        "A black horse",
                        "A white horse",
                        "A red horse",
                        "A pale horse"
                },
                2
        ));

        questions.add(new Question(
                "What appeared when the fourth seal was opened?",
                new String[]{
                        "A white horse",
                        "A pale horse",
                        "A red horse",
                        "A black horse"
                },
                1
        ));

        questions.add(new Question(
                "How many people were sealed from the tribes of Israel?",
                new String[]{
                        "12,000",
                        "70,000",
                        "144,000",
                        "7,000"
                },
                2
        ));

        questions.add(new Question(
                "How many angels stood before God with seven trumpets?",
                new String[]{
                        "Seven",
                        "Four",
                        "Twelve",
                        "Twenty-four"
                },
                0
        ));

        questions.add(new Question(
                "What came out of the bottomless pit in Revelation 9?",
                new String[]{
                        "A great army of locust-like creatures",
                        "A flood of water",
                        "A golden city",
                        "Seven kings"
                },
                0
        ));

        questions.add(new Question(
                "What did John see coming down from heaven in Revelation 21?",
                new String[]{
                        "A new Jerusalem",
                        "A new Egypt",
                        "A new Rome",
                        "A new Babylon"
                },
                0
        ));

        questions.add(new Question(
                "What did the New Jerusalem have instead of a temple?",
                new String[]{
                        "A great palace",
                        "The Lord God Almighty and the Lamb",
                        "A throne of David",
                        "Seven churches"
                },
                1
        ));

        questions.add(new Question(
                "What will be no more in the new heaven and new earth?",
                new String[]{
                        "The sea",
                        "The sun",
                        "The moon",
                        "The stars"
                },
                0
        ));

        questions.add(new Question(
                "What will God wipe away from their eyes?",
                new String[]{
                        "Sweat",
                        "Tears",
                        "Dust",
                        "Blood"
                },
                1
        ));

        questions.add(new Question(
                "What will be no more?",
                new String[]{
                        "Death",
                        "Prayer",
                        "Worship",
                        "Faith"
                },
                0
        ));

        questions.add(new Question(
                "What is the river in the New Jerusalem called?",
                new String[]{
                        "The river of life",
                        "The river of Jordan",
                        "The river of fire",
                        "The river of mercy"
                },
                0
        ));

        questions.add(new Question(
                "What tree is mentioned in the New Jerusalem?",
                new String[]{
                        "The tree of knowledge",
                        "The tree of life",
                        "The olive tree",
                        "The fig tree"
                },
                1
        ));

        questions.add(new Question(
                "What does Revelation say about the words of its prophecy?",
                new String[]{
                        "They are uncertain",
                        "They are only for kings",
                        "They are faithful and true",
                        "They are hidden forever"
                },
                2
        ));
    }
            }

    }

}
