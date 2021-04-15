package ru.job4j.inheritance;

import java.time.LocalDate;

public class Programmer extends Engineer {
    private ProgrammingLanguage mainLanguage;
    private String qualificationLevel;

    public Programmer(String name, String surname, String education,
                      LocalDate birthday, int countCompletedProjects,
                      ProgrammingLanguage mainLanguage, String qualificationLevel) {
        super(name, surname, education, birthday, countCompletedProjects);
        this.mainLanguage = mainLanguage;
        this.qualificationLevel = qualificationLevel;
    }

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
