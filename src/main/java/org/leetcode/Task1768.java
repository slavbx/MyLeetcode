package org.leetcode;

public class Task1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i;
        for (i = 0; (i < word1.length()) && (i < word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) sb.append(word1.substring(i));
        if (word2.length() > word1.length()) sb.append(word2.substring(i));

        return sb.toString();
    }
}
