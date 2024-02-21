import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuButton extends JButton {
    private String sceneName;

    public MenuButton(String text, String sceneName){
        super(text);
        this.sceneName = sceneName;
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene(sceneName);
            }
        });
    }
}
