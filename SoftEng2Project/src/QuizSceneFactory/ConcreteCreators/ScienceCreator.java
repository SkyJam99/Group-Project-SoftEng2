package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.ScienceQuiz;

public class ScienceCreator extends QuizSceneCreator {
    @Override
    public QuizSceneInterface constructScene() {
        return new ScienceQuiz();
    }   
}
