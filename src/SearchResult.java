/**
 * The underlying data structure that handle all our logical commands
 * recursively.
 * 
 * Even levels will split on x, while odd levels will split on y.
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.26
 */
public class SearchResult {

    // Setting up vars
    private City[] ans;
    private int nodesVisited;

    /**
     * Constructor for SearchResult
     * 
     * @param n
     *            number of Cities in the range.
     */
    public SearchResult(int n) {
        ans = new City[n];
        nodesVisited = 0;
    }


    /**
     * This will be what CommandManager calls to get cities.
     * 
     * @return City[] of cities in the range
     */
    public City[] answers() {
        return ans;
    }


    /**
     * This returns the number of nodes visited
     * 
     * @return int of nodes visited
     */
    public int nodesVisited() {
        return this.nodesVisited;
    }


    /**
     * This returns the number of nodes visited
     * 
     * @return int of nodes visited
     */
    public void setNodesVisited(int nodesVisited) {
        this.nodesVisited = nodesVisited;
    }
}
