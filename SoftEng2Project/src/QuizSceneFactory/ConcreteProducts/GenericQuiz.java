package QuizSceneFactory.ConcreteProducts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import app.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericQuiz {
    public static JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        JPanel panel = new JPanel();
        String panelName = category +" Q#" + Integer.toString(questionNum);
        JLabel panelNameLabel = new JLabel(panelName);
        panel.add(panelNameLabel);

        List<String> shuffledOptions = new ArrayList<>(List.of(optionA, optionB, optionC, optionD));
        Collections.shuffle(shuffledOptions);
        String opA = shuffledOptions.get(0);
        String opB = shuffledOptions.get(1);
        String opC = shuffledOptions.get(2);
        String opD = shuffledOptions.get(3);

        JPanel layoutPanel = new JPanel();
        layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));

        JLabel questionTextLabel = new JLabel(questionText);
        panel.add(questionTextLabel);

        JRadioButton optionAButton = new JRadioButton(opA);
        JRadioButton optionBButton = new JRadioButton(opB);
        JRadioButton optionCButton = new JRadioButton(opC);
        JRadioButton optionDButton = new JRadioButton(opD);

        ButtonGroup group = new ButtonGroup();
        group.add(optionAButton);
        group.add(optionBButton);
        group.add(optionCButton);
        group.add(optionDButton);

        panel.add(optionAButton);
        panel.add(optionBButton);
        panel.add(optionCButton);
        panel.add(optionDButton);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (group.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Please select an option");
                    return;
                }

                String selectedOption;
                if(optionAButton.isSelected()) {
                    selectedOption = opA;
                } else if(optionBButton.isSelected()) {
                    selectedOption = opB;
                } else if(optionCButton.isSelected()) {
                    selectedOption = opC;
                } else {
                    selectedOption = opD;
                }

                if(selectedOption.equals(correctOption)) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    ScoreTracker.incrementScore();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctOption);
                }

                if(questionNum == 10) {
                    JOptionPane.showMessageDialog(null, "Game Over! Your score is " + Integer.toString(ScoreTracker.getScore()) + " points.");
                    String playerName = JOptionPane.showInputDialog(null, "Enter your name for the leaderboard!");
                    if(playerName != null && !playerName.isEmpty()){
                        Leaderboard.addNewScore(playerName, ScoreTracker.getScore());
                    }
                    LeaderboardScene.updateLeaderboard();
                    Application.showScene("Leaderboard Scene"); //Will need to change this once we have an end scene
                    return;
                } else {
                    String nextScene = category + " Q#" + Integer.toString(questionNum + 1);
                    Application.showScene(nextScene);
                }
            }
        });

        panel.add(submitButton);


        return panel;
    }

    
}
