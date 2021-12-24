package chapter2.part1.item5.singleton;

import chapter2.part1.item5.Lexicon;

import java.util.List;

// Ненадлежащее использование синглтона - негибкое и не тестируемое!
public class SpellChecker {
    private final Lexicon dictionary = null; // ...

    private SpellChecker() {
    } // ...

    public static SpellChecker INSTANCE = new SpellChecker(); // ..

    public boolean isValid(String word) {
        // ...
        return false;
    }

    public static List<String> suggestion(String typo) {
        // ...
        return null;
    }
}
