
package service;

import java.util.List;

import model.Order;

public class ReportService {

    public void showReport(List<Order> orders) {

        int totalOrders = orders.size();

        double totalSales = 0;

        for (Order order : orders) {

            totalSales = totalSales + order.getTotalAmount();

        }

        System.out.println();
        System.out.println("====================================");
        System.out.println("           SALES REPORT");
        System.out.println("====================================");

        System.out.println("Total Orders: " + totalOrders);

        System.out.println("Total Sales: Rs. " + totalSales);

        System.out.println("====================================");

    }
}
