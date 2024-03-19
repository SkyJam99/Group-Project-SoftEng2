package QuizStrategy;

import javax.swing.JPanel;

/**
 * Class Name: Context
 * Purpose: Defines the context for the Strategy pattern.
 * Usage: Used to execute a strategy for creating quiz scenes.
 */

public class Context {
    private Quiz _strategy;

    /**
     * Method Name: Context
     * Purpose: Constructor for the Context class.
     * Parameters:
     *     - strategy (Quiz): The strategy to be executed.
     * Returns: None
     */
    public Context(Quiz strategy) {
        this._strategy = strategy;
    }

    /**
     * Method Name: setStrategy
     * Purpose: Sets the strategy to be executed.
     * Parameters:
     *     - strategy (Quiz): The strategy to be executed.
     * Returns: None
     */
    public void setStrategy(Quiz strategy) {
        this._strategy = strategy;
    }

    /**
     * Method Name: executeStrategy
     * Purpose: Executes the strategy to create a quiz scene.
     * Parameters:
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     *     - questionText (String): The text of the question
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct option.
     * Returns: JPanel with the question and options.
     */
    public JPanel executeStrategy(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) { 
        return this._strategy.quizConstructor(category, questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
    }
}
