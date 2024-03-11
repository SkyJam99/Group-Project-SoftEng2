package ScoreCommand;

public class AddScoreCommand implements Command{
    private ScoreReceiver scoreReceiver;

    public AddScoreCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    @Override
    public void execute() {
        scoreReceiver.addScore();
    }
    
}
