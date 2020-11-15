package top.woohoo.set;

import top.woohoo.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/** 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author Emmettwoo
 */
public class LeetCode142 {

    /** Provided by LeetCode, Modify by Emmettwoo.
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> usedNodes = new HashSet<>();

            ListNode currentNode = head;
            while (currentNode != null) {
                if (usedNodes.contains(currentNode)) {
                    return currentNode;
                }
                usedNodes.add(currentNode);
                currentNode = currentNode.next;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();
        leetCode142.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        ListNode headNode = null;
        // Null Elements Test.
        System.out.println("LinkedList cycle start at: " + solution.detectCycle(headNode));
        // Two Elements NonLoop Test.
        headNode = generateLinkedListWithLoop(0, 100, 2, -1);
        System.out.println("LinkedList cycle start at: " + solution.detectCycle(headNode));
        // Two Elements Loop Test.
        headNode = generateLinkedListWithLoop(0, 100, 2, 0);
        System.out.println("LinkedList cycle start at: " + solution.detectCycle(headNode));
        // Ten Elements NonLoop Test.
        headNode = generateLinkedListWithLoop(0, 100, 10, -1);
        System.out.println("LinkedList cycle start at: " + solution.detectCycle(headNode));
        // Ten Elements Loop Test.
        headNode = generateLinkedListWithLoop(0, 100, 10, 2);
        System.out.println("LinkedList cycle start at: " + solution.detectCycle(headNode));
    }

    public ListNode generateLinkedListWithLoop(int minimum, int maximum, int length, int loopStart) {
        ArrayList<Integer> arrayList = RandomUtil.generateIntegerArrayList(minimum, maximum, length);

        ListNode headNode = new ListNode(arrayList.remove(0));
        ListNode currentNode = headNode;
        ListNode loopNode = null;

        for (int index = 0; index < arrayList.size(); index++) {
            Integer value = arrayList.get(index);
            currentNode.next = new ListNode(value);

            if (index == loopStart) {
                /* fixme: When loopNode is the last node, loopNode.next will be null;
                if (index == arrayList.size() - 1) {
                    currentNode.next = currentNode;
                }
                */

                loopNode = currentNode;
            }

            currentNode = currentNode.next;
        }

        currentNode.next = loopNode;

        // System.out.println("Integer LinkedList Generated: " + headNode);
        return headNode;
    }
}
