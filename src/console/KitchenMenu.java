
package console;

import concurrency.KitchenQueue;
import concurrency.OrderStatusNotifier;
import concurrency.KitchenWorker;
import service.ReportService;

public class KitchenMenu {

    InputHandler input = new InputHandler();

    DisplayFormatter display = new DisplayFormatter();

    KitchenQueue queue = new KitchenQueue();

    OrderStatusNotifier notifier = new OrderStatusNotifier();

    ReportService report = new ReportService();

    private boolean workersStarted = false;

    private Thread worker1;

    private Thread worker2;


    // Start Kitchen Workers

    public void startWorkers() {

        if (!workersStarted) {

            worker1 = new Thread(
                new KitchenWorker(queue, notifier, "Worker 1")
            );

            worker2 = new Thread(
                new KitchenWorker(queue, notifier, "Worker 2")
            );

            worker1.setDaemon(true);

            worker2.setDaemon(true);

            worker1.start();

            worker2.start();

            workersStarted = true;

            System.out.println("Kitchen workers started.");

        }
    }


    // Display Kitchen Menu

    public void showKitchenMenu() {

        startWorkers();

        int choice;

        do {

            display.showHeading("KITCHEN DASHBOARD");

            System.out.println("1. View Incoming Orders");

            System.out.println("2. Add Sample Order");

            System.out.println("3. View Sales Report");

            System.out.println("4. Back");

            choice = input.getNumber();

            switch (choice) {

                case 1:

                    queue.displayOrders();

                    break;

                case 2:

                    System.out.println("Connect student order module to add real orders.");

                    break;

                case 3:

                    report.showReport(queue.getAllOrders());

                    break;

                case 4:

                    System.out.println("Returning to Main Menu...");

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 4);

    }


    // Get Kitchen Queue

    public KitchenQueue getQueue() {

        return queue;

    }

}
