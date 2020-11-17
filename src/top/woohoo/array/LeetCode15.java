package top.woohoo.array;

import top.woohoo.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @author Emmettwoo
 */
public class LeetCode15 {

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            int length = nums.length;
            Arrays.sort(nums);

            for (int indexA = 0; indexA < length - 2; indexA++) {
                // 已排序，三个大于零的正数不可能为零
                if (nums[indexA] > 0) {
                    break;
                }
                // 已排序，同一起点数字结果相同
                if (indexA > 0 && nums[indexA] == nums[indexA-1]) {
                    continue;
                }

                int indexL = indexA + 1, indexR = length - 1;
                while (indexL != indexR) {
                    int difference = nums[indexA] + nums[indexL] + nums[indexR];

                    // 差不为零时，调整index来增大或减少数值（排序的好处）
                    if (difference > 0) {
                        indexR--;
                    } else if (difference < 0) {
                        indexL++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[indexA]);
                        temp.add(nums[indexL]);
                        temp.add(nums[indexR]);
                        result.add(temp);
                        indexL++;
                    }
                }
            }

            // 需要去重，感觉很影响效率。
            return result.stream().distinct().collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        leetCode15.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        List<List<Integer>> result;
        int[][] testData = {{-1, 0, 1, 2, -1, -4}, {0, 0, 0, 0}, {-2, 0, 1, 1, 2}, {1, 2, -2, -1}, {3, 0, -2, -1, 1, 2}};

        result = solution.threeSum(testData[0]);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.threeSum(testData[1]);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.threeSum(testData[2]);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.threeSum(testData[3]);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.threeSum(testData[4]);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });
    }
}
