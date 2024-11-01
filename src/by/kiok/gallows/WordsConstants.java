package by.kiok.gallows;

import java.util.List;
import java.util.Random;

public class WordsConstants {

    private static final Random random = new Random();
    private static final List<String> words = List.of("animal", "banana", "car", "pineapple", "apple", "claude");

    public static String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
