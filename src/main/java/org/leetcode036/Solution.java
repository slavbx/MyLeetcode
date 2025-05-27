package org.leetcode036;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        //System.out.println(Arrays.deepToString(board));
        boolean result = true;

        for (int i = 0; i < board.length; i++) { //Check rows
            char[] buffer = Arrays.copyOf(board[i], board[i].length);
            Arrays.sort(buffer);
            for (int j = 1; j < buffer.length; j++) {
                if (!(buffer[j] == '.') && buffer[j] == buffer[j-1]) {
                    result = false;
                    break;
                }
            }
            if (!result) break;
        }

        for (int i = 0; i < board.length; i++) { //Check columns
            char[] buffer = new char[board.length];
            for (int j = 0; j < board[0].length; j++) {
                buffer[j] = board[j][i];
            }
            //System.out.println(Arrays.toString(buffer));
            Arrays.sort(buffer);
            for (int j = 1; j < buffer.length; j++) {
                if (!(buffer[j] == '.') && buffer[j] == buffer[j-1]) {
                    result = false;
                    break;
                }
            }
            if (!result) break;
        }


        int b = 0;
        for (int left = 0; left < board.length / 3; left++) {
            for (int down = 0; down < board.length / 3; down++) {
                char[] buffer = new char[board.length];
                for (int i = 0; i < board.length / 3; i++) { //Check columns
                    for (int j = 0; j < board.length / 3; j++) {
                        buffer[b] = board[i + left * 3][j + down * 3];
                        System.out.println("i = " + (i + left * 3) + ", j = " + (j + down * 3));
                        b++;
                    }
                }
                b = 0;
                Arrays.sort(buffer);
                for (int j = 1; j < buffer.length; j++) {
                    if (!(buffer[j] == '.') && buffer[j] == buffer[j-1]) {
                        result = false;
                        break;
                    }
                }
                if (!result) break;
            }
        }
        System.out.println("result = " + result);
    }
}
