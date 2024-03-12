package ScoreCommand;

public class AddScoreHalfCommand implements Command{
    private ScoreReceiver scoreReceiver;

    public AddScoreHalfCommand(ScoreReceiver scoreReceiver) {
        this.scoreReceiver = scoreReceiver;
    }

    @Override
    public void execute() {
        scoreReceiver.addScoreHalf();
    }
    
}
