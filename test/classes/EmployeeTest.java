package classes;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final String employeeForename = "Andrew";
    private final String employeeSurname = "Foster";

    private final Employee emp1 = new Employee(employeeForename, employeeSurname);

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public EmployeeTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Test
    public void testRewardBeenz() throws Exception {
        
        // test data.
        int startingBeenz = emp1.getBeenz().getNumBeenz();
        int beenzToAdd = 100;
        
        // add some beenz.
        emp1.rewardBeenz(beenzToAdd);
        
        // setup results.
        int expResult = startingBeenz + beenzToAdd;
        int actResult = emp1.getBeenz().getNumBeenz();
        
        // test.
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testViewAvailableBeenz() throws Exception {

        // test data.
        emp1.clearBeenz();
        emp1.getBeenz().addBeenz(100);
        
        // setup results.
        int expResult = 100;
        int actResult = emp1.viewAvailableBeenz();
        
        // test.
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testClearBeenz() throws Exception {
        
        // test data.
        emp1.rewardBeenz(10000);
        emp1.clearBeenz();
        
        // setup results.
        int expResult = 0;
        int actResult = emp1.viewAvailableBeenz();
        
        // test.
        assertEquals(expResult, actResult);
    }
}
