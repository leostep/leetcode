package com.github.leostep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, ListNode> hashMap;
    private ListNode head;
    private ListNode last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity, 1);
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            final ListNode cacheHit = hashMap.get(key);
            moveToFront(cacheHit);
            return cacheHit.val;
        }
        return -1;
    }

    public void put(int key,
                    int value) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.val = value;
            moveToFront(node);
        } else {
            if (hashMap.size() == capacity) {
                hashMap.remove(evictLast());
            }
            final ListNode node = new ListNode(key, value);
            hashMap.put(key, node);
            appendFirst(node);
        }
    }

    private void moveToFront(ListNode node) {
        if (node == head) {
            return;
        }
        if (node == last) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        node.prev.next = node.next;
        node.prev = null;
        appendFirst(node);
    }

    private int evictLast() {
        int evictedKey = last.key;
        if (last == head) {
            last = null;
            head = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return evictedKey;
    }

    private void appendFirst(ListNode node) {
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (last == null) {
            last = node;
        }
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }

    private static class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int val;

        ListNode(int key,
                 int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    public static void main(String[] args) {
        var cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache);
        System.out.println(cache.get(1));
    }
}
