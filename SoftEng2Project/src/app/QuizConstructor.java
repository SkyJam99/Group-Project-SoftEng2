package app;

import QuizSceneFactory.ConcreteCreators.*;
import QuizSceneFactory.*;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class QuizConstructor {
    public static void buildQuiz(String category) {
        //Create the 10 scenes (one for each question) and add them to Application
        //Then show the first scene, which will have a button pointing to the next scene and so on
        //Question 10 should lead to a new scene and a button to go to the leaderboard
        //We will wait to create the final scene until we have the score

        //First we get the questions from Jakobs code
        QuestionRepository repo = QuestionRepository.getInstance();
        List<Question> questions; // Declare the variable outside the if-else statements
        QuizScene tempConstructor;

        if (category.equals("Science")) {
            questions = repo.getScienceQuestions();
            tempConstructor = new ScienceQuestion();
        }
        else if (category.equals("History")) {
            questions = repo.getHistoryQuestions();
            tempConstructor = new HistoryQuestion();
        }
        else {
            questions = repo.getEntertainmentQuestions();
            tempConstructor = new EntertainmentQuestion();
        }

        //Then we call the QuizScene factory in a for loop
        //Quiz scene factory should accept all the question parameters
        //As well as what number question each scene is
        //Each quiz scene constructed should have a button that leads to the next scene
        //Except for the last one, which should lead to the score reveal scene
        //We need some way to track the users score globally as they play the game
        //Maybe we can use the observer pattern to update the score in the Application class
        for (int i = 0; i < questions.size(); i++) {
            Question tempQuestion = questions.get(i);
            //System.out.println(tempQuestion.getQuestionText());
            JPanel tempScene = tempConstructor.createScene(i + 1, 
                tempQuestion.getQuestionText(),
                tempQuestion.getOptionA(),
                tempQuestion.getOptionB(),
                tempQuestion.getOptionC(),
                tempQuestion.getOptionD(),
                tempQuestion.getCorrectOption());

            Application.addScene(tempScene, category + " Q#" + Integer.toString(i + 1));
        }
        
        //Finally we show the first question scene
        Application.showScene(category + " Q#1");
    }
    
}
