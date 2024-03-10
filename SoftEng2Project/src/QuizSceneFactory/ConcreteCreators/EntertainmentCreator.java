package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.EntertainmentQuiz;

public class EntertainmentCreator extends QuizSceneCreator {
    @Override
    public QuizSceneInterface constructScene() {
        return new EntertainmentQuiz();
    }
}
