package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Member;
import model.Name;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class MemberDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private final String tableName = " MEMBERS ";
    private ProgrammeDA programmeDA;

    //No-arg constructor
    public MemberDA() {
        initDBConnection();
        programmeDA = new ProgrammeDA();
    }

    //Method to initialize database connection
    private final void initDBConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to select a specific record
    public Member selectRecord(String studID) {
        Member member = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName + "WHERE MEMBERID = ?");
            pstmt.setString(1, studID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member(rs.getString(1), programmeDA.selectProgramme(rs.getString(2)),
                                    new Name(rs.getString(3), rs.getString(4)), rs.getString(5), rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8).charAt(0),
                                    rs.getBoolean(9),
                                    rs.getInt(10),
                                    rs.getString(11)
                                    );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return member;
    }
    
    //Method to find a specific record - ONLY used to check for duplication 
    private void findRecord(String studID) {
        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName + "WHERE MEMBERID = ?");
            pstmt.setString(1, studID);
            rs = pstmt.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to create new recored
    public int createRecord(Member member) {
        int successInsert = 0;

        try {
            findRecord(member.getStudID());
            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement("INSERT INTO" + tableName + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, member.getStudID());
                pstmt.setString(2, member.getProgramme().getProgID());
                pstmt.setString(3, member.getStudName().getFirstName());
                pstmt.setString(4, member.getStudName().getLastName());
                pstmt.setString(5, member.getStudEmail());
                pstmt.setString(6, member.getStudContact());
                pstmt.setString(7, member.getIc());
                pstmt.setString(8, String.valueOf(member.getGender()));
                pstmt.setBoolean(9, member.isMembershipFeeStatus());
                pstmt.setInt(10, member.getPosition());
                pstmt.setString(11, member.getAcademicYear());
                successInsert = pstmt.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Method to delete a record
    public int deleteRecord(Member member) {
        int successDelete = 0;
        try {
            findRecord(member.getStudID());
            if (rs.next()) {
                pstmt = conn.prepareStatement("DELETE FROM" + tableName + "WHERE MEMBERID = ?");
                pstmt.setString(1, member.getStudID());
                successDelete = pstmt.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return successDelete;
    }

    //Method to update a record
    public int updateRecord(Member member) {
        int successUpdate = 0;

        try {
            findRecord(member.getStudID());
            if (rs.next()) {
                pstmt = conn.prepareStatement("UPDATE" + tableName + "SET PROGID = ?, FIRSTNAME = ?, LASTNAME = ?, STUDEMAIL = ?, STUDCONTACT = ?, ICNUM = ?, GENDER = ?, MEMFEESTATS = ?, POSITION = ?, ACADEMICYEAR = ? WHERE MEMBERID = ?");
                pstmt.setString(1, member.getProgramme().getProgID());
                pstmt.setString(2, member.getStudName().getFirstName());
                pstmt.setString(3, member.getStudName().getLastName());
                pstmt.setString(4, member.getStudEmail());
                pstmt.setString(5, member.getStudContact());
                pstmt.setString(6, member.getIc());
                pstmt.setString(7, String.valueOf(member.getGender()));
                pstmt.setBoolean(8, member.isMembershipFeeStatus());
                pstmt.setInt(9, member.getPosition());
                pstmt.setString(10, member.getAcademicYear());
                pstmt.setString(11, member.getStudID());
                successUpdate = pstmt.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Method to select all records
    public ArrayList<Member> selectAllMembersList() {
        ArrayList<Member> selectAllMembersList = new ArrayList<Member>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllMembersList.add(new Member(rs.getString(1), programmeDA.selectRecord(rs.getString(2)),
                                         new Name(rs.getString(3), rs.getString(4)), rs.getString(5), rs.getString(6),
                                         rs.getString(7),
                                         rs.getString(8).charAt(0),
                                         rs.getBoolean(9),
                                         rs.getInt(10),
                                         rs.getString(11))
                                         );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllMembersList;
    }
}
