package toberenamed;

public class Beenz {
  
  //----------------------------------------------------------------------
  // Constants:
  //----------------------------------------------------------------------

  private final int STARTING_AMOUNT = 0;
  
  //----------------------------------------------------------------------
  // Private Fields:
  //----------------------------------------------------------------------

  private final int id;
  private final Employee owner;
  private int amount;
  
  //----------------------------------------------------------------------
  // Constructor:
  //----------------------------------------------------------------------
  
  public Beenz(Employee aOwner) {
    id     = Unique.getUniqueId();
    owner  = aOwner;
    amount = STARTING_AMOUNT;    
  }
  
  //----------------------------------------------------------------------
  // Public Methods:
  //----------------------------------------------------------------------
  
  @Override
  public String toString() {
    return id + " " + owner.getEmployeeName() + " " + amount;
  }
  
}
