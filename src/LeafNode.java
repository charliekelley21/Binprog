import java.util.NoSuchElementException;

/**
 * The class representing the leaf Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 * 
 * @param <E>
 *            variable type to be stored in InternalNode
 */
public class LeafNode<E> implements BaseNode<E> {
    private E v;

    /**
     * Default constructor for the leafNode class
     */
    LeafNode() {
        v = null;
    }


    /**
     * Constructor for LeafNode class. Stores given value in the LeafNode.
     * 
     * @param newValue
     *            value to be stored in the LeafNode
     */
    LeafNode(E newValue) {
        v = newValue;
    }


    /**
     * Reveals that a given node is a LeafNode
     * 
     * @return true
     */
    public boolean isLeaf() {
        return true;
    }


    /**
     * Return the value stored in the LeafNode
     * 
     * @return value of LeafNode
     */
    public E value() {
        return v;
    }


    /**
     * Set a new value for a LeafNode
     * 
     * @param it
     *            new value to be stored
     */
    public void setValue(E it) {
        v = it;
    }


    /**
     * This is going to be the left node of the BaseNode
     * 
     * @return BaseNode's left node
     */
    public BaseNode<E> left() {
        return null;
    }


    /**
     * This is going to be the right node of the BaseNode
     * 
     * @return BaseNode's right node
     */
    public BaseNode<E> right() {
        return null;
    }


    /**
     * Set the left child of LeafNode node to a new pointer. Throws an exception
     * because the LeafNode class does not store pointers.
     * 
     * @param newLeft
     *            new left child to replace current pointer
     */
    public void setLeft(BaseNode<E> newLeft) {
        throw new NoSuchElementException(
            "LeafNode: no children exist for a given LeafNode");
    }


    /**
     * Set the right child of LeafNode node to a new pointer. Throws an
     * exception
     * because the LeafNode class does not store pointers.
     * 
     * @param newRight
     *            new right child to replace current pointer
     */
    public void setRight(BaseNode<E> newRight) {
        throw new NoSuchElementException(
            "LeafNode: no children exist for a given LeafNode");
    }

}
