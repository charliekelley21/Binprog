/**
 * The class representing the internal Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class InternalNode<E> implements BaseNode<E> {
    private E v; // might not be needed
    private BaseNode<E> left;
    private BaseNode<E> right;

    InternalNode(E newValue, BaseNode<E> l, BaseNode<E> r) {
        v = newValue;
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


    public E value() {
        return this.v;
    }


    public void setValue(E it) {
        this.v = it;
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

}
