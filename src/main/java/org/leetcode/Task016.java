package org.leetcode;

//16. 3Sum Closest
class Task016 {
    public int threeSumClosest(int[] nums, int target) {

        int result = Integer.MIN_VALUE;

        for (int pivot = 0; pivot < nums.length; pivot++) {
            for (int i = pivot + 1; i < nums.length; i++) {  //with skip known at start of cycle
                for (int j = i + 1; j < nums.length; j++) {
                    if (i != j && i != pivot && j != pivot) {
                        int sum = nums[pivot] + nums[i] + nums[j];
                        //long for tests with overflow int
                        if (Math.abs((long)(sum - target)) < Math.abs((long)(result - target))) result = sum;
                    }

                }
            }
        }
        return result;
    }
}
