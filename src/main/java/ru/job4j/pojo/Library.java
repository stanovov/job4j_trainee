package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean Code", 464);
        books[1] = new Book("Effective Java", 464);
        books[2] = new Book("Thinking In Java", 1168);
        books[3] = new Book("Head First Design Patterns", 676);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCount());
        }
        System.out.println();
        System.out.println("Replace indexes 0 and 3.");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCount());
        }
        System.out.println();
        System.out.println("Only with a name \"Clean Code\"");
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getCount());
            }
        }
    }
}
