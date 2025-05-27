package org.leetcode042;

import java.util.Arrays;

public class Solution {
//    public static void main(String[] args) {
//        //int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height = new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
//        //int[] height = new int[] {4,2,0,3,2,5};
//        int square = 0;
//        int level = 0;
//
//        for (int i = 0; i < height.length; i++) { //search maximum level
//            if (height[i] > level) level = height[i];
//        }
//
//        for (int i = level; i > 0; i--) { //run each level 3..2..1
//            int start = -1;
//            for (int j = 0; j < height.length; j++) { //across all heights
//                if (height[j] >= i) {
//                    if (start >= 0) {
//                        if (j - start == 2 && height[j - 1] == 0) {
//                            square = square + i;
//                            height[j - 1] = i;
//                            start = j;
//                        } else {
//                            square = square + j - start - 1; //may simply for husband
//                            start = j;
//                        }
//                    } else {
//
//                        start = j;
//                    }
//
//                }
//            }
//        }
//        System.out.println("square = " + square);
//    }

    public static void main(String[] args) {
        //int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
        int[] height = new int[] {4,2,0,3,2,5};
        int square = 0;
        int level = 0;

        for (int i = 0; i < height.length; i++) { //search maximum level
            if (height[i] > level) level = height[i];
        }

        for (int i = level; i > 0; i--) { //run each level 3..2..1
            int start = -1;
//            for (int j = 0; j < height.length; j++) {
//                if (height[j] >= i) {
//                    start = j - 1;
//                    break;
//                }
//            }
//
            int end = height.length;
//            for (int j = height.length - 1; j > 0; j--) {
//                if (height[j] >= i) {
//                    end = j + 1;
//                    break;
//                }
//            }

//            System.out.println("start = " + start);
//            System.out.println("end = " + end);

            for (int j = start; j < end; j++) { //across all heights
                if (height[j] >= i) {
                    if (start >= 0) {
                            square = square + j - start - 1; //may simply for husband
                            start = j;
                    } else {

                        start = j;
                    }

                }
//                            System.out.println("start = " + start);
//            System.out.println("end = " + end);
            }
        }
        System.out.println("square = " + square);
    }
}
