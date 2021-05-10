package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.isEmpty() ? el : start + "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> expect = Arrays.asList(
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk2", "k2/sk2/ssk1",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2"
        );
        sortAsc(expect);
        expect.forEach(System.out::println);
    }

}
