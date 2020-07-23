import org.junit.Test;

import student.TestCase;

public class BinprogTest extends TestCase {

    /**
     * An artificial test to get initial coverage for the
     * main method. Delete or modify this test.
     */
    @Test
    public void testMain() {
        Binprog dum = new Binprog();
        assertNotNull(dum);
        Binprog.main(new String[1]);
        assertEquals(systemOut().getHistory(), ""); // check that nothing was printed out
    }

}
