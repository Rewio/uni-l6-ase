package classes;

import classes.Document;
import classes.Employee;
import java.time.LocalDate;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class DocumentTest {

    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------
    
    private final int STARTING_CONTRIBUTORS = 0;

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final String employeeForename = "Andrew";
    private final String employeeSurname = "Foster";
    private final String documentTitle = "Test Title";
    private final String documentContent = "Test Content";

    private final Employee emp1 = new Employee(employeeForename, employeeSurname);
    private final Document doc1 = Document.createDocument(emp1, documentTitle, documentContent);

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public DocumentTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Test
    public void testCreateDocument() throws Exception {

        // data to be tested.
        Document result = Document.createDocument(emp1, documentTitle, documentContent);

        // test.
        assertEquals(documentTitle, result.getTitle());
        assertEquals(emp1.getName(), result.getAuthor().getName());
        assertEquals(LocalDate.now().toString(), result.getDateCreated());
        assertEquals(documentContent, result.getContent());
        assertEquals(STARTING_CONTRIBUTORS, result.getNumContributors());
    }

    @Test
    public void testContributeToDocument() throws Exception {

        // data to be tested.
        int numContributors = doc1.getNumContributors();
        int newContributors = numContributors + 1;

        // add a contributor.
        doc1.contributeToDocument(emp1, "Test Contribution");

        // test.
        assertEquals(newContributors, doc1.getNumContributors());
    }

    @Test
    public void testViewDocument() throws Exception {

        // data to be tested.
        String expResult = documentContent;
        String result    = doc1.getContent();

        // test.
        assertEquals(expResult, result);
    }

    @Test
    public void testViewContributors() throws Exception {

        // data to be tested.
        int expResult = STARTING_CONTRIBUTORS;
        int actResult = doc1.getNumContributors();

        // test.
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testRewardBeenz() throws Exception {
        
        // data to be tested.
        int startingBeenz = emp1.getBeenz().getNumBeenz();
        
        // Create a new document 100 times, statistically should be rewarded for this.
        for (int i = 0; i < 100; i++) {
           Document newDoc = Document.createDocument(emp1, "Document", "Content");
        }
        
        int currentBeenz = emp1.getBeenz().getNumBeenz();
        
        // test.
        assertNotEquals(startingBeenz, currentBeenz);
    }

}
