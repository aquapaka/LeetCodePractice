package algorithms.medium;

/*
You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.

Example 1:


Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
Output: [3,2,2]
Explanation: The points and circles are shown above.
queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
 */

public class NumberOfPointsInsideACircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] countArray = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int[] center = {queries[i][0], queries[i][1]};
            int count = 0;

            for (int j = 0; j < points.length; ++j) {
                if (calculateDistantBetweenTwoPoint(points[j], center) <= queries[i][2]) {
                    count++;
                }
            }

            countArray[i] = count;
        }

        return countArray;
    }

    private double calculateDistantBetweenTwoPoint(int[] point1, int[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }

}
