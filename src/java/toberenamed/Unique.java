package toberenamed;

public class Unique {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------
    
    private static int counter = 0;

    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    public static int getUniqueId() {
        return ++counter;
    }

}
