package service;

import model.Payment;
import repository.PaymentRepository;
import utility.IdGenerator;
import exception.PaymentFailedException;

public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(int orderId, double amount,
                               String method)
            throws PaymentFailedException {

        if (amount <= 0) {
            throw new PaymentFailedException(
                "Invalid payment amount."
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
