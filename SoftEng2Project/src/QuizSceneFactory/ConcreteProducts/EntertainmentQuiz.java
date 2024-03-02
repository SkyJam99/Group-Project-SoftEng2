package QuizSceneFactory.ConcreteProducts;

import QuizSceneFactory.QuizSceneInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import app.*;



public class EntertainmentQuiz implements QuizSceneInterface {
    
    
    @Override
    public JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        JPanel panel = new JPanel();
        
        String panelName = "Entertainment Q#" + Integer.toString(questionNum);
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
                String nextScene = "Entertainment Q#" + Integer.toString(questionNum + 1);
                Application.showScene(nextScene);
            }
        });

        panel.add(submitButton);

        

        return panel;
    }
}
