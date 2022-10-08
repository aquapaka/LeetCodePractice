package algorithms.medium;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        // Sort the array
        Arrays.sort(nums);

        for (int firstPointer = 0, length = nums.length - 2; firstPointer < length; firstPointer++) {
            int secondPointer = firstPointer + 1;
            int thirdPointer = nums.length - 1;

            while(secondPointer < thirdPointer) {
                // Find the sum
                int sum = nums[firstPointer] + nums[secondPointer] + nums[thirdPointer];
                if(sum == target) return sum;

                // Find the different
                int diff = Math.abs(target - sum);

                // Update the new closestSum and min diff
                if(diff < minDiff) {
                    closestSum = sum;
                    minDiff = diff;
                }

                // Update pointer
                if(sum > target) {
                    thirdPointer--;
                } else {
                    secondPointer++;
                }

            }
        }

        return closestSum;
    }
}
