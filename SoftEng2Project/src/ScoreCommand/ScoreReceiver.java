package ScoreCommand;

public class ScoreReceiver {
    public static int score = 0;

    public void initScore() {
        score = 0;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
