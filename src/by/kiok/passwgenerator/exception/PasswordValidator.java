package by.kiok.passwgenerator.exception;

public class PasswordValidator {

    public static boolean validateLength(int len) {
        if (len < 8 || len > 12) {
            throw FormatException.byLength(len);
        }
        return true;
    }
}
