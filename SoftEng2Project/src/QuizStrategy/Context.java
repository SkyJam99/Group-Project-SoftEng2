package QuizStrategy;

import javax.swing.JPanel;

public class Context {
    private Quiz _strategy;

    public Context(Quiz strategy) {
        this._strategy = strategy;
    }

    public void setStrategy(Quiz strategy) {
        this._strategy = strategy;
    }

    public JPanel executeStrategy(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) { 
        return this._strategy.quizConstructor(category, questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
    }
}
