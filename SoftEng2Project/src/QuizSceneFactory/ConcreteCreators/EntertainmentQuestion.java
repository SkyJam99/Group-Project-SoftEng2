package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizScene;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.EntertainmentQuiz;

public class EntertainmentQuestion extends QuizScene {
    @Override
    public QuizSceneInterface constructScene() {
        return new EntertainmentQuiz();
    }
}
