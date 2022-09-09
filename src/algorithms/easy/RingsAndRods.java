package algorithms.easy;

/*
There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings forms a color-position pair that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.


Example 1:


Input: rings = "B0B6G0R6R0R6G9"
Output: 1
Explanation:
- The rod labeled 0 holds 3 rings with all colors: red, green, and blue.
- The rod labeled 6 holds 3 rings, but it only has red and blue.
- The rod labeled 9 holds only a green ring.
Thus, the number of rods with all three colors is 1.

Example 2:


Input: rings = "B0R0G0R9R0B0G0"

Output: 1
Explanation:
- The rod labeled 0 holds 6 rings with all colors: red, green, and blue.
- The rod labeled 9 holds only a red ring.
Thus, the number of rods with all three colors is 1.

Example 3:

Input: rings = "G4"
Output: 0
Explanation:
Only one ring is given. Thus, no rods have all three colors.


Constraints:

rings.length == 2 * n
1 <= n <= 100
rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
rings[i] where i is odd is a digit from '0' to '9' (0-indexed).
 */

public class RingsAndRods {
    public static int countPoints(String rings) {
        // Create array of 10 rods (from 0 -> 9)
        int[] rods = new int[10];

        // Loop through each pair of 'color' and 'rodIndex'
        for (int i = 0; i < rings.length(); i += 2) {
            // Get 'color' and 'rodIndex' of each pair
            char color = rings.charAt(i);
            int rodIndex = rings.charAt(i + 1) - '0';

            // Bit manipulation explain
            // Problem: There is 3 color R,G,B and we want to check if a rod have both 3 color
            // Idea:
            //      Working with bit, we can have a bit '000' (3 switches off) meaning rod don't have any of R,G or B
            //      and a bit '111' (3 switches on) meaning rod have both 3 color R,G,B.
            //      Now we can assign each 'switch' to a color
            //      Below I have:
            //          'R' assigned to bit '001' (1 in integer)
            //          'G' assigned to bit '010' (2 in integer)
            //          'B' assigned to bit '100' (4 in integer) (we assume that other than 'R' and 'G' is 'B')
            int integerOfSwitch = (color == 'R' ? 1 : color == 'G' ? 2 : 4);

            // Perform assign OR operation
            // Explain:
            //      If the rod current don't have any color, so it bit will be '000'
            //      If the ring put in is 'G' (or 2 in integer) ('010' in bit) -> '000' | '010' = '010' (the 'G' switch is on)
            //      Then the ring put in is 'B' (or 4 in integer) ('100' in bit) -> '010' | '100' = '110' (the 'G' and 'B' switches is on)
            rods[rodIndex] |= integerOfSwitch;
        }

        // Count number of rod that have both three rings RGB
        int count = 0;
        for (int rod : rods) {
            // Check if a rod have both 3 switches enabled ('111' in bit -> 7 in integer)
            if (rod == 7) count++;
        }

        return count;
    }
}
