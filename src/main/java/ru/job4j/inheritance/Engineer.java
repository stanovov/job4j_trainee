package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int countCompletedProjects;

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
