
package service;

import model.Payment;
import model.PaymentMethod;
import repository.PaymentRepository;
import utility.IdGenerator;
import exception.PaymentFailedException;

public class PaymentService {

    private PaymentRepository paymentRepository;

    // Constructor
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Process payment
    public Payment makePayment(int orderId, double amount,
                               String method,
                               PaymentMethod paymentMethod)
            throws PaymentFailedException {

        if (amount <= 0) {
            throw new PaymentFailedException(
                "Invalid payment amount."
            );
        }

        boolean success = paymentMethod.pay(amount);

        if (!success) {
            throw new PaymentFailedException(
                "Payment failed."
            );
        }

        Payment payment = new Payment(
            IdGenerator.getPaymentId(),
            orderId,
            amount,
            method,
            "SUCCESS"
        );

        paymentRepository.addPayment(payment);

        System.out.println("Payment successful!");

        return payment;
    }
}
