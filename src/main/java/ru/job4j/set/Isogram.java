package ru.job4j.set;

import java.util.*;

public class Isogram {
    public static boolean checkString(String s) {
        Character[] charObjectArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Set<Character> charSet = new HashSet<>(Arrays.asList(charObjectArray));
        return charSet.size() == s.length();
    }
}