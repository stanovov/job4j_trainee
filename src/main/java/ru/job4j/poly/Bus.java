package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void go() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Пассажиры в количестве \"" + number + "\" садятся в автобус");
    }

    @Override
    public float refuel(int quantity) {
        float price = 43.92f;
        float sum = (float) (Math.round(price * quantity * 100.0) / 100.0);
        System.out.println(
                "Автобус заправляется на " + quantity + " л.\n"
                + "Стоимость заправки составляет - " + sum + " руб."
        );
        return sum;
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
