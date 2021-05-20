package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    public EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(new ArrayList<>(source));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, fun.apply(list.get(i)));
        }
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (!fun.test(value)) {
                iterator.remove();
            }
        }
        return this;
    }

    public List<Integer> collect() {
        return list;
    }
}