package utility;

public class IdGenerator {

    private static int orderId = 100;
    private static int paymentId = 500;
    private static int tokenNumber = 1000;

    public static synchronized int getOrderId() {
        orderId++;
        return orderId;
    }

    public static synchronized int getPaymentId() {
        paymentId++;
        return paymentId;
    }

    public static synchronized int getTokenNumber() {
        tokenNumber++;
        return tokenNumber;
    }
}
