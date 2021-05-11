package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsMapTest {
    @Test
    public void whenOneStudentInListThenOnePairInMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1")
        );
        Map<String, Student> rsl = new StudentsMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTwoStudentsInListThenTwoPairsInMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname2")
        );
        Map<String, Student> rsl = new StudentsMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname2", new Student(20, "Surname2"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTwoElementsOfListHaveSameSurnameThenOnePairInMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(20, "Surname1")
        );
        Map<String, Student> rsl = new StudentsMap().convertListToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(20, "Surname1"));
        assertThat(rsl, is(expected));
    }
}