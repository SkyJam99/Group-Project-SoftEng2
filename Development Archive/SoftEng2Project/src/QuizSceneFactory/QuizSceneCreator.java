package QuizSceneFactory;

import javax.swing.JPanel;

/**
 * Class Name: QuizSceneCreator
 * Purpose: Serves as the base creator in the Factory design pattern for quiz scenes.
 * Usage: Extended by concrete creators to define specific quiz scene creations
 */
public abstract class QuizSceneCreator extends JPanel {
    /**
     * Method Name: createScene
     * Purpose: Creates and initializes a quiz scene with the given question and options.
     * Parameters:
     *     - questionNum (int): The number of the current question.
     *     - questionText (String): The text of the current question.
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct option for the question.
     * Returns: JPanel - The fully initialized quiz scene panel.
     */
    public JPanel createScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption){
        QuizSceneInterface scene = constructScene();
        return scene.initializeScene(questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
    }

    /**
     * Method Name: constructScene
     * Purpose: Constructs an instance of a quiz scene. This method is intended to be implemented by subclasses to define specific types of quiz scenes.
     * Parameters: None.
     * Returns: QuizSceneInterface - An instance of a class that implements QuizSceneInterface
     */
    public abstract QuizSceneInterface constructScene();
}
