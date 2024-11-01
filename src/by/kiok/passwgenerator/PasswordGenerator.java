package by.kiok.passwgenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static by.kiok.passwgenerator.exception.PasswordValidator.validateLength;

public class PasswordGenerator {

    private static final List<String> SYMBOLS_GROUPS = List.of(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", "0123456789", "!*-_");

    private static List<Integer> generateRandomArrayByCountAndLength(int count, int size) {
        List<Integer> groupsElementCount = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < size - 1; i++) {
            groupsElementCount.add((int) (Math.random() * (count - sum)));
            sum += groupsElementCount.get(i);
        }
        groupsElementCount.add(count - sum);

        return groupsElementCount;
    }

    public static String generate(int len) {
        validateLength(len);

        List<Character> sequence = new ArrayList<>();
        List<Integer> groupCounts = generateRandomArrayByCountAndLength(len, SYMBOLS_GROUPS.size());
        SecureRandom random = new SecureRandom();

        for(int j = 0; j < groupCounts.size(); j++) {
            for (int i = 0; i < groupCounts.get(j); i++) {
                int ind = random.nextInt(SYMBOLS_GROUPS.get(j).length());
                sequence.add(SYMBOLS_GROUPS.get(j).charAt(ind));
            }
        }
        Collections.shuffle(sequence);

        StringBuilder sb = new StringBuilder(sequence.size());
        for (Character c : sequence) {
            sb.append(c);
        }
        return sb.toString();
    }
}
