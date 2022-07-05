package com.github.leostep.leetcode;

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1,
                                  ListNode list2) {
        final ListNode res = new ListNode();
        ListNode curr = res;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }

        return res.next;
    }
}
