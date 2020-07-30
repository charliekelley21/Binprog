import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The underlying data structure that parse our input file
 * This will be more generic to handle out I/O for Project 3 too
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class InputParser {

    // Initialize private vars
    private File file;
    private String[] ans;
    private int numProblems;

    /**
     * This constructor creates a new InputParser object. It requires a String
     * of the text file's name or the path, and will throw a
     * FileNotFoundException
     * if it is not found.
     * 
     * @param textfile
     *            file's name
     * @throws FileNotFoundException
     *             The inputed file name is incorrect.
     */
    public InputParser(String textfile) throws FileNotFoundException {
        file = new File(textfile);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException();
        }
        assignFileLength();
        ans = new String[numProblems];
    }


    /**
     * This method will count how many valid problems so that ans knows how big
     * of a String array it needs to be
     * 
     * @throws FileNotFoundException
     *             should be impossible
     * 
     */
    private void assignFileLength() throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNextLine()) {
            // counting valid file lines
            String line = sc.nextLine();
            line = properSpacing(line);
            if (line.length() != 0) {
                count++;
            }
        }
        numProblems = count;
    }


    /**
     * This will use the internal solver to get all the answers in the input
     * text file
     * 
     * @throws FileNotFoundException
     *             whether the file was found
     * @return String[] the items in the TextFile
     */
    public String[] readTextFile() throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(file);
        int problemNumber = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = properSpacing(line);

            // store in the ans array
            if (line.length() != 0) {
                ans[problemNumber] = line;
                problemNumber++;
            }
        }
        return ans;
    }


    /**
     * This will get rid of the weird spacing in the input file.
     * 
     * @param unformatted
     *            The preprocessed String
     * @return The processed String
     */
    private String properSpacing(String unformatted) {
        char[] tocopy = unformatted.toCharArray();
        char[] answer = new char[tocopy.length];
        int location = 0;
        for (int i = 0; i < tocopy.length; i++) {
            // copies chars to new array
            if (tocopy[i] != ' ') {
                answer[location] = tocopy[i];
                location++;
            }
            else {
                // adds one space after a segment of chars
                answer[location] = ' ';
                location++;
            }
        }
        // converts to string and gets rid of leading and following spaces
        return new String(answer).trim();
    }
}
