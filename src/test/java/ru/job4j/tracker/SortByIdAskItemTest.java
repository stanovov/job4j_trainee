package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SortByIdAskItemTest {

    @Test
    public void sort() {
        Item item1 = new Item(1, "task 1");
        Item item2 = new Item(2, "task 2");
        Item item3 = new Item(3, "task 3");
        Item item4 = new Item(4, "task 4");
        Item item5 = new Item(5, "task 5");
        List<Item> rsl = new ArrayList<>(List.of(
                item3,
                item4,
                item1,
                item5,
                item2
        ));
        Collections.sort(rsl, new SortByIdAskItem());
        List<Item> expected = new ArrayList<>(List.of(
                item1,
                item2,
                item3,
                item4,
                item5
        ));
        assertThat(rsl, is(expected));
    }
}