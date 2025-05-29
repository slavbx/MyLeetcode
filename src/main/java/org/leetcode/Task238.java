package org.leetcode;

import java.util.Arrays;

public class Task238 {
    public static void main(String[] args) {
        //int[] input = new int[]{2, 3, 0, 0};
        //int[] input = new int[]{5,9,2,-9,-9,-7,-8,7,-9,10};
        //int[] input = new int[]{1,1,1,1,-1,1,5,1,-1,-1,-1,1,-1,1,-3,1,1,1,1,1,1,1,-1,1,-1,1,1,5,-1,1,-1,1,1,3,-1,-5,-1,1,-1,1,-1,-3,1,2,-1,1,-1,1,-1,1,1,1,1,1,-1,-1,-1,-3,-1,-1,4,-1,1,-1,1,-1,-1,-1,-1,3,1,4,-5,-1,1,1,1,1,1,-4,1,1,-3,-1,-1,1,3,-1,1,-2,1,-1,1,1,1,-1,1,1,1,-1};
        //int[] input = new int[]{1, -1};
        int[] input = new int[]{0, 2, 3, 4};
        //int[] input = new int[]{-1, 1, 0, -3, 3};
        System.out.println("Ответ = " + Arrays.toString(productExceptSelf(input)));

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int allMul = 1;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeroes++;
            } else {
                allMul = allMul * nums[i];
                if (i == 0) {
                    allMul = nums[i];
                }
            }
        }
        System.out.println(allMul);

        if (zeroes == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    result[i] = allMul;
                    continue;
                }
                if (nums[i] == -1) {
                    result[i] = -allMul;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        result[i] = result[j];
                        break;
                    }
                }
                if (result[i] > 0) continue;



                int cnt = 0;
                int tmp = Math.abs(allMul);
                int num = Math.abs(nums[i]);

                if (num == 1) {
                    cnt = tmp;
                } else if (nums[i] == -1) {
                    cnt = -tmp;
                } else {
                    while (tmp != 0) {
                        tmp = tmp - num;
                        cnt++;
                    }
                }

                if ((nums[i] < 0 && allMul >= 0) || ((allMul < 0 && nums[i] >= 0))) {
                    result[i] = -cnt;
                } else {
                    result[i] = cnt;
                }
            }
        } else if (zeroes == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) result[i] = allMul;
            }
        }
        return result;
    }
}
