package algorithms.medium;

/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.


Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.
 */

import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    private int max = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);

        return max;
    }

    private void backtrack(List<String> arr, String current, int start) {
        if(current.length() > max) max = current.length();

        for (int i = start, length = arr.size(); i < length; i++) {
            if (isValid(current, arr.get(i))) {
                backtrack(arr, current + arr.get(i), i + 1);
            }
        }
    }

    private boolean isValid(String current, String nextString) {
        boolean[] charCheckArray = new boolean[26];

        for (int i = 0; i < nextString.length(); i++) {
            char c = nextString.charAt(i);

            if(charCheckArray[c-'a'] || current.indexOf(c) != -1) return false;
            charCheckArray[c-'a'] = true;
        }

        return true;
    }
}
