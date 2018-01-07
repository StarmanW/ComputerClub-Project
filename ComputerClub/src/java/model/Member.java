/**
 *
 * @author Kyj
 */
package model;

public class Member {

    private String studID;
    private Programme programme;
    private Name studName;
    private String studEmail;
    private String studContact;
    private String ic;
    private char gender;
    private boolean membershipFeeStatus;
    private int position;
    private String academicYear;

    public Member() {

    }

    public Member(String studID, Programme programme, Name studName, String studEmail, String studContact, String ic, char gender, boolean membershipFeeStatus, int position, String academicYear) {
        this.studID = studID;
        this.programme = programme;
        this.studName = studName;
        this.studEmail = studEmail;
        this.studContact = studContact;
        this.ic = ic;
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

    public String getStudEmail() {
        return studEmail;
    }

    public String getStudContact() {
        return studContact;
    }

    public String getIc() {
        return ic;
    }

    public char getGender() {
        return gender;
    }

    public boolean isMembershipFeeStatus() {
        return membershipFeeStatus;
    }

    public String getMembershipFeeStatusString() {
        if (this.membershipFeeStatus) {
            return "Paid";
        } else {
            return "Pending";
        }
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        String positionTitle = null;
        switch (position) {
            case 1:
                positionTitle = "Member";
                break;
            case 2:
                positionTitle = "Treasurer";
                break;
            case 3:
                positionTitle = "Secretary";
                break;
            case 4:
                positionTitle = "Vice President";
                break;
            case 5:
                positionTitle = "President";
                break;
            default:
                break;
        }
        return positionTitle;
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

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public void setStudContact(String studContact) {
        this.studContact = studContact;
    }

    public void setIc(String ic) {
        this.ic = ic;
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
