package QuizStrategy;

import ScoreCommand.*;
import javax.swing.*;

import Leaderboard.Leaderboard;
import Leaderboard.LeaderboardScene;

import java.awt.*;
//import java.awt.event.*;
import app.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Enumeration;

/**
 * Class Name: GenericQuiz
 * Purpose: Provides the generic structure and functionality for creating quiz question scenes within the game.
 * Utilizes the Strategy pattern to define a common interface for quiz questions, Quiz.java
 * Usage: Used as the base class for creating different types of quiz questions. Interacts with the UI components and scoring system.
 */
public class GenericQuiz implements Quiz{
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

    public JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {

        JPanel panel = createPanel(category, questionNum);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        List<String> shuffledOptions = shuffleOptions(optionA, optionB, optionC, optionD);
        createQuestionAndOptions(panel, questionText, shuffledOptions);
        createSubmitButton(panel, shuffledOptions, correctOption, category, questionNum);

        panel.add(Box.createVerticalGlue());

        return panel;
    }

    /**
     * Method Name: createPanel
     * Purpose: Creates a JPanel with a label indicating the question category and number.
     * Parameters:
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     * Returns: JPanel with a category and question number label.
     */
    public JPanel createPanel(String category, int questionNum) {
        JPanel panel = new JPanel();
        String panelName = category + " Q#" + questionNum;
        JLabel panelNameLabel = new JLabel(panelName);


        panel.add(panelNameLabel);

        return panel;

    }

    /**
     * Method Name: shuffleOptions
     * Purpose: Shuffles the given options and returns them as a list.
     * Parameters:
     *     - options (String...): Varargs parameter for question options.
     * Returns: A list of shuffled options.
     */
    public List<String> shuffleOptions(String... options) {
        List<String> shuffledOptions = new ArrayList<>(List.of(options));
        Collections.shuffle(shuffledOptions);
        return shuffledOptions;
    }

    /**
     * Method Name: createQuestionAndOptions
     * Purpose: Adds the question text and option buttons to a panel.
     * Parameters:
     *     - panel (JPanel): The panel to add components to.
     *     - questionText (String): The text of the question.
     *     - options (List<String>): A list of option texts.
     * Returns: None.
     */
    public void createQuestionAndOptions(JPanel panel, String questionText, List<String> options) {

        //align each component in the center of the box layout (from parent panel)

        JLabel questionTextLabel = new JLabel(questionText);
        questionTextLabel.setFont(questionTextLabel.getFont().deriveFont(Font.PLAIN, 30));
        questionTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(questionTextLabel);

        JRadioButton optionAButton = new JRadioButton(options.get(0));
        optionAButton.setFont(optionAButton.getFont().deriveFont(Font.PLAIN, 20));
        optionAButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JRadioButton optionBButton = new JRadioButton(options.get(1));
        optionBButton.setFont(optionBButton.getFont().deriveFont(Font.PLAIN, 20));
        optionBButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JRadioButton optionCButton = new JRadioButton(options.get(2));
        optionCButton.setFont(optionCButton.getFont().deriveFont(Font.PLAIN, 20));
        optionCButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JRadioButton optionDButton = new JRadioButton(options.get(3));
        optionDButton.setFont(optionDButton.getFont().deriveFont(Font.PLAIN, 20));
        optionDButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        ButtonGroup group = new ButtonGroup();
        group.add(optionAButton);
        group.add(optionBButton);
        group.add(optionCButton);
        group.add(optionDButton);

        panel.add(optionAButton);
        panel.add(optionBButton);
        panel.add(optionCButton);
        panel.add(optionDButton);

    }

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
    public void createSubmitButton(JPanel panel, List<String> options, String correctOption, String category, int questionNum) {
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(30,30));
        submitButton.addActionListener(e -> handleSubmitAction(options, correctOption, category, questionNum, panel));
        //aligning in the center
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(submitButton);
    }

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
    public void handleSubmitAction(List<String> options, String correctOption, String category, int questionNum, JPanel panel) {
        ButtonGroup group = findButtonGroup(panel);
        if (group != null && group.getSelection() != null) {
            String selectedOption = options.get(getSelectedOptionIndex(group, panel));
            displayResultMessage(selectedOption, correctOption, category, questionNum);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an option");
        }
    }

    /**
     * Method Name: findButtonGroup
     * Purpose: Finds the ButtonGroup associated with the radio buttons in the panel.
     * Parameters:
     *     - container (Container): The container to search within.
     * Returns: The ButtonGroup if found, otherwise null.
     */
    public ButtonGroup findButtonGroup(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JRadioButton) {
                return ((JRadioButton) comp).getModel().getGroup();
            }
        }
        return null;
    }

    /**
     * Method Name: getSelectedOptionIndex
     * Purpose: Gets the index of the selected option in the ButtonGroup.
     * Parameters:
     *     - group (ButtonGroup): The ButtonGroup containing the options.
     *     - container (Container): The container of the ButtonGroup.
     * Returns: The index of the selected option.
     */
    public int getSelectedOptionIndex(ButtonGroup group, Container container) {
        int i = 0;
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return i;
            }
            i++;
        }
        return -1; // Should not happen
    }

    /**
     * Method Name: displayResultMessage
     * Purpose: Displays a message to the user indicating whether they selected the correct answer.
     * Parameters:
     *     - selectedOption (String): The option selected by the user.
     *     - correctOption (String): The correct answer.
     *     - category (String): The category of the question.
     *     - questionNum (int): The question number within the category.
     */
    public void displayResultMessage(String selectedOption, String correctOption, String category, int questionNum) {
        if (selectedOption.equals(correctOption)) {
            JOptionPane.showMessageDialog(null, "Correct!");
            Command addScoreCommand = new AddScoreCommand(QuizConstructor.scoreReceiver);
            addScoreCommand.execute();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctOption);
            Command updateLastQuestionTimeCommand = new UpdateLastQuestionTimeCommand(QuizConstructor.scoreReceiver);
            updateLastQuestionTimeCommand.execute();
        }

        if (questionNum == 10) {
            endGame();
        } else {
            String nextScene = category + " Q#" + (questionNum + 1);
            Application.showScene(nextScene);
        }
    }

    /**
     * Method Name: endGame
     * Purpose: Ends the game, displays the user's score and asks for leaderboard entry.
     */
    public void endGame() {

        JOptionPane.showMessageDialog(
            null, 
            "Game Over! Your score is " + 
            QuizConstructor.scoreReceiver.getScore() + 
            " points. You took " + 
            QuizConstructor.scoreReceiver.getTotalTime() + 
            " seconds to complete the quiz.");

        String playerName = JOptionPane.showInputDialog(null, "Enter your name for the leaderboard!");
        if (playerName != null && !playerName.trim().isEmpty()) {
            Leaderboard.addNewScore(playerName, QuizConstructor.scoreReceiver.getScore());
        }
        LeaderboardScene.updateLeaderboard();
        Application.showScene("Leaderboard Scene");
    }
}
