package org.leetcode;

public class Task283 {
    public void moveZeroes(int[] nums) {
        int pivot = 0;
        int zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pivot] = nums[i];
                pivot++;
            }
            if (i >= nums.length - zeros) nums[i] = 0;
        }

    }
}
