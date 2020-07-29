import student.TestCase;

/**
 * The testing class for the CommandManager
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class CommandManagerTest extends TestCase {

    // Setting up vars
    private CommandManager test;

    /**
     * This is the set up method for the testing.
     */
    public void setUp() {
        test = new CommandManager();
    }


    /**
     * Tests the Command manager's ability to evaluate valid
     * commands for the internal CItyTree
     */
    public void testEvaluateInsertRemove() {
        //test insert
        String[] eval = test.evaluate("insert 45 60 Blacksburg");
        assertEquals(eval[0], ">insert 45 60 Blacksburg");

        eval = test.evaluate("insert 20 200 Roanoke");
        assertEquals(eval[0], ">insert 20 200 Roanoke");

        eval = test.evaluate("insert 1001 451 Hillsville");
        assertEquals(eval[0], ">insert 1001 451 Hillsville");

        CityTree testTree = test.getTree();
        assertEquals(3, testTree.length());
        assertEquals("Hillsville", testTree.find(1001, 451).getName());
        assertEquals("Roanoke", testTree.find(20, 200).getName());
        assertEquals("Blacksburg", testTree.find(45, 60).getName());
        
        eval = test.evaluate("print");
        assertEquals(eval[0], ">print");
        assertEquals("I, 0, 0, 1024, 1024\r\n" + 
            "  I, 0, 0, 512, 1024\r\n" + 
            "    I, 0, 0, 512, 512\r\n" + 
            "      I, 0, 0, 256, 512\r\n" + 
            "        I, 0, 0, 256, 256\r\n" + 
            "          I, 0, 0, 128, 256\r\n" + 
            "            Blacksburg 45 60\r\n" + 
            "            Roanoke 20 200\r\n" + 
            "          E, 128, 0, 128, 256\r\n" + 
            "        E, 0, 256, 256, 256\r\n" + 
            "      E, 256, 0, 256, 512\r\n" + 
            "    E, 0, 512, 512, 512\r\n" + 
            "  Hillsville 1001 451", eval[1]);
        
        // test region search and find
        eval = test.evaluate("find 45 60");
        assertEquals(eval[0], ">find 45 60");
        assertEquals(eval[1], "Blacksburg 45 60");
        
        eval = test.evaluate("regionsearch 0 0 500 500");
        assertEquals(eval[0], ">regionsearch 0 0 500 500");
        assertEquals(eval[1], "Blacksburg 45 60");
        assertEquals(eval[2], "Roanoke 20 200");
        assertEquals(eval[3], "11 Nodes visited.");

        // test remove
        eval = test.evaluate("remove 1001 451");
        assertEquals(eval[0], ">remove 1001 451");

        eval = test.evaluate("remove 20 200");
        assertEquals(eval[0], ">remove 20 200");

        testTree = test.getTree();
        assertNull(testTree.find(1001, 451));
        assertNull(testTree.find(20, 200));
        assertEquals(1, testTree.length());
    }
    
    /**
     * Test CommandManager's evaluate function with bad commands
     */
    public void testBadInput() {
        String[] eval = test.evaluate("insert -2 4 Blacksburg");
        assertEquals(eval[0], ">insert -2 4 Blacksburg");
        assertEquals(eval[1], "Record could not be inserted. Invalid location.");
        
        eval = test.evaluate("remove 101 451");
        assertEquals(eval[0], ">remove 101 451");
        assertEquals(eval[1], "Record could not be removed. It does not exist.");
        
        eval = test.evaluate("find 101 451");
        assertEquals(eval[0], ">find 101 451");
        assertEquals(eval[1], "Record could not be printed.  It does not exist.");
        
        eval = test.evaluate("regionsearch -300 200 50 50");
        assertEquals(eval[0], ">regionsearch -300 200 50 50");
        assertEquals(eval[1], "The specified region is outside the known world.");
        
        eval = test.evaluate("invalid command");
        assertEquals(eval[0], ">invalid command");
        assertEquals(eval[1], "ERROR! Unrecognized command: invalid command");
        
        // test print on empty internal tree
        eval = test.evaluate("print");
        assertEquals(eval[0], ">print");
        assertEquals("E, 0, 0, 1024, 1024", eval[1]);
    }
}
