package com.github.leostep.leetcode;

public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode middle = head;
        for (ListNode current = head; current != null; current = current.next) {
            size++;
            if ((size & 1) == 0) {
                middle = middle.next;
            }
        }
        return middle;
    }
}
