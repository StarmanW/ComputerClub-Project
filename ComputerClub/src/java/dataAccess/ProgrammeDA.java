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
}
