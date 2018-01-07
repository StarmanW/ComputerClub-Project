package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Event;

/**
 *
 * @author ChongJH
 */
public class EventDA {
    //Data fields declaration

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private String tableName = " EVENT ";

    //No-arg constructor
    public EventDA() {
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

    //Method to retrieve all records
    public ArrayList<Event> selectAllEventsList() {
        ArrayList<Event> eventList = new ArrayList<Event>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eventList.add(new Event(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return eventList;
    }

    //Select record method
    public Event selectRecord(String eventID) {
        Event event = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                event = new Event(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return event;
    }

    //Create method
    public int createRecord(Event event) throws Exception {
        int successInsert = 0;
        String eventID = event.getEventID();
        String eventName = event.getEventName();
        int eventType = event.getEventType();
        String eventDate = event.getEventDate();
        String eventStartTime = event.getEventStartTime();
        String eventEndTime = event.getEventEndTime();
        String eventLocation = event.getEventLocation();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?,?,?,?,?)";

        try {
            retrieveRecord(eventID);

            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.setString(2, eventName);
                pstmt.setInt(3, eventType);
                pstmt.setString(4, eventDate);
                pstmt.setString(5, eventStartTime);
                pstmt.setString(6, eventEndTime);
                pstmt.setString(7, eventLocation);
                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String eventID) throws Exception {
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
    public int updateRecord(Event event) throws Exception {
        int successUpdate = 0;

        String eventID = event.getEventID();
        String eventName = event.getEventName();
        int eventType = event.getEventType();
        String eventDate = event.getEventDate();
        String eventStartTime = event.getEventStartTime();
        String eventEndTime = event.getEventEndTime();
        String eventLocation = event.getEventLocation();
        String queryStr = "UPDATE" + tableName + "SET EVENTNAME = ?, EVENTTYPE = ?, EVENTDATE = ?, EVENTSTARTTIME = ?, EVENTENDTIME = ?, EVENTLOCATION = ? WHERE EVENTID = ?";

        try {
            retrieveRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventName);
                pstmt.setInt(2, eventType);
                pstmt.setString(3, eventDate);
                pstmt.setString(4, eventStartTime);
                pstmt.setString(5, eventEndTime);
                pstmt.setString(6, eventLocation);
                pstmt.setString(7, eventID);
                pstmt.executeUpdate();
                successUpdate = 1;
            } else {
                successUpdate = 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Delete method
    public int deleteRecord(String eventID) throws Exception {
        int successDelete = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTID = ?";

        try {
            retrieveRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                successDelete = pstmt.executeUpdate();
            } else {
                //ADD INVALID RESPONSE
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successDelete;
    }
}
