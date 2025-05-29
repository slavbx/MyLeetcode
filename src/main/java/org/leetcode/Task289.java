package org.leetcode;

import java.util.Arrays;

public class Task289 {
    public static void main(String[] args) {
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};

        int[][] bigBoard = new int[board.length + 2][board[0].length + 2];
        int[][] result = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bigBoard[i + 1][j + 1] = board[i][j];
            }
        }


        for (int i = 1; i < bigBoard.length - 1; i++) {
            for (int j = 1; j < bigBoard[0].length - 1; j++) {
                int sum = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    for (int m = j - 1; m < j + 2; m++) {
                        if (!(k == i && m == j)) {
                            sum = sum + bigBoard[k][m];
                        }
                    }
                }
                System.out.println(sum);
                if (bigBoard[i][j] == 1 && sum < 2) result[i - 1][j - 1] = 0;
                if (bigBoard[i][j] == 1 && (sum == 2 || sum == 3)) result[i - 1][j - 1] = 1;
                if (bigBoard[i][j] == 1 && sum > 3) result[i - 1][j - 1] = 0;
                if (bigBoard[i][j] == 0 && sum == 3) result[i - 1][j - 1] = 1;
            }
        }
        System.out.println(Arrays.deepToString(result));
    }
}
