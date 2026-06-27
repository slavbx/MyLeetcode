package org.leetcode;

import java.util.Arrays;

//59. Spiral Matrix II
public class Task059 {
    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(generateMatrix(1)));
        //System.out.println(Arrays.deepToString(generateMatrix(2)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        //System.out.println(Arrays.deepToString(generateMatrix(4)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int right = n - 1;
        int down = n - 1;
        int left = 0;
        int up = 0;
        int num = 0;

        while (num < n * n) {
            for (int j = left; j <= right; j++) matrix[up][j] = ++num;
            if (num == n * n) break;
            num--;
            for (int j = up; j <= down; j++) matrix[j][right] = ++num;
            if (num == n * n) break;
            num--;
            for (int j = right; j >= left; j--) matrix[down][j] = ++num;
            if (num == n * n) break;
            num--;
            up++;
            right--;
            for (int j = down; j >= up; j--) matrix[j][left] = ++num;
            if (num == n * n) break;
            left++;
            down--;

        }
        return matrix;
    }
}

