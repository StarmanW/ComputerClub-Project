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
    private String additionalNotes;

    public Collaborator() {

    }

    public Collaborator(String collabID, String collabName, int collabType, String collabContact, String collabEmail, String additionalNotes) {
        this.collabID = collabID;
        this.collabName = collabName;
        this.collabType = collabType;
        this.collabContact = collabContact;
        this.collabEmail = collabEmail;
        this.additionalNotes = additionalNotes;
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

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public String getCollabTypeString() {
        String collabTypeString = null;
        
        switch (collabType) {
            case 1:
                collabTypeString = "Company";
                break;
            case 2:
                collabTypeString = "Individual";
                break;
            default:
                break;
        }
        return collabTypeString;
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

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

}
