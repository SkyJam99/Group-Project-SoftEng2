package app;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LeaderboardScene extends JPanel {
    static JTextArea leaderboardText = new JTextArea();
    public LeaderboardScene(){

        setLayout(new GridLayout(1,3));

        JPanel contentPanel = new JPanel();

        //create panels for each part of the grid layout in order to edit the indiviudal components while maintaining the grid
        contentPanel.setLayout(new GridLayout(3,1));
        JPanel buttonPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel textPanel = new JPanel();


        JLabel title = new JLabel("Leaderboards");
        title.setFont(new Font("Tahoma",Font.BOLD, 20));

        JLabel subTitle = new JLabel("SHOOT FOR HIGH SCORE!");
        subTitle.setFont(new Font("Tahoma",Font.BOLD, 16));

        subTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        JButton menuButton = new JButton("Menu");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setPreferredSize(new Dimension(200,50));

        leaderboardText.setPreferredSize(new Dimension(100,700));
        leaderboardText.setEditable(false);

        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Main Menu");

            }
        });


        leaderboardText.setText(updateScores());
        add(new JPanel());

        labelPanel.add(title);
        labelPanel.add(subTitle);

        //adding components to each panel, then adding all panels in order for the grid panel.
        textPanel.add(leaderboardText);
        buttonPanel.add(menuButton);

        contentPanel.add(labelPanel);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);


        //adding content panel to the LeaderboardScene (the extra panel is to center it in the middle of the window)
        add(contentPanel);
        add(new JPanel());

    }
    //method for displaying the scores from the text file
    public static String updateScores() {
        //using rileys leaderboard code
        String[][] scores = Leaderboard.getScores();
        //string builder is a tool to concatenate strings together;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<scores.length; i++) {
            String[] score = scores[i];
            sb.append(score[0]).append(" ").append(score[1]).append("\n");
        }
        //setting leaderboard to the text area
        //leaderboardText.setText(sb.toString());
        return sb.toString();
    }

    public static void updateLeaderboard() {
        leaderboardText.setText(updateScores());
    }
}
