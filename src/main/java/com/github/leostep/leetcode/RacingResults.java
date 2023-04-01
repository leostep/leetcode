package com.github.leostep.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResults {
    public static void print_classification(List<List<Integer>> raw_data) {
        Map<Integer, Integer> positionToPoints = Map.of(1, 10, 2, 6, 3, 4, 4, 3, 5, 2, 6, 1);
        Map<Integer, Integer> racerStats = new HashMap<>();
        for (var row : raw_data) {
            int racerId = row.get(1);
            int points = positionToPoints.getOrDefault(row.get(2), 0);
            racerStats.put(racerId, racerStats.getOrDefault(racerId, 0) + points);
        }
        int winnerId = -1;
        int winnerResult = -1;
        for (var entry : racerStats.entrySet()) {
            int racerId = entry.getKey();
            int result = entry.getValue();
            if (result > winnerResult) {
                winnerResult = result;
                winnerId = racerId;
            } else if (result == winnerResult) {
                if (racerId < winnerId) {
                    winnerId = racerId;
                }
            }
        }
        System.out.println(winnerId + " " + winnerResult);
    }
}
