package top.woohoo.leetcode;

/** 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author Emmettwoo
 */
public class LeetCode98 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return this.validBST(root, null, null);
        }

        private boolean validBST(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            if (max != null && node.val >= max) {
                return false;
            } else if(min != null && node.val <= min) {
                return false;
            } else {
                return this.validBST(node.left, min, node.val) && this.validBST(node.right, node.val, max);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode98 leetCode98 = new LeetCode98();
        leetCode98.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        TreeNode root = null;

        // null test.
        System.out.println(solution.isValidBST(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root));

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(solution.isValidBST(root));

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(solution.isValidBST(root));
    }
}
