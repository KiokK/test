package by.kiok.passwgenerator;

import by.kiok.passwgenerator.exception.FormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static by.kiok.passwgenerator.exception.PasswordValidator.validateLength;

public class MainPassGen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean marker = false;
        int len = 0;

        while (!marker) {
            try {
                System.out.print("Enter length: ");
                len = scanner.nextInt();
                marker = validateLength(len);
            } catch (InputMismatchException | FormatException e) {
                System.err.println("Error input!");
                scanner.nextLine();
            }
        }
        System.out.println(PasswordGenerator.generate(len));
    }
}
