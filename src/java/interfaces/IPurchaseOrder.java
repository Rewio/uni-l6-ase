package interfaces;

import classes.Employee;
import classes.PurchaseOrder;
import classes.Redeemable;
import java.time.LocalDate;

public interface IPurchaseOrder {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    public PurchaseOrder createPurchaseOrder(Employee purchasee, Redeemable purchasedRedeemable, LocalDate dateRedeemed);
    public String viewPurchaseOrderDetails();
    
}
