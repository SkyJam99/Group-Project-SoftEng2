import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class GameScene extends JPanel {
    public GameScene(){
        JPanel GameScene = new JPanel();
        add(new JLabel("Game Scene"));

        MenuButton menuButton = new MenuButton("Menu","Main Menu");
        add(menuButton);
    }
}
