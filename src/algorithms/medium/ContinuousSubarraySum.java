package algorithms.medium;

/*
Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 */

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int[] totalArr = new int[nums.length];

        for (int i = 0; i < totalArr.length; i++) {

            // Find total of this subarray
            if(i == 0) totalArr[i] = nums[i];
            else totalArr[i] = totalArr[i - 1] + nums[i];

            // Check if this remainder already exist
            int remainder = totalArr[i] % k;
            Integer prevIndex = remainderMap.get(remainder);
            if(prevIndex != null) {
                if(i - prevIndex >= 2) return true;
            }
            else remainderMap.put(remainder, i);
        }

        return false;
    }

    // Slow method
    public static boolean checkSubarraySumSlow(int[] nums, int k) {

        for (int start = 0; start < nums.length - 1; start++) {

            for (int end = start + 1; end < nums.length; end++) {
                int total = 0;

                for (int i = start; i <= end; i++) {
                    total += nums[i];
                }

                if(total % k == 0) return true;
            }
        }

        return false;
    }
}
