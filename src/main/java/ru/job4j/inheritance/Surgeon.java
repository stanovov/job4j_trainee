package ru.job4j.inheritance;

import java.time.LocalDate;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education,
                   LocalDate birthday, String category) {
        super(name, surname, education, birthday, category);
    }

    public boolean doSurgery(Pacient pacient) {
        return true;
    }
}
