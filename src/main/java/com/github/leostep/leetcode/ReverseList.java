package com.github.leostep.leetcode;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = head;
        ListNode tail = head.next;
        reversed.next = null;
        while (tail != null) {
            ListNode rest = tail.next;
            tail.next = reversed;
            reversed = tail;
            tail = rest;
        }
        return reversed;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}
