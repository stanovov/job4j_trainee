package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банком
 * @author SEMYON STANOVOV
 * @version 1.0
 */
public class User {
    /**
     * Серия и номер паспорта хранятся в строке
     */
    private String passport;
    /**
     * Имя пользователя хранится в строке
     */
    private String username;

    /**
     * Данный конструктор предназначен для инициализации начальными
     * значениями пользователя банка
     * @param passport серия и номер паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает текущие данные паспорта (серия и номер)
     * @return возвращает поле passport типа String
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает новые паспортные данные пользователя банка
     * @param passport паспортные данные, которые будут установлены
     *                 (серия и номер)
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает текущее имя пользователя банка
     * @return возвращает поле username типа String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает новое имя пользователя банка
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнивает текущий объект, с переданным объектом. Сравнение
     * происходит по полю passport.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хеш-код текущего объекта
     * @return возвращает хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}