package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.EntertainmentQuiz;


/**
 * Class Name: EntertainmentCreator
 * Purpose: A concrete creator that extends the QuizSceneCreator to instantiate EntertainmentQuiz scenes.
 * Usage: Used within the Factory design pattern to create specific quiz scenes related to entertainment topics.
 */
public class EntertainmentCreator extends QuizSceneCreator {
    /**
     * Method Name: constructScene
     * Purpose: Constructs an EntertainmentQuiz scene, overriding the abstract method in QuizSceneCreator.
     * Parameters: None.
     * Returns: QuizSceneInterface - An instance of EntertainmentQuiz which implements QuizSceneInterface.
     */
    @Override
    public QuizSceneInterface constructScene() {
        return new EntertainmentQuiz();
    }
}
