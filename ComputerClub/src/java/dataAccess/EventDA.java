/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Event;

/**
 *
 * @author preloaded
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
            pstmt = conn.prepareCall("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eventList.add(new Event(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
                event = new Event(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
        String eventTime = event.getEventTime();
        String eventLocation = event.getEventLocation();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?,?,?,?)";

        try {
            selectRecord(eventID);

            if (rs.next()) {
                //ADD ERR MSG
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.setString(2, eventName);
                pstmt.setInt(3, eventType);
                pstmt.setString(4, eventDate);
                pstmt.setString(5, eventTime);
                pstmt.setString(6, eventLocation);
                pstmt.executeUpdate();

                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String eventID, String facultyID) throws Exception {

        try {
            selectRecord(eventID);

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
    public int updateRecord(Event event) throws Exception {
        int successInsert = 0;

        String eventID = event.getEventID();
        String eventName = event.getEventName();
        int eventType = event.getEventType();
        String eventDate = event.getEventDate();
        String eventTime = event.getEventTime();
        String eventLocation = event.getEventLocation();
        String queryStr = "UPDATE" + tableName + "SET EVENTNAME = ?, EVENTTYPE = ?, EVENTDATE = ?, EVENTTIME = ?, EVENTLOCATION = ? WHERE EVENTID = ?";

        try {
            selectRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventName);
                pstmt.setInt(2, eventType);
                pstmt.setString(3, eventDate);
                pstmt.setString(4, eventTime);
                pstmt.setString(5, eventLocation);
                pstmt.setString(6, eventID);
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
    public int deleteRecord(String eventID, String facultyID) throws Exception {
        int succesInsert = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTID = ?";

        try {
            selectRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
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
