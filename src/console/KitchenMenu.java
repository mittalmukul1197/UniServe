package console;

import concurrency.KitchenQueue;
import concurrency.KitchenWorker;
import concurrency.OrderStatusNotifier;
import model.Order;
import repository.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class KitchenMenu {

    private KitchenQueue queue;
    private OrderRepository orderRepository;
    private Scanner scanner;

    private boolean workersStarted = false;

    public KitchenMenu(KitchenQueue queue,
                       OrderRepository orderRepository,
                       Scanner scanner) {

        this.queue = queue;
        this.orderRepository = orderRepository;
        this.scanner = scanner;
    }

    // Start kitchen workers only once
    public void startWorkers() {

        if (workersStarted) {
            return;
        }

        OrderStatusNotifier notifier = new OrderStatusNotifier();

        KitchenWorker worker1 =
                new KitchenWorker(queue, notifier, "Worker 1");

        KitchenWorker worker2 =
                new KitchenWorker(queue, notifier, "Worker 2");

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        workersStarted = true;

        System.out.println("Kitchen workers started successfully!");
    }

    // Display kitchen dashboard
    public void showKitchenMenu() {

        startWorkers();

        int choice;

        do {
            System.out.println("\n========== KITCHEN DASHBOARD ==========");
            System.out.println("1. View Pending Orders");
            System.out.println("2. View All Orders");
            System.out.println("3. Sales Report");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.println("\n--- PENDING ORDERS ---");
                        queue.displayOrders();
                        break;

                    case 2:
                        viewAllOrders();
                        break;

                    case 3:
                        showSalesReport();
                        break;

                    case 4:
                        System.out.println("Returning to main menu...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Please enter a valid number!");
            }

        } while (choice != 4);
    }

    // Display all orders
    private void viewAllOrders() {

        System.out.println("\n========== ALL ORDERS ==========");

        List<Order> orders = orderRepository.getAllOrders();

        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            order.displayOrder();
            System.out.println("-----------------------------");
        }
    }

    // Basic sales report
    private void showSalesReport() {

        System.out.println("\n========== SALES REPORT ==========");

        List<Order> orders = orderRepository.getAllOrders();

        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.println("Total Orders: " + orders.size());

        System.out.println("\nOrder Summary:");

        for (Order order : orders) {
            order.displayOrder();
            System.out.println("-----------------------------");
        }
    }
}