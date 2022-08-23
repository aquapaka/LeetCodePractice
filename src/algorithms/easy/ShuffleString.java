package algorithms.easy;

/*
You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.

Example 1:

Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
Example 2:

Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.
 */

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            stringBuilder.append(s.charAt(indexOfInts(indices, i)));
        }

        return stringBuilder.toString();
    }

    private static int indexOfInts(int[] array, int number) {
        for(int i = 0; i < array.length; ++i) {
            if(number == array[i]) return i;
        }

        return -1;
    }
}
