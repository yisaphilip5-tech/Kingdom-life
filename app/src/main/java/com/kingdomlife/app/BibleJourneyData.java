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

        return questions;
    }
}
