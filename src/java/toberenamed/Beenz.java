package toberenamed;

import java.time.LocalDate;

public class Beenz {

    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------
    
    private final int STARTING_AMOUNT = 0;
    private final int EXPIRY_DATE_INCREMENT = 1;
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final int id;
    private final Employee owner;
    private int amount;
    private LocalDate expiryDate;
    
    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public Beenz(Employee anOwner) {
        id = Unique.getUniqueId();
        owner = anOwner;
        amount = STARTING_AMOUNT;
        expiryDate = LocalDate.now().plusYears(EXPIRY_DATE_INCREMENT);
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public void addBeenz(int numBeenz) {
        amount += numBeenz;
        incrementExpiryDate();
    }
    
    public boolean spendBeenz(int numBeenz) {
        
        // we can only spend the beenz if we have enough, back out if we don't.
        if (numBeenz > amount) {
            return false;
        }
        
        // if our beenz have expired, we cannot spend them, back out.
        if (LocalDate.now().isAfter(expiryDate)) {
            amount = 0;
            return false;
        }
        
        // spend the beenz then say the operation was successful.
        amount -= numBeenz;
        return true;
    }
    
    @Override
    public String toString() {
        return owner.getName() + " has " + amount + " beenz, expiring: " + expiryDate;
    }

    //----------------------------------------------------------------------
    // Private Methods:
    //----------------------------------------------------------------------
    
    public void incrementExpiryDate() {
        expiryDate = expiryDate.plusYears(EXPIRY_DATE_INCREMENT);
    }
}
