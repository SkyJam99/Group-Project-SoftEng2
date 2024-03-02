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
                if(questionNum == 10) {
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
