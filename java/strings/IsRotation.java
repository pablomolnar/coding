package strings;

// Assume you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s i and s2, write code to check if s2 is a rotation of si using only
// one call to isSubstring (e.g.,"waterbottle" is a rotation of "erbottlewat").
public class IsRotation {

    public static void main(String args[]) {


        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    private static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) return false;
        return (b + b).contains(a);
    }
}
