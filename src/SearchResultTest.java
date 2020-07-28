import student.TestCase;

/**
 * The testing class for the SearchResult
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.28
 */
public class SearchResultTest extends TestCase {

    // setting up vars
    private SearchResult test;

    /**
     * The setup method for the test suite
     */
    public void setUp() {
        test = new SearchResult(10);
    }


    /**
     * Tests the insert method
     */
    public void testInsert() {
        test.insert(new City("Blacksburg", 60, 60));
        assertEquals(10, test.answers().length);
        assertEquals("Blacksburg", test.answers()[0].getName());
    }


    /**
     * Tests the answers method
     */
    public void testAnswers() {
        test.insert(new City("Blacksburg", 60, 60));
        assertEquals(10, test.answers().length);
        assertEquals("Blacksburg", test.answers()[0].getName());
    }


    /**
     * Tests the snip method
     */
    public void testSnip() {
        test.insert(new City("Blacksburg", 60, 60));
        test.snip();
        assertEquals(1, test.answers().length);
        assertEquals("Blacksburg", test.answers()[0].getName());
    }


    /**
     * Tests the nodeVisit method
     */
    public void testNodeVisit() {
        test.nodeVisit();
        test.nodeVisit();
        assertEquals(2, test.nodesVisited());
    }


    /**
     * Tests the nodesVisited method
     */
    public void testNodesVisited() {
        test.nodeVisit();
        test.nodeVisit();
        assertEquals(2, test.nodesVisited());
    }
}
