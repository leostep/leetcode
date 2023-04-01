package com.github.leostep.leetcode;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        var freqMap = new HashMap<Integer, Integer>();
        int targetFreq = (nums.length & 1) == 0 ? (nums.length / 2) : (nums.length / 2 + 1);
        for (int num : nums) {
            int currFreq = freqMap.getOrDefault(num, 0);
            int newFrequency = currFreq + 1;
            if (newFrequency >= targetFreq) {
                return num;
            }
            freqMap.put(num, newFrequency);
        }
        return -1;
    }

    public static int majorityElementNoExtraSpace(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int counter = 1;
        int majEl = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                majEl = nums[i];
            }
            if (nums[i] == majEl) {
                counter++;
            } else {
                counter--;
            }
        }
        return majEl;
    }
}
