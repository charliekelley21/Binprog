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
    private int index;

    /**
     * Constructor for SearchResult
     * 
     * @param n
     *            number of Cities in the range.
     */
    public SearchResult(int n) {
        ans = new City[n];
        index = 0;
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
     * Inserts a City into the SearchResult
     * 
     * @param c
     *            City to be inserted
     */
    public void insert(City c) {
        ans[index] = c;
        index++;
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
     * Removes all the items after index
     */
    public void snip() {
        City[] tmp = new City[index];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = ans[i];
        }
        ans = tmp;
    }


    /**
     * This returns the number of nodes visited
     * 
     * @return int of nodes visited
     */
    public void nodeVisit() {
        nodesVisited++;
    }
}
