
package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class KitchenQueue {

    private BlockingQueue<Order> orderQueue =
            new LinkedBlockingQueue<Order>();

    private List<Order> allOrders =
            new ArrayList<Order>();

    public void addOrder(Order order) {

        try {

            orderQueue.put(order);

            synchronized (allOrders) {
                allOrders.add(order);
            }

            System.out.println("Order added to kitchen queue.");

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("Unable to add order.");

        }
    }

    public Order getNextOrder() {

        try {

            return orderQueue.take();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            return null;

        }
    }

    public void displayOrders() {

        System.out.println("Incoming Orders:");

        if (orderQueue.isEmpty()) {

            System.out.println("No pending orders.");

        } else {

            for (Order order : orderQueue) {

                System.out.println("Order ID: " + order.getOrderId());

            }

        }
    }

    public List<Order> getAllOrders() {

        synchronized (allOrders) {

            return new ArrayList<Order>(allOrders);

        }
    }
}
