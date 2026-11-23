
package console;

public class ConsoleApp {

    InputHandler input = new InputHandler();

    DisplayFormatter display = new DisplayFormatter();

    KitchenMenu kitchen = new KitchenMenu();

    public void startApplication() {

        int choice;

        do {

            display.showHeading("COLLEGE CANTEEN MANAGEMENT SYSTEM");

            System.out.println("1. Student Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Kitchen Dashboard");
            System.out.println("4. Exit");

            choice = input.getNumber();

            switch (choice) {

                case 1:
                    System.out.println("Student module will be connected here.");
                    break;

                case 2:
                    System.out.println("Staff module will be connected here.");
                    break;

                case 3:
                    kitchen.showKitchenMenu();
                    break;

                case 4:
                    System.out.println("Thank you for using our application!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 4);

    }
}
