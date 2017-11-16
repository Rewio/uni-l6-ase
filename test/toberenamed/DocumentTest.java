package toberenamed;

import java.time.LocalDate;
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
        assertEquals(emp1.getEmployeeName(), result.getAuthor().getAuthorName());
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
        String result = doc1.getContent();

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

}
