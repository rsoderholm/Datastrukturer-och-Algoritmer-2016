import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by robin on 2016-11-12.
 * <p>
 * This class parses the textfile and adds its contents to the array.
 * It also initializes the variables and creates a board.
 */
public class Example {
    private Squares[][] squaresArray;

    /**
     * Parses the textfile and splits by "," then adds the
     * parts to array. This array is used as a parameter for the
     * initializeVariables method.
     *
     * @param filepath filepath
     */
    public void parseTextFile(String filepath) {
        ArrayList<String> splitted = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            String[] splitLine;
            while ((line = br.readLine()) != null) {
                splitLine = line.split(",");
                if (splitLine.length > 2) {
                    for (int i = 0; i < 3; i++)
                        splitted.add(splitLine[i]);

                } else {
                    splitted.add(splitLine[0]);
                    splitted.add(splitLine[1]);
                }
            }
            initializeVariables(splitted);
        } catch (IOException e) {
            e.printStackTrace();

        }
        getSquaresArray();
    }


    /**
     * Initializes all variables
     *
     * @param parsedText
     */

    private void initializeVariables(ArrayList<String> parsedText) {
        int nbrOfColumns = Integer.parseInt(parsedText.get(0));
        int nbrOfRows = Integer.parseInt(parsedText.get(1));
        int nbrOfObstacles = Integer.parseInt(parsedText.get(2));
        int obstacle_X;
        int obstacle_Y;

        //Array with the size of columns and rows
        squaresArray = new Squares[nbrOfColumns][nbrOfRows];

        // Initiates bricks
        initializeBricks();


        int indexCounter = 3;

        //This loop runs as many times as there are obstacles.
        for (int i = 0; i < nbrOfObstacles; i++) {
            obstacle_X = Integer.parseInt(parsedText.get(indexCounter));
            obstacle_Y = Integer.parseInt(parsedText.get(indexCounter + 1));
            squaresArray[obstacle_X][obstacle_Y].setIsObstacle(true);

            //increment by two as every obstacle is represented by [x][y]
            indexCounter += 2;
        }
    }

    /**
     * Creates brick object and puts in brick array.
     */
    private void initializeBricks() {
        for (int x = 0; x < squaresArray[0].length; x += 1) {
            for (int y = 0; y < squaresArray[1].length; y += 1) {
                squaresArray[x][y] = new Squares();
            }
        }

    }

    public Squares[][] getSquaresArray() {
        return squaresArray;
    }

    public void setSquaresArray(Squares[][] squaresArray) {

        this.squaresArray = squaresArray;
    }
}