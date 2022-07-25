package com.github.leostep.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsequence {
    public static boolean isSubsequence(String s,
                                        String t) {
        if (s.isEmpty()) {
            return true;
        }
        int subIndex = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(subIndex)) {
                subIndex++;
            }
            if (subIndex == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSubsequenceV2(String s,
                                          String t) {
        if (s.isEmpty()) {
            return true;
        }
        final Map<Character, List<Integer>> charIndexMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            charIndexMap.computeIfAbsent(curr, k -> new ArrayList<>()).add(i);
        }

        int previousIndex = 0;
        for (char c : s.toCharArray()) {
            final List<Integer> indices = charIndexMap.get(c);
            if (indices == null) {
                return false;
            } else {
                int result = Collections.binarySearch(indices, previousIndex);
                if (result < 0) {
                    result = -(result + 1);
                }
                if (result == indices.size()) {
                    return false;
                }
                previousIndex = indices.get(result) + 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequenceV2("abba", "ababagalamaga"));
        System.out.println(isSubsequenceV2("axc", "ahbgdc"));
    }
}
