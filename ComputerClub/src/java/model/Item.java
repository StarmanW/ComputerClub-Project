/**
 *
 * @author Shirlina Koo Yung Ja
 */
package model;

public class Item {

    private String itemID;
    private Collaborator collaborator;
    private int itemType;
    private String itemName;
    private int quantity;

    public Item() {

    }

    public Item(String itemID, Collaborator collaborator, int itemType, String itemName, int quantity) {
        this.itemID = itemID;
        this.collaborator = collaborator;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    //Getters
    public String getItemID() {
        return itemID;
    }

    public int getItemType() {
        return itemType;
    }

    public String getItemTypeString() {
        String itemTypeString = null;
        switch (itemType) {
            case 1:
                itemTypeString = "Others";
                break;
            case 2:
                itemTypeString = "Funds";
                break;
            case 3:
                itemTypeString = "Foods & drinks";
                break;
            case 4:
                itemTypeString = "Certificates";
                break;
            case 5:
                itemTypeString = "Equipments";
                break;
            case 6:
                itemTypeString = "Trophy";
                break;
        }
        return itemTypeString;
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
