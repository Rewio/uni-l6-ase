package classes;

import java.time.LocalDate;

public class Vacation extends Redeemable {
    
    //----------------------------------------------------------------------
    // Type Definitions:
    //----------------------------------------------------------------------

    public enum Destinations {
        London,
        NewYork,
        Paris, 
        Amsterdam, 
        Manitoba,
        PaidLeave
    }
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private final Destinations destination;
    private final LocalDate startDate;
    private final LocalDate endDate;
    
    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------
    
    public Vacation(Destinations aDestination, LocalDate aStartDate, LocalDate aEndDate, int aCost) {
        destination = aDestination;
        startDate   = aStartDate;
        endDate     = aEndDate;
        cost        = aCost;
    }
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Vacation: " + destination + ", from: " + startDate.toString() + " to " + endDate.toString() + ". Cost: " + cost + " beenz.";
    } 
    
}
