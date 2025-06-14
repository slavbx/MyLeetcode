package org.leetcode;

import java.util.ArrayList;
import java.util.List;

//93. Restore IP Addresses
class Task093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        recursive(0, s, new ArrayList<>(), "", result);

        return result;
    }

    private void recursive(int start, String s, List<String> list, String current, List<String> result) {
        if (s == null) return;
        if (!current.isEmpty()) {
            if (Integer.parseInt(current) > 255) return;
            if (current.length() > 1 && current.startsWith("0")) return;

            if (list.size() == 4) {
                if (start == s.length()) {
                    result.add(String.join(".", list));
                }
                return;
            }
        }

        for (int i = 1; i < 4; i++) {
            if (start + i <= s.length()) {
                current = s.substring(start, start + i);
                list.add(current);
                recursive(start + i, s, list, current, result);
                if (!list.isEmpty()) list.remove(list.size() - 1);
            }
        }

    }
}
