package org.leetcode219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,1,2,3}; int k = 2; //false
       int[] nums = {1,2,3,1}; int k = 3; //true
        //int[] nums = {1}; int k = 1;

        Map<Integer, Integer> map = new HashMap<>();
        boolean result = false;

        for (int i = 0; i <= k; i++) { //initial map
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                result = true;
            }
        }
        //System.out.println(map);

        for (int i = k + 1; i < nums.length; i++) {
            if (map.containsKey(nums[i - k - 1])) {
                if (map.get(nums[i - k - 1]) == 1) {
                    map.remove(nums[i - k - 1]);
                } else {
                    map.put(nums[i - k - 1], map.get(nums[i - k - 1]) - 1);
                }
            }
           // System.out.println(map);
            map.merge(nums[i], 1, Integer::sum);
            //System.out.println(map);
            if (map.get(nums[i]) > 1) {
                //System.out.println(i);
                result = true;
                break;
            }

        }
        System.out.println(result);
    }
}
