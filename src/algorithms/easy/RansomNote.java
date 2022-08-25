package algorithms.easy;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        if(magazine.length() < ransomNote.length()) return false;

        // Get list of characters in both string
        List<Character> ransomNoteCharList = Arrays.stream(ransomNote.split(""))
                .map(string -> string.charAt(0))
                .toList();
        List<Character> magazineCharList = new ArrayList<>(Arrays.stream(magazine.split(""))
                .map(string -> string.charAt(0))
                .toList());

        // Check if magazine characters list contains all characters of randomNote
        for (char c : ransomNoteCharList) {
            if (magazineCharList.contains(c)) {
                magazineCharList.remove(magazineCharList.indexOf(c));
            } else {
                return false;
            }
        }

        return true;
    }
}
