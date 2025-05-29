package org.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  the sky is blue   "));
    }

    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("[\\w'-]+");
        Matcher matcher = pattern.matcher(s);


        while (matcher.find()) {
            words.add(matcher.group());
        }

        Collections.reverse(words);
        for (String word : words) {
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
}


//boolean startsWithSpace = s.startsWith(" ");
//boolean endsWithSpace = s.endsWith(" ");
//List<String> words = new ArrayList<>();
//ArrayList<String> delimiters = new ArrayList<>();
//StringBuilder sb = new StringBuilder();
//
//Pattern pattern = Pattern.compile("\\s+");
//Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//        delimiters.add(matcher.group());
//        }
//
//pattern = Pattern.compile("[\\w'-]+");
//matcher = pattern.matcher(s);
//        while (matcher.find()) {
//        words.add(matcher.group());
//        }
//
//        Collections.reverse(words);
//        Collections.reverse(delimiters);
//        if (endsWithSpace) {
//        sb.append(delimiters.get(0));
//        delimiters.remove(0);
//        }
//
//                for (int i = 0; i < words.size(); i++) {
//        sb.append(words.get(i));
//        if (i == words.size() - 1 && endsWithSpace) {
//        sb.append(delimiters.get(i));
//        } else if (i < words.size() - 1) {
//        sb.append(delimiters.get(i));
//        }
//        }
//        return sb.toString();
//    }
