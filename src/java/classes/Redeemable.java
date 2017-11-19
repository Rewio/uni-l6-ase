package classes;

import java.time.LocalDate;

public abstract class Redeemable extends Unique {
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private final PurchaseOrder po = new PurchaseOrder();
    
    //----------------------------------------------------------------------
    // Protected Fields:
    //----------------------------------------------------------------------
    
    protected int cost;
    
    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------
    
    public float getCost() {
        return cost;
    }
    
    public void setCost(int newCost) {
        cost = newCost;
    }
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public PurchaseOrder redeem(Employee redeemer) {
        
        // if the redeemer does not have enough beenz, let them know then return.
        if (redeemer.getBeenz().getNumBeenz() < cost) {
            System.out.println(redeemer.getName() + " does not have enough Beenz (" + cost + ") for this redeemable.");
            return null;
        }
        
        // spend the redeemers beenz.
        redeemer.getBeenz().spendBeenz(cost);
        
        // create a purchase order as we have been redeemed.
        return po.createPurchaseOrder(redeemer, this, LocalDate.now());
    }
    
}
