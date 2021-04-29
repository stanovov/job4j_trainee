package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать?");
        String question = input.nextLine();
        int rnd = new Random().nextInt(3);
        String answer = "";
        if (rnd == 0) {
            answer = "Да";
        } else if (rnd == 1) {
            answer = "Нет";
        } else {
            answer = "Может быть";
        }
        System.out.println(answer);
    }
}
