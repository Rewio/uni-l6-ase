package classes;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class BeenzTest {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final String employeeForename = "Andrew";
    private final String employeeSurname = "Foster";

    private final Employee emp1 = new Employee(employeeForename, employeeSurname);

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public BeenzTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Test
    public void testAddBeenz() throws Exception {

        // test data.
        int startingBeenz = emp1.getBeenz().getNumBeenz();
        int beenzToAdd = 100;

        // add beenz for testing.
        emp1.getBeenz().addBeenz(beenzToAdd);
        
        // get the new beenz number after adding some.
        int expResult = startingBeenz + beenzToAdd;
        int actResult = emp1.getBeenz().getNumBeenz();
        
        // test.
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testSpendBeenz() throws Exception {
        
        // test data.
        int beenzToSpend = 100;
        
        // need to start with some beenz, otherwise have none to spend.
        emp1.getBeenz().addBeenz(beenzToSpend);
        int startingBeenz = emp1.getBeenz().getNumBeenz();
              
        // spend the beenz.
        emp1.getBeenz().spendBeenz(beenzToSpend);
        
        // setup results.
        int expResult = startingBeenz - beenzToSpend;
        int actResult = emp1.getBeenz().getNumBeenz();
        
        // test.
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testClearBeenz() throws Exception {
        
        // add some beenz to remove.
        emp1.getBeenz().addBeenz(100);
        emp1.clearBeenz();
        
        // setup results.
        int expResult = 0;
        int actResult = emp1.getBeenz().getNumBeenz();
        
        // test.
        assertEquals(expResult, actResult);
        
    }

}
