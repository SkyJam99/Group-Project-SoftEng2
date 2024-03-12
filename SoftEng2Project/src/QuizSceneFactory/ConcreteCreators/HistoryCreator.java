package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.HistoryQuiz;


/**
 * Class Name: HistoryCreator
 * Purpose: A concrete creator class that extends QuizSceneCreator to instantiate HistoryQuiz scenes.
 * Usage: Utilized within the Factory design pattern framework to generate quiz scenes focused on history topics.
 */
public class HistoryCreator extends QuizSceneCreator {
    
    /**
     * Method Name: constructScene
     * Purpose: Constructs a HistoryQuiz scene, implementing the abstract method from QuizSceneCreator.
     * Parameters: None.
     * Returns: QuizSceneInterface - An instance of HistoryQuiz
     */

    @Override
    public QuizSceneInterface constructScene() {
        return new HistoryQuiz();
    }
    
}
