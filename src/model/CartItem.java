
package model;

public class CartItem {

    private MenuItem item;
    private int quantity;

    // Constructor
    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Get item details
    public MenuItem getItem() {
        return item;
    }

    // Get quantity
    public int getQuantity() {
        return quantity;
    }

    // Update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate price of selected quantity
    public double getSubTotal() {
        return item.getPrice() * quantity;
    }
}
