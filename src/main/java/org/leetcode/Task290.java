package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Task290 {
    public static void main(String[] args) {
        //String pattern = "abba"; String s = "dog cat cat dog";
        String pattern = "abba"; String s = "dog dog dog dog";
        Map<String, String> map = new HashMap<>();
        String[] keys = pattern.split("");
        String[] values = s.split(" ");
        boolean result = true;

        for (int i = 0; i < keys.length; i++) {
            if (!map.containsKey(keys[i])) {
                if (map.containsValue(values[i])) {
                    result = false;
                    break;
                } else {
                    map.put(keys[i], values[i]);
                }
            } else {
                if (!map.get(keys[i]).equals(values[i])) {
                    result = false;
                    break;
                }
            }
        }

        System.out.println(map);
    }
}
