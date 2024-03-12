package ScoreCommand;

public class ScoreReceiver {
    public static int score = 0;
    private long startTime;
    private long lastQuestionTime;
    private long endTime;

    public void initScore() {
        score = 0;
        startTime = System.currentTimeMillis();
        lastQuestionTime = startTime;
    }

    public void addScore() {
        endTime = System.currentTimeMillis();
        long timeElapsedMilliseconds = endTime - lastQuestionTime;
        long timeElapsedSeconds = timeElapsedMilliseconds / 1000;

        int points = (int) (100 - (timeElapsedSeconds * 10));
        points = Math.max(points, 1); //Ensure user gets at least one point if they got the question right
        
        score += points;
        updateLastQuestionTime();
    }

    public void addScoreHalf() {
        endTime = System.currentTimeMillis();
        long timeElapsedMilliseconds = endTime - lastQuestionTime;
        long timeElapsedSeconds = timeElapsedMilliseconds / 1000;

        int points = (int) (100 - (timeElapsedSeconds * 10));
        points = Math.max(points, 1); //Ensure user gets at least one point if they got the question right
        
        score += (points/2);
        updateLastQuestionTime();
    }

    public void updateLastQuestionTime() {
        lastQuestionTime = System.currentTimeMillis();
        endTime = lastQuestionTime;
    }

    public int getScore() {
        return score;
    }

    public int getTotalTime() {
        return (int) ((endTime - startTime) / 1000);
    }
}
