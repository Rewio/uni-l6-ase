package classes;

public class Book extends Redeemable {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final String author;
    private final String title;
    private final int numPages;
    
    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------
    
    public Book(String anAuthor, String aTitle, int aNumPages, int aCost) {
        author   = anAuthor;
        title    = aTitle;
        numPages = aNumPages;
        cost     = aCost;
    }
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Book: " + title + " by " + author + ". Has " + numPages + " pages, costing: " + cost + " beenz.";
    }

}
