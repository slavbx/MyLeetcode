package org.leetcode134;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        //System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
        //System.out.println(canCompleteCircuit(new int[]{3,3,4}, new int[]{3,4,4}));
        //System.out.println(canCompleteCircuit(new int[]{4,5,2,6,5,3},
        //                                      new int[]{3,2,7,3,2,9}));
        System.out.println(canCompleteCircuit(new int[]{2,0,1,2,3,4,0},
                                              new int[]{0,1,0,0,0,0,11}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gascirc = new int[gas.length * 2];
        int[] costcirc = new int[cost.length * 2];
        int tank = 0;

        System.arraycopy(gas, 0, gascirc, 0, gas.length);
        System.arraycopy(gas, 0, gascirc, gas.length, gas.length);
        System.arraycopy(cost, 0, costcirc, 0, cost.length);
        System.arraycopy(cost, 0, costcirc, cost.length, cost.length);

        System.out.println(Arrays.toString(gascirc));
        System.out.println(Arrays.toString(costcirc));

        int result = -1;
        for (int i = 0; i < gas.length; i++) { //search start station
            System.out.println("i = " + i);
            if (gas[i] >= cost[i]) {
                tank = gas[i];
                result = i;

                    for (int j = i; j < gas.length + i; j++) { //search route from start station
                        if (cost[i] != 0) {
                        if (tank < costcirc[j]) {
                            result = -1;
                            break;
                        }
                        System.out.println("tank = " + tank + " j = " + j + " gas = " + gascirc[j] + " coast = " + costcirc[j]);
                        tank = tank - costcirc[j] + gascirc[j + 1];
                        }
                    }

                if (result >= 0) break;

            }
        }
        return result;
    }
}
