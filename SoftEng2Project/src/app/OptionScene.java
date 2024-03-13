package app;
import javax.swing.*;
import java.awt.event.*;

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
    public OptionScene(){
        JPanel OptionScene = new JPanel();
        add(new JLabel("Options"));
        MenuButton menuButton = new MenuButton("Exit","Main Menu");
        add(menuButton);
    }
}
