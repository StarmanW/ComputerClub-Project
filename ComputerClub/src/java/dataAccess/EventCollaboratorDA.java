package dataAccess;

import java.sql.*;
import java.util.ArrayList;
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
        eventDA = new EventDA();
        collaboratorDA = new CollaboratorDA();
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
    public ArrayList<EventCollaborator> selectAllEventCollabList() {
        ArrayList<EventCollaborator> eventCollabList = new ArrayList<EventCollaborator>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eventCollabList.add(new EventCollaborator(rs.getString(1), eventDA.selectRecord(rs.getString(2)), collaboratorDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eventCollabList;
    }

    //Method to retrieve all records for a specific event
    public ArrayList<EventCollaborator> selectAllEventCollabByEventID(String eventID) {
        ArrayList<EventCollaborator> eventCollabList = new ArrayList<EventCollaborator>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName + "WHERE EVENTID = ?");
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eventCollabList.add(new EventCollaborator(rs.getString(1), eventDA.selectRecord(rs.getString(2)), collaboratorDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eventCollabList;
    }
    
    //Select record method
    public EventCollaborator selectRecord(String eventID, String collabID) {
        EventCollaborator eventCollaborator = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTID = ? AND COLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            pstmt.setString(2, collabID);
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
    public int createRecord(EventCollaborator eventCollaborator) throws Exception {
        int successInsert = 0;
        String eventCollabID = eventCollaborator.getEventColladID();
        String eventID = eventCollaborator.getEvent().getEventID();
        String collabID = eventCollaborator.getCollaborator().getCollabID();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?)";

        try {
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
    private void findRecord(String eventID) {
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Update method
    public int updateRecord(EventCollaborator eventCollaborator) throws Exception {
        int successUpdate = 0;

        String eventCollabID = eventCollaborator.getEventColladID();
        String eventID = eventCollaborator.getEvent().getEventID();
        String collabID = eventCollaborator.getCollaborator().getCollabID();
        String queryStr = "UPDATE" + tableName + "SET EVENTID = ?, COLLABID = ? WHERE EVENTCOLLABID = ?";

        try {
            findRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.setString(2, collabID);
                pstmt.setString(3, eventCollabID);
                successUpdate = pstmt.executeUpdate();
            } else {
                successUpdate = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Delete method by Event ID - used for deleting an event
    public boolean deleteRecordByEventID(String eventID) throws Exception {
        boolean successDelete = false;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTID = ?";

        try {
            findRecord(eventID);
            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.executeUpdate();
                successDelete = true;
            } else {
                successDelete = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successDelete;
    }

    //Delete method by Collaborator ID - used when deleting a collaborator
    public boolean deleteRecordByCollaboratorID(String collabID) throws Exception {
        boolean successDelete = false;

        String queryStr = "DELETE FROM" + tableName + "WHERE COLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, collabID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }

    //Delete method by Collaborator ID and Event ID - used when updating a specific event
    public boolean deleteRecordByCollabEventID(String eventID, String collabID) throws Exception {
        boolean successDelete = false;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTID = ? AND COLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            pstmt.setString(2, collabID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }

}
