package app;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class OptionScene extends JPanel {
    public OptionScene(){
        JPanel OptionScene = new JPanel();
        add(new JLabel("Options"));
        MenuButton menuButton = new MenuButton("Exit","Main Menu");
        add(menuButton);
    }
}
