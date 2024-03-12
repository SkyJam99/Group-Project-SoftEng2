package QuizSceneFactory.ConcreteProducts;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ScoreCommand.*;
import ScoreCommand.UpdateLastQuestionTimeCommand;
import app.Application;
import app.Leaderboard;
import app.QuizConstructor;

import app.*;

public class PointModQuiz implements Quiz {
    public JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        JPanel panel = createPanel(category, questionNum);
        List<String> shuffledOptions = shuffleOptions(optionA, optionB, optionC, optionD);
        createQuestionAndOptions(panel, questionText, shuffledOptions);
        createSubmitButton(panel, shuffledOptions, correctOption, category, questionNum);
        return panel;
    }

    public JPanel createPanel(String category, int questionNum) {
        JPanel panel = new JPanel();
        String panelName = category + " Q#" + questionNum;
        JLabel panelNameLabel = new JLabel(panelName);
        
        panel.setLayout(new GridLayout(12,3));
        
        //NEED TO FIGURE OUT HOW EACH SCENE IS BUILT TO KNOW WHEN EACH IS INSERTED INTO THE SCENE
        //SWING STYLING IS LIKE ON BY ONE IN ORDER

        //SO I NEED TO FIGURE OUT AND HOW TO USE THE SAME SCENE "PANEL" TO INSERT ALL COMPONENTS
        panel.add(panelNameLabel);
        System.out.println("CreatePanel fired");
    

        
        return panel;

    }

    public List<String> shuffleOptions(String... options) {
        List<String> shuffledOptions = new ArrayList<>(List.of(options));
        Collections.shuffle(shuffledOptions);
        return shuffledOptions;
    }

    public void createQuestionAndOptions(JPanel panel, String questionText, List<String> options) {
        JLabel questionTextLabel = new JLabel(questionText);
        
        System.out.println("Create question and options fired");
        
        //styling


        panel.add(questionTextLabel);


        JRadioButton optionAButton = new JRadioButton(options.get(0));
        JRadioButton optionBButton = new JRadioButton(options.get(1));
        JRadioButton optionCButton = new JRadioButton(options.get(2));
        JRadioButton optionDButton = new JRadioButton(options.get(3));


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
        submitButton.addActionListener(e -> handleSubmitAction(options, correctOption, category, questionNum, panel));
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
            Command addScoreCommand = new AddScoreHalfCommand(QuizConstructor.scoreReceiver);
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
