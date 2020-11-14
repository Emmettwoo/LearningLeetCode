package top.woohoo.linkedlist;

import top.woohoo.utils.RandomUtil;

import java.util.ArrayList;

/** 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author Emmettwoo
 */
public class LeetCode141 {

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
        /* using Set to store ListNodes that has visited.
        public boolean hasCycle(ListNode head) {
            Set<ListNode> usedNodes = new HashSet<>();

            ListNode currentNode = head;
            while (currentNode != null) {
                if (usedNodes.contains(currentNode)) {
                    return true;
                }
                usedNodes.add(currentNode);
                currentNode = currentNode.next;
            }

            return false;
        }
        */

        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode slowPointer = head;
            ListNode fastPointer = head;

            // todo: Simplify the loop conditions.
            while (slowPointer.next != null && fastPointer.next != null && fastPointer.next.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;

                if (slowPointer == fastPointer) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode141 leetCode141 = new LeetCode141();
        leetCode141.demo();
    }

    public void demo() {
        // Initialize Solution.
        Solution solution = new Solution();
        ListNode headNode = null;
        // Null Elements Test.
        System.out.println("LinkedList hasCycle: " + solution.hasCycle(headNode));
        // Two Elements NonLoop Test.
        headNode = generateLinkedListWithLoop(0, 100, 2, -1);
        System.out.println("LinkedList hasCycle: " + solution.hasCycle(headNode));
        // Two Elements Loop Test.
        headNode = generateLinkedListWithLoop(0, 100, 2, 0);
        System.out.println("LinkedList hasCycle: " + solution.hasCycle(headNode));
        // Ten Elements NonLoop Test.
        headNode = generateLinkedListWithLoop(0, 100, 10, -1);
        System.out.println("LinkedList hasCycle: " + solution.hasCycle(headNode));
        // Ten Elements Loop Test.
        headNode = generateLinkedListWithLoop(0, 100, 10, 2);
        System.out.println("LinkedList hasCycle: " + solution.hasCycle(headNode));
    }

    public ListNode generateLinkedListWithLoop(int minimum, int maximum, int length, int loopStart) {
        ArrayList<Integer> arrayList = RandomUtil.generateIntegerArrayList(minimum, maximum, length);

        ListNode headNode = new ListNode(arrayList.remove(0));
        ListNode currentNode = headNode;
        ListNode loopNode = null;

        for (int index = 0; index < arrayList.size(); index++) {
            Integer value = arrayList.get(index);
            currentNode.next = new ListNode(value);
            currentNode = currentNode.next;

            if (index == loopStart) {
                /* fixme: When loopNode is the last node, loopNode.next will be null;
                if (index == arrayList.size() - 1) {
                    currentNode.next = currentNode;
                }
                */

                loopNode = currentNode;
            }
        }

        currentNode.next = loopNode;

        // System.out.println("Integer LinkedList Generated: " + headNode);
        return headNode;
    }
}
