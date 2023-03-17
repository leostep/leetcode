package com.github.leostep.leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        var openBrackets = Set.of('(', '[', '{');
        var closedToOpenMap = Map.of(')', '(', ']', '[', '}', '{');

        final var openedStack = new LinkedList<Character>();
        for (Character c : s.toCharArray()) {
            if (openBrackets.contains(c)) {
                openedStack.push(c);
                continue;
            }
            if (openedStack.isEmpty() || openedStack.pop() != closedToOpenMap.get(c)) {
                return false;
            }
        }
        return openedStack.isEmpty();
    }
}
