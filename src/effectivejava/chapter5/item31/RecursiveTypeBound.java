package effectivejava.chapter5.item31;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Использование рекурсивного типа, связанного подстановочными знаками
public class RecursiveTypeBound {

    // Возвращает максимальное значение коллекции -
    // использует рекурсивное ограничение типа
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Пустая коллекция");

        E result = null;

        for (E e : list)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}