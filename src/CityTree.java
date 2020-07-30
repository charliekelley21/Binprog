/**
 * The underlying data structure that handle all our logical commands
 * recursively.
 * 
 * Even levels will split on x, while odd levels will split on y.
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.26
 */
public class CityTree {

    // Setting up local vars.
    private BaseNode<City> root;
    private LeafNode<City> flyWeight;
    private SearchResult search;
    private int size;
    private final int worldSize = 1024;

    /**
     * This is the default zero information instantiation of CityTree
     */
    public CityTree() {
        flyWeight = new LeafNode<City>();
        root = flyWeight;
        size = 0;
    }


    /**
     * This is the default one city information instantiation of CityTree
     * 
     * @param c
     *            An initial City to add to the CityTree
     */
    public CityTree(City c) {
        flyWeight = new LeafNode<City>();
        root = new LeafNode<City>(c);
        size = 1;
    }


    /**
     * This is the insert method for the CityTree.
     * 
     * @param newCity
     *            new city to be inserted
     * @return boolean telling if the insertion was performed.
     */
    public boolean insert(City newCity) {
        if (newCity.getX() >= worldSize || newCity.getX() < 0 || newCity
            .getY() >= worldSize || newCity.getY() < 0) {
            return false;
        }
        // the split boolean carries info as to which axis to cut in half.
        // we split along the x axis first, the ints will remember the slice
        // location.
        boolean answer = insert(root, null, false, newCity, false, worldSize
            / 2, worldSize / 2, worldSize / 4);
        if (answer) {
            size++;
            return true;
        }
        return false;
    }


    /**
     * Recursive helper method for the insert method
     * 
     * @param rt
     *            The current root node of the subtree
     * @param last
     *            The parent node of the current root node
     * @param parentsRight
     *            conveys whether root is last's right or left child
     * @param newCity
     *            the new city to be inserted
     * @param splitY
     *            boolean the indicator whether to split on y
     * @param xcut
     *            int that remembers where in the subsection we are in for x
     * @param ycut
     *            int that remembers where in the subsection we are in for y
     * @param splitdist
     *            int that knows how to shift xcut or ycut
     * @return boolean on whether operation successful or not (won't be if
     *         coordinates already exist)
     */
    private boolean insert(
        BaseNode<City> rt,
        BaseNode<City> last,
        boolean parentsRight,
        City newCity,
        boolean splitY,
        int xcut,
        int ycut,
        int splitdist) {

        // if no nodes in tree reassign root and return true
        if (this.length() == 0) {
            root = new LeafNode<City>(newCity);
            return true;
        }
        if (rt.isLeaf()) {
            if (rt == flyWeight) {
                rt = new LeafNode<City>(newCity);
                // need to correctly insert newly generated LeafNode
                if (parentsRight) {
                    last.setRight(rt);
                }
                else {
                    last.setLeft(rt);
                }
                return true;
            }
            else {
                // we have a filled leaf node
                if (rt.value().getX() == newCity.getX() && rt.value()
                    .getY() == newCity.getY()) {
                    return false;
                }
                InternalNode<City> newInternalNode = new InternalNode<City>(
                    flyWeight, flyWeight);
                // node, null implies the root must be switched to internal
                if (last == null) {
                    root = newInternalNode;
                }
                else {
                    if (parentsRight) {
                        last.setRight(newInternalNode);
                    }
                    else {
                        last.setLeft(newInternalNode);
                    }
                }
                // reinsert both Cities
                insert(newInternalNode, last, parentsRight, rt.value(), splitY,
                    xcut, ycut, splitdist);
                return insert(newInternalNode, last, parentsRight, newCity,
                    splitY, xcut, ycut, splitdist);
            }

        }
        else {
            // the root is an internal node, and we need to find out which way
            // to traverse the tree
            if (splitY) {
                if (newCity.getY() >= ycut) {
                    return insert(rt.right(), rt, true, newCity, false, xcut,
                        ycut + splitdist, splitdist / 2);
                }
                else {
                    return insert(rt.left(), rt, false, newCity, false, xcut,
                        ycut - splitdist, splitdist / 2);
                }
            }
            else {
                if (newCity.getX() >= xcut) {
                    return insert(rt.right(), rt, true, newCity, true, xcut
                        + splitdist, ycut, splitdist);
                }
                else {
                    return insert(rt.left(), rt, false, newCity, true, xcut
                        - splitdist, ycut, splitdist);
                }
            }
        }
    }


