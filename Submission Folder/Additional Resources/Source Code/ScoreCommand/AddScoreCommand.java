package ScoreCommand;

/**
 * Class Name: AddScoreCommand
 * Purpose: Encapsulates the action of adding a full score to the player's total score, following the Command pattern.
 * Usage: This command is instantiated with a reference to the ScoreReceiver.
 */
public class AddScoreCommand implements Command{
    private ScoreReceiver scoreReceiver;

    /**
     * Method Name: AddScoreCommand
     * Purpose: Constructs an AddScoreCommand with a specific ScoreReceiver.
     * Parameters:
     *     - scoreReceiver (ScoreReceiver): The receiver that will be used to add score.
     */
    public AddScoreCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    /**
     * Method Name: execute
     * Purpose: Triggers the addScore method of the ScoreReceiver, effectively updating the game score.
     */
    @Override
    public void execute() {
        scoreReceiver.addScore();
    }
    
}
