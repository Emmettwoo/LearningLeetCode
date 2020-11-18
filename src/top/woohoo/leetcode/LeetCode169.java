package top.woohoo.leetcode;

import java.util.HashMap;
import java.util.Map;

/** 多数元素
 * 多数元素是指在数组中出现次数大于 [ n/2 ] 的元素
 * https://leetcode-cn.com/problems/majority-element/
 * @author Emmettwoo
 */
public class LeetCode169 {

    class Solution {
        public int majorityElement(int[] nums) {
            int halfLength = nums.length / 2;
            if (halfLength == 0) {
                return nums[0];
            }

            Map<Integer, Integer> counter = new HashMap<>(halfLength);

            for (int num : nums) {
                if (counter.containsKey(num)) {
                    int count = counter.get(num);
                    if (count >= halfLength) {
                        return num;
                    } else {
                        counter.put(num, count+1);
                    }
                } else {
                    counter.put(num, 1);
                }
            }

            // int 不是 Integer 甚至不能返回null，抛出异常又要try-catch，还好“给定的数组总是存在多数元素”。
            return -1;
        }
    }

    public static void main(String[] args) {
        LeetCode169 leetCode169 = new LeetCode169();
        leetCode169.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        int[][] testData = {{3, 2, 3}, {2, 2, 1, 1, 1, 2, 2}, {1}, {6, 5, 5}};

        System.out.println(solution.majorityElement(testData[0]));
        System.out.println(solution.majorityElement(testData[1]));
        System.out.println(solution.majorityElement(testData[2]));
        System.out.println(solution.majorityElement(testData[3]));
    }
}
