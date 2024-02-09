import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
public class MainMenu {

    public MainMenu() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JLabel title = new JLabel("Spooky Quiz Game");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Adding vertical glue to center the title label
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        Font titleFont = title.getFont().deriveFont(Font.BOLD, 24); //setting font size bigger
        title.setFont(titleFont);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1)); // 4 columns
        buttonPanel.add(title, new GridBagConstraints()); // gridbag constraints make it centered
        JButton playButton = new JButton("Play now!");
        JButton optionsButton = new JButton("Options");
        JButton leaderboardButton = new JButton("Leaderboards");



        //GAME SCENE
        JPanel gameScene = new JPanel();
        gameScene.setLayout(new GridLayout(6,1));

        JLabel question = new JLabel("Question Logic goes here");
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setVerticalAlignment(SwingConstants.CENTER);
        question.setFont(titleFont);

        JButton answer1 = new JButton("Answer1");
        JButton answer2 = new JButton("answer1");
        JButton answer3 = new JButton("answer3");
        JButton answer4 = new JButton("answer4");
        JButton exitButton = new JButton("Exit the game");

        gameScene.add(question);
        gameScene.add(answer1);
        gameScene.add(answer2);
        gameScene.add(answer3);
        gameScene.add(answer4);
        gameScene.add(exitButton);


        //We can do this which removes all components then repaints the scene, but doesnt work seem good
        // need to split it up and actually use java classes
        playButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(gameScene);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });


        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(buttonPanel);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });




        buttonPanel.add(playButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(leaderboardButton);

        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.setSize(new Dimension(600,600));
        frame.setVisible(true);

    }
    public static void main(String[] args){
        new MainMenu();
    }






}
