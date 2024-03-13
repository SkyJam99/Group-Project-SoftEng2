package app;
import com.sun.tools.javac.Main;

import javax.swing.*;

import java.awt.*;

/**
 * Class Name: Application
 * Purpose: Initializes the main application, setting up the quiz game scenes.
 * Usage: This class is the entry point of the Quiz Game, it initializes the game's GUI and leaderboard
 */
public class Application {

    //Can we get rid of these variables?
    public static int score = 0;
    public static int timer = 0;

    
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel parentPanel = new JPanel(cardLayout);
    

    /**
     * Method Name: Application (Constructor)
     * Purpose: Sets up the main game window, initializes the game scenes, and displays the main menu.
     * Parameters: None.
     * Returns: None.
     * Usage Example: new Application(); // To start the game.
     * Last Modified: [Your Name/Team Name] on [Last Modification Date].
     */
    public Application() {

        //this swingutilities increases performance
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Spooky Quiz Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Initialize Leaderboard
            Leaderboard.initalizeLeaderboard();

            //adding scene
            addScene(new MainMenu(frame), "Main Menu");
            addScene(new GameScene(), "Game Scene");
            addScene(new LeaderboardScene(), "Leaderboard Scene");
            addScene(new OptionScene(), "Option Scene");
            addScene(new HistoryScene(), "History Scene");
            addScene(new ScienceScene(), "Science Scene");
            addScene(new EntertainmentScene(), "Entertainment Scene");


            frame.add(parentPanel);

            frame.getContentPane().setBackground(new Color(303));

            frame.setSize(1000,1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    /**
     * Method Name: showScene
     * Purpose: Changes the current visible scene to the one specified by the scene name.
     * Parameters:
     *     - sceneName (String): The name of the scene to be displayed.
     * Returns: None.
     * Usage Example: Application.showScene("Main Menu"); // To display the main menu
     */
    public static void showScene(String sceneName){
        cardLayout.show(parentPanel, sceneName);
    }
    
    /**
     * Method Name: addScene
     * Purpose: Adds a new scene to the card layout for later display.
     * Parameters:
     *     - scene (JPanel): The scene to add to the card layout.
     *     - sceneName (String): The name of the scene, used as a reference for switching scenes.
     * Returns: None.
     * Usage Example: Application.addScene(new GameScene(), "Game Scene"); // To add the game scene.
     */
    public static void addScene(JPanel scene, String sceneName){
        parentPanel.add(scene, sceneName);
    }

    /**
     * Method Name: main
     * Purpose: Creates an instance of the Application class to start the game.
     * Parameters:
     *     - args (String[]): Command line arguments passed to the application.
     * Returns: None.
     */
    public static void main(String[] args){
        new Application();
    }
}