    /**
     * This searches for what cities are in a given range and returns a
     * SearchResult based on this nodes it visited and the Cities it visited
     * 
     * @param x
     *            specifies the smallest x coordinate
     * @param y
     *            specifies the smallest y coordinate
     * @param w
     *            specifies the width, such that the largest x coordinate is x +
     *            w
     * @param h
     *            specifies the height, such that the largest y coordinate is y
     *            + h
     * @return SearchResult this is the answer to the search
     */
    public SearchResult regionSearch(int x, int y, int w, int h) {
        // find number of cities in range using helper method
        // outside world size
        if (x > worldSize || y > worldSize || x + w < 0 || y + h < 0
            || size == 0) {
            return null;
        }
        // fix parameters
        if (x + w > worldSize) {
            w = worldSize - x;
        }
        if (y + h > worldSize) {
            h = worldSize - y;
        }
        if (x < 0) {
            w = w + x;
            x = 0;
        }
        if (y < 0) {
            h = h + y;
            y = 0;
        }
        search = new SearchResult(size);
        regionSearch(root, false, x, y, w, h, worldSize / 2, worldSize / 2,
            worldSize / 4);
        search.snip();
        return search;
    }


    /**
     * This searches for what cities are in a given range and returns a
     * SearchResult based on this nodes it visited and the Cities it visited
     * 
     * @param rt
     *            current node we are searching through
     * @param x
     *            specifies the smallest x coordinate
     * @param y
     *            specifies the smallest y coordinate
     * @param w
     *            specifies the width, such that the largest x coordinate is x +
     *            w
     * @param h
     *            specifies the height, such that the largest y coordinate is y
     *            + h
     */
    private void regionSearch(
        BaseNode<City> rt,
        boolean splitY,
        int x,
        int y,
        int w,
        int h,
        int xcut,
        int ycut,
        int splitdist) {
        // base case
        search.nodeVisit();
        if (rt.isLeaf()) {
            // check if we are at valid leaf
            if (rt != flyWeight) {
                City temp = rt.value();
                // just because we are at a leaf node doesn't guarentee we are
                // in the range
                if (temp.getX() >= x && temp.getX() <= x + w && temp.getY() >= y
                    && temp.getY() <= y + h) {
                    search.insert(temp);
                }
            }
        }
        else {
            if (splitY) {
                // three cases:
                // region's y strictly greater than cut
                // region's right corner strictly less
                // a punctured region where we need to traverse down left and
                // right.
                if (y >= ycut) {
                    regionSearch(rt.right(), false, x, y, w, h, xcut, ycut
                        + splitdist, splitdist / 2);
                }
                else if (y + h <= ycut) {
                    regionSearch(rt.left(), false, x, y, w, h, xcut, ycut
                        - splitdist, splitdist / 2);
                }
                else {
                    regionSearch(rt.right(), false, x, y, w, h, xcut, ycut
                        + splitdist, splitdist / 2);
                    regionSearch(rt.left(), false, x, y, w, h, xcut, ycut
                        - splitdist, splitdist / 2);
                }
            }
            else {
                if (x >= xcut) {
                    regionSearch(rt.right(), true, x, y, w, h, xcut + splitdist,
                        ycut, splitdist);
                }
                else if (x + w <= xcut) {
                    regionSearch(rt.left(), true, x, y, w, h, xcut - splitdist,
                        ycut, splitdist);
                }
                else {
                    regionSearch(rt.right(), true, x, y, w, h, xcut + splitdist,
                        ycut, splitdist);
                    regionSearch(rt.left(), true, x, y, w, h, xcut - splitdist,
                        ycut, splitdist);
                }
            }
        }
    }


    /**
     * The find method for the CityTree, given coordinates it will return the
     * city or nulls
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @return City if found, null otherwise
     */
    public City find(int x, int y) {
        return find(x, y, root, false, worldSize / 2, worldSize / 2, worldSize
            / 4);
    }


    /**
     * Recursive implementation for the find method.
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param node
     *            the current node
     * @param splitY
     *            boolean the indicator whether to split on y
     * @param xcut
     *            int that remembers where in the subsection we are in for x
     * @param ycut
     *            int that remembers where in the subsection we are in for y
     * @param splitdist
     *            int that knows how to shift xcut or ycut
     * @return City if found, null otherwise
     */
    private City find(
        int x,
        int y,
        BaseNode<City> node,
        boolean splitY,
        int xcut,
        int ycut,
        int splitdist) {
        // reached a leaf node
        if (node.isLeaf()) {
            LeafNode<City> leaf = (LeafNode<City>)node;
            City eval = leaf.value();
            // flyweight
            if (eval == null) {
                return null;
            }
            if (eval.getX() == x && eval.getY() == y) {
                return eval;
            }
            return null;
        }
        InternalNode<City> intern = (InternalNode<City>)node;
        // see insert comments for decision making
        if (splitY) {
            if (y >= ycut) {
                return find(x, y, intern.right(), false, xcut, ycut + splitdist,
                    splitdist / 2);
            }
            else {
                return find(x, y, intern.left(), false, xcut, ycut - splitdist,
                    splitdist / 2);
            }
        }
        else {
            if (x >= xcut) {
                return find(x, y, intern.right(), true, xcut + splitdist, ycut,
                    splitdist);
            }
            else {
                return find(x, y, intern.left(), true, xcut - splitdist, ycut,
                    splitdist);
            }
        }
    }


