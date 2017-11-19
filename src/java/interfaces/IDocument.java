package interfaces;

import classes.Employee;

public interface IDocument {
    
    public void contributeToDocument(Employee contributor, String contribution);
    public String viewDocument(Employee viewer);
    public String viewContributors();

}
