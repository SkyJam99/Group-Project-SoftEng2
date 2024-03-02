package app;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizButton extends JButton {
    boolean answer;
    public QuizButton(String text, Boolean answer){
        super(text);
        addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if(answer){
                //increase score // new question
                //take to next question
            } else {
                //do nothing to score, create new question
            }
          }
        });
    }

}
