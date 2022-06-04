package effectivejava.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// Генерация декартова произведения двух списков с использованием итерации и потоков
public class Card {

    public enum Suit {
        SPADE, HEART, DIAMOND, CLUB
    }

    public enum Rank {
        ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Rank rank;

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private static final List<Card> NEW_DECK = newDeck();

    // Итеративное вычисление декартова произведения
    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

//    // Вычисление декартова произведения на основе потока
//    private static List<Card> newDeck() {
//        return Stream.of(Suit.values())
//                .flatMap(suit ->
//                        Stream.of(Rank.values())
//                                .map(rank -> new Card(suit, rank)))
//                .collect(toList());
//    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}