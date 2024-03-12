package QuizSceneFactory.ConcreteProducts;

import QuizSceneFactory.QuizSceneInterface;
import javax.swing.*;

public class EntertainmentQuiz implements QuizSceneInterface {
    @Override
    public JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        GenericQuiz q = new GenericQuiz();
        JPanel panel = q.quizConstructor("Entertainment", questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
        return panel;
    }
}
