package toberenamed;

public class Employee {

  //----------------------------------------------------------------------
  // Private Fields:
  //----------------------------------------------------------------------

  private final int id;
  private final String forename;
  private final String surname;
  private final Beenz beenz;
  
  //----------------------------------------------------------------------
  // Constructor:
  //----------------------------------------------------------------------
  
  public Employee(String aForename, String aSurname) {
    id       = Unique.getUniqueId();
    forename = aForename;
    surname  = aSurname;
    beenz    = new Beenz();
  }
  
  //----------------------------------------------------------------------
  // Public Methods:
  //----------------------------------------------------------------------
  
  public String toString() {
    return id + " " + forename + " " + surname + " " + beenz;
  }
  
}
