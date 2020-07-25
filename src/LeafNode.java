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
    
    public String printNode(BaseNode<E> rt, int level, int x, int y, int w, int h) {
        if (rt == null) return "";
        // insert logic for a flyweight print
        return new String(new char[level*2]).replace("\0", " ") + v;
    }
    
    public E value() {
        return v;
    }
    
    public void setValue(E it) {
        v = it;
    }
    
}