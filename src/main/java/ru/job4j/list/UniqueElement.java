package ru.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        int index = list.indexOf(str);
        if (index == -1) {
            return false;
        }
        return index == list.lastIndexOf(str);
    }
}