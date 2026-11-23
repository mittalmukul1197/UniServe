
package model;

public class Payment {

    private int paymentId;
    private int orderId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    // Constructor
    public Payment(int paymentId, int orderId, double amount,
                   String paymentMethod, String paymentStatus) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Get payment ID
    public int getPaymentId() {
        return paymentId;
    }

    // Get order ID
    public int getOrderId() {
        return orderId;
    }

    // Get amount
    public double getAmount() {
        return amount;
    }

    // Get payment method
    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Get payment status
    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Display payment details
    public void displayPayment() {

        System.out.println("\n------- PAYMENT DETAILS -------");

        System.out.println("Payment ID: " + paymentId);
        System.out.println("Order ID: " + orderId);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Status: " + paymentStatus);

        System.out.println("-------------------------------");
    }
}
