package top.woohoo.leetcode;

/** 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author Emmettwoo
 */
public class LeetCode122 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) {
                return 0;
            }

            boolean holdFlag = false;
            int profit = 0;
            int days = prices.length;

            for (int index = 0; index < days; index++) {
                if (holdFlag && prices[index] > prices[index - 1]) {
                    profit += prices[index] - prices[index - 1];
                    holdFlag = false;
                }
                if (index < days - 1 && !holdFlag && prices[index] < prices[index + 1]) {
                    holdFlag = true;
                }
            }

            return profit;
        }
    }

    public static void main(String[] args) {
        LeetCode122 leetCode122 = new LeetCode122();
        leetCode122.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        int[][] testData = {{1}, {1, 2}, {7, 1, 5, 3, 6, 4}, {1, 2, 3, 4, 5}, {7, 6, 4, 3, 1}};

        System.out.println(solution.maxProfit(null));
        System.out.println(solution.maxProfit(testData[0]));
        System.out.println(solution.maxProfit(testData[1]));
        System.out.println(solution.maxProfit(testData[2]));
        System.out.println(solution.maxProfit(testData[3]));
        System.out.println(solution.maxProfit(testData[4]));
    }
}
