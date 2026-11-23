
package service;

import java.util.ArrayList;

import model.Order;
import model.OrderStatusHistory;

import repository.OrderRepository;

import exception.OrderNotFoundException;

public class TrackingService {

    private OrderRepository orderRepository;

    private ArrayList<OrderStatusHistory> historyList;

    public TrackingService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

        historyList = new ArrayList<OrderStatusHistory>();
    }

    public void updateStatus(int orderId, String newStatus)
            throws OrderNotFoundException {

        Order order = orderRepository.getOrder(orderId);

        if (order == null) {

            throw new OrderNotFoundException(
                "Order not found."
            );
        }

        order.setStatus(newStatus);

        String time = java.time.LocalDateTime.now().toString();

        OrderStatusHistory history = new OrderStatusHistory(
            orderId,
            newStatus,
            time
        );

        historyList.add(history);

        System.out.println("Order status updated successfully.");
    }

    public void trackOrder(int orderId)
            throws OrderNotFoundException {

        Order order = orderRepository.getOrder(orderId);

        if (order == null) {

            throw new OrderNotFoundException(
                "Order not found."
            );
        }

        order.displayOrder();

        System.out.println("\n------- ORDER HISTORY -------");

        for (OrderStatusHistory history : historyList) {

            if (history.getOrderId() == orderId) {
                history.displayHistory();
            }
        }
    }

    public ArrayList<OrderStatusHistory> getHistoryList() {

        return historyList;
    }

}
