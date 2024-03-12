package app;
import java.io.*;

public class Leaderboard {

    private static String FILE_PATH;

    //Assuming that only 10 scores will be tracked total
    public static String[][] getScores() {
        String[][] scores = new String[10][2];
        String[] tempScore;
        //Use BufferedReader to read each line from the leaderboard file
        //Each line is a seperate score, and the name and score is added to the array
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            for(int i = 0; i < 10; i++){
                line = reader.readLine();
                System.out.println(line);
                tempScore = line.split(" ");
                scores[i][0] = tempScore[0];
                scores[i][1] = tempScore[1];
                /*System.out.println(line); //Testing code
                System.out.println(scores[i][0]);
                System.out.println(scores[i][1]);*/
            }
        } catch (IOException e) {
            System.out.println("Error retrieving scores");
        }

        return scores;
    }


    //This function will need to get all the existing scores 
    //and place the new score in the correct placement
    //while removing score #11. Ties will result in the older score being ranked higher
    public static void addNewScore(String name, int score) {
        String[][] oldScores = new String[10][2];
        String[][] newScores = new String[10][2];
        String finalScores = "";
        boolean placedNewScore = false;
        int tempScore;

        //Get existing scores
        oldScores = getScores();

        //Use insertion to place the new score in a sorted array
        for(int i = 0; i < 10; i++) {
            try{ //Store integer value of score
                tempScore = Integer.parseInt(oldScores[i][1]);
            } catch (NumberFormatException ex) {
                System.out.println("Error converting score to integer for sorting");
                break;
            }

            if(placedNewScore) { //If we've placed the new score we can just go through the rest of the old scores
                newScores[i][0] = oldScores[i-1][0];
                newScores[i][1] = oldScores[i-1][1];
            } else if(score > tempScore) { //This is what places the new score
                placedNewScore = true;
                newScores[i][0] = name;
                newScores[i][1] = String.valueOf(score);
            } else { //If the current oldScore is greater than the new score
                newScores[i][0] = oldScores[i][0];
                newScores[i][1] = oldScores[i][1];
            }
            System.out.println(newScores[i][0]);
            System.out.println(newScores[i][1]);
            //Create string containing all the new scores
            finalScores = finalScores + newScores[i][0] + " " + newScores[i][1] + "\n";
        }

        //Overwrite the top 10 scores in the scores.txt file
        try(FileWriter writer = new FileWriter(FILE_PATH, false)){
            writer.write(finalScores);
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        }
    }

    public static void initalizeLeaderboard(){
        //Set file path based on OS
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("win")){
            FILE_PATH = System.getProperty("user.dir") + "\\SoftEng2Project\\scores.txt";
        } else {
            FILE_PATH = System.getProperty("user.dir") + "/SoftEng2Project/scores.txt";
        }

        System.out.println(FILE_PATH);
        //Check if the scoresFile exists, if not create it
        File scoresFile = new File(FILE_PATH);
        if (!scoresFile.exists()) {
            try {
                scoresFile.createNewFile();
                FileWriter writer = new FileWriter(scoresFile);
                for (int i = 0; i < 10; i++) {
                    writer.write("Empty 0\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while creating file");
            }
        }

    }


    /* Testing code
    public static void main(String[] args) {
        //Leaderboard test = new Leaderboard();
        //Leaderboard.addNewScore("Riley", 1);
        //Leaderboard.getScores();
        //Leaderboard.testScores();
    }

    public static void testScores() {
        File f = new File(FILE_PATH);
        System.out.println("Attempting to write to: " + f.getAbsolutePath());
        try(FileWriter writer = new FileWriter(FILE_PATH, false)){
            writer.write("Empty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\nEmpty 0\n");
        } catch (IOException e) {
            System.out.println("Error while writing to file");
        }
    }
    */



}

