package org.leetcode;

public class Task1071 {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str2.length(); i++) {
            if (!str1.replaceAll(str2.substring(0, i + 1), "").equals("")) continue;
            if (!str2.replaceAll(str2.substring(0, i + 1), "").equals("")) continue;

            sb.setLength(0);
            sb.insert(0, str2.substring(0, i + 1));
        }
        return sb.toString();
    }
}
