package org.leetcode;

import java.util.Set;

public class Task345 {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = sb.length() - 1;

        while (left <= right) {
            if (left != right) {
                while (left <= right && !vowels.contains(sb.charAt(left))) {
                    left++;
                }
                while (left <= right && !vowels.contains(sb.charAt(right))) {
                    right--;
                }
                if (left > right) break;
                if (vowels.contains(sb.charAt(left)) && vowels.contains(sb.charAt(right))) {
                    char chLeft = sb.charAt(left);
                    char chRight = sb.charAt(right);
                    sb.setCharAt(left, chRight);
                    sb.setCharAt(right, chLeft);
                    left++;
                    right--;
                }
            } else {
                left++;
                right--;
            }
        }
        return sb.toString();


    }
}
