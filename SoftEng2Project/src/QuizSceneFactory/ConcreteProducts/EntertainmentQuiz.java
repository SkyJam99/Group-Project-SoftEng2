package QuizSceneFactory.ConcreteProducts;

import java.util.Random;

import javax.swing.*;

import QuizSceneFactory.QuizSceneInterface;
import QuizStrategy.*;
public class EntertainmentQuiz implements QuizSceneInterface {
    @Override
    public JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        Random random = new Random();
        int r = random.nextInt(10);
        
        Quiz q;

        if (r == 0) {
            q = new PointModQuiz();
        } else if (r == 1) {
            q = new JumbledQuiz();
        } else if (r == 2) {
            q = new LessTimeQuiz();
        } else {
            q = new GenericQuiz();
        }

        JPanel panel = q.quizConstructor("Entertainment", questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
        return panel;
    }
}