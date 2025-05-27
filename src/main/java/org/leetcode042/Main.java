package org.leetcode042;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] height = new int[] {100,0,99,0,98,0,97,0,96,0,95,0,94};
//        int[] height = new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
        int[] height = new int[] {4,2,0,3,2,5};
        boolean[] checked = new boolean[height.length];
        int checks = 0;
        int square = 0;
        int level = 0;

        for (int i = 0; i < height.length; i++) { //search maximum level
            if (height[i] > level) level = height[i];
        }

        for (int i = level; i > 0; i--) { //run each level 3..2..1
            if (checks >= checked.length - 1) break;
            int start = 0; //jump all empty heights at start
            boolean flag = false;
            for (int j = 0; j < height.length; j++) {
                if (checked[j]) flag = true;
                if ((!checked[j] || flag) && height[j] >= i) {
                    start = j;
                    break;
                }
            }
            flag = false;
            int end = 0; //jump all empty heights at end
            for (int j = height.length - 1; j >= 0; j--) {
                if (checked[j]) flag = true;
                if ((!checked[j] || flag) && height[j] >= i) {
                    end = j;
                    break;
                }
            }
            for (int j = start; j < end; j++) { //across all heights
                if (!checked[j]) {
                    if (height[j] == 0) {
                        square = square + i;
                        checked[j] = true;
                        checks++;
                        if (j > 0 && height[j - 1] >= i) checked[j - 1] = true;
                    } else if (height[j] < i) {
                        square++;
                        //checks++;
                    } else {
                        checked[j] = true;
                        checks++;
                    }
                }
                if (checks >= checked.length - 1) break;
            }
            System.out.println(Arrays.toString(checked));
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("square = " + square);
        }

    }
}
