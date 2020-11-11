package top.woohoo.linkedlist;

import top.woohoo.utils.RandomUtil;

import java.util.ArrayList;

/** 反转一个单链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author Emmettwoo
 */
public class LeetCode206 {

    public static void main(String[] args) {
        // Initialize Solution.
        Solution solution = new Solution();

        // Null Test.
        System.out.println(solution.reverseList(null));

        // Solution Test.
        ListNode headNode = generateLinkedList(0, 100, 2);
        System.out.println("Reverse LinkedList Result is: " + solution.reverseList(headNode));
        headNode = generateLinkedList(0, 100, 10);
        System.out.println("Reverse LinkedList Result is: " + solution.reverseList(headNode));
    }

    public static ListNode generateLinkedList(int minimum, int maximum, int length) {
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

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Initial current node (the first value in origin linked list).
        ListNode currentNode = head;
        // Initial target node (which after current node, move it to top).
        ListNode targetNode = currentNode.next;

        while (targetNode != null) {
            // Pop out target node.
            currentNode.next = targetNode.next;
            // make target node on top.
            targetNode.next = head;
            // Redefine head node to target node.
            head = targetNode;
            // Locate next target node.
            targetNode = currentNode.next;
        }

        return head;
    }
}

/** Provided by LeetCode, Modify by Emmettwoo.
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

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