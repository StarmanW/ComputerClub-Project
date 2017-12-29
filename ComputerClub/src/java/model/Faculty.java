/**
 *
 * @author Kyj
 */
package model;

public class Faculty {

    private String facultyID;
    private String facultyName;

    public Faculty() {

    }

    public Faculty(String facultyID, String facultyName) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
    }

    //Getters
    public String getFacultyID() {
        return facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    //Setters
    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
