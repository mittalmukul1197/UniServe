package repository;

import java.util.LinkedHashMap;
import java.util.ArrayList;

import model.Order;

public class OrderRepository {

    private LinkedHashMap<Integer, Order> orders;

    public OrderRepository() {
        orders = new LinkedHashMap<Integer, Order>();
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public ArrayList<Order> getAllOrders() {

        return new ArrayList<Order>(orders.values());
    }

    public ArrayList<Order> getOrdersByStudent(int studentId) {

        ArrayList<Order> studentOrders = new ArrayList<Order>();

        for (Order order : orders.values()) {

            if (order.getStudentId() == studentId) {
                studentOrders.add(order);
            }
        }

        return studentOrders;
    }

    public boolean removeOrder(int orderId) {

        if (orders.containsKey(orderId)) {
            orders.remove(orderId);
            return true;
        }

        return false;
    }
}
