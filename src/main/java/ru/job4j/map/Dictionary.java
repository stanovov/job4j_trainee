package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
            String key = str.substring(0, 1);
            if (!rsl.containsKey(key)) {
                rsl.put(key, new ArrayList<>());
            }
            rsl.get(key).add(str);
        }
        return rsl;
    }
}