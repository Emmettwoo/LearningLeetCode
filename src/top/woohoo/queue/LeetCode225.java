package top.woohoo.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode225 {

    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new ArrayDeque<>();
            queue2 = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue1.add(x);
                while (!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                }
            } else {
                queue2.add(x);
                while (!queue1.isEmpty()) {
                    queue2.add(queue1.poll());
                }
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (!queue1.isEmpty()) {
                return queue1.poll();
            } else {
                return queue2.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if (!queue1.isEmpty()) {
                return queue1.peek();
            } else {
                return queue2.peek();
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        LeetCode225 leetCode225 = new LeetCode225();
        leetCode225.demo();
    }

    public void demo() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
