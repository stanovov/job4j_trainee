package ru.job4j.task;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвигается по рельсам");
    }

    @Override
    public void stop() {
        System.out.println("Останавливается на станции");
    }
}
