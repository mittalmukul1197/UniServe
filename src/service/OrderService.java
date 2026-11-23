
package service;

import java.util.ArrayList;

import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderItem;
import model.DigitalToken;
import model.PaymentMethod;
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

    // Constructor
    public OrderService(OrderRepository orderRepository,
                        CartService cartService,
                        PaymentService paymentService,
                        TokenService tokenService) {

        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.paymentService = paymentService;
        this.tokenService = tokenService;
    }

    // Place new order
    public Order placeOrder(int studentId,
                            Cart cart,
                            String paymentType,
                            PaymentMethod paymentMethod)
            throws EmptyCartException, PaymentFailedException {

        // Check whether cart is empty
        if (cart.isEmpty()) {

            throw new EmptyCartException(
                "Your cart is empty. Add food first."
            );
        }

        // Calculate total amount
        double total = cartService.getTotal(cart);

        // Generate order ID
        int orderId = IdGenerator.getOrderId();

        // Create order items
        ArrayList<OrderItem> orderItems =
                new ArrayList<OrderItem>();

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = new OrderItem(
                cartItem.getItem(),
                cartItem.getQuantity()
            );

            orderItems.add(orderItem);
        }

        // Process payment
        Payment payment = paymentService.makePayment(
            orderId,
            total,
            paymentType,
            paymentMethod
        );

        // Generate digital token
        DigitalToken token =
                tokenService.generateToken(orderId);

        // Create order
        Order order = new Order(
            orderId,
            studentId,
            orderItems,
            total,
            "PLACED",
            token
        );

        // Save order
        orderRepository.addOrder(order);

        // Empty cart after successful order
        cart.clearCart();

        System.out.println("\nOrder placed successfully!");

        System.out.println(
            "Payment Status: " + payment.getPaymentStatus()
        );

        // Display token
        token.displayToken();

        return order;
    }

    // Get all orders
    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

}
