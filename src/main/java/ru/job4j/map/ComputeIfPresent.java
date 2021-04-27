package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer id : name.keySet()) {
            name.computeIfPresent(id, (key, value) -> value + " " + surname.get(id));
        }
        return name;
    }
}