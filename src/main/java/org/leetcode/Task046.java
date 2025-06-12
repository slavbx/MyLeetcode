package org.leetcode;


import java.util.ArrayList;
import java.util.List;

//46. Permutations
class Task046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(nums, new ArrayList<>(), result);

        return result;
    }

    /* In cycle after add cur num in current list jump to recursive, where add other nums.
        after that save current list and return by recursive step by step clear current list
        to the end return in cycle for where continue to add other cur nums in cycle for in other order
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    */
    private void recursive(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                recursive(nums, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
