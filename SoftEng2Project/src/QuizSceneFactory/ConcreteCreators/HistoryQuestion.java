package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizScene;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.HistoryQuiz;

public class HistoryQuestion extends QuizScene {
    
    @Override
    public QuizSceneInterface constructScene() {
        return new HistoryQuiz();
    }
    
}
