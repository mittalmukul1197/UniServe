package exception;

public class InvalidMenuItemException extends Exception {
    public InvalidMenuItemException() {
        super();
    }

    public InvalidMenuItemException(String message) {
        super(message);
    }
}
