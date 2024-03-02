package app;

public class ScoreTracker {
    public static int score = 0;

    public static void initialize() {
        score = 0;
    }

    public static void incrementScore() {
        score++;
    }

    public static int getScore() {
        return score;
    }
}
