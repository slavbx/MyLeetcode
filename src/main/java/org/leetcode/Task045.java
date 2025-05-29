package org.leetcode045;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Task045 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println("Ответ: " + jump(nums));
    }

    public static int jump(int[] nums) {
        ArrayDeque<ArrayList<Integer>> stack = new ArrayDeque<>();
        boolean[] checked = new boolean[nums.length];
        int cnt = 0;
        boolean finish = false;

        if (nums.length > 1) {
            stack.add(new ArrayList<>(List.of(0)));
        } else {
            finish = true;
        }

        while (!finish) {
            ArrayList<Integer> jumps = new ArrayList<>();
            for (Integer pos: stack.pop()) {
                if (pos == nums.length - 1) finish = true;
                int end = pos + nums[pos];
                if (end > nums.length - 1) end = nums.length - 1;

                for (int i = pos + 1; i <= end; i++) {
                    if (!checked[i]) {
                        jumps.add(i);
                        checked[i] = true;
                    }
                }
            }
            if (!finish) cnt++;
            stack.add(jumps);
        }
        return cnt;
    }
}
