package com.algorithm.learn.offer;

import java.util.Stack;

public class OfferSubject9 {

    /**
     * 用两个栈实现队列
     * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
     *
     * @param args
     */
    public static void main(String... args) {

    }

    public static class MockQueue {
        Stack<Integer> stack1 = new Stack<Integer>(); // in
        Stack<Integer> stack2 = new Stack<Integer>(); // out

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("");
            }
            return stack2.pop();
        }
    }
}
