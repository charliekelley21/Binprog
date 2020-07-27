/**
 * The class representing the internal Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class InternalNode<E> implements BaseNode<E> {
    private BaseNode<E> left;
    private BaseNode<E> right;

    InternalNode(BaseNode<E> l, BaseNode<E> r) {
        left = l;
        right = r;
    }


    InternalNode() {
        left = null;
        right = null;
    }


    public boolean isLeaf() {
        return false;
    }


    public BaseNode<E> left() {
        return this.left;
    }


    public BaseNode<E> right() {
        return this.right;
    }


    public void setLeft(BaseNode<E> newLeft) {
        this.left = newLeft;
    }


    public void setRight(BaseNode<E> newRight) {
        this.right = newRight;
    }


    public E value() {
        return null;
    }

}
