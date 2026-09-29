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
                }

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
        return questions;
    }
}
