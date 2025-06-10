package org.leetcode;

//35. Search Insert Position
class Task035 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int half = (end - start) / 2 + start;

        while (end - start > 0) { //div array to half for find target value until array = [0,1]
            if (target <= nums[half]) end = half;
            if (target > nums[half]) start = half + 1;
            half = (end - start) / 2 + start;
        }

        if (target <= nums[start]) return start;
        if (target >= nums[end]) return end + 1;
        if (target > nums[start] && target < nums[end]) return start;

        return 0;
    }
}
