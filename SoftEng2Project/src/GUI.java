import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class GUI {
    public GUI() {
        JFrame frame = new JFrame();

        JButton button = new JButton("CLick Me");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Software Engineering project");
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args){
        new GUI();
    }
}
