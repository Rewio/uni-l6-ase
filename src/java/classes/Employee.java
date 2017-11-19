package classes;

import interfaces.IEmployee;
import javax.ejb.Stateless;

@Stateless
public class Employee extends Unique implements IEmployee {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private String forename;
    private String surname;
    private Beenz beenz;
    
    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------

    public String getName() {
        return forename + " " + surname;
    }

    public String getInitials() {
        return forename.substring(0, 1) + surname.substring(0, 1);
    }
    
    public Beenz getBeenz() {
        return beenz;
    }
    
    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------
    
    // required to be flagged as stateless.
    protected Employee() {
    }

    public Employee(String aForename, String aSurname) {
        forename = aForename;
        surname = aSurname;
        beenz = new Beenz(this);
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public void rewardBeenz(int rewardedBeenz) {
        beenz.addBeenz(rewardedBeenz);
    }
    
    public int viewAvailableBeenz() {
        return beenz.getNumBeenz();
    }
    
    public void clearBeenz() {
        beenz.clearBeenz();
    }
    
    public PurchaseOrder redeemRedeemable(Redeemable redeemable) {
        return null;
    }
    
    @Override
    public String toString() {
        return getId() + " " + forename + " " + surname + " " + beenz;
    }

}
