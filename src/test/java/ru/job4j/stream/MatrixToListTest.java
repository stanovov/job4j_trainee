package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenSquareTwoDimensionalArray() {
        Integer[][] matrix = new Integer[][]{
                {1, 2}, {3, 4}
        };
        List<Integer> rsl = new MatrixToList().convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenRectangularTwoDimensionalArray() {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}
        };
        List<Integer> rsl = new MatrixToList().convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenNotRectangularTwoDimensionalArray() {
        Integer[][] matrix = new Integer[][]{
                {1}, {2, 3}, {4, 5, 6}
        };
        List<Integer> rsl = new MatrixToList().convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }

}