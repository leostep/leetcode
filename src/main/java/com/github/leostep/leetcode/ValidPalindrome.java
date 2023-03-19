package com.github.leostep.leetcode;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        final StringBuilder res = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            }
        }
        return res.toString().equals(res.reverse().toString());
    }

    public static boolean isPalindromeTwoPointers(String s) {
        int startIdx = 0;
        int endIdx = s.length() - 1;
        while (startIdx <= endIdx) {
            char startChar = s.charAt(startIdx);
            char endChar = s.charAt(endIdx);
            if (!Character.isLetterOrDigit(startChar)) {
                startIdx++;
            } else if (!Character.isLetterOrDigit(endChar)) {
                endIdx--;
            } else {
                if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                    return false;
                }
                startIdx++;
                endIdx--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindromeTwoPointers(" "));
    }
}
