package org.leetcode;

import java.util.Arrays;

public class Task031 {
    public static void main(String[] args) {
        nextPermutation(new int[] {1, 2, 3}); //[1, 3, 2]
        nextPermutation(new int[] {3, 2, 1}); //[1, 2, 3]
        nextPermutation(new int[] {1, 1, 5}); //[1, 5, 1]
        nextPermutation(new int[] {2, 3, 1, 3, 3}); //[2, 3, 3, 1, 3]
        nextPermutation(new int[] {1, 3, 2}); //[2, 1, 3]
        nextPermutation(new int[] {2, 3, 1}); //[3, 1, 2]
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) return;

        int start = nums.length - 2;
        int end = nums.length - 1;

        while (start >= 0) {
            if (nums[start] < nums[end]) break;
            if (start == 0) {
                Arrays.sort(nums);
                System.out.println("nums = " + Arrays.toString(nums));
                return;
            }
            start--;
            end--;
        }
        //System.out.println("start = " + start);
        end = nums.length - 1;
        Arrays.sort(nums, start + 1, end + 1);
        //System.out.println("nums = " + Arrays.toString(nums));

        int next = 0;
         for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                next = i;
                break;
            }
        }

        int temp = nums[next];
        nums[next] = nums[start];
        nums[start] = temp;
        Arrays.sort(nums, start + 1, end + 1);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
