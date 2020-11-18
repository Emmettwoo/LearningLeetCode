package top.woohoo.leetcode;

import java.util.PriorityQueue;

/** 数据流中的第 K 大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * @author Emmettwoo
 */
public class LeetCode703 {

    class KthLargest {
        int maxSize;
        PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            if (k <= 0) {
                throw new IllegalArgumentException("K should be a positive number.");
            }

            this.maxSize = k;
            minHeap = new PriorityQueue<>();

            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < maxSize) {
                minHeap.add(val);
            } else if (minHeap.peek() < val) {
                minHeap.add(val);
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        LeetCode703 leetCode703 = new LeetCode703();
        leetCode703.demo();
    }

    public void demo() {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
