package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        char rsl = ' ';
        char[] chars = str.toLowerCase().replaceAll(" ", "").toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char symbol : chars) {
            map.putIfAbsent(symbol, 1);
            if (map.containsKey(symbol)) {
                map.computeIfPresent(symbol, (key, value) -> ++value);
            } else {
                map.putIfAbsent(symbol, 1);
            }
        }
        Map.Entry<Character, Integer> entryRsl = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entryRsl == null || entry.getValue() > entryRsl.getValue()) {
                entryRsl = entry;
            }
        }
        return entryRsl == null ? rsl : entryRsl.getKey();
    }
}