package QuizSceneFactory.ConcreteProducts;

import javax.swing.*;
import java.awt.event.*;
import app.*;

public class GenericQuiz {
    public static JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        JPanel panel = new JPanel();
        String panelName = category +" Q#" + Integer.toString(questionNum);
        JLabel panelNameLabel = new JLabel(panelName);
        panel.add(panelNameLabel);

        JLabel questionTextLabel = new JLabel(questionText);
        panel.add(questionTextLabel);

        JRadioButton optionAButton = new JRadioButton(optionA);
        JRadioButton optionBButton = new JRadioButton(optionB);
        JRadioButton optionCButton = new JRadioButton(optionC);
        JRadioButton optionDButton = new JRadioButton(optionD);

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
                    selectedOption = optionA;
                } else if(optionBButton.isSelected()) {
                    selectedOption = optionB;
                } else if(optionCButton.isSelected()) {
                    selectedOption = optionC;
                } else {
                    selectedOption = optionD;
                }

                if(selectedOption.equals(correctOption)) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    ScoreTracker.incrementScore();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctOption);
                }

                if(questionNum == 10) {
                    JOptionPane.showMessageDialog(null, "Game Over! Your score is " + Integer.toString(ScoreTracker.getScore()) + " points.");
                    Leaderboard.addNewScore("TempName", ScoreTracker.getScore()); //Need to add a way to capture name
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
