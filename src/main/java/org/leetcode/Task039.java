package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//39. Combination Sum
class Task039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        recursive(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void recursive(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            recursive(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
