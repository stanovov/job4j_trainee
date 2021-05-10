package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        supplier();
        consumer();
        biConsumer();
        predicate();
        biPredicate();
        function();
        biFunction();
        unaryOperator();
        binaryOperator();
    }

    public static void supplier() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"Supplier\": ");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        Set<String> strings = sup.get();
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static void consumer() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"Consumer\": ");
        Supplier<String> sup = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());
    }

    public static void biConsumer() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"BiConsumer\": ");
        Supplier<String> sup = () -> "New String For Interface";
        BiConsumer<String, String> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(sup.get(), " and Second String");
    }

    public static void predicate() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"Predicate\": ");
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
    }

    public static void biPredicate() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"BiPredicate\": ");
        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
    }

    public static void function() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"Function\": ");
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
    }

    public static void biFunction() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"BiFunction\": ");
        BiFunction<String, Integer, String> biFunc = (s, i) -> s.concat(" ").concat(i.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));
    }

    public static void unaryOperator() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"UnaryOperator\": ");
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(
                new StringBuilder("String for test"))
        );
        System.out.println("Строка после реверса: " + builder.apply(
                new StringBuilder("tset rof gnirtS"))
        );
    }

    public static void binaryOperator() {
        System.out.println("\n" + "Пример работы функционального интерфейса \"BinaryOperator\": ");
        BinaryOperator<StringBuilder> binBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + binBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}