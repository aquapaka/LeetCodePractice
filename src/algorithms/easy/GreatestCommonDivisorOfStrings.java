package algorithms.easy;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t
 * (i.e., t is concatenated with itself one or more times).
 * 
 * Given two strings str1 and str2, return the largest string x such that x
 * divides both str1 and str2.
 * 
 * Example 1:
 * 
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * 
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * 
 * 
 * Constraints:
 * 
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            String substr = str1.substring(0, str1.length() - i);

            if (isDividable(str1, substr) && isDividable(str2, substr))
                return substr;
        }

        return "";
    }

    private boolean isDividable(String string, String devString) {
        int maxMultiply = string.length() / devString.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxMultiply; i++) {
            sb.append(devString);
        }

        return sb.toString().equals(string);
    }
}
