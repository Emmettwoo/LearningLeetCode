package top.woohoo.leetcode;

import top.woohoo.utils.RandomUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author Emmettwoo
 */
public class LeetCode20 {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> bracketsMap = new HashMap<Character, Character>() {{
                put('}', '{');
                put(']', '[');
                put(')', '(');
            }};

            for (char character : s.toCharArray()) {
                if (bracketsMap.containsKey(character)) {
                    if (stack.isEmpty() || !bracketsMap.get(character).equals(stack.pop())) {
                        return false;
                    }
                } else {
                    stack.push(character);
                }
            }
            return stack.isEmpty();
        }

        /** interesting solution, but low efficiency.
        public boolean isValid(String s) {
            int nowLength = 0;
            while (nowLength != s.length()) {
                nowLength = s.length();
                s = s.replace("()", "").replace("[]", "").replace("{}", "");
            }
            return s.length() == 0;
        }
        */
    }

    public static void main(String[] args) {
        LeetCode20 leetCode20 = new LeetCode20();
        leetCode20.demo();
    }

    public void demo() {
        Character[] bracketCharacterSet = {'{', '}', '[', ']', '(', ')'};
        // Initialize Solution.
        Solution solution = new Solution();
        String[] testData = {"", "([])", "({[]}", RandomUtil.generateStringWithCharacterSet(10, bracketCharacterSet)};

        // Null Test.
        System.out.println(testData[0] + " -> isValid: " + solution.isValid(testData[0]));
        // Valid Test.
        System.out.println(testData[1] + " -> isValid: " + solution.isValid(testData[1]));
        // inValid Test.
        System.out.println(testData[2] + " -> isValid: " + solution.isValid(testData[2]));
        // Random Test.
        System.out.println(testData[3] + " -> isValid: " + solution.isValid(testData[3]));
    }
}
