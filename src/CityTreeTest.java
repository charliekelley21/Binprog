import student.TestCase;

/**
 * The testing class for the CityTree object
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class CityTreeTest extends TestCase {

    // Setting up vars
    private CityTree test;

    /**
     * This is the set up method for the testing.
     */
    public void setUp() {
        test = new CityTree();
    }


    /**
     * This will test the insert method of CityTree
     */
    public void testInsert() {
        assertTrue(test.insert(new City("Detriot", 20, 20)));
        test.printTree();
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
    }

}
