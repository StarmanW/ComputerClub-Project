/**
 *
 * @author Kyj
 */
package model;

public class Collaborator {

    private String collabID;
    private String collabName;
    private char collabType;
    private String contactNo;
    private String email;

    public Collaborator() {

    }

    public Collaborator(String collabID, String collabName, char collabType, String contactNo, String email) {
        this.collabID = collabID;
        this.collabName = collabName;
        this.collabType = collabType;
        this.contactNo = contactNo;
        this.email = email;
    }

    //Getters
    public String getColabID() {
        return collabID;
    }

    public String getColabName() {
        return collabName;
    }

    public char getColabType() {
        return collabType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    //Setters
    public void setColabID(String collabID) {
        this.collabID = collabID;
    }

    public void setColabName(String collabName) {
        this.collabName = collabName;
    }

    public void setColabType(char collabType) {
        this.collabType = collabType;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
