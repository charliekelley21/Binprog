import student.TestCase;

/**
 * The testing class for Binprog
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class BinprogTest extends TestCase {

    /**
     * An artificial test to get initial coverage for the
     * main method. Delete or modify this test.
     */
    public void testMain() {
        Binprog dum = new Binprog();
        assertNotNull(dum);
        Binprog.main(new String[1]);
        assertEquals(systemOut().getHistory(), ""); // check that nothing was
                                                    // printed out
    }

}
