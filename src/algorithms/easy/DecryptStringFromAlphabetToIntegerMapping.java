package algorithms.easy;

/*
ou are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
 */

public class DecryptStringFromAlphabetToIntegerMapping {
    public static String freqAlphabets(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {

            // Decode the number before '#' character
            if (s.charAt(i) == '#') {

                // Form the number
                int firstDigit = s.charAt(i - 2) - 48;
                int secondDigit = s.charAt(i - 1) - 48;
                int number = firstDigit * 10 + secondDigit;

                // Append the number's th character
                stringBuilder.append((char) (number + 96));

                // Skip 2 used digit
                i -= 2;

            } else {

                // Get the number
                int number = s.charAt(i) - 48;

                // Append the number's th character
                stringBuilder.append((char) (number + 96));
            }
        }

        return stringBuilder.reverse().toString();
    }
}
