package org.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//22. Generate Parentheses
class Task022 {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();

        recursive(n, new ArrayList<>(), result, 0);
        return new ArrayList<>(result);
    }

    /*  Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
    */

    private void recursive(int n, List<String> current, Set<String> result, int toClose) {
        String s = String.join("", current);

        if (toClose != 0 && s.length() >= n * 2) return;
        if (toClose == 0 && s.length() >= n * 2) {
            result.add(s);
            return;
        }

        current.add("(");
        current.add(")");
        recursive(n, current, result, toClose);
        current.remove(current.size() - 1); //backup
        current.remove(current.size() - 1); //backup

        current.add("(");
        recursive(n, current, result, toClose + 1); //go in recursive with open (
        current.remove(current.size() - 1);

        if (toClose > 0) {
            current.add(")");
            recursive(n, current, result, toClose - 1);
            current.remove(current.size() - 1);
        }
    }
}
