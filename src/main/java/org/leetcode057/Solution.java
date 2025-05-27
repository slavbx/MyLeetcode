package org.leetcode057;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{6,9}}; int[] newInterval = new int[]{2,5}; //{{1,5}, {6,9}}

        List<int[]> listIn = new ArrayList<>(Arrays.asList(intervals));
        //list = list.stream().distinct().collect(Collectors.toList());
        listIn.add(newInterval);
        listIn.sort(Comparator.comparingInt(s -> s[0]));
        //listIn.forEach(s -> System.out.print(Arrays.toString(s) + ", "));
        List<int[]> list = new ArrayList<>();

        int i = 0;
        int[] prev = new int[2];
        prev[0] = listIn.get(i)[0];
        prev[1] = listIn.get(i)[1];
        list.add(prev);
        //System.out.println("prev = " + Arrays.toString(prev));
        i++;
        while (i < listIn.size()) {
            int[] cur = new int[2];
            cur[0] = listIn.get(i)[0];
            cur[1] = listIn.get(i)[1];
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


        int[][] newIntervals = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            newIntervals[j] = list.get(j);
        }
        System.out.println();
        System.out.println(Arrays.deepToString(newIntervals));
    }
}
