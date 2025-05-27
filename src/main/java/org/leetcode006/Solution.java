package org.leetcode006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        ArrayList<ArrayList<String>> stringLists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringLists.add(new ArrayList<>());
        }

        int iRow = 0;
        int iZig = 0;
        for (int i = 0; i < s.length(); i++) {
            if (iRow < numRows) {
                stringLists.get(iRow).add(String.valueOf(s.charAt(i)));
                iRow++;
                iZig = numRows - 2;
            } else if (iZig > 0) {
                stringLists.get(iZig).add(String.valueOf(s.charAt(i)));
                iZig--;
            } else if (iZig == 0) {
                iRow = 0;
                stringLists.get(iRow).add(String.valueOf(s.charAt(i)));
                iRow++;
                iZig = numRows - 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (ArrayList<String> list: stringLists) {
            sb.append(String.join("", list));
        }
        return sb.toString();
    }
}
