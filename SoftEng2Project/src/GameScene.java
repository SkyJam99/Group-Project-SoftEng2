import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameScene extends JPanel {
    public GameScene(){
        JPanel GameScene = new JPanel();
        setLayout(new GridLayout(5,3));
        add(new JLabel("Select your category"));

        MenuButton historyButton = new MenuButton("History","History Scene");
        MenuButton scienceButton = new MenuButton("Science", "Science Scene");
        MenuButton entertainmentButton = new MenuButton("Entertainment", "Entertainment Scene");


        add(historyButton);
        add(scienceButton);
        add(entertainmentButton);

    }

}
