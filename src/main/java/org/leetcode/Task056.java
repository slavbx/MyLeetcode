package org.leetcode056;

import java.util.*;

public class Task056 {
    public static void main(String[] args) {
        //int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}}; //{{1,6},{8,10},{15,18}}
        //int[][] intervals = new int[][]{{1,4},{4,5}}; //{{1,5}}
        //int[][] intervals = new int[][]{{1,4},{0,5}}; //{{0,5}}
        //int[][] intervals = new int[][]{{1,4},{1,4}}; //{{1,4}}
        //int[][] intervals = new int[][]{{1,4},{0,0}}; //{{0,0},{1,4}}
        //int[][] intervals = new int[][]{{1,4},{0,2},{3,5}}; //{{0,5}}
        //int[][] intervals = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}}; //{{1,3},{4,7}}
        //int[][] intervals = new int[][]{{5,5},{1,3},{3,5},{4,6},{1,1},{3,3},{5,6},{3,3},{2,4},{0,0}}; //{{0,0},{1,6}}
        //int[][] intervals = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}}; //{{1,3},{4,7}}
        //int[][] intervals = new int[][]{{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}}; //{{0,6}}
        int[][] intervals = new int[][]{{0,2},{2,3},{4,4},{0,1},{5,7},{4,5},{0,0}}; //{{0,3},{4,7}}

//        List<int[]> list = new ArrayList<>();
//        list.addAll(Arrays.asList(intervals));
//        //Collections.sort(list, Comparator.comparingInt(s -> Integer.parseInt(s.split(" ")[0])));
        Arrays.sort(intervals, Comparator.comparingInt((a -> a[0])));
        System.out.println(Arrays.deepToString(intervals));

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] prev = new int[2];
            prev[0] = intervals[i][0];
            prev[1] = intervals[i][1];
            list.add(prev);
            //System.out.println("prev = " + Arrays.toString(prev));
            i++;
            while (i < intervals.length) {
                int[] cur = new int[2];
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
                //System.out.println("prev = " + Arrays.toString(prev) + " cur = " + Arrays.toString(cur));
                if (prev[0] == cur[0] && prev[1] <= cur[1]) {
                    prev[0] = cur[0];
                    prev[1] = cur[1];
                    i++;
                } else if (prev[0] == prev[1] && prev[0] == 0) {
                    if (!Arrays.equals(cur, prev)) list.add(cur);
                    prev = cur;
                    i++;
                    //break;
                } else if (cur[0] <= prev[1]) {
                    prev[1] = Math.max(prev[1], cur[1]);
                    i++;
                } else {
                    list.add(cur);
                    prev = cur;
                    //break;
                }
            }
        }

        int[][] newIntervals = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            newIntervals[i] = list.get(i);
        }
        System.out.println();
        System.out.println(Arrays.deepToString(newIntervals));
        //System.out.println("prev = " + Arrays.toString(prev) + " cur = " + Arrays.toString(cur));

    }
}
