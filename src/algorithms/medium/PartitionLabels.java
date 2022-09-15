package algorithms.medium;

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.



Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {

        // Create hashmap of all character in string with it last index
        Map<Character, Integer> characterIntegerHashMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            characterIntegerHashMap.put(s.charAt(i), i);
        }

        // Create a list to store size of partitions
        List<Integer> sizeList = new ArrayList<>();
        int prev = -1;
        int max = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            max = Math.max(max, characterIntegerHashMap.get(c));

            if (i == max) {
                sizeList.add(max - prev);
                prev = max;
            }
        }

        return sizeList;


    }
}
