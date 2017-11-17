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
        id = Unique.getUniqueId();
        forename = aForename;
        surname = aSurname;
        beenz = new Beenz(this);
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Override
    public String toString() {
        return id + " " + forename + " " + surname + " " + beenz;
    }

}
