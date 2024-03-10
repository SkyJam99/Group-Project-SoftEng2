package QuizSceneFactory;

import javax.swing.JPanel;

//Base Creator for the Quiz Scene Factory
public abstract class QuizSceneCreator extends JPanel {
    public JPanel createScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption){
        QuizSceneInterface scene = constructScene();
        return scene.initializeScene(questionNum, questionText, optionA, optionB, optionC, optionD, correctOption);
    }

    public abstract QuizSceneInterface constructScene();
}
