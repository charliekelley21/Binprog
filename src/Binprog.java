import java.io.FileNotFoundException;

/**
 * A spatial data structure to support geographical queries. This is our class
 * that contains our main method for the Binprog program.
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class Binprog {

    /**
     * This is the entry point of the application
     * 
     * @param args
     *            Command line arguments
     * @throws FileNotFoundException
     *             Throws exception on invalid filename
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        InputParser parse = null;
        CommandManager cm = new CommandManager();
        // attempt to initialize parse and complete program
        try {
            parse = new InputParser(args[0]);
            String[] lines = parse.readTextFile();
            for (int i = 0; i < lines.length; i++) {
                String[] toPrint = cm.evaluate(lines[i]);
                for (int j = 0; j < toPrint.length; j++) {
                    if (!toPrint[j].equals("")) {
                        System.out.println(toPrint[j]);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
}
