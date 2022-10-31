package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 */
public class PascalsTriangleII {

    public static List<Integer> prevRow;
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Base case
        if (rowIndex == 0) {
            row.add(1);
            return row;
        }

        prevRow = getRow(rowIndex - 1);

        for (int i = 0; i <= rowIndex; i++) {
            if(i == 0 || i == rowIndex) row.add(1);
            else {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }
        }

        return row;
    }
}
