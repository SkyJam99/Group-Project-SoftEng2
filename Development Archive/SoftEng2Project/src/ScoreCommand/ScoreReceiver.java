package ScoreCommand;

/**
 * Class Name: ScoreReceiver
 * Purpose: Manages the scoring logic for the quiz game, including initialization, score calculation, and time tracking.
 * Usage: Used by command objects to modify the player's score based on their performance and the time taken to answer questions.
 */
public class ScoreReceiver {
    public static int score = 0;
    private long startTime;
    private long lastQuestionTime;
    private long endTime;

    /**
     * Method Name: initScore
     * Purpose: Initializes or resets the game score and time tracking at the start of the quiz.
     * Parameters: None
     * Returns: None
     * Usage Example: scoreReceiver.initScore(); // Resets score and timestamps at the beginning of the game
     */
    public void initScore() {
        score = 0;
        startTime = System.currentTimeMillis();
        lastQuestionTime = startTime;
    }

    /**
     * Method Name: addScore
     * Purpose: Calculates and adds points to the current score based on the time taken to answer the current question.
     */
    public void addScore() {
        endTime = System.currentTimeMillis();
        long timeElapsedMilliseconds = endTime - lastQuestionTime;
        long timeElapsedSeconds = timeElapsedMilliseconds / 1000;

        int points = (int) (100 - (timeElapsedSeconds * 10));
        points = Math.max(points, 1); //Ensure user gets at least one point if they got the question right
        
        score += points;
        updateLastQuestionTime();
    }

    /**
     * Method Name: addScoreHalf
     * Purpose: Adds half the points calculated based on the time taken to answer the current question, to mess with the user
     */
    public void addScoreHalf() {
        endTime = System.currentTimeMillis();
        long timeElapsedMilliseconds = endTime - lastQuestionTime;
        long timeElapsedSeconds = timeElapsedMilliseconds / 1000;

        int points = (int) (100 - (timeElapsedSeconds * 10));
        points = Math.max(points, 1); //Ensure user gets at least one point if they got the question right
        
        score += (points/2);
        updateLastQuestionTime();
    }

    /**
     * Method Name: addScoreLessTime
     * Purpose: Adds the points calculated based on the time taken to answer the current question using half the time, to mess with the user
     */
    public void addScoreLessTime() {
        endTime = System.currentTimeMillis();
        long timeElapsedMilliseconds = endTime - lastQuestionTime;
        long timeElapsedSeconds = timeElapsedMilliseconds / 1000;

        int points = (int) (50 - (timeElapsedSeconds * 10));
        points = Math.max(points, 1); //Ensure user gets at least one point if they got the question right
        
        score += (points);
        updateLastQuestionTime();
    }

    /**
     * Method Name: updateLastQuestionTime
     * Purpose: Updates the timestamp of the last question to the current time.
     * Parameters: None
     * Returns: None
     * Usage Example: Automatically called within addScore methods to reset the timer for the next question
     */
    public void updateLastQuestionTime() {
        lastQuestionTime = System.currentTimeMillis();
        endTime = lastQuestionTime;
    }

    /**
     * Method Name: getScore
     * Purpose: Returns the current score of the game.
     * Parameters: None
     * Returns: int - The current score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Method Name: getTotalTime
     * Purpose: Calculates and returns the total time spent on the quiz in seconds.
     * Parameters: None
     * Returns: int - The total time spent in seconds.
     */
    public int getTotalTime() {
        return (int) ((endTime - startTime) / 1000);
    }
}
