package strings;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IsPermutation {

    public static void main(String args[]) {

        var testCases = new String[]{
                "ABC", "BAC", "true",
                "A", "A", "true",
                "ABC", "ABB", "false"
        };

        for (int i = 0; i < testCases.length; i += 3) {
            boolean got = isPermutation(testCases[i], testCases[i + 1]);
            var testResults = Boolean.valueOf(testCases[i + 2]) == got ? "PASSED" : "FAILED";
            System.out.printf("[%s] isPermutation(%s, %s) return %s\n", testResults, testCases[i], testCases[i + 1], got);
        }
    }

    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        var charMap = new HashMap<Character, AtomicInteger>();
        a.chars().forEach(c -> {
            var counter = charMap.get((char) c);
            if (counter == null) counter = new AtomicInteger();
            charMap.put((char) c, counter);
            counter.incrementAndGet();
        });

        for (int i = 0; i < b.length(); i++) {
            var c = charMap.get(b.charAt(i));
            if (c == null) {
                return false;
            }

            var count = c.decrementAndGet();
            if (count < 0) {
                return false;
            }
        }

        return true;
    }
}
