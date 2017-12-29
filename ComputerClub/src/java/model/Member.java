/**
 *
 * @author Kyj
 */
package model;

public class Member {

    private String studID;
    private Programme programme;
    private Name studName;
    private String email;
    private String contactNo;
    private String ic;
    private String password;
    private char gender;
    private boolean membershipFeeStatus;
    private int position;
    private String academicYear;

    public Member() {

    }

    public Member(String studID, Programme programme, Name studName, String email, String contactNo, String ic, String password, char gender, boolean membershipFeeStatus, int position, String academicYear) {
        this.studID = studID;
        this.programme = programme;
        this.studName = studName;
        this.email = email;
        this.contactNo = contactNo;
        this.ic = ic;
        this.password = password;
        this.gender = gender;
        this.membershipFeeStatus = membershipFeeStatus;
        this.position = position;
        this.academicYear = academicYear;
    }

    //Getters
    public String getStudID() {
        return studID;
    }

    public Programme getProgramme() {
        return programme;
    }

    public Name getStudName() {
        return studName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getIc() {
        return ic;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
        return gender;
    }

    public boolean isMembershipFeeStatus() {
        return membershipFeeStatus;
    }

    public int getPosition() {
        return position;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    //Setters
    public void setStudID(String studID) {
        this.studID = studID;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public void setStudName(Name studName) {
        this.studName = studName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setMembershipFeeStatus(boolean membershipFeeStatus) {
        this.membershipFeeStatus = membershipFeeStatus;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

}
