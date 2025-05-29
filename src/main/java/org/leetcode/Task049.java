package org.leetcode049;

import java.util.*;

public class Task049 {
    public static void main(String[] args) {
        //String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] strs = new String[] {"ac","c"};
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            boolean saved = false;
            String[] arrStr = str.split("");
            Arrays.sort(arrStr);
            String arrStrString = String.join("", arrStr);
            List<String> list;
            if (map.containsKey(arrStrString)) {
                list = map.get(arrStrString);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(arrStrString, list);

        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        System.out.println(lists);
    }
}
