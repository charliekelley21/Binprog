import java.io.FileNotFoundException;
import student.TestCase;

/**
 * The testing class for Binprog
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class BinprogTest extends TestCase {

    /**
     * Test the main method
     */
    public void testMain() {
        try {
            Binprog.main(new String[] { "src/test/P2InputSample.txt" });
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(multiline(">insert 37 80 Blacksburg",
            ">insert 38 122 San_Francisco", ">insert 41 96 Omaha",
            ">remove 38 122", ">find 38 122",
            "Record could not be printed.  It does not exist.",
            ">remove 38 122", "Record could not be removed. It does not exist.",
            ">find 41 96", "Omaha 41 96", ">regionsearch 30 70 20 50",
            "37 80 Blacksburg", "41 96 Omaha", "13 Nodes visited.", ">print",
            "I, 0, 0, 1024, 1024", "  I, 0, 0, 512, 1024",
            "    I, 0, 0, 512, 512", "      I, 0, 0, 256, 512",
            "        I, 0, 0, 256, 256", "          I, 0, 0, 128, 256",
            "            I, 0, 0, 128, 128", "              I, 0, 0, 64, 128",
            "                E, 0, 0, 64, 64",
            "                I, 0, 64, 64, 64",
            "                  E, 0, 64, 32, 64",
            "                  I, 32, 64, 32, 64",
            "                    Blacksburg, 37, 80",
            "                    Omaha, 41, 96",
            "              E, 64, 0, 64, 128",
            "            E, 0, 128, 128, 128", "          E, 128, 0, 128, 256",
            "        E, 0, 256, 256, 256", "      E, 256, 0, 256, 512",
            "    E, 0, 512, 512, 512", "  E, 512, 0, 512, 1024",
            ">I am the very model of a modern Major-General",
            "ERROR! Unrecognized command: I am the very model of"
                + " a modern Major-General"), systemOut().getHistory());
    }


    /**
     * Test the illegal argument exception
     */
    public void testIllegalArg() {
        try {
            Binprog.main(new String[] {});
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    /**
     * Test the file not found exception
     */
    public void testFileNotFound() {
        try {
            Binprog.main(new String[] { "yarg" });
        }
        catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }

}
