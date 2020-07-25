/**
 * The underlying data structure that handle all our logical commands
 * recursively.
 * 
 * Even levels wil split on x, while odd levels will split on y.
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class CityTree {

    // Setting up local vars.
    private BaseNode<City> root;
    private int size;

    /**
     * This is the default zero information instantiation of CityTree
     */
    public CityTree() {
        root = new LeafNode<City>();
        size = 0;
    }


    /**
     * This is the default one city information instantiation of CityTree
     */
    public CityTree(City c) {
        root = new LeafNode<City>();
        size = 1;
    }


    /**
     * Gets the number of items in the CityTree
     * 
     * @return int of number of items in CityTree
     */
    public int length() {
        return size;
    }


    /**
     * Clears contents of CityTree
     */
    public void clear() {
        root = new LeafNode<City>();
        size = 0;
    }
}
