package org.leetcode;

//75. Sort Colors
class Task075 {
    public void sortColors(int[] nums) {
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    changed = true;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }
}
