package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class Name: MenuButton
 * Purpose: Extends JButton to create a specialized button that switches scenes within the application.
 * Usage: Used throughout the application for navigating between different scenes of the quiz game.
 */
public class MenuButton extends JButton {
    //Remove this?
    private String sceneName;

    
     /**
     * Method Name: MenuButton
     * Purpose: Constructs a MenuButton with specified text and the name of the scene it should switch to.
     * Parameters:
     *     - text (String): The text to be displayed on the button.
     *     - sceneName (String): The name of the scene to load on button press.
     * Returns: None
     * Usage Example: MenuButton exitButton = new MenuButton("Exit", "Main Menu"); // Creates a button to return to the main menu
     */
    public MenuButton(String text, String sceneName){
        super(text);
        this.sceneName = sceneName;
        initButton(); // Initialize button appearance
    }

    /**
     * Method Name: initButton
     * Purpose: Constructs a MenuButton with specified formatting
     * Returns: None
     */
    private void initButton() {

        this.setForeground(new Color(239, 240, 209)); //text color
        this.setBackground(new Color(38, 39, 48)); 
        this.setFont(new Font("Tahoma", Font.BOLD, 20));

        // Set the button's action listener
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.showScene(sceneName);
            }
        });
    }
}
