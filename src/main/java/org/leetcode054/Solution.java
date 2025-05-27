package org.leetcode054;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1; //columns
        int up = 0;
        int down = matrix.length - 1; //rows
        int step = matrix.length * matrix[0].length;

        for (int j = 0; j < step; ) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
                j++;
                if (j >= step) break;
            }
            up++;
            if (j >= step) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
                j++;
                if (j >= step) break;
            }
            right--;
            if (j >= step) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
                j++;
                if (j >= step) break;
            }
            down--;
            if (j >= step) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
                j++;
                if (j >= step) break;
            }
            left++;
            if (j >= step) break;
        }

        System.out.println(list);
    }
}
