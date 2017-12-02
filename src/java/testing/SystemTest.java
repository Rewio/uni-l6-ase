package testing;

import classes.Vacation;
import classes.Book;
import classes.Employee;
import classes.CD;
import classes.Document;
import classes.PurchaseOrder;
import java.time.LocalDate;

/**
 * A class used to show the use of the system. Everything shown is a requirement as specified by the case study, and modelled in the UML.
 */
public class SystemTest {
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private static final SystemClass sys = new SystemClass();
    private static Document doc1;
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public static void main(String[] args) {
        
        // setup the employee(s) and document(s) to be manipulated.
        Employee emp1 = sys.createEmployee("Andrew", "Foster");
        Employee emp2 = sys.createEmployee("John", "Doe");
        Employee emp3 = sys.createEmployee("Jane", "Doe");
        
        // show beenz before creating, contributing, and viewing documents.
        System.out.println(sys.viewEmployeeBeenz(emp1));
        System.out.println(sys.viewEmployeeBeenz(emp2));
        System.out.println(sys.viewEmployeeBeenz(emp3));
        System.out.println();
        
        // repeatidly create, contribute to, and read documents to get beenz rewards.
        for (int i = 0; i < 100; i++) {
            doc1 = sys.createDocument(emp1, "Document Title", "Document Content");
            sys.contributeToDocument(doc1, emp2, "Document Contribution");
            sys.viewDocument(doc1, emp3);
        }
        
        // show beenz after creating, contributing, and viewing documents.
        System.out.println(sys.viewEmployeeBeenz(emp1));
        System.out.println(sys.viewEmployeeBeenz(emp2));
        System.out.println(sys.viewEmployeeBeenz(emp3));
        System.out.println();

        // empty the employees beenz.
        sys.clearEmployeesBeenz(emp1);
        sys.clearEmployeesBeenz(emp2);
        sys.clearEmployeesBeenz(emp3);
        
        // setup some redeemable's to be purchased with beenz.
        Book book         = sys.createBookRedeemable("Book Author", "Book Title", 12, 100);
        CD cd             = sys.createCdRedeemable("CD Artist", "CD Title", 12, LocalDate.now(), 300);
        Vacation vacation = sys.createVacationRedeemable(Vacation.Destinations.PaidLeave, LocalDate.now(), LocalDate.now().plusDays(7), 1000);
                
        // attempt to purchase the redeemables.
        PurchaseOrder po1 = sys.redeemRedeemable(emp1, book);
        PurchaseOrder po2 = sys.redeemRedeemable(emp2, cd);
        PurchaseOrder po3 = sys.redeemRedeemable(emp3, vacation);
        System.out.println();
        
        // give beenz to be used to purchase some redeemables.
        sys.rewardEmployeeWithBeenz(emp1, 1500);
        
        // attempt to purchase the redeemables and print out their purchase orders, and an updated beenz count to show their deduction.
        po1 = sys.redeemRedeemable(emp1, book);
        System.out.println(sys.viewPurchaseOrderDetails(po1));
        System.out.println(sys.viewEmployeeBeenz(emp1));
        System.out.println();
        
        po2 = sys.redeemRedeemable(emp1, cd);
        System.out.println(sys.viewPurchaseOrderDetails(po2));
        System.out.println(sys.viewEmployeeBeenz(emp1));
        System.out.println();
        
        po3 = sys.redeemRedeemable(emp1, vacation);
        System.out.println(sys.viewPurchaseOrderDetails(po3));
        System.out.println(sys.viewEmployeeBeenz(emp1));
        
   }
}
