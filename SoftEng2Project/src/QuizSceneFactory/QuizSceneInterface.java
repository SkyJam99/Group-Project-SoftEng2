package QuizSceneFactory;

import javax.swing.*;
import java.awt.*;


public interface QuizSceneInterface {
    JPanel initializeScene(int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption);
}
