package by.kiok.passwgenerator.exception;

public class FormatException extends RuntimeException {

    public FormatException(String message) {
        super(message);
    }

    public static FormatException byLength(int len) {
        return new FormatException("Incorrect length " + len);
    }
}
