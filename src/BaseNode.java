/**
 * The interface that our two Node types will be built off of.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public interface BaseNode<E> {
    public boolean isLeaf();
    public String printNode(BaseNode<E> rt, int level, int x, int y, int w, int h);
}
