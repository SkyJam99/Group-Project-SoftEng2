package app;

import QuizSceneFactory.ConcreteCreators.*;
import QuizSceneFactory.*;
import javax.swing.*;

import QuestionSingleton.Question;
import QuestionSingleton.QuestionRepository;

import java.util.*;
import ScoreCommand.*;

/**
 * Class Name: QuizConstructor
 * Purpose: Responsible for constructing and sequencing the quiz scenes based on the selected category.
 * Utilizes the Factory and Command patterns to create quiz scenes and manage game scoring.
 * Usage: Called to initiate the construction of a quiz when a user starts a category.
 */
public class QuizConstructor {
    public static ScoreReceiver scoreReceiver = new ScoreReceiver();

    /**
     * Method Name: buildQuiz
     * Purpose: Constructs the quiz scenes for the selected category and initializes the game's score tracking. It sets up the quiz scenes and ensures the flow from one question to the next.
     * Parameters:
     *     - category (String): The selected category of questions.
     * Returns: None
     * Usage Example: QuizConstructor.buildQuiz("Science"); // Constructs a quiz for the Science category.
     */
    public static void buildQuiz(String category) {
        //Create the 10 scenes (one for each question) and add them to Application
        //Then show the first scene, which will have a button pointing to the next scene and so on
        //Question 10 should lead to a new scene and a button to go to the leaderboard
        //We will wait to create the final scene until we have the score

        //First we get the questions
        QuestionRepository repo = QuestionRepository.getInstance();
        List<Question> questions; // Declare the variable outside the if-else statements

        
        QuizSceneCreator tempConstructor;

        if (category.equals("Science")) {
            questions = repo.getScienceQuestions();
            tempConstructor = new ScienceCreator();
        }
        else if (category.equals("History")) {
            questions = repo.getHistoryQuestions();
            tempConstructor = new HistoryCreator();
        }
        else {
            questions = repo.getEntertainmentQuestions();
            tempConstructor = new EntertainmentCreator();
        }

        //Then we call the QuizScene factory in a for loop
        //Quiz scene factory should accept all the question parameters
        //As well as what number question each scene is
        //Each quiz scene constructed should have a button that leads to the next scene
        //Except for the last one, which should lead to the leaderboard
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
        
        //Finally we initialize the score tracker and show the first question scene
        Command initScoreCommand = new InitScoreCommand(scoreReceiver);
        initScoreCommand.execute();

        Application.showScene(category + " Q#1");
    }
    
}
