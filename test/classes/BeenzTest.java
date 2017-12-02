package classes;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BeenzTest {
    
    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------

    private final String EMPLOYEE_FORENAME = "Andrew";
    private final String EMPLOYEE_SURNAME  = "Foster";
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private Employee emp;
    private Beenz beenz;
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Before
    public void setUp() {
        emp   = new Employee(EMPLOYEE_FORENAME, EMPLOYEE_SURNAME);
        beenz = new Beenz(emp);
    }
    
    @After
    public void tearDown() {
       beenz = null;
       emp   = null;
    }
    
    @Test
    public void testGetNumBeenz() throws Exception {
        
        // starting beenz is a constant in the Beenz class, if that changes, this must also.
        int startingBeenz = 0;
        
        // setup expected and actual results, then test.
        int expResult = startingBeenz;
        int actResult = beenz.getNumBeenz();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testAddBeenz() throws Exception {

        // get the starting beenz to be compared later.
        int startingBeenz = beenz.getNumBeenz();
        
        // add some beenz.
        int beenzToAdd = 500;
        beenz.addBeenz(beenzToAdd);
        
        // setup expected and actual results, then test.
        int expResult = startingBeenz + beenzToAdd;
        int actResult = beenz.getNumBeenz();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testSpendBeenz() throws Exception {
        
        // add some beenz so we have some to spend.
        beenz.addBeenz(5000);
        
        // get how many beenz we have after adding some.
        int numBeenz = beenz.getNumBeenz();
        
        // spend some beenz.
        int beenzToSpend = 500;
        beenz.spendBeenz(beenzToSpend);
        
        // setup expected and actual results, then test.
        int expResult = numBeenz - beenzToSpend;
        int actResult = beenz.getNumBeenz();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testClearBeenz() throws Exception {
      
        // add some beenz to be cleared, then attempt to clear them.
        beenz.addBeenz(500000);
        beenz.clearBeenz();
        
        // setup expected and actual results, then test.
        int expResult = 0;
        int actResult = beenz.getNumBeenz();
        assertEquals(expResult, actResult);
    }

}
