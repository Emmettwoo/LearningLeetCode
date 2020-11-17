package top.woohoo.array;

import top.woohoo.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode18 {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            Arrays.sort(nums);

            for (int indexA = 0; indexA < length - 3; indexA++) {

                for (int indexB = indexA + 1; indexB < length - 2; indexB++) {

                    int indexL = indexB + 1, indexR = length - 1;
                    while (indexL != indexR) {
                        int difference = nums[indexA] + nums[indexB] + nums[indexL] + nums[indexR];

                        // 差不为target时，调整index来增大或减少数值（排序的好处）
                        if (difference > target) {
                            indexR--;
                        } else if (difference < target) {
                            indexL++;
                        } else {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[indexA]);
                            temp.add(nums[indexB]);
                            temp.add(nums[indexL]);
                            temp.add(nums[indexR]);
                            result.add(temp);
                            indexL++;
                        }
                    }
                }
            }

            // 需要去重，感觉很影响效率。
            return result.stream().distinct().collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        leetCode18.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        List<List<Integer>> result;
        int[][] testData = {{1, 0, -1, 0, -2, 2}, {0, 0, 0, 0}, {-2, -1, -1, 1, 1, 2, 2},
                {-1, 0, 1, 2, -1, -4}, {1, -2, -5, -4, -3, 3, 3, 5}};

        result = solution.fourSum(testData[0], 0);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.fourSum(testData[1], 0);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.fourSum(testData[2], 0);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.fourSum(testData[3], -1);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });

        System.out.println("---");

        result.clear();
        result = solution.fourSum(testData[4], -11);
        result.forEach((list) -> {
            System.out.println(PrintUtil.printIntegerArrayList(list));
        });
    }
}
