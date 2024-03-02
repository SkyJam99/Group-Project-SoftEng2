package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScene extends JPanel {
    public GameScene(){
        JPanel GameScene = new JPanel();
        Dimension buttonSize = new Dimension(200,50);

        setLayout(new GridLayout(5,3));
        add(new JLabel("Select your category"));

        MenuButton historyButton = new MenuButton("History","History Scene");
        MenuButton scienceButton = new MenuButton("Science", "Science Scene");
        MenuButton entertainmentButton = new MenuButton("Entertainment", "Entertainment Scene");


        MenuButton backButton = new MenuButton("Back to Main Menu", "Main Menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setPreferredSize(buttonSize);
        backButton.setFont(backButton.getFont().deriveFont(Font.PLAIN, 20));

        add(historyButton);
        add(scienceButton);
        add(entertainmentButton);
        add(backButton);

    }

}
