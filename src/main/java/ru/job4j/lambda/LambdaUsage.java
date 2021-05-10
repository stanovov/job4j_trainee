package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] array = {"abc", "bcd", "asdf", "qwerty"};
        Comparator<String> comparator = (left, right) -> {
            int rsl = right.compareTo(left);
            System.out.println(
                    "Compare. left = " + left + ". right = " + right + ". result = " + rsl
            );
            return rsl;
        };
        Arrays.sort(array, comparator);
    }
}
