package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Collaborator;
import model.Event;
import model.EventCollaborator;

/**
 *
 * @author ChongJH
 */
public class EventCollaboratorDA {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private EventDA eventDA;
    private CollaboratorDA collaboratorDA;
    String tableName = " EVENTCOLLABORATOR ";

    //No-arg constructor
    public EventCollaboratorDA() {
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
    public ArrayList<EventCollaborator> selectAllCollaboratorList() {
        ArrayList<EventCollaborator> selectAllEventCollabList = new ArrayList<EventCollaborator>();

        try {
            pstmt = conn.prepareCall("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllEventCollabList.add(new EventCollaborator(rs.getString(1), eventDA.selectRecord(rs.getString(2)), collaboratorDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllEventCollabList;
    }

    //Select record method
    public EventCollaborator selectRecord(String eventCollabID) {
        EventCollaborator eventCollaborator = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTCOLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventCollabID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                eventCollaborator = new EventCollaborator(rs.getString(1), eventDA.selectRecord(rs.getString(2)), collaboratorDA.selectRecord(rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return eventCollaborator;
    }

    //Create method
    public int createRecord(EventCollaborator eventCollaborator, Event event, Collaborator collaborator) throws Exception {
        int successInsert = 0;
        String eventCollabID = eventCollaborator.getEventColladID();
        String eventID = event.getEventID();
        String collabID = collaborator.getCollabID();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?)";

        try {
            findRecord(eventCollabID);
            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventCollabID);
                pstmt.setString(2, eventID);
                pstmt.setString(3, collabID);
                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    private void findRecord(String eventCollabID) {
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTCOLLABID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventCollabID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Update method
    public int updateRecord(EventCollaborator eventCollaborator, Event event, Collaborator collaborator) throws Exception {
        int successUpdate = 0;

        String eventCollabID = eventCollaborator.getEventColladID();
        String eventID = event.getEventID();
        String collabID = collaborator.getCollabID();
        String queryStr = "UPDATE" + tableName + "SET EVENTID = ?, COLLABID = ? WHERE EVENTCOLLABID = ?";

        try {
            findRecord(eventCollabID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.setString(2, collabID);
                pstmt.setString(3, eventCollabID);
                pstmt.executeUpdate();

                successUpdate = pstmt.executeUpdate();
            } else {
                successUpdate = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Delete method
    public int deleteRecord(String eventCollabID) throws Exception {
        int successDelete = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTCOLLABID = ?";

        try {
            findRecord(eventCollabID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventCollabID);
                pstmt.executeUpdate();
                successDelete = pstmt.executeUpdate();
            } else {
                successDelete = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successDelete;
    }

}
