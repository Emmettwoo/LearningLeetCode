package top.woohoo.leetcode;

import top.woohoo.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Stack;

/** K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author Emmettwoo
 */
public class LeetCode25 {

    /** Provided by LeetCode, Modify by Emmettwoo.
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            ListNode currentNode = this;
            while (currentNode != null) {
                result.append(currentNode.val).append(" -> ");
                currentNode = currentNode.next;
            }
            result.append("NULL;");
            return result.toString();
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            ListNode dummyHead = new ListNode(0);
            ListNode currentNode = dummyHead;
            ListNode startNode = head;
            ListNode endNode = head;
            Stack<ListNode> stack = new Stack<>();

            while (true) {
                int count = 0;
                for (; count < k && endNode != null; count++) {
                    stack.add(endNode);
                    endNode = endNode.next;
                }

                if (count == k) {
                    while (!stack.isEmpty()) {
                        currentNode.next = stack.pop();
                        currentNode = currentNode.next;
                    }
                    startNode = endNode;
                } else {
                    currentNode.next = startNode;
                    return dummyHead.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode25 leetCode25 = new LeetCode25();
        leetCode25.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        ListNode headNode = null;

        // Null Elements Test, loop at index 2.
        System.out.println(solution.reverseKGroup(headNode, 2));
        // Two Elements Test, loop at index 2.
        headNode = generateLinkedList(0, 100, 2);
        System.out.println("reverseKGroup LinkedList Result: " + solution.reverseKGroup(headNode, 2));
        // Five Elements Test, loop at index 3.
        headNode = generateLinkedList(0, 100, 5);
        System.out.println("reverseKGroup LinkedList Result: " + solution.reverseKGroup(headNode, 3));
        // Ten Elements Test, loop at index 2.
        headNode = generateLinkedList(0, 100, 10);
        System.out.println("reverseKGroup LinkedList Result: " + solution.reverseKGroup(headNode, 2));
    }

    public ListNode generateLinkedList(int minimum, int maximum, int length) {
        ArrayList<Integer> arrayList = RandomUtil.generateIntegerArrayList(minimum, maximum, length);

        ListNode headNode = new ListNode(arrayList.remove(0));
        ListNode currentNode = headNode;

        for (Integer value : arrayList) {
            currentNode.next = new ListNode(value);
            currentNode = currentNode.next;
        }

        System.out.println("Integer LinkedList Generated: " + headNode);
        return headNode;
    }
}
