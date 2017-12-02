package testing;

import classes.*;
import java.time.LocalDate;

public class SystemClass {
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public Document createDocument(Employee theDocumentAuthor, String theDocumentsTitle, String theDocumentsContents) {
        return Document.createDocument(theDocumentAuthor, theDocumentsTitle, theDocumentsContents);
    }
    
    public void contributeToDocument(Document documentToContributeTo, Employee contributingEmployee, String documentContribution) {
        documentToContributeTo.contributeToDocument(contributingEmployee, documentContribution);
    }
    
    public void viewDocument(Document documentToView, Employee viewingEmployee) {
        documentToView.viewDocument(viewingEmployee);
    }

    public Employee createEmployee(String employeeForename, String employeeSurname) {
        return new Employee(employeeForename, employeeSurname);
    }
    
    public Beenz viewEmployeeBeenz(Employee employee) {
        return employee.getBeenz();
    }
    
    public void clearEmployeesBeenz(Employee employee) {
        employee.clearBeenz();
    }
    
    public void rewardEmployeeWithBeenz(Employee employee, int beenzReward) {
        employee.rewardBeenz(beenzReward);
    }
    
    public Book createBookRedeemable(String bookAuthor, String bookTitle, int bookPageCount, int bookRedeemCost) {
        return new Book(bookAuthor, bookTitle, bookPageCount, bookRedeemCost);
    }
    
    public CD createCdRedeemable(String cdArtist, String cdTitle, int cdTrackCount, LocalDate cdReleaseDate, int cdRedeemCost) {
        return new CD(cdArtist, cdTitle, cdTrackCount, cdReleaseDate, cdRedeemCost);
    }
    
    public Vacation createVacationRedeemable(Vacation.Destinations vacationDestination, LocalDate vacationFromDate, 
            LocalDate vacationToDate, int vacationRedeemCost) {
        return new Vacation(vacationDestination, vacationFromDate, vacationToDate, vacationRedeemCost);
    }
    
    public PurchaseOrder redeemRedeemable(Employee redeemingEmployee, Redeemable redeemedRedeemable) {
        return redeemingEmployee.redeemRedeemable(redeemedRedeemable);
    }
    
    public String viewPurchaseOrderDetails(PurchaseOrder purchaseOrder) {
        return purchaseOrder.viewPurchaseOrderDetails();
    }
    
}
