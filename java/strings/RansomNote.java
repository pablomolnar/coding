package strings;

import java.util.HashMap;

// A ransom note can be formed by cutting words out of a magazine to form a new sentence.
// How would you figure out if a ransom note (represented as a string) can be formed from a given magazine (string)?
public class RansomNote {


    public static void main(String args[]) {
        var testCases = new String[]{
                // [note, magazine, expected]
                "ABC", "ABC", "true",
                "ABC", "ABCD", "true",
                "ABC", "AB", "false",
                "ABB", "AB", "false",

                // corner cases
                "ABC", "", "false",
                "", "ABC", "false" // InvalidArgumentException?
        };

        for (int i = 0; i < testCases.length; i += 3) {

            var note = testCases[i];
            var magazine = testCases[i + 1];
            var expected = testCases[i + 2];
            boolean got = canBeFormed(note, magazine);
            var testResult = expected.equals(String.valueOf(got)) ? "PASSED" : "FAILED";

            System.out.printf("[%s]\tnote: %s\tmagazine: %s\tcanBeForm: %s\n", testResult, note, magazine, got);
        }
    }

    private static boolean canBeFormed(String note, String magazine) {
        // check invalid note
        if (note == null || note.length() == 0) return false;

        // check if magazine has not enough letters
        if (magazine.length() < note.length()) return false;

        // create noteMap [letter:count]
        var noteMap = new HashMap<Character, Integer>();
        for (int i = note.length() - 1; i >= 0; i--) {
            char letter = note.charAt(i);
            Integer count = noteMap.get(letter);
            if (count == null) {
                count = 0;
            }

            noteMap.put(letter, count + 1);
        }

        // total remaining letters
        int remaining = note.length();

        // iterate magazine
        for (int i = magazine.length() - 1; i >= 0; i--) {
            char letter = magazine.charAt(i);
            Integer count = noteMap.get(letter);

            // if mag letter is not in the note then keep with next letter
            if(count == null) continue;

            // decrement count
            count -= 1;

            // if count is 0 remove letter otherwise decrement count
            if(count == 0) {
                noteMap.remove(letter);
            } else {
                noteMap.put(letter, count);
            }

            if(--remaining == 0) {
                return true;
            }
        }

        return false;
    }


}
