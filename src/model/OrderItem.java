
package model;

public class OrderItem {

    private MenuItem item;
    private int quantity;
    private double price;

    public OrderItem(MenuItem item, int quantity) {

        this.item = item;
        this.quantity = quantity;
        this.price = item.getPrice();
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSubTotal() {
        return price * quantity;
    }
}
