package com.github.leostep.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class StackBasedQueue {

    private final Deque<Integer> inbound = new LinkedList<>();
    private final Deque<Integer> outbound = new LinkedList<>();

    public void push(int x) {
        inbound.push(x);
    }

    public int pop() {
        transferElements();
        return outbound.pop();
    }

    public int peek() {
        transferElements();
        return outbound.peek();
    }

    public boolean empty() {
        return inbound.isEmpty() && outbound.isEmpty();
    }

    private void transferElements() {
        if (outbound.isEmpty()) {
            while (!inbound.isEmpty()) {
                outbound.push(inbound.pop());
            }
        }
    }
}
