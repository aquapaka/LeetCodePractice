package algorithms.easy;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 */

public class MinCostClimbingStairs {

    static int[] dp;

    public static int minCostClimbingStairs(int[] cost) { // cost = [10,15,20]
        dp = new int[cost.length];

        return Math.min(minCost(cost, cost.length - 2), minCost(cost, cost.length - 1));
    }

    private static int minCost(int[] cost, int i) {
        if(i == 0) return cost[0];
        if(i == 1) return cost[1];
        if(dp[i] != 0) return dp[i];
        dp[i] = cost[i] + Math.min(minCost(cost, i - 2), minCost(cost, i - 1));

        return dp[i];
    }
}
