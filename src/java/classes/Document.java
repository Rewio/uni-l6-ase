package classes;

import interfaces.IDocument;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;

@Stateless
public class Document extends Unique implements IDocument {
    
    //----------------------------------------------------------------------
    // Constants:
    //----------------------------------------------------------------------

    private static final int CREATION_REWARD_CHANCE = 50;
    private final int CONTRIBUTION_REWARD_CHANCE    = 20;
    private final int VIEW_REWARD_CHANCE            = 5;
    
    private static final int BEENZ_REWARD = 100;    
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private String title;
    private Author author; 
    private List<Employee> contributors;
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
        title = aTitle;
        author = anAuthor;
        contributors = new ArrayList<>();
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
        
        // if we should reward beenz, do so.
        if (shouldRewardBeenz(CREATION_REWARD_CHANCE)) {
            rewardBeenz(author);
        }

        return new Document(documentTitle, new Author(author), documentContent);
    }

    @Override
    public void contributeToDocument(Employee contributor, String contribution) {

        // only add the contribution if there is something to contribute.
        if (contribution.equals("")) {
            return;
        }
        
        // if we should reward beenz, do so.
        if (shouldRewardBeenz(CONTRIBUTION_REWARD_CHANCE)) {
            rewardBeenz(contributor);
        }

        // add the contribution to the documents content, and the contributor to the contributors container.
        content += " " + contribution + "(" + contributor.getInitials() + ")";
        contributors.add(contributor);
    }

    @Override
    public String viewDocument(Employee viewer) {
        
        // if we should reward beenz, do so.
        if (shouldRewardBeenz(VIEW_REWARD_CHANCE)) {
            rewardBeenz(viewer);
        }
        
        return content;
    }

    @Override
    public String viewContributors() {

        // if there are no contributors, return now and say so.
        if (contributors.isEmpty()) {
            return "No contributors.";
        }
        
        // build a string containing the name of all the contributors.
        StringBuilder sb = new StringBuilder();
        for (Employee contributor : contributors) {
            sb.append(contributor.getName());
            sb.append("\n");
        }
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return getId() + ": Title: " + title + " - Author: " + author + " - Num. Contributors: " + contributors.size() + " - Created: " + dateCreated + " Content: " + content;
    }
    
    //----------------------------------------------------------------------
    // Private Methods:
    //----------------------------------------------------------------------
    
    private static boolean shouldRewardBeenz(int rewardChance) {
        
        // generate a random number, if its greater than the reward chance, return true.
        Random random = new Random();
        return random.nextInt(100) > (100 - rewardChance);
    }

    private static void rewardBeenz(Employee rewardee) {
        rewardee.getBeenz().addBeenz(BEENZ_REWARD);
    }
    
}
