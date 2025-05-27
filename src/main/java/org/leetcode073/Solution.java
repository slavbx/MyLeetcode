package org.leetcode073;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};

        Set<Integer> setI = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }

        for(Integer i : setI) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for(Integer j : setJ) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

}
