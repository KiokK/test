package by.kiok.gallows;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Gallows {

    private static final char SECRET_SYMBOL = '*';
    private static final String LIVE_ELEMENT = "+";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern patternLetter = Pattern.compile("[a-z]");

    private static char[] word;
    private static char[] wordForUserWatching;
    private static int currentOpenLettersCount = 0;

    private static void initState() {
        word = WordsConstants.getRandomWord().toCharArray();
        wordForUserWatching = new char[word.length];
        Arrays.fill(wordForUserWatching, SECRET_SYMBOL);
    }

    private static boolean isUpdate(char letter) {
        boolean isUpdated = false;
        for (int i = 0; i < word.length; i++) {
            if (letter == wordForUserWatching[i]) {
                return true;
            }
            if (word[i] == letter && wordForUserWatching[i] == SECRET_SYMBOL) {
                wordForUserWatching[i] = letter;
                currentOpenLettersCount++;
                isUpdated = true;
            }
        }
        return isUpdated;
    }

    private static char readNextLetter() {
        String letter = null;
        while (letter == null) {
            System.out.print("\nWrite letter: ");
            try {
                letter = scanner.next(patternLetter);
            } catch (InputMismatchException e) {
                System.err.println("Error attempt of write letter. Try [a-z]!");
                scanner.nextLine();
            }
        }
        return letter.charAt(0);
    }

    public static void startNewGame(User user) {
        initState();
        System.out.println("________GAME STARTED________");

        while (user.getLives() > 0) {
            System.out.println("Lives: " + LIVE_ELEMENT.repeat(user.getLives()));
            System.out.println("Secret word: " + String.copyValueOf(wordForUserWatching));

            char letter = readNextLetter();
            if (!isUpdate(letter)) {
                user.setLives(user.getLives() - 1);
            }
            System.out.println("---------------------------");

            if (currentOpenLettersCount == word.length) {
                System.out.println("\tWIN!!!!");
                return;
            }
        }
        System.out.println("\tLose...");
    }
}
