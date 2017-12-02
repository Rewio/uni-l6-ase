package classes;

import interfaces.IPurchaseOrder;
import java.time.LocalDate;
import javax.ejb.Stateless;

@Stateless
public class PurchaseOrder extends Unique implements IPurchaseOrder {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private Employee purchasee;
    private Redeemable purchasedRedeemable;
    private LocalDate dateRedeemed;
    
    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------
    
    public Employee getEmployee() {
        return purchasee;
    }
    
    public Redeemable getPurchasedRedeemable() {
        return purchasedRedeemable;
    }
    
    public LocalDate getDateRedeemed() {
        return dateRedeemed;
    }
    
    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------
    
    public PurchaseOrder() {
    }
    
    private PurchaseOrder(Employee aPurchasee, Redeemable aPurchasedRedeeamble, LocalDate aDateRedeemed) {
        purchasee           = aPurchasee;
        purchasedRedeemable = aPurchasedRedeeamble;
        dateRedeemed        = aDateRedeemed;
    }

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    @Override
    public PurchaseOrder createPurchaseOrder(Employee purchasee, Redeemable purchasedRedeemable, LocalDate dateRedeemed) {
        return new PurchaseOrder(purchasee, purchasedRedeemable, dateRedeemed);
    }

    @Override
    public String viewPurchaseOrderDetails() {
        return "POID: " + getId() + " - PO: " + purchasee + " purchased " + purchasedRedeemable + " on " + dateRedeemed;
    }
    
}
