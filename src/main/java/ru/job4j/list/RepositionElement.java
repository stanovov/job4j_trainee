package ru.job4j.list;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        if (!list.isEmpty()) {
            String tmp = list.remove(list.size() - 1);
            if (index < list.size()) {
                list.set(index, tmp);
            }
        }
        return list;
    }
}