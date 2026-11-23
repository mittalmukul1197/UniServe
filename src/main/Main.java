package main;

import model.*;
import repository.*;
import service.*;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();

        MenuRepository menuRepository = new MenuRepository();

        AuthService authService = new AuthService(userRepository);

        MenuService menuService = new MenuService(menuRepository);

        // Register student

        authService.registerStudent(
                "Rahul",
                "rahul@gmail.com",
                "1234",
                "ST101",
                "CSE",
                2
        );

        // Login student

        User user = authService.login(
                "rahul@gmail.com",
                "1234"
        );

        if (user != null) {

            user.displayDetails();
        }

        // Add food items

        menuService.addFood(
                "Veg Burger", 80, Category.FAST_FOOD
        );

        menuService.addFood(
                "Cold Coffee", 60, Category.BEVERAGES
        );

        menuService.addFood(
                "Pizza", 120, Category.FAST_FOOD
        );

        // Display menu

        menuService.displayMenu();

        // Search food

        System.out.println("\nSearching for Burger:");

        menuService.searchFood("Burger");

        // Sort menu

        System.out.println("\nSorted Menu:");

        menuService.sortByPrice();
    }
}