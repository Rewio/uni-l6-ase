package testing;

import toberenamed.*;

public class SystemClass {

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public static void main(String[] args) {
        
        Employee emp1 = new Employee("Andrew", "Foster");
        Document doc1 = Document.createDocument(emp1, "Document Title", "This is the content of the document.");
        System.out.println(doc1);
        
        Employee emp2 = new Employee("Bob", "Dillon");
        doc1.contributeToDocument(emp2, "Contribution.");
        doc1.contributeToDocument(emp2, "Not a contribution at all!");

        System.out.println(doc1);
        
        doc1.contributeToDocument(emp2, "This is a terrible contribution!");
        
        System.out.println(doc1.viewContributors());
        System.out.println(doc1);
        
        Beenz b = emp1.getBeenz();
        System.out.println(b);
        b.addBeenz(50000);                  
        System.out.println(b);
   }
    
}
