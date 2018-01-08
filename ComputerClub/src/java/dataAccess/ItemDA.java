package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Item;

/**
 *
 * @author ChongJH
 */
public class ItemDA {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private final String dbUrl = "jdbc:derby://localhost:1527/computerclubdb";
    private final String dbUser = "nbuser";
    private final String dbPass = "nbuser";
    private CollaboratorDA collaboratorDA;
    String tableName = " SPONSOREDITEM ";

    //No-arg constructor
    public ItemDA() {
        initDBConnection();
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
    public ArrayList<Item> selectAllItem() {
        ArrayList<Item> selectAllItemList = new ArrayList<Item>();

        try {
            pstmt = conn.prepareStatement("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllItemList.add(new Item(rs.getString(1), collaboratorDA.selectRecord(rs.getString(2)), rs.getInt(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllItemList;
    }

    //Select record method by Item ID
    public Item selectRecord(String itemID) {
        Item item = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE ITEMID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, itemID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getString(1), collaboratorDA.selectRecord(rs.getString(2)), rs.getInt(3), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return item;
    }

    //Select record method by Collab ID
    public Item selectRecordByCollabID(String collabID) {
        Item item = null;
        String queryStr = "SELECT * FROM" + tableName + "WHERE COLLABID = ?";

        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, collabID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new Item(rs.getString(1), collaboratorDA.selectRecord(rs.getString(2)), rs.getInt(3), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return item;
    }

    //Create method
    public int createRecord(Item item) throws Exception {
        int successInsert = 0;

        String itemID = item.getItemID();
        String collabID = item.getCollaborator().getCollabID();
        int itemType = item.getItemType();
        String itemName = item.getItemName();
        int itemQuantity = item.getQuantity();

        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?,?,?)";

        try {
            retrieveRecord(itemID);
            if (rs.next()) {
                successInsert = -1;
            } else {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, itemID);
                pstmt.setString(2, collabID);
                pstmt.setInt(3, itemType);
                pstmt.setString(4, itemName);
                pstmt.setInt(5, itemQuantity);
                successInsert = pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successInsert;
    }

    //Retrieve method
    public void retrieveRecord(String itemID) throws Exception {
        String queryStr = "SELECT * FROM" + tableName + "WHERE ITEMID = ?";
        try {
            pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1, itemID);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Update method
    public int updateRecord(Item item) throws Exception {
        int successUpdate = 0;

        String itemID = item.getItemID();
        String collabID = item.getCollaborator().getCollabID();
        int itemType = item.getItemType();
        String itemName = item.getItemName();
        int itemQuantity = item.getQuantity();
        String queryStr = "UPDATE" + tableName + "SET COLLABID = ?, ITEMTYPE = ?, ITEMNAME = ?, ITEMQUANTITY = ? WHERE ITEMID = ?";

        try {
            retrieveRecord(itemID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, collabID);
                pstmt.setInt(2, itemType);
                pstmt.setString(3, itemName);
                pstmt.setInt(4, itemQuantity);
                pstmt.setString(5, itemID);
                successUpdate = pstmt.executeUpdate();
            } else {
                successUpdate = -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successUpdate;
    }

    //Delete method by Item ID
    public int deleteRecord(String itemID) throws Exception {
        int successDelete = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE ITEMID = ?";

        try {
            retrieveRecord(itemID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, itemID);
                successDelete = pstmt.executeUpdate();
            } else {
                successDelete = -1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return successDelete;
    }

    //Delete method by Collab ID
    public boolean deleteRecordByCollabID(String collabID) throws Exception {
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
}
