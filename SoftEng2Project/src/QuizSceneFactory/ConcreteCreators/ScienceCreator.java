package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.ScienceQuiz;

/**
 * Class Name: ScienceCreator
 * Purpose: A concrete creator class that extends QuizSceneCreator to instantiate ScienceQuiz scenes.
 * Usage: Utilized within the Factory design pattern framework to generate quiz scenes focused on science topics.
 */
public class ScienceCreator extends QuizSceneCreator {

    /**
     * Method Name: constructScene
     * Purpose: Constructs a ScienceQuiz scene, implementing the abstract method from QuizSceneCreator.
     * Parameters: None.
     * Returns: QuizSceneInterface - An instance of ScienceQuiz
     */
    @Override
    public QuizSceneInterface constructScene() {
        return new ScienceQuiz();
    }   
}
