import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles how the snake moves throughout the map.
 * It contains the actual logic of the game.
 *
 * @author Robin
 */
public class Game {

    private Example ex;
    private Squares[][] squaresArray;
    private List<Point> points = new ArrayList<Point>();
    private int end = 0;

    public Game(Example ex) {
        squaresArray = ex.getSquaresArray();

        squaresArray[0][0].setVisited(true);
        points.add(new Point(0, 0));
        end++;
        move(0, 0);
        print();

    }

    /**
     * Recursive method that moves the snake around the map
     * and sets bricks as visited.
     *
     * @param x1
     * @param y1
     */
    public void move(int x1, int y1) {

        try {
            if (((x1 + 1) < squaresArray[1].length) && !squaresArray[x1 + 1][y1].getIsObstacle()
                    && !squaresArray[x1 + 1][y1].getVisited()) {
                squaresArray[x1 + 1][y1].setVisited(true);
                points.add(new Point(x1 + 1, y1));
                end++;
                move(x1 + 1, y1);
            } else if (((y1 + 1) < squaresArray.length) && !squaresArray[x1][y1 + 1].getIsObstacle()
                    && !squaresArray[x1][y1 + 1].getVisited()) {

                squaresArray[x1][y1 + 1].setVisited(true);
                points.add(new Point(x1, y1 + 1));
                end++;

                move(x1, y1 + 1);


            } else if (x1 > 0 && !squaresArray[x1 - 1][y1].getIsObstacle()
                    && !squaresArray[x1 - 1][y1].getVisited()) {

                squaresArray[x1 - 1][y1].setVisited(true);
                points.add(new Point(x1 - 1, y1));

                end++;

                move(x1 - 1, y1);
            } else if (y1 > 0 && !squaresArray[x1][y1 - 1].getIsObstacle()
                    && !squaresArray[x1][y1 - 1].getVisited()) {

                squaresArray[x1][y1 - 1].setVisited(true);
                points.add(new Point(x1, y1 - 1));
                end++;

                move(x1, y1 - 1);


            }
        } catch (ArrayIndexOutOfBoundsException exception) {

        }
    }

    /**
     * Prints result of the round
     */
    public void print() {
        System.out.println("The snake visited " + points.size() + "  squares this round." + "\n");
        System.out.println("-----------------------");

        for (Point point : points) {
            System.out.println("#" + point + "#");
        }
        if (end == points.size()) {
            System.out.println("-----------------------");
            System.out.println("\n" + "The game is over!");
        }

    }

}