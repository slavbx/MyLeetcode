package org.leetcode076;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //String s = "ADOBECODEBANC"; String t = "ABC"; //BANC
        //String s = "bba"; String t = "ab"; //ba
        //String s = "cabwefgewcwaefgcf"; String t = "cae"; //cwae
        String s = "aaaaaaaaaaaabbbbbcdd"; String t = "abcdd"; //abbbbbcdd
        int minLength = 0;
        List<String> subList = new ArrayList<>();
        String result = "";


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) { //build map with finded chars
            map.merge(String.valueOf(t.charAt(i)), 1, Integer::sum);
        }
        //System.out.println(map);
        int second = 0;
        int start = 0;
        Map<String, Integer> charsMap = new HashMap<>(map);
        for (int i = start; i < s.length(); i++) {

            //System.out.println("start = " + start);
//            for (int j = start; j < s.length(); j++) {
//                if (charsMap.get(String.valueOf(s.charAt(j))) != null) {
//                    //System.out.println("start = " + start);
//                    start = j;
//                    break;
//                }
//            }

            int cnt = 0;
            if (charsMap.get(String.valueOf(s.charAt(i))) != null && charsMap.get(String.valueOf(s.charAt(i))) > 0) {
                charsMap.merge(String.valueOf(s.charAt(i)), -1, Integer::sum);
            } else {
                continue;
            }

            for(Map.Entry<String, Integer> entry : charsMap.entrySet()) {
                if (entry.getValue() > 0) cnt++;
            }
            if (cnt == 0) {
                String subString = s.substring(start, i + 1);
                //System.out.println("sub = " + subString);
                if (minLength == 0 || subString.length() <= minLength) {
                    subList.add(subString);
                    minLength = subString.length();
                }
                charsMap = new HashMap<>(map);
//                for (int j = start + 1; j < s.length(); j++) {
//                    if (charsMap.containsKey(String.valueOf(s.charAt(j)))) {
//                        //System.out.println("start = " + start);
//                        start = j + 1;
//                        break;
//                    }
//                }
                //start = start + 1; //go back to find next substring
                i = start - 1;
            }
            //System.out.println("start = " + start);
        }

        System.out.println(subList);
        if (subList.size() > 0) {
            subList.sort(Comparator.comparing(String::length));
            result = subList.get(0);
        }
        System.out.println(result);
    }
}
