import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class HistoryScene extends JPanel {
    public HistoryScene(){

        add(new JLabel("History"));
        JButton menuButton = new JButton("Testing");

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);
    }
}
