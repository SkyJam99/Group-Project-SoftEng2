import javax.swing.*;
import java.awt.event.*;

public class HistoryScene extends JPanel {
    public HistoryScene(){

        add(new JLabel("History"));
        JButton menuButton = new JButton("Testing");

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.addScene(new LeaderboardScene(), "History Scene #2");
                Application.showScene("History Scene #2");

            }
        });

        add(menuButton);
    }
}
