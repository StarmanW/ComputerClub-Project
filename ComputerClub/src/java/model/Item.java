/**
 *
 * @author Kyj
 */
package model;

public class Item {

    private String itemID;
    private String itemType;
    private String itemName;
    private int quantity;

    public Item() {

    }

    public Item(String itemID, String itemName, String itemType, int quantity) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    //Getters
    public String getItemID() {
        return itemID;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    //Setters
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
