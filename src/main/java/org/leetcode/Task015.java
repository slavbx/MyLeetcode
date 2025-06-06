package org.leetcode;

import java.util.*;

class Task015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 2) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == nums[i] * (-1)) {
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        set.add(triplet);
                        left++;
                    }
                    if (nums[left] + nums[right] > nums[i] * (-1)) right--;
                    if (nums[left] + nums[right] < nums[i] * (-1)) left++;
                }
            }
        }
        list.addAll(set);
        return list;
    }
}
