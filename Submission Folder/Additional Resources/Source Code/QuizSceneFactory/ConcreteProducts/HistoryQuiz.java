package QuizSceneFactory.ConcreteProducts;

import java.awt.Color;
import java.util.Random;

import javax.swing.*;

import QuizSceneFactory.QuizSceneInterface;
import QuizStrategy.*;

/**
 * Class Name: HistoryQuiz
 * Purpose: Represents the concrete product for creating quiz scenes in the History category.
 * Usage: Used by the QuizSceneFactory to instantiate History quiz scenes with different behaviors
 *        based on a randomly selected quiz strategy.
 */
public class HistoryQuiz implements QuizSceneInterface {
    
    /**
     * Method Name: initializeScene
     * Purpose: Initializes and returns a JPanel that represents a single question scene for the History category.
     * Parameters:
     *     - questionNum (int): The question number within the quiz sequence.
     *     - questionText (String): The text of the question to be displayed.
     *     - optionA (String): The text for option A.
     *     - optionB (String): The text for option B.
     *     - optionC (String): The text for option C.
     *     - optionD (String): The text for option D.
     *     - correctOption (String): The correct option
     * Returns: JPanel - A panel representing the quiz scene.
     */
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

        Context context = new Context(q);

        JPanel panel = context.executeStrategy("History", questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
        panel.setBackground(new Color(119, 186, 153));

        return panel;
    }
}