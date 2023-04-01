package com.github.leostep.leetcode;

import java.util.Arrays;
import java.util.List;

public class BakeryQualityControl {
    public static int count_invalid_boxes(List<List<String>> box_template_list) {
        int mismatches = 0;
        for (var pair: box_template_list) {
            String box = pair.get(0);
            String template = pair.get(1);
            if (box.equals(template)) {
                continue;
            }
            char[] sortedBox = box.toCharArray();
            Arrays.sort(sortedBox);
            char[] sortedTemplate = template.toCharArray();
            Arrays.sort(sortedTemplate);
            if (!Arrays.equals(sortedBox, sortedTemplate)) {
                mismatches++;
            }
        }
        return mismatches;
    }
}
