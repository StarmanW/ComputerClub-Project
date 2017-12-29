/**
 *
 * @author Kyj
 */
package model;

public class Collaborator {

    private String colabID;
    private String colabName;
    private char colabType;
    private String contactNo;
    private String email;

    public Collaborator() {

    }

    public Collaborator(String colabID, String colabName, char colabType, String contactNo, String email) {
        this.colabID = colabID;
        this.colabName = colabName;
        this.colabType = colabType;
        this.contactNo = contactNo;
        this.email = email;
    }

    //Getters
    public String getColabID() {
        return colabID;
    }

    public String getColabName() {
        return colabName;
    }

    public char getColabType() {
        return colabType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    //Setters
    public void setColabID(String colabID) {
        this.colabID = colabID;
    }

    public void setColabName(String colabName) {
        this.colabName = colabName;
    }

    public void setColabType(char colabType) {
        this.colabType = colabType;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
