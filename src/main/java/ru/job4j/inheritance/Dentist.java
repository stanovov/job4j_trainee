package ru.job4j.inheritance;

import java.time.LocalDate;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education,
                   LocalDate birthday, String category) {
        super(name, surname, education, birthday, category);
    }

    public boolean treatTooth(Pacient pacient, Tooth tooth) {
        return true;
    }

    public boolean pullOutTooth(Pacient pacient, Tooth tooth) {
        return true;
    }
}
