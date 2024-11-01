package by.kiok.gallows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGallows {

    public static int readLives() {
        Scanner scanner = new Scanner(System.in);
        int newUserLives = 0;

        while (newUserLives <= 0) {
            try {
                System.out.print("Enter user lives count: ");
                newUserLives = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error input!");
                scanner.nextLine();
            }
        }
        return newUserLives;
    }

    public static void main(String[] args) {
        int newUserLives = readLives();
        User currentUser = new User("user", newUserLives);

        Gallows.startNewGame(currentUser);
    }
}
