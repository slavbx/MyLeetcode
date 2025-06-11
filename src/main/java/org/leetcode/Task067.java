package org.leetcode;

//67. Add binary
class Task067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        int diffLength = (int)Math.abs(a.length() - b.length());
        if (a.length() >= b.length()) {
            for(int i = 0; i < diffLength; i++) sbB.append("0");
            sbA.append(a);
            sbB.append(b);
        } else {
            for(int i = 0; i < diffLength; i++) sbA.append("0");
            sbA.append(a);
            sbB.append(b);
        }

        //will work in reverse order
        sbA.reverse();
        sbB.reverse();

        int acc = 0;
        for (int i = 0; i < sbA.length(); i++) {
            if (acc == 0) {
                if (sbA.charAt(i) == '1' && sbB.charAt(i) == '1') {
                    sb.append(0);
                    acc = 1;
                } else {
                    if (sbA.charAt(i) == '0' && sbB.charAt(i) == '0') sb.append(0);
                    if (sbA.charAt(i) == '1' && sbB.charAt(i) == '0') sb.append(1);
                    if (sbA.charAt(i) == '0' && sbB.charAt(i) == '1') sb.append(1);
                }
            } else {
                if (sbA.charAt(i) == '1' && sbB.charAt(i) == '1') {
                    sb.append(1);
                    continue;
                }
                if (sbA.charAt(i) == '0' && sbB.charAt(i) == '0') {
                    sb.append(1);
                    acc = 0;
                    continue;
                }
                if (sbA.charAt(i) == '1' && sbB.charAt(i) == '0') {
                    sb.append(0);
                    continue;
                }
                if (sbA.charAt(i) == '0' && sbB.charAt(i) == '1') {
                    sb.append(0);
                }
            }
        }
        if (acc == 1) sb.append(1);

        return sb.reverse().toString();
    }
}
