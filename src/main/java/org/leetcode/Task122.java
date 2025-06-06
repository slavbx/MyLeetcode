package org.leetcode;

class Task122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int start = -1;
        for(int i = 0; i < prices.length - 1; i++) {
            //save start of positive sequence
            if (prices[i] < prices[i + 1] && start == -1) {
                start = i;
            }
            //fix sum at end of positive sequence
            if (prices[i] > prices[i + 1] && start >= 0) {
                sum = sum + prices[i] - prices[start];
                start = -1;
            }
            //save sum at end of array when positive sequence along to end of array
            if (start != -1 && i == prices.length - 2) {
                sum = sum + prices[i + 1] - prices[start];
            }
        }
        return sum;
    }
}
