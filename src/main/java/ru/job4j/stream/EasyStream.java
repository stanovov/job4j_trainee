package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(new ArrayList<>(source));
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmpList = new ArrayList<>();
        for (Integer integer : list) {
            tmpList.add(fun.apply(integer));
        }
        return new EasyStream(tmpList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> tmpList = new ArrayList<>();
        for (Integer integer : list) {
            if (fun.test(integer)) {
                tmpList.add(integer);
            }
        }
        return new EasyStream(tmpList);
    }

    public List<Integer> collect() {
        return new ArrayList<>(list);
    }
}