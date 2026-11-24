package console;

import service.MenuService;
import model.Category;

import java.util.Scanner;

public class StaffMenu {

    private MenuService menuService;
    private Scanner sc;

    public StaffMenu(MenuService menuService, Scanner sc) {

        this.menuService = menuService;
        this.sc = sc;
    }

    public void displayMenu() {

        int choice;

        do {

            System.out.println("\n===== STAFF DASHBOARD =====");

            System.out.println("1. View Food Menu");
            System.out.println("2. Add Food");
            System.out.println("3. Remove Food");
            System.out.println("4. Update Food Price");
            System.out.println("5. Logout");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    menuService.displayMenu();
                    break;

                case 2:

                    System.out.print("Enter food name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Available categories:");

                    for (Category category : Category.values()) {
                        System.out.println(category);
                    }

                    System.out.print("Enter category: ");

                    String categoryName = sc.nextLine();

                    try {

                        Category category = Category.valueOf(
                                categoryName.toUpperCase()
                        );

                        menuService.addFood(name, price, category);

                    }
                    catch (IllegalArgumentException e) {

                        System.out.println("Invalid category!");
                    }

                    break;

                case 3:

                    System.out.print("Enter food ID: ");

                    int id = sc.nextInt();

                    menuService.removeFood(id);

                    break;

                case 4:

                    System.out.print("Enter food ID: ");

                    id = sc.nextInt();

                    System.out.print("Enter new price: ");

                    double newPrice = sc.nextDouble();

                    menuService.updatePrice(id, newPrice);

                    break;

                case 5:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}