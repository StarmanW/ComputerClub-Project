package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Faculty;

/**
 *
 * @author StarmanW
 */
public class FacultyDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    String tableName = " faculty ";

    //No-arg constructor
    public FacultyDA() {
        initDBConnection();
    }

    //Method to initialize database connection
    private final void initDBConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to retrieve all records
    public ArrayList<Faculty> selectAllFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();

        try {
            pstmt = conn.prepareCall("SELECT * FROM FACULTY");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                faculty.add(new Faculty(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return faculty;
    }

    //Method to retrieve a specific faculty
    public Faculty selectFaculty(String facultyID) {
        return (Faculty) selectRecord(facultyID);
    }

    //Select record method
    public ResultSet selectRecord(String facultyID) {
        ResultSet rs = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE FACULTYID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, facultyID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    //Create method
    public int createRecord(Faculty faculty) throws Exception {
        int successInsert = 0;
        String facultyID = faculty.getFacultyID();
        String facultyName = faculty.getFacultyName();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?)";
        ResultSet rs = selectRecord(facultyID);

        try {
            if (rs.next()) {
                //ADD ERR MSG
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyID);
                pstmt.setString(2, facultyName);
                pstmt.executeUpdate();

                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String facultyID) {
        ResultSet rs = selectRecord(facultyID);

        try {
            if (rs.next()) {
                //ADD RESPONSE
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Update method
    public int updateRecord(Faculty faculty) throws Exception {
        int successInsert = 0;

        String facultyID = faculty.getFacultyID();
        String facultyName = faculty.getFacultyName();
        String queryStr = "UPDATE" + tableName + "SET FACULTYNAME = ? WHERE FACULTYID = ?";
        ResultSet rs = selectRecord(facultyID);

        try {
            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyName);
                pstmt.setString(2, facultyID);
                pstmt.executeUpdate();

                successInsert = pstmt.executeUpdate();
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Delete method
    public int deleteRecord(String facultyID) throws Exception {
        int succesInsert = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE FACULTYID = ?";
        ResultSet rs = selectRecord(facultyID);

        try {
            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyID);
                pstmt.executeUpdate();

                succesInsert = pstmt.executeUpdate();
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return succesInsert;
    }
}
