package org.leetcode;

import java.util.ArrayList;
import java.util.List;

// 66. Plus One
class Task066 {
    public int[] plusOne(int[] digits) {

        List<Integer> list = new ArrayList<>();
        for (int d: digits) {
            list.add(d);
        }

        boolean addDigit = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < 9) {
                list.set(i, list.get(i) + 1);
                break;
            }
            if ((list.get(i) == 9)) {
                if (i == 0) addDigit = true;
                list.set(i, 0);
                continue;
            }
        }
        if (addDigit) list.add(0, 1);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
