package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> leftMap = countingNumberOfCharacters(left);
        HashMap<Character, Integer> rightMap = countingNumberOfCharacters(right);
        if (leftMap.size() != rightMap.size()) {
            return false;
        }
        for (Character character : leftMap.keySet()) {
            if (!rightMap.containsKey(character)) {
                return false;
            } else {
                if (leftMap.get(character) != rightMap.get(character)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> countingNumberOfCharacters(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.computeIfPresent(c, (key, value) -> ++value);
        }
        return map;
    }
}