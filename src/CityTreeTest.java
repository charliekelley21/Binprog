import student.TestCase;

/**
 * The testing class for the CityTree object
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.26
 */
public class CityTreeTest extends TestCase {

    // Setting up vars
    private CityTree test;

    /**
     * This is the set up method for the testing.
     */
    public void setUp() {
        test = new CityTree(new City("testcity", 45, 3));
        test = new CityTree();
    }


    /**
     * This will test the insert method of CityTree
     */
    public void testInsert() {
        assertTrue(test.insert(new City("Detriot", 20, 20)));
        assertTrue(test.insert(new City("New York", 700, 700)));
        assertTrue(test.insert(new City("Boston", 1000, 20)));
        assertTrue(test.insert(new City("New York", 710, 700)));
        assertTrue(test.insert(new City("Ba Sing Se", 700, 710)));
        assertFalse(test.insert(new City("King's Landing", 1000, 20)));
        assertFalse(test.insert(new City("Atlantis", 100000, -1)));
        assertFalse(test.insert(new City("Olympus", -1, 1000000)));
        assertFalse(test.insert(new City("Winterfell", 300, -1)));
        assertFalse(test.insert(new City("Hogarts", 20, 1000000)));
        assertEquals(5, test.length());
        assertTrue(test.insert(new City("The Shire", 999, 45)));
        assertTrue(test.insert(new City("Cairo", 60, 16)));
        assertTrue(test.insert(new City("Vienna", 69, 420)));
        assertTrue(test.insert(new City("Amsterdam", 420, 69)));
        assertTrue(test.insert(new City("Frankfurt", 20, 111)));
        assertEquals(10, test.length());
        assertFalse(test.insert(new City("Hyrule", 69, 420)));
        assertFalse(test.insert(new City("Mushroom Kingdom", 1000, 20)));
        assertFalse(test.insert(new City("Kaer Morhen", 20, 20)));
        assertTrue(test.insert(new City("White Orchard", 21, 20)));
        test.printTree();
    }


    /**
     * Tests two cities inserted right on cut border.
     */
    public void testMiddleEdge() {
        assertTrue(test.insert(new City("Atlantis", 511, 512)));
        assertTrue(test.insert(new City("Olympus", 512, 512)));
        assertTrue(test.insert(new City("Venice", 510, 512)));
        assertEquals(3, test.length());
    }


    /**
     * This will test the find method of CityTree
     */
    public void testFind() {
        test.insert(new City("Detriot", 20, 20));
        test.insert(new City("New York", 700, 700));
        test.insert(new City("Boston", 1000, 20));
        test.insert(new City("New York", 710, 700));
        test.insert(new City("Ba Sing Se", 700, 710));
        test.insert(new City("The Shire", 999, 45));
        test.insert(new City("Cairo", 60, 16));
        test.insert(new City("Vienna", 69, 420));
        test.insert(new City("Amsterdam", 420, 69));
        test.insert(new City("Frankfurt", 20, 111));
        test.insert(new City("White Orchard", 21, 20));

        assertEquals("Ba Sing Se", test.find(700, 710).getName());
        assertEquals("Vienna", test.find(69, 420).getName());
        assertEquals("Frankfurt", test.find(20, 111).getName());
        assertNull(test.find(34, 896));
        assertNull(test.find(20, 112));
        assertNull(test.find(21, 111));
    }


    /**
     * This method tests CityTree's print function
     */
    public void testPrint() {
        test.insert(new City("Detriot", 20, 20));
        test.insert(new City("New York", 700, 700));
        test.insert(new City("Boston", 1000, 20));
        test.insert(new City("New York", 710, 700));
        test.insert(new City("Ba Sing Se", 700, 710));

        System.out.println(test.printTree());
        assertEquals(multiline("I, 0, 0, 1024, 1024", "  Detriot 20 20",
            "  I, 512, 0, 512, 1024", "    Boston 1000 20",
            "    I, 512, 512, 512, 512", "      I, 512, 512, 256, 512",
            "        I, 512, 512, 256, 256", "          E, 512, 512, 128, 256",
            "          I, 640, 512, 128, 256",
            "            E, 640, 512, 128, 128",
            "            I, 640, 640, 128, 128",
            "              I, 640, 640, 64, 128",
            "                New York 700 700",
            "                Ba Sing Se 700 710",
            "              New York 710 700", "        E, 512, 768, 256, 256",
            "      E, 768, 512, 256, 512"), systemOut().getHistory());
    }


    /**
     * This method tests CityTree's clear function
     */
    public void testClear() {
        test.insert(new City("Detriot", 20, 20));
        test.insert(new City("New York", 700, 700));
        test.insert(new City("Boston", 1000, 20));
        test.insert(new City("New York", 710, 700));
        test.insert(new City("Ba Sing Se", 700, 710));
        test.clear();
        assertEquals(0, test.length());
        assertNull(test.find(700, 700));
    }
}
