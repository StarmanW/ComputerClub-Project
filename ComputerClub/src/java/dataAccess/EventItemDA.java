package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.EventItem;

/**
 *
 * @author ChongJH
 */
public class EventItemDA {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private EventDA eventDA;
    private ItemDA itemDA;
    String tableName = " EVENTITEM ";

    //No-arg constructor
    public EventItemDA() {
        initDBConnection();
        itemDA = new ItemDA();
        eventDA = new EventDA();
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
    public ArrayList<EventItem> selectAllEventItemList() {
        ArrayList<EventItem> selectAllEventItemList = new ArrayList<EventItem>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllEventItemList.add(new EventItem(rs.getString(1), eventDA.selectRecord(rs.getString(2)), itemDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllEventItemList;
    }

    
    //Method to retrieve all records for a specific event
    public ArrayList<EventItem> selectAllEventItemListByEventID(String eventID) {
        ArrayList<EventItem> selectAllEventItemList = new ArrayList<EventItem>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName + "WHERE EVENTID = ?");
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllEventItemList.add(new EventItem(rs.getString(1), eventDA.selectRecord(rs.getString(2)), itemDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllEventItemList;
    }

    //Select record method
    public EventItem selectRecord(String eventID) {
        EventItem eventItem = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                eventItem = new EventItem(rs.getString(1), eventDA.selectRecord(rs.getString(2)), itemDA.selectRecord(rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return eventItem;
    }

    //Create method
    public int createRecord(EventItem eventItem) throws Exception {
        int successInsert = 0;
        String eventItemID = eventItem.getEventItemID();
        String eventID = eventItem.getEvent().getEventID();
        String itemID = eventItem.getItem().getItemID();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?)";

        try {
            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventItemID);
                pstmt.setString(2, eventID);
                pstmt.setString(3, itemID);
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
    public int updateRecord(EventItem eventItem) throws Exception {
        int successUpdate = 0;

        String eventItemID = eventItem.getEventItemID();
        String eventID = eventItem.getEvent().getEventID();
        String itemID = eventItem.getItem().getItemID();
        String queryStr = "UPDATE" + tableName + "SET EVENTID = ?, ITEMID = ? WHERE EVENTITEMID = ?";

        try {
            findRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventID);
                pstmt.setString(2, itemID);
                pstmt.setString(3, eventItemID);
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

    //Delete method by Item ID - used when deleting a item
    public boolean deleteRecordByItemID(String itemID) throws Exception {
        boolean successDelete = false;

        String queryStr = "DELETE FROM" + tableName + "WHERE ITEMID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, itemID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }
    
    //Delete method by Item ID and Event ID - used when updating a specific event
    public boolean deleteRecordByItemID(String eventID, String itemID) throws Exception {
        boolean successDelete = false;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTID = ? AND ITEMID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventID);
            pstmt.setString(2, itemID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }
}
