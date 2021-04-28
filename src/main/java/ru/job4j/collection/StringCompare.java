package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Math.max(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            if (i < left.length() && i < right.length()) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    break;
                }
            } else if (i == right.length()) {
                rsl = 1;
                break;
            } else if (i == left.length()) {
                rsl = -1;
                break;
            }
        }
        return rsl;
    }
}