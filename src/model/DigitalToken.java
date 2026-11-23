
package model;

public class DigitalToken {

    private int tokenNumber;
    private int orderId;

    public DigitalToken(int tokenNumber, int orderId) {

        this.tokenNumber = tokenNumber;
        this.orderId = orderId;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public int getOrderId() {
        return orderId;
    }

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
