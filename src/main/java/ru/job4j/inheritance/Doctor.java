package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String category;

    public String getCategory() {
        return category;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
