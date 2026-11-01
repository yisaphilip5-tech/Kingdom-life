package com.kingdomlife.app;

public final class DailyEncouragementData {

private DailyEncouragementData() {
    // Prevent creating instances of this class.
}

public static final String[] MESSAGES = {
    "God is not finished with your story.",
    "Keep growing in faith, one day at a time.",
    "You are stronger than you think.",
    "Every new day brings another opportunity to grow.",
    "Keep moving forward; your small steps matter.",
    "Walk in faith and live with purpose.",
    "Your journey is meaningful, even when progress feels slow.",
    "Choose hope, even when the road feels difficult.",
    "Great things begin with small steps.",
    "Be patient with yourself as you grow.",
    "Let kindness guide your words and actions.",
    "Stay focused on the good you are building.",
    "Difficult days do not define your whole journey.",
    "Keep learning, keep growing, and keep believing.",
    "Face each new day with hope and courage.",
    "You do not have to be perfect to make progress.",
    "Every challenge is an opportunity to learn and grow.",
    "Let your light shine through the way you treat others.",
    "Take one step today toward the person you want to become.",
    "Your past does not have to determine your future.",
    "Make room for joy, gratitude, and new beginnings.",
    "Keep your heart hopeful and your intentions kind.",
    "Progress may be slow, but every step still counts.",
    "Give yourself permission to learn from your mistakes.",
    "Be courageous enough to begin again.",
    "The good you do today can make a difference tomorrow.",
    "Stay humble, stay hopeful, and keep moving forward.",
    "You have the opportunity to make today meaningful.",
    "Let patience guide you and purpose inspire you.",
    "Begin today with hope; there is still good to build."
};

public static String getMessageForDay(int dayOfYear) {
    if (dayOfYear < 1 || dayOfYear > 366) {
        throw new IllegalArgumentException(
                "Day of year must be between 1 and 366."
        );
    }

    return MESSAGES[(dayOfYear - 1) % MESSAGES.length];
}

}
