package repository;
import java.util.ArrayList;
import model.Payment;
public class PaymentRepository {

    private ArrayList<Payment> payments;

    public PaymentRepository() {
        payments = new ArrayList<Payment>();
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public ArrayList<Payment> getAllPayments() {
        return payments;
    }

    public Payment getPaymentByOrderId(int orderId) {

        for (Payment payment : payments) {

            if (payment.getOrderId() == orderId) {
                return payment;
            }
        }

        return null;
    }
}
