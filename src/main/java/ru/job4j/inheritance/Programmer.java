package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private ProgrammingLanguage mainLanguage;
    private String qualificationLevel;

    public ProgrammingLanguage getMainProgrammingLanguage() {
        return mainLanguage;
    }

    public String getEngineerQualificationLevel() {
        return qualificationLevel;
    }

    public Project create(TechnicalTask task) {
        return this.create(task, mainLanguage);
    }

    public Project create(TechnicalTask task, ProgrammingLanguage language) {
        return new Project();
    }

    public boolean fixBugs(Project project) {
        return this.fixBugs(project, mainLanguage);
    }

    public boolean fixBugs(Project project, ProgrammingLanguage language) {
        return true;
    }
}
