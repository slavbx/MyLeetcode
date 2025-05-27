package org.leetcode274;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 6, 1, 5};
        System.out.println("Ответ: " + hIndex(nums));
    }

    public static int hIndex(int[] citations) {
        int result = 0;
        int cnt = 0;
        Arrays.sort(citations);

        for (int citation : citations) {
            if (citation > 0) cnt++;
        }
        int[] buffer = new int[cnt];

        cnt = 0;
        for (int citation : citations) {
            if (citation > 0) {
                buffer[buffer.length - cnt - 1] = citation;
                cnt++;
            }
        }

        for(int i = 0; i < buffer.length; i++) {
            if (buffer[i] >= i + 1) {
                result = i + 1;
            }
        }
        return result;
    }
}
