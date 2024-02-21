import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel {
    public MainMenu(JFrame frame){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Dimension buttonSize = new Dimension(200,50);

        add(Box.createVerticalBox());
        add(Box.createVerticalGlue());
        add(Box.createVerticalStrut(10));

        JLabel title = new JLabel("Spooky Quiz Game");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //increasing font
        title.setFont(new Font("Tahoma",Font.BOLD, 40));
        add(title);

        //each menuButton styles are added differently, gridlayout doesn't allow you to change the
        //size of the buttons itself, so change font size and it increases the button size
        MenuButton gameButton = new MenuButton("Play the Game", "Game Scene");
        gameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameButton.setPreferredSize(buttonSize);
        gameButton.setFont(gameButton.getFont().deriveFont(Font.PLAIN, 20));


        MenuButton leaderboardButton = new MenuButton("Leaderboards", "Leaderboard Scene");
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaderboardButton.setPreferredSize(buttonSize);
        leaderboardButton.setFont(leaderboardButton.getFont().deriveFont(Font.PLAIN, 20));



        MenuButton optionButton = new MenuButton("Options", "Option Scene");
        optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionButton.setPreferredSize(new Dimension(350,50));
        optionButton.setFont(optionButton.getFont().deriveFont(Font.PLAIN, 20));


        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setPreferredSize(buttonSize);
        closeButton.setFont(closeButton.getFont().deriveFont(Font.PLAIN, 20));
        closeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        //vertical strut is like css vertical padding (space between components)
        add(Box.createVerticalStrut(10));
        add(gameButton);

        add(Box.createVerticalStrut(10));
        add(leaderboardButton);

        add(Box.createVerticalStrut(10));
        add(optionButton);

        add(Box.createVerticalStrut(10));
        add(closeButton);

        //vertical glue centers it vertically
        add(Box.createVerticalGlue());
    }

}
