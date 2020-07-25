import java.io.FileNotFoundException;
import student.TestCase;

/**
 * The testing class for the InputParser
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class InputParserTest extends TestCase {

    // Setting up vars.
    private InputParser test;

    /**
     * This method sets up the testing
     */
    public void setUp() {
        try {
            test = new InputParser("src/test/P2InputSample.txt");
        }
        catch (Exception e) {
            // This shouldn't happen
        }
    }


    /**
     * Tests that the input is read correctly from the text file.
     * 
     * @throws FileNotFoundException
     */
    public void testReadTextFile() throws FileNotFoundException {
        String[] tests = test.readTextFile();
        String[] ans = new String[] { "insert 37 80 Blacksburg",
            "insert 38 122 San_Francisco", "insert 41 96 Omaha",
            "remove 38 122", "find 38 122", "remove 38 122", "find 41 96",
            "regionsearch 30 70 20 50", "print",
            "I am the very model of a modern Major-General" };
        for (int i = 0; i < tests.length; i++) {
            assertEquals(ans[i], tests[i]);
        }
    }


    /**
     * Tests that InputParser throws the proper exceptions
     */
    public void testException() {
        try {
            test = new InputParser("notafile.txt");
        }
        catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
        try {
            test = new InputParser("src/test");
        }
        catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }

}
