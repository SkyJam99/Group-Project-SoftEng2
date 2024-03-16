package QuestionSingleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class Name: QuestionRepository
 * Purpose: Manages and provides access to a collection of quiz questions across various categories,
 *          ensuring there is a single shared instance of the repository.
 *          It follows the Singleton design pattern to manage question data for the Spooky Quiz game.
 * Usage: Utilized to fetch category-specific questions for the game.
 */
public class QuestionRepository {
    private static QuestionRepository instance;

    private List<Question> scienceQuestions;
    private List<Question> historyQuestions;
    private List<Question> entertainmentQuestions;

    /**
     * Constructor: QuestionRepository (private)
     * Purpose: Initializes the repository by loading question sets for each category.
     */
    private QuestionRepository() { initializeQuestions(); }


    /**
     * Method Name: getInstance
     * Purpose: Provides the singleton instance of the QuestionRepository, creating it if it does not exist.
     * Parameters: None
     * Returns: QuestionRepository - The single instance of QuestionRepository.
     * Usage Example: QuestionRepository repo = QuestionRepository.getInstance();
     */
    public static synchronized QuestionRepository getInstance() {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }

    /**
     * Method Name: initializeQuestions
     * Purpose: Initializes and populates the question lists for each quiz category.
     */
    private void initializeQuestions() {
        scienceQuestions = new ArrayList<>();
        addScienceQuestions();

        historyQuestions = new ArrayList<>();
        addHistoryQuestions();

        entertainmentQuestions = new ArrayList<>();
        addEntertainmentQuestions();
    }

    /**
     * Method Name: addScienceQuestions
     * Purpose: Initializes and populates the science question list
     */
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

    /**
     * Method Name: addHistoryQuestions
     * Purpose: Initializes and populates the history question list
     */
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

    /**
     * Method Name: addEntertainmentQuestions
     * Purpose: Initializes and populates the entertainment question list
     */
    private void addEntertainmentQuestions() {
        entertainmentQuestions.add(new Question("Which actor played the character of Tony Stark in the Marvel Cinematic Universe?", "Robert Downey Jr.", "Chris Hemsworth", "Chris Evans", "Mark Ruffalo", "Robert Downey Jr."));
        entertainmentQuestions.add(new Question("What is the highest-grossing animated film of all time?", "The Lion King (2019)", "Frozen", "The Super Mario Bros. Movie", "Minions", "The Lion King (2019)"));
        entertainmentQuestions.add(new Question("In which year did the first episode of \"Friends\" air?", "1994", "1990", "1997", "1996", "1994"));
        entertainmentQuestions.add(new Question("Which of these William Shakespeare plays were written first?", "Romeo and Juliet", "Macbeth", "Twelfth Night", "Hamlet", "Romeo and Juliet"));
        entertainmentQuestions.add(new Question("Which of these is not a Beatles album?", "Hey Jude", "Abbey Road", "Yellow Submarine", "Let It Be", "Hey Jude"));
        entertainmentQuestions.add(new Question("Which Hogwarts House from Harry Potter is represented by a Lion?", "Gryffindor", "Ravenclaw", "Hufflepuff", "Slytherin", "Gryffindor"));
        entertainmentQuestions.add(new Question("Which of the races from the Lord of the Rings were not gifted one of the original rings of power?", "Hobbits", "Dwarves", "Elves", "Men", "Hobbits"));
        entertainmentQuestions.add(new Question("What is the greatest selling album of all time?", "Thriller", "The Dark Side of the Moon", "Back in Black", "The Bodyguard", "Thriller"));
        entertainmentQuestions.add(new Question("Which of these films did Christopher Nolan NOT direct?", "Man of Steel", "Interstellar", "Oppenheimer", "The Dark Knight", "Man of Steel"));
        entertainmentQuestions.add(new Question("When did the first episode of Saturday Night Live air?", "1975", "1970", "1973", "1978", "1975"));
    }

    /**
     * Method Name: getScienceQuestions
     * Purpose: Retrieves a shuffled list of science questions.
     * Parameters: None
     * Returns: List<Question> - A shuffled list of science questions.
     */
    public List<Question> getScienceQuestions() { 
        List<Question> scienceQuestionsShuffled = scienceQuestions;
        Collections.shuffle(scienceQuestionsShuffled);
        return scienceQuestionsShuffled;
    }

    /**
     * Method Name: getHistoryQuestions
     * Purpose: Retrieves a shuffled list of history questions.
     * Parameters: None
     * Returns: List<Question> - A shuffled list of history questions.
     */
    public List<Question> getHistoryQuestions() { 
        List<Question> historyQuestionsShuffled = historyQuestions;
        Collections.shuffle(historyQuestionsShuffled);
        return historyQuestionsShuffled;
    }

    /**
     * Method Name: getEntertainmentQuestions
     * Purpose: Retrieves a shuffled list of entertainment questions.
     * Parameters: None
     * Returns: List<Question> - A shuffled list of entertainment questions.
     */
    public List<Question> getEntertainmentQuestions() { 
        List<Question> entertainmentQuestionsShuffled = entertainmentQuestions;
        Collections.shuffle(entertainmentQuestionsShuffled);
        return entertainmentQuestionsShuffled;
    }
}