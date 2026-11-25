
package model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> items;

    public Cart() {
        items = new ArrayList<CartItem>();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item, int quantity) {

        for (CartItem cartItem : items) {

            if (cartItem.getItem().getId() == item.getId()) {

                cartItem.setQuantity(
                    cartItem.getQuantity() + quantity
                );

                return;
            }
        }

        CartItem newItem = new CartItem(item, quantity);
        items.add(newItem);
    }

    public boolean removeItem(int itemId) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getItem().getId() == itemId) {

                items.remove(i);
                return true;
            }
        }

        return false;
    }

    public double calculateTotal() {

        double total = 0;

        for (CartItem item : items) {

            total = total + item.getSubTotal();
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {

        if (items.isEmpty()) {

            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n========== YOUR CART ==========");

        for (CartItem item : items) {

            System.out.println(
                item.getItem().getName()
                + " x " + item.getQuantity()
                + " = Rs. " + item.getSubTotal()
            );
        }

        System.out.println("-------------------------------");

        System.out.println(
            "Total Amount: Rs. " + calculateTotal()
        );
    }
}
