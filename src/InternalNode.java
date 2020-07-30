/**
 * The class representing the internal Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 * 
 * @param <E>
 *            variable type to be stored in InternalNode
 */
public class InternalNode<E> implements BaseNode<E> {
    private BaseNode<E> left;
    private BaseNode<E> right;

    /**
     * Constructor for an Internal node with given children
     * 
     * @param l
     *            left child of new internal node
     * @param r
     *            right child of new internal node
     */
    InternalNode(BaseNode<E> l, BaseNode<E> r) {
        left = l;
        right = r;
    }


    /**
     * Default constructor for the InternalNode class
     */
    InternalNode() {
        left = null;
        right = null;
    }


    /**
     * Check if the current node is a LeafNode
     * 
     * @return returns false
     */
    public boolean isLeaf() {
        return false;
    }


    /**
     * Return the left child of the InternalNode
     * 
     * @return left child
     */
    public BaseNode<E> left() {
        return this.left;
    }


    /**
     * Return the right child of the InternalNode
     * 
     * @return right child
     */
    public BaseNode<E> right() {
        return this.right;
    }


    /**
     * Set the left child of Internal node to a new pointer
     * 
     * @param newLeft
     *            new left child to replace current pointer
     */
    public void setLeft(BaseNode<E> newLeft) {
        this.left = newLeft;
    }


    /**
     * Set the right child of Internal node to a new pointer
     * 
     * @param newright
     *            new right child to replace current pointer
     */
    public void setRight(BaseNode<E> newRight) {
        this.right = newRight;
    }


    /**
     * return the value stored in an internal node which is always empty
     * 
     * @return null value
     */
    public E value() {
        return null;
    }

}
