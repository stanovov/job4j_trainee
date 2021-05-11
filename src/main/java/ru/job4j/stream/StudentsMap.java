package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsMap {
    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        Student::getSurname,
                        student -> student,
                        (t1, t2) -> t2
                )
        );
    }
}
