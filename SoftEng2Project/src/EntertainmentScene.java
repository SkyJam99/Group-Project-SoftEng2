import javax.swing.JFrame;

import QuizSceneFactory.ConcreteCreators.EntertainmentQuestion;
import QuizSceneFactory.*;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EntertainmentScene extends JPanel {
    public EntertainmentScene(){

        add(new JLabel("Entertainment"));
        JButton menuButton = new JButton("Back to Game Scene");
        menuButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Application.showScene("Game Scene");

            }
        });

        add(menuButton);

        JButton startButton = new JButton("Start Entertainment Category");
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Create the 10 scenes (one for each question) and add them to Application
                //Then show the first scene, which will have a button pointing to the next scene and so on
                //Question 10 should lead to a new scene and a button to go to the leaderboard
                //We will wait to create the final scene until we have the score

                //First we get the questions from Jakobs code
                QuestionRepository entertainmentRepository = QuestionRepository.getInstance();
                List<Question> entertainmentQuestions = entertainmentRepository.getEntertainmentQuestions();

                //Then we call the QuizScene factory in a for loop
                //Quiz scene factory should accept all the question parameters
                //As well as what number question each scene is
                //Each quiz scene constructed should have a button that leads to the next scene
                //Except for the last one, which should lead to the score reveal scene
                //We need some way to track the users score globally as they play the game
                //Maybe we can use the observer pattern to update the score in the Application class
                for (int i = 0; i < entertainmentQuestions.size(); i++) {
                    Question tempQuestion = entertainmentQuestions.get(i);
                    System.out.println(tempQuestion.getQuestionText());
                    QuizScene tempConstructor = new EntertainmentQuestion();
                    JPanel tempScene = tempConstructor.createScene(i + 1, 
                        tempQuestion.getQuestionText(),
                        tempQuestion.getOptionA(),
                        tempQuestion.getOptionB(),
                        tempQuestion.getOptionC(),
                        tempQuestion.getOptionD(),
                        tempQuestion.getCorrectOption());

                    Application.addScene(tempScene, "Entertainment Q#" + Integer.toString(i + 1));
                }
                
                //Finally we show the first question scene
                Application.showScene("Entertainment Q#1");

            }
        });

        add(startButton);
    }
}
