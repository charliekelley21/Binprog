import java.util.NoSuchElementException;
import student.TestCase;

/**
 * The test class for the LeafNode class
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class LeafNodeTest extends TestCase {

    /**
     * Test leafNode's constructor for different variable types
     */
    public void testConstructor() {
        LeafNode<String> s = new LeafNode<String>();
        assertNull(s.value());

        s = new LeafNode<String>("testString");
        assertEquals(s.value(), "testString");

        LeafNode<Integer> d = new LeafNode<Integer>();
        assertNull(d.value());

        d = new LeafNode<Integer>(45);
        assertTrue(d.value() == 45);
    }


    /**
     * Test leafNode's isLeaf method
     */
    public void testIsLeaf() {
        LeafNode<City> c = new LeafNode<City>();
        assertTrue(c.isLeaf());
    }


    /**
     * Test leafNode's setValue method
     */
    public void testSetValue() {
        LeafNode<String> s = new LeafNode<String>();
        assertNull(s.value());
        s.setValue("new value");
        assertEquals(s.value(), "new value");
    }


    /**
     * test that a leafNode's left and right methods do no return a value as it
     * is not an internal node
     */
    public void testChildrenOfLeaf() {
        LeafNode<String> s = new LeafNode<String>();
        assertNull(s.left());
        assertNull(s.right());
    }


    /**
     * test LeafNode's ability to prevent setting a child for the node.
     */
    public void testSetChildrenOfLeafNode() {
        LeafNode<String> s = new LeafNode<String>();
        try {
            s.setLeft(new LeafNode<String>("fake left"));
        }
        catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }

        try {
            s.setRight(new LeafNode<String>("fake right"));
        }
        catch (Exception e) {
            assertTrue(e instanceof NoSuchElementException);
        }
    }

}
