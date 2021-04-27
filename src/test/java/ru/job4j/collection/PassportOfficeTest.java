package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddTwoIdenticalPassportOfCitizensThenFalse() {
        Citizen citizen1 = new Citizen("0020-4060", "Semyon Stanovov");
        Citizen citizen2 = new Citizen("0020-4060", "Semyon Stanovov Sergeevich");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        boolean rsl = office.add(citizen2);
        assertFalse(rsl);
    }
}