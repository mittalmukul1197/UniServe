package utility;

public class Validator {

    public static boolean isValidEmail(String email) {

        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidPassword(String password) {

        return password.length() >= 4;
    }

    public static boolean isValidPrice(double price) {

        return price > 0;
    }

    public static boolean isValidName(String name) {

        return name != null && !name.trim().isEmpty();
    }
}
