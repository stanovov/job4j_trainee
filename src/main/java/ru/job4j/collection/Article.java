package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> originSet = new HashSet<>(
                Arrays.asList(origin.replaceAll("\\p{P}", "").split(" "))
        );
        String[] array = line.replaceAll("\\p{P}", "").split(" ");
        for (String str : array) {
            if (!originSet.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
