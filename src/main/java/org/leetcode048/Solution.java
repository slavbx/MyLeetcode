package org.leetcode048;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {  //rotate by diagonal
                if (j > i) { //only one action, never back
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) { //mirroring columns
            int left = 0;
            int right = matrix[0].length - 1;
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
                if (left >= right) break;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
