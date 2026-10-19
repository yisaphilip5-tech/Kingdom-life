package com.kingdomlife.app;

public class MissingWordData {

// Each question contains:
// [0] Verse with missing word
// [1] Correct answer
// [2] Wrong answer
// [3] Wrong answer
// [4] Wrong answer
// [5] Bible reference
// [6] Index of the correct option (0=A, 1=B, 2=C, 3=D)

public static String[][] getLevel1Questions() {
    return new String[][]{

        {"Trust in the Lord with all your ___", "heart", "mind", "strength", "soul", "Proverbs 3:5", "2"},
        {"I can do all things through Christ which ___ me", "strengtheneth", "guideth", "teacheth", "keepeth", "Philippians 4:13", "0"},
        {"The Lord is my ___; I shall not want", "shepherd", "refuge", "strength", "rock", "Psalm 23:1", "3"},
        {"Be strong and of a good ___", "courage", "faith", "hope", "heart", "Joshua 1:9", "1"},
        {"All things work together for ___ to them that love God", "good", "peace", "love", "wisdom", "Romans 8:28", "2"},
        {"Thy word is a ___ unto my feet", "lamp", "light", "guide", "shield", "Psalm 119:105", "0"},
        {"Fear thou not; for I am with ___", "him", "you", "thee", "them", "Isaiah 41:10", "1"},
        {"Seek ye first the kingdom of ___", "heaven", "Christ", "glory", "God", "Matthew 6:33", "3"},
        {"The joy of the Lord is your ___", "peace", "strength", "refuge", "salvation", "Nehemiah 8:10", "1"},
        {"God is our refuge and ___", "strength", "shield", "rock", "helper", "Psalm 46:1", "0"},
        {"Create in me a clean ___, O God", "spirit", "mind", "heart", "soul", "Psalm 51:10", "2"},
        {"This is the day which the Lord hath ___", "given", "blessed", "chosen", "made", "Psalm 118:24", "3"},
        {"Walk by ___, not by sight", "hope", "faith", "love", "wisdom", "2 Corinthians 5:7", "1"},
        {"Pray without ___", "ceasing", "stopping", "fear", "doubt", "1 Thessalonians 5:17", "0"},
        {"Let your light so ___ before men", "glow", "stand", "shine", "rise", "Matthew 5:16", "2"},
        {"Blessed are the ___ in heart", "humble", "meek", "faithful", "pure", "Matthew 5:8", "3"},
        {"The Lord is my light and my ___", "strength", "salvation", "refuge", "shield", "Psalm 27:1", "1"},
        {"Whatsoever ye do, do it ___", "faithfully", "quickly", "heartily", "joyfully", "Colossians 3:23", "2"},
        {"Rejoice in the Lord ___", "alway", "daily", "always", "forever", "Philippians 4:4", "0"},
        {"Let all your things be done with ___", "faith", "joy", "peace", "charity", "1 Corinthians 16:14", "3"},
        {"If any of you lack ___, let him ask of God", "faith", "wisdom", "strength", "knowledge", "James 1:5", "1"},
        {"Cast thy burden upon the Lord, and he shall ___ thee", "strengthen", "guide", "sustain", "comfort", "Psalm 55:22", "2"},
        {"The Lord is good, a strong hold in the day of ___", "trouble", "battle", "sorrow", "fear", "Nahum 1:7", "0"},
        {"Wait on the Lord: be of good ___", "hope", "faith", "cheer", "courage", "Psalm 27:14", "3"},
        {"The fear of the Lord is the beginning of ___", "knowledge", "wisdom", "understanding", "faith", "Proverbs 9:10", "1"}
    };
}

public static String[][] getLevel2Questions() {
    return new String[][]{

        {"Blessed are the meek: for they shall inherit the ___", "earth", "kingdom", "heavens", "land", "Matthew 5:5", "2"},
        {"Man shall not live by bread ___", "alone", "only", "daily", "ever", "Matthew 4:4", "0"},
        {"The truth shall make you ___", "holy", "strong", "wise", "free", "John 8:32", "3"},
        {"The love of money is the root of all ___", "evil", "sorrow", "trouble", "sin", "1 Timothy 6:10", "0"},
        {"A soft answer turneth away ___", "anger", "wrath", "hatred", "strife", "Proverbs 15:1", "1"},
        {"Iron sharpeneth ___", "iron", "steel", "metal", "tools", "Proverbs 27:17", "0"},
        {"Pride goeth before destruction, and an haughty spirit before a ___", "fall", "storm", "curse", "battle", "Proverbs 16:18", "0"},
        {"The labourer is worthy of his ___", "reward", "wages", "hire", "meat", "Luke 10:7", "3"},
        {"The letter killeth, but the spirit giveth ___", "hope", "life", "peace", "power", "2 Corinthians 3:6", "1"},
        {"Be ye doers of the word, and not hearers ___", "only", "alone", "always", "also", "James 1:22", "0"},
        {"The prayer of faith shall save the ___", "sick", "weak", "poor", "lost", "James 5:15", "0"},
        {"The wages of sin is ___", "death", "sorrow", "judgment", "darkness", "Romans 6:23", "0"},
        {"The fruit of the Spirit is love, joy, peace, ___", "patience", "longsuffering", "kindness", "goodness", "Galatians 5:22", "1"},
        {"Where your treasure is, there will your heart be ___", "also", "there", "found", "kept", "Matthew 6:21", "0"},
        {"A friend loveth at all ___", "times", "seasons", "hours", "days", "Proverbs 17:17", "0"},
        {"The just shall live by ___", "hope", "faith", "love", "grace", "Romans 1:17", "1"},
        {"Let not your heart be ___", "troubled", "fearful", "sorrowful", "broken", "John 14:1", "0"},
        {"God loveth a cheerful ___", "giver", "servant", "worker", "helper", "2 Corinthians 9:7", "0"},
        {"Be swift to hear, slow to speak, slow to ___", "anger", "answer", "judge", "act", "James 1:19", "0"},
        {"The name of the Lord is a strong ___", "tower", "fortress", "castle", "wall", "Proverbs 18:10", "0"},
        {"A merry heart doeth good like a ___", "song", "medicine", "feast", "celebration", "Proverbs 17:22", "1"},
        {"The Lord is nigh unto them that are of a broken ___", "heart", "spirit", "mind", "soul", "Psalm 34:18", "0"},
        {"In quietness and in confidence shall be your ___", "peace", "strength", "rest", "hope", "Isaiah 30:15", "1"},
        {"Let the words of my mouth and the meditation of my heart be acceptable in thy ___", "sight", "presence", "house", "kingdom", "Psalm 19:14", "0"},
        {"Be not overcome of evil, but overcome evil with ___", "truth", "good", "love", "faith", "Romans 12:21", "1"}
    };
}

public static String[][] getLevel3Questions() {
    return new String[][]{

        {"The fear of the Lord is the beginning of ___", "wisdom", "knowledge", "understanding", "judgment", "Proverbs 9:10", "2"},
        {"Though I walk through the valley of the shadow of ___", "death", "darkness", "sorrow", "fear", "Psalm 23:4", "0"},
        {"The Lord is slow to anger, and great in ___", "mercy", "power", "wisdom", "goodness", "Psalm 145:8", "1"},
        {"Be ye transformed by the renewing of your ___", "mind", "heart", "spirit", "soul", "Romans 12:2", "0"},
        {"The just man falleth seven times, and riseth up ___", "again", "strong", "daily", "always", "Proverbs 24:16", "0"},
        {"A word fitly spoken is like apples of gold in pictures of ___", "silver", "bronze", "gold", "glass", "Proverbs 25:11", "0"},
        {"The horse is prepared against the day of battle: but safety is of the ___", "Lord", "king", "captain", "army", "Proverbs 21:31", "0"},
        {"The liberal soul shall be made ___", "rich", "fat", "strong", "wise", "Proverbs 11:25", "1"},
        {"The Lord shall fight for you, and ye shall hold your ___", "peace", "tongue", "ground", "faith", "Exodus 14:14", "0"},
        {"The righteous shall flourish like the ___", "cedar", "palm tree", "olive", "vine", "Psalm 92:12", "1"},
        {"The grass withereth, the flower fadeth: but the word of our God shall stand ___", "always", "forever", "sure", "fast", "Isaiah 40:8", "1"},
        {"The Lord is my portion, saith my ___", "soul", "heart", "spirit", "mind", "Lamentations 3:24", "0"},
        {"He that is slow to anger is better than the ___", "mighty", "wise", "strong", "brave", "Proverbs 16:32", "0"},
        {"A false balance is abomination to the ___", "Lord", "king", "people", "judge", "Proverbs 11:1", "0"},
        {"The name of the Lord is a strong tower: the righteous runneth into it, and is ___", "safe", "saved", "secure", "protected", "Proverbs 18:10", "0"},
        {"The Lord is good unto them that wait for him, to the soul that seeketh ___", "him", "peace", "wisdom", "truth", "Lamentations 3:25", "0"},
        {"The words of the wise are as goads, and as nails fastened by the masters of ___", "assemblies", "workmen", "Israel", "judgment", "Ecclesiastes 12:11", "0"},
        {"Better is the end of a thing than the ___ thereof", "beginning", "middle", "purpose", "promise", "Ecclesiastes 7:8", "0"},
        {"The heart of the wise teacheth his mouth, and addeth learning to his ___", "lips", "heart", "mind", "words", "Proverbs 16:23", "0"},
        {"A just weight and balance are the ___", "Lord's", "king's", "people's", "judge's", "Proverbs 16:11", "0"},
        {"The Lord is good, a strong hold in the day of trouble; and he knoweth them that ___ in him", "trust", "believe", "hope", "wait", "Nahum 1:7", "0"},
        {"The spirit of a man will sustain his infirmity; but a wounded spirit who can ___", "bear", "heal", "comfort", "restore", "Proverbs 18:14", "0"},
        {"The fining pot is for silver, and the furnace for ___", "gold", "iron", "brass", "copper", "Proverbs 17:3", "0"},
        {"The way of the Lord is strength to the upright: but destruction shall be to the workers of ___", "iniquity", "wickedness", "evil", "deceit", "Proverbs 10:29", "0"},
        {"Commit thy works unto the Lord, and thy thoughts shall be ___", "established", "ordered", "guided", "fulfilled", "Proverbs 16:3", "0"}
    };
}
    public static String[][] getLevel4Questions() {
return new String[][]{
{"The Lord is gracious, and full of ___", "compassion", "anger", "fear", "doubt", "Psalm 145:8", "0"},
{"A good name is rather to be chosen than great ___", "riches", "power", "honour", "wisdom", "Proverbs 22:1", "0"},
{"The liberal deviseth liberal things; and by liberal things shall he ___", "stand", "prosper", "flourish", "live", "Isaiah 32:8", "0"},
{"The Lord will perfect that which concerneth ___", "me", "thee", "us", "them", "Psalm 138:8", "1"},
{"The blessing of the Lord, it maketh ___", "rich", "strong", "wise", "holy", "Proverbs 10:22", "0"},
{"A merry heart maketh a cheerful ___", "face", "spirit", "countenance", "voice", "Proverbs 15:13", "2"},
{"The integrity of the upright shall guide ___", "them", "him", "us", "you", "Proverbs 11:3", "0"},
{"The Lord is nigh unto all them that call upon ___", "him", "thee", "God", "Jesus", "Psalm 145:18", "0"},
{"A faithful man shall abound with ___", "blessings", "riches", "wisdom", "honour", "Proverbs 28:20", "0"},
{"The righteous eateth to the satisfying of his ___", "heart", "soul", "mouth", "desire", "Proverbs 13:25", "1"},
{"The Lord shall preserve thy going out and thy coming in from this time forth, and even for ___", "ever", "always", "eternity", "life", "Psalm 121:8", "0"},
{"The path of the just is as the shining ___", "sun", "light", "star", "moon", "Proverbs 4:18", "1"},
{"The Lord is my strength and my ___", "shield", "refuge", "rock", "fortress", "Psalm 28:7", "0"},
{"A soft tongue breaketh the ___", "bone", "heart", "pride", "silence", "Proverbs 25:15", "0"},
{"The memory of the just is ___", "blessed", "honoured", "good", "lasting", "Proverbs 10:7", "0"},
{"The righteous shall never be ___", "moved", "forgotten", "shaken", "forsaken", "Psalm 112:6", "0"},
{"The Lord is good to all: and his tender mercies are over all his ___", "works", "children", "people", "creation", "Psalm 145:9", "0"},
{"The way of the wicked is as ___", "darkness", "death", "destruction", "sorrow", "Proverbs 4:19", "0"},
{"The fear of the Lord is the instruction of ___", "wisdom", "knowledge", "understanding", "life", "Proverbs 15:33", "0"},
{"The Lord upholdeth all that ___", "fall", "trust", "believe", "wait", "Psalm 145:14", "0"},
{"A wise son maketh a glad ___", "father", "mother", "family", "king", "Proverbs 10:1", "0"},
{"The name of the Lord is a strong tower: the righteous runneth into it, and is ___", "safe", "strong", "saved", "secure", "Proverbs 18:10", "0"},
{"The Lord is righteous in all his ___", "ways", "works", "judgments", "words", "Psalm 145:17", "0"},
{"He that followeth after righteousness and mercy findeth life, righteousness, and ___", "honour", "peace", "wisdom", "joy", "Proverbs 21:21", "0"},
{"The tongue of the wise useth knowledge ___", "aright", "well", "daily", "faithfully", "Proverbs 15:2", "0"}
};
    }
    public static String[][] getLevel5Questions() {
    return new String[][]{
        {"The secret things belong unto the Lord our ___", "God", "King", "Father", "Creator", "Deuteronomy 29:29", "0"},
        {"The Lord is good, a strong hold in the day of ___", "trouble", "sorrow", "fear", "battle", "Nahum 1:7", "0"},
        {"The fining pot is for silver, and the furnace for ___", "gold", "iron", "brass", "copper", "Proverbs 17:3", "0"},
        {"The heart of the prudent getteth ___", "knowledge", "wisdom", "understanding", "instruction", "Proverbs 18:15", "0"},
        {"The words of the Lord are pure words: as silver tried in a furnace of earth, purified ___ times", "seven", "three", "five", "ten", "Psalm 12:6", "0"},
        {"The just man walketh in his ___", "integrity", "wisdom", "strength", "righteousness", "Proverbs 20:7", "0"},
        {"A word fitly spoken is like apples of gold in pictures of ___", "silver", "bronze", "ivory", "wood", "Proverbs 25:11", "0"},
        {"The spirit of man is the candle of the Lord, searching all the inward parts of the ___", "belly", "heart", "mind", "soul", "Proverbs 20:27", "0"},
        {"The fining pot is for silver, and the furnace for gold: but the Lord trieth the ___", "hearts", "spirits", "works", "ways", "Proverbs 17:3", "0"},
        {"The desire accomplished is sweet to the ___", "soul", "heart", "mind", "spirit", "Proverbs 13:19", "0"},
        {"The righteous considereth the cause of the ___", "poor", "fatherless", "widow", "stranger", "Proverbs 29:7", "0"},
        {"The Lord hath made all things for ___", "himself", "his people", "his glory", "his kingdom", "Proverbs 16:4", "0"},
        {"The hoary head is a crown of ___", "glory", "honour", "wisdom", "righteousness", "Proverbs 16:31", "0"},
        {"The name of the Lord is a strong ___", "tower", "shield", "refuge", "fortress", "Proverbs 18:10", "0"},
        {"The words of a man's mouth are as deep ___", "waters", "wells", "rivers", "oceans", "Proverbs 18:4", "0"},
        {"A man that hath friends must shew himself ___", "friendly", "faithful", "kind", "honest", "Proverbs 18:24", "0"},
        {"The king's heart is in the hand of the ___", "Lord", "people", "prophet", "priest", "Proverbs 21:1", "0"},
        {"The horse is prepared against the day of battle: but safety is of the ___", "Lord", "king", "captain", "army", "Proverbs 21:31", "0"},
        {"Every way of a man is right in his own ___", "eyes", "heart", "mind", "sight", "Proverbs 21:2", "0"},
        {"The lot is cast into the lap; but the whole disposing thereof is of the ___", "Lord", "king", "priest", "judge", "Proverbs 16:33", "0"},
        {"The fear of the Lord tendeth to ___", "life", "wisdom", "peace", "knowledge", "Proverbs 19:23", "0"},
        {"A false witness shall not be ___", "unpunished", "forgotten", "believed", "honoured", "Proverbs 19:5", "0"},
        {"The soul of the sluggard desireth, and hath ___", "nothing", "little", "enough", "much", "Proverbs 13:4", "0"},
        {"The Lord is far from the wicked: but he heareth the prayer of the ___", "righteous", "humble", "faithful", "poor", "Proverbs 15:29", "0"},
        {"The fining pot is for silver, and the furnace for gold: and a man is valued by his ___", "praise", "wealth", "strength", "wisdom", "Proverbs 27:21", "0"}
    };
        }

public static String[][] getQuestionsForLevel(int level) {
    switch (level) {
        case 1:
            return getLevel1Questions();
        case 2:
            return getLevel2Questions();
        case 3:
            return getLevel3Questions();
        default:
            return new String[0][0];
    }
}

         }
