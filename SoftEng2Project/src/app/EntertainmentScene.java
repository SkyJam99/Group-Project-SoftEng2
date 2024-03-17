package app;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Class Name: EntertainmentScene
 * Purpose: Provides the GUI for the Entertainment category of the quiz game, allowing users to start the quiz or return to the main game scene.
 * Usage: This class is instantiated and displayed when the user selects the Entertainment category from the main game scene.
 */
public class EntertainmentScene extends JPanel {
    
    /**
     * Method Name: EntertainmentScene
     * Purpose: Constructs the EntertainmentScene with all UI components setup
     */
    public EntertainmentScene(){
        setBackground(new Color(119, 186, 153));

        Dimension buttonSize = new Dimension(200,50);
        JLabel entertainmentText = new JLabel("How well do you know your entertainment?");

        entertainmentText.setFont(entertainmentText.getFont().deriveFont(Font.PLAIN, 40));
        entertainmentText.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.setPreferredSize(buttonSize);
        menuButton.setFont(menuButton.getFont().deriveFont(Font.PLAIN, 30));

        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });


        JButton startButton = new JButton("Start Entertainment Category");
        startButton.setPreferredSize(buttonSize);
        startButton.setFont(menuButton.getFont().deriveFont(Font.PLAIN, 30));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("Entertainment");
            }
        });


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalGlue());

        add(entertainmentText);

        add(Box.createVerticalStrut(50));

        add(startButton);

        add(Box.createVerticalStrut(10));
        
        add(menuButton);

        add(Box.createVerticalGlue());

    }
}
