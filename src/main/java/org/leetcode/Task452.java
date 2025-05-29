package org.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Task452 {
    public static void main(String[] args) {
        //int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
//        int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
//        int[][] points = new int[][]{{0, 10}, {20, 30}, {40, 50}, {60, 70}};
//        int[][] points = new int[][]{{-10, -5}, {-7, 0}, {2, 5}, {7, 10}};
//        int[][] points = new int[][]{{100, 200}, {150, 250}, {180, 220}, {210, 230}};
//        int[][] points = new int[][]{{-50, -40}, {-30, -20}, {-10, 0}, {10, 20}, {30, 40}};
//        int[][] points = new int[][]{{500, 510}, {520, 530}, {540, 550}, {560, 570}, {580, 590}};
//        int[][] points = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
//        int[][] points = new int[][]{{10, 20}, {30, 40}, {50, 60}, {70, 80}, {90, 100}};
//        int[][] points = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int[][] points = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Arrays.sort(points, Comparator.comparingInt((a -> a[1])));
        System.out.println(Arrays.deepToString(points));

        int cnt = 1;
        int max = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (!(max >= points[i][0] && max <= points[i][1])) {
                cnt++;
                max = points[i][1];
            }
        }
        System.out.println(cnt);
    }
}
