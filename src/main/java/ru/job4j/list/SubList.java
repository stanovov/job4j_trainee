package ru.job4j.list;

import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        int inStart = list.indexOf(el);
        if (inStart == -1) {
            return List.of();
        }
        int inEnd = list.lastIndexOf(el);
        return list.subList(inStart, inEnd);
    }
}