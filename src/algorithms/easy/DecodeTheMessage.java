package algorithms.easy;

/*
You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:

Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
Align the substitution table with the regular English alphabet.
Each letter in message is then substituted using the table.
Spaces ' ' are transformed to themselves.
For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
Return the decoded message.

Example 1:

Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
Output: "this is a secret"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
Example 2:

Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
Output: "the five boxing wizards jump quickly"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".
 */

import java.util.HashMap;

public class DecodeTheMessage {
    public static String decodeMessage(String key, String message) {
        StringBuilder decodedMessage = new StringBuilder();
        HashMap<Character, Character> keyMap = createKeyMap(key);

        for (int i = 0; i < message.length(); ++i) {
            // 'a' character code is 97 in ascii table
            if(keyMap.containsKey(message.charAt(i))) decodedMessage.append(keyMap.get(message.charAt(i)));
            else decodedMessage.append(" ");

        }

        return decodedMessage.toString();
    }

    public static HashMap<Character, Character> createKeyMap(String key) {
        HashMap<Character, Character> keyMap = new HashMap<>();
        key = key.replaceAll("\\s+", "");

        // 'a' character in ascii code
        int characterIndex = 97;
        int keyIndex = 0;

        // 'z' character in ascii code
        while(characterIndex <= 122 && keyIndex < key.length()) {
            if (!keyMap.containsKey(key.charAt(keyIndex))) {
                keyMap.put(key.charAt(keyIndex), (char) characterIndex);
                characterIndex++;
            }
            keyIndex++;
        }

        return keyMap;
    }
}
