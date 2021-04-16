package ru.job4j.oop;

import ru.job4j.poly.Vehicle;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Двигается по скоростному шоссе");
    }

    @Override
    public void stop() {
        System.out.println("Тормозит напротив автобусной остановки");
    }
}
