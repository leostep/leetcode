package com.github.leostep.leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] shorter = a.length() <= b.length() ? a.toCharArray() : b.toCharArray();
        char[] longer = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        int idx = 0;
        StringBuilder res = new StringBuilder();
        boolean carry = false;
        while (idx < longer.length) {
            char left;
            if (idx < shorter.length) {
                left = shorter[shorter.length - idx - 1];
            } else {
                left = '0';
            }
            char right = longer[longer.length - idx - 1];
            char resChar;
            if (left == '0' && right == '0') {
                if (carry) {
                    resChar = '1';
                    carry = false;
                } else {
                    resChar = '0';
                }
            } else if (left == '0' && right == '1' || right == '0' && left == '1') {
                if (carry) {
                    resChar = '0';
                } else {
                    resChar = '1';
                }
            } else {
                if (carry) {
                    resChar = '1';
                } else {
                    resChar = '0';
                    carry = true;
                }
            }
            res.append(resChar);
            idx++;
        }
        if (carry) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
