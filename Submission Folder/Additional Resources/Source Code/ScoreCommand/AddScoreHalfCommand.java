package ScoreCommand;


/**
 * Class Name: AddScoreHalfCommand
 * Purpose: Implements the Command pattern by encapsulating the action of adding half of the calculated score for a question to the player's total score.
 * Usage: Utilized when a player provides a partially correct answer, resulting in half the normal points being awarded.
 */
public class AddScoreHalfCommand implements Command{
    private ScoreReceiver scoreReceiver;

    /**
     * Method Name: AddScoreHalfCommand
     * Purpose: Constructs an AddScoreHalfCommand with a specific ScoreReceiver to manage scoring actions.
     * Parameters:
     *     - scoreReceiver (ScoreReceiver): The receiver that handles scoring logic.
     */
    public AddScoreHalfCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    /**
     * Method Name: execute
     * Purpose: Executes the score updating action by adding half of the calculated points to the total score, via the ScoreReceiver.
     */
    @Override
    public void execute() {
        scoreReceiver.addScoreHalf();
    }
    
}
