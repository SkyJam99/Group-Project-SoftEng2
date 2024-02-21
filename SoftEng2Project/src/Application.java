import com.sun.tools.javac.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.*;

import javax.swing.BorderFactory;
import java.awt.GridLayout;
public class Application {
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel parentPanel = new JPanel(cardLayout);
    public Application() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Spooky Quiz Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            addScene(new MainMenu(frame), "Main Menu");
            addScene(new GameScene(), "Game Scene");
            addScene(new LeaderboardScene(), "Leaderboard Scene");
            addScene(new OptionScene(), "Option Scene");

            frame.add(parentPanel);

            frame.setSize(1000,1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void showScene(String sceneName){
        cardLayout.show(parentPanel, sceneName);
    }
    public static void addScene(JPanel scene, String sceneName){
        parentPanel.add(scene, sceneName);
    }

    public static void main(String[] args){
        new Application();
    }
}
