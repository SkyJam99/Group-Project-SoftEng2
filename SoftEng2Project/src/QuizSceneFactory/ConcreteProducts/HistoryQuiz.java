package QuizSceneFactory.ConcreteProducts;

import javax.swing.*;

import QuizSceneFactory.QuizSceneInterface;

public class HistoryQuiz implements QuizSceneInterface {
    @Override
    public JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        GenericQuiz q = new GenericQuiz();
        JPanel panel = q.quizConstructor("History", questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
        return panel;
    }
}
