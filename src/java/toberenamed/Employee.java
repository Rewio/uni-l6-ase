package toberenamed;

import interfaces.IEmployee;
import javax.ejb.Stateless;

@Stateless
public class Employee implements IEmployee {

  //----------------------------------------------------------------------
  // Private Fields:
  //----------------------------------------------------------------------

  private int id;
  private String forename;
  private String surname;
  private Beenz beenz;
  
  //----------------------------------------------------------------------
  // Constructors:
  //----------------------------------------------------------------------
  
  // required to be flagged as stateless.
  protected Employee() {}
  
  public Employee(String aForename, String aSurname) {
    id       = Unique.getUniqueId();
    forename = aForename;
    surname  = aSurname;
    beenz    = new Beenz(this);
  }
  
  //----------------------------------------------------------------------
  // Public Methods:
  //----------------------------------------------------------------------
  
  public String getEmployeeName() {
    return forename + " " + surname;
  }
  
  @Override
  public String toString() {
    return id + " " + forename + " " + surname + " " + beenz;
  }
  
}
