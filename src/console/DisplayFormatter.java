
package console;

public class DisplayFormatter {

    public void showHeading(String heading) {

        System.out.println();
        System.out.println("====================================");
        System.out.println("       " + heading);
        System.out.println("====================================");
    }

    public void showMessage(String message) {

        System.out.println(message);
    }

    public void showLine() {

        System.out.println("------------------------------------");
    }
}
