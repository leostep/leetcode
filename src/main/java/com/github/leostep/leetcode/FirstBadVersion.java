package com.github.leostep.leetcode;

public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int minVersion = 1;
        int maxVersion = n;
        while (minVersion < maxVersion) {
            int midVersion = minVersion + (maxVersion - minVersion) / 2;
            if (isBadVersion(midVersion)) {
                maxVersion = midVersion;
            } else {
                minVersion = midVersion + 1;
            }
        }
        return maxVersion;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    // mock
    static boolean isBadVersion(int version) {
        return version >= 4;
    }
}
