package org.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//90. Subsets II
class Task090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int max = (int)Math.pow(2, nums.length) - 1;

        /*
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        1   00001111
        2   00110011
        3   01010101 generate all bit masks for value nums.length
        */

        for (int mask = 0; mask <= max; mask++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((mask >> j) & 1) != 0) {
                    list.add(nums[j]);
                }
            }
            Collections.sort(list);
            if (!result.contains(list)) result.add(list);
        }
        return result;
    }
}
