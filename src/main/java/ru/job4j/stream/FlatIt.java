package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        int characteristics = Spliterator.SIZED | Spliterator.IMMUTABLE;
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(it, characteristics), false)
                .flatMap(its -> StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(its, characteristics), false)
                )
                .collect(Collectors.toList());
//        return Stream.iterate(it.next(), i -> it.hasNext(), i -> it.next())
//                .flatMap(its -> Stream.iterate(its.next(), i -> its.hasNext(), i -> its.next()))
//                .collect(Collectors.toList());
    }
}
