package org.leetcode;

import java.util.HashMap;
import java.util.Map;

class Task076 {
    Map<Character, Integer> map = new HashMap<>();
    Map<Character, Integer> mapWindow = new HashMap<>();

    public String minWindow(String s, String t) {
        String result = "";

        for (int i = 0; i < t.length(); i++) { //build map with chars
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        int start = 0;
        int end = 0;
        mapWindow.merge(s.charAt(start), 1, Integer::sum);
        while (end < s.length()){
            if (!strExistsChars()) {
                end++;
                if (end < s.length()) {
                    mapWindow.put(s.charAt(end), mapWindow.getOrDefault(s.charAt(end), 0) + 1);
                }
            } else {

                while (start < end - 1 && !strExistsChars()) {
                    decrease(mapWindow, s.charAt(start));
                    start++;
                }
                if (!strExistsChars()) {
                    start--;
                    mapWindow.put(s.charAt(start), mapWindow.getOrDefault(s.charAt(start), 0) + 1);
                }
                if (result.isEmpty() || s.substring(start, end + 1).length() <= result.length()) {
                    result = s.substring(start, end + 1);
                }
                decrease(mapWindow, s.charAt(start));
                start++;
            }
        }
        return result;
    }

    public boolean strExistsChars() {
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            Character key = m.getKey();
            Integer value = m.getValue();
            if (!mapWindow.containsKey(key)) return false;
            if (mapWindow.get(key) < value) return false;
        }
        return true;
    }

    public void decrease(Map<Character, Integer> map, Character key) {
        if (map.containsKey(key)) {
            map.merge(key, -1, Integer::sum);
            if (!(map.get(key) > 0)) {
                map.remove(key);
            }
        }
    }
}

