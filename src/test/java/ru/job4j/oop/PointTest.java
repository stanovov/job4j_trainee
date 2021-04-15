package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when234to236Then2() {
        Point first = new Point(2, 3, 4);
        Point second = new Point(2, 3, 6);
        double out = first.distance3d(second);
        double expected = 2.0;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenMinus324toMinus323Then1() {
        Point first = new Point(-3, 2, 4);
        Point second = new Point(-3, 2, 3);
        double out = first.distance3d(second);
        double expected = 1.0;
        Assert.assertEquals(expected, out, 0.01);
    }
}