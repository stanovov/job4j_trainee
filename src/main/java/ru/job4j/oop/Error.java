package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка ативна: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        err1.printInfo();
        Error err2 = new Error(false, 308, "Permanent Redirect");
        err2.printInfo();
        Error err3 = new Error(true, 408, "Request Timeout");
        err3.printInfo();
        Error err4 = new Error(true, 500, "Internal Server Error");
        err4.printInfo();
    }
}
