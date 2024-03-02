package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizScene;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.ScienceQuiz;

public class ScienceQuestion extends QuizScene {
    @Override
    public QuizSceneInterface constructScene() {
        return new ScienceQuiz();
    }   
}
