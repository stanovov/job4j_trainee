package ru.job4j.inheritance;

import java.time.LocalDate;

public class Engineer extends Profession {
    private int countCompletedProjects;

    public Engineer(String name, String surname, String education,
                    LocalDate birthday, int countCompletedProjects) {
        super(name, surname, education, birthday);
        this.countCompletedProjects = countCompletedProjects;
    }

    public int getCountCompletedProjects() {
        return countCompletedProjects;
    }

    public boolean analyze(TechnicalTask task) {
        return true;
    }

    public Project create(TechnicalTask task) {
        return new Project();
    }
}
