package org.leetcode;

//17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task073 {
    List<List<String>> lists = new ArrayList<>();
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));

        for (int i = 0; i < digits.length(); i++) {
            Integer digit = Integer.parseInt(digits.substring(i, i + 1));
            lists.add(map.get(digit));
        }

        recursive(0, "");

        return combinations;
    }

    private void recursive(int numList, String combination) {
        if (lists.isEmpty()) return;
        if (numList == lists.size()) {
            combinations.add(combination);
            return;
        }

        List<String> list = lists.get(numList);
        for (String symbol : list) {
            recursive(numList + 1, combination + symbol);
        }
    }
}
