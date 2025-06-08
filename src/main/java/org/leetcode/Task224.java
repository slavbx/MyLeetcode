package org.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Task224 {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Deque<Integer> resultStack = new ArrayDeque<>();
        Deque<Integer> signStack = new ArrayDeque<>();
        int curResult = 0;
        int curSign = 1;
        Pattern pattern = Pattern.compile("[0-9]+|[+\\-()]");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()) {
            String str = matcher.group();
            if (str.matches("[0-9]+")) curResult = curResult + curSign*Integer.parseInt(str);
            if (str.equals("+")) curSign = 1;
            if (str.equals("-")) curSign = -1;
            if (str.equals("("))  {
                resultStack.push(curResult);
                signStack.push(curSign);
                curResult = 0;
                curSign = 1;
            }
            if (str.equals(")"))  {
                int prevResult = resultStack.pop();
                int prevSign = signStack.pop();
                curResult = prevResult + prevSign * curResult;
            }
        }
        return curResult;
    }

}
