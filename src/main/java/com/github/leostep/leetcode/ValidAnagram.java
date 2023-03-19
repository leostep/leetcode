package com.github.leostep.leetcode;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final int[] mask = new int[26];
        for (char c: s.toCharArray()) {
            mask[c - 'a']++;
        }
        for(char c: t.toCharArray()){
            if (--mask[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "gramana"));
    }
}
