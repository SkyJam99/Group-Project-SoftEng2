package app;
public class QuestionFactory {
    public static Question createQuestion(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        return new Question(questionText, optionA, optionB, optionC, optionD, correctOption);
    }
}