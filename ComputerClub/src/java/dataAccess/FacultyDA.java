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

    //No-arg constructor
    public FacultyDA() {
        initDBConnection();
    }

    //Method to initialize database connection
    private final void initDBConnection() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbUser);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Method to retrieve a specific faculty
    public Faculty retrieveFaculty(String facultyCode) {
        Faculty faculty = null;
        
        try {
            pstmt = conn.prepareCall("SELECT * FROM FACULTY WHERE FACULTYCODE = ?");
            pstmt.setString(1, facultyCode);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                faculty = new Faculty(rs.getString(1), rs.getString(2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return faculty; 
    }
    
    //Method to retrieve all records
    public ArrayList<Faculty> retrieveAllFaculty() {
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
}
