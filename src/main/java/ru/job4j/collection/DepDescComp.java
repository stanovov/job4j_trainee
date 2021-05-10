package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split("/");
        String[] rightArr = right.split("/");
        int rsl = rightArr[0].compareTo(leftArr[0]);
        return rsl == 0 ? left.compareTo(right) : rsl;
    }
}
