package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenSortAscByName() {
        Job job1 = new Job("You won't get paid without it", 1);
        Job job2 = new Job("This is important", 2);
        Job job3 = new Job("Just do it", 3);
        Job job4 = new Job("Can be done later", 4);
        Job job5 = new Job("Fix bug", 5);
        List<Job> rsl = new ArrayList<>(List.of(
                job1,
                job2,
                job3,
                job4,
                job5
        ));
        Collections.sort(rsl, new JobAscByName());
        List<Job> expected = List.of(
                job4,
                job5,
                job3,
                job2,
                job1
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortDescByName() {
        Job job1 = new Job("You won't get paid without it", 1);
        Job job2 = new Job("This is important", 2);
        Job job3 = new Job("Just do it", 3);
        Job job4 = new Job("Can be done later", 4);
        Job job5 = new Job("Fix bug", 5);
        List<Job> rsl = new ArrayList<>(List.of(
                job1,
                job2,
                job3,
                job4,
                job5
        ));
        Collections.sort(rsl, new JobDescByName());
        List<Job> expected = List.of(
                job1,
                job2,
                job3,
                job5,
                job4
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortAscByPriority() {
        Job job1 = new Job("You won't get paid without it", 1);
        Job job2 = new Job("This is important", 2);
        Job job3 = new Job("Just do it", 3);
        Job job4 = new Job("Can be done later", 4);
        Job job5 = new Job("Fix bug", 5);
        List<Job> rsl = new ArrayList<>(List.of(
                job4,
                job3,
                job1,
                job5,
                job2
        ));
        Collections.sort(rsl, new JobAscByPriority());
        List<Job> expected = List.of(
                job1,
                job2,
                job3,
                job4,
                job5
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortDescByPriority() {
        Job job1 = new Job("You won't get paid without it", 1);
        Job job2 = new Job("This is important", 2);
        Job job3 = new Job("Just do it", 3);
        Job job4 = new Job("Can be done later", 4);
        Job job5 = new Job("Fix bug", 5);
        List<Job> rsl = new ArrayList<>(List.of(
                job4,
                job3,
                job1,
                job5,
                job2
        ));
        Collections.sort(rsl, new JobDescByPriority());
        List<Job> expected = List.of(
                job5,
                job4,
                job3,
                job2,
                job1
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortAscByNameAndAscByPriority() {
        Job job1 = new Job("AAA", 1);
        Job job2 = new Job("AAA", 2);
        Job job3 = new Job("AAB", 1);
        Job job4 = new Job("AAB", 2);
        List<Job> rsl = new ArrayList<>(List.of(
                job3,
                job2,
                job4,
                job1
        ));
        Collections.sort(rsl, new JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = List.of(
                job1,
                job2,
                job3,
                job4
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortDescByNameAndDescByPriority() {
        Job job1 = new Job("BBB", 5);
        Job job2 = new Job("BBB", 4);
        Job job3 = new Job("AAA", 5);
        Job job4 = new Job("AAA", 4);
        List<Job> rsl = new ArrayList<>(List.of(
                job4,
                job2,
                job3,
                job1
        ));
        Collections.sort(rsl, new JobDescByName().thenComparing(new JobDescByPriority()));
        List<Job> expected = List.of(
                job1,
                job2,
                job3,
                job4
        );
        assertThat(rsl, is(expected));
    }
}