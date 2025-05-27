package org.leetcode055;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
            boolean[] checked = new boolean[nums.length];
            ArrayDeque<ArrayList<Integer>> stack = new ArrayDeque<>();

            stack.add(new ArrayList<>(List.of(0)));
            while (!stack.isEmpty()) {


                for (Integer pos : stack.pop()) {
                    ArrayList<Integer> jumps = new ArrayList<>();
                    int start = pos - nums[pos];
                    int end = pos + nums[pos];
                    if (start < 0) start = 0;
                    if (end > nums.length - 1) end = nums.length - 1;

                    for (int i = start; i <= end; i++) {
                        if (!checked[i]) {
                            jumps.add(i);
                            checked[i] = true;
                        }
                    }
                    stack.add(jumps);
                }
            }

            return checked[checked.length - 1];
    }
}
