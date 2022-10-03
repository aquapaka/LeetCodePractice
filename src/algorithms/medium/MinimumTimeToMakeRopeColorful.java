package algorithms.medium;

/*
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.



Example 1:


Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
Example 2:


Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
Example 3:


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 */

public class MinimumTimeToMakeRopeColorful {
    public static int minCost(String colors, int[] neededTime) {

        int totalTime = 0;

        for (int i = 0, length = colors.length(), maxNeededTime = neededTime[0]; i < length; i++) {

            // Add all remove time of balloons
            totalTime += neededTime[i];
            // Find the longest time in consecutive balloons
            if (neededTime[i] > maxNeededTime) maxNeededTime = neededTime[i];

            // Check if we're reached the last balloon
            if (i == length - 1) {
                totalTime -= maxNeededTime;
                break;
            }

            // Check if consecutive is ended (the next balloon is different), if yes then subtract the longest time
            if (colors.charAt(i) != colors.charAt(i + 1)) {
                totalTime -= maxNeededTime;

                maxNeededTime = neededTime[i + 1];
            }
        }

        return totalTime;
    }
}
