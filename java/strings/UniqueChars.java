package strings;

// Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

import java.util.HashMap;
import java.util.Map;

public class UniqueChars {

    public static void main(String args[]) {
        var testCases = Map.of(
                "ABC", true,
                "ABCA", false,
                "", true
        );

        testCases.forEach((k, v) -> {
            boolean got = hasUniqueChars(k);
            String testResult = got == v ? "PASSED" : "FAILED";
            System.out.format("[%s] str: %s hasUniqueChars: %s\n", testResult, k, got);
        });

        testCases.forEach((k, v) -> {
            boolean got = hasUniqueChars2(k);
            String testResult = got == v ? "PASSED" : "FAILED";
            System.out.format("[%s] str: %s hasUniqueChars2: %s\n", testResult, k, got);
        });
    }

    public static boolean hasUniqueChars(String str) {
        var charMap = new HashMap<Character, Boolean>();
        for (int i = str.length() - 1; i >= 0; i--) {
            var c = str.charAt(i);
            if (charMap.containsKey(c)) {
                return false;
            } else {
                charMap.put(c, true);
            }
        }

        return true;
    }

    public static boolean hasUniqueChars2(String str) {
        if (str.length() <= 2) return true;

        for (int i = 0; i < str.length(); i++) {
            for (int k = i + 1; k < str.length(); k++) {
                if (str.charAt(i) == str.charAt(k)) return false;
            }

        }

        return true;
    }
}
