package classes;

import java.time.LocalDate;

public class CD extends Redeemable {

    //----------------------------------------------------------------------
    // Private Fields:
    //----------------------------------------------------------------------

    private final String artist;
    private final String title;
    private final int numTracks;
    private final LocalDate releaseDate;
    
    //----------------------------------------------------------------------
    // Constructors:
    //----------------------------------------------------------------------

    public CD(String anArtist, String aTitle, int aNumTracks, LocalDate aReleaseDate, int aCost) {
        artist      = anArtist;
        title       = aTitle;
        numTracks   = aNumTracks;
        releaseDate = aReleaseDate;
        cost        = aCost;
    }
    
    //----------------------------------------------------------------------
    // Public Methods:
    //----------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "CD: " + title + " by " + artist + ". Has " + numTracks + " released " + releaseDate.toString() + ". Cost: " + cost + " beenz.";
    }
    
}
