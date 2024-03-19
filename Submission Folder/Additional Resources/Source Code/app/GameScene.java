package app;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

/**
 * Class Name: GameScene
 * Purpose: Serves as the main panel for category selection within the Spooky Quiz game. It displays
 *          the category options to the user, allowing them to choose the quiz category they want to play.
 * Usage: This class is displayed when the user navigates to the category selection 
 *        screen from the main menu.
 */
public class GameScene extends JPanel {
    
     /**
     * Constructor: GameScene
     * Purpose: Initializes the GameScene panel by setting up the category selection UI.
     * Parameters: None
     * Returns: An instance of GameScene with all UI components set up for category selection.
     */
    public GameScene(){
        setBackground(new Color(119, 186, 153));
        Dimension buttonSize = new Dimension(250,50);
        JLabel categoryText = new JLabel("Select your category!!");
        categoryText.setFont(categoryText.getFont().deriveFont(Font.PLAIN, 40));
        categoryText.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.add(Box.createHorizontalGlue());
        contentPanel.setBackground(new Color(119, 186, 153));

        add(categoryText);

        MenuButton historyButton = new MenuButton("History","History Scene");
        historyButton.setPreferredSize(buttonSize);
        historyButton.setFont(historyButton.getFont().deriveFont(Font.PLAIN, 20));


        MenuButton scienceButton = new MenuButton("Science", "Science Scene");
        scienceButton.setPreferredSize(buttonSize);
        scienceButton.setFont(scienceButton.getFont().deriveFont(Font.PLAIN, 20));


        MenuButton entertainmentButton = new MenuButton("Entertainment", "Entertainment Scene");
        entertainmentButton.setPreferredSize(buttonSize);
        entertainmentButton.setFont(entertainmentButton.getFont().deriveFont(Font.PLAIN, 20));



        MenuButton backButton = new MenuButton("Back to Main Menu", "Main Menu");
        backButton.setPreferredSize(buttonSize);
        backButton.setFont(backButton.getFont().deriveFont(Font.PLAIN, 20));

        contentPanel.add(historyButton);
        contentPanel.add(scienceButton);
        contentPanel.add(entertainmentButton);
        contentPanel.add(backButton);
        contentPanel.add(Box.createHorizontalGlue());
        add(contentPanel);
        add(Box.createVerticalGlue());


    }

}
