package app;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class ScienceScene extends JPanel {
    public ScienceScene(){
        add(new JLabel("Science Scene"));
        JButton menuButton = new JButton("Back to  Categories");

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);
    }
}
