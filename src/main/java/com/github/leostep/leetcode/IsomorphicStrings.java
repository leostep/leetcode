package com.github.leostep.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyz",
            "zbcdefghijklmnopqrstuvwxya"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        return map(s).equals(map(t));
    }

    private static String map(String s) {
        final Map<Character, String> map = new HashMap<>();
        final StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            final Character curr = s.charAt(i);
            if (map.containsKey(curr)) {
                res.append(map.get(curr));
            } else {
                final String value = "|" + num++;
                map.put(curr, value);
                res.append(value);
            }
        }
        return res.toString();
    }
}
