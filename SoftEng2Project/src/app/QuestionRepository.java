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
        scienceQuestions.add(new Question("What is the chemical symbol for gold?", "Au", "Gd", "Ag", "Hg", "Au"));
        scienceQuestions.add(new Question("What is the powerhouse of the cell?", "Mitochondria", "Nucleus", "Membrane", "Chloroplast", "Mitochondria"));
        scienceQuestions.add(new Question("What is the chemical formula for water?", "H2O", "H2O2", "NH3", "CH4", "H2O"));
        scienceQuestions.add(new Question("What is the largest planet in our solar system?", "Jupiter", "Saturn", "The Sun", "Earth", "Jupiter"));
        scienceQuestions.add(new Question("Which element has the symbol Fe on the periodic table?", "Iron", "Sodium", "Potassium ", "Fluorine", "Iron"));
        scienceQuestions.add(new Question("In which galaxy is our solar system located?", "Milky Way", "Andromeda", "Bear Paw", "Black Eye", "Milky Way"));
        scienceQuestions.add(new Question("What is the speed of light in a vacuum?", "3x10^8 m/s", "2x10^8 m/s", "3x10^9 m/s", "2x10^9 m/s", "3x10^8 m/s"));
        scienceQuestions.add(new Question("Which of these is NOT one of the four fundamental forces in physics?", "Brute Force", "Weak Force", "Gravitational Force", "Electromagnetic Force", "Brute Force"));
        scienceQuestions.add(new Question("Who is known as the father of modern physics?", "Isaac Newton", "Albert Einstein", "Neils Bohr", "Galileo Galilei", "Isaac Newton"));
        scienceQuestions.add(new Question("How many colors are in a rainbow?", "7", "5", "6", "8", "7"));
    }

    private void addHistoryQuestions() {
        historyQuestions.add(new Question("Who was the first President of the United States?", "George Washington", "John Adams", "Thomas Jefferson", "James Madison", "George Washington"));
        historyQuestions.add(new Question("Who was the leader of the Soviet Union during World War II?", "Joseph Stalin", "Vladimir Lenin", "Georgy Malenkov", "Nikita Khrushchev", "Joseph Stalin"));
        historyQuestions.add(new Question("In what year did the Berlin Wall fall?", "1989", "1991", "1990", "1988", "1989"));
        historyQuestions.add(new Question("Which American founding father is known for flying a kite during a lightning storm?", "Benjamin Franklin", "George Washington", "Thomas Jefferson", "John Adams", "Benjamin Franklin"));
        historyQuestions.add(new Question("Which kingdom sent Christopher Columbus to explore the New World?", "Spain", "France", "England", "Portugal", "Spain"));
        historyQuestions.add(new Question("Which empire historically held the most land?", "British Empire", "Molgol Empire", "Russian Empire", "Qing Dynasty", "British Empire"));
        historyQuestions.add(new Question("In which year did the Titanic sink?", "1912", "1910", "1914", "1916", "1912"));
        historyQuestions.add(new Question("Which country was the first to send a human to space?", "Russia", "America", "China", "Britain", "Russia"));
        historyQuestions.add(new Question("Who was the first woman to win a Nobel Prize?", "Marie Curie", "Emilie du Chatelet", "Caroline Herschel", "Mary Anning", "Marie Curie"));
        historyQuestions.add(new Question("Where was the city of Babylon located with respect to modern countries?", "Iraq", "Iran", "Syria", "Saudi Arabia", "Iraq"));
    }

    private void addEntertainmentQuestions() {
        entertainmentQuestions.add(new Question("Which actor played the character of Tony Stark in the Marvel Cinematic Universe?", "Robert Downey Jr.", "Chris Hemsworth", "Chris Evans", "Mark Ruffalo", "Robert Downey Jr."));
        entertainmentQuestions.add(new Question("What is the highest-grossing animated film of all time?", "The Lion King (2019)", "Frozen", "The Super Mario Bros. Movie", "Minions", "The Lion King (2019)"));
        entertainmentQuestions.add(new Question("In which year did the first episode of \"Friends\" air?", "1994", "1990", "1997", "1996", "1994"));
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