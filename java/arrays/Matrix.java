package arrays;
// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees. Can you do this in place?


/*


12345
ABCDE
67890

123
456

41
52
63

1,1 -> 1,2
1,2 -> 2,2
1,3 -> 3,2

2,1 -> 1,1
2,2 -> 1,2
2,3 -> 1,3

 */

import java.util.BitSet;

public class Matrix {

    public static void main(String args[]) {

        var matrix = new char[][]{
                new char[]{'A', 'B', 'C', 'D'},
                new char[]{'F', 'G', 'H', 'X'},
                new char[]{'J', 'K', 'L', 'M'}
        };

        //var output = rotate90(matrix);
        //print(output);

        resetRowAndColumn(matrix);
        print(matrix);
    }

    public static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.print(matrix[i][k]);
            }
            System.out.println();
        }
    }

    public static char[][] rotate90(char[][] matrix) {
        int rows = matrix[0].length;
        int columns = matrix.length;
        var output = new char[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            columns--;
            for (int c = 0; c < matrix[r].length; c++) {
                output[c][columns] = matrix[r][c];
            }
        }

        return output;
    }

    public static void resetRowAndColumn(char[][] matrix) {
        var rows = new BitSet();
        var columns = new BitSet();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'X') {
                    rows.set(r);
                    columns.set(c);

                    // reset already traversed
                    for (int i = r - 1; i >= 0; i--) {
                        matrix[i][c] = 'X';
                    }

                    for (int i = c - 1; i >= 0; i--) {
                        matrix[r][i] = 'X';
                    }

                } else if (rows.get(r) || columns.get(c)) {
                    matrix[r][c] = 'X';
                }
            }
        }
    }
}
