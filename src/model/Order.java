
package model;

import java.util.ArrayList;

public class Order {

    private int orderId;
    private int studentId;
    private ArrayList<OrderItem> items;
    private double totalAmount;
    private String status;
    private DigitalToken token;

    // Constructor
    public Order(int orderId, int studentId,
                 ArrayList<OrderItem> items,
                 double totalAmount, String status,
                 DigitalToken token) {

        this.orderId = orderId;
        this.studentId = studentId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = status;
        this.token = token;
    }

    // Get order ID
    public int getOrderId() {
        return orderId;
    }

    // Get student ID
    public int getStudentId() {
        return studentId;
    }

    // Get order items
    public ArrayList<OrderItem> getItems() {
        return items;
    }

    // Get total amount
    public double getTotalAmount() {
        return totalAmount;
    }

    // Get order status
    public String getStatus() {
        return status;
    }

    // Get digital token
    public DigitalToken getToken() {
        return token;
    }

    // Update order status
    public void setStatus(String status) {
        this.status = status;
    }

    // Display complete order
    public void displayOrder() {

        System.out.println("\n========== ORDER DETAILS ==========");

        System.out.println("Order ID: " + orderId);
        System.out.println("Student ID: " + studentId);

        System.out.println("\nOrdered Items:");

        for (OrderItem item : items) {

            System.out.println(
                item.getItem().getName()
                + " x " + item.getQuantity()
                + " = Rs. " + item.getSubTotal()
            );
        }

        System.out.println("-----------------------------------");

        System.out.println("Total Amount: Rs. " + totalAmount);
        System.out.println("Order Status: " + status);

        if (token != null) {
            System.out.println(
                "Token Number: " + token.getTokenNumber()
            );
        }

        System.out.println("===================================");
    }
}
