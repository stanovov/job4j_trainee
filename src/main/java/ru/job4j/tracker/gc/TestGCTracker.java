package ru.job4j.tracker.gc;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;

public class TestGCTracker {

    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void main(String[] args) throws Exception {
        Thread.sleep(30000);
        Store store = new MemTracker();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000; j++) {
                String name = "" + j;
                store.add(new Item(name));
                for (int k = 0; k < 1000; k++) {
                    new Item(name);
                }
            }
            System.out.println("#" + i + " " + ENVIRONMENT.freeMemory() / 1000000);
        }
    }
}
