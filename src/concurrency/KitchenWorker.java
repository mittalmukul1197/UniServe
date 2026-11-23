
package concurrency;

import model.Order;
import model.OrderStatus;

public class KitchenWorker implements Runnable {

    private KitchenQueue queue;

    private OrderStatusNotifier notifier;

    private String workerName;

    public KitchenWorker(
            KitchenQueue queue,
            OrderStatusNotifier notifier,
            String workerName) {

        this.queue = queue;

        this.notifier = notifier;

        this.workerName = workerName;

    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            Order order = queue.getNextOrder();

            if (order == null) {
                break;
            }

            System.out.println(
                    workerName + " started Order: "
                    + order.getOrderId()
            );

            order.setStatus(OrderStatus.ACCEPTED);

            notifier.notifyStatusChanged();

            order.setStatus(OrderStatus.PREPARING);

            notifier.notifyStatusChanged();

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                break;

            }

            order.setStatus(OrderStatus.READY);

            notifier.notifyStatusChanged();

            System.out.println(
                    workerName + " completed Order: "
                    + order.getOrderId()
            );

        }

    }
}
