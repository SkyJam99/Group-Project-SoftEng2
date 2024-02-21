import java.io.*;

public class Leaderboard {
    private static final String FILE_PATH = "scores.txt";

    //Assuming that only 10 scores will be tracked total
    public String[][] getScores() {
        

        String[][] scores = new String[10][2];
        String[] tempScore;
        //Use BufferedReader to read each line from the leaderboard file
        //Each line is a seperate score, and the name and score is added to the array
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            for(int i = 0; i < 10; i++){
                line = reader.readLine();
                tempScore = line.split(" ");
                scores[i][0] = tempScore[0];
                scores[i][1] = tempScore[1];
                System.out.println(line);
                System.out.println(scores[i][0]);
                System.out.println(scores[i][1]);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving scores");
        }

        return scores;
    }


    //This function will need to get all the existing scores 
    //and place the new score in the correct placement
    //while removing score #11. Ties will result in the older score being ranked higher
    public void addNewScore(String name, int score) {
        //Get existing scores

        //Use insertion sort to place the new score in a sorted array

        //Erase the information in the old scores.txt file

        //Write the top 10 scores to the scores.txt file

        //Return true / false 
        try(FileWriter writer = new FileWriter(FILE_PATH, true)){
            writer.write("test\n");
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        }
    }

    public static void main(String[] args) {
        Leaderboard test = new Leaderboard();
        //test.addNewScore("Jam", 1);
        test.getScores();
    }
}

