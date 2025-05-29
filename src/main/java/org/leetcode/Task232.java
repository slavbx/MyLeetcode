package org.leetcode;

public class Task232 {
    public static void main(String[] args) {
        String s = "abc";
        //String t = "ahbgdc";
        String t = "bca";

        //        String pattern = s.replaceAll("", ".*");
//        return t.matches(pattern);
        boolean result = false;
        int cursor = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.length() > 0 && t.length() > 0 && t.charAt(i) == s.charAt(cursor)) {
                cursor++;
            }
        }

        if (s.length() > 1 && cursor == s.length()) result = true;

        if (s.length() == 0) result = true;
        System.out.println("cursor = " + cursor);
        System.out.println(result);


    }
}
