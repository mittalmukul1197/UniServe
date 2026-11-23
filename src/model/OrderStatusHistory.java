
package model;

public class OrderStatusHistory {

    private int orderId;
    private String status;
    private String updateTime;

    // Constructor
    public OrderStatusHistory(int orderId, String status,
                              String updateTime) {

        this.orderId = orderId;
        this.status = status;
        this.updateTime = updateTime;
    }

    // Get order ID
    public int getOrderId() {
        return orderId;
    }

    // Get status
    public String getStatus() {
        return status;
    }

    // Get update time
    public String getUpdateTime() {
        return updateTime;
    }

    // Display order history
    public void displayHistory() {

        System.out.println(
            "Order ID: " + orderId
            + " | Status: " + status
            + " | Time: " + updateTime
        );
    }
}
