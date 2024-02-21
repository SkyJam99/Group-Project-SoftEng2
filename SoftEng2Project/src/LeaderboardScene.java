import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class LeaderboardScene extends JPanel {
    public LeaderboardScene(){
        JPanel LeaderboardScene = new JPanel();
        add(new JLabel("Leaderboard Scene"));
        JButton menuButton = new JButton("Menu");

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Main Menu");

            }
        });

        add(menuButton);
    }
}
