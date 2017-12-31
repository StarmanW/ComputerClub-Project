package dataAccess;

import java.sql.*;
import java.util.ArrayList;
import model.Collaborator;
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
            pstmt = conn.prepareCall("SELECT * FROM" + tableName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                selectAllItemList.add(new Item(rs.getString(1), collaboratorDA.selectRecord(rs.getString(2)), rs.getInt(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return selectAllItemList;
    }

//Select record method
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

    //Create method
    public int createRecord(Item item, Collaborator collaborator) throws Exception {
        int successInsert = 0;
        
        String itemID = item.getItemID();
        String collabID = collaborator.getCollabID();
        int itemType = item.getItemType();
        String itemName = item.getItemName();
        int itemQuantity = item.getQuantity();
        
        String queryStr = "INSERT INTO" + tableName + "VALUES(?,?,?,?,?)";

        try {
            selectRecord(itemID);

            if (rs.next()) {
                //ADD ERR MSG
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
    public int updateRecord(Item item, Collaborator collaborator) throws Exception {
        int successInsert = 0;

        String itemID = item.getItemID();
        String collabID = collaborator.getCollabID();
        int itemType = item.getItemType();
        String itemName = item.getItemName();
        int itemQuantity = item.getQuantity();
        String queryStr = "UPDATE" + tableName + "SET COLLABID = ?, ITEMTYPE = ?, ITEMNAME = ?, ITEMQUANTITY = ? WHERE ITEMID = ?";

        try {
            selectRecord(collabID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, collabID);
                pstmt.setInt(2, itemType);
                pstmt.setString(3, itemName);
                pstmt.setInt(4, itemQuantity);
                pstmt.setString(5, itemID);
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
    public int deleteRecord(String itemID) throws Exception {
        int succesInsert = 0;

        String queryStr = "DELETE FROM" + tableName + "WHERE ITEMID = ?";

        try {
            selectRecord(itemID);

            if (rs.next()) {
                pstmt = conn.prepareStatement(queryStr);
                pstmt.setString(1, itemID);
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
