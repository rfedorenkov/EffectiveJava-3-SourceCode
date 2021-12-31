package effectivejava.chapter2.item5.staticclass;

import effectivejava.chapter2.item5.Lexicon;

import java.util.List;

// Ненадлежащее использование статического служебного
// класса - негибкое и не тестируемое!
public class SpellChecker {
    private static final Lexicon dictionary = null; // ...

    private SpellChecker() {
    } // Неинстанцируемый

    public static boolean isValid(String word) {
        // ...
        return false;
    }

    public static List<String> suggestion(String typo) {
        // ...
        return null;
    }
}
