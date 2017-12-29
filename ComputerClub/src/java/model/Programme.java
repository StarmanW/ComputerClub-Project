/**
 *
 * @author Kyj
 */
package model;

public class Programme {

    private String progCode;
    private String progName;
    private Faculty faculty;

    public Programme() {

    }

    public Programme(String progCode, String progName, Faculty faculty) {
        this.progCode = progCode;
        this.progName = progName;
        this.faculty = faculty;
    }

    //Getters
    public String getProgCode() {
        return progCode;
    }

    public String getProgName() {
        return progName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    //Setters
    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
