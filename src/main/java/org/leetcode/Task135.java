package org.leetcode;

class Task135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int sum = 0;

        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        for (int i = 0; i < candies.length; i++) candies[i] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }

        for(int i = 0; i < candies.length; i++) sum = sum + candies[i];

        return sum;
    }
}
