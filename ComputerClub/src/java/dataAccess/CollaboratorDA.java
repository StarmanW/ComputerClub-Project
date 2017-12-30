package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Collaborator;

/**
 *
 * @author ChongJH
 */
public class CollaboratorDA {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    String tableName = " COLLABORATOR ";

    //No-arg constructor
    public CollaboratorDA() {
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
    public ArrayList<Collaborator> selectAllFaculty() {
        ArrayList<Collaborator> selectAllCollabList = new ArrayList<Collaborator>();

        try {
            pstmt = conn.prepareCall("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllCollabList.add(new Collaborator(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllCollabList;
    }

//Select record method
    public Collaborator selectRecord(String facultyID) {
        Collaborator collaborator = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE COLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, facultyID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                collaborator = new Collaborator(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return collaborator;
    }

    //Create method
    public int createRecord(Collaborator collaborator) throws Exception {
        int successInsert = 0;
        String collabID = collaborator.getColabID();
        String collabName = collaborator.getColabName();
        int collabType = collaborator.getColabType();
        String collabContact = collaborator.getCollabContact();
        String collabEmail = collaborator.getCollabEmail();
        String additionalNotes = collaborator.getAdditionalNotes();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?,?,?,?)";

        try {
            selectRecord(collabID);

            if (rs.next()) {
                //ADD ERR MSG
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, collabID);
                pstmt.setString(2, collabName);
                pstmt.setInt(3, collabType);
                pstmt.setString(4, collabContact);
                pstmt.setString(5, collabEmail);
                pstmt.setString(6, additionalNotes);
                pstmt.executeUpdate();

                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String collabID) {

        try {
            selectRecord(collabID);

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
    public int updateRecord(Collaborator collaborator) throws Exception {
        int successInsert = 0;

        String collabID = collaborator.getColabID();
        String collabName = collaborator.getColabName();
        int collabType = collaborator.getColabType();
        String collabContact = collaborator.getCollabContact();
        String collabEmail = collaborator.getCollabEmail();
        String additionalNotes = collaborator.getAdditionalNotes();
        String queryStr = "UPDATE" + tableName + "SET COLLABNAME = ?, COLLABTYPE = ?, COLLABCONTACT = ?, COLLABEMAIL = ?, ADDITIONALNOTES = ? WHERE COLLABID = ?";

        try {
            selectRecord(collabID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, collabName);
                pstmt.setInt(2, collabType);
                pstmt.setString(3, collabContact);
                pstmt.setString(4, collabEmail);
                pstmt.setString(5,additionalNotes);
                pstmt.setString(6, collabID);
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
    public int deleteRecord(String collabID) throws Exception {
        int succesInsert = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE COLLABID = ?";

        try {
            selectRecord(collabID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, collabID);
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
