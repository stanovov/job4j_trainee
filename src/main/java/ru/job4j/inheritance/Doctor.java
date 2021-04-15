package ru.job4j.inheritance;

import java.time.LocalDate;

public class Doctor extends Profession {
    private String category;

    public Doctor(String name, String surname, String education,
                  LocalDate birthday, String category) {
        super(name, surname, education, birthday);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
