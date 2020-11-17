package top.woohoo.array;

import java.util.Arrays;

/** 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author Emmettwoo
 */
public class LeetCode242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] sCounter = new int[26];
            int[] tCounter = new int[26];

            for (char c : s.toCharArray()) {
                sCounter[c - 'a']++;
            }

            for (char c : t.toCharArray()) {
                tCounter[c - 'a']++;
            }

            return Arrays.equals(sCounter, tCounter);
        }
    }

    public static void main(String[] args) {
        LeetCode242 leetCode242 = new LeetCode242();
        leetCode242.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();

        String[] testData = {"", "", "anagram", "nagaram", "rat", "car", "can", "ca"};
        System.out.println(testData[0] + " & " + testData[1] + " isAnagram: " + solution.isAnagram(testData[0], testData[1]));
        System.out.println(testData[2] + " & " + testData[3] + " isAnagram: " + solution.isAnagram(testData[2], testData[3]));
        System.out.println(testData[4] + " & " + testData[5] + " isAnagram: " + solution.isAnagram(testData[4], testData[5]));
        System.out.println(testData[6] + " & " + testData[7] + " isAnagram: " + solution.isAnagram(testData[6], testData[7]));
        System.out.println(testData[7] + " & " + testData[6] + " isAnagram: " + solution.isAnagram(testData[7], testData[6]));
    }
}
