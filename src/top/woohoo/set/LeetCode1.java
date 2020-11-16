package top.woohoo.set;


import java.util.HashMap;
import java.util.Map;

/** 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @author Emmettwoo
 */
public class LeetCode1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int index = 0; index < nums.length; index++) {
                if (map.containsKey(target - nums[index])) {
                    return new int[] {index, map.get(target - nums[index])};
                }
                map.put(nums[index], index);
            }

            return null;
        }
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        leetCode1.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution1 = new Solution();
        int[] result;

        int[][] testData = {{2, 7, 11, 15}, {9}, {3, 2, 4}, {6}, {3, 3}, {6}};
        result = solution1.twoSum(testData[4], testData[5][0]);
        System.out.println(testData[4][result[0]] + " + " + testData[4][result[1]] + " = " + testData[5][0]);
        result = solution1.twoSum(testData[0], testData[1][0]);
        System.out.println(testData[0][result[0]] + " + " + testData[0][result[1]] + " = " + testData[1][0]);
        result = solution1.twoSum(testData[2], testData[3][0]);
        System.out.println(testData[2][result[0]] + " + " + testData[2][result[1]] + " = " + testData[3][0]);
    }
}
