package top.woohoo.heap;

import top.woohoo.utils.PrintUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/** 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author Emmettwoo
 */
public class LeetCode239 {

    class Solution {
        /* 超出时间限制
        public int[] maxSlidingWindow(int[] nums, int k) {
            int maxIndex = 0;
            int length = nums.length;
            int slideTimes = length - k + 1;
            int[] results = new int[slideTimes];

            for (int times = 0; times < slideTimes; times++) {
                for (int index = times; index < k + times; index++) {
                    if (maxIndex < times) {
                        maxIndex = times;
                    }
                    if (nums[index] > nums[maxIndex]) {
                        maxIndex = index;
                    }
                }
                results[times] = nums[maxIndex];
            }
            return results;
        }
        */

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k <= 0) {
                return null;
            }

            int numsLength = nums.length;
            int[] results = new int[numsLength - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int index = 0; index < numsLength; index++) {
                // 旧值小于新值，无出线机会，删除
                while (!deque.isEmpty() && nums[deque.getFirst()]< nums[index]) {
                    deque.pollFirst();
                }
                deque.push(index);

                // 当前最大值的位置已超出窗口，删除
                if (index - k >= deque.getLast()) {
                    deque.pollLast();
                }

                // 存放窗口中的最大值
                if (index + 1 >= k) {
                    results[index + 1 - k] = nums[deque.getLast()];
                }
            }
            return results;
        }
    }

    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
        leetCode239.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();

        /* demo chart.
        滑动窗口的位置                最大值
        ---------------             -----
        [1  3  -1] -3 5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        */

        int[][] nums = {{1, 3, -1, -3, 5, 3, 6, 7}, {1, -1}, {1, 3, 1, 2, 0, 5}};
        System.out.println(PrintUtil.printIntegerArray(solution.maxSlidingWindow(nums[0], 3)));
        System.out.println(PrintUtil.printIntegerArray(solution.maxSlidingWindow(nums[1], 1)));
        System.out.println(PrintUtil.printIntegerArray(solution.maxSlidingWindow(nums[2], 3)));
    }
}
