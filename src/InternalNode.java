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


    public boolean isLeaf() {
        return false;
    }


    public String printNode(
        BaseNode<E> rt,
        int level,
        int x,
        int y,
        int w,
        int h) {
        if (rt == null)
            return "";

        String node = new String(new char[level * 2]).replace("\0", " ");
        node += String.format("I, %d, %d, %d, %d\n", x, y, w, h);

        if (level % 2 == 0) { // split the X grid
            return node + printNode(left, level + 1, x, y, w / 2, h)
                + printNode(left, level + 1, x + (w / 2), y, w / 2, h);
        }
        else { // split the Y grid
            return node + printNode(left, level + 1, x, y, w, h / 2)
                + printNode(left, level + 1, x, y + (h / 2), w, h / 2);
        }
    }


    public E value() {
        return v;
    }


    public void setValue(E it) {
        v = it;
    }


    public BaseNode<E> left() {
        return left;
    }


    public BaseNode<E> right() {
        return right;
    }


    public void setLeft(BaseNode<E> newLeft) {
        this.left = newLeft;
    }


    public void setRight(BaseNode<E> newRight) {
        this.right = newRight;
    }

}