    /**
     * Remove a node with the given coordinates
     *
     * @param x
     *            Given x coordinate
     * @param y
     *            Given y coordinate
     * @return boolean on success
     */
    public boolean remove(int x, int y) {
        City temp = find(x, y);
        if (temp == null) {
            return false;
        }
        size--;
        root = remove(root, x, y, false, worldSize / 2, worldSize / 2, worldSize
            / 4);
        return true;
    }


    /**
     * Internal remove method for CityTree. removes a given city from the tree
     * recursively.
     * 
     * @param rt
     *            root node
     * @param x
     *            X coordinate to remove
     * @param y
     *            Y coordinate to remove
     * @param splitY
     *            boolean true if this level splits in the y direction
     * @param xcut
     *            distance of current grid in the X direction
     * @param ycut
     *            distance of current grid in the Y direction
     * @param splitdist
     *            distance to split the current grid
     * @return the node to replace itself within the tree. used to recursively
     *         modify the CityTree class
     */
    private BaseNode<City> remove(
        BaseNode<City> rt,
        int x,
        int y,
        boolean splitY,
        int xcut,
        int ycut,
        int splitdist) {
        // if a leaf node is reached, it is the node to remove
        if (rt.isLeaf()) {
            return flyWeight;
        }
        // else traverse the internal node
        // see insert comments for decision making
        if (splitY) {
            if (y >= ycut) {
                rt.setRight(remove(rt.right(), x, y, false, xcut, ycut
                    + splitdist, splitdist / 2));
            }
            else {
                rt.setLeft(remove(rt.left(), x, y, false, xcut, ycut
                    - splitdist, splitdist / 2));
            }
        }
        else {
            if (x >= xcut) {
                rt.setRight(remove(rt.right(), x, y, true, xcut + splitdist,
                    ycut, splitdist));
            }
            else {
                rt.setLeft(remove(rt.left(), x, y, true, xcut - splitdist, ycut,
                    splitdist));
            }
        }
        // In the case that an internal node must be removed to remove a
        // partition in the grid then we must find the value to replace to
        // internal node with.
        if (rt.left() == flyWeight && rt.right().isLeaf()) {
            rt = rt.right();
        }
        else if (rt.right() == flyWeight && rt.left().isLeaf()) {
            rt = rt.left();
        }
        // unwind the recursion and return the rt node
        return rt;
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


    /**
     * Prints the contents of CityTree in pre-order
     * 
     * @return Printable string of CityTree structure
     */
    public String printTree() {
        // want to remove the new line character that isn't needed
        String tmp = printNode(root, 0, 0, 0, worldSize, worldSize);
        return tmp.substring(0, tmp.length() - 1);
    }


    /**
     * Print function for a BaseNode<E>
     * 
     * @param rt
     *            node that is currently being printed
     * @param level
     *            current depth of the node being printed
     * @param x
     *            current X coordinate of grid
     * @param y
     *            current Y coordinate of grid
     * @param w
     *            current width of grid
     * @param h
     *            current height of grid
     * @return Printable string of the current node and sub-trees
     */
    private String printNode(
        BaseNode<City> rt,
        int level,
        int x,
        int y,
        int w,
        int h) {
        String str = new String(new char[level * 2]).replace("\0", " ");
        if (level == 0) {
            str = "";
        }
        if (rt.isLeaf()) {
            if (rt.value() == null) {
                str += String.format("E, %d, %d, %d, %d\n", x, y, w, h);
            }
            else {
                str += rt.value().toString() + "\n";
            }
        }
        else {
            str += String.format("I, %d, %d, %d, %d\n", x, y, w, h);
            if (level % 2 == 0) { // split the X grid
                return str + printNode(rt.left(), level + 1, x, y, w / 2, h)
                    + printNode(rt.right(), level + 1, x + (w / 2), y, w / 2,
                        h);
            }
            else { // split the Y grid
                return str + printNode(rt.left(), level + 1, x, y, w, h / 2)
                    + printNode(rt.right(), level + 1, x, y + (h / 2), w, h
                        / 2);
            }
        }
        return str;
    }
}
