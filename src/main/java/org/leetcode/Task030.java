package org.leetcode030;

import java.util.*;

public class Task030 {
    public static void main(String[] args) {
        //String s = "barfoofoobarthefoobarman";
        //String[] words = new String[] {"bar","foo","the"};
        //String s = "wordgoodgoodgoodbestword";
        //String[] words = new String[]{"word","good","best","good"};
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        List<Integer> result = new ArrayList<>();
        List<String> wordSet = new ArrayList<>(Arrays.asList(words));
        Collections.sort(wordSet);

        int subLength = words.length * words[0].length(); //Iterate all substrings
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            int index = s.indexOf(words[i]);
            if (index > -1 && (start == 0 || index < start)) start = index; //Search start of substring in s
        }
        for ( ;start < s.length() - subLength + 1; start = start + words[0].length()) {

            int end = start + subLength;
            String word = s.substring(start, end);

           System.out.println(word);

            List<String> subSet = new ArrayList<>();
            for (int i = 0; i < word.length(); i = i + words[0].length()) { //Cut each substring into words and put to subSet
                subSet.add(word.substring(i, i + words[0].length()));
            }
            Collections.sort(subSet);
            System.out.println(subSet);
            System.out.println(wordSet);

            if (wordSet.equals(subSet)) {
                result.add(start);
            }
        }
        System.out.println(result);
    }
}
