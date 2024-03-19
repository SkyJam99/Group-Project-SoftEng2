package app;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Class Name: ScienceScene
 * Purpose: Provides the GUI for the science category of the quiz game, allowing users to start the quiz or return to the main game scene.
 * Usage: This class is instantiated and displayed when the user selects the science category from the main game scene.
 */
public class ScienceScene extends JPanel {
    
    /**
     * Method Name: ScienceScene
     * Purpose: Constructs the ScienceScene with all UI components setup
     */
    public ScienceScene(){
        setBackground(new Color(119, 186, 153));
        Dimension buttonSize = new Dimension(200,50);

        JLabel scienceText = new JLabel("Feeling sciency? Test your knowledge!");
        scienceText.setFont(scienceText.getFont().deriveFont(Font.PLAIN, 40));
        scienceText.setAlignmentX(Component.CENTER_ALIGNMENT);

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


        JButton startButton = new JButton("Start Science Category");
        startButton.setPreferredSize(buttonSize);
        startButton.setFont(menuButton.getFont().deriveFont(Font.PLAIN, 30));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                QuizConstructor.buildQuiz("Science");
            }
        });

        menuButton.setForeground(new Color(239, 240, 209));
        menuButton.setBackground(new Color(38, 39, 48));
        startButton.setForeground(new Color(239, 240, 209));
        startButton.setBackground(new Color(38, 39, 48));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createVerticalGlue());


        add(scienceText);

        add(Box.createVerticalStrut(50));

        add(startButton);

        add(Box.createVerticalStrut(10));
        
        add(menuButton);

        add(Box.createVerticalGlue());
    }
}
