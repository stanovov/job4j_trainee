package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void go() {

    }

    @Override
    public void passengers(int number) {

    }

    @Override
    public float refuel(int quantity) {
        return 0;
    }

    @Override
    public void move() {
        System.out.println("Двигается по скоростному шоссе");
    }

    @Override
    public void stop() {
        System.out.println("Тормозит напротив автобусной остановки");
    }
}
