package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsMap {
    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                        Student::getSurname,
                        student -> student,
                        (t1, t2) -> t1.equals(t2) ? t1 : t2
                )
        );
    }
}
