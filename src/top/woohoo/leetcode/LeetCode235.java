package top.woohoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author Emmettwoo
 */
public class LeetCode235 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }

            List<TreeNode> pathToP = this.pathToNode(root, p.val);
            List<TreeNode> pathToQ = this.pathToNode(root, q.val);

            for (int index = pathToP.size() - 1; index >= 0; index--) {
                if (pathToQ.contains(pathToP.get(index))) {
                    return pathToP.get(index);
                }
            }

            return null;
        }

        private List<TreeNode> pathToNode(TreeNode root, Integer value) {
            List<TreeNode> path = new ArrayList<>();
            while (root.val != value) {
                if (root.val > value) {
                    path.add(root);
                    root = root.left;
                } else {
                    path.add(root);
                    root = root.right;
                }
            }
            path.add(root);
            return path;
        }
    }

    public static void main(String[] args) {
        LeetCode235 leetCode235 = new LeetCode235();
        leetCode235.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        TreeNode root = null;

        // null test.
        System.out.println(solution.lowestCommonAncestor(root, null, null));

        root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);
    }
}
