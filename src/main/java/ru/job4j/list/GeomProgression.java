package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> list = new ArrayList<>();
        list.add(first);
        int sum = first;
        for (int i = 0; i < count - 1; i++) {
            int tmp = list.get(i);
            int value = tmp * denominator;
            sum += value;
            list.add(value);
        }
        return sum;
    }
}