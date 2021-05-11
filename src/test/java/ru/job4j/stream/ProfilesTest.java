package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenOneProfileThenOneAddress() {
        Address address = new Address(
                "Moscow",
                "Arthuhinoy",
                21,
                174
        );
        List<Profile> profiles = List.of(
                new Profile(address)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = List.of(address);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenProfilesWithTheSameAddress() {
        Address address = new Address(
                "Moscow",
                "Arthuhinoy",
                21,
                174
        );
        List<Profile> profiles = List.of(
                new Profile(address),
                new Profile(address)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                address,
                address
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenThreeProfilesThenThreeAddresses() {
        Address address1 = new Address(
                "Moscow",
                "Arthuhinoy",
                21,
                174
        );
        Address address2 = new Address(
                "St. Petersburg",
                "Ordzhonikidze",
                2,
                65
        );
        Address address3 = new Address(
                "Tver'",
                "Donskogo",
                32,
                357
        );
        List<Profile> profiles = List.of(
                new Profile(address1),
                new Profile(address2),
                new Profile(address3)
        );
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                address1,
                address2,
                address3
        );
        assertThat(rsl, is(expected));
    }
}