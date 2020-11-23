package top.woohoo.leetcode;

/** 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author Emmettwoo
 */
public class LeetCode104 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        LeetCode104 leetCode104 = new LeetCode104();
        leetCode104.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        TreeNode root = null;

        // null test.
        System.out.println(solution.maxDepth(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root));
    }
}
