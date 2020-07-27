
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


    public BaseNode<E> left();


    public BaseNode<E> right();


    public void setLeft(BaseNode<E> newLeft);


    public void setRight(BaseNode<E> newRight);


    public E value();

}
