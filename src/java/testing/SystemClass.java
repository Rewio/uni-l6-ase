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
public class SystemClass {

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public static void main(String[] args) {
        
        Document doc1;
        
        // setup the employee(s) and document(s) to be manipulated.
        Employee emp1 = new Employee("Andrew", "Foster");
        Employee emp2 = new Employee("John", "Doe");
        Employee emp3 = new Employee("Jane", "Doe");
        
        // show beenz before creating, contributing, and viewing documents.
        System.out.println(emp1.getBeenz());
        System.out.println(emp2.getBeenz());
        System.out.println(emp3.getBeenz());
        System.out.println();
        
        // repeatidly create, contribute to, and read documents to get beenz rewards.
        for (int i = 0; i < 100; i++) {
            doc1 = Document.createDocument(emp1, "Document Title", "Document Content");
            doc1.contributeToDocument(emp2, "Document Contribution");
            doc1.viewDocument(emp3);
        }
        
        // show beenz after creating, contributing, and viewing documents.
        System.out.println(emp1.getBeenz());
        System.out.println(emp2.getBeenz());
        System.out.println(emp3.getBeenz());
        System.out.println();

        // empty the employees beenz.
        emp1.clearBeenz();
        emp2.clearBeenz();
        emp3.clearBeenz();
        
        // setup some redeemable's to be purchased with beenz.
        Book book         = new Book("Book Author", "Book Title", 12, 100);
        CD cd             = new CD("CD Artist", "CD Title", 12, LocalDate.now(), 300);
        Vacation vacation = new Vacation(Vacation.Destinations.PaidLeave, LocalDate.now(), LocalDate.now().plusDays(7), 1000);
                
        // attempt to purchase the redeemables.
        PurchaseOrder po1 = book.redeem(emp1);
        PurchaseOrder po2 = cd.redeem(emp2);
        PurchaseOrder po3 = vacation.redeem(emp3);
        System.out.println();
        
        // give beenz to be used to purchase some redeemables.
        emp1.rewardBeenz(1500);
        
        // attempt to purchase the redeemables and print out their purchase orders, and an updated beenz count to show their deduction.
        po1 = book.redeem(emp1);
        System.out.println(po1.viewPurchaseOrderDetails());
        System.out.println(emp1.getBeenz());
        System.out.println();
        
        po2 = cd.redeem(emp1);
        System.out.println(po2.viewPurchaseOrderDetails());
        System.out.println(emp1.getBeenz());
        System.out.println();
        
        po3 = vacation.redeem(emp1);
        System.out.println(po3.viewPurchaseOrderDetails());
        System.out.println(emp1.getBeenz());
        
   }
}
