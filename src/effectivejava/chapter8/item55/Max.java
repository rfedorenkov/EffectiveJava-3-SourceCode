package effectivejava.chapter8.item55;

import java.util.*;

// Использование Optional<T> в качестве возвращаемого типа
public class Max {
//    // Возврат максимального значения коллекции - генерируя
//    // исключение в случае пустой коллекции
//    public static <E extends Comparable<E>> E max(Collection<E> c) {
//        if (c.isEmpty())
//            throw new IllegalArgumentException("Пустая коллекция");
//
//        E result = null;
//        for (E e : c)
//            if (result == null || e.compareTo(result) > 0)
//                result = Objects.requireNonNull(e);
//        return result;
//    }

//    // Возврат максимального значения коллекции как Optional<E>
//    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
//        if (c.isEmpty())
//            return Optional.empty();
//
//        E result = null;
//
//        for (E e : c)
//            if (result == null || e.compareTo(result) > 0)
//                result = Objects.requireNonNull(e);
//
//        return Optional.of(result);
//    }

    // Возврат максимального значения коллекции
    // как Optional<E> - использует поток
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        System.out.println(max(words));

        // Использование Optional для предоставления значения по умолчанию
        String lastWordInLexicon = max(words).orElse("Нет слов...");
        System.out.println(lastWordInLexicon);
    }
}