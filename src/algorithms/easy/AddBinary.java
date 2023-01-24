package algorithms.easy;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder output = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;

        while (i >= 0 || j >= 0) {
            int digitA = 0;
            int digitB = 0;

            if (i >= 0)
                digitA = (int) a.charAt(i) - '0';
            if (j >= 0)
                digitB = (int) b.charAt(j) - '0';

            int sum = digitA + digitB + remainder;
            remainder = sum / 2;
            output.append(sum % 2);

            // Update loop variables
            i--;
            j--;
        }

        if (remainder != 0)
            output.append(remainder);

        return output.reverse().toString();
    }
}
