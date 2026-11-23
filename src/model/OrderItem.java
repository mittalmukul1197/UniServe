
package model;

public class OrderItem {

    private MenuItem item;
    private int quantity;
    private double price;

    // Constructor
    public OrderItem(MenuItem item, int quantity) {

        this.item = item;
        this.quantity = quantity;
        this.price = item.getPrice();
    }

    // Get food item
    public MenuItem getItem() {
        return item;
    }

    // Get quantity
    public int getQuantity() {
        return quantity;
    }

    // Get price
    public double getPrice() {
        return price;
    }

    // Calculate subtotal
    public double getSubTotal() {
        return price * quantity;
    }
}
