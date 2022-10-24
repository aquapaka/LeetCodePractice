package algorithms.easy;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 */

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') pStack.push(c);
            else if (c == ')') {
                if (pStack.size() == 0 || pStack.pop() != '(') return false;
            } else if (c == ']') {
                if (pStack.size() == 0 || pStack.pop() != '[') return false;
            } else if (c == '}') {
                if (pStack.size() == 0 || pStack.pop() != '{') return false;
            }
        }

        return pStack.size() == 0;
    }
}
