package QuizStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;

import Leaderboard.Leaderboard;
import Leaderboard.LeaderboardScene;
import ScoreCommand.AddScoreCommand;
import ScoreCommand.Command;
import ScoreCommand.UpdateLastQuestionTimeCommand;
import app.*;

public class JumbledQuiz implements Quiz {
    public JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        StringBuilder optionARev = new StringBuilder(optionA);
        optionA = optionARev.reverse().toString();
        StringBuilder optionBRev = new StringBuilder(optionB);
        optionB = optionBRev.reverse().toString();
        StringBuilder optionCRev = new StringBuilder(optionC);
        optionC = optionCRev.reverse().toString();
        StringBuilder optionDRev = new StringBuilder(optionD);
        optionD = optionDRev.reverse().toString();
        StringBuilder correctOptionRev = new StringBuilder(correctOption);
        correctOption = correctOptionRev.reverse().toString();

        JPanel panel = createPanel(category, questionNum);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        List<String> shuffledOptions = shuffleOptions(optionA, optionB, optionC, optionD);
        createQuestionAndOptions(panel, questionText, shuffledOptions);
        createSubmitButton(panel, shuffledOptions, correctOption, category, questionNum);

        panel.add(Box.createVerticalGlue());

        return panel;
    }

    public JPanel createPanel(String category, int questionNum) {
        JPanel panel = new JPanel();
        String panelName = category + " Q#" + questionNum;
        JLabel panelNameLabel = new JLabel(panelName);

        panelNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(panelNameLabel);
        System.out.println("ScrambledQuiz created");
        return panel;

    }

    public List<String> shuffleOptions(String... options) {
        List<String> shuffledOptions = new ArrayList<>(List.of(options));
        Collections.shuffle(shuffledOptions);
        return shuffledOptions;
    }

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

    public void createSubmitButton(JPanel panel, List<String> options, String correctOption, String category, int questionNum) {
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(30,30));
        submitButton.addActionListener(e -> handleSubmitAction(options, correctOption, category, questionNum, panel));
        //aligning in the center
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(submitButton);
    }

    public void handleSubmitAction(List<String> options, String correctOption, String category, int questionNum, JPanel panel) {
        ButtonGroup group = findButtonGroup(panel);
        if (group != null && group.getSelection() != null) {
            String selectedOption = options.get(getSelectedOptionIndex(group, panel));
            displayResultMessage(selectedOption, correctOption, category, questionNum);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an option");
        }
    }

    public ButtonGroup findButtonGroup(Container container) {
        // Assuming there is only one ButtonGroup in this context
        for (Component comp : container.getComponents()) {
            if (comp instanceof JRadioButton) {
                return ((JRadioButton) comp).getModel().getGroup();
            }
        }
        return null;
    }

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
