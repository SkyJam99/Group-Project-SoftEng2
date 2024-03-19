package app;
import javax.swing.*;

import Leaderboard.*;

import java.awt.Color;
import java.awt.Dimension;
//import javax.swing.*;
import java.awt.*;

/**
 * Class Name: OptionScene
 * Purpose: Constructs the options menu for the quiz game.
 * Usage: This scene is used as part of the game's UI 
 */
public class OptionScene extends JPanel {

    /**
     * Method Name: OptionScene
     * Purpose: Initializes the OptionScene with UI components.
     */


    public OptionScene() {
        setBackground(new Color(119, 186, 153));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 

        JLabel titleLabel = new JLabel("Options");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        add(titleLabel);

        JButton resetButton = new JButton("Reset Leaderboard");
        resetButton.setPreferredSize(new Dimension(200, 50));
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        resetButton.addActionListener(e -> {
            Leaderboard.resetLeaderboard();
            LeaderboardScene.updateLeaderboard();
        });
        resetButton.setForeground(new Color(239, 240, 209));
        resetButton.setBackground(new Color(38, 39, 48));
        add(resetButton);

        MenuButton menuButton = new MenuButton("Exit", "Main Menu");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
        add(menuButton);
    }

}
