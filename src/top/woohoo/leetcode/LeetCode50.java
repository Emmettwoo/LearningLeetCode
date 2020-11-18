package top.woohoo.leetcode;

import top.woohoo.utils.RandomUtil;

/** Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author Emmettwoo
 */
public class LeetCode50 {

    class Solution {
        public double myPow(double x, int n) {
            // 中止条件
            if (n == 0) {
                return 1;
            }

            // 负数反转（n = Integer.MIN_VALUE 时直接反转会溢出)
            // https://leetcode-cn.com/problems/powx-n/comments/391291
            if (n < 0) {
                return 1 / (myPow(x, -(n+1)) * x);
            }

            // n为奇数，处理第一层递归，使其变为偶数
            if (n % 2 != 0) {
                return x * myPow(x, n - 1);
            }

            // 折半分治
            x*=x;
            return myPow(x, n/2);
        }
    }

    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();
        leetCode50.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        double[][] testData = {{2, 10}, {2.1, 3}, {2.0, -2}, {0.00001, 2147483647}, {1.00000, -2147483648},
                {RandomUtil.generateInteger(-100, 100), RandomUtil.generateInteger(Integer.MIN_VALUE, Integer.MAX_VALUE)}};

        System.out.println(testData[0][0] + " ^ " + testData[0][1] + " = " + solution.myPow(testData[0][0], (int)testData[0][1]));
        System.out.println(testData[1][0] + " ^ " + testData[1][1] + " = " + solution.myPow(testData[1][0], (int)testData[1][1]));
        System.out.println(testData[2][0] + " ^ " + testData[2][1] + " = " + solution.myPow(testData[2][0], (int)testData[2][1]));
        System.out.println(testData[3][0] + " ^ " + testData[3][1] + " = " + solution.myPow(testData[3][0], (int)testData[3][1]));
        System.out.println(testData[4][0] + " ^ " + testData[4][1] + " = " + solution.myPow(testData[4][0], (int)testData[4][1]));
        System.out.println(testData[5][0] + " ^ " + testData[5][1] + " = " + solution.myPow(testData[5][0], (int)testData[5][1]));
    }
}
