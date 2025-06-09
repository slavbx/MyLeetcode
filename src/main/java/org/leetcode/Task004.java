package org.leetcode;

//4. Median of Two Sorted Arrays

class Task004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        double result = 0.0;

        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1] < nums2[n2]) {
                    merged[i] = nums1[n1];
                    n1++;
                } else {
                    merged[i] = nums2[n2];
                    n2++;
                }
            } else if (n1 >= nums1.length) {
                merged[i] = nums2[n2];
                n2++;
            } else {
                merged[i] = nums1[n1];
                n1++;
            }
        }

        int half = 0;
        if (merged.length % 2 == 1) {
            half = merged.length / 2 + 1;
            result = merged[half - 1];
        }
        if (merged.length % 2 == 0) {
            half = merged.length / 2;
            result = (double) (merged[half - 1] + merged[half]) / 2;
        }
        return result;
    }
}
