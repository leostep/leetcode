package com.github.leostep.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = -1;
        while (left < right) {
            int lHeight = height[left];
            int rHeight = height[right];
            int area = Math.min(lHeight, rHeight) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (lHeight < rHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
