package arrays;

import java.util.Arrays;
import java.util.Map;

// A sorted array has been rotated so that the elements might appear in the order 3456712. 
// How would you find the minimum element? Youmay assume that the array has all unique elements.

public class RotatedSortedArray {
    public static void main(String args[]) {

        // 3456712 -> 1
        // 1234567 -> 1
        // 2345671 -> 1
        // input is not a natural sorted array -> InvalidArgumentException

        var testCases = Map.of(
                new int[]{3, 4, 5, 6, 7, 1, 2}, 1,
                new int[]{1, 2, 3, 4, 5, 6, 7}, 1,
                new int[]{2, 3, 4, 5, 6, 7, 1}, 1,

                // one element
                new int[]{1}, 1,

                // even elements
                new int[]{1, 2}, 1,
                new int[]{2, 1}, 1,

                // odd elements
                new int[]{1, 2, 3}, 1,
                new int[]{2, 3, 1}, 1,
                new int[]{3, 1, 2}, 1,


                // corner cases
                new int[]{3, 3}, 3
        );

        testCases.forEach((sortedArray, expected) -> {
            int got = getMinimum(sortedArray);
            var testResult = got == expected ? "PASSED" : "FAILED";
            System.out.printf("[%s] input: %s, expected: %s, got: %s\n", testResult, Arrays.toString(sortedArray), expected, got);
        });
    }

    private static int getMinimum(int[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;

        // if is not rotated then return left (first item)
        if (sortedArray[left] <= sortedArray[right]) {
            return sortedArray[left];
        }

        // iterate until left and right are next to each other
        while (right - left > 1) {
            int middle = ((right - left) / 2) + left;

            if (sortedArray[left] < sortedArray[middle]) {
                // search right side
                left = middle;
            } else {
                // search left side
                right = middle;
            }
        }

        if (sortedArray[left] < sortedArray[right]) {
            return sortedArray[left];
        } else {
            return sortedArray[right];
        }
    }
}