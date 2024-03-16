package QuizStrategy;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import java.awt.Container;
import java.util.List;

/**
 * Class Name: Quiz
 * Purpose: Defines the interface for creating quiz questions.
 * This interface establishes the contract for implementing the Strategy pattern.
 * Usage: Implemented by classes that define specific quiz behaviors..
 */
public interface Quiz {
    
    /**
     * Method Name: quizConstructor
     * Purpose: Constructs a JPanel for a quiz question, including question text and options.
     * Parameters:
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     *     - questionText (String): The text of the question.
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct option.
     * Returns: JPanel containing the question and options.
     */
    JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption);
    
    /**
     * Method Name: createPanel
     * Purpose: Creates a JPanel with a label indicating the question category and number.
     * Parameters:
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     * Returns: JPanel with a category and question number label.
     */
    JPanel createPanel(String category, int questionNum);
    
    /**
     * Method Name: shuffleOptions
     * Purpose: Shuffles the given options and returns them as a list.
     * Parameters:
     *     - options (String...): Varargs parameter for question options.
     * Returns: A list of shuffled options.
     */
    List<String> shuffleOptions(String... options);
    
    /**
     * Method Name: createQuestionAndOptions
     * Purpose: Adds the question text and option buttons to a panel.
     * Parameters:
     *     - panel (JPanel): The panel to add components to.
     *     - questionText (String): The text of the question.
     *     - options (List<String>): A list of option texts.
     * Returns: None.
     */
    void createQuestionAndOptions(JPanel panel, String questionText, List<String> options);
    
    /**
     * Method Name: createSubmitButton
     * Purpose: Adds a submit button to the panel and sets its action.
     * Parameters:
     *     - panel (JPanel): The panel to add the submit button to.
     *     - options (List<String>): A list of option texts.
     *     - correctOption (String): The correct option.
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     * Returns: None.
     */
    void createSubmitButton(JPanel panel, List<String> options, String correctOption, String category, int questionNum);
    
    /**
     * Method Name: handleSubmitAction
     * Purpose: Handles the submit button action, checks the selected option, and displays the result.
     * Parameters:
     *     - options (List<String>): A list of option texts.
     *     - correctOption (String): The correct option.
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     *     - panel (JPanel): The panel containing the options.
     * Returns: None.
     */
    void handleSubmitAction(List<String> options, String correctOption, String category, int questionNum, JPanel panel);
    
    /**
     * Method Name: findButtonGroup
     * Purpose: Finds the ButtonGroup associated with the radio buttons in the panel.
     * Parameters:
     *     - container (Container): The container to search within.
     * Returns: The ButtonGroup if found, otherwise null.
     */
    ButtonGroup findButtonGroup(Container container);
    
    /**
     * Method Name: getSelectedOptionIndex
     * Purpose: Gets the index of the selected option in the ButtonGroup.
     * Parameters:
     *     - group (ButtonGroup): The ButtonGroup containing the options.
     *     - container (Container): The container of the ButtonGroup.
     * Returns: The index of the selected option.
     */
    int getSelectedOptionIndex(ButtonGroup group, Container container);
    
    /**
     * Method Name: displayResultMessage
     * Purpose: Displays a message to the user indicating whether they selected the correct answer.
     * Parameters:
     *     - selectedOption (String): The option selected by the user.
     *     - correctOption (String): The correct answer.
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     */
    void displayResultMessage(String selectedOption, String correctOption, String category, int questionNum);

    /**
     * Method Name: endGame
     * Purpose: Ends the game, displays the user's score and asks for leaderboard entry.
     */
    void endGame();
}
