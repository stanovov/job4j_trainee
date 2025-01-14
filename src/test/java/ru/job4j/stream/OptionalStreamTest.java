package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static ru.job4j.stream.OptionalStream.*;

public class OptionalStreamTest {

    @Test
    public void test() {
        PhoneNumber ph1 = new PhoneNumber("+7 123 345 61 91");
        PhoneNumber ph2 = new PhoneNumber("+7 123 345 61 92");
        PhoneNumber ph3 = new PhoneNumber("+7 123 345 61 93");
        PhoneNumber ph4 = new PhoneNumber("+1 123 345 61 91");
        PhoneNumber ph5 = new PhoneNumber("+2 123 345 61 91");
        PhoneNumber ph6 = new PhoneNumber("+3 123 345 61 91");
        OptionalStream.User u1 = new OptionalStream.User(1, List.of(ph1));
        OptionalStream.User u2 = new OptionalStream.User(2, List.of(ph2));
        OptionalStream.User u3 = new OptionalStream.User(3, List.of(ph3, ph4, ph5));
        OptionalStream.User u4 = new OptionalStream.User(3, List.of(ph6));
        assertEquals(
                "+7 123 345 61 93",
                OptionalStream.collectNumber(List.of(u1, u2, u3, u4), 3, "+7").get(0).getPhone()
        );
    }

    @Test
    public void test2() {
        PhoneNumber ph1 = new PhoneNumber("+7 123 345 61 91");
        PhoneNumber ph2 = new PhoneNumber("+7 123 345 61 92");
        PhoneNumber ph3 = new PhoneNumber("+7 123 345 61 93");
        PhoneNumber ph4 = new PhoneNumber("+1 123 345 61 91");
        PhoneNumber ph5 = new PhoneNumber("+2 123 345 61 91");
        PhoneNumber ph6 = new PhoneNumber("+3 123 345 61 91");
        OptionalStream.User u1 = new OptionalStream.User(1, List.of(ph1));
        OptionalStream.User u2 = new OptionalStream.User(2, List.of(ph2));
        OptionalStream.User u3 = new OptionalStream.User(3, List.of(ph2, ph3, ph4, ph5));
        OptionalStream.User u4 = new OptionalStream.User(3, List.of(ph6));
        assertEquals(
                List.of(ph2.getPhone(), ph3.getPhone()),
                OptionalStream.collectNumber(List.of(u1, u2, u3, u4), 3, "+7").stream()
                        .map(PhoneNumber::getPhone).collect(Collectors.toList())
        );
    }

}