package toberenamed;

import interfaces.IRedeemable;
import javax.ejb.Stateless;

@Stateless
public class Redeemable implements IRedeemable {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    protected int id;
    protected float cost;
    
    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------
    
    public float getCost() {
        return cost;
    }
    
    public void setCost(float newCost) {
        cost = newCost;
    }
    
    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    protected Redeemable() {
        
    }
    
    public void Test() {
        
    }
    
}
