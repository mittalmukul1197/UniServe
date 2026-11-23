
package service;

import model.Cart;
import model.MenuItem;
import exception.InvalidMenuItemException;

public class CartService {

    // Add food item to cart
    public void addToCart(Cart cart, MenuItem item, int quantity)
            throws InvalidMenuItemException {

        if (item == null) {
            throw new InvalidMenuItemException(
                "Food item not found."
            );
        }

        if (quantity <= 0) {
            throw new InvalidMenuItemException(
                "Quantity must be greater than zero."
            );
        }

        if (!item.isAvailable()) {
            throw new InvalidMenuItemException(
                "Food item is not available."
            );
        }

        cart.addItem(item, quantity);

        System.out.println("Item added to cart successfully.");
    }

    // Remove food item from cart
    public void removeFromCart(Cart cart, int itemId) {

        boolean removed = cart.removeItem(itemId);

        if (removed) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    // Display cart
    public void showCart(Cart cart) {
        cart.displayCart();
    }

    // Calculate total bill
    public double getTotal(Cart cart) {
        return cart.calculateTotal();
    }
}
