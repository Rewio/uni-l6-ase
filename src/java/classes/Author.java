package classes;

public class Author extends Unique {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private final Employee author;

    //----------------------------------------------------------------------
    // Constructor:
    //----------------------------------------------------------------------
    
    public Author(Employee theAuthor) {
        author = theAuthor;
    }

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public String getName() {
        return author.getName();
    }
    
    public String getInitials() {
        return author.getInitials();
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + " - " + getInitials();
    }

}
