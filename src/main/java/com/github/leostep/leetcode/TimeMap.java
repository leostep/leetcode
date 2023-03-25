package com.github.leostep.leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TimeMap {
    private final Map<String, NavigableSet<TimeRecord>> hash = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        final TimeRecord timeRecord = new TimeRecord(timestamp, value);
        if (hash.containsKey(key)) {
            hash.get(key).add(timeRecord);
        } else {
            hash.put(key, new TreeSet<>(Collections.singleton(timeRecord)));
        }
    }

    public String get(String key, int timestamp) {
        if (hash.containsKey(key)) {
            TimeRecord res = hash.get(key).floor(new TimeRecord(timestamp, "dummy"));
            if (res != null) {
                return res.value;
            }
        }
        return "";
    }

    private record TimeRecord(int time, String value) implements Comparable<TimeRecord> {
        @Override
        public int compareTo(@NotNull final TimeRecord o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
