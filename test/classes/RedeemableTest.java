package classes;

import classes.Document;
import classes.Employee;
import java.time.LocalDate;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedeemableTest {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final String employeeForename = "Andrew";
    private final String employeeSurname = "Foster";

    private final Employee emp1 = new Employee(employeeForename, employeeSurname);
    private final Vacation red1 = new Vacation(Vacation.Destinations.London, LocalDate.now(), LocalDate.now().plusWeeks(1), 500);

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public RedeemableTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Test
    public void testRedeem() throws Exception {

        // ensure the employee has no beenz to begin with.
        emp1.clearBeenz();
        
        // create a null PO and attempt to redeem without enough beenz, resulting in a null PO.
        PurchaseOrder expResult = null;
        PurchaseOrder actResult = emp1.redeemRedeemable(red1);
        
        // test.
        assertEquals(expResult, actResult);
        
        // give the employee enough beenz to purchase the redeemable.
        emp1.clearBeenz();
        emp1.rewardBeenz(500);
        
        // setup next test.
        PurchaseOrder po = new PurchaseOrder();
        expResult = po.createPurchaseOrder(emp1, red1, LocalDate.now());
        actResult = emp1.redeemRedeemable(red1);
        
        // test the test where everything should succeed, and not have a null PO.
        assertEquals(expResult.getEmployee(), actResult.getEmployee());
        assertEquals(expResult.getPurchasedRedeemable(), actResult.getPurchasedRedeemable());
        assertEquals(expResult.getDateRedeemed(), actResult.getDateRedeemed());
    }

}
