package algorithms.easy;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 */

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        // In ASCII table 97 is 'a' character and 122 is 'z' character
        for (int i = 97; i <= 122; i++) {
            if (!sentence.contains(String.valueOf((char)i))) return false;
        }

        return true;
    }
}
