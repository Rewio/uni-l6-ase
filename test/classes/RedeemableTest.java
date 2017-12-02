package classes;

import java.time.LocalDate;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RedeemableTest {
    
    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------

    private final String EMPLOYEE_FORENAME = "Andrew";
    private final String EMPLOYEE_SURNAME  = "Foster";
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private Employee emp;
    private Vacation red;

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public RedeemableTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Before
    public void setUp() {
        emp = new Employee(EMPLOYEE_FORENAME, EMPLOYEE_SURNAME);
        red = new Vacation(Vacation.Destinations.PaidLeave, LocalDate.now(), LocalDate.now().plusWeeks(1), 500);
    }
    
    @After
    public void tearDown() {
        emp = null;
        red = null;
    }
    
    @Test
    public void testRedeem() throws Exception {

        // first we test when the employee has no beenz.
        
        // make sure the employee has no beenz.
        emp.clearBeenz();
        
        // setup expected and actual results, then test.
        PurchaseOrder expResult = null;
        PurchaseOrder actResult = emp.redeemRedeemable(red);
        assertEquals(expResult, actResult);
        
        // now we test when the employee certainly has enough beenz.
        
        // give the employee enough beenz to purchase the redeemable.
        emp.rewardBeenz(100000);
        
        // setup expected and actual results, then test.
        PurchaseOrder po = new PurchaseOrder();
        expResult = po.createPurchaseOrder(emp, red, LocalDate.now());
        actResult = emp.redeemRedeemable(red);
        
        assertEquals(expResult.getEmployee(), actResult.getEmployee());
        assertEquals(expResult.getPurchasedRedeemable(), actResult.getPurchasedRedeemable());
        assertEquals(expResult.getDateRedeemed(), actResult.getDateRedeemed());
    }

}
