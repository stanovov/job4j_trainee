package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CountingFunctionInRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountingFunctionInRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResult() {
        List<Double> result = CountingFunctionInRange.diapason(3, 7, x -> x * x);
        List<Double> expected = Arrays.asList(9D, 16D, 25D, 36D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = CountingFunctionInRange.diapason(1, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D, 81D);
        assertThat(result, is(expected));
    }
}