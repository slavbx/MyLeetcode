package org.leetcode;

import java.util.Arrays;

public class Task034 {
    public static void main(String[] args) {
        //int[] result = searchRange(new int[] {5,7,7,8,8,10}, 8);
        //int[] result = searchRange(new int[] {5,7,7,8,8,10}, 6);
        //int[] result = searchRange(new int[] {2,2}, 3);
        //int[] result = searchRange(new int[] {2,2}, 2);
        //int[] result = searchRange(new int[] {1,4}, 4);
        int[] result = searchRange(new int[] {1,2,2}, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = -1;
        int half = -1;

        if (nums.length == 0) return new int[] {-1, -1};

        while (true) { //search of target
            if (start == end) {
                half = start;
            } else {
                half = ((end - start) / 2) + start;
            }

            System.out.println(start + ", " + end + ", " + half);

            if (nums[start] == target) {
                pivot = start;
                break;
            }

            if (nums[end] == target) {
                pivot = end;
                break;
            }

            if (nums[half] < target) {
                start = half;
            } else if (nums[half] > target) {
                end = half;
            } else {
                pivot = half; //finded
                break;
            }
            if (start == end) break;

            if (start == end - 1 && nums[start] < target && nums[end] > target) {
                break;
            }
            if (start == 0 && end == start + 1 && nums[start] != target && nums[end] != target) {
                break;
            }
            if (start == end - 1 && end == nums.length - 1 && nums[start] != target && nums[end] != target) {
                break;
            }

        }
        System.out.println(pivot);
        if (pivot < 0) return new int[] {-1, -1};

        start = pivot;
        end = pivot;

        boolean search = false;
        while (true) {
            search = false;
            if (start >= 1) {
                if (nums[start - 1] == nums[pivot]) {
                    start--;
                    search = true;
                }
            }
            if (end <= nums.length - 2) {
                if (nums[end + 1] == nums[pivot]) {
                    end++;
                    search = true;
                }
            }

            if (!search) break;
            if (start == 0 && end == nums.length - 1) break;
            if (start > 1 && nums[start - 1] != nums[pivot] && end < nums.length - 1 && nums[end + 1] != nums[pivot]) break;
        }

        return new int[] {start, end};
    }
}


