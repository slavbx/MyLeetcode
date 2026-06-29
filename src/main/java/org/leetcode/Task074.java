package org.leetcode;

//74. Search a 2D Matrix
public class Task074 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3));
        System.out.println(searchMatrix(new int[][] {{1,1}, {1, 1}}, 1));
        System.out.println(searchMatrix(new int[][] {{1}}, 1));
        System.out.println(searchMatrix(new int[][] {{1,1}}, 0));
        System.out.println(searchMatrix(new int[][] {{1,3,5}}, 4));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        int half = 0;

        while (left < right) {
            half = (right - left) / 2 + left;
            //System.out.println("matrix[half][0] = " + matrix[half][0] + ", left = " + left + ", right = " + right);
            if (left == right - 1) {
                if (matrix[left][0] == target) return true;
                if (matrix[half][0] == target) return true;
                break;
            }

            if (matrix[half][0] > target) {
                right = half;
            } else {
                left = half;
            }
        }
        //left - found row
        int row = left;
        left = 0;
        right = matrix[0].length - 1;

        while (left < right) {
            half = (right - left) / 2 + left;
            //System.out.println("matrix[row][half] = " + matrix[row][half] + ", left = " + left + ", half = " + half + ", right = " + right);
            if (matrix[row][half] == target ||
                    matrix[row][left] == target||
                    matrix[row][right] == target) {
                return true;
            }

            if (left == right - 1) {
                if (matrix[row][left] == target) return true;
                if (matrix[row][half] == target) return true;
                return false;
            }

            if (matrix[row][half] > target) {
                right = half;
            } else {
                left = half;
            }
        }
        return false;
    }
}
