package org.leetcode;

import java.util.Arrays;

//79. Word Search
public class Task079 {
    public static void main(String[] args) {
        //System.out.println(exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        //System.out.println(exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean result = false;
        boolean[][] finded = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = result || recursive(board, word, 0, i, j, finded);
                }
            }
        }
        System.out.println("finded = " + Arrays.deepToString(finded));
        return result;
    }

    public static boolean recursive(char[][] board, String word, int num, int row, int col, boolean[][] finded) {
        finded[row][col] = true;
        //System.out.println("finded = " + Arrays.deepToString(finded) + " " + word.charAt(num));
        if (num == word.length() - 1) {
            return true;
        }

        if (num < word.length() - 1) {
            num++;
        }

        if (row - 1 >= 0 && row - 1 <= board.length - 1 && !finded[row - 1][col] && board[row - 1][col] == word.charAt(num)) {
            if (recursive(board, word, num, row - 1, col, finded)) return true;
        }
        if (row + 1 >= 0 && row + 1 <= board.length - 1 && !finded[row + 1][col] && board[row + 1][col] == word.charAt(num)) {
            if ( recursive(board, word, num, row + 1, col, finded)) return true;
        }
        if (col - 1 >= 0 && col - 1 <= board[row].length - 1 && !finded[row][col - 1] && board[row][col - 1] == word.charAt(num)) {
            if ( recursive(board, word, num, row, col - 1, finded)) return true;
        }
        if (col + 1 >= 0 && col + 1 <= board[row].length - 1 && !finded[row][col + 1] && board[row][col + 1] == word.charAt(num)) {
            if ( recursive(board, word, num, row, col + 1, finded)) return true;
        }
        finded[row][col] = false;
        return false;
    }
}
