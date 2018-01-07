package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Faculty;

/**
 *
 * @author Samuel Wong Kim Foong
 */
public class FacultyDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    String tableName = " FACULTY ";

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
        ArrayList<Faculty> selectAllFacultyList = new ArrayList<Faculty>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllFacultyList.add(new Faculty(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllFacultyList;
    }

    //Select record method
    public Faculty selectRecord(String facultyID) {
        Faculty faculty = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE FACULTYID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, facultyID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                faculty = new Faculty(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return faculty;
    }

    //Create method
    public int createRecord(Faculty faculty) throws Exception {
        int successInsert = 0;
        String facultyID = faculty.getFacultyID();
        String facultyName = faculty.getFacultyName();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?)";

        try {
            selectRecord(facultyID);

            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyID);
                pstmt.setString(2, facultyName);
                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String facultyID) throws Exception {
        String queryStr = "SELECT * FROM" + tableName + "WHERE FACULTYID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, facultyID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Update method
    public int updateRecord(Faculty faculty) throws Exception {
        int successUpdate = 0;

        String facultyID = faculty.getFacultyID();
        String facultyName = faculty.getFacultyName();
        String queryStr = "UPDATE" + tableName + "SET FACULTYNAME = ? WHERE FACULTYID = ?";

        try {
            selectRecord(facultyID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyName);
                pstmt.setString(2, facultyID);
                successUpdate = pstmt.executeUpdate();
            } else {
                successUpdate = -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Delete method
    public int deleteRecord(String facultyID) throws Exception {
        int succesDelete = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE FACULTYID = ?";

        try {
            selectRecord(facultyID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, facultyID);
                succesDelete = pstmt.executeUpdate();
            } else {
                succesDelete = -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return succesDelete;
    }
}
