package org.leetcode026;

import java.util.Arrays;

public class Task026 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int[] temp = new int[nums.length];
        int t = 0;
        for (int n = 0; n < nums.length; n++) {
            if (n == 0) {
                temp[t] = nums[n];
                t++;
            } else {
                if (nums[n] == nums[n - 1]) {
                    temp[t] = nums[n];
                } else {
                    temp[t] = nums[n];
                    t++;
                }
            }
        }
        String str;


        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        return t;
    }
}
