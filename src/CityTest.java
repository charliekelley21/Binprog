import student.TestCase;

/**
 * The unit testing class for the City Object
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class CityTest extends TestCase {

    // setting up the local variables
    private City test1;
    private City test2;

    /**
     * This is the setUp method for the City Testing suite.
     */
    public void setUp() {
        test1 = new City("Hello_town", 500, 200);
        test2 = new City(250, 420, "Apple_town");
    }


    /**
     * This will test the getX method
     */
    public void testGetX() {
        assertEquals(500, test1.getX());
        assertEquals(250, test2.getX());
    }


    /**
     * This will test the getY method
     */
    public void testGetY() {
        assertEquals(200, test1.getY());
        assertEquals(420, test2.getY());
    }


    /**
     * This will test the getName method
     */
    public void testGetName() {
        assertEquals("Hello_town", test1.getName());
        assertEquals("Apple_town", test2.getName());
    }


    /**
     * This will test the equals method
     */
    public void testGetEquals() {
        City equaltest1 = null;
        String equaltest2 = "Hello_town";
        City equaltest3 = new City("Hello_town", 0, 0);
        City equaltest4 = new City("abc", 500, 0);
        City equaltest5 = new City("abc", 0, 200);
        City equaltest6 = new City("Hello_town", 500, 0);
        City equaltest7 = new City("Hello_town", 0, 200);
        City equaltest8 = new City("abc", 500, 200);
        City equaltest9 = new City("Hello_town", 500, 200);
        assertFalse(test1.equals(equaltest1));
        assertFalse(test1.equals(equaltest2));
        assertFalse(test1.equals(equaltest3));
        assertFalse(test1.equals(equaltest4));
        assertFalse(test1.equals(equaltest5));
        assertFalse(test1.equals(equaltest6));
        assertFalse(test1.equals(equaltest7));
        assertFalse(test1.equals(equaltest8));
        assertTrue(test1.equals(equaltest9));
        assertFalse(test1.equals(test2));
    }


    /**
     * This will test the toString method
     */
    public void testToString() {
        assertEquals("Hello_town 500 200", test1.toString());
        assertEquals("Apple_town 250 420", test2.toString());
    }
}
