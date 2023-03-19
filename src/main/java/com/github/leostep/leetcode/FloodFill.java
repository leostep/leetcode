package com.github.leostep.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        final Queue<Point> pointsToCheck = new LinkedList<>();
        pointsToCheck.offer(new Point(sr, sc));
        while (!pointsToCheck.isEmpty()) {
            final Point p = pointsToCheck.poll();
            image[p.r][p.c] = color;
            if (p.r - 1 >= 0 && image[p.r - 1][p.c] == originalColor) {
                pointsToCheck.add(new Point(p.r - 1, p.c));
            }
            if (p.r + 1 < image.length && image[p.r + 1][p.c] == originalColor) {
                pointsToCheck.add(new Point(p.r + 1, p.c));
            }
            if (p.c - 1 >= 0 && image[p.r][p.c - 1] == originalColor) {
                pointsToCheck.add(new Point(p.r, p.c - 1));
            }
            if (p.c + 1 < image[p.r].length && image[p.r][p.c + 1] == originalColor) {
                pointsToCheck.add(new Point(p.r, p.c + 1));
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }

    private static final class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
