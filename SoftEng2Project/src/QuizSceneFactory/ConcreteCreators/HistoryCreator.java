package QuizSceneFactory.ConcreteCreators;

import QuizSceneFactory.QuizSceneCreator;
import QuizSceneFactory.QuizSceneInterface;
import QuizSceneFactory.ConcreteProducts.HistoryQuiz;

public class HistoryCreator extends QuizSceneCreator {
    
    @Override
    public QuizSceneInterface constructScene() {
        return new HistoryQuiz();
    }
    
}
