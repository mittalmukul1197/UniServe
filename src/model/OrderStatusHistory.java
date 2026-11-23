
package model;

public class OrderStatusHistory {

    private int orderId;
    private String status;
    private String updateTime;

    public OrderStatusHistory(int orderId, String status,
                              String updateTime) {

        this.orderId = orderId;
        this.status = status;
        this.updateTime = updateTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void displayHistory() {

        System.out.println(
            "Order ID: " + orderId
            + " | Status: " + status
            + " | Time: " + updateTime
        );
    }
}
