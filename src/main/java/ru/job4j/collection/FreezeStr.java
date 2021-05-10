package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.computeIfPresent(c, (key, value) -> ++value);
        }
        for (int i = 0; i < right.length(); i++) {
            char c = right.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                int count = map.get(c);
                count--;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.computeIfPresent(c, (key, value) -> --value);
                }
            }
        }
        return map.isEmpty();
    }
}