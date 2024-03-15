package QuizStrategy;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import java.awt.Container;
import java.util.List;

public interface Quiz {
    JPanel quizConstructor(String category, int questionNum, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption);
    JPanel createPanel(String category, int questionNum);
    List<String> shuffleOptions(String... options);
    void createQuestionAndOptions(JPanel panel, String questionText, List<String> options);
    void createSubmitButton(JPanel panel, List<String> options, String correctOption, String category, int questionNum);
    void handleSubmitAction(List<String> options, String correctOption, String category, int questionNum, JPanel panel);
    ButtonGroup findButtonGroup(Container container);
    int getSelectedOptionIndex(ButtonGroup group, Container container);
    void displayResultMessage(String selectedOption, String correctOption, String category, int questionNum);
    void endGame();
}
