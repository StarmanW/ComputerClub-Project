package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.EventMember;

/**
 *
 * @author ChongJH
 */
public class EventMemberDA {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private EventDA eventDA;
    private MemberDA memberDA;
    String tableName = " EVENTMEMBER ";

    //No-arg constructor
    public EventMemberDA() {
        initDBConnection();
        memberDA = new MemberDA();
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
    public ArrayList<EventMember> selectAllEventMemberList() {
        ArrayList<EventMember> membersList = new ArrayList<EventMember>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                membersList.add(new EventMember(rs.getString(1), memberDA.selectRecord(rs.getString(2)), eventDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return membersList;
    }

    //Method to retrieve all records for a specific event
    public ArrayList<EventMember> selectAllEventMemberList(String eventID) {
        ArrayList<EventMember> membersList = new ArrayList<EventMember>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName + "WHERE EVENTID = ?");
            pstmt.setString(1, eventID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                membersList.add(new EventMember(rs.getString(1), memberDA.selectRecord(rs.getString(2)), eventDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return membersList;
    }

    //Select record method
    public EventMember selectRecord(String memberID, String eventID) {
        EventMember eventMember = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE MEMBERID = ? AND EVENTID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, memberID);
            pstmt.setString(2, eventID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                eventMember = new EventMember(rs.getString(1), memberDA.selectRecord(rs.getString(2)), eventDA.selectRecord(rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return eventMember;
    }

    //Create method
    public int createRecord(EventMember eventMember) throws Exception {
        int successInsert = 0;
        String eventMemberID = eventMember.getEventMemberID();
        String memberID = eventMember.getMember().getStudID();
        String eventID = eventMember.getEvent().getEventID();
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?)";

        try {
            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventMemberID);
                pstmt.setString(2, memberID);
                pstmt.setString(3, eventID);
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
    public int updateRecord(EventMember eventMember) throws Exception {
        int successUpdate = 0;

        String eventMemberID = eventMember.getEventMemberID();
        String memberID = eventMember.getMember().getStudID();
        String eventID = eventMember.getEvent().getEventID();
        String queryStr = "UPDATE" + tableName + "SET MEMBERID = ?, EVENTID = ? WHERE EVENTMEMBERID = ?";

        try {
            findRecord(eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, memberID);
                pstmt.setString(2, eventID);
                pstmt.setString(3, eventMemberID);
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

    //Delete method by Member ID - used when deleting a member
    public boolean deleteRecordByMemberID(String memberID) throws Exception {
        boolean successDelete = false;
        String queryStr = "DELETE FROM" + tableName + "WHERE MEMBERID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, memberID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }

    //Delete method by Member ID and Event ID - used when updating a specific event
    public boolean deleteRecordByMemberEventID(String memberID, String eventID) throws Exception {
        boolean successDelete = false;
        String queryStr = "DELETE FROM" + tableName + "WHERE MEMBERID = ? AND EVENTID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, memberID);
            pstmt.setString(2, eventID);
            pstmt.executeUpdate();
            successDelete = true;
        } catch (SQLException ex) {
            successDelete = false;
            ex.printStackTrace();
        }

        return successDelete;
    }
}
