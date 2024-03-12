package ScoreCommand;

/**
 * Class Name: InitScoreCommand
 * Purpose: Encapsulates the action of initializing or resetting the score and time tracking at the start of the quiz game.
 * Usage: Used to reset the game state before starting a new game or retrying the quiz.
 */
public class InitScoreCommand implements Command {
    private ScoreReceiver scoreReceiver;

     /**
     * Method Name: InitScoreCommand
     * Purpose: Constructs an InitScoreCommand with a specified ScoreReceiver to handle score and time initialization.
     * Parameters:
     *     - scoreReceiver (ScoreReceiver): The receiver that initializes the score and time.
     */
    public InitScoreCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    /**
     * Method Name: execute
     * Purpose: Executes the action of initializing the game's score and time tracking through the ScoreReceiver.
     */
    @Override
    public void execute() {
        scoreReceiver.initScore();
    }
    
}
