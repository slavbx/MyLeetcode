package org.leetcode;

//5. Longest Palindromic Substring
class Task005 {
    StringBuilder sb = new StringBuilder();

    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);

        if (s.length() == 0) return "";
        if (s.length() == 1) return s;

        int start = 0;
        int end = 2;
        while(end < s.length() + 1) { //find aa
            int savedStart = start;
            int savedEnd = end;
            while (isPalindrome(s.substring(start, end))) {
                if (result.length() < s.substring(start, end).length()) result = s.substring(start, end);
                if (start > 0 && end < s.length()) {
                    start--;
                    end++;
                } else {
                    start = savedStart;
                    end = savedEnd;
                    break;
                }
            }
            start++; end++;
        }

        start = 0;
        end = 3;
        while(end < s.length() + 1) { //find aba
            int savedStart = start;
            int savedEnd = end;
            while (isPalindrome(s.substring(start, end))) {
                if (result.length() < s.substring(start, end).length()) result = s.substring(start, end);
                if (start == 0 && end == s.length()) break;

                if (start > 0 && end < s.length()) {
                    start--;
                    end++;
                } else {
                    start = savedStart;
                    end = savedEnd;
                    break;
                }
            }
            start++; end++;
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        sb.setLength(0);
        sb.append(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
}
