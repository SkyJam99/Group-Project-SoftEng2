package QuestionSingleton;

/**
 * Class Name: Question
 * Purpose: Represents a single quiz question, holding the question text, four answer options,
 *          and the correct answer. It encapsulates the data necessary for quiz questions
 *          in the Spooky Quiz game.
 * Usage: Instances of this class are used to store the details of each quiz question. 
 */
public class Question {
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    /**
     * Constructor: Question
     * Purpose: Initializes a new Question object with the provided question text, options, and the correct option.
     * Parameters:
     *     - questionText (String): The text of the quiz question.
     *     - optionA (String): Text for option A.
     *     - optionB (String): Text for option B.
     *     - optionC (String): Text for option C.
     *     - optionD (String): Text for option D.
     *     - correctOption (String): The correct answer
     */

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectOption() { return correctOption; }
}