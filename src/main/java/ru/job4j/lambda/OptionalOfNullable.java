package ru.job4j.lambda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> result = Optional.empty();
        for (String str : strings) {
            if (Objects.equals(value, str)) {
                result = Optional.ofNullable(str);
            }
        }
        return result;
    }
}
