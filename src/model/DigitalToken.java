
package model;

public class DigitalToken {

    private int tokenNumber;
    private int orderId;

    // Constructor
    public DigitalToken(int tokenNumber, int orderId) {

        this.tokenNumber = tokenNumber;
        this.orderId = orderId;
    }

    // Get token number
    public int getTokenNumber() {
        return tokenNumber;
    }

    // Get order ID
    public int getOrderId() {
        return orderId;
    }

    // Display token details
    public void displayToken() {

        System.out.println("\n================================");
        System.out.println("       DIGITAL ORDER TOKEN");
        System.out.println("================================");

        System.out.println("Token Number: " + tokenNumber);
        System.out.println("Order ID: " + orderId);

        System.out.println("--------------------------------");
        System.out.println("Please keep your token.");
        System.out.println("Collect your food when ready.");

        System.out.println("================================");
    }
}
