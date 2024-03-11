package ScoreCommand;

public class InitScoreCommand implements Command {
    private ScoreReceiver scoreReceiver;

    public InitScoreCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    @Override
    public void execute() {
        scoreReceiver.initScore();
    }
    
}
