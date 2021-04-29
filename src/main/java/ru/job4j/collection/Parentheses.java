package ru.job4j.collection;

public class Parentheses {
    public static boolean valid(char[] data) {
        int open = 0;
        int end = 0;
        for (char c : data) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                end++;
            } else {
                return false;
            }
            if (end > open) {
                return false;
            }
        }
        return open == end;
    }
}
