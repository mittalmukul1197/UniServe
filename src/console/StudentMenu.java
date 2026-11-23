package console;

import service.MenuService;
import java.util.Scanner;

public class StudentMenu {

    private MenuService menuService;
    private Scanner sc;

    public StudentMenu(MenuService menuService, Scanner sc) {

        this.menuService = menuService;
        this.sc = sc;
    }

    public void displayMenu() {

        int choice;

        do {

            System.out.println("\n===== STUDENT DASHBOARD =====");

            System.out.println("1. View Food Menu");
            System.out.println("2. Search Food");
            System.out.println("3. Sort Food by Price");
            System.out.println("4. Logout");

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

                    menuService.searchFood(name);
                    break;

                case 3:
                    menuService.sortByPrice();
                    break;

                case 4:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}