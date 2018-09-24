package strings;

// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
// become smaller than the original string, your method should return the original string.


import java.util.Map;

public class Compressor {

    public static void main(String args[]) {
        var testCases = Map.of(
                "aabcccccaaa", "a2b1c5a3",
                "abc", "abc",
                "aa", "aa"
        );


        testCases.forEach((input, expected) -> {
            String output = compress(input);
            String testResult = expected.equals(output) ? "PASSED" : "FAILED";
            System.out.format("[%s] input: %s output:%s\n", testResult, input, output);
        });
    }

    public static String compress(String input) {
        if (input.length() < 3) return input;

        var output = new StringBuilder();


        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            char current = input.charAt(i);

            for (int k = i + 1; k < input.length() && current == input.charAt(k); k++, i++) {
                count++;
            }

            output.append(current).append(count);
            if (output.length() >= input.length()) {
                return input;
            }
        }

        return output.toString();
    }
}
