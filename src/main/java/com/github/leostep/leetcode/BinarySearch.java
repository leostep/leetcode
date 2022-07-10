package com.github.leostep.leetcode;

public class BinarySearch {
    public static int search(int[] nums,
                             int target) {
        int lower = 0;
        int upper = nums.length - 1;
        while (upper >= lower) {
            final int idx = lower + (upper - lower) / 2;
            final int value = nums[idx];
            if (target == value) {
                return idx;
            } else if (target < value) {
                upper = idx - 1;
            } else {
                lower = idx + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 4, 5, 9, 12}, 12));
    }
}
