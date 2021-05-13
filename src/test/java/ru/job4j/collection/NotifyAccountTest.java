package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        Set<Account> expect = Set.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenThereIsOneDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("11002200", "Semyon Stanovov", "a23f21sfa2"),
                new Account("11002200", "Semyon Stanovov", "231123")
        );
        Set<Account> expect = Set.of(
                new Account("11002200", "Semyon Stanovov", "a23f21sfa2")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenThereIsTwoDuplicates() {
        List<Account> accounts = Arrays.asList(
                new Account("11002200", "Semyon Stanovov", "a23f21sfa2"),
                new Account("11002200", "Semyon Stanovov", "231123"),
                new Account("21312322", "George Orwell", "1984"),
                new Account("21312322", "George Orwell", "2bbbbbbbbbb2")
        );
        Set<Account> expect = Set.of(
                new Account("11002200", "Semyon Stanovov", "a23f21sfa2"),
                new Account("21312322", "George Orwell", "1984")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}