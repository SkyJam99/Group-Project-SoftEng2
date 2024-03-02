package app;
import javax.swing.*;
import java.awt.event.*;

public class HistoryScene extends JPanel {
    public HistoryScene(){

        add(new JLabel("History"));
        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);

        JButton startButton = new JButton("Start History Category");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("History");
            }
        });

        add(startButton);
    }
}
