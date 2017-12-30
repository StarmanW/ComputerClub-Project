/**
 *
 * @author Kyj
 */
package model;

public class Item {

    private String itemID;
    private int itemType;
    private String itemName;
    private int quantity;
    private Collaborator collaborator;

    public Item() {

    }

    public Item(String itemID, int itemType, String itemName, int quantity, Collaborator collaborator) {
        this.itemID = itemID;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
        this.collaborator = collaborator;
    }

    //Getters
    public String getItemID() {
        return itemID;
    }

    public int getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    //Setters
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

}
