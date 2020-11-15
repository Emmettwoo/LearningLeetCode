package top.woohoo.stack;

import java.util.Stack;

public class LeetCode232 {

    class MyQueue {
        Stack<Integer> inputStack;
        Stack<Integer> outputStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            this.outTrigger();
            return outputStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            this.outTrigger();
            return outputStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }

        private void outTrigger() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode232 leetCode232 = new LeetCode232();
        leetCode232.demo();
    }

    public void demo() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
