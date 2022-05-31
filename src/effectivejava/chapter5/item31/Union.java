package effectivejava.chapter5.item31;

import java.util.HashSet;
import java.util.Set;

// Общий метод объединения с подстановочными знаками для повышения гибкости
public class Union {

    // Обобщенный метод
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Простая программа, использующая обобщенный метод
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Set<Double> doubles = new HashSet<>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        Set<Number> numbers = union(integers, doubles);

//        // Явный параметр типа - требовался до Java 8
//        Set<Number> numbers = Union.<Number>union(integers, doubles);

        System.out.println(numbers);
    }
}