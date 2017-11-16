package interfaces;

import toberenamed.Employee;

public interface IDocument {

    public void contributeToDocument(Employee contributor, String contribution);
    public String viewDocument();
    public String viewContributors();

}
