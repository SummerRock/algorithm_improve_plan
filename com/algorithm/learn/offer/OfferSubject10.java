package com.algorithm.learn.offer;

import com.algorithm.learn.ListNode;

public class OfferSubject10 {

    /**
     * 反转链表
     * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
     *
     * @param args
     */
    public static void main(String... args) {
        // 构建一个测试用例
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseList(head);

        // 输出反转后的链表
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static ListNode reverseList (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
