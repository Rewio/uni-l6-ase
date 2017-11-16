package toberenamed;

import interfaces.IDocument;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class Document implements IDocument {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private int id;
    private String title;
    private Author author; // TODO: implement author.
    private Map<Employee, String> contributors;
    private LocalDate dateCreated;
    private String content;

    //----------------------------------------------------------------------
    // Getters and Setters:
    //----------------------------------------------------------------------
    
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getDateCreated() {
        return dateCreated.toString();
    }

    public String getContent() {
        return content;
    }

    public int getNumContributors() {
        return contributors.size();
    }

    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------
    
    // required to be flagged as stateless.
    protected Document() {
    }

    private Document(String aTitle, Author anAuthor, String aContent) {
        id = Unique.getUniqueId();
        title = aTitle;
        author = anAuthor;
        contributors = new HashMap<>();
        dateCreated = LocalDate.now();
        content = aContent;
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public static Document createDocument(Employee author, String documentTitle, String documentContent) {

        // if any required field is missing, return null.
        if (author == null || documentTitle.equals("") || documentContent.equals("")) {
            return null;
        }

        return new Document(documentTitle, new Author(author), documentContent);
    }

    @Override
    public void contributeToDocument(Employee contributor, String contribution) {

        // only add the contribution if there is something to contribute.
        if (contribution.equals("")) {
            return;
        }

        // add the contribution to the documents content, and the contributor to the contributors container.
        content += contribution + "(" + contributor.getEmployeeInitials() + ")";
        contributors.put(contributor, contribution);
    }

    @Override
    public String viewDocument() {
        return content;
    }

    @Override
    public String viewContributors() {

        if (contributors.isEmpty()) {
            return "No contributors.";
        }

        StringBuilder sb = new StringBuilder();
        for (Employee employee : contributors.keySet()) {
            sb.append(employee.getEmployeeInitials());
            sb.append(" - ");
            sb.append(contributors.get(employee));
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Title: " + title + " - Author: " + author + " - Num. Contributors: " + contributors.size() + " - Created: " + dateCreated + " Content: " + content;
    }

}
