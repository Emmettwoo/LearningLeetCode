package top.woohoo.leetcode;

import top.woohoo.utils.PrintUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author Emmettwoo
 */
public class LeetCode102 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            // 初始化结果集，置入root
            List<List<Integer>> result = new ArrayList<List<Integer>>() {{
                add(new ArrayList<Integer>() {{
                    add(root.val);
                }});
            }};

            // 初始化 待遍历的节点集、遍历中的节点集
            Queue<TreeNode> waittingNodes = new ArrayDeque<>();
            Queue<TreeNode> workingNodes = new ArrayDeque<>();
            waittingNodes.add(root);

            // 待遍历的节点集不为空时，放入正在遍历节点集
            while (!waittingNodes.isEmpty()) {
                workingNodes.addAll(waittingNodes);
                waittingNodes.clear();

                // 遍历 遍历中的节点集（当前层），将下一层节点放入 待遍历节点集
                List<Integer> temp = new ArrayList<>();
                while (!workingNodes.isEmpty()) {
                    TreeNode currentNode = workingNodes.poll();

                    if (currentNode.left != null) {
                        waittingNodes.add(currentNode.left);
                        temp.add(currentNode.left.val);
                    }
                    if (currentNode.right != null) {
                        waittingNodes.add(currentNode.right);
                        temp.add(currentNode.right.val);
                    }
                }

                // 遍历结果（下一层节点）不为空，放入结果集
                if (!temp.isEmpty()) {
                    result.add(temp);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode102 leetCode102 = new LeetCode102();
        leetCode102.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        TreeNode root = null;

        // null test.
        System.out.println(PrintUtil.printIntegerArrayLists(solution.levelOrder(root)) + "\n");

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(PrintUtil.printIntegerArrayLists(solution.levelOrder(root)) + "\n");

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(PrintUtil.printIntegerArrayLists(solution.levelOrder(root)) + "\n");
    }
}
