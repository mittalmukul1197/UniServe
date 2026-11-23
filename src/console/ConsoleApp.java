package console;

import java.util.Scanner;
import model.*;
import repository.*;
import service.*;
import concurrency.KitchenQueue;

public class ConsoleApp {

    private Scanner sc = new Scanner(System.in);

    public void startApplication() {

        UserRepository userRepository = new UserRepository();
        MenuRepository menuRepository = new MenuRepository();
        OrderRepository orderRepository = new OrderRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        AuthService authService = new AuthService(userRepository);
        MenuService menuService = new MenuService(menuRepository);
        CartService cartService = new CartService();
        PaymentService paymentService = new PaymentService(paymentRepository);
        TokenService tokenService = new TokenService();

        OrderService orderService = new OrderService(
                orderRepository,
                cartService,
                paymentService,
                tokenService
        );

        TrackingService trackingService =
                new TrackingService(orderRepository);

        KitchenQueue kitchenQueue = new KitchenQueue();

        KitchenMenu kitchenMenu = new KitchenMenu(
                kitchenQueue,
                orderRepository,
                sc
        );

        Staff staff = new Staff(
                userRepository.generateId(),
                "Canteen Manager",
                "staff@gmail.com",
                "1234",
                "EMP101",
                "Manager"
        );

        userRepository.addUser(staff);

        menuService.addFood("Veg Burger", 80, Category.FAST_FOOD);
        menuService.addFood("Cold Coffee", 60, Category.BEVERAGES);
        menuService.addFood("Pizza", 150, Category.FAST_FOOD);
        menuService.addFood("Samosa", 20, Category.SNACKS);

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println(" COLLEGE CANTEEN MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Staff Login");
            System.out.println("4. Kitchen Dashboard");
            System.out.println("5. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    int year = readInt("Enter year: ");

                    authService.registerStudent(
                            name,
                            email,
                            password,
                            studentId,
                            course,
                            year
                    );

                    break;

                case 2:

                    System.out.print("Enter email: ");
                    email = sc.nextLine();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    User studentUser =
                            authService.login(email, password);

                    if (studentUser instanceof Student) {

                        Student student = (Student) studentUser;

                        StudentMenu studentMenu = new StudentMenu(
                                menuService,
                                sc,
                                student,
                                cartService,
                                orderService,
                                trackingService,
                                kitchenQueue
                        );

                        studentMenu.displayMenu();

                    } else if (studentUser != null) {

                        System.out.println(
                                "This account is not a student account."
                        );
                    }

                    break;

                case 3:

                    System.out.print("Enter staff email: ");
                    email = sc.nextLine();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    User staffUser =
                            authService.login(email, password);

                    if (staffUser instanceof Staff) {

                        StaffMenu staffMenu =
                                new StaffMenu(menuService, sc);

                        staffMenu.displayMenu();

                    } else if (staffUser != null) {

                        System.out.println(
                                "This account is not a staff account."
                        );
                    }

                    break;

                case 4:

                    kitchenMenu.showKitchenMenu();

                    break;

                case 5:

                    System.out.println(
                            "Thank you for using our application!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

    }

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }
        }
    }
}
