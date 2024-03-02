package app;
import javax.swing.*;
import java.awt.event.*;

public class ScienceScene extends JPanel {
    public ScienceScene(){
        add(new JLabel("Science"));
        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);

        JButton startButton = new JButton("Start Science Category");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("Science");
            }
        });

        add(startButton);
    }
}
