package ScoreCommand;

public class UpdateLastQuestionTimeCommand implements Command {
    private ScoreReceiver scoreReceiver;

    public UpdateLastQuestionTimeCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    @Override
    public void execute() {
        scoreReceiver.updateLastQuestionTime();
    }   
}
