/**
 * The underlying data structure that handle all our logical commands
 * recursively.
 * 
 * Even levels will split on x, while odd levels will split on y.
 * 
 * @author Charlie Kelley (charlk21)
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class CityTree {

    // Setting up local vars.
    private BaseNode<City> root;
    private int size;
    private final int WORLDSIZE = 1024;

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
     * This is the insert method for the CityTree.
     * 
     * @param newCity
     *            new city to be inserted
     * @return boolean telling if the insertion was performed.
     */
    public boolean insert(City newCity) {
        if (newCity.getX() >= WORLDSIZE || newCity.getX() < 0 || newCity
            .getY() >= WORLDSIZE || newCity.getY() < 0) {
            return false;
        }
        // the split boolean carries info as to which axis to cut in half.
        // we split along the x axis first, the ints will remember the slice
        // location.
        boolean answer = insert(root, null, newCity, false, WORLDSIZE / 2,
            WORLDSIZE / 2, WORLDSIZE / 4);
        if (answer) {
            size++;
            return true;
        }
        return false;
    }


    /**
     * Recursive helper method for the insert method
     * 
     * @param root
     *            The current root node of the subtree
     * @param last
     *            The parent node of the current root node
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
        BaseNode<City> root,
        InternalNode<City> last,
        City newCity,
        boolean splitY,
        int xcut,
        int ycut,
        int splitdist) {

        // test if root is leaf
        if (root.isLeaf() == true) {
            LeafNode<City> temp = (LeafNode<City>)root;
            // if flyweight
            if (temp.value() == null) {
                temp.setValue(newCity);
                return true;
            }
            else {
                // we have a filled leaf node
                // if the filled leaf node has equal coords to newCity return
                // false if not equal we need to change the leafnode to a
                // internalnode , give it two leafnode children, and call
                // insert on both of the colliding nodes.
                if (temp.value().getX() == newCity.getX() && temp.value()
                    .getY() == newCity.getY()) {
                    return false;
                }

                InternalNode<City> newInternalNode = new InternalNode<City>(
                    null, new LeafNode<City>(), new LeafNode<City>());

                // this new internal node must be linked to the last parent
                // node, null implies the root must be switched to internal
                if (last == null) {
                    this.root = newInternalNode;
                }
                else {
                    if (root == last.right()) {
                        last.setRight(newInternalNode);
                    }
                    else {
                        last.setLeft(newInternalNode);
                    }
                }
                // reinserting temp.value() which was the old value, and the
                // newCity value into the new Internal Node
                insert(newInternalNode, last, temp.value(), splitY, xcut, ycut,
                    splitdist);

                // The second is the only city that can possibly collide.
                return insert(newInternalNode, last, newCity, splitY, xcut,
                    ycut, splitdist);
            }

        }
        else {
            // the root is an internal node, and we need to find out which way
            // to traverse the tree
            InternalNode<City> temp = (InternalNode<City>)root;
            if (splitY) {
                if (newCity.getY() >= ycut) {
                    // shift ycut up, change to xcut, on y cuts we halve the
                    // split distance also
                    // we also got to root's right, but first we need to case it
                    return insert(temp.right(), temp, newCity, false, xcut, ycut
                        + splitdist, splitdist / 2);
                }
                else {
                    // The same as before, only going left and subtracting
                    // splitdist from ycut
                    return insert(temp.left(), temp, newCity, false, xcut, ycut
                        - splitdist, splitdist / 2);
                }
            }
            else {
                if (newCity.getX() >= xcut) {
                    // shift ycut up, change to xcut, on y cuts we halve the
                    // split distance also
                    // we also got to root's right, but first we need to case it
                    return insert(temp.right(), temp, newCity, true, xcut
                        + splitdist, ycut, splitdist);
                }
                else {
                    // The same as before, only going left and subtracting
                    // splitdist from ycut
                    return insert(temp.left(), temp, newCity, true, xcut
                        - splitdist, ycut, splitdist);
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
        return find(x, y, root, false, WORLDSIZE / 2, WORLDSIZE / 2, WORLDSIZE
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
     */
    public void printTree() {
        System.out.print(root.printNode(root, 0, 0, 0, WORLDSIZE, WORLDSIZE));
    }
}
