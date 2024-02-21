import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel {
    public MainMenu(JFrame frame){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(Box.createVerticalBox());
        add(Box.createVerticalStrut(10));

        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(title);

        MenuButton gameButton = new MenuButton("Play the Game", "Game Scene");
        gameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        MenuButton leaderboardButton = new MenuButton("Leaderboards", "Leaderboard Scene");
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        MenuButton optionButton = new MenuButton("Options", "Option Scene");
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        add(Box.createVerticalStrut(10));
        add(gameButton);

        add(Box.createVerticalStrut(10));
        add(leaderboardButton);

        add(Box.createVerticalStrut(10));
        add(optionButton);

        add(Box.createVerticalStrut(10));
        add(closeButton);

        add(Box.createVerticalGlue());
    }

}
