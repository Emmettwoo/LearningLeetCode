package top.woohoo.stack;

import java.util.Stack;

public class LeetCode844 {

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            for (char character : S.toCharArray()) {
                if (character != '#') {
                    stack1.push(character);
                } else if (!stack1.isEmpty()){
                    stack1.pop();
                }
            }

            for (char character : T.toCharArray()) {
                if (character != '#') {
                    stack2.push(character);
                } else if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }

            if (stack1.size() != stack2.size()) {
                return false;
            } else {
                while (!stack1.isEmpty()) {
                    if (!stack1.pop().equals(stack2.pop())) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode844 leetCode844 = new LeetCode844();
        leetCode844.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        String[] testData = {"", "", "a##c", "#a#c", "a#c", "b"};

        // Null Test.
        System.out.println(testData[0] + " : " + testData[1] + " -> isSame: " + solution.backspaceCompare(testData[0], testData[1]));
        // Valid Test.
        System.out.println(testData[2] + " : " + testData[3] + " -> isSame: " + solution.backspaceCompare(testData[2], testData[3]));
        // inValid Test.
        System.out.println(testData[4] + " : " + testData[5] + " -> isSame: " + solution.backspaceCompare(testData[4], testData[5]));
    }
}
