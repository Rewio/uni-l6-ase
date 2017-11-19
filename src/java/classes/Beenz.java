package classes;

import java.time.LocalDate;

public class Beenz extends Unique {

    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------
    
    private final int STARTING_AMOUNT = 0;
    private final int EXPIRY_DATE_INCREMENT = 1;
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private final Employee owner;
    private int amount;
    private LocalDate expiryDate;
    
    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------
    
    public int getNumBeenz() {
        return amount;
    }
    
    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public Beenz(Employee anOwner) {
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
    
    public void clearBeenz() {
        amount = 0;
    }
    
    @Override
    public String toString() {
        return getId() + " " + owner.getName() + " has " + amount + " beenz, expiring: " + expiryDate;
    }

    //----------------------------------------------------------------------
    // Private Methods:
    //----------------------------------------------------------------------
    
    private void incrementExpiryDate() {
        expiryDate = expiryDate.plusYears(EXPIRY_DATE_INCREMENT);
    }
}
