package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса, который позволяет
 * создавать новых пользователей, создавать банковские счета пользователей,
 * переводить деньги между счетами.
 * @author SEMYON STANOVOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользовтелей и их счетов осуществляется в структуре данных
     * типа HashMap, где ключ - это пользователь, а значение - это коллекция типа
     * ArrayList, которая хранит счета пользователя.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в список пользователей банковского сервиса.
     * Если пользователь уже был добавлен ранее, ничего не просходит.
     * @param user пользователь, который добавляется
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет банковский аккаунт к пользователю. Поиск пользователя
     * осуществляется по паспортным данным (тип String). Если пользователь был найден,
     * то выполняется добавление банковского аккаунта к найденному пользователю.
     * @param passport паспортные данные, по которым осуществляется поиск пользователя
     * @param account банковский аккаунт, который добавляется
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод выполняет поиск пользователя в списке users. Поиск выполняется по паспортным
     * данным ключей (тип User) списка users.
     * @param passport паспортные данные, по которым осуществляется поиск пользователя
     * @return При нахождении возвращает пользователя типа User, в другом случае
     * возвращается null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод выполняет поиск банковского аккаунта в списке users. Поиск выполняется по
     * паспортным данным ключей (тип User) поля users. А затем осуществляется поиск в
     * списке банковских счетов найденного пользователя.
     * @param passport паспортные данные, по которым осуществляется поиск пользователя
     * @param requisite реквизиты банковского счета, по которым осуществляется поиск
     *                  банковского счета.
     * @return При нахождении возвращает банковский счет типа Account, в другом случае
     * возвращается null.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод между двумя счетами банковского сервиса. Сначала выполняется
     * поиск этих аккаунтов. Если она найдены, то идет проверка, хватит ли баланса у счета
     * отправителя, если хватит, то выполняется перевод на счет получатель.
     * @param srcPassport паспортные данные, пользователя отправителя
     * @param srcRequisite банковские реквизиты, счета отправителя
     * @param destPassport паспортные данные, пользователя получателя
     * @param destRequisite банковские реквизиты, счета получателя
     * @param amount сумма перевода
     * @return в случае, если один из аккауентов не будет найден или если не будет достаточно
     * средств для перевода - возвращается false. В другом случае возвращается true.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getBalance() >= amount) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}