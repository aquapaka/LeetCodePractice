package algorithms.easy;

/*
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */

public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength == 0) return 0;
        if (needleLength > haystackLength) return -1;

        for (int i = 0; i <= haystackLength - needleLength; ++i) {
            String haySub = haystack.substring(i, i + needleLength);
            if (needle.equals(haySub)) {
                return i;
            }
        }

        return -1;
    }
}
