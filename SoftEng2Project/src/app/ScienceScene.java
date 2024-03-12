package app;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ScienceScene extends JPanel {
    public ScienceScene(){

        JLabel scienceText = new JLabel("Feeling sciency? Test your knowledge!");
        scienceText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });


        JButton startButton = new JButton("Start Science Category");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("Science");
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalGlue());


        add(scienceText);

        add(Box.createVerticalStrut(50));

        add(startButton);

        add(Box.createVerticalStrut(50));
        
        add(menuButton);

        add(Box.createVerticalGlue());
    }
}
