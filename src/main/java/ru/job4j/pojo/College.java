package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Stanovov Semyon Sergeevich");
        student.setGroup("IST-1207");
        student.setAdmissionDate(LocalDate.of(2012, 9, 1));
        System.out.println(
                "Student: " + student.getFullName()
                        + System.lineSeparator()
                        + "Group: " + student.getGroup()
                        + System.lineSeparator()
                        + "Date of admission: " + student.getAdmissionDate()
        );
    }
}
