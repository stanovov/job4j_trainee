package ru.job4j.inheritance;

import java.time.LocalDate;

public class Builder extends Engineer {
    private String category;

    public Builder(String name, String surname, String education,
                   LocalDate birthday, int countCompletedProjects, String category) {
        super(name, surname, education, birthday, countCompletedProjects);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
