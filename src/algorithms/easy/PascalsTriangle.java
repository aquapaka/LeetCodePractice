package algorithms.easy;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                if (j == 0 || j == i - 1) row.add(1);
                else {
                    row.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
                }
            }

            result.add(row);
        }

        return result;
    }
}
