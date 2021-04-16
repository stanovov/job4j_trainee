package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летит по воздуху");
    }

    @Override
    public void stop() {
        System.out.println("Идет на посадку");
    }
}
