package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. Combination Sum II
class Task040 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void recursive(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            if (!result.contains(current)) result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) { //against duplicates
                continue;
            }
            current.add(candidates[i]);
            recursive(candidates, target - candidates[i], i+1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
