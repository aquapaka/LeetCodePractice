package algorithms.easy;

/*
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.


Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5
 */

public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int total = 0;
        int length = mat.length;

        // Sum all elements in 2 diagonal
        for (int row = 0; row < length; row++) {
            total += mat[row][row];
            total += mat[row][length - 1 - row];
        }

        // Subtract the middle element if the matrix size is odd
        if (length % 2 == 1) {
            total -= mat[length / 2][length / 2];
        }

        return total;
    }
}
