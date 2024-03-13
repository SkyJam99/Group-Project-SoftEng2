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
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene(sceneName);
                Application.score++;
                System.out.println(Application.score);
            }
        });
    }
}
