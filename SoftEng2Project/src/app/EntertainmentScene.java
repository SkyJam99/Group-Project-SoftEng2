package app;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class EntertainmentScene extends JPanel {
    public EntertainmentScene(){

        add(new JLabel("Entertainment"));
        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);

        JButton startButton = new JButton("Start Entertainment Category");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("Entertainment");
            }
        });

        add(startButton);
    }
}
