package strings;


// Design an algorithm to print all permutations of a string. For simplicity, assume all characters are unique.
public class AllPermutations {

    public static void main(String args[]) {

        // A -> A
        // AB -> AB + BA
        // ABC -> (CAB + CBA) + (ACB + BCA) + (ABC + BAC)
        printPermutations("ABC");
    }

    private static void printPermutations(String rest) {
        traverse("", rest);
    }

    private static void traverse(String prefix, String rest) {
        if (rest.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < rest.length(); i++) {
                traverse(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1));
            }
        }
    }
}
