package repository;

import java.util.LinkedHashMap;
import java.util.ArrayList;

import model.Order;

public class OrderRepository {

    private LinkedHashMap<Integer, Order> orders;

    // Constructor
    public OrderRepository() {
        orders = new LinkedHashMap<Integer, Order>();
    }

    // Add new order
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    // Find order using order ID
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    // Get all orders
    public ArrayList<Order> getAllOrders() {

        return new ArrayList<Order>(orders.values());
    }

    // Get orders of a particular student
    public ArrayList<Order> getOrdersByStudent(int studentId) {

        ArrayList<Order> studentOrders = new ArrayList<Order>();

        for (Order order : orders.values()) {

            if (order.getStudentId() == studentId) {
                studentOrders.add(order);
            }
        }

        return studentOrders;
    }

    // Remove an order
    public boolean removeOrder(int orderId) {

        if (orders.containsKey(orderId)) {
            orders.remove(orderId);
            return true;
        }

        return false;
    }
}