package com.algorithm.learn.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * @param args
     */
    public static void main(String... args) {

    }


    /*
     * 经典的【栈】思路
     *
     * 遇到'('，就入栈;  遇到')'，就出栈
     * 扫描过程中，当出栈时发现栈空时，串无效
     * 扫描结束后。若栈空，则串有效；如果栈不空，则串有效
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
