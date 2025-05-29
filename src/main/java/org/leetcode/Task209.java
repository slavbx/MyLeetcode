package org.leetcode;

public class Task209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};//7
        //int[] nums = new int[]{1,1,1,1,1,1,1,1};
        //int[] nums = new int[]{1,2,3,4,5};
        //int[] nums = new int[]{1,1,1,1,7}; //1
        int minLength = 0;
        int i = 0;
        int j = 0;
        int sum = nums[0];
        while (i < nums.length && j < nums.length) {
            if (sum >= target) {
                if (minLength == 0 || j - i + 1 < minLength) minLength = j - i + 1;
                sum = sum - nums[i];
                i++;
            } else if (sum < target) {
                if (j < nums.length - 1) {
                    sum = sum + nums[j + 1];
                    j++;
                } else if (i == 0) {
                    break;
                } else if (j == nums.length - 1) {
                    break;
                }
            }
            System.out.println("i = " + i + "; j = " + j+ "; sum = " + sum);
            if (i > nums.length && j > nums.length) break;
        }

        System.out.println(minLength);
    }
}
