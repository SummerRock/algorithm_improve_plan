package com.algorithm.learn.offer;

import java.util.Stack;

public class OfferSubject30 {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
     *
     * @param args
     */
    public static void main(String... args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println("Min element: " + stack.getMin()); // -3
        stack.pop();
        System.out.println("Top element: " + stack.top()); // 0
        System.out.println("Min element: " + stack.getMin()); // -2
    }








    /**
     * 要实现一个包含 min 函数的栈，可以使用两个栈来实现：一个栈用于存储数据元素，另一个栈用于存储当前栈中的最小元素。
     * 每次入栈操作时，如果入栈的元素比当前最小元素小，则将该元素也入栈到最小元素栈中；
     * 出栈操作时，如果出栈的元素是最小元素，则同时从最小元素栈中出栈。
     * 这样，最小元素栈的栈顶元素始终是当前栈中的最小元素。
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            int popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
