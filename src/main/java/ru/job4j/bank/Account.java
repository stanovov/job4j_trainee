package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет
 * @author SEMYON STANOVOV
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета хранятся в строке
     */
    private String requisite;
    /**
     * Баланс счета хранится в числе с плавающей точкой типа double
     */
    private double balance;

    /**
     * Данный конструктор предназначен для инициализации начальными
     * значениями банковского счета.
     * @param requisite реквизиты банковского счета
     * @param balance начальный баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает текущие реквизиты банковского счета.
     * @return возвращает поле requisite типа String
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает новые реквизиты банковскому счету.
     * @param requisite реквизиты, которые будут установлены
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает текущий баланс банковского счета.
     * @return возвращает поле balance типа double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает новый баланс банковскому счету.
     * @param balance баланс, который будет установлен
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнивает текущий объект, с переданным объектом. Сравнение
     * происходит по полю requisite.
     * @param o объект сравнения
     * @return возвращает результат типа boolean. Если объекты сравнения
     * равны - true, если не равны - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хеш-код текущего объекта
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}