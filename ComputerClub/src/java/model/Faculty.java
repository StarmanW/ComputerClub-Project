/**
 *
 * @author Kyj
 */
package model;

public class Faculty {

    private String facultyCode;
    private String facultyName;

    public Faculty() {

    }

    public Faculty(String facultyCode, String facultyName) {
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
    }

    //Getters
    public String getFacultyCode() {
        return facultyCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    //Setters
    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
