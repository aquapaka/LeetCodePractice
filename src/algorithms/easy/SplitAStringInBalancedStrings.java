package algorithms.easy;

/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
 */

import java.util.regex.Pattern;

public class SplitAStringInBalancedStrings {
    public static int balancedStringSplit(String s) {
        int subStringCount = 0;
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'L') count++;
            else count--;

            if(count == 0 || i == s.length() - 1) subStringCount++;
        }

        return subStringCount;
    }
}
