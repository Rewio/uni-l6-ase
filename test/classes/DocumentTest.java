package classes;

import java.time.LocalDate;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class DocumentTest {

    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------
    
    private final int STARTING_CONTRIBUTORS = 0;
    
    private final String EMPLOYEE_FORENAME = "Andrew";
    private final String EMPLOYEE_SURNAME  = "Foster";
    private final String DOCUMENT_TITLE    = "Test Title";
    private final String DOCUMENT_CONTENT  = "Test Content";

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
 
    private Employee emp;
    private Document doc;

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public DocumentTest() {
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Before
    public void setUp() {
        emp = new Employee(EMPLOYEE_FORENAME, EMPLOYEE_SURNAME);
        doc = Document.createDocument(emp, DOCUMENT_TITLE, DOCUMENT_CONTENT);
    }
    
    @After
    public void tearDown() {
        doc = null;
        emp = null;
    }
    
    @Test
    public void testGetAuthorName() throws Exception {
        
        // setup expected and actual results, then test.
        String expResult = EMPLOYEE_FORENAME + " " + EMPLOYEE_SURNAME;
        String actResult = doc.getAuthor().getName();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testGetContent() throws Exception {
        
        // setup expected and actual results, then test.
        String expResult = DOCUMENT_CONTENT;
        String actResult = doc.getContent();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testGetDateCreated() throws Exception {
        
        // setup expected and actual results, then test.
        String expResult = LocalDate.now().toString();
        String actResult = doc.getDateCreated();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testGetNumContributors() throws Exception {
        
        // setup expected and actual results, then test.
        int expResult = STARTING_CONTRIBUTORS;
        int actResult = doc.getNumContributors();
        assertEquals(expResult, actResult);
        
        // contribute to document and test again.
        doc.contributeToDocument(emp, "contribution");
        expResult = STARTING_CONTRIBUTORS + 1;
        actResult = doc.getNumContributors();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testGetTitle() throws Exception {
        
        // setup expected and actual results, then test.
        String expResult = DOCUMENT_TITLE;
        String actResult = doc.getTitle();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testCreateDocument() throws Exception {

        // create a document with identical information as the one in setUp()
        Document testDoc = Document.createDocument(emp, DOCUMENT_TITLE, DOCUMENT_CONTENT);
        
        // test information. They logically wont be equal due to their unique ID, so this is a workaround.
        assertEquals(doc.getAuthor().getName(), testDoc.getAuthor().getName());
        assertEquals(doc.getContent(), testDoc.getContent());
        assertEquals(doc.getDateCreated(), testDoc.getDateCreated());
        assertEquals(doc.getNumContributors(), doc.getNumContributors());
        assertEquals(doc.getTitle(), testDoc.getTitle());
    }

    @Test
    public void testContributeToDocument() throws Exception {

        // get the current document content.
        String currentContent = doc.getContent();
        
        // contribute to the document.
        String contribution = "Contribution";
        doc.contributeToDocument(emp, contribution);
        
        // setup expected and actual results, then test.
        String expResult = currentContent + (" " + contribution + "(" + emp.getInitials() + ")");
        String actResult = doc.getContent();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testViewDocument() throws Exception {

        // setup expected and actual results, then test.
        String expResult = DOCUMENT_CONTENT;
        String actResult = doc.getContent();
        assertEquals(expResult, actResult);
    }

    @Test
    public void testViewContributors() throws Exception {

        // setup expected and actual results, then test.
        int expResult = STARTING_CONTRIBUTORS;
        int actResult = doc.getNumContributors();
        assertEquals(expResult, actResult);
    }
    
    @Test
    public void testRewardBeenz() throws Exception {
        
        // data to be tested.
        int startingBeenz = emp.getBeenz().getNumBeenz();
        
        // Create a new document 1000 times, statistically should be rewarded for this.
        for (int i = 0; i < 1000; i++) {
           Document newDoc = Document.createDocument(emp, "Document", "Content");
        }
        
        int currentBeenz = emp.getBeenz().getNumBeenz();
        
        // test.
        assertNotEquals(startingBeenz, currentBeenz);
    }

}
