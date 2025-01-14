package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterAndLongerThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Stanovova",
                "Stanovov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void lastCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Stanovow",
                "Stanovov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void lastCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Jerri",
                "Jerry"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void lowercaseCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "john",
                "John"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void uppercaseCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Stanovov",
                "stanovov"
        );
        assertThat(rst, lessThan(0));
    }
}