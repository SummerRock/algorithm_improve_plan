package com.algorithm.learn.offer;

import com.algorithm.learn.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class OfferSubject6 {

    /**
     * 从尾到头打印链表
     * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
     *
     * @param args
     */
    public static void main(String... args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(printListFromTailToHead(listNode));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
