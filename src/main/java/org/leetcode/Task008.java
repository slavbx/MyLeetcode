package org.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

//8. String to Integer (atoi)
class Task008 {
    public int myAtoi(String s) {
        BigInteger bigNumber;
        int sign = 1;
        StringBuilder sb = new StringBuilder(s.trim());
        if (sb.isEmpty()) return 0;
        if (sb.length() > 1 && sb.charAt(1) == '+') return 0;
        if (sb.charAt(0) == '-') {
            sign = -1;
            sb.deleteCharAt(0);
        }
        if (!sb.isEmpty() && sb.charAt(0) == '+') sb.deleteCharAt(0);

        Pattern pattern = Pattern.compile("^\\d+");
        Matcher matcher = pattern.matcher(sb.toString());
        if (matcher.find()) {
            bigNumber = new BigInteger(matcher.group());
            bigNumber = bigNumber.multiply(BigInteger.valueOf(sign));
            BigInteger max = BigInteger.valueOf(2147483647);
            BigInteger min = BigInteger.valueOf(-2147483648);
            if (bigNumber.compareTo(max) > 0) bigNumber = max;
            if (bigNumber.compareTo(min) < 0) bigNumber = min;
        } else {
            return 0;
        }
        return bigNumber.intValue();
    }
}
