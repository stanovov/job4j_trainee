package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(value -> System.out.println("Max: " + value));
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> result = Optional.empty();
        if (data.length != 0) {
            int max = data[0];
            for (int i = 1; i < data.length; i++) {
                if (data[i] > max) {
                    max = data[i];
                }
            }
            result = Optional.of(max);
        }
        return result;
    }
}
