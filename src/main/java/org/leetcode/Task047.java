package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//47. Permutations II
class Task047 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        recursive(map, new ArrayList<>(), result);

        return result;
    }

    /* In cycle after add cur num in current list jump to recursive, where add other nums.
        after that save current list and return by recursive step by step clear current list
        to the end return in cycle for where continue to add other cur nums in cycle for in other order
    */
    private void recursive(Map<Integer, Integer> map, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == map.size()) {

            List<Integer> values = new ArrayList<>();
            for (Integer key : current) {
                values.add(map.get(key));
            }
            if (!result.contains(values)) {
                result.add(new ArrayList<>(values));
            }
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!current.contains(entry.getKey())) {
                current.add(entry.getKey());
                recursive(map, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
