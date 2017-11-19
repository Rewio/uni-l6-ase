package classes;

public abstract class Unique {
    
    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private static int counter = 0;
    private final int id = ++counter;
    
    //----------------------------------------------------------------------
    // Protected Methods:
    //----------------------------------------------------------------------
    
    protected int getId() {
        return id;
    }
    
}
