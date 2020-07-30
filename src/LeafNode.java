import java.util.NoSuchElementException;

/**
 * The class representing the leaf Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @param <E>
 *            The type of info stored in the LeafNode
 * @version 2020.07.25
 * 
 * @param <E>
 *            variable type to be stored in InternalNode
 */
public class LeafNode<E> implements BaseNode<E> {

    // Setting up vars
    private E v;

    /**
     * Public null constructor for LeafNode
     */
    LeafNode() {
        v = null;
    }


    /**
     * Constructor for LeafNode with a value
     * 
     * @param newValue
     *            The new value of LeafNode
     */
    LeafNode(E newValue) {
        v = newValue;
    }


    /**
     * Checks if LeafNode
     * 
     * @return boolean on whether a LeafNode or not.
     */
    public boolean isLeaf() {
        return true;
    }


    /**
     * Returns the value of LeafNode
     * 
     * @return E the value of the LeafNode
     */
    public E value() {
        return v;
    }


    /**
     * Sets the Value of the LeafNode
     * 
     * @param it
     *            the new value of the LeafNode
     */
    public void setValue(E it) {
        v = it;
    }


    /**
     * LeafNodes contain no left node so this returns null
     * 
     * @return BaseNode<E> null for LeafNodes have no children
     */
    public BaseNode<E> left() {
        return null;
    }


    /**
     * LeafNodes contain no right node so this returns null
     * 
     * @return BaseNode<E> null for LeafNodes have no children
     */
    public BaseNode<E> right() {
        return null;
    }


    /**
     * Throws an error for LeafNodes have no children
     * 
     * @param newRight
     *            filler for error checking function
     */
    public void setLeft(BaseNode<E> newLeft) {
        throw new NoSuchElementException(
            "LeafNode: no children exist for a given LeafNode");
    }


    /**
     * Throws an error for LeafNodes have no children
     * 
     * @param newRight
     *            filler for error checking function
     */
    public void setRight(BaseNode<E> newRight) {
        throw new NoSuchElementException(
            "LeafNode: no children exist for a given LeafNode");
    }

}
