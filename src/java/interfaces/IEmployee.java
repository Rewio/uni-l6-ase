package interfaces;

import classes.PurchaseOrder;
import classes.Redeemable;

public interface IEmployee {

    public void rewardBeenz(int rewardedBeenz);
    public int viewAvailableBeenz();
    public PurchaseOrder redeemRedeemable(Redeemable redeemable);

}
