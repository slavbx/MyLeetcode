package org.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Task071 {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        Pattern pattern = Pattern.compile("[^/]+/*");
        Matcher matcher = pattern.matcher(path);

        while(matcher.find()) {
            String directory = matcher.group();
            directory = directory.replaceAll("[/]+", "");
            if (directory.equals(".")) continue;
            if (directory.equals("..")) {
                if (!stack.isEmpty())stack.pop();
                continue;
            }
            stack.push(directory);
        }
        if (stack.isEmpty()) result.append("/");
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.pollLast());
        }
        return result.toString();
    }
}
