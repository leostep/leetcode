package com.github.leostep.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new LinkedList<>();
        int index = 0;
        int[] intervalToInsert = {newInterval[0], newInterval[1]};

        while (index < intervals.length && intervals[index][1] < intervalToInsert[0]) {
            resList.add(intervals[index++]);
        }

        while (index < intervals.length && intervals[index][0] <= intervalToInsert[1]) {
            intervalToInsert = merge(intervals[index++], intervalToInsert);
        }

        resList.add(intervalToInsert);
        while (index < intervals.length) {
            resList.add(intervals[index++]);
        }
        return resList.toArray(new int[0][0]);
    }

    private static int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public static void main(String[] args) {
        var res = insert(new int[][]{new int[]{1, 5}}, new int[]{2, 3});
        var string = Arrays.stream(res)
                .map(Arrays::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(string);
    }
}
