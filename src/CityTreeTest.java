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
        test.insert(new City("Detriot", 20, 20));
        test.printTree();
        test.insert(new City("New York", 700, 700));
        test.insert(new City("Boston", 1000, 20));
    }

}
