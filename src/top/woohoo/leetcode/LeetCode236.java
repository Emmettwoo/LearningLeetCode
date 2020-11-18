package top.woohoo.leetcode;

/** 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author Emmettwoo
 */
public class LeetCode236 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** 这tm是人想出来的解决方法？膜拜了。。。
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-jian-j/
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            TreeNode leftNode = this.lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = this.lowestCommonAncestor(root.right, p, q);

            /* 左子树空，则祖先在右。反之亦然。左右均不为空，则为左右子树的出发点root。
             * (注意root不一定是根节点，是递归中尝试寻找左右子树，并得到两者的出发点，即公共祖先)。
             */
            return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
        }
    }

    public static void main(String[] args) {
        LeetCode236 leetCode236 = new LeetCode236();
        leetCode236.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        TreeNode root = null;

        // null test.
        System.out.println(solution.lowestCommonAncestor(root, null, null));

        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left.left, root.left.right).val);
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
