package QuizSceneFactory.ConcreteProducts;

import javax.swing.*;


import QuizSceneFactory.QuizSceneInterface;

public class ScienceQuiz implements QuizSceneInterface {
    @Override
    public JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        JPanel panel = GenericQuiz.quizConstructor("Science", questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
        return panel;
    }
}
