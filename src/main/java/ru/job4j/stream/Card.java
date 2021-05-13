package ru.job4j.stream;

import ru.job4j.oop.Car;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                    .map(value -> suit + " " + value))
                .forEach(System.out::println);

        List<Card> deckList = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                    .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());

        Card[] deckArray = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .toArray(Card[]::new);
    }
}
