package com.github.leostep.leetcode;

public class RomanToInt {
    public static int romanToInt(String s) {
        int res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                res += 1000;
            }
            if (c == 'D') {
                res += 500;
            }
            if (c == 'C') {
                if (i < length - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (nextChar == 'D') {
                        res += 400;
                        i++;
                    } else if (nextChar == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
            }
            if (c == 'L') {
                res += 50;
            }
            if (c == 'X') {
                if (i < length - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (nextChar == 'L') {
                        res += 40;
                        i++;
                    } else if (nextChar == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                } else {
                    res += 10;
                }
            }
            if (c == 'V') {
                res += 5;
            }
            if (c == 'I') {
                if (i < length - 1) {
                    char nextChar = s.charAt(i + 1);
                    if (nextChar == 'V') {
                        res += 4;
                        i++;
                    } else if (nextChar == 'X') {
                        res += 9;
                        i++;
                    } else {
                        res += 1;
                    }
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
