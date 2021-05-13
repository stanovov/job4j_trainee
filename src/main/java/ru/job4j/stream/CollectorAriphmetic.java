package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorAriphmetic {
    public static Integer collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = LinkedList::new;
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        BinaryOperator<List<Integer>> merger = (xs, ys) -> {
            xs.addAll(ys);
            return xs;
        };
        Function<List<Integer>, Integer> function = (ns) -> {
            int sum = 0;
            if (!ns.isEmpty()) {
                sum = ns.get(0);
                for (int i = 1; i < ns.size(); i++) {
                    sum *= ns.get(i);
                }
            }
            return sum;
        };
        return list.stream()
                .collect(Collector.of(supplier, consumer, merger, function));
    }
}
