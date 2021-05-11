package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                3, 6, -9, 12, -15, 18, -21
        ));
        List<Integer> positiveNum = numbers.stream().filter(
                x -> x > 0
        ).collect(Collectors.toList());
        positiveNum.forEach(System.out::println);
    }
}
