package ru.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int sum = 0;
        if (data.size() > 2) {
            int left = data.get(0);
            int middle = data.get(1);
            int right = 0;
            sum = left + middle;
            for (int i = 2; i < data.size(); i++) {
                right = data.get(i);
                if ((right + left) / 2 == middle && (right + left) % 2 == 0) {
                    sum += right;
                    left = middle;
                    middle = right;
                } else {
                    sum = 0;
                    break;
                }
            }
        }
        return sum;
    }
}