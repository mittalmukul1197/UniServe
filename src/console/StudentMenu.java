package console;

import java.util.Scanner;
import model.*;
import service.*;
import concurrency.KitchenQueue;
import exception.EmptyCartException;
import exception.PaymentFailedException;
import exception.OrderNotFoundException;

public class StudentMenu {

    private MenuService menuService;
    private Scanner sc;
    private Student student;

    private Cart cart = new Cart();

    private CartService cartService;
    private OrderService orderService;
    private TrackingService trackingService;
    private KitchenQueue kitchenQueue;

    public StudentMenu(MenuService menuService, Scanner sc,
            Student student,
            CartService cartService,
            OrderService orderService,
            TrackingService trackingService,
            KitchenQueue kitchenQueue) {

        this.menuService = menuService;
        this.sc = sc;
        this.student = student;
        this.cartService = cartService;
        this.orderService = orderService;
        this.trackingService = trackingService;
        this.kitchenQueue = kitchenQueue;
    }

    public void displayMenu() {

        int choice;

        do {

            System.out.println("\n===== STUDENT DASHBOARD =====");
            System.out.println("Welcome, " + student.getName());

            System.out.println("1. View Food Menu");
            System.out.println("2. Add Food to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Item from Cart");
            System.out.println("5. Place Order and Pay");
            System.out.println("6. Track My Orders");
            System.out.println("7. Logout");

            choice = readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    menuService.displayMenu();
                    break;

                case 2:

                    menuService.displayMenu();

                    int itemId = readInt("Enter food ID: ");
                    int quantity = readInt("Enter quantity: ");

                    try {

                        MenuItem item = menuService.findFoodById(itemId);

                        cartService.addToCart(
                                cart,
                                item,
                                quantity);

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;

                case 3:

                    cartService.showCart(cart);
                    break;

                case 4:

                    cartService.showCart(cart);

                    int removeId = readInt("Enter food ID to remove: ");

                    cartService.removeFromCart(cart, removeId);
                    break;

                case 5:

                    System.out.println("\n1. Cash at Counter");

                    int paymentChoice = readInt("Choose payment method: ");

                    if (paymentChoice == 1) {

                        try {

                            Order order = orderService.placeOrder(
                                    student.getId(),
                                    cart,
                                    "CASH");

                            kitchenQueue.addOrder(order);

                        } catch (EmptyCartException | PaymentFailedException e) {

                            System.out.println(e.getMessage());

                        }

                    } else {

                        System.out.println("Invalid payment method.");

                    }

                    break;

                case 6:

                    System.out.println("\n===== MY ORDERS =====");

                    for (Order order : orderService.getOrdersByStudent(
                            student.getId())) {

                        try {

                            trackingService.trackOrder(
                                    order.getOrderId());

                        } catch (OrderNotFoundException e) {

                            System.out.println(e.getMessage());

                        }
                    }

                    break;

                case 7:

                    System.out.println("Logging out...");
                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 7);

    }

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }
        }
    }
}