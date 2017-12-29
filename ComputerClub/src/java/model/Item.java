/**
 *
 * @author Kyj
 */
package model;

public class Item {

    private String itemCode;
    private String itemType;
    private String itemName;
    private int quantity;

    public Item() {

    }

    public Item(String itemCode, String itemName, String itemType, int quantity) {
        this.itemCode = itemCode;
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    //Getters
    public String getItemCode() {
        return itemCode;
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
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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
