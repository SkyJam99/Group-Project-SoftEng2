package Leaderboard;

import app.Application;

import javax.swing.*;
import java.awt.*;

/**
 * Class Name: LeaderboardScene
 * Purpose: Displays the leaderboard scene for the Spooky Quiz game.
 * Usage: This class is instantiated to show the leaderboard screen, where scores are displayed and the user can return to the main menu.
 */
public class LeaderboardScene extends JPanel {
    static JTextPane leaderboardText = new JTextPane();
    /**
     * Constructor: LeaderboardScene
     * Purpose: Initializes the LeaderboardScene.
     */
    public LeaderboardScene() {
        setLayout(new GridLayout(1, 3));

        // Set the background color of the LeaderboardScene
        setBackground(new Color(119, 186, 153));

        // Initialize panels
        JPanel leftFillerPanel = new JPanel();
        JPanel contentPanel = new JPanel(new GridLayout(3, 1));
        JPanel rightFillerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel textPanel = new JPanel();

        leaderboardText.setContentType("text/html");
        leaderboardText.setEditable(false); // Make sure it's not editable
        leaderboardText.setBackground(new Color(233, 233, 233)); // Set a light background color
        leaderboardText.setBorder(BorderFactory.createCompoundBorder(
            leaderboardText.getBorder(),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Set background for all panels
        leftFillerPanel.setBackground(new Color(119, 186, 153));
        contentPanel.setBackground(new Color(119, 186, 153));
        rightFillerPanel.setBackground(new Color(119, 186, 153));
        buttonPanel.setBackground(new Color(119, 186, 153));
        labelPanel.setBackground(new Color(119, 186, 153));
        textPanel.setBackground(new Color(119, 186, 153));

        // Configure components
        JLabel title = new JLabel("Leaderboards");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        JLabel subTitle = new JLabel("SHOOT FOR HIGH SCORE!");
        subTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

        JButton menuButton = new JButton("Menu");
        menuButton.setPreferredSize(new Dimension(200, 50));
        menuButton.addActionListener(e -> Application.showScene("Main Menu"));
        menuButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        menuButton.setForeground(new Color(239, 240, 209));
        menuButton.setBackground(new Color(38, 39, 48));

        leaderboardText.setPreferredSize(new Dimension(200, 700));
        leaderboardText.setEditable(false);
        leaderboardText.setText(updateScores());

        // Add components to their respective panels
        labelPanel.add(title);
        labelPanel.add(subTitle);
        textPanel.add(leaderboardText);
        buttonPanel.add(menuButton);

        // Add panels to contentPanel
        contentPanel.add(labelPanel);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);

        // Add panels to the LeaderboardScene
        add(leftFillerPanel);
        add(contentPanel);
        add(rightFillerPanel);
    }

    /**
     * Method Name: updateScores
     * Purpose: Retrieves and formats the leaderboard scores for display in the leaderboard text area.
     * Parameters: None
     * Returns: String - The formatted scores for display.
     * Usage Example: leaderboardText.setText(updateScores()); // Updates the leaderboard text area with the latest scores.
     */
    public static String updateScores() {
        //using rileys leaderboard code
        String[][] scores = Leaderboard.getScores();
        //string builder is a tool to concatenate strings together;
        StringBuilder sb = new StringBuilder();
        sb.append("<style>table {width: 100%;} th, td {padding: 5px; text-align: left;}</style>");
        sb.append("<table>");
        sb.append("<tr><th>Player</th><th>Score</th></tr>"); // Table headers

        for (int i = 0; i < scores.length; i++) {
            String[] score = scores[i];
            sb.append("<tr><td>").append(score[0]).append("</td>")
            .append("<td>").append(score[1]).append("</td></tr>");
        }

        sb.append("</table>");
        sb.append("</html>");
        //setting leaderboard to the text area
        //leaderboardText.setText(sb.toString());
        return sb.toString();
    }

    /**
     * Method Name: updateLeaderboard
     * Purpose: Updates the text area of the leaderboard with the latest scores. 
     */
    public static void updateLeaderboard() {
        leaderboardText.setContentType("text/html");
        leaderboardText.setText(updateScores());
    }
}
