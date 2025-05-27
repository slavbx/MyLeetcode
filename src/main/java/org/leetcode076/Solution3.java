package org.leetcode076;

import java.util.*;

class Solution3 {
    public static void main(String[] args) {
        //String s = "ADOBECODEBANC"; String t = "ABC"; //BANC
        String s = "ab"; String t = "b";
        //String s = "acbba"; String t = "aab"; //acbba
        //String s = "bba"; String t = "ab"; //ba
        //String s = "cabwefgewcwaefgcf"; String t = "cae"; //cwae
        //String s = "aaaaaaaaaaaabbbbbcdd"; String t = "abcdd"; //abbbbbcdd
        String result = "";

        Map<String, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) { //build map with chars
            mapT.merge(String.valueOf(t.charAt(i)), 1, Integer::sum);
        }
        //System.out.println(mapT);
        Map<String, Integer> mapS = new HashMap<>();


        int start = 0;
        int end = 0;
        boolean finish = false;
        while (!(start == end && finish)) {
            if (!mapT.equals(mapS) && !finish) { //Until substring not exists all needed chars
                Integer valueT = mapT.get(String.valueOf(s.charAt(end)));
                Integer valueS = mapS.get(String.valueOf(s.charAt(end)));
                if (valueT != null) {
                    if (valueS == null || valueS < valueT) {
                        mapS.merge(String.valueOf(s.charAt(end)), 1, Integer::sum);
                    }
                }
                end++;
                System.out.println(mapS + " " + s.substring(start, end)  + " Расширение");
                if (end >= s.length()) finish = true;
            } else {
                //System.out.println(mapS + " " + s.substring(start, end)  + " Найдена строка");
                while (start < end && mapT.equals(mapS)) {
                    start++;
                    mapS.clear();
                    for (int i = start; i < end; i++) {
                        Integer valueT = mapT.get(String.valueOf(s.charAt(i)));
                        Integer valueS = mapS.get(String.valueOf(s.charAt(i)));
                        if (valueT != null) {
                            if (valueS == null || valueS < valueT) {
                                mapS.merge(String.valueOf(s.charAt(i)), 1, Integer::sum);
                            }
                        }
                    }
                    System.out.println(mapS + " " + s.substring(start, end)  + " Попытка сужения");
                    if (!mapT.equals(mapS)) {
                        if (result.isEmpty() || s.substring(start - 1, end).length() <= result.length()) {
                            result = s.substring(start - 1, end);
                        }
                        //mapS.clear();
                        System.out.println(mapS + " " + result  + " Записано");
                        break;
                    }
                }
                start++;
                //System.out.println(mapS + " " + s.substring(start, end));
            }
            if (start == end && finish) break;
            //if (end >= s.length()) break;

        }
        System.out.println(result);
    }
}

