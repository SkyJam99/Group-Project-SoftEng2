package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionRepository {
    private static QuestionRepository instance;

    private List<Question> scienceQuestions;
    private List<Question> historyQuestions;
    private List<Question> entertainmentQuestions;

    private QuestionRepository() { initializeQuestions(); }

    public static synchronized QuestionRepository getInstance() {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }

    private void initializeQuestions() {
        scienceQuestions = new ArrayList<>();
        addScienceQuestions();

        historyQuestions = new ArrayList<>();
        addHistoryQuestions();

        entertainmentQuestions = new ArrayList<>();
        addEntertainmentQuestions();
    }

    private void addScienceQuestions() {
        scienceQuestions.add(new Question("Science Question 1", "Option A", "Option B", "Option C", "Option D", "Option A"));
        scienceQuestions.add(new Question("Science Question 2", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 3", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 4", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 5", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 6", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 7", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 8", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 9", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        scienceQuestions.add(new Question("Science Question 10", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
    }

    private void addHistoryQuestions() {
        historyQuestions.add(new Question("History Question 1", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 2", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 3", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 4", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 5", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 6", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 7", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 8", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 9", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        historyQuestions.add(new Question("History Question 10", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
    }

    private void addEntertainmentQuestions() {
        entertainmentQuestions.add(new Question("Entertainment Question 1", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 2", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 3", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 4", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 5", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 6", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 7", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 8", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 9", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
        entertainmentQuestions.add(new Question("Entertainment Question 10", "Option A", "Option B", "Option C", "Option D", "Correct Option"));
    }

    public List<Question> getScienceQuestions() { 
        List<Question> scienceQuestionsShuffled = scienceQuestions;
        Collections.shuffle(scienceQuestionsShuffled);
        return scienceQuestionsShuffled;
    }

    public List<Question> getHistoryQuestions() { 
        List<Question> historyQuestionsShuffled = historyQuestions;
        Collections.shuffle(historyQuestionsShuffled);
        return historyQuestionsShuffled;
    }

    public List<Question> getEntertainmentQuestions() { 
        List<Question> entertainmentQuestionsShuffled = entertainmentQuestions;
        Collections.shuffle(entertainmentQuestionsShuffled);
        return entertainmentQuestionsShuffled;
    }
}