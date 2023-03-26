package com.github.leostep.leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int nMinus2 = 1;
        int nMinus1 = 2;
        int total = 0;
        for (int i = 2; i < n; i++) {
            total = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = total;
        }
        return total;
    }
}
