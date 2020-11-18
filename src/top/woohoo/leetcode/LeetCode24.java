package top.woohoo.leetcode;

import top.woohoo.utils.RandomUtil;

import java.util.ArrayList;

/** 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author Emmettwoo
 */
public class LeetCode24 {

    /** Provided by LeetCode, Modify by Emmettwoo.
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // PreviousNode initial like a dummy head.
            ListNode previousNode = new ListNode(0, head);
            ListNode currentNode = head;
            // New head will be the 2nd element.
            head = head.next;

            while (currentNode != null && currentNode.next != null) {
                // Pop out 2.
                previousNode.next = currentNode.next;
                // Linked 3 to 1.
                currentNode.next = currentNode.next.next;
                // Linked 1 to 2.
                previousNode.next.next = currentNode;

                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            return head;
        }
    }

    public static void main(String[] args) {
        LeetCode24 leetCode24 = new LeetCode24();
        leetCode24.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        ListNode headNode = null;

        // Null Elements Test.
        System.out.println(solution.swapPairs(headNode));
        // Two Elements Test.
        headNode = generateLinkedList(0, 100, 2);
        System.out.println("swapPairs LinkedList Result is: " + solution.swapPairs(headNode));
        // Five Elements Test.
        headNode = generateLinkedList(0, 100, 5);
        System.out.println("swapPairs LinkedList Result is: " + solution.swapPairs(headNode));
        // Ten Elements Test.
        headNode = generateLinkedList(0, 100, 10);
        System.out.println("swapPairs LinkedList Result is: " + solution.swapPairs(headNode));
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


