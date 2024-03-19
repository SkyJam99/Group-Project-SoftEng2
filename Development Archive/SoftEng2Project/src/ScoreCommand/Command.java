package ScoreCommand;

/**
 * Interface Name: Command
 * Purpose: Defines a contract for implementing commands in the quiz game, specifically related to game scoring.
 * Usage: Implemented by concrete command classes that execute specific actions such as updating scores based on player responses.
 */
public interface Command {
    /**
     * Method Name: execute
     * Purpose: Executes the specific action encapsulated by the command, such as modifying the game's score.
     */
    void execute();
}
