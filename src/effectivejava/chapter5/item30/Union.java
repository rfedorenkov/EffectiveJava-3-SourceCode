package effectivejava.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

// Общий метод объединения и программа для его реализации
public class Union {

    // Обобщенный метод
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Простая программа, использующая обобщенный метод
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}