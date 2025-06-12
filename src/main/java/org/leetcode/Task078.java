package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
class Task078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int max = (int)Math.pow(2, nums.length) - 1;

        /*
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        1   00001111
        2   00110001
        3   01010111 generate all bit masks for value nums.length
        */

        for (int mask = 0; mask <= max; mask++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((mask >> j) & 1) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
