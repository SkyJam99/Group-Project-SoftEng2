package QuestionSingleton;

/**
 * Class Name: QuestionFactory
 * Purpose: Provides a method for creating Question objects, encapsulating the instantiation
 *          logic for questions in the Spooky Quiz game.
 * Usage: This class is utilized whenever a new question needs to be created.
 */
public class QuestionFactory {

    /**
     * Method Name: createQuestion
     * Purpose: Creates and returns a new Question object with the specified details.
     * Parameters:
     *     - questionText (String): The text of the quiz question.
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct answer
     * Returns: Question - A new instance of Question filled with the provided parameters.
     */
    public static Question createQuestion(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        return new Question(questionText, optionA, optionB, optionC, optionD, correctOption);
    }
}