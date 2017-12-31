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
    public ArrayList<EventMember> selectAllEventCollabList() {
        ArrayList<EventMember> selectAllEventCollabList = new ArrayList<EventMember>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllEventCollabList.add(new EventMember(rs.getString(1), memberDA.selectRecord(rs.getString(2)), eventDA.selectRecord(rs.getString(3))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllEventCollabList;
    }

    //Select record method
    public EventMember selectRecord(String eventMemberID, String memberID, String eventID) {
        EventMember eventMember = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTMEMBERID = ? AND MEMBERID = ? AND EVENTID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventMemberID);
            pstmt.setString(2, memberID);
            pstmt.setString(3, eventID);
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
            findRecord(eventMemberID, memberID, eventID);

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
    private void findRecord(String eventMemberID, String memberID, String eventID) {
        String queryStr = "SELECT * FROM" + tableName + "WHERE EVENTMEMBERID = ? AND MEMBERID = ? AND EVENTID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, eventMemberID);
            pstmt.setString(2, memberID);
            pstmt.setString(3, eventID);
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
            findRecord(eventMemberID, memberID, eventID);

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

    //Delete method
    public int deleteRecord(String eventMemberID, String memberID, String eventID) throws Exception {
        int successDelete = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE EVENTMEMBERID = ? AND MEMBERID = ? AND EVENTID = ?";

        try {
            findRecord(eventMemberID, memberID, eventID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, eventMemberID);
                pstmt.setString(2, memberID);
                pstmt.setString(3, eventID);
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
