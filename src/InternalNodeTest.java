import java.util.NoSuchElementException;
import student.TestCase;

/**
 * The test class for the InternalNode class
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class InternalNodeTest extends TestCase {

    /**
     * Test InternalNode's constructor for different variable types
     */
    public void testConstructor() {
        InternalNode<String> s = new InternalNode<String>();
        assertNull(s.left());
        assertNull(s.right());

        InternalNode<String> l = new InternalNode<String>();
        InternalNode<String> r = new InternalNode<String>();
        s = new InternalNode<String>(l, r);
        assertEquals(l, s.left());
        assertEquals(r, s.right());
    }


    /**
     * Test InternalNode's isLeaf method
     */
    public void testIsLeaf() {
        InternalNode<City> c = new InternalNode<City>();
        assertFalse(c.isLeaf());
    }


    /**
     * test that a InternalNode's left and right methods 
     */
    public void testChildrenOfInternal() {
        InternalNode<String> s = new InternalNode<String>();
        InternalNode<String> l = new InternalNode<String>();
        InternalNode<String> r = new InternalNode<String>();
        s.setRight(r);
        s.setLeft(l);        
        assertEquals(l, s.left());
        assertEquals(r, s.right());
    }
    
    /**
     * test that InternalNode class does not contain a value
     */
    public void testValue() {
        InternalNode<String> s = new InternalNode<String>();
        assertNull(s.value());
    }

}
