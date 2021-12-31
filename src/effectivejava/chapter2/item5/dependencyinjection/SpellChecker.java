package effectivejava.chapter2.item5.dependencyinjection;

import effectivejava.chapter2.item5.Lexicon;

import java.util.List;
import java.util.Objects;

// Внедрение зависимостей обеспечивает гибкость и тестируемость
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        // ...
        return false;
    }

    public static List<String> suggestion(String typo) {
        // ...
        return null;
    }
}
