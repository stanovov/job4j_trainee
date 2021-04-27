package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        String tmp = s.replaceAll(" ", "").toLowerCase();
        Set<String> set = new HashSet<>(Arrays.asList(tmp.split("")));
        return set.size() == 26;
    }
}