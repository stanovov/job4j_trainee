package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        int result = -1;
        Optional<Integer> value = indexOf(data, el);
        if (value.isPresent()) {
            result = value.get();
        }
        return result;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> result = Optional.empty();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                result = Optional.of(i);
                break;
            }
        }
        return result;
    }
}
