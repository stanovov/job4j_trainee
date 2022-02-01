package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
        System.out.println(minus(5));
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(7));
        System.out.println(calc.divide(10));
        System.out.println(calc.sumAllOperation(5));
    }

}