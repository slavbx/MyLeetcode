package org.leetcode028;

import java.util.*;

public class Task028 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2}; //4
        //int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1}; //9
        //int[] nums = new int[]{1,0,1,2}; //3

        Arrays.sort(nums);
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
            } else if (!(nums[i] == nums[i - 1])) {
                cnt = 1;
            }
            if (cnt > max) max = cnt;
        }

        System.out.println(max);
        List<String> list = new ArrayList<>();

                Collections.sort(list, Comparator.comparingInt(Integer::parseInt));

    }
}
