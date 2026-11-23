
package service;

import java.util.ArrayList;

import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderItem;
import model.DigitalToken;
import model.Payment;

import repository.OrderRepository;

import exception.EmptyCartException;
import exception.PaymentFailedException;

import utility.IdGenerator;

public class OrderService {

    private OrderRepository orderRepository;
    private CartService cartService;
    private PaymentService paymentService;
    private TokenService tokenService;

    public OrderService(OrderRepository orderRepository,
                        CartService cartService,
                        PaymentService paymentService,
                        TokenService tokenService) {

        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.paymentService = paymentService;
        this.tokenService = tokenService;
    }

    public Order placeOrder(int studentId,
                            Cart cart,
                            String paymentType)
            throws EmptyCartException, PaymentFailedException {

        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Your cart is empty. Add food first."
            );
        }

        double total = cartService.getTotal(cart);

        int orderId = IdGenerator.getOrderId();

        ArrayList<OrderItem> orderItems =
                new ArrayList<OrderItem>();

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = new OrderItem(
                cartItem.getItem(),
                cartItem.getQuantity()
            );

            orderItems.add(orderItem);
        }

        Payment payment = paymentService.makePayment(
            orderId,
            total,
            paymentType
        );

        DigitalToken token =
                tokenService.generateToken(orderId);

        Order order = new Order(
            orderId,
            studentId,
            orderItems,
            total,
            "PLACED",
            token
        );

        orderRepository.addOrder(order);

        cart.clearCart();

        System.out.println("\nOrder placed successfully!");

        System.out.println(
            "Payment Status: " + payment.getPaymentStatus()
        );

        token.displayToken();

        return order;
    }

    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public ArrayList<Order> getOrdersByStudent(int studentId) {
        return orderRepository.getOrdersByStudent(studentId);
    }

}
