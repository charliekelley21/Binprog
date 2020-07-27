/**
 * The class representing the leaf Nodes of CityTree
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class LeafNode<E> implements BaseNode<E> {
    private E v;

    LeafNode() {
        v = null;
    }


    LeafNode(E newValue) {
        v = newValue;
    }


    public boolean isLeaf() {
        return true;
    }


    public E value() {
        return v;
    }


    public void setValue(E it) {
        v = it;
    }
    
    public BaseNode<E> left() {
        return null;
    }
    
    public BaseNode<E> right() {
        return null;
    }
    
    public void setLeft(BaseNode<E> newLeft) { // raise exception
        return;
    }


    public void setRight(BaseNode<E> newRight) {
        return;
    }

}
