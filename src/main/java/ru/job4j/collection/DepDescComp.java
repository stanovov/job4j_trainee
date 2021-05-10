package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split("/");
        String[] rightArr = right.split("/");
        int rsl = 0;
        int len = Math.max(leftArr.length, rightArr.length);
        for (int i = 0; i < len; i++) {
            if (i < leftArr.length && i < rightArr.length) {
                rsl = leftArr[i].compareTo(rightArr[i]);
                if (i == 0) {
                    rsl = -rsl;
                }
                if (rsl != 0) {
                    break;
                }
            } else if (i == rightArr.length) {
                rsl = 1;
                break;
            } else if (i == leftArr.length) {
                rsl = -1;
                break;
            }
        }
        return rsl;
    }
}
