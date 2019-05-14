/**
 * Starts the program
 *
 * @author Robin
 */
public class Run {

    public static void main(String[] args) {

        Example ex = new Example();
        String path = "files/Map.txt";
        ex.parseTextFile(path);
        Game game = new Game(ex);
    }

}