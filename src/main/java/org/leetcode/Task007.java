package org.leetcode;

//7. Reverse Integer
class Task007 {
    public int reverse(int x) {
        int sign = 1;
        StringBuilder sb = new StringBuilder();

        sb.append(x);
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        sb.reverse();
        long testOverload = Long.parseLong(sb.toString());
        if (testOverload > 2147483647) return 0;

        sb.setLength(0);
        sb.append(x);

        if (sb.charAt(0) == '-') {
            sign = -1;
            sb.deleteCharAt(0);
        }
        sb.reverse();
        return (int)Long.parseLong(sb.toString()) * sign;
    }
}
