/**
 *
 * @author Kyj
 */
package model;

public class Collaborator {

    private String collabID;
    private String collabName;
    private int collabType;
    private String collabContact;
    private String collabEmail;

    public Collaborator() {

    }

    public Collaborator(String collabID, String collabName, char collabType, String collabContact, String collabEmail) {
        this.collabID = collabID;
        this.collabName = collabName;
        this.collabType = collabType;
        this.collabContact = collabContact;
        this.collabEmail = collabEmail;
    }

    //Getters
    public String getColabID() {
        return collabID;
    }

    public String getColabName() {
        return collabName;
    }

    public int getColabType() {
        return collabType;
    }

    public String getCollabContact() {
        return collabContact;
    }

    public String getCollabEmail() {
        return collabEmail;
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

    public void setCollabContact(String collabContact) {
        this.collabContact = collabContact;
    }

    public void setCollabEmail(String collabEmail) {
        this.collabEmail = collabEmail;
    }

}
