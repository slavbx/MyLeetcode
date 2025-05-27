package org.leetcode076;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC"; String t = "ABC"; //BANC
        //String s = "ab"; String t = "a"; //a
        //String s = "acbba"; String t = "aab"; //acbba
        //String s = "bba"; String t = "ab"; //ba
        //String s = "cabwefgewcwaefgcf"; String t = "cae"; //cwae
        //String s = "aaaaaaaaaaaabbbbbcdd"; String t = "abcdd"; //abbbbbcdd
        String result = "";

        String[] arrayS = s.split("");
        String[] arrayT = t.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayT.length; i++) { //build map with chars
            map.merge(arrayT[i], 1, Integer::sum);
        }
        System.out.println(map);

        int start = 0;
        int end = 0;
        while (end < s.length()){
            if (!strExistsChars(arrayS, start, end, map)) {
                end++;
            } else {
                //start++;
                while (start < end && strExistsChars(arrayS, start, end, map)) {
                    start++;
                }
                if (!strExistsChars(arrayS, start, end, map)) start--;

                if (result.isEmpty() || end - start + 1 <= result.length()) {

                    result = s.substring(start, end + 1);
                }
                start++;
            }
        }
        System.out.println(result);
    }
    public static boolean strExistsChars(String[] array, int start, int end, Map<String, Integer> map) {
        Map<String, Integer> charsMap = new HashMap<>(map);
        for (int i = start; i <= end; i++) {
            Integer value = charsMap.get(array[i]);
            if (value != null && value > 1) {
                charsMap.merge(array[i], -1, Integer::sum);
            } else {
                charsMap.remove(array[i]);
            }
            if (charsMap.isEmpty()) break;
        }
        return charsMap.isEmpty();
    }

//    public static boolean strExistsChars(String s, Map<String, Integer> map) {
//        Map<String, Integer> charsMap = new HashMap<>(map);
//        int cnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            //if (charsMap.get(String.valueOf(s.charAt(i))) != null && charsMap.get(String.valueOf(s.charAt(i))) > 0) {
//            charsMap.merge(String.valueOf(s.charAt(i)), -1, Integer::sum);
//            //}
//        }
//        for(Map.Entry<String, Integer> entry : charsMap.entrySet()) {
//            if (entry.getValue() > 0) cnt++;
//        }
//        return !(cnt > 0);
//    }

}
