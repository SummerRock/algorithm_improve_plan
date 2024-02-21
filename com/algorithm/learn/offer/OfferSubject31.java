package com.algorithm.learn.offer;

import java.util.Stack;

public class OfferSubject31 {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
     *
     * @param args
     */
    public static void main(String... args) {
        int[] pushSequence = {1, 2, 3, 4, 5};
        int[] popSequence1 = {4, 5, 3, 2, 1};
        int[] popSequence2 = {4, 3, 5, 1, 2};

        System.out.println("popSequence1 is valid: " + validateStackSequences(pushSequence, popSequence1));
        System.out.println("popSequence2 is valid: " + validateStackSequences(pushSequence, popSequence2));
    }









    /**
     * 要判断第二个序列是否为栈的弹出顺序，可以使用一个辅助栈来模拟栈的压入和弹出过程。
     * 遍历第一个序列，依次将元素压入辅助栈中，并在每次压入后，检查辅助栈的栈顶元素是否与第二个序列的当前元素相同，
     * 如果相同，则从辅助栈中弹出该元素，同时继续遍历第二个序列的下一个元素。
     * 最后，如果辅助栈为空，则第二个序列为栈的弹出顺序，否则不是。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
