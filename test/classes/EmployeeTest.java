package classes;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class EmployeeTest {

    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------

    private final String EMPLOYEE_FORENAME = "Andrew";
    private final String EMPLOYEE_SURNAME  = "Foster";
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private Employee emp;

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public EmployeeTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Before
    public void setUp() {
        emp = new Employee(EMPLOYEE_FORENAME, EMPLOYEE_SURNAME);
    }
    
    @After
    public void tearDown() {
        emp = null;
    }
    
    @Test
    public void testRewardBeenz() throws Exception {
        
        // get the starting beenz to be compared later.
        int startingBeenz = emp.getBeenz().getNumBeenz();
        
        // add some beenz.
        int beenzToAdd = 100;
        emp.rewardBeenz(beenzToAdd);
        
        // setup expected and actual results, then test.
        int expResult = startingBeenz + beenzToAdd;
        int actResult = emp.getBeenz().getNumBeenz();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testViewAvailableBeenz() throws Exception {

        // clear the employees beenz so they have none.
        emp.clearBeenz();
        
        // add some beenz.
        int beenzToAdd = 100;
        emp.getBeenz().addBeenz(beenzToAdd);
        
        // setup expected and actual results, then test.
        int expResult = beenzToAdd;
        int actResult = emp.viewAvailableBeenz();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testClearBeenz() throws Exception {
        
        // reward the employee with beenz, then attempt to clear them.
        emp.rewardBeenz(10000);
        emp.clearBeenz();
        
        // setup expected and actual results, then test.
        int expResult = 0;
        int actResult = emp.viewAvailableBeenz();
        assertEquals(expResult, actResult);
    }
}
