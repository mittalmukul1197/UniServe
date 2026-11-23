
package concurrency;

import model.Order;
import model.OrderStatus;

public class OrderStatusNotifier {

    public synchronized void notifyStatusChanged() {

        notifyAll();

    }

    public synchronized void waitForStatus(
            Order order, OrderStatus expectedStatus) {

        try {

            while (order.getStatus() != expectedStatus) {

                wait();

            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println("Waiting interrupted.");

        }
    }
}
