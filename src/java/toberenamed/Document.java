package toberenamed;

import interfaces.IDocument;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class Document implements IDocument {

  //----------------------------------------------------------------------
  // Private Fields:
  //----------------------------------------------------------------------

  private int id;
  private String title;
  private String author; // TODO: implement author.
  private List<Employee> contributors;
  private LocalDate dateCreated;
  private String content;
  
  //----------------------------------------------------------------------
  // Constructors:
  //----------------------------------------------------------------------
  
  // required to be flagged as stateless.
  protected Document() {}
  
  private Document(String aTitle, String aAuthor, String aContent) {
    id           = Unique.getUniqueId();
    title        = aTitle;
    author       = aAuthor;
    contributors = new ArrayList<Employee>();
    dateCreated  = LocalDate.now();
    content      = aContent;
  }
  
}
