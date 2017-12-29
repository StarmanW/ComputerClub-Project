package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Programme;

/**
 *
 * @author StarmanW
 */
public class ProgrammeDA {

    //Data fields declaration
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private FacultyDA facultyDA;
    private String tableName = " programme ";

    //No-arg constructor
    public ProgrammeDA() {
        initDBConnection();
        facultyDA = new FacultyDA();
    }

    //Method to initialize database connection
    private final void initDBConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbUser);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to retrieve a specific programme
    public Programme retrieveProgramme(String progCode) {
        Programme programme = null;
        try {
            pstmt = conn.prepareCall("SELECT * FROM PROGRAMME WHERE PROGCODE = ?");
            pstmt.setString(1, progCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                programme = new Programme(rs.getString(1), rs.getString(2), facultyDA.retrieveFaculty(rs.getString(3)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return programme;
    }

    //Method to retrieve all records
    public ArrayList<Programme> retrieveAllProgrammes() {
        ArrayList<Programme> programme = new ArrayList<Programme>();

        try {
            pstmt = conn.prepareCall("SELECT * FROM PROGRAMME");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                programme.add(new Programme(rs.getString(1), rs.getString(2), facultyDA.retrieveFaculty(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return programme;
    }

    //Select record method
    public ResultSet selectRecord(String progID, String facultyID/*ADD FROM SERVLET*/) {
        ResultSet rs = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE PROGID = ? AND FACULTYID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, progID);
            pstmt.setString(2, facultyID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            //ADD ERR RESPONSE
        }

        return rs;
    }

    //Create method
    public void createRecord() {
        String progID = null; //ADD ID FROM SERVLET
        String progName = null; //ADD NAME FROM SERVLET
        String facultyID = null; //ADD NAME FROM SERVLET
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?)";
        ResultSet rs = selectRecord(progID, facultyID);

        try {
            if (rs.next()) {
                //ADD ERR MSG
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, progID);
                pstmt.setString(2, progName);
                pstmt.setString(3, facultyID);
                pstmt.executeUpdate();

                //ADD SUCCESS RESPONSE
            }
        } catch (SQLException ex) {
            //ADD ERR RESPONSE
        }
    }

    //Retrieve method
    public void retrieveRecord() {
        String progID = null; //ADD ID FROM SERVLET
        String facultyID = null; //ADD NAME FROM SERVLET
        ResultSet rs = selectRecord(progID, facultyID);

        try {
            if (rs.next()) {
                //ADD RESPONSE
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            //ADD ERR RESPONSE
        }
    }

    //Update method
    public void updateRecord() {
        String progID = null; //ADD ID FROM SERVLET
        String progName = null; //ADD NAME FROM SERVLET
        String facultyID = null; //ADD NAME FROM SERVLET
        String queryStr = "UPDATE" + tableName + "SET PROGNAME = ? WHERE PROGID = ? AND FACULTYID = ?";
        ResultSet rs = selectRecord(progID, facultyID);

        try {
            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, progName);
                pstmt.setString(2, progID);
                pstmt.setString(3, facultyID);
                pstmt.executeUpdate();
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            //ADD ERR RESPONSE
        }
    }

    //Delete method
    public void deleteRecord() {
        String progID = null; //ADD ID FROM SERVLET
        String facultyID = null; //ADD NAME FROM SERVLET
        String queryStr = "DELETE FROM" + tableName + "WHERE PROGID = ? AND FACULTYID = ?";
        ResultSet rs = selectRecord(progID, facultyID);

        try {
            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, progID);
                pstmt.setString(2, facultyID);
                pstmt.executeUpdate();
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            //ADD ERR RESPONSE
        }
    }
}
