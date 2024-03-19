package ScoreCommand;


/**
 * Class Name: AddScoreLessTimeCommand
 * Purpose: Implements the Command pattern by encapsulating the action of adding the calculated score for a question to the player's total score based on less time.
 * Usage: Utilized when a player provides a partially correct answer, resulting in about half the normal points being awarded.
 */
public class AddScoreLessTimeCommand implements Command{
    private ScoreReceiver scoreReceiver;

    /**
     * Method Name: AddScoreLessTimeCommand
     * Purpose: Constructs an AddScoreLessTimeCommand with a specific ScoreReceiver to manage scoring actions.
     * Parameters:
     *     - scoreReceiver (ScoreReceiver): The receiver that handles scoring logic.
     */
    public AddScoreLessTimeCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    /**
     * Method Name: execute
     * Purpose: Executes the score updating action by adding the calculated points to the total score based on less time, via the ScoreReceiver.
     */
    @Override
    public void execute() {
        scoreReceiver.addScoreLessTime();
    }
    
}
