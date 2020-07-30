
/**
 * The interface that our two Node types will be built off of.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 * 
 * @param <E>
 *            type to be store in BaseNode
 */
public interface BaseNode<E> {
    /**
     * Determines if the node is a leaf node
     * 
     * @return true if the node is a leafNode
     */
    public boolean isLeaf();


    /**
     * This is going to be the left node of the BaseNode
     * 
     * @return BaseNode's left node
     */
    public BaseNode<E> left();


    /**
     * This is going to be the right node of the BaseNode
     * 
     * @return BaseNode's right node
     */
    public BaseNode<E> right();


    /**
     * This is going to set the left node of BaseNode
     * 
     * @param newLeft
     *            node to set left child equal to
     */
    public void setLeft(BaseNode<E> newLeft);


    /**
     * This is going to set the right node of BaseNode
     * 
     * @param newRight
     *            node to set right child equal to
     */
    public void setRight(BaseNode<E> newRight);


    /**
     * The value of the BaseNode
     * 
     * @return the value of the BaseNode
     */
    public E value();

}
