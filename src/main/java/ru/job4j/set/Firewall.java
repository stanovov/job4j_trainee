package ru.job4j.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        for (String word : words) {
            if (s.contains(word)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}