
package console;

import java.util.Scanner;

public class InputHandler {

    Scanner sc = new Scanner(System.in);

    public int getNumber() {

        System.out.print("Enter your choice: ");

        int number = sc.nextInt();

        return number;
    }

    public String getText() {

        System.out.print("Enter your name: ");

        String name = sc.next();

        return name;
    }
}
