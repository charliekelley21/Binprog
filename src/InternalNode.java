/**
 * The class representing the internal Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @param <E>
 *            The type of info stored in the InternalNode
 * @version 2020.07.25
 */
public class InternalNode<E> implements BaseNode<E> {

    // setting up vars
    private BaseNode<E> left;
    private BaseNode<E> right;

    /**
     * The constructor for InternalNode with values
     * 
     * @param l
     *            the left child
     * @param r
     *            the right child
     */
    InternalNode(BaseNode<E> l, BaseNode<E> r) {
        left = l;
        right = r;
    }


    /**
     * The null constructor for the InternalNode
     */
    InternalNode() {
        left = null;
        right = null;
    }


    /**
     * InternalNode cannot be a leaf node
     * 
     * @return boolean on whether leaf node or not
     */
    public boolean isLeaf() {
        return false;
    }


    /**
     * Returns the left node of this InternalNode
     * 
     * @return BaseNode<E> The left child of this node
     */
    public BaseNode<E> left() {
        return this.left;
    }


    /**
     * Returns the right node of this InternalNode
     * 
     * @return BaseNode<E> The right child of this node
     */
    public BaseNode<E> right() {
        return this.right;
    }


    /**
     * Sets the left node for this InternalNode
     * 
     * @param BaseNode<E>
     *            The left child of this node
     */
    public void setLeft(BaseNode<E> newLeft) {
        this.left = newLeft;
    }


    /**
     * Sets the right node for this InternalNode
     * 
     * @param BaseNode<E>
     *            The right child of this node
     */
    public void setRight(BaseNode<E> newRight) {
        this.right = newRight;
    }


    /**
     * This returns the value of the InternalNode
     * 
     * @return E this will always be null, for we are not storing info in the
     *         InternalNode
     */
    public E value() {
        return null;
    }

}
