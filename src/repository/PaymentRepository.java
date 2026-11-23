
package repository;

import java.util.ArrayList;

import model.Payment;

public class PaymentRepository {

    private ArrayList<Payment> payments;

    // Constructor
    public PaymentRepository() {
        payments = new ArrayList<Payment>();
    }

    // Add payment
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    // Get all payments
    public ArrayList<Payment> getAllPayments() {
        return payments;
    }

    // Find payment using order ID
    public Payment getPaymentByOrderId(int orderId) {

        for (Payment payment : payments) {

            if (payment.getOrderId() == orderId) {
                return payment;
            }
        }

        return null;
    }
}
