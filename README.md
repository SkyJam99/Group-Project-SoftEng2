Group Project Software Engineering 2

Quiz Game

Riley's Changes 02/03/2024
1. Made a quiz scene factory - to edit the look / logic of each quiz scene change src/QuizSceneFactory/ConcreteProducts/GenericQuiz.java - this will change all the quizzes
2. Implemented the quiz scenes for each category - change src/app/QuizConstructor.java to change the logic of how these are constructed
3. Sorted java classes into packages - feel free to do more sorting

MVP TODO
1. Add logic for checking user answers and tracking score (observer pattern?)
2. Update leaderboard with new scores after game
3. Add real questions to QuestionRepository.java

Extras TODO
1. Make question scenes look better
2. Make category scenes look better
3. Add an end of quiz summary scene
4. Scene memory management pattern? Current solution will just continuously keep adding scenes
