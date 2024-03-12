package ScoreCommand;


/**
 * Class Name: UpdateLastQuestionTimeCommand
 * Purpose: Implements the Command pattern to encapsulate the action of updating the timestamp of the last question asked in the quiz game.
 * Usage: This command is utilized to reset the time tracking for the next question.
 */
public class UpdateLastQuestionTimeCommand implements Command {
    private ScoreReceiver scoreReceiver;

    /**
     * Method Name: UpdateLastQuestionTimeCommand
     * Purpose: Constructs an UpdateLastQuestionTimeCommand with a specific ScoreReceiver for time tracking updates.
     * Parameters:
     *     - scoreReceiver (ScoreReceiver): The receiver responsible for updating the last question time.
     */
    public UpdateLastQuestionTimeCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    /**
     * Method Name: execute
     * Purpose: Executes the action of updating the time stamp of the last question through the ScoreReceiver.
     */
    @Override
    public void execute() {
        scoreReceiver.updateLastQuestionTime();
    }   
}
