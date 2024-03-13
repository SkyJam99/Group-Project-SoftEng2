package app;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Class Name: HistoryScene
 * Purpose: Provides the GUI for the History category of the quiz game, allowing users to start the quiz or return to the main game scene.
 * Usage: This class is instantiated and displayed when the user selects the History category from the main game scene.
 */
public class HistoryScene extends JPanel {
    
    /**
     * Method Name: HistoryScene
     * Purpose: Constructs the HistoryScene with all UI components setup
     */
    public HistoryScene(){

        JLabel historyText = new JLabel("How well do you know your history?");
        historyText.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });


        JButton startButton = new JButton("Start History Category");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("History");
            }
        });


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalGlue());

        add(historyText);

        add(Box.createVerticalStrut(50));

        add(startButton);

        add(Box.createVerticalStrut(50));

        add(menuButton);

        add(Box.createVerticalGlue());
        
    }
}
