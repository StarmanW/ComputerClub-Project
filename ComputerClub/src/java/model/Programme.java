/**
 *
 * @author Shirlina Koo Yung Ja
 */
package model;

public class Programme {

    private String progID;
    private String progName;
    private Faculty faculty;

    public Programme() {

    }

    public Programme(String progID, String progName, Faculty faculty) {
        this.progID = progID;
        this.progName = progName;
        this.faculty = faculty;
    }

    //Getters
    public String getProgID() {
        return progID;
    }

    public String getProgName() {
        return progName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    //Setters
    public void setProgID(String progID) {
        this.progID = progID;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
