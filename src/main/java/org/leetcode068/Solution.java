package org.leetcode068;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
    }

    public static void fullJustify(String[] words, int maxWidth) {
        ArrayList<ArrayList<StringBuilder>> listOfListBuilders = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int width = 0;
        for (int i = 0; i < words.length; i++) { //by all input words
            System.out.println("words = " + Arrays.toString(words) + ", maxWidth = " + maxWidth);
            if (width == 0) listOfListBuilders.add(new ArrayList<>()); //one string

            if (width != 0 && width + 1 + words[i].length() <= maxWidth || width == 0 && width + words[i].length() <= maxWidth) {
                if (width != 0) {
                    listOfListBuilders.get(listOfListBuilders.size() - 1).add(new StringBuilder(" ")); //add delimiters between words
                    listOfListBuilders.get(listOfListBuilders.size() - 1).add(new StringBuilder(words[i]));
                    width = width + 1 + words[i].length();
                } else {
                    listOfListBuilders.get(listOfListBuilders.size() - 1).add(new StringBuilder(words[i]));
                    width = words[i].length();
                }
            } else {
                width = 0;
                i--;
            }

        }

        for (ArrayList<StringBuilder> listOfListBuilder : listOfListBuilders) { //lists
            width = 0;
            for (StringBuilder stringBuilder : listOfListBuilder) { //strings
                width = width + stringBuilder.length();
            }
            widths.add(width);
        }

        for (int i = 0; i < listOfListBuilders.size(); i++) { //lists
            while (widths.get(i) < maxWidth) {
                ArrayList<StringBuilder> list = listOfListBuilders.get(i);
                for (int j = 0; j < list.size(); j++) { //strings
                    if (widths.get(i) < maxWidth) {
                        if ((list.size() > 1 && (j + 1) % 2 == 0 && i != listOfListBuilders.size() - 1) || list.size() == 1 || i == listOfListBuilders.size() - 1 && j == list.size() - 1) {
                            list.get(j).append(" ");
                            widths.set(i, widths.get(i) + 1);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for (ArrayList<StringBuilder> list : listOfListBuilders) { //lists
            StringBuilder sb = new StringBuilder();
            for (StringBuilder stringBuilder : list) { //strings
                sb.append(stringBuilder);
            }
            result.add(sb.toString());
        }


        System.out.println(result.toString());
    }
}
