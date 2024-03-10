package app;
import com.sun.tools.javac.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.*;

import javax.swing.BorderFactory;
import java.awt.GridLayout;


public class Application {

    public static int score = 0;
    public static int timer = 0;
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel parentPanel = new JPanel(cardLayout);
    public Application() {

        //apprently this swingutilities increases performance? can take it out if needed
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Spooky Quiz Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //adding scene
            addScene(new MainMenu(frame), "Main Menu");
            addScene(new GameScene(), "Game Scene");
            addScene(new LeaderboardScene(), "Leaderboard Scene");
            addScene(new OptionScene(), "Option Scene");
            addScene(new HistoryScene(), "History Scene");
            addScene(new ScienceScene(), "Science Scene");
            addScene(new EntertainmentScene(), "Entertainment Scene");


            frame.add(parentPanel);

            frame.setSize(1000,1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    //method to show the scene (used in MenuButton)
    public static void showScene(String sceneName){
        cardLayout.show(parentPanel, sceneName);
    }
    //method to add scene to the parent panel, reduced code repetition; sceneName matters
    public static void addScene(JPanel scene, String sceneName){
        parentPanel.add(scene, sceneName);
    }

    public static void main(String[] args){
        new Application();
    }
}
