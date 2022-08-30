package algorithms.easy;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 */

public class ReverseWordsStringIII {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            stringBuilder.append(reverseWord(word)).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private String reverseWord(String word) {
        StringBuilder wordBuilder = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; --i) {
            wordBuilder.append(word.charAt(i));
        }

        return wordBuilder.toString();
    }
}
