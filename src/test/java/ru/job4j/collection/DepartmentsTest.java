package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedMoreDepartments() {
        List<String> input = Arrays.asList(
                "k1/sk1/ssk1", "k1/sk1/ssk2",
                "k2/sk1/ssk1", "k2/sk2/ssk1"
        );
        List<String> expect = Arrays.asList(
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2",
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk2", "k2/sk2/ssk1"
        );
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortedInAsc() {
        List<String> result = Arrays.asList(
                "k2", "k1/sk1", "k2/sk1/ssk1", "k2/sk2", "k1/sk1/ssk2",
                "k1", "k2/sk1", "k1/sk1/ssk1", "k2/sk2/ssk1"
        );
        List<String> expect = Arrays.asList(
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2",
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk2", "k2/sk2/ssk1"
        );
        Departments.sortAsc(result);
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortedDesc() {
        List<String> result = Arrays.asList(
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2",
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2"
        );
        List<String> expect = Arrays.asList(
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2"
        );
        Departments.sortDesc(result);
        assertThat(result, is(expect));
    }
}