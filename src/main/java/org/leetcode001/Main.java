package org.leetcode001;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,2,3,0,4,2};

        removeElement(nums, 2);

        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        nums[0] = -12;
        nums = new int[] {1,2};

        return 0;
    }
}
