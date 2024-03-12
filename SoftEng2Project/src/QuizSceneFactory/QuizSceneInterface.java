package QuizSceneFactory;

import javax.swing.*;
/**
 * Interface Name: QuizSceneInterface
 * Purpose: Defines a contract for quiz scene creation using the Factory design pattern.
 * Usage: Implemented by classes for specific quiz scene types, ensuring a standardized initialization method.
 */
public interface QuizSceneInterface {
    /**
     * Method Name: initializeScene
     * Purpose: Initializes and returns a quiz scene panel with given question and options.
     * Parameters:
     *     - questionNum (int): The number of the current question.
     *     - questionText (String): The text of the current question.
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct option for the question.
     * Returns: JPanel - A JPanel containing the quiz scene.
     * Usage Example: Implemented by specific scene classes for scene creation.
     */
    JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption);
}
