package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Заявка"));
        Item findItem = tracker.findById(item.getId());
        System.out.println(findItem);
    }
}
