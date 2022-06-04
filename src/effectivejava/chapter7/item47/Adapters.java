package effectivejava.chapter7.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// Адаптеры от потока к итерируемому и наоборот
public class Adapters {

    // Адаптер Stream<E> к Iterable<E>
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Адаптер Iterable<E> к Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}