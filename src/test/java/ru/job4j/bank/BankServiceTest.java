package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(Optional.of(user)));
    }

    @Test
    public void add2Users() {
        User firstUser = new User("1234", "Semyon Stanovov");
        User secondUser = new User("5678", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(firstUser);
        bank.addUser(secondUser);
        assertThat(bank.findByPassport("1234"), is(Optional.of(firstUser)));
        assertThat(bank.findByPassport("5678"), is(Optional.of(secondUser)));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546"), is(Optional.empty()));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").get().getBalance(), is(150D));
    }

    @Test
    public void add2Accounts() {
        User user = new User("1234", "Semyon Stanovov");
        BankService bank = new BankService();
        bank.addUser(user);
        Account account1 = new Account("1111", 777);
        Account account2 = new Account("2222", 42);
        bank.addAccount(user.getPassport(), account1);
        bank.addAccount(user.getPassport(), account2);
        assertThat(
                bank.findByRequisite(user.getPassport(), account1.getRequisite()),
                is(Optional.of(account1))
        );
        assertThat(
                bank.findByRequisite(user.getPassport(), account2.getRequisite()),
                is(Optional.of(account2))
        );
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(200D));
    }

    @Test
    public void transferMoneyBetweenTwoUsers() {
        User user1 = new User("1234", "Semyon Stanovov");
        User user2 = new User("5678", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("1111", 42000));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("2222", 0));
        bank.transferMoney(user1.getPassport(), "1111", user2.getPassport(), "2222", 22000);
        assertThat(
                bank.findByRequisite(user1.getPassport(), "1111").get().getBalance(),
                is(20000D)
        );
        assertThat(
                bank.findByRequisite(user2.getPassport(), "2222").get().getBalance(),
                is(22000D)
        );
    }
}