package strings;

public class Reverse {

    public static void main(String args[]) {
        assert "FEDCBA".equals(reverse("ABCDEF"));
    }

    public static String reverse(String str) {
        if (str.length() < 2) return str;

        var out = new StringBuffer(str.length());
        for (int i = str.length() - 1; i >= 0; i--) {
            out.append(str.charAt(i));
        }

        return out.toString();
    }
}
