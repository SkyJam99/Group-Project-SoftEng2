package QuizSceneFactory.ConcreteProducts;

import javax.swing.JPanel;
import java.util.List;

public interface Quiz {
    JPanel createPanel(String category, int questionNum);
    List<String> shuffleOptions(String optionA, String optionB, String optionC, String optionD);
    void createQuestionAndOptions(JPanel panel, String questionText, List<String> options);
    void createSubmitButton(JPanel panel, List<String> options, String correctOption, String category, int questionNum);
    void handleSubmitAction(List<String> options, String correctOption, String category, int questionNum, JPanel panel);
}
