package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenDoubleOrder() {
        List<Order> orders = new ArrayList<>();
        Order first  = new Order("4a20-11111", "Hat");
        Order second = new Order("4a21-11112", "Jacket");
        orders.add(first);
        orders.add(second);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get(first.getNumber()), is(first));
        assertThat(map.get(second.getNumber()), is(second));
    }

    @Test
    public void whenZeroOrders() {
        List<Order> orders = new ArrayList<>();
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertTrue(map.isEmpty());
    }
}